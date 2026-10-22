package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e extends IHostAppMonitorListener.Stub {
    public boolean a;

    public e() {
    }

    public final void appEnterBackground(boolean r17, boolean r18) {
        super.appEnterBackground(r17, r18);
        this.a = r17;
        long r2 = 0;
        if (r17 == false) goto L11;
        String r0 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r1 = LinkmicOnlineFloatWindowManager.c.a();
        r1.C(true);
        gm2.i r6 = new gm2.i();
        r6.type = 100101;
        r6.senderUserId = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        r6.senderInteractIdStr = tc0.c.h().f;
        r6.targetUserId = "0";
        r6.targetInteractId = "0";
        r6.targetInteractIdStr = "0";
        ALogger.w("LinkmicOnlineFloatWindowManager", "sendSignalV1 onEnterBackground ");
        long r4 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.S(100101);
        CompositeDisposable r7 = r1.T;
        if (r7 == null) goto L10;
        LinkApi r9 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r3 = r1.m;
        if (r3 == null) goto L9;
        r2 = r3.getId();
    L9:
        r7.add(r9.sendSignalV1(r2, GsonProtectorUtils.toJson(GsonHelper.get(), r6), null, null, "").subscribeOn(Schedulers.io()).subscribe(new h(r4, r6), new i(r4, r6)));
    L10:
        LinkmicOnlineFloatWindowManager.c.a().hideFloatWindow();
        return;
    L11:
        String r5 = LinkmicOnlineFloatWindowManager.Y;
        LinkmicOnlineFloatWindowManager r8 = LinkmicOnlineFloatWindowManager.c.a();
        r8.C(false);
        if (r8.r != null) goto L16;
        if (r8.x != null) goto L16;
    L18:
        gm2.i r10 = new gm2.i();
        r10.type = 100102;
        r10.senderUserId = jc1.k.n(IMiddlewareUserService.class).user().n().toString();
        r10.senderInteractIdStr = tc0.c.h().f;
        r10.targetUserId = "0";
        r10.targetInteractId = "0";
        r10.targetInteractIdStr = "0";
        ALogger.w("LinkmicOnlineFloatWindowManager", "sendSignalV1 onEnterForeground ");
        long r11 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.S(100102);
        CompositeDisposable r12 = r8.T;
        if (r12 == null) goto L24;
        LinkApi r13 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r14 = r8.m;
        if (r14 == null) goto L23;
        r2 = r14.getId();
    L23:
        r12.add(RxCompatKt.b(r13.sendSignalV1(r2, GsonProtectorUtils.toJson(GsonHelper.get(), r10), null, null, "").toObservable(), new com.bytedance.android.live.core.utils.rxutils.l(5, 3000)).subscribeOn(Schedulers.io()).subscribe(new j(r11, r10), new k(r11, r10)));
    L24:
        LinkmicOnlineFloatWindowManager.c.a().showFloatWindow();
        return;
    L16:
        if (r8.i == false) goto L18;
        r8.i = false;
        r8.l();
        goto L18
    }
}
