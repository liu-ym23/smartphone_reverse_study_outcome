package com.obric.lifelog.data;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/lifelog/data/LifelogStatus;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SUCCESS", RawObservationEntity.STATE_FAILED, "DISABLED", "lifelog_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LifelogStatus extends Enum<LifelogStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LifelogStatus[] $VALUES = null;
    public static final LifelogStatus DISABLED = null;
    public static final LifelogStatus FAILED = null;
    public static final LifelogStatus SUCCESS = null;
    public static final LifelogStatus UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ LifelogStatus[] $values() {
        return new LifelogStatus[]{UNKNOWN, SUCCESS, FAILED, DISABLED};
    }

    static {
        UNKNOWN = new LifelogStatus("UNKNOWN", 0, -1);
        SUCCESS = new LifelogStatus("SUCCESS", 1, 0);
        FAILED = new LifelogStatus(RawObservationEntity.STATE_FAILED, 2, 1);
        DISABLED = new LifelogStatus("DISABLED", 3, 2);
        LifelogStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private LifelogStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<LifelogStatus> getEntries() {
        return $ENTRIES;
    }

    public static LifelogStatus valueOf(String r2) {
        return (LifelogStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(LifelogStatus.class, r2), LifelogStatus.class, "com.obric.memorydata.plugin");
    }

    public static LifelogStatus[] values() {
        return (LifelogStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LifelogStatus[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
