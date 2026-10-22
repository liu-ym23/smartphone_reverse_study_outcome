package com.larksuite.rucket.job.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJobImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ErrorHolderRucketJob<T> extends RucketJobImpl<T> {

    /* JADX INFO: renamed from: com.larksuite.rucket.job.impl.ErrorHolderRucketJob$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.impl.ErrorHolderRucketJob$1", f = "ErrorHolderRucketJob.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Exception $exception;
        int label;
        final /* synthetic */ ErrorHolderRucketJob<T> this$0;

        public AnonymousClass1(Exception r1, ErrorHolderRucketJob<T> r2, Continuation<? super AnonymousClass1> r3) {
            this.$exception = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$exception, this.this$0, r4);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Throwable r5 = this.$exception;
            if ((r5 instanceof ErrorResult) == false) goto L11;
            ErrorResult r6 = (ErrorResult) r5;
        L12:
            ErrorHolderRucketJob<T> r2 = this.this$0;
            this.label = 1;
            if (r2.setError(r6, this) != r0) goto L16;
            return r0;
        L11:
            r6 = new ErrorResult(this.$exception);
            goto L12
        }
    }

    public ErrorHolderRucketJob(Exception r8) {
        Intrinsics.checkNotNullParameter(r8, "exception");
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(r8, this, null), 3, null);
    }
}
