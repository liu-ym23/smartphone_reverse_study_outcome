package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolverBase;", "types", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes;", "strings", "", "", "(Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$StringTableTypes;[Ljava/lang/String;)V", "getTypes", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$StringTableTypes;", "metadata.jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.types;
    }
}
