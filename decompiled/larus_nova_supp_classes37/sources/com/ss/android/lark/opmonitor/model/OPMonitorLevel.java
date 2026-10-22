package com.ss.android.lark.opmonitor.model;

import com.ss.android.lark.passport.base.core.log.LevelTypes;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OPMonitorLevel extends Enum<OPMonitorLevel> {
    private static final /* synthetic */ OPMonitorLevel[] $VALUES = null;
    public static final OPMonitorLevel ERROR = null;
    public static final OPMonitorLevel FATAL = null;
    public static final OPMonitorLevel NORMAL = null;
    public static final OPMonitorLevel TRACE = null;
    public static final OPMonitorLevel UNKNOWN = null;
    public static final OPMonitorLevel WARN = null;
    private final int value;

    static {
        OPMonitorLevel r0 = new OPMonitorLevel("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        OPMonitorLevel r1 = new OPMonitorLevel("TRACE", 1, 1);
        TRACE = r1;
        OPMonitorLevel r3 = new OPMonitorLevel("NORMAL", 2, 2);
        NORMAL = r3;
        OPMonitorLevel r5 = new OPMonitorLevel(LevelTypes.TYPE_WARN, 3, 3);
        WARN = r5;
        OPMonitorLevel r7 = new OPMonitorLevel(LevelTypes.TYPE_ERROR, 4, 4);
        ERROR = r7;
        OPMonitorLevel r9 = new OPMonitorLevel("FATAL", 5, 5);
        FATAL = r9;
        $VALUES = new OPMonitorLevel[]{r0, r1, r3, r5, r7, r9};
    }

    public static OPMonitorLevel[] values() {
        return (OPMonitorLevel[]) $VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static OPMonitorLevel forNumber(int r1) {
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L17;
        if (r1 == 5) goto L15;
        return UNKNOWN;
    L15:
        return FATAL;
    L17:
        return ERROR;
    L19:
        return WARN;
    L21:
        return NORMAL;
    L23:
        return TRACE;
    }

    public static OPMonitorLevel valueOf(String r1) {
        return (OPMonitorLevel) a.a(OPMonitorLevel.class, r1);
    }

    private OPMonitorLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
