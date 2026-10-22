package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.profit.privilege.model.touch.GrowthTouchData$Position;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.live.profit.privilege.model.touch.s;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.scope.o {
    public static final /* synthetic */ int l = 0;
    public final CompositeDisposable a;
    public final com.bytedance.android.live.revenue.common.reactive.c b;
    public final com.bytedance.android.live.revenue.common.reactive.c c;
    public final com.bytedance.android.live.revenue.common.reactive.c d;
    public final com.bytedance.android.live.revenue.common.reactive.c e;
    public final com.bytedance.android.live.revenue.common.reactive.c f;
    public final com.bytedance.android.live.revenue.common.reactive.c g;
    public final com.bytedance.android.live.revenue.common.reactive.c h;
    public final com.bytedance.android.live.revenue.common.reactive.c i;
    public final yz0.g j;
    public final com.bytedance.android.live.recharge.i k;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final IBaseUser b() {
        IBaseUser r0 = this.j.getUser();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUserKt /* = com.bytedance.android.live.base.model.user.IBaseUser */");
    }

    public final String c() {
        IBaseUser r0 = this.j.mo444getRoom().getOwnerKt();
        if (r0 == null) goto L6;
        String r1 = r0.getIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final long d() {
        return IRoomKtKt.getId(this.j.mo444getRoom());
    }

    public final void onStop() {
        this.a.dispose();
    }

    public final String f() {
        return b().getIdString();
    }

    public d(yz0.g r57, com.bytedance.android.live.recharge.i r58) {
        Intrinsics.checkNotNullParameter(r57, "roomDataService");
        Intrinsics.checkNotNullParameter(r58, "walletService");
        this.j = r57;
        this.k = r58;
        this.a = new CompositeDisposable();
        com.bytedance.android.live.revenue.common.reactive.c r2 = new com.bytedance.android.live.revenue.common.reactive.c(new DanmakuTabList(null, false, false, 0, 0, null, 63, null));
        this.b = r2;
        Intrinsics.checkNotNullParameter(r2, "$this$asReadonly");
        this.c = r2;
        com.bytedance.android.live.revenue.common.reactive.c r3 = new com.bytedance.android.live.revenue.common.reactive.c(new TouchPositionData(null, false, null, 7, null));
        this.d = r3;
        Intrinsics.checkNotNullParameter(r3, "$this$asReadonly");
        this.e = r3;
        py.d r4 = b().getUserHonor();
        if (r4 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "$this$toPayGrade");
        long r5 = r4.getScore();
        Intrinsics.checkNotNullParameter(r4, "$this$levelKt");
        long r7 = r4.getLevel();
        long r12 = r4.getThisGradeMaxDiamond();
        PayGrade r6 = new PayGrade(r5, r7, r4.getThisGradeMinDiamond(), r12, r4.getGradeDescribe(), r4.getNewImIconWithLevel(), r4.getNewLiveIcon(), r4.getBuffInfo(), r4.getGradeDescribeShining(), 0, null, 0, null, null, null, null, 0, 0, r4.getRecentConsumeBadge(), 261120, null);
    L6:
        com.bytedance.android.live.revenue.common.reactive.c r8 = new com.bytedance.android.live.revenue.common.reactive.c(r6);
        this.f = r8;
        Intrinsics.checkNotNullParameter(r8, "$this$asReadonly");
        this.g = r8;
        com.bytedance.android.live.revenue.common.reactive.c r9 = new com.bytedance.android.live.revenue.common.reactive.c(new GiftPanelTouchData(null, 1, null));
        this.h = r9;
        Intrinsics.checkNotNullParameter(r9, "$this$asReadonly");
        this.i = r9;
        return;
    L5:
        r6 = new PayGrade(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
        goto L6
    }

    public static final void a(d r28, Map r29) {
        boolean r3 = true;
        a5 r4 = null;
        if (r29 == null) goto L127;
        r28.getClass();
        if (r29.isEmpty() == true) goto L127;
        s r5 = (s) r29.get(Long.valueOf(GrowthTouchData$Position.PositionGiftPanelTop.getValue()));
        if (r5 == null) goto L79;
        List<com.bytedance.android.live.profit.privilege.model.touch.p> r6 = r5.getData();
        if (r6 == null) goto L79;
        com.bytedance.android.live.profit.privilege.model.touch.p r7 = (com.bytedance.android.live.profit.privilege.model.touch.p) ListProtector.get(r6, 0);
        if (r7 == null) goto L79;
        com.bytedance.android.live.profit.privilege.model.touch.q r8 = r7.getDetail();
        if (r8 == null) goto L20;
        com.bytedance.android.live.profit.privilege.model.touch.f r9 = r8.getGiftPanelTopDetail();
        if (r9 == null) goto L20;
        com.bytedance.android.live.profit.privilege.model.touch.o r10 = r9.getButton();
        if (r10 == null) goto L20;
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r12 = r10.getText();
    L21:
        if (r12 != null) goto L23;
        boolean r13 = true;
    L24:
        Intrinsics.checkNotNullParameter(r7, "$this$toTouchPositionsStr");
        if (r7.getMeta() != null) goto L27;
        c.d.setValue(null, c.a[2], null);
        boolean r15 = r13;
    L77:
        String r2 = null;
    L78:
        r3 = r15;
    L80:
        s r1 = (s) r29.get(Long.valueOf(GrowthTouchData$Position.PositionGiftPanelEntrance.getValue()));
        if (r1 == null) goto L126;
        List<com.bytedance.android.live.profit.privilege.model.touch.p> r14 = r1.getData();
        if (r14 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.p r16 = (com.bytedance.android.live.profit.privilege.model.touch.p) ListProtector.get(r14, 0);
        if (r16 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.q r17 = r16.getDetail();
        if (r17 == null) goto L126;
        GiftPanelEntranceDetail r18 = r17.getGiftPanelPrivilegeEntranceInfo();
        if (r18 == null) goto L126;
        com.bytedance.android.live.profit.privilege.model.touch.r r19 = r16.getMeta();
        if (r19 == null) goto L93;
        Long r110 = r19.getMetaId();
    L94:
        Intrinsics.checkNotNullParameter(r18, "$this$toPrivilegeEntranceInfo");
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r20 = r18.getPanelDetail();
        if (r20 == null) goto L97;
        a5 r111 = b.a(r20);
    L98:
        String r112 = r18.getPanelUrl();
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r22 = r18.getBubbleText();
        if (r22 == null) goto L101;
        a5 r113 = b.a(r22);
    L102:
        py.k r114 = r18.getBubbleBackgroundImg();
        String r115 = r18.getBubbleUrl();
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r23 = r18.getAwardTips();
        if (r23 == null) goto L105;
        a5 r24 = b.a(r23);
    L106:
        com.bytedance.android.live.profit.privilege.model.touch.h r25 = r18.getLightInfo();
        if (r25 == null) goto L109;
        com.bytedance.android.live.profit.privilege.model.touch.i r26 = new com.bytedance.android.live.profit.privilege.model.touch.i(r25.isOn(), r25.getImage());
    L110:
        com.bytedance.android.live.profit.privilege.model.touch.b r27 = r18.getDynamicInfo();
        if (r27 == null) goto L124;
        Long r30 = r27.getShowAfterTimeMs();
        if (r30 == null) goto L115;
        long r210 = r30.longValue();
        int r32 = 0;
    L116:
        List<com.bytedance.android.live.profit.privilege.model.touch.n> r33 = r27.getText();
        if (r33 == null) goto L119;
        r4 = b.a(r33);
    L119:
        a5 r211 = r4;
        Long r34 = r27.getDurationMs();
        if (r34 == null) goto L122;
        long r35 = r34.longValue();
    L123:
        com.bytedance.android.live.profit.privilege.model.touch.c r212 = new com.bytedance.android.live.profit.privilege.model.touch.c(r210, r211, r35);
    L125:
        r4 = new PrivilegeEntranceInfo(r110, r111, r112, r113, r114, r115, r24, r26, r212, r18.getExtra());
        goto L126
    L122:
        r35 = r32;
        goto L123
    L115:
        r32 = 0;
        r210 = 0;
        goto L116
    L124:
        r212 = null;
        goto L125
    L109:
        r26 = null;
        goto L110
    L105:
        r24 = null;
        goto L106
    L101:
        r113 = null;
        goto L102
    L97:
        r111 = null;
        goto L98
    L93:
        r110 = null;
    L126:
        r28.d.setValue(new TouchPositionData(r2, r3, r4));
        return;
    L27:
        com.bytedance.android.live.profit.privilege.model.touch.r r36 = r7.getMeta();
        if (r36 == null) goto L57;
        List<com.bytedance.android.live.profit.privilege.model.touch.d> r37 = r36.getFreqCtrlParamsList();
        if (r37 == null) goto L57;
        HashMap r38 = (HashMap) c.c.getValue(null, c.a[1]);
        ArrayList r116 = new ArrayList();
        Iterator r117 = r38.entrySet().iterator();
    L33:
        if (r117.hasNext() == false) goto L45;
        Map.Entry r118 = (Map.Entry) r117.next();
        com.bytedance.live.kmp.util.c r119 = com.bytedance.live.kmp.util.c.a;
        long r120 = System.currentTimeMillis();
        Long r39 = com.bytedance.android.live.profit.privilege.model.touch.e.a((com.bytedance.android.live.profit.privilege.model.touch.d) GsonProtectorUtils.fromJson(l97.a.a, (String) r118.getValue(), TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.touch.d.class))));
        if (r39 == null) goto L37;
        long r121 = r39.longValue();
    L39:
        if (r121 <= 0) goto L33;
        boolean r122 = r13;
        if ((r120 / ((long) WebcastRedirectException.UNKNOWN)) <= r121) goto L43;
        r117.remove();
    L43:
        r13 = r122;
        goto L33
    L37:
        r121 = 0;
        goto L39
    L45:
        r15 = r13;
        Intrinsics.checkNotNullParameter(r38, "<set-?>");
        c.c.setValue(null, c.a[1], r38);
        Iterator<T> r40 = r37.iterator();
    L47:
        if (r40.hasNext() == false) goto L55;
        com.bytedance.android.live.profit.privilege.model.touch.d r42 = (com.bytedance.android.live.profit.privilege.model.touch.d) r40.next();
        if (r38.containsKey(r42.getKey()) == true) goto L50;
        r116.add(r42);
        goto L47
    L50:
        String r43 = (String) r38.get(r42.getKey());
        if (r43 == null) goto L47;
        r116.add((com.bytedance.android.live.profit.privilege.model.touch.d) GsonProtectorUtils.fromJson(l97.a.a, r43, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.profit.privilege.model.touch.d.class))));
        goto L47
    L55:
        if ((!r116.isEmpty()) != true) goto L58;
        com.bytedance.android.live.profit.privilege.model.touch.r r44 = r7.getMeta();
        Intrinsics.checkNotNull(r44);
        r44.setFreqCtrlParamsList(r116);
    L58:
        if (r116 == null) goto L73;
        Iterator r45 = r116.iterator();
    L61:
        if (r45.hasNext() == false) goto L73;
        com.bytedance.android.live.profit.privilege.model.touch.d r46 = (com.bytedance.android.live.profit.privilege.model.touch.d) r45.next();
        Long r47 = r46.getCur();
        if (r47 == null) goto L65;
        long r48 = r47.longValue();
        int r123 = 0;
    L66:
        Long r49 = r46.getLimit();
        if (r49 == null) goto L69;
        long r50 = r49.longValue();
    L71:
        if (r48 < r50) goto L61;
        boolean r52 = false;
    L74:
        if (r52 == false) goto L76;
        com.bytedance.android.live.profit.privilege.model.touch.p[] r53 = new com.bytedance.android.live.profit.privilege.model.touch.p[1];
        r53[r123] = r7;
        r2 = GsonProtectorUtils.toJson(l97.a.a, CollectionsKt.mutableListOf(r53));
        goto L78
    L76:
        c.d.setValue(null, c.a[2], null);
        goto L77
    L69:
        r50 = r123;
        goto L71
    L65:
        r123 = 0;
        r48 = 0;
    L73:
        r123 = 0;
        r52 = true;
    L57:
        r15 = r13;
        r116 = null;
        goto L58
    L23:
        r13 = false;
    L20:
        r12 = null;
    L79:
        r2 = null;
    L127:
        r28.d.setValue(new TouchPositionData(null, true, null));
        c.d.setValue(null, c.a[2], null);
    }
}
