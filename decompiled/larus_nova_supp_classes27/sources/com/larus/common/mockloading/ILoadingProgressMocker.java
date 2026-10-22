package com.larus.common.mockloading;

import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface ILoadingProgressMocker {

    public static final class DefaultImpls {
        public static Object a(ILoadingProgressMocker r12, Continuation<? super Unit> r13) {
            if ((r13 instanceof ILoadingProgressMocker$startProgress$1) == false) goto L7;
            ILoadingProgressMocker$startProgress$1 r0 = (ILoadingProgressMocker$startProgress$1) r13;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            int r15 = r0.I$0;
            double r4 = r0.D$0;
            ILoadingProgressMocker r5 = (ILoadingProgressMocker) r0.L$0;
            ResultKt.throwOnFailure(r14);
            int r16 = r15;
            r12 = r5;
        L16:
            if (r12.getProgress() > 99) goto L25;
            int r6 = (int) Math.floor(Math.pow(1.0d - (1.0d / ((r4 * 2.0d) + 1.0d)), 2.0d) * 100.0d);
            if (r6 < r16) goto L20;
            r12.setProgress(r6);
            FLogger.a.i("ILoadingProgressMocker", r12.hashCode() + " update: Duration: " + r4 + ", Progress: " + r12.getProgress() + ", New Progress: " + r6);
            r16 = r6;
        L21:
            r4 = r4 + 0.1d;
            r0.L$0 = r12;
            r0.D$0 = r4;
            r0.I$0 = r16;
            r0.label = 1;
            if (DelayKt.delay(100, r0) != r2) goto L16;
            return r2;
        L20:
            FLogger.a.i("ILoadingProgressMocker", "skipped update: Duration: " + r4 + ", Progress: " + r12.getProgress() + ", New Progress: " + r6);
            goto L21
        L25:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            r16 = r12.getProgress();
            r4 = 0.0d;
        L7:
            r0 = new ILoadingProgressMocker$startProgress$1(r13);
            goto L8
        }
    }

    int getProgress();

    void setProgress(int r1);
}
