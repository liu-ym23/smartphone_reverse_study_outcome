package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = null;
    private static final VersionRequirementTable EMPTY = null;
    private final List<ProtoBuf.VersionRequirement> infos;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.access$getEMPTY$cp();
        }

        public final VersionRequirementTable create(ProtoBuf$VersionRequirementTable r3) {
            Intrinsics.checkNotNullParameter(r3, "table");
            if (r3.getRequirementCount() != 0) goto L6;
            return getEMPTY();
        L6:
            return new VersionRequirementTable(r3.getRequirementList(), null);
        }
    }

    public /* synthetic */ VersionRequirementTable(List r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    static {
        Companion = new Companion(null);
        EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    }

    public static final /* synthetic */ VersionRequirementTable access$getEMPTY$cp() {
        return EMPTY;
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r1) {
        this.infos = r1;
    }
}
