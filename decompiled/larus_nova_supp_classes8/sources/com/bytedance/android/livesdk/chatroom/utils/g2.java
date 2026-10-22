package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.feed.LiveFeedType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g2 {
    public static boolean a;
    public static CompositeDisposable b;

    public interface a {
        public static final Throwable a = null;
        public static final Throwable b = null;

        static {
            a = new IllegalStateException("is fetching");
            new IllegalStateException("no tab data");
            new IllegalStateException("request is empty");
            b = new RuntimeException("enter room failed.");
        }
    }

    public static Bundle b(FeedItem r4, FeedExtra r5) {
        String r0 = null;
        if (r4 != null) goto L5;
    L30:
        return null;
    L5:
        if (r4.getItem() == null) goto L30;
        if ((r4.getItem() instanceof Room) == false) goto L30;
        Bundle r1 = ArgumentsBuilder.buildRoomArgs(r4.getItem());
        if (r5 != null) goto L31;
    L28:
        com.bytedance.android.livesdk.log.n.a(r1, r4);
        return r1;
    L31:
        r1.putString("live.intent.extra.LOG_PB", String.valueOf(r5.getLogPb()));     // Catch: Exception -> L26
        r1.putString("log_pb", String.valueOf(r5.getLogPb()));     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r5.reqId) == true) goto L14;
    L16:
        r1.putString("live.intent.extra.REQUEST_ID", r5.reqId);     // Catch: Exception -> L26
        r1.putString("request_id", r5.reqId);     // Catch: Exception -> L26
        if (r4.isRecommendCard == false) goto L19;
        r0 = "pop_card";
    L19:
        r1.putString("enter_from_merge_recommend", r0);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r4.liveReason) == true) goto L23;
        r1.putString("live_reason", r4.liveReason);     // Catch: Exception -> L26
    L23:
        if (TextUtils.isEmpty(r4.adRawString) == true) goto L28;
        r1.putString("data_live_effect_ad_log_extra_string", r4.adRawString);     // Catch: Exception -> L26
        goto L28
    L14:
        if (TextUtils.isEmpty(String.valueOf(r5.getLogPb())) == true) goto L16;
        r5.reqId = JSONObjectProtectorUtils.getString(new JSONObject(r5.getLogPb().toString()), "impr_id");     // Catch: Exception -> L26
    L26:
        e = move-exception;
        ALogger.e("NewFeedStyleEntranceUtils", e);
        goto L28
    }

    public static void a(final Map r24, final v r25, final ILiveCallback r26) {
        if (a == false) goto L7;
        if (r26 == null) goto L43;
        r26.onFailed(a.a);
        return;
    L43:
        return;
    L7:
        a = true;
        final long r6 = SystemClock.elapsedRealtime();
        final long r8 = System.currentTimeMillis();
        if (r24.containsKey("enter_from_merge") == false) goto L10;
        String r1 = (String) r24.get("enter_from_merge");
    L11:
        if (r25 == null) goto L16;
        if (TextUtils.isEmpty(r1) == false) goto L16;
        r1 = "live_merge_task";
    L16:
        if (r24.containsKey("enter_method") == false) goto L18;
        String r2 = (String) r24.get("enter_method");
    L19:
        String r21 = r1 + "-" + r2;
        if (b != null) goto L22;
        b = new CompositeDisposable();
    L22:
        final String r5 = com.bytedance.android.live.core.feed.c.a(r1, r2, LiveFeedType.INNER_FLOW).getLiveFeedUrl();
        CompositeDisposable r3 = b;
        long r11 = 0;
        if (r24.containsKey("force_is_draw") == true) goto L25;
    L28:
        long r16 = r11;
        if (r3 == null) goto L44;
        HashMap r4 = new HashMap();
    L37:
        e = move-exception;
        ALogger.e("NewFeedStyleEntranceUtils", e);
    L39:
        Map r0 = com.bytedance.android.livesdk.preview.u.a;
        r4.putAll(com.bytedance.android.livesdk.preview.u.d());
        CompositeDisposable r7 = b;
        com.bytedance.android.livesdk.service.l.d().getClass();
        r7.add(((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(r5, 0, "enter_auto_feed_draw_refresh", r16, -1, "", r21, null, r4).map(new c2()).doOnNext(new d2()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e2(r26, r25, r24, r5, r6, r8), new f2(r26)));
        return;
    L32:
        if (r24.containsKey("feed_extra_params") == false) goto L39;
        String r9 = (String) r24.get("feed_extra_params");     // Catch: Exception -> L37
        if (StringUtils.isEmpty(r9) == true) goto L39;
        r4.putAll((HashMap) LiveGsonHelper.get().fromJson(r9, HashMap.class));     // Catch: Exception -> L37
        goto L39
    L44:
        return;
    L25:
        if ("1".equals((String) r24.get("force_is_draw")) == false) goto L27;
        r11 = 1;
    L27:
        r24.remove("force_is_draw");
        goto L28
    L18:
        r2 = "live_cover";
        goto L19
    L10:
        r1 = "live_merge";
        goto L11
    }
}
