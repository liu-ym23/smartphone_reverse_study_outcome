package com.ss.android.lark.opmonitor.model;

import com.ss.android.lark.passport.base.core.log.LevelTypes;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum OPMonitorLogLevel extends Enum<OPMonitorLogLevel> {
    public static final OPMonitorLogLevel DEBUG = null;
    public static final OPMonitorLogLevel ERROR = null;
    public static final OPMonitorLogLevel FATAL = null;
    public static final OPMonitorLogLevel INFO = null;
    public static final OPMonitorLogLevel UNKNOWN = null;
    public static final OPMonitorLogLevel WARN = null;
    public static final /* synthetic */ OPMonitorLogLevel[] a = null;
    private final int value;

    static {
        OPMonitorLogLevel r0 = new OPMonitorLogLevel("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        OPMonitorLogLevel r1 = new OPMonitorLogLevel(LevelTypes.TYPE_DEBUG, 1, 1);
        DEBUG = r1;
        OPMonitorLogLevel r3 = new OPMonitorLogLevel(LevelTypes.TYPE_INFO, 2, 2);
        INFO = r3;
        OPMonitorLogLevel r5 = new OPMonitorLogLevel(LevelTypes.TYPE_WARN, 3, 3);
        WARN = r5;
        OPMonitorLogLevel r7 = new OPMonitorLogLevel(LevelTypes.TYPE_ERROR, 4, 4);
        ERROR = r7;
        OPMonitorLogLevel r9 = new OPMonitorLogLevel("FATAL", 5, 5);
        FATAL = r9;
        a = new OPMonitorLogLevel[]{r0, r1, r3, r5, r7, r9};
    }

    public static OPMonitorLogLevel[] values() {
        return (OPMonitorLogLevel[]) a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static OPMonitorLogLevel forNumber(int r1) {
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
        return INFO;
    L23:
        return DEBUG;
    }

    public static OPMonitorLogLevel valueOf(String r1) {
        return (OPMonitorLogLevel) a.a(OPMonitorLogLevel.class, r1);
    }

    public OPMonitorLogLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
