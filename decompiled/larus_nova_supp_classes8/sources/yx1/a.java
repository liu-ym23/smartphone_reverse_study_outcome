package yx1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.config.mc;
import com.bytedance.android.livesdk.config.vx;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static boolean b(Room r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        MiddlewareRoomContext r1 = MiddlewareRoomContext.getShared(null, r4.getRoomId());
        if (r1 != null) goto L9;
        return false;
    L9:
        if (vx.a.getValue().enable == 1) goto L11;
        return false;
    L11:
        if (r4.getRoomAuthStatus() != null) goto L13;
        return false;
    L13:
        if (r4.getRoomAuthStatus().isEnableGamePointsPlaying(((Boolean) r1.isAnchor().getValue()).booleanValue()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static void a(Context r11, Room r12, String r13, String r14, String r15) {
        if (r13 != null) goto L4;
        return;
    L4:
        if (r13.equals("") == true) goto L43;
        Uri r16 = UriProtector.parse(r13);
        Uri r1 = null;
        Uri.Builder r2 = null;
        r1 = null;
        r1 = null;
        if (r11 == null) goto L33;
        if (r12 == null) goto L33;
        if (r16 == null) goto L33;
        int r3 = t6.c(r11);
        HashMap r4 = new HashMap();
        r4.put("room_id", String.valueOf(r12.getId()));
        r4.put("anchor_id", r12.getOwnerUserIdString());
        r4.put("web_bg_color", "#00000000");
        r4.put("enter_from", r14);
        if (r15.isEmpty() == true) goto L14;
        r4.put("request_page", r15);
    L14:
        String r17 = i2.d(r16, "fallback_url", "");
        if (TextUtils.isEmpty(r17) == true) goto L17;
        Uri r18 = UriProtector.parse(r17);
        r2 = i2.e(UriProtector.parse(UriProtector.getQueryParameter(r18, "url")), "web_bg_color").buildUpon();
        Uri.Builder r19 = i2.e(r18, "url").buildUpon();
    L18:
        Uri.Builder r110 = UriProtector.parse(UriProtector.getQueryParameter(r16, "url")).buildUpon();
        Iterator r5 = r4.entrySet().iterator();
    L20:
        if (r5.hasNext() == false) goto L27;
        Map.Entry r6 = (Map.Entry) r5.next();
        if (TextUtils.isEmpty((CharSequence) r6.getValue()) == true) goto L20;
        if (r2 == null) goto L25;
        r2.appendQueryParameter((String) r6.getKey(), Uri.encode((String) r6.getValue()));
    L25:
        r110.appendQueryParameter((String) r6.getKey(), Uri.encode((String) r6.getValue()));
        goto L20
    L27:
        if (r19 == null) goto L29;
        r19.appendQueryParameter("url", r2.build().toString()).appendQueryParameter("width", UIUtils.px2dip(r11, UIUtils.getScreenWidth(r11)) + "").appendQueryParameter("height", ((int) (((float) UIUtils.px2dip(r11, (float) UIUtils.getScreenWidth(r11))) * 1.2f)) + "").appendQueryParameter("horizontal_height", UIUtils.px2dip(r11, (float) UIUtils.getScreenHeight(r11)) + "").appendQueryParameter("horizontal_width", UIUtils.px2dip(r11, (float) r3) + "");
    L29:
        Uri.Builder r111 = i2.e(i2.e(r16, "url"), "fallback_url").buildUpon().appendQueryParameter("url", r110.build().toString()).appendQueryParameter("type", "popup").appendQueryParameter("gravity", "bottom").appendQueryParameter("width", UIUtils.px2dip(r11, UIUtils.getScreenWidth(r11)) + "").appendQueryParameter("height", ((int) (((float) UIUtils.px2dip(r11, (float) UIUtils.getScreenWidth(r11))) * 1.2f)) + "").appendQueryParameter("horizontal_height", UIUtils.px2dip(r11, (float) UIUtils.getScreenHeight(r11)) + "").appendQueryParameter("horizontal_width", UIUtils.px2dip(r11, (float) r3) + "").appendQueryParameter("panel_scene", "predictor");
        if (r19 == null) goto L32;
        r111.appendQueryParameter("fallback_url", r19.build().toString());
    L32:
        r1 = r111.build();
        goto L33
    L17:
        r19 = null;
    L33:
        if (r1 != null) goto L35;
        return;
    L35:
        k.f(IBaseLiveActionHandler.class).handle(r11, r1);
        return;
    }

    public static void d(Context r0, Room r1, String r2, String r3, String r4) {
        a(r0, r1, r2, r3, r4);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.e("PredictorUtils", "PredictorUtils#showPredictorDialog : " + th.toString());
    }

    public static String c(DataCenter r0, boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        if (r0 == null) goto L7;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        return vx.a.getValue().anchorLeaveSchema;
    L7:
        if (r0 == null) goto L14;
        if (r1 == false) goto L14;
        if (r5 == false) goto L14;
        if (mc.a.getValue().booleanValue() == false) goto L14;
        return vx.a.getValue().anchorPredictorListSchema;
    L14:
        if (r0 == null) goto L18;
        if (r1 == false) goto L18;
        return vx.a.getValue().anchorSchema;
    L18:
        if (r3 == true) goto L24;
        if (r4 == true) goto L24;
        return vx.a.getValue().audienceInteractionSchema;
    L24:
        return vx.a.getValue().audienceSchema;
    }
}
