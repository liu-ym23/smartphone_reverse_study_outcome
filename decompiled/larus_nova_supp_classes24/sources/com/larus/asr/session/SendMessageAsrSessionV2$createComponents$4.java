package com.larus.asr.session;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class SendMessageAsrSessionV2$createComponents$4 extends FunctionReferenceImpl implements Function1<Long, Long> {
    public SendMessageAsrSessionV2$createComponents$4(Object r8) {
        super(1, r8, SendMessageAsrSessionV2.class, "getEffectiveDurationForShortCheck", "getEffectiveDurationForShortCheck(J)J", 0);
    }

    public final Long invoke(long r10) {
        SendMessageAsrSessionV2 r0 = (SendMessageAsrSessionV2) ((CallableReference) this).receiver;
        int r1 = SendMessageAsrSessionV2.q;
        r0.getClass();
        ObricAsrDelegate r2 = ObricAsrDelegate.b;
        if (r2.m() == false) goto L29;
        if (r2.a() == false) goto L29;
        Long r3 = r0.k;
        if (r3 == null) goto L29;
        boolean r5 = true;
        if (r3.longValue() <= 0) goto L12;
        boolean r4 = true;
    L13:
        Long r6 = null;
        if (r4 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L29;
        Long r7 = Long.valueOf(System.currentTimeMillis() - r3.longValue());
        long r8 = r7.longValue();
        if (1 <= r8) goto L21;
    L23:
        r5 = false;
    L24:
        if (r5 == false) goto L26;
        r6 = r7;
    L26:
        if (r6 == null) goto L29;
        r10 = Math.max(r10, r6.longValue());
        goto L29
    L21:
        if (r8 >= 5001) goto L23;
    L12:
        r4 = false;
    L29:
        return Long.valueOf(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3) {
        return invoke(((Number) r3).longValue());
    }
}
