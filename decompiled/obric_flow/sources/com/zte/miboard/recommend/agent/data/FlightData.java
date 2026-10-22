package com.zte.miboard.recommend.agent.data;

import ai.j0;
import m.g;

/* JADX INFO: loaded from: classes3.dex */
public class FlightData extends TravelData {
    public String AlternateArrAirport;
    public String AlternateArrCity;
    public String AlternateArrtime;
    public String AlternateArrtimePlan;
    public String AlternateDepAirport;
    public String AlternateDepCity;
    public String AlternateDeptime;
    public String AlternateDeptimePlan;
    public String AlternateStatus;
    public String BaggageID;
    public String BoardGate;
    public String CheckinTable;
    public String FlightArr;
    public String FlightArrAirport;
    public String FlightArrcode;
    public String FlightArrtimeDate;
    public String FlightArrtimePlanDate;
    public String FlightArrtimeReadyDate;
    public String FlightCompany;
    public String FlightDep;
    public String FlightDepAirport;
    public String FlightDepcode;
    public String FlightDeptimeDate;
    public String FlightDeptimePlanDate;
    public String FlightDeptimeReadyDate;
    public String FlightHTerminal;
    public String FlightNo;
    public String FlightState;
    public String FlightTerminal;
    public String FlightYear;
    public String ReachExit;
    public String StopAirportCode;
    public String StopCity;
    public String dst_timezone;
    public String fcategory;
    public String generic;
    public String org_timezone;

    public FlightData(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
        super(r5, r10, r11, r12, r13, r14, r15);
    }

    public static FlightData parseToFlightData(String r10, String r11, String r12, String r13, String r14, String r15) {
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
        return new FlightData(r10, g.b(r15), r5, r13, r14, r17, r18);
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
}
