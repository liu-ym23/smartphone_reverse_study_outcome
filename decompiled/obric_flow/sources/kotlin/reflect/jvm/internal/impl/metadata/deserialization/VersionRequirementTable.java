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

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> r5) {
        this.infos = r5;
    }
}
