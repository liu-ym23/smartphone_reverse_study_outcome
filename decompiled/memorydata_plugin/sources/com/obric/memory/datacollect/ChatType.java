package com.obric.memory.datacollect;

import com.google.gson.annotations.SerializedName;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum ChatType extends Enum<ChatType> {
    private static final /* synthetic */ ChatType[] $VALUES = null;

    @SerializedName("2")
    public static final ChatType Group = null;

    @SerializedName("0")
    public static final ChatType None = null;

    @SerializedName("1")
    public static final ChatType Private = null;
    private final int value;

    static {
        ChatType r0 = new ChatType("None", 0, 0);
        None = r0;
        ChatType r1 = new ChatType(i.l, 1, 1);
        Private = r1;
        ChatType r3 = new ChatType("Group", 2, 2);
        Group = r3;
        $VALUES = new ChatType[]{r0, r1, r3};
    }

    private ChatType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ChatType findByValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Group;
    L12:
        return Private;
    L14:
        return None;
    }

    public static ChatType valueOf(String r2) {
        return (ChatType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChatType.class, r2), ChatType.class, "com.obric.memorydata.plugin");
    }

    public static ChatType[] values() {
        return (ChatType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChatType[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
