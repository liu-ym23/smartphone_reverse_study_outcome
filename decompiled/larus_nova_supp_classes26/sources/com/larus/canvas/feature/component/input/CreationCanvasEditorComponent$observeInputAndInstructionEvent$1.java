package com.larus.canvas.feature.component.input;

import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.feature.ability.CanvasInputEventType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CreationCanvasEditorComponent$observeInputAndInstructionEvent$1", f = "CreationCanvasEditorComponent.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class CreationCanvasEditorComponent$observeInputAndInstructionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationCanvasEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationCanvasEditorComponent a;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CreationCanvasEditorComponent$observeInputAndInstructionEvent$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0088a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[CanvasInputEventType.values().length];
                r0[CanvasInputEventType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[CanvasInputEventType.EVENT_CLICK_SEND_BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[CanvasInputEventType.EVENT_FINISH_SPEAK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[CanvasInputEventType.EVENT_FINISH_PASTE_AND_SEND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public a(CreationCanvasEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            fy8.g r13 = (fy8.g) r11;
            CanvasInputEventType r0 = r13.a;
            int r1 = C0088a.a[r0.ordinal()];
            if (r1 == 1) goto L25;
            if (r1 != 2) goto L7;
            Object r14 = this.a.o.emit(new fy8.d(CanvasEditorEventType.EVENT_CLICK_SEND_BUTTON, r13.b, null, null, null, null, 124), r12);
            if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
            return r14;
        L28:
            return Unit.INSTANCE;
        L7:
            if (r1 != 3) goto L9;
            Object r15 = this.a.o.emit(new fy8.d(CanvasEditorEventType.EVENT_FINISH_SPEAK, r13.b, null, null, null, null, 124), r12);
            if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            return r15;
        L27:
            return Unit.INSTANCE;
        L9:
            if (r1 != 4) goto L15;
            Object r16 = this.a.o.emit(new fy8.d(CanvasEditorEventType.EVENT_FINISH_PASTE_AND_SEND, r13.b, null, null, null, null, 124), r12);
            if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
            return r16;
        L26:
            return Unit.INSTANCE;
        L15:
            throw new NoWhenBranchMatchedException();
        L25:
            return Unit.INSTANCE;
        }
    }

    public CreationCanvasEditorComponent$observeInputAndInstructionEvent$1(CreationCanvasEditorComponent r1, Continuation<? super CreationCanvasEditorComponent$observeInputAndInstructionEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationCanvasEditorComponent$observeInputAndInstructionEvent$1(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationCanvasEditorComponent r6 = this.this$0;
        int r2 = CreationCanvasEditorComponent.q;
        fy8.f r7 = r6.Y2();
        if (r7 == null) goto L18;
        a1 r8 = r7.CV();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
