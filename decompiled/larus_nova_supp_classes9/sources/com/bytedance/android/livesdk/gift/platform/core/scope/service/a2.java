package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.os.Bundle;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.toolbar.ToolbarGiftBehavior;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.util.FetchOpenGiftPanelFrom;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a2 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public boolean b;
    public final i12.d c;
    public final DataCenter d;
    public final ToolbarGiftBehavior e;
    public final u0 f;
    public final uz1.a g;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k h;
    public final OpenDialogService i;
    public final d1 j;
    public final GiftExtraRepo k;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f l;
    public final xz1.c m;

    public final void onStart() {
        this.b = true;
        this.h.f();
        System.currentTimeMillis();
        d1 r1 = this.j;
        if (r1.i != 1) goto L8;
        Disposable r2 = r1.g;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        if (r1.j != 1) goto L12;
        Disposable r3 = r1.h;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        GiftListRepo.k.getClass();
        if (((Boolean) GiftListRepo.h.getValue()).booleanValue() == false) goto L16;
        jy0.b.f("ttlive_gift_list", "intercept sync gift list since createPanelRequestList", null, 4);
    L33:
        boolean r4 = true;
    L35:
        if (r4 == true) goto L37;
        a(3, BuildConfig.FLAVOR);
    L37:
        Iterator r5 = ((ArrayList) this.f.c).iterator();
    L39:
        if (r5.hasNext() == false) goto L41;
        ((com.bytedance.android.livesdk.gift.platform.business.f) r5.next()).q();
        goto L39
    L41:
        GiftExtraRepo.a r6 = GiftExtraRepo.v;
        r6.getClass();
        if (((Boolean) GiftExtraRepo.t.getValue(r6, GiftExtraRepo.a.a[1])).booleanValue() == true) goto L44;
        this.m.a();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0.a.a(this.k, CollectionsKt.emptyList(), "giftPanelOpen", null, 12);
    L44:
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L47;
        Object r7 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d.class);
    L48:
        com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d r8 = (com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d) r7;
        if (r8 == null) goto L53;
        com.bytedance.android.livesdk.gift.platform.core.ui.configuration.d.a(r8, null, null, null, 7);
        return;
    L53:
        return;
    L47:
        r7 = null;
        goto L48
    L16:
        if (this.e.D != 0) goto L18;
    L20:
        Bundle r9 = this.c.q();
        if (r9 == null) goto L23;
        String r10 = r9.getString("gift_show_from");
    L25:
        if (Intrinsics.areEqual(r10, "recharge_panel") == true) goto L27;
    L34:
        r4 = false;
        goto L35
    L27:
        if (GiftListRepo.c != 3) goto L34;
        GiftManagerKt.z.getClass();
        if (GiftManagerKt.A() == false) goto L34;
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.C.getValue()).booleanValue() == false) goto L34;
        jy0.b.d("ttlive_gift_list", "intercept sync gift list since open by recharge_panel");
        goto L33
    L23:
        r10 = null;
        goto L25
    L18:
        if ((System.currentTimeMillis() - this.e.D) >= I18nInitTask.DELAY_TS_MS) goto L20;
        jy0.b.d("ttlive_gift_list", "intercept sync gift list since touch down preload");
        goto L33
    }

    public final void onStop() {
        this.b = false;
        Iterator r0 = ((ArrayList) this.f.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.gift.platform.business.f) r0.next()).c();
        goto L4
    L6:
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.k<Unit> r2 = r1.getGiftDialogCloseEvent();
        if (r2 == null) goto L11;
        r2.post(Unit.INSTANCE);
    L11:
        Object r3 = null;
        this.d.put("data_gift_send_extra", null);
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L14;
        r3 = com.bytedance.android.scope.m.e.d(r4, e1.class);
    L14:
        e1 r5 = (e1) r3;
        if (r5 == null) goto L19;
        Observable<Unit> r6 = r5.b;
        if (r6 == null) goto L19;
        r6.subscribe();
    L19:
        this.a.clear();
        JSONObject r7 = new JSONObject();
        r7.put("eventName", "didCloseGiftPanel");
        com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).sendEventToAllJsBridges("H5_webcastNotification", r7);
    }

    public final void a(int r10, String r11) {
        Boolean r0 = (Boolean) this.d.get("data_is_anchor", Boolean.FALSE);
        if (r0 == null) goto L5;
        boolean r3 = r0.booleanValue();
    L6:
        IRoom r2 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r2 != null) goto L10;
        return;
    L10:
        if (this.i.f(FetchOpenGiftPanelFrom.GIFT_PANEL_CREATE) == false) goto L12;
        return;
    L12:
        int r4 = com.bytedance.android.livesdk.gift.platform.core.utils.u.c(this.l.b);
        long r1 = this.c.C().getTargetGiftId();
        long r5 = -1;
        if (r1 != (-1)) goto L22;
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.m<GiftContext.a> r7 = r6.getLastSendGiftId();
        if (r7 == null) goto L23;
        GiftContext.a r8 = (GiftContext.a) r7.getValue();
        if (r8 == null) goto L23;
        r1 = r8.a;
    L23:
        z1.a(r10, r2, r3, r4, r5, this.l.a, r11);
        return;
    L22:
        r5 = r1;
        goto L23
    L5:
        r3 = false;
        goto L6
    }

    public a2(i12.d r2, DataCenter r3, ToolbarGiftBehavior r4, u0 r5, u1 r6, uz1.a r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r8, OpenDialogService r9, d1 r10, GiftExtraRepo r11, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r13, xz1.c r14) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "mDataCenter");
        Intrinsics.checkNotNullParameter(r4, "toolbarGiftBehavior");
        Intrinsics.checkNotNullParameter(r5, "internalScopeService");
        Intrinsics.checkNotNullParameter(r6, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r7, "giftMVIFacade");
        Intrinsics.checkNotNullParameter(r8, "receiverModeService");
        Intrinsics.checkNotNullParameter(r9, "openDialogService");
        Intrinsics.checkNotNullParameter(r10, "giftListRoomService");
        Intrinsics.checkNotNullParameter(r11, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r13, "receiverService");
        Intrinsics.checkNotNullParameter(r14, "giftExtraInterfaceMonitor");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r13;
        this.m = r14;
        this.a = new CompositeDisposable();
        this.b = true;
    }
}
