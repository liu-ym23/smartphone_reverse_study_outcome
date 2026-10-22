package com.larus.uaigc.chat.markdown.image.component;

import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent$saveImage$3", f = "ImageOperatorComponent.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class ImageOperatorComponent$saveImage$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreationFromIM $creationFromIM;
    final /* synthetic */ String $creationTaskId;
    final /* synthetic */ String $messageId;
    int label;

    public ImageOperatorComponent$saveImage$3(UserCreationFromIM r1, String r2, String r3, Continuation<? super ImageOperatorComponent$saveImage$3> r4) {
        this.$creationFromIM = r1;
        this.$creationTaskId = r2;
        this.$messageId = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new ImageOperatorComponent$saveImage$3(this.$creationFromIM, this.$creationTaskId, this.$messageId, r5);
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
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L18;
        r7.w();
        k1 r8 = k1.a;
        UserCreationFromIM r2 = this.$creationFromIM;
        if (r2 == null) goto L13;
        String r3 = r2.getCreationId();
    L14:
        String r4 = this.$creationTaskId;
        String r5 = this.$messageId;
        this.label = 1;
        if (r8.h1(r3, r4, r5, this) != r0) goto L18;
        return r0;
    L13:
        r3 = null;
        goto L14
    }
}
