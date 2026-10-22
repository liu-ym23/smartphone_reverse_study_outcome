package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(JvmProtoBuf.StringTableTypes r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "types");
        Intrinsics.checkNotNullParameter(r11, "strings");
        List<Integer> r12 = r10.getLocalNameList();
        if (r12.isEmpty() == false) goto L5;
        Set r13 = SetsKt.emptySet();
    L6:
        List<JvmProtoBuf.StringTableTypes.Record> r14 = r10.getRecordList();
        Intrinsics.checkNotNullExpressionValue(r14, "types.recordList");
        super(r11, r13, JvmNameResolverKt.toExpandedRecordsList(r14));
        this.types = r10;
        return;
    L5:
        Intrinsics.checkNotNullExpressionValue(r12, "_init_$lambda$0");
        r13 = CollectionsKt.toSet(r12);
        goto L6
    }
}
