package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView$bind$1", f = "DoubaoMentionPanelView.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoMentionPanelView$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoubaoMentionPanelView.c $delegate;
    final /* synthetic */ DoubaoMentionViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoubaoMentionPanelView this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView$bind$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/mention/base/impl/atselector/doubaoview/DoubaoMentionUiState;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionPanelView$bind$1$1", f = "DoubaoMentionPanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<j, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ DoubaoMentionPanelView.c $delegate;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoubaoMentionPanelView this$0;

        public AnonymousClass1(CoroutineScope r1, DoubaoMentionPanelView r2, DoubaoMentionPanelView.c r3, Continuation<? super AnonymousClass1> r4) {
            this.$$this$launch = r1;
            this.this$0 = r2;
            this.$delegate = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$$this$launch, this.this$0, this.$delegate, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(j r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((j) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r13) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r13);
            j r14 = (j) this.L$0;
            DoubaoMentionPanelView r2 = this.this$0;
            DoubaoMentionPanelView.c r3 = this.$delegate;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
            boolean r6 = true;
            if (r14.c.length() <= 0) goto L8;
            boolean r7 = true;
        L9:
            if (r7 == false) goto L11;
            b r8 = r14.b;     // Catch: Throwable -> L27
        L14:
            if ((r8 instanceof b.C0175b) == false) goto L20;
            StringBuilder r1 = new StringBuilder("uiState error inSearch=");     // Catch: Throwable -> L27
            if (r7 == true) goto L19;
            r6 = false;
        L19:
            r1.append(r6);     // Catch: Throwable -> L27
            r1.append(", keyLen=");     // Catch: Throwable -> L27
            r1.append(r14.c.length());     // Catch: Throwable -> L27
            r1.append(", requestId=");     // Catch: Throwable -> L27
            r1.append(r14.d);     // Catch: Throwable -> L27
            Log.e("DoubaoMentionPanelView", r1.toString(), ((b.C0175b) r8).b);     // Catch: Throwable -> L27
        L25:
            int r0 = c.a;     // Catch: Throwable -> L27
            c.a(r2.c, r14, r3);     // Catch: Throwable -> L27
            Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
        L29:
            DoubaoMentionPanelView.c r4 = this.$delegate;
            if (Result.exceptionOrNull-impl(r15) == null) goto L33;
            r4.d(false);
        L33:
            return Unit.INSTANCE;
        L20:
            StringBuilder r9 = new StringBuilder("uiState update inSearch=");     // Catch: Throwable -> L27
            if (r7 == true) goto L24;
            r6 = false;
        L24:
            r9.append(r6);     // Catch: Throwable -> L27
            r9.append(", keyLen=");     // Catch: Throwable -> L27
            r9.append(r14.c.length());     // Catch: Throwable -> L27
            r9.append(", requestId=");     // Catch: Throwable -> L27
            r9.append(r14.d);     // Catch: Throwable -> L27
            r9.append(", load=");     // Catch: Throwable -> L27
            r9.append(r8.getClass().getSimpleName());     // Catch: Throwable -> L27
            Log.d("DoubaoMentionPanelView", r9.toString());     // Catch: Throwable -> L27
            goto L25
        L11:
            r8 = r14.a;     // Catch: Throwable -> L27
            goto L14
        L8:
            r7 = false;
        L27:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L29
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoubaoMentionPanelView$bind$1(DoubaoMentionViewModel r1, DoubaoMentionPanelView r2, DoubaoMentionPanelView.c r3, Continuation<? super DoubaoMentionPanelView$bind$1> r4) {
        this.$viewModel = r1;
        this.this$0 = r2;
        this.$delegate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoubaoMentionPanelView$bind$1 r0 = new DoubaoMentionPanelView$bind$1(this.$viewModel, this.this$0, this.$delegate, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        i1<j> r2 = this.$viewModel.getUiState();
        AnonymousClass1 r3 = new AnonymousClass1(r9, this.this$0, this.$delegate, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
