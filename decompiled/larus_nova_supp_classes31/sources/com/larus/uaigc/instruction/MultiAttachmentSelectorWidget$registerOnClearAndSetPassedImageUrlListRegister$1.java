package com.larus.uaigc.instruction;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
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
@DebugMetadata(c = "com.larus.uaigc.instruction.MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1", f = "MultiAttachmentSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiAttachmentSelectorWidget this$0;

    public MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1(MultiAttachmentSelectorWidget r1, Continuation<? super MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MultiAttachmentSelectorWidget$registerOnClearAndSetPassedImageUrlListRegister$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        MultiAttachmentSelectorWidget r5 = this.this$0;
        int r0 = MultiAttachmentSelectorWidget.m;
        Fragment r6 = r5.getFragment();
        if (r6 == null) goto L12;
        final MultiAttachmentSelectorWidget r1 = this.this$0;
        ry9.h r2 = r1.i;
        if (r2 == null) goto L12;
        MutableLiveData r3 = r2.Bw();
        if (r3 == null) goto L12;
        r3.observe(r6, new MultiAttachmentSelectorWidget.d(new i0(r1)));
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
