package com.larus.chat.gallery.impl.providers;

import com.larus.bmhome.bigimg.m1;
import com.larus.gallery.api.t;
import com.larus.home.impl.sdk.k1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.providers.ChatTopBarProvider$downloadImage$1$checkBlock$1", f = "ChatTopBarProvider.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
final class ChatTopBarProvider$downloadImage$1$checkBlock$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ d this$0;

    public ChatTopBarProvider$downloadImage$1$checkBlock$1(String r1, d r2, Message r3, Continuation<? super ChatTopBarProvider$downloadImage$1$checkBlock$1> r4) {
        this.$creationId = r1;
        this.this$0 = r2;
        this.$message = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new ChatTopBarProvider$downloadImage$1$checkBlock$1(this.$creationId, this.this$0, this.$message, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L20;
        r7.w();
        k1 r8 = k1.a;
        String r2 = this.$creationId;
        ty8.b r3 = (ty8.b) ((t) this.this$0).d;
        if (r3 == null) goto L15;
        m1 r4 = r3.b;
        if (r4 == null) goto L15;
        String r5 = r4.f;
    L16:
        String r9 = this.$message.getMessageId();
        this.label = 1;
        if (r8.h1(r2, r5, r9, this) != r0) goto L20;
        return r0;
    L15:
        r5 = null;
        goto L16
    }
}
