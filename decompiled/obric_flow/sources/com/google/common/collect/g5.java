package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class g5 extends e {
    public static final g5 d = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f8991c;

    static {
        d = new g5(new Object[0], 0, 0);
    }

    public g5(Object[] r5, int r10, int r11) {
        super(r10, r11);
        this.f8991c = r5;
    }

    @Override // com.google.common.collect.e
    public final Object a(int r5) {
        return this.f8991c[r5];
    }
}
