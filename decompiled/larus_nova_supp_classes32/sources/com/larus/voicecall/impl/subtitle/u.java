package com.larus.voicecall.impl.subtitle;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u implements h {
    public final /* synthetic */ RealtimeCallSubtitleLayout a;

    public u(RealtimeCallSubtitleLayout r1) {
        this.a = r1;
    }

    @Override // com.larus.voicecall.impl.subtitle.h
    public final void a(c r12) {
        q0 r1 = this.a.b;
        if (r1 == null) goto L5;
        q0.s(r1, SubtitleListUpdateType.RETRY_IMAGE_HOLDER, null, null, null, r12, null, null, null, 238);
    L5:
        Function1<c, Unit> r0 = this.a.getSubtitleImgRetryCallback();
        if (r0 == null) goto L9;
        r0.invoke(r12);
        return;
    }
}
