package com.larus.bmhome.chat.bubble.floating.runtime;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final Handler a = null;
    public static final ConcurrentHashMap<String, Runnable> b = null;

    static {
        a = new Handler(Looper.getMainLooper());
        b = new ConcurrentHashMap();
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "promptId");
        Runnable r2 = b.remove(r1);
        if (r2 == null) goto L6;
        a.removeCallbacks(r2);
        return;
    }

    public static void b(final pc8.e r8) {
        Intrinsics.checkNotNullParameter(r8, "prompt");
        a(r8.a);
        if (r8.b.f.c > 0) goto L5;
        long r0 = -1;
    L16:
        if (r0 != (-1)) goto L19;
        return;
    L19:
        if (r0 > 0) goto L22;
        j r1 = j.a;
        String r9 = r8.a;
        BubbleBannerDismissReason r2 = BubbleBannerDismissReason.AUTO_DISMISS;
        r1.getClass();
        j.c(r9, r2);
        return;
    L22:
        Runnable r3 = new a(r8);
        b.put(r8.a, r3);
        a.postDelayed(r3, r0);
        return;
    L5:
        Long r4 = Long.valueOf(r8.e);
        if (r4.longValue() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L14;
        r0 = r4.longValue() - System.currentTimeMillis();
        goto L16
    L14:
        r0 = r8.b.f.c * 1000;
        goto L16
    L8:
        r5 = false;
        goto L9
    }
}
