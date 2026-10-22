package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/index/CoverageCompletion;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INCOMPLETE", "COMPLETE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CoverageCompletion extends Enum<CoverageCompletion> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CoverageCompletion[] $VALUES = null;
    public static final CoverageCompletion COMPLETE = null;
    public static final CoverageCompletion INCOMPLETE = null;
    public static final CoverageCompletion UNKNOWN = null;

    private static final /* synthetic */ CoverageCompletion[] $values() {
        return new CoverageCompletion[]{UNKNOWN, INCOMPLETE, COMPLETE};
    }

    static {
        UNKNOWN = new CoverageCompletion("UNKNOWN", 0);
        INCOMPLETE = new CoverageCompletion("INCOMPLETE", 1);
        COMPLETE = new CoverageCompletion("COMPLETE", 2);
        CoverageCompletion[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private CoverageCompletion(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<CoverageCompletion> getEntries() {
        return $ENTRIES;
    }

    public static CoverageCompletion valueOf(String r2) {
        return (CoverageCompletion) ZeusTransformUtils.preCheckCast(Enum.valueOf(CoverageCompletion.class, r2), CoverageCompletion.class, "com.obric.memorydata.plugin");
    }

    public static CoverageCompletion[] values() {
        return (CoverageCompletion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CoverageCompletion[].class, "com.obric.memorydata.plugin");
    }
}
