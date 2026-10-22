package com.larus.bmhome.view.actionbar.edit.kmp;

import com.larus.bmhome.actionbar.model.t1;
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
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1", f = "KmpInstructionEditorViewFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.view.actionbar.edit.c $viewModel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpInstructionEditorViewFactory this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1$1", f = "KmpInstructionEditorViewFactory.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.view.actionbar.edit.c $viewModel;
        int label;
        final /* synthetic */ KmpInstructionEditorViewFactory this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "conf", "Lcom/larus/bmhome/actionbar/model/ParamFilterConf;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1$1$1", f = "KmpInstructionEditorViewFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00471 extends SuspendLambda implements Function2<t1, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ KmpInstructionEditorViewFactory this$0;

            public C00471(KmpInstructionEditorViewFactory r1, Continuation<? super C00471> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00471 r0 = new C00471(this.this$0, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(t1 r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((t1) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r5);
                t1 r6 = (t1) this.L$0;
                KmpInstructionEditorViewFactory r0 = this.this$0;
                int r1 = KmpInstructionEditorViewFactory.p;
                r0.q().ki(new aq8.c.e(r6, false, this.this$0.c));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(com.larus.bmhome.view.actionbar.edit.c r1, KmpInstructionEditorViewFactory r2, Continuation<? super AnonymousClass1> r3) {
            this.$viewModel = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$viewModel, this.this$0, r4);
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
            d1<t1> r7 = this.$viewModel.getOptionParamFilterConfChanged();
            C00471 r2 = new C00471(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
            return r0;
        }
    }

    public KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1(com.larus.bmhome.view.actionbar.edit.c r1, KmpInstructionEditorViewFactory r2, Continuation<? super KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1> r3) {
        this.$viewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1 r0 = new KmpInstructionEditorViewFactory$observeViewModelExternalEvents$1(this.$viewModel, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        BuildersKt.launch$default((CoroutineScope) this.L$0, null, null, new AnonymousClass1(this.$viewModel, this.this$0, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
