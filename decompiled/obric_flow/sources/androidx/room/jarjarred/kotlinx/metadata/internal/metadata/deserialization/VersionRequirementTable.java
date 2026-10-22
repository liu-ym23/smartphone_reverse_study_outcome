package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "", "infos", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$VersionRequirement;", "(Ljava/util/List;)V", "get", "id", "", "Companion", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VersionRequirementTable {
    public static final Companion Companion = null;
    private static final VersionRequirementTable EMPTY = null;
    private final List<ProtoBuf.VersionRequirement> infos;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable$Companion;", "", "()V", "EMPTY", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/VersionRequirementTable;", "getEMPTY", "()Lorg/jetbrains/kotlin/metadata/deserialization/VersionRequirementTable;", "create", "table", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$VersionRequirementTable;", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable r5) {
            Intrinsics.checkNotNullParameter(r5, "table");
            if (r5.getRequirementCount() != 0) goto L6;
            return getEMPTY();
        L6:
            return new VersionRequirementTable(r5.getRequirementList(), null);
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.access$getEMPTY$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    }

    public /* synthetic */ VersionRequirementTable(List r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public static final /* synthetic */ VersionRequirementTable access$getEMPTY$cp() {
        return EMPTY;
    }

    public final ProtoBuf.VersionRequirement get(int r5) {
        return (ProtoBuf.VersionRequirement) CollectionsKt.getOrNull(this.infos, r5);
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r5) {
        this.infos = r5;
    }
}
