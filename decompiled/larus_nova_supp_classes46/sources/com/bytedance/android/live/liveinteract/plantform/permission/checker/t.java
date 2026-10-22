package com.bytedance.android.live.liveinteract.plantform.permission.checker;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t implements qh0.a<rh0.a>, qh0.d<rh0.a> {
    public static final /* synthetic */ int g = 0;
    public qh0.d<rh0.a> a;
    public boolean b;
    public final qh0.f.h c;
    public final qh0.a<rh0.a> d;
    public final j1 e;
    public final Function2<? super String, ? super String, Unit> f;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        long r0 = System.currentTimeMillis();
        qh0.f.h r2 = this.c;
        InteractLinkFullLinkMonitor.q0(r2.c, r2.f);
        int r3 = eg0.c.a;
        IRoom r4 = this.c.e;
        if (r4 == null) goto L8;
        long r5 = r4.getId();
    L9:
        long r6 = r5;
        String r7 = String.valueOf(d5.c(this.c.f));
        qh0.f.h r8 = this.c;
        String r9 = r8.f;
        int r10 = r8.c;
        String r11 = r8.g;
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        ((ObservableSubscribeProxy) eg0.c.a(r6, r7, r9, r10, r11).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(ContextUtil.contextToFragmentActivity(this.c.getContext())))).subscribe(new u(this, r0), new v(this, r0));
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // qh0.a
    public final void a(qh0.d<rh0.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "consumer");
        this.a = r4;
        qh0.a<rh0.a> r5 = this.d;
        if (r5 == null) goto L5;
        r5.a(this);
        return;
    L5:
        com.bytedance.android.scope.m r6 = com.bytedance.android.scope.m.e;
        f00.a.a r0 = f00.a.b;
        nz.t r1 = (nz.t) r6.d(r0, nz.t.class);
        if (r1 != null) goto L8;
    L12:
        ((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).init();
    L13:
        c();
        return;
    L8:
        if (r1.isOpen() != true) goto L12;
        nz.t r7 = (nz.t) r6.d(r0, nz.t.class);
        if (r7 == null) goto L13;
        r7.init();
        goto L13
    }

    @Override // qh0.d
    public final void b(BaseCheckException r3) {
        Intrinsics.checkNotNullParameter(r3, "exception");
        qh0.d<rh0.a> r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.b(r3);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r3) {
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new w(this, r3)).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ServerCameraChecker");
    }

    public t(qh0.f.h r2, qh0.a<rh0.a> r3, j1 r4, Function2<? super String, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "createConfig");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
