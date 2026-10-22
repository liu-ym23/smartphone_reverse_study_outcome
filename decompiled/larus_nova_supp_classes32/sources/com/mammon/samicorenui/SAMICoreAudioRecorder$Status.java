package com.mammon.samicorenui;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreAudioRecorder$Status extends Enum<SAMICoreAudioRecorder$Status> {
    public static final SAMICoreAudioRecorder$Status STATUS_NO_READY = null;
    public static final SAMICoreAudioRecorder$Status STATUS_PAUSE = null;
    public static final SAMICoreAudioRecorder$Status STATUS_READY = null;
    public static final SAMICoreAudioRecorder$Status STATUS_START = null;
    public static final SAMICoreAudioRecorder$Status STATUS_STOP = null;
    public static final /* synthetic */ SAMICoreAudioRecorder$Status[] a = null;

    static {
        SAMICoreAudioRecorder$Status r0 = new SAMICoreAudioRecorder$Status("STATUS_NO_READY", 0);
        STATUS_NO_READY = r0;
        SAMICoreAudioRecorder$Status r1 = new SAMICoreAudioRecorder$Status("STATUS_READY", 1);
        STATUS_READY = r1;
        SAMICoreAudioRecorder$Status r3 = new SAMICoreAudioRecorder$Status("STATUS_START", 2);
        STATUS_START = r3;
        SAMICoreAudioRecorder$Status r5 = new SAMICoreAudioRecorder$Status("STATUS_PAUSE", 3);
        STATUS_PAUSE = r5;
        SAMICoreAudioRecorder$Status r7 = new SAMICoreAudioRecorder$Status("STATUS_STOP", 4);
        STATUS_STOP = r7;
        a = new SAMICoreAudioRecorder$Status[]{r0, r1, r3, r5, r7};
    }

    public static SAMICoreAudioRecorder$Status[] values() {
        return (SAMICoreAudioRecorder$Status[]) a.clone();
    }

    public static SAMICoreAudioRecorder$Status valueOf(String r1) {
        return (SAMICoreAudioRecorder$Status) a.a(SAMICoreAudioRecorder$Status.class, r1);
    }

    public SAMICoreAudioRecorder$Status(String r1, int r2) {
        super(r1, r2);
    }
}
