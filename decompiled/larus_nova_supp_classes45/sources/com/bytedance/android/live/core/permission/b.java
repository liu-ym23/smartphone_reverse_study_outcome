package com.bytedance.android.live.core.permission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements o60.b {
    public final /* synthetic */ PermissionFragment.b a;
    public final /* synthetic */ PermissionFragment b;

    @Override // o60.b
    public final void cancel() {
        this.a.c();
    }

    @Override // o60.b
    public final void execute() {
        PermissionFragment r0 = this.b;
        PermissionFragment.b r1 = this.a;
        int r2 = PermissionFragment.c;
        r0.getClass();
        int r3 = m60.a.a(r1.b) & 65535;
        r0.a.put(r3, r1);
        r0.requestPermissions(r1.c, r3);
    }

    public b(PermissionFragment r1, PermissionFragment.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
