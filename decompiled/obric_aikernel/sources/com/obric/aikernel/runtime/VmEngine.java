package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.obric.aee.ExecutionEngine;
import com.obric.aee.PythonException;
import com.obric.aikernel.model.device.UnNamedExceptionStrategy;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.config.RequestParams;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
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
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class VmEngine {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5343d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f5344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AIInferRuntime.d f5345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UnNamedExceptionStrategy f5346c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Integer a(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Integer r11 = Integer.valueOf(r10.getInt(ApiPerfDetails.KEY_KERNEL_SESSION, -1));
            if (r11.intValue() < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == true) goto L10;
            return null;
        L10:
            return r11;
        L5:
            r12 = false;
            goto L6
        }

        public final Integer b(RequestParams r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Integer r11 = d(r10);
            if (r11 == null) goto L5;
            return r11;
        L5:
            return c(r10);
        }

        public final Integer c(RequestParams r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Bundle r11 = ApiPerfDetails.Companion.d(r10.getBackend());
            if (r11 != null) goto L7;
            return null;
        L7:
            return a(r11);
        }

        public final Integer d(RequestParams r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return a(r10.getBackend());
        }
    }

    static {
        f5343d = new a(null);
    }

    public VmEngine(l0 r10, AIInferRuntime.d r11, UnNamedExceptionStrategy r12) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r12, "unNamedExceptionStrategy");
        this.f5344a = r10;
        this.f5345b = r11;
        this.f5346c = r12;
    }

    public static final /* synthetic */ AIInferRuntime.d a(VmEngine r10) {
        return r10.f5345b;
    }

    public static final /* synthetic */ l0 b(VmEngine r10) {
        return r10.f5344a;
    }

    public static final /* synthetic */ UnNamedExceptionStrategy c(VmEngine r10) {
        return r10.f5346c;
    }

    public static final /* synthetic */ Bundle d(VmEngine r10, Throwable r11, Bundle r12, String r13, y6.b r14, String r15) {
        return r10.h(r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ void e(VmEngine r10, AIInferRuntime.PackageWrapper r11) {
        r10.j(r11);
    }

    public static final /* synthetic */ Object f(VmEngine r10, y6.b r11, RequestParams r12, String r13, AIInferRuntime.PackageWrapper r14, Function1 r15, Continuation r16) {
        return r10.o(r11, r12, r13, r14, r15, r16);
    }

    private final Object g(y6.b r10, Bundle r11, String r12, Bundle r13, boolean r14, Bundle r15, Function1<? super Bundle, Unit> r16, Continuation<? super Bundle> r17) {
        if (r14 == false) goto L7;
        return l(r10, r11, r12, r13, r15, r16, r17);
    L7:
        return k(r10, r11, r12, r13, r17);
    }

    private final Bundle h(Throwable r15, Bundle r16, String r17, y6.b r18, String r19) {
        if ((r15 instanceof PythonException) == false) goto L15;
        PythonException r10 = (PythonException) r15;
        int r11 = r10.getCode();
        if (r16 == null) goto L7;
        r16.putString(ApiPerfDetails.exceptionType, r10.getType());
    L7:
        AIInferRuntime.c r12 = this.f5345b.a();
        if (r12 == null) goto L13;
        String r13 = r10.getType();
        int r14 = r10.getCode();
        String r20 = r15.getMessage();
        if (r20 != null) goto L12;
        r20 = "";
    L12:
        r12.c(r13, r14, r20, ((PythonException) r15).getTraceback(), r18, r19);
    L13:
        String r21 = r10.getType() + ' ' + r10.getCode() + ' ' + r15.getMessage() + " \n " + ((PythonException) r15).getTraceback();
    L23:
        if (r16 == null) goto L25;
        r16.putString(ApiPerfDetails.exceptionInfo, r21);
    L25:
        if (r11 != (-1)) goto L27;
        int r22 = 500;
    L28:
        com.obric.aikernel.runtime.utils.d.f5417a.e("VmEngine", r17 + " failed: " + r21);
        return e8.a.B(new Bundle(), r22, r21, false, 4, null);
    L27:
        r22 = r11;
        goto L28
    L15:
        if ((r15 instanceof CancellationException) == false) goto L20;
        r11 = 501;
        if (r16 == null) goto L19;
        r16.putString(ApiPerfDetails.exceptionType, "CancellationException");
    L19:
        r21 = r15.toString();
        goto L23
    L20:
        if (r16 == null) goto L22;
        r16.putString(ApiPerfDetails.exceptionType, r15.getClass().getName());
    L22:
        r21 = r15.getClass() + ' ' + ExceptionsKt.stackTraceToString(r15);
        r11 = -1;
        goto L23
    }

    static /* synthetic */ Bundle i(VmEngine r10, Throwable r11, Bundle r12, String r13, y6.b r14, String r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L6;
        r13 = "runPackage";
    L6:
        return r10.h(r11, r12, r13, r14, r15);
    }

    private final void j(AIInferRuntime.PackageWrapper r10) {
        r10.g().p0(System.currentTimeMillis());
    }

    private final Object k(y6.b r10, Bundle r11, String r12, Bundle r13, Continuation<? super Bundle> r14) {
        return ExecutionEngine.f4305a.g(r10, r11, r12, r13, r14);
    }

    private final Object l(y6.b r14, Bundle r15, String r16, Bundle r17, Bundle r18, final Function1<? super Bundle, Unit> r19, Continuation<? super Bundle> r20) {
        final o r10 = new o(IntrinsicsKt.intercepted(r20), 1);
        r10.F();
        Function2<Bundle, Boolean, Unit> r11 = new VmEngine$runAsFlow$2$vmCallback$1(r10, r19);
        final v1 r12 = h.d(b(this), null, null, new VmEngine$runAsFlow$2$job$1(r14, r15, r11, r16, r17, r10, this, r18, null), 3, null);
        r10.h(new VmEngine$runAsFlow$2$1(r12));
        Object r13 = r10.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L5:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object n(VmEngine r10, y6.b r11, RequestParams r12, String r13, AIInferRuntime.PackageWrapper r14, Function1 r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        r13 = "";
    L5:
        String r19 = r13;
        if ((r17 & 16) == 0) goto L9;
        r15 = VmEngine$vmExecuteEntry$2.INSTANCE;
    L9:
        return r10.m(r11, r12, r19, r14, r15, r16);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 23041. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private final java.lang.Object o(y6.b r35, com.obric.aikernel.sdk.config.RequestParams r36, java.lang.String r37, com.obric.aikernel.runtime.AIInferRuntime.PackageWrapper r38, kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r0v0 ?? I:??[OBJECT, ARRAY]) = (r34v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: com.obric.aikernel.runtime.VmEngine.o(y6.b, com.obric.aikernel.sdk.config.RequestParams, java.lang.String, com.obric.aikernel.runtime.AIInferRuntime$PackageWrapper, kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit>, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes2.dex
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
            Method dump skipped, instruction units count: 2304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.aikernel.runtime.VmEngine.o(y6.b, com.obric.aikernel.sdk.config.RequestParams, java.lang.String, com.obric.aikernel.runtime.AIInferRuntime$PackageWrapper, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object m(final y6.b r17, final RequestParams r18, final String r19, final AIInferRuntime.PackageWrapper r20, final Function1<? super Bundle, Unit> r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof VmEngine$vmExecuteEntry$1) == false) goto L7;
        VmEngine$vmExecuteEntry$1 r10 = (VmEngine$vmExecuteEntry$1) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L26:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r15 = (Ref.ObjectRef) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L20:
        r0 r16 = (r0) r15.element;
        if (r16 == null) goto L28;
        r10.L$0 = null;
        r10.label = 2;
        if (r16.r(r10) != r13) goto L26;
        return r13;
    L28:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r12);
        final Ref.ObjectRef r23 = new Ref.ObjectRef();
        final CoroutineContext r24 = r10.getContext();
        Function1<? super Bundle, Unit> r110 = new VmEngine$vmExecuteEntry$3(r23, this, r24, r21, r18, r17, r19, r20);
        r10.L$0 = r23;
        r10.label = 1;
        if (o(r17, r18, r19, r20, r110, r10) != r13) goto L19;
        return r13;
    L19:
        r15 = r23;
    L7:
        r10 = new VmEngine$vmExecuteEntry$1(this, r22);
        goto L8
    }
}
