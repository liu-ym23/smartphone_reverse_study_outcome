package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.b2;
import com.bytedance.android.livesdk.gift.model.e2;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.k1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.GiftPluginType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftGroupCardDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftBuffCardHelper;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.p0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClearGiftSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListPanelRepository;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftInsertStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel.SelectStatus;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    public g() {
    }

    static {
    }

    public static boolean a(l1 r7) {
        if (r7 == null) goto L40;
        com.bytedance.android.livesdk.gift.model.i r1 = r7.getLockInfo();
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L39;
        com.bytedance.android.livesdk.gift.model.i r3 = r7.getLockInfo();
        String r4 = null;
        if (r3 == null) goto L24;
        String r5 = r3.getSchema();
        if (r5 == null) goto L24;
        if (r5.length() <= 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 != true) goto L24;
        zz0.g r0 = com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class);
        Context r8 = s1.getContext();
        com.bytedance.android.livesdk.gift.model.i r9 = r7.getLockInfo();
        if (r9 == null) goto L23;
        r4 = r9.getSchema();
    L23:
        Intrinsics.checkNotNull(r4);
        r0.S2(r8, r4);
        goto L39
    L18:
        r6 = false;
    L24:
        int r10 = ToastUtil.a;
        com.bytedance.android.livesdk.gift.model.i r11 = r7.getLockInfo();
        if (r11 == null) goto L38;
        String r13 = r11.getToast();
        if (r13 == null) goto L38;
        if (r13.length() != 0) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == false) goto L37;
        Object[] r15 = new Object[1];
        h2 r16 = GiftManagerKt.l(r7.getBuffGiftId());
        if (r16 == null) goto L36;
        r4 = r16.getName();
    L36:
        r15[0] = r4;
        r4 = s1.C(2131917096, r15);
        goto L38
    L37:
        r4 = r13;
        goto L38
    L31:
        r14 = false;
    L38:
        ToastUtil.b(r4, 0);
    L39:
        return r2;
    L7:
        if (r1.getLocked() != true) goto L9;
        r2 = true;
        goto L10
    L40:
        return false;
    }

    public static boolean b(com.bytedance.android.livesdk.gift.model.n r5) {
        if (r5 == null) goto L29;
        boolean r1 = !gz1.a.c(r5);
        if (r1 == false) goto L28;
        CardLockInfo r3 = r5.getLockInfo();
        String r4 = null;
        if (r3 == null) goto L19;
        String r6 = r3.getSchema();
        if (r6 == null) goto L19;
        if (r6.length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 != true) goto L19;
        zz0.g r0 = com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class);
        Context r2 = s1.getContext();
        CardLockInfo r8 = r5.getLockInfo();
        if (r8 == null) goto L18;
        r4 = r8.getSchema();
    L18:
        Intrinsics.checkNotNull(r4);
        r0.S2(r2, r4);
        goto L28
    L13:
        r7 = false;
    L19:
        CardLockInfo r9 = r5.getLockInfo();
        if (r9 == null) goto L22;
        String r10 = r9.getToast();
    L24:
        if ((true ^ TextUtils.isEmpty(r10)) == false) goto L26;
        r4 = r10;
    L26:
        if (r4 == null) goto L28;
        ToastUtil.b(r4, 0);
        goto L28
    L22:
        r10 = null;
    L28:
        return r1;
    L29:
        return false;
    }

    public static AbsPanel d(h1 r4, com.bytedance.android.livesdk.gift.model.n r5) {
        if (r4 == null) goto L4;
        com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a r0 = ((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).l(r4);
        int r1 = r4.getType();
        String r3 = BuildConfig.FLAVOR;
        if (r1 != 13) goto L16;
        if (r5 == null) goto L9;
        r0.b = gz1.c.g(r5);
        r0.g = r5.getConfigId();
    L9:
        if (r5 == null) goto L14;
        String r6 = r5.getCardName();
        if (r6 == null) goto L14;
        r3 = r6;
    L14:
        r0.c = r3;
        return r0;
    L16:
        com.bytedance.android.livesdk.gift.platform.business.g r2 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r2 == null) goto L35;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r7 = r2.h();
        if (r7 == null) goto L35;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r8 = r7.values().iterator();
    L23:
        if (r8.hasNext() == false) goto L35;
        AbsPanel<?> r9 = r8.next().f(r4);
        if (r9 == null) goto L23;
        if (r5 == null) goto L28;
        r9.b = gz1.c.g(r5);
        r9.g = r5.getConfigId();
    L28:
        if (r5 == null) goto L33;
        String r10 = r5.getCardName();
        if (r10 == null) goto L33;
        r3 = r10;
    L33:
        r9.c = r3;
        return r9;
    L35:
        return r0;
    L4:
        return new pz1.d();
    }

    public static int f(vz1.e r6, GiftGroupCardDataStore r7) {
        Intrinsics.checkNotNullParameter(r7, "giftGroupCardDataStore");
        if (r6 == null) goto L5;
        long r0 = r6.b;
    L7:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L29;
        oc6.g r2 = r7.k();
        if (r2 != null) goto L11;
    L12:
        if (r6 != null) goto L14;
        return 1;
    L14:
        if (r6.e != true) goto L31;
    L15:
        oc6.g r8 = r7.k();
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.a());
    L19:
        if (r9 == null) goto L32;
        oc6.g r10 = r7.k();
        if (r10 == null) goto L23;
        int r11 = r10.a();
    L24:
        if (r11 <= 0) goto L33;
        oc6.g r13 = r7.k();
        if (r13 != null) goto L28;
        return 1;
    L28:
        return r13.a();
    L33:
        return 1;
    L23:
        r11 = 0;
        goto L24
    L32:
        return 1;
    L18:
        r9 = null;
        goto L19
    L31:
        return 1;
    L11:
        if (r2.b() == r0) goto L15;
    L29:
        return 1;
    L5:
        r0 = 0;
        goto L7
    }

    public static Map g(long r1, GiftExtraRepo r3) {
        Intrinsics.checkNotNullParameter(r3, "giftExtraRepo");
        com.bytedance.android.livesdk.gift.model.g0 r2 = r3.q(r1);
        Object r4 = null;
        if (r2 == null) goto L30;
        String r5 = r2.getBannerGiftInfo();
        if (r5 != null) goto L7;
        return null;
    L7:
        if (r5.length() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L32;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        com.bytedance.android.livesdk.gift.model.f r8 = (com.bytedance.android.livesdk.gift.model.f) GsonHelper.get().fromJson(r5, com.bytedance.android.livesdk.gift.model.f.class);     // Catch: Throwable -> L20
        if (r8 == null) goto L17;
        Map<String, String> r9 = r8.a();     // Catch: Throwable -> L20
    L18:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r10) == true) goto L27;
        r4 = r10;
    L27:
        return (Map) r4;
    L17:
        r9 = null;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L32:
        return null;
    L9:
        r6 = false;
        goto L10
    L30:
        return null;
    }

    public static AbsPanel k(h1 r5, p0 r6) {
        if (r5 == null) goto L4;
        com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a r0 = ((com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class)).l(r5);
        int r1 = r5.getType();
        String r3 = BuildConfig.FLAVOR;
        Long r4 = null;
        if (r1 != 13) goto L23;
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.n r7 = r6.a;
        if (r7 == null) goto L14;
        r0.b = gz1.c.g(r7);
        com.bytedance.android.livesdk.gift.model.n r8 = r6.a;
        if (r8 == null) goto L13;
        r4 = Long.valueOf(r8.getConfigId());
    L13:
        r0.g = r4.longValue();
    L14:
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.gift.model.n r9 = r6.a;
        if (r9 == null) goto L21;
        String r10 = r9.getCardName();
        if (r10 == null) goto L21;
        r3 = r10;
    L21:
        r0.c = r3;
        return r0;
    L23:
        com.bytedance.android.livesdk.gift.platform.business.g r2 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r2 == null) goto L49;
        Map<GiftPluginType, com.bytedance.android.livesdk.gift.platform.business.h> r11 = r2.h();
        if (r11 == null) goto L49;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.h> r13 = r11.values().iterator();
    L30:
        if (r13.hasNext() == false) goto L49;
        AbsPanel<?> r14 = r13.next().f(r5);
        if (r14 == null) goto L30;
        if (r6 == null) goto L40;
        com.bytedance.android.livesdk.gift.model.n r15 = r6.a;
        if (r15 == null) goto L40;
        r14.b = gz1.c.g(r15);
        com.bytedance.android.livesdk.gift.model.n r16 = r6.a;
        if (r16 == null) goto L39;
        r4 = Long.valueOf(r16.getConfigId());
    L39:
        r14.g = r4.longValue();
    L40:
        if (r6 == null) goto L47;
        com.bytedance.android.livesdk.gift.model.n r17 = r6.a;
        if (r17 == null) goto L47;
        String r18 = r17.getCardName();
        if (r18 == null) goto L47;
        r3 = r18;
    L47:
        r14.c = r3;
        return r14;
    L49:
        return r0;
    L4:
        return new pz1.d();
    }

    public static String e(l1 r2, h1 r3, GiftExtraRepo r4) {
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        if (r2 == null) goto L8;
        h1 r5 = GiftManagerKt.j(r2.getBuffGiftId(), null);
        if (r5 == null) goto L8;
        return r5.getName();
    L8:
        if (r3 == null) goto L10;
        long r0 = r3.getId();
    L11:
        com.bytedance.android.livesdk.gift.model.g0 r6 = r4.q(r0);
        if (r6 == null) goto L20;
        com.bytedance.android.livesdk.gift.model.p r7 = r6.getDiyGiftToolbarInfo();
        if (r7 == null) goto L20;
        String r8 = r7.getGiftShowName();
        if (r8 == null) goto L20;
        if (TextUtils.isEmpty(r8) == true) goto L20;
        return r8;
    L20:
        if (r3 == null) goto L23;
        String r9 = r3.getName();
        if (r9 == null) goto L23;
        return r9;
    L23:
        return BuildConfig.FLAVOR;
    L10:
        r0 = 0;
        goto L11
    }

    public static String j(com.bytedance.android.livesdk.gift.model.n r1, l1 r2, long r3) {
        if (r1 != null) goto L9;
        if (r2 == null) goto L8;
        return String.valueOf(r3) + "-" + String.valueOf(r2.getBuffLevel());
    L8:
        return String.valueOf(r3);
    L9:
        return String.valueOf(r3) + "-" + gz1.c.a(gz1.c.g(r1), 0);
    }

    public static void c(GiftDialogStateDataStore r2, u0 r3, ClearGiftSource r4, Runnable r5) {
        Intrinsics.checkNotNullParameter(r2, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r3, "internalScopeService");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "action");
        r2.S(SelectStatus.IDLE);
        Iterator r6 = ((ArrayList) r3.c).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gift.platform.business.f.a.a((com.bytedance.android.livesdk.gift.platform.business.f) r6.next(), null);
        goto L4
    L6:
        r5.run();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.e.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.e.a[0])).booleanValue() == false) goto L12;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == true) goto L12;
        r2.I(null, -1, true);
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.a() == true) goto L14;
        return;
    L14:
        if (r4 == ClearGiftSource.SelectGift) goto L19;
        r2.I(null, -1, true);
        return;
    }

    public static int h(long r1, l1 r3, com.bytedance.android.livesdk.gift.model.n r4, GiftExtraRepo r5) {
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        if (r3 == null) goto L8;
        com.bytedance.android.livesdk.gift.model.g0 r2 = r5.q(r3.getBuffGiftId());
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getGiftSelectedStyle();
    L8:
        if (r4 != null) goto L10;
        com.bytedance.android.livesdk.gift.model.g0 r6 = r5.q(r1);
        if (r6 != null) goto L14;
        return 0;
    L14:
        return r6.getGiftSelectedStyle();
    L10:
        return r4.getGiftSelectedStyle();
    }

    public static String i(long r2, GiftExtraRepo r4, GiftListSortDataStore r5, GiftTopViewState.Mode r6) {
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r5, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r6, "currentTopViewMode");
        com.bytedance.android.livesdk.gift.model.g0 r7 = r4.q(r2);
        if (r7 == null) goto L5;
        IGiftMarketingInfo r8 = r7.getGiftMarketingInfo();
    L6:
        int r1 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.a;
        r5.n(r2);
        if (r6 != GiftTopViewState.Mode.Marketing) goto L10;
        return "top_scene";
    L10:
        if (r6 != GiftTopViewState.Mode.BuffContainer) goto L12;
    L15:
        if (r8 != null) goto L17;
    L20:
        return null;
    L17:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.d(r8) != true) goto L20;
        return "top_scene";
    L12:
        if (r6 == GiftTopViewState.Mode.DIYContainer) goto L15;
        if (r6 != GiftTopViewState.Mode.Banner) goto L20;
    L5:
        r8 = null;
        goto L6
    }

    public static boolean l(vz1.e r11, u1 r13, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r14, r3 r15, GiftExtraRepo r16) {
        Intrinsics.checkNotNullParameter(r13, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r14, "receiverService");
        Intrinsics.checkNotNullParameter(r15, "giftSendService");
        Intrinsics.checkNotNullParameter(r16, "giftExtraRepo");
        if (r11 == null) goto L9;
        h1 r0 = r11.a;
        if (r0 == null) goto L9;
        k0 r1 = r0.getGiftPreviewInfo();
        if (r1 == null) goto L9;
        long r2 = r1.getLockStatus();
    L11:
        if (r2 == k0.UNLOCKED) goto L13;
        boolean r3 = true;
    L14:
        Object r4 = null;
        if (r11 == null) goto L34;
        h1 r5 = r11.a;
        if (r5 == null) goto L34;
        k0 r6 = r5.getGiftPreviewInfo();
        if (r6 == null) goto L34;
        if (r6.getClientBlockUseSchemeUrl() != true) goto L34;
        k0 r7 = r11.a.getGiftPreviewInfo();
        if (r7 == null) goto L25;
        String r8 = r7.getBlockSchemeUrl();
    L26:
        if (r8 != null) goto L28;
    L31:
        boolean r9 = true;
    L32:
        if (r9 == true) goto L34;
        boolean r10 = true;
    L35:
        if (r3 == false) goto L38;
        if (r10 == false) goto L38;
        boolean r17 = true;
    L40:
        if (r3 == false) goto L55;
        if (r11 == null) goto L45;
        h1 r18 = r11.a;
        if (r18 == null) goto L45;
        long r19 = r18.getId();
    L46:
        Map<? extends String, ? extends String> r110 = g(r19, r16);
        r13.getClass();
        Pair[] r20 = new Pair[2];
        r20[0] = TuplesKt.to("gift_id", String.valueOf(r19));
        py.d r21 = r13.o.getUser().getUserHonor();
        if (r21 == null) goto L50;
        String r23 = String.valueOf(r21.getLevel());
        if (r23 == null) goto L50;
    L51:
        r20[1] = TuplesKt.to("privilege_level", r23);
        Map<String, String> r24 = MapsKt.mutableMapOf(r20);
        r13.d(r24);
        u1.o(r24);
        if (r110 == null) goto L54;
        r24.putAll(r110);
    L54:
        r13.p1("gift_unlock_click", r24, true);
    L50:
        r23 = "0";
    L45:
        r19 = 0;
    L55:
        if (r17 == false) goto L86;
        if (r11 == null) goto L86;
        h1 r111 = r11.a;
        if (r111 == null) goto L86;
        final k0 r112 = r111.getGiftPreviewInfo();
        if (r112 == null) goto L86;
        if (r112.getClientBlockUseSchemeUrl() == false) goto L86;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L75;
        i12.e r113 = i12.o.b();
        if (r113 == null) goto L68;
        r4 = com.bytedance.android.scope.m.e.d(r113, GiftInRoomService.class);
    L68:
        GiftInRoomService r25 = (GiftInRoomService) r4;
        if (r25 == null) goto L71;
        r25.a(1001);
    L72:
        m(r11, 505, "unlogin", r14, r15);
        return true;
    L71:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1001));
        goto L72
    L75:
        if (r112.getBlockToast().length() <= 0) goto L77;
        boolean r114 = true;
    L78:
        if (r114 == false) goto L84;
        String r115 = UriProtector.parse(r112.getBlockSchemeUrl()).getHost();
        if (r115 != null) goto L82;
    L83:
        int r116 = ToastUtil.a;
        ToastUtil.b(r112.getBlockToast(), 0);
        goto L84
    L82:
        if (StringsKt.startsWith$default(r115, "webcast_inroom_toast", false, 2, null) != true) goto L83;
    L84:
        m(r11, 501, BuildConfig.FLAVOR, r14, r15);
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftListVMCommonHelper$handleSendGiftLocked$1$2(r112), 7);
        return true;
    L77:
        r114 = false;
    L86:
        return false;
    L38:
        r17 = false;
        goto L40
    L28:
        if (r8.length() == 0) goto L31;
        r9 = false;
        goto L32
    L25:
        r8 = null;
    L34:
        r10 = false;
        goto L35
    L13:
        r3 = false;
    L9:
        r2 = k0.UNLOCKED;
        goto L11
    }

    public static void m(vz1.e r25, int r26, String r27, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r28, r3 r29) {
        Intrinsics.checkNotNullParameter(r27, "errorMessage");
        Intrinsics.checkNotNullParameter(r28, "receiverService");
        Intrinsics.checkNotNullParameter(r29, "giftSendService");
        if (r25 != null) goto L5;
        return;
    L5:
        yz0.k r3 = u.h();
        if (r3 == null) goto L8;
        IRoom r4 = r3.getRoom();
    L9:
        IBaseUser r14 = r28.a;
        String r19 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        int r1 = r29.f(r28.b);
        boolean r2 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        long r6 = r25.b;
        boolean r8 = r25.e;
        if (r4 == null) goto L12;
        long r9 = r4.getRoomId();
    L14:
        if (r19 != null) goto L16;
        String r13 = BuildConfig.FLAVOR;
    L17:
        if (r4 == null) goto L22;
        String r5 = r4.getAnchorId();
        if (r5 == null) goto L22;
        String r16 = r5;
    L23:
        com.bytedance.android.livesdk.gift.platform.core.d0.p(r6, r6, r8, r9, r26, r27, r13, r16, r14.getIdString(), com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r14), r1);
        long r7 = r25.b;
        boolean r10 = r25.e;
        if (r4 == null) goto L26;
        long r11 = r4.getRoomId();
    L27:
        if (r19 != null) goto L29;
        String r15 = BuildConfig.FLAVOR;
    L30:
        if (r4 == null) goto L35;
        String r0 = r4.getAnchorId();
        if (r0 == null) goto L35;
        String r17 = r0;
    L36:
        com.bytedance.android.livesdk.gift.platform.core.d0.q(r7, r7, r10, r11, r26, r27, r15, r17, r14.getIdString(), com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r14), r1);
        return;
    L35:
        r17 = BuildConfig.FLAVOR;
        goto L36
    L29:
        r15 = r19;
        goto L30
    L26:
        r11 = 0;
    L22:
        r16 = BuildConfig.FLAVOR;
        goto L23
    L16:
        r13 = r19;
        goto L17
    L12:
        r9 = 0;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public static com.bytedance.android.livesdk.gift.platform.core.model.a n(GiftListPanelRepository r19, GiftListSortDataStore r20, ReceiverType r21, h1 r23, int r24) {
        Pair<String, List<com.bytedance.android.livesdk.gift.platform.core.giftlist.p>> r2 = r19.c(r21);
        List r3 = (List) r2.getSecond();
        boolean r5 = false;
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.p) r4.next()).a.getId() != r23.getId()) goto L6;
        r5 = true;
    L10:
        if (r5 == true) goto L12;
        r20.getClass();
        return new com.bytedance.android.livesdk.gift.platform.core.model.a(null, null, GiftInsertStatus.NOT_STRATEGY, null, r20.g, null, null);
    L12:
        if (com.bytedance.android.livesdk.gift.platform.core.h.o().contains(r2.getFirst()) == true) goto L14;
    L19:
        r20.getClass();
        return new com.bytedance.android.livesdk.gift.platform.core.model.a(null, null, "strategy_not_insert", null, r20.g, null, null);
    L14:
        if (r24 != 1) goto L19;
        if (r21 != ReceiverType.Anchor) goto L18;
        r20.getClass();
        return new com.bytedance.android.livesdk.gift.platform.core.model.a(null, null, GiftInsertStatus.STRATEGY_INSERT, null, r20.g, null, null);
    L18:
        r20.getClass();
        return new com.bytedance.android.livesdk.gift.platform.core.model.a(null, null, "strategy_not_insert", null, r20.g, null, null);
    }

    public static /* synthetic */ vz1.e p(h1 r26, int r27, String r28, ReceiverType r29, GiftExtraRepo r30, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r31, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r33, com.bytedance.android.livesdk.gift.platform.business.config.a r34, boolean r35, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r36, IRoom r37, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r38, e1 r39, GiftListPanelRepository r310, GiftListSortDataStore r40, int r41, int r43) {
        return o(r26, new vz1.e(r26, 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862), r27, r28, r29, r30, r31, r33, r34, r35, r36, r37, r38, r39, r310, r40, r41, r43);
    }

    public static vz1.e o(h1 r40, vz1.e r41, int r43, String r44, ReceiverType r45, GiftExtraRepo r46, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r47, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.c r48, com.bytedance.android.livesdk.gift.platform.business.config.a r49, boolean r410, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r50, IRoom r51, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r53, e1 r54, GiftListPanelRepository r55, GiftListSortDataStore r56, int r57, int r58) {
        com.bytedance.android.livesdk.gift.platform.business.config.a r7 = r49;
        Intrinsics.checkNotNullParameter(r40, "gift");
        Intrinsics.checkNotNullParameter(r41, "originIconModel");
        Intrinsics.checkNotNullParameter(r45, "receiverType");
        Intrinsics.checkNotNullParameter(r46, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r47, "giftDIYDataStore");
        Intrinsics.checkNotNullParameter(r48, "cardDataStore");
        Intrinsics.checkNotNullParameter(r7, "cardConfig");
        Intrinsics.checkNotNullParameter(r50, "receiverService");
        Intrinsics.checkNotNullParameter(r51, "currentRoom");
        Intrinsics.checkNotNullParameter(r53, "giftListRepository");
        Intrinsics.checkNotNullParameter(r54, "giftListService");
        Intrinsics.checkNotNullParameter(r55, "giftListPanelRepository");
        Intrinsics.checkNotNullParameter(r56, "giftListSortDataStore");
        com.bytedance.android.livesdk.gift.model.g0 r13 = r46.q(r40.getId());
        GiftPanelBizBoostUtils.E.getClass();
        Lazy r14 = GiftPanelBizBoostUtils.q;
        if (((Boolean) r14.getValue()).booleanValue() == false) goto L6;
        if (r44 == null) goto L6;
        String r8 = r44;
    L7:
        int r15 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a;
        long r16 = r40.getId();
        e2 r17 = r40.getGiftTouchLabel();
        if (r17 == null) goto L10;
        String r4 = r17.getTouchUniqueKey();
    L11:
        boolean r23 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a(r16, r8, r4);
        if (r13 == null) goto L16;
        com.bytedance.android.livesdk.gift.model.p r5 = r13.getDiyGiftToolbarInfo();
        if (r5 == null) goto L16;
        List<com.bytedance.android.livesdk.gift.model.n> r6 = r5.getForceIndexCards();
    L17:
        if (r13 == null) goto L21;
        com.bytedance.android.livesdk.gift.model.p r9 = r13.getDiyGiftToolbarInfo();
        if (r9 == null) goto L21;
        List<com.bytedance.android.livesdk.gift.model.n> r10 = r47.d(r40.getId(), r9);
        Unit r18 = Unit.INSTANCE;
    L22:
        com.bytedance.android.livesdk.gift.platform.core.model.a r24 = n(r55, r56, r45, r40, r43);
        if (r13 == null) goto L25;
        List<l1> r0 = r13.getGiftBuffInfos();
    L26:
        boolean r19 = true;
        if (r6 != null) goto L326;
        if (r10 != null) goto L326;
        if (r0 != null) goto L32;
        py.k r2 = null;
        com.bytedance.android.livesdk.gift.platform.core.model.k r25 = new com.bytedance.android.livesdk.gift.platform.core.model.k(r57, r43, r58, r40.getId(), false);
        if (r13 == null) goto L324;
        k1 r110 = r13.getBottomLabel();
        if (r110 == null) goto L324;
        r2 = r110.getLabel();
    L324:
        return new vz1.e(r40, 0, null, 0, false, false, null, null, null, null, null, null, null, null, new vz1.f(r2), null, null, null, r23, r25, r24, 20709374);
    L32:
        if (GiftPanelBizBoostUtils.c() == false) goto L34;
        HashMap<String, String> r11 = r48.o;
    L35:
        String r20 = r11.get(String.valueOf(r40.getId()));
        if (r20 == null) goto L38;
        Long r21 = StringsKt.toLongOrNull(r20);
    L40:
        if (GiftPanelBizBoostUtils.c() == false) goto L42;
        HashMap<String, String> r26 = r48.p;
    L43:
        String r27 = r26.get(String.valueOf(r40.getId()));
        if (r27 == null) goto L46;
        Long r28 = StringsKt.toLongOrNull(r27);
    L47:
        Iterator<T> r1 = r0.iterator();
        l1 r29 = null;
        int r30 = 0;
        h2 r111 = null;
        h2 r112 = null;
    L49:
        if (r1.hasNext() == false) goto L77;
        Object r113 = r1.next();
        int r210 = r30 + 1;
        if (r30 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        l1 r31 = (l1) r113;
        GiftBuffCardHelper.a.getClass();
        if (GiftBuffCardHelper.Companion.j(r31, r40, r410, r53, r54) == false) goto L76;
        com.bytedance.android.livesdk.gift.model.i r114 = r31.getLockInfo();
        if (r114 != null) goto L58;
    L61:
        l1.Companion.getClass();
        if (l1.a.g(r43, r31) == 0) goto L64;
        r112 = GiftManagerKt.l(r31.getBuffGiftId());
        r29 = r31;
    L64:
        com.bytedance.android.livesdk.gift.model.i r115 = r31.getLockInfo();
        if (r115 != null) goto L67;
    L70:
        long r116 = r31.getBuffLevel();
        if (r21 == null) goto L76;
        if (r116 != r21.longValue()) goto L76;
        r111 = GiftManagerKt.l(r31.getBuffGiftId());
        goto L76
    L67:
        if (r115.getLocked() != r19) goto L70;
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.c(r7, r43) == false) goto L76;
    L58:
        if (r114.getLocked() != r19) goto L61;
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.c(r7, r43) == false) goto L64;
    L76:
        r30 = r210;
        r19 = true;
        goto L49
    L77:
        Long r3 = r41.h;
        String r33 = r41.p;
        py.k r34 = r41.o;
        GiftPanelIconSource r117 = r41.q;
        vz1.d r118 = r41.t;
        Pair<Integer, vz1.i> r119 = r41.c;
        CardType r120 = r41.v;
        String r121 = r41.l;
        Long r122 = r3;
        String r35 = r41.m;
        Boolean r36 = r41.n;
        vz1.a r211 = new vz1.a(0, null, 0, null, false, null, null, 0, 255);
        if (r49.u6() == false) goto L99;
        if (r111 == null) goto L99;
        String r37 = r111.getName();
        if (r37 != null) goto L83;
    L87:
        r37 = r111.getDescribe();
    L88:
        if (r37 != null) goto L90;
        r37 = BuildConfig.FLAVOR;
    L90:
        r34 = r111.getImage();
        r117 = GiftPanelIconSource.GIFT_LIST;
        e3 r123 = (e3) vh7.f.c(e3.class);
        r123.setPluginId(r111.getId());
        CardType r124 = CardType.Buff;
        GiftBuffCardHelper.Companion r125 = GiftBuffCardHelper.a;
        if (r21 == null) goto L93;
        int r126 = (int) r21.longValue();
    L94:
        if (r29 == null) goto L96;
        py.k r127 = r29.getDynamicGiftIcon();
    L97:
        r125.getClass();
        r119 = GiftBuffCardHelper.Companion.b(r126, r34, r127);
        r118 = new vz1.d(r37, CollectionsKt.listOf(r123));
        r120 = r124;
        goto L99
    L96:
        r127 = null;
        goto L97
    L93:
        r126 = -1;
        goto L94
    L83:
        if ((!TextUtils.isEmpty(r37)) == true) goto L86;
        r37 = null;
    L86:
        if (r37 != null) goto L88;
    L99:
        if (r29 == null) goto L155;
        if (r28 != null) goto L102;
    L103:
        if (r112 == null) goto L111;
        String r38 = r112.getName();
        if (r38 == null) goto L111;
        if ((!TextUtils.isEmpty(r38)) == true) goto L110;
        r38 = null;
    L110:
        if (r38 == null) goto L111;
    L114:
        if (r38 != null) goto L116;
        r38 = BuildConfig.FLAVOR;
    L116:
        l1.Companion.getClass();
        if (l1.a.e(r43, r29) == false) goto L120;
        r33 = r38;
    L120:
        if (l1.a.b(r43, r29) == false) goto L213;
        long r39 = r29.getBuffDiamondCount();
        Long r59 = r41.h;
        if (r59 == null) goto L124;
        long r128 = r59.longValue();
    L125:
        Long r60 = Long.valueOf(r39 + r128);
        if (r112 == null) goto L129;
        py.k r61 = r112.getImage();
        if (r61 == null) goto L129;
    L130:
        r34 = r61;
        Map<Integer, b2> r63 = r29.getDefaultGiftTextMap();
        if (r63 == null) goto L135;
        b2 r64 = r63.get(Integer.valueOf(r43));
        if (r64 == null) goto L135;
        String r129 = r64.getDefaultGiftMainText();
    L136:
        Map<Integer, b2> r65 = r29.getDefaultGiftTextMap();
        if (r65 == null) goto L141;
        b2 r66 = r65.get(Integer.valueOf(r43));
        if (r66 == null) goto L141;
        String r67 = r66.getDefaultGiftSubText();
    L142:
        com.bytedance.android.livesdk.gift.model.i r68 = r29.getLockInfo();
        if (r68 != null) goto L145;
    L147:
        boolean r69 = false;
    L148:
        Boolean r70 = Boolean.valueOf(r69);
        r117 = GiftPanelIconSource.BUFF_CARD;
        e3 r130 = (e3) vh7.f.c(e3.class);
        if (r112 == null) goto L151;
        long r71 = r112.getId();
    L152:
        r130.setPluginId(r71);
        r120 = CardType.Buff;
        GiftBuffCardHelper.Companion r73 = GiftBuffCardHelper.a;
        int r74 = r29.getBuffLevel();
        py.k r131 = r29.getDynamicGiftIcon();
        r73.getClass();
        r119 = GiftBuffCardHelper.Companion.b(r74, r34, r131);
        vz1.d r75 = new vz1.d(r38, CollectionsKt.listOf(r130));
    L153:
        r33 = r33;
        r36 = r70;
        r122 = r60;
        String r76 = r67;
        r118 = r75;
    L214:
        if (r112 == null) goto L222;
        String r77 = r112.getName();
        if (r77 == null) goto L222;
        if ((!TextUtils.isEmpty(r77)) == true) goto L221;
        r77 = null;
    L221:
        if (r77 == null) goto L222;
    L225:
        if (r77 != null) goto L227;
        r77 = BuildConfig.FLAVOR;
    L227:
        l1.Companion.getClass();
        if (l1.a.f(r43, r29) == false) goto L230;
        String r132 = r77;
    L232:
        if (l1.a.c(r43, r29) == false) goto L299;
        if (r29 == null) goto L235;
        long r78 = r29.getBuffDiamondCount();
    L236:
        Long r79 = r41.h;
        if (r79 == null) goto L239;
        long r80 = r79.longValue();
    L240:
        r122 = Long.valueOf(r78 + r80);
        if (r112 == null) goto L243;
        py.k r81 = r112.getImage();
    L244:
        if (r29 == null) goto L250;
        Map<Integer, b2> r83 = r29.getDefaultGiftTextMap();
        if (r83 == null) goto L250;
        b2 r84 = r83.get(Integer.valueOf(r43));
        if (r84 == null) goto L250;
        String r85 = r84.getDefaultGiftMainText();
    L251:
        if (r29 == null) goto L257;
        Map<Integer, b2> r86 = r29.getDefaultGiftTextMap();
        if (r86 == null) goto L257;
        b2 r87 = r86.get(Integer.valueOf(r43));
        if (r87 == null) goto L257;
        String r88 = r87.getDefaultGiftSubText();
    L258:
        if (r29 == null) goto L264;
        com.bytedance.android.livesdk.gift.model.i r89 = r29.getLockInfo();
        if (r89 == null) goto L264;
        if (r89.getLocked() != true) goto L264;
        boolean r90 = true;
    L265:
        Boolean r91 = Boolean.valueOf(r90);
        GiftPanelIconSource r93 = GiftPanelIconSource.BUFF_CARD;
        e3 r133 = (e3) vh7.f.c(e3.class);
        if (r112 == null) goto L268;
        long r134 = r112.getId();
    L269:
        r133.setPluginId(r134);
        CardType r135 = CardType.Buff;
        if (r29 == null) goto L276;
        com.bytedance.android.livesdk.gift.model.i r136 = r29.getLockInfo();
        if (r136 == null) goto L276;
        if (r136.getLocked() != true) goto L276;
        int r137 = CardStatus.INSTANCE.getLOCK();
    L277:
        if (r29 == null) goto L281;
        com.bytedance.android.livesdk.gift.model.i r138 = r29.getLockInfo();
        if (r138 == null) goto L281;
        String r139 = r138.getCellText();
    L282:
        if (r29 == null) goto L284;
        int r94 = (int) r29.getBuffDiamondCount();
    L285:
        int r411 = r94;
        py.k r95 = null;
        int r96 = h(r40.getId(), r29, null, r46);
        if (r29 == null) goto L290;
        com.bytedance.android.livesdk.gift.model.i r97 = r29.getLockInfo();
        if (r97 == null) goto L290;
        boolean r98 = r97.getUseCustomButtonColor();
    L291:
        vz1.a r140 = new vz1.a(r137, r139, r411, null, r98, r29, null, r96, 72);
        vz1.d r99 = new vz1.d(r77, CollectionsKt.listOf(r133));
        GiftBuffCardHelper.Companion r100 = GiftBuffCardHelper.a;
        if (r29 == null) goto L294;
        int r101 = r29.getBuffLevel();
    L295:
        if (r29 == null) goto L297;
        py.k r102 = r29.getDynamicGiftIcon();
    L298:
        r100.getClass();
        Pair<Integer, vz1.i> r103 = GiftBuffCardHelper.Companion.b(r101, r81, r102);
        py.k r141 = r81;
        vz1.d r212 = r99;
        CardType r213 = r135;
        vz1.a r142 = r140;
        r76 = r88;
        Boolean r143 = r91;
        GiftPanelIconSource r144 = r93;
        String r145 = r85;
    L301:
        if (l1.a.h(r43, r142.f) == false) goto L307;
        Long r104 = r41.h;
        if (r104 == null) goto L305;
        long r105 = r104.longValue();
    L306:
        r122 = Long.valueOf(r105);
        goto L307
    L305:
        r105 = 0;
    L307:
        Long r214 = r122;
        com.bytedance.android.livesdk.gift.platform.core.model.k r215 = new com.bytedance.android.livesdk.gift.platform.core.model.k(r57, r43, r58, r40.getId(), false);
        if (r13 == null) goto L312;
        k1 r146 = r13.getBottomLabel();
        if (r146 == null) goto L312;
        r95 = r146.getLabel();
    L312:
        vz1.e r147 = new vz1.e(r40, 0, r103, 0, false, false, null, null, r145, r76, r143, r141, r132, r144, new vz1.f(r95), r212, r142, r213, r23, r215, r24, 16910330);
        Long r106 = r147.h;
        if (r214 == null) goto L316;
        r106 = r214;
    L316:
        r147.r = r106;
        return r147;
    L297:
        r102 = null;
        goto L298
    L294:
        r101 = -1;
    L290:
        r98 = false;
        goto L291
    L284:
        r94 = 0;
    L281:
        r139 = null;
    L276:
        r137 = CardStatus.INSTANCE.getUNLOCK();
        goto L277
    L268:
        r134 = 0;
    L264:
        r90 = false;
    L257:
        r88 = null;
    L250:
        r85 = null;
        goto L251
    L243:
        r81 = null;
        goto L244
    L239:
        r80 = 0;
        goto L240
    L235:
        r78 = 0;
        goto L236
    L299:
        r95 = null;
        r144 = r117;
        r212 = r118;
        r103 = r119;
        r145 = r129;
        r142 = r211;
        r141 = r34;
        r213 = r120;
        r143 = r36;
        goto L301
    L230:
        r132 = r33;
    L222:
        if (r112 == null) goto L224;
        r77 = r112.getDescribe();
        goto L225
    L224:
        r77 = null;
        goto L225
    L151:
        r71 = 0;
        goto L152
    L145:
        if (r68.getLocked() != true) goto L147;
        r69 = true;
    L141:
        r67 = null;
    L135:
        r129 = null;
    L129:
        r61 = (py.k) vh7.f.c(py.k.class);
        goto L130
    L124:
        r128 = 0;
    L213:
        r76 = r35;
        r129 = r121;
    L111:
        if (r112 == null) goto L113;
        r38 = r112.getDescribe();
        goto L114
    L113:
        r38 = null;
        goto L114
    L102:
        if (r29.getStartTime() > r28.longValue()) goto L103;
    L155:
        if (r29 == null) goto L211;
        if (r28 == null) goto L211;
        if (r29.getStartTime() > r28.longValue()) goto L211;
        String r148 = r33;
        if (Intrinsics.areEqual(r21, Long.valueOf(r29.getBuffLevel())) == false) goto L212;
        if (r112 == null) goto L169;
        String r107 = r112.getName();
        if (r107 == null) goto L169;
        if ((!TextUtils.isEmpty(r107)) == true) goto L168;
        r107 = null;
    L168:
        if (r107 == null) goto L169;
    L172:
        if (r107 != null) goto L174;
        r107 = BuildConfig.FLAVOR;
    L174:
        l1.Companion.getClass();
        if (l1.a.d(r43, r29) == false) goto L177;
        r33 = r107;
    L179:
        if (l1.a.a(r43, r29) == false) goto L213;
        long r108 = r29.getBuffDiamondCount();
        Long r109 = r41.h;
        if (r109 == null) goto L183;
        long r149 = r109.longValue();
    L184:
        r60 = Long.valueOf(r108 + r149);
        if (r112 == null) goto L187;
        r34 = r112.getImage();
    L188:
        Map<Integer, b2> r150 = r29.getDefaultGiftTextMap();
        if (r150 == null) goto L193;
        b2 r151 = r150.get(Integer.valueOf(r43));
        if (r151 == null) goto L193;
        r129 = r151.getDefaultGiftMainText();
    L194:
        Map<Integer, b2> r152 = r29.getDefaultGiftTextMap();
        if (r152 == null) goto L199;
        b2 r153 = r152.get(Integer.valueOf(r43));
        if (r153 == null) goto L199;
        r67 = r153.getDefaultGiftSubText();
    L200:
        com.bytedance.android.livesdk.gift.model.i r154 = r29.getLockInfo();
        if (r154 != null) goto L203;
    L205:
        boolean r155 = false;
    L206:
        r70 = Boolean.valueOf(r155);
        r117 = GiftPanelIconSource.BUFF_CARD;
        e3 r156 = (e3) vh7.f.c(e3.class);
        if (r112 == null) goto L209;
        long r157 = r112.getId();
    L210:
        r156.setPluginId(r157);
        r120 = CardType.Buff;
        r75 = new vz1.d(r107, CollectionsKt.listOf(r156));
        GiftBuffCardHelper.Companion r158 = GiftBuffCardHelper.a;
        int r159 = r29.getBuffLevel();
        py.k r160 = r29.getDynamicGiftIcon();
        r158.getClass();
        r119 = GiftBuffCardHelper.Companion.b(r159, r34, r160);
        goto L153
    L209:
        r157 = 0;
        goto L210
    L203:
        if (r154.getLocked() != true) goto L205;
        r155 = true;
    L199:
        r67 = null;
    L193:
        r129 = null;
        goto L194
    L187:
        r34 = null;
        goto L188
    L183:
        r149 = 0;
        goto L184
    L177:
        r33 = r148;
    L169:
        if (r112 == null) goto L171;
        r107 = r112.getDescribe();
        goto L172
    L171:
        r107 = null;
    L212:
        r33 = r148;
    L211:
        r148 = r33;
        goto L212
    L46:
        r28 = null;
        goto L47
    L42:
        r26 = ay1.b.d();
        goto L43
    L38:
        r21 = null;
        goto L40
    L34:
        r11 = ay1.b.c();
    L326:
        if (r6 != null) goto L328;
    L330:
        com.bytedance.android.livesdk.gift.model.n r161 = null;
    L332:
        if (GiftPanelBizBoostUtils.c() == false) goto L334;
        HashMap<String, String> r162 = r48.l;
    L335:
        String r163 = r162.get(String.valueOf(r40.getId()));
        if (r163 == null) goto L338;
        Long r164 = StringsKt.toLongOrNull(r163);
    L340:
        if (GiftPanelBizBoostUtils.c() == false) goto L342;
        HashMap<String, String> r165 = r48.m;
    L343:
        Long r166 = r41.h;
        String r167 = r41.p;
        py.k r168 = r41.o;
        Pair<Integer, vz1.i> r169 = r41.c;
        vz1.d r170 = r41.t;
        GiftPanelIconSource r171 = r41.q;
        vz1.a r172 = new vz1.a(0, null, 0, null, false, null, null, 0, 255);
        CardType r216 = CardType.None;
        GiftPanelIconSource r217 = r171;
        String r173 = r41.l;
        String r218 = r41.m;
        Boolean r174 = r41.n;
        if (r165 != null) goto L346;
        Boolean r219 = r174;
    L356:
        ArrayList<e3> r175 = null;
    L357:
        GiftPanelBizBoostUtils.E.getClass();
        if (GiftPanelBizBoostUtils.c() == false) goto L360;
        HashMap<String, String> r176 = r48.n;
    L361:
        String r177 = r176.get(String.valueOf(r40.getId()));
        if (r49.u6() == false) goto L400;
        if (r13 == null) goto L378;
        com.bytedance.android.livesdk.gift.model.p r178 = r13.getDiyGiftToolbarInfo();
        if (r178 == null) goto L378;
        List<com.bytedance.android.livesdk.gift.model.n> r179 = r178.getCards();
        if (r179 == null) goto L378;
        Iterator r180 = r179.iterator();
    L370:
        if (r180.hasNext() == false) goto L375;
        Object r181 = r180.next();
        Iterator r412 = r180;
        if (gz1.b.d((com.bytedance.android.livesdk.gift.model.n) r181, r175, r177) == true) goto L376;
        r180 = r412;
    L376:
        com.bytedance.android.livesdk.gift.model.n r182 = (com.bytedance.android.livesdk.gift.model.n) r181;
        if (r182 == null) goto L378;
    L393:
        if (r182 == null) goto L400;
        r47.getClass();
        int r183 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f.c(r10, r182);
        r168 = r182.getIconImg();
        GiftPanelIconSource r184 = GiftPanelIconSource.GIFT_LIST;
        Integer r185 = Integer.valueOf(r183);
        GiftBuffCardHelper.a.getClass();
        r169 = TuplesKt.to(r185, GiftBuffCardHelper.Companion.f(r182));
        vz1.d r186 = new vz1.d(r182.getCardName(), gz1.c.g(r182));
        r216 = CardType.DIY;
        long r187 = r182.getTotalDiamonds();
        Long r188 = r41.h;
        if (r188 == null) goto L397;
        long r220 = r188.longValue();
    L398:
        r166 = Long.valueOf(r187 + r220);
        Unit r189 = Unit.INSTANCE;
        r217 = r184;
        r170 = r186;
        goto L400
    L397:
        r220 = 0;
        goto L398
    L375:
        r181 = null;
    L378:
        if (r13 == null) goto L392;
        com.bytedance.android.livesdk.gift.model.p r190 = r13.getDiyGiftToolbarInfo();
        if (r190 == null) goto L392;
        List<com.bytedance.android.livesdk.gift.model.n> r191 = r190.getForceIndexCards();
        if (r191 == null) goto L392;
        Iterator r192 = r191.iterator();
    L385:
        if (r192.hasNext() == false) goto L390;
        Object r193 = r192.next();
        Iterator r413 = r192;
        if (gz1.b.d((com.bytedance.android.livesdk.gift.model.n) r193, r175, r177) == true) goto L391;
        r192 = r413;
    L391:
        r182 = (com.bytedance.android.livesdk.gift.model.n) r193;
        goto L393
    L390:
        r193 = null;
    L392:
        r182 = null;
    L400:
        if (r161 != null) goto L402;
    L440:
        if (r161 != null) goto L442;
    L481:
        String r194 = r173;
        String r195 = r167;
    L482:
        if (r161 == null) goto L519;
        if (gz1.a.c(r161) == false) goto L486;
    L489:
        com.bytedance.android.livesdk.gift.model.n.Companion.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.c(r43, r161) == false) goto L500;
        String r196 = r161.getMainText();
        if (r196 == null) goto L500;
        if ((!TextUtils.isEmpty(r196)) == true) goto L497;
        r196 = null;
    L497:
        if (r196 == null) goto L500;
        Unit r197 = Unit.INSTANCE;
        r195 = r196;
    L500:
        if (com.bytedance.android.livesdk.gift.model.n.a.c(r43, r161) == false) goto L519;
        r168 = r161.getIconImg();
        r217 = GiftPanelIconSource.DIY_CARD;
        GiftBuffCardHelper.a.getClass();
        r169 = TuplesKt.to(0, GiftBuffCardHelper.Companion.f(r161));
        vz1.d r198 = new vz1.d(r161.getCardName(), gz1.c.g(r161));
        r216 = CardType.DIY;
        long r199 = r161.getTotalDiamonds();
        Long r200 = r41.h;
        if (r200 == null) goto L504;
        long r221 = r200.longValue();
    L505:
        r166 = Long.valueOf(r199 + r221);
        Map<Integer, b2> r201 = r161.getDefaultGiftTextMap();
        if (r201 == null) goto L510;
        b2 r202 = r201.get(Integer.valueOf(r43));
        if (r202 == null) goto L510;
        r194 = r202.getDefaultGiftMainText();
    L511:
        Map<Integer, b2> r203 = r161.getDefaultGiftTextMap();
        if (r203 == null) goto L516;
        b2 r204 = r203.get(Integer.valueOf(r43));
        if (r204 == null) goto L516;
        String r205 = r204.getDefaultGiftSubText();
    L517:
        r219 = Boolean.valueOf(!com.bytedance.android.livesdk.gift.model.o.c(r161));
        r170 = r198;
        r218 = r205;
    L516:
        r205 = null;
    L510:
        r194 = null;
        goto L511
    L504:
        r221 = 0;
        goto L505
    L486:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.c(r7, r43) == false) goto L519;
        com.bytedance.android.livesdk.gift.model.n.Companion.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.f(r43, r161) != 0) goto L489;
    L519:
        if (r10 == null) goto L583;
        Iterator r206 = r10.iterator();
        int r207 = 0;
    L522:
        if (r206.hasNext() == false) goto L582;
        Object r208 = r206.next();
        int r209 = r207 + 1;
        if (r207 >= 0) goto L526;
        CollectionsKt.throwIndexOverflow();
    L526:
        com.bytedance.android.livesdk.gift.model.n r222 = (com.bytedance.android.livesdk.gift.model.n) r208;
        if (gz1.a.c(r222) == false) goto L529;
    L530:
        com.bytedance.android.livesdk.gift.model.n.Companion.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.f(r43, r222) != 0) goto L533;
    L581:
        r206 = r206;
        r7 = r49;
        r207 = r209;
        goto L522
    L533:
        if ((com.bytedance.android.livesdk.gift.model.n.a.f(r43, r222) & 32) != 32) goto L535;
        boolean r223 = true;
    L536:
        if (r223 == false) goto L546;
        String r224 = r222.getMainText();
        if (r224 == null) goto L546;
        if ((!TextUtils.isEmpty(r224)) == true) goto L543;
        r224 = null;
    L543:
        if (r224 == null) goto L546;
        Unit r1100 = Unit.INSTANCE;
        r195 = r224;
    L546:
        if (com.bytedance.android.livesdk.gift.model.n.a.c(r43, r222) == false) goto L581;
        py.k r225 = r222.getIconImg();
        long r1101 = r222.getTotalDiamonds();
        Long r226 = r41.h;
        if (r226 == null) goto L550;
        long r1102 = r226.longValue();
    L551:
        Long r1103 = Long.valueOf(r1101 + r1102);
        GiftPanelIconSource r227 = GiftPanelIconSource.DIY_CARD;
        Integer r228 = Integer.valueOf(r207);
        GiftBuffCardHelper.a.getClass();
        Pair<Integer, vz1.i> r229 = TuplesKt.to(r228, GiftBuffCardHelper.Companion.f(r222));
        Map<Integer, b2> r1104 = r222.getDefaultGiftTextMap();
        if (r1104 == null) goto L556;
        b2 r1105 = r1104.get(Integer.valueOf(r43));
        if (r1105 == null) goto L556;
        String r1106 = r1105.getDefaultGiftMainText();
    L557:
        Map<Integer, b2> r1107 = r222.getDefaultGiftTextMap();
        if (r1107 == null) goto L562;
        b2 r1108 = r1107.get(Integer.valueOf(r43));
        if (r1108 == null) goto L562;
        String r1109 = r1108.getDefaultGiftSubText();
    L563:
        Boolean r1110 = Boolean.valueOf(!com.bytedance.android.livesdk.gift.model.o.c(r222));
        vz1.d r230 = new vz1.d(r222.getCardName(), gz1.c.g(r222));
        CardType r231 = CardType.DIY;
        if (gz1.a.c(r222) == false) goto L566;
        int r1111 = CardStatus.INSTANCE.getUNLOCK();
    L567:
        int r310 = r1111;
        CardLockInfo r1112 = r222.getLockInfo();
        if (r1112 == null) goto L570;
        String r311 = r1112.getCellText();
    L571:
        String r1113 = r222.getSendButtonText();
        if (r1113 != null) goto L574;
        String r312 = BuildConfig.FLAVOR;
    L575:
        int r232 = (int) r222.getTotalDiamonds();
        String r510 = r1106;
        int r313 = h(r40.getId(), null, r222, r46);
        CardLockInfo r1114 = r222.getLockInfo();
        if (r1114 == null) goto L578;
        boolean r314 = r1114.getUseCustomButtonColor();
    L579:
        r166 = r1103;
        r170 = r230;
        r216 = r231;
        r172 = new vz1.a(r310, r311, r232, r312, r314, null, r222, r313, 32);
        r217 = r227;
        r218 = r1109;
        r219 = r1110;
        r168 = r225;
        r169 = r229;
        r194 = r510;
        goto L581
    L578:
        r314 = false;
        goto L579
    L574:
        r312 = r1113;
        goto L575
    L570:
        r311 = null;
        goto L571
    L566:
        r1111 = CardStatus.INSTANCE.getLOCK();
    L562:
        r1109 = null;
    L556:
        r1106 = null;
        goto L557
    L550:
        r1102 = 0;
        goto L551
    L535:
        r223 = false;
        goto L536
    L529:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.c(r7, r43) == false) goto L581;
    L582:
        py.k r233 = null;
        Unit r234 = Unit.INSTANCE;
    L584:
        String r1115 = r195;
        Pair<Integer, vz1.i> r235 = r169;
        vz1.a r1116 = r172;
        GiftPanelIconSource r1117 = r217;
        String r236 = r218;
        String r1118 = r194;
        py.k r1119 = r168;
        vz1.d r1120 = r170;
        CardType r237 = r216;
        Boolean r1121 = r219;
        com.bytedance.android.livesdk.gift.model.n.a r238 = com.bytedance.android.livesdk.gift.model.n.Companion;
        com.bytedance.android.livesdk.gift.model.n r239 = r1116.g;
        r238.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.g(r43, r239) == false) goto L587;
        r166 = r41.h;
    L587:
        Long r240 = r166;
        com.bytedance.android.livesdk.gift.platform.core.model.k r241 = new com.bytedance.android.livesdk.gift.platform.core.model.k(r57, r43, r58, r40.getId(), false);
        if (r13 == null) goto L592;
        k1 r242 = r13.getBottomLabel();
        if (r242 == null) goto L592;
        py.k r243 = r242.getLabel();
    L593:
        vz1.e r1122 = new vz1.e(r40, 0, r235, 0, false, false, null, null, r1118, r236, r1121, r1119, r1115, r1117, new vz1.f(r243), r1120, r1116, r237, r23, r241, r24, 16910330);
        Long r244 = r1122.h;
        if (r240 == null) goto L597;
        r244 = r240;
    L597:
        r1122.r = r244;
        return r1122;
    L592:
        r243 = r233;
        goto L593
    L583:
        r233 = null;
        goto L584
    L442:
        if (gz1.a.c(r161) == false) goto L444;
    L445:
        if (r164 == null) goto L481;
        if (r161.getStartTime() > r164.longValue()) goto L481;
        if (gz1.b.d(r161, r175, r177) == false) goto L481;
        com.bytedance.android.livesdk.gift.model.n.Companion.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.d(r43, r161) == false) goto L460;
        String r245 = r161.getMainText();
        if (r245 == null) goto L460;
        if ((!TextUtils.isEmpty(r245)) == true) goto L458;
        r245 = null;
    L458:
        if (r245 == null) goto L460;
        Unit r246 = Unit.INSTANCE;
        r195 = r245;
    L462:
        if (com.bytedance.android.livesdk.gift.model.n.a.a(r43, r161) == true) goto L463;
    L439:
        r194 = r173;
        goto L482
    L463:
        py.k r247 = r161.getIconImg();
        GiftPanelIconSource r248 = GiftPanelIconSource.DIY_CARD;
        GiftBuffCardHelper.a.getClass();
        Pair<Integer, vz1.i> r249 = TuplesKt.to(0, GiftBuffCardHelper.Companion.f(r161));
        vz1.d r250 = new vz1.d(r161.getCardName(), gz1.c.g(r161));
        CardType r1123 = CardType.DIY;
        long r1124 = r161.getTotalDiamonds();
        Long r1125 = r41.h;
        if (r1125 == null) goto L466;
        long r251 = r1125.longValue();
    L467:
        r166 = Long.valueOf(r1124 + r251);
        Map<Integer, b2> r1126 = r161.getDefaultGiftTextMap();
        if (r1126 == null) goto L472;
        b2 r1127 = r1126.get(Integer.valueOf(r43));
        if (r1127 == null) goto L472;
        String r1128 = r1127.getDefaultGiftMainText();
    L473:
        Map<Integer, b2> r1129 = r161.getDefaultGiftTextMap();
        py.k r414 = r247;
        if (r1129 == null) goto L478;
        b2 r252 = r1129.get(Integer.valueOf(r43));
        if (r252 == null) goto L478;
        String r253 = r252.getDefaultGiftSubText();
    L479:
        Boolean r1130 = Boolean.valueOf(!com.bytedance.android.livesdk.gift.model.o.c(r161));
        r217 = r248;
        r170 = r250;
        r216 = r1123;
    L438:
        r194 = r1128;
        r168 = r414;
        r218 = r253;
        r219 = r1130;
        r169 = r249;
    L478:
        r253 = null;
    L472:
        r1128 = null;
        goto L473
    L466:
        r251 = 0;
    L460:
        r195 = r167;
        goto L462
    L444:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(r7, r43) == false) goto L481;
    L402:
        if (gz1.a.c(r161) == false) goto L404;
    L405:
        if (r164 != null) goto L407;
    L408:
        com.bytedance.android.livesdk.gift.model.n.Companion.getClass();
        if (com.bytedance.android.livesdk.gift.model.n.a.e(r43, r161) == false) goto L418;
        String r254 = r161.getMainText();
        if (r254 == null) goto L418;
        if ((!TextUtils.isEmpty(r254)) == true) goto L416;
        r254 = null;
    L416:
        if (r254 == null) goto L418;
        Unit r255 = Unit.INSTANCE;
        r195 = r254;
    L420:
        if (com.bytedance.android.livesdk.gift.model.n.a.b(r43, r161) == false) goto L439;
        py.k r256 = r161.getIconImg();
        GiftBuffCardHelper.a.getClass();
        Pair<Integer, vz1.i> r257 = TuplesKt.to(0, GiftBuffCardHelper.Companion.f(r161));
        vz1.d r258 = new vz1.d(r161.getCardName(), gz1.c.g(r161));
        GiftPanelIconSource r259 = GiftPanelIconSource.DIY_CARD;
        CardType r1131 = CardType.DIY;
        long r1132 = r161.getTotalDiamonds();
        Long r1133 = r41.h;
        if (r1133 == null) goto L424;
        long r260 = r1133.longValue();
    L425:
        r166 = Long.valueOf(r1132 + r260);
        Map<Integer, b2> r1134 = r161.getDefaultGiftTextMap();
        if (r1134 == null) goto L430;
        b2 r1135 = r1134.get(Integer.valueOf(r43));
        if (r1135 == null) goto L430;
        r1128 = r1135.getDefaultGiftMainText();
    L431:
        Map<Integer, b2> r1136 = r161.getDefaultGiftTextMap();
        r414 = r256;
        if (r1136 == null) goto L436;
        b2 r261 = r1136.get(Integer.valueOf(r43));
        if (r261 == null) goto L436;
        r253 = r261.getDefaultGiftSubText();
    L437:
        r1130 = Boolean.valueOf(!com.bytedance.android.livesdk.gift.model.o.c(r161));
        r170 = r258;
        r217 = r259;
        r216 = r1131;
        r249 = r257;
    L436:
        r253 = null;
    L430:
        r1128 = null;
        goto L431
    L424:
        r260 = 0;
    L418:
        r195 = r167;
        goto L420
    L407:
        if (r161.getStartTime() <= r164.longValue()) goto L440;
    L404:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(r7, r43) == false) goto L440;
    L360:
        r176 = ay1.b.f();
        goto L361
    L346:
        if (((Boolean) r14.getValue()).booleanValue() == false) goto L350;
        r219 = r174;
        if (r165.get(String.valueOf(r40.getId())) == null) goto L356;
    L599:
        r175 = gz1.c.d(new JSONArray(r165.get(String.valueOf(r40.getId()))));     // Catch: Exception -> L353
    L353:
        e = move-exception;
        e.printStackTrace();
        goto L356
    L350:
        r219 = r174;
        goto L599
    L342:
        r165 = ay1.b.g();
        goto L343
    L338:
        r164 = null;
        goto L340
    L334:
        r162 = ay1.b.h();
        goto L335
    L328:
        if ((!r6.isEmpty()) != true) goto L330;
        r161 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r6, 0);
        goto L332
    L25:
        r0 = null;
    L21:
        r10 = null;
    L16:
        r6 = null;
        goto L17
    L10:
        r4 = null;
    L6:
        r8 = r50.a.getIdString();
        goto L7
    }
}
