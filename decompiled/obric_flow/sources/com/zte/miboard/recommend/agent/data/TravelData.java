package com.zte.miboard.recommend.agent.data;

import ai.j0;
import androidx.annotation.NonNull;
import java.util.Objects;
import m.g;

/* JADX INFO: loaded from: classes3.dex */
public class TravelData {
    private static final String DIMENTION_DOOR = "智能推荐";
    public String cardDetailsPageDeepLink;
    public String cardDetailsPagePkg;
    public String fromStation;
    public String fromTime;
    public String personName;
    public String planFromTime;
    public String planToTime;
    public String realFromTime;
    public String realToTime;
    public String source;
    public String toStation;
    public String toTime;
    public String trainTicketCheck;
    public String travelDate;
    public String travelNumber;
    public Long updateTimeLong;

    public static abstract class Builder<T extends Builder<T>> {
        String cardDetailsPageDeepLink;
        String cardDetailsPagePkg;
        String fromTime;
        String source;
        String toTime;
        String travelDate;
        String travelNumber;

        public Builder() {
        }

        public TravelData build() {
            return new TravelData(this);
        }

        public abstract T self();

        public T setMembers(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
            this.travelDate = r5;
            this.travelNumber = r10;
            this.source = r11;
            this.fromTime = r12;
            this.toTime = r13;
            this.cardDetailsPagePkg = r14;
            this.cardDetailsPageDeepLink = r15;
            return (T) self();
        }
    }

    public TravelData(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
        this.personName = r5;
        this.travelNumber = r10;
        this.travelDate = r11;
        this.fromStation = r12;
        this.toStation = r13;
        this.fromTime = r14;
        this.toTime = r15;
        this.source = DIMENTION_DOOR;
    }

    public static TravelData parseToTravelData(String r10, String r11, String r12, String r13, String r14, String r15) {
        String r5 = g.d(r11);
        StringBuilder r16 = j0.w(r5, " ");
        r16.append(g.c(r11));
        String r17 = r16.toString();
        StringBuilder r18 = j0.w(r5, " ");
        r18.append(g.c(r12));
        String r19 = r18.toString();
        return new TravelData(r10, g.b(r15), r5, r13, r14, r17, r19);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        TravelData r10 = (TravelData) r5;
        if (Objects.equals(this.personName, r10.personName) == false) goto L17;
        if (Objects.equals(this.travelNumber, r10.travelNumber) == false) goto L17;
        if (Objects.equals(this.travelDate, r10.travelDate) == false) goto L17;
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.personName, this.travelNumber, this.travelDate});
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("TravelData{personName='");
        r5.append(this.personName);
        r5.append("', travelNumber='");
        r5.append(this.travelNumber);
        r5.append("', travelDate='");
        r5.append(this.travelDate);
        r5.append("', toStation='");
        r5.append(this.toStation);
        r5.append("', fromStation='");
        r5.append(this.fromStation);
        r5.append("', fromTime='");
        r5.append(this.fromTime);
        r5.append("', toTime='");
        return j0.q(r5, this.toTime, "'}");
    }

    public TravelData(String r5, String r10, String r11, String r12, String r13, String r14) {
        this.travelNumber = r5;
        this.travelDate = r10;
        this.fromTime = r11;
        this.toTime = r12;
        this.fromStation = r13;
        this.toStation = r14;
        this.source = DIMENTION_DOOR;
    }

    public TravelData(String r5, String r10, String r11, String r12, String r13) {
        this.personName = r5;
        this.travelNumber = r10;
        this.travelDate = r11;
        this.fromTime = r12;
        this.toTime = r13;
        this.source = DIMENTION_DOOR;
    }

    public TravelData(Builder<?> r5) {
        this.travelDate = r5.travelDate;
        this.travelNumber = r5.travelNumber;
        this.source = r5.source;
        this.fromTime = r5.fromTime;
        this.toTime = r5.toTime;
        this.cardDetailsPagePkg = r5.cardDetailsPagePkg;
        this.cardDetailsPageDeepLink = r5.cardDetailsPageDeepLink;
    }
}
