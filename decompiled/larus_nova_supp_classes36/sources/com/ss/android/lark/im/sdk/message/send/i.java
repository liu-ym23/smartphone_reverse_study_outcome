package com.ss.android.lark.im.sdk.message.send;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.QuasiMessage;
import com.bytedance.lark.pb.im.v1.CreateQuasiMessageRequest;
import com.bytedance.lark.pb.im.v1.CreateQuasiMessageResponse;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements j.b {
    public static final i a = null;

    public static final class a<T> implements SdkSender.IParser {
        public final /* synthetic */ CreateQuasiMessageRequest.Builder a;

        public a(CreateQuasiMessageRequest.Builder r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r4) {
            CreateQuasiMessageResponse r5 = (CreateQuasiMessageResponse) CreateQuasiMessageResponse.ADAPTER.decode(r4);
            Entity r0 = r5.entity;
            QuasiMessage r6 = (QuasiMessage) r0.quasi_messages.get(r5.cid);
            com.ss.android.lark.chat.entity.chatter.a r1 = com.ss.android.lark.parser.internal.b.d(r0, true);
            Message r7 = ModelParserMessage.d(r0, r6);
            MessageInfo r2 = ModelParserMessage.k(r7, r0, r1, null);
            Log.i("SdkCreatePreMessageStep", "quasi message created: " + r7.getcId() + '/' + this.a.cid);
            return new l5b.c(r2);
        }
    }

    static {
        a = new i();
    }

    public i() {
    }

    @Override // com.ss.android.lark.im.sdk.message.send.j.b
    public final SdkSender.d<l5b.c> a(CreateQuasiMessageRequest.Builder r3, String r4, com.ss.android.lark.sdk.h r5) {
        Intrinsics.checkNotNullParameter(r3, "requestBuilder");
        Intrinsics.checkNotNullParameter(r4, "contextId");
        Intrinsics.checkNotNullParameter(r5, "requestParams");
        return SdkSender.syncSendMayError(Command.CREATE_QUASI_MESSAGE, r3, r4, new a(r3), r5);
    }
}
