package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: classes.dex */
public final class ParamsValidator {
    public ParamsValidator() {
    }

    public static boolean validate(HarMonitorParams r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.stateVoteWindowSize > 0) goto L9;
        return false;
    L9:
        if (r8.accStateMonitorWindow > 0) goto L11;
    L15:
        return false;
    L11:
        if (r8.runningStateMonitorWindow <= 0) goto L15;
        return true;
    }
}
