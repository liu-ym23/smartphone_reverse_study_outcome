package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PreResendMessageRequest;
import com.bytedance.lark.pb.im.v1.PreResendMessageResponse;
import com.bytedance.lark.pb.im.v1.ResendMessageRequest;
import com.bytedance.lark.pb.im.v1.ResendMessageResponse;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.capacity_insufficient.CapacityCallback;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends com.ss.android.lark.im.sdk.message.resend.a {
    public final l b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            s r3 = (s) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return t.e(r3, FinalResendMessageStepV2$callSdkResendMessage$disposable$1$1.INSTANCE);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.message.resend.a, jkb.d
    public final String getName() {
        return "FinalResendMessageStepV2";
    }

    public e(l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.b = r2;
    }

    @Override // com.ss.android.lark.im.sdk.message.resend.a
    public final void d(Message.b r11, IGetDataCallback<String> r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Log.i("FinalResendMessageStepV2", "callSdkResendMessage");
        ResendMessageRequest.Builder r2 = new ResendMessageRequest.Builder().cid(r11.a).file_handle(r11.b);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r2, ResendMessageResponse.ADAPTER, Command.RESEND_MESSAGE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.b.h(r13).a().map(b.a), new CapacityCallback(r12));
    }

    @Override // com.ss.android.lark.im.sdk.message.resend.a
    public final void e(UploadResourceRequest.Builder r12, FinalResendMessageStep$uploadResources$1 r13) {
        Intrinsics.checkNotNullParameter(r12, "requestBuilder");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Log.i("FinalResendMessageStepV2", "callSdkUploadResource");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r12, UploadResourceResponse.ADAPTER, Command.UPLOAD_RESOURCE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.b.h(r0).a(), new CapacityCallback(r13));
    }

    @Override // com.ss.android.lark.im.sdk.message.resend.a
    public final void c(Message.b r10, List r11, FinalResendMessageStep$process$1 r12) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "uploadIds");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Log.i("FinalResendMessageStepV2", "callSdkPreResendMessage");
        PreResendMessageRequest.Builder r1 = new PreResendMessageRequest.Builder().upload_ids(r11);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r1, PreResendMessageResponse.ADAPTER, Command.PRE_RESEND_MESSAGE, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.b.h(r13).a().map(f.a), new CapacityCallback(r12));
    }
}
