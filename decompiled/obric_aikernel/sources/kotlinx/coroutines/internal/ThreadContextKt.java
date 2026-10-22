package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final i0 f10533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.Element, Object> f10534b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function2<r2<?>, CoroutineContext.Element, r2<?>> f10535c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Function2<p0, CoroutineContext.Element, p0> f10536d = null;

    static {
        f10533a = new i0("NO_THREAD_ELEMENTS");
        f10534b = ThreadContextKt$countAll$1.INSTANCE;
        f10535c = ThreadContextKt$findOne$1.INSTANCE;
        f10536d = ThreadContextKt$updateState$1.INSTANCE;
    }

    public static final void a(CoroutineContext r10, Object r11) {
        if (r11 != f10533a) goto L6;
        return;
    L6:
        if ((r11 instanceof p0) == false) goto L8;
        ((p0) r11).b(r10);
        return;
    L8:
        Object r12 = r10.fold(null, f10535c);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((r2) r12).F(r10, r11);
    }

    public static final Object b(CoroutineContext r10) {
        Object r11 = r10.fold(0, f10534b);
        Intrinsics.checkNotNull(r11);
        return r11;
    }

    public static final Object c(CoroutineContext r10, Object r11) {
        if (r11 != null) goto L5;
        r11 = b(r10);
    L5:
        if (r11 != 0) goto L8;
        return f10533a;
    L8:
        if ((r11 instanceof Integer) == true) goto L13;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((r2) r11).X(r10);
    L13:
        return r10.fold(new p0(r10, ((Number) r11).intValue()), f10536d);
    }
}
