package com.bytedance.android.live.room.navi.tetris;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l81.s;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ LandscapeNavigatorTetris a;

    public l(LandscapeNavigatorTetris r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        boolean r0 = false;
        if (this.a.p == false) goto L12;
        MiddlewareRoomContext r6 = o3.b();
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.m r7 = r6.getVsInChorusConcert();
        if (r7 == null) goto L12;
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L12;
        f2.b(2131918791, 0);
        return;
    L12:
        DataCenter r8 = this.a.K().h;
        if (r8 == null) goto L22;
        IAbilityCenter r9 = a0.a(r8);
        if (r9 == null) goto L22;
        IRoomRecordService r10 = r9.getAbility(IRoomRecordService.class);
        if (r10 == null) goto L22;
        if (r10.isRecording() == false) goto L22;
        f2.b(2131911633, 0);
        return;
    L22:
        d90.d r12 = this.a.K();
        Intrinsics.checkNotNullParameter(r12, "$this$isMiddlewareFromLongerVideoLandscape");
        DataCenter r13 = r12.h;
        if (r13 == null) goto L27;
        Boolean r14 = (Boolean) r13.get("data_longer_video_within_live_type", Boolean.FALSE);
        if (r14 == null) goto L27;
        r0 = r14.booleanValue();
    L27:
        if (r0 == false) goto L30;
        ALogger.i("LandscapeNavigatorTetris", "longer video scene navigator should leave room");
        xs2.b r15 = xs2.b.a();
        h1 r1 = new h1(6);
        HashMap r2 = new HashMap();
        r2.put("exit_type", "back");
        r1.e = r2;
        Unit r3 = Unit.INSTANCE;
        r15.post(r1);
        return;
    L30:
        INavigationProxyService r16 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r16 == null) goto L35;
        l81.j r17 = r16.getLiveLogger();
        if (r17 == null) goto L35;
        r17.a();
    L35:
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", "ToolbarScreenOrientationBehavior cause to hide interaction");
        INavigationProxyService r18 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r18 == null) goto L40;
        s r19 = r18.getScreenRotateService();
        if (r19 == null) goto L40;
        r19.a(this.a.K().h);
    L40:
        xs2.b.a().post(new HorizontalPlayEvent(1, 1));
    }
}
