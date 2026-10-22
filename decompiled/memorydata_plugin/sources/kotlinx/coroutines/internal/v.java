package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ%\u0010\u0017\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0086\bJ \u0010\u001a\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0001J\u0012\u0010\u001b\u001a\u00020\t2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000fJ\u001b\u0010\u001c\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0082\u0010J\u0019\u0010\u001f\u001a\u00060\u0000j\u0002`\u000f2\n\u0010 \u001a\u00060\u0000j\u0002`\u000fH\u0082\u0010J\u0014\u0010!\u001a\u00020\u00152\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0002J%\u0010\"\u001a\u00020#2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\u000e\b\u0004\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0081\bJ\u0010\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0014J\b\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u000fH\u0001J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020)H\u0016J(\u0010*\u001a\u00020+2\n\u0010\u0016\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000f2\u0006\u0010,\u001a\u00020#H\u0001J%\u0010-\u001a\u00020\u00152\n\u0010.\u001a\u00060\u0000j\u0002`\u000f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u000fH\u0000¢\u0006\u0002\b/R\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004R\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004X\u0082\u0004R\u0011\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00060\u0000j\u0002`\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "()V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "_removedRef", "Lkotlinx/coroutines/internal/Removed;", "isRemoved", "", "()Z", "next", "getNext", "()Ljava/lang/Object;", "nextNode", "Lkotlinx/coroutines/internal/Node;", "getNextNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "prevNode", "getPrevNode", "addLast", "", "node", "addLastIf", "condition", "Lkotlin/Function0;", "addNext", "addOneIfEmpty", "correctPrev", "op", "Lkotlinx/coroutines/internal/OpDescriptor;", "findPrevNonRemoved", "current", "finishAdd", "makeCondAddOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "remove", "removeOrNext", "removed", "toString", "", "tryCondAddNext", "", "condAdd", "validateNode", "prev", "validateNode$kotlinx_coroutines_core", "CondAddOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17598b = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater c = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;
    private volatile /* synthetic */ Object _removedRef$volatile;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class a extends b<v> {
        public final v c;
        public v d;

        public a(v r1) {
            this.c = r1;
        }

        @Override // kotlinx.coroutines.internal.b
        public /* synthetic */ void a(v r3, Object r4) {
            a2((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.memorydata.plugin"), r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(v r3, Object r4) {
            if (r4 != null) goto L4;
            boolean r5 = true;
        L5:
            if (r5 == false) goto L7;
            v r0 = this.c;
        L8:
            if (r0 != null) goto L10;
            return;
        L10:
            if (v.j().compareAndSet(r3, this, r0) == false) goto L15;
            if (r5 == false) goto L16;
            v r6 = this.c;
            v r2 = this.d;
            Intrinsics.checkNotNull(r2);
            v.a(r6, r2);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r0 = this.d;
            goto L8
        L4:
            r5 = false;
            goto L5
        }
    }

    static {
        f17597a = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_next$volatile");
        f17598b = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_prev$volatile");
        c = AtomicReferenceFieldUpdater.newUpdater(v.class, Object.class, "_removedRef$volatile");
    }

    public v() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    private final v a(ac r11) {
    L3:
        v r1 = (v) ZeusTransformUtils.preCheckCast(l().get(this), v.class, "com.obric.memorydata.plugin");
        v r4 = r1;
    L4:
        v r5 = null;
    L5:
        Object r6 = k().get(r4);
        if (r6 == this) goto L7;
        if (d() == true) goto L15;
        if (r6 == r11) goto L17;
        if (ZeusTransformUtils.instanceOf(r6, ac.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, ad.class) == true) goto L23;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        r5 = r4;
        r4 = (v) ZeusTransformUtils.preCheckCast(r6, v.class, "com.obric.memorydata.plugin");
        goto L5
    L23:
        if (r5 != null) goto L25;
        r4 = (v) ZeusTransformUtils.preCheckCast(l().get(r4), v.class, "com.obric.memorydata.plugin");
        goto L5
    L25:
        if (k().compareAndSet(r5, r4, ((ad) ZeusTransformUtils.preCheckCast(r6, ad.class, "com.obric.memorydata.plugin")).f17556a) == false) goto L3;
        r4 = r5;
        goto L4
    L20:
        ((ac) ZeusTransformUtils.preCheckCast(r6, ac.class, "com.obric.memorydata.plugin")).b(r4);
        goto L3
    L17:
        return r4;
    L15:
        return null;
    L7:
        if (r1 == r4) goto L8;
        if (l().compareAndSet(this, r1, r4) == false) goto L3;
        return r4;
    L8:
        return r4;
    }

    public static final /* synthetic */ void a(v r0, v r1) {
        r0.c(r1);
    }

    private final v b(v r2) {
    L3:
        if (r2.d() == false) goto L4;
        r2 = (v) ZeusTransformUtils.preCheckCast(l().get(r2), v.class, "com.obric.memorydata.plugin");
        goto L3
    L4:
        return r2;
    }

    private final ad c() {
        ad r0 = (ad) ZeusTransformUtils.preCheckCast(m().get(this), ad.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ad r1 = new ad(this);
        m().set(this, r1);
        return r1;
    L6:
        return r0;
    }

    private final void c(v r5) {
        AtomicReferenceFieldUpdater r0 = l();
    L3:
        v r1 = (v) ZeusTransformUtils.preCheckCast(r0.get(r5), v.class, "com.obric.memorydata.plugin");
        if (f() != r5) goto L5;
        if (l().compareAndSet(r5, r1, this) == false) goto L3;
        if (d() == false) goto L15;
        r5.a(null);
        return;
    L15:
        return;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater j() {
        return k();
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f17597a;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater l() {
        return f17598b;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater m() {
        return c;
    }

    public final int a(v r2, v r3, a r4) {
        l().set(r2, this);
        k().set(r2, r3);
        r4.d = r3;
        if (k().compareAndSet(this, r3, r4) == true) goto L7;
        return 0;
    L7:
        if (r4.b(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    public final boolean a(v r2) {
        l().set(r2, this);
        k().set(r2, this);
    L4:
        if (f() != this) goto L5;
        if (k().compareAndSet(this, this, r2) == false) goto L4;
        r2.c(this);
        return true;
    L5:
        return false;
    }

    public boolean d() {
        return ZeusTransformUtils.instanceOf(f(), ad.class);
    }

    public boolean e() {
        if (i() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Object f() {
        AtomicReferenceFieldUpdater r0 = k();
    L3:
        Object r1 = r0.get(this);
        if (ZeusTransformUtils.instanceOf(r1, ac.class) == false) goto L5;
        ((ac) ZeusTransformUtils.preCheckCast(r1, ac.class, "com.obric.memorydata.plugin")).b(this);
        goto L3
    L5:
        return r1;
    }

    public final v g() {
        Object r2 = f();
        if (ZeusTransformUtils.instanceOf(r2, ad.class) == false) goto L5;
        ad r0 = (ad) ZeusTransformUtils.preCheckCast(r2, ad.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L9;
        v r1 = r0.f17556a;
        if (r1 == null) goto L9;
        return r1;
    L9:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (v) ZeusTransformUtils.preCheckCast(r2, v.class, "com.obric.memorydata.plugin");
    L5:
        r0 = null;
        goto L6
    }

    public final v h() {
        v r0 = a(null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return b((v) ZeusTransformUtils.preCheckCast(l().get(this), v.class, "com.obric.memorydata.plugin"));
    }

    public final v i() {
    L3:
        Object r1 = f();
        if (ZeusTransformUtils.instanceOf(r1, ad.class) == true) goto L6;
        if (r1 == this) goto L9;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        ad r2 = ((v) ZeusTransformUtils.preCheckCast(r1, v.class, "com.obric.memorydata.plugin")).c();
        if (k().compareAndSet(this, r1, r2) == false) goto L3;
        ((v) ZeusTransformUtils.preCheckCast(r1, v.class, "com.obric.memorydata.plugin")).a(null);
        return null;
    L9:
        return (v) ZeusTransformUtils.preCheckCast(r1, v.class, "com.obric.memorydata.plugin");
    L6:
        return ((ad) ZeusTransformUtils.preCheckCast(r1, ad.class, "com.obric.memorydata.plugin")).f17556a;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + kotlinx.coroutines.ao.a(this);
    }
}
