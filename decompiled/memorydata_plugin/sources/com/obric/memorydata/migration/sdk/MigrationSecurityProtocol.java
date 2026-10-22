package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol;", "", "wireVersion", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireVersion", "()Ljava/lang/String;", "LEGACY_V1", "ATTESTED_V2", "Companion", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MigrationSecurityProtocol extends Enum<MigrationSecurityProtocol> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MigrationSecurityProtocol[] $VALUES = null;
    public static final MigrationSecurityProtocol ATTESTED_V2 = null;
    public static final a Companion = null;
    public static final MigrationSecurityProtocol LEGACY_V1 = null;
    private final String wireVersion;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol$Companion;", "", "<init>", "()V", "fromWireVersion", "Lcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol;", "version", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MigrationSecurityProtocol a(String r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(MigrationSecurityProtocol.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((MigrationSecurityProtocol) ZeusTransformUtils.preCheckCast(r0, MigrationSecurityProtocol.class, "com.obric.memorydata.plugin")).getWireVersion(), r4) == false) goto L4;
        L10:
            return (MigrationSecurityProtocol) ZeusTransformUtils.preCheckCast(r0, MigrationSecurityProtocol.class, "com.obric.memorydata.plugin");
        L8:
            r0 = null;
            goto L10
        }
    }

    private static final /* synthetic */ MigrationSecurityProtocol[] $values() {
        return new MigrationSecurityProtocol[]{LEGACY_V1, ATTESTED_V2};
    }

    static {
        LEGACY_V1 = new MigrationSecurityProtocol("LEGACY_V1", 0, "1");
        ATTESTED_V2 = new MigrationSecurityProtocol("ATTESTED_V2", 1, "2");
        MigrationSecurityProtocol[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MigrationSecurityProtocol(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireVersion = r3;
    }

    public static EnumEntries<MigrationSecurityProtocol> getEntries() {
        return $ENTRIES;
    }

    public static MigrationSecurityProtocol valueOf(String r2) {
        return (MigrationSecurityProtocol) ZeusTransformUtils.preCheckCast(Enum.valueOf(MigrationSecurityProtocol.class, r2), MigrationSecurityProtocol.class, "com.obric.memorydata.plugin");
    }

    public static MigrationSecurityProtocol[] values() {
        return (MigrationSecurityProtocol[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MigrationSecurityProtocol[].class, "com.obric.memorydata.plugin");
    }

    public final String getWireVersion() {
        return this.wireVersion;
    }
}
