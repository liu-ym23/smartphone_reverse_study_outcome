package com.larus.uaigc.music.applet;

import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.applet.MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1", f = "MusicAppletInstructionEditorComponent.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
final class MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i1<Boolean> $hiddenFlow;
    int label;
    final /* synthetic */ MusicAppletInstructionEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MusicAppletInstructionEditorComponent a;

        public a(MusicAppletInstructionEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            boolean r4 = ((Boolean) r2).booleanValue();
            int r0 = MusicAppletInstructionEditorComponent.w;
            this.a.m3(!r4);
            return Unit.INSTANCE;
        }
    }

    public MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1(kotlinx.coroutines.flow.i1<Boolean> r1, MusicAppletInstructionEditorComponent r2, Continuation<? super MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1> r3) {
        this.$hiddenFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicAppletInstructionEditorComponent$observeInstructionPanelVisibility$1(this.$hiddenFlow, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1<Boolean> r6 = this.$hiddenFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
