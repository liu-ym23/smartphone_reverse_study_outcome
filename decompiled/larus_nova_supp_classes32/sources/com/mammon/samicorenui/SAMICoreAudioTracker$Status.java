package com.mammon.samicorenui;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreAudioTracker$Status extends Enum<SAMICoreAudioTracker$Status> {
    public static final SAMICoreAudioTracker$Status STATUS_NO_READY = null;
    public static final SAMICoreAudioTracker$Status STATUS_READY = null;
    public static final SAMICoreAudioTracker$Status STATUS_START = null;
    public static final SAMICoreAudioTracker$Status STATUS_STOP = null;
    public static final /* synthetic */ SAMICoreAudioTracker$Status[] a = null;

    static {
        SAMICoreAudioTracker$Status r0 = new SAMICoreAudioTracker$Status("STATUS_NO_READY", 0);
        STATUS_NO_READY = r0;
        SAMICoreAudioTracker$Status r1 = new SAMICoreAudioTracker$Status("STATUS_READY", 1);
        STATUS_READY = r1;
        SAMICoreAudioTracker$Status r3 = new SAMICoreAudioTracker$Status("STATUS_START", 2);
        STATUS_START = r3;
        SAMICoreAudioTracker$Status r5 = new SAMICoreAudioTracker$Status("STATUS_STOP", 3);
        STATUS_STOP = r5;
        a = new SAMICoreAudioTracker$Status[]{r0, r1, r3, r5};
    }

    public static SAMICoreAudioTracker$Status[] values() {
        return (SAMICoreAudioTracker$Status[]) a.clone();
    }

    public static SAMICoreAudioTracker$Status valueOf(String r1) {
        return (SAMICoreAudioTracker$Status) a.a(SAMICoreAudioTracker$Status.class, r1);
    }

    public SAMICoreAudioTracker$Status(String r1, int r2) {
        super(r1, r2);
    }
}
