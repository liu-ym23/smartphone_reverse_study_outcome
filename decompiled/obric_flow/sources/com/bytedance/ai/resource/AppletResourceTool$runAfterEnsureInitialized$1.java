package com.bytedance.ai.resource;

import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$runAfterEnsureInitialized$1", f = "AppletResourceTool.kt", i = {}, l = {InputDeviceCompat.SOURCE_GAMEPAD, 1026}, m = "invokeSuspend", n = {}, s = {})
final class AppletResourceTool$runAfterEnsureInitialized$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f2554b;

    /* JADX INFO: renamed from: com.bytedance.ai.resource.AppletResourceTool$runAfterEnsureInitialized$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$runAfterEnsureInitialized$1$1", f = "AppletResourceTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f2555a;

        public AnonymousClass1(Function0 r5, Continuation r10) {
            this.f2555a = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f2555a, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            Function0 r11 = this.f2555a;
            return new AnonymousClass1(r11, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r5);
            this.f2555a.invoke();
            return Unit.INSTANCE;
        }
    }

    public AppletResourceTool$runAfterEnsureInitialized$1(Function0 r5, Continuation r10) {
        this.f2554b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletResourceTool$runAfterEnsureInitialized$1(this.f2554b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        Function0 r11 = this.f2554b;
        return new AppletResourceTool$runAfterEnsureInitialized$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2553a;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        wt.d r12 = t2.b.d;
        AnonymousClass1 r13 = new AnonymousClass1(this.f2554b, null);
        this.f2553a = 2;
        if (BuildersKt.withContext(r12, r13, this) != r5) goto L17;
    L15:
        return r5;
    L10:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.s r14 = e0.g;
        this.f2553a = 1;
        if (r14.d(this) != r5) goto L13;
        goto L13
    }
}
