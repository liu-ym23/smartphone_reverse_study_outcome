package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ActionType extends Enum<ActionType> {
    private static final /* synthetic */ ActionType[] $VALUES = null;

    @SerializedName("5")
    public static final ActionType AI_Feed = null;

    @SerializedName("4")
    public static final ActionType Card = null;

    @SerializedName("2")
    public static final ActionType Proactive_Dialogue = null;

    @SerializedName("3")
    public static final ActionType Push = null;

    @SerializedName("1")
    public static final ActionType Text = null;
    private final int value;

    static {
        ActionType r0 = new ActionType("Text", 0, 1);
        Text = r0;
        ActionType r1 = new ActionType("Proactive_Dialogue", 1, 2);
        Proactive_Dialogue = r1;
        ActionType r4 = new ActionType("Push", 2, 3);
        Push = r4;
        ActionType r6 = new ActionType("Card", 3, 4);
        Card = r6;
        ActionType r8 = new ActionType("AI_Feed", 4, 5);
        AI_Feed = r8;
        $VALUES = new ActionType[]{r0, r1, r4, r6, r8};
    }

    private ActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ActionType findByValue(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return null;
    L15:
        return AI_Feed;
    L17:
        return Card;
    L19:
        return Push;
    L21:
        return Proactive_Dialogue;
    L23:
        return Text;
    }

    public static ActionType valueOf(String r2) {
        return (ActionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ActionType.class, r2), ActionType.class, "com.obric.memorydata.plugin");
    }

    public static ActionType[] values() {
        return (ActionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ActionType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
