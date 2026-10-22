package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.platform.depend.user.ILoginCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y1 implements ILoginCallback {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ z1 b;

    public final void onCancel(Throwable r3) {
        if (this.a == false) goto L5;
        this.b.finishWithResult(new z1.b(2));
        return;
    L5:
        this.b.finishWithFailure(r3);
    }

    public final void onSuccess(IBaseUser r3) {
        if (this.a == false) goto L5;
        this.b.finishWithResult(new z1.b(1));
        return;
    L5:
        this.b.finishWithSuccess();
    }

    public y1(z1 r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
