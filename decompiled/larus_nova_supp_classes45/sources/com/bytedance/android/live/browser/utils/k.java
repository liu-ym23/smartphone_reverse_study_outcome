package com.bytedance.android.live.browser.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final l a = null;
    public static final WeakHashMap<Context, i> b = null;
    public static final String[] c = null;
    public static boolean d;

    static {
        a = new l();
        b = new WeakHashMap();
        c = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏"};
    }

    public static void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (d == false) goto L5;
        return;
    L5:
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = false;
        if (r0 < 33) goto L13;
        if (r6.getApplicationInfo().targetSdkVersion < 33) goto L13;
        if (ContextCompat.checkSelfPermission(r6, "android.permission.READ_MEDIA_IMAGES") != 0) goto L13;
    L14:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        return;
    L18:
        l r4 = a;
        r4.getClass();
        r4.a = new WeakReference(r6);
        ContentResolver r7 = r6.getApplicationContext().getContentResolver();     // Catch: Exception -> L24
        Uri r5 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L24
        if (r0 <= 28) goto L22;
        r1 = true;
    L22:
        r7.registerContentObserver(r5, r1, r4);     // Catch: Exception -> L24
        d = true;     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "registerScreenCaptureObserver Error" + e.getMessage());
        return;
    L13:
        if (ContextCompat.checkSelfPermission(r6, "android.permission.READ_EXTERNAL_STORAGE") == 0) goto L14;
        r3 = false;
        goto L16
    }

    public static void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (d == false) goto L12;
        d = false;
        l r0 = a;
        r0.getClass();
        r2.getApplicationContext().getContentResolver().unregisterContentObserver(r0);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "unRegisterScreenCaptureObserver Error" + e.getMessage());
        return;
    }
}
