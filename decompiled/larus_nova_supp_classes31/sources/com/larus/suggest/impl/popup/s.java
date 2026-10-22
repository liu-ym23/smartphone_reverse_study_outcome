package com.larus.suggest.impl.popup;

import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.platform.api.k0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import yq9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s implements k0 {
    public s() {
    }

    @Override // com.larus.platform.api.k0
    public final void a(c r8) {
        Intrinsics.checkNotNullParameter(r8, "info");
        int r0 = r8.a;
        String r2 = "user_package";
        String r4 = null;
        if (r0 != 2) goto L5;
        FLogger.a.i("NexPulseDialogManager", "preload video success " + r8.b);
        StateFlowImpl r9 = q.b;
        b1 r1 = q.c;
        e r3 = (e) r1.getValue();
        if (r3 == null) goto L24;
        NexPulseCandidate r5 = r3.a;
    L25:
        e r6 = (e) r1.getValue();
        if (r6 == null) goto L28;
        r4 = r6.c;
    L28:
        e r7 = (e) r1.getValue();
        if (r7 == null) goto L34;
        String r10 = r7.d;
        if (r10 == null) goto L34;
        r2 = r10;
    L34:
        r9.setValue(new e(r5, true, r4, r2));
        return;
    L24:
        r5 = null;
        goto L25
    L5:
        if (r0 != 3) goto L37;
        FLogger.a.e("NexPulseDialogManager", "preload video failed, videoCoverLoaded=" + q.d);
        StateFlowImpl r11 = q.b;
        b1 r12 = q.c;
        e r13 = (e) r12.getValue();
        if (r13 == null) goto L10;
        NexPulseCandidate r14 = r13.a;
    L11:
        boolean r15 = q.d;
        e r16 = (e) r12.getValue();
        if (r16 == null) goto L14;
        r4 = r16.c;
    L14:
        e r17 = (e) r12.getValue();
        if (r17 == null) goto L20;
        String r18 = r17.d;
        if (r18 == null) goto L20;
        r2 = r18;
    L20:
        r11.setValue(new e(r14, r15, r4, r2));
        return;
    L10:
        r14 = null;
        goto L11
    }
}
