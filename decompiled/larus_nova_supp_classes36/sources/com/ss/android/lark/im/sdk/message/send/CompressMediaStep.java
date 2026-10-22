package com.ss.android.lark.im.sdk.message.send;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.t0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.service.impl.u;
import com.ss.android.lark.chat.service.impl.v;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.message.SendMessagePipelines;
import com.ss.android.lark.im.sdk.service.o;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m6b.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CompressMediaStep implements jkb.d<k> {
    public static final a c = null;
    public final SendMessagePipelines.b a;
    public final c b;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/im/sdk/message/send/CompressMediaStep$UploadMediaCallback;", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/chat/service/ISendMessageBegin;", "Lcom/ss/android/lark/chat/service/impl/IMediaCompressProgress;", "Lcom/ss/android/lark/chat/service/impl/IMediaSendCallback;", "Lcom/ss/android/lark/chat/service/impl/mediasend/dispatcher/MediaCompressStateListener;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public interface UploadMediaCallback extends IGetDataCallback<String>, p, u, v, p6b.b {
        /* synthetic */ void onBeginSendMessage(Message r1);

        /* synthetic */ void onCompressMediaEnd(VideoCompressResult r1);

        /* synthetic */ void onCompressMediaStart();

        /* synthetic */ void onInterrupted(String r1);

        /* synthetic */ void onUpdateMediaCompressProgress(Message r1);
    }

    public static final class a implements c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.im.sdk.message.send.CompressMediaStep.c
        public final void a(p6b.d.b r2) {
            Intrinsics.checkNotNullParameter(r2, "sendInfo");
            p6b.d.a.a.b(r2);
        }
    }

    public static final class b {
    }

    public interface c {
        void a(p6b.d.b r1);
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // jkb.d
    public final String getName() {
        return "CompressMediaStep";
    }

    static {
        c = a.a;
    }

    public CompressMediaStep(SendMessagePipelines.g r3) {
        a r0 = c;
        Intrinsics.checkNotNullParameter(r3, "preMessageCallback");
        Intrinsics.checkNotNullParameter(r0, "mediaSender");
        this.a = r3;
        this.b = r0;
    }

    @Override // jkb.d
    public final void a(jkb.b r7, final jkb.c r8) {
        k r9 = (k) r7;
        Intrinsics.checkNotNullParameter(r9, "pipelineContext");
        Intrinsics.checkNotNullParameter(r8, "pipelineControl");
        t0 r1 = r9.a;
        if ((r1 instanceof t0) == true) goto L5;
    L7:
        final MessageInfo r2 = r9.c;
        Intrinsics.checkNotNull(r2);
        MessageInfo r3 = r9.c;
        Intrinsics.checkNotNull(r3);
        Message r4 = r3.getMessage();
        final o r10 = r9.b;
        final SendMessagePipelines.b r5 = this.a;
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        Intrinsics.checkNotNullParameter(r8, "pipelineControl");
        Intrinsics.checkNotNullParameter(r5, "preMessageCallback");
        Intrinsics.checkNotNullParameter(r10, "originalCallback");
        UploadMediaCallback r0 = new CompressMediaStep$Companion$buildMediaUploadCallback$1(r10, r8, r2, r5);
        Message.Type r11 = r4.getType();
        if (r11 != null) goto L10;
        int r12 = -1;
    L12:
        if (r12 != 1) goto L14;
        p6b.d.b r13 = new p6b.d.b();
        r13.a = ImSdkProxy.e().getCurrentUserId();
        r13.b = r4;
        r13.c = 1;
        r13.d = true;
        r13.e = r0;
        r13.f = false;
        r13.g = false;
    L18:
        if (r13 != null) goto L20;
        r8.b(new jkb.e("SendInfo build failed for message type: " + r4.getType()));
        return;
    L20:
        com.ss.android.lark.im.sdk.a.b("CompressMediaStep", "Start compress media");
        this.b.a(r13);
        return;
    L14:
        if (r12 == 2) goto L16;
        r13 = null;
        goto L18
    L16:
        r13 = q6b.a.a(r4, r0, false);
        r13.g = false;
        goto L18
    L10:
        r12 = d.a[r11.ordinal()];
        goto L12
    L5:
        if (r1.L == false) goto L7;
        Log.i("CompressMediaStep", "skip CompressMediaStep");
    }
}
