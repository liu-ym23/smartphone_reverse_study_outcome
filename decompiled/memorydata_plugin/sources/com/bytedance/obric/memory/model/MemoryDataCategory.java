package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum MemoryDataCategory extends Enum<MemoryDataCategory> {
    private static final /* synthetic */ MemoryDataCategory[] $VALUES = null;

    @SerializedName("2")
    public static final MemoryDataCategory CommonlyMessage = null;

    @SerializedName("4")
    public static final MemoryDataCategory LongTermMemory = null;

    @SerializedName("0")
    public static final MemoryDataCategory ShortTermMemory = null;

    @SerializedName("1")
    public static final MemoryDataCategory UserPortrait = null;

    @SerializedName("3")
    public static final MemoryDataCategory UserPreferences = null;

    @SerializedName("5")
    public static final MemoryDataCategory UserTodo = null;
    private final int value;

    static {
        MemoryDataCategory r0 = new MemoryDataCategory("ShortTermMemory", 0, 0);
        ShortTermMemory = r0;
        MemoryDataCategory r1 = new MemoryDataCategory("UserPortrait", 1, 1);
        UserPortrait = r1;
        MemoryDataCategory r3 = new MemoryDataCategory("CommonlyMessage", 2, 2);
        CommonlyMessage = r3;
        MemoryDataCategory r5 = new MemoryDataCategory("UserPreferences", 3, 3);
        UserPreferences = r5;
        MemoryDataCategory r7 = new MemoryDataCategory("LongTermMemory", 4, 4);
        LongTermMemory = r7;
        MemoryDataCategory r9 = new MemoryDataCategory("UserTodo", 5, 5);
        UserTodo = r9;
        $VALUES = new MemoryDataCategory[]{r0, r1, r3, r5, r7, r9};
    }

    private MemoryDataCategory(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static MemoryDataCategory findByValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return UserTodo;
    L18:
        return LongTermMemory;
    L20:
        return UserPreferences;
    L22:
        return CommonlyMessage;
    L24:
        return UserPortrait;
    L26:
        return ShortTermMemory;
    }

    public static MemoryDataCategory valueOf(String r2) {
        return (MemoryDataCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryDataCategory.class, r2), MemoryDataCategory.class, "com.obric.memorydata.plugin");
    }

    public static MemoryDataCategory[] values() {
        return (MemoryDataCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryDataCategory[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
