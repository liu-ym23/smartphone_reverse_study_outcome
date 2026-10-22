package com.bytedance.android.livesdk.interactivity.personalized;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final boolean a = false;

    static {
        a = ((Boolean) t6.a.getValue()).booleanValue();
    }

    @JvmStatic
    public static final void a(InteractivityMonitor.Event r1, IRoom r2, Integer r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "event");
        if (a == true) goto L5;
        return;
    L5:
        LiveMonitor.a r5 = InteractivityMonitor.a(r1, r2, null);
        if (r3 == null) goto L8;
        int r6 = r3.intValue();
    L9:
        r5.l(r6);
        if (r4 != null) goto L12;
        r4 = BuildConfig.FLAVOR;
    L12:
        r5.m(r4);
        r5.a().report();
        return;
    L8:
        r6 = 0;
        goto L9
    }
}
