package com.larus.dora.impl.noti_v3;

import com.bytedance.dora.device.DoraDevice;
import com.google.gson.Gson;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.f0;
import com.larus.dora.impl.network.g0;
import com.larus.dora.impl.network.s;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo;
import com.larus.dora.impl.util.b0;
import g49.d;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class NotificationBroadcastV3Tracker {
    public static final NotificationBroadcastV3Tracker a = null;
    public static final CoroutineScope b = null;
    public static final Map<String, Boolean> c = null;

    public NotificationBroadcastV3Tracker() {
    }

    static {
        a = new NotificationBroadcastV3Tracker();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Boolean r1 = Boolean.TRUE;
        Boolean r2 = Boolean.FALSE;
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("finance_security", r1), TuplesKt.to("schedule", r1), TuplesKt.to("life_service", r1), TuplesKt.to("news_info", r2), TuplesKt.to("entertainment_recommendation", r2)});
    }

    public static void g() {
        BuildersKt.launch$default(b, null, null, new NotificationBroadcastV3Tracker$reportSettingsResultOnConnected$1(null), 3, null);
    }

    public static String e(String r1) {
        if (r1 != null) goto L5;
        r1 = "1";
    L5:
        if (Intrinsics.areEqual(r1, "0") == false) goto L8;
        return "all";
    L8:
        if (Intrinsics.areEqual(r1, "2") == false) goto L10;
        return "off";
    L10:
        return "important_only";
    }

    public static String f(Boolean r1) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L5;
        return "on";
    L5:
        return "off";
    }

    public final Object c(Continuation<? super f0> r5) {
        if ((r5 instanceof NotificationBroadcastV3Tracker$loadFreshUserSettings$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadFreshUserSettings$1 r0 = (NotificationBroadcastV3Tracker$loadFreshUserSettings$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L17:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 == null) goto L22;
        d.c("NotificationBroadcastV3Tracker", "loadFreshUserSettings failed, fallback to cache", r4);
        DoraUserSettingsManager r8 = DoraUserSettingsManager.a;
        return DoraUserSettingsManager.c;
    L22:
        return r7;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        DoraNetworkApi r9 = DoraNetworkApi.a;
        r0.label = 1;
        r7 = r9.v(true, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new NotificationBroadcastV3Tracker$loadFreshUserSettings$1(this, r5);
        goto L8
    }

    public final Object d(Continuation<? super Integer> r5) {
        if ((r5 instanceof NotificationBroadcastV3Tracker$loadSelectedRuleCount$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadSelectedRuleCount$1 r0 = (NotificationBroadcastV3Tracker$loadSelectedRuleCount$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L17:
        Throwable r4 = Result.exceptionOrNull-impl(r7);
        if (r4 == null) goto L21;
        d.c("NotificationBroadcastV3Tracker", "loadSelectedRuleCount failed", r4);
        r7 = CollectionsKt.emptyList();
    L21:
        List r8 = (List) r7;
        int r9 = 0;
        if ((r8 instanceof Collection) == true) goto L24;
    L26:
        Iterator r10 = r8.iterator();
    L28:
        if (r10.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(((NotificationRule) r10.next()).getStatus(), Boxing.boxBoolean(true)) == false) goto L28;
        r9 = r9 + 1;
        if (r9 >= 0) goto L28;
        CollectionsKt.throwCountOverflow();
    L35:
        return Boxing.boxInt(r9);
    L24:
        if (r8.isEmpty() == false) goto L26;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        DoraNotificationRuleRepo r11 = DoraNotificationRuleRepo.a;
        r0.label = 1;
        r7 = r11.e(r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new NotificationBroadcastV3Tracker$loadSelectedRuleCount$1(this, r5);
        goto L8
    }

    public final Object b(DoraDevice r5, Continuation<? super Map<String, ? extends Object>> r6) {
        if ((r6 instanceof NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1) == false) goto L7;
        NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1 r0 = (NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L17:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L22;
        d.c("NotificationBroadcastV3Tracker", "loadFreshDeviceInfo failed, fallback to memory state", r9);
        return null;
    L22:
        return ((com.larus.dora.impl.network.d) r8).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        List<String> r10 = q59.c.a;
        List<String> r11 = CollectionsKt.plus(q59.c.a, "wearing_reminder_switch");
        DoraNetworkApi r4 = DoraNetworkApi.a;
        r0.label = 1;
        r8 = r4.l(r5, r11, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new NotificationBroadcastV3Tracker$loadFreshDeviceInfo$1(this, r6);
        goto L8
    }

    public static final Object a(NotificationBroadcastV3Tracker r17, DoraDevice r18, Continuation r110) {
        r17.getClass();
        if ((r110 instanceof NotificationBroadcastV3Tracker$buildSettingsParams$1) == false) goto L7;
        NotificationBroadcastV3Tracker$buildSettingsParams$1 r2 = (NotificationBroadcastV3Tracker$buildSettingsParams$1) r110;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        List r1 = (List) r2.L$4;
        Map<String, Boolean> r6 = (Map) r2.L$3;
        q59.a r7 = (q59.a) r2.L$2;
        Map r10 = (Map) r2.L$1;
        f0 r8 = (f0) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L66:
        int r11 = ((Number) r0).intValue();
        Pair[] r12 = new Pair[15];
        g0 r9 = r8.d();
        if (r9 == null) goto L69;
        String r13 = r9.g();
    L70:
        String r14 = "on";
        if (Intrinsics.areEqual(r13, "1") == false) goto L73;
        Object r15 = "on";
    L74:
        r12[0] = TuplesKt.to("broadcast_switch", r15);
        r12[1] = TuplesKt.to("private_chat_mode", e(r7.c));
        r12[2] = TuplesKt.to("group_chat_mode", e(r7.d));
        String r16 = r7.f;
        if (r16 != null) goto L77;
    L80:
        boolean r20 = true;
    L81:
        if (r20 == false) goto L185;
        int r21 = 0;
    L109:
        r12[3] = TuplesKt.to("special_contact_cnt", Boxing.boxInt(r21));
        r12[4] = TuplesKt.to("finance_security_on", f(r6.get("finance_security")));
        r12[5] = TuplesKt.to("schedule_on", f(r6.get("schedule")));
        r12[6] = TuplesKt.to("life_service_on", f(r6.get("life_service")));
        r12[7] = TuplesKt.to("news_info_on", f(r6.get("news_info")));
        r12[8] = TuplesKt.to("entertainment_on", f(r6.get("entertainment_recommendation")));
        List r22 = r1;
        if ((r22 instanceof Collection) == true) goto L112;
    L114:
        Iterator r23 = r22.iterator();
        int r24 = 0;
    L116:
        if (r23.hasNext() == false) goto L125;
        if (((s) r23.next()).e() != 2) goto L120;
        boolean r25 = true;
    L121:
        if (r25 == false) goto L116;
        r24 = r24 + 1;
        if (r24 >= 0) goto L116;
        CollectionsKt.throwCountOverflow();
        goto L116
    L120:
        r25 = false;
    L125:
        r12[9] = TuplesKt.to("disabled_app_cnt", Boxing.boxInt(r24));
        r12[10] = TuplesKt.to("custom_rule_selected_cnt", Boxing.boxInt(r11));
        String r26 = r7.b;
        if (r26 != null) goto L128;
        r26 = "10";
    L128:
        int r27 = r26.hashCode();
        if (r27 == 48) goto L143;
        if (r27 == 51) goto L140;
        if (r27 == 1629) goto L136;
    L144:
        String r28 = "summary_10s";
    L146:
        r12[11] = TuplesKt.to("broadcast_rhythm", r28);
        String r30 = r7.a;
        if (r30 != null) goto L150;
        r30 = "1";
    L150:
        if (Intrinsics.areEqual(r30, "0") == false) goto L152;
        String r31 = "not_broadcast";
    L153:
        r12[12] = TuplesKt.to("broadcast_conflict_mode", r31);
        int r32 = kj4.a.g().D();
        b0.a.getClass();
        if (b0.r() == true) goto L156;
    L158:
        boolean r33 = false;
    L159:
        r12[13] = TuplesKt.to("shake_head_stop_switch", f(Boxing.boxBoolean(r33)));
        if (r10 == null) goto L164;
        Object r34 = r10.get("wearing_reminder_switch");
        if (r34 == null) goto L164;
        String r35 = r34.toString();
    L165:
        if (r35 == null) goto L182;
        int r36 = r35.hashCode();
        if (r36 == 49) goto L181;
        if (r36 == 50) goto L177;
        if (r36 != 1444) goto L182;
        if (r35.equals("-1") == false) goto L182;
    L179:
        r14 = "off";
    L183:
        r12[14] = TuplesKt.to("wear_greeting_switch", r14);
        return MapsKt.mapOf(r12);
    L177:
        if (r35.equals("2") == true) goto L179;
    L181:
        if (r35.equals("1") == true) goto L183;
    L182:
        r14 = f(Boolean.valueOf(Intrinsics.areEqual(DoraUserSettingsManager.w.getValue(), Boolean.TRUE)));
    L164:
        r35 = null;
        goto L165
    L156:
        if (r32 != 2) goto L158;
        r33 = true;
        goto L159
    L152:
        r31 = "lower_media";
        goto L153
    L136:
        if (r26.equals("30") == false) goto L144;
        r28 = "summary_30s";
        goto L146
    L140:
        if (r26.equals("3") == false) goto L144;
    L145:
        r28 = "realtime";
        goto L146
    L143:
        if (r26.equals("0") == true) goto L145;
    L112:
        if (r22.isEmpty() == false) goto L114;
        r24 = 0;
        goto L125
    L185:
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L102
        Type r38 = new a().getType();     // Catch: Throwable -> L102
        List r40 = (List) new Gson().fromJson(r16, r38);     // Catch: Throwable -> L102
        if (r40 == null) goto L99;
        List r41 = r40;     // Catch: Throwable -> L102
        if ((r41 instanceof Collection) == true) goto L88;
    L90:
        Iterator r42 = r41.iterator();     // Catch: Throwable -> L102
        int r43 = 0;
    L92:
        if (r42.hasNext() == false) goto L100;
        if (Intrinsics.areEqual(((y59.a) r42.next()).e(), Boolean.TRUE) == false) goto L92;
        r43 = r43 + 1;     // Catch: Throwable -> L102
        if (r43 >= 0) goto L92;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L102
    L100:
        Object r44 = Result.constructor-impl(Integer.valueOf(r43));     // Catch: Throwable -> L102
    L104:
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L108;
        d.c("NotificationBroadcastV3Tracker", "countSelectedSpecialContacts failed", r45);
        r44 = 0;
    L108:
        r21 = ((Number) r44).intValue();
        goto L109
    L88:
        if (r41.isEmpty() == false) goto L90;
    L99:
        r43 = 0;
    L102:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L104
    L77:
        if (StringsKt.isBlank(r16) == true) goto L80;
        r20 = false;
        goto L81
    L73:
        r15 = "off";
        goto L74
    L69:
        r13 = null;
        goto L70
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        f0 r47 = (f0) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L24:
        r10 = (Map) r0;
        if (r10 == null) goto L27;
        q59.a r48 = q59.b.b(r10);
    L28:
        q59.a r111 = r48;
        String r50 = r111.g;
        if (r50 != null) goto L31;
    L34:
        boolean r112 = true;
    L35:
        if (r112 == false) goto L187;
        Map<String, Boolean> r51 = c;
    L56:
        List r113 = r47.c();
        if (r113 == null) goto L61;
        List r114 = CollectionsKt.filterNotNull(r113);
        if (r114 == null) goto L61;
    L62:
        r2.L$0 = r47;
        r2.L$1 = r10;
        r2.L$2 = r111;
        r2.L$3 = r51;
        r2.L$4 = r114;
        r2.label = 3;
        Object r52 = r17.d(r2);
        if (r52 == r4) goto L208;
        r6 = r51;
        r0 = r52;
        r8 = r47;
        r7 = r111;
        r1 = r114;
        goto L66
    L208:
        return r4;
    L61:
        r114 = (List) DoraUserSettingsManager.k.getValue();
        goto L62
    L187:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L49
        Type r116 = new b().getType();     // Catch: Throwable -> L49
        List r53 = (List) new Gson().fromJson(r50, r116);     // Catch: Throwable -> L49
        if (r53 != null) goto L40;
        r53 = CollectionsKt.emptyList();     // Catch: Throwable -> L49
    L40:
        Map r117 = MapsKt.toMutableMap(c);     // Catch: Throwable -> L49
        Iterator r54 = r53.iterator();     // Catch: Throwable -> L49
    L42:
        if (r54.hasNext() == false) goto L47;
        c r118 = (c) r54.next();     // Catch: Throwable -> L49
        String r119 = r118.b();     // Catch: Throwable -> L49
        if (r119 == null) goto L42;
        r117.put(r119, Boolean.valueOf(r118.a()));     // Catch: Throwable -> L49
        goto L42
    L47:
        Object r55 = Result.constructor-impl(r117);     // Catch: Throwable -> L49
    L51:
        Throwable r120 = Result.exceptionOrNull-impl(r55);
        if (r120 == null) goto L55;
        d.c("NotificationBroadcastV3Tracker", "parseServiceConfigList failed, fallback to defaults", r120);
        r55 = c;
    L55:
        r51 = (Map) r55;
    L49:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r55 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L51
    L31:
        if (StringsKt.isBlank(r50) == true) goto L34;
        r112 = false;
        goto L35
    L27:
        r48 = (q59.a) DoraUserSettingsManager.m.getValue();
        goto L28
    L17:
        DoraDevice r56 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Object r57 = r0;
        DoraDevice r58 = r56;
    L21:
        r47 = (f0) r57;
        r2.L$0 = r47;
        r2.label = 2;
        r0 = r17.b(r58, r2);
        if (r0 != r4) goto L24;
        return r4;
    L18:
        ResultKt.throwOnFailure(r0);
        r58 = r18;
        r2.L$0 = r58;
        r2.label = 1;
        r57 = r17.c(r2);
        if (r57 != r4) goto L21;
        return r4;
    L7:
        r2 = new NotificationBroadcastV3Tracker$buildSettingsParams$1(r17, r110);
        goto L8
    }
}
