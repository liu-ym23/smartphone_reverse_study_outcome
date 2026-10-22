package com.zte.miboard.cards.travel.data;

import android.text.TextUtils;
import c.m;

/* JADX INFO: loaded from: classes3.dex */
public class TrainData extends TravelData {
    private String trainCarriageNumber;
    private String trainSeatNumber;
    private String trainTicketCheck;

    public TrainData() {
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getShowToString() {
        return ", fromStation=" + getFromStation() + ", toStation=" + getToStation() + ", trainCarriageNumber=" + this.trainCarriageNumber + ", trainSeatNumber=" + this.trainSeatNumber;
    }

    public String getTrainCarriageNumber() {
        if (TextUtils.isEmpty(this.trainCarriageNumber) == false) goto L7;
        return "";
    L7:
        return this.trainCarriageNumber;
    }

    public String getTrainSeatNumber() {
        if (TextUtils.isEmpty(this.trainSeatNumber) == false) goto L7;
        return "";
    L7:
        return this.trainSeatNumber;
    }

    public String getTrainTicketCheck() {
        if (TextUtils.isEmpty(this.trainTicketCheck) == false) goto L7;
        return "";
    L7:
        return this.trainTicketCheck;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public boolean isAvailable() {
        boolean r5 = super.isAvailable();
        if (r5 == false) goto L9;
        boolean r10 = TextUtils.isEmpty(getFromStation());
        boolean r11 = !r10;
        if (r10 == false) goto L8;
        m.l(TravelData.TAG, "isAvailable false fromStation or toStation error, fromStation=" + getFromStation() + " toStation=" + getToStation() + " this=" + this);
    L8:
        return r11;
    L9:
        return r5;
    }
}
