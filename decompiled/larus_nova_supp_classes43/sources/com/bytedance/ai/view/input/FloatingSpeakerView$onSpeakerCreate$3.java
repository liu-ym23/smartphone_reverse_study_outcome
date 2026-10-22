package com.bytedance.ai.view.input;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.view.input.FloatingSpeakerView$onSpeakerCreate$3", f = "FloatingSpeakerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FloatingSpeakerView$onSpeakerCreate$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FloatingSpeakerView this$0;

    /* JADX INFO: renamed from: com.bytedance.ai.view.input.FloatingSpeakerView$onSpeakerCreate$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.view.input.FloatingSpeakerView$onSpeakerCreate$3$1", f = "FloatingSpeakerView.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FloatingSpeakerView this$0;

        /* JADX INFO: renamed from: com.bytedance.ai.view.input.FloatingSpeakerView$onSpeakerCreate$3$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ FloatingSpeakerView a;

            /* JADX INFO: renamed from: com.bytedance.ai.view.input.FloatingSpeakerView$onSpeakerCreate$3$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0053a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[FloatingChatStatus.values().length];
                    r0[FloatingChatStatus.ON_SPEAK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
                L4:
                    a = r0;
                }
            }

            public a(FloatingSpeakerView r1) {
                this.a = r1;
            }

            public final Object emit(Object r10, Continuation r11) {
                if (C0053a.a[((FloatingChatStatus) r10).ordinal()] != 1) goto L10;
                ConstraintLayout r12 = this.a.b;
                if (r12 == null) goto L7;
                r12.setVisibility(0);
            L7:
                ConstraintLayout r13 = this.a.c;
                if (r13 == null) goto L17;
                r13.setVisibility(0);
            L17:
                return Unit.INSTANCE;
            L10:
                ConstraintLayout r14 = this.a.b;
                if (r14 == null) goto L13;
                r14.setVisibility(0);
            L13:
                ConstraintLayout r15 = this.a.c;
                if (r15 == null) goto L17;
                r15.setVisibility(8);
                goto L17
            }
        }

        public AnonymousClass1(FloatingSpeakerView r1, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            FloatingSpeakerView r11 = this.this$0;
            StateFlowImpl r12 = r11.g;
            a r13 = new a(r11);
            this.label = 1;
            if (r12.collect(r13, this) != r0) goto L12;
            return r0;
        }
    }

    public FloatingSpeakerView$onSpeakerCreate$3(FloatingSpeakerView r1, Continuation<? super FloatingSpeakerView$onSpeakerCreate$3> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        FloatingSpeakerView$onSpeakerCreate$3 r0 = new FloatingSpeakerView$onSpeakerCreate$3(this.this$0, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
