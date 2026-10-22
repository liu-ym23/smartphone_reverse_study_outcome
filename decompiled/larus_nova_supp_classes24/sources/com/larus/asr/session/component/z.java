package com.larus.asr.session.component;

import com.larus.asr.VoiceInputType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class z implements p0 {
    public final com.larus.asr.session.p a;
    public final VoiceInputType b;
    public final Function1<f0, Boolean> c;
    public final Function1<f0, Boolean> d;
    public final Function1<f0, Unit> e;

    @Override // com.larus.asr.session.component.p0
    public final void b(final b0 r10, final com.larus.asr.session.i r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "complete");
        final f0 r5 = r10.getContext();
        final String r7 = r5.m;
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r11.invoke(c0.a.a);
        return;
    L12:
        final AtomicBoolean r2 = new AtomicBoolean(false);
        this.a.Bb(new y(r2, r10, r11, r5, this, r7));
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public /* synthetic */ z(com.larus.asr.session.p r9, Function1 r10, Function1 r11, int r12) {
        Function1 r1 = null;
        if ((r12 & 2) == 0) goto L5;
        VoiceInputType r4 = VoiceInputType.TouchSpeaker;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r10 = new v();
    L9:
        Function1 r5 = r10;
        if ((r12 & 8) == 0) goto L12;
        r1 = new w();
    L12:
        Function1 r6 = r1;
        if ((r12 & 16) == 0) goto L15;
        r11 = new x();
    L15:
        this(r9, r4, r5, r6, r11);
        return;
    L5:
        r4 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(com.larus.asr.session.p r2, VoiceInputType r3, Function1<? super f0, Boolean> r4, Function1<? super f0, Boolean> r5, Function1<? super f0, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "voiceInputType");
        Intrinsics.checkNotNullParameter(r4, "needVibrateProvider");
        Intrinsics.checkNotNullParameter(r5, "beforeShowSpeaker");
        Intrinsics.checkNotNullParameter(r6, "onPermissionGranted");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
