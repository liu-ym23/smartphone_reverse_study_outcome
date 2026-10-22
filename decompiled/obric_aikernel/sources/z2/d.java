package z2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import o2.f;
import o2.g;
import okio.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13779a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f13780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f13781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f13782d = null;

    static {
        f13782d = new ConcurrentHashMap();
    }

    public static void a(byte[] r10, int r11) {
        if (r10 == null) goto L8;
        if (r11 <= 0) goto L10;
        byte[] r12 = {-99, -114, ByteCompanionObject.MAX_VALUE, 90};
        int r13 = 0;
    L6:
        if (r13 >= r11) goto L11;
        r10[r13] = (byte) (r10[r13] ^ r12[r13 % 4]);
        r13 = r13 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    private static int b(int r10) {
        if (r10 > 0) goto L6;
        return 5242880;
    L6:
        if (r10 >= 1048576) goto L8;
        return 1048576;
    L8:
        return r10;
    }

    private static boolean c(int r10) {
        if (r10 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 5242880) goto L7;
        return true;
    }

    public static void d(SharedPreferences r10) {
        f13780b = r10.getInt("read_response_buff_init_size", 0);
        f13781c = r10.getInt("read_response_buff_increase_size", 0);
    }

    public static void e(SharedPreferences.Editor r10) {
        r10.putInt("read_response_buff_init_size", f13780b);
        r10.putInt("read_response_buff_increase_size", f13781c);
    }

    public static void f(JSONObject r10) {
        f13780b = r10.optInt("read_response_buff_init_size", 0);
        f13781c = r10.optInt("read_response_buff_increase_size", 0);
        JSONObject r11 = r10.optJSONObject("specific_init_size");
        if (r11 == null) goto L19;
        f13782d.clear();
        Iterator<String> r12 = r11.keys();
    L6:
        if (r12.hasNext() == false) goto L11;
        String r13 = r12.next();
        int r14 = r11.optInt(r13);
        if (r14 < 4096) goto L6;
        f13782d.put(r13, Integer.valueOf(r14));
        goto L6
    L11:
        if (Logger.debug() == false) goto L20;
        Logger.d(f13779a, "bufrefine, get specific init size " + f13782d);
        return;
    L20:
        return;
    }

    public static InputStream g(InputStream r10, Map<String, List<String>> r11, boolean r12, RetrofitMetrics r13) {
        if (r12 == true) goto L4;
        f.s r14 = f.r();
        if (r14 != null) goto L9;
        return r10;
    L9:
        return r14.a(r10, r11, r13);
    L4:
        return new GZIPInputStream(r10);
    }

    public static byte[] h(boolean r16, Map<String, List<String>> r17, int r18, InputStream r19, int[] r20, RetrofitMetrics r21) {
        InputStream r10 = r19;
        int r11 = b(r18);
        if (r10 != null) goto L88;
        return null;
    L88:
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L83
        r10 = g(r10, r17, r16, r21);     // Catch: Throwable -> L83
        int r13 = 32768;
        if (c(f13780b) == false) goto L8;
        r13 = f13780b;     // Catch: Throwable -> L83
    L8:
        int r14 = 102400;
        if (c(f13781c) == false) goto L11;
        r14 = f13781c;     // Catch: Throwable -> L83
    L11:
        if (r21 == null) goto L21;
        URL r15 = r21.f2425a;     // Catch: Throwable -> L83
        if (r15 == null) goto L21;
        if (TextUtils.isEmpty(r15.getPath()) == true) goto L21;
        Integer r110 = f13782d.get(r21.f2425a.getPath());     // Catch: Throwable -> L83
        if (r110 == null) goto L21;
        r13 = r110.intValue();     // Catch: Throwable -> L83
    L21:
        if (Logger.debug() == false) goto L26;
        if (r21 == null) goto L26;
        if (r21.f2425a == null) goto L26;
        Logger.d(f13779a, "bufrefine " + r21.f2425a.getPath() + " read init buf size is " + r13);     // Catch: Throwable -> L83
    L26:
        byte[] r22 = new byte[r13];     // Catch: Throwable -> L83
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L86:
    L50:
        e = move-exception;
        Logger.e(f13779a, "new buff error" + e);     // Catch: Throwable -> L83
    L52:
        l(r10);
        return null;
    L66:
        e = e;
        String r114 = "bufrefine ";
    L68:
        if (r16 == false) goto L82;
        if (r111 <= 0) goto L82;
        String r23 = f13779a;     // Catch: Throwable -> L83
        String r24 = "ungzip got exception " + e;     // Catch: Throwable -> L83
    L64:
        Logger.w(r23, r24);     // Catch: Throwable -> L83
    L71:
        if (r111 <= 0) goto L52;
        if (r21 == null) goto L74;
        r21.f2444j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r12));     // Catch: Throwable -> L83
        r21.f2444j0.put("streamReadByteCount", Long.valueOf(r111));     // Catch: Throwable -> L83
        r21.f2462s0 = r113;     // Catch: Throwable -> L83
        r21.f2427b = r112;     // Catch: Throwable -> L83
        r21.f2429c = 0;     // Catch: Throwable -> L83
    L74:
        r20[0] = r111;     // Catch: Throwable -> L83
        if (Logger.debug() == false) goto L80;
        if (r21 == null) goto L80;
        if (r21.f2425a == null) goto L80;
        Logger.d(f13779a, r114 + r21.f2425a.getPath() + " copyTimes is " + r112 + " final length is " + r111);     // Catch: Throwable -> L83
    L80:
        l(r10);
        return r22;
    L82:
        throw e;     // Catch: Throwable -> L83
    L54:
        e = e;
        r114 = "bufrefine ";
    L56:
        String r25 = e.getMessage();     // Catch: Throwable -> L83
        if (r16 == false) goto L65;
        if (r111 <= 0) goto L65;
        if ("CRC mismatch".equals(r25) == false) goto L62;
    L63:
        r23 = f13779a;     // Catch: Throwable -> L83
        r24 = "ungzip got exception " + e;     // Catch: Throwable -> L83
        goto L64
    L62:
        if ("Size mismatch".equals(r25) == true) goto L63;
    L65:
        throw e;     // Catch: Throwable -> L83
    L30:
        if ((r111 + 4096) > r22.length) goto L32;
    L36:
        int r26 = r10.read(r22, r111, r22.length - r111);     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        r113 = r113 + 1;     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        if (r26 <= 0) goto L49;
        r111 = r111 + r26;     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        if (r111 <= r11) goto L86;
        Logger.w(f13779a, "entity length did exceed given maxLength");     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        r114 = "bufrefine ";
    L47:
        e = e;
    L45:
        e = e;
        goto L56
    L44:
        throw new DownloadFileTooLargeException(r11, r111);     // Catch: IOException -> L45 EOFException -> L47 OutOfMemoryError -> L50 Throwable -> L83
    L49:
        r114 = "bufrefine ";
        goto L71
    L32:
        if (r22.length >= r14) goto L34;
        int r27 = r22.length + r14;     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
    L35:
        byte[] r28 = new byte[r27];     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        System.arraycopy(r22, 0, r28, 0, r111);     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        r112 = r112 + 1;     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
        r22 = r28;
        goto L36
    L34:
        r27 = r22.length * 2;     // Catch: OutOfMemoryError -> L50 IOException -> L54 EOFException -> L66 Throwable -> L83
    L83:
        th = move-exception;
        l(r10);
        throw th;
    }

    public static byte[] i(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, RetrofitMetrics r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        long r15 = System.currentTimeMillis();
        okio.d r16 = new okio.d();
        InputStream r17 = g(r13, r11, r10, r14);
        int r18 = b(r12);
        okio.f r19 = t.b(t.g(r17));     // Catch: Throwable -> L28 Exception -> L30
    L36:
    L21:
        th = move-exception;
        if (r19 != null) goto L37;
    L27:
        throw th;     // Catch: Throwable -> L28 Exception -> L30
    L37:
        r19.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L28 Exception -> L30
        goto L27
    L8:
        if (r19.n() == true) goto L16;
        long r20 = r18;
        if (r19.S(r16, r20 - r16.M()) == (-1)) goto L15;
        if (r16.M() <= r20) goto L36;
    L15:
        throw new DownloadFileTooLargeException(r18, r16.M());     // Catch: Throwable -> L21
    L16:
        if (r14 == null) goto L18;
        r14.f2444j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r15));     // Catch: Throwable -> L21
        r14.f2444j0.put("streamReadByteCount", Long.valueOf(r16.M()));     // Catch: Throwable -> L21
        r14.f2429c = 1;     // Catch: Throwable -> L21
    L18:
        r19.close();     // Catch: Throwable -> L28 Exception -> L30
        l(r17);
        return r16.C();
    L28:
        th = move-exception;
        l(r17);
        throw th;
    L30:
        e = move-exception;
        Logger.e("ttnet_okio", e.getMessage());     // Catch: Throwable -> L28
        throw e;     // Catch: Throwable -> L28
    }

    public static byte[] j(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, RetrofitMetrics r14) {
        if (Logger.debug() == false) goto L9;
        if (r14 == null) goto L9;
        URL r15 = r14.f2425a;
        if (r15 == null) goto L9;
        Logger.d("ttnet_0cp", r15.getPath());
    L9:
        if (r13 != null) goto L11;
        return null;
    L11:
        long r16 = System.currentTimeMillis();
        InputStream r17 = g(r13, r11, r10, r14);
        r17.read(new byte[0]);     // Catch: Throwable -> L20 Exception -> L22
        int r18 = r17.available();     // Catch: Throwable -> L20 Exception -> L22
        if (Logger.debug() == false) goto L15;
        Logger.d("ttnet_0cp", "available size is " + r18);     // Catch: Throwable -> L20 Exception -> L22
    L15:
        byte[] r19 = new byte[r18];     // Catch: Throwable -> L20 Exception -> L22
        r17.read(r19);     // Catch: Throwable -> L20 Exception -> L22
        if (r14 == null) goto L18;
        r14.f2444j0.put("streamReadTime", Long.valueOf(System.currentTimeMillis() - r16));     // Catch: Throwable -> L20 Exception -> L22
        r14.f2429c = 2;     // Catch: Throwable -> L20 Exception -> L22
        r14.f2444j0.put("streamReadByteCount", Long.valueOf(r18));     // Catch: Throwable -> L20 Exception -> L22
    L18:
        l(r17);
        return r19;
    L22:
        e = move-exception;
        Logger.e("ttnet_0cp", e.getMessage());     // Catch: Throwable -> L20
        throw e;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        l(r17);
        throw th;
    }

    public static byte[] k(boolean r10, Map<String, List<String>> r11, int r12, InputStream r13, int[] r14, g r15) {
        if (r13 != null) goto L18;
        return null;
    L18:
        byte[] r16 = h(r10, r11, r12, r13, r14, null);     // Catch: Exception -> L13
        if (r16 != null) goto L9;
    L12:
        return null;
    L9:
        if (r14[0] <= 0) goto L12;
        return r16;
    L13:
        e = move-exception;
        if (r15 != null) goto L20;
    L16:
        throw e;
    L20:
        r15.a();     // Catch: Throwable -> L17
        goto L16
    }

    public static void l(Closeable r10) {
        m(r10, null);
    }

    private static void m(Closeable r10, String r11) {
        if (r10 == null) goto L13;
        r10.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (Logger.debug() == false) goto L14;
        if (r11 == null) goto L15;
        Logger.d(f13779a, r11 + " " + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static boolean n(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r11 = r10.indexOf("application/octet-stream");
        if (r11 < 0) goto L8;
        r11 = r10.indexOf("ssmix=", r11 + 24);
    L8:
        if (r11 <= 0) goto L11;
        return true;
    L11:
        return false;
    }
}
