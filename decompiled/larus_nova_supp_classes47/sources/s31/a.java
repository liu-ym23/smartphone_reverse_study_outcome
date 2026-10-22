package s31;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.match.o;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.e4;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.g;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.i8;
import com.bytedance.android.livesdk.link.model.k3;
import com.bytedance.android.livesdk.link.model.l4;
import com.bytedance.android.livesdk.link.model.n1;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.p5;
import com.bytedance.android.livesdk.link.model.p8;
import com.bytedance.android.livesdk.link.model.q3;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.livesdk.link.model.r3;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.w7;
import com.bytedance.android.livesdk.link.model.z0;
import com.bytedance.android.livesdk.revenue.service.room.c;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
import tz0.b;
import uz0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements r31.a {
    public final c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    @Override // r31.a
    public final Observable<ExtraResponse<e4, Extra>> G() {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter(r1.b, "queriesMap");
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/battle/cut_short_count/", TypesJVMKt.getJavaType(Reflection.typeOf(e4.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public final String T() {
        JSONObject r0 = new JSONObject();
        b51.b r1 = b51.b.c0;
        r1.getClass();
        r0.put("live_sdk_pk_ab_crop_opt", (String) b51.b.Q.getValue(r1, b51.b.a[41]));
        boolean r2 = b51.c.a(this.b);
        String r3 = DataType.TRUE;
        if (r2 == false) goto L5;
        Object r4 = DataType.TRUE;
    L6:
        r0.put("linkmic_panel_opt", r4);
        com.bytedance.android.live.revlink.impl.global.c r5 = this.c;
        if (r5 == null) goto L13;
        com.bytedance.android.live.revlink.impl.precisefind.a r6 = r5.Wd();
        if (r6 == null) goto L13;
        if (r6.Ip() != true) goto L13;
    L14:
        r0.put("precise_find_people_enable", r3);
        return r0.toString();
    L13:
        r3 = DataType.FALSE;
        goto L14
    L5:
        r4 = DataType.FALSE;
        goto L6
    }

    @Override // r31.a
    public final Observable b() {
        Intrinsics.checkNotNullParameter("", "activityName");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        Intrinsics.checkNotNullParameter("activity_name", "$this$setTo");
        r1.put("activity_name", "");
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/cancel_match/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    public static String V(List r5) {
        JSONArray r0 = new JSONArray();
        if (r5 == null) goto L9;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        o r1 = (o) r6.next();
        JSONObject r2 = new JSONObject();
        r2.put("UserID", r1.a);
        r2.put("RoomID", r1.b);
        r0.put(r2);
    L9:
        return r0.toString();
    }

    @Override // r31.a
    public final Observable P(String r12) {
        Intrinsics.checkNotNullParameter("live_pk", "channel");
        Intrinsics.checkNotNullParameter(r12, "editWord");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        Intrinsics.checkNotNullParameter("pd", "$this$setTo");
        r1.put("pd", "live_pk");
        Long r3 = 30010L;
        String r4 = r3.toString();
        Intrinsics.checkNotNullParameter("business_id", "$this$setTo");
        if (r4 == null) goto L5;
        r1.put("business_id", r4);
    L5:
        Intrinsics.checkNotNullParameter("query", "$this$setTo");
        r1.put("query", r12);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "https://i.snssdk.com/api/suggest_words/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(e21.f.class)))), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> feedback(Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "map");
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        S(r12, new uz0.f(r1.b));
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/feedback/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<bf2.a, Extra>> getLatestBanRecord(long r12) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter(r1, "$this$addSaasMiddleware");
        r1.a(qx0.a.a);
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r13 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("ban_type", "$this$setTo");
        if (r13 == null) goto L5;
        r2.put("ban_type", r13);
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/review/get_latest_ban_record/", TypesJVMKt.getJavaType(Reflection.typeOf(bf2.a.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<z0, Extra>> q(int r12) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r13 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("data_type", "$this$setTo");
        if (r13 == null) goto L5;
        r2.put("data_type", r13);
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/battle/get_battle_self_data_config/", TypesJVMKt.getJavaType(Reflection.typeOf(z0.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    public a(c r1, LinkFakeGlobalService r2) {
        this.b = r1;
        this.c = r2;
    }

    public static void S(Map r3, uz0.f r4) {
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L18;
        Map.Entry r0 = (Map.Entry) r5.next();
        Object r1 = r0.getValue();
        if ((r1 instanceof Boolean) == true) goto L7;
        if ((r1 instanceof Number) == true) goto L10;
        String r2 = (String) r0.getKey();
        if (r1 == null) goto L14;
        String r6 = r1.toString();
    L15:
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        r4.a(r2, r6);
        goto L4
    L14:
        r6 = null;
        goto L15
    L10:
        r4.a((String) r0.getKey(), ((Number) r1).toString());
        goto L4
    L7:
        r4.a((String) r0.getKey(), String.valueOf(((Boolean) r1).booleanValue()));
        goto L4
    }

    public static void U(Map r1, uz0.c r2) {
        S(r1, new uz0.f(r2.b));
    }

    @Override // r31.a
    public final Observable B(String r12, int r13) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        Intrinsics.checkNotNullParameter("offset", "$this$setTo");
        r2.put("offset", r12);
        Integer r14 = 20;
        String r15 = r14.toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r15 == null) goto L8;
        r2.put("count", r15);
    L8:
        String r16 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("filter_type", "$this$setTo");
        if (r16 == null) goto L11;
        r2.put("filter_type", r16);
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/records/", TypesJVMKt.getJavaType(Reflection.typeOf(p5.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable I(long r12, String r13) {
        b r0 = b.a;
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
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        Intrinsics.checkNotNullParameter("content", "$this$setTo");
        r2.put("content", r13);
        Intrinsics.checkNotNullParameter("to_user_ids", "$this$setTo");
        r2.put("to_user_ids", "null");
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/send_signal/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> R(long r14, long r16) {
        b r0 = b.a;
        e r1 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r4 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("channel_id", r4);
    L5:
        String r5 = Long.valueOf(r16).toString();
        Intrinsics.checkNotNullParameter("battle_id", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("battle_id", r5);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).L4(r0.b(), "/webcast/linkmic/battle/end_punish/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c, r1.e, r1.f, r1.g);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.o, Extra>> getAnchorLinkSetting(long r12, String r13) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r14 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r14 == null) goto L5;
        r2.put("room_id", r14);
    L5:
        int r15 = t31.a.a;
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        Map r16 = MapsKt.mapOf(TuplesKt.to("open_id", r13));
        if (r16 == null) goto L11;
        U(r16, r1);
    L11:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/get_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.link.model.o.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<l4, Extra>> intercomClose(long r12, long r13) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r14 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r14 == null) goto L5;
        r2.put("room_id", r14);
    L5:
        String r15 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r15 == null) goto L8;
        r2.put("channel_id", r15);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/interaction/intercom/close/", TypesJVMKt.getJavaType(Reflection.typeOf(l4.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<l4, Extra>> intercomInvite(long r12, long r13) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r14 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r14 == null) goto L5;
        r2.put("room_id", r14);
    L5:
        String r15 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r15 == null) goto L8;
        r2.put("channel_id", r15);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/interaction/intercom/invite/", TypesJVMKt.getJavaType(Reflection.typeOf(l4.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<i8, Extra>> j(String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "activityId");
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        Intrinsics.checkNotNullParameter("activity_id", "$this$setTo");
        if (r12 == null) goto L5;
        r2.put("activity_id", r12);
    L5:
        String r14 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("action_type", "$this$setTo");
        if (r14 == null) goto L8;
        r2.put("action_type", r14);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/battle/recommend_area_action/", TypesJVMKt.getJavaType(Reflection.typeOf(i8.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable s(String r12, int r13) {
        Intrinsics.checkNotNullParameter("", "activityName");
        Intrinsics.checkNotNullParameter(r12, "openGameAppId");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        Intrinsics.checkNotNullParameter("activity_name", "$this$setTo");
        r1.put("activity_name", "");
        if (r12.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        Intrinsics.checkNotNullParameter("open_game_app_id", "$this$setTo");
        r1.put("open_game_app_id", r12);
    L8:
        String r14 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("match_type", "$this$setTo");
        if (r14 == null) goto L11;
        r1.put("match_type", r14);
    L11:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/cancel_match/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    L5:
        r3 = false;
        goto L6
    }

    @Override // r31.a
    public final Observable i(long r12, String r13, int r14) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r15 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r15 == null) goto L5;
        r2.put("room_id", r15);
    L5:
        String r16 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r16 == null) goto L8;
        r2.put("scene", r16);
    L8:
        int r17 = t31.a.a;
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        Map r18 = MapsKt.mapOf(TuplesKt.to("open_id", r13));
        if (r18 == null) goto L14;
        U(r18, r1);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/get_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(g.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable m(long r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r14, "offsetId");
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r15 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r15 == null) goto L5;
        r2.put("room_id", r15);
    L5:
        String r16 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("tab_type", "$this$setTo");
        if (r16 == null) goto L8;
        r2.put("tab_type", r16);
    L8:
        Integer r17 = 10;
        String r18 = r17.toString();
        Intrinsics.checkNotNullParameter("limit", "$this$setTo");
        if (r18 == null) goto L11;
        r2.put("limit", r18);
    L11:
        Intrinsics.checkNotNullParameter("offset_id", "$this$setTo");
        if (r14 == null) goto L14;
        r2.put("offset_id", r14);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/reserve_record/", TypesJVMKt.getJavaType(Reflection.typeOf(p8.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<r3, Extra>> n(long r12, long r13, String r15) {
        b r0 = b.a;
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
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        Intrinsics.checkNotNullParameter("battle_config_setting", "$this$setTo");
        r2.put("battle_config_setting", r15);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/change_multi_pk_team/", TypesJVMKt.getJavaType(Reflection.typeOf(r3.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable r(int r12, String r13, int r14) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r15 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("offset", "$this$setTo");
        if (r15 == null) goto L5;
        r2.put("offset", r15);
    L5:
        Integer r16 = 20;
        String r17 = r16.toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r17 == null) goto L8;
        r2.put("count", r17);
    L8:
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        Intrinsics.checkNotNullParameter("activity_name", "$this$setTo");
        r2.put("activity_name", r13);
        String r18 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("from_type", "$this$setTo");
        if (r18 == null) goto L13;
        r2.put("from_type", r18);
    L13:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/record/", TypesJVMKt.getJavaType(Reflection.typeOf(g2.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable v(long r12, long r14, long r16) {
        return O(r12, r14, 7, false, "multi_anchor_link_widget_create", r16, null);
    }

    @Override // r31.a
    public final Observable y(List r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter("", "activityName");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        Intrinsics.checkNotNullParameter("activity_name", "$this$setTo");
        r1.put("activity_name", "");
        String r3 = String.valueOf(true);
        Intrinsics.checkNotNullParameter("cancel_multi_match", "$this$setTo");
        if (r3 == null) goto L5;
        r1.put("cancel_multi_match", r3);
    L5:
        String r15 = V(r12);
        Intrinsics.checkNotNullParameter("participants_str", "$this$setTo");
        if (r15 == null) goto L8;
        r1.put("participants_str", r15);
    L8:
        String r16 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("match_type", "$this$setTo");
        if (r16 == null) goto L11;
        r1.put("match_type", r16);
    L11:
        String r17 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("cancel_scene", "$this$setTo");
        if (r17 == null) goto L14;
        r1.put("cancel_scene", r17);
    L14:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/cancel_match/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<IPropInfoNotifyResponse, Extra>> A(int r12, long r13, long r15, String r17) {
        Intrinsics.checkNotNullParameter(r17, "anchorId");
        b r1 = b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r4 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("notify_type", "$this$setTo");
        if (r4 == null) goto L5;
        r3.put("notify_type", r4);
    L5:
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L8;
        r3.put("channel_id", r5);
    L8:
        String r6 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("battle_id", "$this$setTo");
        if (r6 == null) goto L11;
        r3.put("battle_id", r6);
    L11:
        int r7 = t31.a.a;
        U(MapsKt.mapOf(TuplesKt.to("anchor_open_id", r17)), r2);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/prop_info_notify/", TypesJVMKt.getJavaType(Reflection.typeOf(IPropInfoNotifyResponse.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable C(boolean r12, boolean r13, long r14, long r15) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = String.valueOf(r12);
        Intrinsics.checkNotNullParameter("show_interaction_score_close", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("show_interaction_score_close", r3);
    L5:
        String r4 = String.valueOf(r13);
        Intrinsics.checkNotNullParameter("clear_score", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("clear_score", r4);
    L8:
        String r5 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("channel_id", r5);
    L11:
        String r6 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("room_id", r6);
    L14:
        Long r7 = 0L;
        String r8 = r7.toString();
        Intrinsics.checkNotNullParameter("battle_id", "$this$setTo");
        if (r8 == null) goto L17;
        r2.put("battle_id", r8);
    L17:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/interaction_update_setting/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> K(int r12, String r13, long r14, long r16) {
        Intrinsics.checkNotNullParameter(r13, "appID");
        b r1 = b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r5 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("biz_type", "$this$setTo");
        if (r5 == null) goto L5;
        r3.put("biz_type", r5);
    L5:
        Intrinsics.checkNotNullParameter("game_app_id", "$this$setTo");
        if (r13 == null) goto L8;
        r3.put("game_app_id", r13);
    L8:
        String r0 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r0 == null) goto L11;
        r3.put("room_id", r0);
    L11:
        String r4 = Long.valueOf(r16).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L14;
        r3.put("channel_id", r4);
    L14:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r1.b(), "/webcast/linkmic/biz/end/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> N(long r12, String r13, int r14, Map<String, ? extends Object> r15) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("room_id", Long.valueOf(r12).toString());
        r2.a("battle_effective_field", Integer.valueOf(r14).toString());
        S(r15, r2);
        int r16 = t31.a.a;
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        Map r17 = MapsKt.mapOf(TuplesKt.to("open_id", r13));
        if (r17 == null) goto L8;
        U(r17, r1);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/update_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> Q(int r12, String r13, long r14, long r16) {
        Intrinsics.checkNotNullParameter(r13, "appID");
        b r1 = b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r5 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("biz_type", "$this$setTo");
        if (r5 == null) goto L5;
        r3.put("biz_type", r5);
    L5:
        Intrinsics.checkNotNullParameter("game_app_id", "$this$setTo");
        if (r13 == null) goto L8;
        r3.put("game_app_id", r13);
    L8:
        String r0 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r0 == null) goto L11;
        r3.put("room_id", r0);
    L11:
        String r4 = Long.valueOf(r16).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L14;
        r3.put("channel_id", r4);
    L14:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r1.b(), "/webcast/linkmic/biz/start/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<q3, Extra>> h(long r12, long r13, int r15, String r16) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r4 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("channel_id", r4);
    L5:
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("room_id", r5);
    L8:
        String r6 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("multi_pk_mode_tab", "$this$setTo");
        if (r6 == null) goto L11;
        r2.put("multi_pk_mode_tab", r6);
    L11:
        if (r16 != null) goto L13;
        String r7 = "";
    L14:
        Intrinsics.checkNotNullParameter("battle_config_setting", "$this$setTo");
        r2.put("battle_config_setting", r7);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/change_multi_pk_mode_tab/", TypesJVMKt.getJavaType(Reflection.typeOf(q3.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L13:
        r7 = r16;
        goto L14
    }

    @Override // r31.a
    public final Observable<ExtraResponse<l4, Extra>> intercomReply(long r12, long r13, int r15, boolean r16) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r4 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("room_id", r4);
    L5:
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("channel_id", r5);
    L8:
        String r6 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("reply_status", "$this$setTo");
        if (r6 == null) goto L11;
        r2.put("reply_status", r6);
    L11:
        String r7 = String.valueOf(r16);
        Intrinsics.checkNotNullParameter("always_reject", "$this$setTo");
        if (r7 == null) goto L14;
        r2.put("always_reject", r7);
    L14:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/interaction/intercom/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(l4.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> mute(long r12, int r13, String r14, long r15) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("room_id", r3);
    L5:
        String r4 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("scene", r4);
    L8:
        String r5 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("channel_id", r5);
    L11:
        int r6 = t31.a.a;
        if (r14 != null) goto L14;
        String r7 = "";
    L15:
        Map r8 = MapsKt.mapOf(TuplesKt.to("to_open_id", r7));
        if (r8 == null) goto L18;
        U(r8, r1);
    L18:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/silence/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L14:
        r7 = r14;
        goto L15
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> o(long r13, long r15, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "inviterUid");
        Intrinsics.checkNotNullParameter(r18, "clientAttachedInfo");
        b r2 = b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map<String, String> r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("reply_status", "$this$setTo");
        if (r5 == null) goto L5;
        r4.put("reply_status", r5);
    L5:
        String r6 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L8;
        r4.put("room_id", r6);
    L8:
        Intrinsics.checkNotNullParameter("invite_user_id", "$this$setTo");
        r4.put("invite_user_id", r17);
        Intrinsics.checkNotNullParameter("client_attached_info", "$this$setTo");
        r4.put("client_attached_info", r18);
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/match_reply/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r3.d, r3.a, r3.b, r3.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> updateAnchorLinkSetting(long r12, String r13, int r14, Map<String, ? extends Object> r15) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("room_id", Long.valueOf(r12).toString());
        r2.a("effective_field", Integer.valueOf(r14).toString());
        S(r15, r2);
        int r16 = t31.a.a;
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        Map r17 = MapsKt.mapOf(TuplesKt.to("user_openid", r13));
        if (r17 == null) goto L8;
        U(r17, r1);
    L8:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/update_settings/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<w7, Extra>> x(String r12, long r13, long r14, String r16) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = "";
        if (r12 != null) goto L5;
        String r4 = "";
    L6:
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        r2.put("scene", r4);
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L9;
        r2.put("room_id", r5);
    L9:
        String r6 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r6 == null) goto L12;
        r2.put("channel_id", r6);
    L12:
        int r7 = t31.a.a;
        if (r16 == null) goto L16;
        r3 = r16;
    L16:
        Map r8 = MapsKt.mapOf(TuplesKt.to("anchor_open_id", r3));
        if (r8 == null) goto L19;
        U(r8, r1);
    L19:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/feedback_issues/", TypesJVMKt.getJavaType(Reflection.typeOf(w7.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L5:
        r4 = r12;
        goto L6
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> a(int r12, long r13, int r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r16, "flexActivityId");
        b r1 = b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r5 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("respond", "$this$setTo");
        if (r5 == null) goto L5;
        r3.put("respond", r5);
    L5:
        String r6 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("precision_match_id", "$this$setTo");
        if (r6 == null) goto L8;
        r3.put("precision_match_id", r6);
    L8:
        String r7 = Integer.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r7 == null) goto L11;
        r3.put("source", r7);
    L11:
        Intrinsics.checkNotNullParameter("activity_id", "$this$setTo");
        if (r16 == null) goto L14;
        r3.put("activity_id", r16);
    L14:
        String r0 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("not_disturb", "$this$setTo");
        if (r0 == null) goto L17;
        r3.put("not_disturb", r0);
    L17:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r1.b(), "/webcast/battle/precision/match/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> d(List<String> r16, long r17, long r19, int r22, int r23) {
        Intrinsics.checkNotNullParameter(r16, "inviteeAnchorIds");
        b r2 = b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        Map<String, String> r4 = r3.b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        String r5 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L5;
        r4.put("room_id", r5);
    L5:
        String r6 = Long.valueOf(r19).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r6 == null) goto L8;
        r4.put("channel_id", r6);
    L8:
        String r7 = Integer.valueOf(r22).toString();
        Intrinsics.checkNotNullParameter("match_type", "$this$setTo");
        if (r7 == null) goto L11;
        r4.put("match_type", r7);
    L11:
        String r8 = Integer.valueOf(r23).toString();
        Intrinsics.checkNotNullParameter("invite_type", "$this$setTo");
        if (r8 == null) goto L14;
        r4.put("invite_type", r8);
    L14:
        int r9 = t31.a.a;
        Intrinsics.checkNotNullParameter(r16, "inviteeAnchorIds");
        HashMap r1 = new HashMap();
        r1.put("invitee_anchor_open_ids", CollectionsKt.joinToString$default(r16, ",", null, null, 0, null, null, 62, null));
        U(r1, r3);
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/switch_channel_cancel/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r3.d, r3.a, r3.b, r3.c);
    }

    @Override // r31.a
    public final Observable g(long r12, long r13, long r15, int r17, int r18) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("channel_id", Long.valueOf(r12).toString());
        r2.a("room_id", Long.valueOf(r13).toString());
        r2.a("to_room_id", Long.valueOf(r15).toString());
        Integer r3 = 1;
        r2.a("scene", r3.toString());
        r2.a("effective_fields", "0,1");
        r2.a("room_linker_silence_status", Integer.valueOf(r17).toString());
        r2.a("room_linker_is_background", Integer.valueOf(r18).toString());
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/update_cross_room_info/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> l(long r12, int r14, String r15, int r16, long r17) {
        Intrinsics.checkNotNullParameter(r15, "openAppID");
        b r1 = b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r3 = r2.b;
        Intrinsics.checkNotNullParameter(r3, "queriesMap");
        String r4 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L5;
        r3.put("channel_id", r4);
    L5:
        String r5 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("biz_type", "$this$setTo");
        if (r5 == null) goto L8;
        r3.put("biz_type", r5);
    L8:
        Intrinsics.checkNotNullParameter("open_app_id", "$this$setTo");
        if (r15 == null) goto L11;
        r3.put("open_app_id", r15);
    L11:
        String r0 = Integer.valueOf(r16).toString();
        Intrinsics.checkNotNullParameter("invite_type", "$this$setTo");
        if (r0 == null) goto L14;
        r3.put("invite_type", r0);
    L14:
        int r6 = t31.a.a;
        String r7 = String.valueOf(r17);
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        U(MapsKt.mapOf(TuplesKt.to("to_uid", r7)), r2);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/biz/invite/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> updateLinkMicConfig(long r12, long r13, String r15, boolean r16, boolean r17) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r4 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r4 == null) goto L5;
        r2.put("channel_id", r4);
    L5:
        String r5 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r5 == null) goto L8;
        r2.put("room_id", r5);
    L8:
        if (r15 != null) goto L10;
        String r6 = "";
    L11:
        Intrinsics.checkNotNullParameter("effective_fields", "$this$setTo");
        r2.put("effective_fields", r6);
        String r7 = String.valueOf(r16);
        Intrinsics.checkNotNullParameter("forbid_invite_by_general", "$this$setTo");
        if (r7 == null) goto L14;
        r2.put("forbid_invite_by_general", r7);
    L14:
        String r8 = String.valueOf(r17);
        Intrinsics.checkNotNullParameter("forbid_apply_from_other", "$this$setTo");
        if (r8 == null) goto L17;
        r2.put("forbid_apply_from_other", r8);
    L17:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/update_linkmic_config/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L10:
        r6 = r15;
        goto L11
    }

    @Override // r31.a
    public final Observable w(long r12, String r13, String r14, long r15, int r17) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("room_id", r3);
    L5:
        String r4 = "";
        if (r14 != null) goto L8;
        String r5 = "";
    L9:
        Intrinsics.checkNotNullParameter("cursor", "$this$setTo");
        r2.put("cursor", r5);
        String r6 = Long.valueOf(r15).toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r6 == null) goto L12;
        r2.put("count", r6);
    L12:
        String r7 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("battle_setting_type", "$this$setTo");
        if (r7 == null) goto L15;
        r2.put("battle_setting_type", r7);
    L15:
        int r8 = t31.a.a;
        if (r13 == null) goto L19;
        r4 = r13;
    L19:
        Map r9 = MapsKt.mapOf(TuplesKt.to("open_user_id", r4));
        if (r9 == null) goto L22;
        U(r9, r1);
    L22:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/get_settings_list/", TypesJVMKt.getJavaType(Reflection.typeOf(k3.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L8:
        r5 = r14;
        goto L9
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> z(int r12, long r13, long r14, String r16, int r17) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("update_anchor_layout_type", "$this$setTo");
        if (r3 == null) goto L5;
        r2.put("update_anchor_layout_type", r3);
    L5:
        String r4 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r4 == null) goto L8;
        r2.put("room_id", r4);
    L8:
        String r5 = Long.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r5 == null) goto L11;
        r2.put("channel_id", r5);
    L11:
        String r6 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("ui_operation_type", "$this$setTo");
        if (r6 == null) goto L14;
        r2.put("ui_operation_type", r6);
    L14:
        int r7 = t31.a.a;
        if (r16 != null) goto L17;
        String r8 = "";
    L18:
        Map r9 = MapsKt.mapOf(TuplesKt.to("to_user_openid", r8));
        if (r9 == null) goto L21;
        U(r9, r1);
    L21:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/update_anchor_layout/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L17:
        r8 = r16;
        goto L18
    }

    @Override // r31.a
    public final Observable<ExtraResponse<n9, Extra>> E(List<String> r17, int r18, int r19, long r20, long r22, String r24) {
        Intrinsics.checkNotNullParameter(r17, "inviteeAnchorIds");
        Intrinsics.checkNotNullParameter(r24, "clientAttachedInfo");
        b r3 = b.a;
        uz0.c r4 = new uz0.c();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        Map<String, String> r5 = r4.b;
        Intrinsics.checkNotNullParameter(r5, "queriesMap");
        String r6 = Integer.valueOf(r18).toString();
        Intrinsics.checkNotNullParameter("match_type", "$this$setTo");
        if (r6 == null) goto L5;
        r5.put("match_type", r6);
    L5:
        String r7 = Integer.valueOf(r19).toString();
        Intrinsics.checkNotNullParameter("invite_type", "$this$setTo");
        if (r7 == null) goto L8;
        r5.put("invite_type", r7);
    L8:
        String r8 = Long.valueOf(r20).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r8 == null) goto L11;
        r5.put("channel_id", r8);
    L11:
        String r9 = Long.valueOf(r22).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r9 == null) goto L14;
        r5.put("room_id", r9);
    L14:
        Intrinsics.checkNotNullParameter("client_attached_info", "$this$setTo");
        if (r24 == null) goto L17;
        r5.put("client_attached_info", r24);
    L17:
        int r1 = t31.a.a;
        Intrinsics.checkNotNullParameter(r17, "inviteeAnchorIds");
        HashMap r2 = new HashMap();
        r2.put("invitee_anchor_open_ids", CollectionsKt.joinToString$default(r17, ",", null, null, 0, null, null, 62, null));
        U(r2, r4);
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/switch_channel_invite/", TypesJVMKt.getJavaType(Reflection.typeOf(n9.class)), Extra.class, r4.d, r4.a, r4.b, r4.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<u6, Extra>> J(String r12, int r13, int r14, String r15, String r16, int r17) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map<String, String> r2 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r4 = "";
        if (r12 != null) goto L5;
        String r5 = "";
    L6:
        Intrinsics.checkNotNullParameter("query_word", "$this$setTo");
        r2.put("query_word", r5);
        String r6 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("offset", "$this$setTo");
        if (r6 == null) goto L9;
        r2.put("offset", r6);
    L9:
        String r7 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("count", "$this$setTo");
        if (r7 == null) goto L12;
        r2.put("count", r7);
    L12:
        if (r15 != null) goto L14;
        String r8 = "";
    L15:
        Intrinsics.checkNotNullParameter("search_id", "$this$setTo");
        r2.put("search_id", r8);
        if (r16 == null) goto L19;
        r4 = r16;
    L19:
        Intrinsics.checkNotNullParameter("activity_name", "$this$setTo");
        r2.put("activity_name", r4);
        String r9 = Integer.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("search_scene", "$this$setTo");
        if (r9 == null) goto L22;
        r2.put("search_scene", r9);
    L22:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/rivals/search/", TypesJVMKt.getJavaType(Reflection.typeOf(u6.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    L14:
        r8 = r15;
        goto L15
    L5:
        r5 = r12;
        goto L6
    }

    @Override // r31.a
    public final Observable M(long r12, int r13, long r14, int r16, boolean r17, String r18) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("room_id", Long.valueOf(r12).toString());
        r2.a("scene", Integer.valueOf(r13).toString());
        r2.a("channel_id", Long.valueOf(r14).toString());
        Long r3 = 0L;
        r2.a("to_room_id", r3.toString());
        r2.a("silence_action", Integer.valueOf(r16).toString());
        r2.a("is_to_all", String.valueOf(r17));
        r2.a("to_ai_user_id", r18);
        int r4 = t31.a.a;
        Map r5 = MapsKt.mapOf(TuplesKt.to("to_open_id", ""));
        if (r5 == null) goto L5;
        U(r5, r1);
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/silence/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable c(int r12, boolean r13, int r14, String r15, int r16, int r17) {
        b r0 = b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("entrance", Integer.valueOf(r12).toString());
        r2.a("reuse_last_recommend", String.valueOf(r13));
        r2.a("tab_type", Integer.valueOf(r14).toString());
        r2.a("activity_name", r15);
        r2.a("new_recommend_type", Integer.valueOf(r16).toString());
        Long r3 = 0L;
        r2.a("flex_activity_id", r3.toString());
        Integer r4 = 0;
        r2.a("flex_activity_plan", r4.toString());
        Integer r5 = 0;
        r2.a("recommend_select_type", r5.toString());
        r2.a("load_type", Integer.valueOf(r17).toString());
        r2.a("ab_test_value_map", T());
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/rivals/recommend/", TypesJVMKt.getJavaType(Reflection.typeOf(IRivalRankRecommendResponse.class)), Extra.class, r1.d, r1.a, r1.b, r1.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> p(long r5, int r7, String r8, long r9, long r12, int r13) {
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        String r6 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L5;
        r1.put("room_id", r6);
    L5:
        String r10 = Integer.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r10 == null) goto L8;
        r1.put("scene", r10);
    L8:
        String r14 = Long.valueOf(r9).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r14 == null) goto L11;
        r1.put("channel_id", r14);
    L11:
        String r15 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r15 == null) goto L14;
        r1.put("to_room_id", r15);
    L14:
        String r16 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("silence_action", "$this$setTo");
        if (r16 == null) goto L17;
        r1.put("silence_action", r16);
    L17:
        int r17 = t31.a.a;
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        Map r18 = MapsKt.mapOf(TuplesKt.to("to_open_id", r8));
        if (r18 == null) goto L23;
        U(r18, r2);
    L23:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/silence/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> F(int r6, long r7, String r9, long r10, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "inviteUserId");
        Intrinsics.checkNotNullParameter(r12, "clientAttachedInfo");
        Intrinsics.checkNotNullParameter(r13, "reserveId");
        Intrinsics.checkNotNullParameter(r14, "inviteOpenId");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r3 = new uz0.f(r2.b);
        r3.a("reply_status", Integer.valueOf(r6).toString());
        r3.a("room_id", Long.valueOf(r7).toString());
        r3.a("invite_user_id", r9);
        r3.a("invite_room_id", Long.valueOf(r10).toString());
        r3.a("client_attached_info", r12);
        r3.a("reserve_id", r13);
        r3.a("invite_open_id", r14);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/battle/reserve_reply/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> H(int r5, long r6, long r8, String r10, String r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r10, "battleAttachedInfo");
        Intrinsics.checkNotNullParameter(r12, "reserveId");
        Intrinsics.checkNotNullParameter(r13, "toOpenId");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r1 = new uz0.f(r2.b);
        r1.a("settle_status", Integer.valueOf(r5).toString());
        r1.a("room_id", Long.valueOf(r6).toString());
        r1.a("to_user_id", Long.valueOf(r8).toString());
        r1.a("battle_attached_info", r10);
        r1.a("reserve_id", r12);
        r1.a("to_open_id", r13);
        r1.a("to_room_id", Long.valueOf(r14).toString());
        int r7 = t31.a.a;
        String r9 = String.valueOf(r8);
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        U(MapsKt.mapOf(TuplesKt.to("to_open_id", r9)), r2);
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/reserve_settle/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable O(long r5, long r7, int r9, boolean r10, String r12, long r13, String r14) {
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r1 = new uz0.f(r2.b);
        r1.a("channel_id", Long.valueOf(r5).toString());
        r1.a("link_status", Long.valueOf(r7).toString());
        Long r6 = 0L;
        r1.a("offset", r6.toString());
        Long r8 = -1L;
        r1.a("count", r8.toString());
        r1.a("scene", Integer.valueOf(r9).toString());
        r1.a("use_local_cache", String.valueOf(r10));
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        r1.a("request_source", r12);
        r1.a("room_id", Long.valueOf(r13).toString());
        int r15 = t31.a.a;
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        Map r16 = MapsKt.mapOf(TuplesKt.to("anchor_openid", r14));
        if (r16 == null) goto L11;
        U(r16, r2);
    L11:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/list/", TypesJVMKt.getJavaType(Reflection.typeOf(r.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> k(long r5, long r7, String r9, int r10, int r12, int r13, int r14) {
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        Map<String, String> r1 = r2.b;
        Intrinsics.checkNotNullParameter(r1, "queriesMap");
        String r6 = Long.valueOf(r5).toString();
        Intrinsics.checkNotNullParameter("channel_id", "$this$setTo");
        if (r6 == null) goto L5;
        r1.put("channel_id", r6);
    L5:
        String r8 = Long.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("battle_id", "$this$setTo");
        if (r8 == null) goto L8;
        r1.put("battle_id", r8);
    L8:
        String r15 = Integer.valueOf(r10).toString();
        Intrinsics.checkNotNullParameter("reply_status", "$this$setTo");
        if (r15 == null) goto L11;
        r1.put("reply_status", r15);
    L11:
        String r16 = Integer.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("invite_type", "$this$setTo");
        if (r16 == null) goto L14;
        r1.put("invite_type", r16);
    L14:
        String r17 = Integer.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("multi_pk_mode", "$this$setTo");
        if (r17 == null) goto L17;
        r1.put("multi_pk_mode", r17);
    L17:
        String r18 = Integer.valueOf(r14).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r18 == null) goto L20;
        r1.put("scene", r18);
    L20:
        int r19 = t31.a.a;
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        Map r20 = MapsKt.mapOf(TuplesKt.to("invite_uid", r9));
        if (r20 == null) goto L26;
        U(r20, r2);
    L26:
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/reply/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<Object, Extra>> L(int r10, String r12, long r13, long r14, long r16, long r18, int r20, int r22) {
        Intrinsics.checkNotNullParameter(r12, "fromAnchorId");
        b r2 = b.a;
        uz0.c r4 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        uz0.f r3 = new uz0.f(r4.b);
        r3.a("answer_status", Integer.valueOf(r10).toString());
        r3.a("from_room_id", Long.valueOf(r13).toString());
        r3.a("room_id", Long.valueOf(r14).toString());
        r3.a("cur_channel_id", Long.valueOf(r16).toString());
        r3.a("to_join_channel_id", Long.valueOf(r18).toString());
        r3.a("match_type", Integer.valueOf(r20).toString());
        r3.a("invite_type", Integer.valueOf(r22).toString());
        int r5 = t31.a.a;
        Intrinsics.checkNotNullParameter(r12, "fromAnchorId");
        U(MapsKt.mapOf(TuplesKt.to("from_anchor_open_id", r12)), r4);
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/switch_channel_reply/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r4.d, r4.a, r4.b, r4.c);
    }

    @Override // r31.a
    public final Observable u(long r14, boolean r16, int r17, long r18, long r20, String r22, int r23, String r24) {
        b r0 = b.a;
        e r1 = new e();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        uz0.f r2 = new uz0.f(r1.b);
        r2.a("channel_id", Long.valueOf(r14).toString());
        r2.a("after_punish", String.valueOf(r16));
        r2.a("invite_type", Integer.valueOf(r17).toString());
        String r4 = "";
        r2.a("activity_name", "");
        r2.a("battle_id", Long.valueOf(r18).toString());
        r2.a("duration_time", Long.valueOf(r20).toString());
        r2.a("multi_pk_mode", Integer.valueOf(r23).toString());
        Map<String, String> r3 = r1.e;
        Intrinsics.checkNotNullParameter(r3, "fieldsMap");
        if (r22 != null) goto L5;
        String r5 = "";
    L6:
        Intrinsics.checkNotNullParameter("battle_config_setting", "$this$setTo");
        r3.put("battle_config_setting", r5);
        if (r24 == null) goto L10;
        r4 = r24;
    L10:
        Intrinsics.checkNotNullParameter("client_attached_info", "$this$setTo");
        r3.put("client_attached_info", r4);
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/invite/", TypesJVMKt.getJavaType(Reflection.typeOf(n1.class)), Extra.class, r1.d, r1.a, r1.b, r1.c, r1.e, r1.f, r1.g);
    L5:
        r5 = r22;
        goto L6
    }

    @Override // r31.a
    public final Observable D(int r6, String r7, String r8, int r9, int r10, int r12, int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r8, "flexActivityId");
        Intrinsics.checkNotNullParameter(r14, "pos");
        Intrinsics.checkNotNullParameter(r15, "source");
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r1 = new uz0.f(r2.b);
        r1.a("entrance", Integer.valueOf(r6).toString());
        Integer r4 = 0;
        r1.a("reuse_last_recommend", String.valueOf(false));
        r1.a("tab_type", r4.toString());
        r1.a("activity_name", r7);
        r1.a("new_recommend_type", r4.toString());
        r1.a("activity_id", r8);
        r1.a("sub_tab_id", r8);
        r1.a("flex_activity_plan", Integer.valueOf(r9).toString());
        r1.a("recommend_select_type", Integer.valueOf(r10).toString());
        r1.a("load_type", Integer.valueOf(r12).toString());
        r1.a("is_recommend_init", Integer.valueOf(r13).toString());
        r1.a("selected_pk_sub_tab_key", r14);
        r1.a("request_source", r15);
        r1.a("ab_test_value_map", T());
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/battle/rivals/recommend/", TypesJVMKt.getJavaType(Reflection.typeOf(IRivalRankRecommendResponse.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    }

    @Override // r31.a
    public final Observable<ExtraResponse<f1, Extra>> f(long r10, int r12, int r13, long r14, int r16, String r17, long r18, int r20, long r22) {
        b r0 = b.a;
        uz0.c r2 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        uz0.f r3 = new uz0.f(r2.b);
        r3.a("channel_id", Long.valueOf(r10).toString());
        r3.a("battle_source", Integer.valueOf(r12).toString());
        r3.a("is_cut_short", Integer.valueOf(r13).toString());
        r3.a("mode", Long.valueOf(r14).toString());
        r3.a("reason", Integer.valueOf(r16).toString());
        if (r17 != null) goto L5;
        String r4 = "";
    L6:
        r3.a(Constants.OperatorKey.KEY_TOKEN, r4);
        r3.a("room_id", Long.valueOf(r18).toString());
        r3.a("scene", Integer.valueOf(r20).toString());
        r3.a("battle_id", Long.valueOf(r22).toString());
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(r0.b(), "/webcast/linkmic/battle/finish/", TypesJVMKt.getJavaType(Reflection.typeOf(f1.class)), Extra.class, r2.d, r2.a, r2.b, r2.c);
    L5:
        r4 = r17;
        goto L6
    }

    @Override // r31.a
    public final Observable e(long r13, long r15, String r17, int r18, String r19, String r20, Long r22, String r23, int r24, Map r25) {
        Intrinsics.checkNotNullParameter(r23, "inviteeIds");
        b r2 = b.a;
        e r4 = new e();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        uz0.f r3 = new uz0.f(r4.b);
        r3.a("channel_id", Long.valueOf(r13).toString());
        r3.a(Constants.Keys.duration, Long.valueOf(r15).toString());
        String r5 = "";
        if (r17 != null) goto L5;
        String r6 = "";
    L6:
        r3.a(FileUtils.PICTURE_THEME, r6);
        long r7 = 0;
        Long r8 = 0L;
        r3.a("mode", r8.toString());
        r3.a("invite_type", Integer.valueOf(r18).toString());
        if (r19 != null) goto L9;
        String r9 = "";
    L10:
        r3.a(Constants.OperatorKey.KEY_TOKEN, r9);
        r3.a("invitee_ids", r23);
        r3.a("multi_pk_mode", Integer.valueOf(r24).toString());
        if (r25 == null) goto L13;
        S(r25, new uz0.f(r4.b));
    L13:
        Map<String, String> r0 = r4.e;
        Intrinsics.checkNotNullParameter(r0, "fieldsMap");
        if (r22 == null) goto L16;
        r7 = r22.longValue();
    L16:
        String r1 = Long.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r1 == null) goto L19;
        r0.put("room_id", r1);
    L19:
        if (r20 == null) goto L22;
        r5 = r20;
    L22:
        Intrinsics.checkNotNullParameter("battle_config_setting", "$this$setTo");
        r0.put("battle_config_setting", r5);
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/open/", TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)), Extra.class, r4.d, r4.a, r4.b, r4.c, r4.e, r4.f, r4.g);
    L9:
        r9 = r19;
        goto L10
    L5:
        r6 = r17;
        goto L6
    }

    @Override // r31.a
    public final Observable<ExtraResponse<r4, com.bytedance.android.livesdk.link.model.a>> t(long r10, int r12, int r13, int r14, boolean r15, String r16, int r17, List<o> r18, int r19, String r20, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r22, "activityId");
        Intrinsics.checkNotNullParameter(r23, "openGameAppId");
        b r2 = b.a;
        uz0.c r4 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        uz0.f r3 = new uz0.f(r4.b);
        r3.a("room_id", Long.valueOf(r10).toString());
        r3.a("is_first", Integer.valueOf(r12).toString());
        r3.a("match_type", Integer.valueOf(r13).toString());
        r3.a("sub_type", Integer.valueOf(r14).toString());
        r3.a("high_way", String.valueOf(r15));
        String r5 = "";
        if (r16 != null) goto L5;
        String r6 = "";
    L6:
        r3.a("activity_name", r6);
        r3.a("activity_id", r22);
        r3.a("speed_up_level", Integer.valueOf(r17).toString());
        r3.a("participants_str", V(r18));
        r3.a("match_style_type", Integer.valueOf(r19).toString());
        if (r20 == null) goto L10;
        r5 = r20;
    L10:
        r3.a("battle_attached_info", r5);
        r3.a("open_game_app_id", r23);
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        return ((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/linkmic/battle/auto_match/", TypesJVMKt.getJavaType(Reflection.typeOf(r4.class)), com.bytedance.android.livesdk.link.model.a.class, r4.d, r4.a, r4.b, r4.c);
    L5:
        r6 = r16;
        goto L6
    }
}
