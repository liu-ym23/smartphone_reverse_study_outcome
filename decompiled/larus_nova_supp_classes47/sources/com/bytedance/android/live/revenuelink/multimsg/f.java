package com.bytedance.android.live.revenuelink.multimsg;

import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenuelink.multimsg.api.TaskState;
import com.bytedance.android.livesdk.link.model.bridge.h2;
import com.bytedance.android.livesdk.revenue.message.i;
import com.bytedance.live.kmp.statemachine.StateMachine;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends com.bytedance.android.live.revenuelink.multimsg.api.a<ByteBuffer, g> {
    public f() {
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.a
    public final void b(ByteBuffer r5) {
        ByteBuffer r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "params");
        int r0 = r6.remaining();
        byte[] r1 = new byte[r0];
        r6.get(r1);
        if (r0 != 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        int r8 = com.bytedance.android.live.revenuelink.multimsg.api.e.a;
        Exception r9 = new Exception("RtcMsgTask-->bytes is empty");
        Intrinsics.checkNotNullParameter(r9, "ex");
        com.bytedance.android.live.revenuelink.multimsg.api.e.b r2 = new com.bytedance.android.live.revenuelink.multimsg.api.e.b(r9);
        Intrinsics.checkNotNullParameter(r2, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r10 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r2, "result");
        StateMachine.c(r10.d, new TaskState.a.C0113a(r2));
        return;
    L9:
        h2 r12 = (h2) vh7.f.b(r1, h2.class);
        com.bytedance.android.livesdk.revenue.service.message.d r3 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.message.d.class);
        if (r3 == null) goto L14;
        i r4 = r3.getMessageManager();
        if (r4 == null) goto L14;
        yh6.c r13 = r4.a(r12);
    L15:
        if (r13 != null) goto L17;
        int r14 = com.bytedance.android.live.revenuelink.multimsg.api.e.a;
        Exception r15 = new Exception("RtcMsgTask decode error}");
        Intrinsics.checkNotNullParameter(r15, "ex");
        com.bytedance.android.live.revenuelink.multimsg.api.e.b r16 = new com.bytedance.android.live.revenuelink.multimsg.api.e.b(r15);
        Intrinsics.checkNotNullParameter(r16, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r17 = this.a;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "result");
        StateMachine.c(r17.d, new TaskState.a.C0113a(r16));
        return;
    L17:
        int r18 = com.bytedance.android.live.revenuelink.multimsg.api.e.a;
        com.bytedance.android.live.revenuelink.multimsg.api.e.c r19 = new com.bytedance.android.live.revenuelink.multimsg.api.e.c(new g(r12, r13));
        Intrinsics.checkNotNullParameter(r19, "result");
        TaskState<INPUT, OUTPUT, com.bytedance.android.live.revenuelink.multimsg.api.a<INPUT, OUTPUT>> r20 = this.a;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "result");
        StateMachine.c(r20.d, new TaskState.a.C0113a(r19));
        return;
    L14:
        r13 = null;
        goto L15
    L5:
        r7 = false;
        goto L7
    }
}
