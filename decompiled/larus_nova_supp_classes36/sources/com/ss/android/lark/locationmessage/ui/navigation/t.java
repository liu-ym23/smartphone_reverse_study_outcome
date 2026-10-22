package com.ss.android.lark.locationmessage.ui.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.biz.im.api.LocationInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.CarUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t extends kqb.a {
    public final /* synthetic */ NavigateView b;

    @Override // kqb.a
    public final void a() {
        Statistics.sendEvent("message_location_navigation_click");
        NavigateView r0 = this.b;
        final Activity r1 = r0.b;
        final LocationInfo r2 = r0.i;
        boolean r3 = true;
        if (CarUtils.a() == false) goto L24;
        int r4 = a.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "locationInfo");
        if (CarUtils.c() == false) goto L21;
        Uri.Builder r5 = UriProtector.parse("carmap://com.mi.car.map").buildUpon().path("navi").appendQueryParameter("from", r1.getPackageName()).appendQueryParameter("des.name", r2.getName());
        if (oqb.c.a(r2.getLatitude()) != 360.0d) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
    L17:
        Intent r7 = new Intent("android.intent.action.VIEW", r5.build());
        if (r7.resolveActivity(r1.getPackageManager()) == null) goto L20;
        r1.startActivity(r7);
        Log.i("CarMapRouteService", "start xiaomi car map");
        boolean r8 = true;
    L22:
        if (r8 == false) goto L24;
        return;
    L20:
        Log.i("CarMapRouteService", "start xiaomi car map failed");
        goto L21
    L12:
        if (oqb.c.a(r2.getLongitude()) != 360.0d) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L17;
        r5.appendQueryParameter("des.geo", r2.getLongitude() + ',' + r2.getLatitude());
        goto L17
    L14:
        r9 = false;
        goto L15
    L9:
        r6 = false;
    L21:
        r8 = false;
    L24:
        Context r10 = lqb.b.a.getContext();
        final e r11 = new e();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        if (MapRouteService.a(r10, MapRouteService.MapPackageName.PACKAGE_NAME_AMAP) == false) goto L28;
        d r14 = new d();
        r14.a = 0;
        r10.getString(2131890388);
        r14.b = MapRouteService.MapPackageName.PACKAGE_NAME_AMAP;
        r14.c = MapRouteService.MapRouteURI.URI_AMAP;
        r14.d = MapRouteService.MapCustomRouteURI.CUSTOM_URI_AMAP;
        r12.add(r10.getString(2131890388));
        r13.add(r14);
    L28:
        if (MapRouteService.a(r10, MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP) == false) goto L31;
        d r15 = new d();
        r15.a = 1;
        r10.getString(2131890387);
        r15.b = MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP;
        r15.c = MapRouteService.MapRouteURI.URI_BAIDUMAP;
        r15.d = MapRouteService.MapCustomRouteURI.CUSTOM_URI_BAIDUMAP;
        r12.add(r10.getString(2131890387));
        r13.add(r15);
    L31:
        if (MapRouteService.a(r10, MapRouteService.MapPackageName.PACKAGE_NAME_QQMAP) == false) goto L34;
        d r16 = new d();
        r16.a = 2;
        r10.getString(2131890392);
        r16.b = MapRouteService.MapPackageName.PACKAGE_NAME_QQMAP;
        r16.c = MapRouteService.MapRouteURI.URI_QQMAP;
        r16.d = MapRouteService.MapCustomRouteURI.CUSTOM_URI_QQMAP;
        r12.add(r10.getString(2131890392));
        r13.add(r16);
    L34:
        if (MapRouteService.a(r10, MapRouteService.MapPackageName.PACKAGE_NAME_GOOGLEMAP) == false) goto L37;
        d r17 = new d();
        r17.a = 3;
        r10.getString(2131890389);
        r17.b = MapRouteService.MapPackageName.PACKAGE_NAME_GOOGLEMAP;
        r17.c = MapRouteService.MapRouteURI.URI_GOOGLEMAP;
        r17.d = MapRouteService.MapCustomRouteURI.CUSTOM_URI_GOOGLEMAP;
        r12.add(r10.getString(2131890389));
        r13.add(r17);
    L37:
        if (MapRouteService.a(r10, MapRouteService.MapPackageName.PACKAGE_NAME_WAZE) == false) goto L39;
        d r18 = new d();
        r18.a = 4;
        r10.getString(2131890393);
        r18.b = MapRouteService.MapPackageName.PACKAGE_NAME_WAZE;
        r18.c = MapRouteService.MapRouteURI.URI_WAZEMAP;
        r18.d = MapRouteService.MapCustomRouteURI.CUSTOM_URI_WAZEMAP;
        r12.add(r10.getString(2131890393));
        r13.add(r18);
    L39:
        r11.b = r13;
        r11.a = r12;
        if ((!r13.isEmpty()) == true) goto L43;
        LKUIToast.show(r1, 2131890386);
        return;
    L43:
        if ((!r11.b.isEmpty()) == true) goto L45;
    L47:
        r3 = false;
    L48:
        if (r3 == true) goto L50;
        ArrayList r19 = new ArrayList(r11.a);
        r19.add(r1.getString(2131891541));
        com.larksuite.component.ui.dialog.i r20 = new com.larksuite.component.ui.dialog.i(r1);
        r20.n((String[]) r19.toArray(new String[r19.size()]));
        r20.m(2131563582);
        ((com.larksuite.component.ui.dialog.b) r20).f = new lqb.a(r11, r1, r2);
        r20.i();
        return;
    L50:
        if (r11.b.size() > 0) goto L52;
        d r21 = null;
    L53:
        MapRouteService.b(r1, r21, r2.getName(), r2.getLatitude(), r2.getLongitude());
        return;
    L52:
        r21 = (d) ListProtector.get(r11.b, 0);
        goto L53
    L45:
        if (r11.b.size() != 1) goto L47;
        goto L47
    }

    public t(NavigateView r1) {
        this.b = r1;
    }
}
