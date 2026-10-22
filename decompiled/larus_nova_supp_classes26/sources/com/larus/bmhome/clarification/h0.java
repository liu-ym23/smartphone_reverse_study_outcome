package com.larus.bmhome.clarification;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h0 implements Runnable {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ d2 b;
    public final /* synthetic */ v1 c;

    public /* synthetic */ h0(ClarificationComponent r1, d2 r2, v1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClarificationComponent r0 = this.a;
        d2 r1 = this.b;
        v1 r2 = this.c;
        int r3 = ClarificationComponent.k0;
        va8.o r4 = r0.G3();
        Integer r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.u7();
    L6:
        va8.o r7 = r0.G3();
        if (r7 == null) goto L11;
        kotlinx.coroutines.flow.i1 r8 = r7.cv();
        if (r8 == null) goto L11;
        r5 = (Integer) r8.getValue();
    L11:
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("observe restored host input, messageId=");
        r10.append(r1.b);
        r10.append(", blockId=");
        r10.append(r1.c);
        r10.append(", actualTextLength=");
        if (r6 == null) goto L14;
        int r11 = r6.length();
    L15:
        r10.append(r11);
        r10.append(", actualStatus=");
        r10.append(r5);
        r10.append(", textRestored=");
        r10.append(Intrinsics.areEqual(r6, r2.a));
        r10.append(", statusRestored=");
        int r12 = r2.b;
        if (r5 != null) goto L19;
    L21:
        boolean r13 = false;
    L22:
        r10.append(r13);
        r9.i("ClarificationComponent", r10.toString());
        return;
    L19:
        if (r5.intValue() != r12) goto L21;
        r13 = true;
        goto L22
    L14:
        r11 = -1;
        goto L15
    L5:
        r6 = null;
        goto L6
    }
}
