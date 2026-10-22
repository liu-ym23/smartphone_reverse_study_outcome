package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multiscene.LinkMicTeamFightInfo;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.gift.model.t2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.android.livesdk.utils.u2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.util.ArrayList;
import java.util.Comparator;
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
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public static final ReadOnlyProperty c = null;
    public static boolean d;
    public static final Map<String, String> e = null;
    public static final a f = null;
    public final com.bytedance.android.scope.j a;
    public final DataCenter b;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "enableGuestUserJsonCache", "getEnableGuestUserJsonCache()Z", 0))};
        }

        public a() {
        }
    }

    public static final class b<T> implements Comparator<T> {
        public final /* synthetic */ Map a;

        public b(Map r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues((Integer) this.a.get(((HashMap) r3).get("identifier")), (Integer) this.a.get(((HashMap) r4).get("identifier")));
        }
    }

    static {
        a r0 = new a();
        f = r0;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_gift_guest_user_json_cache", Boolean.FALSE, Boolean.TYPE, false);
        KProperty[] r2 = a.a;
        KProperty r11 = r2[0];
        ReadOnlyProperty r3 = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r11);
        c = r3;
        d = ((Boolean) r3.getValue(r0, r2[0])).booleanValue();
        e = new LinkedHashMap();
    }

    public final String a() {
        i12.e r1 = i12.o.b();
        if (r1 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r2 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r1).a(Reflection.getOrCreateKotlinClass(GiftReceiverRepoService.class));
    L6:
        GiftReceiverRepoService r3 = (GiftReceiverRepoService) r2;
        yz0.g r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r3 == null) goto L10;
        List<IBaseUser> r5 = r3.k().a;
        if (r5 == null) goto L10;
    L11:
        i12.d r6 = i12.m.e2.a();
        if (r6 == null) goto L14;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r7 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class));
    L15:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r8 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r7;
        if (r8 == null) goto L19;
        IBaseUser r9 = r8.a;
        if (r9 == null) goto L19;
    L27:
        if (r9 != null) goto L36;
        i12.e r10 = i12.o.b();
        if (r10 == null) goto L31;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r11 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x.class));
    L32:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r13 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x) r11;
        if (r13 == null) goto L35;
        r9 = r13.a();
        goto L36
    L35:
        r9 = null;
        goto L36
    L31:
        r11 = null;
    L36:
        if (r9 != null) goto L43;
        if (r4 == null) goto L41;
        IRoomBase r14 = r4.getRoom();
        if (r14 == null) goto L41;
        r9 = r14.getOwnerKt();
    L41:
        r9 = null;
    L43:
        if (r4 == null) goto L47;
        IRoomBase r15 = r4.getRoom();
        if (r15 == null) goto L47;
        boolean r16 = x12.a.b(r15);
    L49:
        if (r9 != null) goto L51;
    L59:
        List r17 = CollectionsKt.toMutableList(r5);
        if (r3 == null) goto L63;
        List<t2> r18 = r3.k().c;
        if (r18 == null) goto L63;
    L64:
        ArrayList r19 = new ArrayList();
        if (r4 == null) goto L69;
        IRoomBase r20 = r4.getRoom();
        if (r20 == null) goto L69;
        IBaseUser r21 = r20.getOwnerKt();
    L70:
        if (r21 == null) goto L83;
        List r23 = r17;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r24 = r23.iterator();
    L73:
        if (r24.hasNext() == false) goto L76;
        r110.add(((IBaseUser) r24.next()).getIdString());
        goto L73
    L76:
        if (r110.contains(r21.getIdString()) == true) goto L83;
        if (TypeIntrinsics.isMutableList(r17) == true) goto L80;
        List r25 = null;
    L81:
        if (r25 == null) goto L83;
        ListProtector.add(r25, 0, r21);
        Unit r26 = Unit.INSTANCE;
        goto L83
    L80:
        r25 = r17;
    L83:
        List<ILinkPlayerInfoBridge> r27 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.v.b(this.a, this.b);
        String r28 = "$this$fanTicketDisplayStrExt";
        String r111 = "0";
        if (r27 == null) goto L104;
        Iterator<T> r29 = r27.iterator();
    L87:
        if (r29.hasNext() == false) goto L99;
        Object r112 = r29.next();
        IBaseUser r113 = com.bytedance.android.live.liveinteract.plantform.model.n.d((ILinkPlayerInfoBridge) r112);
        if (r113 == null) goto L96;
        String r114 = r113.getIdString();
        if (r114 == null) goto L96;
        if (r21 == null) goto L94;
        String r115 = r21.getIdString();
    L95:
        boolean r116 = r114.equals(r115);
    L97:
        if (r116 == false) goto L87;
    L100:
        ILinkPlayerInfoBridge r117 = (ILinkPlayerInfoBridge) r112;
        if (r117 == null) goto L104;
        Intrinsics.checkNotNullParameter(r117, "$this$fanTicketDisplayStrExt");
        String r30 = r117.getFanTicketDisplayStr();
        if (r30 == null) goto L104;
    L105:
        String r118 = "identifier";
        String r31 = "user";
        if (r16 == true) goto L108;
    L166:
        Iterator r33 = r17.iterator();
    L168:
        if (r33.hasNext() == false) goto L378;
        IBaseUser r34 = (IBaseUser) r33.next();
        String r35 = r34.getIdString();
        if (r21 == null) goto L172;
        String r119 = r21.getIdString();
    L173:
        boolean r36 = r35.equals(r119);
        HashMap r120 = new HashMap();
        if (d == false) goto L386;
        Map<String, String> r121 = e;
        String r37 = (String) ((LinkedHashMap) r121).get(r34.getIdString());
        if (r37 != null) goto L178;
    L183:
        r37 = null;
    L184:
        if (r37 == null) goto L388;
    L188:
        r120.put(r31, r37);
    L193:
        zc6.a r38 = zc6.a.a;
        dq2.m r39 = zc6.b.b(this.a);
        Iterator r122 = r33;
        IBaseUser r210 = r21;
        if (r39 == null) goto L235;
        dq2.m r40 = r39;
        String r211 = r31;
        ArrayList r212 = r19;
        if (r40.c() != true) goto L236;
        com.bytedance.android.livesdk.chatroom.model.interact.a0 r41 = r40.a();
        if (r41 == null) goto L234;
        Intrinsics.checkNotNullParameter(r41, "$this$resultsFlexKmp");
        List r43 = r41.getResultsFlex();
        if (r43 == null) goto L234;
        Iterator r44 = r43.iterator();
    L203:
        if (r44.hasNext() == false) goto L208;
        Object r45 = r44.next();
        Iterator r213 = r44;
        com.bytedance.android.livesdk.chatroom.model.interact.a0.d r46 = (com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r45;
        String r47 = r34.getIdString();
        Intrinsics.checkNotNullParameter(r46, "$this$guestIdFlexStrKmp");
        if (r47.equals(r46.getGuestIdFlexStr()) == true) goto L206;
        r44 = r213;
        goto L203
    L206:
        Object r48 = r45;
    L209:
        com.bytedance.android.livesdk.chatroom.model.interact.a0.d r49 = (com.bytedance.android.livesdk.chatroom.model.interact.a0.d) r48;
        if (r49 != null) goto L213;
        if (r36 == false) goto L213;
        r120.put("count", r30);
    L233:
        Unit r50 = Unit.INSTANCE;
    L213:
        zc6.a r51 = zc6.a.a;
        com.bytedance.android.scope.j r53 = this.a;
        if (r49 == null) goto L216;
        Intrinsics.checkNotNullParameter(r49, "$this$guestIdFlexStrKmp");
        String r54 = r49.getGuestIdFlexStr();
    L217:
        long r214 = u2.a(r54);
        if (r49 == null) goto L222;
        Intrinsics.checkNotNullParameter(r49, "$this$contributorsFlexKmp");
        com.bytedance.android.livesdk.chatroom.model.interact.a0.e r55 = r49.getContributorsFlex();
        if (r55 == null) goto L222;
        Intrinsics.checkNotNullParameter(r55, "$this$userIdsFlexKmp");
        List r215 = r55.getUserIdsFlex();
    L223:
        if (r49 == null) goto L225;
        Intrinsics.checkNotNullParameter(r49, "$this$scoreFlexKmp");
        String r216 = r49.getScoreFlex();
    L226:
        if (r49 == null) goto L228;
        Intrinsics.checkNotNullParameter(r49, "$this$scoreFuzzyFlexKmp");
        String r217 = r49.getScoreFuzzyFlex();
    L229:
        String r56 = zc6.b.a(r53, r214, r215, r216, r217);
        if (r56 != null) goto L232;
        r56 = r111;
    L232:
        r120.put("count", r56);
        goto L233
    L228:
        r217 = null;
        goto L229
    L225:
        r216 = null;
    L222:
        r215 = null;
        goto L223
    L216:
        r54 = null;
        goto L217
    L208:
        r48 = null;
    L234:
        String r218 = r30;
        String r57 = r28;
        String r219 = r111;
        String r220 = r118;
    L328:
        zc6.a r58 = zc6.a.a;
        dq2.m r59 = zc6.b.b(this.a);
        if (r59 == null) goto L333;
        boolean r60 = true;
        if (r59.b() == true) goto L368;
    L334:
        dq2.v r61 = zc6.b.c(this.a);
        if (r61 != null) goto L337;
    L339:
        int r63 = x12.c.a(this.a);
        com.bytedance.android.scope.j r64 = this.a;
        Intrinsics.checkNotNullParameter(r58, "$this$modeUtils");
        Intrinsics.checkNotNullParameter(r64, "scope");
        gq2.b r65 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        r65.c();
        if (r65.d(r63, 4) == true) goto L369;
        r65.h();
        if (r65.d(r63, 16) == true) goto L369;
        r65.k();
        if (r65.d(r63, 64) == true) goto L369;
        com.bytedance.android.scope.j r66 = this.a;
        Intrinsics.checkNotNullParameter(r58, "$this$currentScene");
        Intrinsics.checkNotNullParameter(r66, "scope");
        int r67 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (r67 == 1) goto L369;
        if (r67 == 2) goto L369;
        if (r67 == 5) goto L368;
        if (r67 == 16) goto L368;
        if (r67 == 7) goto L369;
        if (r67 == 8) goto L368;
        if (r67 == 9) goto L369;
        if (r67 == 11) goto L369;
        if (r67 == 12) goto L368;
        String r68 = r34.getIdString();
        IRoom r69 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r69 == null) goto L366;
        String r70 = IRoomKt_androidKt.getAnchorId(r69);
    L367:
        boolean r71 = r68.equals(r70);
    L371:
        if (r71 == false) goto L373;
        r120.put("disable_display_count", Boolean.TRUE);
    L373:
        int r73 = b(r34);
        if (r73 != 1) goto L376;
        String r74 = r219;
        r120.put("count", r74);
        r120.put("disable_display_count", Boolean.TRUE);
    L377:
        String r75 = r220;
        r120.put(r75, Integer.valueOf(r73));
        ArrayList r76 = r212;
        r76.add(r120);
        r28 = r57;
        r19 = r76;
        r118 = r75;
        r111 = r74;
        r33 = r122;
        r21 = r210;
        r31 = r211;
        r30 = r218;
        goto L168
    L376:
        r74 = r219;
        goto L377
    L366:
        r70 = null;
    L369:
        r71 = true;
        goto L371
    L337:
        if (r61.e() != r60) goto L339;
    L368:
        r71 = false;
        goto L371
    L333:
        r60 = true;
    L236:
        dq2.v r77 = zc6.b.c(this.a);
        r220 = r118;
        r219 = r111;
        if (r77 == null) goto L274;
        String r221 = r28;
        if (r77.f() != true) goto L275;
        dq2.v r78 = zc6.b.c(this.a);
        if (r78 == null) goto L272;
        LinkMicTeamFightInfo r79 = r78.a();
        if (r79 == null) goto L272;
        String r80 = r34.getIdString();
        if (r80 != null) goto L247;
        r80 = BuildConfig.FLAVOR;
    L247:
        Intrinsics.checkNotNullParameter(r79, "$this$getPlayerByUserIdKmp");
        Intrinsics.checkNotNullParameter(r80, "userId");
        com.bytedance.android.live.liveinteract.multiscene.f r81 = com.bytedance.android.live.liveinteract.multiscene.b.b(r79, r80);
        if (r81 != null) goto L251;
        if (r36 == false) goto L251;
        r120.put("count", r30);
    L271:
        Unit r83 = Unit.INSTANCE;
    L251:
        com.bytedance.android.scope.j r84 = this.a;
        if (r81 == null) goto L254;
        Intrinsics.checkNotNullParameter(r81, "$this$userIdStringKmp");
        String r85 = r81.getUserIdString();
    L255:
        long r222 = u2.a(r85);
        if (r81 == null) goto L260;
        Intrinsics.checkNotNullParameter(r81, "$this$contributorsFlexKmp");
        com.bytedance.android.live.liveinteract.multiscene.f.b r86 = r81.getContributorsFlex();
        if (r86 == null) goto L260;
        Intrinsics.checkNotNullParameter(r86, "$this$userIdsFlexKmp");
        List r223 = r86.getUserIdsFlex();
    L261:
        if (r81 == null) goto L263;
        Intrinsics.checkNotNullParameter(r81, "$this$scoreStrFlexKmp");
        String r310 = r81.getScoreStrFlex();
    L264:
        if (r81 == null) goto L266;
        Intrinsics.checkNotNullParameter(r81, "$this$scoreFuzzyFlexKmp");
        String r311 = r81.getScoreFuzzyFlex();
    L267:
        String r87 = zc6.b.a(r84, r222, r223, r310, r311);
        if (r87 != null) goto L270;
        r87 = r219;
    L270:
        r120.put("count", r87);
        goto L271
    L266:
        r311 = null;
        goto L267
    L263:
        r310 = null;
    L260:
        r223 = null;
        goto L261
    L254:
        r85 = null;
    L272:
        r218 = r30;
    L273:
        r57 = r221;
    L275:
        com.bytedance.android.scope.j r88 = this.a;
        zc6.a r89 = zc6.a.a;
        Intrinsics.checkNotNullParameter(r89, "$this$linkRoomFightService");
        Intrinsics.checkNotNullParameter(r88, "scope");
        dq2.s r90 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).T9();
        if (r90 == null) goto L306;
        r218 = r30;
        if (r90.b() != true) goto L307;
        com.bytedance.android.scope.j r91 = this.a;
        Intrinsics.checkNotNullParameter(r89, "$this$linkRoomFightService");
        Intrinsics.checkNotNullParameter(r91, "scope");
        dq2.s r93 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).T9();
        if (r93 == null) goto L273;
        LinkMicTeamFightInfo r94 = r93.a();
        if (r94 == null) goto L273;
        String r95 = r34.getIdString();
        if (r95 != null) goto L286;
        r95 = BuildConfig.FLAVOR;
    L286:
        Intrinsics.checkNotNullParameter(r94, "$this$getPlayerByUserIdKmp");
        Intrinsics.checkNotNullParameter(r95, "userId");
        com.bytedance.android.live.liveinteract.multiscene.f r96 = com.bytedance.android.live.liveinteract.multiscene.b.b(r94, r95);
        com.bytedance.android.scope.j r97 = this.a;
        if (r96 == null) goto L289;
        Intrinsics.checkNotNullParameter(r96, "$this$userIdStringKmp");
        String r98 = r96.getUserIdString();
    L290:
        long r224 = u2.a(r98);
        if (r96 == null) goto L295;
        Intrinsics.checkNotNullParameter(r96, "$this$contributorsFlexKmp");
        com.bytedance.android.live.liveinteract.multiscene.f.b r99 = r96.getContributorsFlex();
        if (r99 == null) goto L295;
        Intrinsics.checkNotNullParameter(r99, "$this$userIdsFlexKmp");
        List r312 = r99.getUserIdsFlex();
    L296:
        if (r96 == null) goto L298;
        Intrinsics.checkNotNullParameter(r96, "$this$scoreStrFlexKmp");
        String r313 = r96.getScoreStrFlex();
    L299:
        if (r96 == null) goto L301;
        Intrinsics.checkNotNullParameter(r96, "$this$scoreFuzzyFlexKmp");
        String r314 = r96.getScoreFuzzyFlex();
    L302:
        String r100 = zc6.b.a(r97, r224, r312, r313, r314);
        if (r100 != null) goto L305;
        r100 = r219;
    L305:
        r120.put("count", r100);
        Unit r101 = Unit.INSTANCE;
        goto L273
    L301:
        r314 = null;
        goto L302
    L298:
        r313 = null;
    L295:
        r312 = null;
        goto L296
    L289:
        r98 = null;
    L307:
        List<ILinkPlayerInfoBridge> r102 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.v.b(this.a, this.b);
        if (r102 == null) goto L325;
        Iterator<T> r103 = r102.iterator();
    L311:
        if (r103.hasNext() == false) goto L319;
        Object r104 = r103.next();
        IBaseUser r105 = com.bytedance.android.live.liveinteract.plantform.model.n.d((ILinkPlayerInfoBridge) r104);
        if (r105 == null) goto L315;
        String r106 = r105.getIdString();
    L317:
        if (Intrinsics.areEqual(r106, r34.getIdString()) == false) goto L311;
    L320:
        ILinkPlayerInfoBridge r107 = (ILinkPlayerInfoBridge) r104;
        if (r107 == null) goto L325;
        r57 = r221;
        Intrinsics.checkNotNullParameter(r107, r57);
        String r108 = r107.getFanTicketDisplayStr();
        if (r108 == null) goto L326;
    L327:
        r120.put("count", r108);
    L326:
        r108 = r219;
        goto L327
    L315:
        r106 = null;
        goto L317
    L319:
        r104 = null;
    L325:
        r57 = r221;
        goto L326
    L306:
        r218 = r30;
        goto L307
    L274:
        r221 = r28;
        goto L275
    L235:
        r212 = r19;
        r211 = r31;
        goto L236
    L388:
        r37 = l97.a.a.toJson(r34);     // Catch: Throwable -> L187
        r121.put(r34.getIdString(), r37);     // Catch: Throwable -> L187
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L187
    L187:
        r37 = BuildConfig.FLAVOR;
        goto L188
    L178:
        if (r37.length() <= 0) goto L180;
        boolean r124 = true;
    L181:
        if (r124 == false) goto L183;
    L180:
        r124 = false;
        goto L181
    L386:
        String r109 = l97.a.a.toJson(r34);     // Catch: Throwable -> L191
    L192:
        r120.put(r31, r109);
    L191:
        r109 = BuildConfig.FLAVOR;
        goto L192
    L172:
        r119 = null;
    L378:
        ArrayList r125 = r19;
        Map r126 = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, 0), TuplesKt.to(3, 1), TuplesKt.to(4, 2), TuplesKt.to(1, 3), TuplesKt.to(5, 5), TuplesKt.to(6, 6), TuplesKt.to(7, 7)});
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L381;
    L390:
        return l97.a.a.toJson(r125);
    L419:
        return BuildConfig.FLAVOR;
    L381:
        if (r125.size() <= 1) goto L390;
        CollectionsKt.sortWith(r125, new b(r126));
        goto L390
    L108:
        if ((!r18.isEmpty()) == false) goto L166;
        i12.e r127 = i12.o.b();
        if (r127 == null) goto L112;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r128 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r127).a(Reflection.getOrCreateKotlinClass(GroupLiveReceiverService.class));
    L113:
        GroupLiveReceiverService r129 = (GroupLiveReceiverService) r128;
        if (r129 != null) goto L116;
    L150:
        Iterator<t2> r130 = r18.iterator();
    L152:
        if (r130.hasNext() == false) goto L378;
        t2 r131 = r130.next();
        IBaseUser r132 = r131.getUser();
        if (r132 == null) goto L152;
        HashMap r133 = new HashMap();
        String r134 = l97.a.a.toJson(r131.getUser());     // Catch: Throwable -> L159
    L160:
        r133.put("user", r134);
        r133.put("count", Long.valueOf(r131.getScore()));
        r133.put("identifier", Integer.valueOf(b(r132)));
        com.bytedance.android.livesdk.gift.model.j0 r135 = r131.getExtraInfo();
        if (r135 == null) goto L165;
        String r136 = r135.getLabel();
        if (r136 == null) goto L165;
        r133.put("status_label", r136);
        Unit r137 = Unit.INSTANCE;
    L165:
        r19.add(r133);
    L159:
        r134 = BuildConfig.FLAVOR;
        goto L160
    L116:
        if (r129.i() != true) goto L150;
        Intrinsics.checkNotNullParameter(r18, "newGroupUserList");
        ArrayList r138 = new ArrayList();
        Iterator<T> r139 = r18.iterator();
    L119:
        if (r139.hasNext() == false) goto L149;
        t2 r140 = (t2) r139.next();
        if (r140.getUser() != null) goto L123;
        HashMap r141 = null;
    L147:
        if (r141 == null) goto L119;
        r138.add(r141);
        goto L119
    L123:
        r141 = new HashMap();
        r141.put("user", GsonProtectorUtils.toJson(l97.a.a, r140.getUser()));
        r141.put("count", Long.valueOf(r140.getScore()));
        com.bytedance.android.livesdk.gift.model.j0 r142 = r140.getExtraInfo();
        if (r142 == null) goto L128;
        String r143 = r142.getLabel();
        if (r143 == null) goto L128;
        r141.put("status_label", r143);
    L128:
        IBaseUser r144 = r140.getUser();
        if (r144 == null) goto L131;
        String r145 = r144.getIdString();
    L133:
        if (Intrinsics.areEqual(r145, r129.d().getIdString()) == false) goto L135;
        int r146 = 2;
    L146:
        r141.put("identifier", Integer.valueOf(r146));
        goto L147
    L135:
        IBaseUser r147 = r129.f();
        if (r147 == null) goto L138;
        String r148 = r147.getIdString();
    L140:
        if (Intrinsics.areEqual(r145, r148) == true) goto L142;
    L145:
        r146 = 6;
        goto L146
    L142:
        if (r129.b == true) goto L145;
        r146 = 7;
        goto L146
    L138:
        r148 = null;
        goto L140
    L131:
        r145 = null;
        goto L133
    L149:
        r19.addAll(r138);
        goto L378
    L112:
        r128 = null;
        goto L113
    L94:
        r115 = null;
    L96:
        r116 = false;
        goto L97
    L99:
        r112 = null;
    L104:
        r30 = "0";
    L69:
        r21 = null;
    L63:
        r18 = CollectionsKt.emptyList();
        goto L64
    L51:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.w.a() == false) goto L59;
        if (r16 == false) goto L59;
        if (r3 == null) goto L59;
        List<com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h> r149 = r3.y(r9);
        ArrayList r150 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r149, 10));
        Iterator r151 = ((ArrayList) r149).iterator();
    L56:
        if (r151.hasNext() == false) goto L58;
        r150.add(((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.h) r151.next()).a);
        goto L56
    L58:
        Unit r152 = Unit.INSTANCE;
        r5 = r150;
    L47:
        r16 = false;
    L19:
        i12.e r153 = i12.o.b();
        if (r153 == null) goto L22;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r154 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r153).a(Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.class));
    L23:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r155 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y) r154;
        if (r155 == null) goto L26;
        r9 = r155.i();
        goto L27
    L26:
        r9 = null;
        goto L27
    L22:
        r154 = null;
        goto L23
    L14:
        r7 = null;
    L10:
        r5 = CollectionsKt.emptyList();
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static int b(IBaseUser r5) {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        com.bytedance.android.scope.m.e.getClass();
        com.bytedance.android.scope.o r1 = (com.bytedance.android.scope.o) com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(GiftReceiverRepoService.class));
    L6:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 != null) goto L10;
        return 0;
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.c.b(r5) == false) goto L13;
        return 2;
    L13:
        if (r2.K(r5, 4) == false) goto L17;
        return 3;
    L17:
        if (r2.K(r5, 2) == false) goto L20;
        return 4;
    L20:
        if (r2.K(r5, 1024) == false) goto L24;
        return 1;
    L24:
        if (r2.K(r5, 8) == false) goto L27;
        return 5;
    L27:
        return 0;
    L5:
        r1 = null;
        goto L6
    }

    public k(com.bytedance.android.scope.j r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
    }
}
