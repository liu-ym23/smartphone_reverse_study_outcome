package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import io.reactivex.functions.Consumer;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ QuickCommentWidget a;

    public g(QuickCommentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        QuickCommentWidget r4 = this.a;
        int r0 = QuickCommentWidget.h;
        r4.getClass();
        if (k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L8;
        com.bytedance.android.livesdk.interactivity.api.quickcomment.f r5 = this.a.xq();
        if (r5 == null) goto L9;
        r5.onLoginSuccess();
        return;
    L9:
        return;
    }
}
