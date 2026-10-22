package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.Window;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiEmbeddedUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;

    static {
        a = LazyKt.lazy(ForsetiEmbeddedUtils$isHuaweiFoldDisplay$2.INSTANCE);
        b = LazyKt.lazy(ForsetiEmbeddedUtils$huaweiPad$2.INSTANCE);
        c = LazyKt.lazy(ForsetiEmbeddedUtils$huaweiTripleFold$2.INSTANCE);
        d = LazyKt.lazy(ForsetiEmbeddedUtils$foldDisplay$2.INSTANCE);
        e = LazyKt.lazy(ForsetiEmbeddedUtils$pad$2.INSTANCE);
        f = LazyKt.lazy(ForsetiEmbeddedUtils$pico$2.INSTANCE);
        g = LazyKt.lazy(ForsetiEmbeddedUtils$candybarPhone$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public static boolean c() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public static boolean d() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public static boolean f() {
        return ((Boolean) g.getValue()).booleanValue();
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static int e(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        int r2 = 0;
        if (((Boolean) b.getValue()).booleanValue() == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L22;
        int r1 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.use_view_width_disabled") == true) goto L22;
        Activity r8 = ContextsKt.findActivity(r7);
        if (r8 == null) goto L20;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L20;
        View r10 = a(r9);
        if (r10 == null) goto L20;
        r2 = r10.getWidth();
    L20:
        Log.i("ForsetiEmbeddedUtils", "isHuaweiBigScreen, getScreenWidth: " + r2);
        return r2;
    L22:
        Rect r6 = null;
        MatchResult r3 = Regex.find$default(new Regex("mMaxBounds=Rect\\((\\d+),\\s*(\\d+)\\s*-\\s*(\\d+),\\s*(\\d+)\\)"), r7.getResources().getConfiguration().toString(), 0, 2, null);
        if (r3 == null) goto L25;
        MatchResult.Destructured r4 = r3.getDestructured();
        r6 = new Rect(CastIntegerProtector.parseInt((String) ListProtector.get(r4.getMatch().getGroupValues(), 1)), CastIntegerProtector.parseInt((String) ListProtector.get(r4.getMatch().getGroupValues(), 2)), CastIntegerProtector.parseInt((String) ListProtector.get(r4.getMatch().getGroupValues(), 3)), CastIntegerProtector.parseInt((String) ListProtector.get(r4.getMatch().getGroupValues(), 4)));
    L25:
        if (r6 == null) goto L27;
        r2 = r6.width();
    L34:
        Log.i("ForsetiEmbeddedUtils", "getScreenWidth: " + r2);
        return r2;
    L27:
        Activity r11 = ContextsKt.findActivity(r7);
        if (r11 == null) goto L34;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L34;
        View r13 = a(r12);
        if (r13 == null) goto L34;
        r2 = r13.getWidth();
        goto L34
    L5:
        if (c() == true) goto L8;
        r0 = false;
        goto L10
    }

    public static boolean g(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Log.i("ForsetiEmbeddedUtils", "isHuaweiCarDevice: activity class=".concat(r6.getClass().getName()));     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 30) goto L11;
        Display r7 = r6.getDisplay();     // Catch: Throwable -> L14
        if (r7 == null) goto L9;
        String r8 = r7.getName();     // Catch: Throwable -> L14
        if (r8 == null) goto L9;
    L10:
        Log.i("ForsetiEmbeddedUtils", "isHuaweiCarDevice: displayName=".concat(r8));     // Catch: Throwable -> L14
        boolean r9 = StringsKt.contains(r8, "superlauncher", true);     // Catch: Throwable -> L14
    L12:
        Log.i("ForsetiEmbeddedUtils", "isHuaweiCarDevice: " + r9);     // Catch: Throwable -> L14
        return r9;
    L9:
        r8 = "";
        goto L10
    L11:
        r9 = false;
    L14:
        th = move-exception;
        Log.e("ForsetiEmbeddedUtils", "isHuaweiCarDevice: ", th);
        return false;
    }
}
