package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.GroupPurchaseItem;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LifeLivePackComponentConfig;
import com.bytedance.android.livesdkapi.depend.model.live.RandomStrategyParams;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ToolbarComponentCheckInterface {
    public final /* synthetic */ GroupPurchaseConfig a;

    public static final class a implements Runnable {
        public final /* synthetic */ k a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ ToolbarMatchInterface d;
        public final /* synthetic */ Function0 e;
        public final /* synthetic */ Function1 f;
        public final /* synthetic */ Ref.BooleanRef g;

        public a(k r1, boolean r2, long r3, ToolbarMatchInterface r5, Function0 r6, Function1 r7, Ref.BooleanRef r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GroupPurchaseConfig.q(this.a.a, this.b, this.c, this.d, this.e, this.f, this.g.element, "");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public k(GroupPurchaseConfig r1) {
        this.a = r1;
    }

    public final boolean checkThenLoad(ToolbarMatchInterface r25, Function0<Unit> r26, Function1<? super String, Unit> r27) {
        Intrinsics.checkNotNullParameter(r25, "model");
        Intrinsics.checkNotNullParameter(r26, "loadButton");
        Intrinsics.checkNotNullParameter(r27, "stopLoadCallback");
        long r4 = com.bytedance.android.live.core.utils.z.o(this.a.h).getRoomId();
        if (r25.getSource() != 1) goto L5;
        boolean r3 = true;
    L6:
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        r9.element = false;
        long r12 = 0;
        if (r3 == false) goto L9;
    L71:
        LifeLivePackComponentConfig r2 = null;
    L72:
        DataCenter r0 = this.a.h;
        if (r2 == null) goto L77;
        Integer r1 = r2.getFirstMeetEffectiveType();
        if (r1 == null) goto L77;
        int r5 = r1.intValue();
    L78:
        if (r5 <= 0) goto L110;
        if (r2 == null) goto L86;
        RandomStrategyParams r14 = r2.getRandomStrategyParams();
        if (r14 == null) goto L86;
        Long r15 = r14.getMinRandomMS();
        if (r15 == null) goto L86;
        long r16 = r15.longValue();
    L87:
        if (r2 == null) goto L93;
        RandomStrategyParams r17 = r2.getRandomStrategyParams();
        if (r17 == null) goto L93;
        Long r18 = r17.getMaxRandomMS();
        if (r18 == null) goto L93;
        long r19 = r18.longValue();
    L95:
        if (r16 >= r19) goto L110;
        if (r5 != 3) goto L101;
    L109:
        boolean r6 = true;
    L111:
        if (r6 == false) goto L127;
        Random.Default r7 = Random.Default;
        if (r2 == null) goto L119;
        RandomStrategyParams r8 = r2.getRandomStrategyParams();
        if (r8 == null) goto L119;
        Long r10 = r8.getMinRandomMS();
        if (r10 == null) goto L119;
        long r110 = r10.longValue();
    L120:
        if (r2 == null) goto L126;
        RandomStrategyParams r11 = r2.getRandomStrategyParams();
        if (r11 == null) goto L126;
        Long r13 = r11.getMaxRandomMS();
        if (r13 == null) goto L126;
        r12 = r13.longValue();
    L126:
        i0.c().postDelayed(new a(this, r3, r4, r25, r26, r27, r9), r7.nextLong(r110, r12));
    L128:
        return true;
    L119:
        r110 = 0;
        goto L120
    L127:
        GroupPurchaseConfig.q(this.a, r3, r4, r25, r26, r27, r9.element, r25.getComponentExtra());
        goto L128
    L101:
        if (r5 != 1) goto L106;
        if (((Boolean) r0.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == true) goto L109;
    L106:
        if (r5 != 2) goto L110;
        if (((Boolean) r0.get("data_current_is_preview", Boolean.FALSE)).booleanValue() == true) goto L110;
    L93:
        r19 = 0;
    L86:
        r16 = 0;
    L110:
        r6 = false;
    L77:
        r5 = 0;
        goto L78
    L9:
        if ((r25 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) == false) goto L71;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r20 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r25;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L13
        Object r21 = Result.constructor-impl(GsonHelper.get().fromJson(r20.d, RoomLifeGrouponInfo.class));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r21) == false) goto L18;
        r21 = null;
    L18:
        RoomLifeGrouponInfo r112 = (RoomLifeGrouponInfo) r21;
        Gson r22 = GsonHelper.getDefault();
        if (r112 == null) goto L21;
        String r113 = r112.getDynamicUrl();
    L22:
        UrlModel r23 = (UrlModel) GsonProtectorUtils.fromJson(r22, r113, UrlModel.class);
        Gson r24 = GsonHelper.get();     // Catch: Throwable -> L30
        RoomLifeGrouponInfo r114 = com.bytedance.android.live.core.utils.z.o(this.a.h).lifeGrouponInfo;     // Catch: Throwable -> L30
        if (r114 == null) goto L27;
        String r115 = r114.getLifeLivePackComponentConfig();     // Catch: Throwable -> L30
        if (r115 == null) goto L27;
    L28:
        Object r28 = Result.constructor-impl((LifeLivePackComponentConfig) r24.fromJson(r115, LifeLivePackComponentConfig.class));     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r28) == false) goto L35;
        r28 = null;
    L35:
        LifeLivePackComponentConfig r29 = (LifeLivePackComponentConfig) r28;
        r25.setExtraDataAfterCheck(new GroupPurchaseItem("", null, r23, null, null, null, null));
        if (com.bytedance.android.live.core.utils.z.m(this.a.h, true) == false) goto L69;
        if (r112 == null) goto L41;
        Long r30 = r112.getAggCardId();
        if (r30 == null) goto L41;
        long r116 = r30.longValue();
    L43:
        if (r116 <= 0) goto L69;
        if (r112 == null) goto L46;
        String r31 = r112.getDynamicUrl();
    L47:
        if (r31 == null) goto L69;
        if (r23 == null) goto L50;
        List r32 = r23.getUrlList();
    L51:
        List r33 = r32;
        if (r33 != null) goto L54;
    L57:
        boolean r34 = true;
    L58:
        if (r34 == true) goto L69;
        r26.invoke();
        r9.element = true;
        GroupPurchaseConfig r35 = this.a;
        r35.getClass();
        ILiveService r36 = TTLiveService.getLiveService();
        if (r36 == null) goto L65;
        ILiveLocalLifeService r37 = (ILiveLocalLifeService) r36.liveLocalLifeService(ILiveLocalLifeService.class);
        if (r37 == null) goto L65;
        long r117 = r37.getTimeStamp("enter_room", "start");
    L66:
        long r118 = SystemClock.elapsedRealtime() - (r117 + (SystemClock.elapsedRealtime() - SystemClock.uptimeMillis()));
        LinkedHashMap r38 = new LinkedHashMap();
        r38.put("delay_time", String.valueOf(r118));
        IHostLiveLocalLife r119 = (IHostLiveLocalLife) r35.f.getValue();
        if (r119 == null) goto L70;
        r119.sendLog(com.bytedance.android.live.core.utils.z.d(r35.h, null), "live_life_performance_icon_first_show", r38);
    L70:
        r2 = r29;
    L65:
        r117 = 0;
        goto L66
    L54:
        if (r33.isEmpty() == true) goto L57;
        r34 = false;
        goto L58
    L50:
        r32 = null;
        goto L51
    L46:
        r31 = null;
    L41:
        r116 = 0;
    L69:
        r27.invoke("dynamicIconUrl is null");
    L27:
        r115 = "";
    L30:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L21:
        r113 = null;
    L13:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        r3 = false;
        goto L6
    }
}
