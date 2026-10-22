package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return LifecycleKt.getCoroutineScope(r10.getLifecycle());
    }
}
