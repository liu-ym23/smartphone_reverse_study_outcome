package com.ss.android.lark.keyboard.ime;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.ime.ExtensionImeKt$addImeStateChangeListener$job$1", f = "ExtensionIme.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExtensionImeKt$addImeStateChangeListener$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $listener;
    final /* synthetic */ a $this_addImeStateChangeListener;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.ime.ExtensionImeKt$addImeStateChangeListener$job$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.ime.ExtensionImeKt$addImeStateChangeListener$job$1$1", f = "ExtensionIme.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i $listener;
        final /* synthetic */ a $this_addImeStateChangeListener;
        int label;

        public AnonymousClass1(a r1, i r2, Continuation<? super AnonymousClass1> r3) {
            this.$this_addImeStateChangeListener = r1;
            this.$listener = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$this_addImeStateChangeListener, this.$listener, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            j r6 = ((ImeWrapper) this.$this_addImeStateChangeListener).getImeState();
            final i r3 = this.$listener;
            Function2<ImeStateDetail, ImeStateDetail, Unit> r2 = new C01491(r3);
            this.label = 1;
            r6.getClass();
            Object r7 = kotlinx.coroutines.flow.e.h(kotlinx.coroutines.flow.e.o(r6, new ImeStateFlow$doOnChange$2(r2)), this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r7 = Unit.INSTANCE;
        L12:
            if (r7 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.ime.ExtensionImeKt$addImeStateChangeListener$job$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.ime.ExtensionImeKt$addImeStateChangeListener$job$1$2", f = "ExtensionIme.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i $listener;
        final /* synthetic */ a $this_addImeStateChangeListener;
        int label;

        public AnonymousClass2(a r1, i r2, Continuation<? super AnonymousClass2> r3) {
            this.$this_addImeStateChangeListener = r1;
            this.$listener = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$this_addImeStateChangeListener, this.$listener, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            j r6 = ((ImeWrapper) this.$this_addImeStateChangeListener).getPanelState();
            final i r3 = this.$listener;
            Function2<ImeStateDetail, ImeStateDetail, Unit> r2 = new AnonymousClass1(r3);
            this.label = 1;
            r6.getClass();
            Object r7 = kotlinx.coroutines.flow.e.h(kotlinx.coroutines.flow.e.o(r6, new ImeStateFlow$doOnChange$2(r2)), this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r7 = Unit.INSTANCE;
        L12:
            if (r7 != r0) goto L15;
            return r0;
        }
    }

    public ExtensionImeKt$addImeStateChangeListener$job$1(a r1, i r2, Continuation<? super ExtensionImeKt$addImeStateChangeListener$job$1> r3) {
        this.$this_addImeStateChangeListener = r1;
        this.$listener = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ExtensionImeKt$addImeStateChangeListener$job$1 r0 = new ExtensionImeKt$addImeStateChangeListener$job$1(this.$this_addImeStateChangeListener, this.$listener, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(r9, null, null, new AnonymousClass1(this.$this_addImeStateChangeListener, this.$listener, null), 3, null);
        BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.$this_addImeStateChangeListener, this.$listener, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
