package com.obric.aikernel.service.res;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.bytedance.crash.dumper.Scraps;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.ChargingStateListener;
import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.settings.AppSettingsManager;
import com.obric.aikernel.multiproc.InferForegroundService;
import com.obric.aikernel.multiproc.LLMForegroundService;
import com.obric.aikernel.multiproc.SubProcessManager;
import com.obric.aikernel.obric_os_feature.api.IModelPowerPerfManager;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class PythonRuntimeService implements com.obric.aikernel.service.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Regex f5479n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f5481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f5482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g1<Pair<Boolean, String>> f5483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g1<String> f5484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n f5486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private v1 f5487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f5488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f5489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e f5490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.obric.aikernel.middleware.interfaces.a> f5491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final r0<AIInferRuntime> f5492m;

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$2", f = "PythonRuntimeService.kt", i = {}, l = {520}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PythonRuntimeService f5493c;

            AnonymousClass1(PythonRuntimeService r10) {
                this.f5493c = r10;
            }

            public final Object a(int r10, Continuation<? super Unit> r11) {
                if ((r11 instanceof PythonRuntimeService$2$1$emit$1) == false) goto L7;
                PythonRuntimeService$2$1$emit$1 r12 = (PythonRuntimeService$2$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r12.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                AnonymousClass1<T> this = (AnonymousClass1) r12.L$0;
                ResultKt.throwOnFailure(r14);
            L17:
                PythonRuntimeService.v(this.f5493c, false, 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r14);
                PythonRuntimeService r17 = this.f5493c;
                r12.L$0 = this;
                r12.label = 1;
                if (PythonRuntimeService.p(r17, "thermal", r12) != r15) goto L17;
                return r15;
            L7:
                r12 = new PythonRuntimeService$2$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Number) r10).intValue(), r11);
            }
        }

        AnonymousClass2(PythonRuntimeService r10, Continuation<? super AnonymousClass2> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            g1<Integer> r13 = n7.a.f11264a.a();
            AnonymousClass1 r14 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$3, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$3", f = "PythonRuntimeService.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$3$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PythonRuntimeService f5494c;

            AnonymousClass1(PythonRuntimeService r10) {
                this.f5494c = r10;
            }

            public final Object a(int r10, Continuation<? super Unit> r11) {
                if ((r11 instanceof PythonRuntimeService$3$1$emit$1) == false) goto L7;
                PythonRuntimeService$3$1$emit$1 r12 = (PythonRuntimeService$3$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r12.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                AnonymousClass1<T> this = (AnonymousClass1) r12.L$0;
                ResultKt.throwOnFailure(r14);
            L17:
                PythonRuntimeService.v(this.f5494c, false, 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r14);
                PythonRuntimeService r17 = this.f5494c;
                r12.L$0 = this;
                r12.label = 1;
                if (PythonRuntimeService.p(r17, Scraps.BATTERY, r12) != r15) goto L17;
                return r15;
            L7:
                r12 = new PythonRuntimeService$3$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Number) r10).intValue(), r11);
            }
        }

        AnonymousClass3(PythonRuntimeService r10, Continuation<? super AnonymousClass3> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass3(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            g1<Integer> r13 = com.obric.aikernel.middleware.api.appcontext.receiver.a.f4528a.c();
            AnonymousClass1 r14 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$4, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$4", f = "PythonRuntimeService.kt", i = {}, l = {533}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$4$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PythonRuntimeService f5495c;

            AnonymousClass1(PythonRuntimeService r10) {
                this.f5495c = r10;
            }

            public final Object a(boolean r10, Continuation<? super Unit> r11) {
                if ((r11 instanceof PythonRuntimeService$4$1$emit$1) == false) goto L7;
                PythonRuntimeService$4$1$emit$1 r12 = (PythonRuntimeService$4$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r12.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                AnonymousClass1<T> this = (AnonymousClass1) r12.L$0;
                ResultKt.throwOnFailure(r14);
            L17:
                PythonRuntimeService.v(this.f5495c, false, 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r14);
                PythonRuntimeService r17 = this.f5495c;
                r12.L$0 = this;
                r12.label = 1;
                if (PythonRuntimeService.p(r17, "charging", r12) != r15) goto L17;
                return r15;
            L7:
                r12 = new PythonRuntimeService$4$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Boolean) r10).booleanValue(), r11);
            }
        }

        AnonymousClass4(PythonRuntimeService r10, Continuation<? super AnonymousClass4> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass4(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass4) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            p1<Boolean> r13 = ChargingStateListener.f4508a.b();
            AnonymousClass1 r14 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (r13.a(r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$5, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$5", f = "PythonRuntimeService.kt", i = {}, l = {541}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$5$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<NetworkStateListener.b> f5496c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ PythonRuntimeService f5497g;

            AnonymousClass1(Ref.ObjectRef<NetworkStateListener.b> r10, PythonRuntimeService r11) {
                this.f5496c = r10;
                this.f5497g = r11;
            }

            public final Object a(NetworkStateListener.b r10, Continuation<? super Unit> r11) {
                if ((r11 instanceof PythonRuntimeService$5$1$emit$1) == false) goto L7;
                PythonRuntimeService$5$1$emit$1 r12 = (PythonRuntimeService$5$1$emit$1) r11;
                int r13 = r12.label;
                if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
                r12.label = r13 - Integer.MIN_VALUE;
            L8:
                Object r14 = r12.result;
                Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r16 = r12.label;
                if (r16 == 0) goto L14;
                if (r16 != 1) goto L13;
                boolean r17 = r12.Z$0;
                Object r18 = (T) ((NetworkStateListener.b) r12.L$1);
                AnonymousClass1<T> r19 = (AnonymousClass1) r12.L$0;
                ResultKt.throwOnFailure(r14);
                Object r20 = r18;
            L18:
                if (r17 == false) goto L20;
                PythonRuntimeService.f(r19.f5497g, AutoUpdateCheckSource.NETWORK);
            L20:
                r19.f5496c.element = (T) r20;
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r14);
                NetworkStateListener.b r110 = this.f5496c.element;
                boolean r21 = com.obric.aikernel.service.res.c.c(r110, r10);
                AIKLog.INSTANCE.i("PythonRuntimeService", "network snapshot collected previous=" + r110 + " current=" + r10 + " resumeBlockedUpdateTasksIfNeed=true recheckAutoUpdate=" + r21);
                PythonRuntimeService r22 = this.f5497g;
                StringBuilder r23 = new StringBuilder();
                r23.append("network previous=");
                r23.append(r110);
                r23.append(" current=");
                r23.append(r10);
                String r111 = r23.toString();
                r12.L$0 = this;
                r12.L$1 = r10;
                r12.Z$0 = r21;
                r12.label = 1;
                if (PythonRuntimeService.q(r22, r111, r12) != r15) goto L17;
                return r15;
            L17:
                r19 = this;
                r17 = r21;
                r20 = r10;
            L7:
                r12 = new PythonRuntimeService$5$1$emit$1(this, r11);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a((NetworkStateListener.b) r10, r11);
            }
        }

        AnonymousClass5(PythonRuntimeService r10, Continuation<? super AnonymousClass5> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass5(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass5) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Ref.ObjectRef r13 = new Ref.ObjectRef();
            g1<NetworkStateListener.b> r14 = NetworkStateListener.f4510a.j();
            AnonymousClass1 r15 = new AnonymousClass1(r13, this.this$0);
            this.label = 1;
            if (r14.a(r15, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$6, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$6", f = "PythonRuntimeService.kt", i = {}, l = {561}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PythonRuntimeService this$0;

        AnonymousClass6(PythonRuntimeService r10, Continuation<? super AnonymousClass6> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass6(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass6) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            PythonRuntimeService r13 = this.this$0;
            this.label = 1;
            if (PythonRuntimeService.o(r13, this) != r11) goto L12;
            return r11;
        }
    }

    private static final enum AutoUpdateCheckSource extends Enum<AutoUpdateCheckSource> {
        private static final /* synthetic */ AutoUpdateCheckSource[] $VALUES = null;
        public static final AutoUpdateCheckSource CONSTRAINT = null;
        public static final AutoUpdateCheckSource NETWORK = null;
        public static final AutoUpdateCheckSource RETRY = null;
        public static final AutoUpdateCheckSource STARTUP = null;

        private static final /* synthetic */ AutoUpdateCheckSource[] $values() {
            return new AutoUpdateCheckSource[]{STARTUP, NETWORK, RETRY, CONSTRAINT};
        }

        static {
            STARTUP = new AutoUpdateCheckSource("STARTUP", 0);
            NETWORK = new AutoUpdateCheckSource("NETWORK", 1);
            RETRY = new AutoUpdateCheckSource("RETRY", 2);
            CONSTRAINT = new AutoUpdateCheckSource("CONSTRAINT", 3);
            $VALUES = $values();
        }

        private AutoUpdateCheckSource(String r10, int r11) {
            super(r10, r11);
        }

        public static AutoUpdateCheckSource valueOf(String r10) {
            return (AutoUpdateCheckSource) Enum.valueOf(AutoUpdateCheckSource.class, r10);
        }

        public static AutoUpdateCheckSource[] values() {
            return (AutoUpdateCheckSource[]) $VALUES.clone();
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f5499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f5500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f5501d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5502e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f5503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f5504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f5505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f5506i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f5507j;

        public a(String r10, int r11, boolean r12, int r13, boolean r14, boolean r15, boolean r16, String r17, boolean r18, String r19) {
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r17, "currentReason");
            Intrinsics.checkNotNullParameter(r19, "nextReason");
            this.f5498a = r10;
            this.f5499b = r11;
            this.f5500c = r12;
            this.f5501d = r13;
            this.f5502e = r14;
            this.f5503f = r15;
            this.f5504g = r16;
            this.f5505h = r17;
            this.f5506i = r18;
            this.f5507j = r19;
        }

        public final int a() {
            return this.f5501d;
        }

        public final boolean b() {
            return this.f5503f;
        }

        public final boolean c() {
            return this.f5504g;
        }

        public final String d() {
            return this.f5505h;
        }

        public final boolean e() {
            return this.f5506i;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f5498a, r11.f5498a) == true) goto L12;
            return false;
        L12:
            if (this.f5499b == r11.f5499b) goto L15;
            return false;
        L15:
            if (this.f5500c == r11.f5500c) goto L18;
            return false;
        L18:
            if (this.f5501d == r11.f5501d) goto L21;
            return false;
        L21:
            if (this.f5502e == r11.f5502e) goto L24;
            return false;
        L24:
            if (this.f5503f == r11.f5503f) goto L27;
            return false;
        L27:
            if (this.f5504g == r11.f5504g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f5505h, r11.f5505h) == true) goto L33;
            return false;
        L33:
            if (this.f5506i == r11.f5506i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f5507j, r11.f5507j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final String f() {
            return this.f5507j;
        }

        public final String g() {
            return this.f5498a;
        }

        public final int h() {
            return this.f5499b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int r10 = ((this.f5498a.hashCode() * 31) + Integer.hashCode(this.f5499b)) * 31;
            boolean r11 = this.f5500c;
            ?? r12 = 1;
            ?? r13 = r11;
            if (r11 == false) goto L5;
            r13 = 1;
        L5:
            int r14 = (((r10 + r13) * 31) + Integer.hashCode(this.f5501d)) * 31;
            boolean r15 = this.f5502e;
            ?? r16 = r15;
            if (r15 == false) goto L8;
            r16 = 1;
        L8:
            int r17 = (r14 + r16) * 31;
            boolean r18 = this.f5503f;
            ?? r19 = r18;
            if (r18 == false) goto L11;
            r19 = 1;
        L11:
            int r20 = (r17 + r19) * 31;
            boolean r21 = this.f5504g;
            ?? r22 = r21;
            if (r21 == false) goto L14;
            r22 = 1;
        L14:
            int r23 = (((r20 + r22) * 31) + this.f5505h.hashCode()) * 31;
            boolean r24 = this.f5506i;
            if (r24 == true) goto L19;
            r12 = r24;
        L19:
            return ((r23 + r12) * 31) + this.f5507j.hashCode();
        }

        public final boolean i() {
            return this.f5500c;
        }

        public final boolean j() {
            return this.f5502e;
        }

        public String toString() {
            return "AllowBgUpdateSnapshot(source=" + this.f5498a + ", thermalStatus=" + this.f5499b + ", thermalStatusMeet=" + this.f5500c + ", batteryLevel=" + this.f5501d + ", isCharging=" + this.f5502e + ", batteryStatusMeet=" + this.f5503f + ", currentAllowed=" + this.f5504g + ", currentReason=" + this.f5505h + ", nextAllowed=" + this.f5506i + ", nextReason=" + this.f5507j + ')';
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AutoUpdateCheckSource f5508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f5511d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f5512e;

        public b(AutoUpdateCheckSource r10, boolean r11, long r12, long r13, long r14) {
            Intrinsics.checkNotNullParameter(r10, "source");
            this.f5508a = r10;
            this.f5509b = r11;
            this.f5510c = r12;
            this.f5511d = r13;
            this.f5512e = r14;
        }

        public final long a() {
            return this.f5511d;
        }

        public final AutoUpdateCheckSource b() {
            return this.f5508a;
        }

        public final long c() {
            return this.f5510c;
        }

        public final boolean d() {
            return this.f5509b;
        }

        public final long e() {
            return this.f5512e;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (this.f5508a == r11.f5508a) goto L12;
            return false;
        L12:
            if (this.f5509b == r11.f5509b) goto L15;
            return false;
        L15:
            if (this.f5510c == r11.f5510c) goto L18;
            return false;
        L18:
            if (this.f5511d == r11.f5511d) goto L21;
            return false;
        L21:
            if (this.f5512e == r11.f5512e) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            int r10 = this.f5508a.hashCode() * 31;
            boolean r11 = this.f5509b;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return ((((((r10 + r12) * 31) + Long.hashCode(this.f5510c)) * 31) + Long.hashCode(this.f5511d)) * 31) + Long.hashCode(this.f5512e);
        }

        public String toString() {
            return "AutoUpdateTriggerSnapshot(source=" + this.f5508a + ", startup=" + this.f5509b + ", startTimeMills=" + this.f5510c + ", intervalMills=" + this.f5511d + ", triggerToken=" + this.f5512e + ')';
        }
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new c(null);
        f5479n = new Regex("File \"<?(.+?)>?\", line (\\d+), in (.+)");
    }

    public PythonRuntimeService(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.f5480a = r10;
        this.f5481b = LazyKt.lazy(PythonRuntimeService$useObricDownloader$2.INSTANCE);
        this.f5482c = LazyKt.lazy(PythonRuntimeService$distributeApi$2.INSTANCE);
        this.f5483d = q1.a(new Pair(Boolean.FALSE, "default disable"));
        this.f5484e = q1.a("");
        this.f5485f = SystemClock.elapsedRealtime();
        this.f5486g = new n(false, false, null, 7, null);
        this.f5491l = new CopyOnWriteArrayList();
        this.f5492m = kotlinx.coroutines.h.b(m0.a(z0.b()), null, null, new PythonRuntimeService$inferRuntime$1(this, null), 3, null);
        IModelPowerPerfManager r11 = y7.a.a();
        if (r11 == null) goto L5;
        K(r11);
    L5:
        u(true);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass2(this, null), 3, null);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass3(this, null), 3, null);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass4(this, null), 3, null);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass5(this, null), 3, null);
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new AnonymousClass6(this, null), 3, null);
    }

    private final boolean D() {
        return ((Boolean) this.f5481b.getValue()).booleanValue();
    }

    private final void E(RequestParams r10, Bundle r11) {
        O(true);
        Iterator<T> r12 = this.f5491l.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((com.obric.aikernel.middleware.interfaces.a) r12.next()).notifyVMExecuteBegin(r10, r11);
        goto L4
    }

    private final void F(RequestParams r10) {
        O(false);
        Iterator<T> r11 = this.f5491l.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((com.obric.aikernel.middleware.interfaces.a) r11.next()).notifyVMExecuteEnd(r10);
        goto L4
    }

    private final void G(com.obric.aikernel.res.update.a r11) {
        monitor-enter(this);
        boolean r10 = false;
        if (this.f5486g.d() == true) goto L6;
    L22:
        Long r12 = null;
    L23:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L39
        monitor-exit(this);
        if (r12 == null) goto L27;
        N(r12.longValue());
        return;
    L27:
        if (r10 == false) goto L46;
        monitor-enter(this);
        v1 r14 = this.f5487h;     // Catch: Throwable -> L35
        if (r14 == null) goto L32;
        v1.a.a(r14, null, 1, null);     // Catch: Throwable -> L35
    L32:
        this.f5487h = null;     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L35:
        th = move-exception;
        throw th;
    L46:
        return;
    L6:
        if (Intrinsics.areEqual(r11.b(), ":autoupdate") == false) goto L22;
        if (r11.d() == true) goto L11;
        this.f5486g = new n(false, false, null, 6, null);     // Catch: Throwable -> L39
        this.f5485f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L39
        r10 = true;
        goto L22
    L11:
        m r15 = l.d(this.f5486g, r11.e(), r11.c());     // Catch: Throwable -> L39
        this.f5486g = r15.c();     // Catch: Throwable -> L39
        if (r15.a() == false) goto L14;
        this.f5485f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L39
    L14:
        r12 = r15.b();     // Catch: Throwable -> L39
        if (r15.b() != null) goto L17;
        r10 = true;
    L17:
        AIKLog r16 = AIKLog.INSTANCE;     // Catch: Throwable -> L39
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L39
        r17.append("startup auto update attempt success=");     // Catch: Throwable -> L39
        r17.append(r11.e());     // Catch: Throwable -> L39
        r17.append(" failureKind=");     // Catch: Throwable -> L39
        r17.append(r11.c());     // Catch: Throwable -> L39
        r17.append(" cached=");     // Catch: Throwable -> L39
        r17.append(r11.a());     // Catch: Throwable -> L39
        r17.append(" pending=");     // Catch: Throwable -> L39
        r17.append(this.f5486g.d());     // Catch: Throwable -> L39
        r17.append(" retry=");     // Catch: Throwable -> L39
        if (r12 == null) goto L20;
        long r18 = r12.longValue();     // Catch: Throwable -> L39
    L21:
        r17.append(r18);     // Catch: Throwable -> L39
        r17.append(" reason=");     // Catch: Throwable -> L39
        r17.append(r11.f());     // Catch: Throwable -> L39
        r16.i("PythonRuntimeService", r17.toString());     // Catch: Throwable -> L39
        goto L23
    L20:
        r18 = 0;
    L39:
        th = move-exception;
        throw th;
    }

    private final Object H(Continuation<? super Unit> r10) {
        if ((r10 instanceof PythonRuntimeService$preloadSubprocess$1) == false) goto L7;
        PythonRuntimeService$preloadSubprocess$1 r11 = (PythonRuntimeService$preloadSubprocess$1) r10;
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
    L22:
        if (Intrinsics.areEqual(((AIInferRuntime) r13).R().g(), AppContext.INSTANCE.getPackageName()) == false) goto L25;
        SubProcessManager.f4700a.f();
    L25:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        com.obric.aikernel.multiproc.d r16 = com.obric.aikernel.multiproc.d.f4707a;
        if (Intrinsics.areEqual(r16.b(), r16.e()) == true) goto L17;
        r0<AIInferRuntime> r17 = this.f5492m;
        r11.label = 1;
        r13 = r17.r(r11);
        if (r13 != r14) goto L22;
        return r14;
    L17:
        return Unit.INSTANCE;
    L7:
        r11 = new PythonRuntimeService$preloadSubprocess$1(this, r10);
        goto L8
    }

    private final Object L(String r10, Continuation<? super Unit> r11) {
        if (s(r10) == false) goto L10;
        Object r12 = M("background gate " + r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r12;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final Object M(String r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1) == false) goto L7;
        PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1 r12 = (PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L17;
        if (r16 != 2) goto L16;
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L29
    L27:
        Object r17 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L35;
        AIKLog.INSTANCE.e("PythonRuntimeService", "resumeBlockedUpdateTasksIfNeed failed trigger=" + r10 + ' ' + ExceptionsKt.stackTraceToString(r18));
    L35:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L29
    L24:
        r12.L$0 = r10;     // Catch: Throwable -> L29
        r12.label = 2;     // Catch: Throwable -> L29
        if (((AIInferRuntime) r14).r0(r10, r12) != r15) goto L27;
        return r15;
    L20:
        ResultKt.throwOnFailure(r14);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L29
        r0<AIInferRuntime> r20 = this.f5492m;     // Catch: Throwable -> L29
        r12.L$0 = r10;     // Catch: Throwable -> L29
        r12.label = 1;     // Catch: Throwable -> L29
        r14 = r20.r(r12);     // Catch: Throwable -> L29
        if (r14 != r15) goto L24;
        return r15;
    L29:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r12 = new PythonRuntimeService$resumeBlockedUpdateTasksIfNeed$1(this, r11);
        goto L8
    }

    private final void N(long r10) {
        monitor-enter(this);
        v1 r11 = this.f5487h;     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        v1.a.a(r11, null, 1, null);     // Catch: Throwable -> L9
    L6:
        this.f5487h = kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new PythonRuntimeService$scheduleStartupAutoUpdateRetry$1$1(r10, this, null), 3, null);     // Catch: Throwable -> L9
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private final void O(boolean r10) {
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        if (r10 == false) goto L5;
        InferForegroundService.f4690g.b(this.f5480a);     // Catch: Throwable -> L8
        LLMForegroundService.f4695g.b(this.f5480a);     // Catch: Throwable -> L8
    L6:
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L16;
        AIKLog.INSTANCE.w("PythonRuntimeService", "syncExecutionForegroundService started=" + r10 + " failed: " + r13);
        return;
    L16:
        return;
    L5:
        InferForegroundService.f4690g.a(this.f5480a);     // Catch: Throwable -> L8
        LLMForegroundService.f4695g.a(this.f5480a);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static /* synthetic */ Object Q(PythonRuntimeService r10, String r11, boolean r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = true;
    L6:
        return r10.P(r11, r12, r13);
    }

    public static /* synthetic */ Object S(PythonRuntimeService r10, String r11, String r12, boolean r13, String r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        r13 = false;
    L5:
        boolean r18 = r13;
        if ((r16 & 8) == 0) goto L9;
        r14 = "";
    L9:
        return r10.R(r11, r12, r18, r14, r15);
    }

    public static final /* synthetic */ String d(PythonRuntimeService r10, String r11) {
        return r10.r(r11);
    }

    public static final /* synthetic */ boolean e(PythonRuntimeService r10, String r11) {
        return r10.s(r11);
    }

    public static final /* synthetic */ void f(PythonRuntimeService r10, AutoUpdateCheckSource r11) {
        r10.t(r11);
    }

    public static final /* synthetic */ g1 g(PythonRuntimeService r10) {
        return r10.f5483d;
    }

    public static final /* synthetic */ Context h(PythonRuntimeService r10) {
        return r10.f5480a;
    }

    public static final /* synthetic */ com.obric.aikernel.model.cloud.common.e i(PythonRuntimeService r10) {
        return r10.w();
    }

    public static final /* synthetic */ r0 j(PythonRuntimeService r10) {
        return r10.f5492m;
    }

    public static final /* synthetic */ g1 k(PythonRuntimeService r10) {
        return r10.f5484e;
    }

    public static final /* synthetic */ void l(PythonRuntimeService r10, RequestParams r11, Bundle r12) {
        r10.E(r11, r12);
    }

    public static final /* synthetic */ void m(PythonRuntimeService r10, RequestParams r11) {
        r10.F(r11);
    }

    public static final /* synthetic */ void n(PythonRuntimeService r10, com.obric.aikernel.res.update.a r11) {
        r10.G(r11);
    }

    public static final /* synthetic */ Object o(PythonRuntimeService r10, Continuation r11) {
        return r10.H(r11);
    }

    public static final /* synthetic */ Object p(PythonRuntimeService r10, String r11, Continuation r12) {
        return r10.L(r11, r12);
    }

    public static final /* synthetic */ Object q(PythonRuntimeService r10, String r11, Continuation r12) {
        return r10.M(r11, r12);
    }

    private final String r(String r24) {
        List r10 = StringsKt.split$default(r24, new char[]{'\n'}, false, 0, 6, null);
        List r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L32;
        Object r13 = r12.next();
        if ((!StringsKt.isBlank((String) r13)) == false) goto L4;
        r11.add(r13);
        goto L4
    L32:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L10
        Object r15 = Result.m32constructorimpl(r11.subList(1, r11.size() - 1));     // Catch: Throwable -> L10
    L13:
        if (Result.m38isFailureimpl(r15) == false) goto L15;
        r15 = null;
    L15:
        List r16 = (List) r15;
        if (r16 == null) goto L19;
        r11 = r16;
    L19:
        List r17 = CollectionsKt.reversed(r11);
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        r18.add(Regex.find$default(f5479n, StringsKt.trim((String) r19.next()).toString(), 0, 2, null));
        goto L21
    L23:
        List r20 = CollectionsKt.filterNotNull(r18);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r21 = r20.iterator();
        int r22 = 0;
    L25:
        if (r21.hasNext() == false) goto L31;
        Object r23 = r21.next();
        int r25 = r22 + 1;
        if (r22 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        MatchResult.Destructured r26 = ((MatchResult) r23).getDestructured();
        String r111 = r26.getMatch().getGroupValues().get(1);
        String r27 = r26.getMatch().getGroupValues().get(2);
        String r28 = r26.getMatch().getGroupValues().get(3);
        StringBuilder r29 = new StringBuilder();
        r29.append('#');
        StringCompanionObject r30 = StringCompanionObject.INSTANCE;
        String r31 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r22)}, 1));
        Intrinsics.checkNotNullExpressionValue(r31, "format(format, *args)");
        r29.append(r31);
        r29.append(" pc 0000000000000000  ");
        r29.append(StringsKt.replace$default(StringsKt.replace$default(r111, ' ', '.', false, 4, null), '.', '/', false, 4, null));
        r29.append(".py (");
        r29.append(r28);
        r29.append('+');
        r29.append(r27);
        r29.append(')');
        r110.add(r29.toString());
        r22 = r25;
        goto L25
    L31:
        return CollectionsKt.joinToString$default(r110, "\n", null, null, 0, null, null, 62, null);
    L10:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r15 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final boolean s(String r17) {
        monitor-enter(this);
        Pair<Boolean, String> r10 = this.f5483d.getValue();     // Catch: Throwable -> L66
        int r11 = n7.a.f11264a.a().getValue().intValue();     // Catch: Throwable -> L66
        if (r11 >= 2) goto L7;
        boolean r12 = true;
    L8:
        int r13 = com.obric.aikernel.middleware.api.appcontext.receiver.a.f4528a.c().getValue().intValue();     // Catch: Throwable -> L66
        boolean r14 = ChargingStateListener.f4508a.e();     // Catch: Throwable -> L66
        if (r13 <= 50) goto L12;
        if (r14 == false) goto L12;
        boolean r15 = true;
    L13:
        String r16 = com.obric.aikernel.service.res.c.b(r13, r14);     // Catch: Throwable -> L66
        if (r10.getFirst().booleanValue() == false) goto L20;
        if (r12 == true) goto L17;
        e r18 = new e(false, "disallowed by thermal:" + r11);     // Catch: Throwable -> L66
    L27:
        e r19 = com.obric.aikernel.service.res.c.a(r18, this.f5490k);     // Catch: Throwable -> L66
        boolean r110 = com.obric.aikernel.service.res.c.d(new e(r10.getFirst().booleanValue(), r10.getSecond()), r19);     // Catch: Throwable -> L66
        Pair<Boolean, String> r111 = new Pair(Boolean.valueOf(r19.a()), r19.b());     // Catch: Throwable -> L66
        a r20 = new a(r17, r11, r12, r13, r14, r15, r10.getFirst().booleanValue(), r10.getSecond(), r111.getFirst().booleanValue(), r111.getSecond());     // Catch: Throwable -> L66
        if (Intrinsics.areEqual(r20, this.f5489j) == true) goto L63;
        a r21 = this.f5489j;     // Catch: Throwable -> L66
        if (r21 == null) goto L61;
        List r22 = new ArrayList();     // Catch: Throwable -> L66
        if (Intrinsics.areEqual(r21.g(), r20.g()) == true) goto L35;
        r22.add("source");     // Catch: Throwable -> L66
    L35:
        if (r21.h() == r20.h()) goto L38;
        r22.add("thermalStatus");     // Catch: Throwable -> L66
    L38:
        if (r21.i() == r20.i()) goto L41;
        r22.add("thermalStatusMeet");     // Catch: Throwable -> L66
    L41:
        if (r21.a() == r20.a()) goto L44;
        r22.add("batteryLevel");     // Catch: Throwable -> L66
    L44:
        if (r21.j() == r20.j()) goto L47;
        r22.add("isCharging");     // Catch: Throwable -> L66
    L47:
        if (r21.b() == r20.b()) goto L50;
        r22.add("batteryStatusMeet");     // Catch: Throwable -> L66
    L50:
        if (r21.c() == r20.c()) goto L53;
        r22.add("currentAllowed");     // Catch: Throwable -> L66
    L53:
        if (Intrinsics.areEqual(r21.d(), r20.d()) == true) goto L56;
        r22.add("currentReason");     // Catch: Throwable -> L66
    L56:
        if (r21.e() == r20.e()) goto L59;
        r22.add("nextAllowed");     // Catch: Throwable -> L66
    L59:
        if (Intrinsics.areEqual(r21.f(), r20.f()) == true) goto L62;
        r22.add("nextReason");     // Catch: Throwable -> L66
    L62:
        AIKLog.INSTANCE.i("PythonRuntimeService", "checkAllowBackgroundUpdate changed=" + CollectionsKt.joinToString$default(r22, null, null, null, 0, null, null, 63, null) + " source=" + r20.g() + " thermal=" + r20.h() + '/' + r20.i() + " battery=" + r20.a() + " charging=" + r20.j() + " batteryMeet=" + r20.b() + " cur=" + r20.c() + ':' + r20.d() + " next=" + r20.e() + ':' + r20.f());     // Catch: Throwable -> L66
        this.f5489j = r20;     // Catch: Throwable -> L66
        goto L63
    L61:
        r22 = CollectionsKt.listOf("initial");     // Catch: Throwable -> L66
    L63:
        this.f5483d.c(r111);     // Catch: Throwable -> L66
        monitor-exit(this);
        return r110;
    L17:
        if (r15 == true) goto L19;
        e r23 = new e(false, r16);     // Catch: Throwable -> L66
    L26:
        r18 = r23;
        goto L27
    L19:
        r18 = new e(r10.getFirst().booleanValue(), r10.getSecond());     // Catch: Throwable -> L66
        goto L27
    L20:
        if (r12 == false) goto L23;
        if (r15 == false) goto L23;
        r18 = new e(true, "allowed by thermal:" + r11 + " batt:" + r13);     // Catch: Throwable -> L66
    L23:
        if (r12 == true) goto L25;
        r18 = new e(false, "disallowed by thermal:" + r11);     // Catch: Throwable -> L66
        goto L27
    L25:
        r23 = new e(false, r16);     // Catch: Throwable -> L66
    L12:
        r15 = false;
        goto L13
    L7:
        r12 = false;
    L66:
        th = move-exception;
        throw th;
    }

    private final void t(AutoUpdateCheckSource r17) {
        monitor-enter(this);
        boolean r10 = this.f5483d.getValue().getFirst().booleanValue();     // Catch: Throwable -> L32
        long r11 = AppSettingsManager.INSTANCE.getVmSettings().d();     // Catch: Throwable -> L32
        boolean r12 = false;
        if (this.f5486g.d() == false) goto L11;
        if (SetsKt.setOf(new AutoUpdateCheckSource[]{AutoUpdateCheckSource.STARTUP, AutoUpdateCheckSource.NETWORK, AutoUpdateCheckSource.RETRY}).contains(r17) == false) goto L11;
        r12 = true;
    L11:
        if (r12 == false) goto L20;
        if (this.f5486g.c() == true) goto L21;
        v1 r13 = this.f5487h;     // Catch: Throwable -> L32
        if (r13 == null) goto L18;
        v1.a.a(r13, null, 1, null);     // Catch: Throwable -> L32
    L18:
        this.f5487h = null;     // Catch: Throwable -> L32
        this.f5486g = n.b(this.f5486g, false, true, null, 5, null);     // Catch: Throwable -> L32
        long r14 = this.f5485f;     // Catch: Throwable -> L32
        long r15 = this.f5488i + 1;     // Catch: Throwable -> L32
        this.f5488i = r15;     // Catch: Throwable -> L32
        b r16 = new b(r17, true, r14, r11, r15);     // Catch: Throwable -> L32
    L27:
        monitor-exit(this);
        if (r16 != null) goto L30;
        return;
    L30:
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new PythonRuntimeService$checkShouldTriggerAutoUpdate$1(this, r16, null), 3, null);
        return;
    L21:
        r16 = null;
        goto L27
    L20:
        if (this.f5486g.d() == true) goto L21;
        if (r10 == false) goto L21;
        long r18 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L32
        if ((r18 - this.f5485f) <= r11) goto L21;
        this.f5485f = r18;     // Catch: Throwable -> L32
        long r19 = this.f5488i + 1;     // Catch: Throwable -> L32
        this.f5488i = r19;     // Catch: Throwable -> L32
        r16 = new b(r17, false, r18, r11, r19);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    private final void u(boolean r10) {
        if (r10 == false) goto L4;
        AutoUpdateCheckSource r11 = AutoUpdateCheckSource.STARTUP;
    L5:
        t(r11);
        return;
    L4:
        r11 = AutoUpdateCheckSource.CONSTRAINT;
        goto L5
    }

    static /* synthetic */ void v(PythonRuntimeService r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = false;
    L5:
        r10.u(r11);
    }

    private final com.obric.aikernel.model.cloud.common.e w() {
        return (com.obric.aikernel.model.cloud.common.e) this.f5482c.getValue();
    }

    public final List<y6.b> A() {
        return (List) kotlinx.coroutines.h.f(null, new PythonRuntimeService$getPackageInfos$1(this, null), 1, null);
    }

    public final Object B(String r10, Continuation<? super Float> r11) {
        if ((r11 instanceof PythonRuntimeService$getPackageUpdateProgress$1) == false) goto L7;
        PythonRuntimeService$getPackageUpdateProgress$1 r12 = (PythonRuntimeService$getPackageUpdateProgress$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L22:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        r12.L$0 = null;
        r12.label = 2;
        r14 = ((AIInferRuntime) r14).Z(r10, r12);
        if (r14 != r15) goto L22;
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        r0<AIInferRuntime> r17 = this.f5492m;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r12 = new PythonRuntimeService$getPackageUpdateProgress$1(this, r11);
        goto L8
    }

    public final IBinder C() {
        return (IBinder) kotlinx.coroutines.h.f(null, new PythonRuntimeService$getSubProcHost$1(this, null), 1, null);
    }

    public final Object I(String r10, String r11, RequestParams r12, Continuation<? super List<Pair<String, Boolean>>> r13) {
        if ((r13 instanceof PythonRuntimeService$preparePackage$1) == false) goto L7;
        PythonRuntimeService$preparePackage$1 r14 = (PythonRuntimeService$preparePackage$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        PythonRuntimeService$preparePackage$1 r16 = r14;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        if (r19 == 0) goto L16;
        if (r19 == 1) goto L15;
        if (r19 != 2) goto L14;
        ResultKt.throwOnFailure(r17);
    L22:
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (RequestParams) r16.L$2;
        r11 = (String) r16.L$1;
        r10 = (String) r16.L$0;
        ResultKt.throwOnFailure(r17);
    L19:
        AIInferRuntime r20 = (AIInferRuntime) r17;
        r16.L$0 = null;
        r16.L$1 = null;
        r16.L$2 = null;
        r16.label = 2;
        String r21 = r10;
        r17 = r20.l0(r21, r11, false, r12, r16);
        if (r17 != r18) goto L22;
        return r18;
    L16:
        ResultKt.throwOnFailure(r17);
        r0<AIInferRuntime> r22 = this.f5492m;
        r16.L$0 = r10;
        r16.L$1 = r11;
        r16.L$2 = r12;
        r16.label = 1;
        r17 = r22.r(r16);
        if (r17 != r18) goto L19;
        return r18;
    L7:
        r14 = new PythonRuntimeService$preparePackage$1(this, r13);
        goto L8
    }

    public final Object J(com.google.gson.k r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof PythonRuntimeService$pushDebugDistributeInfo$1) == false) goto L7;
        PythonRuntimeService$pushDebugDistributeInfo$1 r12 = (PythonRuntimeService$pushDebugDistributeInfo$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L19;
        if (r16 == 1) goto L16;
        if (r16 != 2) goto L15;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L28
    L26:
        Object r17 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r18 = Result.m35exceptionOrNullimpl(r17);
        if (r18 == null) goto L34;
        AIKLog.INSTANCE.e("PythonRuntimeService", "pushDebugDistributeInfo error " + ExceptionsKt.stackTraceToString(r18));
    L34:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r10 = (com.google.gson.k) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L28
    L23:
        r12.L$0 = null;     // Catch: Throwable -> L28
        r12.label = 2;     // Catch: Throwable -> L28
        if (((AIInferRuntime) r14).p0(r10, r12) != r15) goto L26;
        return r15;
    L19:
        ResultKt.throwOnFailure(r14);
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L28
        r0<AIInferRuntime> r20 = this.f5492m;     // Catch: Throwable -> L28
        r12.L$0 = r10;     // Catch: Throwable -> L28
        r12.label = 1;     // Catch: Throwable -> L28
        r14 = r20.r(r12);     // Catch: Throwable -> L28
        if (r14 != r15) goto L23;
        return r15;
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r12 = new PythonRuntimeService$pushDebugDistributeInfo$1(this, r11);
        goto L8
    }

    public final void K(com.obric.aikernel.middleware.interfaces.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.f5491l.add(r10);
    }

    public final Object P(String r10, boolean r11, Continuation<? super Map<String, UpdateResult>> r12) {
        if ((r12 instanceof PythonRuntimeService$updateAll$1) == false) goto L7;
        PythonRuntimeService$updateAll$1 r13 = (PythonRuntimeService$updateAll$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L22:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r13.Z$0;
        r10 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        r13.L$0 = null;
        r13.label = 2;
        r15 = ((AIInferRuntime) r15).F0(r10, r11, r13);
        if (r15 != r16) goto L22;
        return r16;
    L16:
        ResultKt.throwOnFailure(r15);
        r0<AIInferRuntime> r18 = this.f5492m;
        r13.L$0 = r10;
        r13.Z$0 = r11;
        r13.label = 1;
        r15 = r18.r(r13);
        if (r15 != r16) goto L19;
        return r16;
    L7:
        r13 = new PythonRuntimeService$updateAll$1(this, r12);
        goto L8
    }

    public final Object R(String r10, String r11, boolean r12, String r13, Continuation<? super PackageResource> r14) {
        if ((r14 instanceof PythonRuntimeService$updatePackage$1) == false) goto L7;
        PythonRuntimeService$updatePackage$1 r15 = (PythonRuntimeService$updatePackage$1) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        PythonRuntimeService$updatePackage$1 r17 = r15;
        Object r18 = r17.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r17.label;
        if (r20 == 0) goto L16;
        if (r20 == 1) goto L15;
        if (r20 != 2) goto L14;
        ResultKt.throwOnFailure(r18);
    L22:
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = r17.Z$0;
        r13 = (String) r17.L$2;
        r11 = (String) r17.L$1;
        r10 = (String) r17.L$0;
        ResultKt.throwOnFailure(r18);
    L19:
        r17.L$0 = null;
        r17.L$1 = null;
        r17.L$2 = null;
        r17.label = 2;
        r18 = ((AIInferRuntime) r18).H0(r10, r11, r12, r13, r17);
        if (r18 != r19) goto L22;
        return r19;
    L16:
        ResultKt.throwOnFailure(r18);
        r0<AIInferRuntime> r21 = this.f5492m;
        r17.L$0 = r10;
        r17.L$1 = r11;
        r17.L$2 = r13;
        r17.Z$0 = r12;
        r17.label = 1;
        r18 = r21.r(r17);
        if (r18 != r19) goto L19;
        return r19;
    L7:
        r15 = new PythonRuntimeService$updatePackage$1(this, r14);
        goto L8
    }

    public final boolean T() {
        return D();
    }

    public final Object U(String r10, RequestParams r11, String r12, com.obric.aikernel.b r13, Continuation<? super Bundle> r14) {
        if ((r14 instanceof PythonRuntimeService$vmExecute$1) == false) goto L7;
        PythonRuntimeService$vmExecute$1 r15 = (PythonRuntimeService$vmExecute$1) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        PythonRuntimeService$vmExecute$1 r17 = r15;
        Object r18 = r17.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r17.label;
        if (r20 == 0) goto L16;
        if (r20 == 1) goto L15;
        if (r20 != 2) goto L14;
        ResultKt.throwOnFailure(r18);
    L22:
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (com.obric.aikernel.b) r17.L$3;
        r12 = (String) r17.L$2;
        r11 = (RequestParams) r17.L$1;
        r10 = (String) r17.L$0;
        ResultKt.throwOnFailure(r18);
    L19:
        r17.L$0 = null;
        r17.L$1 = null;
        r17.L$2 = null;
        r17.L$3 = null;
        r17.label = 2;
        r18 = ((AIInferRuntime) r18).K0(r10, r11, r12, r13, r17);
        if (r18 != r19) goto L22;
        return r19;
    L16:
        ResultKt.throwOnFailure(r18);
        r0<AIInferRuntime> r21 = this.f5492m;
        r17.L$0 = r10;
        r17.L$1 = r11;
        r17.L$2 = r12;
        r17.L$3 = r13;
        r17.label = 1;
        r18 = r21.r(r17);
        if (r18 != r19) goto L19;
        return r19;
    L7:
        r15 = new PythonRuntimeService$vmExecute$1(this, r14);
        goto L8
    }

    public final Object V(String r10, RequestParams r11, String r12, Function1<? super Bundle, Unit> r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof PythonRuntimeService$vmExecute$2) == false) goto L7;
        PythonRuntimeService$vmExecute$2 r15 = (PythonRuntimeService$vmExecute$2) r14;
        int r16 = r15.label;
        if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
        r15.label = r16 - Integer.MIN_VALUE;
    L8:
        PythonRuntimeService$vmExecute$2 r17 = r15;
        Object r18 = r17.result;
        Object r19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r20 = r17.label;
        if (r20 == 0) goto L16;
        if (r20 == 1) goto L15;
        if (r20 != 2) goto L14;
        ResultKt.throwOnFailure(r18);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (Function1) r17.L$3;
        r12 = (String) r17.L$2;
        r11 = (RequestParams) r17.L$1;
        r10 = (String) r17.L$0;
        ResultKt.throwOnFailure(r18);
    L19:
        r17.L$0 = null;
        r17.L$1 = null;
        r17.L$2 = null;
        r17.L$3 = null;
        r17.label = 2;
        if (((AIInferRuntime) r18).L0(r10, r11, r12, r13, r17) != r19) goto L23;
        return r19;
    L16:
        ResultKt.throwOnFailure(r18);
        r0<AIInferRuntime> r21 = this.f5492m;
        r17.L$0 = r10;
        r17.L$1 = r11;
        r17.L$2 = r12;
        r17.L$3 = r13;
        r17.label = 1;
        r18 = r21.r(r17);
        if (r18 != r19) goto L19;
        return r19;
    L7:
        r15 = new PythonRuntimeService$vmExecute$2(this, r14);
        goto L8
    }

    @Override // com.obric.aikernel.service.b
    public void a(RequestParams r10) {
        Intrinsics.checkNotNullParameter(r10, "requestParams");
        String r11 = f.a(r10.getEvent(), r10.getBackend().getString(IdlKeys.Args_BindResumeSource), D());
        if (r11 == null) goto L6;
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new PythonRuntimeService$handleEvent$1$1(this, r11, null), 3, null);
        return;
    }

    @Override // com.obric.aikernel.service.b
    public int b() {
        return 1;
    }

    @Override // com.obric.aikernel.service.b
    public void c(FileDescriptor r10, PrintWriter r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "fout");
        Intrinsics.checkNotNullParameter(r12, "args");
        com.obric.aikernel.service.res.b r13 = d.f5520a.a(r12);
        if (r13 != null) goto L5;
        kotlinx.coroutines.h.f(null, new PythonRuntimeService$dump$2(this, r10, r11, r12, null), 1, null);
        return;
    L5:
        if ((r13 instanceof com.obric.aikernel.service.res.b.C0121b) == false) goto L16;
        monitor-enter(this);
        e r14 = new e(this.f5483d.getValue().getFirst().booleanValue(), this.f5483d.getValue().getSecond());     // Catch: Throwable -> L12
        this.f5490k = ((com.obric.aikernel.service.res.b.C0121b) r13).a();     // Catch: Throwable -> L12
        this.f5483d.c(new Pair(Boolean.valueOf(((com.obric.aikernel.service.res.b.C0121b) r13).a().a()), ((com.obric.aikernel.service.res.b.C0121b) r13).a().b()));     // Catch: Throwable -> L12
        boolean r15 = com.obric.aikernel.service.res.c.d(r14, ((com.obric.aikernel.service.res.b.C0121b) r13).a());     // Catch: Throwable -> L12
        monitor-exit(this);
        if (r15 == false) goto L11;
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new PythonRuntimeService$dump$1$1(this, null), 3, null);
    L11:
        StringBuilder r16 = new StringBuilder();
        r16.append("background_override allowed=");
        com.obric.aikernel.service.res.b.C0121b r17 = (com.obric.aikernel.service.res.b.C0121b) r13;
        r16.append(r17.a().a());
        r16.append(" reason=");
        String r18 = r17.a().b();
    L30:
        r16.append(r18);
        String r19 = r16.toString();
    L31:
        r11.println(r19);
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (Intrinsics.areEqual(r13, com.obric.aikernel.service.res.b.a.f5517a) == false) goto L28;
        monitor-enter(this);
        this.f5490k = null;     // Catch: Throwable -> L24
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(this);
        if (s("debug_clear") == false) goto L23;
        kotlinx.coroutines.h.d(m0.a(z0.b()), null, null, new PythonRuntimeService$dump$1$3(this, null), 3, null);
    L23:
        r19 = "background_override cleared";
    L24:
        th = move-exception;
        throw th;
    L28:
        if ((r13 instanceof com.obric.aikernel.service.res.b.c) == false) goto L39;
        com.obric.aikernel.service.res.b.c r21 = (com.obric.aikernel.service.res.b.c) r13;
        this.f5484e.c(r21.a());
        r16 = new StringBuilder();
        r16.append("trigger_auto_update reason=");
        r18 = r21.a();
        goto L30
    }

    @Override // com.obric.aikernel.service.b
    public String name() {
        return "package";
    }

    public final Object x(Continuation<? super com.google.gson.k> r10) {
        if ((r10 instanceof PythonRuntimeService$getDownloadingSummary$1) == false) goto L7;
        PythonRuntimeService$getDownloadingSummary$1 r11 = (PythonRuntimeService$getDownloadingSummary$1) r10;
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
    L22:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L19:
        r11.label = 2;
        r13 = ((AIInferRuntime) r13).U(r11);
        if (r13 != r14) goto L22;
        return r14;
    L16:
        ResultKt.throwOnFailure(r13);
        r0<AIInferRuntime> r16 = this.f5492m;
        r11.label = 1;
        r13 = r16.r(r11);
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r11 = new PythonRuntimeService$getDownloadingSummary$1(this, r10);
        goto L8
    }

    public final Object y(String r10, String r11, Continuation<? super PackageResource> r12) {
        if ((r12 instanceof PythonRuntimeService$getLoraPackage$1) == false) goto L7;
        PythonRuntimeService$getLoraPackage$1 r13 = (PythonRuntimeService$getLoraPackage$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L16;
        if (r17 == 1) goto L15;
        if (r17 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L22:
        return r15;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (String) r13.L$1;
        r10 = (String) r13.L$0;
        ResultKt.throwOnFailure(r15);
    L19:
        r13.L$0 = null;
        r13.L$1 = null;
        r13.label = 2;
        r15 = ((AIInferRuntime) r15).V(r10, r11, r13);
        if (r15 != r16) goto L22;
        return r16;
    L16:
        ResultKt.throwOnFailure(r15);
        r0<AIInferRuntime> r18 = this.f5492m;
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        r15 = r18.r(r13);
        if (r15 != r16) goto L19;
        return r16;
    L7:
        r13 = new PythonRuntimeService$getLoraPackage$1(this, r12);
        goto L8
    }

    public final Object z(String r10, Continuation<? super PackageResource> r11) {
        if ((r11 instanceof PythonRuntimeService$getPackage$1) == false) goto L7;
        PythonRuntimeService$getPackage$1 r12 = (PythonRuntimeService$getPackage$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L22:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (String) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L19:
        r12.L$0 = null;
        r12.label = 2;
        r14 = ((AIInferRuntime) r14).X(r10, r12);
        if (r14 != r15) goto L22;
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        r0<AIInferRuntime> r17 = this.f5492m;
        r12.L$0 = r10;
        r12.label = 1;
        r14 = r17.r(r12);
        if (r14 != r15) goto L19;
        return r15;
    L7:
        r12 = new PythonRuntimeService$getPackage$1(this, r11);
        goto L8
    }
}
