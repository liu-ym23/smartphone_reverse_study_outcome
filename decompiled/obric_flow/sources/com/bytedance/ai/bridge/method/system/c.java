package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.utils.e;
import java.net.URISyntaxException;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2011c;
    public static AlertDialog d;
    public static final ArrayList e = null;

    static {
        e = new ArrayList();
    }

    public static void a(Activity r10, Location r11, NavigateMode r12, Location r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "dest");
        Intrinsics.checkNotNullParameter(r12, "mode");
        if (f2009a == true) goto L51;
        b(r10, "com.autonavi.minimap");
        return;
    L51:
    L20:
        e = move-exception;
        String r14 = "[callUpAMapApp] with error msg:" + e.getMessage();
        Intrinsics.checkNotNullParameter("MapUtils", "tag");
        d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L54;
        r15.e("MapUtils", r14);
        return;
    L54:
        return;
    L22:
        e = move-exception;
        String r16 = "[callUpAMapApp] with error msg:" + e.getMessage();
        Intrinsics.checkNotNullParameter("MapUtils", "tag");
        d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L56;
        r17.e("MapUtils", r16);
        return;
    L56:
        return;
    L5:
        if (r11.getLat() != null) goto L7;
        return;
    L7:
        if (r11.getLng() == null) goto L53;
        e2.a r5 = e.a(r11.getLat().doubleValue(), r11.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        Intent r18 = new Intent();     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        r18.setAction("android.intent.action.VIEW");     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        r18.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        Uri.Builder r19 = new Uri.Builder().scheme("androidamap").authority("route").path("plan").appendQueryParameter("sourceApplication", "flow").appendQueryParameter("dev", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        Intrinsics.checkNotNullParameter(r12, "<this>");     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        int r20 = r12.ordinal();     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        if (r20 == 0) goto L24;
        int r21 = 1;
        if (r20 == 1) goto L25;
        r21 = 2;
        if (r20 == 2) goto L25;
        r21 = 3;
        if (r20 == 3) goto L25;
        throw new NoWhenBranchMatchedException();     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
    L25:
        Uri.Builder r22 = r19.appendQueryParameter("t", String.valueOf(r21)).appendQueryParameter("dlat", String.valueOf(r5.f16741a)).appendQueryParameter("dlon", String.valueOf(r5.f16742b));     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        if (com.bytedance.ai.utils.c.l(r11.getName()) == false) goto L28;
        r22.appendQueryParameter("dname", r11.getName());     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
    L28:
        if (r13 == null) goto L38;
        if (com.bytedance.ai.utils.c.l(r13.getName()) == false) goto L33;
        r22.appendQueryParameter("sname", r13.getName());     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
    L33:
        if (r13.getLat() == null) goto L38;
        if (r13.getLng() == null) goto L38;
        e2.a r110 = e.a(r13.getLat().doubleValue(), r13.getLng().doubleValue());     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        r22.appendQueryParameter("slat", String.valueOf(r110.f16741a));     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        r22.appendQueryParameter("slon", String.valueOf(r110.f16742b));     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
    L38:
        if (r12 != NavigateMode.e) goto L40;
        r22.appendQueryParameter("rideType", "bike");     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
    L40:
        r18.setData(r22.build());     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        r10.startActivity(r18);     // Catch: ActivityNotFoundException -> L20 URISyntaxException -> L22
        return;
    L24:
        r21 = 0;
        goto L25
    }

    public static void b(Activity r5, String r10) {
        Intent r11 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(r10)));
        if (r11.resolveActivity(r5.getPackageManager()) == null) goto L6;
        r5.startActivity(r11);
        return;
    L6:
        String r12 = "can not find market app to install ".concat(r10);
        Intrinsics.checkNotNullParameter("MapUtils", "tag");
        d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L10;
        r13.e("MapUtils", r12);
        return;
    }

    public static boolean c(Activity r5, String r10) {
        if (r10.length() != 0) goto L11;
        return false;
    L11:
        if (r5.getPackageManager().getPackageInfo(r10, 0) == null) goto L9;
        return true;
    L9:
        return false;
    }
}
