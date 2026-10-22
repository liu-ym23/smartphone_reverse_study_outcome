package kotlinx.coroutines.flow.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.internal.c;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u0017\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001b\u001a\u00020\tH$¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0 H\u0084\bJ\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010#R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private S[] f17450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17451b;
    private int c;
    private x d;

    public a() {
    }

    public static final /* synthetic */ int a(a r0) {
        return r0.f17451b;
    }

    public static final /* synthetic */ c[] b(a r0) {
        return r0.f17450a;
    }

    public final ar<Integer> a() {
        monitor-enter(this);
        x r0 = this.d;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = new x(this.f17451b);     // Catch: Throwable -> L9
        this.d = r0;     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);
        return (ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        throw th;
    }

    public final void a(S r6) {
        monitor-enter(this);
        int r0 = this.f17451b - 1;     // Catch: Throwable -> L17
        this.f17451b = r0;     // Catch: Throwable -> L17
        x r2 = this.d;     // Catch: Throwable -> L17
        int r3 = 0;
        if (r0 != 0) goto L6;
        this.c = 0;     // Catch: Throwable -> L17
    L6:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        Continuation<Unit>[] r7 = r6.b(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r5 = r7.length;
    L9:
        if (r3 >= r5) goto L14;
        Continuation<Unit> r1 = r7[r3];
        if (r1 == null) goto L13;
        Result.Companion r4 = Result.Companion;
        r1.resumeWith(Result.m1421constructorimpl(Unit.INSTANCE));
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r2 == null) goto L25;
        r2.c(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public abstract S[] b(int r1);

    public abstract S g();

    public final S[] h() {
        return this.f17450a;
    }

    public final int i() {
        return this.f17451b;
    }

    public final S j() {
        monitor-enter(this);
        S[] r0 = this.f17450a;     // Catch: Throwable -> L23
        if (r0 != null) goto L7;
        r0 = (S[]) b(2);
        this.f17450a = r0;     // Catch: Throwable -> L23
    L9:
        int r1 = this.c;     // Catch: Throwable -> L23
    L10:
        S r2 = r0[r1];     // Catch: Throwable -> L23
        if (r2 != null) goto L13;
        r2 = (S) g();
        r0[r1] = r2;     // Catch: Throwable -> L23
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        if (r1 < r0.length) goto L16;
        r1 = 0;
    L16:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r2.a(this) == false) goto L10;
        this.c = r1;     // Catch: Throwable -> L23
        this.f17451b++;     // Catch: Throwable -> L23
        x r3 = this.d;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r3 == null) goto L22;
        r3.c(1);
    L22:
        return r2;
    L7:
        if (this.f17451b < r0.length) goto L9;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(...)");     // Catch: Throwable -> L23
        this.f17450a = (S[]) ((c[]) ZeusTransformUtils.preCheckCast(r4, c[].class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        r0 = (S[]) ((c[]) ZeusTransformUtils.preCheckCast(r4, c[].class, "com.obric.memorydata.plugin"));
    L23:
        th = move-exception;
        throw th;
    }
}
