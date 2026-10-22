package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

import android.util.Log;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import r52.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j {
    public static final boolean a = false;
    public static final int b = 0;
    public static final j c = null;

    public j() {
    }

    static {
        c = new j();
        a = v.a();
        b = s1.f(100.0f);
    }

    public final void b() {
        if (a == false) goto L11;
        Integer r0 = (Integer) q3.a.getValue();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != 10) goto L12;
        Log.getStackTraceString(new TraceException());
        return;
    L12:
        return;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        boolean r0 = TextMessageTracer.a;
        TextMessageTracer.A(r2);
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void c(d r3, Room r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "heightInfo");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "source");
        a("on height change error!! , too low !!!, height is " + r3.a);
        InteractivityMonitor.c(InteractivityMonitor.Event.PublicScreenHeightError, r4, 2, r5, 16);
    }
}
