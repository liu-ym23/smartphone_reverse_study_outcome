package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f16054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f16055b = null;
    public static final h c = null;
    public static final h d = null;
    protected static final h e = null;
    protected static final h f = null;
    private static final h[] i = null;
    private final long j;
    private final boolean k;

    static {
        i = new h[357];
        f16054a = a(0);
        f16055b = a(1);
        c = a(2);
        d = a(3);
        e = b(true);
        f = b(false);
    }

    private h(long r1, boolean r3) {
        this.j = r1;
        this.k = r3;
    }

    public static h a(long r4) {
        if ((-100) > r4) goto L12;
        if (r4 > 256) goto L12;
        int r0 = ((int) r4) + 100;
        h[] r2 = i;
        if (r2[r0] != null) goto L10;
        r2[r0] = new h(r4, true);
    L10:
        return r2[r0];
    L12:
        return new h(r4, true);
    }

    private static h b(boolean r3) {
        if (r3 == false) goto L6;
        return new h(Long.MAX_VALUE, false);
    L6:
        return new h(Long.MIN_VALUE, false);
    }

    @Override // com.tom_roush.pdfbox.a.k
    public float a() {
        return this.j;
    }

    @Override // com.tom_roush.pdfbox.a.k
    public long b() {
        return this.j;
    }

    @Override // com.tom_roush.pdfbox.a.k
    public int c() {
        return (int) this.j;
    }

    public boolean d() {
        return this.k;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin")).c() != c()) goto L7;
        return true;
    }

    public int hashCode() {
        long r0 = this.j;
        return (int) (r0 ^ (r0 >> 32));
    }

    public String toString() {
        return "COSInt{" + this.j + "}";
    }
}
