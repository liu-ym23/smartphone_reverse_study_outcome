package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.locationmessage.statistics.NavigateHitPoint$Event;
import com.ss.android.lark.locationmessage.statistics.NavigateHitPoint$MapType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MapRouteService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapCustomRouteURI {
        public static final String CUSTOM_URI_AMAP = "androidamap://keywordNavi?keyword=%1$s&style=0";
        public static final String CUSTOM_URI_BAIDUMAP = "baidumap://map/direction?destination=%1$s&mode=driving";
        public static final String CUSTOM_URI_GOOGLEMAP = "https://www.google.com/maps/search/?api=1&query=%1$s";
        public static final String CUSTOM_URI_QQMAP = "qqmap://map/search?type=drive&keyword=%1$s";
        public static final String CUSTOM_URI_WAZEMAP = "https://waze.com/ul?q=%1$s&navigate=yes";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapPackageName {
        public static final String PACKAGE_NAME_AMAP = "com.autonavi.minimap";
        public static final String PACKAGE_NAME_BAIDUMAP = "com.baidu.BaiduMap";
        public static final String PACKAGE_NAME_GOOGLEMAP = "com.google.android.apps.maps";
        public static final String PACKAGE_NAME_QQMAP = "com.tencent.map";
        public static final String PACKAGE_NAME_WAZE = "com.waze";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapRouteURI {
        public static final String URI_AMAP = "amapuri://route/plan/?dlat=%1$s&dlon=%2$s&dname=%3$s&dev=0&t=0";
        public static final String URI_BAIDUMAP = "baidumap://map/direction?destination=name:%1$s|latlng:%2$s,%3$s&coord_type=gcj02&mode=driving";
        public static final String URI_GOOGLEMAP = "https://www.google.com/maps/dir/?api=1&destination=%1$s/%2$s&travelmode=drive";
        public static final String URI_QQMAP = "qqmap://map/routeplan?type=drive&to=%1$s&tocoord=%2$s,%3$s";
        public static final String URI_WAZEMAP = "https://waze.com/ul?ll=%1$s,%2$s&navigate=yes";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapType {
        public static final int AMAP = 0;
        public static final int BAIDUMAP = 1;
        public static final int GOOGLEMAP = 3;
        public static final int QQMAP = 2;
        public static final int WAZEMAP = 4;
    }

    public static boolean a(Context r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return false;
    L11:
        r2.getPackageManager().getApplicationInfo(r3, 8192);     // Catch: PackageManager.NameNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        Log.e("MapRouteService", "isInstalled called, e:" + e);
        return false;
    }

    public static void b(Context r10, d r11, String r12, String r13, String r14) {
        int r1 = r11.getType();
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 != 3) goto L8;
        String r2 = "google";
    L45:
        Statistics.sendEvent(NavigateHitPoint$Event.MESSAGE_LOCATION_NAVIGATION, new JSONObject().put("navigation_map_type", r2));     // Catch: JSONException -> L17
    L19:
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.VIEW");
        r0.setPackage(r11.b);
        r0.addCategory("android.intent.category.DEFAULT");
        if (oqb.c.a(r13) != 360.0d) goto L22;
    L34:
        String r5 = String.format(r11.d, new Object[]{r12});
    L36:
        if (TextUtils.isEmpty(r5) == false) goto L38;
        return;
    L38:
        r0.setData(UriProtector.parse(r5));
        if ((r10 instanceof Activity) == true) goto L42;
        r0.addFlags(268435456);
    L42:
        if (r0.resolveActivity(r10.getPackageManager()) == null) goto L47;
        r10.startActivity(r0);
        return;
    L47:
        return;
    L22:
        if (oqb.c.a(r14) == 360.0d) goto L34;
        r5 = String.format(r11.c, new Object[]{r13, r14, r12});
        int r6 = r11.a;
        if (r6 != 1) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == true) goto L33;
        if (r6 != 2) goto L31;
        boolean r8 = true;
    L32:
        if (r8 == false) goto L36;
    L31:
        r8 = false;
    L33:
        r5 = String.format(r11.c, new Object[]{r12, r13, r14});
        goto L36
    L27:
        r7 = false;
    L17:
        e = move-exception;
        Log.d("sendNavigationClick failed to e:" + e);
        goto L19
    L8:
        if (r1 == 4) goto L10;
        r2 = "none";
        goto L45
    L10:
        r2 = NavigateHitPoint$MapType.WAZE;
        goto L45
    L12:
        r2 = "tencent";
        goto L45
    L13:
        r2 = "baidu";
        goto L45
    L14:
        r2 = "gaode";
        goto L45
    }
}
