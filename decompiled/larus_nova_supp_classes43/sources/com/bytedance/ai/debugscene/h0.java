package com.bytedance.ai.debugscene;

import com.bytedance.ai.event.MessageIndication;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class h0 implements com.bytedance.ai.debug.i {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ f0.b b;
    public final /* synthetic */ com.bytedance.ai.debug.i c;

    public /* synthetic */ h0(AtomicBoolean r1, f0.b r10, com.bytedance.ai.debug.i r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // com.bytedance.ai.debug.i
    public final void a(int r10, String r11, String r12) {
        AtomicBoolean r0 = this.a;
        f0.b r1 = this.b;
        com.bytedance.ai.debug.i r13 = this.c;
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        if (r0.compareAndSet(false, true) == true) goto L6;
        com.bytedance.ai.utils.g.a.w("AIDebugPanelCoordinator", "ignore duplicated panel reply, code:" + r10);
        return;
    L6:
        if (r1.b.get() == true) goto L8;
        com.bytedance.ai.utils.g.a.w("AIDebugPanelCoordinator", "drop panel reply because session is unavailable, code:" + r10);
        return;
    L8:
        r1.b(r13, r10, r11, r12);
    }
}
