package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MeetingAICapability extends Enum<MeetingAICapability> implements WireEnum {
    private static final /* synthetic */ MeetingAICapability[] $VALUES = null;
    public static final ProtoAdapter<MeetingAICapability> ADAPTER = null;
    public static final MeetingAICapability AI_Chat = null;
    public static final MeetingAICapability Unknown_Capability = null;
    private final int value;

    static {
        MeetingAICapability r0 = new MeetingAICapability("Unknown_Capability", 0, 0);
        Unknown_Capability = r0;
        MeetingAICapability r1 = new MeetingAICapability("AI_Chat", 1, 1);
        AI_Chat = r1;
        $VALUES = new MeetingAICapability[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(MeetingAICapability.class);
    }

    public static MeetingAICapability[] values() {
        return (MeetingAICapability[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MeetingAICapability fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return AI_Chat;
    L10:
        return Unknown_Capability;
    }

    public static MeetingAICapability valueOf(String r1) {
        return (MeetingAICapability) a.a(MeetingAICapability.class, r1);
    }

    private MeetingAICapability(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
