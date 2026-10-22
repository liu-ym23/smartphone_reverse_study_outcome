package com.larus.slides.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4", f = "SlidesFragment.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
final class SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SlidesFragment this$0;

    /* JADX INFO: renamed from: com.larus.slides.impl.SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.slides.impl.SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4$1", f = "SlidesFragment.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;
        final /* synthetic */ SlidesFragment this$0;

        public AnonymousClass1(SlidesFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<String> r5 = this.this$0.J;
            this.label = 1;
            r4 = r5.await(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4(SlidesFragment r1, Continuation<? super SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SlidesFragment$initTitleBarService$1$onTitleMenuUpdate$4(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        SlidesFragment r2 = (SlidesFragment) this.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        r2.G = (String) r7;
    L21:
        SlidesFragment r8 = this.this$0;
        r8.z = true;
        int r3 = ww9.a.b;
        ww9.a.b("undo", null, r8.t9());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        String r9 = this.this$0.G;
        if (r9 != null) goto L11;
    L14:
        boolean r10 = true;
    L15:
        if (r10 == false) goto L21;
        SlidesFragment r11 = this.this$0;
        AnonymousClass1 r4 = new AnonymousClass1(r11, null);
        this.L$0 = r11;
        this.label = 1;
        Object r5 = TimeoutKt.c(15000, r4, this);
        if (r5 != r0) goto L19;
        return r0;
    L19:
        r2 = r11;
        r7 = r5;
        goto L20
    L11:
        if (r9.length() == 0) goto L14;
        r10 = false;
        goto L15
    }
}
