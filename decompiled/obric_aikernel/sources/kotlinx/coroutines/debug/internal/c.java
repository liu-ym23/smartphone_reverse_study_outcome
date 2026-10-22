package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
@PublishedApi
@SourceDebugExtension({"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,620:1\n150#1:638\n151#1,4:640\n156#1,5:645\n150#1:650\n151#1,4:652\n156#1,5:657\n1#2:621\n1#2:639\n1#2:651\n766#3:622\n857#3,2:623\n1208#3,2:625\n1238#3,4:627\n1855#3,2:665\n350#3,7:673\n1819#3,8:680\n603#4:631\n603#4:644\n603#4:656\n603#4:662\n1295#4,2:663\n37#5,2:632\n37#5,2:634\n37#5,2:636\n1627#6,6:667\n1735#6,6:688\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n245#1:638\n245#1:640,4\n245#1:645,5\n252#1:650\n252#1:652,4\n252#1:657,5\n245#1:639\n252#1:651\n110#1:622\n110#1:623,2\n111#1:625,2\n111#1:627,4\n307#1:665,2\n416#1:673,7\n506#1:680,8\n154#1:631\n245#1:644\n252#1:656\n287#1:662\n288#1:663,2\n211#1:632,2\n212#1:634,2\n213#1:636,2\n355#1:667,6\n558#1:688,6\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentWeakMap<a<?>, Boolean> f10369b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function1<Boolean, Unit> f10370c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> f10371d = null;

    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final Continuation<T> f10372c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public final DebugCoroutineInfoImpl f10373g;

        private final f b() {
            return this.f10373g.d();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            b();
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f10372c.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            b();
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object r10) {
            c.c(c.f10368a, this);
            this.f10372c.resumeWith(r10);
        }

        public String toString() {
            return this.f10372c.toString();
        }
    }

    private static final class b {

        @Volatile
        private volatile int installations;

        static {
            AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.c$c, reason: collision with other inner class name */
    private static final class C0224c {

        @Volatile
        private volatile long sequenceNumber;

        static {
            AtomicLongFieldUpdater.newUpdater(C0224c.class, "sequenceNumber");
        }

        private C0224c() {
        }

        public /* synthetic */ C0224c(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        c r10 = new c();
        f10368a = r10;
        new a.a().b();
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DefaultConstructorMarker r11 = null;
        f10369b = new ConcurrentWeakMap(false, 1, r11);
        f10370c = r10.d();
        f10371d = new ConcurrentWeakMap(true);
        new b(r11);
        new C0224c(r11);
    }

    private c() {
    }

    public static final /* synthetic */ ConcurrentWeakMap a() {
        return f10371d;
    }

    public static final /* synthetic */ boolean b(c r10, a r11) {
        return r10.e(r11);
    }

    public static final /* synthetic */ void c(c r10, a r11) {
        r10.f(r11);
    }

    private final Function1<Boolean, Unit> d() {
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L4
        Object r11 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");     // Catch: Throwable -> L4
        Object r12 = Result.m32constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, 1));     // Catch: Throwable -> L4
    L7:
        if (Result.m38isFailureimpl(r12) == false) goto L10;
        r12 = null;
    L10:
        return (Function1) r12;
    L4:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean e(a<?> r10) {
        CoroutineContext r11 = r10.f10373g.c();
        if (r11 == null) goto L12;
        v1 r12 = (v1) r11.get(v1.f10723e);
        if (r12 == null) goto L12;
        if (r12.a() == true) goto L10;
        return false;
    L10:
        f10369b.remove(r10);
        return true;
    L12:
        return false;
    }

    private final void f(a<?> r10) {
        f10369b.remove(r10);
        CoroutineStackFrame r11 = r10.f10373g.f();
        if (r11 == null) goto L9;
        CoroutineStackFrame r12 = g(r11);
        if (r12 == null) goto L10;
        f10371d.remove(r12);
        return;
    L10:
        return;
    }

    private final CoroutineStackFrame g(CoroutineStackFrame r10) {
    L2:
        r10 = r10.getCallerFrame();
        if (r10 == null) goto L4;
        if (r10.getStackTraceElement() == null) goto L2;
        return r10;
    L4:
        return null;
    }
}
