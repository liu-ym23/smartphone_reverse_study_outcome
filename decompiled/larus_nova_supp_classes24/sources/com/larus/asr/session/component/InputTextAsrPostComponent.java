package com.larus.asr.session.component;

import android.app.Application;
import android.os.SystemClock;
import com.larus.asr.VoiceInputType;
import com.larus.asr.x5;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class InputTextAsrPostComponent implements o0 {
    public final com.larus.asr.session.p a;
    public final String b;
    public final f0 c;

    @Override // com.larus.asr.session.component.o0
    public final void onClear() {
    }

    @Override // com.larus.asr.session.component.o0
    public final void onStop() {
    }

    @Override // com.larus.asr.session.component.o0
    public final void a(byte[] r3) {
        if (r3 == null) goto L5;
        this.a.Ma(this.b, r3);
        return;
    }

    @Override // com.larus.asr.session.component.o0
    public final void c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void d(a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.a.setKeepScreenOn(false);
        e2a.e.a();
        if (this.c.o != AsrEngineRoute.NORMAL) goto L5;
        x5.a().d(r3.a);
    L5:
        int r4 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.e();
    }

    @Override // com.larus.asr.session.component.o0
    public final void e(j0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.asr.session.component.o0
    public final void i(j0 r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.c.o != AsrEngineRoute.NORMAL) goto L9;
        com.larus.audio.k0 r0 = x5.a();
        String r1 = r5.a;
        Message r2 = r5.b;
        if (r2 == null) goto L7;
        String r3 = r2.getLocalMessageId();
    L8:
        r0.g(r1, r3, this.a.I9());
        goto L9
    L7:
        r3 = null;
    L9:
        String r4 = r5.a;
        String r6 = "onSubmit1:" + r5.a;
        int r7 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.a(this.a, r4, VoiceInputType.TouchSpeaker, false, r6);
    }

    @Override // com.larus.asr.session.component.o0
    public final void j(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.larus.asr.session.component.o0
    public final void h(a0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // com.larus.asr.session.component.o0
    public final void l(a0 r7, com.larus.audio.b r8) {
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r8, "result");
        f0 r9 = r7.getContext();
        if (r9 != null) goto L5;
        return;
    L5:
        String r0 = r8.b;
        this.c.d();
        String r1 = this.c.m;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r10 = "asrSuccess:" + r8.a;
        int r2 = AsrSessionComponentUtils.a;
        boolean r4 = true;
        AsrSessionComponentUtils.a(this.a, r1, VoiceInputType.TouchSpeaker, true, r10);
        this.a.J9(r0, false);
        if (r9.c() == false) goto L11;
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r4 = false;
    L14:
        if (r4 == true) goto L16;
        return;
    L16:
        if ((SystemClock.elapsedRealtime() - r9.n) <= 500) goto L21;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new InputTextAsrPostComponent$onSuccess$1(r9, null), 3, null);
        return;
    }

    public InputTextAsrPostComponent(com.larus.asr.session.p r2, String r3, f0 r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r4, "asrContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.larus.asr.session.component.o0
    public final void f(a0 r1, String r2, String r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r1, "scope");
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "path");
        if (r1.getContext() != null) goto L6;
        return;
    L6:
        if (r6 != AsrEventEnum.ASR_RECORDER_SILENCED.getCode()) goto L8;
    L9:
        t19.s r5 = t19.s.a;
        Application r7 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.b(r7, 2131899941, false);
    L10:
        this.c.d();
        String r8 = this.c.m;
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        int r9 = AsrSessionComponentUtils.a;
        AsrSessionComponentUtils.a(this.a, r8, VoiceInputType.TouchSpeaker, true, "asrFail:" + r2);
        this.a.Fa();
        return;
    L8:
        if (r6 != AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L10;
        goto L9
    }
}
