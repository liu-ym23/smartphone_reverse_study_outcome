package com.obric.assistant.chat.internal;

import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.upload.IObricUploadService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.internal.SingleImageWithTextHandler$onSuccess$1", f = "SingleImageWithTextHandler.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class SingleImageWithTextHandler$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    int label;
    final /* synthetic */ SingleImageWithTextHandler this$0;

    public SingleImageWithTextHandler$onSuccess$1(SingleImageWithTextHandler r1, UplinkFileEntity r2, Continuation<? super SingleImageWithTextHandler$onSuccess$1> r3) {
        this.this$0 = r1;
        this.$entity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SingleImageWithTextHandler$onSuccess$1(this.this$0, this.$entity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == false) goto L14;
        final SingleImageWithTextHandler r5 = this.this$0;
        final UplinkFileEntity r2 = this.$entity;
        r5.update(r2, new i(r5, r2));
    L15:
        IObricUploadService.a.getClass();
        IObricUploadService r6 = IObricUploadService.a.a();
        if (r6 == null) goto L19;
        r6.c(this.this$0.a);
    L19:
        return Unit.INSTANCE;
    L14:
        this.$entity.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        SingleImageWithTextHandler r7 = this.this$0;
        UplinkFileEntity r3 = this.$entity;
        int r8 = SingleImageWithTextHandler.k;
        r7.update(r3, null);
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        SingleImageWithTextHandler r9 = this.this$0;
        UplinkFileEntity r10 = this.$entity;
        this.label = 1;
        r4 = r9.g(r10, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
