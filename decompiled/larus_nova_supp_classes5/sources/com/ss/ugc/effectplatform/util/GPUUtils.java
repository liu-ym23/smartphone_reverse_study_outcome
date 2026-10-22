package com.ss.ugc.effectplatform.util;

import android.util.SparseArray;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class GPUUtils {
    public static final HashMap<String, float[]> a = null;
    public static final SparseArray<float[]> b = null;
    public static final Pattern c = null;
    public static final Lazy d = null;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
        public final int f;
        public double g;
        public String h;

        public final String toString() {
            return "GPUInfo{renderer='" + this.a + "', version='" + this.b + "', vendor='" + this.c + "', maxFreq=" + this.d + ", minFreq=" + this.e + ", glVer=" + this.f + ", alusOrThroughput=" + this.g + "}";
        }

        public a() {
            this.a = "unknown";
            this.b = "unknown";
            this.c = "unknown";
            this.f = -1;
            this.g = -1.0d;
            this.h = "unknown";
        }
    }

    static {
        HashMap<String, float[]> r0 = new HashMap();
        a = r0;
        SparseArray<float[]> r1 = new SparseArray();
        b = r1;
        c = PatternProtector.compile("\\d+$");
        d = LazyKt.lazy(GPUUtils$gpuInfo$2.INSTANCE);
        r0.put("mali-g72", new float[]{850.0f, 850.0f, 27.2f});
        r0.put("mali-g71", new float[]{850.0f, 850.0f, 27.2f});
        r0.put("mali-t880", new float[]{850.0f, 850.0f, 13.6f});
        r0.put("mali-t860", new float[]{650.0f, 650.0f, 10.4f});
        r0.put("mali-t760", new float[]{650.0f, 650.0f, 10.4f});
        r0.put("mali-g51", new float[]{650.0f, 650.0f, 3.9f});
        r0.put("mali-t830", new float[]{650.0f, 650.0f, 2.6f});
        r0.put("mali-t820", new float[]{650.0f, 650.0f, 2.6f});
        r0.put("mali-t720", new float[]{650.0f, 650.0f, 5.2f});
        r0.put("mali-t470", new float[]{250.0f, 650.0f, 0.65f});
        r0.put("mali-t450", new float[]{270.0f, 650.0f, 5.2f});
        r0.put("mali-t400", new float[]{210.0f, 500.0f, 2.0f});
        r0.put("mali-400 mp", new float[]{210.0f, 500.0f, 2.0f});
        r0.put("mali-450 mp", new float[]{210.0f, 500.0f, 2.6f});
        r1.put(200, new float[]{200.0f, 245.0f, 8.0f});
        r1.put(203, new float[]{245.0f, 294.0f, 16.0f});
        r1.put(205, new float[]{225.0f, 245.0f, 16.0f});
        r1.put(220, new float[]{266.0f, 266.0f, 32.0f});
        r1.put(225, new float[]{400.0f, 400.0f, 32.0f});
        r1.put(302, new float[]{400.0f, 400.0f, 24.0f});
        r1.put(304, new float[]{400.0f, 400.0f, 24.0f});
        r1.put(305, new float[]{400.0f, 450.0f, 24.0f});
        r1.put(306, new float[]{400.0f, 400.0f, 24.0f});
        r1.put(308, new float[]{500.0f, 500.0f, 24.0f});
        r1.put(320, new float[]{450.0f, 450.0f, 96.0f});
        r1.put(330, new float[]{578.0f, 578.0f, 128.0f});
        r1.put(405, new float[]{550.0f, 550.0f, 48.0f});
        r1.put(418, new float[]{600.0f, 600.0f, 128.0f});
        r1.put(420, new float[]{600.0f, 600.0f, 128.0f});
        r1.put(430, new float[]{500.0f, 650.0f, 192.0f});
        r1.put(505, new float[]{450.0f, 450.0f, 48.0f});
        r1.put(506, new float[]{650.0f, 650.0f, 96.0f});
        r1.put(508, new float[]{850.0f, 850.0f, 96.0f});
        r1.put(510, new float[]{600.0f, 600.0f, 128.0f});
        r1.put(512, new float[]{600.0f, 850.0f, 128.0f});
        r1.put(530, new float[]{650.0f, 650.0f, 256.0f});
        r1.put(540, new float[]{710.0f, 710.0f, 256.0f});
    }

    public static int a(String r2) {
        Matcher r3 = c.matcher(r2);
        if (r3.find() == false) goto L9;
        boolean r0 = false;
        String r4 = r3.group(0);
        if (r4.length() <= 0) goto L7;
        r0 = true;
    L7:
        if (r0 == false) goto L9;
        return CastIntegerProtector.parseInt(r4);
    L9:
        return -1;
    }

    public static double b(String r5) {
        if (r5.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        float[] r4 = null;
        if (StringsKt.startsWith$default(r5.toLowerCase(), "mali", false, 2, null) == false) goto L11;
        r4 = a.get(r5);
    L13:
        if (r4 == null) goto L17;
        return r4[2];
    L11:
        if (StringsKt.contains$default(r5.toLowerCase(), "adreno", false, 2, null) == false) goto L13;
        r4 = b.get(a(r5));
    L17:
        return -1;
    L5:
        r0 = false;
        goto L6
    }

    public static int c(String r13, String r14) {
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        int r3 = -1;
        if (r0 == false) goto L9;
        return -1;
    L9:
        BufferedReader r6 = null;
        if (StringsKt.startsWith$default(r13.toLowerCase(), "mali", false, 2, null) == false) goto L19;
        float[] r15 = a.get(r13);
        if (r15 != null) goto L14;
        return 850;
    L14:
        if (Intrinsics.areEqual("min", r14) == false) goto L16;
        float r16 = r15[0];
    L25:
        int r17 = (int) r16;
    L101:
        return r17;
    L16:
        r16 = r15[1];
        goto L25
    L19:
        if (StringsKt.startsWith$default(r13.toLowerCase(), "adreno", false, 2, null) == false) goto L100;
        int r18 = a(r13);
        if (r18 <= 0) goto L27;
        float[] r1 = b.get(r18);
        if (r1 == null) goto L27;
        r16 = r1[1];
    L27:
        File[] r2 = new PolarisFileWrapper("/sys/class/devfreq/").listFiles(j.a);
        if (r2 != null) goto L30;
    L36:
        boolean r4 = true;
    L37:
        if (r4 == false) goto L39;
        r17 = r18 + 200;
        goto L101
    L39:
        int r19 = r2.length;
        int r5 = 0;
    L40:
        if (r5 >= r19) goto L104;
        BufferedReader r7 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(r2[r5], r14.concat("_freq"))));     // Catch: Throwable -> L65 Exception -> L69
    L85:
        String r8 = r7.readLine();     // Catch: Throwable -> L62 Exception -> L64
        int r9 = r8.length() - 1;     // Catch: Throwable -> L62 Exception -> L64
        int r10 = 0;
        boolean r11 = false;
    L44:
        if (r10 > r9) goto L59;
        if (r11 == true) goto L47;
        int r12 = r10;
    L49:
        if (r8.charAt(r12) > ' ') goto L51;
        boolean r110 = true;
    L52:
        if (r11 == false) goto L53;
        if (r110 == false) goto L59;
        r9 = r9 - 1;     // Catch: Throwable -> L62 Exception -> L64
        goto L44
    L53:
        if (r110 == false) goto L54;
        r10 = r10 + 1;     // Catch: Throwable -> L62 Exception -> L64
        goto L44
    L54:
        r11 = true;
        goto L44
    L51:
        r110 = false;
        goto L52
    L47:
        r12 = r9;
    L59:
        int r20 = Integer.parseInt(r8.subSequence(r10, r9 + 1).toString()) / 1000000;     // Catch: Throwable -> L62 Exception -> L64
        r7.close();     // Catch: IOException -> L74
        return r20;
    L103:
        return r20;
    L62:
        th = th;
        r6 = r7;
    L66:
        if (r6 != null) goto L77;
    L68:
        throw th;
    L77:
        r6.close();     // Catch: IOException -> L75
    L70:
        if (r7 == null) goto L72;
        r7.close();     // Catch: IOException -> L76
    L72:
        r5 = r5 + 1;
    L69:
        r7 = null;
    L65:
        th = th;
        goto L66
    L104:
        return r3;
    L30:
        if (r2.length != 0) goto L32;
        boolean r21 = true;
    L33:
        if (r21 == true) goto L36;
        r4 = false;
        goto L37
    L32:
        r21 = false;
        goto L33
    L100:
        return -1;
    L5:
        r0 = false;
        goto L6
    }
}
