package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.databinding.LarusLayoutViewResultDetectComponentBinding;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$launchStartLoadingAnimationJob$1", f = "ResultDetectComponent.kt", i = {}, l = {107, 108}, m = "invokeSuspend", n = {}, s = {})
final class ResultDetectComponent$launchStartLoadingAnimationJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $showLoadingThresholdMs;
    int label;
    final /* synthetic */ ResultDetectComponent this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$launchStartLoadingAnimationJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectComponent$launchStartLoadingAnimationJob$1$1", f = "ResultDetectComponent.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ResultDetectComponent this$0;

        public AnonymousClass1(ResultDetectComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ResultDetectComponent r7 = this.this$0;
            this.label = 1;
            LarusLayoutViewResultDetectComponentBinding r8 = r7.m;
            if (r8 == null) goto L14;
            FLogger.a.i("ResultDetectComponent", "[startDetectAnimation] start");
            Object r9 = r8.b.l(true, this);
            if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            r9 = Unit.INSTANCE;
        L15:
            if (r9 != r0) goto L18;
            return r0;
        L14:
            r9 = null;
            goto L15
        }
    }

    public ResultDetectComponent$launchStartLoadingAnimationJob$1(long r1, ResultDetectComponent r3, Continuation<? super ResultDetectComponent$launchStartLoadingAnimationJob$1> r4) {
        this.$showLoadingThresholdMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ResultDetectComponent$launchStartLoadingAnimationJob$1(this.$showLoadingThresholdMs, this.this$0, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        FLogger.a.i("ResultDetectComponent", "[launchStartLoadingAnimationJob] launch, showLoadingThresholdMs:" + this.$showLoadingThresholdMs);
        long r4 = this.$showLoadingThresholdMs;
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L13;
        return r0;
    }
}
