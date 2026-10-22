package com.bytedance.android.livesdk.interactivity.api.monitorV2;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.d;
import com.bytedance.live.datacontext.j;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static j<d> a;

    public static j a() {
        j<d> r0 = a;
        if (r0 != null) goto L11;
        IRoomContextService r1 = k.f(IRoomContextService.class);
        if (r1 == null) goto L10;
        o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L10;
        return r2.D2();
    L10:
        return null;
    L11:
        return r0;
    }

    static {
    }

    @JvmStatic
    public static final void g(final MonitorEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "newEvent");
        j r0 = a();
        if (r0 == null) goto L6;
        r0.c(new InteractivityMonitorHelper$registEvent$1(r2));
        Unit r3 = Unit.INSTANCE;
        return;
    }

    @JvmStatic
    public static final void d(EventName r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "params");
        j r0 = a();
        if (r0 == null) goto L8;
        d r3 = (d) r0.getValue();
        if (r3 == null) goto L9;
        r3.g(r1, r2);
        Unit r4 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void b(EventName r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "nodeName");
        Intrinsics.checkNotNullParameter(r3, "value");
        j r0 = a();
        if (r0 == null) goto L8;
        d r4 = (d) r0.getValue();
        if (r4 == null) goto L9;
        r4.a(r1, r2, r3);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void c(EventName r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "fieldName");
        Intrinsics.checkNotNullParameter(r3, "fieldValue");
        j r0 = a();
        if (r0 == null) goto L8;
        d r4 = (d) r0.getValue();
        if (r4 == null) goto L9;
        r4.e(r1, r2, r3);
        Unit r5 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void e(EventName r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "indiName");
        j r0 = a();
        if (r0 == null) goto L8;
        d r4 = (d) r0.getValue();
        if (r4 == null) goto L9;
        r4.h(r1, r2, r3);
        Unit r5 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void f(EventName r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r2, "nodeName");
        j r0 = a();
        if (r0 == null) goto L8;
        d r4 = (d) r0.getValue();
        if (r4 == null) goto L9;
        r4.c(r1, r2, r3);
        Unit r5 = Unit.INSTANCE;
        return;
    L9:
        return;
    }
}
