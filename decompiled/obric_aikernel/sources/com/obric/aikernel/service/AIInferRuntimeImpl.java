package com.obric.aikernel.service;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.InferEntry;
import com.obric.aikernel.InferEntryHolder;
import com.obric.aikernel.e;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.service.IAIInferRuntime;
import com.obric.aikernel.request.track.VMStartupInfo;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class AIInferRuntimeImpl implements IAIInferRuntime {
    public static final AIInferRuntimeImpl INSTANCE = null;
    private static final AtomicBoolean isInited = null;

    /* JADX INFO: renamed from: com.obric.aikernel.service.AIInferRuntimeImpl$init$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.AIInferRuntimeImpl$init$1", f = "AIInferRuntimeImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(r11);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            InferEntryHolder.b(InferEntryHolder.f4392a, null, 1, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        INSTANCE = new AIInferRuntimeImpl();
        isInited = new AtomicBoolean(false);
        VMStartupInfo.f4878a.d();
    }

    private AIInferRuntimeImpl() {
    }

    public static /* synthetic */ Map a(CrashType r10) {
        return init$lambda$5(r10);
    }

    @JvmStatic
    public static final AIInferRuntimeImpl getInst() {
        return INSTANCE;
    }

    private static final Map init$lambda$5(CrashType r12) {
        LinkedHashMap r13 = new LinkedHashMap();
        File r10 = new File(AppContext.INSTANCE.getContext().getFilesDir(), "/logs/pydump/" + Process.myPid() + ".log");
        InferEntry r11 = null;
        if (r10.exists() == true) goto L6;
        r10 = null;
    L6:
        String r14 = "";
        if (r10 == null) goto L20;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        Object r16 = Result.m32constructorimpl(FilesKt.readText$default(r10, null, 1, null));     // Catch: Throwable -> L10
    L13:
        if (Result.m38isFailureimpl(r16) == false) goto L15;
        r16 = null;
    L15:
        String r17 = (String) r16;
        if (r17 != null) goto L18;
        r17 = "";
    L18:
        r13.put("pydump", r17);
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L20:
        if (r13.containsKey("pydump") == false) goto L46;
    L35:
        e r19 = InferEntryHolder.b(InferEntryHolder.f4392a, null, 1, null).q2();
        if ((r19 instanceof InferEntry) == false) goto L38;
        r11 = (InferEntry) r19;
    L38:
        if (r11 == null) goto L44;
        List<y6.b> r20 = r11.j();
        if (r20 == null) goto L44;
        String r21 = CollectionsKt.joinToString$default(r20, "\n", null, null, 0, null, AIInferRuntimeImpl$init$2$3.INSTANCE, 30, null);
        if (r21 == null) goto L44;
        r14 = r21;
    L44:
        r13.put("packageInfos", r14);
        return r13;
    L46:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L23
        Object r23 = Result.m32constructorimpl(ExecutionEngine.f4305a.b());     // Catch: Throwable -> L23
    L25:
        Throwable r24 = Result.m35exceptionOrNullimpl(r23);
        if (r24 == null) goto L29;
        AIKLog.INSTANCE.e("pydump", "dumpThreadSync failed: " + r24);
    L29:
        if (Result.m38isFailureimpl(r23) == false) goto L31;
        r23 = null;
    L31:
        String r25 = (String) r23;
        if (r25 != null) goto L34;
        r25 = "invalid pydump";
    L34:
        r13.put("pydump", r25);
    L23:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    @Override // com.obric.aikernel.middleware.api.service.IAIInferRuntime
    public void init() {
        if (isInited.compareAndSet(false, true) == false) goto L6;
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
        Npth.addAttachUserData(a.f5439a, CrashType.ALL);
        AIKLog.INSTANCE.i("AIInferRuntimeImpl", "end init");
        return;
    }
}
