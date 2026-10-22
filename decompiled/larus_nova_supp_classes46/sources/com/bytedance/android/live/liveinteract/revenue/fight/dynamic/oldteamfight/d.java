package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.f;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.h;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.multiscene.k;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.m;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightTitleLayout;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import sh0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public DynamicTeamFightViewManager a;
    public final com.bytedance.android.live.liveinteract.revenue.fight.c b;
    public final Context c;
    public final DataCenter d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.c;
    }

    public final void a(l r7) {
        Intrinsics.checkNotNullParameter(r7, "initInfo");
        RecyclerView r0 = null;
        if (r7 == null) goto L5;
        hg0.d r1 = r7.c;
    L6:
        if (r1 == null) goto L8;
        RecyclerView r2 = r1.a;
    L10:
        if ((r2 instanceof LinkMicRecyclerView) == false) goto L13;
        r0 = r2;
    L13:
        LinkMicRecyclerView r3 = (LinkMicRecyclerView) r0;
        ViewGroup r4 = r7.b;
        r4.removeAllViews();
        System.currentTimeMillis();
        VerticalNitaInflate.a(VerticalNitaInflate.Tag.MultiLinkDynamicTeamFightView.name(), 2131567146, this.c, r4, true);
        System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.revenue.fight.c r5 = this.b;
        ViewParent r8 = r7.a.getParent();
        if (r8 == null) goto L18;
        this.a = new DynamicTeamFightViewManager(r5, r3, (ViewGroup) r8, this.d);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void b(e r14) {
        Intrinsics.checkNotNullParameter(r14, "lastInfo");
        final DynamicTeamFightViewManager r0 = this.a;
        if (r0 == null) goto L77;
        com.bytedance.android.live.liveinteract.multiscene.a r1 = r14.a;
        int r2 = r14.b;
        int r3 = r14.c;
        int r15 = r14.d;
        Intrinsics.checkNotNullParameter(r1, "teamFightInfo");
        if (li0.d.g(r1) == true) goto L82;
        String r4 = r1.getDressId();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r0.n = r4;
        ALogger.w("DynamicTeamFightViewManager", "onStatusChange enterFrom:" + r2 + " preStatus:" + r3 + ", status:" + r15);
        int r5 = m.a;
        if (r2 != 1) goto L34;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L17;
        boolean r6 = false;
    L18:
        if (r6 == true) goto L34;
        if (r15 == 1) goto L24;
        if (r15 == 2) goto L24;
        if (r15 == 3) goto L24;
        boolean r7 = false;
    L25:
        if (r7 == false) goto L34;
        int r8 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r9 = r0.r;
        IRoom r10 = r0.g;
        if (r10 == null) goto L29;
        Long r11 = Long.valueOf(r10.getId());
    L30:
        MultiSceneEnterRoomStatisticsUtils r12 = MultiSceneEnterRoomStatisticsUtils.a.a(r9, Long.valueOf(r11.longValue()));
        if (r12 == null) goto L33;
        r12.j(null);
    L33:
        int r13 = f.e;
        f.a.a(r0.f, new DynamicTeamFightViewManager$onStatusChange$1(r0));
        goto L34
    L29:
        r11 = null;
    L24:
        r7 = true;
    L17:
        r6 = true;
    L34:
        if (r15 == 0) goto L75;
        if (r15 != 1) goto L37;
        r0.c(r1, "TO->PREPARING");
        r0.a();
        if (r0.o.zh() == true) goto L48;
    L72:
        r0.e.f();
        r0.e.setVisibility(8);
        if (r3 != 0) goto L80;
        ALogger.w("DynamicTeamFightViewManager", "首次创建团战:上报createFightSuccess");
        int r16 = h.a;
        Intrinsics.checkNotNullParameter(r1, "fightInfo");
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        ALogger.d("TeamFightFullLinkMonitor", String.format("createFightSuccess, isOperator: %s", Arrays.copyOf(new Object[]{Boolean.FALSE}, 1)));
        return;
    L80:
        return;
    L48:
        if (r0.h == false) goto L50;
    L53:
        Intrinsics.checkNotNullParameter(r1, "$this$canStartFight");
        if (r1.getTeamInfos() == null) goto L62;
        List<j> r18 = r1.getTeamInfos();
        Intrinsics.checkNotNull(r18);
        if (r18.size() <= 1) goto L62;
        List<j> r19 = r1.getTeamInfos();
        Intrinsics.checkNotNull(r19);
        Object r110 = ListProtector.get(r19, 0);
        Intrinsics.checkNotNull(r110);
        if (k.c((j) r110) == false) goto L62;
        List<j> r111 = r1.getTeamInfos();
        Intrinsics.checkNotNull(r111);
        Object r112 = ListProtector.get(r111, 1);
        Intrinsics.checkNotNull(r112);
        if (k.c((j) r112) == false) goto L62;
        boolean r113 = true;
    L63:
        if (r113 == false) goto L71;
        TeamFightTitleLayout r114 = r0.f;
        if (r114.a == true) goto L70;
        r114.a = true;
        if (r114.b == false) goto L70;
        UtilityKotlinExtentionsKt.t(r114.c);
        UtilityKotlinExtentionsKt.t(r114.d);
        UtilityKotlinExtentionsKt.t(r114.e);
        UtilityKotlinExtentionsKt.w(r114.f);
        UtilityKotlinExtentionsKt.w(r114.g);
        r114.g.setBackgroundResource(2131248603);
    L70:
        ALogger.w("DynamicTeamFightViewManager", "current can start fight: " + r1);
        goto L72
    L71:
        r0.f.a();
    L62:
        r113 = false;
        goto L63
    L50:
        if (com.bytedance.android.live.liveinteract.utils.e.b() == true) goto L53;
        r0.f.a();
        goto L72
    L37:
        if (r15 == 2) goto L43;
        if (r15 != 3) goto L40;
        r0.c(r1, "TO->PUNISHING");
        r0.e.setVisibility(0);
        r0.e.j(r1, true);
        Intrinsics.checkNotNullParameter(r1, "$this$calculatePunishDuration");
        long r20 = (r1.getPunishStartTime() + r1.getPunishDuration()) - (p6.b() / ((long) 1000));
        r0.j = r20;
        r0.f.setPenalState(r20);
        r0.a();
        com.bytedance.android.live.core.utils.rxutils.j.a r115 = com.bytedance.android.live.core.utils.rxutils.j.a;
        r0.m = com.bytedance.android.live.core.utils.rxutils.j.c(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r0));
        return;
    L40:
        if (r15 == 4) goto L75;
        return;
    L43:
        r0.c(r1, "TO->PLAYING");
        r0.e.f();
        r0.e.j(r1, false);
        r0.a();
        Intrinsics.checkNotNullParameter(r1, "$this$calculateFightingDuration");
        long r21 = (r1.getStartTime() + r1.getDuration()) - (p6.b() / ((long) 1000));
        r0.j = r21;
        r0.f.setFightingState(r21);
        com.bytedance.android.live.core.utils.rxutils.j.a r116 = com.bytedance.android.live.core.utils.rxutils.j.a;
        r0.l = com.bytedance.android.live.core.utils.rxutils.j.c(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r0));
        r0.e.setVisibility(0);
        return;
    L75:
        r0.b("state-reset");
        return;
    L82:
        return;
    }

    public d(com.bytedance.android.live.liveinteract.revenue.fight.c r2, Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
