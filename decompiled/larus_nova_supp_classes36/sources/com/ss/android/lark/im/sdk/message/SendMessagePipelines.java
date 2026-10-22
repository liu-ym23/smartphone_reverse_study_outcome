package com.ss.android.lark.im.sdk.message;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.message.send.CompressMediaStep;
import com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep;
import com.ss.android.lark.im.sdk.message.send.i;
import com.ss.android.lark.im.sdk.message.send.j;
import com.ss.android.lark.im.sdk.message.send.k;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SendMessagePipelines {
    public final com.ss.android.lark.im.sdk.message.send.b a;
    public final com.ss.android.lark.im.sdk.message.send.e b;
    public final com.ss.android.lark.im.sdk.message.send.c c;
    public final j d;
    public final com.ss.android.lark.im.sdk.message.send.h e;
    public final CompressMediaStep f;
    public final FinalSendMessageStep g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final com.ss.android.lark.im.sdk.message.send.c l;
    public final Lazy m;

    public static final class a {
    }

    public interface b {
        void I(MessageInfo r1);
    }

    public static final class c implements b {
        public final /* synthetic */ SendMessagePipelines a;

        public c(SendMessagePipelines r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            SendMessagePipelines.a(this.a, r2);
        }
    }

    public static final class d implements nkb.a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // nkb.a
        public final ChatChatter a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return ImSdkService.d().x1(r2);
        }
    }

    public static final class e implements b {
        public final /* synthetic */ SendMessagePipelines a;

        public e(SendMessagePipelines r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            SendMessagePipelines.a(this.a, r2);
        }
    }

    public static final class f implements nkb.a {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // nkb.a
        public final ChatChatter a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return ImSdkService.d().x1(r2);
        }
    }

    public static final class g implements b {
        public final /* synthetic */ SendMessagePipelines a;

        public g(SendMessagePipelines r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            SendMessagePipelines.a(this.a, r2);
        }
    }

    public static final class h implements b {
        public final /* synthetic */ SendMessagePipelines a;

        public h(SendMessagePipelines r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            SendMessagePipelines.a(this.a, r2);
        }
    }

    public String c() {
        return "ImSdkSendPipelines";
    }

    public jkb.d<k> e() {
        return null;
    }

    static {
        new SendMessagePipelines();
    }

    public SendMessagePipelines() {
        this.a = new com.ss.android.lark.im.sdk.message.send.b();
        com.ss.android.lark.im.sdk.message.c r1 = com.ss.android.lark.im.sdk.message.c.a;
        this.b = new com.ss.android.lark.im.sdk.message.send.e();
        this.c = new com.ss.android.lark.im.sdk.message.send.c(false, new c(this), d.a);
        this.d = new j(i.a);
        this.e = new com.ss.android.lark.im.sdk.message.send.h(new h(this));
        this.f = new CompressMediaStep(new g(this));
        this.g = new FinalSendMessageStep(com.ss.android.lark.im.sdk.message.send.g.a);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.h = LazyKt.lazy(r0, new SendMessagePipelines$specialSendMessagePipelineMap$2(this));
        this.i = LazyKt.lazy(r0, new SendMessagePipelines$flowMediaSendMessagePipeline$2(this));
        this.j = LazyKt.lazy(r0, new SendMessagePipelines$doubaoFileSendMessagePipeline$2(this));
        this.k = LazyKt.lazy(r0, new SendMessagePipelines$commonSendMessagePipeline$2(this));
        this.l = new com.ss.android.lark.im.sdk.message.send.c(true, new e(this), f.a);
        this.m = LazyKt.lazy(r0, new SendMessagePipelines$sendLocalPreMessagePipeline$2(this));
    }

    public FinalSendMessageStep b() {
        return this.g;
    }

    public j d() {
        return this.d;
    }

    public static final void a(SendMessagePipelines r0, MessageInfo r1) {
        r0.getClass();
        ImSdkService.e().I(r1);
    }
}
