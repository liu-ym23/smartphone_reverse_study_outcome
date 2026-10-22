package com.larus.utils;

import android.app.Activity;
import android.transition.AutoTransition;
import androidx.core.app.ActivityCompat;
import kotlin.jvm.internal.Intrinsics;
import l2a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public d() {
    }

    public static void a(Activity r1, l2a.c r2, l2a.d r3, com.larus.video.impl.douyin.j r4, final f r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r2 = new AutoTransition();
    L6:
        if ((r6 & 4) == 0) goto L9;
        r3 = new AutoTransition();
    L9:
        if ((r6 & 8) == 0) goto L12;
        r4 = new a();
    L12:
        if ((r6 & 16) == 0) goto L14;
        r5 = new b();
    L14:
        Intrinsics.checkNotNullParameter(r2, "enterTransition");
        Intrinsics.checkNotNullParameter(r3, "exitTransition");
        Intrinsics.checkNotNullParameter(r4, "onExitTransitionStart");
        Intrinsics.checkNotNullParameter(r5, "onEnterSharedElementEnd");
        if (r1 == null) goto L19;
        r3.addListener(new c(r4));
        r1.getWindow().setSharedElementEnterTransition(r2);
        r1.getWindow().setSharedElementReturnTransition(r3);
        ActivityCompat.setEnterSharedElementCallback(r1, new ActivityTransition$configTransition$4(r5));
        return;
    }
}
