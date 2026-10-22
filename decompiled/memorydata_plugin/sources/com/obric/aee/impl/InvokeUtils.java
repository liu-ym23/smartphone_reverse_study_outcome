package com.obric.aee.impl;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.random.Random;
import kotlin.text.Typography;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.da;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00029:B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0017j\b\u0012\u0004\u0012\u00020\u0001`\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0086 J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u001f\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0006\u0010%\u001a\u00020\u001bJ\u0011\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0006H\u0082 J\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0082 J$\u0010)\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0082 ¢\u0006\u0002\u0010*J!\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0082 J<\u0010/\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\u00012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00062\b\b\u0002\u00105\u001a\u00020\u0012J0\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0017j\b\u0012\u0004\u0012\u00020\u0001`\u0018H\u0007J*\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0017j\b\u0012\u0004\u0012\u00020\u0001`\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/obric/aee/impl/InvokeUtils;", "", "()V", "TAG", "", "_asyncFinishFn", "", "_regJavaMethods", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aee/impl/InvokeUtils$JavaMethodMeta;", "_slowCallArgs", "", "_slowCallFn", "_slowCallNextCid", "Ljava/util/concurrent/atomic/AtomicLong;", "callSuspendMethod", "key", "unpack", "", "method", "Ljava/lang/reflect/Method;", "instance", "args", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ZLjava/lang/reflect/Method;Ljava/lang/Object;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableVerifySo", "", "enable", "getPythonFunction", "Lcom/obric/aee/impl/InvokeUtils$PythonFunction;", "module", "getSlowCallArgs", "cid", "(J)[Ljava/lang/Object;", "hasRegMethod", "", "initCallback", "nativeFreeFunction", "ptr", "nativeGetFunction", "nativeRunFunction", "(J[Ljava/lang/Object;)V", "nativeSlowCall", "slowCallPtr", "sid", "funcPtr", "registerJavaMethod", "func", "obj", "ctx", "Lkotlin/coroutines/CoroutineContext;", LocationMonitorConst.TIMEOUT, "unpackArgs", "runAsyncRegMethod", "Lcom/obric/aee/impl/JobWrapper;", "runRegMethod", "JavaMethodMeta", "PythonFunction", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InvokeUtils {
    public static final InvokeUtils INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f5879b;
    private static long c;
    private static final AtomicLong d = null;
    private static final ConcurrentHashMap<Long, Object[]> e = null;
    private static final ConcurrentHashMap<String, a> f = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/aee/impl/InvokeUtils$JavaMethodMeta;", "", "method", "Ljava/lang/reflect/Method;", "unpack", "", "inst", "ctx", "Lkotlin/coroutines/CoroutineContext;", "asyncTimeout", "", "(Ljava/lang/reflect/Method;ZLjava/lang/Object;Lkotlin/coroutines/CoroutineContext;J)V", "getAsyncTimeout", "()J", "getCtx", "()Lkotlin/coroutines/CoroutineContext;", "getInst", "()Ljava/lang/Object;", "getMethod", "()Ljava/lang/reflect/Method;", "getUnpack", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f5880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5881b;
        private final Object c;
        private final CoroutineContext d;
        private final long e;

        public a(Method r3, boolean r4, Object r5, CoroutineContext r6, long r7) {
            CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.f5880a = r3;
            this.f5881b = r4;
            this.c = r5;
            this.d = r8;
            this.e = r7;
        }

        public final Method a() {
            return this.f5880a;
        }

        public final boolean b() {
            return this.f5881b;
        }

        public final Object c() {
            return this.c;
        }

        public final CoroutineContext d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f5880a, r8.f5880a) == true) goto L12;
            return false;
        L12:
            if (this.f5881b == r8.f5881b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r8.e) goto L23;
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
            int r0 = this.f5880a.hashCode() * 31;
            boolean r1 = this.f5881b;
            ?? r2 = r1;
            if (r1 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = (r0 + r2) * 31;
            Object r4 = this.c;
            int r5 = 0;
            if (r4 != null) goto L8;
            int r6 = 0;
        L9:
            int r7 = (r3 + r6) * 31;
            CoroutineContext r8 = this.d;
            if (r8 == null) goto L14;
            r5 = r8.hashCode();
        L14:
            return ((r7 + r5) * 31) + Long.hashCode(this.e);
        L8:
            r6 = r4.hashCode();
            goto L9
        }

        public String toString() {
            return "JavaMethodMeta(method=" + this.f5880a + ", unpack=" + this.f5881b + ", inst=" + this.c + ", ctx=" + this.d + ", asyncTimeout=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001f\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\u00020\f2\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aee/impl/InvokeUtils$PythonFunction;", "Ljava/lang/AutoCloseable;", "ptr", "", "borrow", "", "(JZ)V", IslandSession.REOPEN_VALUE_CLOSE, "", "fastCall", "args", "", "", "([Ljava/lang/Object;)V", "slowCall", "([Ljava/lang/Object;)Ljava/lang/Object;", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f5883b;

        public b(long r1, boolean r3) {
            this.f5882a = r1;
            this.f5883b = r3;
        }

        public final void a(Object... r7) {
            Intrinsics.checkNotNullParameter(r7, "args");
            InvokeUtils r0 = InvokeUtils.INSTANCE;
            long r1 = this.f5882a;
            int r6 = r7.length;
            Object[] r3 = new Object[r6];
            int r4 = 0;
        L3:
            if (r4 >= r6) goto L5;
            r3[r4] = r7[r4];
            r4 = r4 + 1;
            goto L3
        L5:
            InvokeUtils.a(r0, r1, r3);
        }

        public final Object b(Object... r11) {
            Intrinsics.checkNotNullParameter(r11, "args");
            long r8 = InvokeUtils.b().incrementAndGet();
            Map r0 = (Map) ZeusTransformUtils.preCheckCast(InvokeUtils.c(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            Long r1 = Long.valueOf(r8);     // Catch: Throwable -> L9
            int r2 = 0;
            int r3 = r11.length;     // Catch: Throwable -> L9
            Object[] r4 = new Object[r3];     // Catch: Throwable -> L9
        L4:
            if (r2 >= r3) goto L6;
            r4[r2] = r11[r2];     // Catch: Throwable -> L9
            r2 = r2 + 1;     // Catch: Throwable -> L9
            goto L4
        L6:
            r0.put(r1, r4);     // Catch: Throwable -> L9
            Object r10 = InvokeUtils.a(InvokeUtils.INSTANCE, InvokeUtils.d(), this.f5882a, r8);     // Catch: Throwable -> L9
            InvokeUtils.c().remove(Long.valueOf(r8));
            return r10;
        L9:
            th = move-exception;
            InvokeUtils.c().remove(Long.valueOf(r8));
            throw th;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.f5883b == true) goto L6;
            InvokeUtils.a(InvokeUtils.INSTANCE, this.f5882a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"com/obric/aee/impl/InvokeUtils$callSuspendMethod$2$con$1", "Lkotlin/coroutines/Continuation;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements Continuation<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<Object> f5884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CoroutineContext f5885b;

        c(n<Object> r3) {
            n<Object> r4 = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
            this.f5884a = r4;
            this.f5885b = r4.getContext();
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f5885b;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r3) {
            boolean r0 = Result.m1428isSuccessimpl(r3);
            n<Object> r2 = this.f5884a;
            if (r0 == false) goto L5;
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r3);
            Result.Companion r1 = Result.Companion;
        L6:
            r4.resumeWith(Result.m1421constructorimpl(r3));
            return;
        L5:
            r4 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r5 = Result.Companion;
            Throwable r6 = Result.m1424exceptionOrNullimpl(r3);
            Intrinsics.checkNotNull(r6);
            r3 = ResultKt.createFailure(r6);
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1", f = "InvokeUtils.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Object> $args;
        final /* synthetic */ b $cb;
        final /* synthetic */ long $cid;
        final /* synthetic */ a $entry;
        final /* synthetic */ String $key;
        int label;

        /* JADX INFO: renamed from: com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.aee.impl.InvokeUtils$runAsyncRegMethod$1$1", f = "InvokeUtils.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
        static final class C02261 extends SuspendLambda implements Function2<al, Continuation<? super Object>, Object> {
            final /* synthetic */ ArrayList<Object> $args;
            final /* synthetic */ b $cb;
            final /* synthetic */ long $cid;
            final /* synthetic */ a $entry;
            final /* synthetic */ String $key;
            int label;

            C02261(String r3, a r4, ArrayList<Object> r5, b r6, long r7, Continuation<? super C02261> r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                this.$key = r3;
                this.$entry = r4;
                this.$args = r5;
                this.$cb = r6;
                this.$cid = r7;
                super(2, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C02261(this.$key, this.$entry, this.$args, this.$cb, this.$cid, r8), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Object> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<Object> r4) {
                return ((C02261) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C02261.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r11) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r11);
            L12:
                return this.$cb.b(new Object[]{Boxing.boxLong(this.$cid), r11, "", this.$key, ""});
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r11);
                InvokeUtils r3 = InvokeUtils.INSTANCE;
                String r4 = this.$key;
                boolean r5 = this.$entry.b();
                Method r6 = this.$entry.a();
                Object r7 = this.$entry.c();
                ArrayList<Object> r8 = this.$args;
                Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                r11 = InvokeUtils.a(r3, r4, r5, r6, r7, r8, r9);
                if (r11 != r0) goto L12;
                return r0;
            }
        }

        AnonymousClass1(a r3, b r4, long r5, String r7, ArrayList<Object> r8, Continuation<? super AnonymousClass1> r9) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$entry = r3;
            this.$cb = r4;
            this.$cid = r5;
            this.$key = r7;
            this.$args = r8;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$entry, this.$cb, this.$cid, this.$key, this.$args, r8), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L7
            AnonymousClass1 this = this;
        L22:
        L21:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r15);
            long r4 = this.$entry.e();     // Catch: Throwable -> L7
            Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new C02261(this.$key, this.$entry, this.$args, this.$cb, this.$cid, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            Object r14 = da.a(r4, r16, r2);     // Catch: Throwable -> L7
            this = r14;
            if (r14 != r0) goto L22;
            return r0;
        L7:
            th = th;
            Throwable r3 = th.getCause();
            if (r3 == null) goto L19;
            th = r3;
        L19:
            StackTraceElement[] r5 = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(r5, "finalExcep.stackTrace");
            this.$cb.b(new Object[]{Boxing.boxLong(this.$cid), Boxing.boxInt(0), NotificationCompat.CATEGORY_ERROR, this.$key, ArraysKt.joinToString$default((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Caused by: " + th + '\n', CharSequence.class, "com.obric.memorydata.plugin"), null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(InvokeUtils$runAsyncRegMethod$1$joined$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 28, null)});
            goto L21
        }
    }

    static {
        INSTANCE = new InvokeUtils();
        f5878a = "InvokeUtils";
        d = new AtomicLong(Random.Default.nextLong(1024, 4096));
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
    }

    private InvokeUtils() {
    }

    public static final /* synthetic */ Object a(InvokeUtils r0, long r1, long r3, long r5) {
        return r0.nativeSlowCall(r1, r3, r5);
    }

    public static final /* synthetic */ Object a(InvokeUtils r7, String r8, boolean r9, Method r10, Object r11, ArrayList r12, Continuation r13) {
        return r7.a(r8, r9, r10, r11, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(final String r5, boolean r6, Method r7, Object r8, ArrayList<Object> r9, Continuation<Object> r10) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        o r11 = new o(IntrinsicsKt.intercepted(r4), 1);
        r11.e();
        n r1 = (n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.memorydata.plugin");
        r1.a((Function1) ZeusTransformUtils.preCheckCast(new InvokeUtils$callSuspendMethod$2$1(r5), Function1.class, "com.obric.memorydata.plugin"));
        c r12 = new c(r1);     // Catch: Exception -> L11
        if (r6 == false) goto L6;
        SpreadBuilder r13 = new SpreadBuilder(2);     // Catch: Exception -> L11
        r13.addSpread(r9.toArray());     // Catch: Exception -> L11
        r13.add(r12);     // Catch: Exception -> L11
        Object r14 = r7.invoke(r8, r13.toArray(new Object[r13.size()]));     // Catch: Exception -> L11
    L8:
        if (Intrinsics.areEqual(r14, IntrinsicsKt.getCOROUTINE_SUSPENDED()) == true) goto L13;
        Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L11
        Result.Companion r16 = Result.Companion;     // Catch: Exception -> L11
        r15.resumeWith(Result.m1421constructorimpl(r14));     // Catch: Exception -> L11
    L13:
        Object r17 = r11.h();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L16:
        return r17;
    L6:
        r14 = r7.invoke(r8, new Object[]{r9.toArray(), r12});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r19 = Result.Companion;
        r18.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"))));
        goto L13
    }

    public static final /* synthetic */ void a(InvokeUtils r0, long r1) {
        r0.nativeFreeFunction(r1);
    }

    public static final /* synthetic */ void a(InvokeUtils r0, long r1, Object[] r3) {
        r0.nativeRunFunction(r1, r3);
    }

    public static final /* synthetic */ AtomicLong b() {
        return d;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return e;
    }

    public static final /* synthetic */ long d() {
        return f5879b;
    }

    public static final /* synthetic */ String e() {
        return f5878a;
    }

    private final native void nativeFreeFunction(long r1);

    private final native long nativeGetFunction(String r1, String r2);

    private final native void nativeRunFunction(long r1, Object[] r3);

    private final native Object nativeSlowCall(long r1, long r3, long r5);

    public final b a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "module");
        Intrinsics.checkNotNullParameter(r6, "method");
        if (nativeGetFunction(r5, r6) != 0) goto L7;
        return null;
    L7:
        return new b(nativeGetFunction(r5, r6), false);
    }

    public final void a() {
        f5879b = nativeGetFunction("pap.invoke", "_slow_call");
        long r0 = nativeGetFunction("pap.invoke", "_async_finish");
        c = r0;
        if (f5879b == 0) goto L8;
        if (r0 == 0) goto L8;
        return;
    L8:
        throw new RuntimeException("aee native function not found");
    }

    public final void a(String r8, Method r9, Object r10, CoroutineContext r11, long r12, boolean r14) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r11, CoroutineContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "func");
        if (f.putIfAbsent(r8, new a(r9, r14, r10, r4, r12)) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("method " + r8 + " is already registered.");
    }

    public final native void enableVerifySo(boolean r1);

    public final Object[] getSlowCallArgs(long r1) {
        return (Object[]) ZeusTransformUtils.preCheckCast(e.get(Long.valueOf(r1)), Object[].class, "com.obric.memorydata.plugin");
    }

    public final int hasRegMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        a r1 = (a) ZeusTransformUtils.preCheckCast(f.get(r2), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return 0;
    L7:
        if (r1.d() == null) goto L10;
        return 2;
    L10:
        return 1;
    }

    public final JobWrapper runAsyncRegMethod(long r17, String r19, ArrayList<Object> r20) {
        Intrinsics.checkNotNullParameter(r19, "key");
        Intrinsics.checkNotNullParameter(r20, "args");
        a r1 = (a) ZeusTransformUtils.preCheckCast(f.get(r19), a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        if (r1.d() == null) goto L9;
        return new JobWrapper(i.a(am.a(r1.d()), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1, new b(c, true), r17, r19, r20, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
    L9:
        throw new RuntimeException("sync method can not be called in async context.");
    L11:
        throw new InvalidParameterException("no method named \"" + r19 + Typography.quote);
    }

    public final Object runRegMethod(String r3, ArrayList<Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "args");
        a r2 = (a) ZeusTransformUtils.preCheckCast(f.get(r3), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        if (r2.d() != null) goto L12;
        if (r2.b() == false) goto L10;
        Method r5 = r2.a();
        Object r6 = r2.c();
        Object[] r7 = r4.toArray();
        return r5.invoke(r6, Arrays.copyOf(r7, r7.length));
    L10:
        return r2.a().invoke(r2.c(), new Object[]{r4.toArray()});
    L12:
        throw new RuntimeException("async method can not be called in sync context.");
    L14:
        throw new InvalidParameterException("no method named \"" + r3 + Typography.quote);
    }
}
