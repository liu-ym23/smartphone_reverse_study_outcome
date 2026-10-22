package av1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.BundleCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTraceSchemaMonitor;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.livepullstream.api.IPullStreamService;
import com.bytedance.android.live.room.enterprocess.IFeedBizInterceptor;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.viewmodule.z0;
import com.bytedance.android.livesdk.config.feed.LiveFeedAdParams;
import com.bytedance.android.livesdk.config.feed.LiveFeedHybridAdParams;
import com.bytedance.android.livesdk.enterprocess.util.RoomWatchTimer;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.log.n;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.performance.h0;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.AdDataParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFlushInfo;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.AESDecryptLiveUrlUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.g;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements IFeedBizInterceptor {
    public static long a;
    public static final b b = null;

    public b() {
    }

    static {
        b = new b();
        a = -1000;
    }

    public static void d(Bundle r14) {
        com.bytedance.android.live.core.feed.a r6 = com.bytedance.android.live.core.feed.a.d.a();
        boolean r7 = false;
        r6.a = false;
        r6.b = -1;
        if (r14.containsKey("source") == true) goto L5;
        return;
    L5:
        if (TextUtils.equals(r14.getString("source"), "ad_union") == false) goto L48;
        r14.putBoolean("enter_from_effect_ad", true);
        if (r14.containsKey("ad_data_params") == true) goto L9;
    L35:
        Bundle r15 = m0.a(r14);
        if (r15 == null) goto L38;
        String r1 = r15.getString("enter_method");
    L40:
        if (Intrinsics.areEqual("top_portrait", r1) == false) goto L42;
        return;
    L42:
        if (r15 == null) goto L49;
        r15.putString("enter_from_merge", "ad_union");
        r15.putString("enter_method", "h5");
        return;
    L49:
        return;
    L38:
        r1 = null;
        goto L40
    L9:
        if (TextUtils.isEmpty(r14.getString("ad_data_params")) == true) goto L35;
        HashMap r9 = new HashMap();
        HashMap r10 = new HashMap();
        AdDataParams r8 = (AdDataParams) new Gson().fromJson(r14.getString("ad_data_params"), AdDataParams.class);     // Catch: Exception -> L29
        if (r8 == null) goto L32;
        r7 = b(r8.getLiveSDKInfoExtra(), r10);     // Catch: Exception -> L29
        r9.put("ad_id", String.valueOf(r8.getAid()));     // Catch: Exception -> L29
        r9.put("value", String.valueOf(r8.getCid()));     // Catch: Exception -> L29
        r9.put("log_extra", r8.getLog_extra());     // Catch: Exception -> L29
        r9.put("IESLiveEffectAdTrackExtraServiceKey", e(r8.getLog_extra(), String.valueOf(r8.getCid())));     // Catch: Exception -> L29
        long r11 = r14.getLong("live.intent.extra.ROOM_ID", 0);     // Catch: Exception -> L29
        nn2.a r13 = nn2.a.d;     // Catch: Exception -> L29
        if (nn2.a.a.a().b(r11) == false) goto L16;
        String r12 = "union_ad";
    L17:
        r9.put("is_other_channel", r12);     // Catch: Exception -> L29
        if (r7 == false) goto L32;
        if (r10.containsKey("ad_id") == true) goto L23;
        r10.put("ad_id", String.valueOf(r8.getAid()));     // Catch: Exception -> L29
    L23:
        if (r10.containsKey("IESLiveEffectAdTrackExtraServiceKey") == true) goto L26;
        r10.put("IESLiveEffectAdTrackExtraServiceKey", e((String) r10.get("log_extra"), String.valueOf(r8.getCid())));     // Catch: Exception -> L29
    L26:
        if (TextUtils.equals(r12, (CharSequence) r10.get("is_other_channel")) == true) goto L32;
        ALogger.e("FeedBizInterceptor", "configIntentFromPangolin:adRawString is_other_channel unexpected: channel=" + r12 + ", remote=" + ((String) r10.get("is_other_channel")));     // Catch: Exception -> L29
        goto L32
    L16:
        r12 = "effective_ad";
    L32:
        if (r7 == false) goto L34;
        r14.putSerializable("live_effect_ad_log_extra_map", r10);
        goto L35
    L34:
        r14.putSerializable("live_effect_ad_log_extra_map", r9);
    L29:
        e = move-exception;
        ALogger.e("FeedBizInterceptor", "穿山甲配置数据格式有问题 - crash - " + e.getMessage());
        goto L32
    }

    public static void f(long r2) {
        HashMap r0 = new HashMap();
        r0.put("roomId", String.valueOf(r2));
        u.l().sendLog("decrypt_stream_url_failed", r0, new Object[0]);
    }

    public static void a(long r7, Bundle r9) {
        String r1 = yt2.a.e(r9, "live.intent.extra.PULL_STREAM_DATA");
        if (TextUtils.isEmpty(r1) == true) goto L12;
        ALogger.i("FeedBizInterceptor", "prepare decrypt EXTRA_PULL_STREAM_DATA");
        AESDecryptLiveUrlUtils r2 = AESDecryptLiveUrlUtils.INSTANCE;
        int r5 = bv1.a.a;
        String r3 = r2.getDecryptPullUrl(r1, "naZ=Q%#3xu2f5vs9");
        if (TextUtils.isEmpty(r3) == false) goto L8;
        ALogger.e("FeedBizInterceptor", "decrypt EXTRA_PULL_STREAM_DATA failed");
        f(r7);
    L8:
        if (yt2.a.a() == false) goto L10;
        yt2.a.g(r9, "live.intent.extra.PULL_STREAM_DATA", r3);
        goto L12
    L10:
        r9.putString("live.intent.extra.PULL_STREAM_DATA", r3);
    L12:
        if (r9.getBoolean("enter_preview_smooth", false) == false) goto L19;
        String r4 = yt2.a.e(r9, "live.intent.extra.PULL_SHARE_URL");
        if (TextUtils.isEmpty(r4) == true) goto L19;
        ALogger.i("FeedBizInterceptor", "prepare decrypt EXTRA_PULL_SHARE_URL");
        AESDecryptLiveUrlUtils r6 = AESDecryptLiveUrlUtils.INSTANCE;
        int r8 = bv1.a.a;
        String r10 = r6.getDecryptPullUrl(r4, "naZ=Q%#3xu2f5vs9");
        if (TextUtils.isEmpty(r10) == false) goto L18;
        ALogger.e("FeedBizInterceptor", "decrypt EXTRA_PULL_SHARE_URL failed");
        f(r7);
    L18:
        yt2.a.g(r9, "live.intent.extra.PULL_SHARE_URL", r10);
    L19:
        String r11 = yt2.a.e(r9, "live.intent.extra.PULL_STREAM_URL");
        if (TextUtils.isEmpty(r11) == true) goto L25;
        ALogger.i("FeedBizInterceptor", "prepare decrypt EXTRA_PULL_STREAM_URL");
        AESDecryptLiveUrlUtils r12 = AESDecryptLiveUrlUtils.INSTANCE;
        int r13 = bv1.a.a;
        String r14 = r12.getDecryptPullUrl(r11, "naZ=Q%#3xu2f5vs9");
        if (TextUtils.isEmpty(r14) == false) goto L24;
        ALogger.e("FeedBizInterceptor", "decrypt EXTRA_PULL_STREAM_URL failed");
        f(r7);
    L24:
        r9.putString("live.intent.extra.PULL_STREAM_URL", r14);
    L25:
        StreamUrl r0 = yt2.a.c(r9);
        if (r0 != null) goto L28;
        return;
    L28:
        if ((r0 instanceof StreamUrl) == false) goto L38;
        int r15 = bv1.a.a;
        if (r0.decryptLiveUrl("naZ=Q%#3xu2f5vs9") == false) goto L33;
        ALogger.e("FeedBizInterceptor", "decrypt EXTRA_PULL_STREAM_URL failed");
        f(r7);
    L33:
        if (yt2.a.a() == false) goto L35;
        BundleCompat.putBinder(r9, "live.intent.extra.PULL_ORIGIN_STREAM_URL", new g(r0));
        return;
    L35:
        r9.putSerializable("live.intent.extra.PULL_ORIGIN_STREAM_URL", r0);
        return;
    }

    public static boolean b(String r7, HashMap r8) {
        boolean r2 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L30;
        JSONObject r5 = new JSONObject(r7);     // Catch: Exception -> L24
        String r9 = r5.optString("is_other_channel", "");     // Catch: Exception -> L24
        String r6 = r5.optString("log_extra", "");     // Catch: Exception -> L24
        String r1 = r5.optString("value", "");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r9) == false) goto L14;
    L22:
        ALogger.i("FeedBizInterceptor", "configAdLiveSdkInfoExtra: check liveSDKInfoExtra");     // Catch: Exception -> L24
        return false;
    L14:
        if (TextUtils.isEmpty(r6) == true) goto L22;
        if (TextUtils.isEmpty(r1) == true) goto L22;
        Iterator<String> r10 = r5.keys();     // Catch: Exception -> L24
    L20:
        if (r10.hasNext() == false) goto L27;
        String r3 = r10.next();     // Catch: Exception -> L24
        r8.put(r3, r5.optString(r3));     // Catch: Exception -> L24
    L27:
        return r2;
    L24:
        e = move-exception;
        ALogger.e("FeedBizInterceptor", "configAdLiveSdkInfoExtra - crash - " + e.getMessage());
        r2 = false;
        goto L27
    L30:
        return false;
    L5:
        if (r7.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static String e(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.put("log_extra", r2);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.put("creativeID", r3);
    L9:
        return r0.toString();
    }

    public final void processEnterRoomParam(long r2, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "enterRoomParam");
        d(r4);     // Catch: Throwable -> L5
        a(r2, r4);     // Catch: Throwable -> L5
        a = -1000;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ALogger.e("FeedBizInterceptor", "decrypt pull url failed", th);
    }

    public final void processHandleIntent(Bundle r7, Bundle r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.core.feed.a.a r0 = com.bytedance.android.live.core.feed.a.d;
        com.bytedance.android.live.core.feed.a r1 = r0.a();
        r1.a = false;
        r1.b = -1;
        LiveTraceSchemaMonitor.m(BaseMonitor.MonitorEventModule.ENTER_ROOM, LiveTraceSchemaMonitor.Status.SUCCESS, "进房成功", yt2.a.e(r7, "live.intent.extra.EXTRA_ENTER_ROOM_FROM_SCHEMA"), "LiveRoomFragment");
        Map r2 = n.a;
        Intrinsics.checkNotNullParameter(r7, "arguments");
        Object r3 = r7.get("live.intent.extra.EXTRA_PENETRATE_PARAMS_CLICK");
        Object r4 = null;
        if ((r3 instanceof Map) == true) goto L7;
        r3 = null;
    L7:
        n.c = (Map) r3;
        n.d = Intrinsics.areEqual(r7.get("live.intent.extra.EXTRA_PENETRATE_PARAMS_EFFECT_DRAW"), Boolean.TRUE);
        n.e = n.c(r7);
        n.f = null;
        n.d(r7);
        if (r7.getSerializable("live_effect_ad_log_extra_map") == null) goto L28;
        r7.putBoolean("enter_from_effect_ad", true);
        com.bytedance.android.live.core.feed.a r5 = r0.a();
        r5.getClass();
        Serializable r6 = r7.getSerializable("live_effect_ad_log_extra_map");
        if ((r6 instanceof HashMap) == false) goto L28;
        Object r9 = ((Map) r6).get("send_ad_click_event");
        if ((r9 instanceof Integer) == true) goto L15;
        r9 = null;
    L15:
        Integer r10 = (Integer) r9;
        if ((r10 instanceof Integer) == false) goto L28;
        if (r10.intValue() != 1) goto L28;
        Object r11 = r7.get("live.intent.extra.ROOM_ID");
        if ((r11 instanceof Long) == false) goto L24;
        r4 = r11;
    L24:
        Long r12 = (Long) r4;
        if ((r12 instanceof Long) == false) goto L28;
        r5.b = r12.longValue();
    L28:
        if (r8 != null) goto L30;
        return;
    L30:
        if (r8.containsKey("enter_from_merge") == true) goto L33;
        r8.putString("enter_from_merge", r7.getString("enter_from_merge", ""));
    L33:
        if (r8.containsKey("enter_method") == true) goto L37;
        r8.putString("enter_method", r7.getString("enter_method", ""));
        return;
    }

    public final void processStartFirstRoomRunnable(Bundle r3, Bundle r4) {
        if (r3 == null) goto L10;
        if (r4 == null) goto L11;
        String r0 = r3.getString("data_live_effect_ad_log_extra_string");
        String r5 = r3.getString("data_live_hybrid_ad_inner_log_extra_string");
        if (r2.a(r0) == false) goto L7;
    L8:
        c(r0, r5, r4);
        return;
    L7:
        if (r2.a(r5) == true) goto L8;
        return;
    L11:
        return;
    }

    public static void c(String r12, String r13, Bundle r14) {
        if (r14 != null) goto L5;
        return;
    L5:
        if (r2.a(r13) == false) goto L17;
        if (r13 == null) goto L54;
        com.bytedance.android.live.core.feed.a.d.a().a = true;
        LiveFeedHybridAdParams r15 = (LiveFeedHybridAdParams) GsonProtectorUtils.fromJson(new Gson(), r13, LiveFeedHybridAdParams.class);     // Catch: JsonSyntaxException -> L15
        String r0 = r15.component2();     // Catch: JsonSyntaxException -> L15
        String r16 = r15.component3();     // Catch: JsonSyntaxException -> L15
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r16) == true) goto L56;
        HashMap r5 = new HashMap();     // Catch: JsonSyntaxException -> L15
        r5.put("value", r0);     // Catch: JsonSyntaxException -> L15
        r5.put("log_extra", r16);     // Catch: JsonSyntaxException -> L15
        r14.putBoolean("enter_from_hybrid_ad", true);     // Catch: JsonSyntaxException -> L15
        r14.putString("data_live_hybrid_ad_inner_log_extra_string", r13);     // Catch: JsonSyntaxException -> L15
        r14.putSerializable("live_hybrid_ad_log_extra_map", r5);     // Catch: JsonSyntaxException -> L15
        return;
    L56:
        return;
    L15:
        e = move-exception;
        ALogger.e("FeedBizInterceptor", "configHybridAd error " + Log.getStackTraceString(e));
        return;
    L54:
        return;
    L17:
        if (r12 != null) goto L19;
        return;
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L59;
        com.bytedance.android.live.core.feed.a.d.a().a = true;
        r14.putBoolean("enter_from_effect_ad", true);
        HashMap r2 = new HashMap();
        HashMap r7 = new HashMap();
        boolean r8 = false;
        LiveFeedAdParams r9 = (LiveFeedAdParams) new Gson().fromJson(r12, LiveFeedAdParams.class);     // Catch: Exception -> L42
        if (r9 == null) goto L45;
        r8 = b(r9.getLiveSDKInfoExtra(), r7);     // Catch: Exception -> L42
        r2.put("ad_id", r9.getAdId());     // Catch: Exception -> L42
        r2.put("value", r9.getCreativeId());     // Catch: Exception -> L42
        r2.put("log_extra", r9.getLogExtra());     // Catch: Exception -> L42
        r2.put("IESLiveEffectAdTrackExtraServiceKey", e(r9.getLogExtra(), r9.getCreativeId()));     // Catch: Exception -> L42
        long r10 = r14.getLong("live.intent.extra.ROOM_ID", 0);     // Catch: Exception -> L42
        nn2.a r1 = nn2.a.d;     // Catch: Exception -> L42
        if (nn2.a.a.a().b(r10) == false) goto L26;
        String r3 = "union_ad";
    L27:
        r2.put("is_other_channel", r3);     // Catch: Exception -> L42
        if (r8 == false) goto L39;
        if (r7.containsKey("ad_id") == true) goto L33;
        r7.put("ad_id", r9.getAdId());     // Catch: Exception -> L42
    L33:
        if (r7.containsKey("IESLiveEffectAdTrackExtraServiceKey") == true) goto L36;
        r7.put("IESLiveEffectAdTrackExtraServiceKey", e((String) r7.get("log_extra"), r9.getCreativeId()));     // Catch: Exception -> L42
    L36:
        if (TextUtils.equals(r3, (CharSequence) r7.get("is_other_channel")) == true) goto L39;
        ALogger.e("FeedBizInterceptor", "adRawString is_other_channel unexpected: channel=" + r3 + ", remote=" + ((String) r7.get("is_other_channel")));     // Catch: Exception -> L42
    L39:
        if (r9.getEcpm() == null) goto L45;
        Double r4 = r9.getEcpm();     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L42
        r14.putDouble("live_effect_ad_ecpm", r4.doubleValue());     // Catch: Exception -> L42
        goto L45
    L26:
        r3 = "effective_ad";
    L45:
        if (r8 == false) goto L47;
        r14.putSerializable("live_effect_ad_log_extra_map", r7);
    L48:
        r14.putString("data_live_effect_ad_log_extra_string", r12);
        return;
    L47:
        r14.putSerializable("live_effect_ad_log_extra_map", r2);
    L42:
        e = move-exception;
        ALogger.e("FeedBizInterceptor", "穿山甲配置数据格式有问题 - crash - " + e.getMessage());
        goto L45
    }

    public final void onActivityStateChanged(boolean r2, LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r2 == true) goto L5;
        return;
    L5:
        if (r4 != Lifecycle.Event.ON_DESTROY) goto L9;
        String r5 = bv1.b.a;
        bv1.b.a = "";
        return;
    }

    public final void processOnDestroy(Room r4, int r5, boolean r6) {
        h0.b.getClass();
        h0.a = 1;
        IFeatureService r1 = k.f(IFeatureService.class);
        if (r1 == null) goto L6;
        if (r4 == null) goto L6;
        r1.handleRoom(r4);
    L6:
        k60.b.j(r5);
        n.c = null;
        n.d = Intrinsics.areEqual(null, Boolean.TRUE);
        n.e = n.c(null);
        n.f = null;
        n.a = null;
        n.b = n.c(null);
        n.f = null;
        if (r6 == false) goto L12;
        nn2.a r7 = nn2.a.d;
        nn2.a r8 = nn2.a.a.a();
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("sum_ecpm", new BigDecimal(CollectionsKt.sumOfDouble(((LinkedHashMap) r8.b).values())).toString());
        u.l().sendLog("live_sum_ecpm", r9, new Object[0]);
        ((LinkedHashMap) r8.b).clear();
        Map r10 = com.bytedance.android.livesdk.preview.u.a;
        e r11 = com.bytedance.android.livesdk.sharedpref.b.z1;
        Map r12 = com.bytedance.android.livesdk.preview.u.a;
        HashMap r13 = new HashMap(r12);
        r11.getClass();
        f.d(r11, r13);
        ((LinkedHashMap) r12).clear();
        IEnterGuideService r14 = k.f(IEnterGuideService.class);
        if (r14 == null) goto L11;
        r14.taskManagerReleaseAction();
    L11:
        bv1.b.a = "";
    L12:
        IEnterGuideService r15 = k.f(IEnterGuideService.class);
        if (r15 == null) goto L15;
        r15.taskManagerReset();
    L15:
        com.bytedance.android.livesdk.bottomguide.b.a = true;
        z0.a = true;
    }

    public final int processStatusBarHeight(int r2, Intent r3, Bundle r4) {
        if (r3 == null) goto L7;
        Bundle r5 = r3.getBundleExtra("argument");
        Context r6 = BadParcelableCrashOptimizer.getContext();
        if (r5 == null) goto L9;
        if (r6 == null) goto L9;
        r5.setClassLoader(r6.getClassLoader());
    L9:
        if (r5 == null) goto L11;
        boolean r7 = r5.getBoolean("enter_preview_smooth", false);
    L12:
        if (r7 == false) goto L16;
        if (r2 > 0) goto L17;
        return 0;
    L17:
        return r2;
    L16:
        return r2;
    L11:
        r7 = false;
        goto L12
    L7:
        r5 = null;
        goto L9
    }

    public final void processInstantiateItem(int r5, Intent r6, Bundle r7, Bundle r8) {
        if (r6 == null) goto L7;
        Bundle r9 = r6.getBundleExtra("argument");
        Context r0 = BadParcelableCrashOptimizer.getContext();
        if (r9 == null) goto L8;
        if (r0 == null) goto L8;
        r9.setClassLoader(r0.getClassLoader());
    L8:
        if (r9 == null) goto L74;
        int r1 = -1;
        if (r7 == null) goto L13;
        r1 = r7.getInt("live.intent.extra.DESIRED_TOP_SPACE_HEIGHT", -1);
    L13:
        if (r9.getBoolean("enter_preview_smooth", false) == false) goto L21;
        if (r1 > 0) goto L21;
        Bundle r10 = m0.a(r9);
        if (r10 == null) goto L18;
        int r11 = r10.getInt("live.intent.extra.EXTRA_INTERACTION_LAYER_MARGIN_TOP");
    L19:
        if (r8 == null) goto L21;
        r8.putInt("live.intent.extra.EXTRA_INTERACTION_LAYER_MARGIN_TOP", r11);
        goto L21
    L18:
        r11 = 0;
    L21:
        if (r8 == null) goto L75;
        if (r5 != 0) goto L79;
        Bundle r12 = m0.a(r9);
        if (r9.containsKey("enter_room_num") == false) goto L27;
        r8.putInt("enter_room_num", r9.getInt("enter_room_num", 0));
        r9.remove("enter_room_num");
    L32:
        if (r9.containsKey("auto_enter") == false) goto L34;
        r8.putBoolean("auto_enter", r9.getBoolean("auto_enter", false));
        r9.remove("auto_enter");
    L39:
        if (r9.containsKey("is_from_preview") == false) goto L41;
        r8.putInt("is_from_preview", r9.getInt("is_from_preview", 0));
        r9.remove("is_from_preview");
    L46:
        if (r9.containsKey("try_enter_room_time") == false) goto L48;
        r8.putLong("try_enter_room_time", r9.getLong("try_enter_room_time", 0));
        r9.remove("try_enter_room_time");
    L53:
        if (r9.containsKey("is_enter_from_other_channel") == false) goto L55;
        r8.putInt("is_enter_from_other_channel", r9.getInt("is_enter_from_other_channel", 0));
        r9.remove("is_enter_from_other_channel");
    L60:
        if (r9.containsKey("is_plugin_install_when_enter_room") == false) goto L62;
        r8.putInt("is_plugin_install_when_enter_room", r9.getInt("is_plugin_install_when_enter_room", 0));
        r9.remove("is_plugin_install_when_enter_room");
    L67:
        if (r9.containsKey("is_plugin_load_when_enter_room") == false) goto L69;
        r8.putInt("is_plugin_load_when_enter_room", r9.getInt("is_plugin_load_when_enter_room", 0));
        r9.remove("is_plugin_load_when_enter_room");
        return;
    L69:
        if (r12 != null) goto L71;
        return;
    L71:
        if (r12.containsKey("is_plugin_load_when_enter_room") == false) goto L78;
        r8.putInt("is_plugin_load_when_enter_room", r12.getInt("is_plugin_load_when_enter_room", 0));
        r12.remove("is_plugin_load_when_enter_room");
        return;
    L78:
        return;
    L62:
        if (r12 == null) goto L67;
        if (r12.containsKey("is_plugin_install_when_enter_room") == false) goto L67;
        r8.putInt("is_plugin_install_when_enter_room", r12.getInt("is_plugin_install_when_enter_room", 0));
        r12.remove("is_plugin_install_when_enter_room");
        goto L67
    L55:
        if (r12 == null) goto L60;
        if (r12.containsKey("is_enter_from_other_channel") == false) goto L60;
        r8.putInt("is_enter_from_other_channel", r12.getInt("is_enter_from_other_channel", 0));
        r12.remove("is_enter_from_other_channel");
        goto L60
    L48:
        if (r12 == null) goto L53;
        if (r12.containsKey("try_enter_room_time") == false) goto L53;
        r8.putLong("try_enter_room_time", r12.getLong("try_enter_room_time", 0));
        r12.remove("try_enter_room_time");
        goto L53
    L41:
        if (r12 == null) goto L46;
        if (r12.containsKey("is_from_preview") == false) goto L46;
        r8.putInt("is_from_preview", r12.getInt("is_from_preview", 0));
        r12.remove("is_from_preview");
        goto L46
    L34:
        if (r12 == null) goto L39;
        if (r12.containsKey("auto_enter") == false) goto L39;
        r8.putBoolean("auto_enter", r12.getBoolean("auto_enter", false));
        r12.remove("auto_enter");
        goto L39
    L27:
        if (r12 == null) goto L32;
        if (r12.containsKey("enter_room_num") == false) goto L32;
        r8.putInt("enter_room_num", r12.getInt("enter_room_num", 0));
        r12.remove("enter_room_num");
        goto L32
    L79:
        return;
    L75:
        return;
    L74:
        return;
    L7:
        r9 = null;
        goto L8
    }

    public final void processSaveBackRoomInfo(Room r3, Bundle r4, Bundle r5, RoomFlushInfo r6) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.adRawString;
    L7:
        if (r2.a(r1) == true) goto L13;
        if (r3 == null) goto L10;
        String r2 = r3.getHybridAdExtra();
    L12:
        if (r2.a(r2) == true) goto L13;
    L19:
        if (r5 == null) goto L22;
        r5.putParcelable("live.intent.provider_room_flush_info", r6);
        return;
    L22:
        return;
    L10:
        r2 = null;
    L13:
        if (r3 == null) goto L15;
        String r7 = r3.adRawString;
    L16:
        if (r3 == null) goto L18;
        r0 = r3.getHybridAdExtra();
    L18:
        c(r7, r0, r4);
        goto L19
    L15:
        r7 = null;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public final void processLogShow(int r7, Bundle r8, Map<String, String> r9, RoomFlushInfo r10, Room r11) {
        Intrinsics.checkNotNullParameter(r9, "outputLogMap");
        if (r8 != null) goto L5;
    L16:
        r9.put("flow_id", bv1.b.a);
        r9.put("flow_pos_num", String.valueOf(r7 + 1));
        if (r10 == null) goto L19;
        r9.put("flow_req_bursh", String.valueOf(r10.getFlushTimes()));
        r9.put("flow_req_pos_num", String.valueOf(r10.getPositionInFlush()));
    L19:
        if (r11 == null) goto L24;
        nn2.a r12 = nn2.a.d;
        if (nn2.a.a.a().b(r11.id) == false) goto L25;
        nn2.a.a.a();
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter("draw_ad", "adType");
        nn2.a.a("show", r11, "draw_ad");
        nn2.a.a.a();
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter("draw_ad", "adType");
        nn2.a.a("click", r11, "draw_ad");
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r8.getLong("anchor_aid") == 0) goto L8;
        r9.put("anchor_aid", String.valueOf(r8.getLong("anchor_aid")));
    L8:
        if (r8.getLong("xg_uid") == 0) goto L11;
        r9.put("xg_uid", String.valueOf(r8.getLong("xg_uid")));
    L11:
        if (TextUtils.isEmpty(r8.getString("live_reason")) == true) goto L14;
        r9.put("live_reason", r8.getString("live_reason"));
    L14:
        if (TextUtils.isEmpty(r8.getString("live_recommend_info")) == true) goto L16;
        r9.put("live_recommend_info", r8.getString("live_recommend_info"));
        goto L16
    }

    public final void processPageSelected(int r7, int r8, int r9, Room r10, Bundle r11) {
        if (r7 == r8) goto L5;
        h0.b.getClass();
        h0.a++;
    L5:
        if (r11 == null) goto L24;
        long r1 = 0;
        if (r11.getLong("live.intent.extra.ROOM_ID", 0) <= 0) goto L10;
        r1 = r11.getLong("live.intent.extra.ROOM_ID");
    L15:
        n.d(r11);
        long r3 = a;
        if (r1 == r3) goto L24;
        IPerformanceManager r12 = k.f(IPerformanceManager.class);
        if (r12 == null) goto L20;
        r12.forceStopLoadStallMonitor(r3, true);
    L20:
        IPerformanceManager r13 = k.f(IPerformanceManager.class);
        if (r13 == null) goto L23;
        r13.startLoadStallMonitor(r1);
    L23:
        a = r1;
        goto L24
    L10:
        if (TextUtils.isEmpty(r11.getString("live.intent.extra.ROOM_ID", "")) == true) goto L15;
        String r14 = r11.getString("live.intent.extra.ROOM_ID");     // Catch: NumberFormatException -> L13
        Intrinsics.checkNotNull(r14);     // Catch: NumberFormatException -> L13
        r1 = CastLongProtector.parseLong(r14);     // Catch: NumberFormatException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (r9 <= r7) goto L44;
        if (r10 == null) goto L44;
        String r15 = null;
        if (r11 == null) goto L29;
        String r2 = r11.getString("data_live_effect_ad_log_extra_string");
    L30:
        if (r11 == null) goto L33;
        r15 = r11.getString("data_live_hybrid_ad_inner_log_extra_string");
    L33:
        if (TextUtils.isEmpty(r2) == true) goto L36;
        r10.adRawString = r2;
    L36:
        if (TextUtils.isEmpty(r15) == true) goto L39;
        r10.setHybridAdExtra(r15);
    L39:
        if (r2.a(r10.adRawString) == false) goto L41;
    L42:
        if (r11 == null) goto L44;
        c(r10.adRawString, r10.getHybridAdExtra(), r11);
        goto L44
    L41:
        if (r2.a(r10.getHybridAdExtra()) == false) goto L44;
    L29:
        r2 = null;
    L44:
        IPullStreamService r16 = k.f(IPullStreamService.class);
        if (r16 == null) goto L50;
        com.bytedance.android.live.livepullstream.service.c r17 = r16.getLivePlayerOptimizer();
        if (r17 == null) goto L50;
        if (r17.a() != true) goto L50;
        return;
    L50:
        IFeatureService r18 = k.f(IFeatureService.class);
        if (r18 == null) goto L59;
        if (r9 <= r7) goto L60;
        if (r10 == null) goto L61;
        r18.handleRoom(r10);
        return;
    L61:
        return;
    L60:
        return;
    }

    public final void processSetup(String r8, String r9, Bundle r10, Bundle r11, Lifecycle r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        String r4 = null;
        String r5 = r10.getString("ecom_live_params", null);     // Catch: JSONException -> L35
        if (r2.a(r5) == false) goto L10;
        if (r11 == null) goto L10;
        r11.putString("ecom_live_params", r5);     // Catch: JSONException -> L35
    L10:
        String r6 = r10.getString("ad_live_params", null);     // Catch: JSONException -> L35
        if (r2.a(r6) == false) goto L14;
        if (r11 == null) goto L14;
        r11.putString("ad_live_params", r6);     // Catch: JSONException -> L35
    L14:
        if (r11 == null) goto L17;
        r4 = r11.getString("ecom_live_params");     // Catch: JSONException -> L35
    L17:
        if (r2.a(r4) == false) goto L19;
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L35
    L20:
        String r7 = r10.getString("shop_guide_id", "");     // Catch: JSONException -> L35
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L35
        r13.put("shop_guide_id", r7);     // Catch: JSONException -> L35
        if (r0.has("pass_through_log_data") == true) goto L24;
        r0.put("pass_through_log_data", r13);     // Catch: JSONException -> L35
    L30:
        String r1 = r0.toString();     // Catch: JSONException -> L35
        if (r2.a(r1) == false) goto L37;
        if (r11 == null) goto L37;
        r11.putString("ecom_live_params", r1);     // Catch: JSONException -> L35
    L37:
        boolean r2 = true;
        if (Intrinsics.areEqual("live_timing_task", r8) == true) goto L40;
    L46:
        String r14 = bv1.b.a;
        String r15 = r8 + "_" + r9 + "_" + System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r15, "flowId");
        if (bv1.b.a.length() == 0) goto L50;
        r2 = false;
    L50:
        if (r2 == false) goto L55;
        bv1.b.a = r15;
        return;
    L55:
        return;
    L40:
        if (r10.getInt("campaign_task_timer_interval") < 1) goto L46;
        int r16 = r10.getInt("campaign_task_timer_interval");
        int r3 = r10.getInt("campaign_task_timer_left_times");
        String r17 = r10.getString("campaign_task_token");
        if (r17 == null) goto L46;
        RoomWatchTimer r18 = new RoomWatchTimer(r16, r3, r17);
        if (r12 == null) goto L46;
        r12.addObserver(r18);
        goto L46
    L24:
        if (r0.optJSONObject("pass_through_log_data") == null) goto L30;
        if ((r0.optJSONObject("pass_through_log_data") instanceof JSONObject) == false) goto L30;
        JSONObject r19 = r0.optJSONObject("pass_through_log_data");     // Catch: JSONException -> L35
        if (r19 == null) goto L30;
        r19.put("shop_guide_id", r7);     // Catch: JSONException -> L35
        goto L30
    L19:
        r0 = new JSONObject();     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    }
}
