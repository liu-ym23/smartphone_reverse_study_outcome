package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,731:1\n28#2,4:732\n28#2,4:738\n28#2,4:760\n28#2,4:767\n28#2,4:779\n28#2,4:793\n28#2,4:807\n20#3:736\n20#3:742\n20#3:764\n20#3:771\n20#3:783\n20#3:797\n20#3:811\n329#4:737\n1#5:743\n94#6,2:744\n96#6,2:747\n98#6:750\n94#6,2:772\n96#6,2:775\n98#6:778\n94#6,2:800\n96#6,2:803\n98#6:806\n13579#7:746\n13580#7:749\n13579#7:774\n13580#7:777\n13579#7:802\n13580#7:805\n314#8,9:751\n323#8,2:765\n314#8,9:784\n323#8,2:798\n*S KotlinDebug\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowImpl\n*L\n351#1:732,4\n391#1:738,4\n485#1:760,4\n506#1:767,4\n626#1:779,4\n661#1:793,4\n689#1:807,4\n351#1:736\n391#1:742\n485#1:764\n506#1:771\n626#1:783\n661#1:797\n689#1:811\n373#1:737\n453#1:744,2\n453#1:747,2\n453#1:750\n529#1:772,2\n529#1:775,2\n529#1:778\n676#1:800,2\n676#1:803,2\n676#1:806\n453#1:746\n453#1:749\n529#1:774\n529#1:777\n676#1:802\n676#1:805\n483#1:751,9\n483#1:765,2\n660#1:784,9\n660#1:798,2\n*E\n"})
public class SharedFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<l1> implements f1<T>, kotlinx.coroutines.flow.internal.k<T>, kotlinx.coroutines.flow.internal.k {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f10441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f10442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final BufferOverflow f10443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Object[] f10444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f10445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f10446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f10447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10448q;

