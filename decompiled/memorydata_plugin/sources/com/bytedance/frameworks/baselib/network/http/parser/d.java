package com.bytedance.frameworks.baselib.network.http.parser;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.f;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2532a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f2533b;
    private static volatile int c;
    private static final Map<String, Integer> d = null;
    private static volatile int e;
    private static final Map<String, Integer> f = null;

    static {
        d = new ConcurrentHashMap();
        e = 5242880;
        f = new ConcurrentHashMap();
    }

    public d() {
    }

    private static int a(int r4, RetrofitMetrics r5) {
        Map<String, Integer> r0 = f;
        if (r0.isEmpty() == true) goto L17;
        if (r5 == null) goto L17;
        if (r5.url == null) goto L17;
        String r6 = r5.url.getPath();
        Iterator<String> r1 = r0.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r6.startsWith(r2) == false) goto L9;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(f.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        return r3.intValue();
    L17:
        if (r4 < 5242880) goto L20;
        return r4;
    L20:
        return Math.max(e, 5242880);
    }

    public static InputStream a(InputStream r2, Map<String, List<String>> r3, boolean r4, RetrofitMetrics r5) {
        Map<String, List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L5;
        f.s r7 = f.j();
        if (r7 != null) goto L9;
        return r2;
    L9:
        if (r5 == null) goto L19;
        r5.inputStreamProcessStart();
    L19:
        InputStream r8 = r7.a(r2, r6, r5);     // Catch: Throwable -> L15
        if (r5 == null) goto L14;
        r5.inputStreamProcessEnd();
    L14:
        return r8;
    L15:
        th = move-exception;
        if (r5 == null) goto L18;
        r5.inputStreamProcessEnd();
    L18:
        throw th;
    L5:
        return new GZIPInputStream(r2);
    }

    public static void a(SharedPreferences.Editor r2) {
        SharedPreferences.Editor r3 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
        r3.putInt("read_response_buff_init_size", f2533b);
        r3.putInt("read_response_buff_increase_size", c);
    }

    public static void a(SharedPreferences r2) {
        SharedPreferences r3 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.class, "com.obric.memorydata.plugin");
        f2533b = r3.getInt("read_response_buff_init_size", 0);
        c = r3.getInt("read_response_buff_increase_size", 0);
    }

    public static void a(Closeable r2) {
        a((Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin"), null);
    }

    private static void a(Closeable r2, String r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L14;
        r4.close();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        if (Logger.debug() == false) goto L15;
        if (r3 == null) goto L16;
        Logger.d(f2532a, r3 + " " + e);
        return;
    L16:
        return;
    L15:
        return;
    }

    public static void a(JSONObject r9) {
        f2533b = r9.optInt("read_response_buff_init_size", 0);
        c = r9.optInt("read_response_buff_increase_size", 0);
        JSONObject r0 = r9.optJSONObject("specific_init_size");
        if (r0 == null) goto L13;
        d.clear();
        Iterator<String> r2 = r0.keys();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        int r4 = r0.optInt(r3);
        if (r4 < 4096) goto L6;
        d.put(r3, Integer.valueOf(r4));
        goto L6
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(f2532a, "bufrefine, get specific init size " + d);
    L13:
        e = r9.optInt("retrofit_response_max_length", 5242880);
        JSONObject r10 = r9.optJSONObject("retrofit_response_max_length_path_prefix_list");
        f.clear();
        if (r10 == null) goto L23;
        Iterator<String> r1 = r10.keys();
    L17:
        if (r1.hasNext() == false) goto L36;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        int r6 = r10.optInt(r5);
        if (r6 < 5242880) goto L17;
        Map<String, Integer> r7 = f;
        r7.put(r5, Integer.valueOf(r6));
        if (Logger.debug() == false) goto L17;
        Logger.d(f2532a, "max length refine, " + r7.size() + " key " + r5 + " value " + r6);
        goto L17
    L36:
        return;
    }

    public static void a(byte[] r4, int r5) {
        if (r4 == null) goto L8;
        if (r5 <= 0) goto L10;
        byte[] r0 = {-99, -114, ByteCompanionObject.MAX_VALUE, 90};
        int r1 = 0;
    L6:
        if (r1 >= r5) goto L11;
        r4[r1] = (byte) (r4[r1] ^ r0[r1 % 4]);
        r1 = r1 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    private static boolean a(int r1) {
        if (r1 >= 4096) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 5242880) goto L7;
        return true;
    }

    public static boolean a(String r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = r3.indexOf("application/octet-stream");
        if (r1 < 0) goto L8;
        r1 = r3.indexOf("ssmix=", r1 + 24);
    L8:
        if (r1 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    private static byte[] a(int r7, InputStream r8, RetrofitMetrics r9) {
        Buffer r0 = new Buffer();
        BufferedSource r10 = Okio.buffer(Okio.source(r8));     // Catch: Exception -> L26
    L29:
    L19:
        th = move-exception;
        if (r10 != null) goto L30;
    L25:
        throw th;     // Catch: Exception -> L26
    L30:
        r10.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L26
        goto L25
    L5:
        if (r10.exhausted() == true) goto L13;
        long r1 = r7;
        if (r10.read(r0, r1 - r0.size()) == (-1)) goto L12;
        if (r0.size() <= r1) goto L29;
    L12:
        throw new DownloadFileTooLargeException(r7, r0.size());     // Catch: Throwable -> L19
    L13:
        if (r9 == null) goto L15;
        r9.responseReadType = 1;     // Catch: Throwable -> L19
        r9.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r0.size()));     // Catch: Throwable -> L19
    L15:
        byte[] r11 = r0.readByteArray();     // Catch: Throwable -> L19
        if (r10 == null) goto L18;
        r10.close();     // Catch: Exception -> L26
    L18:
        return r11;
    L26:
        e = move-exception;
        Logger.e("ttnet_okio", e.getMessage());
        throw e;
    }

    public static byte[] a(InputStream r5, RetrofitMetrics r6) {
        if (r5 != null) goto L17;
        return null;
    L17:
        r5.read(new byte[0]);     // Catch: IOException -> L14
        int r1 = r5.available();     // Catch: IOException -> L14
        if (Logger.debug() == false) goto L10;
        Logger.d("ttnet_0cp", "available size is " + r1);     // Catch: IOException -> L14
    L10:
        byte[] r2 = new byte[r1];     // Catch: IOException -> L14
        r5.read(r2);     // Catch: IOException -> L14
        if (r6 == null) goto L13;
        r6.responseReadType = 2;     // Catch: IOException -> L14
        r6.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r1));     // Catch: IOException -> L14
    L13:
        return r2;
    L14:
        e = move-exception;
        Logger.e("ttnet_0cp", e.getMessage());
        throw e;
    }

    private static byte[] a(boolean r11, int r12, InputStream r13, int[] r14, RetrofitMetrics r15) {
        if (a(f2533b) == false) goto L5;
        int r1 = f2533b;
    L6:
        int r2 = 102400;
        if (a(c) == false) goto L9;
        r2 = c;
    L9:
        if (r15 == null) goto L18;
        if (r15.url == null) goto L18;
        if (TextUtils.isEmpty(r15.url.getPath()) == true) goto L18;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(d.get(r15.url.getPath()), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        r1 = r3.intValue();
    L18:
        if (Logger.debug() == false) goto L23;
        if (r15 == null) goto L23;
        if (r15.url == null) goto L23;
        Logger.d(f2532a, "bufrefine " + r15.url.getPath() + " read init buf size is " + r1);
    L23:
        byte[] r4 = new byte[r1];
        int r5 = 0;
        int r6 = 0;
    L70:
    L52:
        e = e;
        if (r11 == false) goto L69;
        if (r5 <= 0) goto L69;
        String r16 = f2532a;
        StringBuilder r17 = new StringBuilder();
    L56:
        Logger.w(r16, r17.append("ungzip got exception ").append(e).toString());
    L57:
        if (r5 <= 0) goto L68;
        if (r15 == null) goto L61;
        r15.responseReadType = 0;
        r15.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_BYTE_COUNT, Long.valueOf(r5));
        r15.streamParserCopyCount = r6;
    L61:
        if (Logger.debug() == false) goto L66;
        if (r15 == null) goto L66;
        if (r15.url == null) goto L66;
        Logger.d(f2532a, "bufrefine " + r15.url.getPath() + " copyTimes is " + r6 + " final length is " + r5);
    L66:
        byte[] r18 = new byte[r5];
        System.arraycopy(r4, 0, r18, 0, r5);
        r14[0] = r5;
        return r18;
    L68:
        return null;
    L69:
        throw e;
    L42:
        e = e;
        String r19 = e.getMessage();
        if (r11 == false) goto L51;
        if (r5 <= 0) goto L51;
        if ("CRC mismatch".equals(r19) == false) goto L49;
    L50:
        r16 = f2532a;
        r17 = new StringBuilder();
        goto L56
    L49:
        if ("Size mismatch".equals(r19) == true) goto L50;
    L51:
        throw e;
    L39:
        e = move-exception;
        Logger.e(f2532a, "new buff error" + e);
        return null;
    L26:
        if ((r5 + 4096) > r4.length) goto L28;
    L32:
        int r7 = r13.read(r4, r5, r4.length - r5);     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        if (r7 <= 0) goto L57;
        r5 = r5 + r7;     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        if (r5 <= r12) goto L70;
        Logger.w(f2532a, "entity length did exceed given maxLength");     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        throw new DownloadFileTooLargeException(r12, r5);     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
    L28:
        if (r4.length >= r2) goto L30;
        int r8 = r4.length + r2;     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
    L31:
        byte[] r9 = new byte[r8];     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        System.arraycopy(r4, 0, r9, 0, r5);     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        r6 = r6 + 1;     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        r4 = r9;
        goto L32
    L30:
        r8 = r4.length * 2;     // Catch: OutOfMemoryError -> L39 IOException -> L42 EOFException -> L52
        goto L31
    L5:
        r1 = 32768;
        goto L6
    }

    public static byte[] a(boolean r3, int r4, InputStream r5, int[] r6, RetrofitMetrics r7, boolean r8, boolean r9) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = a(r4, r7);
        if (Logger.debug() == false) goto L8;
        Logger.d(f2532a, "readResponseInternal maxLength is " + r10);
    L8:
        long r0 = System.currentTimeMillis();
        if (r9 == false) goto L16;
        byte[] r11 = a(r5, r7);     // Catch: Throwable -> L14
        if (r7 == null) goto L13;
        r7.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r0));
    L13:
        return r11;
    L16:
        if (r8 == false) goto L21;
        byte[] r12 = a(r10, r5, r7);     // Catch: Throwable -> L14
        if (r7 == null) goto L20;
        r7.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r0));
    L20:
        return r12;
    L21:
        byte[] r13 = a(r3, r10, r5, r6, r7);     // Catch: Throwable -> L14
        if (r7 == null) goto L24;
        r7.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r0));
    L24:
        return r13;
    L14:
        th = move-exception;
        if (r7 == null) goto L27;
        r7.extra.put(RetrofitMetrics.ExtraKeys.STREAM_READ_TIME, Long.valueOf(System.currentTimeMillis() - r0));
    L27:
        throw th;
    }

    public static byte[] a(boolean r8, Map<String, List<String>> r9, int r10, InputStream r11, int[] r12, g r13) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        g r14 = (g) ZeusTransformUtils.wrapperContextForParams(r13, g.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L20;
        return null;
    L20:
        byte[] r15 = a(r8, r3, r10, r11, r12, null);     // Catch: Exception -> L13
        if (r15 != null) goto L9;
    L12:
        return null;
    L9:
        if (r12[0] <= 0) goto L12;
        return r15;
    L13:
        e = move-exception;
        if (r14 != null) goto L18;
    L16:
        throw e;
    L18:
        r14.a();     // Catch: Throwable -> L17
        goto L16
    }

    public static byte[] a(boolean r7, Map<String, List<String>> r8, int r9, InputStream r10, int[] r11, RetrofitMetrics r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L12;
        return null;
    L12:
        r10 = a(r10, r13, r7, r12);     // Catch: Throwable -> L9
        byte[] r14 = a(r7, r9, r10, r11, r12, false, false);     // Catch: Throwable -> L9
        a(r10);
        return r14;
    L9:
        th = move-exception;
        a(r10);
        throw th;
    }
}
