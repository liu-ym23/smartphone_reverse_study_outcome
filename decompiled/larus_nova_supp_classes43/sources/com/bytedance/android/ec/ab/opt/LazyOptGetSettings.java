package com.bytedance.android.ec.ab.opt;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class LazyOptGetSettings<Config> implements ReadOnlyProperty<Object, Config> {
    public final AtomicBoolean a;
    public long b;
    public Config c;

    /* JADX INFO: renamed from: com.bytedance.android.ec.ab.opt.LazyOptGetSettings$getValue$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Config", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.ab.opt.LazyOptGetSettings$getValue$1", f = "LazyOptSettings.kt", i = {}, l = {30, 35, 39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyOptGetSettings this$0;

        public AnonymousClass1(LazyOptGetSettings r1, Continuation r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            return new AnonymousClass1(this.this$0, r11);
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
        L28:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r10);
        L16:
            if (r10 != this.this$0.b()) goto L22;
            this.this$0.a.compareAndSet(true, false);
            LazyOptGetSettings r11 = this.this$0;
            r11.b = System.currentTimeMillis();
            if (this.this$0.f() == false) goto L28;
            LazyOptGetSettings r12 = this.this$0;
            this.label = 2;
            if (LazyOptGetSettings.a(r12, this) != r0) goto L28;
            return r0;
        L22:
            LazyOptGetSettings r13 = this.this$0;
            r13.c = (Config) r10;
            Function2<Config, Continuation<? super Unit>, Object> r14 = r13.d();
            if (r14 == null) goto L28;
            this.label = 3;
            if (r14.invoke(r10, this) != r0) goto L28;
            return r0;
        L12:
            ResultKt.throwOnFailure(r10);
            LazyOptGetSettings r15 = this.this$0;
            this.label = 1;
            r10 = (Config) r15.e(this);
            if (r10 != r0) goto L16;
            return r0;
        }
    }

    public abstract Config b();

    public abstract a<Config> c();

    public abstract Function2<Config, Continuation<? super Unit>, Object> d();

    public abstract Object e(Continuation<? super Config> r1);

    public abstract boolean f();

    public abstract Function0<Boolean> g();

    public boolean i() {
        return true;
    }

    public LazyOptGetSettings() {
        this.a = new AtomicBoolean(false);
    }

    public static boolean h() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Object a(LazyOptGetSettings r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof LazyOptGetSettings$defaultLocalConfigInit$1) == false) goto L7;
        LazyOptGetSettings$defaultLocalConfigInit$1 r0 = (LazyOptGetSettings$defaultLocalConfigInit$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L15;
        if (r14 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L25
    L21:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r15);     // Catch: Throwable -> L25
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L25
        a<Config> r17 = r10.c();     // Catch: Throwable -> L25
        if (r17 == null) goto L22;
        r0.label = 1;     // Catch: Throwable -> L25
        if (r17.a(r0) != r13) goto L21;
        return r13;
    L22:
        r15 = null;
    L25:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new LazyOptGetSettings$defaultLocalConfigInit$1(r10, r11);
        goto L8
    }

    public final Config getValue(Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        Config r12 = null;
        if (this.c == null) goto L5;
    L17:
        Config r13 = this.c;
        if (r13 != null) goto L29;
        boolean r14 = ((Boolean) g().invoke()).booleanValue();
        boolean r0 = f();     // Catch: Throwable -> L27
        if (r14 == false) goto L28;
        if (r0 == false) goto L28;
        a<Config> r15 = c();     // Catch: Throwable -> L27
        if (r15 == null) goto L28;
        r12 = r15.b;     // Catch: Throwable -> L27
    L28:
        r13 = r12;
    L29:
        if (r13 == null) goto L31;
        return r13;
    L31:
        return b();
    L5:
        if (((Boolean) g().invoke()).booleanValue() == false) goto L17;
        if ((System.currentTimeMillis() - this.b) <= 1000) goto L17;
        if (this.a.compareAndSet(false, true) == false) goto L17;
        if (h() == true) goto L13;
    L15:
        CoroutineDispatcher r16 = Dispatchers.getUnconfined();
    L16:
        CoroutineScope r1 = c.a;
        BuildersKt.launch$default(r1, r16, null, new AnonymousClass1(this, null), 2, null);
        goto L17
    L13:
        if (i() == false) goto L15;
        r16 = Dispatchers.getIO();
        goto L16
    }
}
