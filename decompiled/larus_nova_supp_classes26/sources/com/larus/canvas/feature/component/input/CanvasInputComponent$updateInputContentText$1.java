package com.larus.canvas.feature.component.input;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
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
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CanvasInputComponent$updateInputContentText$1", f = "CanvasInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasInputComponent$updateInputContentText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $requestFocus;
    final /* synthetic */ Integer $selectionEndIndex;
    final /* synthetic */ Integer $selectionStartIndex;
    final /* synthetic */ boolean $showIme;
    final /* synthetic */ String $text;
    int label;
    final /* synthetic */ CanvasInputComponent this$0;

    public CanvasInputComponent$updateInputContentText$1(CanvasInputComponent r1, String r2, boolean r3, boolean r4, Integer r5, Integer r6, Continuation<? super CanvasInputComponent$updateInputContentText$1> r7) {
        this.this$0 = r1;
        this.$text = r2;
        this.$requestFocus = r3;
        this.$showIme = r4;
        this.$selectionStartIndex = r5;
        this.$selectionEndIndex = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CanvasInputComponent$updateInputContentText$1(this.this$0, this.$text, this.$requestFocus, this.$showIme, this.$selectionStartIndex, this.$selectionEndIndex, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        CanvasInputComponent r11 = this.this$0;
        int r0 = CanvasInputComponent.t;
        ICoreInputAbility r1 = r11.Y2();
        if (r1 == null) goto L8;
        ICoreInputAbility.b.d(r1, this.$text, this.$requestFocus, this.$showIme, this.$selectionStartIndex, this.$selectionEndIndex, false, 32);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
