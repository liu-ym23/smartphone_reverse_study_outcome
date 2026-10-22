package com.zte.miboard.recommend.agent.data;

import ai.j0;
import m.g;

/* JADX INFO: loaded from: classes3.dex */
public class TrainData extends TravelData {
    public String trainCarriageNumber;
    public String trainSeatNumber;

    public TrainData(String r5, String r10, String r11, String r12, String r13, String r14) {
        super(r5, r10, r11, r12, r13, r14);
    }

    public static TrainData parseToTrainData(String r10, String r11, String r12, String r13, String r14, String r15) {
        String r5 = g.d(r11);
        String r16 = g.d(r12);
        if (r11 != null) goto L5;
    L12:
        String r17 = "";
    L13:
        if (r12 != null) goto L15;
    L22:
        String r18 = "";
    L24:
        return new TrainData(r10, g.b(r15), r5, r13, r14, r17, r18);
    L15:
        if (r12.isEmpty() == true) goto L22;
        String r19 = g.c(r12);
        if (r19 != null) goto L19;
    L21:
        r18 = r16;
        goto L24
    L19:
        if (r19.isEmpty() == true) goto L21;
        r18 = j0.D(r16, " ", r19);
        goto L24
    L5:
        if (r11.isEmpty() == true) goto L12;
        String r20 = g.c(r11);
        if (r20 != null) goto L9;
    L11:
        r17 = r5;
        goto L13
    L9:
        if (r20.isEmpty() == true) goto L11;
        r17 = j0.D(r5, " ", r20);
        goto L13
    }

    public TrainData(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
        super(r5, r10, r11, r12, r13, r14, r15);
    }

    public TrainData(String r5, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        super(r5, r10, r11, r12, r13, r14, r15);
        this.trainCarriageNumber = r16;
        this.trainSeatNumber = r17;
    }

    public static TrainData parseToTrainData(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18) {
        String r5 = g.d(r12);
        String r10 = g.d(r13);
        if (r12 != null) goto L5;
    L12:
        String r19 = "";
    L13:
        if (r13 != null) goto L15;
    L22:
        String r20 = "";
    L24:
        return new TrainData(r11, g.b(r16), r5, r14, r15, r19, r20, r17, r18);
    L15:
        if (r13.isEmpty() == true) goto L22;
        String r21 = g.c(r13);
        if (r21 != null) goto L19;
    L21:
        r20 = r10;
        goto L24
    L19:
        if (r21.isEmpty() == true) goto L21;
        r10 = j0.D(r10, " ", r21);
        goto L21
    L5:
        if (r12.isEmpty() == true) goto L12;
        String r22 = g.c(r12);
        if (r22 != null) goto L9;
    L11:
        r19 = r5;
        goto L13
    L9:
        if (r22.isEmpty() == true) goto L11;
        r19 = j0.D(r5, " ", r22);
        goto L13
    }
}
