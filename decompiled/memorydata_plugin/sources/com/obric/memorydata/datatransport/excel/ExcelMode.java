package com.obric.memorydata.datatransport.excel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelMode;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "getMode", "()I", "DEFAULT", "WHOLE_TABLE", "PARTITIONED_TABLE", "SLM_FINETUNE", "WHOLE_TABLE_ACCESSIBILITY", "EVALUATION_PERSONAL_CONTEXT_OLD", "EVALUATION_PERSONAL_CONTEXT_EXTEND", "EVALUATION_PERSONAL_CONTEXT", "EVALUATION_PERSONAL_CONTEXT_DB_DATASET", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExcelMode extends Enum<ExcelMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExcelMode[] $VALUES = null;
    public static final ExcelMode DEFAULT = null;
    public static final ExcelMode EVALUATION_PERSONAL_CONTEXT = null;
    public static final ExcelMode EVALUATION_PERSONAL_CONTEXT_DB_DATASET = null;
    public static final ExcelMode EVALUATION_PERSONAL_CONTEXT_EXTEND = null;
    public static final ExcelMode EVALUATION_PERSONAL_CONTEXT_OLD = null;
    public static final ExcelMode PARTITIONED_TABLE = null;
    public static final ExcelMode SLM_FINETUNE = null;
    public static final ExcelMode WHOLE_TABLE = null;
    public static final ExcelMode WHOLE_TABLE_ACCESSIBILITY = null;
    private final int mode;

    private static final /* synthetic */ ExcelMode[] $values() {
        return new ExcelMode[]{DEFAULT, WHOLE_TABLE, PARTITIONED_TABLE, SLM_FINETUNE, WHOLE_TABLE_ACCESSIBILITY, EVALUATION_PERSONAL_CONTEXT_OLD, EVALUATION_PERSONAL_CONTEXT_EXTEND, EVALUATION_PERSONAL_CONTEXT, EVALUATION_PERSONAL_CONTEXT_DB_DATASET};
    }

    static {
        DEFAULT = new ExcelMode("DEFAULT", 0, 0);
        WHOLE_TABLE = new ExcelMode("WHOLE_TABLE", 1, 1);
        PARTITIONED_TABLE = new ExcelMode("PARTITIONED_TABLE", 2, 2);
        SLM_FINETUNE = new ExcelMode("SLM_FINETUNE", 3, 3);
        WHOLE_TABLE_ACCESSIBILITY = new ExcelMode("WHOLE_TABLE_ACCESSIBILITY", 4, 4);
        EVALUATION_PERSONAL_CONTEXT_OLD = new ExcelMode("EVALUATION_PERSONAL_CONTEXT_OLD", 5, 5);
        EVALUATION_PERSONAL_CONTEXT_EXTEND = new ExcelMode("EVALUATION_PERSONAL_CONTEXT_EXTEND", 6, 6);
        EVALUATION_PERSONAL_CONTEXT = new ExcelMode("EVALUATION_PERSONAL_CONTEXT", 7, 7);
        EVALUATION_PERSONAL_CONTEXT_DB_DATASET = new ExcelMode("EVALUATION_PERSONAL_CONTEXT_DB_DATASET", 8, 8);
        ExcelMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ExcelMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mode = r3;
    }

    public static EnumEntries<ExcelMode> getEntries() {
        return $ENTRIES;
    }

    public static ExcelMode valueOf(String r2) {
        return (ExcelMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExcelMode.class, r2), ExcelMode.class, "com.obric.memorydata.plugin");
    }

    public static ExcelMode[] values() {
        return (ExcelMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExcelMode[].class, "com.obric.memorydata.plugin");
    }

    public final int getMode() {
        return this.mode;
    }
}
