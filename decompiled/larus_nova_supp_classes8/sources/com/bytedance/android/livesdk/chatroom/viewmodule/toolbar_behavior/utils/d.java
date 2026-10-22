package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.g01;
import com.bytedance.android.livesdk.config.h01;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static String b() {
        String r0 = g01.a.getValue();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "aweme://webview_popup/?url=https%3A%2F%2Faweme.snssdk.com%2Ffalcon%2Fpoi_live%2Fanchorman%2Fsite%2Fliving_home%3F_pia_%3D1&gravity=bottom&height_percent=75&width_percent=100&radius=8&popup_enter_type=bottom&disable_all_bounces=1&disable_bounces=1&web_over_scroll_mode=2&disable_outside_click_close=0&loader_name=forest&radius_use_dp=1&container_bg_color=%230000000&enable_preload=main";
    L6:
        Uri r1 = UriProtector.parse(r0);
        Set r2 = UriProtector.getQueryParameterNames(r1);
        Uri.Builder r3 = r1.buildUpon();
        Iterator r4 = Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null).s1().entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r4.next();
        if ((!StringsKt.isBlank((CharSequence) r5.getValue())) == false) goto L8;
        if (r2.contains(r5.getKey()) == true) goto L8;
        r3.appendQueryParameter((String) r5.getKey(), (String) r5.getValue());
        goto L8
    L15:
        return r3.toString();
    }

    public static Uri a() {
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        if ((r0 instanceof FragmentActivity) == false) goto L13;
        String r1 = h01.a.getValue();
        String r2 = String.valueOf((int) s1.G(s1.y()));
        Resources r3 = r0.getResources();
        if (r3 == null) goto L10;
        DisplayMetrics r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics());
        if (r4 == null) goto L10;
        int r5 = (int) (((double) (r4.heightPixels / r4.density)) * 0.73d);
    L12:
        return x6.a.a(r1).appendQueryParameter("type", "popup").appendQueryParameter("width", r2).appendQueryParameter("height", String.valueOf(r5)).appendQueryParameter("radius", "8").appendQueryParameter("margin", "0").appendQueryParameter("gravity", "bottom").appendQueryParameter("mask_click_disable", "0").build();
    L10:
        r5 = 484;
        goto L12
    L13:
        return null;
    }

    static {
    }

    public static boolean c(Room r5) {
        IHostContext r0 = jc1.k.f(IHostContext.class);
        Long r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.FALSE;
        Boolean r3 = (Boolean) r0.getHostABValue("poi_local_living_room_close_rights", "", r2, r2);
    L7:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == true) goto L17;
        RoomLifeGrouponInfo r6 = r5.lifeGrouponInfo;
        if (r6 == null) goto L11;
        r1 = r6.getPermissionStatus();
    L11:
        if (r1 != null) goto L14;
    L16:
        return false;
    L14:
        if (r1.longValue() != 1) goto L16;
    L17:
        return true;
    L5:
        r3 = null;
        goto L7
    }
}
