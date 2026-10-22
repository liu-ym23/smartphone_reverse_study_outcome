package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.InputTextAsrPostComponent;
import com.larus.asr.session.component.ObricAsrPreComponent;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q0 extends ComponentAsrSession {
    public static final /* synthetic */ int j = 0;

    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.asr.session.p0] */
    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.a, new n0()), new com.larus.asr.session.component.z(this.a, new o0(), null, 26), new ObricAsrPreComponent(this.f, false), new com.larus.asr.session.component.h(this.a, this.b, this.f, new com.larus.asr.session.component.e(false, false, null, new p0(), 21))}), CollectionsKt.listOf(new com.larus.asr.session.component.o0[]{new InputTextAsrPostComponent(this.a, this.b, this.f), new com.larus.asr.session.component.l0(this.a, this.f), new com.larus.asr.session.component.z0(this.a, this.f, false)}));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean g(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r2 != this.f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void h(com.larus.asr.session.component.f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a.V9(AppHost.a.getApplication().getString(2131901796));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        BotModel r0 = this.a.i();
        if (r0 == null) goto L5;
        String r1 = r0.getBotId();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        String r2 = "actionbar_instruction_" + System.currentTimeMillis();
        AsrEngineRoute r3 = r5.o;
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "route");
        r5.m = r2;
        r5.n = 0;
        r5.o = r3;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public q0(p r2, String r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "isCurrentSession");
        super(r2, r3, VoiceInputType.TouchSpeaker, r4);
    }
}
