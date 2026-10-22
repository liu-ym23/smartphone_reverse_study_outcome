package com.tom_roush.pdfbox.pdfparser;

import com.tom_roush.pdfbox.a.m;
import com.tom_roush.pdfbox.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public class h extends com.tom_roush.pdfbox.pdfparser.a {
    private final XrefTrailerResolver d;
    private final int[] e;
    private a f;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdfparser.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements Iterator<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f16136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f16137b;
        private int c;
        private long d;
        private long e;
        private long f;

        private a(com.tom_roush.pdfbox.a.a r9) {
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            long[] r1 = new long[r9.b() / 2];
            this.f16136a = r1;
            this.f16137b = new long[r1.length];
            Iterator<com.tom_roush.pdfbox.a.b> r10 = r9.iterator();
            int r2 = 0;
        L4:
            if (r10.hasNext() == false) goto L17;
            com.tom_roush.pdfbox.a.b r3 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r10.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.h.class) == false) goto L16;
            long r4 = ((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).b();
            if (r10.hasNext() == false) goto L17;
            com.tom_roush.pdfbox.a.b r6 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r10.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.h.class) == false) goto L14;
            long r5 = ((com.tom_roush.pdfbox.a.h) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.h.class, "com.obric.memorydata.plugin")).b();
            this.f16136a[r2] = r4;
            this.f16137b[r2] = r4 + r5;
            r2 = r2 + 1;
            goto L4
        L14:
            throw new IOException("Xref stream must have integer in /Index array");
        L16:
            throw new IOException("Xref stream must have integer in /Index array");
        L17:
            this.e = this.f16136a[0];
            long[] r11 = this.f16137b;
            this.d = r11[0];
            this.f = r11[r2 - 1];
        }

        /* synthetic */ a(com.tom_roush.pdfbox.a.a r1, AnonymousClass1 r2) {
            this(r1);
        }

        public Long a() {
            long r0 = this.e;
            if (r0 >= this.f) goto L11;
            if (r0 >= this.d) goto L8;
            this.e = 1 + r0;
            return Long.valueOf(r0);
        L8:
            long[] r1 = this.f16136a;
            int r2 = this.c + 1;
            this.c = r2;
            long r5 = r1[r2];
            this.e = r5;
            this.d = this.f16137b[r2];
            this.e = 1 + r5;
            return Long.valueOf(r5);
        L11:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.e >= this.f) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ Long next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public h(n r3, com.tom_roush.pdfbox.a.e r4, XrefTrailerResolver r5) {
        super(new d(r3.h()));
        this.e = new int[3];
        this.f = null;
        this.c = r4;
        this.d = r5;
        a(r3);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        s();
        throw e;
    }

    private long a(byte[] r7, int r8, int r9) {
        long r0 = 0;
        int r6 = 0;
    L3:
        if (r6 >= r9) goto L5;
        r0 = r0 + ((((long) r7[r6 + r8]) & 255) << (((r9 - r6) - 1) * 8));
        r6 = r6 + 1;
        goto L3
    L5:
        return r0;
    }

    private void a(n r7) {
        com.tom_roush.pdfbox.a.a r0 = r7.f(com.tom_roush.pdfbox.a.i.iY);
        if (r0 == null) goto L31;
        if (r0.b() != 3) goto L29;
        int r3 = 0;
    L7:
        if (r3 >= 3) goto L9;
        this.e[r3] = r0.a(r3, 0);
        r3 = r3 + 1;
        goto L7
    L9:
        int[] r1 = this.e;
        if (r1[0] < 0) goto L27;
        if (r1[1] < 0) goto L27;
        if (r1[2] < 0) goto L27;
        com.tom_roush.pdfbox.a.a r2 = r7.f(com.tom_roush.pdfbox.a.i.dT);
        if (r2 != null) goto L19;
        r2 = new com.tom_roush.pdfbox.a.a();
        r2.a(com.tom_roush.pdfbox.a.h.f16054a);
        r2.a(com.tom_roush.pdfbox.a.h.a(r7.b(com.tom_roush.pdfbox.a.i.hs, 0)));
    L19:
        if (r2.b() == 0) goto L25;
        if ((r2.b() % 2) == 1) goto L25;
        this.f = new a(r2, null);
        return;
    L25:
        throw new IOException("Wrong number of values for /Index array in XRef: " + Arrays.toString(this.e));
    L27:
        throw new IOException("Incorrect /W array in XRef: " + Arrays.toString(this.e));
    L29:
        throw new IOException("Wrong number of values for /W array in XRef: " + Arrays.toString(this.e));
    L31:
        throw new IOException("/W array is missing in Xref stream");
    }

    private void s() {
        if (this.f16131b == null) goto L5;
        this.f16131b.close();
    L5:
        this.c = null;
    }

    public void r() {
        int[] r0 = this.e;
        byte[] r1 = new byte[(r0[0] + r0[1]) + r0[2]];
    L4:
        if (this.f16131b.d() == true) goto L21;
        if (this.f.hasNext() == false) goto L21;
        this.f16131b.a(r1);
        long r5 = this.f.a().longValue();
        int[] r2 = this.e;
        if (r2[0] != 0) goto L10;
        int r3 = 1;
    L11:
        if (r3 == 0) goto L4;
        int[] r7 = this.e;
        long r8 = a(r1, r7[0], r7[1]);
        if (r3 != 1) goto L16;
        int[] r9 = this.e;
        int r10 = (int) a(r1, r9[0] + r9[1], r9[2]);
    L17:
        m r11 = new m(r5, r10);
        if (r3 == 1) goto L19;
        this.d.a(r11, -r8);
        goto L4
    L19:
        this.d.a(r11, r8);
        goto L4
    L16:
        r10 = 0;
        goto L17
    L10:
        r3 = (int) a(r1, 0, r2[0]);
    L21:
        s();
    }
}
