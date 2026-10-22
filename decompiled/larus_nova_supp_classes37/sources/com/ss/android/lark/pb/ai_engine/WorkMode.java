package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum WorkMode extends Enum<WorkMode> implements WireEnum {
    private static final /* synthetic */ WorkMode[] $VALUES = null;
    public static final ProtoAdapter<WorkMode> ADAPTER = null;
    public static final WorkMode AtAIKnowledge = null;
    public static final WorkMode Chat = null;
    public static final WorkMode IMReply = null;
    public static final WorkMode Inline = null;
    public static final WorkMode Playground = null;
    public static final WorkMode UnreadRecommend = null;
    private final int value;

    static {
        WorkMode r0 = new WorkMode("Chat", 0, 1);
        Chat = r0;
        WorkMode r1 = new WorkMode("Inline", 1, 2);
        Inline = r1;
        WorkMode r4 = new WorkMode("Playground", 2, 3);
        Playground = r4;
        WorkMode r6 = new WorkMode("IMReply", 3, 4);
        IMReply = r6;
        WorkMode r8 = new WorkMode("AtAIKnowledge", 4, 5);
        AtAIKnowledge = r8;
        WorkMode r10 = new WorkMode("UnreadRecommend", 5, 6);
        UnreadRecommend = r10;
        $VALUES = new WorkMode[]{r0, r1, r4, r6, r8, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(WorkMode.class);
    }

    public static WorkMode[] values() {
        return (WorkMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WorkMode fromValue(int r0) {
        switch(r0) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return UnreadRecommend;
    L8:
        return AtAIKnowledge;
    L10:
        return IMReply;
    L12:
        return Playground;
    L14:
        return Inline;
    L16:
        return Chat;
    }

    public static WorkMode valueOf(String r1) {
        return (WorkMode) a.a(WorkMode.class, r1);
    }

    private WorkMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
