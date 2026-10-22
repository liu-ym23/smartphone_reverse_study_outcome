package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class i<P, Q> implements h<P, Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<Object, k<?>, Object, Unit> f10688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3<Object, Object, Object, Object> f10689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function3<k<?>, Object, Object, Function1<Throwable, Unit>> f10690d;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Object r10, Function3<Object, ? super k<?>, Object, Unit> r11, Function3<Object, Object, Object, ? extends Object> r12, Function3<? super k<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r13) {
        this.f10687a = r10;
        this.f10688b = r11;
        this.f10689c = r12;
        this.f10690d = r13;
    }

    public /* synthetic */ i(Object r10, Function3 r11, Function3 r12, Function3 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, k<?>, Object, Unit> a() {
        return this.f10688b;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, Object, Object, Object> d() {
        return this.f10689c;
    }
}
