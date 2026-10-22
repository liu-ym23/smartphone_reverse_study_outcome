package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends ResendMessagePipelines {
    public final String e;
    public final com.ss.android.lark.im.sdk.message.resend.e f;

    @Override // com.ss.android.lark.im.sdk.message.ResendMessagePipelines
    public final com.ss.android.lark.im.sdk.message.resend.a a() {
        return this.f;
    }

    @Override // com.ss.android.lark.im.sdk.message.ResendMessagePipelines
    public final String b() {
        return this.e;
    }

    @Inject
    public b(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.e = "ImSdkResendPipelinesV2";
        this.f = new com.ss.android.lark.im.sdk.message.resend.e(r2);
    }
}
