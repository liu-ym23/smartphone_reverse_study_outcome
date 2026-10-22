package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n314#2,9:128\n323#2,2:141\n13#3:137\n19#3:140\n13579#4,2:138\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll\n*L\n71#1:128,9\n71#1:141,2\n78#1:137\n90#1:140\n83#1:138,2\n*E\n"})
final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f10376b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r0<T>[] f10377a;

    @Volatile
    private volatile int notCompletedCount;

    @SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n11335#2:128\n11670#2,3:129\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$AwaitAllNode\n*L\n121#1:128\n121#1:129,3\n*E\n"})
    private final class a extends b2 {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f10378m = null;

        @Volatile
        private volatile Object _disposer;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final n<List<? extends T>> f10379j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public b1 f10380k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ e<T> f10381l;

        static {
            f10378m = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(e r10, n<? super List<? extends T>> r11) {
            this.f10381l = r10;
            this.f10379j = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
            q(r10);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.d0
        public void q(Throwable r10) {
            if (r10 == null) goto L9;
            Object r11 = this.f10379j.j(r10);
            if (r11 == null) goto L16;
            this.f10379j.N(r11);
            e<T>.b r12 = t();
            if (r12 == null) goto L17;
            r12.h();
            return;
        L17:
            return;
        L16:
            return;
        L9:
            if (e.b().decrementAndGet(this.f10381l) != 0) goto L19;
            n<List<? extends T>> r13 = this.f10379j;
            r0[] r14 = e.a(this.f10381l);
            ArrayList r15 = new ArrayList(r14.length);
            int r16 = 0;
            int r17 = r14.length;
        L11:
            if (r16 >= r17) goto L13;
            r15.add(r14[r16].f());
            r16 = r16 + 1;
            goto L11
        L13:
            Result.Companion r18 = Result.Companion;
            r13.resumeWith(Result.m32constructorimpl(r15));
            return;
        }

        public final e<T>.b t() {
            return (b) f10378m.get(this);
        }

        public final b1 u() {
            b1 r10 = this.f10380k;
            if (r10 == null) goto L5;
            return r10;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        public final void v(e<T>.b r10) {
            f10378m.set(this, r10);
        }

        public final void w(b1 r10) {
            this.f10380k = r10;
        }
    }

    @SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,127:1\n13579#2,2:128\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel\n*L\n96#1:128,2\n*E\n"})
    private final class b extends l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e<T>.a[] f10382c;

        public b(e r10, e<T>.a[] r11) {
            this.f10382c = r11;
        }

        @Override // kotlinx.coroutines.m
        public void g(Throwable r10) {
            h();
        }

        public final void h() {
            e<T>.a[] r10 = this.f10382c;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r10[r12].u().dispose();
            r12 = r12 + 1;
            goto L3
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r10) {
            g(r10);
            return Unit.INSTANCE;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f10382c + ']';
        }
    }

    static {
        f10376b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(r0<? extends T>[] r10) {
        this.f10377a = r10;
        this.notCompletedCount = r10.length;
    }

    public static final /* synthetic */ r0[] a(e r10) {
        return r10.f10377a;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater b() {
        return f10376b;
    }

    public final Object c(Continuation<? super List<? extends T>> r10) {
        o r11 = new o(IntrinsicsKt.intercepted(r10), 1);
        r11.F();
        int r12 = a(this).length;
        a[] r13 = new a[r12];
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r0 r16 = a(this)[r15];
        r16.start();
        a r17 = new a(this, r11);
        r17.w(r16.A(r17));
        Unit r18 = Unit.INSTANCE;
        r13[r15] = r17;
        r15 = r15 + 1;
        goto L3
    L5:
        e<T>.b r19 = new b(this, r13);
    L6:
        if (r14 >= r12) goto L9;
        r13[r14].v(r19);
        r14 = r14 + 1;
        goto L6
    L9:
        if (r11.a() == false) goto L11;
        r19.h();
    L12:
        Object r20 = r11.B();
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L15:
        return r20;
    L11:
        r11.h(r19);
        goto L12
    }
}
