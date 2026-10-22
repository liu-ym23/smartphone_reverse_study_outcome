package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.obric.aee.PythonException;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJW\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J1\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!JO\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#JK\u0010$\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'JK\u0010(\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/obric/aikernel/runtime/VmEngine;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "unNamedExceptionStrategy", "Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/obric/aikernel/runtime/AIInferRuntime$Config;Lcom/obric/aikernel/model/device/UnNamedExceptionStrategy;)V", "executionEngineRun", "Landroid/os/Bundle;", "pkg", "Lcom/obric/aee/res/PackageInfo;", "args", "event", "", "vmContext", "useStream", "", "contextExtra", "callback", "Lkotlin/Function1;", "", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;ZLandroid/os/Bundle;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVmException", "e", "", "method", "callerPkgName", "loggerUsage", "pkgWrapper", "Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;", "run", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAsFlow", "(Lcom/obric/aee/res/PackageInfo;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vmExecuteEntry", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aee/res/PackageInfo;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/String;Lcom/obric/aikernel/runtime/AIInferRuntime$PackageWrapper;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vmExecuteRaw", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6197b;
    private final AIInferRuntime.d c;
    private final com.obric.aikernel.model.device.a d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\t*\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\t*\u00020\f¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/runtime/VmEngine$Companion;", "", "()V", "ENGINE_RUN_COUNT_KEY", "", "KEY_VM_DUR", "MODEL_QUOTA_COUNT_KEY", "TAG", "getKernelSessionId", "", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)Ljava/lang/Integer;", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;)Ljava/lang/Integer;", "getKernelSessionIdFromPyExtension", "getKernelSessionIdFromVm", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Integer a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Integer r1 = Integer.valueOf(r2.getInt(ApiPerfDetails.KEY_KERNEL_SESSION, -1));
            if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == true) goto L10;
            return null;
        L10:
            return r1;
        L5:
            r3 = false;
            goto L6
        }

        public final Integer a(RequestParams r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return a(r2.getBackend());
        }

        public final Integer b(RequestParams r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Bundle r3 = ApiPerfDetails.Companion.c(r2.getBackend());
            if (r3 != null) goto L7;
            return null;
        L7:
            return a(r3);
        }
    }

    static {
        f6196a = new a(null);
    }

    public e(al r3, AIInferRuntime.d r4, com.obric.aikernel.model.device.a r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "unNamedExceptionStrategy");
        this.f6197b = r6;
        this.c = r4;
        this.d = r5;
    }

    public static final /* synthetic */ Bundle a(e r0, Throwable r1, Bundle r2, String r3, com.obric.aee.res.b r4, String r5) {
        return r0.a(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ Bundle a(e r6, Throwable r7, Bundle r8, String r9, com.obric.aee.res.b r10, String r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r9 = "runPackage";
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    private final Bundle a(Throwable r15, Bundle r16, String r17, com.obric.aee.res.b r18, String r19) {
        if (ZeusTransformUtils.instanceOf(r15, PythonException.class) == false) goto L15;
        int r2 = ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getCode();
        if (r16 == null) goto L7;
        r16.putString(ApiPerfDetails.exceptionType, ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getType());
    L7:
        AIInferRuntime.b r7 = this.c.d();
        if (r7 == null) goto L13;
        String r8 = ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getType();
        int r9 = ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getCode();
        String r5 = r15.getMessage();
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r7.a(r8, r9, r5, ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getTraceback(), r18, r19);
    L13:
        String r0 = ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getType() + ' ' + ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getCode() + ' ' + r15.getMessage() + " \n " + ((PythonException) ZeusTransformUtils.preCheckCast(r15, PythonException.class, "com.obric.memorydata.plugin")).getTraceback();
    L23:
        if (r16 == null) goto L25;
        r16.putString(ApiPerfDetails.exceptionInfo, r0);
    L25:
        if (r2 != (-1)) goto L27;
        int r1 = 500;
    L28:
        com.obric.aikernel.runtime.utils.d.f6216a.g("VmEngine", r17 + " failed: " + r0);
        return BundleExtKt.setErr$default(new Bundle(), r1, r0, false, 4, null);
    L27:
        r1 = r2;
        goto L28
    L15:
        if (ZeusTransformUtils.instanceOf(r15, CancellationException.class) == false) goto L20;
        r2 = 501;
        if (r16 == null) goto L19;
        r16.putString(ApiPerfDetails.exceptionType, "CancellationException");
    L19:
        r0 = r15.toString();
        goto L23
    L20:
        if (r16 == null) goto L22;
        r16.putString(ApiPerfDetails.exceptionType, r15.getClass().getName());
    L22:
        r0 = r15.getClass() + ' ' + ExceptionsKt.stackTraceToString(r15);
        r2 = -1;
        goto L23
    }

    private final Object a(com.obric.aee.res.b r17, Bundle r18, String r19, Bundle r20, Bundle r21, Function1<? super Bundle, Unit> r22, Continuation<? super Bundle> r23) {
        final Function1 r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        o r3 = new o(IntrinsicsKt.intercepted(r2), 1);
        r3.e();
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        Function2 r8 = (Function2) ZeusTransformUtils.preCheckCast(new VmEngine$runAsFlow$2$vmCallback$1(r4, r0), Function2.class, "com.obric.memorydata.plugin");
        final bx r1 = i.a(a(this), null, null, (Function2) ZeusTransformUtils.preCheckCast(new VmEngine$runAsFlow$2$job$1(r17, r18, r8, r19, r20, r4, this, r21, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r4.a((Function1) ZeusTransformUtils.preCheckCast(new VmEngine$runAsFlow$2$1(r1), Function1.class, "com.obric.memorydata.plugin"));
        Object r5 = r3.h();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L5:
        return r5;
    }

    private final Object a(com.obric.aee.res.b r7, Bundle r8, String r9, Bundle r10, Continuation<? super Bundle> r11) {
        Continuation<? super Bundle> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return com.obric.aee.b.f5869a.a(r7, r8, r9, r10, r5);
    }

    private final Object a(com.obric.aee.res.b r11, Bundle r12, String r13, Bundle r14, boolean r15, Bundle r16, Function1<? super Bundle, Unit> r17, Continuation<? super Bundle> r18) {
        Function1<? super Bundle, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Bundle> r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (r15 == false) goto L7;
        return a(r11, r12, r13, r14, r16, r8, r0);
    L7:
        return a(r11, r12, r13, r14, r0);
    }

    public static final /* synthetic */ Object a(e r9, com.obric.aee.res.b r10, RequestParams r11, String r12, AIInferRuntime.g r13, Function1 r14, Continuation r15) {
        return r9.b(r10, r11, r12, r13, (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(e r10, com.obric.aee.res.b r11, RequestParams r12, String r13, AIInferRuntime.g r14, Function1 r15, Continuation r16, int r17, Object r18) {
        Function1<? super Bundle, Unit> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        if ((r17 & 4) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r17 & 16) == 0) goto L10;
        r0 = (Function1) ZeusTransformUtils.preCheckCast(VmEngine$vmExecuteEntry$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L10:
        return r10.a(r11, r12, r6, r14, r0, r9);
    L5:
        r6 = r13;
        goto L7
    }

    public static final /* synthetic */ al a(e r0) {
        return r0.f6197b;
    }

    private final void a(AIInferRuntime.g r3) {
        r3.a().a(System.currentTimeMillis());
    }

    public static final /* synthetic */ void a(e r0, AIInferRuntime.g r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ AIInferRuntime.d b(e r0) {
        return r0.c;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34941. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final java.lang.Object b(com.obric.aee.res.b r42, com.obric.aikernel.sdk.config.RequestParams r43, java.lang.String r44, com.obric.aikernel.runtime.AIInferRuntime.g r45, kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> r46, kotlin.coroutines.Continuation<? super kotlin.Unit> r47) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: CONST_CLASS (r10v0 ?? I:java.lang.Class<com.obric.aikernel.runtime.e>) =  A[DECLARE_VAR] com.obric.aikernel.runtime.e.class in method: com.obric.aikernel.runtime.e.b(com.obric.aee.res.b, com.obric.aikernel.sdk.config.RequestParams, java.lang.String, com.obric.aikernel.runtime.AIInferRuntime$g, kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit>, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aikernel.runtime.e.b(com.obric.aee.res.b, com.obric.aikernel.sdk.config.RequestParams, java.lang.String, com.obric.aikernel.runtime.AIInferRuntime$g, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ com.obric.aikernel.model.device.a c(e r0) {
        return r0.d;
    }

    public final Object a(final com.obric.aee.res.b r17, final RequestParams r18, final String r19, final AIInferRuntime.g r20, Function1<? super Bundle, Unit> r21, Continuation<? super Unit> r22) {
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, VmEngine$vmExecuteEntry$1.class) == false) goto L7;
        VmEngine$vmExecuteEntry$1 r2 = (VmEngine$vmExecuteEntry$1) ZeusTransformUtils.preCheckCast(r0, VmEngine$vmExecuteEntry$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        VmEngine$vmExecuteEntry$1 r1 = r2;
        Object r3 = r1.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r3);
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r5 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r1.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L20:
        ar r7 = (ar) ZeusTransformUtils.preCheckCast(r5.element, ar.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L28;
        r1.L$0 = null;
        r1.label = 2;
        if (r7.a(r1) != r14) goto L26;
        return r14;
    L28:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r3);
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        final CoroutineContext r8 = r1.getContext();
        Function1<? super Bundle, Unit> r9 = (Function1) ZeusTransformUtils.preCheckCast(new VmEngine$vmExecuteEntry$3(r13, this, r8, r6, r18, r17, r19, r20), Function1.class, "com.obric.memorydata.plugin");
        r1.L$0 = r13;
        r1.label = 1;
        if (b(r17, r18, r19, r20, r9, r1) != r14) goto L19;
        return r14;
    L19:
        r5 = r13;
    L7:
        r2 = new VmEngine$vmExecuteEntry$1(this, r0);
        goto L8
    }
}
