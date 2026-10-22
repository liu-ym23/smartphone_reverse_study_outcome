package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3<Object, k<?>, Object, Unit> f10680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3<k<?>, Object, Object, Function1<Throwable, Unit>> f10681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function3<Object, Object, Object, Object> f10682d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r10, Function3<Object, ? super k<?>, Object, Unit> r11, Function3<? super k<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> r12) {
        this.f10679a = r10;
        this.f10680b = r11;
        this.f10681c = r12;
        this.f10682d = SelectKt.c();
    }

    public /* synthetic */ e(Object r10, Function3 r11, Function3 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, k<?>, Object, Unit> a() {
        return this.f10680b;
    }

    @Override // kotlinx.coroutines.selects.j
    public Object b() {
        return this.f10679a;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<k<?>, Object, Object, Function1<Throwable, Unit>> c() {
        return this.f10681c;
    }

    @Override // kotlinx.coroutines.selects.j
    public Function3<Object, Object, Object, Object> d() {
        return this.f10682d;
    }
}
