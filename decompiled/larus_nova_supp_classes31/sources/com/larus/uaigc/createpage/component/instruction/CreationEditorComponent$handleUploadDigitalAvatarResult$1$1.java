package com.larus.uaigc.createpage.component.instruction;

import android.view.View;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$handleUploadDigitalAvatarResult$1$1", f = "CreationEditorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationEditorComponent$handleUploadDigitalAvatarResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $customItemBar;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$handleUploadDigitalAvatarResult$1$1(CreationEditorComponent r1, com.larus.bmhome.actionbar.model.z0 r2, Continuation<? super CreationEditorComponent$handleUploadDigitalAvatarResult$1$1> r3) {
        this.this$0 = r1;
        this.$customItemBar = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationEditorComponent$handleUploadDigitalAvatarResult$1$1(this.this$0, this.$customItemBar, r4);
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
        View r5 = this.this$0.F2();
        final com.larus.bmhome.actionbar.model.z0 r0 = this.$customItemBar;
        final CreationEditorComponent r1 = this.this$0;
        r5.postDelayed(new v1(r0, r1), 200);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
