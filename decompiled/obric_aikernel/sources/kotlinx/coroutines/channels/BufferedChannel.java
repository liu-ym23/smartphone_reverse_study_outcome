package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.c3;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.internal.i0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3055:1\n273#1,6:3058\n280#1,68:3065\n374#1,18:3156\n244#1:3174\n269#1,10:3175\n280#1,48:3186\n395#1:3234\n334#1,14:3235\n399#1,3:3250\n244#1:3263\n269#1,10:3264\n280#1,68:3275\n244#1:3353\n269#1,10:3354\n280#1,68:3365\n244#1:3437\n269#1,10:3438\n280#1,68:3449\n886#1,52:3519\n964#1,8:3575\n858#1:3583\n882#1,33:3584\n974#1:3617\n916#1,14:3618\n935#1,3:3633\n979#1,6:3636\n886#1,52:3650\n964#1,8:3706\n858#1:3714\n882#1,33:3715\n974#1:3748\n916#1,14:3749\n935#1,3:3764\n979#1,6:3767\n858#1:3782\n882#1,48:3783\n935#1,3:3832\n858#1:3835\n882#1,48:3836\n935#1,3:3885\n244#1:3897\n269#1,10:3898\n280#1,68:3909\n858#1:3978\n882#1,48:3979\n935#1,3:4028\n1#2:3056\n3038#3:3057\n3038#3:3064\n3038#3:3185\n3038#3:3274\n3038#3:3364\n3038#3:3436\n3038#3:3448\n3038#3:3518\n3038#3:3781\n3038#3:3888\n3038#3:3889\n3052#3:3890\n3052#3:3891\n3051#3:3892\n3051#3:3893\n3051#3:3894\n3052#3:3895\n3051#3:3896\n3038#3:3908\n3039#3:4031\n3038#3:4032\n3038#3:4033\n3038#3:4034\n3039#3:4035\n3038#3:4036\n3039#3:4059\n3038#3:4060\n3038#3:4061\n3039#3:4062\n3038#3:4112\n3039#3:4113\n3039#3:4114\n3039#3:4132\n3039#3:4133\n314#4,9:3133\n323#4,2:3150\n332#4,4:3152\n336#4,8:3253\n314#4,9:3344\n323#4,2:3434\n332#4,4:3571\n336#4,8:3642\n332#4,4:3702\n336#4,8:3773\n220#5:3142\n221#5:3145\n220#5:3146\n221#5:3149\n61#6,2:3143\n61#6,2:3147\n61#6,2:3261\n269#7:3249\n269#7:3343\n269#7:3433\n269#7:3517\n269#7:3977\n882#8:3632\n882#8:3763\n882#8:3831\n882#8:3884\n882#8:4027\n37#9,11:4037\n37#9,11:4048\n72#10,3:4063\n46#10,8:4066\n72#10,3:4074\n46#10,8:4077\n46#10,8:4085\n72#10,3:4093\n46#10,8:4096\n46#10,8:4104\n766#11:4115\n857#11,2:4116\n2310#11,14:4118\n766#11:4134\n857#11,2:4135\n2310#11,14:4137\n766#11:4151\n857#11,2:4152\n2310#11,14:4154\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n113#1:3058,6\n113#1:3065,68\n154#1:3156,18\n154#1:3174\n154#1:3175,10\n154#1:3186,48\n154#1:3234\n154#1:3235,14\n154#1:3250,3\n194#1:3263\n194#1:3264,10\n194#1:3275,68\n225#1:3353\n225#1:3354,10\n225#1:3365,68\n391#1:3437\n391#1:3438,10\n391#1:3449,68\n667#1:3519,52\n696#1:3575,8\n696#1:3583\n696#1:3584,33\n696#1:3617\n696#1:3618,14\n696#1:3633,3\n696#1:3636,6\n732#1:3650,52\n748#1:3706,8\n748#1:3714\n748#1:3715,33\n748#1:3748\n748#1:3749,14\n748#1:3764,3\n748#1:3767,6\n781#1:3782\n781#1:3783,48\n781#1:3832,3\n971#1:3835\n971#1:3836,48\n971#1:3885,3\n1464#1:3897\n1464#1:3898,10\n1464#1:3909,68\n1512#1:3978\n1512#1:3979,48\n1512#1:4028,3\n70#1:3057\n113#1:3064\n154#1:3185\n194#1:3274\n225#1:3364\n278#1:3436\n391#1:3448\n606#1:3518\n771#1:3781\n1007#1:3888\n1056#1:3889\n1374#1:3890\n1376#1:3891\n1406#1:3892\n1416#1:3893\n1425#1:3894\n1426#1:3895\n1433#1:3896\n1464#1:3908\n1865#1:4031\n1867#1:4032\n1869#1:4033\n1882#1:4034\n1893#1:4035\n1894#1:4036\n2196#1:4059\n2209#1:4060\n2219#1:4061\n2222#1:4062\n2539#1:4112\n2541#1:4113\n2566#1:4114\n2628#1:4132\n2629#1:4133\n134#1:3133,9\n134#1:3150,2\n153#1:3152,4\n153#1:3253,8\n221#1:3344,9\n221#1:3434,2\n695#1:3571,4\n695#1:3642,8\n746#1:3702,4\n746#1:3773,8\n138#1:3142\n138#1:3145\n141#1:3146\n141#1:3149\n138#1:3143,2\n141#1:3147,2\n183#1:3261,2\n154#1:3249\n194#1:3343\n225#1:3433\n391#1:3517\n1464#1:3977\n696#1:3632\n748#1:3763\n781#1:3831\n971#1:3884\n1512#1:4027\n2098#1:4037,11\n2153#1:4048,11\n2361#1:4063,3\n2361#1:4066,8\n2416#1:4074,3\n2416#1:4077,8\n2435#1:4085,8\n2465#1:4093,3\n2465#1:4096,8\n2526#1:4104,8\n2575#1:4115\n2575#1:4116,2\n2576#1:4118,14\n2640#1:4134\n2640#1:4135,2\n2641#1:4137,14\n2681#1:4151\n2681#1:4152,2\n2682#1:4154,14\n*E\n"})
public class BufferedChannel<E> implements d<E> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10275i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10276j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10277k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f10278l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10279m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10280n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10281o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10282p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f10283q = null;

    @Volatile
    private volatile Object _closeCause;

    @Volatile
    private volatile long bufferEnd;

    @Volatile
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10284c;

    @Volatile
    private volatile Object closeHandler;

    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final Function1<E, Unit> f10285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function3<kotlinx.coroutines.selects.k<?>, Object, Object, Function1<Throwable, Unit>> f10286h;

    @Volatile
    private volatile Object receiveSegment;

    @Volatile
    private volatile long receivers;

    @Volatile
    private volatile Object sendSegment;

    @Volatile
    private volatile long sendersAndCloseStatus;

    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n886#2,52:3056\n964#2,8:3112\n858#2:3120\n882#2,33:3121\n974#2:3154\n916#2,14:3155\n935#2,3:3170\n979#2,6:3173\n332#3,4:3108\n336#3,8:3179\n882#4:3169\n61#5,2:3187\n61#5,2:3190\n1#6:3189\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1590#1:3056,52\n1627#1:3112,8\n1627#1:3120\n1627#1:3121,33\n1627#1:3154\n1627#1:3155,14\n1627#1:3170,3\n1627#1:3173,6\n1625#1:3108,4\n1625#1:3179,8\n1627#1:3169\n1663#1:3187,2\n1708#1:3190,2\n*E\n"})
    private final class a implements ChannelIterator<E>, c3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f10287c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private kotlinx.coroutines.o<? super Boolean> f10288g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BufferedChannel<E> f10289h;

        public a(BufferedChannel r10) {
            this.f10289h = r10;
            this.f10287c = BufferedChannelKt.m();
        }

        public static final /* synthetic */ void b(a r10) {
            r10.h();
        }

        public static final /* synthetic */ void d(a r10, kotlinx.coroutines.o r11) {
            r10.f10288g = r11;
        }

        public static final /* synthetic */ void e(a r10, Object r11) {
            r10.f10287c = r11;
        }

        private final Object f(h<E> r11, int r12, long r13, Continuation<? super Boolean> r15) {
            BufferedChannel<E> r10 = this.f10289h;
            kotlinx.coroutines.o r14 = q.b(IntrinsicsKt.intercepted(r15));
            d(this, r14);     // Catch: Throwable -> L45
            Object r16 = BufferedChannel.D(r10, r11, r12, r13, this);     // Catch: Throwable -> L45
            if (r16 != BufferedChannelKt.r()) goto L6;
            BufferedChannel.r(r10, this, r11, r12);     // Catch: Throwable -> L45
        L41:
            Object r17 = r14.B();
            if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
            DebugProbesKt.probeCoroutineSuspended(r15);
        L44:
            return r17;
        L6:
            Function1<Throwable, Unit> r18 = null;
            if (r16 == BufferedChannelKt.h()) goto L9;
            r11.b();     // Catch: Throwable -> L45
            e(this, r16);     // Catch: Throwable -> L45
            d(this, null);     // Catch: Throwable -> L45
            Boolean r19 = Boxing.boxBoolean(true);     // Catch: Throwable -> L45
            Function1<E, Unit> r110 = r10.f10285g;     // Catch: Throwable -> L45
            if (r110 != null) goto L39;
        L34:
            r14.y(r19, r18);     // Catch: Throwable -> L45
            goto L41
        L39:
            r18 = OnUndeliveredElementKt.a(r110, r16, r14.getContext());     // Catch: Throwable -> L45
            goto L34
        L9:
            if (r13 >= r10.a0()) goto L11;
            r11.b();     // Catch: Throwable -> L45
        L11:
            h r111 = (h) BufferedChannel.i().get(r10);     // Catch: Throwable -> L45
        L13:
            if (r10.h0() == true) goto L14;
            long r112 = BufferedChannel.j().getAndIncrement(r10);     // Catch: Throwable -> L45
            int r113 = BufferedChannelKt.f10293b;     // Catch: Throwable -> L45
            long r20 = r112 / ((long) r113);     // Catch: Throwable -> L45
            int r114 = (int) (r112 % ((long) r113));     // Catch: Throwable -> L45
            if (r111.f10550h == r20) goto L21;
            h r21 = BufferedChannel.a(r10, r20, r111);     // Catch: Throwable -> L45
            if (r21 == null) goto L13;
            r111 = r21;
        L21:
            Object r22 = BufferedChannel.D(r10, r111, r114, r112, this);     // Catch: Throwable -> L45
            if (r22 == BufferedChannelKt.r()) goto L23;
            if (r22 != BufferedChannelKt.h()) goto L30;
            if (r112 >= r10.a0()) goto L13;
            r111.b();     // Catch: Throwable -> L45
            goto L13
        L30:
            if (r22 == BufferedChannelKt.s()) goto L36;
            r111.b();     // Catch: Throwable -> L45
            e(this, r22);     // Catch: Throwable -> L45
            d(this, null);     // Catch: Throwable -> L45
            r19 = Boxing.boxBoolean(true);     // Catch: Throwable -> L45
            Function1<E, Unit> r115 = r10.f10285g;     // Catch: Throwable -> L45
            if (r115 == null) goto L34;
            r18 = OnUndeliveredElementKt.a(r115, r22, r14.getContext());     // Catch: Throwable -> L45
            goto L34
        L36:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L45
        L23:
            BufferedChannel.r(r10, this, r111, r114);     // Catch: Throwable -> L45
            goto L41
        L14:
            b(this);     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            r14.S();
            throw th;
        }

        private final boolean g() {
            this.f10287c = BufferedChannelKt.z();
            Throwable r10 = this.f10289h.W();
            if (r10 != null) goto L7;
            return false;
        L7:
            throw h0.j(r10);
        }

        private final void h() {
            kotlinx.coroutines.o<? super Boolean> r10 = this.f10288g;
            Intrinsics.checkNotNull(r10);
            this.f10288g = null;
            this.f10287c = BufferedChannelKt.z();
            Throwable r11 = this.f10289h.W();
            if (r11 != null) goto L7;
            Result.Companion r12 = Result.Companion;
            Object r13 = Boolean.FALSE;
        L5:
            r10.resumeWith(Result.m32constructorimpl(r13));
            return;
        L7:
            if (n0.d() == true) goto L9;
        L12:
            Result.Companion r14 = Result.Companion;
            r13 = ResultKt.createFailure(r11);
            goto L5
        L9:
            if ((r10 instanceof CoroutineStackFrame) == false) goto L12;
            r11 = h0.a(r11, r10);
            goto L12
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation<? super Boolean> r14) {
            BufferedChannel<E> r10 = this.f10289h;
            h<E> r11 = (h) BufferedChannel.i().get(r10);
        L4:
            if (r10.h0() == true) goto L5;
            long r12 = BufferedChannel.j().getAndIncrement(r10);
            int r13 = BufferedChannelKt.f10293b;
            long r15 = r12 / ((long) r13);
            int r16 = (int) (r12 % ((long) r13));
            if (r11.f10550h == r15) goto L13;
            h<E> r17 = BufferedChannel.a(r10, r15, r11);
            if (r17 == null) goto L4;
            h<E> r18 = r17;
        L14:
            Object r19 = BufferedChannel.D(r10, r18, r16, r12, null);
            if (r19 == BufferedChannelKt.r()) goto L29;
            if (r19 != BufferedChannelKt.h()) goto L23;
            if (r12 >= r10.a0()) goto L21;
            r18.b();
        L21:
            r11 = r18;
            goto L4
        L23:
            if (r19 == BufferedChannelKt.s()) goto L25;
            r18.b();
            this.f10287c = r19;
            boolean r110 = true;
        L27:
            return Boxing.boxBoolean(r110);
        L25:
            return f(r18, r16, r12, r14);
        L29:
            throw new IllegalStateException("unreachable".toString());
        L13:
            r18 = r11;
            goto L14
        L5:
            r110 = g();
            goto L27
        }

        @Override // kotlinx.coroutines.c3
        public void c(f0<?> r10, int r11) {
            kotlinx.coroutines.o<? super Boolean> r12 = this.f10288g;
            if (r12 == null) goto L6;
            r12.c(r10, r11);
            return;
        }

        public final boolean i(E r10) {
            kotlinx.coroutines.o<? super Boolean> r11 = this.f10288g;
            Intrinsics.checkNotNull(r11);
            Function1<Throwable, Unit> r12 = null;
            this.f10288g = null;
            this.f10287c = r10;
            Boolean r13 = Boolean.TRUE;
            Function1<E, Unit> r14 = this.f10289h.f10285g;
            if (r14 == null) goto L6;
            r12 = OnUndeliveredElementKt.a(r14, r10, r11.getContext());
        L6:
            return BufferedChannelKt.u(r11, r13, r12);
        }

        public final void j() {
            kotlinx.coroutines.o<? super Boolean> r10 = this.f10288g;
            Intrinsics.checkNotNull(r10);
            this.f10288g = null;
            this.f10287c = BufferedChannelKt.z();
            Throwable r11 = this.f10289h.W();
            if (r11 != null) goto L7;
            Result.Companion r12 = Result.Companion;
            Object r13 = Boolean.FALSE;
        L5:
            r10.resumeWith(Result.m32constructorimpl(r13));
            return;
        L7:
            if (n0.d() == true) goto L9;
        L12:
            Result.Companion r14 = Result.Companion;
            r13 = ResultKt.createFailure(r11);
            goto L5
        L9:
            if ((r10 instanceof CoroutineStackFrame) == false) goto L12;
            r11 = h0.a(r11, r10);
            goto L12
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E r10 = (E) this.f10287c;
            if (r10 == BufferedChannelKt.m()) goto L5;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L13;
            this.f10287c = BufferedChannelKt.m();
            if (r10 == BufferedChannelKt.z()) goto L11;
            return r10;
        L11:
            throw h0.j(BufferedChannel.h(this.f10289h));
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r11 = false;
            goto L6
        }
    }

    private static final class b implements c3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final kotlinx.coroutines.n<Boolean> f10290c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final /* synthetic */ kotlinx.coroutines.o<Boolean> f10291g;

        /* JADX WARN: Multi-variable type inference failed */
        public b(kotlinx.coroutines.n<? super Boolean> r10) {
            this.f10290c = r10;
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f10291g = (kotlinx.coroutines.o) r10;
        }

        public final kotlinx.coroutines.n<Boolean> a() {
            return this.f10290c;
        }

        @Override // kotlinx.coroutines.c3
        public void c(f0<?> r10, int r11) {
            this.f10291g.c(r10, r11);
        }
    }

    static {
        f10275i = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");
        f10276j = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");
        f10277k = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");
        f10278l = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");
        f10279m = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");
        f10280n = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");
        f10281o = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");
        f10282p = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");
        f10283q = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.functions.Function1<? super E, kotlin.Unit>, kotlin.jvm.functions.Function1<E, kotlin.Unit>] */
    public BufferedChannel(int r10, Function1<? super E, Unit> r11) {
        this.f10284c = r10;
        this.f10285g = r11;
        if (r10 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L17;
        this.bufferEnd = BufferedChannelKt.t(r10);
        this.completedExpandBuffersAndPauseFlag = V();
        h r13 = new h(0, null, this, 3);
        this.sendSegment = r13;
        this.receiveSegment = r13;
        if (l0() == false) goto L10;
        r13 = BufferedChannelKt.n();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L10:
        this.bufferEndSegment = r13;
        if (r11 == 0) goto L13;
        Function3 r14 = new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this);
    L14:
        this.f10286h = r14;
        this._closeCause = BufferedChannelKt.l();
        return;
    L13:
        r14 = null;
        goto L14
    L17:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r10 + ", should be >=0").toString());
    L5:
        r12 = false;
        goto L6
    }

    public /* synthetic */ BufferedChannel(int r10, Function1 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ Object A(BufferedChannel r10, h r11, int r12, long r13, Continuation r14) {
        return r10.I0(r11, r12, r13, r14);
    }

    private final void A0(c3 r10, h<E> r11, int r12) {
        z0();
        r10.c(r11, r12);
    }

    private final void B0(c3 r10, h<E> r11, int r12) {
        r10.c(r11, r12 + BufferedChannelKt.f10293b);
    }

    public static final /* synthetic */ void C(BufferedChannel r10, kotlinx.coroutines.selects.k r11, Object r12) {
        r10.K0(r11, r12);
    }

    private final Object C0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L6;
        return r11;
    L6:
        throw X();
    }

    public static final /* synthetic */ Object D(BufferedChannel r10, h r11, int r12, long r13, Object r14) {
        return r10.a1(r11, r12, r13, r14);
    }

    private final Object D0(Object r10, Object r11) {
        if (r11 != BufferedChannelKt.z()) goto L5;
        Object r12 = g.f10318b.a(W());
    L7:
        return g.b(r12);
    L5:
        r12 = g.f10318b.c(r11);
        goto L7
    }

    private final Object E0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L5;
        return r11;
    L5:
        if (W() != null) goto L8;
        return null;
    L8:
        throw X();
    }

    public static final /* synthetic */ int F(BufferedChannel r10, h r11, int r12, Object r13, long r14, Object r15, boolean r16) {
        return r10.c1(r11, r12, r13, r14, r15, r16);
    }

    private final Object F0(Object r10, Object r11) {
        if (r11 == BufferedChannelKt.z()) goto L6;
        return this;
    L6:
        throw Z();
    }

    private final boolean G(long r10) {
        if (r10 >= V()) goto L5;
    L8:
        return true;
    L5:
        if (r10 < (Y() + ((long) this.f10284c))) goto L8;
        return false;
    }

    static /* synthetic */ <E> Object G0(BufferedChannel<E> r10, Continuation<? super E> r11) {
        h<E> r12 = (h) i().get(r10);
    L4:
        if (r10.h0() == true) goto L27;
        long r13 = j().getAndIncrement(r10);
        int r14 = BufferedChannelKt.f10293b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r12.f10550h == r15) goto L11;
        h<E> r17 = a(r10, r15, r12);
        if (r17 == null) goto L4;
        r12 = r17;
    L11:
        Object r18 = D(r10, r12, r16, r13, null);
        if (r18 == BufferedChannelKt.r()) goto L25;
        if (r18 != BufferedChannelKt.h()) goto L19;
        if (r13 >= r10.a0()) goto L4;
        r12.b();
        goto L4
    L19:
        if (r18 == BufferedChannelKt.s()) goto L21;
        r12.b();
        return r18;
    L21:
        return r10.J0(r12, r16, r13, r11);
    L25:
        throw new IllegalStateException("unexpected".toString());
    L27:
        throw h0.j(r10.X());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <E> Object H0(BufferedChannel<E> r14, Continuation<? super g<? extends E>> r15) {
        if ((r15 instanceof BufferedChannel$receiveCatching$1) == false) goto L7;
        BufferedChannel$receiveCatching$1 r10 = (BufferedChannel$receiveCatching$1) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatching$1 r12 = r10;
        Object r16 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r12.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
        return ((g) r16).k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        h<E> r18 = (h) i().get(r14);
    L16:
        if (r14.h0() == true) goto L51;
        long r19 = j().getAndIncrement(r14);
        int r20 = BufferedChannelKt.f10293b;
        long r21 = r19 / ((long) r20);
        int r22 = (int) (r19 % ((long) r20));
        if (r18.f10550h == r21) goto L24;
        h<E> r23 = a(r14, r21, r18);
        if (r23 == null) goto L16;
        h<E> r110 = r23;
    L25:
        Object r24 = D(r14, r110, r22, r19, null);
        if (r24 == BufferedChannelKt.r()) goto L41;
        if (r24 != BufferedChannelKt.h()) goto L34;
        if (r19 >= r14.a0()) goto L32;
        r110.b();
    L32:
        r18 = r110;
        goto L16
    L34:
        if (r24 != BufferedChannelKt.s()) goto L38;
        r12.label = 1;
        Object r111 = r14.I0(r110, r22, r19, r12);
        if (r111 != r13) goto L52;
        return r13;
    L52:
        return r111;
    L38:
        r110.b();
        return g.f10318b.c(r24);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        r110 = r18;
        goto L25
    L51:
        return g.f10318b.a(r14.W());
    L7:
        r10 = new BufferedChannel$receiveCatching$1(r14, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object I0(h<E> r11, int r12, long r13, Continuation<? super g<? extends E>> r15) {
        if ((r15 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r10 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r15;
        int r14 = r10.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r16 = r10.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r10.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        h r19 = (h) r10.L$1;
        BufferedChannel r110 = (BufferedChannel) r10.L$0;
        ResultKt.throwOnFailure(r16);
    L59:
        return ((g) r16).k();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r10.L$0 = this;
        r10.L$1 = r11;
        r10.I$0 = r12;
        r10.J$0 = r13;
        r10.label = 1;
        kotlinx.coroutines.o r111 = q.b(IntrinsicsKt.intercepted(r10));
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");     // Catch: Throwable -> L60
        m r20 = new m(r111);     // Catch: Throwable -> L60
        Object r21 = D(this, r11, r12, r13, r20);     // Catch: Throwable -> L60
        if (r21 != BufferedChannelKt.r()) goto L18;
        r(this, r20, r11, r12);     // Catch: Throwable -> L60
    L53:
        r16 = r111.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L56:
        if (r16 != r17) goto L59;
        return r17;
    L18:
        Function1<Throwable, Unit> r22 = null;
        if (r21 == BufferedChannelKt.h()) goto L21;
        r11.b();     // Catch: Throwable -> L60
        g r112 = g.b(g.f10318b.c(r21));     // Catch: Throwable -> L60
        Function1<E, Unit> r113 = this.f10285g;     // Catch: Throwable -> L60
        if (r113 != null) goto L51;
    L46:
        r111.y(r112, r22);     // Catch: Throwable -> L60
        goto L53
    L51:
        r22 = OnUndeliveredElementKt.a(r113, r21, r111.getContext());     // Catch: Throwable -> L60
        goto L46
    L21:
        if (r13 >= a0()) goto L23;
        r11.b();     // Catch: Throwable -> L60
    L23:
        h r114 = (h) i().get(this);     // Catch: Throwable -> L60
    L25:
        if (h0() == true) goto L26;
        long r115 = j().getAndIncrement(this);     // Catch: Throwable -> L60
        int r116 = BufferedChannelKt.f10293b;     // Catch: Throwable -> L60
        long r23 = r115 / ((long) r116);     // Catch: Throwable -> L60
        int r117 = (int) (r115 % ((long) r116));     // Catch: Throwable -> L60
        if (r114.f10550h == r23) goto L33;
        h r24 = a(this, r23, r114);     // Catch: Throwable -> L60
        if (r24 == null) goto L25;
        r114 = r24;
    L33:
        Object r25 = D(this, r114, r117, r115, r20);     // Catch: Throwable -> L60
        if (r25 == BufferedChannelKt.r()) goto L35;
        if (r25 != BufferedChannelKt.h()) goto L42;
        if (r115 >= a0()) goto L25;
        r114.b();     // Catch: Throwable -> L60
        goto L25
    L42:
        if (r25 == BufferedChannelKt.s()) goto L48;
        r114.b();     // Catch: Throwable -> L60
        r112 = g.b(g.f10318b.c(r25));     // Catch: Throwable -> L60
        Function1<E, Unit> r118 = this.f10285g;     // Catch: Throwable -> L60
        if (r118 == null) goto L46;
        r22 = OnUndeliveredElementKt.a(r118, r25, r111.getContext());     // Catch: Throwable -> L60
        goto L46
    L48:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L60
    L35:
        r(this, r20, r114, r117);     // Catch: Throwable -> L60
        goto L53
    L26:
        o(this, r111);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        r111.S();
        throw th;
    L7:
        r10 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r15);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(h<E> r10, long r11) {
        Object r12 = p.b(null, 1, null);
    L4:
        if (r10 == null) goto L30;
        int r13 = BufferedChannelKt.f10293b - 1;
    L6:
        if ((-1) >= r13) goto L29;
        if (((r10.f10550h * ((long) BufferedChannelKt.f10293b)) + ((long) r13)) < r11) goto L30;
    L9:
        Object r14 = r10.w(r13);
        if (r14 == null) goto L26;
        if (r14 == BufferedChannelKt.k()) goto L26;
        if ((r14 instanceof o) == true) goto L17;
        if ((r14 instanceof c3) == false) goto L28;
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
    L19:
        r12 = p.c(r12, r14);
        r10.x(r13, true);
    L28:
        r13 = r13 - 1;
        goto L6
    L17:
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
        r14 = ((o) r14).f10327a;
    L26:
        if (r10.r(r13, r14, BufferedChannelKt.z()) == false) goto L9;
        r10.p();
        goto L28
    L29:
        r10 = (h) r10.g();
    L30:
        if (r12 != null) goto L32;
        return;
    L32:
        if ((r12 instanceof ArrayList) == true) goto L34;
        N0((c3) r12);
        return;
    L34:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r15 = (ArrayList) r12;
        int r16 = r15.size() - 1;
    L35:
        if ((-1) >= r16) goto L58;
        N0((c3) r15.get(r16));
        r16 = r16 - 1;
        goto L35
    }

    private final Object J0(h<E> r10, int r11, long r12, Continuation<? super E> r13) {
        kotlinx.coroutines.o r14 = q.b(IntrinsicsKt.intercepted(r13));
        Object r15 = D(this, r10, r11, r12, r14);     // Catch: Throwable -> L49
        if (r15 != BufferedChannelKt.r()) goto L6;
        r(this, r14, r10, r11);     // Catch: Throwable -> L49
    L45:
        Object r16 = r14.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L48:
        return r16;
    L6:
        Function1<Throwable, Unit> r17 = null;
        r17 = null;
        kotlinx.coroutines.o r18 = null;
        if (r15 == BufferedChannelKt.h()) goto L9;
        r10.b();     // Catch: Throwable -> L49
        Function1<E, Unit> r19 = this.f10285g;     // Catch: Throwable -> L49
        if (r19 != null) goto L43;
    L38:
        r14.y(r15, r17);     // Catch: Throwable -> L49
        goto L45
    L43:
        r17 = OnUndeliveredElementKt.a(r19, r15, r14.getContext());     // Catch: Throwable -> L49
        goto L38
    L9:
        if (r12 >= a0()) goto L11;
        r10.b();     // Catch: Throwable -> L49
    L11:
        h r20 = (h) i().get(this);     // Catch: Throwable -> L49
    L13:
        if (h0() == true) goto L14;
        long r110 = j().getAndIncrement(this);     // Catch: Throwable -> L49
        int r111 = BufferedChannelKt.f10293b;     // Catch: Throwable -> L49
        long r21 = r110 / ((long) r111);     // Catch: Throwable -> L49
        int r112 = (int) (r110 % ((long) r111));     // Catch: Throwable -> L49
        if (r20.f10550h == r21) goto L21;
        h r22 = a(this, r21, r20);     // Catch: Throwable -> L49
        if (r22 == null) goto L13;
        r20 = r22;
    L21:
        r15 = D(this, r20, r112, r110, r14);     // Catch: Throwable -> L49
        if (r15 == BufferedChannelKt.r()) goto L24;
        if (r15 != BufferedChannelKt.h()) goto L34;
        if (r110 >= a0()) goto L13;
        r20.b();     // Catch: Throwable -> L49
        goto L13
    L34:
        if (r15 == BufferedChannelKt.s()) goto L40;
        r20.b();     // Catch: Throwable -> L49
        Function1<E, Unit> r23 = this.f10285g;     // Catch: Throwable -> L49
        if (r23 == null) goto L38;
        r17 = OnUndeliveredElementKt.a(r23, r15, r14.getContext());     // Catch: Throwable -> L49
        goto L38
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L49
    L24:
        if ((r14 instanceof c3) == false) goto L26;
        r18 = r14;
    L26:
        if (r18 == null) goto L45;
        r(this, r18, r20, r112);     // Catch: Throwable -> L49
        goto L45
    L14:
        p(this, r14);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r14.S();
        throw th;
    }

    private final h<E> K() {
        Object r10 = f10281o.get(this);
        h r11 = (h) f10279m.get(this);
        if (r11.f10550h <= ((h) r10).f10550h) goto L5;
        r10 = r11;
    L5:
        h r12 = (h) f10280n.get(this);
        if (r12.f10550h <= ((h) r10).f10550h) goto L9;
        r10 = r12;
    L9:
        return (h) kotlinx.coroutines.internal.e.b((kotlinx.coroutines.internal.f) r10);
    }

    private final void K0(kotlinx.coroutines.selects.k<?> r10, Object r11) {
        h r12 = (h) i().get(this);
    L4:
        if (h0() == true) goto L5;
        long r13 = j().getAndIncrement(this);
        int r14 = BufferedChannelKt.f10293b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r12.f10550h == r15) goto L12;
        h r17 = a(this, r15, r12);
        if (r17 == null) goto L4;
        r12 = r17;
    L12:
        Object r18 = D(this, r12, r16, r13, r10);
        if (r18 == BufferedChannelKt.r()) goto L15;
        if (r18 != BufferedChannelKt.h()) goto L26;
        if (r13 >= a0()) goto L4;
        r12.b();
        goto L4
    L26:
        if (r18 == BufferedChannelKt.s()) goto L30;
        r12.b();
        r10.f(r18);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if ((r10 instanceof c3) == false) goto L17;
        c3 r19 = (c3) r10;
    L18:
        if (r19 == null) goto L42;
        r(this, r19, r12, r16);
        return;
    L42:
        return;
    L17:
        r19 = null;
        goto L18
    L5:
        u0(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M0(h<E> r12) {
        Function1<E, Unit> r10 = this.f10285g;
        UndeliveredElementException r11 = null;
        Object r13 = p.b(null, 1, null);
    L3:
        int r14 = BufferedChannelKt.f10293b - 1;
    L5:
        if ((-1) >= r14) goto L51;
        long r15 = (r12.f10550h * ((long) BufferedChannelKt.f10293b)) + ((long) r14);
    L7:
        Object r16 = r12.w(r14);
        if (r16 == BufferedChannelKt.f()) goto L53;
        if (r16 == BufferedChannelKt.f10295d) goto L12;
        if (r16 == BufferedChannelKt.k()) goto L48;
        if (r16 == null) goto L48;
        if ((r16 instanceof c3) == true) goto L37;
        if ((r16 instanceof o) == true) goto L37;
        if (r16 == BufferedChannelKt.p()) goto L53;
        if (r16 == BufferedChannelKt.q()) goto L53;
        if (r16 == BufferedChannelKt.p()) goto L7;
    L50:
        r14 = r14 - 1;
    L37:
        if (r15 < Y()) goto L53;
        if ((r16 instanceof o) == false) goto L41;
        c3 r17 = ((o) r16).f10327a;
    L43:
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
        if (r10 == null) goto L46;
        r11 = OnUndeliveredElementKt.c(r10, r12.v(r14), r11);
    L46:
        r13 = p.c(r13, r17);
    L17:
        r12.s(r14);
    L18:
        r12.p();
        goto L50
    L41:
        r17 = (c3) r16;
    L48:
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
    L12:
        if (r15 < Y()) goto L53;
        if (r12.r(r14, r16, BufferedChannelKt.z()) == false) goto L7;
        if (r10 == null) goto L17;
        r11 = OnUndeliveredElementKt.c(r10, r12.v(r14), r11);
    L53:
        if (r13 != null) goto L55;
    L60:
        if (r11 != null) goto L62;
        return;
    L62:
        throw r11;
    L55:
        if ((r13 instanceof ArrayList) == true) goto L57;
        O0((c3) r13);
        goto L60
    L57:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r18 = (ArrayList) r13;
        int r19 = r18.size() - 1;
    L58:
        if ((-1) >= r19) goto L60;
        O0((c3) r18.get(r19));
        r19 = r19 - 1;
        goto L58
    L51:
        r12 = (h) r12.g();
        if (r12 != null) goto L3;
        goto L53
    }

    private final void N(long r10) {
        M0(O(r10));
    }

    private final void N0(c3 r10) {
        P0(r10, true);
    }

    private final h<E> O(long r10) {
        h<E> r11 = K();
        if (k0() == false) goto L7;
        long r12 = m0(r11);
        if (r12 == (-1)) goto L7;
        Q(r12);
    L7:
        J(r11, r10);
        return r11;
    }

    private final void O0(c3 r10) {
        P0(r10, false);
    }

    private final void P() {
        L();
    }

    private final void P0(c3 r10, boolean r11) {
        if ((r10 instanceof b) == false) goto L6;
        kotlinx.coroutines.n<Boolean> r12 = ((b) r10).a();
        Result.Companion r13 = Result.Companion;
        r12.resumeWith(Result.m32constructorimpl(Boolean.FALSE));
        return;
    L6:
        if ((r10 instanceof kotlinx.coroutines.n) == false) goto L13;
        Continuation r14 = (Continuation) r10;
        Result.Companion r15 = Result.Companion;
        if (r11 == false) goto L10;
        Throwable r16 = X();
    L11:
        Object r17 = ResultKt.createFailure(r16);
    L15:
        r14.resumeWith(Result.m32constructorimpl(r17));
        return;
    L10:
        r16 = Z();
        goto L11
    L13:
        if ((r10 instanceof m) == false) goto L17;
        r14 = ((m) r10).f10326c;
        Result.Companion r18 = Result.Companion;
        r17 = g.b(g.f10318b.a(W()));
        goto L15
    L17:
        if ((r10 instanceof a) == false) goto L20;
        ((a) r10).j();
        return;
    L20:
        if ((r10 instanceof kotlinx.coroutines.selects.k) == false) goto L24;
        ((kotlinx.coroutines.selects.k) r10).d(this, BufferedChannelKt.z());
        return;
    L24:
        throw new IllegalStateException(("Unexpected waiter: " + r10).toString());
    }

    static /* synthetic */ <E> Object Q0(BufferedChannel<E> r13, E r14, Continuation<? super Unit> r15) {
        h<E> r10 = (h) k().get(r13);
    L3:
        long r11 = l().getAndIncrement(r13);
        long r12 = 1152921504606846975L & r11;
        boolean r16 = m(r13, r11);
        int r17 = BufferedChannelKt.f10293b;
        long r18 = r12 / ((long) r17);
        int r19 = (int) (r12 % ((long) r17));
        if (r10.f10550h == r18) goto L12;
        h<E> r20 = f(r13, r18, r10);
        if (r20 == null) goto L7;
        r10 = r20;
        goto L12
    L7:
        if (r16 == false) goto L3;
        Object r110 = r13.w0(r14, r15);
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        return r110;
    L46:
        return Unit.INSTANCE;
    L12:
        int r21 = F(r13, r10, r19, r14, r12, null, r16);
        if (r21 == 0) goto L44;
        if (r21 == 1) goto L46;
        if (r21 == 2) goto L35;
        if (r21 == 3) goto L32;
        if (r21 == 4) goto L27;
        if (r21 != 5) goto L3;
        r10.b();
        goto L3
    L27:
        if (r12 >= r13.Y()) goto L29;
        r10.b();
    L29:
        Object r111 = r13.w0(r14, r15);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        return r111;
    L32:
        Object r112 = r13.T0(r10, r19, r14, r12, r15);
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        return r112;
    L35:
        if (r16 == false) goto L40;
        r10.p();
        Object r113 = r13.w0(r14, r15);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        return r113;
    L40:
        if (n0.a() == false) goto L46;
        throw new AssertionError();
    L44:
        r10.b();
        goto L46
    }

    private final void R() {
        if (l0() == false) goto L5;
        return;
    L5:
        h<E> r10 = (h) f10281o.get(this);
    L6:
        long r11 = f10277k.getAndIncrement(this);
        int r12 = BufferedChannelKt.f10293b;
        long r13 = r11 / ((long) r12);
        long r14 = a0();
        long r15 = r10.f10550h;
        if (r14 <= r11) goto L9;
        if (r15 == r13) goto L21;
        h<E> r16 = S(r13, r10, r11);
        if (r16 == null) goto L6;
        r10 = r16;
    L21:
        boolean r17 = Y0(r10, (int) (r11 % ((long) r12)), r11);
        d0(this, 0, 1, null);
        if (r17 == false) goto L6;
        return;
    L9:
        if (r15 < r13) goto L11;
    L13:
        d0(this, 0, 1, null);
        return;
    L11:
        if (r10.e() == 0) goto L13;
        q0(r13, r10);
        goto L13
    }

    private final h<E> S(long r16, h<E> r18, long r19) {
        AtomicReferenceFieldUpdater r10 = f10281o;
        Function2 r11 = (Function2) BufferedChannelKt.y();
    L3:
        Object r12 = kotlinx.coroutines.internal.e.c(r18, r16, r11);
        boolean r13 = false;
        if (g0.c(r12) == true) goto L23;
        f0 r14 = g0.b(r12);
    L6:
        f0 r15 = (f0) r10.get(this);
        if (r15.f10550h >= r14.f10550h) goto L8;
        if (r14.q() == false) goto L11;
        if (r10.compareAndSet(this, r15, r14) == true) goto L15;
        if (r14.m() == false) goto L6;
        r14.k();
        goto L6
    L15:
        if (r15.m() == false) goto L8;
        r15.k();
        goto L8
    L11:
        boolean r17 = false;
    L17:
        if (r17 == false) goto L3;
    L8:
        r17 = true;
    L23:
        if (g0.c(r12) == false) goto L26;
        P();
        q0(r16, r18);
    L25:
        d0(this, 0, 1, null);
        return null;
    L26:
        h<E> r110 = (h) g0.b(r12);
        long r20 = r110.f10550h;
        if (r20 <= r16) goto L32;
        int r21 = BufferedChannelKt.f10293b;
        if (f10277k.compareAndSet(this, r19 + 1, ((long) r21) * r20) == false) goto L25;
        c0((r110.f10550h * ((long) r21)) - r19);
        return null;
    L32:
        if (n0.a() == false) goto L41;
        if (r110.f10550h != r16) goto L36;
        r13 = true;
    L36:
        if (r13 == true) goto L41;
        throw new AssertionError();
    L41:
        return r110;
    }

    static /* synthetic */ <E> Object S0(BufferedChannel<E> r18, E r19, Continuation<? super Boolean> r20) {
        kotlinx.coroutines.o r10 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r20), 1);
        r10.F();
        if (r18.f10285g != null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L47;
        b r12 = new b(r10);
        h r13 = (h) k().get(r18);
    L8:
        long r14 = l().getAndIncrement(r18);
        long r15 = r14 & 1152921504606846975L;
        boolean r16 = m(r18, r14);
        int r17 = BufferedChannelKt.f10293b;
        long r21 = r15 / ((long) r17);
        int r22 = (int) (r15 % ((long) r17));
        if (r13.f10550h == r21) goto L15;
        h r23 = f(r18, r21, r13);
        if (r23 == null) goto L12;
        h r24 = r23;
    L16:
        h r110 = r24;
        int r25 = F(r18, r24, r22, r19, r15, r12, r16);
        if (r25 == 0) goto L39;
        if (r25 == 1) goto L40;
        if (r25 == 2) goto L35;
        if (r25 == 3) goto L34;
        if (r25 == 4) goto L31;
        if (r25 != 5) goto L29;
        r110.b();
    L29:
        r13 = r110;
        goto L8
    L31:
        if (r15 >= r18.Y()) goto L37;
        r110.b();
    L37:
        Result.Companion r26 = Result.Companion;
        Boolean r27 = Boxing.boxBoolean(false);
    L41:
        r10.resumeWith(Result.m32constructorimpl(r27));
    L42:
        Object r28 = r10.B();
        if (r28 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L45;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L45:
        return r28;
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r16 == false) goto L38;
        r110.p();
        goto L37
    L38:
        s(r18, r12, r110, r22);
    L40:
        Result.Companion r29 = Result.Companion;
        r27 = Boxing.boxBoolean(true);
        goto L41
    L39:
        r110.b();
        goto L40
    L12:
        if (r16 == false) goto L8;
    L15:
        r24 = r13;
        goto L16
    L47:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    L5:
        r11 = false;
        goto L6
    }

    private final h<E> T(long r12, h<E> r14) {
        AtomicReferenceFieldUpdater r10 = f10280n;
        Function2 r11 = (Function2) BufferedChannelKt.y();
    L3:
        Object r13 = kotlinx.coroutines.internal.e.c(r14, r12, r11);
        boolean r15 = false;
        if (g0.c(r13) == true) goto L23;
        f0 r16 = g0.b(r13);
    L6:
        f0 r17 = (f0) r10.get(this);
        if (r17.f10550h >= r16.f10550h) goto L8;
        if (r16.q() == false) goto L11;
        if (r10.compareAndSet(this, r17, r16) == true) goto L15;
        if (r16.m() == false) goto L6;
        r16.k();
        goto L6
    L15:
        if (r17.m() == false) goto L8;
        r17.k();
        goto L8
    L11:
        boolean r18 = false;
    L17:
        if (r18 == false) goto L3;
    L8:
        r18 = true;
    L23:
        if (g0.c(r13) == false) goto L27;
        P();
        if ((r14.f10550h * ((long) BufferedChannelKt.f10293b)) >= a0()) goto L79;
    L26:
        r14.b();
        return null;
    L79:
        return null;
    L27:
        r14 = (h) g0.b(r13);
        if (l0() == false) goto L30;
    L44:
        long r19 = r14.f10550h;
        if (r19 <= r12) goto L50;
        int r110 = BufferedChannelKt.f10293b;
        e1(r19 * ((long) r110));
        if ((r14.f10550h * ((long) r110)) < a0()) goto L26;
        return null;
    L50:
        if (n0.a() == false) goto L59;
        if (r14.f10550h != r12) goto L54;
        r15 = true;
    L54:
        if (r15 == true) goto L59;
        throw new AssertionError();
    L59:
        return r14;
    L30:
        if (r12 > (V() / ((long) BufferedChannelKt.f10293b))) goto L44;
        AtomicReferenceFieldUpdater r20 = f10281o;
    L32:
        f0 r21 = (f0) r20.get(this);
        if (r21.f10550h >= r14.f10550h) goto L44;
        if (r14.q() == false) goto L44;
        if (r20.compareAndSet(this, r21, r14) == true) goto L39;
        if (r14.m() == false) goto L32;
        r14.k();
        goto L32
    L39:
        if (r21.m() == false) goto L44;
        r21.k();
        goto L44
    }

    private final Object T0(h<E> r21, int r22, E r23, long r24, Continuation<? super Unit> r26) {
        kotlinx.coroutines.o r10 = q.b(IntrinsicsKt.intercepted(r26));
        int r11 = F(this, r21, r22, r23, r24, r10, false);     // Catch: Throwable -> L66
        if (r11 != 0) goto L6;
        r21.b();     // Catch: Throwable -> L66
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L66
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L47:
        r10.resumeWith(r13);     // Catch: Throwable -> L66
    L58:
        Object r14 = r10.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        DebugProbesKt.probeCoroutineSuspended(r26);
    L62:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        return r14;
    L65:
        return Unit.INSTANCE;
    L6:
        if (r11 != 1) goto L8;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L66
        r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
        goto L47
    L8:
        if (r11 != 2) goto L10;
        s(this, r10, r21, r22);     // Catch: Throwable -> L66
        goto L58
    L10:
        if (r11 == 4) goto L52;
        if (r11 != 5) goto L50;
        r21.b();     // Catch: Throwable -> L66
        h r16 = (h) k().get(this);     // Catch: Throwable -> L66
    L14:
        long r17 = l().getAndIncrement(this);     // Catch: Throwable -> L66
        long r18 = r17 & 1152921504606846975L;     // Catch: Throwable -> L66
        boolean r19 = m(this, r17);     // Catch: Throwable -> L66
        int r20 = BufferedChannelKt.f10293b;     // Catch: Throwable -> L66
        long r25 = r18 / ((long) r20);     // Catch: Throwable -> L66
        int r27 = (int) (r18 % ((long) r20));     // Catch: Throwable -> L66
        if (r16.f10550h == r25) goto L21;
        h r28 = f(this, r25, r16);     // Catch: Throwable -> L66
        if (r28 == null) goto L18;
        h r29 = r28;
    L22:
        h r210 = r29;
        int r30 = F(this, r29, r27, r23, r18, r10, r19);     // Catch: Throwable -> L66
        if (r30 == 0) goto L48;
        if (r30 == 1) goto L46;
        if (r30 == 2) goto L38;
        if (r30 == 3) goto L37;
        if (r30 == 4) goto L34;
        if (r30 != 5) goto L32;
        r210.b();     // Catch: Throwable -> L66
    L32:
        r16 = r210;
        goto L14
    L34:
        if (r18 < Y()) goto L35;
    L19:
        q(this, r23, r10);     // Catch: Throwable -> L66
        goto L58
    L35:
        r210.b();     // Catch: Throwable -> L66
        goto L19
    L37:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L66
    L38:
        if (r19 == false) goto L41;
        r210.p();     // Catch: Throwable -> L66
        goto L19
    L41:
        if ((r10 instanceof c3) == false) goto L43;
        kotlinx.coroutines.o r31 = r10;
    L44:
        if (r31 == null) goto L58;
        s(this, r31, r210, r27);     // Catch: Throwable -> L66
        goto L58
    L43:
        r31 = null;
        goto L44
    L46:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L66
        r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
        goto L47
    L48:
        r210.b();     // Catch: Throwable -> L66
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L66
        r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
        goto L47
    L18:
        if (r19 == false) goto L14;
    L21:
        r29 = r16;
        goto L22
    L50:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L66
    L52:
        if (r24 >= Y()) goto L19;
        r21.b();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        r10.S();
        throw th;
    }

    private final h<E> U(long r12, h<E> r14) {
        AtomicReferenceFieldUpdater r10 = f10279m;
        Function2 r11 = (Function2) BufferedChannelKt.y();
    L3:
        Object r13 = kotlinx.coroutines.internal.e.c(r14, r12, r11);
        boolean r15 = false;
        if (g0.c(r13) == true) goto L23;
        f0 r16 = g0.b(r13);
    L6:
        f0 r17 = (f0) r10.get(this);
        if (r17.f10550h >= r16.f10550h) goto L8;
        if (r16.q() == false) goto L11;
        if (r10.compareAndSet(this, r17, r16) == true) goto L15;
        if (r16.m() == false) goto L6;
        r16.k();
        goto L6
    L15:
        if (r17.m() == false) goto L8;
        r17.k();
        goto L8
    L11:
        boolean r18 = false;
    L17:
        if (r18 == false) goto L3;
    L8:
        r18 = true;
    L23:
        if (g0.c(r13) == false) goto L27;
        P();
        if ((r14.f10550h * ((long) BufferedChannelKt.f10293b)) >= Y()) goto L55;
    L26:
        r14.b();
        return null;
    L55:
        return null;
    L27:
        r14 = (h) g0.b(r13);
        long r19 = r14.f10550h;
        if (r19 <= r12) goto L33;
        int r110 = BufferedChannelKt.f10293b;
        f1(r19 * ((long) r110));
        if ((r14.f10550h * ((long) r110)) < Y()) goto L26;
        return null;
    L33:
        if (n0.a() == false) goto L42;
        if (r14.f10550h != r12) goto L37;
        r15 = true;
    L37:
        if (r15 == true) goto L42;
        throw new AssertionError();
    L42:
        return r14;
    }

    private final boolean U0(long r10) {
        if (j0(r10) == false) goto L7;
        return false;
    L7:
        return !G(r10 & 1152921504606846975L);
    }

    private final long V() {
        return f10277k.get(this);
    }

    private final boolean W0(Object r10, E r11) {
        if ((r10 instanceof kotlinx.coroutines.selects.k) == true) goto L23;
        Function1<Throwable, Unit> r12 = null;
        if ((r10 instanceof m) == false) goto L12;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        m r13 = (m) r10;
        kotlinx.coroutines.o<g<? extends E>> r14 = r13.f10326c;
        g r15 = g.b(g.f10318b.c(r11));
        Function1<E, Unit> r16 = this.f10285g;
        if (r16 == null) goto L24;
        r12 = OnUndeliveredElementKt.a(r16, r11, r13.f10326c.getContext());
    L24:
        return BufferedChannelKt.u(r14, r15, r12);
    L12:
        if ((r10 instanceof a) == false) goto L15;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        return ((a) r10).i(r11);
    L15:
        if ((r10 instanceof kotlinx.coroutines.n) == false) goto L22;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.n r17 = (kotlinx.coroutines.n) r10;
        Function1<E, Unit> r18 = this.f10285g;
        if (r18 == null) goto L20;
        r12 = OnUndeliveredElementKt.a(r18, r11, r17.getContext());
    L20:
        return BufferedChannelKt.u(r17, r11, r12);
    L22:
        throw new IllegalStateException(("Unexpected receiver type: " + r10).toString());
    L23:
        return ((kotlinx.coroutines.selects.k) r10).d(this, r11);
    }

    private final Throwable X() {
        Throwable r10 = W();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ClosedReceiveChannelException("Channel was closed");
    }

    private final boolean X0(Object r10, h<E> r11, int r12) {
        if ((r10 instanceof kotlinx.coroutines.n) == false) goto L6;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        return BufferedChannelKt.C((kotlinx.coroutines.n) r10, Unit.INSTANCE, null, 2, null);
    L6:
        if ((r10 instanceof kotlinx.coroutines.selects.k) == false) goto L15;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult r13 = ((SelectImplementation) r10).C(this, Unit.INSTANCE);
        if (r13 != TrySelectDetailedResult.REREGISTER) goto L11;
        r11.s(r12);
    L11:
        if (r13 != TrySelectDetailedResult.SUCCESSFUL) goto L13;
        return true;
    L13:
        return false;
    L15:
        if ((r10 instanceof b) == false) goto L19;
        return BufferedChannelKt.C(((b) r10).a(), Boolean.TRUE, null, 2, null);
    L19:
        throw new IllegalStateException(("Unexpected waiter: " + r10).toString());
    }

    private final boolean Y0(h<E> r10, int r11, long r12) {
        Object r13 = r10.w(r11);
        if ((r13 instanceof c3) == false) goto L14;
        if (r12 < f10276j.get(this)) goto L14;
        if (r10.r(r11, r13, BufferedChannelKt.p()) == false) goto L14;
        if (X0(r13, r10, r11) == false) goto L11;
        r10.A(r11, BufferedChannelKt.f10295d);
        return true;
    L11:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        return false;
    L14:
        return Z0(r10, r11, r12);
    }

    private final boolean Z0(h<E> r10, int r11, long r12) {
    L2:
        Object r13 = r10.w(r11);
        if ((r13 instanceof c3) == true) goto L5;
        if (r13 == BufferedChannelKt.j()) goto L18;
        if (r13 == null) goto L21;
        if (r13 == BufferedChannelKt.f10295d) goto L25;
        if (r13 == BufferedChannelKt.o()) goto L41;
        if (r13 == BufferedChannelKt.f()) goto L41;
        if (r13 == BufferedChannelKt.i()) goto L41;
        if (r13 == BufferedChannelKt.z()) goto L35;
        if (r13 == BufferedChannelKt.q()) goto L2;
        throw new IllegalStateException(("Unexpected cell state: " + r13).toString());
    L35:
        return true;
    L41:
        return true;
    L25:
        return true;
    L21:
        if (r10.r(r11, r13, BufferedChannelKt.k()) == false) goto L2;
        return true;
    L18:
        return false;
    L5:
        if (r12 < f10276j.get(this)) goto L7;
        if (r10.r(r11, r13, BufferedChannelKt.p()) == false) goto L2;
        if (X0(r13, r10, r11) == false) goto L14;
        r10.A(r11, BufferedChannelKt.f10295d);
        return true;
    L14:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        return false;
    L7:
        if (r10.r(r11, r13, new o((c3) r13)) == false) goto L2;
        return true;
    }

    public static final /* synthetic */ h a(BufferedChannel r10, long r11, h r12) {
        return r10.T(r11, r12);
    }

    private final Object a1(h<E> r10, int r11, long r12, Object r13) {
        Object r14 = r10.w(r11);
        if (r14 != null) goto L14;
        if (r12 < (f10275i.get(this) & 1152921504606846975L)) goto L20;
        if (r13 != null) goto L10;
        return BufferedChannelKt.s();
    L10:
        if (r10.r(r11, r14, r13) == false) goto L20;
        R();
        return BufferedChannelKt.r();
    L20:
        return b1(r10, r11, r12, r13);
    L14:
        if (r14 != BufferedChannelKt.f10295d) goto L20;
        if (r10.r(r11, r14, BufferedChannelKt.f()) == false) goto L20;
        R();
        return r10.y(r11);
    }

    private final Object b1(h<E> r10, int r11, long r12, Object r13) {
    L2:
        Object r14 = r10.w(r11);
        if (r14 == null) goto L41;
        if (r14 == BufferedChannelKt.k()) goto L41;
        if (r14 == BufferedChannelKt.f10295d) goto L10;
        if (r14 == BufferedChannelKt.j()) goto L16;
        if (r14 == BufferedChannelKt.o()) goto L20;
        if (r14 == BufferedChannelKt.z()) goto L23;
        if (r14 == BufferedChannelKt.p()) goto L2;
        if (r10.r(r11, r14, BufferedChannelKt.q()) == false) goto L2;
        boolean r15 = r14 instanceof o;
        if (r15 == false) goto L33;
        r14 = ((o) r14).f10327a;
    L33:
        if (X0(r14, r10, r11) == false) goto L35;
        r10.A(r11, BufferedChannelKt.f());
        R();
        return r10.y(r11);
    L35:
        r10.A(r11, BufferedChannelKt.j());
        r10.x(r11, false);
        if (r15 == false) goto L39;
        R();
    L39:
        return BufferedChannelKt.h();
    L23:
        R();
        return BufferedChannelKt.h();
    L20:
        return BufferedChannelKt.h();
    L16:
        return BufferedChannelKt.h();
    L10:
        if (r10.r(r11, r14, BufferedChannelKt.f()) == false) goto L2;
        R();
        return r10.y(r11);
    L41:
        if (r12 < (f10275i.get(this) & 1152921504606846975L)) goto L43;
        if (r13 == null) goto L48;
        if (r10.r(r11, r14, r13) == false) goto L2;
        R();
        return BufferedChannelKt.r();
    L48:
        return BufferedChannelKt.s();
    L43:
        if (r10.r(r11, r14, BufferedChannelKt.o()) == false) goto L2;
        R();
        return BufferedChannelKt.h();
    }

    private final void c0(long r10) {
        if ((f10278l.addAndGet(this, r10) & 4611686018427387904L) == 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        return;
    L8:
        if ((f10278l.get(this) & 4611686018427387904L) == 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L8;
        return;
    L10:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L6
    }

    private final int c1(h<E> r10, int r11, E r12, long r13, Object r14, boolean r15) {
        r10.B(r11, r12);
        if (r15 == true) goto L5;
        Object r16 = r10.w(r11);
        if (r16 != null) goto L21;
        if (G(r13) == true) goto L11;
        if (r14 != null) goto L17;
        return 3;
    L17:
        if (r10.r(r11, null, r14) == false) goto L31;
        return 2;
    L31:
        return d1(r10, r11, r12, r13, r14, r15);
    L11:
        if (r10.r(r11, null, BufferedChannelKt.f10295d) == false) goto L31;
        return 1;
    L21:
        if ((r16 instanceof c3) == false) goto L31;
        r10.s(r11);
        if (W0(r16, r12) == false) goto L26;
        r10.A(r11, BufferedChannelKt.f());
        y0();
        return 0;
    L26:
        if (r10.t(r11, BufferedChannelKt.i()) == BufferedChannelKt.i()) goto L28;
        r10.x(r11, true);
    L28:
        return 5;
    L5:
        return d1(r10, r11, r12, r13, r14, r15);
    }

    static /* synthetic */ void d0(BufferedChannel r10, long r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = 1;
    L6:
        r10.c0(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final int d1(h<E> r10, int r11, E r12, long r13, Object r14, boolean r15) {
    L2:
        Object r16 = r10.w(r11);
        if (r16 == null) goto L5;
        if (r16 != BufferedChannelKt.k()) goto L28;
        if (r10.r(r11, r16, BufferedChannelKt.f10295d) == false) goto L2;
        return 1;
    L28:
        if (r16 != BufferedChannelKt.i()) goto L32;
        r10.s(r11);
        return 5;
    L32:
        if (r16 != BufferedChannelKt.o()) goto L36;
        r10.s(r11);
        return 5;
    L36:
        if (r16 != BufferedChannelKt.z()) goto L40;
        r10.s(r11);
        P();
        return 4;
    L40:
        if (n0.a() == true) goto L42;
    L52:
        r10.s(r11);
        if ((r16 instanceof o) == false) goto L56;
        r16 = ((o) r16).f10327a;
    L56:
        if (W0(r16, r12) == false) goto L59;
        r10.A(r11, BufferedChannelKt.f());
        y0();
        return 0;
    L59:
        if (r10.t(r11, BufferedChannelKt.i()) == BufferedChannelKt.i()) goto L62;
        r10.x(r11, true);
    L62:
        return 5;
    L42:
        if ((r16 instanceof c3) == false) goto L44;
    L47:
        boolean r17 = true;
    L48:
        if (r17 == true) goto L52;
        throw new AssertionError();
    L44:
        if ((r16 instanceof o) == true) goto L47;
        r17 = false;
        goto L48
    L5:
        if (G(r13) == false) goto L10;
        if (r15 == true) goto L10;
        if (r10.r(r11, null, BufferedChannelKt.f10295d) == false) goto L2;
        return 1;
    L10:
        if (r15 == true) goto L12;
        if (r14 == null) goto L16;
        if (r10.r(r11, null, r14) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r10.r(r11, null, BufferedChannelKt.j()) == false) goto L2;
        r10.x(r11, false);
        return 4;
    }

    private final void e0() {
        AtomicReferenceFieldUpdater r10 = f10283q;
    L3:
        Object r11 = r10.get(this);
        if (r11 != null) goto L6;
        i0 r12 = BufferedChannelKt.d();
    L8:
        if (r10.compareAndSet(this, r11, r12) == false) goto L3;
        if (r11 != null) goto L11;
        return;
    L11:
        Function1 r13 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r11, 1);
        ((Function1) r11).invoke(W());
        return;
    L6:
        r12 = BufferedChannelKt.e();
        goto L8
    }

    private final void e1(long r10) {
        AtomicLongFieldUpdater r11 = f10276j;
    L3:
        long r12 = r11.get(this);
        if (r12 >= r10) goto L5;
        if (f10276j.compareAndSet(this, r12, r10) == false) goto L3;
        return;
    }

    public static final /* synthetic */ h f(BufferedChannel r10, long r11, h r12) {
        return r10.U(r11, r12);
    }

    private final boolean f0(h<E> r10, int r11, long r12) {
    L2:
        Object r13 = r10.w(r11);
        if (r13 == null) goto L33;
        if (r13 == BufferedChannelKt.k()) goto L33;
        if (r13 != BufferedChannelKt.f10295d) goto L11;
        return true;
    L11:
        if (r13 != BufferedChannelKt.j()) goto L14;
        return false;
    L14:
        if (r13 != BufferedChannelKt.z()) goto L17;
        return false;
    L17:
        if (r13 != BufferedChannelKt.f()) goto L20;
        return false;
    L20:
        if (r13 != BufferedChannelKt.o()) goto L23;
        return false;
    L23:
        if (r13 != BufferedChannelKt.p()) goto L26;
        return true;
    L26:
        if (r13 != BufferedChannelKt.q()) goto L29;
        return false;
    L29:
        if (r12 == Y()) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r10.r(r11, r13, BufferedChannelKt.o()) == false) goto L2;
        R();
        return false;
    }

    private final void f1(long r10) {
        AtomicLongFieldUpdater r11 = f10275i;
    L3:
        long r12 = r11.get(this);
        long r13 = 1152921504606846975L & r12;
        if (r13 >= r10) goto L5;
        long r14 = BufferedChannelKt.b(r13, (int) (r12 >> 60));
        if (f10275i.compareAndSet(this, r12, r14) == false) goto L3;
        return;
    }

    private final boolean g0(long r10, boolean r11) {
        int r12 = (int) (r10 >> 60);
        if (r12 == 0) goto L18;
        if (r12 != 1) goto L6;
        return false;
    L6:
        if (r12 != 2) goto L8;
        O(r10 & 1152921504606846975L);
        if (r11 == true) goto L16;
    L20:
        return true;
    L16:
        if (b0() == false) goto L20;
        return false;
    L8:
        if (r12 != 3) goto L12;
        N(r10 & 1152921504606846975L);
        goto L20
    L12:
        throw new IllegalStateException(("unexpected close status: " + r12).toString());
    L18:
        return false;
    }

    public static final /* synthetic */ Throwable h(BufferedChannel r10) {
        return r10.X();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater i() {
        return f10280n;
    }

    private final boolean i0(long r10) {
        return g0(r10, true);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater j() {
        return f10276j;
    }

    private final boolean j0(long r10) {
        return g0(r10, false);
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater k() {
        return f10279m;
    }

    public static final /* synthetic */ AtomicLongFieldUpdater l() {
        return f10275i;
    }

    private final boolean l0() {
        long r10 = V();
        if (r10 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r10 == Long.MAX_VALUE) goto L8;
        return false;
    }

    public static final /* synthetic */ boolean m(BufferedChannel r10, long r11) {
        return r10.j0(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long m0(h<E> r10) {
    L2:
        int r11 = BufferedChannelKt.f10293b;
    L3:
        r11 = r11 - 1;
        if ((-1) >= r11) goto L20;
        long r12 = (r10.f10550h * ((long) BufferedChannelKt.f10293b)) + ((long) r11);
        if (r12 < Y()) goto L7;
    L8:
        Object r13 = r10.w(r11);
        if (r13 == null) goto L17;
        if (r13 == BufferedChannelKt.k()) goto L17;
        if (r13 != BufferedChannelKt.f10295d) goto L3;
        return r12;
    L17:
        if (r10.r(r11, r13, BufferedChannelKt.z()) == false) goto L8;
        r10.p();
        goto L3
    L7:
        return -1;
    L20:
        r10 = (h) r10.g();
        if (r10 != null) goto L2;
        return -1;
    }

    private final void n0() {
        AtomicLongFieldUpdater r10 = f10275i;
    L3:
        long r11 = r10.get(this);
        if (((int) (r11 >> 60)) != 0) goto L7;
        if (r10.compareAndSet(this, r11, BufferedChannelKt.b(1152921504606846975L & r11, 1)) == false) goto L3;
        return;
    }

    public static final /* synthetic */ void o(BufferedChannel r10, kotlinx.coroutines.n r11) {
        r10.s0(r11);
    }

    private final void o0() {
        AtomicLongFieldUpdater r10 = f10275i;
    L3:
        long r11 = r10.get(this);
        if (r10.compareAndSet(this, r11, BufferedChannelKt.b(1152921504606846975L & r11, 3)) == false) goto L3;
    }

    public static final /* synthetic */ void p(BufferedChannel r10, kotlinx.coroutines.n r11) {
        r10.t0(r11);
    }

    private final void p0() {
        AtomicLongFieldUpdater r10 = f10275i;
    L3:
        long r11 = r10.get(this);
        int r12 = (int) (r11 >> 60);
        if (r12 != 0) goto L6;
        long r13 = r11 & 1152921504606846975L;
        int r14 = 2;
    L11:
        if (r10.compareAndSet(this, r11, BufferedChannelKt.b(r13, r14)) == false) goto L3;
        return;
    L6:
        if (r12 != 1) goto L7;
        r13 = r11 & 1152921504606846975L;
        r14 = 3;
        goto L11
    }

    public static final /* synthetic */ void q(BufferedChannel r10, Object r11, kotlinx.coroutines.n r12) {
        r10.x0(r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q0(long r10, h<E> r11) {
    L3:
        if (r11.f10550h >= r10) goto L9;
        h<E> r12 = (h) r11.e();
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        if (r11.h() == false) goto L14;
        h<E> r13 = (h) r11.e();
        if (r13 == null) goto L14;
        r11 = r13;
    L14:
        AtomicReferenceFieldUpdater r14 = f10281o;
    L15:
        f0 r15 = (f0) r14.get(this);
        boolean r16 = true;
        if (r15.f10550h >= r11.f10550h) goto L26;
        if (r11.q() == false) goto L20;
        if (r14.compareAndSet(this, r15, r11) == true) goto L24;
        if (r11.m() == false) goto L15;
        r11.k();
        goto L15
    L24:
        if (r15.m() == false) goto L26;
        r15.k();
        goto L26
    L20:
        r16 = false;
    L26:
        if (r16 == false) goto L9;
    }

    public static final /* synthetic */ void r(BufferedChannel r10, c3 r11, h r12, int r13) {
        r10.A0(r11, r12, r13);
    }

    public static final /* synthetic */ void s(BufferedChannel r10, c3 r11, h r12, int r13) {
        r10.B0(r11, r12, r13);
    }

    private final void s0(kotlinx.coroutines.n<? super g<? extends E>> r10) {
        Result.Companion r11 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(g.b(g.f10318b.a(W()))));
    }

    private final void t0(kotlinx.coroutines.n<? super E> r10) {
        Result.Companion r11 = Result.Companion;
        r10.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(X())));
    }

    public static final /* synthetic */ Object u(BufferedChannel r10, Object r11, Object r12) {
        return r10.C0(r11, r12);
    }

    private final void u0(kotlinx.coroutines.selects.k<?> r10) {
        r10.f(BufferedChannelKt.z());
    }

    public static final /* synthetic */ Object v(BufferedChannel r10, Object r11, Object r12) {
        return r10.D0(r11, r12);
    }

    private final void v0(E r10, kotlinx.coroutines.selects.k<?> r11) {
        Function1<E, Unit> r12 = this.f10285g;
        if (r12 == null) goto L5;
        OnUndeliveredElementKt.b(r12, r10, r11.getContext());
    L5:
        r11.f(BufferedChannelKt.z());
    }

    private final Object w0(E r10, Continuation<? super Unit> r11) {
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r11), 1);
        r12.F();
        Function1<E, Unit> r13 = this.f10285g;
        if (r13 == null) goto L10;
        Throwable r14 = OnUndeliveredElementKt.d(r13, r10, null, 2, null);
        if (r14 == null) goto L10;
        ExceptionsKt.addSuppressed(r14, Z());
        Result.Companion r15 = Result.Companion;
        if (n0.d() == false) goto L9;
        r14 = h0.a(r14, r12);
    L9:
        Object r16 = ResultKt.createFailure(r14);
    L14:
        r12.resumeWith(Result.m32constructorimpl(r16));
        Object r17 = r12.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L18:
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r17;
    L21:
        return Unit.INSTANCE;
    L10:
        Throwable r18 = Z();
        Result.Companion r19 = Result.Companion;
        if (n0.d() == false) goto L13;
        r18 = h0.a(r18, r12);
    L13:
        r16 = ResultKt.createFailure(r18);
        goto L14
    }

    private final void x0(E r10, kotlinx.coroutines.n<? super Unit> r11) {
        Function1<E, Unit> r12 = this.f10285g;
        if (r12 == null) goto L5;
        OnUndeliveredElementKt.b(r12, r10, r11.getContext());
    L5:
        Throwable r13 = Z();
        if (n0.d() == true) goto L8;
    L11:
        Result.Companion r14 = Result.Companion;
        r11.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(r13)));
        return;
    L8:
        if ((r11 instanceof CoroutineStackFrame) == false) goto L11;
        r13 = h0.a(r13, (CoroutineStackFrame) r11);
        goto L11
    }

    public static final /* synthetic */ Object y(BufferedChannel r10, Object r11, Object r12) {
        return r10.E0(r11, r12);
    }

    public static final /* synthetic */ Object z(BufferedChannel r10, Object r11, Object r12) {
        return r10.F0(r11, r12);
    }

    @Override // kotlinx.coroutines.channels.n
    public void B(Function1<? super Throwable, Unit> r10) {
        AtomicReferenceFieldUpdater r11 = f10283q;
        if (r11.compareAndSet(this, null, r10) == false) goto L5;
        return;
    L5:
        Object r12 = r11.get(this);
        if (r12 != BufferedChannelKt.d()) goto L12;
        if (f10283q.compareAndSet(this, BufferedChannelKt.d(), BufferedChannelKt.e()) == false) goto L5;
        r10.invoke(W());
        return;
    L12:
        if (r12 != BufferedChannelKt.e()) goto L16;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L16:
        throw new IllegalStateException(("Another handler is already registered: " + r12).toString());
    }

    @Override // kotlinx.coroutines.channels.n
    public Object E(E r15) {
        if (U0(f10275i.get(this)) == true) goto L5;
        Object r10 = BufferedChannelKt.j();
        h r11 = (h) k().get(this);
    L7:
        long r12 = l().getAndIncrement(this);
        long r13 = r12 & 1152921504606846975L;
        boolean r14 = m(this, r12);
        int r16 = BufferedChannelKt.f10293b;
        long r17 = r13 / ((long) r16);
        int r18 = (int) (r13 % ((long) r16));
        if (r11.f10550h == r17) goto L14;
        h r19 = f(this, r17, r11);
        if (r19 == null) goto L11;
        h r110 = r19;
    L15:
        int r20 = F(this, r110, r18, r15, r13, r10, r14);
        if (r20 == 0) goto L45;
        if (r20 == 1) goto L47;
        if (r20 == 2) goto L35;
        if (r20 == 3) goto L34;
        if (r20 == 4) goto L31;
        if (r20 != 5) goto L29;
        r110.b();
    L29:
        r11 = r110;
        goto L7
    L31:
        if (r13 >= Y()) goto L60;
        r110.b();
    L60:
        return g.f10318b.a(Z());
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r14 == false) goto L39;
        r110.p();
        goto L60
    L39:
        if ((r10 instanceof c3) == false) goto L41;
        c3 r21 = (c3) r10;
    L42:
        if (r21 == null) goto L44;
        s(this, r21, r110, r18);
    L44:
        r110.p();
        return g.f10318b.b();
    L41:
        r21 = null;
    L47:
        return g.f10318b.c(Unit.INSTANCE);
    L45:
        r110.b();
        goto L47
    L11:
        if (r14 == false) goto L7;
    L14:
        r110 = r11;
        goto L15
    L5:
        return g.f10318b.b();
    }

    @Override // kotlinx.coroutines.channels.n
    public Object H(E r10, Continuation<? super Unit> r11) {
        return Q0(this, r10, r11);
    }

    public boolean I(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new CancellationException("Channel was cancelled");
    L5:
        return M(r10, true);
    }

    @Override // kotlinx.coroutines.channels.n
    public boolean L() {
        return j0(f10275i.get(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void L0(kotlinx.coroutines.selects.k<?> r14, Object r15) {
        h r10 = (h) k().get(this);
    L3:
        long r11 = l().getAndIncrement(this);
        long r12 = 1152921504606846975L & r11;
        boolean r13 = m(this, r11);
        int r16 = BufferedChannelKt.f10293b;
        long r17 = r12 / ((long) r16);
        int r18 = (int) (r12 % ((long) r16));
        if (r10.f10550h == r17) goto L10;
        h r19 = f(this, r17, r10);
        if (r19 == null) goto L7;
        r10 = r19;
        goto L10
    L7:
        if (r13 == false) goto L3;
    L31:
        v0(r15, r14);
        return;
    L10:
        int r20 = F(this, r10, r18, r15, r12, r14, r13);
        if (r20 == 0) goto L38;
        if (r20 == 1) goto L39;
        if (r20 == 2) goto L29;
        if (r20 == 3) goto L28;
        if (r20 == 4) goto L25;
        if (r20 != 5) goto L3;
        r10.b();
        goto L3
    L25:
        if (r12 >= Y()) goto L31;
        r10.b();
        goto L31
    L28:
        throw new IllegalStateException("unexpected".toString());
    L29:
        if (r13 == false) goto L33;
        r10.p();
        goto L31
    L33:
        if ((r14 instanceof c3) == false) goto L35;
        c3 r110 = (c3) r14;
    L36:
        if (r110 == null) goto L56;
        s(this, r110, r10, r18);
        return;
    L56:
        return;
    L35:
        r110 = null;
    L39:
        r14.f(Unit.INSTANCE);
        return;
    L38:
        r10.b();
        goto L39
    }

    protected boolean M(Throwable r10, boolean r11) {
        if (r11 == false) goto L4;
        n0();
    L4:
        boolean r12 = f10282p.compareAndSet(this, BufferedChannelKt.l(), r10);
        if (r11 == false) goto L7;
        o0();
    L8:
        P();
        r0();
        if (r12 == false) goto L11;
        e0();
    L11:
        return r12;
    L7:
        p0();
        goto L8
    }

    protected final void Q(long r11) {
        if (n0.a() == true) goto L5;
    L9:
        h<E> r10 = (h) f10280n.get(this);
    L10:
        AtomicLongFieldUpdater r12 = f10276j;
        long r13 = r12.get(this);
        if (r11 < Math.max(((long) this.f10284c) + r13, V())) goto L12;
        if (r12.compareAndSet(this, r13, r13 + 1) == false) goto L10;
        int r14 = BufferedChannelKt.f10293b;
        long r15 = r13 / ((long) r14);
        int r16 = (int) (r13 % ((long) r14));
        if (r10.f10550h == r15) goto L21;
        h<E> r17 = T(r15, r10);
        if (r17 == null) goto L10;
        r10 = r17;
    L21:
        Object r18 = a1(r10, r16, r13, null);
        if (r18 == BufferedChannelKt.h()) goto L24;
        r10.b();
        Function1<E, Unit> r19 = this.f10285g;
        if (r19 == null) goto L10;
        UndeliveredElementException r20 = OnUndeliveredElementKt.d(r19, r18, null, 2, null);
        if (r20 == null) goto L10;
        throw r20;
    L24:
        if (r13 >= a0()) goto L10;
        r10.b();
        goto L10
    L12:
        return;
    L5:
        if (k0() == true) goto L9;
        throw new AssertionError();
    }

    public Object R0(E r10, Continuation<? super Boolean> r11) {
        return S0(this, r10, r11);
    }

    public boolean V0() {
        return U0(f10275i.get(this));
    }

    protected final Throwable W() {
        return (Throwable) f10282p.get(this);
    }

    public final long Y() {
        return f10276j.get(this);
    }

    protected final Throwable Z() {
        Throwable r10 = W();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new ClosedSendChannelException("Channel was closed");
    }

    public final long a0() {
        return f10275i.get(this) & 1152921504606846975L;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.f<E> b() {
        BufferedChannel$onReceive$1 r10 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3);
        BufferedChannel$onReceive$2 r12 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.g(this, r11, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 3), this.f10286h);
    }

    public final boolean b0() {
    L2:
        AtomicReferenceFieldUpdater r10 = f10280n;
        h<E> r11 = (h) r10.get(this);
        long r12 = Y();
        if (a0() <= r12) goto L4;
        int r13 = BufferedChannelKt.f10293b;
        long r14 = r12 / ((long) r13);
        if (r11.f10550h == r14) goto L12;
        r11 = T(r14, r11);
        if (r11 != null) goto L12;
        if (((h) r10.get(this)).f10550h >= r14) goto L2;
        return false;
    L12:
        r11.b();
        if (f0(r11, (int) (r12 % ((long) r13)), r12) == true) goto L14;
        f10276j.compareAndSet(this, r12, r12 + 1);
        goto L2
    L14:
        return true;
    L4:
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void c(CancellationException r10) {
        I(r10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.f<g<E>> d() {
        BufferedChannel$onReceiveCatching$1 r10 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3);
        BufferedChannel$onReceiveCatching$2 r12 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.g(this, r11, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 3), this.f10286h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object e() {
        long r10 = f10276j.get(this);
        long r11 = f10275i.get(this);
        if (i0(r11) == false) goto L7;
        return g.f10318b.a(W());
    L7:
        if (r10 >= (r11 & 1152921504606846975L)) goto L9;
        Object r12 = BufferedChannelKt.i();
        h r13 = (h) i().get(this);
    L12:
        if (h0() == true) goto L50;
        long r14 = j().getAndIncrement(this);
        int r15 = BufferedChannelKt.f10293b;
        long r16 = r14 / ((long) r15);
        int r17 = (int) (r14 % ((long) r15));
        if (r13.f10550h == r16) goto L20;
        h r18 = a(this, r16, r13);
        if (r18 == null) goto L12;
        h r19 = r18;
    L21:
        Object r20 = D(this, r19, r17, r14, r12);
        if (r20 == BufferedChannelKt.r()) goto L24;
        if (r20 != BufferedChannelKt.h()) goto L37;
        if (r14 >= a0()) goto L35;
        r19.b();
    L35:
        r13 = r19;
        goto L12
    L37:
        if (r20 == BufferedChannelKt.s()) goto L41;
        r19.b();
        return g.f10318b.c(r20);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if ((r12 instanceof c3) == false) goto L26;
        c3 r21 = (c3) r12;
    L27:
        if (r21 == null) goto L29;
        r(this, r21, r19, r17);
    L29:
        g1(r14);
        r19.p();
        return g.f10318b.b();
    L26:
        r21 = null;
        goto L27
    L20:
        r19 = r13;
        goto L21
    L50:
        return g.f10318b.a(W());
    L9:
        return g.f10318b.b();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object g(Continuation<? super g<? extends E>> r10) {
        return H0(this, r10);
    }

    public final void g1(long r14) {
        if (l0() == false) goto L6;
        return;
    L6:
        if (V() <= r14) goto L6;
        int r15 = BufferedChannelKt.g();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L16;
        long r10 = V();
        if (r10 != (DurationKt.MAX_MILLIS & f10278l.get(this))) goto L15;
        if (r10 != V()) goto L15;
        return;
    L15:
        r16 = r16 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r11 = f10278l;
    L17:
        long r12 = r11.get(this);
        if (r11.compareAndSet(this, r12, BufferedChannelKt.a(r12 & DurationKt.MAX_MILLIS, true)) == false) goto L17;
    L19:
        long r17 = V();
        AtomicLongFieldUpdater r13 = f10278l;
        long r18 = r13.get(this);
        long r19 = r18 & DurationKt.MAX_MILLIS;
        if ((4611686018427387904L & r18) == 0) goto L22;
        boolean r20 = true;
    L24:
        if (r17 == r19) goto L26;
    L30:
        if (r20 == true) goto L19;
        r13.compareAndSet(this, r18, BufferedChannelKt.a(r19, true));
        goto L19
    L26:
        if (r17 != V()) goto L30;
    L27:
        long r21 = r13.get(this);
        if (r13.compareAndSet(this, r21, BufferedChannelKt.a(r21 & DurationKt.MAX_MILLIS, false)) == false) goto L27;
        return;
    L22:
        r20 = false;
        goto L24
    }

    public boolean h0() {
        return i0(f10275i.get(this));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new a(this);
    }

    protected boolean k0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.n
    public kotlinx.coroutines.selects.h<E, BufferedChannel<E>> n() {
        BufferedChannel$onSend$1 r10 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r11 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r10, 3);
        BufferedChannel$onSend$2 r12 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.i(this, r11, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r12, 3), null, 8, null);
    }

    protected void r0() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object t(Continuation<? super E> r10) {
        return G0(this, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        int r11 = (int) (f10275i.get(this) >> 60);
        if (r11 == 2) goto L7;
        if (r11 != 3) goto L9;
        String r12 = "cancelled,";
    L8:
        r10.append(r12);
    L9:
        r10.append("capacity=" + this.f10284c + ',');
        r10.append("data=[");
        int r13 = 0;
        List r14 = CollectionsKt.listOf(new h[]{f10280n.get(this), f10279m.get(this), f10281o.get(this)});
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L11:
        if (r16.hasNext() == false) goto L18;
        Object r17 = r16.next();
        if (((h) r17) == BufferedChannelKt.n()) goto L15;
        boolean r18 = true;
    L16:
        if (r18 == false) goto L11;
        r15.add(r17);
        goto L11
    L15:
        r18 = false;
        goto L16
    L18:
        Iterator r19 = r15.iterator();
        if (r19.hasNext() == false) goto L106;
        Object r20 = r19.next();
        if (r19.hasNext() == false) goto L29;
        long r21 = ((h) r20).f10550h;
    L24:
        Object r22 = r19.next();
        long r110 = ((h) r22).f10550h;
        if (r21 <= r110) goto L28;
        r20 = r22;
        r21 = r110;
    L28:
        if (r19.hasNext() == true) goto L24;
    L29:
        h r23 = (h) r20;
        long r111 = Y();
        long r112 = a0();
    L30:
        int r24 = BufferedChannelKt.f10293b;
        int r25 = r13;
    L31:
        if (r25 >= r24) goto L97;
        long r26 = (r23.f10550h * ((long) BufferedChannelKt.f10293b)) + ((long) r25);
        if (r26 >= r112) goto L35;
    L36:
        Object r113 = r23.w(r25);
        Object r114 = r23.v(r25);
        if ((r113 instanceof kotlinx.coroutines.n) == false) goto L47;
        if (r26 >= r111) goto L42;
        if (r26 < r112) goto L42;
        String r27 = "receive";
    L92:
        if (r114 == null) goto L94;
        StringBuilder r28 = new StringBuilder();
        r28.append('(');
        r28.append(r27);
        r28.append(',');
        r28.append(r114);
        r28.append("),");
    L95:
        r10.append(r28.toString());
    L96:
        r25 = r25 + 1;
        goto L31
    L94:
        r28 = new StringBuilder();
        r28.append(r27);
        r28.append(',');
    L42:
        if (r26 >= r112) goto L45;
        if (r26 < r111) goto L45;
        r27 = "send";
    L45:
        r27 = "cont";
        goto L92
    L47:
        if ((r113 instanceof kotlinx.coroutines.selects.k) == false) goto L57;
        if (r26 >= r111) goto L52;
        if (r26 < r112) goto L52;
        r27 = "onReceive";
    L52:
        if (r26 >= r112) goto L55;
        if (r26 < r111) goto L55;
        r27 = "onSend";
    L55:
        r27 = "select";
        goto L92
    L57:
        if ((r113 instanceof m) == false) goto L60;
        r27 = "receiveCatching";
        goto L92
    L60:
        if ((r113 instanceof b) == false) goto L63;
        r27 = "sendBroadcast";
        goto L92
    L63:
        if ((r113 instanceof o) == false) goto L66;
        r27 = "EB(" + r113 + ')';
        goto L92
    L66:
        if (Intrinsics.areEqual(r113, BufferedChannelKt.q()) == false) goto L68;
        boolean r29 = true;
    L69:
        if (r29 == false) goto L71;
        r27 = "resuming_sender";
        goto L92
    L71:
        if (r113 != null) goto L73;
        boolean r30 = true;
    L74:
        if (r30 == false) goto L76;
        boolean r31 = true;
    L77:
        if (r31 == false) goto L79;
        boolean r32 = true;
    L80:
        if (r32 == false) goto L82;
        boolean r33 = true;
    L83:
        if (r33 == false) goto L85;
        boolean r34 = true;
    L86:
        if (r34 == false) goto L88;
        boolean r35 = true;
    L89:
        if (r35 == true) goto L96;
        r27 = r113.toString();
        goto L92
    L88:
        r35 = Intrinsics.areEqual(r113, BufferedChannelKt.z());
        goto L89
    L85:
        r34 = Intrinsics.areEqual(r113, BufferedChannelKt.j());
        goto L86
    L82:
        r33 = Intrinsics.areEqual(r113, BufferedChannelKt.i());
        goto L83
    L79:
        r32 = Intrinsics.areEqual(r113, BufferedChannelKt.o());
        goto L80
    L76:
        r31 = Intrinsics.areEqual(r113, BufferedChannelKt.f());
        goto L77
    L73:
        r30 = Intrinsics.areEqual(r113, BufferedChannelKt.k());
        goto L74
    L68:
        r29 = Intrinsics.areEqual(r113, BufferedChannelKt.p());
        goto L69
    L35:
        if (r26 < r111) goto L36;
    L100:
        if (StringsKt.last(r10) != ',') goto L102;
        Intrinsics.checkNotNullExpressionValue(r10.deleteCharAt(r10.length() - 1), "this.deleteCharAt(index)");
    L102:
        r10.append("]");
        return r10.toString();
    L97:
        r23 = (h) r23.e();
        if (r23 == null) goto L100;
        r13 = 0;
        goto L30
    L106:
        throw new NoSuchElementException();
    L7:
        r12 = "closed,";
        goto L8
    }

    @Override // kotlinx.coroutines.channels.n
    public boolean w(Throwable r10) {
        return M(r10, false);
    }

    protected void y0() {
    }

    protected void z0() {
    }
}
