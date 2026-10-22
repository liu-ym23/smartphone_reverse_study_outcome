package e11;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.a7;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.bridge.m0;
import com.bytedance.android.livesdk.link.model.bridge.n0;
import com.bytedance.android.livesdk.link.model.f;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.v;
import com.bytedance.badger.collect.impl.constants.Constants;
import d11.h;
import d11.i;
import d11.j;
import d11.k;
import d11.l;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b {
    public a() {
    }

    public static void k(Map r3, uz0.c r4) {
        Map<String, String> r5 = r4.b;
        Intrinsics.checkNotNullParameter(r5, "queriesMap");
        Iterator r6 = r3.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Map.Entry r0 = (Map.Entry) r6.next();
        String r1 = (String) r0.getKey();
        Object r2 = r0.getValue();
        if (r2 == null) goto L8;
        String r7 = r2.toString();
    L9:
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$setTo");
        r5.put(r1, r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    }

    public final Observable<ExtraResponse<f, Extra>> c(h r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12.getRoomId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("room_id", r3);
    L5:
        String r4 = Long.valueOf(r12.getToRoomId()).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("to_room_id", r4);
    L8:
        String r5 = Long.valueOf(r12.getApplyType()).toString();
        Intrinsics.checkNotNullParameter("apply_type", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("apply_type", r5);
    L11:
        String r6 = Long.valueOf(r12.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("scene", r6);
    L14:
        String r7 = Long.valueOf(r12.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r7 == null) goto L17;
        r2.put("channel_id", r7);
    L17:
        String r8 = r12.getClientAttachedInfo();
        Intrinsics.checkNotNullParameter("client_attached_info", "$this$setTo");
        if (r8 == null) goto L20;
        r2.put("client_attached_info", r8);
    L20:
        int r9 = f11.a.a;
        r12.l();
        Intrinsics.checkNotNullParameter(r12, "$this$revUserId");
        String r14 = r12.getToOpenId();
        HashMap r10 = new HashMap();
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        r10.put("to_open_id", r14);
        if (r13 == null) goto L26;
        r10.putAll(r13);
    L26:
        k(r10, r1);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/apply/", TypesJVMKt.getJavaType(Reflection.typeOf(f.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final Observable<ExtraResponse<Object, Extra>> d(i r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("channel_id", r3);
    L5:
        String r4 = Long.valueOf(r12.getToRoomId()).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("to_room_id", r4);
    L8:
        String r5 = Long.valueOf(r12.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("scene", r5);
    L11:
        String r6 = Integer.valueOf(r12.getCancelType()).toString();
        Intrinsics.checkNotNullParameter("cancel_type", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("cancel_type", r6);
    L14:
        String r7 = r12.getRequestSource();
        String r8 = "";
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r7);
        int r9 = f11.a.a;
        Intrinsics.checkNotNullParameter(r12, "$this$toRevUid");
        String r10 = r12.getToOpenId();
        r12.l();
        Pair[] r14 = new Pair[1];
        if (r10 == null) goto L21;
        r8 = r10;
    L21:
        r14[0] = TuplesKt.to("to_open_id", r8);
        Map r15 = MapsKt.mutableMapOf(r14);
        if (r13 != null) goto L24;
        r13 = MapsKt.emptyMap();
    L24:
        r15.putAll(r13);
        k(r15, r1);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/cancel/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final Observable<ExtraResponse<m0, Extra>> g(j r17, Map<String, String> r18) {
        Intrinsics.checkNotNullParameter(r17, "params");
        tz0.b r2 = tz0.b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        uz0.f r4 = new uz0.f(r3.b);
        r4.a("to_room_id", Long.valueOf(r17.getToRoomId()).toString());
        r4.a("room_id", Long.valueOf(r17.getRoomId()).toString());
        r4.a("invite_type", Long.valueOf(r17.getInviteType()).toString());
        r4.a("match_type", r17.getMatchType());
        r4.a("scene", Long.valueOf(r17.getScene()).toString());
        String r5 = r17.getTheme();
        String r6 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.a(FileUtils.PICTURE_THEME, r5);
        r4.a(Constants.Keys.duration, Long.valueOf(r17.getDuration()).toString());
        String r7 = r17.getActivityName();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r4.a("activity_name", r7);
        r4.a("match_sub_type", Integer.valueOf(r17.p1()).toString());
        r4.a("invite_source", Integer.valueOf(r17.getInviteSource()).toString());
        r4.a("invitee_scene", Long.valueOf(r17.y5()).toString());
        r4.a("multi_pk_mode", Integer.valueOf(r17.getMultiPkMode()).toString());
        String r8 = r17.getBattleConfigSetting();
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        r4.a("battle_config_setting", r8);
        String r9 = r17.getBattleAttachedInfo();
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r4.a("battle_attached_info", r9);
        r4.a("invite_status", Integer.valueOf(r17.getInviteStatus()).toString());
        r4.a("client_attached_info", r17.getClientAttachedInfo());
        String r10 = r17.s();
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r4.a("open_game_app_id", r10);
        if (r17.j() <= 0) goto L21;
        r4.a("bitrate_kbps", Long.valueOf(r17.j()).toString());
    L21:
        if (r17.K() <= 0) goto L24;
        r4.a("resolution_width", Long.valueOf(r17.K()).toString());
    L24:
        if (r17.x() <= 0) goto L26;
        r4.a("resolution_height", Long.valueOf(r17.x()).toString());
    L26:
        r4.a("channel_id", Long.valueOf(r17.getChannelId()).toString());
        r4.a("biz_type", Integer.valueOf(r17.getBizType()).toString());
        int r12 = f11.a.a;
        Intrinsics.checkNotNullParameter(r17, "$this$toRevUid");
        String r13 = r17.getToOpenId();
        r17.l();
        Intrinsics.checkNotNullParameter(r17, "$this$inviteeUserIds");
        List r0 = StringsKt.split$default(r17.Q6(), new String[]{","}, false, 0, 6, null);
        HashMap r14 = new HashMap();
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r14.put("to_open_id", r13);
        if (r0 == null) goto L32;
        String r1 = CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null);
    L33:
        if (r1 == null) goto L36;
        r6 = r1;
    L36:
        r14.put("invitee_followed_user_ids", r6);
        if (r18 == null) goto L40;
        r14.putAll(r18);
    L40:
        if (r14.isEmpty() == false) goto L42;
        r14 = null;
    L42:
        if (r14 == null) goto L44;
        k(r14, r3);
    L44:
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/invite/", TypesJVMKt.getJavaType(Reflection.typeOf(m0.class)), Extra.class, r3.d, r3.a, r3.b, r3.c);
    L32:
        r1 = null;
        goto L33
    }

    public final Observable<ExtraResponse<v, Extra>> j(k r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12.getChannelId()).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("channel_id", r3);
    L5:
        String r4 = Long.valueOf(r12.Z3()).toString();
        Intrinsics.checkNotNullParameter("permit_status", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("permit_status", r4);
    L8:
        String r5 = Long.valueOf(r12.getRoomId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("room_id", r5);
    L11:
        String r6 = Long.valueOf(r12.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("scene", r6);
    L14:
        int r7 = f11.a.a;
        Intrinsics.checkNotNullParameter(r12, "$this$applyRevUid");
        String r8 = r12.Z0();
        r12.j7();
        Pair[] r14 = new Pair[1];
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        r14[0] = TuplesKt.to("apply_open_id", r8);
        Map r15 = MapsKt.mutableMapOf(r14);
        if (r13 != null) goto L20;
        r13 = MapsKt.emptyMap();
    L20:
        r15.putAll(r13);
        k(r15, r1);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/permit/", TypesJVMKt.getJavaType(Reflection.typeOf(v.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final Observable<ExtraResponse<d1, Extra>> l(l r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r12, "params");
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("channel_id", Long.valueOf(r12.getChannelId()).toString());
        r2.a("room_id", Long.valueOf(r12.getRoomId()).toString());
        r2.a("reply_status", Long.valueOf(r12.getReplyStatus()).toString());
        r2.a("scene", Long.valueOf(r12.getScene()).toString());
        r2.a("multi_pk_mode", Integer.valueOf(r12.getMultiPkMode()).toString());
        r2.a("switch_play_mode", Integer.valueOf(r12.getSwitchPlayMode()).toString());
        r2.a("match_type", Long.valueOf(r12.getMatchType()).toString());
        String r3 = r12.getClientAttachedInfo();
        String r4 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.a("client_attached_info", r3);
        if (r12.s().length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        r2.a("open_game_app_id", r12.s());
    L12:
        if (r12.j() <= 0) goto L15;
        r2.a("bitrate_kbps", Long.valueOf(r12.j()).toString());
    L15:
        if (r12.K() <= 0) goto L18;
        r2.a("resolution_width", Long.valueOf(r12.K()).toString());
    L18:
        if (r12.x() <= 0) goto L20;
        r2.a("resolution_height", Long.valueOf(r12.x()).toString());
    L20:
        r2.a("biz_type", Integer.valueOf(r12.getBizType()).toString());
        int r6 = f11.a.a;
        Intrinsics.checkNotNullParameter(r12, "$this$inviteRevUid");
        String r7 = r12.V5();
        r12.N8();
        Pair[] r14 = new Pair[1];
        if (r7 == null) goto L24;
        r4 = r7;
    L24:
        r14[0] = TuplesKt.to("invite_open_id", r4);
        Map r15 = MapsKt.mutableMapOf(r14);
        if (r13 != null) goto L27;
        r13 = MapsKt.emptyMap();
    L27:
        r15.putAll(r13);
        k(r15, r1);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(d1.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L8:
        r5 = false;
        goto L9
    }

    public final Observable<ExtraResponse<a7, Extra>> f(long r12, long r13, int r15) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r14 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r14 == null) goto L5;
        r2.put("channel_id", r14);
    L5:
        String r16 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r16 == null) goto L8;
        r2.put("room_id", r16);
    L8:
        String r17 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        if (r17 == null) goto L11;
        r2.put("request_source", r17);
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/get_cross_room_rtc_info/", TypesJVMKt.getJavaType(Reflection.typeOf(a7.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // e11.b
    public final Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r12, String r13, int r14) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r15 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r15 == null) goto L5;
        r2.put("channel_id", r15);
    L5:
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        Intrinsics.checkNotNullParameter("content", "$this$setTo");
        r2.put("content", r13);
        String r16 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r16 == null) goto L10;
        r2.put("scene", r16);
    L10:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/send_signal/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final Observable h(long r12, int r13, int r14, int r15) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r16 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r16 == null) goto L5;
        r2.put("channel_id", r16);
    L5:
        String r17 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("is_from_audience", "$this$setTo");
        if (r17 == null) goto L8;
        r2.put("is_from_audience", r17);
    L8:
        String r18 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r18 == null) goto L11;
        r2.put("scene", r18);
    L11:
        Long r19 = 0L;
        String r110 = r19.toString();
        Intrinsics.checkNotNullParameter("resource_id", "$this$setTo");
        if (r110 == null) goto L14;
        r2.put("resource_id", r110);
    L14:
        String r111 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("match_type", "$this$setTo");
        if (r111 == null) goto L17;
        r2.put("match_type", r111);
    L17:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/join_channel/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.link.model.bridge.f.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final Observable<ExtraResponse<n0, Extra>> a(long r12, int r13, String r14, long r15, int r17) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("channel_id", r3);
    L5:
        String r4 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("scene", r4);
    L8:
        if (r14 != null) goto L10;
        String r5 = "";
    L11:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r5);
        String r6 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("room_id", r6);
    L14:
        String r7 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("leave_source", "$this$setTo");
        if (r7 == null) goto L17;
        r2.put("leave_source", r7);
    L17:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/leave/", TypesJVMKt.getJavaType(Reflection.typeOf(n0.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L10:
        r5 = r14;
        goto L11
    }

    public final Observable<ExtraResponse<Object, Extra>> e(long r12, int r13, int r14, String r15, String r16) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("channel_id", r3);
    L5:
        String r4 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("is_to_audience", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("is_to_audience", r4);
    L8:
        String r5 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("scene", r5);
    L11:
        if (r15 != null) goto L13;
        String r6 = "";
    L14:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r6);
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        r2.put("room_id", r16);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/finish/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L13:
        r6 = r15;
        goto L14
    }

    public final Observable<ExtraResponse<Object, Extra>> b(long r5, long r7, String r9, String r10, long r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "linkmicId");
        Intrinsics.checkNotNullParameter(r10, "rtcInfo");
        Intrinsics.checkNotNullParameter(r13, "requestSource");
        tz0.b r0 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        String r6 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("linker_id", "$this$setTo");
        if (r6 == null) goto L5;
        r1.put("linker_id", r6);
    L5:
        String r8 = Long.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r8 == null) goto L8;
        r1.put("room_id", r8);
    L8:
        Intrinsics.checkNotNullParameter("linkmic_id", "$this$setTo");
        r1.put("linkmic_id", r9);
        Intrinsics.checkNotNullParameter("rtc_ext_info", "$this$setTo");
        r1.put("rtc_ext_info", r10);
        String r14 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("mix_type", "$this$setTo");
        if (r14 == null) goto L11;
        r1.put("mix_type", r14);
    L11:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r1.put("request_source", r13);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/media_info_change_call_back/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    public final Observable<ExtraResponse<Object, Extra>> i(long r12, String r13, String r14, int r15, String r16, int r17) {
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("channel_id", r3);
    L5:
        String r4 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("scene", r4);
    L8:
        String r5 = "";
        if (r16 != null) goto L11;
        String r6 = "";
    L12:
        Intrinsics.checkNotNullParameter("request_source", "$this$setTo");
        r2.put("request_source", r6);
        String r7 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("kick_out_source", "$this$setTo");
        if (r7 == null) goto L15;
        r2.put("kick_out_source", r7);
    L15:
        int r8 = f11.a.a;
        Pair[] r9 = new Pair[2];
        if (r13 != null) goto L18;
        String r10 = "";
    L19:
        r9[0] = TuplesKt.to("to_open_id", r10);
        if (r14 == null) goto L23;
        r5 = r14;
    L23:
        r9[1] = TuplesKt.to("sec_to_user_id", r5);
        Map r18 = MapsKt.mapOf(r9);
        if (r18 == null) goto L26;
        k(r18, r1);
    L26:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/kick_out/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L18:
        r10 = r13;
        goto L19
    L11:
        r6 = r16;
        goto L12
    }

    @Override // e11.b
    public final Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r10, long r12, long r14, long r16, int r18, boolean r19, String r20, long r22) {
        tz0.b r0 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r1 = new uz0.f(r2.b);
        r1.a("channel_id", Long.valueOf(r10).toString());
        r1.a("link_status", Long.valueOf(r12).toString());
        r1.a("offset", Long.valueOf(r14).toString());
        r1.a("count", Long.valueOf(r16).toString());
        r1.a("scene", Integer.valueOf(r18).toString());
        r1.a("use_local_cache", String.valueOf(r19));
        if (r20 != null) goto L5;
        String r3 = "";
    L6:
        r1.a("request_source", r3);
        r1.a("room_id", Long.valueOf(r22).toString());
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/list/", TypesJVMKt.getJavaType(Reflection.typeOf(r.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    L5:
        r3 = r20;
        goto L6
    }
}
