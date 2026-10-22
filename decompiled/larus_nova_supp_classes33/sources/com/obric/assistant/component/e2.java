package com.obric.assistant.component;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ ObricIntercomComponent$c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ e2(ObricIntercomComponent r1, ObricIntercomComponent$c r2, String r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        ObricIntercomComponent$c r1 = this.b;
        String r2 = this.c;
        boolean r3 = this.d;
        if (r0.L != r1) goto L30;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "taskId");
        boolean r5 = false;
        if (r2.length() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
    L21:
        if (r5 == true) goto L23;
        FLogger.a.i("OrionIntercomComponent", "ignore stale TouchSpeak visibility: requestTaskId=" + r1.a + ", speakerTaskId=" + r2 + ", visible=" + r3);
        return;
    L23:
        r0.O.put(r2, r1.b);
        if (r3 == true) goto L26;
        r0.D3(r2);
        return;
    L26:
        r1.c = true;
        r0.B3(r1, "speaker_visible");
        return;
    L12:
        if (Intrinsics.areEqual(r1.a, r2) == true) goto L20;
        String r6 = r1.h;
        if (r6 != null) goto L17;
    L19:
        r1.h = r2;
        r1.g.add(r2);
        goto L20
    L17:
        if (Intrinsics.areEqual(r6, r2) == true) goto L19;
    L20:
        r5 = true;
        goto L21
    L8:
        r4 = false;
        goto L9
    }
}
