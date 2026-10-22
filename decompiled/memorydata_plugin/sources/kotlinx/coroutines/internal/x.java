package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", ExifInterface.LONGITUDE_EAST, "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", IslandSession.REOPEN_VALUE_CLOSE, "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class x<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aj f17601b = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater g = null;
    private static final /* synthetic */ AtomicLongFieldUpdater h = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    private final int c;
    private final boolean d;
    private final int e;
    private final /* synthetic */ AtomicReferenceArray f;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a(long r3) {
            if ((r3 & 2305843009213693952L) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long a(long r3, int r5) {
            return a(r3, 1073741823) | (((long) r5) << 0);
        }

        public final long a(long r1, long r3) {
            return r1 & (~r3);
        }

        public final long b(long r3, int r5) {
            return a(r3, 1152921503533105152L) | (((long) r5) << 30);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17602a;

        public b(int r1) {
            this.f17602a = r1;
        }
    }

    static {
        f17600a = new a(null);
        g = AtomicReferenceFieldUpdater.newUpdater(x.class, Object.class, "_next$volatile");
        h = AtomicLongFieldUpdater.newUpdater(x.class, "_state$volatile");
        f17601b = new aj("REMOVE_FROZEN");
    }

    public x(int r4, boolean r5) {
        this.c = r4;
        this.d = r5;
        int r6 = r4 - 1;
        this.e = r6;
        this.f = new AtomicReferenceArray(r4);
        boolean r3 = false;
        if (r6 > 1073741823) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L16;
        if ((r4 & r6) != 0) goto L11;
        r3 = true;
    L11:
        if (r3 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r1 = false;
        goto L7
    }

    private final x<E> a(int r11, int r12) {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        a r1 = f17600a;
        boolean r2 = false;
        int r7 = (int) ((1073741823 & r3) >> 0);
        if (kotlinx.coroutines.an.a() == false) goto L12;
        if (r7 != r11) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L12:
        if ((1152921504606846976L & r3) != 0) goto L14;
        if (i().compareAndSet(this, r3, r1.a(r3, r12)) == false) goto L3;
        f().set(this.e & r7, null);
        return null;
    L14:
        return e();
    }

    private final x<E> a(int r4, E r5) {
        Object r0 = f().get(this.e & r4);
        if (ZeusTransformUtils.instanceOf(r0, b.class) == true) goto L5;
        return null;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).f17602a != r4) goto L10;
        f().set(r4 & this.e, r5);
        return this;
    L10:
        return null;
    }

    private final x<E> a(long r5) {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        x<E> r1 = (x) ZeusTransformUtils.preCheckCast(r0.get(this), x.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        h().compareAndSet(this, null, b(r5));
        goto L3
    L5:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final x<E> b(long r7) {
        x<E> r0 = new x(this.c * 2, this.d);
        int r1 = (int) ((1073741823 & r7) >> 0);
        int r2 = (int) ((1152921503533105152L & r7) >> 30);
    L3:
        int r3 = this.e;
        if ((r1 & r3) == (r3 & r2)) goto L9;
        Object r4 = f().get(this.e & r1);
        if (r4 != null) goto L8;
        r4 = new b(r1);
    L8:
        r0.f().set(r0.e & r1, r4);
        r1 = r1 + 1;
        goto L3
    L9:
        i().set(r0, f17600a.a(r7, 1152921504606846976L));
        return r0;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f;
    }

    private final long g() {
        AtomicLongFieldUpdater r6 = i();
    L3:
        long r2 = r6.get(this);
        if ((r2 & 1152921504606846976L) != 0) goto L5;
        long r7 = r2 | 1152921504606846976L;
        if (r6.compareAndSet(this, r2, r7) == false) goto L3;
        return r7;
    L5:
        return r2;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater h() {
        return g;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater i() {
        return h;
    }

    public final int a(E r15) {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        if ((3458764513820540928L & r3) != 0) goto L6;
        a r1 = f17600a;
        int r2 = (int) ((1073741823 & r3) >> 0);
        int r10 = (int) ((1152921503533105152L & r3) >> 30);
        int r11 = this.e;
        if (((r10 + 2) & r11) == (r2 & r11)) goto L9;
        if (this.d == true) goto L20;
        if (f().get(r10 & r11) == null) goto L20;
        int r4 = this.c;
        if (r4 < 1024) goto L18;
        if (((r10 - r2) & 1073741823) <= (r4 >> 1)) goto L3;
    L18:
        return 1;
    L20:
        if (i().compareAndSet(this, r3, r1.b(r3, (r10 + 1) & 1073741823)) == false) goto L3;
        f().set(r10 & r11, r15);
    L23:
        if ((i().get(this) & 1152921504606846976L) == 0) goto L26;
        x<E> this = this.e().a(r10, r15);
        if (this != null) goto L23;
    L26:
        return 0;
    L9:
        return 1;
    L6:
        return f17600a.a(r3);
    }

    public final boolean a() {
        long r0 = i().get(this);
        if (((int) ((1073741823 & r0) >> 0)) != ((int) ((r0 & 1152921503533105152L) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final int b() {
        long r0 = i().get(this);
        int r4 = (int) ((1073741823 & r0) >> 0);
        return 1073741823 & (((int) ((r0 & 1152921503533105152L) >> 30)) - r4);
    }

    public final boolean c() {
        AtomicLongFieldUpdater r6 = i();
    L3:
        long r2 = r6.get(this);
        if ((r2 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r2) != 0) goto L8;
        if (r6.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    public final Object d() {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        if ((1152921504606846976L & r3) != 0) goto L6;
        a r1 = f17600a;
        int r7 = (int) ((1073741823 & r3) >> 0);
        int r2 = (int) ((1152921503533105152L & r3) >> 30);
        int r5 = this.e;
        if ((r2 & r5) == (r5 & r7)) goto L9;
        Object r9 = f().get(this.e & r7);
        if (r9 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L17;
        int r10 = (r7 + 1) & 1073741823;
        if (i().compareAndSet(this, r3, r1.a(r3, r10)) == true) goto L20;
        if (this.d == false) goto L3;
    L24:
        x<E> this = this.a(r7, r10);
        if (this != null) goto L24;
        return r9;
    L20:
        f().set(this.e & r7, null);
        return r9;
    L17:
        return null;
    L13:
        if (this.d == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f17601b;
    }

    public final x<E> e() {
        return a(g());
    }
}
