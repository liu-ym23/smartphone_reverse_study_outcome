package com.larus.asr.session.component;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.u3;
import com.larus.im.bean.bot.BotModel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t0 implements p0 {
    public final com.larus.asr.session.p a;
    public final VoiceInputType b;
    public final Function1<f0, Unit> c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(final b0 r13, final com.larus.asr.session.i r14) {
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r14, "complete");
        wc9.e r0 = this.a.h();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.a;
    L7:
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        BotModel r3 = this.a.i();
        if (r3 == null) goto L13;
        r1 = r3.getBotId();
    L13:
        if (r1 != null) goto L16;
        r1 = "";
    L16:
        if (com.larus.platform.exp.s.d == true) goto L18;
        ((com.larus.asr.session.n) this.d.getValue()).breakAnswer(r4);
    L18:
        final AtomicBoolean r6 = new AtomicBoolean(false);
        final String r10 = r1;
        ((com.larus.asr.session.n) this.d.getValue()).prepareAudioText(r4, this.a.h(), r1, this.a.M1(), new s0(r6, r13, r14, this, r10));
        return;
    L9:
        r4 = r2;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public t0(com.larus.asr.session.p r2, VoiceInputType r3, u3 r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "voiceInputType");
        Intrinsics.checkNotNullParameter(r4, "onPrepared");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new r0(this));
    }
}
