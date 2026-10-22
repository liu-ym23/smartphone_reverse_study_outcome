package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum MeetingAICapabilityAction extends Enum<MeetingAICapabilityAction> implements WireEnum {
    private static final /* synthetic */ MeetingAICapabilityAction[] $VALUES = null;
    public static final ProtoAdapter<MeetingAICapabilityAction> ADAPTER = null;
    public static final MeetingAICapabilityAction HOST_ACCEPT = null;
    public static final MeetingAICapabilityAction HOST_REFUSE = null;
    public static final MeetingAICapabilityAction MEETING_AI_FETCH_QUICK_ACTIONS = null;
    public static final MeetingAICapabilityAction MEETING_AI_OFF = null;
    public static final MeetingAICapabilityAction MEETING_AI_ON = null;
    public static final MeetingAICapabilityAction MEETING_AI_ON_BY_SUBTITLE = null;
    public static final MeetingAICapabilityAction MEETING_AI_PAUSE = null;
    public static final MeetingAICapabilityAction MEETING_AI_RESUME = null;
    public static final MeetingAICapabilityAction PARTICIPANT_REQUEST_OPEN = null;
    public static final MeetingAICapabilityAction Unknown_Action = null;
    private final int value;

    static {
        MeetingAICapabilityAction r0 = new MeetingAICapabilityAction("Unknown_Action", 0, 0);
        Unknown_Action = r0;
        MeetingAICapabilityAction r1 = new MeetingAICapabilityAction("HOST_ACCEPT", 1, 1);
        HOST_ACCEPT = r1;
        MeetingAICapabilityAction r3 = new MeetingAICapabilityAction("HOST_REFUSE", 2, 2);
        HOST_REFUSE = r3;
        MeetingAICapabilityAction r5 = new MeetingAICapabilityAction("PARTICIPANT_REQUEST_OPEN", 3, 3);
        PARTICIPANT_REQUEST_OPEN = r5;
        MeetingAICapabilityAction r7 = new MeetingAICapabilityAction("MEETING_AI_ON", 4, 4);
        MEETING_AI_ON = r7;
        MeetingAICapabilityAction r9 = new MeetingAICapabilityAction("MEETING_AI_OFF", 5, 5);
        MEETING_AI_OFF = r9;
        MeetingAICapabilityAction r11 = new MeetingAICapabilityAction("MEETING_AI_FETCH_QUICK_ACTIONS", 6, 6);
        MEETING_AI_FETCH_QUICK_ACTIONS = r11;
        MeetingAICapabilityAction r13 = new MeetingAICapabilityAction("MEETING_AI_ON_BY_SUBTITLE", 7, 7);
        MEETING_AI_ON_BY_SUBTITLE = r13;
        MeetingAICapabilityAction r15 = new MeetingAICapabilityAction("MEETING_AI_PAUSE", 8, 8);
        MEETING_AI_PAUSE = r15;
        MeetingAICapabilityAction r14 = new MeetingAICapabilityAction("MEETING_AI_RESUME", 9, 9);
        MEETING_AI_RESUME = r14;
        $VALUES = new MeetingAICapabilityAction[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        ADAPTER = ProtoAdapter.newEnumAdapter(MeetingAICapabilityAction.class);
    }

    public static MeetingAICapabilityAction[] values() {
        return (MeetingAICapabilityAction[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MeetingAICapabilityAction fromValue(int r0) {
        switch(r0) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MEETING_AI_RESUME;
    L8:
        return MEETING_AI_PAUSE;
    L10:
        return MEETING_AI_ON_BY_SUBTITLE;
    L12:
        return MEETING_AI_FETCH_QUICK_ACTIONS;
    L14:
        return MEETING_AI_OFF;
    L16:
        return MEETING_AI_ON;
    L18:
        return PARTICIPANT_REQUEST_OPEN;
    L20:
        return HOST_REFUSE;
    L22:
        return HOST_ACCEPT;
    L24:
        return Unknown_Action;
    }

    public static MeetingAICapabilityAction valueOf(String r1) {
        return (MeetingAICapabilityAction) a.a(MeetingAICapabilityAction.class, r1);
    }

    private MeetingAICapabilityAction(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
