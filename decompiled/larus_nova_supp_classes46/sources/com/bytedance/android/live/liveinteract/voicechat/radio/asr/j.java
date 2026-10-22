package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements k.b {
    public final /* synthetic */ MultiLinkAsrManager a;
    public final /* synthetic */ IJsBridgeManager b;
    public final /* synthetic */ Ref.ObjectRef c;

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void a(e r4) {
        Intrinsics.checkNotNullParameter(r4, "err");
        MultiLinkAsrManager r0 = this.a;
        AsrStateChangeEvent.Type r1 = AsrStateChangeEvent.Type.Failed;
        String r5 = r4.a();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        MultiLinkAsrManager.a(r0, r1, r5, this.b);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        MultiLinkAsrManager.a(this.a, AsrStateChangeEvent.Type.GetResulted, r4, this.b);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        MultiLinkAsrManager.a(this.a, AsrStateChangeEvent.Type.GetPartialResulted, r4, this.b);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void onStart(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        MultiLinkAsrManager.a(this.a, AsrStateChangeEvent.Type.Started, r4, this.b);
        this.c.element = r4;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.k.b
    public final void onStop(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        MultiLinkAsrManager.a(this.a, AsrStateChangeEvent.Type.Finished, r4, this.b);
    }

    public j(MultiLinkAsrManager r1, IJsBridgeManager r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
