package com.larus.bmhome.chat.screenshot;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static c a;
    public static f b;
    public static final CopyOnWriteArrayList<WeakReference<d>> c = null;
    public static final AtomicBoolean d = null;

    public static final class a {
        public static Activity.ScreenCaptureCallback a;
        public static final C0071a b = null;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.screenshot.i$a$a, reason: collision with other inner class name */
        public static final class C0071a implements f09.a.a {
            public C0071a() {
            }

            public final void onPaused(Activity r4) {
                Intrinsics.checkNotNullParameter(r4, "activity");
                Activity.ScreenCaptureCallback r0 = a.a;
                Activity.ScreenCaptureCallback r1 = a.a;
                if (r1 == null) goto L11;
                r4.unregisterScreenCaptureCallback(r1);     // Catch: Exception -> L6
                return;
            L6:
                e = move-exception;
                FLogger.a.e("ScreenCaptureUtils", "unregisterScreenCaptureCallback error: ", e);
                return;
            }

            public final void onPreDestroyed(Activity r2) {
                Intrinsics.checkNotNullParameter(r2, "activity");
            }

            public final void onResumed(Activity r4) {
                Intrinsics.checkNotNullParameter(r4, "activity");
                Activity.ScreenCaptureCallback r0 = a.a;
                if (a.a != null) goto L12;
                a.a = new h();
            L12:
                Activity.ScreenCaptureCallback r1 = a.a;     // Catch: Exception -> L9
                if (r1 == null) goto L14;
                r4.registerScreenCaptureCallback(r4.getMainExecutor(), r1);     // Catch: Exception -> L9
                return;
            L14:
                return;
            L9:
                e = move-exception;
                FLogger.a.e("ScreenCaptureUtils", "registerScreenCaptureCallback error: ", e);
            }

            public final void onStart(Activity r2) {
                Intrinsics.checkNotNullParameter(r2, "activity");
            }

            public final void onStopped(Activity r2) {
                Intrinsics.checkNotNullParameter(r2, "activity");
            }

            public final void onCreate(Activity r1, Bundle r2) {
                Intrinsics.checkNotNullParameter(r1, "activity");
            }
        }

        static {
            b = new C0071a();
        }
    }

    static {
        c = new CopyOnWriteArrayList();
        d = new AtomicBoolean(false);
    }

    public static void a(Context r7, d r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (r8 != null) goto L5;
        return;
    L5:
        Iterator<WeakReference<d>> r0 = c.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r0.next().get(), r8) == false) goto L7;
        return;
    L11:
        Context r9 = r7.getApplicationContext();
        AtomicBoolean r1 = d;
        if (r1.get() == true) goto L48;
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 34) goto L29;
        Activity.ScreenCaptureCallback r10 = a.a;
        f09.a r11 = AppHost.a.a();
        Intrinsics.checkNotNullParameter(r11, "activityStackManager");
        r11.e(a.b);
        Activity r12 = r11.getCurrentActivity();
        if (r12 != null) goto L19;
    L27:
        d.set(true);
        goto L48
    L19:
        if (a.a != null) goto L50;
        a.a = new g();
    L50:
        Activity.ScreenCaptureCallback r3 = a.a;     // Catch: Exception -> L25
        if (r3 == null) goto L27;
        r12.registerScreenCaptureCallback(r12.getMainExecutor(), r3);     // Catch: Exception -> L25
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        FLogger.a.e("ScreenCaptureUtils", "registerScreenCaptureCallback error: ", e);
        Unit r14 = Unit.INSTANCE;
        goto L27
    L29:
        if (a != null) goto L32;
        a = new c(MediaStore.Images.Media.INTERNAL_CONTENT_URI, new WeakReference(r9));
    L32:
        if (b != null) goto L35;
        b = new f(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new WeakReference(r9));
    L35:
        if (r2 <= 28) goto L37;
        boolean r4 = true;
    L52:
        c r5 = a;     // Catch: Exception -> L46
        if (r5 == null) goto L41;
        r9.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, r4, r5);     // Catch: Exception -> L46
    L41:
        f r6 = b;     // Catch: Exception -> L46
        if (r6 == null) goto L44;
        r9.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r4, r6);     // Catch: Exception -> L46
    L44:
        r1.set(true);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        FLogger.a.e("ScreenCaptureUtils", "registerScreenCaptureObserver error: ", e);
        goto L48
    L37:
        r4 = false;
    L48:
        c.add(new WeakReference(r8));
        FLogger.a.i("ScreenCaptureUtils", "addScreenCaptureListener...");
    }

    public static void b(Context r6, d r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r7 != null) goto L5;
        return;
    L5:
        CopyOnWriteArrayList<WeakReference<d>> r0 = c;
        Iterator<WeakReference<d>> r1 = r0.iterator();
    L6:
        boolean r3 = false;
        if (r1.hasNext() == false) goto L17;
        WeakReference<d> r2 = r1.next();
        WeakReference<d> r4 = r2;
        Intrinsics.checkNotNullParameter(r4, "it");
        if (Intrinsics.areEqual(r4.get(), r7) == false) goto L11;
    L12:
        r3 = true;
    L14:
        if (Boolean.valueOf(r3).booleanValue() == false) goto L6;
        r0.remove(r2);
        goto L6
    L11:
        if (r4.get() != null) goto L14;
    L17:
        if (c.size() != 0) goto L42;
        Context r8 = r6.getApplicationContext();
        if (d.get() == false) goto L42;
        if (Build.VERSION.SDK_INT < 34) goto L46;
        Activity.ScreenCaptureCallback r9 = a.a;
        f09.a r10 = AppHost.a.a();
        Intrinsics.checkNotNullParameter(r10, "activityStackManager");
        r10.f(a.b);
        Activity r11 = r10.getCurrentActivity();
        if (r11 == null) goto L31;
        Activity.ScreenCaptureCallback r12 = a.a;
        if (r12 == null) goto L31;
        r11.unregisterScreenCaptureCallback(r12);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        FLogger.a.e("ScreenCaptureUtils", "unregisterScreenCaptureCallback error: ", e);
    L31:
        d.set(false);
        goto L42
    L46:
        c r13 = a;     // Catch: Exception -> L39
        if (r13 == null) goto L35;
        r8.getContentResolver().unregisterContentObserver(r13);     // Catch: Exception -> L39
    L35:
        f r14 = b;     // Catch: Exception -> L39
        if (r14 == null) goto L41;
        r8.getContentResolver().unregisterContentObserver(r14);     // Catch: Exception -> L39
    L41:
        d.set(false);
    L39:
        e = move-exception;
        FLogger.a.e("ScreenCaptureUtils", "unregisterScreenCaptureObserver error: ", e);
    L42:
        FLogger.a.i("ScreenCaptureUtils", "removeScreenCaptureListener");
    }
}
