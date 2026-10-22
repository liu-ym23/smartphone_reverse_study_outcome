package com.bytedance.pia.core.bridge.methods;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements fh.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f6973b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f6974c = null;
    public static final e d = null;
    public static final e e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6975a;

    static {
        f6973b = new e(0);
        f6974c = new e(1);
        d = new e(2);
        e = new e(3);
    }

    public /* synthetic */ e(int r5) {
        this.f6975a = r5;
    }

    @Override // fh.b
    public final Object create() {
        switch(this.f6975a) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return new s();
    L7:
        return new o();
    L9:
        return new l();
    L11:
        return new i();
    }
}
