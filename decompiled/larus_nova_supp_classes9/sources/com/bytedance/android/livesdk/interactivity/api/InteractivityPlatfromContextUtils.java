package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityPlatfromContextUtils {
    static {
    }

    @JvmStatic
    public static final void a(DataCenter r4, final Function1<? super h, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r0, r4, 0, 2);
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.j r7 = r6.M1();
        if (r7 == null) goto L12;
        r7.c(new InteractivityPlatfromContextUtils$useInteractivityContext$1(r5));
        return;
    L12:
        return;
    L11:
        return;
    }
}
