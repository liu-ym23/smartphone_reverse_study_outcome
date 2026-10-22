package com.obric.aikernel.utils;

import android.app.Application;
import android.content.Context;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f5603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f5604b;

    static {
        f5603a = new m();
    }

    private m() {
    }

    public final boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (f5604b == null) goto L5;
    L15:
        Boolean r11 = f5604b;
        Intrinsics.checkNotNull(r11);
        return r11.booleanValue();
    L5:
        monitor-enter(m.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f5604b != null) goto L9;
        String r12 = Application.getProcessName();     // Catch: Throwable -> L12
        AIKLog.INSTANCE.d("ProcessUtils", "processName = " + r12);     // Catch: Throwable -> L12
        f5604b = Boolean.valueOf(Intrinsics.areEqual(Application.getProcessName(), r10.getPackageName()));     // Catch: Throwable -> L12
    L9:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(m.class);
        goto L15
    }
}
