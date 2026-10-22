package com.ss.android.lark.officesdk.contact.impl;

import com.larus.setting.api.s;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mtb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ltb.a<Unit> {
    public final /* synthetic */ ltb.a<f> a;
    public final /* synthetic */ f b;

    @Override // ltb.a
    public final void onSuccess(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a.onSuccess(this.b);
    }

    public a(s r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // ltb.a
    public final void onError(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        this.a.onError(r2, r3);
    }
}
