package com.bytedance.rpc.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum ChatEvent extends Enum<ChatEvent> {
    private static final /* synthetic */ ChatEvent[] $VALUES = null;

    @SerializedName("3")
    public static final ChatEvent Cancel = null;

    @SerializedName("5")
    public static final ChatEvent Continue = null;

    @SerializedName("7")
    public static final ChatEvent CreateSession = null;

    @SerializedName("2")
    public static final ChatEvent End = null;

    @SerializedName("6")
    public static final ChatEvent IntentResult = null;

    @SerializedName("4")
    public static final ChatEvent PreQuery = null;

    @SerializedName("1")
    public static final ChatEvent Query = null;
    private final int value;

    static {
        ChatEvent r0 = new ChatEvent("Query", 0, 1);
        Query = r0;
        ChatEvent r1 = new ChatEvent("End", 1, 2);
        End = r1;
        ChatEvent r4 = new ChatEvent("Cancel", 2, 3);
        Cancel = r4;
        ChatEvent r6 = new ChatEvent("PreQuery", 3, 4);
        PreQuery = r6;
        ChatEvent r8 = new ChatEvent("Continue", 4, 5);
        Continue = r8;
        ChatEvent r10 = new ChatEvent("IntentResult", 5, 6);
        IntentResult = r10;
        ChatEvent r12 = new ChatEvent("CreateSession", 6, 7);
        CreateSession = r12;
        $VALUES = new ChatEvent[]{r0, r1, r4, r6, r8, r10, r12};
    }

    private ChatEvent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static ChatEvent findByValue(int r0) {
        switch(r0) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CreateSession;
    L8:
        return IntentResult;
    L10:
        return Continue;
    L12:
        return PreQuery;
    L14:
        return Cancel;
    L16:
        return End;
    L18:
        return Query;
    }

    public static ChatEvent valueOf(String r2) {
        return (ChatEvent) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChatEvent.class, r2), ChatEvent.class, "com.obric.memorydata.plugin");
    }

    public static ChatEvent[] values() {
        return (ChatEvent[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChatEvent[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
