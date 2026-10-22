package com.bytedance.android.ec.common.impl.sku.presenter;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Action {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ButtonOptimizePresenter c;
    public final /* synthetic */ sc3.b d;
    public final /* synthetic */ String e;

    public d(String r1, String r10, ButtonOptimizePresenter r11, sc3.b r12, String r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void run() {
        this.c.n0(this.a, this.e, this.b, null);
    }
}
