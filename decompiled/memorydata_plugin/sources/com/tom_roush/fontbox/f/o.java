package com.tom_roush.fontbox.f;

import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f16011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16012b;
    private boolean c;
    private a d;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.f.o$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface a {
        void a(ad r1);
    }

    private static class b implements a, Comparator<int[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f16013a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f16014b;
        private int[][] c;

        static {
            f16013a = true;
        }

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        public int a(int[] r5, int[] r6) {
            boolean r4 = f16013a;
            if (r4 == true) goto L9;
            if (r5 != null) goto L9;
            throw new AssertionError();
        L9:
            if (r4 == false) goto L11;
        L15:
            if (r4 == true) goto L20;
            if (r6 != null) goto L20;
            throw new AssertionError();
        L20:
            if (r4 == false) goto L22;
        L26:
            int r0 = r5[0];
            int r1 = r6[0];
            if (r0 >= r1) goto L30;
            return -1;
        L30:
            if (r0 <= r1) goto L32;
            return 1;
        L32:
            int r7 = r5[1];
            int r8 = r6[1];
            if (r7 >= r8) goto L35;
            return -1;
        L35:
            if (r7 <= r8) goto L37;
            return 1;
        L37:
            return 0;
        L22:
            if (r6.length >= 2) goto L26;
            throw new AssertionError();
        L11:
            if (r5.length >= 2) goto L15;
            throw new AssertionError();
        }

        @Override // com.tom_roush.fontbox.f.o.a
        public void a(ad r11) {
            int r0 = r11.d();
            this.f16014b = r11.d() / 6;
            r11.d();
            r11.d();
            this.c = (int[][]) Array.newInstance(int.class, new int[]{r0, 3});
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            int r5 = r11.d();
            int r6 = r11.d();
            short r7 = r11.e();
            int[][] r8 = this.c;
            r8[r2][0] = r5;
            r8[r2][1] = r6;
            r8[r2][2] = r7;
            r2 = r2 + 1;
            goto L3
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(int[] r3, int[] r4) {
            return a((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.memorydata.plugin"), (int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.memorydata.plugin"));
        }
    }

    o() {
    }

    private void a(ad r6) {
        int r0 = r6.d();
        if (r0 == 0) goto L6;
        Log.i("PdfBox-Android", "Unsupported kerning sub-table version: " + r0);
        return;
    L6:
        int r1 = r6.d();
        if (r1 < 6) goto L25;
        int r2 = r6.d();
        if (a(r2, 1, 0) == false) goto L12;
        this.f16011a = true;
    L12:
        if (a(r2, 2, 1) == false) goto L15;
        this.f16012b = true;
    L15:
        if (a(r2, 4, 2) == false) goto L17;
        this.c = true;
    L17:
        int r3 = b(r2, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 8);
        if (r3 != 0) goto L20;
        b(r6);
        return;
    L20:
        if (r3 != 2) goto L22;
        c(r6);
        return;
    L22:
        Log.d("PdfBox-Android", "Skipped kerning subtable due to an unsupported kerning subtable version: " + r3);
        return;
    L25:
        throw new IOException("Kerning sub-table too short, got " + r1 + " bytes, expect 6 or more.");
    }

    private static boolean a(int r0, int r1, int r2) {
        if (b(r0, r1, r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static int b(int r0, int r1, int r2) {
        return (r0 & r1) >> r2;
    }

    private void b(ad r3) {
        b r0 = new b(null);
        this.d = r0;
        r0.a(r3);
    }

    private void c(ad r1) {
        Log.i("PdfBox-Android", "Kerning subtable format 2 not yet supported.");
    }

    private void d(ad r1) {
        Log.i("PdfBox-Android", "Kerning subtable format 1 not yet supported.");
    }

    void a(ad r2, int r3) {
        if (r3 != 0) goto L5;
        a(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        d(r2);
        return;
    L9:
        throw new IllegalStateException();
    }
}
