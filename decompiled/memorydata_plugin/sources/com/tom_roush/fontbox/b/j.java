package com.tom_roush.fontbox.b;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class j {
    private static Map<a, j> c;
    private static Map<String, j> d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f15912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15913b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f15914a;

        public a(int r3) {
            this(new int[]{r3});
        }

        public a(int r3, int r4) {
            this(new int[]{r3, r4});
        }

        private a(int[] r2) {
            this.f15914a = null;
            a(r2);
        }

        private void a(int[] r1) {
            this.f15914a = r1;
        }

        public int[] a() {
            return this.f15914a;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L6;
            a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
            return Arrays.equals(a(), r4.a());
        L6:
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(a());
        }

        public String toString() {
            return Arrays.toString(a());
        }
    }

    static {
        c = new LinkedHashMap(52);
        d = new LinkedHashMap(52);
        a(new a(0), "version");
        a(new a(1), "Notice");
        a(new a(12, 0), ExifInterface.TAG_COPYRIGHT);
        a(new a(2), "FullName");
        a(new a(3), "FamilyName");
        a(new a(4), "Weight");
        a(new a(12, 1), "isFixedPitch");
        a(new a(12, 2), "ItalicAngle");
        a(new a(12, 3), "UnderlinePosition");
        a(new a(12, 4), "UnderlineThickness");
        a(new a(12, 5), "PaintType");
        a(new a(12, 6), "CharstringType");
        a(new a(12, 7), "FontMatrix");
        a(new a(13), "UniqueID");
        a(new a(5), "FontBBox");
        a(new a(12, 8), "StrokeWidth");
        a(new a(14), "XUID");
        a(new a(15), "charset");
        a(new a(16), "Encoding");
        a(new a(17), "CharStrings");
        a(new a(18), com.tom_roush.pdfbox.pdmodel.a.d.i.l);
        a(new a(12, 20), "SyntheticBase");
        a(new a(12, 21), "PostScript");
        a(new a(12, 22), "BaseFontName");
        a(new a(12, 23), "BaseFontBlend");
        a(new a(12, 30), "ROS");
        a(new a(12, 31), "CIDFontVersion");
        a(new a(12, 32), "CIDFontRevision");
        a(new a(12, 33), "CIDFontType");
        a(new a(12, 34), "CIDCount");
        a(new a(12, 35), "UIDBase");
        a(new a(12, 36), "FDArray");
        a(new a(12, 37), "FDSelect");
        a(new a(12, 38), "FontName");
        a(new a(6), "BlueValues");
        a(new a(7), "OtherBlues");
        a(new a(8), "FamilyBlues");
        a(new a(9), "FamilyOtherBlues");
        a(new a(12, 9), "BlueScale");
        a(new a(12, 10), "BlueShift");
        a(new a(12, 11), "BlueFuzz");
        a(new a(10), "StdHW");
        a(new a(11), "StdVW");
        a(new a(12, 12), "StemSnapH");
        a(new a(12, 13), "StemSnapV");
        a(new a(12, 14), "ForceBold");
        a(new a(12, 15), "LanguageGroup");
        a(new a(12, 16), "ExpansionFactor");
        a(new a(12, 17), "initialRandomSeed");
        a(new a(19), "Subrs");
        a(new a(20), "defaultWidthX");
        a(new a(21), "nominalWidthX");
    }

    private j(a r2, String r3) {
        this.f15912a = null;
        this.f15913b = null;
        b(r2);
        a(r3);
    }

    public static j a(a r2) {
        return (j) ZeusTransformUtils.preCheckCast(c.get(r2), j.class, "com.obric.memorydata.plugin");
    }

    private static void a(a r2, String r3) {
        j r0 = new j(r2, r3);
        c.put(r2, r0);
        d.put(r3, r0);
    }

    private void a(String r1) {
        this.f15913b = r1;
    }

    private void b(a r1) {
        this.f15912a = r1;
    }

    public a a() {
        return this.f15912a;
    }

    public String b() {
        return this.f15913b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, j.class) == false) goto L6;
        j r4 = (j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin");
        return a().equals(r4.a());
    L6:
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return b();
    }
}
