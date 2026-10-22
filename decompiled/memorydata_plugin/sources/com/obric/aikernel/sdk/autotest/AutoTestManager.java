package com.obric.aikernel.sdk.autotest;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.da;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJE\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\r0\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/sdk/autotest/AutoTestManager;", "", "()V", "TAG", "", "autoTest", "Lcom/obric/aikernel/sdk/response/Response;", "context", "Landroid/content/Context;", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "(Landroid/content/Context;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callAutoTestAsResponse", ExifInterface.GPS_DIRECTION_TRUE, "binder", "Lcom/obric/aikernel/AIKBinder;", "args", "Landroid/os/Bundle;", "timeoutMs", "", "block", "Lkotlin/Function1;", "(Lcom/obric/aikernel/AIKBinder;Landroid/os/Bundle;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAutoTestApp", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoTestManager {
    public static final AutoTestManager INSTANCE = null;
    private static final String TAG = "AutoTestManager";

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$autoTest$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0}, l = {39, 42}, m = "autoTest", n = {"bArgs"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        AnonymousClass1(AutoTestManager r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.autoTest(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager", f = "AutoTestManager.kt", i = {0, 0, 0, 0}, l = {62}, m = "callAutoTestAsResponse", n = {"this", "args", "block", "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
    static final class C10211<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoTestManager this$0;

        C10211(AutoTestManager r3, Continuation<? super C10211> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            this.result = r8;
            this.label |= Integer.MIN_VALUE;
            return AutoTestManager.access$callAutoTestAsResponse(this.this$0, null, null, 0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new AutoTestManager();
    }

    private AutoTestManager() {
    }

    public static final /* synthetic */ Object access$callAutoTestAsResponse(AutoTestManager r9, a r10, Bundle r11, long r12, Function1 r14, Continuation r15) {
        return r9.callAutoTestAsResponse((a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin"), r11, r12, (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final <T> Object callAutoTestAsResponse(a r17, Bundle r18, long r19, Function1<? super Bundle, ? extends T> r21, Continuation<? super T> r22) {
        AutoTestManager r0 = this;
        long r7 = r19;
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.memorydata.plugin");
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C10211.class) == false) goto L7;
        C10211 r2 = (C10211) ZeusTransformUtils.preCheckCast(r1, C10211.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        C10211 r12 = r2;
        Object r3 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r6 = r12.J$0;
        r11 = (Function1) ZeusTransformUtils.preCheckCast(r12.L$2, Function1.class, "com.obric.memorydata.plugin");
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r12.L$1, Bundle.class, "com.obric.memorydata.plugin");
        AutoTestManager r9 = (AutoTestManager) ZeusTransformUtils.preCheckCast(r12.L$0, AutoTestManager.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r7 = r6;
        Bundle r10 = r8;
        r0 = r9;
    L17:
        Bundle r14 = (Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L21;
        AutoTestManager r15 = (AutoTestManager) ZeusTransformUtils.preCheckCast(r0, AutoTestManager.class, "com.obric.memorydata.plugin");
        AIKLog.INSTANCE.v(TAG, "callAutoTestlAsResponse " + r10.getString(IdlKeys.MethodName) + " timeout after " + r7 + " ms");
        r14 = BundleExtKt.setErr$default(new Bundle(), 107, "timeout after " + r7 + " ms", false, 4, null);
    L21:
        return r11.invoke(r14);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        r10 = r18;
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1(r10, r19, r5, null), Function2.class, "com.obric.memorydata.plugin");
        r12.L$0 = r0;
        r12.L$1 = r10;
        r12.L$2 = r11;
        r12.J$0 = r7;
        r12.label = 1;
        r3 = da.b(r7, r16, r12);
        if (r3 != r13) goto L17;
        return r13;
    L7:
        r2 = new C10211(r0, r1);
        goto L8
    }

    static /* synthetic */ Object callAutoTestAsResponse$default(AutoTestManager r9, a r10, Bundle r11, long r12, Function1 r14, Continuation r15, int r16, Object r17) {
        a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if ((r16 & 4) == 0) goto L5;
        long r5 = 3000;
    L7:
        return r9.callAutoTestAsResponse(r3, r11, r5, r7, r8);
    L5:
        r5 = r12;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    public final Object autoTest(Context r21, JSONObject r22, Continuation<? super Response<Object>> r23) {
        ?? r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r3, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r11 = r4;
        Object r5 = r11.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r11.label;
        if (r7 == 0) goto L21;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r11.L$0, Closeable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
        r1 = r2;
    L36:
        Response r0 = (Response) ZeusTransformUtils.preCheckCast(r5, Response.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r1, null);
        return r0;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r11.L$0, Bundle.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L20:
        Bundle r9 = r8;
        ServiceConnector.MainProcessIpcBinding r10 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r5, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L32;
        Bundle r12 = BundleExtKt.setErr$default(new Bundle(), 102, null, 2, null);
    L25:
        return BundleExtKt.toBasicTypeResponse(r12);
    L32:
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r10, Closeable.class, "com.obric.memorydata.plugin");
        ServiceConnector.MainProcessIpcBinding r14 = (ServiceConnector.MainProcessIpcBinding) ZeusTransformUtils.preCheckCast(r13, ServiceConnector.MainProcessIpcBinding.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        AutoTestManager r15 = INSTANCE;     // Catch: Throwable -> L15
        a r16 = r14.getBinder();     // Catch: Throwable -> L15
        Function1 r17 = (Function1) ZeusTransformUtils.preCheckCast(AutoTestManager$autoTest$2$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        r11.L$0 = r13;     // Catch: Throwable -> L15
        r11.label = 2;     // Catch: Throwable -> L15
        r5 = r15.callAutoTestAsResponse(r16, r9, 5000, r17, r11);     // Catch: Throwable -> L15
        r1 = r13;
        if (r5 != r6) goto L36;
        return r6;
    L21:
        ResultKt.throwOnFailure(r5);
        String r18 = r1.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r18, "context.packageName");
        if (isAutoTestApp(r18) == true) goto L26;
        r12 = BundleExtKt.setErr$default(new Bundle(), 101, "only auto test app can call this method.", false, 4, null);
        goto L25
    L26:
        r8 = BundleExtKt.json2Bundle$default(r22, false, 2, null);
        AIKernelApi r19 = AIKernelManager.INSTANCE.getInstance$sdk_release();
        r11.L$0 = r8;
        r11.label = 1;
        r5 = AIKernelApi.getMainProcessIpcBinding$sdk_release$default(r19, 0, r11, 1, null);
        if (r5 != r6) goto L20;
        return r6;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L7:
        r4 = new AnonymousClass1(this, r3);
        goto L8
    }

    public final boolean isAutoTestApp(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return Intrinsics.areEqual(r1, AutoTestConstant.AUTO_TEST_APP_PACKAGE_NAME);
    }
}
