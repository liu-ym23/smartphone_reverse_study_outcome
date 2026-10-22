package com.obric.audio.enroll.ui.fragment;

import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.recorder.RecordState;
import com.obric.audio.enroll.vm.EnrollViewModel;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$1", f = "EnrollingFragment.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$observe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0031a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RecordState.values().length];
                r0[RecordState.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[RecordState.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r3, Continuation r4) {
            com.obric.audio.enroll.recorder.a r5 = (com.obric.audio.enroll.recorder.a) r3;
            FLogger.a.i("EnrollingFragment", "observe recordingEvent " + r5);
            int r6 = C0031a.a[r5.b.ordinal()];
            if (r6 == 1) goto L10;
            if (r6 == 2) goto L10;
            throw new NoWhenBranchMatchedException();
        L10:
            return Unit.INSTANCE;
        }
    }

    public EnrollingFragment$observe$1(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollingFragment$observe$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);
    L15:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        EnrollViewModel r5 = this.this$0.f;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r5 = null;
    L11:
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r6 = r5.getRecordingEvent();
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L15;
        return r0;
    }
}
