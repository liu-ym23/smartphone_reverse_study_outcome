package com.bytedance.android.live.impl.logfilter;

import android.os.Handler;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import j40.n3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends d implements f, IMiddlewareHostAction.ILiveSmartClientFeatureProducer {
    public static final aa0.c b = null;
    public static final LimitSizeQueue<LimitSizeQueue<JSONObject>> c = null;
    public static final ConcurrentHashMap<Long, JSONObject> d = null;
    public static long e;
    public static IRoom f;
    public static final e g = null;

    @Override // com.bytedance.android.live.impl.logfilter.d
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "name");
    }

    static {
        e r0 = new e();
        g = r0;
        aa0.c r1 = n3.a.getValue();
        b = r1;
        c = new LimitSizeQueue(r1.c());
        d = new ConcurrentHashMap();
        if (r1.a() == false) goto L8;
        FeatureManager.u.getClass();
        Intrinsics.checkNotNullParameter(r0, FileUtils.FILTER);
        FeatureManager.m.add(r0);
        IMiddlewareHostAction r2 = jc1.k.f(IMiddlewareHostAction.class);
        if (r2 == null) goto L9;
        r2.registerSmartClientFeatureProducer(r0);
        return;
    L9:
        return;
    }

    public static JSONObject e() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L35
        IRoom r1 = f;     // Catch: Exception -> L35
        if (r1 == null) goto L10;
        IBaseUser r2 = r1.getOwner();     // Catch: Exception -> L35
        if (r2 == null) goto L10;
        py.j r3 = r2.getFollowInfo();     // Catch: Exception -> L35
        if (r3 == null) goto L10;
        long r5 = r3.getFollowerCount();     // Catch: Exception -> L35
    L11:
        r0.put("anchor_fans_count", r5);     // Catch: Exception -> L35
        IRoom r4 = f;     // Catch: Exception -> L35
        if (r4 == null) goto L19;
        IBaseUser r6 = r4.getOwner();     // Catch: Exception -> L35
        if (r6 == null) goto L19;
        py.j r7 = r6.getFollowInfo();     // Catch: Exception -> L35
        if (r7 == null) goto L19;
        long r8 = r7.getFollowingCount();     // Catch: Exception -> L35
    L20:
        r0.put("anchor_follow_count", r8);     // Catch: Exception -> L35
        IRoom r9 = f;     // Catch: Exception -> L35
        if (r9 == null) goto L26;
        IBaseUser r11 = r9.getOwner();     // Catch: Exception -> L35
        if (r11 == null) goto L26;
        int r12 = r11.getGender();     // Catch: Exception -> L35
    L27:
        r0.put("anchor_gender", r12);     // Catch: Exception -> L35
        IRoom r13 = f;     // Catch: Exception -> L35
        if (r13 == null) goto L32;
        Object r14 = r13.getAnchorId();     // Catch: Exception -> L35
        if (r14 == null) goto L32;
    L33:
        r0.put("anchor_id", r14);     // Catch: Exception -> L35
        return r0;
    L32:
        r14 = FeatureManager.u.getFeature("anchor_id", 0);     // Catch: Exception -> L35
    L26:
        r12 = ((Number) FeatureManager.u.getFeature("anchor_gender", 0)).intValue();     // Catch: Exception -> L35
    L19:
        r8 = ((Number) FeatureManager.u.getFeature("anchor_follow_count", 0L)).longValue();     // Catch: Exception -> L35
    L10:
        r5 = ((Number) FeatureManager.u.getFeature("anchor_fans_count", 0L)).longValue();     // Catch: Exception -> L35
    L35:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static JSONObject f() {
        String r1 = "";
        IRoom r2 = f;
        if (r2 != null) goto L53;
        LimitSizeQueue r0 = (LimitSizeQueue) CollectionsKt.lastOrNull(c);
        if (r0 != null) goto L52;
        return null;
    L52:
        return (JSONObject) CollectionsKt.lastOrNull(r0);
    L53:
        FeatureManager r4 = FeatureManager.u;     // Catch: Exception -> L46
        LongSparseArray r5 = (LongSparseArray) r4.getFeature("live_room_type", new LongSparseArray());     // Catch: Exception -> L46
        ?? r6 = new JSONObject();     // Catch: Exception -> L46
        r6.put("enter_from_merge", r4.getFeature("preview_enter_from_merge", ""));     // Catch: Exception -> L46
        r6.put("enter_method", r4.getFeature("preview_enter_method", ""));     // Catch: Exception -> L46
        r6.put("room_id", r2.getId());     // Catch: Exception -> L46
        r6.put("room_user_count", r2.getUserCount());     // Catch: Exception -> L46
        IRoomStats r8 = r2.getStats();     // Catch: Exception -> L46
        ?? r9 = 0;
        if (r8 == null) goto L7;
        int r11 = r8.getTotalUser();     // Catch: Exception -> L46
    L8:
        r6.put("room_total_user_count", r11);     // Catch: Exception -> L46
        IBaseUser r12 = r2.getOwner();     // Catch: Exception -> L46
        long r13 = 0;
        if (r12 == null) goto L13;
        py.j r14 = r12.getFollowInfo();     // Catch: Exception -> L46
        if (r14 == null) goto L13;
        long r15 = r14.getFollowStatus();     // Catch: Exception -> L46
    L14:
        r6.put("follow_status", r15);     // Catch: Exception -> L46
        String r16 = (String) r5.get(r2.getRoomId());     // Catch: Exception -> L46
        if (r16 == null) goto L18;
        List r7 = StringsKt.split$default(r16, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L46
        if (r7 == null) goto L18;
    L19:
        r6.putOpt("room_tags", new JSONArray(r7));     // Catch: Exception -> L46
        g.getClass();     // Catch: Exception -> L46
        r6.put("live_room_type", h(r2));     // Catch: Exception -> L46
        String r17 = r2.getItemExplicitInfo();     // Catch: Exception -> L46
        if (r17 != null) goto L22;
        r17 = "";
    L22:
        r6.put("live_recommend_info", r17);     // Catch: Exception -> L46
        r6.put("room_position", ((Number) r4.getFeature("live_selected_position", 0)).intValue());     // Catch: Exception -> L46
        r6.put("live_mode", r2.getStreamType().ordinal());     // Catch: Exception -> L46
        IBaseUser r18 = r2.getOwner();     // Catch: Exception -> L46
        if (r18 == null) goto L27;
        py.j r19 = r18.getFollowInfo();     // Catch: Exception -> L46
        if (r19 == null) goto L27;
        long r21 = r19.getFollowerCount();     // Catch: Exception -> L46
    L28:
        r6.put("anchor_fans_count", r21);     // Catch: Exception -> L46
        IBaseUser r22 = r2.getOwner();     // Catch: Exception -> L46
        if (r22 == null) goto L33;
        py.j r23 = r22.getFollowInfo();     // Catch: Exception -> L46
        if (r23 == null) goto L33;
        r13 = r23.getFollowingCount();     // Catch: Exception -> L46
    L33:
        r6.put("anchor_follow_count", r13);     // Catch: Exception -> L46
        IBaseUser r24 = r2.getOwner();     // Catch: Exception -> L46
        if (r24 == null) goto L36;
        int r25 = r24.getGender();     // Catch: Exception -> L46
    L37:
        r6.put("anchor_gender", r25);     // Catch: Exception -> L46
        String r26 = r2.getAnchorId();     // Catch: Exception -> L46
        if (r26 == null) goto L41;
        r1 = r26;
    L41:
        r6.put("anchor_id", r1);     // Catch: Exception -> L46
        com.bytedance.android.livesdk.strategy.a r3 = r2.getAdStrategyFeatures();     // Catch: Exception -> L46
        if (r3 == null) goto L44;
        boolean r27 = r3.a();     // Catch: Exception -> L46
        Handler r28 = UtilityKotlinExtentionsKt.a;     // Catch: Exception -> L46
        r9 = r27;
    L44:
        r6.put("live_is_ad", r9);     // Catch: Exception -> L46
        return r6;
    L36:
        r25 = 0;
    L27:
        r21 = 0;
    L18:
        r7 = CollectionsKt.emptyList();     // Catch: Exception -> L46
    L13:
        r15 = 0;
        goto L14
    L7:
        r11 = 0;
    L46:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
        return null;
    }

    public final List<String> producerName() {
        List<String> r0 = b.b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public e() {
    }

    public static JSONObject g(Map r27) {
        FeatureManager r12 = FeatureManager.u;
        LongSparseArray r13 = (LongSparseArray) r12.getFeature("live_room_type", new LongSparseArray());
        String r15 = (String) r27.get("room_id");     // Catch: Exception -> L29
        if (r15 == null) goto L6;
        long r16 = CastLongProtector.parseLong(r15);     // Catch: Exception -> L29
    L7:
        long r1 = r16;
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L29
        String r18 = (String) r27.get("enter_from_merge");     // Catch: Exception -> L29
        String r3 = "";
        if (r18 != null) goto L11;
        String r4 = "";
    L12:
        r17.put("enter_from_merge", r4);     // Catch: Exception -> L29
        String r5 = (String) r27.get("enter_method");     // Catch: Exception -> L29
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r17.put("enter_method", r5);     // Catch: Exception -> L29
        r17.put("room_id", r1);     // Catch: Exception -> L29
        r17.put("room_user_count", ((Number) r12.getFeature("user_count_in_cur_room", 0)).intValue());     // Catch: Exception -> L29
        r17.put("room_total_user_count", ((Number) r12.getFeature("total_user_count_in_cur_room", 0)).intValue());     // Catch: Exception -> L29
        r17.put("follow_status", ((Number) r12.getFeature("follow_status", 0)).intValue());     // Catch: Exception -> L29
        String r21 = (String) r13.get(r1);     // Catch: Exception -> L29
        if (r21 == null) goto L19;
        List r2 = StringsKt.split$default(r21, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L29
        if (r2 == null) goto L19;
    L20:
        r17.putOpt("room_tags", new JSONArray(r2));     // Catch: Exception -> L29
        r17.put("live_room_type", ((Number) r12.getFeature("live_toolbar_status", 0)).intValue());     // Catch: Exception -> L29
        String r6 = (String) r27.get("live_recommend_info");     // Catch: Exception -> L29
        if (r6 != null) goto L23;
        r6 = "";
    L23:
        r17.put("live_recommend_info", r6);     // Catch: Exception -> L29
        r17.put("room_position", ((Number) r12.getFeature("live_selected_position", 0)).intValue());     // Catch: Exception -> L29
        r17.put("live_mode", r12.getFeature("live_mode", ""));     // Catch: Exception -> L29
        r17.put("anchor_fans_count", ((Number) r12.getFeature("anchor_fans_count", 0)).intValue());     // Catch: Exception -> L29
        r17.put("anchor_follow_count", ((Number) r12.getFeature("anchor_follow_count", 0)).intValue());     // Catch: Exception -> L29
        r17.put("anchor_gender", ((Number) r12.getFeature("anchor_gender", 0)).intValue());     // Catch: Exception -> L29
        String r0 = (String) r27.get("anchor_id");     // Catch: Exception -> L29
        if (r0 == null) goto L27;
        r3 = r0;
    L27:
        r17.put("anchor_id", r3);     // Catch: Exception -> L29
        r17.put("entrance_room_id", e);     // Catch: Exception -> L29
        r17.put("draw_next", 0);     // Catch: Exception -> L29
        boolean r7 = ((Boolean) r12.getFeature("live_is_ad", Boolean.FALSE)).booleanValue();     // Catch: Exception -> L29
        Handler r8 = UtilityKotlinExtentionsKt.a;     // Catch: Exception -> L29
        r17.put("live_is_ad", r7 ? 1 : 0);     // Catch: Exception -> L29
        return r17;
    L19:
        r2 = CollectionsKt.emptyList();     // Catch: Exception -> L29
        goto L20
    L11:
        r4 = r18;
        goto L12
    L6:
        r16 = 0;
    L29:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", e.getMessage());
        return new JSONObject();
    }

    public static int h(IRoom r9) {
        if (TextUtils.equals(r9.isEcomCart(), GamePromoteDataContext.GAME_TYPE_MOBILE) == true) goto L10;
        IRoomCart r0 = r9.getRoomCart();
        if (r0 != null) goto L7;
    L9:
        int r1 = -1;
    L12:
        if (r9.getBusinessLive() != 1) goto L23;
        IRoomAuthStatus r2 = r9.getRoomAuthStatus();
        if (r2 != null) goto L16;
    L17:
        IRoomAuthStatus r3 = r9.getRoomAuthStatus();
        if (r3 == null) goto L23;
        if (r3.getCommerceCard() != 1) goto L23;
    L21:
        r1 = 1;
        goto L23
    L16:
        if (r2.getCommerceCard() == 0) goto L21;
    L23:
        if (r9.getHasGamePromote() != 1) goto L25;
    L26:
        return 2;
    L25:
        if (r9.isGameRoom() == 1) goto L26;
        return r1;
    L7:
        if (r0.getShowCartExt() != 1) goto L9;
    L10:
        r1 = 0;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v22, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v23, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v37, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v42, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // z90.d
    public final <T> T getFeature(String r11) {
        Intrinsics.checkNotNullParameter(r11, "name");
        T r4 = (T) null;
    L73:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
    L75:
        z90.a.C0301a.a(FeatureManager.u, r11, r4);
        return r4;
    L4:
        switch(r11.hashCode()) {
            case -798650717: goto L66;
            case -253476742: goto L61;
            case -155411810: goto L55;
            case 78467070: goto L52;
            case 464019036: goto L46;
            case 609671530: goto L40;
            case 1008792854: goto L25;
            case 1917759056: goto L20;
            case 1935426762: goto L7;
            default: goto L75;
        };     // Catch: Exception -> L73
    L7:
        if (r11.equals("live_auto_enter_params") == false) goto L75;
        IRoom r0 = f;     // Catch: Exception -> L73
        if (r0 == null) goto L11;
        r0.getRoomId();     // Catch: Exception -> L73
    L11:
        ?? r1 = new JSONObject();     // Catch: Exception -> L73
        FeatureManager r2 = FeatureManager.u;     // Catch: Exception -> L73
        r1.put("in_frequency_control", ((Number) r2.getFeature("in_frequency_control", 1)).intValue());     // Catch: Exception -> L73
        r1.put("room_entered", ((Number) r2.getFeature("room_entered", 0)).intValue());     // Catch: Exception -> L73
        IMiddlewareHostAction r3 = jc1.k.f(IMiddlewareHostAction.class);     // Catch: Exception -> L73
        if (r3 == null) goto L44;
        Map r5 = r3.getAutoEnterCountParams();     // Catch: Exception -> L73
        if (r5 == null) goto L44;
        Iterator r6 = r5.entrySet().iterator();     // Catch: Exception -> L73
    L17:
        if (r6.hasNext() == false) goto L44;
        Map.Entry r7 = (Map.Entry) r6.next();     // Catch: Exception -> L73
        r1.put((String) r7.getKey(), ((Number) r7.getValue()).intValue());     // Catch: Exception -> L73
    L44:
        r4 = (T) r1;
        goto L75
    L20:
        if (r11.equals("anchor_params") == false) goto L75;
        r1 = e();     // Catch: Exception -> L73
        if ((r1 instanceof Object) == true) goto L44;
    L25:
        if (r11.equals("live_mode") == false) goto L75;
        IRoomContextService r8 = jc1.k.f(IRoomContextService.class);     // Catch: Exception -> L73
        if (r8 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.o r9 = IRoomContextService.a.a(r8, null, 0, 3);     // Catch: Exception -> L73
        if (r9 == null) goto L35;
        Room r12 = r9.o2();     // Catch: Exception -> L73
        if (r12 == null) goto L35;
        LiveMode r13 = r12.getStreamType();     // Catch: Exception -> L73
        if (r13 == null) goto L35;
        r1 = r13.getSceneName();     // Catch: Exception -> L73
    L37:
        if ((r1 instanceof Object) == true) goto L44;
    L35:
        r1 = 0;
        goto L37
    L40:
        if (r11.equals("room_params") == false) goto L75;
        r1 = f();     // Catch: Exception -> L73
        if (r1 != 0) goto L44;
        r1 = new JSONObject();     // Catch: Exception -> L73
        goto L44
    L46:
        if (r11.equals("unshow_room_params_list") == false) goto L75;
        Collection<JSONObject> r14 = d.values();     // Catch: Exception -> L73
        boolean r15 = r14 instanceof Object;     // Catch: Exception -> L73
        r1 = r14;
        if (r15 == true) goto L50;
        r1 = 0;
    L50:
        Object r16 = (Object) r1;     // Catch: Exception -> L73
        goto L44
    L52:
        if (r11.equals("aweme_params") == false) goto L75;
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L73
        FeatureManager r18 = FeatureManager.u;     // Catch: Exception -> L73
        r17.put("aweme_position", ((Number) r18.getFeature("current_aweme_position", 0)).intValue());     // Catch: Exception -> L73
        r17.put("feed_fetch_count", ((Number) r18.getFeature("current_feed_fetch_count", 0)).intValue());     // Catch: Exception -> L73
        r17.put("item_pitaya_param", r18.getFeature("current_feed_item_pitaya_param", ""));     // Catch: Exception -> L73
        r17.put("total_shrink_count", ((Number) r18.getFeature("total_shrink_count", 0)).intValue());     // Catch: Exception -> L73
        r4 = (T) r17;
        goto L75
    L55:
        if (r11.equals("history_room_params_list") == false) goto L75;
        r1 = new ArrayList();     // Catch: Exception -> L73
        Iterator<LimitSizeQueue<JSONObject>> r19 = c.iterator();     // Catch: Exception -> L73
    L58:
        if (r19.hasNext() == false) goto L44;
        r1.addAll(r19.next());     // Catch: Exception -> L73
        goto L58
    L61:
        if (r11.equals("user_params") == false) goto L75;
        r1 = FeatureManager.u.getFeature("user_features", new JSONObject());     // Catch: Exception -> L73
        if ((r1 instanceof Object) == true) goto L44;
    L66:
        if (r11.equals("live_tab_params") == false) goto L75;
        r1 = new JSONObject();     // Catch: Exception -> L73
        IMiddlewareHostAction r21 = jc1.k.f(IMiddlewareHostAction.class);     // Catch: Exception -> L73
        if (r21 == null) goto L70;
        int r22 = r21.getTabPosition("homepage_tablive");     // Catch: Exception -> L73
    L71:
        r1.put("live_tab_order", r22);     // Catch: Exception -> L73
        r1.put("followings_online_count", ((Number) FeatureManager.u.getFeature("followings_online_count", 0L)).longValue());     // Catch: Exception -> L73
        goto L44
    L70:
        r22 = -1;
        goto L71
    }

    public final JSONObject getFeature(JSONArray r11) {
        if (r11 != null) goto L16;
        return null;
    L16:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L13
        int r2 = r11.length();     // Catch: Exception -> L13
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L21;
        String r5 = r11.get(r4).toString();     // Catch: Exception -> L13
        if (StringsKt.contains$default(r5, "list", false, 2, null) == false) goto L10;
        r1.putOpt(r5, new JSONArray((Collection) FeatureManager.u.getFeature(r5, CollectionsKt.emptyList())));     // Catch: Exception -> L13
    L11:
        r4 = r4 + 1;
        goto L6
    L10:
        r1.putOpt(r5, FeatureManager.u.getFeature(r5, new Object()));     // Catch: Exception -> L13
        goto L11
    L21:
        return r1;
    L13:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
        return null;
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventName");
        Intrinsics.checkNotNullParameter(r8, "params");
        int r2 = r7.hashCode();     // Catch: Exception -> L55
        Long r5 = null;
        if (r2 == (-1115849514)) goto L35;
        if (r2 == 1499179894) goto L10;
        return;
    L10:
        if (r7.equals("livesdk_live_play") == false) goto L62;
        ConcurrentHashMap<Long, JSONObject> r9 = d;     // Catch: Exception -> L55
        String r0 = r8.get("room_id");     // Catch: Exception -> L55
        if (r0 == null) goto L14;
        long r3 = CastLongProtector.parseLong(r0);     // Catch: Exception -> L55
    L15:
        r9.remove(Long.valueOf(r3));     // Catch: Exception -> L55
        String r11 = r8.get("entrance_room_id");     // Catch: Exception -> L55
        if (r11 == null) goto L18;
        r5 = Long.valueOf(CastLongProtector.parseLong(r11));     // Catch: Exception -> L55
    L18:
        long r4 = e;     // Catch: Exception -> L55
        if (r5 != null) goto L22;
        return;
    L22:
        if (r5.longValue() != r4) goto L61;
        LimitSizeQueue r12 = (LimitSizeQueue) CollectionsKt.lastOrNull(c);     // Catch: Exception -> L55
        if (r12 != null) goto L58;
    L32:
        if (r12 == null) goto L63;
        r12.add(g(r8));     // Catch: Exception -> L55
        return;
    L63:
        return;
    L58:
        JSONObject r1 = (JSONObject) CollectionsKt.lastOrNull(r12);     // Catch: Exception -> L30
        if (r1 == null) goto L32;
        r1.put("draw_next", 1);     // Catch: Exception -> L30
    L30:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", e.getMessage());     // Catch: Exception -> L55
        goto L32
    L61:
        return;
    L14:
        r3 = 0;
        goto L15
    L62:
        return;
    L35:
        if (r7.equals("livesdk_live_duration") == false) goto L65;
        LimitSizeQueue r13 = (LimitSizeQueue) CollectionsKt.lastOrNull(c);     // Catch: Exception -> L55
        if (r13 == null) goto L39;
        JSONObject r14 = (JSONObject) CollectionsKt.lastOrNull(r13);     // Catch: Exception -> L55
    L40:
        if (r14 == null) goto L66;
        Object r6 = r14.opt("room_id");     // Catch: Exception -> L55
        if (r6 == null) goto L44;
        String r15 = r6.toString();     // Catch: Exception -> L55
    L46:
        if (TextUtils.equals(r15, r8.get("room_id")) == true) goto L49;
        r14 = null;
    L49:
        if (r14 == null) goto L67;
        String r16 = r8.get("duration");     // Catch: Exception -> L55
        if (r16 == null) goto L53;
        r5 = Long.valueOf(CastLongProtector.parseLong(r16));     // Catch: Exception -> L55
    L53:
        r14.putOpt("duration", r5);     // Catch: Exception -> L55
        return;
    L67:
        return;
    L44:
        r15 = null;
        goto L46
    L66:
        return;
    L39:
        r14 = null;
        goto L40
    L65:
        return;
    L55:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", e.getMessage());
    }
}
