package com.bytedance.android.ec.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i0 {
    public static final j0 a = null;
    public static final WeakHashMap<Context, b1> b = null;
    public static final WeakHashMap<Context, v83.a> c = null;
    public static final String[] d = null;
    public static boolean e;
    public static final i0 f = null;

    public static final class a implements v83.a {
        public a() {
        }
    }

    public i0() {
    }

    static {
        f = new i0();
        a = new j0();
        b = new WeakHashMap();
        c = new WeakHashMap();
        d = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "screenshots"};
    }

    public static void a(Context r10) {
        boolean r0 = ECServiceManager.a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L13;
        if (r10 != null) goto L6;
        return;
    L6:
        a r1 = new a();
        c.put(r10, r1);
        ((s83.g) ECServiceManager.c(s83.g.class)).i0(r1);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.f(e, "registerScreenCaptureObserver error");
        return;
    L13:
        if (e == true) goto L31;
        if (r10 == null) goto L32;
        j0 r11 = a;
        r11.a = r10;
        ContentResolver r12 = r10.getApplicationContext().getContentResolver();     // Catch: Exception -> L23
        Uri r13 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L23
        if (Build.VERSION.SDK_INT <= 28) goto L20;
        boolean r14 = true;
    L21:
        r12.registerContentObserver(r13, r14, r11);     // Catch: Exception -> L23
        e = true;     // Catch: Exception -> L23
        return;
    L20:
        r14 = false;
    L23:
        e = move-exception;
        ECExceptionMonitor.f(e, "screen_capture_observer_error");
        return;
    L32:
        return;
    }

    public static void b(Context r10) {
        boolean r0 = ECServiceManager.a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L13;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        WeakHashMap<Context, v83.a> r11 = c;     // Catch: Throwable -> L9
        v83.a r12 = r11.get(r10);     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        ((s83.g) ECServiceManager.c(s83.g.class)).o(r12);     // Catch: Throwable -> L9
    L7:
        r11.put(r10, null);     // Catch: Throwable -> L9
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L13:
        if (e == false) goto L25;
        e = false;
        j0 r14 = a;
        r14.a = null;
        if (r10 == null) goto L26;
        Context r15 = r10.getApplicationContext();
        if (r15 == null) goto L27;
        ContentResolver r16 = r15.getContentResolver();
        if (r16 == null) goto L28;
        r16.unregisterContentObserver(r14);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }
}
