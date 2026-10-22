package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.BaseObservableState;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends BaseObservableState<IBaseUser> {
    public final Lazy e;
    public DataCenter f;

    public e() {
        this(0);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        DataCenter r0 = this.f;
        IUser r1 = null;
        if (r0 == null) goto L6;
        User r2 = (User) r0.get("data_user_in_room", null);
        if (r2 == null) goto L6;
        return r2;
    L6:
        IUser r3 = k.n(IUserService.class).user().b();
        if ((r3 instanceof User) == false) goto L11;
        r1 = r3;
    L11:
        return (User) r1;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
    public final void i() {
        ((Disposable) this.e.getValue()).dispose();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f d() {
        return i.e.d.b;
    }

    public e(int r1) {
        super(false);
        this.f = null;
        this.e = LazyKt.lazy(new CurrentUserState$disposable$2(this));
    }
}
