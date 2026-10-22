package com.gyf.barlibrary;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5125b;
    private final boolean c;
    private final int d;
    private final int e;
    private final boolean f;
    private final float g;
    private final boolean h;

    a(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getConfiguration().orientation != 1) goto L5;
        boolean r0 = true;
    L6:
        this.f = r0;
        this.g = b(r6);
        this.f5124a = a(r6, "status_bar_height");
        this.f5125b = a(r6);
        int r2 = b(r6);
        this.d = r2;
        this.e = c(r6);
        if (r2 <= 0) goto L9;
        r1 = true;
    L9:
        this.c = r1;
        this.h = g.a(r6);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int a(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 14) goto L5;
        TypedValue r6 = new TypedValue();
        r4.getTheme().resolveAttribute(R.attr.actionBarSize, r6, true);
        return TypedValue.complexToDimensionPixelSize(r6.data, ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics());
    L5:
        return 0;
    }

    private int a(Context r5, String r6) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        int r7 = ZeusTransformUtils.getIdentifier(Resources.getSystem(), r6, "dimen", "android", "com.obric.memorydata.plugin");     // Catch: Resources.NotFoundException -> L11
        if (r7 <= 0) goto L10;
        int r1 = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(r7);     // Catch: Resources.NotFoundException -> L11
        int r8 = Resources.getSystem().getDimensionPixelSize(r7);     // Catch: Resources.NotFoundException -> L11
        if (r8 < r1) goto L8;
        return r8;
    L8:
        return Math.round((r1 * Resources.getSystem().getDisplayMetrics().density) / ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    L10:
        return 0;
    }

    private boolean a(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 17) goto L5;
    L7:
        Display r5 = r3.getWindowManager().getDefaultDisplay();
        DisplayMetrics r6 = new DisplayMetrics();
        if (Build.VERSION.SDK_INT < 17) goto L10;
        r5.getRealMetrics(r6);
    L10:
        int r0 = r6.heightPixels;
        int r7 = r6.widthPixels;
        DisplayMetrics r2 = new DisplayMetrics();
        r5.getMetrics(r2);
        int r8 = r2.heightPixels;
        if ((r7 - r2.widthPixels) <= 0) goto L13;
    L14:
        return true;
    L13:
        if ((r0 - r8) > 0) goto L14;
        return false;
    L5:
        if (Settings.Global.getInt(r3.getContentResolver(), "force_fsg_nav_bar", 0) == 0) goto L7;
        return false;
    }

    private float b(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        DisplayMetrics r4 = new DisplayMetrics();
        int r0 = Build.VERSION.SDK_INT;
        Display r5 = r2.getWindowManager().getDefaultDisplay();
        if (r0 < 16) goto L5;
        r5.getRealMetrics(r4);
    L7:
        return Math.min(r4.widthPixels / r4.density, r4.heightPixels / r4.density);
    L5:
        r5.getMetrics(r4);
        goto L7
    }

    private int b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 14) goto L5;
        return 0;
    L5:
        if (a((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return 0;
    L7:
        if (this.f == false) goto L9;
        String r0 = "navigation_bar_height";
    L11:
        return a(r5, r0);
    L9:
        r0 = "navigation_bar_height_landscape";
        goto L11
    }

    private int c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 14) goto L5;
        return 0;
    L5:
        if (a((Activity) ZeusTransformUtils.preCheckCast(r5, Activity.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return 0;
    L7:
        return a(r5, "navigation_bar_width");
    }

    boolean a() {
        if (this.g < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.f == true) goto L8;
        return false;
    }

    int b() {
        return this.f5124a;
    }

    int c() {
        return this.f5125b;
    }

    boolean d() {
        return this.c;
    }

    int e() {
        return this.d;
    }

    int f() {
        return this.e;
    }

    boolean g() {
        return this.h;
    }
}
