package com.obric.cae.libs.useraware;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ParamPacker {
    public static final int TOTAL_LENGTH = 54;

    public ParamPacker() {
    }

    public static byte[] pack(HarMonitorParams r8) {
        if (r8 != null) goto L5;
    L16:
        return null;
    L5:
        if (ParamsValidator.validate(r8) == false) goto L16;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(54);
        DataOutputStream r11 = new DataOutputStream(r10);
        r11.writeInt(r8.stateVoteWindowSize);     // Catch: IOException -> L17
        r11.writeInt(r8.walkingContinuousThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.runningContinuousThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.accelOccurrenceThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.stationaryOccurrenceThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.accStateDurationThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.accStateMonitorWindow);     // Catch: IOException -> L17
        r11.writeInt(r8.accStateDurationThreshold2);     // Catch: IOException -> L17
        r11.writeInt(r8.runningStateDurationThreshold);     // Catch: IOException -> L17
        r11.writeInt(r8.runningStateMonitorWindow);     // Catch: IOException -> L17
        r11.writeInt(r8.runningStateDurationThreshold2);     // Catch: IOException -> L17
        byte[] r12 = r10.toByteArray();     // Catch: IOException -> L17
        if (r12.length == 52) goto L11;
        return null;
    L11:
        int r13 = Math.min(r12.length, 52);     // Catch: IOException -> L17
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r14 >= r13) goto L14;
        r15 = r15 + (r12[r14] & 255);     // Catch: IOException -> L17
        r14 = r14 + 1;     // Catch: IOException -> L17
        goto L12
    L14:
        r11.writeShort((short) (65535 & r15));     // Catch: IOException -> L17
        return r10.toByteArray();
    }
}
