package com.ss.android.lark.im.sdk.message;

import com.ss.android.lark.im.sdk.message.resend.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ResendMessagePipelines {
    public final g a;
    public final com.ss.android.lark.im.sdk.message.resend.a b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    public String b() {
        return "ImSdkResendPipelines";
    }

    static {
        new ResendMessagePipelines();
    }

    public ResendMessagePipelines() {
        this.a = new g();
        this.b = new com.ss.android.lark.im.sdk.message.resend.a();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.c = LazyKt.lazy(r0, new ResendMessagePipelines$specialResendMessagePipelineMap$2(this));
        this.d = LazyKt.lazy(r0, new ResendMessagePipelines$commonResendMessagePipeline$2(this));
    }

    public com.ss.android.lark.im.sdk.message.resend.a a() {
        return this.b;
    }
}
