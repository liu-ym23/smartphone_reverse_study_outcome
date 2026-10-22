package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9175c;
    public final /* synthetic */ ArrayTable d;

    public /* synthetic */ u0(ArrayTable r5, int r10, int r11) {
        this.f9175c = r11;
        this.d = r5;
        super(r10, 0);
    }

    @Override // com.google.common.collect.e
    public final Object a(int r5) {
        switch(this.f9175c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ArrayTable.access$800(this.d, r5);
    L7:
        return ArrayTable.access$000(this.d, r5);
    }
}
