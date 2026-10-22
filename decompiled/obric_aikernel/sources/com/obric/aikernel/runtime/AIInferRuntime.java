package com.obric.aikernel.runtime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.google.gson.k;
import com.obric.aee.ExecutionEngine;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.model.device.UnNamedExceptionStrategy;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.installer.FusionInstaller;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.config.DistConfig;
import com.obric.aikernel.res.metadata.config.UpdateTaskConfig;
import com.obric.aikernel.res.metadata.data.AIModel;
import com.obric.aikernel.res.metadata.data.AIPackage;
import com.obric.aikernel.res.metadata.data.Lora;
import com.obric.aikernel.res.task.StorageCleanerDaemon;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.runtime.subproc.MainHost;
import com.obric.aikernel.runtime.subproc.SubProcHost;
import com.obric.aikernel.runtime.utils.RuntimeMetrics;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AIInferRuntime {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f5235t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Set<String> f5236u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f5237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l0 f5238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f5239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UnNamedExceptionStrategy f5240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MainHost f5241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SubProcHost f5242f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PackageResourceManager f5243g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final VmEngine f5244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, PackageWrapper> f5245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, PackageWrapper> f5246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CoroutineDispatcher f5247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CoroutineDispatcher f5248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ConcurrentHashMap<String, g> f5249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private v1 f5250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AIInferRuntime$screenOffListener$1 f5251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final h f5252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final r0<Unit> f5253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private r0<Boolean> f5254r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f5255s;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$3, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$3", f = "AIInferRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<List<? extends com.obric.aikernel.res.installer.a.b>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AIInferRuntime this$0;

        AnonymousClass3(AIInferRuntime r10, Continuation<? super AnonymousClass3> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass3 r12 = new AnonymousClass3(this.this$0, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends com.obric.aikernel.res.installer.a.b> r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<com.obric.aikernel.res.installer.a.b> r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            List<com.obric.aikernel.res.installer.a.b> r11 = (List) this.L$0;
            c r12 = this.this$0.R().a();
            if (r12 == null) goto L8;
            r12.i(r11);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final String a(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            return r10.getString("loraType");
        }

        public final Set<String> b() {
            return AIInferRuntime.s();
        }

        public final <T> Object c(Function1<? super Continuation<? super T>, ? extends Object> r10, Function1<? super Long, Unit> r11, Continuation<? super T> r12) {
            if ((r12 instanceof AIInferRuntime$Companion$measureElapseTime$1) == false) goto L7;
            AIInferRuntime$Companion$measureElapseTime$1 r13 = (AIInferRuntime$Companion$measureElapseTime$1) r12;
            int r14 = r13.label;
            if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
            r13.label = r14 - Integer.MIN_VALUE;
        L8:
            Object r15 = r13.result;
            Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r17 = r13.label;
            if (r17 == 0) goto L14;
            if (r17 != 1) goto L13;
            long r18 = r13.J$0;
            Function1<? super Long, Unit> r19 = (Function1) r13.L$0;
            ResultKt.throwOnFailure(r15);
        L18:
            if (r19 == null) goto L20;
            r19.invoke(Boxing.boxLong(SystemClock.elapsedRealtime() - r18));
        L20:
            return r15;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r15);
            long r20 = SystemClock.elapsedRealtime();
            r13.L$0 = r11;
            r13.J$0 = r20;
            r13.label = 1;
            r15 = r10.invoke(r13);
            if (r15 != r16) goto L17;
            return r16;
        L17:
            r19 = r11;
            r18 = r20;
        L7:
            r13 = new AIInferRuntime$Companion$measureElapseTime$1(this, r12);
            goto L8
        }
    }

    public static final class PackageWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AIPackage f5256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PackageResource f5257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Lora f5258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Function1<Continuation<? super y6.b>, Object> f5259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final l0 f5260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final CoroutineDispatcher f5261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Long f5262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final UnNamedExceptionStrategy f5263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Long f5264i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile r0<Result<y6.b>> f5265j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private volatile Result<y6.b> f5266k;

        /* JADX WARN: Multi-variable type inference failed */
        public PackageWrapper(AIPackage r10, PackageResource r11, Lora r12, Function1<? super Continuation<? super y6.b>, ? extends Object> r13, l0 r14, CoroutineDispatcher r15, Long r16, UnNamedExceptionStrategy r17) {
            Intrinsics.checkNotNullParameter(r10, "src");
            Intrinsics.checkNotNullParameter(r11, "sdkPkg");
            Intrinsics.checkNotNullParameter(r14, "asyncScope");
            Intrinsics.checkNotNullParameter(r15, "vmPkgDispatcher");
            Intrinsics.checkNotNullParameter(r17, "unNamedExceptionStrategy");
            this.f5256a = r10;
            this.f5257b = r11;
            this.f5258c = r12;
            this.f5259d = r13;
            this.f5260e = r14;
            this.f5261f = r15;
            this.f5262g = r16;
            this.f5263h = r17;
        }

        public /* synthetic */ PackageWrapper(AIPackage r12, PackageResource r13, Lora r14, Function1 r15, l0 r16, CoroutineDispatcher r17, Long r18, UnNamedExceptionStrategy r19, int r20, DefaultConstructorMarker r21) {
            if ((r20 & 4) == 0) goto L5;
            Lora r10 = null;
        L7:
            if ((r20 & 64) == 0) goto L9;
            Long r11 = null;
        L10:
            this(r12, r13, r10, r15, r16, r17, r11, r19);
            return;
        L9:
            r11 = r18;
            goto L10
        L5:
            r10 = r14;
            goto L7
        }

        public static final /* synthetic */ Long a(PackageWrapper r10) {
            return r10.f5262g;
        }

        public static final /* synthetic */ UnNamedExceptionStrategy b(PackageWrapper r10) {
            return r10.f5263h;
        }

        public static final /* synthetic */ void c(PackageWrapper r10, Long r11) {
            r10.f5264i = r11;
        }

        public final Lora d() {
            return this.f5258c;
        }

        public final Result<y6.b> e() {
            return this.f5266k;
        }

        public final PackageResource f() {
            return this.f5257b;
        }

        public final AIPackage g() {
            return this.f5256a;
        }

        public final Object h(Continuation<? super Pair<Integer, y6.b>> r13) {
            if ((r13 instanceof AIInferRuntime$PackageWrapper$getVmPackageInfo$1) == false) goto L7;
            AIInferRuntime$PackageWrapper$getVmPackageInfo$1 r10 = (AIInferRuntime$PackageWrapper$getVmPackageInfo$1) r13;
            int r11 = r10.label;
            if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
            r10.label = r11 - Integer.MIN_VALUE;
        L8:
            Object r14 = r10.result;
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r15 = r10.label;
            boolean r16 = true;
            Object r17 = null;
            if (r15 == 0) goto L14;
            if (r15 != 1) goto L13;
            PackageWrapper this = (PackageWrapper) r10.L$0;
            ResultKt.throwOnFailure(r14);
        L44:
            Result r18 = (Result) r14;
        L45:
            Result<y6.b> r19 = this.f5266k;
            if (r19 != null) goto L48;
        L50:
            r16 = false;
        L51:
            if (r16 == true) goto L60;
            Integer r20 = Boxing.boxInt(0);
            if (r19 == null) goto L59;
            Object r110 = r19.m41unboximpl();
            if (Result.m38isFailureimpl(r110) == true) goto L58;
            r17 = r110;
        L58:
            r17 = (y6.b) r17;
        L59:
            Pair r111 = new Pair(r20, r17);
        L67:
            return r111;
        L60:
            Throwable r112 = Result.m35exceptionOrNullimpl(r19.m41unboximpl());
            if ((r112 instanceof AIKernelException) == false) goto L64;
            int r113 = ((AIKernelException) r112).getCode();
        L66:
            r111 = new Pair(Boxing.boxInt(r113), null);
            goto L67
        L64:
            if ((r112 instanceof IllegalStateException) == false) goto L68;
            r113 = 202;
            goto L66
        L68:
            if (r112 == null) goto L70;
            throw r112;
        L70:
            throw new NullPointerException("getVmPackageInfo exception should not null!");
        L48:
            if (Result.m39isSuccessimpl(r19.m41unboximpl()) == true) goto L50;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r14);
            monitor-enter(this);
            r0<Result<y6.b>> r114 = this.f5265j;     // Catch: Throwable -> L71
            if (r114 != null) goto L19;
        L21:
            boolean r115 = false;
        L22:
            if (r115 == false) goto L33;
            Result<y6.b> r116 = this.f5266k;     // Catch: Throwable -> L71
            if (r116 == null) goto L29;
            Object r117 = r116.m41unboximpl();     // Catch: Throwable -> L71
            if (Result.m38isFailureimpl(r117) == false) goto L28;
            r117 = null;
        L28:
            y6.b r118 = (y6.b) r117;     // Catch: Throwable -> L71
        L30:
            if (r118 != null) goto L33;
            this.f5265j = null;     // Catch: Throwable -> L71
            goto L33
        L29:
            r118 = null;
        L33:
            if (this.f5265j != null) goto L37;
            Function1<Continuation<? super y6.b>, Object> r119 = this.f5259d;     // Catch: Throwable -> L71
            if (r119 == null) goto L37;
            this.f5265j = kotlinx.coroutines.h.b(this.f5260e, this.f5261f, null, new AIInferRuntime$PackageWrapper$getVmPackageInfo$2$1(r119, this, null), 2, null);     // Catch: Throwable -> L71
        L37:
            Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L71
            monitor-exit(this);
            r0<Result<y6.b>> r121 = this.f5265j;
            if (r121 == null) goto L45;
            r10.L$0 = this;
            r10.label = 1;
            r14 = r121.r(r10);
            if (r14 != r12) goto L44;
            return r12;
        L19:
            if (r114.a() != true) goto L21;
            r115 = true;
        L71:
            th = move-exception;
            throw th;
        L7:
            r10 = new AIInferRuntime$PackageWrapper$getVmPackageInfo$1(this, r13);
            goto L8
        }

        public final boolean i() {
            Long r10 = this.f5264i;
            if (r10 == null) goto L8;
            long r11 = r10.longValue();
            if (SystemClock.elapsedRealtime() > r11) goto L7;
            return false;
        L7:
            return true;
        L8:
            return false;
        }

        public final void j(Result<y6.b> r10) {
            this.f5266k = r10;
        }
    }

    public static final class a implements com.obric.aikernel.res.metadata.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f5267a;

        a(AIInferRuntime r10) {
            this.f5267a = r10;
        }

        @Override // com.obric.aikernel.res.metadata.a
        public void a(AIPackage r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "pkg");
            com.obric.aikernel.runtime.utils.d r12 = com.obric.aikernel.runtime.utils.d.f5417a;
            StringBuilder r13 = new StringBuilder();
            r13.append("onPackageChanged ");
            if (r11 == false) goto L5;
            String r14 = "remove";
        L6:
            r13.append(r14);
            r13.append(' ');
            r13.append(r10.w());
            r13.append('@');
            r13.append(r10.D());
            r12.g("AIInferRuntime", r13.toString());
            AIInferRuntime r15 = this.f5267a;
            if (r11 == false) goto L9;
            AIInferRuntime.x(r15, r10);
            return;
        L9:
            AIInferRuntime.b(r15, r10);
            return;
        L5:
            r14 = "add";
            goto L6
        }
    }

    public static final class b implements PackageResourceManager.PresmConfig.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r0<Unit> f5268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f5269b;

        b(r0<Unit> r10, AIInferRuntime r11) {
            this.f5268a = r10;
            this.f5269b = r11;
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.c
        public Object a(String r10, Continuation<? super Unit> r11) {
            Object r12 = this.f5269b.R().i().a(SetsKt.setOf(r10), r11);
            if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r12;
        L6:
            return Unit.INSTANCE;
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.c
        public void b(List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "packages");
            LinkedHashSet r11 = new LinkedHashSet();
            Map<String, d.C0119d> r12 = this.f5269b.R().f().d();
            if (r12 == null) goto L13;
            Iterator<Map.Entry<String, d.C0119d>> r13 = r12.entrySet().iterator();
        L6:
            if (r13.hasNext() == false) goto L14;
            Map.Entry<String, d.C0119d> r14 = r13.next();
            Iterator<T> r15 = r10.iterator();
        L9:
            if (r15.hasNext() == false) goto L6;
            String r16 = (String) r15.next();
            if (r14.getValue().a(r16) == false) goto L9;
            r11.add(r14.getKey());
        L14:
            this.f5269b.R().i().b(r11);
            return;
        L13:
            r11.add(this.f5269b.R().g());
            goto L14
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.c
        public r0<Unit> c() {
            return this.f5268a;
        }
    }

    public interface c {

        public static final class a {
            public static Integer a(c r10, y6.b r11, RequestParams r12, int r13) {
                Intrinsics.checkNotNullParameter(r11, "pkg");
                Intrinsics.checkNotNullParameter(r12, "params");
                return null;
            }

            public static Pair<Integer, Bundle> b(c r10, y6.b r11, RequestParams r12) {
                Intrinsics.checkNotNullParameter(r11, "pkg");
                Intrinsics.checkNotNullParameter(r12, "params");
                return new Pair(1, null);
            }
        }

        void a(RequestParams r10);

        Integer b(y6.b r10, RequestParams r11, int r12);

        void c(String r10, int r11, String r12, String r13, y6.b r14, String r15);

        Object d(Continuation<? super Unit> r10);

        Object e(Continuation<? super Unit> r10);

        void f(String r10, String r11);

        e g();

        void h();

        void i(List<com.obric.aikernel.res.installer.a.b> r10);

        void j();

        Object k(Continuation<? super Unit> r10);

        void l(y6.b r10);

        Pair<Integer, Bundle> m(y6.b r10, RequestParams r11);

        void notifyVMExecuteBegin(RequestParams r10, Bundle r11);

        void notifyVMExecuteEnd(RequestParams r10);
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f5270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Pair<String, Object>> f5273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final c f5274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Function0<Long> f5275f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Function0<Long> f5276g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final PackageResourceManager.PresmConfig f5277h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c f5278i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final b f5279j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final a f5280k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Map<String, String> f5281l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final String f5282m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @SuppressLint({"NewApi"})
        private final f f5283n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final boolean f5284o;

        public interface a {
            Object a(Set<String> r10, Continuation<? super Unit> r11);

            void b(Set<String> r10);
        }

        public interface b {
            Bundle a(String r10);

            boolean b(String r10);
        }

        public static final class c implements com.obric.aikernel.runtime.utils.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.aikernel.runtime.utils.c f5285a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private MainHost.Proxy f5286b;

            public c(com.obric.aikernel.runtime.utils.c r10) {
                Intrinsics.checkNotNullParameter(r10, "origin");
                this.f5285a = r10;
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void a(String r10, String r11, int r12) {
                Intrinsics.checkNotNullParameter(r10, "tag");
                Intrinsics.checkNotNullParameter(r11, "message");
                this.f5285a.a(r10, r11, r12);
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void aeeLog(int r10, String r11, String r12) {
                Intrinsics.checkNotNullParameter(r11, "tag");
                Intrinsics.checkNotNullParameter(r12, "content");
                this.f5285a.aeeLog(r10, r11, r12);
                MainHost.Proxy r13 = this.f5286b;
                if (r13 == null) goto L6;
                r13.a(r10, r11, r12);
                return;
            }

            @Override // com.obric.aikernel.runtime.utils.c
            public void b(String r10, JSONObject r11) {
                Intrinsics.checkNotNullParameter(r10, "key");
                Intrinsics.checkNotNullParameter(r11, "data");
                this.f5285a.b(r10, r11);
            }

            public final void c(MainHost.Proxy r10) {
                this.f5286b = r10;
            }
        }

        /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$d$d, reason: collision with other inner class name */
        public static final class C0119d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set<String> f5287a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Set<String> f5288b;

            /* JADX WARN: Multi-variable type inference failed */
            public C0119d() {
                Object[] r10 = 0 == true ? 1 : 0;
                this(null, r10, 3, 0 == true ? 1 : 0);
            }

            public C0119d(Set<String> r10, Set<String> r11) {
                this.f5287a = r10;
                this.f5288b = r11;
            }

            public /* synthetic */ C0119d(Set r10, Set r11, int r12, DefaultConstructorMarker r13) {
                if ((r12 & 1) == 0) goto L6;
                r10 = null;
            L6:
                if ((r12 & 2) == 0) goto L8;
                r11 = null;
            L8:
                this(r10, r11);
            }

            public final boolean a(String r10) {
                Intrinsics.checkNotNullParameter(r10, "pkg");
                Set<String> r11 = this.f5287a;
                if (r11 != null) goto L5;
            L7:
                boolean r12 = false;
            L8:
                if (r12 == true) goto L18;
                Set<String> r13 = this.f5288b;
                if (r13 != null) goto L12;
            L14:
                boolean r14 = false;
            L15:
                if (r14 == true) goto L18;
                return true;
            L12:
                if (r13.contains(r10) != true) goto L14;
                r14 = true;
            L18:
                return false;
            L5:
                if (r11.contains(r10) == true) goto L7;
                r12 = true;
                goto L8
            }

            public final Set<String> b() {
                return this.f5287a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Context r10, int r11, boolean r12, List<? extends Pair<String, ? extends Object>> r13, c r14, Function0<Long> r15, Function0<Long> r16, PackageResourceManager.PresmConfig r17, c r18, b r19, a r110, Map<String, C0119d> r111, Map<String, String> r112) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r15, "inferNotResponseTimeMills");
            Intrinsics.checkNotNullParameter(r16, "updateInterval");
            Intrinsics.checkNotNullParameter(r17, "presmConfig");
            this.f5270a = r10;
            this.f5271b = r11;
            this.f5272c = r12;
            this.f5273d = r13;
            this.f5274e = r14;
            this.f5275f = r15;
            this.f5276g = r16;
            this.f5277h = r17;
            this.f5278i = r18;
            this.f5279j = r19;
            this.f5280k = r110;
            this.f5281l = r112;
            String r20 = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(r20, "myProcessName()");
            this.f5282m = r20;
            boolean r21 = true;
            if (r111 == null) goto L36;
            Iterator<T> r22 = r111.entrySet().iterator();
        L6:
            if (r22.hasNext() == false) goto L35;
            Map.Entry r23 = (Map.Entry) r22.next();
            Set<String> r24 = ((C0119d) r23.getValue()).b();
            if (r24 != null) goto L10;
        L12:
            Object[] r25 = false;
        L13:
            if (r25 == false) goto L6;
            String r26 = (String) r23.getKey();
            Iterator<T> r27 = r111.entrySet().iterator();
        L16:
            if (r27.hasNext() == false) goto L33;
            Map.Entry r28 = (Map.Entry) r27.next();
            if (((C0119d) r28.getValue()).a("vlm_local") == false) goto L16;
            String r29 = (String) r28.getKey();
            com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "init config myProcessName:" + this.f5282m + ", mainProcessName:" + r26 + " vlmProc:" + r29);
            Set r30 = null;
            Object[] r31 = 0;
            Object[] r32 = 0;
            if (Intrinsics.areEqual(this.f5282m, r26) == false) goto L28;
            LinkedHashMap r33 = new LinkedHashMap();
            Iterator<Map.Entry<String, C0119d>> r34 = r111.entrySet().iterator();
        L23:
            if (r34.hasNext() == false) goto L27;
            Map.Entry<String, C0119d> r35 = r34.next();
            if (Intrinsics.areEqual(r35.getKey(), r26) == true) goto L23;
            r33.put(r35.getKey(), r35.getValue());
            goto L23
        L27:
            f r36 = new f(r29, true, r33, null);
        L37:
            this.f5283n = r36;
            if (r36.d() == null) goto L41;
            r21 = false;
        L41:
            this.f5284o = r21;
            return;
        L28:
            C0119d r37 = r111.get(this.f5282m);
            if (r37 != null) goto L31;
            r37 = new C0119d(r30, r32 == true ? 1 : 0, 3, r31 == true ? 1 : 0);
        L31:
            r36 = new f(r29, false, null, r37);
            goto L37
        L33:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L10:
            if (r24.isEmpty() != true) goto L12;
            r25 = true;
            goto L13
        L35:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L36:
            r36 = new f(r20, false, null, null, 14, null);
            goto L37
        }

        public final c a() {
            return this.f5274e;
        }

        public final Context b() {
            return this.f5270a;
        }

        public final int c() {
            return this.f5271b;
        }

        public final boolean d() {
            return this.f5272c;
        }

        public final Function0<Long> e() {
            return this.f5275f;
        }

        public final f f() {
            return this.f5283n;
        }

        public final String g() {
            return this.f5282m;
        }

        public final PackageResourceManager.PresmConfig h() {
            return this.f5277h;
        }

        public final a i() {
            return this.f5280k;
        }

        public final List<Pair<String, Object>> j() {
            return this.f5273d;
        }

        public final c k() {
            return this.f5278i;
        }

        public final b l() {
            return this.f5279j;
        }

        public final Function0<Long> m() {
            return this.f5276g;
        }

        public final Map<String, String> n() {
            return this.f5281l;
        }

        public final boolean o() {
            return this.f5284o;
        }
    }

    public interface e {
        int a(int r10);

        void b(int r10);
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<String, d.C0119d> f5291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.C0119d f5292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private MainHost.Proxy f5293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Map<String, SubProcHost.c> f5294f;

        public f(String r10, boolean r11, Map<String, d.C0119d> r12, d.C0119d r13) {
            Intrinsics.checkNotNullParameter(r10, "vlmProcessName");
            this.f5289a = r10;
            this.f5290b = r11;
            this.f5291c = r12;
            this.f5292d = r13;
            this.f5294f = new ConcurrentHashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ f(String r10, boolean r11, Map r12, d.C0119d r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L5;
            r11 = true;
        L5:
            Set r16 = null;
            Object[] r17 = 0;
            Object[] r18 = 0;
            if ((r14 & 4) == 0) goto L9;
            r12 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            r13 = new d.C0119d(r16, r18 == true ? 1 : 0, 3, r17 == true ? 1 : 0);
        L11:
            this(r10, r11, r12, r13);
        }

        public final boolean a() {
            return this.f5290b;
        }

        public final MainHost.Proxy b() {
            return this.f5293e;
        }

        public final Map<String, SubProcHost.c> c() {
            return this.f5294f;
        }

        public final Map<String, d.C0119d> d() {
            return this.f5291c;
        }

        public final String e() {
            return this.f5289a;
        }

        public final d.C0119d f() {
            return this.f5292d;
        }

        public final void g(MainHost.Proxy r10) {
            this.f5293e = r10;
        }
    }

    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f5295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5296b;

        public g() {
            boolean r10 = false;
            this(r10, r10, 3, null);
        }

        public g(boolean r10, boolean r11) {
            this.f5295a = r10;
            this.f5296b = r11;
        }

        public /* synthetic */ g(boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = false;
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = false;
        L8:
            this(r10, r11);
        }

        public final boolean a() {
            return this.f5296b;
        }

        public final boolean b() {
            return this.f5295a;
        }

        public final void c(boolean r10) {
            this.f5296b = r10;
        }

        public final void d(boolean r10) {
            this.f5295a = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof g) == true) goto L8;
            return false;
        L8:
            g r11 = (g) r10;
            if (this.f5295a == r11.f5295a) goto L12;
            return false;
        L12:
            if (this.f5296b == r11.f5296b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean r10 = this.f5295a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f5296b;
            if (r14 == true) goto L10;
            r11 = r14;
        L10:
            return r13 + r11;
        }

        public String toString() {
            return "PrepareScheduleState(running=" + this.f5295a + ", pending=" + this.f5296b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.AIInferRuntime$getDynamicPackageResources$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$getDynamicPackageResources$1", f = "AIInferRuntime.kt", i = {}, l = {216, 216}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super String>, Object> {
        final /* synthetic */ String $lora;
        final /* synthetic */ String $pkg;
        int label;
        final /* synthetic */ AIInferRuntime this$0;

        AnonymousClass1(AIInferRuntime r10, String r11, String r12, Continuation<? super AnonymousClass1> r13) {
            this.this$0 = r10;
            this.$pkg = r11;
            this.$lora = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$pkg, this.$lora, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super String> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super String> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L18:
            Pair r13 = (Pair) r11;
            if (r13 == null) goto L25;
            y6.b r14 = (y6.b) r13.getSecond();
            if (r14 == null) goto L25;
            List<y6.c> r15 = r14.e();
            if (r15 == null) goto L25;
            String r16 = new com.google.gson.d().t(r15);
        L26:
            if (r16 != null) goto L29;
            return "[]";
        L29:
            return r16;
        L25:
            r16 = null;
            goto L26
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L13:
            PackageWrapper r17 = (PackageWrapper) r11;
            if (r17 == null) goto L25;
            this.label = 2;
            r11 = r17.h(this);
            if (r11 != r10) goto L18;
            return r10;
        L10:
            ResultKt.throwOnFailure(r11);
            AIInferRuntime r18 = this.this$0;
            String r19 = this.$pkg;
            String r20 = this.$lora;
            this.label = 1;
            r11 = AIInferRuntime.f0(r18, r19, r20, null, this, 4, null);
            if (r11 != r10) goto L13;
            return r10;
        }
    }

    public static final class h implements com.obric.aee.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIInferRuntime f5299a;

        h(AIInferRuntime r10) {
            this.f5299a = r10;
        }

        @Override // com.obric.aee.a
        public void L0(String r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
            Intrinsics.checkNotNullParameter(r11, "args");
            com.obric.aikernel.runtime.utils.d.f5417a.l("aee-event", r10 + ' ' + r11);
            if (Intrinsics.areEqual(r10, "ServiceNotResponse") == false) goto L8;
            String r12 = r11.getString("package", "");
            c r13 = this.f5299a.R().a();
            if (r13 == null) goto L9;
            Intrinsics.checkNotNullExpressionValue(r12, "servName");
            r13.f(r12, "");
            return;
        L9:
            return;
        }

        @Override // com.obric.aee.a
        public boolean a() {
            return this.f5299a.R().d();
        }

        @Override // com.obric.aee.a
        public void b(int r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            com.obric.aikernel.runtime.utils.d.f5417a.aeeLog(r10, r11, r12);
        }

        @Override // com.obric.aee.a
        public File c() {
            return AIInferRuntime.j(this.f5299a);
        }

        @Override // com.obric.aee.a
        public Map<String, String> d() {
            Map<String, String> r10 = this.f5299a.R().n();
            if (r10 == null) goto L5;
            return r10;
        L5:
            return MapsKt.emptyMap();
        }

        @Override // com.obric.aee.a
        public Context getContext() {
            return this.f5299a.R().b();
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n*L\n1#1,110:1\n*E\n"})
    public static final class i extends AbstractCoroutineContextElement implements h0 {
        public i(h0.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.h0
        public void V(CoroutineContext r10, Throwable r11) {
            com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", r10.get(k0.f10604g) + " crashed " + ExceptionsKt.stackTraceToString(r11));
        }
    }

    static {
        f5235t = new Companion(null);
        f5236u = SetsKt.setOf(new String[]{IdlKeys.Args_SourcePackageName, IdlKeys.Args_Priority});
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.aikernel.runtime.AIInferRuntime$screenOffListener$1] */
    public AIInferRuntime(d r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        this.f5237a = r14;
        l0 r10 = m0.a(new k0("AIInferRuntime").plus(z0.b()).plus(q2.b(null, 1, null)).plus(new i(h0.f10523d)));
        this.f5238b = r10;
        this.f5239c = new File(r14.h().getResRootDir());
        UnNamedExceptionStrategy r11 = new UnNamedExceptionStrategy(this);
        this.f5240d = r11;
        RuntimeMetrics r12 = RuntimeMetrics.f5408a;
        r12.f();
        if (r14.f().a() == false) goto L5;
        PackageResourceManager r13 = new PackageResourceManager(r14.h());
    L6:
        this.f5243g = r13;
        r12.e();
        com.obric.aikernel.runtime.utils.d r15 = com.obric.aikernel.runtime.utils.d.f5417a;
        r15.g("AIInferRuntime", "init_stage PackageResourceManager cost " + (r12.e() - r12.f()) + "ms");
        if (r14.f().f() == null) goto L9;
        VmEngine r16 = new VmEngine(r10, r14, r11);
    L10:
        this.f5244h = r16;
        this.f5245i = new ConcurrentHashMap();
        this.f5246j = new ConcurrentHashMap();
        ExecutorService r17 = Executors.newFixedThreadPool(4);
        Intrinsics.checkNotNullExpressionValue(r17, "newFixedThreadPool(MAX_VM_PKG_BUILD_PARALLELISM)");
        this.f5247k = m1.b(r17);
        ExecutorService r18 = Executors.newFixedThreadPool(2);
        Intrinsics.checkNotNullExpressionValue(r18, "newFixedThreadPool(MAX_PREPARE_PARALLELISM)");
        this.f5248l = m1.b(r18);
        this.f5249m = new ConcurrentHashMap();
        this.f5251o = new AIInferRuntime$screenOffListener$1(this);
        h r19 = new h(this);
        this.f5252p = r19;
        r12.b();
        if (r14.f().a() == false) goto L13;
        ExecutionEngine.f4305a.e(r19);
    L13:
        r12.a();
        r15.g("AIInferRuntime", "init_stage ExecutionEngine.initRes cost " + (r12.a() - r12.b()) + "ms");
        this.f5253q = kotlinx.coroutines.h.b(r10, null, null, new AIInferRuntime$initJob$1(this, null), 3, null);
        this.f5255s = SystemClock.elapsedRealtime();
        if (r13 == null) goto L16;
        r13.registerPackageObserver(new a(this));
    L16:
        r12.d();
        if (r13 == null) goto L24;
        Collection<AIPackage> r110 = r13.getPackageMap();
        if (r110 == null) goto L24;
        Iterator<T> r111 = r110.iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        G((AIPackage) r111.next());
    L24:
        RuntimeMetrics r112 = RuntimeMetrics.f5408a;
        r112.c();
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "init_stage addPackage cost " + (r112.c() - r112.d()) + "ms");
        PackageResourceManager r113 = this.f5243g;
        if (r113 == null) goto L29;
        FusionInstaller r114 = r113.getFusionInstaller();
        if (r114 == null) goto L29;
        r114.e(new AnonymousClass3(this, null));
    L29:
        PackageResourceManager r115 = this.f5243g;
        if (r115 == null) goto L33;
        r115.setRunningDepsGetter(new AnonymousClass4(this));
    L33:
        this.f5237a.b().registerReceiver(this.f5251o, new IntentFilter("android.intent.action.SCREEN_OFF"));
        if (this.f5237a.f().a() == false) goto L43;
        this.f5241e = new MainHost(this);
        if (this.f5237a.i() == null) goto L39;
        this.f5237a.h().setNativeLibLifeCycle(new b(kotlinx.coroutines.h.b(this.f5238b, null, null, new AIInferRuntime$5$syncNativeLib$1(this, null), 3, null), this));
    L39:
        if (this.f5237a.f().f() != null) goto L48;
        c r116 = this.f5237a.a();
        if (r116 == null) goto L49;
        r116.j();
        return;
    L49:
        return;
    L48:
        return;
    L43:
        this.f5242f = new SubProcHost(this);
        c r117 = this.f5237a.a();
        if (r117 == null) goto L51;
        r117.h();
        return;
    L51:
        return;
    L9:
        r16 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }

    public static final /* synthetic */ Object A(AIInferRuntime r10, String r11, Bundle r12, Continuation r13) {
        return r10.z0(r11, r12, r13);
    }

    private final PackageResource A0(AIModel r10) {
        PackageResource r11 = new PackageResource(r10.w(), 1, 1, r10.D(), 0, 16, null);
        if (r10.s() == null) goto L6;
        r11.addFlag(new int[]{1});
    L6:
        if (r10.a0() == false) goto L10;
        r11.addFlag(new int[]{4});
        if (r10.Z() == false) goto L10;
        r11.addFlag(new int[]{2});
    L10:
        return r11;
    }

    public static final /* synthetic */ Object B(AIInferRuntime r10, Lora r11, String r12, Continuation r13) {
        return r10.C0(r11, r12, r13);
    }

    private final PackageResource B0(AIPackage r10) {
        PackageResource r11 = new PackageResource(r10.w(), 1, 0, r10.D(), 0, 16, null);
        if (r10.s() == null) goto L6;
        r11.addFlag(new int[]{1});
    L6:
        if (r10.a0() == false) goto L10;
        r11.addFlag(new int[]{4});
        if (r10.H() == false) goto L10;
        r11.addFlag(new int[]{2});
    L10:
        List<com.obric.aikernel.res.metadata.data.b> r12 = r10.k0();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        Object r15 = r14.next();
        if ((r15 instanceof AIModel) == false) goto L12;
        r13.add(r15);
        goto L12
    L16:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r17 = r13.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        r16.add(A0((AIModel) r17.next()));
        goto L18
    L20:
        r11.setSubRes(r16);
        if (this.f5237a.d() == false) goto L23;
        com.obric.aikernel.runtime.utils.d.f5417a.c("AIInferRuntime", "toPackageResource: " + r11);
    L23:
        return r11;
    }

    public static final /* synthetic */ PackageWrapper C(AIInferRuntime r10, AIPackage r11) {
        return r10.E0(r11);
    }

    private final Object C0(Lora r21, String r22, Continuation<? super PackageResource> r23) {
        AIInferRuntime r10 = this;
        Lora r11 = r21;
        String r12 = r22;
        if ((r23 instanceof AIInferRuntime$toPackageResource$1) == false) goto L7;
        AIInferRuntime$toPackageResource$1 r13 = (AIInferRuntime$toPackageResource$1) r23;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        Boolean r18 = null;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        int r19 = r13.I$0;
        String r20 = (String) r13.L$2;
        Lora r24 = (Lora) r13.L$1;
        AIInferRuntime r25 = (AIInferRuntime) r13.L$0;
        ResultKt.throwOnFailure(r15);
        int r26 = r19;
        r10 = r25;
        Object r27 = r15;
        r12 = r20;
        r11 = r24;
    L26:
        UpdateResult r28 = (UpdateResult) r27;
    L28:
        if (r11 == null) goto L33;
        String r29 = r11.w();
        if (r29 == null) goto L33;
        String r110 = r29;
    L34:
        String r30 = "";
        if (r11 == null) goto L43;
        String r31 = r11.D();
        if (r31 == null) goto L43;
        if ((!StringsKt.isBlank(r31)) == true) goto L42;
        r31 = null;
    L42:
        if (r31 == null) goto L43;
    L50:
        String r111 = r31;
    L51:
        PackageResource r32 = new PackageResource(r110, 1, 3, r111, 0, 16, null);
        if (r26 != 0) goto L54;
        if (r28 != null) goto L54;
    L55:
        if (r11 != null) goto L57;
    L59:
        boolean r33 = false;
    L60:
        if (r33 == false) goto L62;
        r32.addFlag(new int[]{2});
    L62:
        if (r11 != null) goto L64;
    L66:
        boolean r34 = false;
    L67:
        if (r34 == false) goto L69;
        r32.addFlag(new int[]{4});
    L69:
        if (r11 == null) goto L76;
        List<AIModel> r35 = r11.k0();
        if (r35 == null) goto L76;
        ArrayList r36 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator<T> r37 = r35.iterator();
    L74:
        if (r37.hasNext() == false) goto L77;
        r36.add(r10.A0((AIModel) r37.next()));
    L77:
        r32.setSubRes(r36);
        if (r32.isDownloaded() == true) goto L93;
        com.obric.aikernel.runtime.utils.d r38 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r39 = new StringBuilder();
        r39.append("toPackageResource lora downloaded=false loraType=");
        r39.append(r12);
        r39.append(" version=");
        if (r11 == null) goto L85;
        String r40 = r11.D();
        if (r40 == null) goto L85;
        r30 = r40;
    L85:
        r39.append(r30);
        r39.append(" selfReady=");
        if (r11 == null) goto L88;
        Boolean r41 = Boxing.boxBoolean(r11.a0());
    L89:
        r39.append(r41);
        r39.append(" selfAvailable=");
        if (r11 == null) goto L92;
        r18 = Boxing.boxBoolean(r11.Z());
    L92:
        r39.append(r18);
        r39.append(" updateInfo=");
        r39.append(r10.L(r28));
        r39.append(" reason=");
        r39.append(r10.J(r12, r32, r28));
        r38.d("AIInferRuntime", r39.toString());
        goto L93
    L88:
        r41 = null;
    L93:
        return r32;
    L76:
        r36 = null;
        goto L77
    L64:
        if (r11.a0() != true) goto L66;
        r34 = true;
        goto L67
    L57:
        if (r11.Z() != true) goto L59;
        r33 = true;
    L54:
        r32.addFlag(new int[]{1});
    L43:
        if (r28 == null) goto L47;
        UpdateTaskConfig r42 = r28.getCfg();
        if (r42 == null) goto L47;
        r31 = r42.i();
    L48:
        if (r31 != null) goto L50;
        r111 = "";
    L47:
        r31 = null;
    L33:
        r110 = r12;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r11 == null) goto L17;
        DistConfig r43 = r21.s();
    L18:
        if (r43 == null) goto L20;
        r26 = 1;
    L21:
        PackageResourceManager r44 = r10.f5243g;
        if (r44 == null) goto L27;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r12;
        r13.I$0 = r26;
        r13.label = 1;
        r27 = r44.getPackageUpdateInfo(r12, r13);
        if (r27 != r16) goto L26;
        return r16;
    L27:
        r28 = null;
        goto L28
    L20:
        r26 = 0;
        goto L21
    L17:
        r43 = null;
    L7:
        r13 = new AIInferRuntime$toPackageResource$1(r10, r23);
        goto L8
    }

    public static final /* synthetic */ Object D(AIInferRuntime r10, String r11, String r12, boolean r13, String r14, boolean r15, Continuation r16) {
        return r10.J0(r11, r12, r13, r14, r15, r16);
    }

    private final String D0(String r10) {
        if (Intrinsics.areEqual(r10, "bridge") == false) goto L6;
        return "Bridge";
    L6:
        return r10;
    }

    public static final /* synthetic */ Object E(AIInferRuntime r10, Continuation r11) {
        return r10.M0(r11);
    }

    private final PackageWrapper E0(AIPackage r15) {
        PackageResource r10 = B0(r15);
        if (r15.H() == false) goto L20;
        List<com.obric.aikernel.res.metadata.data.b> r11 = r15.k0();
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        Object r14 = r13.next();
        com.obric.aikernel.res.metadata.data.b r16 = (com.obric.aikernel.res.metadata.data.b) r14;
        if ((r16 instanceof com.obric.aikernel.res.metadata.data.e) == true) goto L10;
    L12:
        boolean r17 = false;
    L13:
        if (r17 == false) goto L6;
        r12.add(r14);
        goto L6
    L10:
        if (((com.obric.aikernel.res.metadata.data.e) r16).h0() == false) goto L12;
        r17 = true;
        goto L13
    L15:
        Iterator r18 = r12.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        com.obric.aikernel.res.metadata.data.b r19 = (com.obric.aikernel.res.metadata.data.b) r18.next();
        NativeLibVersionPolicy.INSTANCE.recordVersion(r19.w(), r19.D());
        goto L17
    L19:
        AIInferRuntime$transferPackage$vmInfo$3 r20 = new AIInferRuntime$transferPackage$vmInfo$3(this, r15, null);
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "transferPackage avail " + r15.w() + ':' + r15.D());
        AIInferRuntime$transferPackage$vmInfo$3 r21 = r20;
        boolean r110 = true;
    L21:
        PackageWrapper r111 = new PackageWrapper(r15, r10, null, r21, this.f5238b, this.f5247k, null, this.f5240d, 68, null);
        if (r110 == false) goto L26;
        PackageWrapper r22 = this.f5245i.get(r15.w());
        if (Intrinsics.areEqual(r15.w(), this.f5237a.h().getPreInitPackageName()) == true) goto L26;
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AIInferRuntime$transferPackage$1$1(r22, r15, null), 3, null);
    L26:
        this.f5245i.put(r15.w(), r111);
        return r111;
    L20:
        com.obric.aikernel.runtime.utils.d r23 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r24 = new StringBuilder();
        r24.append("transferPackage not avail ");
        r24.append(r15.w());
        r24.append(':');
        r24.append(r15.D());
        r24.append(". Self state is ");
        String r25 = Integer.toString(r10.getSelfFlag(), CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(r25, "toString(this, checkRadix(radix))");
        r24.append(r25);
        r24.append('!');
        r23.l("AIInferRuntime", r24.toString());
        r110 = false;
        r21 = null;
        goto L21
    }

    private final PackageWrapper F(AIPackage r12, Lora r13) {
        Map<String, PackageWrapper> r10 = this.f5246j;
        monitor-enter(r10);
        PackageWrapper r11 = new PackageWrapper(r12, B0(r12), r13, new AIInferRuntime$addLoraPackageInfo$1$wrapper$1(this, r12, r13, null), this.f5238b, this.f5247k, this.f5237a.m().invoke(), this.f5240d);     // Catch: Throwable -> L7
        this.f5246j.put(r13.w(), r11);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private final synchronized void G(AIPackage r10) {
        monitor-enter(this);
        String r11 = this.f5237a.h().getPreInitPackageName();     // Catch: Throwable -> L79
        if (r11 != null) goto L6;
    L14:
        PackageWrapper r12 = this.f5245i.get(r10.w());     // Catch: Throwable -> L79
        boolean r13 = false;
        if (r12 == null) goto L21;
        AIPackage r14 = r12.g();     // Catch: Throwable -> L79
        if (r14 == null) goto L21;
        if (r14.H() != true) goto L21;
        r13 = true;
    L21:
        Unit r15 = null;
        if (r12 != null) goto L25;
    L59:
        if (r10 != null) goto L61;
    L75:
        if (r10 == null) goto L77;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "addPackage ignore " + r10 + " subResource: " + r10.k0().size());     // Catch: Throwable -> L79
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L77:
        monitor-exit(this);
        return;
    L61:
        if ((!r10.k0().isEmpty()) == false) goto L63;
        AIPackage r17 = r10;
    L64:
        if (r17 == null) goto L75;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "addPackage start transferPkg:" + r10);     // Catch: Throwable -> L79
        com.obric.aikernel.res.metadata.d r18 = com.obric.aikernel.res.metadata.d.f5055a;     // Catch: Throwable -> L79
        if (r18.b(r17.w()) == true) goto L68;
    L73:
        E0(r17);     // Catch: Throwable -> L79
        s0(r17.w());     // Catch: Throwable -> L79
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L79
    L74:
        if (r15 != null) goto L77;
    L68:
        if (r18.e(r17) == false) goto L71;
        u0(r17);     // Catch: Throwable -> L79
        goto L74
    L71:
        if (r18.d() == true) goto L73;
    L63:
        r17 = null;
        goto L64
    L25:
        if (r13 == r12.f().isAvailable()) goto L35;
        if (r13 == true) goto L28;
    L34:
        AIPackage r19 = r12.g();     // Catch: Throwable -> L79
    L36:
        boolean r20 = r10.H();     // Catch: Throwable -> L79
        if (r13 == false) goto L54;
        if (r20 == false) goto L58;
        AIPackage.a r21 = AIPackage.f5062u;     // Catch: Throwable -> L79
        if (r21.b(r10.D()) > r21.b(r12.g().D())) goto L59;
        if (Intrinsics.areEqual(r10.D(), "debug") == false) goto L50;
        if (Intrinsics.areEqual(r12.g().D(), "debug") == false) goto L59;
        if (Intrinsics.areEqual(r12.g().i0(), r10.i0()) == true) goto L58;
    L50:
        if (Intrinsics.areEqual(r10.w(), "vlm_local") == false) goto L58;
        if (com.obric.aikernel.res.metadata.d.f5055a.e(r10) == true) goto L59;
    L58:
        r10 = r19;
        goto L59
    L54:
        if (r20 == true) goto L59;
        AIPackage.a r22 = AIPackage.f5062u;     // Catch: Throwable -> L79
        if (r22.b(r10.D()) <= r22.b(r12.g().D())) goto L58;
    L28:
        if (Intrinsics.areEqual(r10.D(), r12.g().D()) == false) goto L33;
        if ((!r10.k0().isEmpty()) == false) goto L33;
        r19 = r10;
    L33:
        if ((!r12.g().k0().isEmpty()) == true) goto L34;
    L35:
        r19 = null;
        goto L36
    L6:
        if (Intrinsics.areEqual(r10.w(), r11) == false) goto L14;
        if (this.f5245i.get(r10.w()) == null) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (r10.H() == false) goto L12;
        E0(r10);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Object G0(AIInferRuntime r10, String r11, boolean r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = PackageResourceManager.DEBUG_CALLER;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = true;
    L9:
        return r10.F0(r11, r12, r13);
    }

    private final Object H(String r18, String r19, Continuation<? super k> r20) {
        if ((r20 instanceof AIInferRuntime$buildDownloadStatus$1) == false) goto L7;
        AIInferRuntime$buildDownloadStatus$1 r10 = (AIInferRuntime$buildDownloadStatus$1) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        String r15 = null;
        boolean r16 = false;
        if (r14 == 0) goto L25;
        if (r14 == 1) goto L24;
        if (r14 == 2) goto L23;
        if (r14 == 3) goto L23;
        if (r14 == 4) goto L22;
        if (r14 != 5) goto L21;
        UpdateResult r17 = (UpdateResult) r10.L$5;
        PackageResource r21 = (PackageResource) r10.L$4;
        k r22 = (k) r10.L$3;
        String r23 = (String) r10.L$2;
        String r24 = (String) r10.L$1;
        AIInferRuntime r25 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L18
    L82:
        Object r26 = Result.m32constructorimpl(Boxing.boxFloat(((Number) r12).floatValue()));     // Catch: Throwable -> L18
    L87:
        Float r27 = Boxing.boxFloat(-1.0f);
        if (Result.m38isFailureimpl(r26) == false) goto L90;
        r26 = r27;
    L90:
        float r28 = ((Number) r26).floatValue();
        if (r21 != null) goto L93;
    L95:
        boolean r29 = false;
    L96:
        r22.n("available", Boxing.boxBoolean(r29));
        if (r21 != null) goto L99;
    L101:
        boolean r30 = false;
    L102:
        r22.n("downloaded", Boxing.boxBoolean(r30));
        if (r21 != null) goto L105;
    L107:
        boolean r31 = false;
    L108:
        r22.n("provisioned", Boxing.boxBoolean(r31));
        if (r21 == null) goto L111;
        String r32 = r21.getVersion();
    L112:
        String r110 = "";
        if (r32 != null) goto L115;
        r32 = "";
    L115:
        r22.p("version", r32);
        r22.o("progress", Boxing.boxFloat(r28));
        if (r17 != null) goto L118;
    L121:
        boolean r33 = true;
    L122:
        r22.n("updateFinished", Boxing.boxBoolean(r33));
        if (r17 != null) goto L125;
    L127:
        boolean r34 = false;
    L128:
        r22.n("updateSuccess", Boxing.boxBoolean(r34));
        if (r17 == null) goto L131;
        int r35 = r17.getStage();
    L132:
        r22.o("updateStage", Boxing.boxInt(r35));
        if (r17 == null) goto L135;
        String r36 = r17.getMsg();
    L136:
        if (r36 != null) goto L138;
        r36 = "";
    L138:
        r22.p("updateMessage", r36);
        if (r23.length() <= 0) goto L141;
        boolean r37 = true;
    L142:
        if (r37 == false) goto L182;
        if (r21 == null) goto L157;
        List<PackageResource> r38 = r21.getSubRes();
        if (r38 == null) goto L157;
        Iterator<T> r39 = r38.iterator();
    L148:
        if (r39.hasNext() == false) goto L155;
        Object r40 = r39.next();
        if (((PackageResource) r40).getType() != 3) goto L152;
        boolean r111 = true;
    L153:
        if (r111 == false) goto L148;
    L156:
        PackageResource r41 = (PackageResource) r40;
    L158:
        com.obric.aikernel.runtime.utils.d r42 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r43 = new StringBuilder();
        r43.append("buildDownloadStatus lora pkg=");
        r43.append(r24);
        r43.append(" loraType=");
        r43.append(r23);
        r43.append(" downloaded=");
        if (r21 != null) goto L161;
    L163:
        boolean r44 = false;
    L164:
        r43.append(r44);
        r43.append(" available=");
        if (r21 != null) goto L167;
    L169:
        boolean r45 = false;
    L170:
        r43.append(r45);
        r43.append(" provisioned=");
        if (r21 != null) goto L173;
    L175:
        r43.append(r16);
        r43.append(" version=");
        if (r21 == null) goto L178;
        r15 = r21.getVersion();
    L178:
        if (r15 == null) goto L181;
        r110 = r15;
    L181:
        r43.append(r110);
        r43.append(" updateInfo=");
        r43.append(r25.L(r17));
        r43.append(" reason=");
        r43.append(r25.J(r23, r41, r17));
        r42.d("AIInferRuntime", r43.toString());
        goto L182
    L173:
        if (r21.isProvisioned() != true) goto L175;
        r16 = true;
        goto L175
    L167:
        if (r21.isAvailable() != true) goto L169;
        r45 = true;
        goto L170
    L161:
        if (r21.isDownloaded() != true) goto L163;
        r44 = true;
        goto L164
    L152:
        r111 = false;
        goto L153
    L155:
        r40 = null;
    L157:
        r41 = null;
    L182:
        return r22;
    L141:
        r37 = false;
        goto L142
    L135:
        r36 = null;
        goto L136
    L131:
        r35 = 0;
        goto L132
    L125:
        if (r17.getSuccess() == false) goto L127;
        r34 = true;
        goto L128
    L118:
        if (r17.getFinished() == true) goto L121;
        r33 = false;
        goto L122
    L111:
        r32 = null;
        goto L112
    L105:
        if (r21.isProvisioned() != true) goto L107;
        r31 = true;
        goto L108
    L99:
        if (r21.isDownloaded() != true) goto L101;
        r30 = true;
        goto L102
    L93:
        if (r21.isAvailable() != true) goto L95;
        r29 = true;
    L18:
        th = th;
    L86:
        Result.Companion r46 = Result.Companion;
        r26 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L87
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        String r47 = (String) r10.L$5;
        PackageResource r48 = (PackageResource) r10.L$4;
        k r49 = (k) r10.L$3;
        String r50 = (String) r10.L$2;
        String r112 = (String) r10.L$1;
        AIInferRuntime r113 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L76:
        String r114 = r112;
        String r115 = r50;
        k r51 = r49;
        PackageResource r52 = r48;
        UpdateResult r53 = (UpdateResult) r12;
        String r54 = r47;
    L183:
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L84
        r10.L$0 = r113;     // Catch: Throwable -> L84
        r10.L$1 = r114;     // Catch: Throwable -> L84
        r10.L$2 = r115;     // Catch: Throwable -> L84
        r10.L$3 = r51;     // Catch: Throwable -> L84
        r10.L$4 = r52;     // Catch: Throwable -> L84
        r10.L$5 = r53;     // Catch: Throwable -> L84
        r10.label = 5;     // Catch: Throwable -> L84
        r12 = r113.Z(r54, r10);     // Catch: Throwable -> L84
        if (r12 != r13) goto L81;
        return r13;
    L81:
        r17 = r53;
        r21 = r52;
        r22 = r51;
        r23 = r115;
        r25 = r113;
        r24 = r114;
    L84:
        th = th;
        r17 = r53;
        r21 = r52;
        r22 = r51;
        r23 = r115;
        r25 = r113;
        r24 = r114;
    L23:
        k r56 = (k) r10.L$3;
        String r57 = (String) r10.L$2;
        String r58 = (String) r10.L$1;
        AIInferRuntime r116 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L59:
        r113 = r116;
        r112 = r58;
        r50 = r57;
        r48 = (PackageResource) r12;
        if (r50.length() != 0) goto L66;
        boolean r59 = true;
    L67:
        if (r59 == false) goto L69;
        r54 = r112;
    L70:
        PackageResourceManager r117 = r113.f5243g;
        if (r117 == null) goto L77;
        r10.L$0 = r113;
        r10.L$1 = r112;
        r10.L$2 = r50;
        r10.L$3 = r56;
        r10.L$4 = r48;
        r10.L$5 = r54;
        r10.label = 4;
        Object r60 = r117.getPackageUpdateInfo(r54, r10);
        if (r60 != r13) goto L75;
        return r13;
    L75:
        r49 = r56;
        r47 = r54;
        r12 = r60;
        goto L76
    L77:
        r52 = r48;
        r53 = null;
        r114 = r112;
        r115 = r50;
        r51 = r56;
        goto L183
    L69:
        r54 = r50;
        goto L70
    L66:
        r59 = false;
        goto L67
    L24:
        k r61 = (k) r10.L$5;
        String r62 = (String) r10.L$4;
        k r118 = (k) r10.L$3;
        String r119 = (String) r10.L$2;
        String r120 = (String) r10.L$1;
        AIInferRuntime r121 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L43:
        r61.m(r62, (com.google.gson.i) r12);
        if (r120.length() != 0) goto L46;
        boolean r63 = true;
    L47:
        if (r63 == false) goto L50;
        return r118;
    L50:
        if (r119.length() <= 0) goto L52;
        boolean r64 = true;
    L53:
        r10.L$0 = r121;
        r10.L$1 = r120;
        r10.L$2 = r119;
        r10.L$3 = r118;
        r10.L$4 = null;
        r10.L$5 = null;
        if (r64 == false) goto L60;
        r10.label = 2;
        r12 = r121.V(r120, r119, r10);
        if (r12 != r13) goto L58;
        return r13;
    L58:
        r56 = r118;
        r57 = r119;
        r58 = r120;
        r116 = r121;
        goto L59
    L60:
        r10.label = 3;
        r12 = r121.X(r120, r10);
        if (r12 != r13) goto L58;
        return r13;
    L52:
        r64 = false;
        goto L53
    L46:
        r63 = false;
        goto L47
    L25:
        ResultKt.throwOnFailure(r12);
        if (r18.length() != 0) goto L28;
        boolean r65 = true;
    L29:
        if (r65 == false) goto L31;
        String r66 = "*";
    L33:
        if (r19.length() != 0) goto L35;
        boolean r67 = true;
    L36:
        if (r67 == false) goto L38;
        String r68 = "-";
    L39:
        r118 = new k();
        r118.p("pkgName", r66);
        r118.p("loraType", r68);
        r62 = "downloadingSummary";
        r10.L$0 = this;
        r10.L$1 = r18;
        r119 = r19;
        r10.L$2 = r119;
        r10.L$3 = r118;
        r10.L$4 = "downloadingSummary";
        r10.L$5 = r118;
        r10.label = 1;
        Object r122 = U(r10);
        if (r122 != r13) goto L42;
        return r13;
    L42:
        r121 = this;
        r61 = r118;
        r120 = r18;
        r12 = r122;
        goto L43
    L38:
        r68 = r19;
        goto L39
    L35:
        r67 = false;
        goto L36
    L31:
        r66 = r18;
        goto L33
    L28:
        r65 = false;
    L7:
        r10 = new AIInferRuntime$buildDownloadStatus$1(this, r20);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01c7 -> B:54:0x01cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x01d4 -> B:111:0x01d8). Please report as a decompilation issue!!! */
    private final Object I(AIPackage r24, Continuation<? super y6.b> r25) {
        if ((r25 instanceof AIInferRuntime$buildPackageInfo$1) == false) goto L7;
        AIInferRuntime$buildPackageInfo$1 r10 = (AIInferRuntime$buildPackageInfo$1) r25;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
        AIInferRuntime r12 = this;
    L8:
        Object r13 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        int r16 = 1;
        char r17 = '@';
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Collection r18 = (Collection) r10.L$6;
        String r19 = (String) r10.L$5;
        com.obric.aikernel.res.metadata.data.b r110 = (com.obric.aikernel.res.metadata.data.b) r10.L$4;
        Iterator r111 = (Iterator) r10.L$3;
        Collection r112 = (Collection) r10.L$2;
        AIPackage r113 = (AIPackage) r10.L$1;
        AIInferRuntime r114 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r13);
    L54:
        String r22 = r19;
        Collection r20 = r18;
        r12 = r114;
        String r115 = r22;
    L111:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L58
        Object r23 = Result.m32constructorimpl(Boxing.boxBoolean(r110.b(Intrinsics.areEqual(r113.w(), "vlm_local"))));     // Catch: Throwable -> L58
    L60:
        Throwable r116 = Result.m35exceptionOrNullimpl(r23);
        if (r116 != null) goto L63;
        String r117 = r110.w();
        String r26 = r110.D();
        Uri r118 = r110.v();
        if (r118 == null) goto L74;
        String r119 = r118.getPath();
        if (r119 == null) goto L74;
        String r27 = r119;
    L75:
        Object r28 = new y6.c(r117, r26, r27, r115);
        com.obric.aikernel.runtime.utils.d r29 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r30 = new StringBuilder();
        r30.append("buildPackageInfo: package ");
        r30.append(r113);
        r30.append(" depends model ");
        r30.append(r110.w());
        char r120 = '@';
        r30.append('@');
        r30.append(r110.D());
        r29.k("AIInferRuntime", r30.toString());
        AIPackage r121 = r113;
    L78:
        r20.add(r28);
        r20 = r112;
        r17 = r120;
        r16 = 1;
    L16:
        if (r111.hasNext() == false) goto L79;
        com.obric.aikernel.res.metadata.data.b r31 = (com.obric.aikernel.res.metadata.data.b) r111.next();
        if ((r31 instanceof com.obric.aikernel.res.metadata.data.e) == false) goto L33;
        if (((com.obric.aikernel.res.metadata.data.e) r31).h0() == false) goto L24;
        String r122 = NativeLibVersionPolicy.INSTANCE.initOrGetVersion(r31.w());
        if (r122 == null) goto L24;
        r31 = new com.obric.aikernel.res.metadata.data.e(r31.w(), r122, r12.f5237a.h());
    L24:
        com.obric.aikernel.res.metadata.data.e r32 = (com.obric.aikernel.res.metadata.data.e) r31;
        String r123 = r12.D0(r32.w());
        String r124 = r32.E();
        Uri r125 = r32.v();
        if (r125 == null) goto L30;
        String r126 = r125.getPath();
        if (r126 == null) goto L30;
        String r127 = r126;
    L31:
        Object r128 = new y6.a(r123, r124, r127, r32.h0(), r32.u());
        com.obric.aikernel.runtime.utils.d.f5417a.k("AIInferRuntime", "transferPackage: package " + r121.w() + r17 + r121.D() + " depends library " + r32.w() + r17 + r32.D());
        r112 = r20;
        r120 = r17;
        r28 = r128;
    L30:
        r127 = "";
        goto L31
    L33:
        if ((r31 instanceof AIModel) == true) goto L35;
        r120 = r17;
        r112 = r20;
        r28 = Unit.INSTANCE;
        goto L78
    L35:
        if (r121.m0() == false) goto L47;
        DistConfig r129 = r121.s();
        if (r129 == null) goto L45;
        k r130 = r129.f();
        if (r130 == null) goto L45;
        k r131 = r130.u("dependency");
        if (r131 == null) goto L45;
        k r132 = r131.u("model_center_conf");
        if (r132 == null) goto L45;
        k r133 = r132.u(r31.w() + r17 + r31.D());
    L46:
        String r134 = AIModel.f5059o.a(r133);
    L49:
        if (((AIModel) r31).i0() == false) goto L55;
        PackageResourceManager.PresmConfig.b r135 = r12.f5237a.h().getDecryptFeature();
        Set r136 = SetsKt.setOf(r31.w() + r17 + r31.D());
        r10.L$0 = r12;
        r10.L$1 = r121;
        r10.L$2 = r20;
        r10.L$3 = r111;
        r10.L$4 = r31;
        r10.L$5 = r134;
        r10.L$6 = r20;
        r10.label = r16;
        if (r135.waitDecrypting(r136, r10) != r14) goto L53;
        return r14;
    L53:
        r114 = r12;
        r18 = r20;
        r113 = r121;
        r110 = r31;
        r19 = r134;
        r112 = r18;
        goto L54
    L55:
        r113 = r121;
        r115 = r134;
        r110 = r31;
        r112 = r20;
    L45:
        r133 = null;
        goto L46
    L47:
        r134 = r31.u();
        goto L49
    L79:
        List r33 = (List) r20;
        Iterator<T> r34 = r121.j0().iterator();
    L81:
        if (r34.hasNext() == false) goto L87;
        c8.d r35 = (c8.d) r34.next();
        if (r35.H() == true) goto L81;
        throw new IllegalStateException("check dependent aikernel model " + r35 + " not avail!");
    L87:
        String r137 = r121.w();
        String r138 = r121.E();
        Uri r36 = r121.v();
        if (r36 == null) goto L93;
        String r37 = r36.getPath();
        if (r37 == null) goto L93;
        String r139 = r37;
    L94:
        ArrayList r38 = new ArrayList();
        Iterator r39 = r33.iterator();
    L96:
        if (r39.hasNext() == false) goto L100;
        Object r40 = r39.next();
        if ((r40 instanceof y6.a) == false) goto L96;
        r38.add(r40);
        goto L96
    L100:
        ArrayList r41 = new ArrayList();
        Iterator r42 = r33.iterator();
    L102:
        if (r42.hasNext() == false) goto L106;
        Object r43 = r42.next();
        if ((r43 instanceof y6.c) == false) goto L102;
        r41.add(r43);
        goto L102
    L106:
        y6.b r44 = new y6.b(r137, r138, r139, "", r38, r41, r121.u());
        c r45 = r12.f5237a.a();
        if (r45 == null) goto L109;
        r45.l(r44);
    L109:
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "buildPackageInfo " + r121 + " done!");
        return r44;
    L93:
        r139 = "";
    L74:
        r27 = "";
        goto L75
    L63:
        if (((AIModel) r110).i0() == false) goto L65;
        int r46 = 202;
    L67:
        throw new AIKernelException(r46, "buildPackageInfo check model resource", r116, 0, 8, null);
    L65:
        r46 = IdlErrors.E_InstalledModelDecryptFailed;
    L58:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r23 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L60
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.obric.aikernel.runtime.utils.d r47 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r48 = new StringBuilder();
        r48.append("buildPackageInfo ");
        r121 = r24;
        r48.append(r121);
        r48.append(" start!");
        r47.g("AIInferRuntime", r48.toString());
        List<com.obric.aikernel.res.metadata.data.b> r49 = r24.k0();
        r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r49, 10));
        r111 = r49.iterator();
    L7:
        r12 = this;
        r10 = new AIInferRuntime$buildPackageInfo$1(r12, r25);
        goto L8
    }

    private final String J(String r10, PackageResource r11, UpdateResult r12) {
        if (r11 != null) goto L6;
        return "missing_lora_resource:" + r10;
    L6:
        if (r11.isDownloaded() == true) goto L21;
        List<PackageResource> r13 = r11.getSubRes();
        if (r13 == null) goto L18;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        Object r16 = r15.next();
        if (((PackageResource) r16).isDownloaded() == true) goto L11;
        r14.add(r16);
        goto L11
    L15:
        String r17 = CollectionsKt.joinToString$default(r14, null, "[", "]", 0, null, new AIInferRuntime$describeLoraDownloadReasonForLog$missingChildren$2(this), 25, null);
        if (r17 == null) goto L18;
    L20:
        return "loraSelf=" + K(r11) + " missingDownloadedSubRes=" + r17 + " updateInfo=" + L(r12);
    L18:
        r17 = "[]";
        goto L20
    L21:
        if (r12 != null) goto L30;
        return "downloaded";
    L30:
        return "downloaded_with_update_info(" + L(r12) + ')';
    }

    private final Object J0(String r33, String r34, boolean r35, String r36, boolean r37, Continuation<? super PackageResource> r38) {
        AIInferRuntime r10 = this;
        if ((r38 instanceof AIInferRuntime$updatePackageInternal$1) == false) goto L7;
        AIInferRuntime$updatePackageInternal$1 r11 = (AIInferRuntime$updatePackageInternal$1) r38;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        boolean r16 = true;
        Object r17 = null;
        if (r15 == 0) goto L21;
        if (r15 == 1) goto L19;
        if (r15 == 2) goto L18;
        if (r15 == 3) goto L17;
        if (r15 != 4) goto L16;
        ResultKt.throwOnFailure(r13);
    L78:
        return (PackageResource) r13;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r18 = (String) r11.L$2;
        String r19 = (String) r11.L$1;
        AIInferRuntime r20 = (AIInferRuntime) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r17 = null;
        r16 = true;
    L62:
        AIPackage r21 = (AIPackage) r13;
        if (r21 == null) goto L66;
        PackageResource r22 = r20.B0(r21);
        if (r22 == null) goto L66;
    L70:
        if (r18.length() > 0) goto L73;
        r16 = false;
    L73:
        if (r16 == false) goto L79;
        r11.L$0 = r17;
        r11.L$1 = r17;
        r11.L$2 = r17;
        r11.L$3 = r17;
        r11.L$4 = r17;
        r11.label = 4;
        r13 = r20.V(r19, r18, r11);
        if (r13 != r14) goto L78;
        return r14;
    L79:
        return r22;
    L66:
        String r110 = r18;
        String r23 = r19;
        r10 = r20;
    L68:
        r20 = r10;
        r19 = r23;
        r18 = r110;
        r22 = new PackageResource(r23, 1, 0, null, 0, 24, null);
        goto L70
    L18:
        boolean r24 = r11.Z$1;
        boolean r25 = r11.Z$0;
        String r26 = (String) r11.L$3;
        String r27 = (String) r11.L$2;
        String r28 = (String) r11.L$1;
        AIInferRuntime r29 = (AIInferRuntime) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L40:
        AIPackage r30 = (AIPackage) r13;
        if (r30 == null) goto L46;
        String r210 = r28;
        if (r30.H() != r16) goto L45;
        boolean r111 = r16;
    L49:
        if (r111 == false) goto L51;
        boolean r112 = r24;
        String r211 = r26;
        String r113 = r27;
        r10 = r29;
        r23 = r210;
    L54:
        String r31 = r211;
    L56:
        PackageResourceManager r32 = r10.f5243g;
        if (r32 == null) goto L67;
        r11.L$0 = r10;
        r11.L$1 = r23;
        r11.L$2 = r31;
        r11.L$3 = r17;
        r11.L$4 = r17;
        r11.label = 3;
        Object r39 = r32.updatePackage(r23, r113, r112, r25, r31, r11);
        if (r39 != r14) goto L61;
        return r14;
    L61:
        r20 = r10;
        r18 = r31;
        r19 = r23;
        r13 = r39;
        goto L62
    L67:
        r110 = r31;
        goto L68
    L51:
        return new PackageResource(r210, 1, 0, null, 0, 24, null);
    L45:
        r111 = false;
        goto L49
    L46:
        boolean r40 = r25;
        String r41 = r27;
        r23 = r28;
        boolean r42 = r24;
        r10 = r29;
        String r43 = r26;
    L48:
        r210 = r23;
        r26 = r43;
        r25 = r40;
        r27 = r41;
        r111 = false;
        r29 = r10;
        r24 = r42;
        goto L49
    L19:
        boolean r44 = r11.Z$1;
        boolean r45 = r11.Z$0;
        String r46 = (String) r11.L$4;
        String r47 = (String) r11.L$3;
        String r48 = (String) r11.L$2;
        String r49 = (String) r11.L$1;
        AIInferRuntime r50 = (AIInferRuntime) r11.L$0;
        ResultKt.throwOnFailure(r13);
        r42 = r44;
        r10 = r50;
        r41 = r48;
        r43 = r47;
        boolean r310 = r45;
        Object r51 = r13;
        r23 = r49;
    L20:
        r40 = r310;
        PackageResource r52 = (PackageResource) r51;
        if (r52 != null) goto L30;
    L32:
        boolean r53 = false;
    L33:
        if (r53 == true) goto L53;
        PackageResourceManager r54 = r10.f5243g;
        if (r54 == null) goto L47;
        r11.L$0 = r10;
        r11.L$1 = r23;
        r11.L$2 = r41;
        r11.L$3 = r43;
        r11.L$4 = null;
        r11.Z$0 = r40;
        r11.Z$1 = r42;
        r11.label = 2;
        boolean r114 = r42;
        String r212 = r43;
        String r115 = r41;
        Object r55 = PackageResourceManager.updatePackage$default(r54, r46, r41, r42, r40, null, r11, 16, null);
        if (r55 != r14) goto L39;
        return r14;
    L39:
        r29 = r10;
        r28 = r23;
        r13 = r55;
        r27 = r115;
        r24 = r114;
        r26 = r212;
        r25 = r40;
        goto L40
    L47:
        r17 = null;
        r16 = true;
        goto L48
    L53:
        r112 = r42;
        r211 = r43;
        r113 = r41;
        r17 = null;
        r16 = true;
        r25 = r40;
        goto L54
    L30:
        if (r52.isAvailable() != true) goto L32;
        r53 = true;
        goto L33
    L21:
        ResultKt.throwOnFailure(r13);
        String r56 = r10.f5237a.h().getPreInitPackageName();
        if (r56 == null) goto L55;
        r11.L$0 = r10;
        r11.L$1 = r33;
        r11.L$2 = r34;
        r11.L$3 = r36;
        r11.L$4 = r56;
        r11.Z$0 = r35;
        r11.Z$1 = r37;
        r11.label = 1;
        Object r57 = r10.X(r56, r11);
        if (r57 != r14) goto L26;
        return r14;
    L26:
        r46 = r56;
        r23 = r33;
        r51 = r57;
        r41 = r34;
        r310 = r35;
        r43 = r36;
        r42 = r37;
        goto L20
    L55:
        r31 = r36;
        r17 = null;
        r16 = true;
        r23 = r33;
        r113 = r34;
        r25 = r35;
        r112 = r37;
    L7:
        r11 = new AIInferRuntime$updatePackageInternal$1(r10, r38);
        goto L8
    }

    private final String K(PackageResource r10) {
        int r11 = r10.getSelfFlag();
        if ((r11 & 2) != 2) goto L6;
        return "available";
    L6:
        if ((r11 & 4) != 4) goto L9;
        return "downloaded";
    L9:
        if ((r11 & 1) != 1) goto L11;
        return "provisioned";
    L11:
        return "not_found";
    }

    private final String L(UpdateResult r10) {
        if (r10 == null) goto L5;
        String r11 = "stage=" + r10.getStage() + ",finished=" + r10.getFinished() + ",success=" + r10.getSuccess() + ",msg=" + r10.getMsg();
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "none";
    }

    private final Object M0(Continuation<? super Unit> r10) {
        if ((r10 instanceof AIInferRuntime$waitLocalInit$1) == false) goto L7;
        AIInferRuntime$waitLocalInit$1 r11 = (AIInferRuntime$waitLocalInit$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIInferRuntime this = (AIInferRuntime) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        PackageResourceManager r16 = this.f5243g;
        if (r16 == null) goto L29;
        r11.L$0 = null;
        r11.label = 2;
        if (r16.waitLocalPackageInit(r11) != r14) goto L27;
        return r14;
    L29:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r13);
        c r17 = this.f5237a.a();
        if (r17 == null) goto L21;
        r11.L$0 = this;
        r11.label = 1;
        if (r17.e(r11) != r14) goto L21;
        return r14;
    L7:
        r11 = new AIInferRuntime$waitLocalInit$1(this, r10);
        goto L8
    }

    private final void N(PrintWriter r10) {
        StringBuilder r11 = new StringBuilder("all pkgs:");
        Iterator<T> r12 = this.f5245i.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        PackageWrapper r13 = (PackageWrapper) r12.next();
        r11.append('[' + r13.f().getName() + '@' + r13.f().getVersion() + ' ' + r13.f());
        goto L4
    L6:
        r10.println(r11.toString());
    }

    private final PackageWrapper O(String r10) {
        return this.f5245i.get(r10);
    }

    private final Set<String> S(AIPackage r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        r11.add("package@" + r10.w() + '@' + r10.D());
        List<com.obric.aikernel.res.metadata.data.b> r12 = r10.k0();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        com.obric.aikernel.res.metadata.data.b r15 = (com.obric.aikernel.res.metadata.data.b) r14.next();
        r13.add(r15.A() + '@' + r15.w() + '@' + r15.D());
        goto L4
    L6:
        r11.addAll(r13);
        return r11;
    }

    private final Set<String> T(Lora r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        r11.add("lora@" + r10.w() + '@' + r10.D());
        List<AIModel> r12 = r10.k0();
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        AIModel r15 = (AIModel) r14.next();
        r13.add(r15.A() + '@' + r15.w() + '@' + r15.D());
        goto L4
    L6:
        r11.addAll(r13);
        return r11;
    }

    private final PackageWrapper W(String r10, String r11, String r12) {
        if (this.f5237a.f().a() == false) goto L5;
        PackageWrapper r13 = null;
        if (Intrinsics.areEqual(r12, "unload") == true) goto L37;
        PackageWrapper r14 = this.f5246j.get(r11);
        boolean r15 = true;
        if (r14 != null) goto L11;
    L35:
        r15 = false;
    L36:
        if (r15 == true) goto L37;
    L48:
        PackageWrapper r16 = this.f5246j.get(r11);
        if (r16 != null) goto L67;
        Map<String, PackageWrapper> r17 = this.f5246j;
        monitor-enter(r17);
        PackageWrapper r18 = this.f5246j.get(r11);     // Catch: Throwable -> L64
        if (r18 != null) goto L62;
        PackageResourceManager r19 = this.f5243g;     // Catch: Throwable -> L64
        if (r19 == null) goto L61;
        Pair<Lora, AIPackage> r20 = Lora.f5072s.a(r10, r11, r19.getContext());     // Catch: Throwable -> L64
        if (r20 == null) goto L59;
        r13 = F(r20.getSecond(), r20.getFirst());     // Catch: Throwable -> L64
    L59:
        r18 = r13;
        goto L62
    L61:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L64
    L62:
        monitor-exit(r17);
        return r18;
    L64:
        th = move-exception;
        throw th;
    L67:
        return r16;
    L11:
        if (r14.i() == true) goto L32;
        Lora r21 = r14.d();
        if (r21 != null) goto L15;
    L17:
        boolean r22 = false;
    L18:
        if (r22 == false) goto L32;
        AIPackage r23 = com.obric.aikernel.res.metadata.d.f5055a.a();
        if (r23 != null) goto L23;
    L21:
        boolean r24 = false;
    L29:
        if (r24 == true) goto L32;
        boolean r25 = false;
    L33:
        if (r25 != true) goto L35;
    L23:
        if (Intrinsics.areEqual(r14.g().D(), r23.D()) == true) goto L25;
    L28:
        r24 = true;
        goto L29
    L25:
        if (Intrinsics.areEqual(r14.g().D(), "debug") == false) goto L21;
        if (Intrinsics.areEqual(r14.g().i0(), r23.i0()) == true) goto L21;
    L15:
        if (r21.H() != true) goto L17;
        r22 = true;
    L32:
        r25 = true;
    L37:
        PackageWrapper r26 = this.f5246j.remove(r11);
        if (r26 == null) goto L48;
        com.obric.aikernel.runtime.utils.d r27 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r28 = new StringBuilder();
        r28.append("getLoraPackageInfo remove ");
        r28.append(r26.g());
        r28.append('-');
        r28.append(r26.d());
        r28.append(" by event:");
        r28.append(r12);
        r28.append(" isAvailable:");
        Lora r110 = r26.d();
        if (r110 == null) goto L42;
        Boolean r111 = Boolean.valueOf(r110.H());
    L43:
        r28.append(r111);
        r28.append(" VlmLocalVersion:");
        AIPackage r112 = com.obric.aikernel.res.metadata.d.f5055a.a();
        if (r112 == null) goto L46;
        String r113 = r112.D() + " debug:" + r112.i0();
    L47:
        r28.append(r113);
        r27.g("AIInferRuntime", r28.toString());
        goto L48
    L46:
        r113 = null;
        goto L47
    L42:
        r111 = null;
        goto L43
    L5:
        return this.f5246j.get(r11);
    }

    private final Object Y(String r10, String r11, boolean r12, Continuation<? super PackageWrapper> r13) {
        if (r12 == false) goto L6;
        return c0(r10, r11, r13);
    L6:
        return f0(this, r10, r11, null, r13, 4, null);
    }

    public static /* synthetic */ g a(Function1 r10, Object r11) {
        return t0(r10, r11);
    }

    public static final /* synthetic */ void b(AIInferRuntime r10, AIPackage r11) {
        r10.G(r11);
    }

    public static final /* synthetic */ Object c(AIInferRuntime r10, String r11, String r12, Continuation r13) {
        return r10.H(r11, r12, r13);
    }

    private final Object c0(String r11, String r12, Continuation<? super PackageWrapper> r13) {
        if ((r13 instanceof AIInferRuntime$getSubProcPackageInfo$1) == false) goto L7;
        AIInferRuntime$getSubProcPackageInfo$1 r10 = (AIInferRuntime$getSubProcPackageInfo$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        PackageWrapper r18 = (PackageWrapper) r10.L$0;
        ResultKt.throwOnFailure(r15);
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIInferRuntime this = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        PackageWrapper r19 = (PackageWrapper) r15;
        if (r19 == null) goto L25;
        r10.L$0 = r19;
        r10.label = 2;
        if (this.h0(r19, r10) != r16) goto L28;
        return r16;
    L28:
        return r19;
    L25:
        return null;
    L16:
        ResultKt.throwOnFailure(r15);
        r10.L$0 = this;
        r10.label = 1;
        r15 = f0(this, r11, r12, null, r10, 4, null);
        if (r15 != r16) goto L19;
        return r16;
    L7:
        r10 = new AIInferRuntime$getSubProcPackageInfo$1(this, r13);
        goto L8
    }

    public static final /* synthetic */ Object d(AIInferRuntime r10, AIPackage r11, Continuation r12) {
        return r10.I(r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, com.obric.aikernel.runtime.subproc.SubProcHost$c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    private final Object d0(String r20, Continuation<? super SubProcHost.c> r21) {
        if ((r21 instanceof AIInferRuntime$getSubProcProxy$1) == false) goto L7;
        AIInferRuntime$getSubProcProxy$1 r10 = (AIInferRuntime$getSubProcProxy$1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AIInferRuntime$getSubProcProxy$1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Pair r16 = (Pair) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L46:
        return r16.getFirst();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Map<String, SubProcHost.c> r17 = this.f5237a.f().c();
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        ?? r19 = r17.get(r20);
        r18.element = r19;
        if (r19 != 0) goto L50;
        monitor-enter(r17);
        r0 r22 = null;
        r22 = null;
        MainHost r23 = null;
        if (r17.get(r20) != null) goto L38;
        d.b r24 = this.f5237a.l();     // Catch: Throwable -> L47
        if (r24 == null) goto L22;
        r24.a(r20);     // Catch: Throwable -> L47
    L22:
        d.b r25 = this.f5237a.l();     // Catch: Throwable -> L47
        if (r25 == null) goto L25;
        Bundle r26 = r25.a(r20);     // Catch: Throwable -> L47
    L26:
        if (r26 == null) goto L28;
        IBinder r27 = r26.getBinder("@sub_proc_host");     // Catch: Throwable -> L47
    L29:
        if (r26 == null) goto L37;
        if (r27 == null) goto L37;
        ?? r28 = new SubProcHost.c(r20, r27);     // Catch: Throwable -> L47
        r17.put(r20, r28);     // Catch: Throwable -> L47
        r18.element = r28;     // Catch: Throwable -> L47
        MainHost r29 = this.f5241e;     // Catch: Throwable -> L47
        if (r29 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mainHost");     // Catch: Throwable -> L47
    L36:
        r28.b(r23);     // Catch: Throwable -> L47
        r22 = kotlinx.coroutines.h.b(this.f5238b, null, null, new AIInferRuntime$getSubProcProxy$result$1$1$2(this, r20, r26, r27, r17, null), 3, null);     // Catch: Throwable -> L47
        goto L37
    L35:
        r23 = r29;
    L37:
        r16 = new Pair(r18.element, r22);     // Catch: Throwable -> L47
    L39:
        monitor-exit(r17);
        r0 r30 = (r0) r16.getSecond();
        if (r30 == null) goto L46;
        r12.L$0 = r16;
        r12.label = 1;
        if (r30.r(r12) != r14) goto L46;
        return r14;
    L28:
        r27 = null;
        goto L29
    L25:
        r26 = null;
        goto L26
    L38:
        r16 = new Pair(r18.element, null);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    L50:
        return r19;
    L7:
        r10 = new AIInferRuntime$getSubProcProxy$1(this, r21);
        goto L8
    }

    public static final /* synthetic */ String e(AIInferRuntime r10, PackageResource r11) {
        return r10.K(r11);
    }

    private final Object e0(String r10, String r11, String r12, Continuation<? super PackageWrapper> r13) {
        if ((r13 instanceof AIInferRuntime$getVmPackageWrapper$1) == false) goto L7;
        AIInferRuntime$getVmPackageWrapper$1 r14 = (AIInferRuntime$getVmPackageWrapper$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        AIInferRuntime this = (AIInferRuntime) r14.L$3;
        r12 = (String) r14.L$2;
        r11 = (String) r14.L$1;
        r10 = (String) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L22:
        if (((Boolean) r16).booleanValue() == false) goto L24;
        PackageWrapper r19 = this.g0(r10, r11, r12);
    L26:
        return r19;
    L24:
        r19 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        PackageWrapper r20 = g0(r10, r11, r12);
        if (r20 != null) goto L27;
        MainHost.Proxy r21 = this.f5237a.f().b();
        if (r21 == null) goto L24;
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.L$3 = this;
        r14.label = 1;
        r16 = r21.c(r10, r11, r14);
        if (r16 != r17) goto L22;
        return r17;
    L27:
        return r20;
    L7:
        r14 = new AIInferRuntime$getVmPackageWrapper$1(this, r13);
        goto L8
    }

    public static final /* synthetic */ PackageResourceManager f(AIInferRuntime r10) {
        return r10.f5243g;
    }

    static /* synthetic */ Object f0(AIInferRuntime r10, String r11, String r12, String r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = "";
    L9:
        return r10.e0(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Map g(AIInferRuntime r10) {
        return r10.f5245i;
    }

    private final PackageWrapper g0(String r10, String r11, String r12) {
        if (r11 != null) goto L4;
    L7:
        boolean r13 = true;
    L8:
        if (r13 == false) goto L11;
        return O(r10);
    L11:
        return W(r10, r11, r12);
    L4:
        if (r11.length() == 0) goto L7;
        r13 = false;
        goto L8
    }

    public static final /* synthetic */ Set h(AIInferRuntime r10, AIPackage r11) {
        return r10.S(r11);
    }

    private final Object h0(PackageWrapper r10, Continuation<? super Unit> r11) {
        Object r12 = r10.h(r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Set i(AIInferRuntime r10, Lora r11) {
        return r10.T(r11);
    }

    public static final /* synthetic */ File j(AIInferRuntime r10) {
        return r10.f5239c;
    }

    public static /* synthetic */ void j0(AIInferRuntime r10, String r11, String r12, boolean r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = false;
    L5:
        r10.i0(r11, r12, r13);
    }

    public static final /* synthetic */ h k(AIInferRuntime r10) {
        return r10.f5252p;
    }

    private final Object k0(Continuation<? super Boolean> r23) {
        AIInferRuntime r10 = this;
        if ((r23 instanceof AIInferRuntime$preInitApp$1) == false) goto L7;
        AIInferRuntime$preInitApp$1 r11 = (AIInferRuntime$preInitApp$1) r23;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        AIInferRuntime$preInitApp$1 r13 = r11;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        boolean r17 = false;
        if (r16 == 0) goto L18;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        ResultKt.throwOnFailure(r14);
    L51:
        if (((Boolean) r14).booleanValue() != true) goto L54;
        r17 = true;
    L54:
        return Boxing.boxBoolean(r17);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        PackageWrapper r18 = (PackageWrapper) r13.L$1;
        AIInferRuntime r19 = (AIInferRuntime) r13.L$0;
        ResultKt.throwOnFailure(r14);
    L32:
        y6.b r20 = (y6.b) ((Pair) r14).getSecond();
        if (r20 == null) goto L44;
        monitor-enter(r19);
    L41:
        th = move-exception;
        throw th;
    L36:
        if (r19.f5254r != null) goto L38;
        r19.f5254r = kotlinx.coroutines.h.b(r19.f5238b, null, null, new AIInferRuntime$preInitApp$3$1$1$1(r20, r19, r18, null), 3, null);     // Catch: Throwable -> L41
    L38:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L41
        monitor-exit(r19);
    L44:
        r10 = r19;
    L45:
        r0<Boolean> r22 = r10.f5254r;
        if (r22 == null) goto L54;
        r13.L$0 = null;
        r13.L$1 = null;
        r13.label = 3;
        r14 = r22.r(r13);
        if (r14 != r15) goto L51;
        return r15;
    L17:
        r10 = (AIInferRuntime) r13.L$0;
        ResultKt.throwOnFailure(r14);
    L26:
        PackageWrapper r24 = (PackageWrapper) r14;
        if (r24 == null) goto L45;
        r13.L$0 = r10;
        r13.L$1 = r24;
        r13.label = 2;
        Object r25 = r24.h(r13);
        if (r25 != r15) goto L31;
        return r15;
    L31:
        r19 = r10;
        r18 = r24;
        r14 = r25;
        goto L32
    L18:
        ResultKt.throwOnFailure(r14);
        if (r10.f5254r != null) goto L45;
        String r26 = r10.f5237a.h().getPreInitPackageName();
        if (r26 != null) goto L23;
        r10.f5254r = kotlinx.coroutines.h.b(r10.f5238b, null, null, new AIInferRuntime$preInitApp$2(null), 3, null);
        goto L45
    L23:
        r13.L$0 = r10;
        r13.label = 1;
        r14 = f0(this, r26, null, null, r13, 6, null);
        if (r14 != r15) goto L26;
        return r15;
    L7:
        r11 = new AIInferRuntime$preInitApp$1(r10, r23);
        goto L8
    }

    public static final /* synthetic */ r0 l(AIInferRuntime r10) {
        return r10.f5253q;
    }

    public static final /* synthetic */ Map m(AIInferRuntime r10) {
        return r10.f5246j;
    }

    public static /* synthetic */ Object m0(AIInferRuntime r10, String r11, String r12, boolean r13, RequestParams r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 2) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        r13 = true;
    L9:
        boolean r19 = r13;
        if ((r16 & 8) == 0) goto L13;
        r14 = new RequestParams(null, null, 3, null);
    L13:
        return r10.l0(r11, r18, r19, r14, r15);
    L5:
        r18 = r12;
        goto L7
    }

    public static final /* synthetic */ Object n(AIInferRuntime r10, String r11, String r12, boolean r13, Continuation r14) {
        return r10.Y(r11, r12, r13, r14);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x025e -> B:82:0x025f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0275 -> B:68:0x020a). Please report as a decompilation issue!!! */
    private final Object n0(final Function1<? super Continuation<? super PackageWrapper>, ? extends Object> r10, String r11, final RequestParams r12, final boolean r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof AIInferRuntime$prepareSubProcessPackageInfo$1) == false) goto L7;
        AIInferRuntime$prepareSubProcessPackageInfo$1 r15 = (AIInferRuntime$prepareSubProcessPackageInfo$1) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        Object r17 = r15.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r19 = false;
        switch(r15.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        SubProcHost.b r20 = (SubProcHost.b) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L125:
        if (r20 == null) goto L130;
        if (r20.c() != true) goto L130;
        r19 = true;
    L130:
        return Boxing.boxBoolean(r19);
    L13:
        r20 = (SubProcHost.b) r15.L$3;
        SubProcHost.c r21 = (SubProcHost.c) r15.L$2;
        String r110 = (String) r15.L$1;
        AIInferRuntime r111 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L104:
        AIInferRuntime r22 = r111;
        String r112 = r110;
    L105:
        if (r20 != null) goto L107;
    L109:
        boolean r113 = false;
    L110:
        if (r113 == false) goto L119;
        if (r21 == null) goto L116;
        MainHost r114 = r22.f5241e;
        if (r114 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mainHost");
        r114 = null;
    L115:
        r21.b(r114);
        Unit r23 = Unit.INSTANCE;
    L117:
        if (r23 != null) goto L119;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "setHost to proc " + r112 + " but got null proxy.");
        goto L119
    L116:
        r23 = null;
    L119:
        if (r20 == null) goto L125;
        Bundle r24 = r20.b();
        if (r24 == null) goto L125;
        r15.L$0 = r20;
        r15.L$1 = null;
        r15.L$2 = null;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.L$5 = null;
        r15.label = 10;
        if (r22.z0(r112, r24, r15) != r18) goto L125;
        return r18;
    L107:
        if (r20.a() != true) goto L109;
        r113 = true;
        goto L110
    L14:
        r20 = (SubProcHost.b) r15.L$3;
        r21 = (SubProcHost.c) r15.L$2;
        r110 = (String) r15.L$1;
        r111 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L99:
        PackageWrapper r115 = (PackageWrapper) r17;
        if (r115 == null) goto L104;
        r15.L$0 = r111;
        r15.L$1 = r110;
        r15.L$2 = r21;
        r15.L$3 = r20;
        r15.label = 9;
        if (r111.h0(r115, r15) != r18) goto L104;
        return r18;
    L15:
        SubProcHost.c r25 = (SubProcHost.c) r15.L$5;
        SubProcHost.c r26 = (SubProcHost.c) r15.L$4;
        Lazy r116 = (Lazy) r15.L$3;
        Function0 r117 = (Function0) r15.L$2;
        String r118 = (String) r15.L$1;
        r22 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L82:
        RequestParams r119 = (RequestParams) r17;
        if (r119 == null) goto L85;
        r20 = r25.a(r119);
        String r27 = r118;
        SubProcHost.c r120 = r26;
        Function0 r28 = r117;
        r112 = r27;
    L68:
        if (r20 != null) goto L88;
        r15.L$0 = r22;
        r15.L$1 = r112;
        r15.L$2 = r28;
        r15.L$3 = r116;
        r15.L$4 = null;
        r15.L$5 = null;
        r15.label = 5;
        if (DelayKt.b(1000, r15) != r18) goto L72;
        return r18;
    L72:
        Lazy r29 = r116;
        String r121 = r112;
        AIInferRuntime r122 = r22;
    L73:
        r15.L$0 = r122;
        r15.L$1 = r121;
        r15.L$2 = r28;
        r15.L$3 = r29;
        r15.label = 6;
        r17 = r122.d0(r121, r15);
        if (r17 == r18) goto L75;
    L17:
        r118 = r121;
        r22 = r122;
        r116 = r29;
        r117 = r28;
        r25 = (SubProcHost.c) r17;
        if (r25 == null) goto L87;
        r0<RequestParams> r30 = o0(r116).getSecond();
        r15.L$0 = r22;
        r15.L$1 = r118;
        r15.L$2 = r117;
        r15.L$3 = r116;
        r15.L$4 = r25;
        r15.L$5 = r25;
        r15.label = 7;
        r17 = r30.r(r15);
        if (r17 != r18) goto L81;
        return r18;
    L81:
        r26 = r25;
        goto L82
    L87:
        r28 = r117;
        r112 = r118;
        r120 = r25;
        r20 = null;
        goto L68
    L75:
        return r18;
    L88:
        r21 = r120;
    L89:
        if (r20 != null) goto L91;
    L93:
        boolean r123 = false;
    L94:
        if (r123 == false) goto L105;
        r0<PackageWrapper> r124 = o0(r116).getFirst();
        r15.L$0 = r22;
        r15.L$1 = r112;
        r15.L$2 = r21;
        r15.L$3 = r20;
        r15.L$4 = null;
        r15.L$5 = null;
        r15.label = 8;
        r17 = r124.r(r15);
        if (r17 != r18) goto L98;
        return r18;
    L98:
        r110 = r112;
        r111 = r22;
        goto L99
    L91:
        if (r20.c() != true) goto L93;
        r123 = true;
        goto L94
    L85:
        r117.invoke();
        throw new KotlinNothingValueException();
    L16:
        r29 = (Lazy) r15.L$3;
        r28 = (Function0) r15.L$2;
        r121 = (String) r15.L$1;
        r122 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
        goto L17
    L18:
        r29 = (Lazy) r15.L$3;
        r28 = (Function0) r15.L$2;
        r121 = (String) r15.L$1;
        r122 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
        goto L73
    L19:
        SubProcHost.c r31 = (SubProcHost.c) r15.L$5;
        SubProcHost.c r32 = (SubProcHost.c) r15.L$4;
        r116 = (Lazy) r15.L$3;
        Function0 r125 = (Function0) r15.L$2;
        String r126 = (String) r15.L$1;
        r22 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L61:
        RequestParams r127 = (RequestParams) r17;
        if (r127 == null) goto L64;
        r20 = r31.a(r127);
        String r33 = r126;
        r120 = r32;
        String r34 = r33;
    L67:
        Function0 r35 = r125;
        r112 = r34;
        r28 = r35;
        goto L68
    L64:
        r125.invoke();
        throw new KotlinNothingValueException();
    L20:
        Lazy r36 = (Lazy) r15.L$3;
        Function0 r37 = (Function0) r15.L$2;
        String r128 = (String) r15.L$1;
        AIInferRuntime r129 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
        r116 = r36;
        final AIInferRuntime this = r129;
        r125 = r37;
        r34 = r128;
    L55:
        r120 = (SubProcHost.c) r17;
        if (r120 == null) goto L66;
        r0<RequestParams> r130 = o0(r116).getSecond();
        r15.L$0 = this;
        r15.L$1 = r34;
        r15.L$2 = r125;
        r15.L$3 = r116;
        r15.L$4 = r120;
        r15.L$5 = r120;
        r15.label = 4;
        r17 = r130.r(r15);
        if (r17 != r18) goto L60;
        return r18;
    L60:
        r22 = this;
        r31 = r120;
        r126 = r34;
        r32 = r31;
        goto L61
    L66:
        r22 = this;
        r20 = null;
        goto L67
    L21:
        SubProcHost.c r38 = (SubProcHost.c) r15.L$5;
        r21 = (SubProcHost.c) r15.L$4;
        r116 = (Lazy) r15.L$3;
        Function0 r131 = (Function0) r15.L$2;
        String r132 = (String) r15.L$1;
        r22 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
    L45:
        RequestParams r133 = (RequestParams) r17;
        if (r133 == null) goto L48;
        r20 = r38.a(r133);
        r112 = r132;
        goto L89
    L48:
        r131.invoke();
        throw new KotlinNothingValueException();
    L22:
        Lazy r39 = (Lazy) r15.L$3;
        Function0 r40 = (Function0) r15.L$2;
        r11 = (String) r15.L$1;
        AIInferRuntime r134 = (AIInferRuntime) r15.L$0;
        ResultKt.throwOnFailure(r17);
        Lazy r41 = r39;
        this = r134;
        Object r135 = r17;
        Function0 r136 = r40;
    L37:
        SubProcHost.c r137 = (SubProcHost.c) r135;
    L38:
        Lazy r42 = r41;
        AIInferRuntime r43 = this;
        r38 = r137;
        r112 = r11;
        r116 = r42;
    L40:
        if (r38 == null) goto L50;
        r0<RequestParams> r138 = o0(r116).getSecond();
        r15.L$0 = r43;
        r15.L$1 = r112;
        r15.L$2 = r136;
        r15.L$3 = r116;
        r15.L$4 = r38;
        r15.L$5 = r38;
        r15.label = 2;
        Object r139 = r138.r(r15);
        if (r139 != r18) goto L44;
        return r18;
    L44:
        r22 = r43;
        r21 = r38;
        r132 = r112;
        r131 = r136;
        r17 = r139;
        goto L45
    L50:
        r22 = r43;
        r21 = r38;
        r20 = null;
        goto L89
    L23:
        ResultKt.throwOnFailure(r17);
        r136 = new AIInferRuntime$prepareSubProcessPackageInfo$throwGetPackageFailure$1(r12);
        r41 = LazyKt.lazy(new AIInferRuntime$prepareSubProcessPackageInfo$initParams$2(this, r10, r12, r13));
        if (r13 == false) goto L51;
        r137 = this.f5237a.f().c().get(r11);
        if (r137 != null) goto L38;
        d.b r140 = this.f5237a.l();
        if (r140 != null) goto L30;
    L32:
        boolean r141 = false;
    L33:
        if (r141 == false) goto L39;
        r15.L$0 = this;
        r15.L$1 = r11;
        r15.L$2 = r136;
        r15.L$3 = r41;
        r15.label = 1;
        r135 = d0(r11, r15);
        if (r135 != r18) goto L37;
        return r18;
    L39:
        r112 = r11;
        r116 = r41;
        r43 = this;
        r38 = null;
        goto L40
    L30:
        if (r140.b(r11) != true) goto L32;
        r141 = true;
        goto L33
    L51:
        r15.L$0 = this;
        r15.L$1 = r11;
        r15.L$2 = r136;
        r15.L$3 = r41;
        r15.label = 3;
        Object r142 = d0(r11, r15);
        if (r142 != r18) goto L54;
        return r18;
    L54:
        r116 = r41;
        r34 = r11;
        r17 = r142;
        r125 = r136;
        goto L55
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r15 = new AIInferRuntime$prepareSubProcessPackageInfo$1(this, r14);
        goto L8
    }

    public static final /* synthetic */ ConcurrentHashMap o(AIInferRuntime r10) {
        return r10.f5249m;
    }

    private static final Pair<r0<PackageWrapper>, r0<RequestParams>> o0(Lazy<? extends Pair<? extends r0<PackageWrapper>, ? extends r0<RequestParams>>> r10) {
        return (Pair) r10.getValue();
    }

    public static final /* synthetic */ v1 p(AIInferRuntime r10) {
        return r10.f5250n;
    }

    public static final /* synthetic */ Object q(AIInferRuntime r10, String r11, String r12, Continuation r13) {
        return r10.c0(r11, r12, r13);
    }

    private final synchronized void q0(AIPackage r10) {
        monitor-enter(this);
        String r11 = this.f5237a.h().getPreInitPackageName();     // Catch: Throwable -> L23
        if (r11 != null) goto L6;
    L11:
        PackageWrapper r12 = this.f5245i.get(r10.w());     // Catch: Throwable -> L23
        if (r12 != null) goto L14;
    L21:
        monitor-exit(this);
        return;
    L14:
        if (Intrinsics.areEqual(r12.f().getVersion(), r10.D()) == false) goto L21;
        if (com.obric.aikernel.res.metadata.d.f5055a.e(r10) == false) goto L20;
        u0(r10);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L20:
        this.f5245i.remove(r10.w());     // Catch: Throwable -> L23
        goto L21
    L6:
        if (Intrinsics.areEqual(r10.w(), r11) == false) goto L11;
        if (this.f5245i.get(r11) == null) goto L11;
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ Object r(AIInferRuntime r10, String r11, Continuation r12) {
        return r10.d0(r11, r12);
    }

    public static final /* synthetic */ Set s() {
        return f5236u;
    }

    private final void s0(String r10) {
        ConcurrentHashMap<String, g> r11 = this.f5249m;
        final AIInferRuntime$schedulePreparePackage$state$1 r12 = AIInferRuntime$schedulePreparePackage$state$1.INSTANCE;
        g r13 = r11.computeIfAbsent(r10, new com.obric.aikernel.runtime.a(r12));
        Intrinsics.checkNotNullExpressionValue(r13, "prepareScheduleState.com… PrepareScheduleState() }");
        g r14 = r13;
        monitor-enter(r14);
        boolean r15 = true;
        if (r14.b() == false) goto L7;
        r14.c(true);     // Catch: Throwable -> L14
        r15 = false;
    L8:
        monitor-exit(r14);
        if (r15 == true) goto L12;
        com.obric.aikernel.runtime.utils.d.f5417a.k("AIInferRuntime", "schedulePreparePackage merge pending " + r10);
        return;
    L12:
        kotlinx.coroutines.h.d(this.f5238b, this.f5248l.plus(new k0("preparePackage-" + r10)), null, new AIInferRuntime$schedulePreparePackage$1(r14, r10, this, null), 2, null);
        return;
    L7:
        r14.d(true);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ VmEngine t(AIInferRuntime r10) {
        return r10.f5244h;
    }

    private static final g t0(Function1 r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return (g) r10.invoke(r11);
    }

    public static final /* synthetic */ Object u(AIInferRuntime r10, String r11, String r12, String r13, Continuation r14) {
        return r10.e0(r11, r12, r13, r14);
    }

    private final void u0(AIPackage r10) {
        v0(r10.w());
    }

    public static final /* synthetic */ Object v(AIInferRuntime r10, Continuation r11) {
        return r10.k0(r11);
    }

    private final void v0(String r11) {
        Map<String, d.C0119d> r10 = this.f5237a.f().d();
        if (r10 == null) goto L19;
        ArrayList r12 = new ArrayList();
        Iterator<Map.Entry<String, d.C0119d>> r13 = r10.entrySet().iterator();
    L5:
        String r14 = null;
        if (r13.hasNext() == false) goto L12;
        Map.Entry<String, d.C0119d> r15 = r13.next();
        if (r15.getValue().a(r11) == false) goto L10;
        r14 = r15.getKey();
    L10:
        if (r14 == null) goto L5;
        r12.add(r14);
        goto L5
    L12:
        kotlinx.coroutines.h.d(this.f5238b, null, null, new AIInferRuntime$scheduleRestartByPackage$2$1(r11, this, r12, null), 3, null);
        return;
    }

    public static final /* synthetic */ Object w(AIInferRuntime r10, Function1 r11, String r12, RequestParams r13, boolean r14, Continuation r15) {
        return r10.n0(r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ void x(AIInferRuntime r10, AIPackage r11) {
        r10.q0(r11);
    }

    public static final /* synthetic */ void y(AIInferRuntime r10, long r11) {
        r10.f5255s = r11;
    }

    private final String y0(Map<String, UpdateResult> r12) {
        Collection<UpdateResult> r11 = r12.values();
        int r10 = 0;
        if ((r11 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        if (((UpdateResult) r13.next()).getSuccess() == false) goto L9;
        r10 = r10 + 1;
        if (r10 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        Collection<UpdateResult> r14 = r12.values();
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L22;
        Object r17 = r16.next();
        if (((UpdateResult) r17).getSuccess() == true) goto L17;
        r15.add(r17);
        goto L17
    L22:
        return "resultCount=" + r12.size() + " success=" + r10 + " failed=" + (r12.size() - r10) + " failureSummary=[" + CollectionsKt.joinToString$default(r15, null, null, null, 5, null, AIInferRuntime$summarizeUpdateResults$failureSummary$2.INSTANCE, 23, null) + ']';
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ void z(AIInferRuntime r10, v1 r11) {
        r10.f5250n = r11;
    }

    private final Object z0(String r10, Bundle r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AIInferRuntime$syncNativeLibInfo$1) == false) goto L7;
        AIInferRuntime$syncNativeLibInfo$1 r13 = (AIInferRuntime$syncNativeLibInfo$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L26:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        NativeLibVersionPolicy r18 = NativeLibVersionPolicy.INSTANCE;
        Map<String, String> r19 = r18.getNativeLibs(r11);
        if (r19 == null) goto L26;
        r18.setSubProcessVersionMap(r10, r19);
        if (r19.isEmpty() == false) goto L26;
        PackageResourceManager r20 = this.f5243g;
        if (r20 == null) goto L26;
        r0<Unit> r21 = r20.refreshAllPackageState();
        if (r21 == null) goto L26;
        r13.label = 1;
        if (r21.r(r13) != r16) goto L26;
        return r16;
    L7:
        r13 = new AIInferRuntime$syncNativeLibInfo$1(this, r12);
        goto L8
    }

    public final Object F0(String r11, boolean r12, Continuation<? super Map<String, UpdateResult>> r13) {
        if ((r13 instanceof AIInferRuntime$updateAll$1) == false) goto L7;
        AIInferRuntime$updateAll$1 r10 = (AIInferRuntime$updateAll$1) r13;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        boolean r18 = false;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        r12 = r10.Z$0;
        AIInferRuntime this = (AIInferRuntime) r10.L$1;
        r11 = (String) r10.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L37:
        Map<String, UpdateResult> r19 = (Map) r15;     // Catch: Throwable -> L14
        com.obric.aikernel.runtime.utils.d r20 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L14
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L14
        r21.append("updateAll end caller=");     // Catch: Throwable -> L14
        r21.append(r11);     // Catch: Throwable -> L14
        r21.append(" background=");     // Catch: Throwable -> L14
        if (r12 == false) goto L40;
        r18 = true;
    L40:
        r21.append(r18);     // Catch: Throwable -> L14
        r21.append(' ');     // Catch: Throwable -> L14
        r21.append(this.y0(r19));     // Catch: Throwable -> L14
        r20.g("AIInferRuntime", r21.toString());     // Catch: Throwable -> L14
        Object r110 = Result.m32constructorimpl((Map) r15);     // Catch: Throwable -> L14
    L43:
        Throwable r111 = Result.m35exceptionOrNullimpl(r110);
        if (r111 == null) goto L46;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "updateAll failed caller=" + r11 + " background=" + r12 + ' ' + ExceptionsKt.stackTraceToString(r111));
    L46:
        ResultKt.throwOnFailure(r110);
        return r110;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        com.obric.aikernel.runtime.utils.d r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r22 = new StringBuilder();
        r22.append("updateAll start caller=");
        r22.append(r11);
        r22.append(" background=");
        r22.append(r12);
        r22.append(" aikPmsNull=");
        if (this.f5243g != null) goto L21;
        boolean r23 = true;
    L22:
        r22.append(r23);
        r112.g("AIInferRuntime", r22.toString());
        PackageResourceManager r24 = this.f5243g;
        if (r24 != null) goto L26;
        r112.l("AIInferRuntime", "updateAll skip caller=" + r11 + " background=" + r12 + " because aikPms is null");
        return MapsKt.emptyMap();
    L26:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L14
        StringBuilder r26 = new StringBuilder();     // Catch: Throwable -> L14
        r26.append("updateAll enter PackageResourceManager.updateAll caller=");     // Catch: Throwable -> L14
        r26.append(r11);     // Catch: Throwable -> L14
        r26.append(" background=");     // Catch: Throwable -> L14
        if (r12 == false) goto L29;
        boolean r27 = true;
    L30:
        r26.append(r27);     // Catch: Throwable -> L14
        r112.g("AIInferRuntime", r26.toString());     // Catch: Throwable -> L14
        if (r12 == false) goto L33;
        boolean r113 = true;
    L34:
        r10.L$0 = r11;     // Catch: Throwable -> L14
        r10.L$1 = this;     // Catch: Throwable -> L14
        r10.Z$0 = r12;     // Catch: Throwable -> L14
        r10.label = 1;     // Catch: Throwable -> L14
        r15 = r24.updateAll(r11, r113, r10);     // Catch: Throwable -> L14
        if (r15 != r16) goto L37;
        return r16;
    L33:
        r113 = false;
        goto L34
    L29:
        r27 = false;
        goto L30
    L21:
        r23 = false;
    L14:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r10 = new AIInferRuntime$updateAll$1(this, r13);
        goto L8
    }

    public final Object H0(String r10, String r11, boolean r12, String r13, Continuation<? super PackageResource> r14) {
        return J0(r10, r11, r12, r13, false, r14);
    }

    public final Object I0(String r10, String r11, String r12, Continuation<? super Unit> r13) {
        if (this.f5243g != null) goto L14;
        MainHost.Proxy r14 = this.f5237a.f().b();
        if (r14 == null) goto L12;
        Object r15 = r14.d(r10, r11, r12, r13);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r15;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        Object r16 = H0(r10, r11, true, r12, r13);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r16;
    L20:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object K0(final String r10, RequestParams r11, String r12, final com.obric.aikernel.b r13, Continuation<? super Bundle> r14) {
        if ((r14 instanceof AIInferRuntime$vmExecute$1) == false) goto L7;
        AIInferRuntime$vmExecute$1 r15 = (AIInferRuntime$vmExecute$1) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        AIInferRuntime$vmExecute$1 r17 = r15;
        Object r18 = r17.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r17.label;
        if (r20 == 0) goto L14;
        if (r20 != 1) goto L13;
        Ref.ObjectRef r21 = (Ref.ObjectRef) r17.L$0;
        ResultKt.throwOnFailure(r18);
    L18:
        T r22 = r21.element;
        if (r22 != 0) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("ret");
        return null;
    L22:
        return (Bundle) r22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r18);
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        Function1<? super Bundle, Unit> r23 = new AIInferRuntime$vmExecute$2(this, r10, r110, r13);
        r17.L$0 = r110;
        r17.label = 1;
        if (L0(r10, r11, r12, r23, r17) != r19) goto L17;
        return r19;
    L17:
        r21 = r110;
    L7:
        r15 = new AIInferRuntime$vmExecute$1(this, r14);
        goto L8
    }

    public final Object L0(String r25, RequestParams r26, String r27, Function1<? super Bundle, Unit> r28, Continuation<? super Unit> r29) {
        AIInferRuntime r10 = this;
        String r11 = r25;
        final RequestParams r12 = r26;
        String r13 = r27;
        if ((r29 instanceof AIInferRuntime$vmExecute$3) == false) goto L7;
        AIInferRuntime$vmExecute$3 r14 = (AIInferRuntime$vmExecute$3) r29;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        AIInferRuntime$vmExecute$3 r16 = r14;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        if (r19 == 0) goto L25;
        if (r19 == 1) goto L24;
        if (r19 == 2) goto L22;
        if (r19 != 3) goto L14;
        String r20 = (String) r16.L$5;
        final Function1<? super Bundle, Unit> r21 = (Function1) r16.L$4;
        String r22 = (String) r16.L$3;
        final RequestParams r23 = (RequestParams) r16.L$2;
        String r24 = (String) r16.L$1;
        AIInferRuntime r30 = (AIInferRuntime) r16.L$0;
        ResultKt.throwOnFailure(r17);
        AIInferRuntime r110 = r30;
    L38:
        PackageWrapper r31 = (PackageWrapper) r17;
        Companion r32 = f5235t;
        AIInferRuntime$vmExecute$pkgInfo$1 r111 = new AIInferRuntime$vmExecute$pkgInfo$1(r31, null);
        Function1<Long, Unit> r112 = new AIInferRuntime$vmExecute$pkgInfo$2(r23);
        r16.L$0 = r110;
        r16.L$1 = r24;
        r16.L$2 = r23;
        r16.L$3 = r22;
        r16.L$4 = r21;
        r16.L$5 = r20;
        r16.L$6 = r31;
        String r113 = r20;
        r16.label = 4;
        Object r33 = r32.c(r111, r112, r16);
        if (r33 != r18) goto L41;
        return r18;
    L41:
        String r34 = r22;
        PackageWrapper r114 = r31;
        String r35 = r24;
        r17 = r33;
        String r36 = r113;
    L42:
        Pair r37 = (Pair) r17;
        if (r37 != null) goto L47;
        Bundle r38 = e8.a.B(new Bundle(), 109, "package " + r35 + " lora:" + r36 + " not available", false, 4, null);
    L45:
        r21.invoke(r38);
    L75:
        return Unit.INSTANCE;
    L47:
        if (((Number) r37.getFirst()).intValue() != 0) goto L60;
        final y6.b r39 = (y6.b) r37.getSecond();
        if (r39 == null) goto L56;
        com.obric.aikernel.runtime.utils.d r40 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r115 = new StringBuilder();
        String r116 = " lora:";
        r115.append("vmExecute gotPkgInfo ");
        r115.append(r35);
        r115.append(' ');
        r115.append(r36);
        r115.append(" request ");
        r115.append(r34);
        r115.append(' ');
        r115.append(r23.getClientId());
        r115.append(':');
        r115.append(r23.getTraceIdStr());
        r40.c("AIInferRuntime", r115.toString());
        VmEngine r41 = r110.f5244h;
        if (r41 == null) goto L57;
        Function1<Bundle, Unit> r117 = new AIInferRuntime$vmExecute$8$1(r39, r21);
        r16.L$0 = r35;
        r16.L$1 = r21;
        r16.L$2 = r36;
        r16.L$3 = null;
        r16.L$4 = null;
        r16.L$5 = null;
        r16.L$6 = null;
        r16.label = 5;
        if (r41.m(r39, r23, r34, r114, r117, r16) != r18) goto L55;
        return r18;
    L55:
        Unit r118 = Unit.INSTANCE;
    L58:
        if (r118 != null) goto L75;
        Bundle r42 = new Bundle();
        int r43 = 201;
        StringBuilder r44 = new StringBuilder();
        r44.append("package ");
        r44.append(r35);
        r44.append(r116);
        r44.append(r36);
        String r45 = " may take valid after process restart.";
    L61:
        r44.append(r45);
        Bundle r210 = r42;
        int r211 = r43;
        String r212 = r44.toString();
        boolean r213 = false;
        int r214 = 4;
        Object r215 = null;
    L62:
        r38 = e8.a.B(r210, r211, r212, r213, r214, r215);
    L57:
        r118 = null;
        goto L58
    L56:
        r116 = " lora:";
        goto L57
    L60:
        r42 = new Bundle();
        r43 = ((Number) r37.getFirst()).intValue();
        r44 = new StringBuilder();
        r44.append("get package ");
        r44.append(r35);
        r44.append(" lora:");
        r44.append(r36);
        r45 = " info failed!";
        goto L61
    L14:
        if (r19 != 4) goto L16;
        PackageWrapper r46 = (PackageWrapper) r16.L$6;
        String r47 = (String) r16.L$5;
        Function1<? super Bundle, Unit> r48 = (Function1) r16.L$4;
        String r49 = (String) r16.L$3;
        RequestParams r50 = (RequestParams) r16.L$2;
        String r51 = (String) r16.L$1;
        r110 = (AIInferRuntime) r16.L$0;
        ResultKt.throwOnFailure(r17);
        r114 = r46;
        r36 = r47;
        r21 = r48;
        r35 = r51;
        r34 = r49;
        r23 = r50;
        goto L42
    L16:
        if (r19 != 5) goto L19;
        r36 = (String) r16.L$2;
        r21 = (Function1) r16.L$1;
        r35 = (String) r16.L$0;
        ResultKt.throwOnFailure(r17);
        r116 = " lora:";
        goto L55
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Function1<? super Bundle, Unit> r52 = (Function1) r16.L$4;
        String r53 = (String) r16.L$3;
        r12 = (RequestParams) r16.L$2;
        String r54 = (String) r16.L$1;
        AIInferRuntime r55 = (AIInferRuntime) r16.L$0;
        ResultKt.throwOnFailure(r17);
        String r216 = r53;
        r21 = r52;
        String r56 = r54;
    L23:
        r23 = r12;
        r22 = r216;
        if (((Boolean) r17).booleanValue() == false) goto L63;
        String r57 = f5235t.a(r23.getBackend());
        r16.L$0 = r55;
        r16.L$1 = r56;
        r16.L$2 = r23;
        r16.L$3 = r22;
        r16.L$4 = r21;
        r16.L$5 = r57;
        r16.label = 3;
        Object r58 = r55.e0(r56, r57, r22, r16);
        if (r58 != r18) goto L37;
        return r18;
    L37:
        r110 = r55;
        r24 = r56;
        r20 = r57;
        r17 = r58;
        goto L38
    L63:
        r0<Boolean> r59 = r55.f5254r;
        if (r59 != null) goto L66;
    L68:
        boolean r60 = false;
    L69:
        if (r60 == false) goto L71;
    L73:
        r210 = new Bundle();
        r211 = 109;
        r212 = "preInitApp not available";
        r213 = false;
        r214 = 4;
        r215 = null;
        goto L62
    L71:
        if ((SystemClock.elapsedRealtime() - r55.f5255s) <= 5000) goto L73;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "preInitApp: reset init job");
        r55.f5254r = null;
        goto L73
    L66:
        if (r59.isActive() != true) goto L68;
        r60 = true;
        goto L69
    L24:
        Function1<? super Bundle, Unit> r61 = (Function1) r16.L$4;
        String r62 = (String) r16.L$3;
        r12 = (RequestParams) r16.L$2;
        String r63 = (String) r16.L$1;
        AIInferRuntime r64 = (AIInferRuntime) r16.L$0;
        ResultKt.throwOnFailure(r17);
        Function1<? super Bundle, Unit> r119 = r61;
        r10 = r64;
        r13 = r62;
        r11 = r63;
    L28:
        Companion r65 = f5235t;
        AIInferRuntime$vmExecute$6 r66 = new AIInferRuntime$vmExecute$6(r10, null);
        Function1<Long, Unit> r120 = new AIInferRuntime$vmExecute$7(r12);
        r16.L$0 = r10;
        r16.L$1 = r11;
        r16.L$2 = r12;
        r16.L$3 = r13;
        r16.L$4 = r119;
        r16.label = 2;
        r17 = r65.c(r66, r120, r16);
        if (r17 != r18) goto L31;
        return r18;
    L31:
        r55 = r10;
        r56 = r11;
        r21 = r119;
        r216 = r13;
        goto L23
    L25:
        ResultKt.throwOnFailure(r17);
        com.obric.aikernel.runtime.utils.d.f5417a.c("AIInferRuntime", "vmExecute receive " + r11 + " request " + r13 + ' ' + r26.getClientId() + ':' + r26.getTraceIdStr());
        Companion r67 = f5235t;
        AIInferRuntime$vmExecute$4 r68 = new AIInferRuntime$vmExecute$4(r10, null);
        Function1<Long, Unit> r121 = new AIInferRuntime$vmExecute$5(r12);
        r16.L$0 = r10;
        r16.L$1 = r11;
        r16.L$2 = r12;
        r16.L$3 = r13;
        r119 = r28;
        r16.L$4 = r119;
        r16.label = 1;
        if (r67.c(r68, r121, r16) != r18) goto L28;
        return r18;
    L7:
        r14 = new AIInferRuntime$vmExecute$3(r10, r29);
        goto L8
    }

    public final void M(FileDescriptor r10, PrintWriter r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "fout");
        Intrinsics.checkNotNullParameter(r12, "args");
        N(r11);
        com.obric.aikernel.runtime.e r13 = com.obric.aikernel.runtime.f.f5371a.a(r12);
        Boolean r14 = null;
        if (r13 != null) goto L5;
        String r15 = (String) CollectionsKt.firstOrNull(r12);
        if (r15 == null) goto L94;
        String r16 = "";
        switch(r15.hashCode()) {
            case -1557772738: goto L90;
            case -1333038649: goto L84;
            case -1298848381: goto L69;
            case -625596190: goto L65;
            case -518321244: goto L54;
            case 94746185: goto L50;
            case 1150401521: goto L46;
            case 1640790517: goto L42;
            case 1671308008: goto L29;
            case 1957569947: goto L21;
            default: goto L94;
        };
    L21:
        if (r15.equals("install") == false) goto L94;
        String r17 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r17 == null) goto L99;
        PackageResourceManager r18 = this.f5243g;
        if (r18 == null) goto L100;
        r18.installFromPath(r17);
        return;
    L100:
        return;
    L99:
        return;
    L29:
        if (r15.equals("disable") == false) goto L94;
        String r19 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r19 == null) goto L38;
        StringBuilder r20 = new StringBuilder();
        r20.append("AIInferRuntime ");
        r20.append(r15);
        r20.append(' ');
        r20.append(r19);
        r20.append(' ');
        PackageResourceManager r21 = this.f5243g;
        if (r21 == null) goto L79;
        AIPackage r22 = r21.getPackage(r19);
        if (r22 == null) goto L79;
        boolean r23 = r22.l();
    L78:
        r14 = Boolean.valueOf(r23);
    L79:
        r20.append(r14);
        String r24 = r20.toString();
    L95:
        r11.println(r24);
        return;
    L38:
        PackageResourceManager r25 = this.f5243g;
        if (r25 == null) goto L102;
        r25.disable("package", "", "");
        return;
    L102:
        return;
    L42:
        if (r15.equals("push_debug_package") == false) goto L94;
        l0 r26 = m0.a(z0.b());
        CoroutineContext r27 = null;
        CoroutineStart r28 = null;
        Function2 r29 = new AIInferRuntime$dump$11(r12, this, null);
    L93:
        kotlinx.coroutines.h.d(r26, r27, r28, r29, 3, null);
        return;
    L46:
        if (r15.equals("request_all") == false) goto L94;
        r26 = m0.a(z0.b());
        r27 = null;
        r28 = null;
        r29 = new AIInferRuntime$dump$4(r12, this, null);
        goto L93
    L50:
        if (r15.equals("clean") == false) goto L94;
        kotlinx.coroutines.h.f(null, new AIInferRuntime$dump$8(this, r11, null), 1, null);
        return;
    L54:
        if (r15.equals("check_time") == false) goto L94;
        StorageCleanerDaemon.a r30 = StorageCleanerDaemon.f5102e;
        StringBuilder r110 = new StringBuilder();
        r110.append(this.f5239c.getPath());
        String r111 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r111 == null) goto L60;
        r16 = r111;
    L60:
        r110.append(r16);
        String r112 = r110.toString();
        File r113 = new File(this.f5237a.b().getExternalCacheDir() + "/usage.txt");
        r113.delete();
        File r31 = r113.getParentFile();
        if (r31 == null) goto L63;
        r31.mkdirs();
    L63:
        Unit r32 = Unit.INSTANCE;
        r30.d(r112, r113, this.f5237a.h());
        return;
    L65:
        if (r15.equals("uninstall") == false) goto L94;
        g7.a.f9003a.a(r12, r11, new AIInferRuntime$dump$7(this));
        return;
    L69:
        if (r15.equals("enable") == false) goto L94;
        String r114 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r114 == null) goto L80;
        r20 = new StringBuilder();
        r20.append("AIInferRuntime ");
        r20.append(r15);
        r20.append(' ');
        r20.append(r114);
        r20.append(' ');
        PackageResourceManager r33 = this.f5243g;
        if (r33 == null) goto L79;
        AIPackage r34 = r33.getPackage(r114);
        if (r34 == null) goto L79;
        r23 = r34.m();
        goto L78
    L80:
        PackageResourceManager r35 = this.f5243g;
        if (r35 == null) goto L107;
        r35.enable("package", "", "");
        return;
    L107:
        return;
    L84:
        if (r15.equals("update_target") == false) goto L94;
        String r36 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r36 == null) goto L109;
        r26 = m0.a(z0.b());
        r27 = null;
        r28 = null;
        r29 = new AIInferRuntime$dump$5$1(this, r36, r12, null);
        goto L93
    L109:
        return;
    L90:
        if (r15.equals("clean_debug_res") == false) goto L94;
        r26 = m0.a(z0.a());
        r27 = null;
        r28 = null;
        r29 = new AIInferRuntime$dump$10(this, null);
    L94:
        r24 = "AIInferRuntime " + r15 + " not impl";
        goto L95
    L5:
        if ((r13 instanceof com.obric.aikernel.runtime.e.b) == false) goto L9;
        l0 r37 = m0.a(z0.b());
        CoroutineContext r38 = null;
        CoroutineStart r39 = null;
        Function2 r40 = new AIInferRuntime$dump$1$1(this, r13, null);
    L7:
        kotlinx.coroutines.h.d(r37, r38, r39, r40, 3, null);
        return;
    L9:
        if ((r13 instanceof com.obric.aikernel.runtime.e.c) == false) goto L12;
        r37 = m0.a(z0.b());
        r38 = null;
        r39 = null;
        r40 = new AIInferRuntime$dump$1$2(this, r13, null);
        goto L7
    L12:
        if ((r13 instanceof com.obric.aikernel.runtime.e.a) == false) goto L98;
        kotlinx.coroutines.h.f(null, new AIInferRuntime$dump$1$3(r11, this, r13, null), 1, null);
        return;
    }

    public final Object P(Continuation<? super List<com.obric.aikernel.res.metadata.config.e>> r10) {
        if ((r10 instanceof AIInferRuntime$getAllPackageConfigs$1) == false) goto L7;
        AIInferRuntime$getAllPackageConfigs$1 r11 = (AIInferRuntime$getAllPackageConfigs$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L19:
        List r16 = (List) r13;
        if (r16 == null) goto L22;
        return r16;
    L22:
        return CollectionsKt.emptyList();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        PackageResourceManager r17 = this.f5243g;
        if (r17 == null) goto L22;
        r11.label = 1;
        r13 = r17.getAllPackageConfigs(r11);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r11 = new AIInferRuntime$getAllPackageConfigs$1(this, r10);
        goto L8
    }

    public final List<y6.b> Q() {
        Map<String, PackageWrapper> r10 = this.f5245i;
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, PackageWrapper>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L14;
        Result<y6.b> r13 = r12.next().getValue().e();
        Object r14 = null;
        if (r13 == null) goto L12;
        Object r15 = r13.m41unboximpl();
        if (Result.m38isFailureimpl(r15) == true) goto L11;
        r14 = r15;
    L11:
        r14 = (y6.b) r14;
    L12:
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L14:
        return r11;
    }

    public final d R() {
        return this.f5237a;
    }

    public final Object U(Continuation<? super k> r10) {
        if ((r10 instanceof AIInferRuntime$getDownloadingSummary$1) == false) goto L7;
        AIInferRuntime$getDownloadingSummary$1 r11 = (AIInferRuntime$getDownloadingSummary$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L19:
        k r16 = (k) r13;
        if (r16 == null) goto L22;
        return r16;
    L22:
        return new k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        PackageResourceManager r17 = this.f5243g;
        if (r17 == null) goto L22;
        r11.label = 1;
        r13 = r17.getDownloadingSummary(r11);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r11 = new AIInferRuntime$getDownloadingSummary$1(this, r10);
        goto L8
    }

    public final Object V(String r17, String r18, Continuation<? super PackageResource> r19) {
        if ((r19 instanceof AIInferRuntime$getLoraPackage$1) == false) goto L7;
        AIInferRuntime$getLoraPackage$1 r10 = (AIInferRuntime$getLoraPackage$1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AIInferRuntime$getLoraPackage$1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        PackageResource r16 = (PackageResource) r12.L$1;
        PackageResource r20 = (PackageResource) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L37:
        List<PackageResource> r21 = CollectionsKt.mutableListOf(new PackageResource[]{(PackageResource) r13});
        List<PackageResource> r22 = r16.getSubRes();
        if (r22 != null) goto L41;
        r22 = CollectionsKt.emptyList();
    L41:
        r21.addAll(r22);
        r16.setSubRes(r21);
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        PackageResourceManager r23 = this.f5243g;
        if (r23 == null) goto L44;
        Pair<Lora, AIPackage> r110 = Lora.f5072s.a(r17, r18, r23.getContext());
        com.obric.aikernel.runtime.utils.d r24 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r25 = new StringBuilder();
        r25.append("getLoraPackage end ");
        r25.append(r17);
        r25.append(", ");
        r25.append(r18);
        r25.append(", ");
        Lora r111 = null;
        if (r110 == null) goto L21;
        AIPackage r26 = r110.getSecond();
        if (r26 == null) goto L21;
        PackageResource r27 = B0(r26);
    L22:
        r25.append(r27);
        r24.c("AIInferRuntime", r25.toString());
        if (r110 == null) goto L30;
        AIPackage r28 = r110.getSecond();
        if (r28 == null) goto L30;
        PackageResource r29 = B0(r28);
        if (r29 == null) goto L30;
        PackageResource r112 = r29;
    L31:
        if (r110 == null) goto L33;
        r111 = r110.getFirst();
    L33:
        r12.L$0 = r112;
        r12.L$1 = r112;
        r12.label = 1;
        r13 = C0(r111, r18, r12);
        if (r13 != r14) goto L36;
        return r14;
    L36:
        r16 = r112;
        r20 = r16;
    L30:
        r112 = new PackageResource(r17, 1, 0, null, 0, 28, null);
    L21:
        r27 = null;
        goto L22
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L7:
        r10 = new AIInferRuntime$getLoraPackage$1(this, r19);
        goto L8
    }

    public final Object X(String r13, Continuation<? super PackageResource> r14) {
        if ((r14 instanceof AIInferRuntime$getPackage$1) == false) goto L7;
        AIInferRuntime$getPackage$1 r10 = (AIInferRuntime$getPackage$1) r14;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r15 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r10.label;
        List<PackageResource> r17 = null;
        boolean r18 = true;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        PackageResource r19 = (PackageResource) r10.L$2;
        r13 = (String) r10.L$1;
        AIInferRuntime r20 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r15);
    L24:
        UpdateResult r110 = (UpdateResult) r15;
        if (r110 == null) goto L27;
        UpdateTaskConfig r111 = r110.getCfg();
        String r21 = r13;
    L29:
        com.obric.aikernel.runtime.utils.d r112 = com.obric.aikernel.runtime.utils.d.f5417a;
        StringBuilder r22 = new StringBuilder();
        r22.append("getPackage isAvailable= ");
        if (r19 == null) goto L32;
        Boolean r23 = Boxing.boxBoolean(r19.isAvailable());
    L33:
        r22.append(r23);
        r22.append("  updateInfo = ");
        r22.append(r111);
        r112.c("AIInferRuntime", r22.toString());
        if (r19 != null) goto L36;
    L38:
        boolean r24 = false;
    L39:
        if (r24 == false) goto L70;
        String r25 = r20.f5237a.h().getPreInitPackageName();
        if (r25 == null) goto L53;
        PackageWrapper r26 = r20.O(r25);
        if (r26 == null) goto L49;
        PackageResource r27 = r26.f();
        if (r27 == null) goto L49;
        if (r27.isAvailable() != true) goto L49;
        boolean r28 = true;
    L51:
        if ((!r28) != true) goto L53;
        boolean r29 = true;
    L54:
        if (r29 == false) goto L57;
        PackageResource r30 = new PackageResource(r21, 1, 0, r19.getVersion(), 1);
    L56:
        r30.setSubRes(r19.getSubRes());
        return r30;
    L57:
        if (r111 == null) goto L66;
        String r113 = r111.i();
        if (r113 == null) goto L66;
        AIPackage.a r31 = AIPackage.f5062u;
        if (r31.b(r19.getVersion()) >= r31.b(r113)) goto L63;
        boolean r114 = true;
    L64:
        if (r114 != true) goto L66;
    L67:
        if (r18 == false) goto L77;
        r30 = new PackageResource(r21, 1, 0, r19.getVersion(), r19.getSelfFlag() & (-5));
        goto L56
    L77:
        return r19;
    L63:
        r114 = false;
    L66:
        r18 = false;
    L49:
        r28 = false;
    L53:
        r29 = false;
        goto L54
    L70:
        if (r111 == null) goto L78;
        PackageResource r115 = new PackageResource(r21, 1, 0, r111.i(), 1);
        if (r19 == null) goto L74;
        r17 = r19.getSubRes();
    L74:
        r115.setSubRes(r17);
        return r115;
    L78:
        return null;
    L36:
        if (r19.isAvailable() != true) goto L38;
        r24 = true;
        goto L39
    L32:
        r23 = null;
        goto L33
    L27:
        PackageResource r116 = r19;
        AIInferRuntime this = r20;
    L28:
        r20 = this;
        r21 = r13;
        r19 = r116;
        r111 = null;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        PackageWrapper r117 = O(r13);
        if (r117 == null) goto L17;
        r116 = r117.f();
    L18:
        PackageResourceManager r32 = this.f5243g;
        if (r32 == null) goto L28;
        r10.L$0 = this;
        r10.L$1 = r13;
        r10.L$2 = r116;
        r10.label = 1;
        Object r33 = r32.getPackageUpdateInfo(r13, r10);
        if (r33 != r12) goto L23;
        return r12;
    L23:
        r20 = this;
        r19 = r116;
        r15 = r33;
        goto L24
    L17:
        r116 = null;
    L7:
        r10 = new AIInferRuntime$getPackage$1(this, r14);
        goto L8
    }

    public final Object Z(String r10, Continuation<? super Float> r11) {
        if ((r11 instanceof AIInferRuntime$getPackageUpdateProgress$1) == false) goto L7;
        AIInferRuntime$getPackageUpdateProgress$1 r12 = (AIInferRuntime$getPackageUpdateProgress$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L19:
        float r17 = ((Number) r14).floatValue();
    L22:
        return Boxing.boxFloat(r17);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        PackageResourceManager r18 = this.f5243g;
        if (r18 == null) goto L20;
        r12.label = 1;
        r14 = r18.getPackageUpdateProgress(r10, r12);
        if (r14 != r15) goto L19;
        return r15;
    L20:
        r17 = -1.0f;
    L7:
        r12 = new AIInferRuntime$getPackageUpdateProgress$1(this, r11);
        goto L8
    }

    public final l0 a0() {
        return this.f5238b;
    }

    public final SubProcHost b0() {
        return this.f5242f;
    }

    @com.obric.aee.utils.a
    @Keep
    public final String getDynamicPackageResources(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pkg");
        Intrinsics.checkNotNullParameter(r11, "lora");
        return (String) kotlinx.coroutines.h.f(null, new AnonymousClass1(this, r10, r11, null), 1, null);
    }

    public final void i0(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "pkg");
        Intrinsics.checkNotNullParameter(r11, "version");
        PackageResourceManager r13 = this.f5243g;
        if (r13 == null) goto L7;
        r13.markPackageCorrupt(r10, r11);
        Unit r14 = Unit.INSTANCE;
        if (r12 == false) goto L11;
        v0(r10);
        return;
    L11:
        return;
    L7:
        MainHost.Proxy r15 = this.f5237a.f().b();
        if (r15 == null) goto L13;
        r15.b(r10, r11, r12);
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00fa -> B:51:0x017e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0125 -> B:41:0x0128). Please report as a decompilation issue!!! */
    public final Object l0(String r18, String r19, boolean r20, RequestParams r21, Continuation<? super List<Pair<String, Boolean>>> r22) {
        if ((r22 instanceof AIInferRuntime$preparePackage$1) == false) goto L7;
        AIInferRuntime$preparePackage$1 r10 = (AIInferRuntime$preparePackage$1) r22;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        int r15 = 2;
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        boolean r16 = r10.Z$0;
        String r17 = (String) r10.L$6;
        Iterator<Map.Entry<String, d.C0119d>> r23 = (Iterator) r10.L$5;
        Function1<? super Continuation<? super PackageWrapper>, ? extends Object> r110 = (Function1) r10.L$4;
        List r111 = (List) r10.L$3;
        RequestParams r112 = (RequestParams) r10.L$2;
        String r113 = (String) r10.L$1;
        AIInferRuntime r114 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L41:
        Object r24 = Result.m32constructorimpl(Boxing.boxBoolean(((Boolean) r12).booleanValue()));     // Catch: Throwable -> L15
    L44:
        Throwable r25 = Result.m35exceptionOrNullimpl(r24);
        if (r25 == null) goto L48;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "prepareSubProcessPackageInfo failed, " + ExceptionsKt.stackTraceToString(r25));
    L48:
        if (Result.m38isFailureimpl(r24) == false) goto L50;
        r24 = null;
    L50:
        r111.add(new Pair(r17, Boxing.boxBoolean(Intrinsics.areEqual(r24, Boxing.boxBoolean(true)))));
    L51:
        r15 = 2;
    L31:
        if (r23.hasNext() == false) goto L53;
        Map.Entry<String, d.C0119d> r26 = r23.next();
        r17 = r26.getKey();
        if (r26.getValue().a(r113) == false) goto L51;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L15
        if (r16 == false) goto L37;
        boolean r28 = true;
    L38:
        r10.L$0 = r114;     // Catch: Throwable -> L15
        r10.L$1 = r113;     // Catch: Throwable -> L15
        r10.L$2 = r112;     // Catch: Throwable -> L15
        r10.L$3 = r111;     // Catch: Throwable -> L15
        r10.L$4 = r110;     // Catch: Throwable -> L15
        r10.L$5 = r23;     // Catch: Throwable -> L15
        r10.L$6 = r17;     // Catch: Throwable -> L15
        r10.Z$0 = r16;     // Catch: Throwable -> L15
        r10.label = r15;     // Catch: Throwable -> L15
        r12 = r114.n0(r110, r17, r112, r28, r10);     // Catch: Throwable -> L15
        if (r12 != r13) goto L41;
        return r13;
    L37:
        r28 = false;
        goto L38
    L53:
        return r111;
    L15:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L44
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        boolean r30 = r10.Z$0;
        RequestParams r31 = (RequestParams) r10.L$3;
        String r32 = (String) r10.L$2;
        String r33 = (String) r10.L$1;
        AIInferRuntime r115 = (AIInferRuntime) r10.L$0;
        ResultKt.throwOnFailure(r12);
        String r34 = r33;
        RequestParams r35 = r31;
        String r36 = r32;
    L27:
        ArrayList r37 = new ArrayList();
        AIInferRuntime$preparePackage$getWrapper$1 r116 = new AIInferRuntime$preparePackage$getWrapper$1(r115, r34, r36, r30, null);
        Map<String, d.C0119d> r38 = r115.f5237a.f().d();
        if (r38 == null) goto L56;
        r113 = r34;
        r112 = r35;
        r114 = r115;
        r110 = r116;
        r111 = r37;
        r23 = r38.entrySet().iterator();
        r16 = r30;
        goto L31
    L56:
        return r37;
    L20:
        ResultKt.throwOnFailure(r12);
        if (this.f5237a.f().a() == true) goto L23;
        return null;
    L23:
        r10.L$0 = this;
        r34 = r18;
        r10.L$1 = r34;
        r36 = r19;
        r10.L$2 = r36;
        r35 = r21;
        r10.L$3 = r35;
        r10.Z$0 = r20;
        r10.label = 1;
        if (M0(r10) != r13) goto L26;
        return r13;
    L26:
        r115 = this;
        r30 = r20;
    L7:
        r10 = new AIInferRuntime$preparePackage$1(this, r22);
        goto L8
    }

    public final Object p0(k r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AIInferRuntime$pushDebugDistributeInfo$1) == false) goto L7;
        AIInferRuntime$pushDebugDistributeInfo$1 r12 = (AIInferRuntime$pushDebugDistributeInfo$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L25
    L21:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Object r18 = Result.m32constructorimpl(r17);     // Catch: Throwable -> L25
    L27:
        Throwable r19 = Result.m35exceptionOrNullimpl(r18);
        if (r19 == null) goto L31;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "pushDebugDistributeInfo error " + ExceptionsKt.stackTraceToString(r19));
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L25
        PackageResourceManager r21 = this.f5243g;     // Catch: Throwable -> L25
        if (r21 == null) goto L22;
        r12.label = 1;     // Catch: Throwable -> L25
        if (r21.pushDebugDistributeInfo(r10, r12) != r15) goto L21;
        return r15;
    L22:
        r17 = null;
    L25:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r12 = new AIInferRuntime$pushDebugDistributeInfo$1(this, r11);
        goto L8
    }

    public final Object r0(String r10, Continuation<? super Unit> r11) {
        PackageResourceManager r12 = this.f5243g;
        if (r12 == null) goto L10;
        Object r13 = r12.resumeBlockedUpdateTasksIfNeed(r10, r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r13;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final Object w0(String r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AIInferRuntime$stopVmPackage$1) == false) goto L7;
        AIInferRuntime$stopVmPackage$1 r12 = (AIInferRuntime$stopVmPackage$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        Unit r17 = null;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        String r18 = (String) r12.L$1;
        AIInferRuntime r19 = (AIInferRuntime) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L32:
        r17 = Unit.INSTANCE;
        r10 = r18;
    L33:
        if (r17 != null) goto L36;
        com.obric.aikernel.runtime.utils.d.f5417a.l("AIInferRuntime", "try stopVmPackage " + r10 + " but no active service!");
    L36:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) r12.L$1;
        AIInferRuntime this = (AIInferRuntime) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        PackageWrapper r20 = (PackageWrapper) r14;
        if (r20 == null) goto L33;
        Result<y6.b> r21 = r20.e();
        if (r21 == null) goto L33;
        Object r22 = r21.m41unboximpl();
        if (Result.m38isFailureimpl(r22) == false) goto L26;
        r22 = null;
    L26:
        y6.b r23 = (y6.b) r22;
        if (r23 == null) goto L33;
        com.obric.aikernel.runtime.utils.d.f5417a.g("AIInferRuntime", "stopVmPackage " + r23);
        ExecutionEngine r24 = ExecutionEngine.f4305a;
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 2;
        if (r24.i(r23, r12) != r15) goto L31;
        return r15;
    L31:
        r18 = r10;
        goto L32
    L16:
        ResultKt.throwOnFailure(r14);
        r12.L$0 = this;
        r12.L$1 = r10;
        r12.label = 1;
        r14 = Y(r10, null, false, r12);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r12 = new AIInferRuntime$stopVmPackage$1(this, r11);
        goto L8
    }

    public final void x0(List<String> r10, List<? extends AIPackage> r11) {
        Intrinsics.checkNotNullParameter(r10, "infos");
        Intrinsics.checkNotNullParameter(r11, "pkgs");
        ArrayList r12 = new ArrayList();
        r12.addAll(r11);
        Iterator<T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        List r14 = StringsKt.split$default((String) r13.next(), new String[]{"@"}, false, 0, 6, null);
        String r15 = (String) CollectionsKt.firstOrNull(r14);
        if (Intrinsics.areEqual(r15, "package") == true) goto L7;
        if (Intrinsics.areEqual(r15, "lora") == false) goto L4;
        com.obric.aikernel.res.metadata.data.b r16 = new Lora((String) r14.get(1), (String) r14.get(2), this.f5237a.h());
    L8:
        r12.add(r16);
        goto L4
    L7:
        r16 = new AIPackage((String) r14.get(1), (String) r14.get(2), this.f5237a.h());
        goto L8
    L12:
        Iterator r17 = r12.iterator();
    L14:
        if (r17.hasNext() == false) goto L34;
        com.obric.aikernel.res.metadata.data.b r18 = (com.obric.aikernel.res.metadata.data.b) r17.next();
        if ((r18 instanceof AIPackage) == true) goto L17;
        if ((r18 instanceof Lora) == true) goto L20;
        com.obric.aikernel.runtime.utils.d.f5417a.e("AIInferRuntime", "vmProcessAddPackageInfo: not configured type " + r18);
        goto L14
    L20:
        Iterator r19 = r12.iterator();
    L22:
        if (r19.hasNext() == false) goto L32;
        Object r20 = r19.next();
        com.obric.aikernel.res.metadata.data.b r21 = (com.obric.aikernel.res.metadata.data.b) r20;
        if ((r21 instanceof AIPackage) == true) goto L26;
    L28:
        boolean r22 = false;
    L29:
        if (r22 == false) goto L22;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");
        F((AIPackage) r20, (Lora) r18);
        goto L14
    L26:
        if (Intrinsics.areEqual(r21.w(), ((Lora) r18).j0()) == false) goto L28;
        r22 = true;
        goto L29
    L32:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L17:
        G((AIPackage) r18);
        goto L14
    }
}
