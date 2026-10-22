package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.Observer;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerUploadAndCheck$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$triggerUploadAndCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ic8.m0 $fileInfo;
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$triggerUploadAndCheck$1(MultiAttachmentSelectorComponent r1, String r2, String r3, ic8.m0 r4, Continuation<? super MultiAttachmentSelectorComponent$triggerUploadAndCheck$1> r5) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$localResPath = r3;
        this.$fileInfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MultiAttachmentSelectorComponent$triggerUploadAndCheck$1(this.this$0, this.$resourceKey, this.$localResPath, this.$fileInfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        MultiAttachmentSelectorComponent r5 = this.this$0;
        String r0 = this.$resourceKey;
        int r1 = MultiAttachmentSelectorComponent.Z;
        r5.e4(r0).observe(s1a.a.c(this.this$0).getViewLifecycleOwner(), (Observer) this.this$0.Y.getValue());
        this.this$0.f5(this.$resourceKey, this.$localResPath, this.$fileInfo);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
