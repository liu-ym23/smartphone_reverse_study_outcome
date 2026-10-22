package com.obric.aikernel.service.foreground;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final void a(Service r10, int r11, Notification r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "notification");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r10.startForeground(r11, r12, 1);
        return;
    L5:
        r10.startForeground(r11, r12);
    }
}
