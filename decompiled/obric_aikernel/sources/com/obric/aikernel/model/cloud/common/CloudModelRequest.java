package com.obric.aikernel.model.cloud.common;

import android.content.Context;
import android.os.Bundle;
import com.obric.aikernel.RequestTracker;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CloudModelRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RequestParams f4628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.aikernel.b f4629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4630f;

    public CloudModelRequest(Context r10, String r11, String r12, RequestParams r13, com.obric.aikernel.b r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "bizName");
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "callback");
        this.f4625a = r10;
        this.f4626b = r11;
        this.f4627c = r12;
        this.f4628d = r13;
        this.f4629e = r14;
        StringBuilder r15 = new StringBuilder();
        r15.append(r11);
        if (r12.length() != 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L8;
        String r17 = "";
    L9:
        r15.append(r17);
        this.f4630f = r15.toString();
        return;
    L8:
        r17 = '_' + r12;
        goto L9
    L5:
        r16 = false;
        goto L6
    }

    protected final String a() {
        return this.f4626b;
    }

    protected final com.obric.aikernel.b b() {
        return this.f4629e;
    }

    protected final Context c() {
        return this.f4625a;
    }

    protected final RequestParams d() {
        return this.f4628d;
    }

    public abstract Object e(Continuation<? super Bundle> r10);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [T, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, android.os.Bundle] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object f(Continuation<? super RequestTracker.b> r21) {
        CloudModelRequest r10 = this;
        if ((r21 instanceof CloudModelRequest$safeRun$1) == false) goto L7;
        CloudModelRequest$safeRun$1 r11 = (CloudModelRequest$safeRun$1) r21;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r11.L$1;
        CloudModelRequest r17 = (CloudModelRequest) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
        Ref.ObjectRef r18 = r16;
        r10 = r17;
    L22:
        Object r19 = Result.m32constructorimpl((Bundle) r13);     // Catch: Throwable -> L24
    L26:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);
        if (r20 == null) goto L37;
        if ((r20 instanceof AIKernelException) == false) goto L33;
        int r22 = ((AIKernelException) r20).getCode();
        String r23 = r20.getMessage();
        if (r23 != null) goto L35;
        StringBuilder r24 = new StringBuilder();
    L34:
        r24.append(r10.f4626b);
        r24.append(" cloud call error: ");
        r24.append(ExceptionsKt.stackTraceToString(r20));
        r23 = r24.toString();
    L35:
        int r25 = r22;
        String r110 = r23;
        AIKLog.INSTANCE.e("CloudModelRequest", "run " + e8.a.e(r10.f4628d.getBackend()) + ' ' + r25 + ':' + r110);
        ApiPerfDetails.a.j(ApiPerfDetails.Companion, r10.f4628d.getBackend(), ApiPerfDetails.onCallbackClient, false, 2, null);
        ?? r26 = e8.a.B(new Bundle(), r25, r110, false, 4, null);
        r10.f4629e.j2(r26);
        r18.element = r26;
        goto L37
    L33:
        r22 = 105;
        r24 = new StringBuilder();
    L37:
        if (Result.m39isSuccessimpl(r19) == false) goto L39;
        r18.element = (Bundle) r19;
    L39:
        ApiPerfDetails.a r27 = ApiPerfDetails.Companion;
        r27.i(r10.f4628d.getBackend(), ApiPerfDetails.onEndApiElapse, true);
        ApiPerfDetails.a.j(r27, r10.f4628d.getBackend(), ApiPerfDetails.onEndApi, false, 2, null);
        return new RequestTracker.b("runPackage", r10.f4630f, r10.f4628d, (Bundle) r18.element, null, 16, null);
    L24:
        Throwable th = th;
    L25:
        Result.Companion r28 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L14:
        th = th;
        r18 = r16;
        r10 = r17;
        goto L25
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        ApiPerfDetails.Companion.b(r10.f4628d.getBackend()).putString("version", r10.f4627c);
        r18 = new Ref.ObjectRef();
        r18.element = com.obric.aikernel.request.b.f4839c.a();
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L24
        r11.L$0 = r10;     // Catch: Throwable -> L24
        r11.L$1 = r18;     // Catch: Throwable -> L24
        r11.label = 1;     // Catch: Throwable -> L24
        r13 = r10.e(r11);     // Catch: Throwable -> L24
        if (r13 != r14) goto L22;
        return r14;
    L7:
        r11 = new CloudModelRequest$safeRun$1(r10, r21);
        goto L8
    }
}
