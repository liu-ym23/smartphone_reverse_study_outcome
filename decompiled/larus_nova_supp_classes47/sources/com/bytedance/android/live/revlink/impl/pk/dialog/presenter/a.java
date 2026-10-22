package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.revlink.impl.pk.dialog.contract.AnchorInteractSettingContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.AnchorInteractSettingFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends x31.a {
    public int d;
    public int e;

    @Override // x31.a
    public final int e() {
        return this.d;
    }

    @Override // x31.a
    public final int f() {
        return this.e;
    }

    public a(AnchorInteractSettingFragment r1) {
        super(r1);
        this.d = l51.a.j();
        this.e = l51.a.k();
    }

    @Override // x31.a
    public final void g(int r1, int r2) {
        this.d = r1;
        this.e = r2;
        l51.a.I(r1);
        l51.a.J(r2);
        ((AnchorInteractSettingContract$View) this.c).ca0(this.d);
    }
}
