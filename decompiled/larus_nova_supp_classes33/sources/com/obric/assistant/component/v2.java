package com.obric.assistant.component;

import com.larus.audio.audiov3.task.asr.AsrLifeState;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class v2 implements Runnable {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ ObricIntercomComponent$c b;
    public final /* synthetic */ AsrLifeState c;

    public /* synthetic */ v2(ObricIntercomComponent r1, ObricIntercomComponent$c r2, AsrLifeState r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricIntercomComponent r0 = this.a;
        ObricIntercomComponent$c r1 = this.b;
        AsrLifeState r2 = this.c;
        if (r0.L != r1) goto L27;
        int r3 = ObricIntercomComponent$c0$a.a[r2.ordinal()];
        if (r3 != 1) goto L8;
        r1.d = true;
        r0.B3(r1, "asr_start");
        return;
    L8:
        if (r3 != 2) goto L10;
    L16:
        AsrLifeState r4 = AsrLifeState.ASR_ERROR;
        if (r2 != r4) goto L19;
        String r5 = "dropped";
    L20:
        if (r2 != r4) goto L22;
        String r6 = "asr_failed_before_pcm";
    L23:
        r0.E3(r5, r6, r0.p0);
        r0.D3(r1.a);
        return;
    L22:
        r6 = "asr_cancelled_before_pcm";
        goto L23
    L19:
        r5 = "cancelled";
        goto L20
    L10:
        if (r3 == 3) goto L16;
        if (r3 != 4) goto L15;
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    }
}
