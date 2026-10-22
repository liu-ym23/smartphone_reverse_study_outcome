package kotlinx.coroutines.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.f;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u0004\u0018\u00018\u00002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0086\b¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0018J\u0013\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"R\u0011\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\n¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "aliveSegmentLeft", "getAliveSegmentLeft", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "aliveSegmentRight", "getAliveSegmentRight", "isRemoved", "", "()Z", "isTail", "next", "getNext", "nextOrClosed", "getNextOrClosed", "()Ljava/lang/Object;", "getPrev", "cleanPrev", "", "markAsClosed", "nextOrIfClosed", "onClosedAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "trySetNext", EventBody.KEY_VALUE, "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class f<N extends f<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17581b = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        f17580a = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_next$volatile");
        f17581b = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_prev$volatile");
    }

    public f(N r1) {
        this._prev$volatile = r1;
    }

    private final Object a() {
        return k().get(this);
    }

    public static final /* synthetic */ Object b(f r0) {
        return r0.a();
    }

    private final N b() {
        N r2 = (N) e();
    L3:
        if (r2 == null) goto L7;
        if (r2.h() == false) goto L7;
        r2 = (N) ZeusTransformUtils.preCheckCast(l().get(r2), f.class, "com.obric.memorydata.plugin");
    L7:
        return r2;
    }

    private final N j() {
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L9:
        N r1 = (N) c();
        Intrinsics.checkNotNull(r1);
    L11:
        if (r1.h() == false) goto L16;
        f r0 = r1.c();
        if (r0 == null) goto L14;
        r1 = (N) r0;
        goto L11
    L14:
        return r1;
    L16:
        return r1;
    L5:
        if ((!d()) == true) goto L9;
        throw new AssertionError();
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f17580a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return f17581b;
    }

    public final boolean a(N r3) {
        return k().compareAndSet(this, null, r3);
    }

    public final N c() {
        Object r2 = b(this);
        if (r2 != e.a()) goto L7;
        return null;
    L7:
        return (N) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.memorydata.plugin");
    }

    public final boolean d() {
        if (c() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final N e() {
        return (N) ZeusTransformUtils.preCheckCast(l().get(this), f.class, "com.obric.memorydata.plugin");
    }

    public final void f() {
        l().set(this, null);
    }

    public final boolean g() {
        return k().compareAndSet(this, null, e.a());
    }

    public abstract boolean h();

    public final void i() {
        if (kotlinx.coroutines.an.a() == false) goto L16;
        if (h() == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L16;
        throw new AssertionError();
    L7:
        if (d() == true) goto L10;
        r0 = false;
    L16:
        if (d() == false) goto L18;
        return;
    L18:
        f r1 = b();
        f r2 = j();
        AtomicReferenceFieldUpdater r3 = l();
    L19:
        Object r4 = r3.get(r2);
        if (((f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.memorydata.plugin")) != null) goto L22;
        f r5 = null;
    L24:
        if (r3.compareAndSet(r2, r4, r5) == false) goto L19;
        if (r1 == null) goto L28;
        k().set(r1, r2);
    L28:
        if (r2.h() == false) goto L31;
        if (r2.d() == false) goto L18;
    L31:
        if (r1 == null) goto L44;
        if (r1.h() == true) goto L18;
        return;
    L44:
        return;
    L22:
        r5 = r1;
        goto L24
    }
}
