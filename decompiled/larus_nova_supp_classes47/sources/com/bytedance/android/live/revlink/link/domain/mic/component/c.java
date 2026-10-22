package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ FollowComponent a;

    public c(FollowComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IBaseUser r5 = (IBaseUser) r4;
        NextLiveData<Boolean> r0 = this.a.b;
        Intrinsics.checkNotNullParameter(r5, "$this$isFollowingExt");
        r0.setValue(Boolean.valueOf(r5.isFollowing()));
        Intrinsics.checkNotNullParameter(r5, "$this$isVcdContentAuthorizedExt");
        if (r5.isVcdContentAuthorized() == false) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$isVcdRelationAuthorizedExt");
        if (r5.isVcdRelationAuthorized() == false) goto L17;
        FollowComponent r6 = this.a;
        r6.getClass();
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r2 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r2);
        Observable r3 = ((com.bytedance.live.kmp.core.c) r2).ff(r6.c);
        if (r3 == null) goto L18;
        int r7 = p.a;
        Observable r8 = r3.subscribeOn(Schedulers.io());
        if (r8 == null) goto L19;
        Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L20;
        Disposable r10 = r9.subscribe(new a(r6), b.a);
        if (r10 == null) goto L21;
        com.bytedance.revenue.platform.api.core.rx.f.a(r10, r6.a);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}
