package com.obric.aikernel.service.foreground;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.obric.aikernel.service.res.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final void a(Context r10, Class<? extends Service> r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "serviceClass");
        Context r13 = r10.getApplicationContext();
        Intent r14 = new Intent(r13, r11);
        if (g.a(r12) == false) goto L5;
        r13.startForegroundService(r14);
        return;
    L5:
        r13.startService(r14);
    }

    public static /* synthetic */ void b(Context r10, Class r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = Build.VERSION.SDK_INT;
    L5:
        a(r10, r11, r12);
    }
}
