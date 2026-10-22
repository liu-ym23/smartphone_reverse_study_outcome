package h38;

import com.larus.platform.model.KmpInstructionCoreOptConfig;
import com.larus.platform.service.z2;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final Lazy a = null;
    public static final Set<Integer> b = null;

    static {
        a = LazyKt.lazy(new a());
        b = SetsKt.setOf(new Integer[]{4, 18, 28});
    }

    public static boolean a(Integer r3) {
        if (CollectionsKt.contains(b, r3) == false) goto L15;
        List r0 = ((KmpInstructionCoreOptConfig) a.getValue()).getSupportedTypes();
        if (r0 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L12;
    L14:
        return false;
    L12:
        if (z2.a.creationInstructionKmpEnabled() == false) goto L14;
        return true;
    L7:
        if (r0.contains(r3) != true) goto L9;
        r4 = true;
        goto L10
    L15:
        List r1 = ((KmpInstructionCoreOptConfig) a.getValue()).getSupportedTypes();
        if (r1 == null) goto L14;
        if (r1.contains(r3) != true) goto L14;
        return true;
    }
}
