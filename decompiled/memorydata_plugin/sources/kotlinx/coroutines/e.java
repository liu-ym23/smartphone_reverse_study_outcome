package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@¢\u0006\u0002\u0010\fR\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\t\u0010\b\u001a\u00020\tX\u0082\u0004¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", ExifInterface.GPS_DIRECTION_TRUE, "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17339b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ar<T>[] f17340a;
    private volatile /* synthetic */ int notCompletedCount$volatile;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001b\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t0\u0007X\u0082\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\u000b\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\u000e\u0018\u00010\bR\b\u0012\u0004\u0012\u00028\u00000\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "_disposer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", EventBody.KEY_VALUE, "disposer", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a extends cd {
        private static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
        private volatile /* synthetic */ Object _disposer$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bc f17341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e<T> f17342b;
        private final n<List<? extends T>> d;

        static {
            e = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer$volatile");
        }

        public a(e r3, n<? super List<? extends T>> r4) {
            n<List<? extends T>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            this.f17342b = r3;
            this.d = r5;
        }

        private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
            return e;
        }

        public final bc a() {
            bc r0 = this.f17341a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        @Override // kotlinx.coroutines.bt
        public void a(Throwable r6) {
            if (r6 == null) goto L9;
            Object r7 = this.d.a(r6);
            if (r7 == null) goto L16;
            this.d.a(r7);
            e<T>.b r5 = b();
            if (r5 == null) goto L17;
            r5.a();
            return;
        L17:
            return;
        L16:
            return;
        L9:
            if (e.a().decrementAndGet(this.f17342b) != 0) goto L19;
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this.d, Continuation.class, "com.obric.memorydata.plugin");
            ar[] r9 = e.a(this.f17342b);
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.memorydata.plugin");
            int r2 = 0;
            int r3 = r9.length;
        L11:
            if (r2 >= r3) goto L13;
            r0.add(r9[r2].f());
            r2 = r2 + 1;
            goto L11
        L13:
            List r10 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
            Result.Companion r1 = Result.Companion;
            r8.resumeWith(Result.m1421constructorimpl(r10));
            return;
        }

        public final void a(bc r3) {
            this.f17341a = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin");
        }

        public final void a(e<T>.b r2) {
            k().set(this, r2);
        }

        public final e<T>.b b() {
            return (b) ZeusTransformUtils.preCheckCast(k().get(this), b.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<T> f17343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e<T>.a[] f17344b;

        public b(e r1, e<T>.a[] r2) {
            this.f17343a = r1;
            this.f17344b = r2;
        }

        public final void a() {
            e<T>.a[] r3 = this.f17344b;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].a().dispose();
            r1 = r1 + 1;
            goto L3
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable r1) {
            a();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f17344b + ']';
        }
    }

    static {
        f17339b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount$volatile");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(ar<? extends T>[] r1) {
        this.f17340a = r1;
        this.notCompletedCount$volatile = r1.length;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater a() {
        return b();
    }

    public static final /* synthetic */ ar[] a(e r0) {
        return r0.f17340a;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater b() {
        return f17339b;
    }

    public final Object a(Continuation<? super List<? extends T>> r18) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        o r3 = new o(IntrinsicsKt.intercepted(r1), 1);
        r3.e();
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        int r5 = a(this).length;
        a[] r6 = new a[r5];
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r8 >= r5) goto L5;
        ar r9 = a(this)[r8];
        r9.s_();
        a r10 = new a(this, r4);
        r10.a(ca.a((bx) ZeusTransformUtils.preCheckCast(r9, bx.class, "com.obric.memorydata.plugin"), false, false, (bt) ZeusTransformUtils.preCheckCast(r10, bt.class, "com.obric.memorydata.plugin"), 3, null));
        Unit r11 = Unit.INSTANCE;
        r6[r8] = r10;
        r8 = r8 + 1;
        goto L3
    L5:
        e<T>.b r12 = new b(this, r6);
    L6:
        if (r7 >= r5) goto L9;
        r6[r7].a(r12);
        r7 = r7 + 1;
        goto L6
    L9:
        if (r4.b() == false) goto L11;
        r12.a();
    L12:
        Object r0 = r3.h();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L15:
        return r0;
    L11:
        q.a(r4, (m) ZeusTransformUtils.preCheckCast(r12, m.class, "com.obric.memorydata.plugin"));
        goto L12
    }
}
