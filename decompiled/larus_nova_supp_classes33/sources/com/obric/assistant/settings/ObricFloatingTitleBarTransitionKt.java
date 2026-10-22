package com.obric.assistant.settings;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.view.IFloatingTransitionSession;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.utils.logger.FLogger;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.floating.FloatingTransitionBridge;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFloatingTitleBarTransitionKt {
    public static final WeakHashMap<Activity, Unit> a = null;

    static {
        a = new WeakHashMap();
    }

    public static final void b(FragmentManager r1) {
        Iterator r2 = r1.getFragments().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Fragment r0 = (Fragment) r2.next();
        Intrinsics.checkNotNull(r0);
        c(r0);
        b(r0.getChildFragmentManager());
        goto L4
    }

    public static final void c(Fragment r1) {
        if ((r1 instanceof t) == false) goto L5;
        t r2 = (t) r1;
    L6:
        if (r2 == null) goto L11;
        OFloatingTitleBar r3 = r2.gW();
        if (r3 == null) goto L12;
        r3.setFloatingTransitionEnabled(true);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void d(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (t9a.b.a().b() == true) goto L5;
        return;
    L5:
        WeakHashMap<Activity, Unit> r0 = a;
        if (r0.containsKey(r3) == false) goto L8;
        return;
    L8:
        r0.put(r3, Unit.INSTANCE);
        r3.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new ObricFloatingTitleBarTransitionKt$installObricFloatingTitleBarTransition$1(), true);
        b(r3.getSupportFragmentManager());
    }

    public static final void a(boolean r1, Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        if (r1 == true) goto L10;
        return;
    L10:
        Map r3 = FloatingTransitionBridge.H;     // Catch: Exception -> L7
        FloatingTransitionBridge.b.b();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ExceptionsKt.addSuppressed(r2, e);
    }

    public static final Boolean e(Activity r6, Intent r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        IBinder r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        boolean r2 = false;
        if (t9a.b.a().b() == false) goto L103;
        if ((r7.getFlags() & 268435456) != 0) goto L103;
        ComponentName r8 = r7.getComponent();
        if (r8 == null) goto L14;
        String r9 = r8.getPackageName();
    L16:
        if (Intrinsics.areEqual(r9, r6.getPackageName()) == false) goto L103;
        if ((r6 instanceof FragmentActivity) == false) goto L21;
        FragmentActivity r10 = (FragmentActivity) r6;
    L22:
        if (r10 == null) goto L103;
        FragmentManager r11 = r10.getSupportFragmentManager();
        if (r11 == null) goto L103;
        t r12 = r11.findFragmentById(2131373275);
        if (r12 == null) goto L103;
        if ((r12 instanceof t) == false) goto L30;
        t r13 = r12;
    L31:
        if (r13 == null) goto L103;
        OFloatingTitleBar r14 = r13.gW();
        if (r14 == null) goto L103;
        if (r14.isAttachedToWindow() == false) goto L103;
        Map r1 = FloatingTransitionBridge.H;
        Intrinsics.checkNotNullParameter(r6, "activity");
        if (com.obric.oui.titlebar.floating.o.c() == true) goto L41;
    L61:
        if (r2 == true) goto L64;
    L101:
        r2 = true;
        goto L103
    L64:
        if (com.obric.oui.titlebar.floating.o.c() == false) goto L101;
        Field r15 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L70
        r15.setAccessible(true);     // Catch: Throwable -> L70
        Object r16 = r15.get(r6);     // Catch: Throwable -> L70
        if ((r16 instanceof IBinder) == false) goto L72;
        IBinder r17 = (IBinder) r16;     // Catch: Throwable -> L70
    L73:
        Window r18 = r6.getWindow();
        if (r18 == null) goto L93;
        View r3 = r18.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L81;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L81;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L81:
        if (r17 != null) goto L86;
        WindowManager.LayoutParams r19 = r18.getAttributes();
        if (r19 == null) goto L87;
        r0 = r19.token;
    L87:
        if (r0 != null) goto L92;
        IBinder r20 = r3.getApplicationWindowToken();
        if (r20 != null) goto L91;
        r20 = r3.getWindowToken();
    L91:
        r17 = r20;
        goto L93
    L92:
        r17 = r0;
        goto L93
    L86:
        r0 = r17;
    L93:
        IFloatingTransitionSession r21 = FloatingTransitionBridge.b.c();
        if (r17 == null) goto L101;
        if (r21 == null) goto L101;
        r21.notifyFloatingTransitionLaunch(r17);     // Catch: Throwable -> L99
        Intrinsics.stringPlus("floating notify launch token=", r17);     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        Intrinsics.stringPlus("floating notify launch failed: ", th.getMessage());
    L72:
        r17 = null;
    L70:
        th = move-exception;
        Intrinsics.stringPlus("floating get activity token failed: ", th.getMessage());
        goto L72
    L41:
        if (r14.M == false) goto L61;
        if (r14.K == true) goto L47;
        r14.K = true;
    L47:
        if (r14.L != null) goto L49;
        r14.L = new FloatingTransitionBridge(r14);
    L49:
        FloatingTransitionBridge r5 = r14.L;
        if (r5 == null) goto L54;
        r5.x = null;
    L54:
        if (r14.isAttachedToWindow() == false) goto L61;
        FloatingTransitionBridge r22 = r14.L;
        if (r22 == null) goto L60;
        r22.x(true);
    L60:
        r2 = true;
        goto L61
    L30:
        r13 = null;
        goto L31
    L21:
        r10 = null;
        goto L22
    L14:
        r9 = null;
    L103:
        return Boolean.valueOf(r2);
    }
}
