package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.n;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
public final class HandlerContext extends d {
    private volatile HandlerContext _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f10235c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f10237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerContext f10238i;

    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,18:1\n148#2:19\n149#2:21\n1#3:20\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f10239c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HandlerContext f10240g;

        public a(n r10, HandlerContext r11) {
            this.f10239c = r10;
            this.f10240g = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f10239c.q(this.f10240g, Unit.INSTANCE);
        }
    }

    public HandlerContext(Handler r10, String r11) {
        this(r10, r11, false);
    }

    public /* synthetic */ HandlerContext(Handler r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HandlerContext(Handler r10, String r11, boolean r12) {
        HandlerContext r13 = null;
        super(0 == true ? 1 : 0);
        this.f10235c = r10;
        this.f10236g = r11;
        this.f10237h = r12;
        if (r12 == false) goto L5;
        r13 = this;
    L5:
        this._immediate = r13;
        HandlerContext r14 = this._immediate;
        if (r14 != null) goto L8;
        r14 = new HandlerContext(r10, r11, true);
        this._immediate = r14;
    L8:
        this.f10238i = r14;
    }

    public static /* synthetic */ void e0(HandlerContext r10, Runnable r11) {
        i0(r10, r11);
    }

    public static final /* synthetic */ Handler f0(HandlerContext r10) {
        return r10.f10235c;
    }

    private final void g0(CoroutineContext r10, Runnable r11) {
        y1.c(r10, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        z0.b().dispatch(r10, r11);
    }

    private static final void i0(HandlerContext r10, Runnable r11) {
        r10.f10235c.removeCallbacks(r11);
    }

    @Override // kotlinx.coroutines.android.d, kotlinx.coroutines.t0
    public b1 B(long r10, final Runnable r11, CoroutineContext r12) {
        if (this.f10235c.postDelayed(r11, RangesKt.coerceAtMost(r10, DurationKt.MAX_MILLIS)) == true) goto L5;
        g0(r12, r11);
        return i2.f10525c;
    L5:
        return new c(this, r11);
    }

    @Override // kotlinx.coroutines.g2
    public /* bridge */ /* synthetic */ g2 c0() {
        return h0();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext r10, Runnable r11) {
        if (this.f10235c.post(r11) == true) goto L6;
        g0(r10, r11);
        return;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof HandlerContext) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HandlerContext) r10).f10235c != this.f10235c) goto L7;
        return true;
    }

    public HandlerContext h0() {
        return this.f10238i;
    }

    public int hashCode() {
        return System.identityHashCode(this.f10235c);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext r10) {
        if (this.f10237h == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), this.f10235c.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.t0
    public void k(long r10, n<? super Unit> r11) {
        final a r12 = new a(r11, this);
        if (this.f10235c.postDelayed(r12, RangesKt.coerceAtMost(r10, DurationKt.MAX_MILLIS)) == false) goto L5;
        r11.h(new HandlerContext$scheduleResumeAfterDelay$1(this, r12));
        return;
    L5:
        g0(r11.getContext(), r12);
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r10 = d0();
        if (r10 != null) goto L11;
        String r11 = this.f10236g;
        if (r11 != null) goto L8;
        r11 = this.f10235c.toString();
    L8:
        if (this.f10237h == true) goto L10;
        return r11;
    L10:
        return r11 + ".immediate";
    L11:
        return r10;
    }
}
