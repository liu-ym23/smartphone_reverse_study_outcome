package com.larus.chat.gallery.impl.preview.input;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.input.PreviewInputCallback$onCameraEntranceClick$1", f = "PreviewInputCallback.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewInputCallback$onCameraEntranceClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ xy8.d $data;
    int label;
    final /* synthetic */ PreviewInputCallback this$0;

    public PreviewInputCallback$onCameraEntranceClick$1(PreviewInputCallback r1, FragmentActivity r2, xy8.d r3, Continuation<? super PreviewInputCallback$onCameraEntranceClick$1> r4) {
        this.this$0 = r1;
        this.$activity = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PreviewInputCallback$onCameraEntranceClick$1(this.this$0, this.$activity, this.$data, r5);
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
        if (((Boolean) r6).booleanValue() == true) goto L15;
        this.this$0.a.c(true);
        this.this$0.e.k();
        this.this$0.h.invoke();
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PreviewInputCallback r7 = this.this$0;
        PreviewCameraParamProvider r2 = r7.e;
        FragmentActivity r3 = this.$activity;
        com.larus.chat.gallery.api.q r8 = r7.f;
        xy8.d r4 = this.$data;
        this.label = 1;
        r6 = r2.t(r3, r8, r4, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
