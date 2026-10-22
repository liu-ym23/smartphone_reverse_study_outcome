package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.as;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u00002\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b¢\u0006\u0002\u0010\u001eJ0\u0010\u001f\u001a\u0004\u0018\u00018\u00002!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u001d¢\u0006\u0002\u0010#J\u000f\u0010$\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010%J\r\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010%J\u0015\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0002¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010-J$\u0010.\u001a\u0004\u0018\u00018\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b¢\u0006\u0002\u0010#J\r\u0010/\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010%J\u0011\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0010H\u0082\u0010J\u0011\u00102\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0010H\u0082\u0010J\u0018\u00103\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0002R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00065"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", EventBody.KEY_VALUE, "", "size", "getSize", "()I", "setSize", "(I)V", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function1;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "find", "predicate", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", com.loc.o.j, "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ar<T extends as & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17569b = null;
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T[] f17570a;

    static {
        f17569b = AtomicIntegerFieldUpdater.newUpdater(ar.class, "_size$volatile");
    }

    public ar() {
    }

    private final void a(int r3, int r4) {
        T[] r2 = this.f17570a;
        Intrinsics.checkNotNull(r2);
        T r0 = r2[r4];
        Intrinsics.checkNotNull(r0);
        T r1 = r2[r3];
        Intrinsics.checkNotNull(r1);
        r2[r3] = r0;
        r2[r4] = r1;
        r0.a(r3);
        r1.a(r4);
    }

    private final void b(int r2) {
        g().set(this, r2);
    }

    private final void c(int r6) {
    L2:
        if (r6 <= 0) goto L3;
        T[] r0 = this.f17570a;
        Intrinsics.checkNotNull(r0);
        int r1 = (r6 - 1) / 2;
        T r2 = r0[r1];
        Intrinsics.checkNotNull(r2);
        Comparable r3 = (Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin");
        T r4 = r0[r6];
        Intrinsics.checkNotNull(r4);
        if (r3.compareTo(r4) <= 0) goto L6;
        a(r6, r1);
        r6 = r1;
        goto L2
    L6:
        return;
    }

    private final void d(int r7) {
    L2:
        int r0 = (r7 * 2) + 1;
        if (r0 >= a()) goto L4;
        T[] r1 = this.f17570a;
        Intrinsics.checkNotNull(r1);
        int r2 = r0 + 1;
        if (r2 >= a()) goto L10;
        T r3 = r1[r2];
        Intrinsics.checkNotNull(r3);
        Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin");
        T r5 = r1[r0];
        Intrinsics.checkNotNull(r5);
        if (r4.compareTo(r5) >= 0) goto L10;
        r0 = r2;
    L10:
        T r6 = r1[r7];
        Intrinsics.checkNotNull(r6);
        Comparable r8 = (Comparable) ZeusTransformUtils.preCheckCast(r6, Comparable.class, "com.obric.memorydata.plugin");
        T r9 = r1[r0];
        Intrinsics.checkNotNull(r9);
        if (r8.compareTo(r9) <= 0) goto L12;
        a(r7, r0);
        r7 = r0;
        goto L2
    L12:
        return;
    }

    private final T[] f() {
        T[] r0 = this.f17570a;
        if (r0 != null) goto L6;
        T[] r1 = (T[]) new as[4];
        this.f17570a = r1;
        return r1;
    L6:
        if (a() < r0.length) goto L10;
        Object[] r2 = Arrays.copyOf(r0, a() * 2);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(...)");
        this.f17570a = (T[]) ((as[]) ZeusTransformUtils.preCheckCast(r2, as[].class, "com.obric.memorydata.plugin"));
        return (T[]) ((as[]) ZeusTransformUtils.preCheckCast(r2, as[].class, "com.obric.memorydata.plugin"));
    L10:
        return r0;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater g() {
        return f17569b;
    }

    public final int a() {
        return g().get(this);
    }

    public final T a(int r9) {
        boolean r1 = false;
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        T[] r0 = this.f17570a;
        Intrinsics.checkNotNull(r0);
        b(a() - 1);
        if (r9 >= a()) goto L20;
        a(r9, a());
        int r3 = (r9 - 1) / 2;
        if (r9 <= 0) goto L19;
        T r5 = r0[r9];
        Intrinsics.checkNotNull(r5);
        Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.memorydata.plugin");
        T r7 = r0[r3];
        Intrinsics.checkNotNull(r7);
        if (r6.compareTo(r7) >= 0) goto L19;
        a(r9, r3);
        c(r3);
    L19:
        d(r9);
    L20:
        T r10 = r0[a()];
        Intrinsics.checkNotNull(r10);
        if (kotlinx.coroutines.an.a() == true) goto L23;
    L29:
        r10.a(null);
        r10.a(-1);
        r0[a()] = null;
        return r10;
    L23:
        if (r10.a() != this) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L29;
        throw new AssertionError();
    L5:
        if (a() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final boolean a(T r4) {
        as r5 = (as) ZeusTransformUtils.wrapperContextForParams(r4, as.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        boolean r1 = true;
        boolean r2 = false;
        if (r5.a() != null) goto L7;
        r1 = false;
    L16:
        monitor-exit(this);
        return r1;
    L7:
        int r6 = r5.b();     // Catch: Throwable -> L18
        if (kotlinx.coroutines.an.a() == false) goto L15;
        if (r6 < 0) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L15;
        throw new AssertionError();     // Catch: Throwable -> L18
    L15:
        a(r6);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final void b(T r4) {
        as r5 = (as) ZeusTransformUtils.wrapperContextForParams(r4, as.class, "com.obric.memorydata.plugin");
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        r5.a(this);
        as[] r0 = f();
        int r1 = a();
        b(r1 + 1);
        r0[r1] = r5;
        r5.a(r1);
        c(r1);
        return;
    L5:
        if (r5.a() != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final boolean b() {
        if (a() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T c() {
        monitor-enter(this);
        T r0 = (T) e();
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final T d() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (a() <= 0) goto L7;
        T r0 = (T) a(0);
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final T e() {
        T[] r1 = this.f17570a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1[0];
    }
}
