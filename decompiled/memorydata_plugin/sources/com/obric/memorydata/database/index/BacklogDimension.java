package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/index/BacklogDimension;", "", "<init>", "(Ljava/lang/String;I)V", "OVERALL", "ENTITY_TYPE", "BUILD_TYPE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BacklogDimension extends Enum<BacklogDimension> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BacklogDimension[] $VALUES = null;
    public static final BacklogDimension BUILD_TYPE = null;
    public static final BacklogDimension ENTITY_TYPE = null;
    public static final BacklogDimension OVERALL = null;

    private static final /* synthetic */ BacklogDimension[] $values() {
        return new BacklogDimension[]{OVERALL, ENTITY_TYPE, BUILD_TYPE};
    }

    static {
        OVERALL = new BacklogDimension("OVERALL", 0);
        ENTITY_TYPE = new BacklogDimension("ENTITY_TYPE", 1);
        BUILD_TYPE = new BacklogDimension("BUILD_TYPE", 2);
        BacklogDimension[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private BacklogDimension(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BacklogDimension> getEntries() {
        return $ENTRIES;
    }

    public static BacklogDimension valueOf(String r2) {
        return (BacklogDimension) ZeusTransformUtils.preCheckCast(Enum.valueOf(BacklogDimension.class, r2), BacklogDimension.class, "com.obric.memorydata.plugin");
    }

    public static BacklogDimension[] values() {
        return (BacklogDimension[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BacklogDimension[].class, "com.obric.memorydata.plugin");
    }
}
