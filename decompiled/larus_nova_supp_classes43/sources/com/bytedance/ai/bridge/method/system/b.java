package com.bytedance.ai.bridge.method.system;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.api.navi.AppletNaviRideType;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final String b = null;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static AlertDialog f;
    public static final List<Pair<UserAction, Function0<Unit>>> g = null;

    public b() {
    }

    static {
        a = new b();
        b = b.class.getSimpleName();
        g = new ArrayList();
    }

    public static boolean b(Context r10, String r11) {
        boolean r1 = true;
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        return false;
    L15:
        if (r10.getPackageManager().getPackageInfo(r11, 0) != null) goto L13;
        r1 = false;
    L13:
        return r1;
    L17:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static void c(Context r10, String r11) {
        Intent r1 = new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=".concat(r11)));
        if (r1.resolveActivity(r10.getPackageManager()) == null) goto L5;
        r10.startActivity(r1);
        return;
    L5:
        g.a.e(b, "can not find market app to install ".concat(r11));
    }

    public static void a(Context r10, Location r11, NavigateMode r12, Location r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "dest");
        Intrinsics.checkNotNullParameter(r12, "mode");
        if (c == true) goto L33;
        c(r10, "com.autonavi.minimap");
        return;
    L33:
    L27:
        e = move-exception;
        g.a.e(b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L29:
        e = move-exception;
        g.a.e(b, "[callUpAMapApp] with error msg:" + e.getMessage());
        return;
    L5:
        if (r11.getLat() != null) goto L7;
        return;
    L7:
        if (r11.getLng() == null) goto L35;
        int r1 = f4.d.a;     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        f4.a r14 = f4.d.a(r11.getLat().doubleValue(), r11.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        Intent r15 = new Intent();     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r15.setAction("android.intent.action.VIEW");     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r15.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        Uri.Builder r16 = new Uri.Builder().scheme("androidamap").authority("route").path("plan").appendQueryParameter("sourceApplication", "flow").appendQueryParameter("dev", "1").appendQueryParameter("t", String.valueOf(r4.g.a(r12))).appendQueryParameter("dlat", String.valueOf(r14.a)).appendQueryParameter("dlon", String.valueOf(r14.b));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        if (f.g(r11.getName()) == false) goto L12;
        r16.appendQueryParameter("dname", r11.getName());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L12:
        if (r13 == null) goto L22;
        if (f.g(r13.getName()) == false) goto L17;
        r16.appendQueryParameter("sname", r13.getName());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L17:
        if (r13.getLat() == null) goto L22;
        if (r13.getLng() == null) goto L22;
        f4.a r17 = f4.d.a(r13.getLat().doubleValue(), r13.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r16.appendQueryParameter("slat", String.valueOf(r17.a));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r16.appendQueryParameter("slon", String.valueOf(r17.b));     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L22:
        if (r12 != NavigateMode.RIDING) goto L24;
        r16.appendQueryParameter("rideType", AppletNaviRideType.BIKE);     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L24:
        r15.setData(r16.build());     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
        r10.startActivity(r15);     // Catch: ActivityNotFoundException -> L27 URISyntaxException -> L29
    L38:
        return;
    }
}
