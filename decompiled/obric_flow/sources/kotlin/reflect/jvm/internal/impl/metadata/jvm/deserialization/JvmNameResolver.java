package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmNameResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolver.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public JvmNameResolver(JvmProtoBuf.StringTableTypes r5, String[] r10) {
        Intrinsics.checkNotNullParameter(r5, "types");
        Intrinsics.checkNotNullParameter(r10, "strings");
        List<Integer> r11 = r5.getLocalNameList();
        if (r11.isEmpty() == false) goto L5;
        Set r12 = SetsKt.emptySet();
    L6:
        super(r10, r12, JvmNameResolverKt.toExpandedRecordsList(r5.getRecordList()));
        this.types = r5;
        return;
    L5:
        r12 = CollectionsKt.toSet(r11);
        goto L6
    }
}
