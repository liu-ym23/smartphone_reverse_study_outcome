package com.obric.aikernel.phx.sdk.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.core.api.CloudBizApi;
import com.obric.aikernel.phx.core.api.ScriptBizApi;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class AIKernelApi implements IAIKernelManager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f4813h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function3<Context, AIKernelConfig, ComponentName, ServiceConnector> f4814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ServiceConnector f4815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w<ServiceConnector> f4816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l0 f4817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f4819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f4820g;

    public static final class Companion {

        public static final enum ExecutionBinderSource extends Enum<ExecutionBinderSource> {
            private static final /* synthetic */ ExecutionBinderSource[] $VALUES = null;
            public static final ExecutionBinderSource CHILD_PROCESS = null;
            public static final a Companion = null;
            public static final ExecutionBinderSource IDLE_UNBIND_UNSUPPORTED = null;

            public static final class a {
                private a() {
                }

                public /* synthetic */ a(DefaultConstructorMarker r10) {
                    this();
                }

                public final ExecutionBinderSource a(String r10) {
                    boolean r11 = true;
                    if (r10 != null) goto L5;
                L7:
                    boolean r12 = false;
                L8:
                    if (r12 == true) goto L18;
                    if (r10 != null) goto L11;
                L13:
                    r11 = false;
                L14:
                    if (r11 == true) goto L18;
                    return ExecutionBinderSource.IDLE_UNBIND_UNSUPPORTED;
                L11:
                    if (StringsKt.endsWith$default(r10, ":llm", false, 2, null) != true) goto L13;
                L18:
                    return ExecutionBinderSource.CHILD_PROCESS;
                L5:
                    if (StringsKt.endsWith$default(r10, ":infer", false, 2, null) != true) goto L7;
                    r12 = true;
                    goto L8
                }
            }

            private static final /* synthetic */ ExecutionBinderSource[] $values() {
                return new ExecutionBinderSource[]{CHILD_PROCESS, IDLE_UNBIND_UNSUPPORTED};
            }

            static {
                CHILD_PROCESS = new ExecutionBinderSource("CHILD_PROCESS", 0);
                IDLE_UNBIND_UNSUPPORTED = new ExecutionBinderSource("IDLE_UNBIND_UNSUPPORTED", 1);
                $VALUES = $values();
                Companion = new a(null);
            }

            private ExecutionBinderSource(String r10, int r11) {
                super(r10, r11);
            }

            public static ExecutionBinderSource valueOf(String r10) {
                return (ExecutionBinderSource) Enum.valueOf(ExecutionBinderSource.class, r10);
            }

            public static ExecutionBinderSource[] values() {
                return (ExecutionBinderSource[]) $VALUES.clone();
            }
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.aikernel.a f4821a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f4822b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final ExecutionBinderSource f4823c;

            public a(com.obric.aikernel.a r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, "binder");
                this.f4821a = r10;
                this.f4822b = r11;
                this.f4823c = ExecutionBinderSource.Companion.a(r11);
            }

            public final com.obric.aikernel.a a() {
                return this.f4821a;
            }

            public final ExecutionBinderSource b() {
                return this.f4823c;
            }

            public final String c() {
                return this.f4822b;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (Intrinsics.areEqual(this.f4821a, r11.f4821a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f4822b, r11.f4822b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r10 = this.f4821a.hashCode() * 31;
                String r11 = this.f4822b;
                if (r11 != null) goto L5;
                int r12 = 0;
            L7:
                return r10 + r12;
            L5:
                r12 = r11.hashCode();
                goto L7
            }

            public String toString() {
                return "LoadedPackage(binder=" + this.f4821a + ", targetProcess=" + this.f4822b + ')';
            }
        }

        public static final class b extends com.obric.aikernel.b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n<Result<? extends List<PackageResource>>> f4824c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ List<String> f4825g;

            /* JADX WARN: Multi-variable type inference failed */
            b(n<? super Result<? extends List<PackageResource>>> r10, List<String> r11) {
                this.f4824c = r10;
                this.f4825g = r11;
            }

            @Override // com.obric.aikernel.b
            public void j2(Bundle r11) {
                if (r11 == null) goto L5;
                r11.setClassLoader(b.class.getClassLoader());
            L5:
                boolean r10 = true;
                if (r11 != null) goto L8;
            L10:
                r10 = false;
            L11:
                if (r10 == false) goto L22;
                List<PackageResource> r12 = e8.a.i(r11);
                if (r12 == null) goto L15;
                n<Result<? extends List<PackageResource>>> r13 = this.f4824c;
                Result.Companion r14 = Result.Companion;
                com.obric.aikernel.sdk.a.a(r13, Result.m31boximpl(Result.m32constructorimpl(r12)));
                Unit r15 = Unit.INSTANCE;
            L16:
                if (r15 != null) goto L25;
                n<Result<? extends List<PackageResource>>> r16 = this.f4824c;
                Result.Companion r17 = Result.Companion;
                List<String> r18 = this.f4825g;
                ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
                Iterator<T> r110 = r18.iterator();
            L19:
                if (r110.hasNext() == false) goto L21;
                r19.add(new PackageResource((String) r110.next(), 1, 0, null, 0, 28, null));
                goto L19
            L21:
                com.obric.aikernel.sdk.a.a(r16, Result.m31boximpl(Result.m32constructorimpl(r19)));
                return;
            L25:
                return;
            L15:
                r15 = null;
                goto L16
            L22:
                n<Result<? extends List<PackageResource>>> r111 = this.f4824c;
                Result.Companion r20 = Result.Companion;
                com.obric.aikernel.sdk.a.a(r111, Result.m31boximpl(Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(e8.a.f(r11), e8.a.g(r11), null, 0, 12, null)))));
                return;
            L8:
                if (e8.a.n(r11) != true) goto L10;
                goto L10
            }
        }

        public static final class c extends com.obric.aikernel.b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n<a> f4826c;

            /* JADX WARN: Multi-variable type inference failed */
            c(n<? super a> r10) {
                this.f4826c = r10;
            }

            @Override // com.obric.aikernel.b
            public void j2(Bundle r10) {
                if (r10 == null) goto L6;
                r10.setClassLoader(c.class.getClassLoader());
            L6:
                if (r10 != null) goto L8;
            L15:
                a r11 = null;
            L16:
                if (r11 == null) goto L18;
                com.obric.aikernel.sdk.a.a(this.f4826c, r11);
                return;
            L18:
                AIKLog r12 = AIKLog.INSTANCE;
                StringBuilder r13 = new StringBuilder();
                r13.append("[SDK] end loadPackage failed: ");
                if (r10 == null) goto L21;
                Integer r14 = Integer.valueOf(e8.a.f(r10));
            L22:
                r13.append(r14);
                r13.append(' ');
                if (r10 == null) goto L25;
                String r15 = e8.a.g(r10);
            L26:
                r13.append(r15);
                r12.i("AIKernelApi", r13.toString());
                com.obric.aikernel.sdk.a.a(this.f4826c, null);
                return;
            L25:
                r15 = null;
                goto L26
            L21:
                r14 = null;
                goto L22
            L8:
                if (e8.a.n(r10) == false) goto L10;
                Bundle r16 = r10;
            L11:
                if (r16 == null) goto L15;
                com.obric.aikernel.a r17 = com.obric.aikernel.a.AbstractBinderC0095a.U0(r16.getBinder(IdlKeys.Args_InferBinder));
                if (r17 == null) goto L15;
                Intrinsics.checkNotNullExpressionValue(r17, "asInterface(it.getBinder…dlKeys.Args_InferBinder))");
                r11 = new a(r17, r16.getString(IdlKeys.Args_TargetProcess));
                goto L16
            L10:
                r16 = null;
                goto L11
            }
        }

        public static final class d extends com.obric.aikernel.b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ n<Result<? extends List<PackageResource>>> f4827c;

            /* JADX WARN: Multi-variable type inference failed */
            d(n<? super Result<? extends List<PackageResource>>> r10) {
                this.f4827c = r10;
            }

            @Override // com.obric.aikernel.b
            public void j2(Bundle r10) {
                if (r10 == null) goto L5;
                r10.setClassLoader(d.class.getClassLoader());
            L5:
                Unit r11 = null;
                if (r10 == null) goto L10;
                e8.a.n(r10);
                n<Result<? extends List<PackageResource>>> r12 = this.f4827c;
                List<PackageResource> r13 = e8.a.i(r10);
                if (r13 == null) goto L10;
                Result.Companion r14 = Result.Companion;
                com.obric.aikernel.sdk.a.a(r12, Result.m31boximpl(Result.m32constructorimpl(r13)));
                r11 = Unit.INSTANCE;
            L10:
                if (r11 != null) goto L13;
                n<Result<? extends List<PackageResource>>> r15 = this.f4827c;
                Result.Companion r16 = Result.Companion;
                com.obric.aikernel.sdk.a.a(r15, Result.m31boximpl(Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(e8.a.f(r10), e8.a.g(r10), null, 0, 12, null)))));
                return;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r8v5, types: [T, kotlinx.coroutines.v1] */
        public final Object a(com.obric.aikernel.a r24, List<String> r25, RequestParams r26, Continuation<? super Result<? extends List<PackageResource>>> r27) {
            if ((r27 instanceof AIKernelApi$Companion$getPackageInfos$1) == false) goto L7;
            AIKernelApi$Companion$getPackageInfos$1 r10 = (AIKernelApi$Companion$getPackageInfos$1) r27;
            int r11 = r10.label;
            if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
            r10.label = r11 - Integer.MIN_VALUE;
        L8:
            Object r12 = r10.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r14 = r10.label;
            if (r14 == 0) goto L22;
            if (r14 == 1) goto L19;
            if (r14 != 2) goto L18;
            Bundle r15 = (Bundle) r10.L$4;
            ?? r16 = (Ref.ObjectRef) r10.L$3;
            CoroutineContext r17 = (CoroutineContext) r10.L$2;
            List r18 = (List) r10.L$1;
            com.obric.aikernel.a r19 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
            r16 = r16;
        L32:
            Object r20 = ((Result) r12).m41unboximpl();     // Catch: Throwable -> L15
            v1 r21 = (v1) r16.element;     // Catch: Throwable -> L15
            if (r21 == null) goto L35;
            v1.a.a(r21, null, 1, null);     // Catch: Throwable -> L15
        L35:
            AIKLog r22 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L15
            r23.append("[SDK] end getPackageInfos: ");     // Catch: Throwable -> L15
            if (Result.m38isFailureimpl(r20) == false) goto L38;
            Object r28 = null;
        L39:
            r23.append(r28);     // Catch: Throwable -> L15
            r23.append(' ');     // Catch: Throwable -> L15
            r23.append(Result.m35exceptionOrNullimpl(r20));     // Catch: Throwable -> L15
            r22.i("AIKernelApi", r23.toString());     // Catch: Throwable -> L15
            return ((Result) r12).m41unboximpl();
        L38:
            r28 = r20;
        L15:
            th = move-exception;
            Throwable r110 = th;
            ?? r29 = r16;
        L43:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] getPackageInfos error: " + r110);
            v1 r30 = (v1) r29.element;
            if (r30 == null) goto L46;
            v1.a.a(r30, null, 1, null);
        L46:
            Result.Companion r31 = Result.Companion;
            return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Got remote error.", r110, 0, 8, null)));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r32 = (Ref.ObjectRef) r10.L$3;
            CoroutineContext r33 = (CoroutineContext) r10.L$2;
            List<String> r34 = (List) r10.L$1;
            com.obric.aikernel.a r111 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L41
            List<String> r112 = r34;
            com.obric.aikernel.a r35 = r111;
            r14 = r32;
        L26:
            Bundle r36 = e8.a.b((Bundle) r12, null, IdlKeys.Method_GetPackageRes, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "getPackageInfos", null, false, 201, null);     // Catch: Throwable -> L41
            r36.putStringArray(IdlKeys.Args_Pkgs, (String[]) r112.toArray(new String[0]));     // Catch: Throwable -> L41
            r10.L$0 = r35;     // Catch: Throwable -> L41
            r10.L$1 = r112;     // Catch: Throwable -> L41
            r10.L$2 = r33;     // Catch: Throwable -> L41
            r10.L$3 = r14;     // Catch: Throwable -> L41
            r10.L$4 = r36;     // Catch: Throwable -> L41
            r10.label = 2;     // Catch: Throwable -> L41
            final o r37 = new o(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L41
            r37.F();     // Catch: Throwable -> L41
            r14.element = BinderMonitor.f4766a.b(r33, r35, new AIKernelApi$Companion$getPackageInfos$2$1(r37));     // Catch: Throwable -> L41
            r35.A1(r36, new b(r37, r112));     // Catch: Throwable -> L41
            r12 = r37.B();     // Catch: Throwable -> L41
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L41
        L29:
            if (r12 != r13) goto L31;
            return r13;
        L31:
            r16 = r14;
            goto L32
        L22:
            ResultKt.throwOnFailure(r12);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start getPackageInfos count:" + r25.size());
            r33 = r10.getContext();
            Ref.ObjectRef r38 = new Ref.ObjectRef();
            ParamsCompat r39 = ParamsCompat.f4752a;     // Catch: Throwable -> L41
            r35 = r24;
            r10.L$0 = r35;     // Catch: Throwable -> L41
            r112 = r25;
            r10.L$1 = r112;     // Catch: Throwable -> L41
            r10.L$2 = r33;     // Catch: Throwable -> L41
            r10.L$3 = r38;     // Catch: Throwable -> L41
            r10.label = 1;     // Catch: Throwable -> L41
            r12 = r39.f(r26, r10);     // Catch: Throwable -> L41
            r14 = r38;
            if (r12 != r13) goto L26;
            return r13;
        L41:
            th = move-exception;
            r110 = th;
            r29 = r14;
        L7:
            r10 = new AIKernelApi$Companion$getPackageInfos$1(this, r27);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [T, kotlinx.coroutines.v1] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v8, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r4v9 */
        public final Object b(com.obric.aikernel.a r23, String r24, RequestParams r25, Continuation<? super a> r26) {
            if ((r26 instanceof AIKernelApi$Companion$loadPackage$1) == false) goto L7;
            AIKernelApi$Companion$loadPackage$1 r10 = (AIKernelApi$Companion$loadPackage$1) r26;
            int r11 = r10.label;
            if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
            r10.label = r11 - Integer.MIN_VALUE;
        L8:
            Object r12 = r10.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r14 = r10.label;
            if (r14 == 0) goto L22;
            if (r14 == 1) goto L19;
            if (r14 != 2) goto L18;
            Bundle r15 = (Bundle) r10.L$3;
            ?? r16 = (Ref.ObjectRef) r10.L$2;
            CoroutineContext r17 = (CoroutineContext) r10.L$1;
            com.obric.aikernel.a r18 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
            r16 = r16;
        L33:
            a r19 = (a) r12;     // Catch: Throwable -> L15
            v1 r20 = (v1) r16.element;     // Catch: Throwable -> L15
            if (r20 == null) goto L36;
            v1.a.a(r20, null, 1, null);     // Catch: Throwable -> L15
        L36:
            return r12;
        L15:
            th = th;
        L39:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] loadPackage error: " + th);
            v1 r21 = (v1) r16.element;
            if (r21 == null) goto L42;
            v1.a.a(r21, null, 1, null);
        L42:
            return null;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r22 = (Ref.ObjectRef) r10.L$3;
            CoroutineContext r27 = (CoroutineContext) r10.L$2;
            String r28 = (String) r10.L$1;
            com.obric.aikernel.a r110 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L37
            String r111 = r28;
            r14 = r22;
        L27:
            Bundle r29 = e8.a.b((Bundle) r12, r111, IdlKeys.Method_LoadPackage, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "loadPackage", null, false, 200, null);     // Catch: Throwable -> L37
            r10.L$0 = r110;     // Catch: Throwable -> L37
            r10.L$1 = r27;     // Catch: Throwable -> L37
            r10.L$2 = r14;     // Catch: Throwable -> L37
            r10.L$3 = r29;     // Catch: Throwable -> L37
            r10.label = 2;     // Catch: Throwable -> L37
            final o r30 = new o(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L37
            r30.F();     // Catch: Throwable -> L37
            r14.element = BinderMonitor.f4766a.b(r27, r110, new AIKernelApi$Companion$loadPackage$2$1(r30));     // Catch: Throwable -> L37
            r110.A1(r29, new c(r30));     // Catch: Throwable -> L37
            r12 = r30.B();     // Catch: Throwable -> L37
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L37
        L30:
            if (r12 != r13) goto L32;
            return r13;
        L32:
            r16 = r14;
            goto L33
        L22:
            ResultKt.throwOnFailure(r12);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start loadPackage " + r24);
            CoroutineContext r31 = r10.getContext();
            Ref.ObjectRef r32 = new Ref.ObjectRef();
            ParamsCompat r33 = ParamsCompat.f4752a;     // Catch: Throwable -> L37
            r110 = r23;
            r10.L$0 = r110;     // Catch: Throwable -> L37
            r10.L$1 = r24;     // Catch: Throwable -> L37
            r10.L$2 = r31;     // Catch: Throwable -> L37
            r10.L$3 = r32;     // Catch: Throwable -> L37
            r10.label = 1;     // Catch: Throwable -> L37
            Object r34 = r33.f(r25, r10);     // Catch: Throwable -> L37
            if (r34 != r13) goto L26;
            return r13;
        L26:
            r111 = r24;
            r27 = r31;
            r12 = r34;
            r14 = r32;
        L37:
            th = th;
            r16 = r14;
        L7:
            r10 = new AIKernelApi$Companion$loadPackage$1(this, r26);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v0, types: [int] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15 */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r8v5, types: [T, kotlinx.coroutines.v1] */
        public final Object c(com.obric.aikernel.a r24, List<PackageResource> r25, RequestParams r26, Continuation<? super Result<? extends List<PackageResource>>> r27) {
            if ((r27 instanceof AIKernelApi$Companion$updatePackages$1) == false) goto L7;
            AIKernelApi$Companion$updatePackages$1 r10 = (AIKernelApi$Companion$updatePackages$1) r27;
            int r11 = r10.label;
            if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
            r10.label = r11 - Integer.MIN_VALUE;
        L8:
            Object r12 = r10.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r14 = r10.label;
            if (r14 == 0) goto L22;
            if (r14 == 1) goto L19;
            if (r14 != 2) goto L18;
            Bundle r15 = (Bundle) r10.L$3;
            ?? r16 = (Ref.ObjectRef) r10.L$2;
            CoroutineContext r17 = (CoroutineContext) r10.L$1;
            com.obric.aikernel.a r18 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
            r16 = r16;
        L32:
            Object r19 = ((Result) r12).m41unboximpl();     // Catch: Throwable -> L15
            v1 r20 = (v1) r16.element;     // Catch: Throwable -> L15
            if (r20 == null) goto L35;
            v1.a.a(r20, null, 1, null);     // Catch: Throwable -> L15
        L35:
            AIKLog r21 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L15
            r22.append("[SDK] end updatePackages: ");     // Catch: Throwable -> L15
            if (Result.m38isFailureimpl(r19) == false) goto L38;
            Object r23 = null;
        L39:
            r22.append(r23);     // Catch: Throwable -> L15
            r22.append(' ');     // Catch: Throwable -> L15
            r22.append(Result.m35exceptionOrNullimpl(r19));     // Catch: Throwable -> L15
            r21.i("AIKernelApi", r22.toString());     // Catch: Throwable -> L15
            return ((Result) r12).m41unboximpl();
        L38:
            r23 = r19;
        L15:
            th = move-exception;
            Throwable r110 = th;
            ?? r28 = r16;
        L43:
            AIKLog.INSTANCE.e("AIKernelApi", "[SDK] updatePackages error: " + r110);
            v1 r29 = (v1) r28.element;
            if (r29 == null) goto L46;
            v1.a.a(r29, null, 1, null);
        L46:
            Result.Companion r30 = Result.Companion;
            return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Got remote error.", r110, 0, 8, null)));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r31 = (Ref.ObjectRef) r10.L$3;
            CoroutineContext r32 = (CoroutineContext) r10.L$2;
            List<PackageResource> r33 = (List) r10.L$1;
            com.obric.aikernel.a r111 = (com.obric.aikernel.a) r10.L$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L41
            List<PackageResource> r112 = r33;
            com.obric.aikernel.a r34 = r111;
            r14 = r31;
        L26:
            Bundle r35 = e8.a.b((Bundle) r12, null, IdlKeys.Method_UpdatePackages, IdlKeys.Call_Type_CallBiz, null, "AIKernelApi", "updatePackages", null, false, 201, null);     // Catch: Throwable -> L41
            r35.putParcelableArray(IdlKeys.Args_Pkgs, (Parcelable[]) r112.toArray(new PackageResource[0]));     // Catch: Throwable -> L41
            r10.L$0 = r34;     // Catch: Throwable -> L41
            r10.L$1 = r32;     // Catch: Throwable -> L41
            r10.L$2 = r14;     // Catch: Throwable -> L41
            r10.L$3 = r35;     // Catch: Throwable -> L41
            r10.label = 2;     // Catch: Throwable -> L41
            final o r36 = new o(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L41
            r36.F();     // Catch: Throwable -> L41
            r14.element = BinderMonitor.f4766a.b(r32, r34, new AIKernelApi$Companion$updatePackages$2$1(r36));     // Catch: Throwable -> L41
            r34.A1(r35, new d(r36));     // Catch: Throwable -> L41
            r12 = r36.B();     // Catch: Throwable -> L41
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L41
        L29:
            if (r12 != r13) goto L31;
            return r13;
        L31:
            r16 = r14;
            goto L32
        L22:
            ResultKt.throwOnFailure(r12);
            AIKLog.INSTANCE.i("AIKernelApi", "[SDK] start updatePackages count:" + r25.size());
            r32 = r10.getContext();
            Ref.ObjectRef r37 = new Ref.ObjectRef();
            ParamsCompat r38 = ParamsCompat.f4752a;     // Catch: Throwable -> L41
            r34 = r24;
            r10.L$0 = r34;     // Catch: Throwable -> L41
            r112 = r25;
            r10.L$1 = r112;     // Catch: Throwable -> L41
            r10.L$2 = r32;     // Catch: Throwable -> L41
            r10.L$3 = r37;     // Catch: Throwable -> L41
            r10.label = 1;     // Catch: Throwable -> L41
            r12 = r38.f(r26, r10);     // Catch: Throwable -> L41
            r14 = r37;
            if (r12 != r13) goto L26;
            return r13;
        L41:
            th = move-exception;
            r110 = th;
            r28 = r14;
        L7:
            r10 = new AIKernelApi$Companion$updatePackages$1(this, r27);
            goto L8
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class a extends AbstractCoroutineContextElement implements h0 {
        public a(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            AIKLog.INSTANCE.e("AIKernelApi", r10 + " crashed " + r11);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$clearAIKernelData$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 1, 1, 1, 1, 1}, l = {325, 598}, m = "clearAIKernelData", n = {"params", "binding", "binder", "formatBundle", "ctx", "monitorTask"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C03781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C03781(AIKernelApi r10, Continuation<? super C03781> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clearAIKernelData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2", f = "AIKernelApi.kt", i = {}, l = {302, 305, 306}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AbsApi>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ boolean $useCloud;
        Object L$0;
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass2(boolean r10, String r11, AIKernelApi r12, RequestParams r13, Continuation<? super AnonymousClass2> r14) {
            this.$useCloud = r10;
            this.$name = r11;
            this.this$0 = r12;
            this.$params = r13;
            super(1, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass2(this.$useCloud, this.$name, this.this$0, this.$params, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super AbsApi> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super AbsApi> r10) {
            return ((AnonymousClass2) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            ServiceConnector r12 = null;
            if (r11 == 0) goto L16;
            if (r11 == 1) goto L15;
            if (r11 == 2) goto L14;
            if (r11 != 3) goto L13;
            Closeable r14 = (Closeable) this.L$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L10
        L39:
            Companion.a r15 = (Companion.a) r13;     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r14, null);
            Companion.a r16 = r15;
        L47:
            if (r16 != null) goto L50;
            return null;
        L50:
            if (this.this$0.k() == true) goto L59;
            if (r16.b() == Companion.ExecutionBinderSource.CHILD_PROCESS) goto L59;
            ServiceConnector r17 = AIKernelApi.a(this.this$0);
            if (r17 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("connector");
        L57:
            r12.B();
            goto L59
        L56:
            r12 = r17;
        L59:
            return new ScriptBizApi(this.$name, this.$params, r16.a(), AIKernelApi.e(this.this$0), r16.c());
        L10:
            th = th;
        L60:
            throw th;     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            CloseableKt.closeFinally(r14, th);
            throw th;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r13);
        L32:
            ServiceConnector.b r18 = (ServiceConnector.b) r13;
            if (r18 != null) goto L34;
        L28:
            r16 = null;
            goto L47
        L34:
            String r19 = this.$name;
            RequestParams r20 = this.$params;
            Companion r21 = AIKernelApi.f4813h;     // Catch: Throwable -> L41
            com.obric.aikernel.a r22 = r18.a();     // Catch: Throwable -> L41
            this.L$0 = r18;     // Catch: Throwable -> L41
            this.label = 3;     // Catch: Throwable -> L41
            Object r23 = r21.b(r22, r19, r20, this);     // Catch: Throwable -> L41
            if (r23 != r10) goto L38;
            return r10;
        L38:
            r14 = r18;
            r13 = r23;
        L41:
            th = th;
            r14 = r18;
            goto L60
        L15:
            ResultKt.throwOnFailure(r13);
        L25:
            com.obric.aikernel.a r110 = (com.obric.aikernel.a) r13;
            if (r110 == null) goto L28;
            r16 = new Companion.a(r110, null);
            goto L47
        L16:
            ResultKt.throwOnFailure(r13);
            if (this.$useCloud == true) goto L19;
            boolean r111 = this.this$0.k();
            AIKernelApi r24 = this.this$0;
            if (r111 == false) goto L29;
            this.label = 1;
            r13 = AIKernelApi.j(r24, 0, this, 1, null);
            if (r13 != r10) goto L25;
            return r10;
        L29:
            this.label = 2;
            r13 = AIKernelApi.m(r24, 0, this, 1, null);
            if (r13 != r10) goto L32;
            return r10;
        L19:
            return new CloudBizApi(this.$name);
        }
    }

    static {
        f4813h = new Companion(null);
    }

    public AIKernelApi() {
        this(AnonymousClass1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIKernelApi(Function3<? super Context, ? super AIKernelConfig, ? super ComponentName, ServiceConnector> r10) {
        Intrinsics.checkNotNullParameter(r10, "serviceConnectorFactory");
        this.f4816c = y.b(null, 1, null);
        this.f4817d = m0.a(z0.b().plus(q2.b(null, 1, null)).plus(new a(h0.f10523d)));
        this.f4818e = true;
        this.f4819f = IAIKernelManager.PACKAGE_NAME_AIK;
        this.f4814a = r10;
    }

    public static final /* synthetic */ ServiceConnector a(AIKernelApi r10) {
        return r10.f4815b;
    }

    public static final /* synthetic */ w b(AIKernelApi r10) {
        return r10.f4816c;
    }

    public static final /* synthetic */ Object c(AIKernelApi r10, List r11, RequestParams r12, Continuation r13) {
        return r10.n(r11, r12, r13);
    }

    public static final /* synthetic */ Object d(AIKernelApi r10, String r11, RequestParams r12, Continuation r13) {
        return r10.o(r11, r12, r13);
    }

    public static final /* synthetic */ String e(AIKernelApi r10) {
        return r10.f4819f;
    }

    public static final /* synthetic */ l0 f(AIKernelApi r10) {
        return r10.f4817d;
    }

    public static final /* synthetic */ Object g(AIKernelApi r10, PackageResource r11, RequestParams r12, Continuation r13) {
        return r10.s(r11, r12, r13);
    }

    public static final /* synthetic */ Object h(AIKernelApi r10, List r11, RequestParams r12, Continuation r13) {
        return r10.t(r11, r12, r13);
    }

    public static /* synthetic */ Object j(AIKernelApi r10, long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 5000;
    L6:
        return r10.i(r11, r12);
    }

    public static /* synthetic */ Object m(AIKernelApi r10, long r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 5000;
    L6:
        return r10.l(r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    private final Object n(List<String> r16, RequestParams r17, Continuation<? super Result<? extends List<PackageResource>>> r18) {
        AIKernelApi r10 = this;
        if ((r18 instanceof AIKernelApi$getPackageInfos$1) == false) goto L7;
        AIKernelApi$getPackageInfos$1 r11 = (AIKernelApi$getPackageInfos$1) r18;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackageInfos$1 r13 = r11;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r19 = r13.label;
        boolean r110 = true;
        if (r19 == 0) goto L20;
        if (r19 == 1) goto L19;
        if (r19 != 2) goto L18;
        Closeable r20 = (Closeable) r13.L$2;
        RequestParams r21 = (RequestParams) r13.L$1;
        List<String> r22 = (List) r13.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        Object r23 = ((Result) r14).m41unboximpl();     // Catch: Throwable -> L15
        r19 = r20;
    L36:
        if (Result.m38isFailureimpl(r23) == false) goto L38;
        AIKLog.INSTANCE.w("AIKernelApi", "[SDK] getPackageInfos binder ready but rpc failed, names=" + r22 + ", traceId=" + r21.getTraceIdStr() + ", error=" + Result.m35exceptionOrNullimpl(r23));     // Catch: Throwable -> L15
    L38:
        CloseableKt.closeFinally(r19, null);
        return r23;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        RequestParams r24 = (RequestParams) r13.L$2;
        List<String> r25 = (List) r13.L$1;
        AIKernelApi r26 = (AIKernelApi) r13.L$0;
        ResultKt.throwOnFailure(r14);
        RequestParams r111 = r24;
        List<String> r112 = r25;
        r10 = r26;
    L23:
        ServiceConnector.b r27 = (ServiceConnector.b) r14;
        if (r27 != null) goto L31;
        AIKLog r28 = AIKLog.INSTANCE;
        StringBuilder r29 = new StringBuilder();
        r29.append("[SDK] getPackageInfos binder is null, names=");
        r29.append(r112);
        r29.append(", traceId=");
        r29.append(r111.getTraceIdStr());
        r29.append(", connectorInited=");
        if (r10.f4815b != null) goto L29;
        r110 = false;
    L29:
        r29.append(r110);
        r29.append(", hasConnectedOnce=");
        r29.append(r10.f4820g);
        r28.e("AIKernelApi", r29.toString());
        Result.Companion r30 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Binder not ready.", null, 0, 12, null)));
    L31:
        Companion r31 = f4813h;     // Catch: Throwable -> L15
        com.obric.aikernel.a r32 = r27.a();     // Catch: Throwable -> L15
        r13.L$0 = r112;     // Catch: Throwable -> L15
        r13.L$1 = r111;     // Catch: Throwable -> L15
        r13.L$2 = r27;     // Catch: Throwable -> L15
        r13.label = 2;     // Catch: Throwable -> L15
        r23 = r31.a(r32, r112, r111, r13);     // Catch: Throwable -> L15
        if (r23 != r15) goto L34;
        return r15;
    L34:
        r22 = r112;
        r21 = r111;
        r19 = r27;
        goto L36
    L20:
        ResultKt.throwOnFailure(r14);
        r13.L$0 = r10;
        r112 = r16;
        r13.L$1 = r112;
        r111 = r17;
        r13.L$2 = r111;
        r13.label = 1;
        r14 = m(this, 0, r13, 1, null);
        if (r14 != r15) goto L23;
        return r15;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);
        throw th;
    L7:
        r11 = new AIKernelApi$getPackageInfos$1(this, r18);
        goto L8
    }

    private final Object o(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelApi$getPackageResource$1) == false) goto L7;
        AIKernelApi$getPackageResource$1 r13 = (AIKernelApi$getPackageResource$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        Object r18 = null;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).m41unboximpl();
    L20:
        if (Result.m39isSuccessimpl(r19) == false) goto L31;
        Result.Companion r20 = Result.Companion;
        if (Result.m38isFailureimpl(r19) == true) goto L25;
        r18 = r19;
    L25:
        List r21 = (List) r18;
        if (r21 == null) goto L30;
        Object r22 = (PackageResource) CollectionsKt.first(r21);
        if (r22 == null) goto L30;
    L33:
        return Result.m32constructorimpl(r22);
    L30:
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(108, "call success but got null!", null, 0, 12, null)));
    L31:
        Result.Companion r23 = Result.Companion;
        r22 = ResultKt.createFailure(AIKernelException.Companion.a(r19));
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<String> r24 = CollectionsKt.listOf(r10);
        r13.label = 1;
        r19 = n(r24, r11, r13);
        if (r19 != r16) goto L20;
        return r16;
    L35:
        throw new NotImplementedError(null, 1, null);
    L7:
        r13 = new AIKernelApi$getPackageResource$1(this, r12);
        goto L8
    }

    public static /* synthetic */ void q(AIKernelApi r10, AIKernelConfig r11, ILog r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.p(r11, r12);
    }

    private final long r(long r10) {
        return Math.max(r10 - System.currentTimeMillis(), 0);
    }

    private final Object s(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelApi$updatePackageInner$1) == false) goto L7;
        AIKernelApi$updatePackageInner$1 r13 = (AIKernelApi$updatePackageInner$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        Object r18 = null;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
        Object r19 = ((Result) r15).m41unboximpl();
    L20:
        if (Result.m39isSuccessimpl(r19) == false) goto L31;
        Result.Companion r20 = Result.Companion;
        if (Result.m38isFailureimpl(r19) == true) goto L25;
        r18 = r19;
    L25:
        List r21 = (List) r18;
        if (r21 == null) goto L30;
        Object r22 = (PackageResource) CollectionsKt.first(r21);
        if (r22 == null) goto L30;
    L33:
        return Result.m32constructorimpl(r22);
    L30:
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(108, "call success but got null!", null, 0, 12, null)));
    L31:
        Result.Companion r23 = Result.Companion;
        r22 = ResultKt.createFailure(AIKernelException.Companion.a(r19));
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r11.getUseLocalPapaya() == true) goto L35;
        List<PackageResource> r24 = CollectionsKt.listOf(r10);
        r13.label = 1;
        r19 = t(r24, r11, r13);
        if (r19 != r16) goto L20;
        return r16;
    L35:
        throw new NotImplementedError(null, 1, null);
    L7:
        r13 = new AIKernelApi$updatePackageInner$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.obric.aikernel.phx.sdk.api.AIKernelApi] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.Closeable] */
    private final Object t(List<PackageResource> r11, RequestParams r12, Continuation<? super Result<? extends List<PackageResource>>> r13) {
        if ((r13 instanceof AIKernelApi$updatePackages$1) == false) goto L7;
        AIKernelApi$updatePackages$1 r10 = (AIKernelApi$updatePackages$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        Closeable r18 = (Closeable) r10.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        Object r19 = ((Result) r15).m41unboximpl();     // Catch: Throwable -> L15
        AIKernelApi this = r18;
    L28:
        CloseableKt.closeFinally(this, null);
        return r19;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r12 = (RequestParams) r10.L$1;
        r11 = (List) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L23:
        ServiceConnector.b r110 = (ServiceConnector.b) r15;
        if (r110 == null) goto L33;
        Companion r111 = f4813h;     // Catch: Throwable -> L15
        com.obric.aikernel.a r20 = r110.a();     // Catch: Throwable -> L15
        r10.L$0 = r110;     // Catch: Throwable -> L15
        r10.L$1 = null;     // Catch: Throwable -> L15
        r10.label = 2;     // Catch: Throwable -> L15
        r19 = r111.c(r20, r11, r12, r10);     // Catch: Throwable -> L15
        this = r110;
        if (r19 != r16) goto L28;
        return r16;
    L33:
        Result.Companion r112 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Binder is null.", null, 0, 12, null)));
    L20:
        ResultKt.throwOnFailure(r15);
        AIKLog.INSTANCE.i("AIKernelApi", "[SDK] updatePackages count:" + r11.size());
        r10.L$0 = r11;
        r10.L$1 = r12;
        r10.label = 1;
        r15 = m(this, 0, r10, 1, null);
        if (r15 != r16) goto L23;
        return r16;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(this, th);
        throw th;
    L7:
        r10 = new AIKernelApi$updatePackages$1(this, r13);
        goto L8
    }

    private final Object u(long r10, Continuation<? super ServiceConnector> r11) {
        ServiceConnector r12 = this.f4815b;
        if (r12 == null) goto L8;
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("connector");
        return null;
    L9:
        return r12;
    L8:
        return TimeoutKt.d(r10, new AIKernelApi$waitForConnector$3(this, null), r11);
    }

    public static /* synthetic */ Object w(AIKernelApi r10, RequestParams r11, com.obric.aikernel.a r12, Function1 r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.v(r11, r12, r13, r14);
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [T, kotlinx.coroutines.v1] */
    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof C03781) == false) goto L7;
        C03781 r10 = (C03781) r23;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        Ref.ObjectRef r15 = (Ref.ObjectRef) r10.L$4;
        CoroutineContext r16 = (CoroutineContext) r10.L$3;
        Bundle r17 = (Bundle) r10.L$2;
        com.obric.aikernel.a r18 = (com.obric.aikernel.a) r10.L$1;
        ServiceConnector.b r19 = (ServiceConnector.b) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L36:
        v1 r20 = (v1) r15.element;     // Catch: RemoteException -> L47
        if (r20 == null) goto L39;
        v1.a.a(r20, null, 1, null);     // Catch: RemoteException -> L47
    L39:
        r19.close();     // Catch: RemoteException -> L47
    L50:
        return Unit.INSTANCE;
    L15:
        th = th;
    L42:
        v1 r21 = (v1) r15.element;     // Catch: RemoteException -> L47
        if (r21 == null) goto L45;
        v1.a.a(r21, null, 1, null);     // Catch: RemoteException -> L47
    L45:
        r19.close();     // Catch: RemoteException -> L47
        throw th;     // Catch: RemoteException -> L47
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        RequestParams r24 = (RequestParams) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L24:
        ServiceConnector.b r25 = (ServiceConnector.b) r12;
        if (r25 != null) goto L28;
        AIKLog.INSTANCE.d("AIKernelApi", "binder is not ready.");
        return Unit.INSTANCE;
    L28:
        com.obric.aikernel.a r26 = r25.a();
        Bundle r27 = e8.a.b(r24.start(), "", IdlKeys.Method_ClearData, IdlKeys.Call_Type_CallBiz, "", "AIKernelApi", "clearAIKernelData", null, false, 192, null);     // Catch: RemoteException -> L47
        AIKLog.INSTANCE.i("AIKernelApi", "[SDK] clearAIKernelData formatBundle:" + r27);     // Catch: RemoteException -> L47
        CoroutineContext r28 = r10.getContext();     // Catch: RemoteException -> L47
        Ref.ObjectRef r110 = new Ref.ObjectRef();     // Catch: RemoteException -> L47
        r10.L$0 = r25;     // Catch: Throwable -> L40
        r10.L$1 = r26;     // Catch: Throwable -> L40
        r10.L$2 = r27;     // Catch: Throwable -> L40
        r10.L$3 = r28;     // Catch: Throwable -> L40
        r10.L$4 = r110;     // Catch: Throwable -> L40
        r10.label = 2;     // Catch: Throwable -> L40
        final o r29 = new o(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L40
        r29.F();     // Catch: Throwable -> L40
        r110.element = BinderMonitor.f4766a.b(r28, r26, new AIKernelApi$clearAIKernelData$2$1(r29));     // Catch: Throwable -> L40
        r26.A1(r27, new AIKernelApi$clearAIKernelData$2$2(r29));     // Catch: Throwable -> L40
        Object r30 = r29.B();     // Catch: Throwable -> L40
        if (r30 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L40
    L33:
        if (r30 != r13) goto L35;
        return r13;
    L35:
        r19 = r25;
        r15 = r110;
    L40:
        th = th;
        r19 = r25;
        r15 = r110;
        goto L42
    L20:
        ResultKt.throwOnFailure(r12);
        r10.L$0 = r22;
        r10.label = 1;
        Object r31 = l(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER, r10);
        if (r31 != r13) goto L23;
        return r13;
    L23:
        r12 = r31;
        r24 = r22;
    L47:
        e = move-exception;
        AIKLog.INSTANCE.e("AIKernelApi", "clearAIKernelData error: " + e);
    L7:
        r10 = new C03781(this, r23);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    public Object mo23getPackage0E7RQCE(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelApi$getPackage$1) == false) goto L7;
        AIKernelApi$getPackage$1 r13 = (AIKernelApi$getPackage$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackage$1 r15 = r13;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        Result r19 = (Result) r16;
        if (r19 != null) goto L22;
        Result.Companion r20 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null)));
    L22:
        return r19.m41unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        AIKernelApi$getPackage$2 r21 = new AIKernelApi$getPackage$2(this, r10, r11, null);
        r15.label = 1;
        r16 = w(this, r11, null, r21, r15, 2, null);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r13 = new AIKernelApi$getPackage$1(this, r12);
        goto L8
    }

    public final Object i(long r19, Continuation<? super com.obric.aikernel.a> r21) {
        AIKernelApi r10 = this;
        if ((r21 instanceof AIKernelApi$getBinder$1) == false) goto L7;
        AIKernelApi$getBinder$1 r11 = (AIKernelApi$getBinder$1) r21;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        r10 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L44:
        com.obric.aikernel.a r16 = (com.obric.aikernel.a) r13;
        if (r16 == null) goto L50;
        r10.f4820g = true;
        return r16;
    L50:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r17 = r11.J$1;
        long r18 = r11.J$0;
        ServiceConnector r20 = (ServiceConnector) r11.L$1;
        AIKernelApi r22 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
        long r110 = r18;
        long r111 = r17;
        r10 = r22;
    L30:
        com.obric.aikernel.a r23 = (com.obric.aikernel.a) r13;
        if (r23 == null) goto L35;
        r10.f4820g = true;
        return r23;
    L35:
        if (r110 != 5000) goto L37;
        boolean r24 = true;
    L39:
        if (r10.f4820g == true) goto L48;
        if (r24 == false) goto L49;
        AIKLog.INSTANCE.w("AIKernelApi", "binder not ready in " + r111 + "ms, retry with first-connect timeout.");
        r11.L$0 = r10;
        r11.L$1 = null;
        r11.label = 3;
        r13 = r20.u(15000, r11);
        if (r13 != r14) goto L44;
        return r14;
    L49:
        return null;
    L48:
        return null;
    L37:
        r24 = false;
        goto L39
    L17:
        long r25 = r11.J$2;
        r111 = r11.J$1;
        r110 = r11.J$0;
        AIKernelApi r26 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
        Object r27 = r13;
        r10 = r26;
        long r28 = r25;
    L22:
        ServiceConnector r29 = (ServiceConnector) r27;
        if (r29 != null) goto L26;
        AIKLog.INSTANCE.w("AIKernelApi", "connector not initialized within " + r111 + "ms");
        return null;
    L26:
        long r30 = r10.r(r28);
        r11.L$0 = r10;
        r11.L$1 = r29;
        r11.J$0 = r110;
        r11.J$1 = r111;
        r11.label = 2;
        r13 = r29.u(r30, r11);
        if (r13 != r14) goto L29;
        return r14;
    L29:
        r20 = r29;
        goto L30
    L18:
        ResultKt.throwOnFailure(r13);
        r111 = Math.max(r19, 0);
        long r112 = System.currentTimeMillis() + r111;
        long r31 = r10.r(r112);
        r11.L$0 = r10;
        r11.J$0 = r19;
        r11.J$1 = r111;
        r11.J$2 = r112;
        r11.label = 1;
        r27 = r10.u(r31, r11);
        if (r27 != r14) goto L21;
        return r14;
    L21:
        r28 = r112;
        r110 = r19;
    L7:
        r11 = new AIKernelApi$getBinder$1(r10, r21);
        goto L8
    }

    public final boolean k() {
        return this.f4818e;
    }

    public final Object l(long r19, Continuation<? super ServiceConnector.b> r21) {
        AIKernelApi r10 = this;
        if ((r21 instanceof AIKernelApi$getMainProcessIpcBinding$1) == false) goto L7;
        AIKernelApi$getMainProcessIpcBinding$1 r11 = (AIKernelApi$getMainProcessIpcBinding$1) r21;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        r10 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L44:
        ServiceConnector.b r16 = (ServiceConnector.b) r13;
        if (r16 == null) goto L50;
        r10.f4820g = true;
        return r16;
    L50:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r17 = r11.J$1;
        long r18 = r11.J$0;
        ServiceConnector r20 = (ServiceConnector) r11.L$1;
        AIKernelApi r22 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
        long r110 = r18;
        long r111 = r17;
        r10 = r22;
    L30:
        ServiceConnector.b r23 = (ServiceConnector.b) r13;
        if (r23 == null) goto L35;
        r10.f4820g = true;
        return r23;
    L35:
        if (r110 != 5000) goto L37;
        boolean r24 = true;
    L39:
        if (r10.f4820g == true) goto L48;
        if (r24 == false) goto L49;
        AIKLog.INSTANCE.w("AIKernelApi", "binder not ready in " + r111 + "ms, retry with first-connect timeout.");
        r11.L$0 = r10;
        r11.L$1 = null;
        r11.label = 3;
        r13 = r20.v(15000, r11);
        if (r13 != r14) goto L44;
        return r14;
    L49:
        return null;
    L48:
        return null;
    L37:
        r24 = false;
        goto L39
    L17:
        long r25 = r11.J$2;
        r111 = r11.J$1;
        r110 = r11.J$0;
        AIKernelApi r26 = (AIKernelApi) r11.L$0;
        ResultKt.throwOnFailure(r13);
        Object r27 = r13;
        r10 = r26;
        long r28 = r25;
    L22:
        ServiceConnector r29 = (ServiceConnector) r27;
        if (r29 != null) goto L26;
        AIKLog.INSTANCE.w("AIKernelApi", "connector not initialized within " + r111 + "ms");
        return null;
    L26:
        long r30 = r10.r(r28);
        r11.L$0 = r10;
        r11.L$1 = r29;
        r11.J$0 = r110;
        r11.J$1 = r111;
        r11.label = 2;
        r13 = r29.v(r30, r11);
        if (r13 != r14) goto L29;
        return r14;
    L29:
        r20 = r29;
        goto L30
    L18:
        ResultKt.throwOnFailure(r13);
        r111 = Math.max(r19, 0);
        long r112 = System.currentTimeMillis() + r111;
        long r31 = r10.r(r112);
        r11.L$0 = r10;
        r11.J$0 = r19;
        r11.J$1 = r111;
        r11.J$2 = r112;
        r11.label = 1;
        r27 = r10.u(r31, r11);
        if (r27 != r14) goto L21;
        return r14;
    L21:
        r28 = r112;
        r110 = r19;
    L7:
        r11 = new AIKernelApi$getMainProcessIpcBinding$1(r10, r21);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r10, boolean r11, RequestParams r12, Continuation<? super IBaseModel> r13) {
        return w(this, r12, null, new AnonymousClass2(r11, r10, this, r12, null), r13, 2, null);
    }

    public final synchronized void p(AIKernelConfig r11, ILog r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "config");     // Catch: Throwable -> L60
        if (this.f4815b == null) goto L8;
        AIKLog.INSTANCE.d("AIKernelApi", "sdk is already inited!");     // Catch: Throwable -> L60
        monitor-exit(this);
        return;
    L8:
        f7.a r10 = f7.a.f8866a;     // Catch: Throwable -> L60
        r10.d(r11);     // Catch: Throwable -> L60
        r10.e("3.1.9");     // Catch: Throwable -> L60
        r10.f(r11.getAuthBySign());     // Catch: Throwable -> L60
        if (r12 == null) goto L11;
        AIKLog.INSTANCE.registerLog(r12);     // Catch: Throwable -> L60
    L11:
        ComponentName r13 = new ComponentName(IAIKernelManager.PACKAGE_NAME_AIK, IAIKernelManager.SERVICE_NAME);     // Catch: Throwable -> L60
        String r14 = IAIKernelManager.PACKAGE_NAME_AIK;
        boolean r15 = true;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L35
        ComponentName r17 = new ComponentName(IAIKernelManager.PACKAGE_NAME_ASSIST, IAIKernelManager.SERVICE_NAME);     // Catch: Throwable -> L35
        PackageManager r18 = r11.getContext().getPackageManager();     // Catch: Throwable -> L35
        Intent r19 = new Intent();     // Catch: Throwable -> L35
        r19.setComponent(r17);     // Catch: Throwable -> L35
        List<ResolveInfo> r20 = r18.queryIntentServices(r19, 131072);     // Catch: Throwable -> L35
        if (r20 != null) goto L16;
    L19:
        boolean r21 = true;
    L20:
        if (r21 == false) goto L66;
        PackageInfo r22 = r11.getContext().getPackageManager().getPackageInfo(IAIKernelManager.PACKAGE_NAME_AIK, 0);     // Catch: Throwable -> L35
        if (r22 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r22, "getPackageInfo(IAIKernel…ager.PACKAGE_NAME_AIK, 0)");     // Catch: Throwable -> L35
        if (r22.getLongVersionCode() < 200000999) goto L26;
        this.f4818e = false;     // Catch: Throwable -> L35
    L26:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L31:
        Object r24 = Result.m32constructorimpl(r23);     // Catch: Throwable -> L35
    L37:
        Throwable r25 = Result.m35exceptionOrNullimpl(r24);     // Catch: Throwable -> L60
        if (r25 == null) goto L40;
        AIKLog.INSTANCE.e("AIKernelApi", "getServicePackageInfo failed: " + ExceptionsKt.stackTraceToString(r25));     // Catch: Throwable -> L60
    L40:
        ServiceConnector r110 = this.f4814a.invoke(r11.getContext(), r11, r13);     // Catch: Throwable -> L60
        this.f4815b = r110;     // Catch: Throwable -> L60
        if (r110 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("connector");     // Catch: Throwable -> L60
        r110 = null;
    L44:
        if (this.f4818e == false) goto L47;
        r15 = false;
    L47:
        r110.A(r15);     // Catch: Throwable -> L60
        this.f4819f = r14;     // Catch: Throwable -> L60
        if (this.f4816c.a() == true) goto L54;
        w<ServiceConnector> r111 = this.f4816c;     // Catch: Throwable -> L60
        ServiceConnector r26 = this.f4815b;     // Catch: Throwable -> L60
        if (r26 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("connector");     // Catch: Throwable -> L60
        r26 = null;
    L52:
        r111.K(r26);     // Catch: Throwable -> L60
    L54:
        if (r11.getBindRemoteOnInit() == false) goto L56;
        h.d(this.f4817d, null, null, new AIKernelApi$init$5(this, null), 3, null);     // Catch: Throwable -> L60
    L57:
        AIKLog.INSTANCE.i("AIKernelApi", "initialize success.");     // Catch: Throwable -> L60
        monitor-exit(this);
        return;
    L56:
        AIKLog.INSTANCE.d("AIKernelApi", "skip remote bind on init by config.");     // Catch: Throwable -> L60
        goto L57
    L28:
        r23 = null;
        goto L31
    L66:
        r14 = IAIKernelManager.PACKAGE_NAME_ASSIST;
        this.f4818e = false;     // Catch: Throwable -> L33
        r23 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r13 = r17;
    L33:
        th = move-exception;
        th = th;
        r13 = r17;
    L36:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L60
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L37
    L16:
        if (r20.isEmpty() == true) goto L19;
        r21 = false;
    L35:
        th = th;
    L60:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    public Object mo24updatePackage0E7RQCE(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12) {
        if ((r12 instanceof AIKernelApi$updatePackage$1) == false) goto L7;
        AIKernelApi$updatePackage$1 r13 = (AIKernelApi$updatePackage$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        AIKernelApi$updatePackage$1 r15 = r13;
        Object r16 = r15.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r15.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        Result r19 = (Result) r16;
        if (r19 != null) goto L22;
        Result.Companion r20 = Result.Companion;
        return Result.m32constructorimpl(ResultKt.createFailure(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null)));
    L22:
        return r19.m41unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        AIKernelApi$updatePackage$2 r21 = new AIKernelApi$updatePackage$2(this, r10, r11, null);
        r15.label = 1;
        r16 = w(this, r11, null, r21, r15, 2, null);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r13 = new AIKernelApi$updatePackage$1(this, r12);
        goto L8
    }

    public final <T> Object v(final RequestParams r10, final com.obric.aikernel.a r11, Function1<? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        long r14 = r10.getTimeout();
        final r0 r15 = h.b(this.f4817d, null, null, new AIKernelApi$wrapApiCall$ipcJob$1(r10, r12, null), 3, null);
        v1 r16 = (v1) r13.getContext().get(v1.f10723e);
        if (r16 == null) goto L6;
        r16.A(new AIKernelApi$wrapApiCall$2(this, r15, r10, r11));
    L6:
        if (r14 <= 0) goto L9;
        return TimeoutKt.d(r14, new AIKernelApi$wrapApiCall$3$1(r15, null), r13);
    L9:
        return r15.r(r13);
    }
}
