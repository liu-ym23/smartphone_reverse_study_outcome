package com.obric.aee.impl;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.event.EnsureReportData;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.random.Random;
import kotlin.text.Typography;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
public final class InvokeUtils {
    public static final InvokeUtils INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f4320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f4322d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, Object[]> f4323e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f4324f = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f4325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f4326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f4327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CoroutineContext f4328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f4329e;

        public a(Method r10, boolean r11, Object r12, CoroutineContext r13, long r14) {
            Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
            this.f4325a = r10;
            this.f4326b = r11;
            this.f4327c = r12;
            this.f4328d = r13;
            this.f4329e = r14;
        }

        public final long a() {
            return this.f4329e;
        }

        public final CoroutineContext b() {
            return this.f4328d;
        }

        public final Object c() {
            return this.f4327c;
        }

        public final Method d() {
            return this.f4325a;
        }

        public final boolean e() {
            return this.f4326b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f4325a, r11.f4325a) == true) goto L12;
            return false;
        L12:
            if (this.f4326b == r11.f4326b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4327c, r11.f4327c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4328d, r11.f4328d) == true) goto L21;
            return false;
        L21:
            if (this.f4329e == r11.f4329e) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int r10 = this.f4325a.hashCode() * 31;
            boolean r11 = this.f4326b;
            ?? r12 = r11;
            if (r11 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = (r10 + r12) * 31;
            Object r14 = this.f4327c;
            int r15 = 0;
            if (r14 != null) goto L8;
            int r16 = 0;
        L9:
            int r17 = (r13 + r16) * 31;
            CoroutineContext r18 = this.f4328d;
            if (r18 == null) goto L14;
            r15 = r18.hashCode();
        L14:
            return ((r17 + r15) * 31) + Long.hashCode(this.f4329e);
        L8:
            r16 = r14.hashCode();
            goto L9
        }

        public String toString() {
            return "JavaMethodMeta(method=" + this.f4325a + ", unpack=" + this.f4326b + ", inst=" + this.f4327c + ", ctx=" + this.f4328d + ", asyncTimeout=" + this.f4329e + ')';
        }
    }

    public static final class b implements AutoCloseable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f4330c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f4331g;

        public b(long r10, boolean r11) {
            this.f4330c = r10;
            this.f4331g = r11;
        }

        public final void a(Object... r10) {
            Intrinsics.checkNotNullParameter(r10, "args");
            InvokeUtils r11 = InvokeUtils.INSTANCE;
            long r12 = this.f4330c;
            int r13 = r10.length;
            Object[] r14 = new Object[r13];
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L5;
            r14[r15] = r10[r15];
            r15 = r15 + 1;
            goto L3
        L5:
            InvokeUtils.g(r11, r12, r14);
        }

        public final Object c(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "args");
            long r10 = InvokeUtils.e().incrementAndGet();
            ConcurrentHashMap r12 = InvokeUtils.c();     // Catch: Throwable -> L9
            Long r13 = Long.valueOf(r10);     // Catch: Throwable -> L9
            int r14 = 0;
            int r15 = r11.length;     // Catch: Throwable -> L9
            Object[] r16 = new Object[r15];     // Catch: Throwable -> L9
        L4:
            if (r14 >= r15) goto L6;
            r16[r14] = r11[r14];     // Catch: Throwable -> L9
            r14 = r14 + 1;     // Catch: Throwable -> L9
            goto L4
        L6:
            r12.put(r13, r16);     // Catch: Throwable -> L9
            Object r17 = InvokeUtils.h(InvokeUtils.INSTANCE, InvokeUtils.d(), this.f4330c, r10);     // Catch: Throwable -> L9
            InvokeUtils.c().remove(Long.valueOf(r10));
            return r17;
        L9:
            th = move-exception;
            InvokeUtils.c().remove(Long.valueOf(r10));
            throw th;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.f4331g == true) goto L6;
            InvokeUtils.f(InvokeUtils.INSTANCE, this.f4330c);
            return;
        }
    }

    public static final class c implements Continuation<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CoroutineContext f4332c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n<Object> f4333g;

        c(n<Object> r10) {
            this.f4333g = r10;
            this.f4332c = r10.getContext();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f4332c;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r10) {
            boolean r11 = Result.m39isSuccessimpl(r10);
            n<Object> r12 = this.f4333g;
            if (r11 == false) goto L5;
            ResultKt.throwOnFailure(r10);
            Result.Companion r13 = Result.Companion;
        L6:
            r12.resumeWith(Result.m32constructorimpl(r10));
            return;
        L5:
            Result.Companion r14 = Result.Companion;
            Throwable r15 = Result.m35exceptionOrNullimpl(r10);
            Intrinsics.checkNotNull(r15);
            r10 = ResultKt.createFailure(r15);
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1", f = "InvokeUtils.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Object> $args;
        final /* synthetic */ b $cb;
        final /* synthetic */ long $cid;
        final /* synthetic */ a $entry;
        final /* synthetic */ String $key;
        int label;

        /* JADX INFO: renamed from: com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1$1, reason: invalid class name and collision with other inner class name */
        @DebugMetadata(c = "com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1$1", f = "InvokeUtils.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
        static final class C00931 extends SuspendLambda implements Function2<l0, Continuation<? super Object>, Object> {
            final /* synthetic */ ArrayList<Object> $args;
            final /* synthetic */ b $cb;
            final /* synthetic */ long $cid;
            final /* synthetic */ a $entry;
            final /* synthetic */ String $key;
            int label;

            C00931(String r10, a r11, ArrayList<Object> r12, b r13, long r14, Continuation<? super C00931> r15) {
                this.$key = r10;
                this.$entry = r11;
                this.$args = r12;
                this.$cb = r13;
                this.$cid = r14;
                super(2, r15);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new C00931(this.$key, this.$entry, this.$args, this.$cb, this.$cid, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Object> r11) {
                return invoke2(r10, r11);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(l0 r10, Continuation<Object> r11) {
                return ((C00931) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r11) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                ResultKt.throwOnFailure(r11);
            L12:
                return this.$cb.c(new Object[]{Boxing.boxLong(this.$cid), r11, "", this.$key, ""});
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                InvokeUtils r13 = InvokeUtils.INSTANCE;
                String r14 = this.$key;
                boolean r15 = this.$entry.e();
                Method r16 = this.$entry.d();
                Object r17 = this.$entry.c();
                ArrayList<Object> r18 = this.$args;
                this.label = 1;
                r11 = InvokeUtils.a(r13, r14, r15, r16, r17, r18, this);
                if (r11 != r10) goto L12;
                return r10;
            }
        }

        AnonymousClass1(a r10, b r11, long r12, String r13, ArrayList<Object> r14, Continuation<? super AnonymousClass1> r15) {
            this.$entry = r10;
            this.$cb = r11;
            this.$cid = r12;
            this.$key = r13;
            this.$args = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$entry, this.$cb, this.$cid, this.$key, this.$args, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L11;
            if (r11 != 1) goto L10;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L7
            AnonymousClass1 this = this;
        L22:
        L21:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r14);
            long r12 = this.$entry.a();     // Catch: Throwable -> L7
            C00931 r15 = new C00931(this.$key, this.$entry, this.$args, this.$cb, this.$cid, null);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            Object r13 = TimeoutKt.c(r12, r15, this);     // Catch: Throwable -> L7
            this = r13;
            if (r13 != r10) goto L22;
            return r10;
        L7:
            th = th;
            Throwable r16 = th.getCause();
            if (r16 == null) goto L19;
            th = r16;
        L19:
            StackTraceElement[] r17 = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(r17, "finalExcep.stackTrace");
            this.$cb.c(new Object[]{Boxing.boxLong(this.$cid), Boxing.boxInt(0), NotificationCompat.CATEGORY_ERROR, this.$key, ArraysKt.joinToString$default(r17, "\n", "Caused by: " + th + '\n', null, 0, null, InvokeUtils$runAsyncRegMethod$1$joined$1.INSTANCE, 28, null)});
            goto L21
        }
    }

    static {
        INSTANCE = new InvokeUtils();
        f4319a = "InvokeUtils";
        f4322d = new AtomicLong(Random.Default.nextLong(1024, 4096));
        f4323e = new ConcurrentHashMap();
        f4324f = new ConcurrentHashMap();
    }

    private InvokeUtils() {
    }

    public static final /* synthetic */ Object a(InvokeUtils r10, String r11, boolean r12, Method r13, Object r14, ArrayList r15, Continuation r16) {
        return r10.i(r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ String b() {
        return f4319a;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return f4323e;
    }

    public static final /* synthetic */ long d() {
        return f4320b;
    }

    public static final /* synthetic */ AtomicLong e() {
        return f4322d;
    }

    public static final /* synthetic */ void f(InvokeUtils r10, long r11) {
        r10.nativeFreeFunction(r11);
    }

    public static final /* synthetic */ void g(InvokeUtils r10, long r11, Object[] r12) {
        r10.nativeRunFunction(r11, r12);
    }

    public static final /* synthetic */ Object h(InvokeUtils r10, long r11, long r12, long r13) {
        return r10.nativeSlowCall(r11, r12, r13);
    }

    private final Object i(final String r10, boolean r11, Method r12, Object r13, ArrayList<Object> r14, Continuation<Object> r15) {
        o r16 = new o(IntrinsicsKt.intercepted(r15), 1);
        r16.F();
        r16.h(new InvokeUtils$callSuspendMethod$2$1(r10));
        c r17 = new c(r16);     // Catch: Exception -> L11
        if (r11 == false) goto L6;
        SpreadBuilder r18 = new SpreadBuilder(2);     // Catch: Exception -> L11
        r18.addSpread(r14.toArray());     // Catch: Exception -> L11
        r18.add(r17);     // Catch: Exception -> L11
        Object r19 = r12.invoke(r13, r18.toArray(new Object[r18.size()]));     // Catch: Exception -> L11
    L8:
        if (Intrinsics.areEqual(r19, IntrinsicsKt.getCOROUTINE_SUSPENDED()) == true) goto L13;
        Result.Companion r20 = Result.Companion;     // Catch: Exception -> L11
        r16.resumeWith(Result.m32constructorimpl(r19));     // Catch: Exception -> L11
    L13:
        Object r21 = r16.B();
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L16:
        return r21;
    L6:
        r19 = r12.invoke(r13, new Object[]{r14.toArray(), r17});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Result.Companion r22 = Result.Companion;
        r16.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(e)));
        goto L13
    }

    private final native void nativeFreeFunction(long r10);

    private final native long nativeGetFunction(String r10, String r11);

    private final native void nativeRunFunction(long r10, Object[] r11);

    private final native Object nativeSlowCall(long r10, long r11, long r12);

    public final native void enableVerifySo(boolean r10);

    @Keep
    public final Object[] getSlowCallArgs(long r10) {
        return f4323e.get(Long.valueOf(r10));
    }

    @Keep
    public final int hasRegMethod(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        a r11 = f4324f.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        if (r11.b() == null) goto L10;
        return 2;
    L10:
        return 1;
    }

    public final b j(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, EnsureReportData.METHOD);
        if (nativeGetFunction(r10, r11) != 0) goto L7;
        return null;
    L7:
        return new b(nativeGetFunction(r10, r11), false);
    }

    public final void k() {
        f4320b = nativeGetFunction("pap.invoke", "_slow_call");
        long r10 = nativeGetFunction("pap.invoke", "_async_finish");
        f4321c = r10;
        if (f4320b == 0) goto L8;
        if (r10 == 0) goto L8;
        return;
    L8:
        throw new RuntimeException("aee native function not found");
    }

    public final void l(String r10, Method r11, Object r12, CoroutineContext r13, long r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "func");
        if (f4324f.putIfAbsent(r10, new a(r11, r15, r12, r13, r14)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("method " + r10 + " is already registered.");
    }

    @Keep
    public final JobWrapper runAsyncRegMethod(long r16, String r18, ArrayList<Object> r19) {
        Intrinsics.checkNotNullParameter(r18, "key");
        Intrinsics.checkNotNullParameter(r19, "args");
        a r10 = f4324f.get(r18);
        if (r10 == null) goto L11;
        if (r10.b() == null) goto L9;
        return new JobWrapper(h.d(m0.a(r10.b()), null, null, new AnonymousClass1(r10, new b(f4321c, true), r16, r18, r19, null), 3, null));
    L9:
        throw new RuntimeException("sync method can not be called in async context.");
    L11:
        throw new InvalidParameterException("no method named \"" + r18 + Typography.quote);
    }

    @Keep
    public final Object runRegMethod(String r10, ArrayList<Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "args");
        a r12 = f4324f.get(r10);
        if (r12 == null) goto L14;
        if (r12.b() != null) goto L12;
        if (r12.e() == false) goto L10;
        Method r13 = r12.d();
        Object r14 = r12.c();
        Object[] r15 = r11.toArray();
        return r13.invoke(r14, Arrays.copyOf(r15, r15.length));
    L10:
        return r12.d().invoke(r12.c(), new Object[]{r11.toArray()});
    L12:
        throw new RuntimeException("async method can not be called in sync context.");
    L14:
        throw new InvalidParameterException("no method named \"" + r10 + Typography.quote);
    }
}
