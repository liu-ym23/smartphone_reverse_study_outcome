package com.zte.miboard.cards.travel.net.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.zte.miboard.cards.travel.data.FlightData;

/* JADX INFO: loaded from: classes3.dex */
public class FlightResult extends FlightData {
    private Boolean registered;

    public FlightResult() {
        this.registered = null;
    }

    public String getTravelDate() {
        return this.depDate;
    }

    public String getTravelNumber() {
        return this.flightNo;
    }

    @Override // com.zte.miboard.cards.travel.data.FlightData, com.zte.miboard.cards.travel.data.TravelData
    public boolean isAvailable() {
        if (TextUtils.isEmpty(this.flightNo) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.depDate) == true) goto L7;
        return true;
    }

    public boolean isRegistered() {
        Boolean r5 = this.registered;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    @NonNull
    public String toString() {
        return "FlightResult{depDate=" + this.depDate + ", flightNo=" + this.flightNo + ", statusKey=" + this.statusKey + ", registered=" + this.registered + "}";
    }
}
