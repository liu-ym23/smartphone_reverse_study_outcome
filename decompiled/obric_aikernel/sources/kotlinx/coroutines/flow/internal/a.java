package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
public abstract class a<S extends c<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private S[] f10485c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r f10488i;

    public a() {
    }

    public static final /* synthetic */ int f(a r10) {
        return r10.f10486g;
    }

    public static final /* synthetic */ c[] g(a r10) {
        return r10.f10485c;
    }

    public final p1<Integer> d() {
        monitor-enter(this);
        r r10 = this.f10488i;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        r10 = new r(this.f10486g);     // Catch: Throwable -> L8
        this.f10488i = r10;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    protected final S h() {
        monitor-enter(this);
        S[] r10 = this.f10485c;     // Catch: Throwable -> L23
        if (r10 != null) goto L7;
        r10 = (S[]) j(2);
        this.f10485c = r10;     // Catch: Throwable -> L23
    L9:
        int r11 = this.f10487h;     // Catch: Throwable -> L23
    L10:
        S r12 = r10[r11];     // Catch: Throwable -> L23
        if (r12 != null) goto L13;
        r12 = (S) i();
        r10[r11] = r12;     // Catch: Throwable -> L23
    L13:
        r11 = r11 + 1;     // Catch: Throwable -> L23
        if (r11 < r10.length) goto L16;
        r11 = 0;
    L16:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r12.a(this) == false) goto L10;
        this.f10487h = r11;     // Catch: Throwable -> L23
        this.f10486g++;     // Catch: Throwable -> L23
        r r13 = this.f10488i;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r13 == null) goto L22;
        r13.Z(1);
    L22:
        return r12;
    L7:
        if (this.f10486g < r10.length) goto L9;
        Object[] r14 = Arrays.copyOf(r10, r10.length * 2);     // Catch: Throwable -> L23
        Intrinsics.checkNotNullExpressionValue(r14, "copyOf(this, newSize)");     // Catch: Throwable -> L23
        this.f10485c = (S[]) ((c[]) r14);     // Catch: Throwable -> L23
        r10 = (S[]) ((c[]) r14);
    L23:
        th = move-exception;
        throw th;
    }

    protected abstract S i();

    protected abstract S[] j(int r10);

    protected final void k(S r10) {
        monitor-enter(this);
        int r11 = this.f10486g - 1;     // Catch: Throwable -> L17
        this.f10486g = r11;     // Catch: Throwable -> L17
        r r12 = this.f10488i;     // Catch: Throwable -> L17
        int r13 = 0;
        if (r11 != 0) goto L6;
        this.f10487h = 0;     // Catch: Throwable -> L17
    L6:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        Continuation<Unit>[] r14 = r10.b(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r15 = r14.length;
    L9:
        if (r13 >= r15) goto L14;
        Continuation<Unit> r16 = r14[r13];
        if (r16 == null) goto L13;
        Result.Companion r17 = Result.Companion;
        r16.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
    L13:
        r13 = r13 + 1;
        goto L9
    L14:
        if (r12 == null) goto L25;
        r12.Z(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    protected final int l() {
        return this.f10486g;
    }

    protected final S[] m() {
        return this.f10485c;
    }
}
