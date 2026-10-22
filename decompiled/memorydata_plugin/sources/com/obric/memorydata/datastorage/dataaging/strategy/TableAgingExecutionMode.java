package com.obric.memorydata.datastorage.dataaging.strategy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingExecutionMode;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE_ROWS", "CALLBACK_ONLY", "DELETE_HANDLER", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TableAgingExecutionMode extends Enum<TableAgingExecutionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TableAgingExecutionMode[] $VALUES = null;
    public static final TableAgingExecutionMode CALLBACK_ONLY = null;
    public static final TableAgingExecutionMode DELETE_HANDLER = null;
    public static final TableAgingExecutionMode DELETE_ROWS = null;

    private static final /* synthetic */ TableAgingExecutionMode[] $values() {
        return new TableAgingExecutionMode[]{DELETE_ROWS, CALLBACK_ONLY, DELETE_HANDLER};
    }

    static {
        DELETE_ROWS = new TableAgingExecutionMode("DELETE_ROWS", 0);
        CALLBACK_ONLY = new TableAgingExecutionMode("CALLBACK_ONLY", 1);
        DELETE_HANDLER = new TableAgingExecutionMode("DELETE_HANDLER", 2);
        TableAgingExecutionMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private TableAgingExecutionMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<TableAgingExecutionMode> getEntries() {
        return $ENTRIES;
    }

    public static TableAgingExecutionMode valueOf(String r2) {
        return (TableAgingExecutionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(TableAgingExecutionMode.class, r2), TableAgingExecutionMode.class, "com.obric.memorydata.plugin");
    }

    public static TableAgingExecutionMode[] values() {
        return (TableAgingExecutionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TableAgingExecutionMode[].class, "com.obric.memorydata.plugin");
    }
}
