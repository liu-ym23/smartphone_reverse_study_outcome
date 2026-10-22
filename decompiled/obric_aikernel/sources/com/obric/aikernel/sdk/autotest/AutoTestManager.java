package com.obric.aikernel.sdk.autotest;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import java.io.Closeable;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AutoTestManager {
    public static final AutoTestManager INSTANCE = null;
    private static final String TAG = "AutoTestManager";

    static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function0 f5435a;

        a(Function0 r10) {
            Intrinsics.checkNotNullParameter(r10, "function");
            this.f5435a = r10;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final /* synthetic */ void binderDied() {
            this.f5435a.invoke();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0}, l = {39, 42}, m = "autoTest", n = {"bArgs"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        AnonymousClass1(AutoTestManager r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.autoTest(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0, 0, 0, 0}, l = {62}, m = "callAutoTestAsResponse", n = {"this", "args", "block", "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
    static final class C03901<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        C03901(AutoTestManager r10, Continuation<? super C03901> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return AutoTestManager.access$callAutoTestAsResponse(this.this$0, null, null, 0, null, this);
        }
    }

    static {
        INSTANCE = new AutoTestManager();
    }

    private AutoTestManager() {
    }

    public static final /* synthetic */ Object access$callAutoTestAsResponse(AutoTestManager r10, com.obric.aikernel.a r11, Bundle r12, long r13, Function1 r14, Continuation r15) {
        return r10.callAutoTestAsResponse(r11, r12, r13, r14, r15);
    }

    private final <T> Object callAutoTestAsResponse(com.obric.aikernel.a r15, Bundle r16, long r17, Function1<? super Bundle, ? extends T> r19, Continuation<? super T> r20) {
        if ((r20 instanceof C03901) == false) goto L7;
        C03901 r10 = (C03901) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        C03901 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r12.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        long r21 = r12.J$0;
        Function1<? super Bundle, ? extends T> r22 = (Function1) r12.L$2;
        Bundle r23 = (Bundle) r12.L$1;
        AutoTestManager r24 = (AutoTestManager) r12.L$0;
        ResultKt.throwOnFailure(r13);
        Function1<? super Bundle, ? extends T> r25 = r22;
        Bundle r26 = r23;
        Object r27 = r13;
    L18:
        Bundle r28 = (Bundle) r27;
        if (r28 != null) goto L22;
        AIKLog.INSTANCE.v(TAG, "callAutoTestlAsResponse " + r26.getString(IdlKeys.MethodName) + " timeout after " + r21 + " ms");
        Bundle r29 = new Bundle();
        StringBuilder r30 = new StringBuilder();
        r30.append("timeout after ");
        r30.append(r21);
        r30.append(" ms");
        r28 = e8.a.B(r29, 107, r30.toString(), false, 4, null);
    L22:
        return r25.invoke(r28);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AutoTestManager$callAutoTestAsResponse$responseBundle$1 r110 = new AutoTestManager$callAutoTestAsResponse$responseBundle$1(r16, r17, r15, null);
        r12.L$0 = this;
        r26 = r16;
        r12.L$1 = r26;
        r25 = r19;
        r12.L$2 = r25;
        r12.J$0 = r17;
        r12.label = 1;
        Object r31 = TimeoutKt.d(r17, r110, r12);
        if (r31 != r14) goto L17;
        return r14;
    L17:
        r27 = r31;
        r21 = r17;
    L7:
        r10 = new C03901(this, r20);
        goto L8
    }

    static /* synthetic */ Object callAutoTestAsResponse$default(AutoTestManager r10, com.obric.aikernel.a r11, Bundle r12, long r13, Function1 r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L6;
        r13 = WsConstants.EXIT_DELAY_TIME;
    L6:
        return r10.callAutoTestAsResponse(r11, r12, r13, r14, r15);
    }

    public final Object autoTest(Context r19, JSONObject r20, Continuation<? super f8.a<Object>> r21) {
        if ((r21 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L21;
        if (r15 == 1) goto L19;
        if (r15 != 2) goto L18;
        Closeable r16 = (Closeable) r12.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L36:
        f8.a r17 = (f8.a) r13;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r16, null);
        return r17;
    L15:
        th = th;
    L16:
        Throwable r18 = th;
        throw r18;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r16, r18);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Bundle r22 = (Bundle) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        Bundle r23 = r22;
        ServiceConnector.b r24 = (ServiceConnector.b) r13;
        if (r24 != null) goto L45;
        Bundle r25 = e8.a.A(new Bundle(), 102, null, 2, null);
    L25:
        return e8.a.H(r25);
    L45:
        AutoTestManager r26 = INSTANCE;     // Catch: Throwable -> L39
        com.obric.aikernel.a r27 = r24.a();     // Catch: Throwable -> L39
        AutoTestManager$autoTest$2$1 r28 = AutoTestManager$autoTest$2$1.INSTANCE;     // Catch: Throwable -> L39
        r12.L$0 = r24;     // Catch: Throwable -> L39
        r12.label = 2;     // Catch: Throwable -> L39
        Object r29 = r26.callAutoTestAsResponse(r27, r23, 5000, r28, r12);     // Catch: Throwable -> L39
        if (r29 != r14) goto L35;
        return r14;
    L35:
        r16 = r24;
        r13 = r29;
    L39:
        th = th;
        r16 = r24;
        goto L16
    L21:
        ResultKt.throwOnFailure(r13);
        String r30 = r19.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r30, "context.packageName");
        if (isAutoTestApp(r30) == true) goto L26;
        r25 = e8.a.B(new Bundle(), 101, "only auto test app can call this method.", false, 4, null);
        goto L25
    L26:
        r22 = e8.a.q(r20, false, 2, null);
        AIKernelApi r31 = AIKernelManager.INSTANCE.getInstance$sdk_release();
        r12.L$0 = r22;
        r12.label = 1;
        r13 = AIKernelApi.m(r31, 0, r12, 1, null);
        if (r13 != r14) goto L20;
        return r14;
    L7:
        r10 = new AnonymousClass1(this, r21);
        goto L8
    }

    public final boolean isAutoTestApp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return Intrinsics.areEqual(r10, "com.obric.aikernelautotest");
    }
}
