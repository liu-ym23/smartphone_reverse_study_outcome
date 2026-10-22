package com.obric.aikernel.auto_test.impl;

import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.auto_test.api.AutoTestHandlerApi;
import com.obric.aikernel.auto_test.impl.util.AppCPUUsage;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.sdk.autotest.AutoTestManager;
import com.obric.aikernel.utils.AppUtils;
import com.obric.aikernel.utils.DmaBufUtils;
import e8.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoTestHandlerImpl implements AutoTestHandlerApi {
    public static final AutoTestHandlerImpl INSTANCE = null;
    private static final String TAG = "AutoTestHandlerImpl";

    /* JADX INFO: renamed from: com.obric.aikernel.auto_test.impl.AutoTestHandlerImpl$queryCPUUsage$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.auto_test.impl.AutoTestHandlerImpl$queryCPUUsage$1", f = "AutoTestHandlerImpl.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $cb;
        int label;

        AnonymousClass1(b r10, Continuation<? super AnonymousClass1> r11) {
            this.$cb = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$cb, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            final float r13 = ((Number) r10).floatValue();
            b r14 = this.$cb;
            if (r14 == null) goto L15;
            AutoTestHandlerImpl r15 = AutoTestHandlerImpl.INSTANCE;
            Boxing.boxBoolean(AutoTestHandlerImpl.access$safeOnResult(r15, r14, AutoTestHandlerImpl.setResApply$default(r15, new Bundle(), 0, new C01031(r13), 1, null)));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            AppCPUUsage r16 = AppCPUUsage.f4473a;
            this.label = 1;
            r10 = AppCPUUsage.c(r16, 0, this, 1, null);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    static {
        INSTANCE = new AutoTestHandlerImpl();
    }

    private AutoTestHandlerImpl() {
    }

    public static final /* synthetic */ boolean access$safeOnResult(AutoTestHandlerImpl r10, b r11, Bundle r12) {
        return r10.safeOnResult(r11, r12);
    }

    @JvmStatic
    public static final AutoTestHandlerImpl getInst() {
        return INSTANCE;
    }

    private final void queryCPUUsage(b r10) {
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(r10, null), 3, null);
    }

    private final void queryMemory(b r10) {
        final Debug.MemoryInfo r11 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r11);
        final int r12 = DmaBufUtils.f5578a.getDmaBufRssSize();
        if (r10 == null) goto L6;
        safeOnResult(r10, setResApply$default(this, new Bundle(), 0, new C03501(r11, r12), 1, null));
        return;
    }

    private final boolean safeOnResult(b r10, Bundle r11) {
        r10.j2(r11);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        AIKLog.INSTANCE.e("TaskOnResult", String.valueOf(th.getMessage()));
        return false;
    }

    private final Bundle setResApply(Bundle r10, int r11, Function1<? super Bundle, Unit> r12) {
        r10.putInt(IdlKeys.ErrorCode, r11);
        r10.putString(IdlKeys.ErrorInfo, null);
        boolean r13 = true;
        if (r11 != 1) goto L6;
        r13 = false;
    L6:
        r10.putBoolean(IdlKeys.IsFinish, r13);
        r12.invoke(r10);
        return r10;
    }

    static /* synthetic */ Bundle setResApply$default(AutoTestHandlerImpl r10, Bundle r11, int r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r12 = 0;
    L6:
        return r10.setResApply(r11, r12, r13);
    }

    @Override // com.obric.aikernel.auto_test.api.AutoTestHandlerApi
    public void handleAutoRequest(Bundle r10, b r11) {
        if (AutoTestManager.INSTANCE.isAutoTestApp(AppUtils.f5573a.d(Binder.getCallingUid())) == true) goto L7;
        if (r11 == null) goto L20;
        safeOnResult(r11, a.B(new Bundle(), 101, "only auto test app can call this method.", false, 4, null));
        return;
    L20:
        return;
    L7:
        if (r10 != null) goto L11;
        if (r11 == null) goto L21;
        safeOnResult(r11, a.B(new Bundle(), 101, "invalid args.", false, 4, null));
        return;
    L21:
        return;
    L11:
        String r12 = r10.getString(EnsureReportData.METHOD);
        AIKLog.INSTANCE.d(TAG, "handleAutoRequest: method = " + r12);
        if (Intrinsics.areEqual(r12, "query_memory") == false) goto L15;
        queryMemory(r11);
        return;
    L15:
        if (Intrinsics.areEqual(r12, "query_cpu_usage") == false) goto L17;
        queryCPUUsage(r11);
        return;
    L17:
        if (r11 == null) goto L24;
        safeOnResult(r11, a.B(new Bundle(), 106, "not supported method: " + r12, false, 4, null));
        return;
    }
}
