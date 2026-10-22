package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollector_commonKt {
    @JvmName(name = "checkContext")
    public static final void a(final SafeCollector<?> r10, CoroutineContext r11) {
        if (((Number) r11.fold(0, new SafeCollector_commonKt$checkContext$result$1(r10))).intValue() != r10.collectContextSize) goto L6;
        return;
    L6:
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + r10.collectContext + ",\n\t\tbut emission happened in " + r11 + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final v1 b(v1 r10, v1 r11) {
    L2:
        if (r10 == null) goto L3;
        if (r10 == r11) goto L6;
        if ((r10 instanceof e0) == false) goto L9;
        r10 = r10.getParent();
        goto L2
    L9:
        return r10;
    L6:
        return r10;
    L3:
        return null;
    }
}
