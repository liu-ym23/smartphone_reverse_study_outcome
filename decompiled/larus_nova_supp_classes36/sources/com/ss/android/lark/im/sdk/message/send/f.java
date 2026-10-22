package com.ss.android.lark.im.sdk.message.send;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.SendMessageRequest;
import com.bytedance.lark.pb.im.v1.SendMessageResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements FinalSendMessageStep.b {
    public final /* synthetic */ com.bytedance.lark.rustclient.api.l a;

    public f(com.bytedance.lark.rustclient.api.l r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep.b
    public final void a(SendMessageRequest.Builder r12, String r13, com.ss.android.lark.sdk.h r14, CapacityCallback<SendMessageResponse> r15) {
        Intrinsics.checkNotNullParameter(r12, "requestBuilder");
        Intrinsics.checkNotNullParameter(r13, "contextId");
        Intrinsics.checkNotNullParameter(r14, "requestParams");
        Intrinsics.checkNotNullParameter(r15, "callback");
        Log.i("FinalSendMessageStepV2", "callSdkSendMessage");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r12, SendMessageResponse.ADAPTER, Command.SEND_MESSAGE, r13, r14, null, null, 192);
        com.ss.android.lark.im.sdk.utils.e.b(this.a.h(r0).a(), r15);
    }
}
