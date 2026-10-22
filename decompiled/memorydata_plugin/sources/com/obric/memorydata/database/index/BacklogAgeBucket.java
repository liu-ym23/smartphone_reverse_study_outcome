package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/index/BacklogAgeBucket;", "", "<init>", "(Ljava/lang/String;I)V", "LT_1H", "H1_TO_6H", "H6_TO_24H", "D1_TO_3D", "D3_TO_7D", "D7_TO_30D", "GE_30D", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BacklogAgeBucket extends Enum<BacklogAgeBucket> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BacklogAgeBucket[] $VALUES = null;
    public static final BacklogAgeBucket D1_TO_3D = null;
    public static final BacklogAgeBucket D3_TO_7D = null;
    public static final BacklogAgeBucket D7_TO_30D = null;
    public static final BacklogAgeBucket GE_30D = null;
    public static final BacklogAgeBucket H1_TO_6H = null;
    public static final BacklogAgeBucket H6_TO_24H = null;
    public static final BacklogAgeBucket LT_1H = null;

    private static final /* synthetic */ BacklogAgeBucket[] $values() {
        return new BacklogAgeBucket[]{LT_1H, H1_TO_6H, H6_TO_24H, D1_TO_3D, D3_TO_7D, D7_TO_30D, GE_30D};
    }

    static {
        LT_1H = new BacklogAgeBucket("LT_1H", 0);
        H1_TO_6H = new BacklogAgeBucket("H1_TO_6H", 1);
        H6_TO_24H = new BacklogAgeBucket("H6_TO_24H", 2);
        D1_TO_3D = new BacklogAgeBucket("D1_TO_3D", 3);
        D3_TO_7D = new BacklogAgeBucket("D3_TO_7D", 4);
        D7_TO_30D = new BacklogAgeBucket("D7_TO_30D", 5);
        GE_30D = new BacklogAgeBucket("GE_30D", 6);
        BacklogAgeBucket[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private BacklogAgeBucket(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<BacklogAgeBucket> getEntries() {
        return $ENTRIES;
    }

    public static BacklogAgeBucket valueOf(String r2) {
        return (BacklogAgeBucket) ZeusTransformUtils.preCheckCast(Enum.valueOf(BacklogAgeBucket.class, r2), BacklogAgeBucket.class, "com.obric.memorydata.plugin");
    }

    public static BacklogAgeBucket[] values() {
        return (BacklogAgeBucket[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BacklogAgeBucket[].class, "com.obric.memorydata.plugin");
    }
}
