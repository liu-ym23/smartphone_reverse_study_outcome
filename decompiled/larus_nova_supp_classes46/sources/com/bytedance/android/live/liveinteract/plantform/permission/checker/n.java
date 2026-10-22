package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends com.bytedance.android.livesdk.user.h<IBaseUser> {
    public final /* synthetic */ o a;

    public final void onComplete() {
        qh0.d<rh0.a> r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.onResult(null);
    }

    public n(o r1) {
        this.a = r1;
    }

    public final void onError(Throwable r9) {
        Intrinsics.checkNotNullParameter(r9, "e");
        super.onError(r9);
        qh0.d<rh0.a> r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        qh0.f.g r2 = this.a.b;
        r0.b(new BaseCheckException(r2.c, r2.b, BaseCheckException.CheckType.Login, "login failed, message: " + r9.getMessage(), r9));
    }
}
