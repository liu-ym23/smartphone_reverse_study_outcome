package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.KmpAsrSessionAdapter;
import com.larus.asr.VoiceInputType;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s3 implements KmpAsrSessionAdapter.a {
    public final /* synthetic */ SendMessageAsrSession a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.larus.audio.asr.c0 d;

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        SendMessageAsrSession r0 = this.a;
        r0.a(this.b, this.c, this.d, r0.c).invoke(r6);
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void c(com.larus.audio.b r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        SendMessageAsrSession r0 = this.a;
        Message r1 = this.b;
        com.larus.audio.asr.c0 r2 = this.d;
        VoiceInputType r3 = r0.c;
        Intrinsics.checkNotNullParameter(r1, "msg");
        Intrinsics.checkNotNullParameter(r2, "traceInfo");
        Intrinsics.checkNotNullParameter(r3, "voiceInputType");
        new f3(r0, r1, r2, r3).invoke(r6);
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionTaskId");
        SendMessageAsrSession r3 = this.a;
        r3.a.onAsrStart(r3.b);
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void d(String r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "data");
        SendMessageAsrSession r5 = this.a;
        r5.getClass();
        if (r4 == null) goto L13;
        r5.a.Ma(r5.b, r4);
        Function2<? super String, ? super byte[], Unit> r0 = r5.p;
        ChatBottomSpeakerComponent r6 = r5.a;
        if ((r6 instanceof ChatBottomSpeakerComponent) == false) goto L7;
        ChatBottomSpeakerComponent r7 = r6;
    L8:
        if (r7 == null) goto L11;
        String r8 = r7.G1;
        if (r8 == null) goto L11;
    L12:
        r0.invoke(r8, r4);
    L11:
        r8 = "";
        goto L12
    L7:
        r7 = null;
    L13:
        Unit r9 = Unit.INSTANCE;
    }

    public s3(SendMessageAsrSession r1, Message r2, String r3, com.larus.audio.asr.c0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // com.larus.asr.KmpAsrSessionAdapter.a
    public final void e(String r5, String r6, long r7, int r9) {
        Intrinsics.checkNotNullParameter(r5, "sessionTaskId");
        Intrinsics.checkNotNullParameter(r6, "audioFilePath");
        SendMessageAsrSession r0 = this.a;
        Message r1 = this.b;
        com.larus.audio.asr.c0 r2 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "msg");
        Intrinsics.checkNotNullParameter(r2, "traceInfo");
        new d3(r0, r1, r2).invoke(r5, r6, Long.valueOf(r7), Integer.valueOf(r9));
    }
}
