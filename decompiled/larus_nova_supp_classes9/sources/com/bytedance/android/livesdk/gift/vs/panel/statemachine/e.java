package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.k;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.n;
import i12.o;
import kotlin.Unit;
import zg1.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements k.a {
    public final /* synthetic */ GiftDialogViewModelNew a;
    public final /* synthetic */ boolean b;

    public final /* synthetic */ void b(int r1, int r2, long r3) {
    }

    public final void a() {
        if (this.b == true) goto L5;
        return;
    L5:
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        n<Boolean> r1 = r0.isContinuous();
        if (r1 == null) goto L10;
        r1.setValue(Boolean.TRUE);
    L10:
        this.a.getClass();
        yz0.k r2 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r2 == null) goto L31;
        IRoom r3 = r2.getRoom();
        if (r3 == null) goto L35;
        Object r4 = null;
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L24;
        i12.e r5 = o.b();
        if (r5 == null) goto L20;
        Object r6 = m.e.d(r5, OpenDialogService.class);
    L22:
        if (((OpenDialogService) r6) == null) goto L32;
        Bundle r7 = new Bundle();
        r7.putString("gift_show_from", "recharge_panel");
        Unit r8 = Unit.INSTANCE;
        xs2.b r9 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r9.post(new o3(null, LocateGiftInfo.a.b(0), r7, BuildConfig.FLAVOR, null));
        return;
    L32:
        return;
    L20:
        r6 = null;
        goto L22
    L24:
        i12.e r10 = o.b();
        if (r10 == null) goto L28;
        r4 = m.e.d(r10, OpenDialogService.class);
    L28:
        if (((OpenDialogService) r4) == null) goto L34;
        IBaseUser r11 = r3.getOwner();
        Bundle r13 = new Bundle();
        r13.putString("gift_show_from", "recharge_panel");
        Unit r14 = Unit.INSTANCE;
        xs2.b r15 = xs2.b.a();
        LocateGiftInfo.Companion.getClass();
        r15.post(new o3(r11, LocateGiftInfo.a.b(0), r13, BuildConfig.FLAVOR, null));
        return;
    L34:
        return;
    L35:
        return;
    }

    public e(GiftDialogViewModelNew r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