    private static final class a implements kotlinx.coroutines.b1 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final SharedFlowImpl<?> f10449c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @JvmField
        public long f10450g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @JvmField
        public final Object f10451h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @JvmField
        public final Continuation<Unit> f10452i;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SharedFlowImpl<?> r10, long r11, Object r12, Continuation<? super Unit> r13) {
            this.f10449c = r10;
            this.f10450g = r11;
            this.f10451h = r12;
            this.f10452i = r13;
        }

        @Override // kotlinx.coroutines.b1
        public void dispose() {
            SharedFlowImpl.n(this.f10449c, this);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10453a = null;

        static {
            int[] r10 = new int[BufferOverflow.values().length];
            r10[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f10453a = r10;
        }
    }

    public SharedFlowImpl(int r10, int r11, BufferOverflow r12) {
        this.f10441j = r10;
        this.f10442k = r11;
        this.f10443l = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <T> Object A(SharedFlowImpl<T> r10, d<? super T> r11, Continuation<?> r12) {
        if ((r12 instanceof SharedFlowImpl$collect$1) == false) goto L7;
        SharedFlowImpl$collect$1 r13 = (SharedFlowImpl$collect$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L26;
        if (r17 == 1) goto L21;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        v1 r18 = (v1) r13.L$3;
        l1 r19 = (l1) r13.L$2;
        d r20 = (d) r13.L$1;
        SharedFlowImpl<T> r21 = (SharedFlowImpl) r13.L$0;
    L56:
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L19
        d r110 = r20;
        v1 r22 = r18;
        r10 = r21;
    L34:
        Object r23 = r10.U(r19);     // Catch: Throwable -> L44
        if (r23 == k1.f10501a) goto L36;
        if (r22 == null) goto L41;
        y1.h(r22);     // Catch: Throwable -> L44
    L41:
        r13.L$0 = r10;     // Catch: Throwable -> L44
        r13.L$1 = r110;     // Catch: Throwable -> L44
        r13.L$2 = r19;     // Catch: Throwable -> L44
        r13.L$3 = r22;     // Catch: Throwable -> L44
        r13.label = 3;     // Catch: Throwable -> L44
        if (r110.emit(r23, r13) != r16) goto L34;
        return r16;
    L36:
        r13.L$0 = r10;     // Catch: Throwable -> L44
        r13.L$1 = r110;     // Catch: Throwable -> L44
        r13.L$2 = r19;     // Catch: Throwable -> L44
        r13.L$3 = r22;     // Catch: Throwable -> L44
        r13.label = 2;     // Catch: Throwable -> L44
        if (r10.x(r19, r13) != r16) goto L34;
        return r16;
    L44:
        th = move-exception;
        r21 = r10;
        Throwable th = th;
    L48:
        r21.k(r19);
        throw th;
    L19:
        th = th;
        goto L48
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r18 = (v1) r13.L$3;
        r19 = (l1) r13.L$2;
        r20 = (d) r13.L$1;
        r21 = (SharedFlowImpl) r13.L$0;
        goto L56
    L21:
        r19 = (l1) r13.L$2;
        d<? super T> r24 = (d) r13.L$1;
        SharedFlowImpl<T> r25 = (SharedFlowImpl) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L24
        d<? super T> r111 = r24;
        r10 = r25;
    L52:
        r22 = (v1) r13.getContext().get(v1.f10723e);     // Catch: Throwable -> L44
        r110 = r111;
    L24:
        th = th;
        r21 = r25;
        goto L48
    L26:
        ResultKt.throwOnFailure(r15);
        l1 r112 = r10.h();
    L46:
        th = move-exception;
        r21 = r10;
        th = th;
        r19 = r112;
        goto L48
    L28:
        if ((r11 instanceof SubscribedFlowCollector) == false) goto L32;
        r13.L$0 = r10;     // Catch: Throwable -> L46
        r13.L$1 = r11;     // Catch: Throwable -> L46
        r13.L$2 = r112;     // Catch: Throwable -> L46
        r13.label = 1;     // Catch: Throwable -> L46
        if (((SubscribedFlowCollector) r11).a(r13) != r16) goto L32;
        return r16;
    L32:
        r111 = r11;
        r19 = r112;
    L7:
        r13 = new SharedFlowImpl$collect$1(r10, r12);
        goto L8
    }

    private final void B(long r10) {
        if (kotlinx.coroutines.flow.internal.a.f(this) == 0) goto L16;
        kotlinx.coroutines.flow.internal.c[] r11 = kotlinx.coroutines.flow.internal.a.g(this);
        if (r11 == null) goto L16;
        int r12 = 0;
        int r13 = r11.length;
    L7:
        if (r12 >= r13) goto L16;
        kotlinx.coroutines.flow.internal.c r14 = r11[r12];
        if (r14 == null) goto L15;
        l1 r15 = (l1) r14;
        long r16 = r15.f10502a;
        if (r16 < 0) goto L15;
        if (r16 >= r10) goto L15;
        r15.f10502a = r10;
    L15:
        r12 = r12 + 1;
    L16:
        this.f10446o = r10;
    }

    private final void E() {
        Object[] r10 = this.f10444m;
        Intrinsics.checkNotNull(r10);
        k1.d(r10, K(), null);
        this.f10447p--;
        long r11 = K() + 1;
        if (this.f10445n >= r11) goto L6;
        this.f10445n = r11;
    L6:
        if (this.f10446o >= r11) goto L9;
        B(r11);
    L9:
        if (kotlinx.coroutines.n0.a() == true) goto L11;
        return;
    L11:
        if (K() != r11) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L17;
        return;
    L17:
        throw new AssertionError();
    L13:
        r12 = false;
        goto L14
    }

    static /* synthetic */ <T> Object F(SharedFlowImpl<T> r10, T r11, Continuation<? super Unit> r12) {
        if (r10.c(r11) == true) goto L5;
        Object r13 = r10.G(r11, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r13;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final Object G(T r11, Continuation<? super Unit> r12) {
        kotlinx.coroutines.o r10 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r12), 1);
        r10.F();
        Continuation<Unit>[] r13 = kotlinx.coroutines.flow.internal.b.f10489a;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (v(this, r11) == false) goto L7;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        r10.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L28
        Continuation<Unit>[] r15 = p(this, r13);     // Catch: Throwable -> L28
        a r16 = null;
    L11:
        monitor-exit(this);
        if (r16 == null) goto L14;
        kotlinx.coroutines.q.a(r10, r16);
    L14:
        int r17 = 0;
        int r18 = r15.length;
    L15:
        if (r17 >= r18) goto L20;
        Continuation<Unit> r19 = r15[r17];
        if (r19 == null) goto L19;
        Result.Companion r20 = Result.Companion;
        r19.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    L19:
        r17 = r17 + 1;
        goto L15
    L20:
        Object r110 = r10.B();
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L24:
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r110;
    L27:
        return Unit.INSTANCE;
    L7:
        long r21 = r(this);     // Catch: Throwable -> L28
        a r22 = new a(this, ((long) t(this)) + r21, r11, r10);     // Catch: Throwable -> L28
        o(this, r22);     // Catch: Throwable -> L28
        u(this, s(this) + 1);     // Catch: Throwable -> L28
        if (q(this) != 0) goto L10;
        r13 = p(this, r13);     // Catch: Throwable -> L28
    L10:
        r15 = r13;
        r16 = r22;
        goto L11
    }

    private final void H(Object r10) {
        int r11 = P();
        Object[] r12 = this.f10444m;
        if (r12 != null) goto L6;
        r12 = Q(null, 0, 2);
    L8:
        k1.d(r12, K() + ((long) r11), r10);
        return;
    L6:
        if (r11 < r12.length) goto L8;
        r12 = Q(r12, r11, r12.length * 2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    private final Continuation<Unit>[] I(Continuation<Unit>[] r11) {
        int r10 = r11.length;
        if (kotlinx.coroutines.flow.internal.a.f(this) == 0) goto L21;
        kotlinx.coroutines.flow.internal.c[] r12 = kotlinx.coroutines.flow.internal.a.g(this);
        if (r12 == null) goto L21;
        int r13 = 0;
        int r14 = r12.length;
        r11 = r11;
    L7:
        if (r13 >= r14) goto L21;
        kotlinx.coroutines.flow.internal.c r15 = r12[r13];
        if (r15 == null) goto L19;
        l1 r16 = (l1) r15;
        Continuation<? super Unit> r17 = r16.f10503b;
        if (r17 == null) goto L19;
        if (T(r16) < 0) goto L19;
        int r18 = r11.length;
        r11 = r11;
        if (r10 < r18) goto L18;
        Object[] r19 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
        Intrinsics.checkNotNullExpressionValue(r19, "copyOf(this, newSize)");
        r11 = r19;
    L18:
        ((Continuation[]) r11)[r10] = r17;
        r16.f10503b = null;
        r10 = r10 + 1;
    L19:
        r13 = r13 + 1;
        r11 = r11;
    L21:
        return (Continuation[]) r11;
    }

    private final long J() {
        return K() + ((long) this.f10447p);
    }

    private final long K() {
        return Math.min(this.f10446o, this.f10445n);
    }

    private final Object M(long r10) {
        Object[] r11 = this.f10444m;
        Intrinsics.checkNotNull(r11);
        Object r12 = k1.c(r11, r10);
        if ((r12 instanceof a) == true) goto L5;
        return r12;
    L5:
        return ((a) r12).f10451h;
    }

    private final long N() {
        return (K() + ((long) this.f10447p)) + ((long) this.f10448q);
    }

    private final int O() {
        return (int) ((K() + ((long) this.f10447p)) - this.f10445n);
    }

    private final int P() {
        return this.f10447p + this.f10448q;
    }

    private final Object[] Q(Object[] r10, int r11, int r12) {
        int r13 = 0;
        if (r12 <= 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L15;
        Object[] r15 = new Object[r12];
        this.f10444m = r15;
        if (r10 != null) goto L10;
        return r15;
    L10:
        long r16 = K();
    L11:
        if (r13 >= r11) goto L13;
        long r17 = ((long) r13) + r16;
        k1.d(r15, r17, k1.c(r10, r17));
        r13 = r13 + 1;
        goto L11
    L13:
        return r15;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r14 = false;
        goto L6
    }

    private final boolean R(T r15) {
        if (l() != 0) goto L7;
        return S(r15);
    L7:
        if (this.f10447p >= this.f10442k) goto L9;
    L18:
        H(r15);
        int r16 = this.f10447p + 1;
        this.f10447p = r16;
        if (r16 <= this.f10442k) goto L22;
        E();
    L22:
        if (O() <= this.f10441j) goto L24;
        V(this.f10445n + 1, this.f10446o, J(), N());
    L24:
        return true;
    L9:
        if (this.f10446o > this.f10445n) goto L18;
        BufferOverflow r10 = this.f10443l;
        int r11 = b.f10453a[r10.ordinal()];
        if (r11 != 1) goto L13;
        return false;
    L13:
        if (r11 != 2) goto L18;
        return true;
    }

    private final boolean S(T r10) {
        if (kotlinx.coroutines.n0.a() == false) goto L13;
        if (l() != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L13;
        throw new AssertionError();
    L7:
        r11 = false;
    L13:
        if (this.f10441j != 0) goto L15;
        return true;
    L15:
        H(r10);
        int r12 = this.f10447p + 1;
        this.f10447p = r12;
        if (r12 <= this.f10441j) goto L18;
        E();
    L18:
        this.f10446o = K() + ((long) this.f10447p);
        return true;
    }

    private final long T(l1 r10) {
        long r11 = r10.f10502a;
        if (r11 >= J()) goto L6;
        return r11;
    L6:
        if (this.f10442k <= 0) goto L9;
        return -1;
    L9:
        if (r11 <= K()) goto L12;
        return -1;
    L12:
        if (this.f10448q != 0) goto L14;
        return -1;
    L14:
        return r11;
    }

    private final Object U(l1 r10) {
        Continuation<Unit>[] r11 = kotlinx.coroutines.flow.internal.b.f10489a;
        monitor-enter(this);
        long r12 = T(r10);     // Catch: Throwable -> L17
        if (r12 >= 0) goto L7;
        Object r13 = k1.f10501a;     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        int r14 = 0;
        int r15 = r11.length;
    L11:
        if (r14 >= r15) goto L16;
        Continuation<Unit> r16 = r11[r14];
        if (r16 == null) goto L15;
        Result.Companion r17 = Result.Companion;
        r16.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    L15:
        r14 = r14 + 1;
        goto L11
    L16:
        return r13;
    L7:
        long r18 = r10.f10502a;     // Catch: Throwable -> L17
        Object r19 = M(r12);     // Catch: Throwable -> L17
        r10.f10502a = r12 + 1;     // Catch: Throwable -> L17
        r11 = W(r18);     // Catch: Throwable -> L17
        r13 = r19;
    L17:
        th = move-exception;
        throw th;
    }

    private final void V(long r15, long r17, long r19, long r21) {
        long r10 = Math.min(r17, r15);
        boolean r11 = true;
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        long r12 = K();
    L14:
        if (r12 >= r10) goto L16;
        Object[] r13 = this.f10444m;
        Intrinsics.checkNotNull(r13);
        k1.d(r13, r12, null);
        r12 = r12 + 1;
        goto L14
    L16:
        this.f10445n = r15;
        this.f10446o = r17;
        this.f10447p = (int) (r19 - r10);
        this.f10448q = (int) (r21 - r19);
        if (kotlinx.coroutines.n0.a() == false) goto L27;
        if (this.f10447p < 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == true) goto L27;
        throw new AssertionError();
    L21:
        r14 = false;
    L27:
        if (kotlinx.coroutines.n0.a() == false) goto L37;
        if (this.f10448q < 0) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == true) goto L37;
        throw new AssertionError();
    L31:
        r16 = false;
    L37:
        if (kotlinx.coroutines.n0.a() == true) goto L39;
        return;
    L39:
        if (this.f10445n <= (K() + ((long) this.f10447p))) goto L42;
        r11 = false;
    L42:
        if (r11 == false) goto L45;
        return;
    L45:
        throw new AssertionError();
    L5:
        if (r10 < K()) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == true) goto L12;
        throw new AssertionError();
    L7:
        r18 = false;
        goto L8
    }

    public static final /* synthetic */ void n(SharedFlowImpl r10, a r11) {
        r10.y(r11);
    }

    public static final /* synthetic */ void o(SharedFlowImpl r10, Object r11) {
        r10.H(r11);
    }

    public static final /* synthetic */ Continuation[] p(SharedFlowImpl r10, Continuation[] r11) {
        return r10.I(r11);
    }

    public static final /* synthetic */ int q(SharedFlowImpl r10) {
        return r10.f10442k;
    }

    public static final /* synthetic */ long r(SharedFlowImpl r10) {
        return r10.K();
    }

    public static final /* synthetic */ int s(SharedFlowImpl r10) {
        return r10.f10448q;
    }

    public static final /* synthetic */ int t(SharedFlowImpl r10) {
        return r10.P();
    }

    public static final /* synthetic */ void u(SharedFlowImpl r10, int r11) {
        r10.f10448q = r11;
    }

    public static final /* synthetic */ boolean v(SharedFlowImpl r10, Object r11) {
        return r10.R(r11);
    }

    public static final /* synthetic */ long w(SharedFlowImpl r10, l1 r11) {
        return r10.T(r11);
    }

    private final Object x(l1 r10, Continuation<? super Unit> r11) {
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (w(this, r10) >= 0) goto L7;
        r10.f10503b = r12;     // Catch: Throwable -> L17
        r10.f10503b = r12;     // Catch: Throwable -> L17
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        Object r14 = r12.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L14:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r14;
    L16:
        return r13;
    L7:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        r12.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L17
        goto L8
    }

    private final void y(a r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r10.f10450g >= K()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r11 = this.f10444m;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L15
        if (k1.c(r11, r10.f10450g) == r10) goto L12;
        monitor-exit(this);
        return;
    L12:
        k1.d(r11, r10.f10450g, k1.f10501a);     // Catch: Throwable -> L15
        z();     // Catch: Throwable -> L15
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private final void z() {
        if (this.f10442k == 0) goto L5;
    L7:
        Object[] r10 = this.f10444m;
        Intrinsics.checkNotNull(r10);
    L9:
        if (this.f10448q <= 0) goto L13;
        if (k1.c(r10, (K() + ((long) P())) - 1) != k1.f10501a) goto L16;
        this.f10448q--;
        k1.d(r10, K() + ((long) P()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.f10448q > 1) goto L7;
    }

    protected l1 C() {
        return new l1();
    }

    protected l1[] D(int r10) {
        return new l1[r10];
    }

    protected final T L() {
        Object[] r10 = this.f10444m;
        Intrinsics.checkNotNull(r10);
        return (T) k1.c(r10, (this.f10445n + ((long) O())) - 1);
    }

    public final Continuation<Unit>[] W(long r20) {
        if (kotlinx.coroutines.n0.a() == false) goto L13;
        if (r20 < this.f10446o) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L13;
        throw new AssertionError();
    L7:
        r10 = false;
    L13:
        if (r20 > this.f10446o) goto L15;
        long r11 = K();
        long r12 = ((long) this.f10447p) + r11;
        if (this.f10442k != 0) goto L22;
        if (this.f10448q <= 0) goto L22;
        r12 = r12 + 1;
    L22:
        if (kotlinx.coroutines.flow.internal.a.f(this) == 0) goto L36;
        kotlinx.coroutines.flow.internal.c[] r13 = kotlinx.coroutines.flow.internal.a.g(this);
        if (r13 == null) goto L36;
        int r14 = r13.length;
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L36;
        kotlinx.coroutines.flow.internal.c r16 = r13[r15];
        if (r16 == null) goto L34;
        long r17 = ((l1) r16).f10502a;
        if (r17 < 0) goto L34;
        if (r17 >= r12) goto L34;
        r12 = r17;
    L34:
        r15 = r15 + 1;
    L36:
        if (kotlinx.coroutines.n0.a() == false) goto L46;
        if (r12 < this.f10446o) goto L40;
        boolean r18 = true;
    L41:
        if (r18 == true) goto L46;
        throw new AssertionError();
    L40:
        r18 = false;
    L46:
        if (r12 <= this.f10446o) goto L48;
        long r19 = J();
        if (l() <= 0) goto L52;
        int r21 = (int) (r19 - r12);
        int r22 = Math.min(this.f10448q, this.f10442k - r21);
    L53:
        Continuation<Unit>[] r110 = kotlinx.coroutines.flow.internal.b.f10489a;
        long r111 = ((long) this.f10448q) + r19;
        if (r22 <= 0) goto L67;
        r110 = new Continuation[r22];
        Object[] r112 = this.f10444m;
        Intrinsics.checkNotNull(r112);
        long r113 = r19;
        int r114 = 0;
    L57:
        if (r19 >= r111) goto L65;
        Object r23 = k1.c(r112, r19);
        kotlinx.coroutines.internal.i0 r24 = k1.f10501a;
        long r115 = r12;
        if (r23 == r24) goto L63;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        a r25 = (a) r23;
        int r26 = r114 + 1;
        r110[r114] = r25.f10452i;
        k1.d(r112, r19, r24);
        k1.d(r112, r113, r25.f10451h);
        long r27 = 1;
        r113 = r113 + 1;
        if (r26 >= r22) goto L66;
        r114 = r26;
    L64:
        r19 = r19 + r27;
        r12 = r115;
    L66:
        r19 = r113;
    L68:
        int r28 = (int) (r19 - r11);
        if (l() != 0) goto L71;
        long r29 = r19;
    L72:
        long r30 = Math.max(this.f10445n, r19 - ((long) Math.min(this.f10441j, r28)));
        if (this.f10442k == 0) goto L75;
    L79:
        V(r30, r29, r19, r111);
        z();
        if (r110.length != 0) goto L82;
        boolean r116 = true;
    L84:
        if ((true ^ r116) == true) goto L86;
        return r110;
    L86:
        return I(r110);
    L82:
        r116 = false;
        goto L84
    L75:
        if (r30 >= r111) goto L79;
        Object[] r31 = this.f10444m;
        Intrinsics.checkNotNull(r31);
        if (Intrinsics.areEqual(k1.c(r31, r30), k1.f10501a) == false) goto L79;
        r19 = r19 + 1;
        r30 = r30 + 1;
        goto L79
    L71:
        r29 = r115;
        goto L72
    L63:
        r27 = 1;
        goto L64
    L65:
        r115 = r12;
        goto L66
    L67:
        r115 = r12;
        goto L68
    L52:
        r22 = this.f10448q;
        goto L53
    L48:
        return kotlinx.coroutines.flow.internal.b.f10489a;
    L15:
        return kotlinx.coroutines.flow.internal.b.f10489a;
    }

    public final long X() {
        long r10 = this.f10445n;
        if (r10 >= this.f10446o) goto L5;
        this.f10446o = r10;
    L5:
        return r10;
    }

    @Override // kotlinx.coroutines.flow.j1, kotlinx.coroutines.flow.c
    public Object a(d<? super T> r10, Continuation<?> r11) {
        return A(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.f1
    public void b() {
        monitor-enter(this);
        V(J(), this.f10446o, J(), N());     // Catch: Throwable -> L6
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.f1
    public boolean c(T r10) {
        Continuation<Unit>[] r11 = kotlinx.coroutines.flow.internal.b.f10489a;
        monitor-enter(this);
        int r12 = 0;
        if (R(r10) == false) goto L8;
        r11 = I(r11);     // Catch: Throwable -> L17
        boolean r13 = true;
    L9:
        monitor-exit(this);
        int r14 = r11.length;
    L11:
        if (r12 >= r14) goto L16;
        Continuation<Unit> r15 = r11[r12];
        if (r15 == null) goto L15;
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    L15:
        r12 = r12 + 1;
        goto L11
    L16:
        return r13;
    L8:
        r13 = false;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public c<T> e(CoroutineContext r10, int r11, BufferOverflow r12) {
        return k1.e(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.f1, kotlinx.coroutines.flow.d
    public Object emit(T r10, Continuation<? super Unit> r11) {
        return F(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c i() {
        return C();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    public /* bridge */ /* synthetic */ kotlinx.coroutines.flow.internal.c[] j(int r10) {
        return D(r10);
    }
}
