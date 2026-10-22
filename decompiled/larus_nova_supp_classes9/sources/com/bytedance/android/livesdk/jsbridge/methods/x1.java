package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x1 implements Observer<IBaseUser> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ z1 b;

    public final void onComplete() {
    }

    public final void onError(Throwable r3) {
        if (this.a == false) goto L5;
        this.b.finishWithResult(new z1.b(2));
        return;
    L5:
        this.b.finishWithFailure(r3);
    }

    public final void onNext(Object r3) {
        IBaseUser r4 = (IBaseUser) r3;
        if (this.a == false) goto L5;
        this.b.finishWithResult(new z1.b(1));
        return;
    L5:
        this.b.finishWithSuccess();
    }

    public final void onSubscribe(Disposable r2) {
        this.b.a = r2;
    }

    public x1(z1 r1, boolean r2) {
        this.b = r1;
        this.a = r2;
    }
}
