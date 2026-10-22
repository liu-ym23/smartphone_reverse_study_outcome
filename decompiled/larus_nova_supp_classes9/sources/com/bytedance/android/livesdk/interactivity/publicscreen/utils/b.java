package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.e4;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean a = false;

    static {
        a = ((Boolean) e4.a.getValue()).booleanValue();
    }

    public static /* synthetic */ void b(InteractivityMonitor.Event r1, IRoom r2) {
        a(r1, r2, 0);
    }

    @JvmStatic
    public static final void a(InteractivityMonitor.Event r1, IRoom r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if (a == true) goto L5;
        return;
    L5:
        LiveMonitor.a r4 = InteractivityMonitor.a(r1, r2, null);
        if (r3 == null) goto L8;
        int r5 = r3.intValue();
    L9:
        r4.l(r5);
        r4.a().report();
        return;
    L8:
        r5 = 0;
        goto L9
    }
}
