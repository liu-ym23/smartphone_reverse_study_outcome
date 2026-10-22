package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ry9.a>, Object> {
    final /* synthetic */ xp9.i $config;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    public SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1(SpringMultiAttachmentSelectorComponent r1, xp9.i r2, Continuation<? super SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1> r3) {
        this.this$0 = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMultiAttachmentSelectorComponent$initTakePictureHelper$1$1$resourceConfig$1(this.this$0, this.$config, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ry9.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return SpringMultiAttachmentSelectorComponent.F2(this.this$0, this.$config);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
