package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreVopSpeakerInfoCommand extends Enum<SAMICoreVopSpeakerInfoCommand> {
    private static final /* synthetic */ SAMICoreVopSpeakerInfoCommand[] $VALUES = null;
    public static final SAMICoreVopSpeakerInfoCommand BIND_VOICE = null;
    public static final SAMICoreVopSpeakerInfoCommand DELETE = null;
    public static final SAMICoreVopSpeakerInfoCommand DISCARD_VOICE = null;
    public static final SAMICoreVopSpeakerInfoCommand SET_PRIVATE = null;
    public static final SAMICoreVopSpeakerInfoCommand SET_PUBLIC = null;
    public static final SAMICoreVopSpeakerInfoCommand SIGN_AGREEMENT = null;
    public static final SAMICoreVopSpeakerInfoCommand START_BUILD_TASK = null;
    public static final SAMICoreVopSpeakerInfoCommand START_RECORD_TASK = null;
    private int value;

    static {
        SAMICoreVopSpeakerInfoCommand r0 = new SAMICoreVopSpeakerInfoCommand("SIGN_AGREEMENT", 0, 0);
        SIGN_AGREEMENT = r0;
        SAMICoreVopSpeakerInfoCommand r1 = new SAMICoreVopSpeakerInfoCommand("START_RECORD_TASK", 1, 1);
        START_RECORD_TASK = r1;
        SAMICoreVopSpeakerInfoCommand r3 = new SAMICoreVopSpeakerInfoCommand("START_BUILD_TASK", 2, 2);
        START_BUILD_TASK = r3;
        SAMICoreVopSpeakerInfoCommand r5 = new SAMICoreVopSpeakerInfoCommand("SET_PUBLIC", 3, 3);
        SET_PUBLIC = r5;
        SAMICoreVopSpeakerInfoCommand r7 = new SAMICoreVopSpeakerInfoCommand("SET_PRIVATE", 4, 4);
        SET_PRIVATE = r7;
        SAMICoreVopSpeakerInfoCommand r9 = new SAMICoreVopSpeakerInfoCommand("DELETE", 5, 5);
        DELETE = r9;
        SAMICoreVopSpeakerInfoCommand r11 = new SAMICoreVopSpeakerInfoCommand("BIND_VOICE", 6, 6);
        BIND_VOICE = r11;
        SAMICoreVopSpeakerInfoCommand r13 = new SAMICoreVopSpeakerInfoCommand("DISCARD_VOICE", 7, 7);
        DISCARD_VOICE = r13;
        $VALUES = new SAMICoreVopSpeakerInfoCommand[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static SAMICoreVopSpeakerInfoCommand[] values() {
        return (SAMICoreVopSpeakerInfoCommand[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopSpeakerInfoCommand valueOf(String r1) {
        return (SAMICoreVopSpeakerInfoCommand) a.a(SAMICoreVopSpeakerInfoCommand.class, r1);
    }

    private SAMICoreVopSpeakerInfoCommand(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
