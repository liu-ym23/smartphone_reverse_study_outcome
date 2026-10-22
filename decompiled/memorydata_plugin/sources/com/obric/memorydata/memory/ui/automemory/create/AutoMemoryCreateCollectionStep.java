package com.obric.memorydata.memory.ui.automemory.create;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionStep;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "EDIT_INFO", "AI_OPTIMIZING", "GENERATE_RECOMMEND_APP", "CLOSE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AutoMemoryCreateCollectionStep extends Enum<AutoMemoryCreateCollectionStep> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMemoryCreateCollectionStep[] $VALUES = null;
    public static final AutoMemoryCreateCollectionStep AI_OPTIMIZING = null;
    public static final AutoMemoryCreateCollectionStep CLOSE = null;
    public static final AutoMemoryCreateCollectionStep EDIT_INFO = null;
    public static final AutoMemoryCreateCollectionStep GENERATE_RECOMMEND_APP = null;
    private final int code;

    private static final /* synthetic */ AutoMemoryCreateCollectionStep[] $values() {
        return new AutoMemoryCreateCollectionStep[]{EDIT_INFO, AI_OPTIMIZING, GENERATE_RECOMMEND_APP, CLOSE};
    }

    static {
        EDIT_INFO = new AutoMemoryCreateCollectionStep("EDIT_INFO", 0, 0);
        AI_OPTIMIZING = new AutoMemoryCreateCollectionStep("AI_OPTIMIZING", 1, 1);
        GENERATE_RECOMMEND_APP = new AutoMemoryCreateCollectionStep("GENERATE_RECOMMEND_APP", 2, 2);
        CLOSE = new AutoMemoryCreateCollectionStep("CLOSE", 3, 5);
        AutoMemoryCreateCollectionStep[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AutoMemoryCreateCollectionStep(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static EnumEntries<AutoMemoryCreateCollectionStep> getEntries() {
        return $ENTRIES;
    }

    public static AutoMemoryCreateCollectionStep valueOf(String r2) {
        return (AutoMemoryCreateCollectionStep) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoMemoryCreateCollectionStep.class, r2), AutoMemoryCreateCollectionStep.class, "com.obric.memorydata.plugin");
    }

    public static AutoMemoryCreateCollectionStep[] values() {
        return (AutoMemoryCreateCollectionStep[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoMemoryCreateCollectionStep[].class, "com.obric.memorydata.plugin");
    }

    public final int getCode() {
        return this.code;
    }
}
