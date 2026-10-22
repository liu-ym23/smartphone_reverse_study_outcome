package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep;
import com.ss.android.lark.im.sdk.message.send.SdkCreatePreMessageStep$Companion$rustClientQuasiMessageCreator$1;
import com.ss.android.lark.im.sdk.message.send.j;
import com.ss.android.lark.im.sdk.message.send.n;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends SendMessagePipelines {
    public final l n;
    public final com.ss.android.lark.im.sdk.service.e o;
    public final String p;
    public final n q;
    public final j r;
    public final FinalSendMessageStep s;

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final FinalSendMessageStep b() {
        return this.s;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final String c() {
        return this.p;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final j d() {
        return this.r;
    }

    @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines
    public final jkb.d e() {
        return this.q;
    }

    @Inject
    public f(final l r3, com.ss.android.lark.im.sdk.service.e r4) {
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        Intrinsics.checkNotNullParameter(r4, "voiceTextPostProcessService");
        this.n = r3;
        this.o = r4;
        this.p = "ImSdkSendPipelinesV2";
        this.q = new n(r4);
        int r1 = j.b;
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        this.r = new j(new SdkCreatePreMessageStep$Companion$rustClientQuasiMessageCreator$1(r3));
        int r2 = FinalSendMessageStep.b;
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        this.s = new FinalSendMessageStep(new com.ss.android.lark.im.sdk.message.send.f(r3));
    }
}
