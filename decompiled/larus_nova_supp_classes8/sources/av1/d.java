package av1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.enterprocess.IRoomBizInterceptor;
import com.bytedance.android.livesdk.log.n;
import com.bytedance.android.livesdk.roomobserver.PluginPreloadObserver;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import is2.g;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements IRoomBizInterceptor {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public final List<g> getExtraLifecycleObserverV2(RoomBaseSession r4) {
        Intrinsics.checkNotNullParameter(r4, "roomBaseSession");
        return CollectionsKt.listOf(new g[]{new com.bytedance.android.livesdk.roomobserver.c(r4), new com.bytedance.android.livesdk.roomobserver.a(r4), new com.bytedance.android.livesdk.roomobserver.b(), new PluginPreloadObserver(r4)});
    }

    public final void processOnCreate(Bundle r3, DataCenter r4) {
        if (r3 == null) goto L4;
        String r5 = r3.getString("ad_live_params", "");
    L6:
        if (r2.a(r5) == false) goto L10;
        if (r4 == null) goto L11;
        r4.put("data_enter_ad_live_params", r5);
        return;
    L11:
        return;
    L10:
        return;
    L4:
        r5 = null;
        goto L6
    }

    public final void processShowInteractionFragment(Bundle r10, DataCenter r11, Room r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r2 = r10.getBoolean("enter_from_effect_ad", false);
        if (r11 == null) goto L8;
        r11.put("enter_from_effect_ad", Boolean.valueOf(r2));
    L8:
        if (r10.getBoolean("enter_from_hybrid_ad", false) == true) goto L10;
        Logger.d("RoomBizInterceptor", "configHybridAdExtra, isHybridRoom = false");
    L29:
        Serializable r1 = r10.getSerializable("live_effect_ad_log_extra_map");
        if ((r1 instanceof HashMap) == true) goto L32;
    L35:
        if (r12 == null) goto L44;
        double r0 = r10.getDouble("live_effect_ad_ecpm", 0.0d);
        nn2.a r13 = nn2.a.d;
        nn2.a r14 = nn2.a.a.a();
        String r3 = r12.getIdStr();
        Intrinsics.checkNotNullParameter(r3, "roomId");
        if (r14.b.containsKey(r3) == true) goto L39;
        r14.b.put(r3, Double.valueOf(r0));
    L39:
        r12.adRawString = r10.getString("data_live_effect_ad_log_extra_string", "");
        r12.setHybridAdExtra(r10.getString("data_live_hybrid_ad_inner_log_extra_string", ""));
        return;
    L44:
        return;
    L32:
        if ((!((Map) r1).isEmpty()) == false) goto L35;
        if (r11 == null) goto L35;
        r11.put("live_effect_ad_log_extra_map", r1);
        goto L35
    L10:
        String r4 = r10.getString("data_live_hybrid_ad_log_extra_string", "");
        Serializable r5 = r10.getSerializable("live_hybrid_ad_log_extra_map");
        if (TextUtils.isEmpty(r4) == true) goto L24;
        JSONObject r6 = new JSONObject(r4);     // Catch: Exception -> L21
        HashMap r7 = new HashMap();     // Catch: Exception -> L21
        Iterator<String> r8 = r6.keys();     // Catch: Exception -> L21
    L14:
        if (r8.hasNext() == false) goto L16;
        String r9 = r8.next();     // Catch: Exception -> L21
        r7.put(r9, JSONObjectProtectorUtils.getString(r6, r9));     // Catch: Exception -> L21
        goto L14
    L16:
        if (r11 == null) goto L18;
        r11.put("enter_from_hybrid_ad", Boolean.TRUE);     // Catch: Exception -> L21
    L18:
        if (r11 == null) goto L29;
        r11.put("live_hybrid_ad_log_extra_map", r7);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("RoomBizInterceptor", "configHybridAdExtra error " + Log.getStackTraceString(e));
        goto L29
    L24:
        if ((r5 instanceof HashMap) == false) goto L29;
        if (r11 == null) goto L27;
        r11.put("enter_from_hybrid_ad", Boolean.TRUE);
    L27:
        if (r11 == null) goto L29;
        r11.put("live_hybrid_ad_log_extra_map", r5);
        goto L29
    }

    public final void processFetchRoomState(DataCenter r6, HashMap<String, String> r7, com.bytedance.android.livesdk.commerce.a r8, Boolean[] r9) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "enterRoomParams");
        Intrinsics.checkNotNullParameter(r8, "eventParams");
        Intrinsics.checkNotNullParameter(r9, "isSpecialAdRef");
        String r1 = (String) r6.get("data_enter_ad_live_params", "");     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r1) == false) goto L6;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L12
    L7:
        Iterator<String> r3 = r2.keys();     // Catch: JSONException -> L12
    L8:
        if (r3.hasNext() == false) goto L14;
        String r4 = r3.next();     // Catch: JSONException -> L12
        r7.put(r4, r2.optString(r4));     // Catch: JSONException -> L12
    L14:
        r9[0] = Boolean.valueOf(((Boolean) r6.get("live_special_ad", Boolean.FALSE)).booleanValue());
        String r10 = r7.get("enter_request");     // Catch: JSONException -> L19
        if (r2.a(r10) == false) goto L21;
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L19
        r11.put("is_need_block_coupon", "true");     // Catch: JSONException -> L19
        r7.put("enter_request", r11.toString());     // Catch: JSONException -> L19
    L21:
        Map<? extends String, ? extends String> r12 = n.b();
        if (r12 == null) goto L30;
        r8.a.putAll(r12);
        return;
    L30:
        return;
    L19:
        e = move-exception;
        ALogger.e("CouponDialogWidget", "In fetchRoomState() ", e);
        goto L21
    L6:
        r2 = new JSONObject(r1);     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        ALogger.e("[build_room_state]", e);
        goto L14
    }
}
