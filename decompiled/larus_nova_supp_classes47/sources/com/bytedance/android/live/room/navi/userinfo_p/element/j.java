package com.bytedance.android.live.room.navi.userinfo_p.element;

import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoTabPresenter;
import com.bytedance.android.livesdk.message.model.ii;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ UserInfoMiddleElement a;

    public j(UserInfoMiddleElement r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        UserInfoTabPresenter r0 = this.a.i;
        if (r0 == null) goto L16;
        if (r4 == null) goto L6;
        ii r5 = (ii) sh6.c.b(r4);
    L7:
        if (r5 == null) goto L19;
        int r1 = n81.a.a;
        if (n81.a.a(r0.a()) == false) goto L14;
        n81.a.b("receive appointment message");
        u32.d r2 = r0.m;
        if (r2 == null) goto L17;
        r2.f(r5);
        return;
    L17:
        return;
    L14:
        n81.a.b("receive appointment message, message can't show");
        return;
    L19:
        return;
    L6:
        r5 = null;
        goto L7
    }
}
