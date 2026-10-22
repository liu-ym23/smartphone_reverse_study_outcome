package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/KvValueType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "INT", "LONG", "FLOAT", "DOUBLE", "BOOLEAN", "STRING_SET", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum KvValueType extends Enum<KvValueType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KvValueType[] $VALUES = null;
    public static final KvValueType BOOLEAN = null;
    public static final KvValueType DOUBLE = null;
    public static final KvValueType FLOAT = null;
    public static final KvValueType INT = null;
    public static final KvValueType LONG = null;
    public static final KvValueType STRING = null;
    public static final KvValueType STRING_SET = null;

    private static final /* synthetic */ KvValueType[] $values() {
        return new KvValueType[]{STRING, INT, LONG, FLOAT, DOUBLE, BOOLEAN, STRING_SET};
    }

    static {
        STRING = new KvValueType("STRING", 0);
        INT = new KvValueType("INT", 1);
        LONG = new KvValueType("LONG", 2);
        FLOAT = new KvValueType("FLOAT", 3);
        DOUBLE = new KvValueType("DOUBLE", 4);
        BOOLEAN = new KvValueType("BOOLEAN", 5);
        STRING_SET = new KvValueType("STRING_SET", 6);
        KvValueType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private KvValueType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<KvValueType> getEntries() {
        return $ENTRIES;
    }

    public static KvValueType valueOf(String r2) {
        return (KvValueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KvValueType.class, r2), KvValueType.class, "com.obric.memorydata.plugin");
    }

    public static KvValueType[] values() {
        return (KvValueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KvValueType[].class, "com.obric.memorydata.plugin");
    }
}
