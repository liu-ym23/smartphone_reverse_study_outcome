package com.obric.memorydata.infra.job;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/infra/job/JobId;", "", OaidModel.KEY_ID, "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "PREDICT_NEXT_HOUR_APP_INIT", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum JobId extends Enum<JobId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ JobId[] $VALUES = null;
    public static final JobId PREDICT_NEXT_HOUR_APP_INIT = null;
    private final int id;

    private static final /* synthetic */ JobId[] $values() {
        return new JobId[]{PREDICT_NEXT_HOUR_APP_INIT};
    }

    static {
        PREDICT_NEXT_HOUR_APP_INIT = new JobId("PREDICT_NEXT_HOUR_APP_INIT", 0, 1);
        JobId[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private JobId(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }

    public static EnumEntries<JobId> getEntries() {
        return $ENTRIES;
    }

    public static JobId valueOf(String r2) {
        return (JobId) ZeusTransformUtils.preCheckCast(Enum.valueOf(JobId.class, r2), JobId.class, "com.obric.memorydata.plugin");
    }

    public static JobId[] values() {
        return (JobId[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JobId[].class, "com.obric.memorydata.plugin");
    }

    public final int getId() {
        return this.id;
    }
}
