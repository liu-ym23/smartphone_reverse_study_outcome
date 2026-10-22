package com.obric.assistant.onelogin;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity$checkOLoginOrRoute$1", f = "ObricOneLoginActivity.kt", i = {}, l = {176, 179, 184}, m = "invokeSuspend", n = {}, s = {})
final class ObricOneLoginActivity$checkOLoginOrRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricOneLoginActivity this$0;

    /* JADX INFO: renamed from: com.obric.assistant.onelogin.ObricOneLoginActivity$checkOLoginOrRoute$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity$checkOLoginOrRoute$1$1", f = "ObricOneLoginActivity.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            Object r5 = kotlinx.coroutines.flow.e.t(c0.a, new ObricOneLoginUtilsKt$awaitOAccountChanged$2(null), this);
            if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r5 = Unit.INSTANCE;
        L12:
            if (r5 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.onelogin.ObricOneLoginActivity$checkOLoginOrRoute$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity$checkOLoginOrRoute$1$2", f = "ObricOneLoginActivity.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricOneLoginActivity this$0;

        public AnonymousClass2(ObricOneLoginActivity r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricOneLoginActivity r5 = this.this$0;
            this.label = 1;
            if (ObricOneLoginActivity.N1(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public ObricOneLoginActivity$checkOLoginOrRoute$1(ObricOneLoginActivity r1, Continuation<? super ObricOneLoginActivity$checkOLoginOrRoute$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricOneLoginActivity$checkOLoginOrRoute$1(this.this$0, r3);
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
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r8);
    L24:
        ObricOneLoginActivity r9 = this.this$0;
        int r2 = ObricOneLoginActivity.o;
        r9.P1();
    L26:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L19:
        if (((Boolean) r8).booleanValue() == true) goto L21;
        ObricOneLoginActivity.O1(this.this$0);
        goto L26
    L21:
        AnonymousClass2 r10 = new AnonymousClass2(this.this$0, null);
        this.label = 3;
        if (TimeoutKt.c(20000, r10, this) != r0) goto L24;
        return r0;
    L11:
        ResultKt.throwOnFailure(r8);
    L15:
        this.label = 2;
        StateFlowImpl r11 = c0.a;
        r8 = CoroutineScopeKt.coroutineScope(new ObricOneLoginUtilsKt.getOAccountLogin.2(null), this);
        if (r8 != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        AnonymousClass1 r12 = new AnonymousClass1(null);
        this.label = 1;
        if (TimeoutKt.c(2000, r12, this) != r0) goto L15;
        return r0;
    }
}
