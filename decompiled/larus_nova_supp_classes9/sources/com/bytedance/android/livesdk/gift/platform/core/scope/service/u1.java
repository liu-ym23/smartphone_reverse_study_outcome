package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.IGiftExposureAnimInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTabDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.CardType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.GiftPanelIconSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftInsertStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.GiftStickerSortService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u1 extends s1 {
    public static final /* synthetic */ int B = 0;
    public final GiftTabDataStore A;
    public final IRoom d;
    public final int[] e;
    public long f;
    public com.bytedance.android.livesdk.gift.platform.core.model.k g;
    public int h;
    public boolean i;
    public int j;
    public final Bundle k;
    public final DataCenter l;
    public final g1 m;
    public final w0 n;
    public final yz0.k o;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f p;
    public final GiftReceiverRepoService q;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r;
    public final PropListService s;
    public final GiftDataStorageService t;
    public final t1 u;
    public final GiftListSortDataStore v;
    public final GroupLiveReceiverService w;
    public final f1 x;
    public final GiftStickerSortService y;
    public final GiftTopicDataStore z;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Map<String, String> b;
        public final String c;
        public final String d;
        public final String e;
        public final Bundle f;
        public final Map<String, String> g;
        public final boolean h;
        public final Map<String, String> i;
        public final com.bytedance.android.livesdk.gift.platform.business.config.n j;
        public final String k;
        public final boolean l;
        public final boolean m;
        public final String n;
        public final boolean o;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L36;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (this.h == r4.h) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
            return false;
        L28:
            if (this.l == r4.l) goto L30;
            return false;
        L30:
            if (this.m == r4.m) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
            return false;
        L34:
            if (this.o == r4.o) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v30, types: [int] */
        /* JADX WARN: Type inference failed for: r2v32, types: [int] */
        /* JADX WARN: Type inference failed for: r2v34 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v46 */
        /* JADX WARN: Type inference failed for: r2v47 */
        /* JADX WARN: Type inference failed for: r2v48 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<String, String> r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            String r14 = this.e;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            Bundle r17 = this.f;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            Map<String, String> r20 = this.g;
            if (r20 == null) goto L29;
            int r21 = r20.hashCode();
        L30:
            int r23 = (r19 + r21) * 31;
            boolean r24 = this.h;
            ?? r25 = 1;
            ?? r26 = r24;
            if (r24 == false) goto L33;
            r26 = 1;
        L33:
            int r27 = (r23 + r26) * 31;
            Map<String, String> r28 = this.i;
            if (r28 == null) goto L36;
            int r29 = r28.hashCode();
        L37:
            int r30 = (r27 + r29) * 31;
            com.bytedance.android.livesdk.gift.platform.business.config.n r31 = this.j;
            if (r31 == null) goto L40;
            int r33 = r31.hashCode();
        L41:
            int r34 = (r30 + r33) * 31;
            String r35 = this.k;
            if (r35 == null) goto L44;
            int r36 = r35.hashCode();
        L45:
            int r37 = (r34 + r36) * 31;
            boolean r38 = this.l;
            ?? r39 = r38;
            if (r38 == false) goto L48;
            r39 = 1;
        L48:
            int r40 = (r37 + r39) * 31;
            boolean r41 = this.m;
            ?? r43 = r41;
            if (r41 == false) goto L51;
            r43 = 1;
        L51:
            int r44 = (r40 + r43) * 31;
            String r45 = this.n;
            if (r45 == null) goto L54;
            r1 = r45.hashCode();
        L54:
            int r46 = (r44 + r1) * 31;
            boolean r47 = this.o;
            if (r47 == true) goto L59;
            r25 = r47;
        L59:
            return r46 + r25;
        L44:
            r36 = 0;
            goto L45
        L40:
            r33 = 0;
            goto L41
        L36:
            r29 = 0;
            goto L37
        L29:
            r21 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GiftItemShowCommonParams(uid=" + this.a + ", sweepLightShowTimes=" + this.b + ", tabName=" + this.c + ", showGiftScene=" + this.d + ", connectionType=" + this.e + ", giftLogExtra=" + this.f + ", ktvReportParams=" + this.g + ", pageTypeNeedSort=" + this.h + ", extraParams=" + this.i + ", uiStrategy=" + this.j + ", toUserStatus=" + this.k + ", toMultiUsers=" + this.l + ", isGroupLiveCompetition=" + this.m + ", toUserType=" + this.n + ", asyncLogOpt=" + this.o + ")";
        }

        public b(String r10, Map<String, String> r11, String r13, String r14, String r15, Bundle r16, Map<String, String> r17, boolean r18, Map<String, String> r19, com.bytedance.android.livesdk.gift.platform.business.config.n r110, String r20, boolean r21, boolean r23, String r24, boolean r25) {
            Intrinsics.checkNotNullParameter(r10, "uid");
            Intrinsics.checkNotNullParameter(r11, "sweepLightShowTimes");
            Intrinsics.checkNotNullParameter(r13, "tabName");
            Intrinsics.checkNotNullParameter(r15, "connectionType");
            Intrinsics.checkNotNullParameter(r110, "uiStrategy");
            Intrinsics.checkNotNullParameter(r20, "toUserStatus");
            Intrinsics.checkNotNullParameter(r24, "toUserType");
            this.a = r10;
            this.b = r11;
            this.c = r13;
            this.d = r14;
            this.e = r15;
            this.f = r16;
            this.g = r17;
            this.h = r18;
            this.i = r19;
            this.j = r110;
            this.k = r20;
            this.l = r21;
            this.m = r23;
            this.n = r24;
            this.o = r25;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ u1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public c(u1 r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            u1 r0 = this.a;     // Catch: Throwable -> L4
            String r1 = this.b;     // Catch: Throwable -> L4
            Map r2 = this.c;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            u1.m1(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static String s() {
        return com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
    }

    public final boolean A() {
        return TextUtils.equals(this.o.getRoom().getAnchorId(), this.o.getUser().getUserId());
    }

    public final boolean K() {
        IMainRoom r0 = this.o.getRoom().castToOrNull(IMainRoom.class);
        if (r0 == null) goto L9;
        com.bytedance.android.live.revenue.model.extension.main.c r1 = r0.getMainOthers();
        if (r1 == null) goto L9;
        IGroupLiveData r2 = r1.getGroupLiveData();
        if (r2 == null) goto L9;
        return r2.isCurrentGroupLive();
    L9:
        return false;
    }

    public final void S0() {
        Intrinsics.checkNotNullParameter("panel", "type");
        p1("livesdk_prop_record_entrance_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("entrance_type", "panel")}), true);
    }

    public final void onStop() {
        long r0 = this.f;
        HashMap r2 = new HashMap(1);
        r2.put("stay_duration", String.valueOf((System.currentTimeMillis() - r0) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        d(r2);
        a(r2);
        int r1 = x12.b.a();
        r2.put("tab_leave_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r1));
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L5;
        p1("tab_live", r2, true);
    L6:
        String r3 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        GiftDataStorageService r4 = this.t;
        int r5 = r4.b;
        if (r5 <= 0) goto L9;
        boolean r6 = true;
    L10:
        int r7 = r4.a;
        int r8 = this.j;
        Pair[] r9 = new Pair[5];
        if (r6 == false) goto L13;
        String r10 = "1";
    L14:
        r9[0] = TuplesKt.to("send_gift", r10);
        r9[1] = TuplesKt.to("send_money", String.valueOf(r7));
        r9[2] = TuplesKt.to("send_cnt", String.valueOf(r5));
        r9[3] = TuplesKt.to("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        r9[4] = TuplesKt.to("refresh_count", String.valueOf(r8));
        LinkedHashMap r11 = new LinkedHashMap();
        MapsKt.putAll(r11, r9);
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L19;
        Bundle r14 = (Bundle) r13.getGiftLogExtra().getValue();
        if (r14 == null) goto L19;
        String r15 = r14.getString("gift_show_from");
    L21:
        if (TextUtils.isEmpty(r15) == false) goto L23;
        r11.put("gift_show_from", com.bytedance.android.livesdk.gift.platform.core.utils.h.a);
    L34:
        int r16 = x12.b.a();
        r11.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r16));
        mz0.n r17 = new mz0.n();
        Map r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r11, "map");
        r18.putAll(r11);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r20 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r20, "pageSourceLog");
        List r21 = r19.a;
        ArrayList r23 = (ArrayList) r21;
        r23.add(r20.a);
        List r24 = r17.b;
        ArrayList r25 = (ArrayList) r24;
        r25.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3("livesdk_send_gift_end", r17.a, r17.b);
        ((LinkedHashMap) this.a).clear();
        return;
    L23:
        if (Intrinsics.areEqual("hourly", r15) == false) goto L25;
    L32:
        r11.put("gift_show_from", "hour_rank");
        goto L34
    L25:
        if (Intrinsics.areEqual("regional", r15) == true) goto L32;
        if (Intrinsics.areEqual("bottom_tab", r15) == false) goto L30;
        r11.put("gift_show_from", "icon");
        goto L34
    L30:
        if (r15 == null) goto L34;
        r11.put("gift_show_from", r15);
    L19:
        r15 = null;
        goto L21
    L13:
        r10 = "0";
        goto L14
    L9:
        r6 = false;
        goto L10
    L5:
        p1("livesdk_tab_leave", r2, true);
        goto L6
    }

    public final void p0() {
        LinkedHashMap r0 = new LinkedHashMap();
        if (A() == false) goto L5;
        String r1 = "1";
    L6:
        r0.put("is_anchor", r1);
        p1("livesdk_gift_recommend_to_find_chain_click", r0, true);
        return;
    L5:
        r1 = "0";
        goto L6
    }

    public final String w() {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getConnectionType();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public static String x() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r1 = r0.getGiftListResultLogId();
        if (r1 == null) goto L8;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.s1
    public final void onStart() {
        this.f = System.currentTimeMillis();
        s0 r0 = this.m.e;
        r0.a = 0;
        r0.b = 0;
        r0.c = 0;
        r0.d = 0;
        r0.e = 0;
        super.onStart();
    }

    public final int F() {
        return this.h;
    }

    public static void o(Map r4) {
        if (TextUtils.equals((CharSequence) r4.get("tab_name"), "粉丝团") == false) goto L35;
        com.bytedance.android.live.profit.fansclub.o r0 = yt0.c.c();
        Long r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r0.getProfile();
        if (r2 == null) goto L11;
        com.bytedance.android.live.profit.fansclub.g r3 = (com.bytedance.android.live.profit.fansclub.g) r2.getValue();
        if (r3 == null) goto L11;
        com.bytedance.android.live.profit.fansclub.b r5 = r3.a;
    L12:
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.b);
    L15:
        r4.put("fans_level", String.valueOf(r6));
        if (r5 == null) goto L22;
        com.bytedance.android.live.profit.fansclub.j r7 = r5.c;
        if (r7 == null) goto L22;
        FansClubUserStatus r8 = r7.a;
        if (r8 == null) goto L22;
        Integer r9 = Integer.valueOf(r8.getValue());
    L23:
        r4.put("fans_status", String.valueOf(r9));
        if (r5 == null) goto L26;
        com.bytedance.android.live.profit.fansclub.m r10 = r5.e;
    L27:
        if (r10 == null) goto L29;
        String r11 = r10.a();
    L30:
        r4.put("star_status", r11);
        if (r10 == null) goto L33;
        r1 = Long.valueOf(r10.d);
    L33:
        r4.put("star_expire_date", String.valueOf(r1));
        return;
    L29:
        r11 = "nonactivated";
        goto L30
    L26:
        r10 = null;
    L22:
        r9 = null;
        goto L23
    L14:
        r6 = null;
    L11:
        r5 = null;
        goto L12
    }

    public static List y(List r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L8;
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r0.add(Integer.valueOf((int) ((com.bytedance.android.livesdk.gift.model.e3) r4.next()).getPluginId()));
    L8:
        return r0;
    }

    public final String I(String r4) {
        String r0 = this.o.getRoom().getAnchorId();
        if (r0 != null) goto L6;
        r0 = BuildConfig.FLAVOR;
    L6:
        if (Intrinsics.areEqual(r4, r0) == false) goto L10;
        return String.valueOf(2);
    L10:
        if (this.q.N(r4, 4) == false) goto L14;
        return String.valueOf(3);
    L14:
        if (this.q.N(r4, 2) == false) goto L18;
        return String.valueOf(4);
    L18:
        if (this.q.N(r4, 1024) == false) goto L22;
        return String.valueOf(1);
    L22:
        return String.valueOf(1);
    }

    public final String J(List<String> r3) {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (this.o.isAnchor() == false) goto L7;
        return "anchor";
    L7:
        if (((ArrayList) r3).contains(r0) == false) goto L10;
        return "guest";
    L10:
        return "user";
    }

    public final void d1(long r7) {
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Map r8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_anchor", String.valueOf(this.o.isAnchor() ? 1 : 0)), TuplesKt.to("selected_gift_id", String.valueOf(r7))});
        Intrinsics.checkNotNullParameter(r8, "map");
        r1.putAll(r8);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.DRAWER_LOG);
        ((ArrayList) r0.b).addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r11);
        ((f80.a) r11).w3("livesdk_gift_anchor_close_face_gift_effects_remind_show", r0.a, r0.b);
    }

    public final void j(Map<String, String> r3) {
        String r0 = this.d.getAnchorId();
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        r3.put("anchor_id", r0);
        r3.put("room_id", String.valueOf(this.d.getId()));
        r3.put("user_id", this.o.getUser().getIdString());
        r3.put("gift_dialog_request_id", x());
        r3.put("gift_panel_session_id", this.n.a);
        n(r3);
        Bundle r1 = this.k;
        if (r1 == null) goto L10;
        String r2 = r1.getString("gift_source");
        if (r2 == null) goto L10;
        r3.put("gift_source", r2);
    L10:
        o(r3);
    }

    public final void k(Map<String, String> r13) {
        GiftTabDataStore r0 = this.A;
        vz1.j r1 = (vz1.j) r0.h.getValue(r0, GiftTabDataStore.p[2]);
        if (r1 != null) goto L5;
    L9:
        String r2 = "guest";
        Object r3 = null;
        if (this.r.j() == false) goto L26;
        List<IBaseUser> r4 = this.r.i();
        if (r4 == null) goto L37;
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L15:
        if (r7.hasNext() == false) goto L25;
        IBaseUser r8 = (IBaseUser) r7.next();
        r5.add(r8.getIdString());
        i12.e r9 = i12.o.b();
        if (r9 == null) goto L19;
        Object r10 = com.bytedance.android.scope.m.e.d(r9, GroupLiveReceiverService.class);
    L20:
        GroupLiveReceiverService r11 = (GroupLiveReceiverService) r10;
        if (r11 == null) goto L23;
        String r14 = r11.h((IRoomBase) this.d, r8.getIdString());
    L24:
        r6.add(r14);
        goto L15
    L23:
        r14 = "guest";
        goto L24
    L19:
        r10 = null;
        goto L20
    L25:
        r13.put("to_user_id", GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        r13.put("to_user_type", GsonProtectorUtils.toJson(GsonHelper.get(), r6));
        return;
    L37:
        return;
    L26:
        String r15 = this.p.a.getIdString();
        r13.put("to_user_id", r15);
        i12.e r16 = i12.o.b();
        if (r16 == null) goto L29;
        r3 = com.bytedance.android.scope.m.e.d(r16, GroupLiveReceiverService.class);
    L29:
        GroupLiveReceiverService r17 = (GroupLiveReceiverService) r3;
        if (r17 == null) goto L32;
        r2 = r17.h((IRoomBase) this.d, r15);
    L32:
        r13.put("to_user_type", r2);
        return;
    L5:
        if (r1.b != 1) goto L9;
        if (TextUtils.isEmpty(this.z.y()) == true) goto L9;
        r13.put("cluster_name", this.z.y());
        goto L9
    }

    public final void n(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "paramMap");
        Bundle r0 = this.k;
        if (r0 == null) goto L5;
        String r1 = r0.getString("gift_show_from");
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        r4.put("gift_show_from", "default");
        return;
    L9:
        if (Intrinsics.areEqual("hourly", r1) == false) goto L11;
    L18:
        r4.put("gift_show_from", "hour_rank");
        return;
    L11:
        if (Intrinsics.areEqual("regional", r1) == true) goto L18;
        if (Intrinsics.areEqual("bottom_tab", r1) == false) goto L16;
        r4.put("gift_show_from", "icon");
        return;
    L16:
        if (r1 == null) goto L22;
        r4.put("gift_show_from", r1);
        return;
    L22:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void q(Map<String, String> r4) {
        com.bytedance.android.livesdk.revenue.service.interact.d r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        r4.put("live_type", r0.getLiveTypeForLog());
        r4.put("function_type", r0.getCurrentFunctionType());
        r4.put("function_type2", r0.getFunctionTypeForLog());
        List<IBaseUser> r1 = this.q.k().a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((IBaseUser) r3.next()).getIdString());
        goto L4
    L6:
        r4.put("user_type", J(r2));
    }

    public final void s1(int r1) {
        this.h = r1;
    }

    public static Map E(long r2, int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r2));
        if (r4 != 1) goto L5;
        String r3 = "locked";
    L12:
        r0.put("mission_type", r3);
        return r0;
    L5:
        if (r4 != 2) goto L7;
        r3 = "process";
        goto L12
    L7:
        if (r4 == 3) goto L9;
        r3 = BuildConfig.FLAVOR;
        goto L12
    L9:
        r3 = com.bytedance.android.livesdk.gift.model.q.UNLOCKED;
        goto L12
    }

    public static void m1(String r3, Map r4) {
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.LIVE_SHARE_LOG);
        r5.b(LogCommon.ROOM);
        r5.b(LogCommon.RECOMMEND_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r6 = r5.a;
        ArrayList r7 = (ArrayList) r6;
        r7.add(r2.a);
        List r8 = r0.b;
        ArrayList r9 = (ArrayList) r8;
        r9.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r10 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r11 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r11);
        ((f80.a) r11).w3(r3, r0.a, r0.b);
    }

    public final void R(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "buttonType");
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("tab_location", String.valueOf(r5 + 1));
        r0[1] = TuplesKt.to("gift_panel_session_id", this.n.a);
        r0[2] = TuplesKt.to("button_type", r6);
        if (this.o.isAnchor() == false) goto L5;
        String r7 = "1";
    L6:
        r0[3] = TuplesKt.to("is_anchor", r7);
        Map<String, String> r8 = MapsKt.mutableMapOf(r0);
        j(r8);
        i12.e r9 = i12.o.b();
        if (r9 == null) goto L9;
        Object r10 = com.bytedance.android.scope.m.e.d(r9, f1.class);
    L10:
        f1 r11 = (f1) r10;
        if (r11 == null) goto L15;
        String r13 = r11.d();
        if (r13 == null) goto L15;
        r8.put("room_live_scene", r13);
    L15:
        i12.e r14 = i12.o.b();
        if (r14 == null) goto L18;
        Object r15 = com.bytedance.android.scope.m.e.d(r14, GroupLiveReceiverService.class);
    L19:
        GroupLiveReceiverService r16 = (GroupLiveReceiverService) r15;
        if (r16 == null) goto L25;
        String r2 = this.p.a.getIdString();
        if (r2 != null) goto L24;
        r2 = BuildConfig.FLAVOR;
    L24:
        r16.a(r8, r2, null);
    L25:
        p1("livesdk_gift_frequently_used_panel_click", r8, true);
        return;
    L18:
        r15 = null;
        goto L19
    L9:
        r10 = null;
        goto L10
    L5:
        r7 = "0";
        goto L6
    }

    public final void Y(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("user_id", r3);
        r0.put("fansclub_status", String.valueOf(r4));
        p1("gift_panel_fans_club_bar_show", r0, true);
    }

    public final String t1(ReceiverType r2, IBaseUser r3) {
        if (iy0.e.b(this.o.getRoom()) == true) goto L5;
        int r4 = v1.a[r2.ordinal()];
        if (r4 != 1) goto L9;
        return "anchor";
    L9:
        if (r4 != 2) goto L11;
        return "guest";
    L11:
        if (r4 != 3) goto L13;
        return "audience";
    L13:
        if (r4 == 4) goto L15;
        return "undefined";
    L15:
        return "other_anchor";
    L5:
        return this.w.g(r3.getIdString());
    }

    public final void J0(int r4, int r5, Map<String, String> r6) {
        Map<String, String> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("user_id", s().toString()), TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r5))});
        if (tz1.a.d(r5) == false) goto L5;
        r0.put("order_type", tz1.a.a(r4));
    L5:
        if (r6 == null) goto L7;
        r0.putAll(r6);
    L7:
        p1("livesdk_gift_order_click", r0, true);
    }

    public final void L(String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "counterArea");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        String r2 = this.d.getIdStr().toString();
        Intrinsics.checkNotNullParameter("room_id", "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        r1.put("room_id", r2);
        String r3 = this.d.getAnchorId();
        if (r3 != null) goto L5;
        r3 = BuildConfig.FLAVOR;
    L5:
        Intrinsics.checkNotNullParameter("anchor_id", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.put("anchor_id", r3);
        Intrinsics.checkNotNullParameter("gift_area", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.put("gift_area", r7);
        String r10 = String.valueOf(r8);
        Intrinsics.checkNotNullParameter("gift_cnt", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r1.put("gift_cnt", r10);
        String r11 = String.valueOf(r9);
        Intrinsics.checkNotNullParameter("gift_area_rank", "key");
        Intrinsics.checkNotNullParameter(r11, "value");
        r1.put("gift_area_rank", r11);
        mz0.m r13 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r14 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r14, "pageSourceLog");
        List r15 = r13.a;
        ArrayList r16 = (ArrayList) r15;
        r16.add(r14.a);
        r13.b(LogCommon.ROOM);
        List r17 = r0.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((f80.a) r20).w3("livesdk_gift_area_more_click", r0.a, r0.b);
    }

    public final void L0(String r6, int r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k.class);
    L6:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.k) r1;
        if (r2 == null) goto L9;
        int r3 = r2.c();
    L11:
        if (Intrinsics.areEqual(r6, this.d.getAnchorId()) == false) goto L13;
        String r4 = "anchor";
    L14:
        String r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r3);
        if (r6 == null) goto L32;
        HashMap r9 = new HashMap();
        r9.put("to_user_id", r6);
        r9.put("send_user_count", String.valueOf(r7));
        r9.put("send_gift_scene", r5);
        r9.put("to_user_type", r4);
        r9.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        if ((!this.q.o(1024).a.isEmpty()) == false) goto L19;
        String r10 = "shortcut";
    L20:
        r9.put("entrance_type", r10);
        i12.e r11 = i12.o.b();
        if (r11 == null) goto L23;
        Object r13 = com.bytedance.android.scope.m.e.d(r11, GroupLiveReceiverService.class);
    L24:
        GroupLiveReceiverService r14 = (GroupLiveReceiverService) r13;
        if (r14 == null) goto L27;
        r14.a(r9, r6, null);
    L27:
        r9.put("gift_panel_session_id", this.n.a);
        r9.put("gift_dialog_request_id", x());
        if (r8 == null) goto L30;
        r9.putAll(r8);
    L30:
        mz0.n r15 = new mz0.n();
        Map r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r16.putAll(r9);
        mz0.m r17 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r18 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r18, "pageSourceLog");
        ((ArrayList) r17.a).add(r18.a);
        r17.b(LogCommon.ROOM);
        ((ArrayList) r15.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((f80.a) r20).w3("livesdk_gift_show_send_show", r15.a, r15.b);
        return;
    L23:
        r13 = null;
        goto L24
    L19:
        r10 = "no_shortcut";
        goto L20
    L32:
        return;
    L13:
        r4 = "guest";
        goto L14
    L9:
        r3 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void S(String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "giftAreaName");
        mz0.n r0 = new mz0.n();
        mz0.o r1 = new mz0.o(r0.a);
        r1.a("room_id", this.d.getIdStr().toString());
        String r2 = this.d.getAnchorId();
        if (r2 != null) goto L5;
        r2 = BuildConfig.FLAVOR;
    L5:
        r1.a("anchor_id", r2);
        r1.a("user_id", s());
        r1.a("gift_area", r5);
        r1.a("gift_cnt", String.valueOf(r6));
        r1.a("gift_area_rank", String.valueOf(r7));
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r10 = r8.a;
        ArrayList r11 = (ArrayList) r10;
        r11.add(r9.a);
        r8.b(LogCommon.ROOM);
        List r13 = r0.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_gift_area_show", r0.a, r0.b);
    }

    public final void T0(int r3, long r4, Map<String, String> r6) {
        HashMap r0 = new HashMap();
        r0.put("diamond_balance", String.valueOf(r4));
        j(r0);
        if (r6 == null) goto L6;
        r0.putAll(r6);
    L6:
        if (r3 == 1) goto L8;
        String r5 = "livesdk_gift_panel_recharge_entrance_show";
    L9:
        p1(r5, r0, true);
        return;
    L8:
        r5 = "livesdk_gift_panel_recharge_entrance_click";
        goto L9
    }

    public final void X(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "isVS");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("user_id", r3);
        r0.put("is_vs", r4);
        r0.put("fansclub_status", String.valueOf(r5));
        p1("gift_panel_fans_club_bar_click", r0, true);
    }

    public final void l1(boolean r4, Map<String, String> r5, long r6) {
        if (r4 == false) goto L5;
        r5.put("is_prop", "2");
        r5.put("gift_id", String.valueOf(r6));
        return;
    L5:
        r5.put("is_prop", "1");
        com.bytedance.android.livesdk.gift.model.l2 r7 = this.s.f(Long.valueOf(r6));
        if (r7 == null) goto L11;
        com.bytedance.android.livesdk.gift.model.h1 r1 = r7.getGift();
        if (r1 == null) goto L11;
        String r2 = String.valueOf(r1.getId());
        if (r2 == null) goto L11;
    L12:
        r5.put("gift_id", r2);
        r5.put("prop_id", String.valueOf(r6));
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.getPropType() != 5) goto L20;
        r5.put("recharge_vou_type", "cashback_coupon");
        return;
    L20:
        return;
    L11:
        r2 = "0";
        goto L12
    }

    public final void p1(String r2, Map<String, String> r3, boolean r4) {
        j(r3);
        if (r4 == true) goto L6;
        m1(r2, r3);
        return;
    L6:
        new Handler(Looper.getMainLooper()).post(new c(this, r2, r3));
    }

    public final void K0(int r3, long r4, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "confirmType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r4));
        if (r6 != 1) goto L5;
        String r5 = "1";
    L9:
        r0.put("business_type", r5);
        if (r3 != 1) goto L12;
        String r8 = "livesdk_gift_tab_popup_show";
    L13:
        p1(r8, r0, true);
        return;
    L12:
        r0.put("confirm_type", r7);
        r8 = "livesdk_gift_tab_popup_click";
        goto L13
    L5:
        if (r6 == 2) goto L7;
        r5 = "0";
        goto L9
    L7:
        r5 = "2";
        goto L9
    }

    public final void N(vz1.e r8, int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "dialogIconModel");
        Intrinsics.checkNotNullParameter(r11, "buttonType");
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<Integer> r2 = r0.getCurrentSelectedGiftPosition();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        Pair[] r5 = new Pair[10];
        r5[0] = TuplesKt.to("gift_id", String.valueOf(r8.a.getId()));
        r5[1] = TuplesKt.to("gift_price", String.valueOf(r8.a.getDiamondCount()));
        r5[2] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r10));
        r5[3] = TuplesKt.to("tab_location", String.valueOf(r9 + 1));
        int r6 = (r4 + 1) - 1;
        r5[4] = TuplesKt.to("gift_column_location", String.valueOf((r6 % 4) + 1));
        r5[5] = TuplesKt.to("gift_row_location", String.valueOf((r6 / 4) + 1));
        r5[6] = TuplesKt.to("gift_panel_session_id", this.n.a);
        r5[7] = TuplesKt.to("button_type", r11);
        com.bytedance.android.livesdk.gift.platform.core.model.k r13 = r8.x;
        if (r13 == null) goto L13;
        int r14 = r13.a;
    L14:
        r5[8] = TuplesKt.to("gift_position", String.valueOf(r14));
        String r15 = "1";
        if (this.o.isAnchor() == false) goto L17;
        Object r16 = "1";
    L18:
        r5[9] = TuplesKt.to("is_anchor", r16);
        Map<String, String> r17 = MapsKt.mutableMapOf(r5);
        com.bytedance.android.livesdk.gift.model.k0 r7 = r8.a.getGiftPreviewInfo();
        if (r7 != null) goto L21;
    L23:
        if (r1 == true) goto L26;
        r15 = "0";
    L26:
        r17.put("gift_unlock_status", r15);
        j(r17);
        i12.e r18 = i12.o.b();
        if (r18 == null) goto L29;
        Object r19 = com.bytedance.android.scope.m.e.d(r18, f1.class);
    L30:
        f1 r110 = (f1) r19;
        if (r110 == null) goto L38;
        String r20 = r110.d();
        if (r20 == null) goto L35;
        r17.put("room_live_scene", r20);
    L35:
        String r21 = r110.c(r8.a.getId());
        if (r21 == null) goto L38;
        r17.put("buff_strategy", r21);
    L38:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L41;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, GroupLiveReceiverService.class);
    L42:
        GroupLiveReceiverService r25 = (GroupLiveReceiverService) r24;
        if (r25 == null) goto L48;
        String r111 = this.p.a.getIdString();
        if (r111 != null) goto L47;
        r111 = BuildConfig.FLAVOR;
    L47:
        r25.a(r17, r111, null);
    L48:
        p1("livesdk_gift_frequently_used_button_click", r17, true);
        return;
    L41:
        r24 = null;
        goto L42
    L29:
        r19 = null;
        goto L30
    L21:
        if (r7.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L23;
        r1 = true;
        goto L23
    L17:
        r16 = "0";
        goto L18
    L13:
        r14 = -1;
    L9:
        r4 = 0;
        goto L10
    }

    public final void N0(int r3, String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r4, "desc");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("cards_left", String.valueOf(r3));
        r0.put("cards_time", r4);
        r0.put("prop_def_type", String.valueOf(r5));
        if (r5 != 4) goto L5;
        r0.put("prop_def_sub_type", String.valueOf(r7));
    L5:
        p1("popular_card_show", r0, true);
    }

    public final void Y0(vz1.e r8, int r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "dialogIconModel");
        Intrinsics.checkNotNullParameter(r11, "buttonType");
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<Integer> r2 = r0.getCurrentSelectedGiftPosition();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        Pair[] r5 = new Pair[10];
        r5[0] = TuplesKt.to("gift_id", String.valueOf(r8.a.getId()));
        r5[1] = TuplesKt.to("gift_price", String.valueOf(r8.a.getDiamondCount()));
        r5[2] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r10));
        r5[3] = TuplesKt.to("tab_location", String.valueOf(r9 + 1));
        int r6 = (r4 + 1) - 1;
        r5[4] = TuplesKt.to("gift_column_location", String.valueOf((r6 % 4) + 1));
        r5[5] = TuplesKt.to("gift_row_location", String.valueOf((r6 / 4) + 1));
        r5[6] = TuplesKt.to("gift_panel_session_id", this.n.a);
        r5[7] = TuplesKt.to("button_type", r11);
        com.bytedance.android.livesdk.gift.platform.core.model.k r13 = r8.x;
        if (r13 == null) goto L13;
        int r14 = r13.a;
    L14:
        r5[8] = TuplesKt.to("gift_position", String.valueOf(r14));
        String r15 = "1";
        if (this.o.isAnchor() == false) goto L17;
        Object r16 = "1";
    L18:
        r5[9] = TuplesKt.to("is_anchor", r16);
        Map<String, String> r17 = MapsKt.mutableMapOf(r5);
        com.bytedance.android.livesdk.gift.model.k0 r7 = r8.a.getGiftPreviewInfo();
        if (r7 != null) goto L21;
    L23:
        if (r1 == true) goto L26;
        r15 = "0";
    L26:
        r17.put("gift_unlock_status", r15);
        j(r17);
        i12.e r18 = i12.o.b();
        if (r18 == null) goto L29;
        Object r19 = com.bytedance.android.scope.m.e.d(r18, f1.class);
    L30:
        f1 r110 = (f1) r19;
        if (r110 == null) goto L38;
        String r20 = r110.d();
        if (r20 == null) goto L35;
        r17.put("room_live_scene", r20);
    L35:
        String r21 = r110.c(r8.a.getId());
        if (r21 == null) goto L38;
        r17.put("buff_strategy", r21);
    L38:
        i12.e r23 = i12.o.b();
        if (r23 == null) goto L41;
        Object r24 = com.bytedance.android.scope.m.e.d(r23, GroupLiveReceiverService.class);
    L42:
        GroupLiveReceiverService r25 = (GroupLiveReceiverService) r24;
        if (r25 == null) goto L48;
        String r111 = this.p.a.getIdString();
        if (r111 != null) goto L47;
        r111 = BuildConfig.FLAVOR;
    L47:
        r25.a(r17, r111, null);
    L48:
        p1("livesdk_gift_frequently_used_button_show", r17, true);
        return;
    L41:
        r24 = null;
        goto L42
    L29:
        r19 = null;
        goto L30
    L21:
        if (r7.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L23;
        r1 = true;
        goto L23
    L17:
        r16 = "0";
        goto L18
    L13:
        r14 = -1;
    L9:
        r4 = 0;
        goto L10
    }

    public final void h1(long r5, int r7, int r8, int r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r5));
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r6 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r10 = r6.getGiftListResultLogId();
        if (r10 == null) goto L8;
        String r11 = (String) r10.getValue();
        if (r11 == null) goto L8;
    L9:
        r0.put("gift_dialog_request_id", r11);
        r0.put("tab_location", String.valueOf(r8 + 1));
        int r13 = r7 + 1;
        int r14 = r13 % 8;
        if (r14 != 0) goto L12;
        int r1 = 0;
    L13:
        r0.put("page_location", String.valueOf((r13 / 8) + r1));
        int[] r15 = this.e;
        if (r1 != 0) goto L16;
        r14 = 8;
    L16:
        r0.put("gift_location", String.valueOf(r15[r14]));
        r0.put("gift_row_location", String.valueOf((r7 / 4) + 1));
        r0.put("gift_column_location", String.valueOf((r7 % 4) + 1));
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r9));
        p1("livesdk_giftgroup_show", r0, true);
        return;
    L12:
        r1 = 1;
    L8:
        r11 = BuildConfig.FLAVOR;
        goto L9
    }

    public static void i(Map r7, GiftPanelIconSource r8, String r9, List r10, CardType r11) {
        List r0 = r10;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r4 = "1";
        if (r3 == false) goto L12;
        Object r5 = "1";
    L13:
        r7.put("base_icon", r5);
        if (r8 != GiftPanelIconSource.DIY_CARD) goto L16;
    L27:
        String r13 = "operation";
    L28:
        r7.put("icon_source", r13);
        if (r0 != null) goto L31;
    L34:
        boolean r14 = true;
    L35:
        if (r14 == true) goto L41;
        int r15 = v1.b[r11.ordinal()];
        if (r15 != 1) goto L40;
    L43:
        r7.put("customize", r4);
        String r16 = "null";
        if (r9 != null) goto L46;
        r9 = "null";
    L46:
        r7.put("card_name", r9);
        if (r0 != null) goto L49;
    L50:
        r1 = true;
    L51:
        if (r1 == true) goto L54;
        r16 = y(r10).toString();
    L54:
        r7.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r16);
        return;
    L49:
        if (r0.isEmpty() == false) goto L51;
    L40:
        if (r15 != 2) goto L41;
        r4 = "2";
    L41:
        r4 = "0";
        goto L43
    L31:
        if (r0.isEmpty() == true) goto L34;
        r14 = false;
        goto L35
    L16:
        if (r8 == GiftPanelIconSource.BUFF_CARD) goto L27;
        if (r0 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == false) goto L26;
        r13 = "base";
        goto L28
    L26:
        r13 = "last";
        goto L28
    L20:
        if (r0.isEmpty() == true) goto L23;
        r17 = false;
        goto L24
    L12:
        r5 = "0";
        goto L13
    L5:
        if (r0.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void b0(vz1.e r5, com.bytedance.android.livesdk.gift.model.l1 r6, boolean r7, int r8, boolean r9, int r10) {
        Intrinsics.checkNotNullParameter(r5, "curGift");
        Intrinsics.checkNotNullParameter(r6, "buffGift");
        Pair[] r0 = new Pair[10];
        r0[0] = TuplesKt.to("origin_gift_id", String.valueOf(r5.b));
        r0[1] = TuplesKt.to("gift_price", String.valueOf(r5.a.getDiamondCount()));
        r0[2] = TuplesKt.to("gift_buff_id", String.valueOf(r6.getBuffGiftId()));
        r0[3] = TuplesKt.to("gift_buff_price", String.valueOf(r6.getBuffDiamondCount()));
        String r11 = "1";
        if (r9 == false) goto L5;
        Object r13 = "1";
    L6:
        r0[4] = TuplesKt.to("gift_buff_unlock_type", r13);
        r0[5] = TuplesKt.to("card_location", String.valueOf(r10 + 1));
        com.bytedance.android.livesdk.gift.model.h2 r14 = GiftManagerKt.l(r6.getBuffGiftId());
        if (r14 == null) goto L10;
        String r15 = r14.getName();
        if (r15 == null) goto L10;
    L11:
        r0[6] = TuplesKt.to("card_name", r15);
        r0[7] = TuplesKt.to("chosen_type", String.valueOf(r8));
        if (r7 == false) goto L14;
        r11 = "0";
    L14:
        r0[8] = TuplesKt.to("gift_buff_click_type", r11);
        r0[9] = TuplesKt.to("tag_type", "null");
        p1("gift_buff_click", MapsKt.mutableMapOf(r0), true);
        return;
    L10:
        r15 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r13 = "0";
        goto L6
    }

    public final void X0(IRoom r5, int r6, long r7, boolean r9, int r10, int r11, vz1.e r13) {
        Intrinsics.checkNotNullParameter(r13, "iconModel");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 == null) goto L8;
        String r2 = r5.getAnchorId();
        if (r2 != null) goto L7;
        r2 = BuildConfig.FLAVOR;
    L7:
        r0.put("anchor_id", r2);
        r0.put("room_id", String.valueOf(r5.getId()));
    L8:
        if (r9 == false) goto L10;
        String r8 = "prop";
    L11:
        r0.put("type", r8);
        r0.put("id", String.valueOf(r7));
        r0.put("group_cnt", String.valueOf(r6));
        p1("group_cnt_click", r0, true);
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        int r15 = 0;
        if (r14 == null) goto L18;
        com.bytedance.live.datacontext.n<Integer> r16 = r14.getCurrentSelectedGiftPosition();
        if (r16 == null) goto L18;
        Integer r17 = (Integer) r16.getValue();
        if (r17 == null) goto L18;
        int r18 = r17.intValue();
    L19:
        int r19 = r18 + 1;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r10));
        r1.put("tab_location", String.valueOf(r11 + 1));
        r1.put("gift_id", String.valueOf(r7));
        if ((r19 % 8) == 0) goto L23;
        r15 = 1;
    L23:
        r1.put("page_location", String.valueOf((r19 / 8) + r15));
        int r20 = r19 - 1;
        r1.put("gift_row_location", String.valueOf((r20 / 4) + 1));
        r1.put("gift_column_location", String.valueOf((r20 % 4) + 1));
        GiftContext r21 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r21 == null) goto L29;
        com.bytedance.live.datacontext.m<String> r23 = r21.getGiftListResultLogId();
        if (r23 == null) goto L29;
        String r24 = (String) r23.getValue();
        if (r24 == null) goto L29;
    L30:
        r1.put("gift_dialog_request_id", r24);
        r1.put("gift_panel_session_id", this.n.a);
        com.bytedance.android.livesdk.gift.platform.core.model.a r25 = r13.z;
        if (r25 == null) goto L34;
        String r26 = r25.b;
        if (r26 == null) goto L34;
    L35:
        r1.put("strategy_scene", r26);
        com.bytedance.android.livesdk.gift.platform.core.model.a r27 = r13.z;
        if (r27 == null) goto L39;
        String r28 = r27.a;
        if (r28 == null) goto L39;
    L40:
        r1.put("strategy_slice_id", r28);
        com.bytedance.android.livesdk.gift.platform.core.model.a r29 = r13.z;
        if (r29 == null) goto L44;
        String r30 = r29.c;
        if (r30 == null) goto L44;
    L45:
        r1.put("strategy_insert_status", r30);
        this.v.getClass();
        r1.put("room_live_scene", BuildConfig.FLAVOR);
        r1.put("to_user_id", this.p.a.getIdString());
        r1.put("to_user_type", t1(this.q.R(this.p.a), this.p.a));
        k(r1);
        p1("livesdk_giftgroup_click", r1, true);
        return;
    L44:
        r30 = GiftInsertStatus.NOT_STRATEGY;
    L39:
        r28 = BuildConfig.FLAVOR;
    L34:
        r26 = BuildConfig.FLAVOR;
    L29:
        r24 = BuildConfig.FLAVOR;
    L18:
        r18 = 0;
        goto L19
    L10:
        r8 = "gift";
        goto L11
    }

    public static /* synthetic */ void j0(u1 r13, long r14, String r15, int r16, int r17, int r18, int r19, vz1.e r20) {
        r13.f0(r14, r15, r16, r17, r18, r19, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, r20);
    }

    public final void e1(int r5, int r6, String r7, String r8, IRoom r9, boolean r10, String r11, Map r13) {
        Intrinsics.checkNotNullParameter(r7, "showType");
        Intrinsics.checkNotNullParameter(r8, "toUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r0, "$this$addTabExtraInfo");
        String r1 = (String) ((LinkedHashMap) this.a).get("red_dot");
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0.put("red_dot", r1);
        Intrinsics.checkNotNullParameter(r0, "$this$addTabLocationInfo");
        String r2 = (String) ((LinkedHashMap) this.a).get("tab_location");
        if (r2 != null) goto L8;
        r2 = BuildConfig.FLAVOR;
    L8:
        r0.put("tab_location", r2);
        String r3 = (String) ((LinkedHashMap) this.a).get("from_tab_name");
        if (r3 != null) goto L11;
        r3 = BuildConfig.FLAVOR;
    L11:
        r0.put("from_tab_name", r3);
        String r4 = (String) ((LinkedHashMap) this.a).get("from_tab_location");
        if (r4 != null) goto L14;
        r4 = BuildConfig.FLAVOR;
    L14:
        r0.put("from_tab_location", r4);
        String r14 = (String) ((LinkedHashMap) this.a).get("tab_gift_cnt");
        if (r14 != null) goto L17;
        r14 = BuildConfig.FLAVOR;
    L17:
        r0.put("tab_gift_cnt", r14);
        r0.put("gift_tab_from", String.valueOf(r5));
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r5));
        r0.put("tab_show_type", r7);
        r0.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a()));
        String r15 = "0";
        if (r9 == null) goto L21;
        String r16 = r9.getAnchorId();
        if (r16 == null) goto L21;
    L23:
        if ((!Intrinsics.areEqual(r8, r16)) == false) goto L25;
        String r17 = "guest";
    L26:
        r0.put("to_user_type", r17);
        r0.put("connection_type", w());
        r0.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (r10 == false) goto L29;
        r15 = "1";
    L29:
        r0.put("is_prop_show", r15);
        a(r0);
        if (r5 == r6) goto L32;
        String r18 = "change";
    L43:
        r0.put("click_type", r18);
        if (r11 != null) goto L46;
        r11 = BuildConfig.FLAVOR;
    L46:
        r0.put("sub_tab_name", r11);
        r0.put("gift_panel_session_id", this.n.a);
        r0.putAll(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService().q());
        if (r13 == null) goto L50;
        r0.putAll(r13);
    L50:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L52;
        p1("gift_panel_subtab_click", r0, true);
        return;
    L52:
        p1("livesdk_gift_tab_click", r0, true);
        return;
    L32:
        List r19 = (List) this.z.S().getSecond();
        if (r19 == null) goto L35;
        Integer r20 = Integer.valueOf(r19.size());
    L37:
        if (r20.intValue() > 0) goto L39;
        r18 = "stay";
        goto L43
    L39:
        if (this.z.U() == false) goto L41;
        r18 = "expand";
        goto L43
    L41:
        r18 = "fold";
        goto L43
    L35:
        r20 = null;
        goto L37
    L25:
        r17 = "anchor";
    L21:
        r16 = "0";
        goto L23
    }

    public static /* synthetic */ void f1(u1 r10, int r11, int r13, String r14, String r15, IRoom r16, boolean r17, String r18, int r19) {
        if ((r19 & 128) == 0) goto L5;
        String r8 = BuildConfig.FLAVOR;
    L6:
        r10.e1(r11, r13, r14, r15, r16, r17, r8, null);
        return;
    L5:
        r8 = r18;
        goto L6
    }

    public final void y0(long r17, boolean r19, int r20, int r21, int r23, boolean r24, long r25, long r26, int r28) {
        if (r17 > 0) goto L5;
        return;
    L5:
        String r3 = s();
        int r4 = r23 + 1;
        int r5 = r4 % 8;
        if (r5 != 0) goto L8;
        int r8 = 0;
    L10:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == false) goto L12;
        int r9 = r23 / 4;
    L13:
        int r10 = r9 + 1;
        int r11 = (r23 % 4) + 1;
        String r13 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
        String r14 = ay1.b.l().get(String.valueOf(r17));
        int r15 = x12.b.a();
        Pair[] r16 = new Pair[12];
        r16[0] = TuplesKt.to("user_id", r3.toString());
        r16[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r20));
        r16[2] = TuplesKt.to("tab_location", String.valueOf(r21 + 1));
        r16[3] = TuplesKt.to("page_location", String.valueOf((r4 / 8) + r8));
        int[] r6 = this.e;
        if (r8 != 0) goto L16;
        r5 = 8;
    L16:
        r16[4] = TuplesKt.to("gift_location", String.valueOf(r6[r5]));
        if (r24 == false) goto L19;
        String r7 = "light_sweep";
    L20:
        r16[5] = TuplesKt.to("show_mode", r7);
        r16[6] = TuplesKt.to("gift_row_location", String.valueOf(r10));
        r16[7] = TuplesKt.to("gift_column_location", String.valueOf(r11));
        r16[8] = TuplesKt.to("show_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r15));
        r16[9] = TuplesKt.to("appear_time", String.valueOf(r25));
        r16[10] = TuplesKt.to("disappear_time", String.valueOf(r26));
        r16[11] = TuplesKt.to("time_interval", String.valueOf(r26 - r25));
        Map<String, String> r18 = MapsKt.mutableMapOf(r16);
        if (tz1.a.d(r20) == false) goto L23;
        r18.put("order_type", tz1.a.a(r28));
    L23:
        GiftManagerKt.z.getClass();
        Map r27 = GiftManagerKt.o();
        if (r27 != null) goto L26;
    L29:
        boolean r29 = true;
    L30:
        if (r29 == true) goto L35;
        Map<? extends String, ? extends String> r30 = GiftManagerKt.o();
        if (r30 == null) goto L35;
        r18.putAll(r30);
    L35:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L37;
        String r31 = "scroll";
    L38:
        r18.put("gift_show_type", r31);
        if (r14 == null) goto L41;
        r18.put("light_sweep_cnt", r14);
    L41:
        l1(r19, r18, r17);
        p1("livesdk_distinct_gift_show_for_strategy", r18, true);
        return;
    L37:
        r31 = "slide";
        goto L38
    L26:
        if (r27.isEmpty() == true) goto L29;
        r29 = false;
        goto L30
    L19:
        r7 = "normal";
        goto L20
    L12:
        r9 = (r23 % 8) / 4;
        goto L13
    L8:
        r8 = 1;
        goto L10
    }

    public final void e0(DataCenter r20, IRoom r21, String r23, int r24, boolean r25, long r26, int r27, boolean r28, Map<String, String> r29, int r30) {
        Iterator r3 = da0.a.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ca0.p) r3.next()).u();
        goto L4
    L6:
        HashMap r4 = new HashMap();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.n<Bundle> r6 = r5.getGiftLogExtra();
        if (r6 == null) goto L11;
        Bundle r7 = (Bundle) r6.getValue();
    L12:
        if (r7 == null) goto L35;
        Iterator<String> r8 = r7.keySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L35;
        String r9 = r8.next();
        Object r10 = r7.get(r9);
        if ((r10 instanceof Boolean) == true) goto L34;
        if ((r10 instanceof Byte) == true) goto L34;
        if ((r10 instanceof Character) == true) goto L34;
        if ((r10 instanceof Double) == true) goto L34;
        if ((r10 instanceof Float) == true) goto L34;
        if ((r10 instanceof Integer) == true) goto L34;
        if ((r10 instanceof Long) == true) goto L34;
        if ((r10 instanceof Short) == true) goto L34;
        if ((r10 instanceof String) == false) goto L15;
    L34:
        r4.put(r9, r10.toString());
    L35:
        r4.put("gift_cnt", String.valueOf(r30));
        if (r20 == null) goto L38;
        Boolean r11 = (Boolean) r20.get("data_is_portrait", Boolean.TRUE);
    L39:
        Boolean r13 = Boolean.TRUE;
        String r14 = "0";
        if (Intrinsics.areEqual(r11, r13) == false) goto L42;
        Object r15 = "0";
    L43:
        r4.put("room_orientation", r15);
        r4.put("to_user_id", String.valueOf(r23));
        int r16 = x12.b.a();
        r4.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r16));
        com.bytedance.android.livesdk.revenue.service.microom.a r17 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.microom.a.class);
        if (r17.isMicRoom(r21) == false) goto L62;
        com.bytedance.android.livesdk.revenue.service.interact.d r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r23 != null) goto L48;
        String r19 = BuildConfig.FLAVOR;
    L50:
        if (r18.isMicRoomHost(r19) == false) goto L62;
        if (r20 == null) goto L53;
        Boolean r110 = (Boolean) r20.get("data_is_anchor", Boolean.FALSE);
    L55:
        if (Intrinsics.areEqual(r110, r13) == false) goto L58;
        String r31 = "carousel_anchor_c_carousel_host";
    L61:
        r4.put("carousel_action_type", r31);
        goto L62
    L58:
        if (r17.isLoyalAudience() == false) goto L60;
        r31 = "loyal_audience_c_carousel_host";
        goto L61
    L60:
        r31 = "carousel_audience_c_carousel_host";
        goto L61
    L53:
        r110 = null;
        goto L55
    L48:
        r19 = r23;
    L62:
        r4.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r24));
        r4.put("tab_location", String.valueOf(r27 + 1));
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L67;
        com.bytedance.live.datacontext.n<Integer> r112 = r111.getCurrentSelectedGiftPosition();
        if (r112 == null) goto L67;
        Integer r113 = (Integer) r112.getValue();
    L69:
        if (r113 != null) goto L71;
        r113 = 0;
    L71:
        Integer r114 = Integer.valueOf(r113.intValue() + 1);
        int r115 = 8;
        if ((r114.intValue() % 8) != 0) goto L74;
        int r116 = 0;
    L75:
        r4.put("page_location", String.valueOf((r114.intValue() / 8) + r116));
        int[] r117 = this.e;
        if (r116 == 0) goto L79;
        r115 = r114.intValue() % 8;
    L79:
        r4.put("gift_location", String.valueOf(r117[r115]));
        r4.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (r25 == false) goto L82;
        Object r118 = "1";
    L83:
        r4.put("is_prop_show", r118);
        a(r4);
        r4.put("gift_id", String.valueOf(r26));
        int r119 = x12.b.a();
        r4.put("gift_show_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r119));
        r4.put("to_user_status", I(this.p.a.getIdString()));
        Iterator r120 = ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).N3().c.iterator();
    L85:
        if (r120.hasNext() == false) goto L93;
        Object r121 = r120.next();
        Iterator r210 = r120;
        String r122 = r14;
        if (((com.bytedance.android.livesdk.gift.model.w1) r121).getPageType() != 17) goto L89;
        boolean r123 = true;
    L90:
        if (r123 == true) goto L94;
        r120 = r210;
        r14 = r122;
    L94:
        if (r121 == null) goto L96;
        String r124 = "1";
    L97:
        r4.put("is_mostly_use_tab_exists", r124);
        HashMap r125 = vh6.c.b(er2.b.class).Z6();
        if (r125 == null) goto L105;
        Iterator r126 = r125.entrySet().iterator();
    L101:
        if (r126.hasNext() == false) goto L105;
        Map.Entry r127 = (Map.Entry) r126.next();
        if (r4.containsKey(r127.getKey()) == true) goto L101;
        r4.put(r127.getKey(), r127.getValue());
    L105:
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r4);
        r4.put("is_screencasting", com.bytedance.android.live.core.utils.m2.b(ay1.b.p()));
        if (r29 == null) goto L109;
        r4.putAll(r29);
        Unit r2 = Unit.INSTANCE;
    L109:
        if (r7 == null) goto L111;
        String r128 = r7.getString("gift_show_from");
    L113:
        if (Intrinsics.areEqual(r128, "jsb") == true) goto L133;
        if (r7 == null) goto L116;
        String r129 = r7.getString("gift_show_from");
    L118:
        if (Intrinsics.areEqual(r129, "profile_card") == true) goto L133;
        if (r7 == null) goto L121;
        String r33 = r7.getString("gift_show_from");
    L123:
        if (Intrinsics.areEqual(r33, "emoji_panel") == true) goto L133;
        if (K() == false) goto L136;
        if (r21 == null) goto L129;
        String r34 = r21.getAnchorId();
    L131:
        if (TextUtils.equals(r23, r34) == false) goto L136;
        r4.put("group_live_to_user_st", "to_room_owner");
        goto L136
    L129:
        r34 = null;
    L136:
        r4.putAll(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService().q());
        r4.put("connection_type", w());
        if (r28 == false) goto L139;
        String r130 = "1";
    L140:
        r4.put("if_before_full_seats", r130);
        List<IBaseUser> r35 = this.q.k().a;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r37 = r35.iterator();
    L142:
        if (r37.hasNext() == false) goto L144;
        r36.add(((IBaseUser) r37.next()).getIdString());
        goto L142
    L144:
        r4.put("user_type", J(r36));
        i12.e r38 = i12.o.b();
        if (r38 == null) goto L147;
        Object r39 = com.bytedance.android.scope.m.e.d(r38, GroupLiveReceiverService.class);
    L148:
        GroupLiveReceiverService r40 = (GroupLiveReceiverService) r39;
        if (r40 == null) goto L154;
        if (r23 != null) goto L152;
        String r41 = BuildConfig.FLAVOR;
    L153:
        Boolean r131 = null;
        r40.a(r4, r41, null);
        Unit r43 = Unit.INSTANCE;
    L155:
        i12.e r44 = i12.o.b();
        if (r44 == null) goto L158;
        Object r45 = com.bytedance.android.scope.m.e.d(r44, f1.class);
    L159:
        f1 r46 = (f1) r45;
        if (r46 == null) goto L164;
        String r47 = r46.d();
        if (r47 == null) goto L164;
        r4.put("room_live_scene", r47);
        Unit r48 = Unit.INSTANCE;
    L164:
        this.v.getClass();
        r4.put("buff_strategy", BuildConfig.FLAVOR);
        r4.put("gift_panel_session_id", this.n.a);
        String r49 = this.v.g;
        if (r49 != null) goto L167;
        r49 = BuildConfig.FLAVOR;
    L167:
        r4.put("strategy_sticker_content", r49);
        r4.put("actual_sticker_content", this.y.d);
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L179;
        if (r20 == null) goto L172;
        r131 = (Boolean) r20.get("data_is_portrait", Boolean.TRUE);
    L172:
        if (Intrinsics.areEqual(r131, Boolean.TRUE) == true) goto L174;
    L178:
        p1("gift_show", r4, true);
        p1("send_gift_icon_click", new LinkedHashMap(), true);
    L205:
        if (r23 != null) goto L207;
        String r50 = BuildConfig.FLAVOR;
    L208:
        f1(this, r24, r24, "call", r50, r21, r25, null, 384);
        return;
    L207:
        r50 = r23;
        goto L208
    L174:
        if ((r114.intValue() % 4) != 0) goto L176;
        int r132 = 0;
    L177:
        r4.put("page_location", String.valueOf((r114.intValue() / 4) + r132));
        r4.put("gift_location", String.valueOf(r114.intValue()));
        goto L178
    L176:
        r132 = 1;
        goto L177
    L179:
        GiftManagerKt.z.getClass();
        Map r51 = GiftManagerKt.o();
        if (r51 != null) goto L182;
    L185:
        boolean r53 = true;
    L186:
        if (r53 == true) goto L190;
        Map r54 = GiftManagerKt.o();
        if (r54 == null) goto L190;
        r4.putAll(r54);
        Unit r55 = Unit.INSTANCE;
    L190:
        j(r4);
        if (r20 == null) goto L203;
        JsonObject r0 = (JsonObject) r20.get("data_multi_fight_profit_egg", new JsonObject());
        if (r0 == null) goto L203;
        JsonElement r1 = r0.get("log");
        if (r1 == null) goto L203;
        JsonObject r56 = r1.getAsJsonObject();
        if (r56 == null) goto L203;
        GsonMap r57 = UtilsKt.i(r56);
        LinkedHashMap r58 = new LinkedHashMap(MapsKt.mapCapacity(r57.size()));
        Iterator r59 = r57.b().iterator();
    L200:
        if (r59.hasNext() == false) goto L202;
        Map.Entry r60 = (Map.Entry) r59.next();
        r58.put(r60.getKey(), String.valueOf(r60.getValue()));
        goto L200
    L202:
        r4.putAll(r58);
        Unit r61 = Unit.INSTANCE;
    L203:
        mz0.n r63 = new mz0.n();
        Map r64 = r63.a;
        Intrinsics.checkNotNullParameter(r64, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r64.putAll(r4);
        mz0.m r65 = new mz0.m();
        r65.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r66 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r66, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_interact", "belong");
        r66.a("live_interact");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r66.c("live_detail");
        List r67 = r65.a;
        ArrayList r68 = (ArrayList) r67;
        r68.add(r66.a);
        List r69 = r63.b;
        ArrayList r70 = (ArrayList) r69;
        r70.addAll(r65.a);
        cy0.e.a.getClass();
        cy0.j r71 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r73 = com.bytedance.android.scope.m.b(r71).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r73);
        ((f80.a) r73).w3("livesdk_gift_show", r63.a, r63.b);
        goto L205
    L182:
        if (r51.isEmpty() == true) goto L185;
        r53 = false;
        goto L186
    L158:
        r45 = r131;
        goto L159
    L152:
        r41 = r23;
        goto L153
    L154:
        r131 = null;
        goto L155
    L147:
        r39 = null;
        goto L148
    L139:
        r130 = r122;
        goto L140
    L121:
        r33 = null;
        goto L123
    L116:
        r129 = null;
    L133:
        r4.put("to_user_st", "path");
        if (K() == false) goto L136;
        r4.put("group_live_to_user_st", "path");
        goto L136
    L111:
        r128 = null;
        goto L113
    L96:
        r124 = r122;
        goto L97
    L89:
        r123 = false;
        goto L90
    L93:
        r122 = r14;
        r121 = null;
        goto L94
    L82:
        r118 = "0";
        goto L83
    L74:
        r116 = 1;
    L67:
        r113 = null;
        goto L69
    L42:
        r15 = "1";
        goto L43
    L38:
        r11 = null;
    L11:
        r7 = null;
        goto L12
    }

    public final void f0(long r16, String r18, int r19, int r20, int r21, int r23, boolean r24, String r25, String r26, vz1.e r27) {
        Intrinsics.checkNotNullParameter(r18, "giftPopupType");
        Intrinsics.checkNotNullParameter(r25, "searchWord");
        Intrinsics.checkNotNullParameter(r26, "searchId");
        Intrinsics.checkNotNullParameter(r27, "iconModel");
        String r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a());
        int r11 = r21;
        if (r11 != (-1)) goto L18;
        GiftContext r13 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r13 == null) goto L11;
        com.bytedance.live.datacontext.n<Integer> r14 = r13.getCurrentSelectedGiftPosition();
        if (r14 == null) goto L11;
        Integer r15 = (Integer) r14.getValue();
        if (r15 == null) goto L11;
        int r17 = r15.intValue();
    L12:
        int r110 = r17 + 1;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == false) goto L15;
        int r111 = (r110 - 1) / 4;
    L16:
        r11 = r111 + 1;
        goto L18
    L15:
        r111 = ((r110 - 1) % 8) / 4;
    L11:
        r17 = 0;
    L18:
        if (r23 != (-1)) goto L28;
        GiftContext r112 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r112 == null) goto L26;
        com.bytedance.live.datacontext.n<Integer> r113 = r112.getCurrentSelectedGiftPosition();
        if (r113 == null) goto L26;
        Integer r114 = (Integer) r113.getValue();
        if (r114 == null) goto L26;
        int r115 = r114.intValue();
    L27:
        int r10 = (((r115 + 1) - 1) % 4) + 1;
        String r116 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
    L29:
        Pair[] r117 = new Pair[17];
        r117[0] = TuplesKt.to("gift_id", String.valueOf(r16));
        r117[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r19));
        r117[2] = TuplesKt.to("tab_location", String.valueOf(r20 + 1));
        r117[3] = TuplesKt.to("gift_row_location", String.valueOf(r11));
        r117[4] = TuplesKt.to("gift_column_location", String.valueOf(r10));
        r117[5] = TuplesKt.to("gift_popup_type", r18);
        r117[6] = TuplesKt.to("send_gift_scene", r5.toString());
        r117[7] = TuplesKt.to("gift_panel_session_id", this.n.a);
        if (r24 == false) goto L32;
        String r1 = "1";
    L33:
        r117[8] = TuplesKt.to("is_search_result", r1);
        r117[9] = TuplesKt.to("search_word", r25);
        r117[10] = TuplesKt.to("gift_panel_search_id", r26);
        this.v.getClass();
        String r2 = BuildConfig.FLAVOR;
        r117[11] = TuplesKt.to("room_live_scene", BuildConfig.FLAVOR);
        com.bytedance.android.livesdk.gift.platform.core.model.a r3 = r27.z;
        if (r3 == null) goto L37;
        String r4 = r3.b;
        if (r4 == null) goto L37;
    L38:
        r117[12] = TuplesKt.to("strategy_scene", r4);
        com.bytedance.android.livesdk.gift.platform.core.model.a r6 = r27.z;
        if (r6 == null) goto L44;
        String r7 = r6.a;
        if (r7 == null) goto L44;
        r2 = r7;
    L44:
        r117[13] = TuplesKt.to("strategy_slice_id", r2);
        com.bytedance.android.livesdk.gift.platform.core.model.a r8 = r27.z;
        if (r8 == null) goto L48;
        String r9 = r8.c;
        if (r9 == null) goto L48;
    L49:
        r117[14] = TuplesKt.to("strategy_insert_status", r9);
        r117[15] = TuplesKt.to("to_user_id", this.p.a.getIdString());
        r117[16] = TuplesKt.to("to_user_type", t1(this.q.R(this.p.a), this.p.a));
        Map<String, String> r28 = MapsKt.mutableMapOf(r117);
        k(r28);
        p1("livesdk_gift_long_click", r28, true);
        return;
    L48:
        r9 = GiftInsertStatus.NOT_STRATEGY;
    L37:
        r4 = BuildConfig.FLAVOR;
        goto L38
    L32:
        r1 = "0";
    L26:
        r115 = 0;
        goto L27
    L28:
        r10 = r23;
        goto L29
    }

    public final void U(long r9, int r11, boolean r13, int r14, long r15, List<Integer> r16, String r17, boolean r18, int r19, Map<String, String> r20, String r21, String r23) {
        Intrinsics.checkNotNullParameter(r16, "customizeItem");
        Intrinsics.checkNotNullParameter(r17, "clickType");
        Intrinsics.checkNotNullParameter(r21, "cardName");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r20);
        IRoom r5 = this.o.getRoom();
        String r6 = r5.getAnchorId();
        if (r6 != null) goto L5;
        r6 = BuildConfig.FLAVOR;
    L5:
        r4.put("anchor_id", r6);
        r4.put("room_id", String.valueOf(r5.getRoomId()));
        r4.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        r4.put("gift_id", String.valueOf(r9));
        r4.put("price", String.valueOf(r11));
        if (r13 == false) goto L8;
        String r7 = "recommend";
    L9:
        r4.put("card_type", r7);
        r4.put("card_location", String.valueOf(r14 + 1));
        r4.put("customize_item", GsonProtectorUtils.toJson(GsonHelper.get(), r16));
        r4.put("customize_price", String.valueOf(r15));
        r4.put("click_type", r17);
        r4.put("chosen_type", String.valueOf(r19));
        if (r18 == false) goto L12;
        String r1 = "2";
    L13:
        r4.put("click_method", r1);
        r4.put("card_name", r21);
        if (r23 != null) goto L16;
    L19:
        boolean r2 = true;
    L20:
        if (r2 == false) goto L22;
        String r3 = "null";
    L23:
        r4.put("tag_type", r3);
        q(r4);
        p1("customize_gift_buff_click", r4, true);
        return;
    L22:
        r3 = "countdown";
        goto L23
    L16:
        if (r23.length() == 0) goto L19;
        r2 = false;
        goto L20
    L12:
        r1 = "1";
        goto L13
    L8:
        r7 = "lately_setting";
        goto L9
    }

    public u1(Bundle r17, DataCenter r18, g1 r19, w0 r20, yz0.k r21, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r23, GiftReceiverRepoService r24, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r25, PropListService r26, GiftDataStorageService r27, t1 r28, GiftListSortDataStore r29, GroupLiveReceiverService r210, f1 r30, GiftStickerSortService r31, GiftTopicDataStore r33, GiftTabDataStore r34) {
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        Intrinsics.checkNotNullParameter(r19, "giftLogService");
        Intrinsics.checkNotNullParameter(r20, "giftPanelLogServiceKmp");
        Intrinsics.checkNotNullParameter(r21, "roomDataService");
        Intrinsics.checkNotNullParameter(r23, "receiverService");
        Intrinsics.checkNotNullParameter(r24, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r25, "allMicService");
        Intrinsics.checkNotNullParameter(r26, "propListService");
        Intrinsics.checkNotNullParameter(r27, "dataStorageService");
        Intrinsics.checkNotNullParameter(r28, "panelLogAggregationService");
        Intrinsics.checkNotNullParameter(r29, "giftPanelSortDataStore");
        Intrinsics.checkNotNullParameter(r210, "groupLiveReceiverService");
        Intrinsics.checkNotNullParameter(r30, "giftListSortService");
        Intrinsics.checkNotNullParameter(r31, "giftStickerSortService");
        Intrinsics.checkNotNullParameter(r33, "giftTopicService");
        Intrinsics.checkNotNullParameter(r34, "giftTabService");
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r23;
        this.q = r24;
        this.r = r25;
        this.s = r26;
        this.t = r27;
        this.u = r28;
        this.v = r29;
        this.w = r210;
        this.x = r30;
        this.y = r31;
        this.z = r33;
        this.A = r34;
        this.d = r21.getRoom();
        this.e = new int[]{0, 1, 5, 2, 6, 3, 7, 4, 8};
    }

    public final void o0(vz1.e r23, int r24, IBaseUser r25, boolean r26, int r27, int r28, int r29, String r210, boolean r30, IGiftExposureAnimInfo r31, int r33, int r34, String r35, GiftTopViewState.Mode r36, boolean r37, String r38, String r39) {
        Intrinsics.checkNotNullParameter(r36, "currentTopViewMode");
        Intrinsics.checkNotNullParameter(r38, "searchWord");
        Intrinsics.checkNotNullParameter(r39, "searchId");
        if (r23 == null) goto L24;
        int r3 = r33;
        if (r3 != (-1)) goto L8;
        r3 = (r24 / 4) + 1;
    L8:
        if (r34 != (-1)) goto L10;
        int r0 = (r24 % 4) + 1;
    L11:
        String r4 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
        Map<String, String> r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("gift_row_location", String.valueOf(r3)), TuplesKt.to("gift_column_location", String.valueOf(r0))});
        String r1 = this.d.getAnchorId();
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L14;
        r1 = BuildConfig.FLAVOR;
    L14:
        r6.put("anchor_id", r1);
        r6.put("room_id", String.valueOf(this.d.getId()));
        r6.put("gift_tab_from", String.valueOf(r27));
        r6.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r27));
        if (r30 == false) goto L21;
        r6.put("show_type", "series");
        if (r210 == null) goto L20;
        r2 = r210;
    L20:
        r6.put("series_name", r2);
    L22:
        IRoom r5 = this.d;
        GiftPanelIconSource r10 = r23.q;
        vz1.d r7 = r23.t;
        r1(r5, r23, r24, r25, r26, r6, r27, r28, r29, r10, r7.a, r7.b, r31, r35, r36, r23.v, r37, r38, r39, r23.z);
        return;
    L21:
        r6.put("show_type", "click");
        goto L22
    L10:
        r0 = r34;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w0(vz1.e r24, int r25, int r26, int r27, com.bytedance.android.livesdk.gift.model.n r28, IBaseUser r29, boolean r30, String r31, Map r33, int r34, int r35, int r36, String r37, GiftTopViewState.Mode r38, boolean r39, String r310, String r40) {
        Intrinsics.checkNotNullParameter(r24, "dialogIconModel");
        Intrinsics.checkNotNullParameter(r29, "toUser");
        Intrinsics.checkNotNullParameter(r38, "currentTopViewMode");
        Intrinsics.checkNotNullParameter(r310, "searchWord");
        Intrinsics.checkNotNullParameter(r40, "searchId");
        long r13 = r24.b;
        boolean r14 = !r24.e;
        String r16 = s();
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L9;
        com.bytedance.live.datacontext.n<Integer> r18 = r17.getCurrentSelectedGiftPosition();
        if (r18 == null) goto L9;
        Integer r19 = (Integer) r18.getValue();
        if (r19 == null) goto L9;
        int r110 = r19.intValue();
    L11:
        if (r34 == (-1)) goto L15;
        if (r35 == (-1)) goto L15;
        int r21 = r34;
    L19:
        if (r34 == (-1)) goto L22;
        if (r35 == (-1)) goto L22;
        int r6 = r35;
    L23:
        String r7 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
        int r8 = r110 + 1;
        int r111 = r8 % 8;
        if (r111 != 0) goto L26;
        int r23 = 0;
    L27:
        Pair[] r15 = new Pair[12];
        r15[0] = TuplesKt.to("user_id", r16.toString());
        r15[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r25));
        r15[2] = TuplesKt.to("tab_location", String.valueOf(r26 + 1));
        r15[3] = TuplesKt.to("page_location", String.valueOf((r8 / 8) + r23));
        int[] r4 = this.e;
        if (r23 != 0) goto L30;
        r111 = 8;
    L30:
        r15[4] = TuplesKt.to("gift_location", String.valueOf(r4[r111]));
        r15[5] = TuplesKt.to("gift_row_location", String.valueOf(r21));
        r15[6] = TuplesKt.to("gift_column_location", String.valueOf(r6));
        r15[7] = TuplesKt.to("order_type", tz1.a.a(r27));
        r15[8] = TuplesKt.to("click_entrance", "gift_tab");
        String r5 = "1";
        if (r39 == true) goto L34;
        r5 = "0";
    L34:
        r15[9] = TuplesKt.to("is_search_result", r5);
        r15[10] = TuplesKt.to("search_word", r310);
        r15[11] = TuplesKt.to("gift_panel_search_id", r40);
        Map<String, String> r9 = MapsKt.mutableMapOf(r15);
        if (tz1.a.d(r25) == false) goto L37;
        r9.put("order_type", tz1.a.a(r27));
    L37:
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        Object[] r11 = new Object[1];
        Long r20 = Long.valueOf(this.m.e.c);
        if (r20.longValue() == 0) goto L40;
        boolean r41 = true;
    L41:
        if (r41 == true) goto L44;
        r20 = null;
    L44:
        if (r20 != null) goto L52;
        Object[] r210 = r11;
        r20 = Long.valueOf(this.m.e.a);
        if (r20.longValue() == 0) goto L48;
        boolean r43 = true;
    L49:
        if (r43 == true) goto L53;
        r20 = null;
    L53:
        if (r20 == null) goto L55;
        long r44 = r20.longValue();
    L56:
        long r45 = System.currentTimeMillis();
        this.m.e.c = r45;
        r210[0] = Double.valueOf(((r45 - r44) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        r9.put("gift_click_time", String.format("%.1f", Arrays.copyOf(r210, 1)));
        if (r14 == false) goto L78;
        com.bytedance.android.livesdk.gift.model.h1 r46 = r24.a;
        if (r46 == null) goto L61;
        Integer r47 = Integer.valueOf(r46.getDiamondCount());
    L62:
        String r48 = String.valueOf(r47.intValue());
        if (r48 != null) goto L65;
        r48 = "0";
    L65:
        r9.put("gift_price", r48);
        com.bytedance.android.livesdk.gift.platform.core.model.k r49 = r24.x;
        if (r49 == null) goto L68;
        int r112 = r49.a;
    L69:
        r9.put("gift_position", String.valueOf(r112));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.b(r25, r8, this.g, r36, r9);
        i12.e r50 = i12.o.b();
        if (r50 == null) goto L72;
        Object r51 = com.bytedance.android.scope.m.e.d(r50, f1.class);
    L73:
        f1 r53 = (f1) r51;
        if (r53 == null) goto L76;
        boolean r54 = r53.f(r24.b);
    L77:
        r9.put("is_group_plugin_gift", String.valueOf(com.bytedance.android.livesdk.gift.platform.core.utils.h.c(r13, r25, r24.y, r54)));
        goto L78
    L76:
        r54 = false;
        goto L77
    L72:
        r51 = null;
        goto L73
    L68:
        r112 = -1;
        goto L69
    L61:
        r47 = null;
    L78:
        i12.e r55 = i12.o.b();
        if (r55 == null) goto L81;
        Object r56 = com.bytedance.android.scope.m.e.d(r55, GroupLiveReceiverService.class);
    L82:
        GroupLiveReceiverService r57 = (GroupLiveReceiverService) r56;
        String r58 = BuildConfig.FLAVOR;
        if (r57 == null) goto L88;
        String r59 = this.p.a.getIdString();
        if (r59 != null) goto L87;
        r59 = BuildConfig.FLAVOR;
    L87:
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r60 = null;
        r57.a(r9, r59, null);
    L89:
        l1(r14, r9, r13);
        r9.put("to_user_status", I(r29.getIdString()));
        GiftPanelIconSource r61 = r24.q;
        vz1.d r63 = r24.t;
        i(r9, r61, r63.a, r63.b, r24.v);
        if (r28 != null) goto L92;
    L95:
        String r64 = "0";
    L96:
        r9.put("operation_icon", r64);
        String r65 = "null";
        if (r28 == null) goto L100;
        String r66 = r28.getCardName();
        if (r66 == null) goto L100;
    L101:
        r9.put("card_name", r66);
        if (r28 == null) goto L104;
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r3 = gz1.c.g(r28);
    L105:
        List r67 = y(r3);
        if (((ArrayList) r67).isEmpty() == true) goto L109;
        r65 = r67.toString();
    L109:
        r9.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r65);
        r9.put("connection_type", w());
        r9.put("to_user_id", r29.getIdString());
        List<IBaseUser> r68 = this.q.k().a;
        ArrayList r69 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, 10));
        Iterator<T> r70 = r68.iterator();
    L111:
        if (r70.hasNext() == false) goto L113;
        r69.add(((IBaseUser) r70.next()).getIdString());
        goto L111
    L113:
        r9.put("user_type", J(r69));
        int r71 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a;
        long r113 = r24.a.getId();
        String r73 = this.p.a.getIdString();
        com.bytedance.android.livesdk.gift.model.e2 r74 = r24.a.getGiftTouchLabel();
        if (r74 == null) goto L116;
        String r75 = r74.getTouchUniqueKey();
    L118:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a(r113, r73, r75) == false) goto L120;
        String r76 = "1";
    L121:
        r9.put("anchor_renew", r76);
        if (r24.a.getBizType() != 1) goto L124;
        String r77 = "1";
    L125:
        r9.put("business_type", r77);
        r9.put("gift_creation_source", String.valueOf(r24.a.getGiftSource()));
        if (r30 == false) goto L132;
        r9.put("show_type", "series");
        if (r31 != null) goto L130;
        String r78 = BuildConfig.FLAVOR;
    L131:
        r9.put("series_name", r78);
        goto L132
    L130:
        r78 = r31;
    L132:
        py.d r79 = this.o.getUser().getUserHonor();
        if (r79 == null) goto L136;
        String r80 = String.valueOf(r79.getLevel());
        if (r80 == null) goto L136;
    L137:
        r9.put("privilege_level", r80);
        if (r33 == null) goto L140;
        r9.putAll(r33);
    L140:
        if (r37 == null) goto L142;
        r9.put("cluster_name", r37);
    L142:
        i12.e r81 = i12.o.b();
        if (r81 == null) goto L145;
        Object r114 = com.bytedance.android.scope.m.e.d(r81, f1.class);
    L146:
        f1 r115 = (f1) r114;
        if (r115 == null) goto L152;
        String r83 = r115.c(r24.b);
        if (r83 == null) goto L152;
        r9.put("buff_strategy", r83);
    L152:
        if (r38 != GiftTopViewState.Mode.Marketing) goto L154;
        r9.put("show_strategy", "top_scene");
    L154:
        int r84 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r24.a.getSortExtra()) == false) goto L157;
        String r2 = r24.a.getSortExtra();
    L160:
        r9.put("gift_feed_str", r2);
        r9.put("gift_panel_session_id", this.n.a);
        com.bytedance.android.livesdk.gift.platform.core.model.a r85 = r24.z;
        if (r85 == null) goto L164;
        String r86 = r85.b;
        if (r86 == null) goto L164;
    L165:
        r9.put("strategy_scene", r86);
        com.bytedance.android.livesdk.gift.platform.core.model.a r87 = r24.z;
        if (r87 == null) goto L169;
        String r88 = r87.a;
        if (r88 == null) goto L169;
    L170:
        r9.put("strategy_slice_id", r88);
        com.bytedance.android.livesdk.gift.platform.core.model.a r89 = r24.z;
        if (r89 == null) goto L174;
        String r90 = r89.c;
        if (r90 == null) goto L174;
    L175:
        r9.put("strategy_insert_status", r90);
        this.v.getClass();
        r9.put("room_live_scene", BuildConfig.FLAVOR);
        r9.put("to_user_type", t1(this.q.R(r29), r29));
        com.bytedance.android.livesdk.gift.platform.core.model.a r1 = r24.z;
        if (r1 == null) goto L181;
        String r91 = r1.e;
        if (r91 == null) goto L181;
        r58 = r91;
    L181:
        r9.put("strategy_sticker_content", r58);
        r9.put("actual_sticker_content", this.y.d);
        k(r9);
        this.v.getClass();
        this.v.getClass();
        p1("livesdk_gift_double_click", r9, true);
        return;
    L174:
        r90 = GiftInsertStatus.NOT_STRATEGY;
    L169:
        r88 = BuildConfig.FLAVOR;
    L164:
        r86 = BuildConfig.FLAVOR;
        goto L165
    L157:
        r2 = this.x.a(r25, r24.b);
        if (r2 != null) goto L160;
        r2 = BuildConfig.FLAVOR;
        goto L160
    L145:
        r114 = r60;
    L136:
        r80 = "0";
        goto L137
    L124:
        r77 = "0";
        goto L125
    L120:
        r76 = "0";
        goto L121
    L116:
        r75 = r60;
        goto L118
    L104:
        r3 = r60;
    L100:
        r66 = "null";
        goto L101
    L92:
        if ((r28 instanceof sz1.a) == true) goto L95;
        r64 = "1";
        goto L96
    L88:
        r60 = null;
        goto L89
    L81:
        r56 = null;
        goto L82
    L55:
        r44 = System.currentTimeMillis();
        goto L56
    L48:
        r43 = false;
        goto L49
    L52:
        r210 = r11;
        goto L53
    L40:
        r41 = false;
        goto L41
    L26:
        r23 = 1;
    L22:
        r6 = (r110 % 4) + 1;
    L15:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.t.b() == false) goto L17;
        int r211 = r110 / 4;
    L18:
        r21 = r211 + 1;
        goto L19
    L17:
        r211 = (r110 % 8) / 4;
    L9:
        r110 = 0;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r1(IRoom r20, vz1.e r21, int r23, IBaseUser r24, boolean r25, Map<String, String> r26, int r27, int r28, int r29, GiftPanelIconSource r210, String r30, List<? extends com.bytedance.android.livesdk.gift.model.e3> r31, IGiftExposureAnimInfo r33, String r34, GiftTopViewState.Mode r35, CardType r36, boolean r37, String r38, String r39, com.bytedance.android.livesdk.gift.platform.core.model.a r310) {
        int r10 = r23 + 1;
        if (r35 != GiftTopViewState.Mode.Marketing) goto L5;
        r26.put("show_strategy", "top_scene");
    L5:
        String r11 = String.valueOf(r21.b);
        boolean r13 = r21.e;
        String r9 = "0";
        String r7 = BuildConfig.FLAVOR;
        if (r13 == false) goto L24;
        i12.e r14 = i12.o.b();
        if (r14 == null) goto L10;
        Object r5 = com.bytedance.android.scope.m.e.d(r14, PropListService.class);
    L11:
        PropListService r6 = (PropListService) r5;
        if (r6 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.l2 r8 = r6.f(Long.valueOf(r21.b));
    L15:
        r26.put("prop_id", String.valueOf(r21.b));
        r26.put("gift_id", String.valueOf(r21.a.getId()));
        if (r8 == null) goto L18;
        Long r15 = Long.valueOf(r8.getDiamond());
    L19:
        r26.put("money", String.valueOf(r15));
        if (r8 == null) goto L22;
        Long r16 = Long.valueOf(r8.getDiamond());
    L23:
        r26.put("gift_price", String.valueOf(r16));
    L58:
        r26.put("gift_creation_source", String.valueOf(r21.a.getGiftSource()));
        int r17 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r21.a.getSortExtra()) == false) goto L61;
        String r18 = r21.a.getSortExtra();
    L64:
        r26.put("gift_feed_str", r18);
        com.bytedance.android.livesdk.gift.platform.core.model.k r19 = r21.x;
        if (r19 == null) goto L67;
        r26.put("gift_position", String.valueOf(r19.a));
        Unit r40 = Unit.INSTANCE;
    L67:
        i12.e r41 = i12.o.b();
        if (r41 == null) goto L70;
        Object r43 = com.bytedance.android.scope.m.e.d(r41, GroupLiveReceiverService.class);
    L71:
        GroupLiveReceiverService r44 = (GroupLiveReceiverService) r43;
        if (r44 == null) goto L78;
        if (r24 == null) goto L76;
        String r45 = r24.getIdString();
        if (r45 == null) goto L76;
    L77:
        Long r46 = null;
        r44.a(r26, r45, null);
        Unit r47 = Unit.INSTANCE;
    L79:
        r26.put("tab_location", String.valueOf(r28 + 1));
        int r48 = r10 % 8;
        if (r48 != 0) goto L82;
        int r49 = 0;
    L83:
        r26.put("page_location", String.valueOf((r10 / 8) + r49));
        int[] r110 = this.e;
        if (r49 != 0) goto L86;
        r48 = 8;
    L86:
        r26.put("gift_location", String.valueOf(r110[r48]));
        r26.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a()));
        if (r24 == null) goto L92;
        if (r20 == null) goto L92;
        if ((!Intrinsics.areEqual(r24.getIdString(), r20.getAnchorId())) == false) goto L92;
        String r50 = "guest";
    L93:
        r26.put("to_user_type", r50);
        r26.put("connection_type", com.bytedance.android.livesdk.gift.platform.core.utils.h.e());
        StringCompanionObject r51 = StringCompanionObject.INSTANCE;
        Object[] r111 = new Object[1];
        Long r53 = Long.valueOf(this.m.e.b);
        if (r53.longValue() == 0) goto L96;
        boolean r112 = true;
    L97:
        if (r112 == true) goto L100;
        r53 = r46;
    L100:
        if (r53 != null) goto L108;
        r53 = Long.valueOf(this.m.e.a);
        if (r53.longValue() == 0) goto L104;
        boolean r113 = true;
    L105:
        if (r113 == true) goto L108;
        r53 = r46;
        goto L108
    L104:
        r113 = false;
    L108:
        if (r53 == null) goto L110;
        long r114 = r53.longValue();
    L111:
        long r115 = System.currentTimeMillis();
        this.m.e.b = r115;
        r111[0] = Double.valueOf(((r115 - r114) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        r26.put("gift_click_time", String.format("%.1f", Arrays.copyOf(r111, 1)));
        r26.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (tz1.a.d(r27) == false) goto L114;
        r26.put("order_type", tz1.a.a(r29));
    L114:
        if (r25 == false) goto L116;
        String r4 = "dynamic";
    L117:
        r26.put("preview_mode", r4);
        String r54 = ay1.b.l().get(r11);
        if (r54 == null) goto L120;
        r26.put("light_sweep_cnt", r54);
    L120:
        if (r33 == null) goto L142;
        py.k r55 = r33.getAssetUrl();
        if (r55 == null) goto L136;
        List r56 = r55.getUrls();
        if (r56 == 0) goto L136;
        if (r56.size() <= 0) goto L128;
        boolean r57 = true;
    L129:
        if (r57 == true) goto L132;
        r56 = r46;
    L132:
        if (r56 == 0) goto L136;
        boolean r58 = false;
        String r59 = (String) ListProtector.get(r56, 0);
        if (r59 == null) goto L137;
    L138:
        r26.put("effect_name", r59);
        String r60 = r33.getFrequencyKey();
        if (r60 != null) goto L141;
        r60 = r7;
    L141:
        r26.put("effect_id", r60);
    L143:
        r26.put("gift_panel_session_id", this.n.a);
        if (r24 == null) goto L146;
        String r61 = I(r24.getIdString());
    L147:
        r26.put("to_user_status", r61);
        String r116 = r30;
        i(r26, r210, r116, r31, r36);
        if (r210 != GiftPanelIconSource.DIY_CARD) goto L150;
        String r63 = "1";
    L151:
        r26.put("operation_icon", r63);
        String r64 = "null";
        if (r116 != null) goto L154;
        r116 = "null";
    L154:
        r26.put("card_name", r116);
        List r117 = y(r31);
        if (((ArrayList) r117).isEmpty() == true) goto L158;
        r64 = r117.toString();
    L158:
        r26.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r64);
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r26);
        r26.put("is_screencasting", com.bytedance.android.live.core.utils.m2.b(ay1.b.p()));
        com.bytedance.android.livesdk.gift.model.k0 r65 = r21.a.getGiftPreviewInfo();
        if (r65 != null) goto L161;
    L163:
        boolean r118 = false;
    L164:
        if (r34 == 0) goto L166;
        r26.put("cluster_name", r34);
        Unit r119 = Unit.INSTANCE;
    L166:
        if (r118 == false) goto L168;
        String r120 = "1";
    L169:
        r26.put("gift_unlock_status", r120);
        if (r37 == false) goto L172;
        String r121 = "1";
    L173:
        r26.put("is_search_result", r121);
        r26.put("search_word", r38);
        r26.put("gift_panel_search_id", r39);
        if (r310 == null) goto L177;
        String r122 = r310.b;
        if (r122 == null) goto L177;
    L178:
        r26.put("strategy_scene", r122);
        if (r310 == null) goto L182;
        String r123 = r310.a;
        if (r123 == null) goto L182;
    L183:
        r26.put("strategy_slice_id", r123);
        if (r310 == null) goto L187;
        String r124 = r310.c;
        if (r124 == null) goto L187;
    L188:
        r26.put("strategy_insert_status", r124);
        if (r310 == null) goto L192;
        String r66 = r310.e;
        if (r66 == null) goto L192;
    L193:
        r26.put("strategy_sticker_content", r66);
        r26.put("actual_sticker_content", this.y.d);
        this.v.getClass();
        r26.put("room_live_scene", r7);
        if (r24 == null) goto L197;
        String r67 = r24.getIdString();
        if (r67 == null) goto L197;
    L198:
        r26.put("to_user_id", r67);
        if (r24 == null) goto L201;
        r26.put("to_user_type", t1(this.q.R(r24), r24));
    L203:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L205;
        p1("gift_preview", r26, true);
    L254:
        Unit r1 = Unit.INSTANCE;
        return;
    L205:
        GiftManagerKt.z.getClass();
        Map r2 = GiftManagerKt.o();
        if (r2 != null) goto L208;
    L211:
        boolean r3 = true;
    L212:
        if (r3 == true) goto L217;
        Map<? extends String, ? extends String> r68 = GiftManagerKt.o();
        if (r68 == null) goto L217;
        r26.putAll(r68);
        Unit r69 = Unit.INSTANCE;
    L217:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L219;
        String r70 = "scroll";
    L220:
        r26.put("gift_show_type", r70);
        if (this.r.i().size() <= 1) goto L223;
        r58 = true;
    L223:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).I0(this.p.a.getIdString(), r21.b, r58, r26);
        int r71 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a;
        long r73 = r21.a.getId();
        String r74 = this.p.a.getIdString();
        com.bytedance.android.livesdk.gift.model.e2 r75 = r21.a.getGiftTouchLabel();
        if (r75 == null) goto L226;
        String r76 = r75.getTouchUniqueKey();
    L228:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a(r73, r74, r76) == false) goto L230;
        r9 = "1";
    L230:
        r26.put("anchor_renew", r9);
        JsonElement r77 = ((JsonObject) this.l.get("data_multi_fight_profit_egg", new JsonObject())).get("log");
        if (r77 == null) goto L239;
        JsonObject r78 = r77.getAsJsonObject();
        if (r78 == null) goto L239;
        GsonMap r79 = UtilsKt.i(r78);
        LinkedHashMap r80 = new LinkedHashMap(MapsKt.mapCapacity(r79.size()));
        Iterator r81 = r79.b().iterator();
    L236:
        if (r81.hasNext() == false) goto L238;
        Map.Entry r83 = (Map.Entry) r81.next();
        r80.put(r83.getKey(), String.valueOf(r83.getValue()));
        goto L236
    L238:
        r26.putAll(r80);
        Unit r84 = Unit.INSTANCE;
    L239:
        com.bytedance.android.livesdk.gift.model.l2 r85 = this.s.f(Long.valueOf(r21.b));
        if (r85 != null) goto L242;
    L244:
        i12.e r86 = i12.o.b();
        if (r86 == null) goto L247;
        Object r125 = com.bytedance.android.scope.m.e.d(r86, f1.class);
    L248:
        f1 r126 = (f1) r125;
        if (r126 == null) goto L253;
        String r87 = r126.c(r21.b);
        if (r87 == null) goto L253;
        r26.put("buff_strategy", r87);
        Unit r88 = Unit.INSTANCE;
    L253:
        k(r26);
        this.v.getClass();
        this.v.getClass();
        p1("livesdk_gift_preview", r26, true);
        goto L254
    L247:
        r125 = r46;
        goto L248
    L242:
        if (r85.getPropType() != 5) goto L244;
        r26.put("recharge_vou_type", "cashback_coupon");
        goto L244
    L226:
        r76 = r46;
        goto L228
    L219:
        r70 = "slide";
        goto L220
    L208:
        if (r2.isEmpty() == true) goto L211;
        r3 = false;
        goto L212
    L201:
        r26.put("to_user_type", r7);
    L197:
        r67 = r7;
    L192:
        r66 = r7;
    L187:
        r124 = GiftInsertStatus.NOT_STRATEGY;
    L182:
        r123 = r7;
    L177:
        r122 = r7;
        goto L178
    L172:
        r121 = "0";
        goto L173
    L168:
        r120 = "0";
        goto L169
    L161:
        if (r65.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.UNLOCKED) goto L163;
        r118 = true;
        goto L164
    L150:
        r63 = "0";
        goto L151
    L146:
        r61 = String.valueOf(2);
    L137:
        r59 = r7;
        goto L138
    L128:
        r57 = false;
    L136:
        r58 = false;
        goto L137
    L142:
        r58 = false;
        goto L143
    L116:
        r4 = "static";
        goto L117
    L110:
        r114 = System.currentTimeMillis();
        goto L111
    L96:
        r112 = false;
    L92:
        r50 = "anchor";
        goto L93
    L82:
        r49 = 1;
    L76:
        r45 = r7;
        goto L77
    L78:
        r46 = null;
        goto L79
    L70:
        r43 = null;
        goto L71
    L61:
        r18 = this.x.a(r27, r21.a.getId());
        if (r18 != null) goto L64;
        r18 = r7;
        goto L64
    L22:
        r16 = null;
        goto L23
    L18:
        r15 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L10:
        r5 = null;
        goto L11
    L24:
        r7 = BuildConfig.FLAVOR;
        r26.put("gift_id", String.valueOf(r21.b));
        r26.put("gift_type", String.valueOf(r21.a.getType()));
        r26.put("money", String.valueOf(r21.a.getDiamondCount()));
        r26.put("gift_price", String.valueOf(r21.a.getDiamondCount()));
        py.k r89 = r21.a.getLeftLogo();
        if (r89 == null) goto L28;
        String r90 = r89.getUri();
        if (r90 == null) goto L28;
    L29:
        r26.put("corner_mark", r90);
        if (r21.a.getBizType() != 1) goto L33;
        String r91 = "1";
    L39:
        r26.put("business_type", r91);
        if (r21.a.getSelectedDynamicEffect() == 0) goto L43;
        r26.put("icon_effect_type", "rare");
    L43:
        if (r21.a.isFreeDisplay() == false) goto L45;
        r26.put("free_display", "1");
    L46:
        com.bytedance.android.livesdk.gift.platform.core.model.k r93 = r21.x;
        if (r93 == null) goto L49;
        String r94 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.b(r93.b, r93.a, this.g, r93.c, r26);
        Unit r95 = Unit.INSTANCE;
    L49:
        i12.e r96 = i12.o.b();
        if (r96 == null) goto L52;
        Object r97 = com.bytedance.android.scope.m.e.d(r96, f1.class);
    L53:
        f1 r98 = (f1) r97;
        if (r98 == null) goto L56;
        boolean r99 = r98.f(r21.b);
    L57:
        String r100 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        r26.put("is_group_plugin_gift", String.valueOf(com.bytedance.android.livesdk.gift.platform.core.utils.h.c(r21.b, r27, r21.y, r99)));
        goto L58
    L56:
        r99 = false;
        goto L57
    L52:
        r97 = null;
        goto L53
    L45:
        r26.put("free_display", "0");
        goto L46
    L33:
        if (r21.a.getBizType() != 2) goto L35;
    L38:
        r91 = "2";
        goto L39
    L35:
        if (r21.a.getType() == 3) goto L38;
        r91 = "0";
    L28:
        r90 = r7;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x0(u1 r23, long r24, com.bytedance.android.livesdk.gift.model.h1 r26, boolean r27, int r28, boolean r29, int r30, int r31, int r33, GiftPanelIconSource r34, String r35, List r36, boolean r37, String r38, String r39, boolean r310, int r40, int r41, Integer r43, int r44, boolean r45, String r46, GiftTopViewState.Mode r47, CardType r48, boolean r49, String r410, String r50, com.bytedance.android.livesdk.gift.platform.core.model.a r51, b r53, int r54) {
        if ((r54 & 8388608) == 0) goto L5;
        boolean r13 = false;
    L7:
        if ((r54 & 16777216) == 0) goto L9;
        String r14 = BuildConfig.FLAVOR;
    L11:
        if ((r54 & 33554432) == 0) goto L13;
        String r15 = BuildConfig.FLAVOR;
    L14:
        Object r18 = null;
        if ((r54 & 67108864) == 0) goto L17;
        com.bytedance.android.livesdk.gift.platform.core.model.a r19 = null;
    L19:
        if ((r54 & 134217728) == 0) goto L21;
        b r16 = null;
    L22:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r26, "gift");
        Intrinsics.checkNotNullParameter(r34, "type");
        Intrinsics.checkNotNullParameter(r47, "currentTopViewMode");
        Intrinsics.checkNotNullParameter(r48, "cardType");
        Intrinsics.checkNotNullParameter(r14, "searchWord");
        Intrinsics.checkNotNullParameter(r15, "searchId");
        if (r24 <= 0) goto L340;
        if (r16 == null) goto L28;
        String r9 = r16.a;
        if (r9 == null) goto L28;
    L29:
        int r17 = r28 + 1;
        int r20 = r17 % 8;
        if (r20 != 0) goto L32;
        int r21 = 0;
    L33:
        String r25 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.k();
        if (r16 == null) goto L37;
        Map r7 = r16.b;
        if (r7 == null) goto L37;
    L38:
        String r8 = (String) r7.get(String.valueOf(r24));
        Pair[] r10 = new Pair[13];
        r10[0] = TuplesKt.to("user_id", r9.toString());
        if (r16 == null) goto L42;
        String r6 = r16.c;
        if (r6 == null) goto L42;
    L43:
        r10[1] = TuplesKt.to("tab_name", r6);
        r10[2] = TuplesKt.to("tab_location", String.valueOf(r31 + 1));
        r10[3] = TuplesKt.to("page_location", String.valueOf((r17 / 8) + r21));
        int[] r11 = r23.e;
        if (r21 != 0) goto L46;
        r20 = 8;
    L46:
        r10[4] = TuplesKt.to("gift_location", String.valueOf(r11[r20]));
        if (r29 == false) goto L49;
        String r55 = "light_sweep";
    L50:
        r10[5] = TuplesKt.to("show_mode", r55);
        r10[6] = TuplesKt.to("gift_row_location", String.valueOf(r40));
        r10[7] = TuplesKt.to("gift_column_location", String.valueOf(r41));
        if (r16 == null) goto L54;
        String r56 = r16.d;
        if (r56 == null) goto L54;
    L55:
        r10[8] = TuplesKt.to("show_gift_scene", r56);
        r10[9] = TuplesKt.to("gift_position", String.valueOf(r28));
        String r57 = "0";
        if (r13 == false) goto L58;
        Object r110 = "1";
    L59:
        r10[10] = TuplesKt.to("is_search_result", r110);
        r10[11] = TuplesKt.to("search_word", r14);
        r10[12] = TuplesKt.to("gift_panel_search_id", r15);
        Map r58 = MapsKt.mutableMapOf(r10);
        if (r27 == false) goto L73;
        if (r37 == false) goto L63;
        Object r111 = "1";
    L64:
        r58.put("gift_unlock_status", r111);
        com.bytedance.android.livesdk.gift.platform.core.utils.h.b(r30, r28, r23.g, r44, r58);
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L67;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, f1.class);
    L68:
        f1 r59 = (f1) r5;
        if (r59 == null) goto L71;
        boolean r60 = r59.f(r24);
    L72:
        r58.put("is_group_plugin_gift", String.valueOf(com.bytedance.android.livesdk.gift.platform.core.utils.h.c(r24, r30, r45, r60)));
        goto L73
    L71:
        r60 = false;
        goto L72
    L67:
        r5 = null;
        goto L68
    L63:
        r111 = "0";
    L73:
        if (r16 == null) goto L76;
        String r61 = r16.e;
        if (r61 == null) goto L76;
    L77:
        r58.put("connection_type", r61);
        if (r16 == null) goto L81;
        Bundle r63 = r16.f;
        if (r63 == null) goto L81;
    L87:
        if (r16 == null) goto L90;
        Map r112 = r16.g;
        if (r112 == null) goto L90;
    L91:
        if (r112 == null) goto L98;
        Iterator r113 = r112.entrySet().iterator();
    L94:
        if (r113.hasNext() == false) goto L98;
        Map.Entry r114 = (Map.Entry) r113.next();
        if (r58.containsKey(r114.getKey()) == true) goto L94;
        r58.put(r114.getKey(), r114.getValue());
    L98:
        if (r63 == null) goto L121;
        Iterator<String> r115 = r63.keySet().iterator();
    L101:
        if (r115.hasNext() == false) goto L121;
        String r116 = r115.next();
        Object r117 = r63.get(r116);
        if ((r117 instanceof Boolean) == true) goto L120;
        if ((r117 instanceof Byte) == true) goto L120;
        if ((r117 instanceof Character) == true) goto L120;
        if ((r117 instanceof Double) == true) goto L120;
        if ((r117 instanceof Float) == true) goto L120;
        if ((r117 instanceof Integer) == true) goto L120;
        if ((r117 instanceof Long) == true) goto L120;
        if ((r117 instanceof Short) == true) goto L120;
        if ((r117 instanceof String) == false) goto L101;
    L120:
        r58.put(r116, r117.toString());
    L121:
        if (r16 == null) goto L123;
        boolean r64 = r16.h;
    L124:
        if (r64 == false) goto L126;
        r58.put("order_type", tz1.a.a(r33));
    L126:
        if (r16 == null) goto L135;
        Map<String, String> r65 = r16.i;
        if (r65 != null) goto L130;
    L146:
        if (r16 == null) goto L149;
        com.bytedance.android.livesdk.gift.platform.business.config.n r66 = r16.j;
        if (r66 == null) goto L149;
    L151:
        if (r66.f() == 0) goto L153;
        String r67 = "scroll";
    L154:
        r58.put("gift_show_type", r67);
        if (r8 == null) goto L157;
        r58.put("light_sweep_cnt", r8);
    L157:
        if (r27 == false) goto L178;
        GiftMsgBoard r68 = r26.getGiftMsgBoard();
        if (r68 == null) goto L164;
        if (r68.forMsgBoard != true) goto L164;
        r58.put("is_message", "1");
    L164:
        if (r26.isFreeDisplay() == false) goto L166;
        r58.put("free_display", "1");
    L167:
        r58.put("gift_price", String.valueOf(r26.getDiamondCount()));
        if (r26.getBizType() != 1) goto L171;
        String r69 = "1";
    L177:
        r58.put("business_type", r69);
        Unit r70 = Unit.INSTANCE;
        goto L178
    L171:
        if (r26.getBizType() != 2) goto L173;
    L176:
        r69 = "2";
        goto L177
    L173:
        if (r26.getType() == 3) goto L176;
        r69 = "0";
        goto L177
    L166:
        r58.put("free_display", "0");
    L178:
        r23.l1(r27, r58, r24);
        if (r16 == null) goto L182;
        String r3 = r16.k;
        if (r3 == null) goto L182;
    L183:
        r58.put("to_user_status", r3);
        String r71 = r35;
        i(r58, r34, r71, r36, r48);
        if (r34 != GiftPanelIconSource.DIY_CARD) goto L186;
        Object r73 = "1";
    L187:
        r58.put("operation_icon", r73);
        String r74 = "null";
        if (r71 != null) goto L190;
        r71 = "null";
    L190:
        r58.put("card_name", r71);
        List r75 = r36;
        if (r75 != null) goto L193;
    L196:
        boolean r76 = true;
    L197:
        if (r76 == true) goto L200;
        r74 = y(r36).toString();
    L200:
        r58.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r74);
        int r77 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.l.a(r24, r23.p.a.getIdString(), r38) == false) goto L203;
        r57 = "1";
    L203:
        r58.put("anchor_renew", r57);
        if (r43 == null) goto L206;
        int r78 = r43.intValue();
    L207:
        r58.put("gift_creation_source", String.valueOf(r78));
        if (r310 == false) goto L214;
        if (r39 != null) goto L211;
        String r79 = BuildConfig.FLAVOR;
    L212:
        r58.put("series_name", r79);
        r58.put("show_type", "series");
        goto L214
    L211:
        r79 = r39;
    L214:
        if (r46 == null) goto L216;
        r58.put("cluster_name", r46);
        Unit r80 = Unit.INSTANCE;
    L216:
        if (r16 == null) goto L219;
        boolean r81 = r16.l;
    L222:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).I0(r23.p.a.getIdString(), r24, r81, r58);
        i12.e r83 = i12.o.b();
        if (r83 == null) goto L225;
        Object r84 = com.bytedance.android.scope.m.e.d(r83, GroupLiveReceiverService.class);
    L226:
        GroupLiveReceiverService r85 = (GroupLiveReceiverService) r84;
        if (r85 == 0) goto L235;
        String r86 = r23.p.a.getIdString();
        if (r86 != null) goto L231;
        r86 = BuildConfig.FLAVOR;
    L231:
        if (r16 == null) goto L233;
        Boolean r87 = Boolean.valueOf(r16.m);
    L234:
        r85.a(r58, r86, r87);
        Unit r88 = Unit.INSTANCE;
        goto L235
    L233:
        r87 = null;
    L235:
        i12.e r89 = i12.o.b();
        if (r89 == null) goto L238;
        r18 = com.bytedance.android.scope.m.e.d(r89, f1.class);
    L238:
        f1 r90 = (f1) r18;
        if (r90 == null) goto L244;
        String r1 = r90.c(r24);
        if (r1 == null) goto L244;
        r58.put("buff_strategy", r1);
        Unit r2 = Unit.INSTANCE;
    L244:
        if (r47 != GiftTopViewState.Mode.Marketing) goto L246;
        r58.put("show_strategy", "top_scene");
    L246:
        int r91 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r26.getSortExtra()) == false) goto L249;
        String r93 = r26.getSortExtra();
    L252:
        r58.put("gift_feed_str", r93);
        r58.put("gift_panel_session_id", r23.n.a);
        r23.v.getClass();
        String r94 = BuildConfig.FLAVOR;
        r58.put("room_live_scene", r94);
        com.bytedance.android.livesdk.gift.platform.core.model.a r95 = r19;
        if (r95 == null) goto L256;
        String r96 = r95.b;
        if (r96 == null) goto L256;
    L257:
        r58.put("strategy_scene", r96);
        if (r95 == null) goto L263;
        String r97 = r95.a;
        if (r97 == null) goto L263;
        r94 = r97;
    L263:
        r58.put("strategy_slice_id", r94);
        if (r95 == null) goto L267;
        String r98 = r95.c;
        if (r98 == null) goto L267;
    L268:
        r58.put("strategy_insert_status", r98);
        r58.put("to_user_id", r23.p.a.getIdString());
        if (r16 == null) goto L272;
        String r99 = r16.n;
        if (r99 == null) goto L272;
    L273:
        r58.put("to_user_type", r99);
        r23.v.getClass();
        r23.v.getClass();
        r23.k(r58);
        if (r16 != null) goto L276;
    L278:
        boolean r100 = false;
    L279:
        r23.p1("livesdk_distinct_gift_show", r58, r100);
        t1 r0 = r23.u;
        long r101 = r26.getId();
        if (r40 > 2) goto L282;
        boolean r102 = true;
    L283:
        r0.getClass();
        if (nz1.a.m().a() == true) goto L287;
        return;
    L287:
        if (r30 != 1) goto L289;
    L291:
        Map<Integer, Map<Long, l2>> r103 = r0.a;
        Integer r104 = Integer.valueOf(r30);
        LinkedHashMap r105 = (LinkedHashMap) r103;
        Object r106 = r105.get(r104);
        if (r106 != null) goto L294;
        r106 = new LinkedHashMap();
        r105.put(r104, r106);
    L294:
        Map r107 = (Map) r106;
        Map<String, Integer> r108 = nz1.a.m().b();
        if (r108 == null) goto L299;
        Integer r109 = r108.get(String.valueOf(r30));
        if (r109 == null) goto L299;
        int r118 = r109.intValue();
    L301:
        if (r107.containsKey(Long.valueOf(r101)) == false) goto L303;
    L305:
        Long r119 = Long.valueOf(r101);
        Object r120 = r107.get(r119);
        if (r120 != null) goto L309;
        r120 = new l2(0);
        r107.put(r119, r120);
    L309:
        l2 r121 = (l2) r120;
        Integer r122 = r121.a;
        if (r122 == null) goto L312;
        int r123 = r122.intValue();
    L313:
        r121.a = Integer.valueOf(r123 + 1);
        if (r102 == false) goto L339;
        Integer r124 = r121.b;
        if (r124 == null) goto L318;
        int r125 = r124.intValue();
    L319:
        r121.b = Integer.valueOf(r125 + 1);
        return;
    L318:
        r125 = 0;
        goto L319
    L339:
        return;
    L312:
        r123 = 0;
        goto L313
    L303:
        if (r107.size() < r118) goto L305;
        return;
    L299:
        r118 = 0;
        goto L301
    L289:
        if (r30 == 15) goto L291;
        return;
    L282:
        r102 = false;
        goto L283
    L276:
        if (r16.o == true) goto L278;
        r100 = true;
    L272:
        r99 = r23.t1(r23.q.R(r23.p.a), r23.p.a);
    L267:
        r98 = GiftInsertStatus.NOT_STRATEGY;
    L256:
        r96 = r94;
        goto L257
    L249:
        r93 = r23.x.a(r30, r26.getId());
        if (r93 != null) goto L252;
        r93 = BuildConfig.FLAVOR;
        goto L252
    L225:
        r84 = null;
        goto L226
    L219:
        if (r23.r.i().size() <= 1) goto L221;
        r81 = true;
        goto L222
    L221:
        r81 = false;
        goto L222
    L206:
        r78 = 0;
        goto L207
    L193:
        if (r75.isEmpty() == true) goto L196;
        r76 = false;
        goto L197
    L186:
        r73 = "0";
    L182:
        r3 = r23.I(r23.p.a.getIdString());
        goto L183
    L153:
        r67 = "slide";
    L149:
        r66 = (com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class);
        goto L151
    L130:
        if ((!r65.isEmpty()) == true) goto L133;
        r65 = null;
    L133:
        if (r65 == null) goto L146;
        r58.putAll(r65);
        Unit r126 = Unit.INSTANCE;
        goto L146
    L135:
        GiftManagerKt.z.getClass();
        Map r127 = GiftManagerKt.o();
        if (r127 != null) goto L138;
    L141:
        boolean r128 = true;
    L142:
        if (r128 == true) goto L146;
        Map r129 = GiftManagerKt.o();
        if (r129 == null) goto L146;
        r58.putAll(r129);
        Unit r130 = Unit.INSTANCE;
        goto L146
    L138:
        if (r127.isEmpty() == true) goto L141;
        r128 = false;
        goto L142
    L123:
        r64 = tz1.a.d(r30);
    L90:
        r112 = vh6.c.b(er2.b.class).Z6();
    L81:
        GiftContext r131 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r131 == null) goto L86;
        com.bytedance.live.datacontext.n<Bundle> r132 = r131.getGiftLogExtra();
        if (r132 == null) goto L86;
        r63 = (Bundle) r132.getValue();
    L86:
        r63 = null;
    L76:
        r61 = r23.w();
        goto L77
    L58:
        r110 = "0";
    L54:
        r56 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a());
        goto L55
    L49:
        r55 = "normal";
    L42:
        r6 = ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r30);
    L37:
        r7 = ay1.b.l();
        goto L38
    L32:
        r21 = 1;
    L28:
        r9 = s();
        goto L29
    L340:
        return;
    L21:
        r16 = r53;
        goto L22
    L17:
        r19 = r51;
        goto L19
    L13:
        r15 = r50;
        goto L14
    L9:
        r14 = r410;
        goto L11
    L5:
        r13 = r49;
        goto L7
    }
}
