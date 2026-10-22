package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes.dex */
public final class e extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1453c;

    public /* synthetic */ e(int r5) {
        this.f1453c = r5;
        super(1);
    }

    public final h F() {
        switch(this.f1453c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new j(this);
    L7:
        return new d(this);
    }
}
