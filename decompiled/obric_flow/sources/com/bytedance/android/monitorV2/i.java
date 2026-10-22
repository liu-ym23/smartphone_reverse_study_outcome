package com.bytedance.android.monitorV2;

import android.os.Handler;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f3604a = null;

    static {
        f3604a = Collections.synchronizedMap(new LinkedHashMap());
    }

    public static void a(String r5, String r10, LinkedHashMap r11, LinkedHashMap r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 8) == 0) goto L8;
        r12 = null;
    L8:
        Intrinsics.checkNotNullParameter(r10, "event");
        Handler r14 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new InternalWatcher$notice$1(r5, r10, r11, r12));
    }

    public static void b(Map r5, Map r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        Handler r12 = com.bytedance.android.monitorV2.executor.b.f3573a;
        com.bytedance.android.monitorV2.executor.b.b(new InternalWatcher$notice$1(null, r11, r5, r10));
    }
}
