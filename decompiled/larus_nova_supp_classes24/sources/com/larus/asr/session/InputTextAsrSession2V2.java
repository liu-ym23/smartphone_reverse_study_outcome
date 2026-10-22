package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.ObricAsrPreComponent;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class InputTextAsrSession2V2 extends ComponentAsrSession {
    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.a, true, new InputTextAsrSession2V2$createComponents$1(this.a), new m0(this)), new com.larus.asr.session.component.z(this.a, null, null, 30), new ObricAsrPreComponent(this.f, true), new com.larus.asr.session.component.u0(this.a, this.b, this.f, new com.larus.asr.session.component.e(false, true, new InputTextAsrSession2V2$createComponents$3(this.a), null, 43))}), CollectionsKt.listOf(new com.larus.asr.session.component.o0[]{new com.larus.asr.session.component.y0(this.a, this.f), new com.larus.asr.session.component.l0(this.a, this.f), new com.larus.asr.session.component.m0(this.a, this.b, this.f), new com.larus.asr.session.component.z0(this.a, this.f, true)}));
    }

    public InputTextAsrSession2V2(p r2, String r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "isCurrentSession");
        super(r2, r3, VoiceInputType.TouchSpeaker, r4);
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void j(com.larus.asr.session.component.f0 r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "path");
        if (r5 != AsrEventEnum.ASR_RECORDER_SILENCED.getCode()) goto L5;
    L6:
        r2.f.set(false);
        r2.e.compareAndSet(false, true);
        return;
    L5:
        if (r5 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L6;
    }
}
