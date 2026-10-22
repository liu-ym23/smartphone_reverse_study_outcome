package com.bytedance.android.live.revlink.link.domain.mic.component;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FollowComponent implements e, s51.a {
    public final CompositeDisposable a;
    public final NextLiveData<Boolean> b;
    public final String c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d d;

    @Override // s51.a
    public final void attach() {
        if (Intrinsics.areEqual(this.c, this.d.eg()) == false) goto L5;
        return;
    L5:
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        Single r2 = ((com.bytedance.live.kmp.core.c) r0).tm(this.c);
        if (r2 == null) goto L15;
        int r3 = p.a;
        Single r4 = r2.subscribeOn(Schedulers.io());
        if (r4 == null) goto L16;
        Single r5 = r4.observeOn(AndroidSchedulers.mainThread());
        if (r5 == null) goto L17;
        Disposable r6 = r5.subscribe(new c(this), d.a);
        if (r6 == null) goto L18;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6, this.a);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // s51.a
    public final void detach() {
        this.a.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.mic.component.e
    public final int g() {
        Boolean r0 = (Boolean) this.b.getValue();
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L6;
        int r1 = s11.a.b;
        return 1;
    L6:
        if (Intrinsics.areEqual(r0, Boolean.TRUE) == false) goto L8;
        int r2 = s11.a.b;
        return 2;
    L8:
        int r3 = s11.a.b;
        return 0;
    }

    public FollowComponent(String r2, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = new NextLiveData();
    }

    public static final void b(FollowComponent r1, Throwable r2) {
        r1.getClass();
        if ((r2 instanceof ApiServerException) == false) goto L5;
        int r3 = ToastUtil.a;
        ToastUtil.b(((ApiServerException) r2).getPrompt(), 0);
        return;
    L5:
        int r4 = ToastUtil.a;
        int r5 = w11.a.a;
        ToastUtil.a(2131919727, 0);
    }

    public final void h(boolean r5, final String r6) {
        Intrinsics.checkNotNullParameter(r6, "requestSource");
        if (Intrinsics.areEqual(Boolean.valueOf(r5), (Boolean) this.b.getValue()) == false) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        com.bytedance.revenue.platform.api.core.rx.f.a(this.d.getCommonService().e(this.c, RevLiveFollowScene.MultiAnchorPanel, new FollowComponent$follow$1(this, r6), new FollowComponent$follow$2(this)), this.a);
    L8:
        this.d.getMultiAnchorLinkLogUtils().A(this.c, "shortcut_button", r5);
        return;
    L7:
        this.d.getCommonService().b(this.c, r6, FollowComponent$follow$3.INSTANCE, new FollowComponent$follow$4(this));
        goto L8
    }
}
