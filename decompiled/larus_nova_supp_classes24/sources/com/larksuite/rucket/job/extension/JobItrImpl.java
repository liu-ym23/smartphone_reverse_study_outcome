package com.larksuite.rucket.job.extension;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.log.Log;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class JobItrImpl<T> implements com.larksuite.rucket.job.extension.a<b<? extends T>> {
    public final RucketJob<T> a;
    public b<? extends T> b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.extension.JobItrImpl$hasNext$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.extension.JobItrImpl", f = "RucketJobIterator.kt", i = {}, l = {25}, m = "hasNext", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ JobItrImpl<T> this$0;

        public AnonymousClass1(JobItrImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return this.this$0.hasNext(this);
        }
    }

    static {
    }

    @Override // com.larksuite.rucket.job.extension.a
    public final b a() {
        b<? extends T> r0 = this.b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public JobItrImpl(RucketJob<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "target");
        this.a = r2;
    }

    @Override // com.larksuite.rucket.job.extension.a
    public final Object hasNext(Continuation<? super Boolean> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        JobItrImpl<T> r4 = (JobItrImpl) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: CancellationException -> L27
    L24:
        r4.b = (b) r7;     // Catch: CancellationException -> L27
        return Boxing.boxBoolean(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r7);
        if (this.a.isCanceled() == true) goto L19;
        RucketJob<T> r8 = this.a;     // Catch: CancellationException -> L27
        r0.L$0 = this;     // Catch: CancellationException -> L27
        r0.label = 1;     // Catch: CancellationException -> L27
        r7 = r8.awaitGet(r0);     // Catch: CancellationException -> L27
        if (r7 != r2) goto L23;
        return r2;
    L23:
        r4 = this;
        goto L24
    L19:
        return Boxing.boxBoolean(false);
    L27:
        Log.d("RucketJobIterator", "Current coroutine has been canceled.");
        this.a.cancel();
        return Boxing.boxBoolean(false);
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
