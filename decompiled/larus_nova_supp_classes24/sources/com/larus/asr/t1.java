package com.larus.asr;

import android.os.CountDownTimer;
import com.larus.utils.logger.FLogger;
import kotlin.ranges.RangesKt;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t1 extends CountDownTimer {
    public long a;
    public final /* synthetic */ ChatBottomSpeakerComponent b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        ChatBottomSpeakerComponent.E3(this.b, 0);
        this.b.q4("maxDurationToastTimer");
        final ChatBottomSpeakerComponent r0 = this.b;
        final s.a r1 = r0.x2;
        com.larus.utils.t0.a.postDelayed(new s1(r0, r1), 300);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r11) {
        if (r11 > 10000) goto L8;
        long r0 = RangesKt.coerceIn(((r11 + 1000) - 1) / 1000, 1, 10);
        if (r0 == this.a) goto L9;
        this.a = r0;
        ChatBottomSpeakerComponent.E3(this.b, r0);
        FLogger.a.i("ChatBottomSpeakerComponent", "[HF] auto-send warning updated, leftSeconds=" + r0 + " leftMs=" + r11);
        return;
    L9:
        return;
    }

    public t1(long r3, ChatBottomSpeakerComponent r5) {
        this.b = r5;
        super(r3, 1000);
        this.a = Long.MIN_VALUE;
    }
}
