package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 extends DynamicFactor<Integer> {
    public Disposable b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a0 a;

        public b(a0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r4 = ((FollowPair) r3).followStatus;
            if (r4 != 0) goto L5;
            this.a.update(0);
            return;
        L5:
            if (r4 != 1) goto L7;
        L9:
            this.a.update(1);
            return;
        L7:
            if (r4 == 2) goto L9;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_user_has_followed";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        IBaseUser r0 = com.bytedance.android.live.core.utils.a0.n(this.c).getOwner();
        if (r0 == null) goto L7;
        int r1 = 1;
        if (r0.isFollowing() != true) goto L7;
    L9:
        return Integer.valueOf(r1);
    L7:
        r1 = 0;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.b = jc1.k.n(IMiddlewareUserService.class).user().u0(com.bytedance.android.live.core.utils.a0.n(this.c).getOwnerUserIdString()).subscribe(new b(this));
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public a0(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }
}
