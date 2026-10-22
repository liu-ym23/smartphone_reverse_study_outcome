package kotlinx.coroutines.internal;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@JvmInline
public final class g0<S extends f0<S>> {
    public static <S extends f0<S>> Object a(Object r10) {
        return r10;
    }

    public static final S b(Object r10) {
        if (r10 == e.a()) goto L7;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) r10;
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object r10) {
        if (r10 != e.a()) goto L5;
        return true;
    L5:
        return false;
    }
}
