package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTRequestCompressManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2528a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2529b = 1048576;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f2530c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f2531d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f2532e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static CompressType f2533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f2534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static CopyOnWriteArraySet<Pattern> f2537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static CopyOnWriteArraySet<Pattern> f2540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static CopyOnWriteArraySet<String> f2542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static CopyOnWriteArraySet<Pattern> f2543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile c f2544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile Boolean f2545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final char[] f2546s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static a f2547t;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType BROTLI = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        public static final CompressType ZSTD = null;
        private final int mType;

        static {
            CompressType r10 = new CompressType("NONE", 0, 0);
            NONE = r10;
            CompressType r11 = new CompressType("GZIP", 1, 1);
            GZIP = r11;
            CompressType r12 = new CompressType("BROTLI", 2, 2);
            BROTLI = r12;
            CompressType r13 = new CompressType("ZSTD", 3, 3);
            ZSTD = r13;
            $VALUES = new CompressType[]{r10, r11, r12, r13};
        }

        private CompressType(String r10, int r11, int r12) {
            super(r10, r11);
            this.mType = r12;
        }

        public static CompressType valueOf(String r10) {
            return (CompressType) Enum.valueOf(CompressType.class, r10);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }

        public int getType() {
            return this.mType;
        }
    }

    public static final enum DisableCompress extends Enum<DisableCompress> {
        private static final /* synthetic */ DisableCompress[] $VALUES = null;
        public static final DisableCompress BODY_ENCRYPTED = null;
        public static final DisableCompress BODY_SIZE_MISMATCH = null;
        public static final DisableCompress BODY_SIZE_OVERFLOW = null;
        public static final DisableCompress DATA_NULL = null;
        public static final DisableCompress GLOBAL_DISABLE = null;
        public static final DisableCompress GZIP_PREFIX_MISMATCH = null;
        public static final DisableCompress NONE = null;
        public static final DisableCompress REMOVE_ENCODING = null;
        public static final DisableCompress TNC_DISABLE = null;
        public static final DisableCompress URL_MISMATCH = null;
        public static final DisableCompress USER_DISABLE = null;
        public static final DisableCompress ZSTD_PREFIX_MISMATCH = null;
        private final int reason;

        static {
            DisableCompress r10 = new DisableCompress("NONE", 0, 0);
            NONE = r10;
            DisableCompress r11 = new DisableCompress("GLOBAL_DISABLE", 1, 1);
            GLOBAL_DISABLE = r11;
            DisableCompress r12 = new DisableCompress("TNC_DISABLE", 2, 2);
            TNC_DISABLE = r12;
            DisableCompress r13 = new DisableCompress("URL_MISMATCH", 3, 3);
            URL_MISMATCH = r13;
            DisableCompress r14 = new DisableCompress("BODY_SIZE_MISMATCH", 4, 4);
            BODY_SIZE_MISMATCH = r14;
            DisableCompress r15 = new DisableCompress("BODY_SIZE_OVERFLOW", 5, 5);
            BODY_SIZE_OVERFLOW = r15;
            DisableCompress r16 = new DisableCompress("ZSTD_PREFIX_MISMATCH", 6, 6);
            ZSTD_PREFIX_MISMATCH = r16;
            DisableCompress r17 = new DisableCompress("GZIP_PREFIX_MISMATCH", 7, 7);
            GZIP_PREFIX_MISMATCH = r17;
            DisableCompress r18 = new DisableCompress("BODY_ENCRYPTED", 8, 8);
            BODY_ENCRYPTED = r18;
            DisableCompress r19 = new DisableCompress("REMOVE_ENCODING", 9, 9);
            REMOVE_ENCODING = r19;
            DisableCompress r110 = new DisableCompress("DATA_NULL", 10, 10);
            DATA_NULL = r110;
            DisableCompress r111 = new DisableCompress("USER_DISABLE", 11, 13);
            USER_DISABLE = r111;
            $VALUES = new DisableCompress[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111};
        }

        private DisableCompress(String r10, int r11, int r12) {
            super(r10, r11);
            this.reason = r12;
        }

        public static DisableCompress valueOf(String r10) {
            return (DisableCompress) Enum.valueOf(DisableCompress.class, r10);
        }

        public static DisableCompress[] values() {
            return (DisableCompress[]) $VALUES.clone();
        }

        public int getReason() {
            return this.reason;
        }
    }

    public interface a {
        byte[] a(byte[] r10, int r11);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f2548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2551d;

        b(int r10) {
            this.f2550c = r10;
        }
    }

    public interface c {
        byte[] compressData(byte[] r10, int r11, int r12, int r13);
    }

    static {
        f2533f = CompressType.NONE;
        f2535h = new CopyOnWriteArraySet();
        f2536i = new CopyOnWriteArraySet();
        f2537j = new CopyOnWriteArraySet();
        f2538k = new CopyOnWriteArraySet();
        f2539l = new CopyOnWriteArraySet();
        f2540m = new CopyOnWriteArraySet();
        f2541n = new CopyOnWriteArraySet();
        f2542o = new CopyOnWriteArraySet();
        f2543p = new CopyOnWriteArraySet();
        f2545r = Boolean.FALSE;
        f2546s = "0123456789ABCDEF".toCharArray();
    }

    public static byte[] a(byte[] r10, int r11, int r12) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (f2544q != null) goto L8;
        return null;
    L8:
        return f2544q.compressData(r10, r11, r12, CompressType.BROTLI.getType());
    }

    private static String b(byte[] r10) {
        char[] r11 = new char[r10.length * 2];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        int r13 = r10[r12] & 255;
        int r14 = r12 * 2;
        char[] r15 = f2546s;
        r11[r14] = r15[r13 >>> 4];
        r11[r14 + 1] = r15[r13 & 15];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    public static boolean c(int r10, byte[] r11, CompressType r12, b r13) {
        if (r11 != null) goto L5;
    L37:
        return false;
    L5:
        if (r11.length <= 3) goto L37;
        if (f2534g == true) goto L11;
        return true;
    L11:
        if (r11.length < r10) goto L15;
        r13.f2550c = DisableCompress.BODY_SIZE_OVERFLOW.getReason();
        return false;
    L15:
        if (r12 != CompressType.GZIP) goto L26;
        byte r14 = r11[0];
        byte r15 = r11[1];
        byte r16 = r11[2];
        if (r14 == 31) goto L19;
    L23:
        r13.f2550c = DisableCompress.GZIP_PREFIX_MISMATCH.getReason();
        r13.f2551d = b(new byte[]{r14, r15, r16});
        return false;
    L19:
        if (r15 != (-117)) goto L23;
        if (r16 != 8) goto L23;
        return true;
    L26:
        if (r12 != CompressType.ZSTD) goto L36;
        byte r17 = r11[0];
        byte r18 = r11[1];
        byte r19 = r11[2];
        if (r17 == 40) goto L30;
    L34:
        r13.f2550c = DisableCompress.ZSTD_PREFIX_MISMATCH.getReason();
        r13.f2551d = b(new byte[]{r17, r18, r19});
        return false;
    L30:
        if (r18 != (-75)) goto L34;
        if (r19 != 47) goto L34;
        return true;
    L36:
        return true;
    }

    public static b d(byte[] r10, int r11, String r12, String r13, boolean r14) {
        b r15 = new b(0);
        if (f2545r.booleanValue() == false) goto L10;
        if (Logger.debug() == false) goto L7;
        Log.d("TTRequestCompress", "global compress is disabled.");
    L7:
        r15.f2550c = DisableCompress.GLOBAL_DISABLE.getReason();
        return r15;
    L10:
        if (f2528a == false) goto L56;
        CompressType r16 = f2533f;
        CompressType r17 = CompressType.NONE;
        if (r16 == r17) goto L56;
        CompressType r18 = f(r12, r13);
        if (r14 == true) goto L23;
        if (r18 != r17) goto L23;
        if (Logger.debug() == false) goto L20;
        Log.d("TTRequestCompress", "Url is not matched:" + r12 + r13);
    L20:
        r15.f2550c = DisableCompress.URL_MISMATCH.getReason();
        return r15;
    L23:
        if (r11 > f2529b) goto L51;
        if (r11 < f2530c) goto L51;
        if (r18 != CompressType.GZIP) goto L35;
        byte[] r19 = g(r10, r11);
        if (c(r11, r19, r18, r15) == true) goto L32;
        return r15;
    L32:
        r15.f2548a = r19;
        r15.f2549b = NetConst.GZIP;
        return r15;
    L35:
        if (r18 != CompressType.BROTLI) goto L42;
        byte[] r20 = a(r10, r11, f2531d);
        if (c(r11, r20, r18, r15) == true) goto L39;
        return r15;
    L39:
        r15.f2548a = r20;
        r15.f2549b = "br";
        return r15;
    L42:
        if (r18 != CompressType.ZSTD) goto L48;
        byte[] r21 = r(r10, f2532e);
        if (c(r11, r21, r18, r15) == true) goto L46;
        return r15;
    L46:
        r15.f2548a = r21;
        r15.f2549b = NetConst.TYPE_ZSTD;
        return r15;
    L48:
        return null;
    L51:
        if (Logger.debug() == false) goto L53;
        Log.d("TTRequestCompress", "Request body size is not matched:" + r11);
    L53:
        r15.f2550c = DisableCompress.BODY_SIZE_MISMATCH.getReason();
        return r15;
    L56:
        if (Logger.debug() == false) goto L58;
        Log.d("TTRequestCompress", "Request compress is disabled.");
    L58:
        r15.f2550c = DisableCompress.TNC_DISABLE.getReason();
        return r15;
    }

    private static void e(int r10) {
        if (r10 != 1) goto L5;
        CompressType r11 = CompressType.GZIP;
    L12:
        f2533f = r11;
        return;
    L5:
        if (r10 != 2) goto L7;
        r11 = CompressType.BROTLI;
        goto L12
    L7:
        if (r10 == 3) goto L9;
        r11 = CompressType.NONE;
        goto L12
    L9:
        r11 = CompressType.ZSTD;
        goto L12
    }

    private static CompressType f(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L86;
        if (TextUtils.isEmpty(r11) == true) goto L86;
        if (i(f2538k) == true) goto L14;
        if (f2538k.contains(r11) == false) goto L14;
        return CompressType.ZSTD;
    L14:
        if (i(f2539l) == true) goto L23;
        Iterator<String> r12 = f2539l.iterator();
    L17:
        if (r12.hasNext() == false) goto L23;
        if (r11.startsWith(r12.next()) == false) goto L17;
        return CompressType.ZSTD;
    L23:
        if (i(f2540m) == true) goto L34;
        Iterator<Pattern> r13 = f2540m.iterator();
    L26:
        if (r13.hasNext() == false) goto L34;
        Pattern r14 = r13.next();
        if (r14 == null) goto L26;
        if (r14.matcher(r11).matches() == false) goto L26;
        return CompressType.ZSTD;
    L34:
        if (i(f2535h) == true) goto L40;
        if (f2535h.contains(r11) == false) goto L40;
        return f2533f;
    L40:
        if (i(f2536i) == true) goto L49;
        Iterator<String> r15 = f2536i.iterator();
    L43:
        if (r15.hasNext() == false) goto L49;
        if (r11.startsWith(r15.next()) == false) goto L43;
        return f2533f;
    L49:
        if (i(f2537j) == true) goto L60;
        Iterator<Pattern> r16 = f2537j.iterator();
    L52:
        if (r16.hasNext() == false) goto L60;
        Pattern r17 = r16.next();
        if (r17 == null) goto L52;
        if (r17.matcher(r11).matches() == false) goto L52;
        return f2533f;
    L60:
        if (i(f2541n) == true) goto L84;
        if (j(r10) == false) goto L84;
        if (i(f2542o) == true) goto L71;
        if (f2542o.contains(r11) == false) goto L71;
        return CompressType.NONE;
    L71:
        if (i(f2543p) == true) goto L82;
        Iterator<Pattern> r18 = f2543p.iterator();
    L74:
        if (r18.hasNext() == false) goto L82;
        Pattern r19 = r18.next();
        if (r19 == null) goto L74;
        if (r19.matcher(r11).matches() == false) goto L74;
        return CompressType.NONE;
    L82:
        return f2533f;
    L84:
        return CompressType.NONE;
    L86:
        return CompressType.NONE;
    }

    public static byte[] g(byte[] r10, int r11) {
        GZIPOutputStream r12 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();
        GZIPOutputStream r14 = new GZIPOutputStream(r13);     // Catch: Throwable -> L16 IOException -> L18
        r14.write(r10);     // Catch: IOException -> L14 Throwable -> L29
        r14.close();     // Catch: IOException -> L10
        r13.close();     // Catch: IOException -> L10
    L13:
        return r13.toByteArray();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
    L20:
        Log.w("TTRequestCompress", "Compress with gzip exception: " + e);     // Catch: Throwable -> L29
        if (r14 != null) goto L43;
    L25:
        r13.close();     // Catch: IOException -> L23
    L28:
        return null;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L43:
        r14.close();     // Catch: IOException -> L23
    L29:
        th = th;
        r12 = r14;
    L31:
        if (r12 != null) goto L41;
    L35:
        r13.close();     // Catch: IOException -> L33
    L38:
        throw th;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L41:
        r12.close();     // Catch: IOException -> L33
        goto L35
    L18:
        e = e;
        r14 = null;
    L16:
        th = th;
        goto L31
    }

    public static boolean h() {
        return f2534g;
    }

    private static boolean i(Set<?> r10) {
        if (r10 != null) goto L4;
        return true;
    L4:
        if (r10.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static boolean j(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        Iterator<String> r11 = f2541n.iterator();
    L7:
        if (r11.hasNext() == false) goto L15;
        if (k(r10, r11.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static boolean k(String r12, String r13) {
        if (r12 == null) goto L29;
        if (r13 == null) goto L29;
        int r10 = r12.length();
        int r11 = r13.length();
        int r14 = 0;
        int r15 = 0;
        int r16 = -1;
        int r17 = -1;
    L8:
        if (r14 >= r10) goto L22;
        if (r15 >= r11) goto L15;
        if (r13.charAt(r15) == '?') goto L14;
        if (r13.charAt(r15) != r12.charAt(r14)) goto L15;
    L14:
        r14 = r14 + 1;
        r15 = r15 + 1;
    L15:
        if (r15 >= r11) goto L19;
        if (r13.charAt(r15) != '*') goto L19;
        r17 = r14;
        r16 = r15;
        r15 = r15 + 1;
    L19:
        if (r16 == (-1)) goto L20;
        r15 = r16 + 1;
        r17 = r17 + 1;
        r14 = r17;
        goto L8
    L20:
        return false;
    L22:
        if (r15 >= r11) goto L27;
        if (r13.charAt(r15) != '*') goto L25;
        r15 = r15 + 1;
        goto L22
    L25:
        return false;
    L27:
        return true;
    L29:
        return false;
    }

    public static void l(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        o();
        JSONObject r11 = r10.optJSONObject("tt_compress");
        if (r11 != null) goto L7;
        return;
    L7:
        boolean r12 = false;
        if (r11.optInt("enabled", 0) <= 0) goto L10;
        boolean r13 = true;
    L11:
        f2528a = r13;
        if (r11.optInt("opt_enabled", 0) <= 0) goto L14;
        r12 = true;
    L14:
        f2534g = r12;
        f2529b = r11.optInt("max_body_size", 1048576);
        f2530c = r11.optInt("min_body_size", 100);
        int r14 = r11.optInt("br_level", 4);
        if (r14 >= 0) goto L17;
    L19:
        int r15 = r11.optInt("zstd_level", 6);
        if (r15 >= 1) goto L22;
    L24:
        int r16 = r11.optInt(WsConstants.KEY_CONNECTION_TYPE, CompressType.GZIP.getType());
        e(r16);
        n(r11.optJSONArray("equal_path"), f2535h);
        n(r11.optJSONArray("prefix_path"), f2536i);
        m(r11.optJSONArray("regex_path"), f2537j);
        n(r11.optJSONArray("zstd_equal_path"), f2538k);
        n(r11.optJSONArray("zstd_prefix_path"), f2539l);
        m(r11.optJSONArray("zstd_regex_path"), f2540m);
        n(r11.optJSONArray("host_group"), f2541n);
        n(r11.optJSONArray("block_path_equal_list"), f2542o);
        m(r11.optJSONArray("block_path_regex_list"), f2543p);
        if (Logger.debug() == false) goto L28;
        Log.d("TTRequestCompress", "sRequestCompressEnabled:" + f2528a + " type:" + r16);
        return;
    L28:
        return;
    L22:
        if (r15 > 22) goto L24;
        f2532e = r15;
        goto L24
    L17:
        if (r14 > 11) goto L19;
        f2531d = r14;
        goto L19
    L10:
        r13 = false;
        goto L11
    }

    private static void m(JSONArray r10, CopyOnWriteArraySet<Pattern> r11) {
        if (r10 == null) goto L13;
        if (r11 == null) goto L23;
        int r12 = 0;
    L16:
        if (r12 >= r10.length()) goto L25;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r13) == true) goto L12;
        r11.add(Pattern.compile(r13, 2));     // Catch: Throwable -> L14
    L12:
        r12 = r12 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private static void n(JSONArray r10, CopyOnWriteArraySet<String> r11) {
        if (r10 == null) goto L12;
        if (r11 == null) goto L19;
        int r12 = 0;
    L14:
        if (r12 >= r10.length()) goto L21;
        String r13 = r10.getString(r12);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r13) == true) goto L11;
        r11.add(r13);     // Catch: JSONException -> L13
    L11:
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private static void o() {
        f2528a = false;
        f2529b = 1048576;
        f2530c = 100;
        f2533f = CompressType.NONE;
        f2535h.clear();
        f2536i.clear();
        f2537j.clear();
        f2538k.clear();
        f2539l.clear();
        f2540m.clear();
        f2541n.clear();
        f2542o.clear();
        f2543p.clear();
    }

    public static void p(c r10) {
        f2544q = r10;
    }

    public static void q() {
        f2545r = Boolean.TRUE;
    }

    public static byte[] r(byte[] r10, int r11) {
        a r12 = f2547t;
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.a(r10, r11);
    }
}
