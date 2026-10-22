package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityContextKt {
    public static final void a(RoomContext r1, final Function1<? super InteractivityContext, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        com.bytedance.live.datacontext.j r3 = r1.getInteractivityContext();
        if (r3 == null) goto L6;
        r3.c(new InteractivityContextKt$useInteractivityContextImpl$1(r2));
        return;
    }
}
