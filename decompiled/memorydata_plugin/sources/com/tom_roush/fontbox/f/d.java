package com.tom_roush.fontbox.f;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15984b;
    private long c;
    private int[] d;
    private final Map<Integer, List<Integer>> e;
    private Map<Integer, Integer> f;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.f.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f15986b;
        private final short c;
        private final int d;

        private a(int r1, int r2, short r3, int r4) {
            this.f15985a = r1;
            this.f15986b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* synthetic */ a(int r1, int r2, short r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        private int a() {
            return this.f15985a;
        }

        static /* synthetic */ int a(a r0) {
            return r0.a();
        }

        private int b() {
            return this.f15986b;
        }

        static /* synthetic */ int b(a r0) {
            return r0.d();
        }

        private short c() {
            return this.c;
        }

        static /* synthetic */ short c(a r0) {
            return r0.c();
        }

        private int d() {
            return this.d;
        }

        static /* synthetic */ int d(a r0) {
            return r0.b();
        }
    }

    public d() {
        this.e = new HashMap();
        this.f = new HashMap();
    }

    private void c(int r7) {
        this.d = d(r7 + 1);
        Iterator<Map.Entry<Integer, Integer>> r8 = this.f.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (this.d[((Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()] == (-1)) goto L7;
        List r1 = (List) ZeusTransformUtils.preCheckCast(this.e.get(r0.getValue()), List.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
        r1 = new ArrayList();
        this.e.put((Integer) r0.getValue(), (List<Integer>) r1);
        r1.add(Integer.valueOf(this.d[((Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()]));
        this.d[((Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()] = Integer.MIN_VALUE;
    L11:
        r1.add(r0.getKey());
        goto L4
    L7:
        this.d[((Integer) ZeusTransformUtils.preCheckCast(r0.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue()] = ((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L4
    }

    private int[] d(int r1) {
        int[] r0 = new int[r1];
        Arrays.fill(r0, -1);
        return r0;
    }

    private int e(int r2) {
        if (r2 < 0) goto L10;
        int[] r1 = this.d;
        if (r1 != null) goto L6;
        return -1;
    L6:
        if (r2 < r1.length) goto L9;
        return -1;
    L9:
        return r1[r2];
    L10:
        return -1;
    }

    public int a() {
        return this.f15984b;
    }

    @Override // com.tom_roush.fontbox.f.c
    public int a(int r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r2)), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.intValue();
    }

    void a(ad r3) {
        this.f15983a = r3.d();
        this.f15984b = r3.d();
        this.c = r3.k();
    }

    void a(ad r31, int r32) {
        int[] r2 = r31.b(8192);
        long r4 = r31.k();
        if (r4 > 65536) goto L46;
        this.d = d(r32);
        this.f = new HashMap(r32);
        if (r32 != 0) goto L8;
        Log.w("PdfBox-Android", "subtable has no glyphs");
        return;
    L8:
        long r6 = 0;
        long r8 = 0;
    L10:
        if (r8 >= r4) goto L44;
        long r10 = r31.k();
        long r12 = r31.k();
        long r14 = r31.k();
        if (r10 > r12) goto L43;
        if (r6 > r10) goto L43;
        long r7 = r10;
    L17:
        if (r7 > r12) goto L41;
        if (r7 > 2147483647L) goto L40;
        long r22 = r4;
        int r5 = (int) r7;
        int r9 = r5 / 8;
        long r24 = r12;
        if (r9 >= r2.length) goto L38;
        if ((r2[r9] & (1 << (r5 % 8))) == 0) goto L28;
        long r11 = ((((r7 >> 10) + 55232) << 10) + ((r7 & 1023) + 56320)) - 56613888;
        if (r11 > 2147483647L) goto L36;
        r5 = (int) r11;
        goto L28
    L36:
        throw new IOException("[Sub Format 8] Invalid character code " + r11);
    L28:
        long r13 = (r7 - r10) + r14;
        int[] r17 = r2;
        if (r13 > r32) goto L34;
        if (r13 > 2147483647L) goto L34;
        int r3 = (int) r13;
        this.d[r3] = r5;
        this.f.put(Integer.valueOf(r5), Integer.valueOf(r3));
        r7 = r7 + 1;
        r2 = r17;
        r4 = r22;
        r12 = r24;
    L34:
        throw new IOException("CMap contains an invalid glyph index");
    L38:
        throw new IOException("[Sub Format 8] Invalid character code " + r7);
    L40:
        throw new IOException("[Sub Format 8] Invalid character code " + r7);
    L41:
        r8 = r8 + 1;
        r6 = 0;
    L43:
        throw new IOException("Range invalid");
    L44:
        return;
    L46:
        throw new IOException("CMap ( Subtype8 ) is invalid");
    }

    void a(e r5, int r6, ad r7) {
        r7.a(r5.i() + this.c);
        int r8 = r7.d();
        r7.d();
        if (r8 >= 8) goto L5;
        r7.d();
    L6:
        if (r8 != 0) goto L8;
        b(r7);
        return;
    L8:
        if (r8 != 2) goto L10;
        h(r7, r6);
        return;
    L10:
        if (r8 != 4) goto L12;
        g(r7, r6);
        return;
    L12:
        if (r8 == 6) goto L24;
        if (r8 != 8) goto L15;
        a(r7, r6);
        return;
    L15:
        if (r8 == 10) goto L22;
        switch(r8) {
            case 12: goto L21;
            case 13: goto L20;
            case 14: goto L19;
            default: goto L18;
        };
    L19:
        e(r7, r6);
        return;
    L20:
        d(r7, r6);
        return;
    L21:
        c(r7, r6);
        return;
    L18:
        throw new IOException("Unknown cmap format:" + r8);
    L22:
        b(r7, r6);
        return;
    L24:
        f(r7, r6);
        return;
    L5:
        r7.k();
        r7.k();
        goto L6
    }

    public int b() {
        return this.f15983a;
    }

    @Override // com.tom_roush.fontbox.f.c
    public List<Integer> b(int r4) {
        int r0 = e(r4);
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        if (r0 != Integer.MIN_VALUE) goto L10;
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.e.get(Integer.valueOf(r4)), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        ArrayList r1 = new ArrayList(r3);
        Collections.sort(r1);
        return r1;
    L12:
        return null;
    L10:
        ArrayList r2 = new ArrayList(1);
        r2.add(Integer.valueOf(r0));
        return r2;
    }

    void b(ad r5) {
        byte[] r6 = r5.d(256);
        this.d = d(256);
        this.f = new HashMap(r6.length);
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L6;
        int r1 = r6[r0] & 255;
        this.d[r1] = r0;
        this.f.put(Integer.valueOf(r0), Integer.valueOf(r1));
        r0 = r0 + 1;
        goto L4
    }

    void b(ad r7, int r8) {
        long r0 = r7.k();
        long r6 = r7.k();
        if (r6 > 2147483647L) goto L18;
        if (r0 < 0) goto L16;
        if (r0 > 1114111) goto L16;
        long r4 = r0 + r6;
        if (r4 > 1114111) goto L16;
        if (r4 >= 55296) goto L13;
        return;
    L13:
        if (r4 <= 57343) goto L16;
        return;
    L16:
        throw new IOException("Invalid character codes, " + String.format("startCode: 0x%X, numChars: %d", new Object[]{Long.valueOf(r0), Long.valueOf(r6)}));
    L18:
        throw new IOException("Invalid number of Characters");
    }

    void c(ad r29, int r30) {
        long r2 = r29.k();
        this.d = d(r30);
        this.f = new HashMap(r30);
        if (r30 != 0) goto L6;
        Log.w("PdfBox-Android", "subtable has no glyphs");
        return;
    L6:
        long r6 = 0;
        long r8 = 0;
        int r10 = 0;
    L8:
        if (r8 >= r2) goto L42;
        long r11 = r29.k();
        long r13 = r29.k();
        long r15 = r29.k();
        if (r11 < r6) goto L41;
        if (r11 > 1114111) goto L41;
        if (r11 < 55296) goto L18;
        if (r11 <= 57343) goto L41;
    L18:
        if (r13 <= 0) goto L22;
        if (r13 >= r11) goto L22;
    L39:
        throw new IOException("Invalid character code " + String.format("0x%X", new Object[]{Long.valueOf(r13)}));
    L22:
        if (r13 > 1114111) goto L39;
        if (r13 >= 55296) goto L26;
    L27:
        long r5 = 0;
    L28:
        long r24 = r2;
        if (r5 > (r13 - r11)) goto L37;
        long r3 = r15 + r5;
        long r26 = r13;
        if (r3 >= r30) goto L32;
        long r14 = r11 + r5;
        if (r14 <= 1114111) goto L36;
        Log.w("PdfBox-Android", "Format 12 cmap contains character beyond UCS-4");
    L36:
        int r4 = (int) r3;
        r10 = Math.max(r10, r4);
        this.f.put(Integer.valueOf((int) r14), Integer.valueOf(r4));
        r5 = r5 + 1;
        r2 = r24;
        r13 = r26;
        goto L28
    L32:
        Log.w("PdfBox-Android", "Format 12 cmap contains an invalid glyph index");
    L37:
        r8 = r8 + 1;
        r6 = 0;
        r2 = r24;
        goto L8
    L26:
        if (r13 <= 57343) goto L39;
    L41:
        throw new IOException("Invalid character code " + String.format("0x%X", new Object[]{Long.valueOf(r11)}));
    L42:
        c(r10);
    }

    void d(ad r27, int r28) {
        int r1 = r28;
        long r2 = r27.k();
        this.d = d(r1);
        this.f = new HashMap(r1);
        if (r1 != 0) goto L6;
        Log.w("PdfBox-Android", "subtable has no glyphs");
        return;
    L6:
        long r7 = 0;
    L8:
        if (r7 >= r2) goto L59;
        long r9 = r27.k();
        long r11 = r27.k();
        long r13 = r27.k();
        if (r13 > r1) goto L11;
        if (r9 < 0) goto L45;
        if (r9 > 1114111) goto L45;
        if (r9 < 55296) goto L21;
        if (r9 <= 57343) goto L45;
    L21:
        if (r11 <= 0) goto L25;
        if (r11 >= r9) goto L25;
    L43:
        throw new IOException("Invalid character code " + String.format("0x%X", new Object[]{Long.valueOf(r11)}));
    L25:
        if (r11 > 1114111) goto L43;
        if (r11 >= 55296) goto L29;
    L30:
        long r5 = 0;
    L31:
        long r24 = r2;
        if (r5 > (r11 - r9)) goto L41;
        long r3 = r9 + r5;
        if (r3 > 2147483647L) goto L40;
        if (r3 <= 1114111) goto L38;
        Log.w("PdfBox-Android", "Format 13 cmap contains character beyond UCS-4");
    L38:
        int r15 = (int) r13;
        int r4 = (int) r3;
        this.d[r15] = r4;
        this.f.put(Integer.valueOf(r4), Integer.valueOf(r15));
        r5 = r5 + 1;
        r2 = r24;
        goto L31
    L40:
        throw new IOException("Character Code greater than Integer.MAX_VALUE");
    L41:
        r7 = r7 + 1;
        r1 = r28;
        goto L8
    L29:
        if (r11 <= 57343) goto L43;
    L45:
        throw new IOException("Invalid character code " + String.format("0x%X", new Object[]{Long.valueOf(r9)}));
    L11:
        Log.w("PdfBox-Android", "Format 13 cmap contains an invalid glyph index");
        return;
    }

    void e(ad r1, int r2) {
        Log.w("PdfBox-Android", "Format 14 cmap table is not supported and will be ignored");
    }

    void f(ad r7, int r8) {
        int r0 = r7.d();
        int r1 = r7.d();
        if (r1 != 0) goto L5;
        return;
    L5:
        this.f = new HashMap(r8);
        int[] r9 = r7.c(r1);
        int r10 = 0;
        int r2 = 0;
    L6:
        if (r10 >= r1) goto L8;
        r2 = Math.max(r2, r9[r10]);
        this.f.put(Integer.valueOf(r0 + r10), Integer.valueOf(r9[r10]));
        r10 = r10 + 1;
        goto L6
    L8:
        c(r2);
    }

    void g(ad r25, int r26) {
        int r2 = r25.d() / 2;
        r25.d();
        r25.d();
        r25.d();
        int[] r3 = r25.c(r2);
        r25.d();
        int[] r4 = r25.c(r2);
        int[] r5 = r25.c(r2);
        long r6 = r25.f();
        int[] r8 = r25.c(r2);
        this.f = new HashMap(r26);
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r9 >= r2) goto L18;
        int r11 = r4[r9];
        int r12 = r3[r9];
        int r13 = r5[r9];
        int r14 = r8[r9];
        int r15 = r2;
        int[] r16 = r3;
        int[] r19 = r4;
        int[] r20 = r5;
        long r7 = ((((long) r9) * 2) + r6) + ((long) r14);
        int r17 = 65535;
        if (r11 == 65535) goto L16;
        if (r12 == 65535) goto L16;
        int r18 = r11;
    L8:
        if (r18 > r12) goto L16;
        if (r14 != 0) goto L12;
        long r22 = r6;
        int r21 = (r18 + r13) & r17;
        int r23 = Math.max(r21, r10);
        this.f.put(Integer.valueOf(r18), Integer.valueOf(r21));
    L11:
        r10 = r23;
    L15:
        r18 = r18 + 1;
        r6 = r22;
        r17 = 65535;
        goto L8
    L12:
        r22 = r6;
        r25.a((((long) (r18 - r11)) * 2) + r7);
        int r24 = r25.d();
        if (r24 == 0) goto L15;
        int r27 = (r24 + r13) & 65535;
        r23 = Math.max(r27, r10);
        this.f.put(Integer.valueOf(r18), Integer.valueOf(r27));
    L16:
        r9 = r9 + 1;
        r2 = r15;
        r3 = r16;
        r4 = r19;
        r5 = r20;
        r6 = r6;
        goto L3
    L18:
        if (this.f.isEmpty() == false) goto L21;
        Log.w("PdfBox-Android", "cmap format 4 subtable is empty");
        return;
    L21:
        c(r10);
    }

    void h(ad r19, int r20) {
        int[] r3 = new int[256];
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r5 >= 256) goto L5;
        r3[r5] = r19.d();
        r6 = Math.max(r6, r3[r5] / 8);
        r5 = r5 + 1;
        goto L3
    L5:
        int r2 = r6 + 1;
        a[] r4 = new a[r2];
        int r7 = 0;
    L6:
        if (r7 > r6) goto L8;
        r4[r7] = new a(r19.d(), r19.d(), r19.e(), (r19.d() - (((r2 - r7) - 1) * 8)) - 2, null);
        r7 = r7 + 1;
        goto L6
    L8:
        long r8 = r19.f();
        this.d = d(r20);
        this.f = new HashMap(r20);
        if (r20 != 0) goto L12;
        Log.w("PdfBox-Android", "subtable has no glyphs");
        return;
    L12:
        int r9 = 0;
    L13:
        if (r9 > r6) goto L26;
        a r10 = r4[r9];
        int r11 = a.a(r10);
        int r12 = a.b(r10);
        short r13 = a.c(r10);
        int r14 = a.d(r10);
        r19.a(((long) r12) + r8);
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L25;
        int r16 = (r9 << 8) + (r11 + r15);
        int r17 = r19.d();
        if (r17 <= 0) goto L21;
        r17 = (r17 + r13) % 65536;
        if (r17 >= 0) goto L21;
        r17 = r17 + 65536;
    L21:
        if (r17 < r20) goto L23;
        Log.w("PdfBox-Android", "glyphId " + r17 + " for charcode " + r16 + " ignored, numGlyphs is " + r20);
    L24:
        r15 = r15 + 1;
        r4 = r4;
        goto L15
    L23:
        this.d[r17] = r16;
        this.f.put(Integer.valueOf(r16), Integer.valueOf(r17));
        goto L24
    L25:
        r9 = r9 + 1;
        goto L13
    }

    public String toString() {
        return "{" + b() + " " + a() + "}";
    }
}
