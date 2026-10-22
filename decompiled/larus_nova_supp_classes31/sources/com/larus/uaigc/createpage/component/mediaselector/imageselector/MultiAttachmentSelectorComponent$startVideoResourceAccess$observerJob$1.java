package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {1329}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceItemBean $bean;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $task;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1(MultiAttachmentSelectorComponent r1, com.larus.bmhome.resource.access.b0 r2, ResourceItemBean r3, String r4, Continuation<? super MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1> r5) {
        this.this$0 = r1;
        this.$task = r2;
        this.$bean = r3;
        this.$resourceKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1(this.this$0, this.$task, this.$bean, this.$resourceKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MultiAttachmentSelectorComponent r7 = this.this$0;
        com.larus.bmhome.resource.access.b0 r2 = this.$task;
        ResourceItemBean r3 = this.$bean;
        String r4 = this.$resourceKey;
        this.label = 1;
        if (MultiAttachmentSelectorComponent.h3(r7, r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
