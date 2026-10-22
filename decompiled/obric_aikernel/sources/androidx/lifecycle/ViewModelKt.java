package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final l0 getViewModelScope(ViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        l0 r11 = (l0) r10.getTag(JOB_KEY);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Object r12 = r10.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(q2.b(null, 1, null).plus(z0.c().c0())));
        Intrinsics.checkNotNullExpressionValue(r12, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (l0) r12;
    }
}
