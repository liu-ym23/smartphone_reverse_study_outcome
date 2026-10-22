package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(JvmProtoBuf.StringTableTypes r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r3, "types");
        Intrinsics.checkNotNullParameter(r4, "strings");
        List<Integer> r0 = r3.getLocalNameList();
        if (r0.isEmpty() == false) goto L5;
        Set r1 = SetsKt.emptySet();
    L6:
        super(r4, r1, JvmNameResolverKt.toExpandedRecordsList(r3.getRecordList()));
        this.types = r3;
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        r1 = CollectionsKt.toSet(r0);
        goto L6
    }
}
