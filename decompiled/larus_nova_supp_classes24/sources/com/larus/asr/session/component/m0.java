package com.larus.asr.session.component;

import android.app.Application;
import com.larus.asr.VoiceInputType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m0 extends AsrMessageResultPostComponent {
    public final com.larus.asr.session.p o;

    @Override // com.larus.asr.session.component.AsrMessageResultPostComponent
    public final boolean s() {
        return false;
    }

    @Override // com.larus.asr.session.component.AsrMessageResultPostComponent
    public final void t(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.larus.asr.session.component.AsrMessageResultPostComponent
    public final void o(a0 r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
        this.o.J9(r3.b, true);
    }

    @Override // com.larus.asr.session.component.AsrMessageResultPostComponent
    public final void v(boolean r1, boolean r2) {
        t19.s r3 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r3.getClass();
        t19.s.s(r4, 2131899943);
    }

    public m0(com.larus.asr.session.p r8, String r9, f0 r10) {
        Intrinsics.checkNotNullParameter(r8, "sessionContext");
        Intrinsics.checkNotNullParameter(r9, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r10, "asrContext");
        super(r8, r9, r10, VoiceInputType.TouchSpeaker, u.a);
        this.o = r8;
    }

    @Override // com.larus.asr.session.component.AsrMessageResultPostComponent
    public final void p(Message r7, String r8, long r9, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "path");
        q(r7, r8, r9, r12);
    }
}
