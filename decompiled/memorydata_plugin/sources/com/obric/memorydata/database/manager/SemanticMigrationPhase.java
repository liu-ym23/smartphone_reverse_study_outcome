package com.obric.memorydata.database.manager;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationPhase;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCHEMA", "PREPARE", "UPGRADE", "REBUILD", "COMPLETED", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SemanticMigrationPhase extends Enum<SemanticMigrationPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SemanticMigrationPhase[] $VALUES = null;
    public static final SemanticMigrationPhase COMPLETED = null;
    public static final a Companion = null;
    public static final SemanticMigrationPhase PREPARE = null;
    public static final SemanticMigrationPhase REBUILD = null;
    public static final SemanticMigrationPhase SCHEMA = null;
    public static final SemanticMigrationPhase UPGRADE = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/manager/SemanticMigrationPhase$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/database/manager/SemanticMigrationPhase;", EventBody.KEY_VALUE, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final SemanticMigrationPhase a(String r4) {
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(SemanticMigrationPhase.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            Object r0 = r3.next();
            if (Intrinsics.areEqual(((SemanticMigrationPhase) ZeusTransformUtils.preCheckCast(r0, SemanticMigrationPhase.class, "com.obric.memorydata.plugin")).getValue(), r4) == false) goto L4;
        L9:
            SemanticMigrationPhase r5 = (SemanticMigrationPhase) ZeusTransformUtils.preCheckCast(r0, SemanticMigrationPhase.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L12;
            return r5;
        L12:
            return SemanticMigrationPhase.SCHEMA;
        L8:
            r0 = null;
            goto L9
        }
    }

    private static final /* synthetic */ SemanticMigrationPhase[] $values() {
        return new SemanticMigrationPhase[]{SCHEMA, PREPARE, UPGRADE, REBUILD, COMPLETED};
    }

    static {
        SCHEMA = new SemanticMigrationPhase("SCHEMA", 0, "schema");
        PREPARE = new SemanticMigrationPhase("PREPARE", 1, LBSLightLocationTraceLogger.PREPARE);
        UPGRADE = new SemanticMigrationPhase("UPGRADE", 2, "upgrade");
        REBUILD = new SemanticMigrationPhase("REBUILD", 3, "rebuild");
        COMPLETED = new SemanticMigrationPhase("COMPLETED", 4, "completed");
        SemanticMigrationPhase[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private SemanticMigrationPhase(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<SemanticMigrationPhase> getEntries() {
        return $ENTRIES;
    }

    public static SemanticMigrationPhase valueOf(String r2) {
        return (SemanticMigrationPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(SemanticMigrationPhase.class, r2), SemanticMigrationPhase.class, "com.obric.memorydata.plugin");
    }

    public static SemanticMigrationPhase[] values() {
        return (SemanticMigrationPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SemanticMigrationPhase[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
