package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends BaseDataObsProvider<User> {
    public final Disposable b;
    public DataCenter c;

    public g() {
        this(0);
    }

    public final Object g() {
        DataCenter r0 = this.c;
        IUser r1 = null;
        if (r0 == null) goto L7;
        User r2 = (User) r0.get("data_user_in_room", null);
        if (r2 == null) goto L7;
        return r2;
    L7:
        IUserService r3 = k.f(IUserService.class);
        if (r3 == null) goto L12;
        com.bytedance.android.livesdk.user.f r4 = r3.user();
        if (r4 == null) goto L12;
        IUser r5 = r4.b();
    L14:
        if ((r5 instanceof User) == false) goto L18;
        r1 = r5;
    L18:
        return (User) r1;
    L12:
        r5 = null;
        goto L14
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.e.d r0 = com.bytedance.android.live.browser.jsbridge.i.e.d.b;
        return "current_user";
    }

    public final void onRelease() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public g(int r3) {
        Disposable r4 = null;
        this.c = null;
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L7;
        Observable r2 = r1.p();
    L8:
        if (r2 == null) goto L10;
        r2.observeOn(AndroidSchedulers.mainThread());
    L10:
        if (r2 == null) goto L12;
        r4 = r2.subscribe(new f(this));
    L12:
        this.b = r4;
        return;
    L7:
        r2 = null;
        goto L8
    }
}
