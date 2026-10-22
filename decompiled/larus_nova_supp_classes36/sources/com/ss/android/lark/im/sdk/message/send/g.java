package com.ss.android.lark.im.sdk.message.send;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.SendMessageRequest;
import com.bytedance.lark.pb.im.v1.SendMessageResponse;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements FinalSendMessageStep.b {
    public static final g a = null;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return (SendMessageResponse) SendMessageResponse.ADAPTER.decode(r2);
        }
    }

    static {
        a = new g();
    }

    public g() {
    }

    @Override // com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep.b
    public final void a(SendMessageRequest.Builder r9, String r10, com.ss.android.lark.sdk.h r11, CapacityCallback<SendMessageResponse> r12) {
        Intrinsics.checkNotNullParameter(r9, "requestBuilder");
        Intrinsics.checkNotNullParameter(r10, "contextId");
        Intrinsics.checkNotNullParameter(r11, "requestParams");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Log.i("FinalSendMessageStep", "callSdkSendMessage");
        SdkSender.asynSendRequestNonWrap(Command.SEND_MESSAGE, r9, r10, r12, a.a, r11);
    }
}
