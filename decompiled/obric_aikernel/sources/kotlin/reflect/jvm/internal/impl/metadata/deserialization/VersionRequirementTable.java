package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = null;
    private static final VersionRequirementTable EMPTY = null;
    private final List<ProtoBuf.VersionRequirement> infos;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable r10) {
            Intrinsics.checkNotNullParameter(r10, "table");
            if (r10.getRequirementCount() == 0) goto L7;
            List<ProtoBuf.VersionRequirement> r11 = r10.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(r11, "table.requirementList");
            return new VersionRequirementTable(r11, null);
        L7:
            return getEMPTY();
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.access$getEMPTY$cp();
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r10) {
        this.infos = r10;
    }

    public /* synthetic */ VersionRequirementTable(List r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public static final /* synthetic */ VersionRequirementTable access$getEMPTY$cp() {
        return EMPTY;
    }
}
