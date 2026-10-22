package kotlin.reflect.jvm.internal.calls;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CallerKt {
    public static final int getArity(Caller<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getParameterTypes().size();
    }
}
