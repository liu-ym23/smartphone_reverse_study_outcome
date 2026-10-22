package com.obric.oui.common.util;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f6397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6398b = null;

    static {
        f6398b = new d();
    }

    private d() {
    }

    public static /* synthetic */ void c(d r10, String r11, String r12, Throwable r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        r10.b(r11, r12, r13);
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        c r12 = f6397a;
        if (r12 == null) goto L5;
        r12.d(r10, r11);
        return;
    L5:
        Log.d(r10, r11);
    }

    public final void b(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        c r13 = f6397a;
        if (r13 == null) goto L5;
        r13.e(r10, r11, r12);
        return;
    L5:
        Log.e(r10, r11, r12);
    }

    public final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        c r12 = f6397a;
        if (r12 == null) goto L5;
        r12.i(r10, r11);
        return;
    L5:
        Log.i(r10, r11);
    }
}
