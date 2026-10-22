package com.obric.audio.continuous_talk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkEndType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TIMEOUT", "INTERRUPT", "MANUAL", "RESTART", "DESTROY", "STOP", "PAUSE", "OTHER", "NETWORK_ERROR", "MEDIA_INTERRUPT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricContinuousTalkEndType extends Enum<ObricContinuousTalkEndType> {
    public static final ObricContinuousTalkEndType DESTROY = null;
    public static final ObricContinuousTalkEndType INTERRUPT = null;
    public static final ObricContinuousTalkEndType MANUAL = null;
    public static final ObricContinuousTalkEndType MEDIA_INTERRUPT = null;
    public static final ObricContinuousTalkEndType NETWORK_ERROR = null;
    public static final ObricContinuousTalkEndType OTHER = null;
    public static final ObricContinuousTalkEndType PAUSE = null;
    public static final ObricContinuousTalkEndType RESTART = null;
    public static final ObricContinuousTalkEndType STOP = null;
    public static final ObricContinuousTalkEndType TIMEOUT = null;
    public static final /* synthetic */ ObricContinuousTalkEndType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ObricContinuousTalkEndType> getEntries() {
        return b;
    }

    static {
        ObricContinuousTalkEndType r0 = new ObricContinuousTalkEndType("TIMEOUT", 0);
        TIMEOUT = r0;
        ObricContinuousTalkEndType r1 = new ObricContinuousTalkEndType("INTERRUPT", 1);
        INTERRUPT = r1;
        ObricContinuousTalkEndType r3 = new ObricContinuousTalkEndType("MANUAL", 2);
        MANUAL = r3;
        ObricContinuousTalkEndType r5 = new ObricContinuousTalkEndType("RESTART", 3);
        RESTART = r5;
        ObricContinuousTalkEndType r7 = new ObricContinuousTalkEndType("DESTROY", 4);
        DESTROY = r7;
        ObricContinuousTalkEndType r9 = new ObricContinuousTalkEndType("STOP", 5);
        STOP = r9;
        ObricContinuousTalkEndType r11 = new ObricContinuousTalkEndType("PAUSE", 6);
        PAUSE = r11;
        ObricContinuousTalkEndType r13 = new ObricContinuousTalkEndType("OTHER", 7);
        OTHER = r13;
        ObricContinuousTalkEndType r15 = new ObricContinuousTalkEndType("NETWORK_ERROR", 8);
        NETWORK_ERROR = r15;
        ObricContinuousTalkEndType r14 = new ObricContinuousTalkEndType("MEDIA_INTERRUPT", 9);
        MEDIA_INTERRUPT = r14;
        ObricContinuousTalkEndType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ObricContinuousTalkEndType[] values() {
        return (ObricContinuousTalkEndType[]) a.clone();
    }

    public static ObricContinuousTalkEndType valueOf(String r1) {
        return (ObricContinuousTalkEndType) r27.a.a(ObricContinuousTalkEndType.class, r1);
    }

    public ObricContinuousTalkEndType(String r1, int r2) {
        super(r1, r2);
    }
}
