package com.bytedance.android.live.core.activity;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;
import x40.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BannerFullMonitor {

    public static final enum BannerType extends Enum<BannerType> {
        public static final BannerType BOTTOM_RIGHT = null;
        public static final BannerType OTHER = null;
        public static final BannerType TOP_RIGHT = null;
        public static final BannerType TOP_RIGHT_TASK = null;
        public static final /* synthetic */ BannerType[] a = null;
        private String type;

        static {
            BannerType r0 = new BannerType("TOP_RIGHT", 0, "top_right");
            TOP_RIGHT = r0;
            BannerType r1 = new BannerType("BOTTOM_RIGHT", 1, "bottom_right");
            BOTTOM_RIGHT = r1;
            BannerType r2 = new BannerType("TOP_RIGHT_TASK", 2, "top_right_task");
            TOP_RIGHT_TASK = r2;
            BannerType r4 = new BannerType("OTHER", 3, "other");
            OTHER = r4;
            a = new BannerType[]{r0, r1, r2, r4};
        }

        public static BannerType[] values() {
            return (BannerType[]) a.clone();
        }

        public static /* synthetic */ String access$000(BannerType r0) {
            return r0.type;
        }

        public static BannerType valueOf(String r1) {
            return (BannerType) a.a(BannerType.class, r1);
        }

        public BannerType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public static void b(int r7, String r8, String r9, BannerType r11, String r12) {
        a("ttlive_in_room_banner_fetch_result", r7, r9, null, r8, r11, r12);
    }

    public static void a(String r9, int r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, BannerType r15, String r16) {
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (ActivityMonitor.a() == true) goto L40;
        return;
    L40:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L35
        if (r12 == null) goto L11;
        r4.put("room_id", r12);     // Catch: JSONException -> L35
    L11:
        if (r13 == null) goto L13;
        r4.put(LiveSlardarConstants.EXTRA_KEY_URL, r13);     // Catch: JSONException -> L35
    L13:
        if (r14 == null) goto L15;
        r4.put("status_msg", r14);     // Catch: JSONException -> L35
    L15:
        LiveTracingMonitor.EventModule r17 = LiveTracingMonitor.EventModule.ACTIVITY;     // Catch: JSONException -> L35
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L35
        r18.put("status_code", r11);     // Catch: JSONException -> L38
    L44:
        r18.put("category_1", BannerType.access$000(r15));     // Catch: JSONException -> L39
    L20:
        LiveMonitor r19 = new LiveMonitor();     // Catch: JSONException -> L35
        r19.mCategory = r18;     // Catch: JSONException -> L35
        r19.mEventModule = r17;     // Catch: JSONException -> L35
        r19.mServiceName = r9;     // Catch: JSONException -> L35
        r19.mExtraLog = r4;     // Catch: JSONException -> L35
        r19.mMetrics = null;     // Catch: JSONException -> L35
        LiveMonitor.access$002(r19, false);     // Catch: JSONException -> L35
        LiveMonitor.access$102(r19, false);     // Catch: JSONException -> L35
        LiveMonitor.access$202(r19, true);     // Catch: JSONException -> L35
        LiveMonitor.access$302(r19, false);     // Catch: JSONException -> L35
        LiveMonitor.access$402(r19, true);     // Catch: JSONException -> L35
        r19.report();     // Catch: JSONException -> L35
        o r110 = j0.l().c(x.class);     // Catch: JSONException -> L35
        if (r110 != null) goto L24;
    L28:
        String r111 = "";
    L30:
        if (e.a(r111) == false) goto L32;
        String r6 = r111;
    L33:
        ActivityMonitor.b(r9, r11, r4, BannerType.access$000(r15), r6, null, r16);     // Catch: JSONException -> L35
        return;
    L32:
        r6 = "";
        goto L33
    L24:
        if (r110.getMap() == null) goto L28;
        if (r110.getMap().containsKey("enter_from_merge") == false) goto L28;
        r111 = (String) r110.getMap().get("enter_from_merge");     // Catch: JSONException -> L35
    L35:
        e = move-exception;
        ALogger.e("BannerFullMonitor", e);
    }
}
