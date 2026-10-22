package com.larus.asr.session;

import android.os.Handler;
import android.os.Looper;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrMessageResultPostComponent;
import com.larus.asr.session.component.ObricAsrPreComponent;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.larus.im.bean.message.Message;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SendMessageAsrSessionV2 extends ComponentAsrSession {
    public static final /* synthetic */ int q = 0;
    public d58.a j;
    public volatile Long k;
    public volatile Long l;
    public boolean m;
    public volatile boolean n;
    public final Handler o;
    public final x3 p;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void clear() {
        this.n = true;
        this.k = null;
        this.o.removeCallbacks(this.p);
        super.clear();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.asr.session.u3] */
    @Override // com.larus.asr.session.ComponentAsrSession
    public final com.larus.asr.session.component.d0 b() {
        return new com.larus.asr.session.component.d0(CollectionsKt.listOf(new com.larus.asr.session.component.p0[]{new com.larus.asr.session.component.h0(this.a, new t3()), new com.larus.asr.session.component.t0(this.a, VoiceInputType.TouchSpeaker, new u3(this)), new com.larus.asr.session.component.z(this.a, null, new v3(this), 14), new ObricAsrPreComponent(this.f, true), new com.larus.asr.session.component.u0(this.a, this.b, this.f, new com.larus.asr.session.component.e(true, false, null, null, 62))}), CollectionsKt.listOf(new com.larus.asr.session.component.o0[]{new com.larus.asr.session.component.y0(this.a, this.f, true, new SendMessageAsrSessionV2$createComponents$4(this)), new com.larus.asr.session.component.l0(this.a, this.f), new AsrMessageResultPostComponent(this.a, this.b, this.f, this.c, new w3(this)), new com.larus.asr.session.component.z0(this.a, this.f, true)}));
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final boolean f(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.m == true) goto L5;
    L10:
        return true;
    L5:
        if (this.n == false) goto L7;
    L9:
        return false;
    L7:
        if (e(r2) == false) goto L9;
        goto L9
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void i(com.larus.asr.session.component.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.j = r2.b().h;
        this.k = r2.b().f;
        this.m = true;
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void qa(String r3, Message r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.n = true;
        this.o.removeCallbacks(this.p);
        super.qa(r3, r4);
    }

    @Override // com.larus.asr.session.ComponentAsrSession, com.larus.asr.session.o
    public final void ma(String r3, Message r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        this.l = Long.valueOf(System.currentTimeMillis());
        this.n = true;
        this.o.removeCallbacks(this.p);
        super.ma(r3, r4, r5);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [com.larus.asr.session.x3] */
    public SendMessageAsrSessionV2(final p r2, final String r3, final VoiceInputType r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionContext");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "voiceInputType");
        Intrinsics.checkNotNullParameter(r5, "isCurrentSession");
        super(r2, r3, r4, r5);
        this.j = d58.a.d;
        this.m = true;
        this.o = new Handler(Looper.getMainLooper());
        this.p = new x3(this, r2, r3, r4);
    }

    @Override // com.larus.asr.session.ComponentAsrSession
    public final void j(com.larus.asr.session.component.f0 r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "path");
        this.n = true;
        this.o.removeCallbacks(this.p);
        r2.f(true);
        r2.d();
        if (r5 != AsrEventEnum.ASR_RECORDER_SILENCED.getCode()) goto L5;
    L6:
        r2.f.set(false);
        r2.e.compareAndSet(false, true);
        return;
    L5:
        if (r5 == AsrEventEnum.ASR_REQUEST_MEDIA_FAILED.getCode()) goto L6;
    }
}
