package com.larus.asr.session;

import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.asr.session.component.AsrSessionComponentUtils;
import com.larus.im.bean.message.Message;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LiveTutorAsrOnlySessionV2 extends ComponentAsrSession {
    public static final /* synthetic */ int j = 0;

    public boolean l(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    public boolean m(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return true;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public boolean m0() {
        return false;
    }

    public void n(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.a, true, new w0(), new x0(this)), new com.larus.asr.session.component.z(this.a, this.c, new LiveTutorAsrOnlySessionV2$createComponents$3(this), new LiveTutorAsrOnlySessionV2$createComponents$4(this), new LiveTutorAsrOnlySessionV2$createComponents$5(this))}), CollectionsKt.listOf(new com.larus.asr.session.component.y0(this.a, this.f)));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean g(com.larus.asr.session.component.f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r3 == this.f) goto L5;
    L9:
        return false;
    L5:
        if (r3.o != AsrEngineRoute.NORMAL) goto L7;
    L8:
        return true;
    L7:
        if (super.g(r3) == false) goto L9;
        goto L8
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r4, Message r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        super.qa(r4, r5);
        int r6 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.e();
        AsrSessionComponentUtils.b(this.a, r4, VoiceInputType.TouchSpeaker, "onCancel:".concat(r4), 8);
        this.f.e(com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r2, Message r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        super.ma(r2, r3, r4);
        int r5 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.e();
    }

    public LiveTutorAsrOnlySessionV2(p r2, String r3, VoiceInputType r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        Intrinsics.checkNotNullParameter(r5, "isCurrentSession");
        super(r2, r3, r4, r5);
    }
}
