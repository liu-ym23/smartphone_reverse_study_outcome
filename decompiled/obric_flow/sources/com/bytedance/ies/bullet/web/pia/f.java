package com.bytedance.ies.bullet.web.pia;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements fh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f6229b;

    public /* synthetic */ f(d r5, int r10) {
        this.f6228a = r10;
        this.f6229b = r5;
    }

    @Override // fh.b
    public final Object create() {
        switch(this.f6228a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f6229b.f6225c;
    L7:
        return this.f6229b.f6224b;
    }
}
