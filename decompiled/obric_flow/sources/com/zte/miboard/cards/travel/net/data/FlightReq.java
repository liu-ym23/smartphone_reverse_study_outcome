package com.zte.miboard.cards.travel.net.data;

import ai.j0;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.s0;
import com.zte.miboard.cards.travel.data.FlightData;

/* JADX INFO: loaded from: classes3.dex */
public class FlightReq {
    public String fromStation;
    public String fromTime;
    private Boolean registered;
    public String toStation;
    public String toTime;
    public String travelDate;
    public String travelNumber;

    public FlightReq(@NonNull FlightData r5) {
        this.registered = null;
        this.travelDate = r5.travelDate;
        this.travelNumber = r5.travelNumber;
        r5.updateFlightReq(this);
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if ((r5 instanceof FlightReq) == false) goto L26;
        FlightReq r10 = (FlightReq) r5;
        String r11 = this.travelDate;
        String r12 = r10.travelDate;
        boolean r13 = s0.f1083a;
        if (r11 != null) goto L12;
        if (r11 != r12) goto L11;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L24;
        String r15 = this.travelNumber;
        String r16 = r10.travelNumber;
        if (r15 != null) goto L19;
        if (r15 != r16) goto L18;
        boolean r17 = true;
    L20:
        if (r17 == true) goto L22;
        return false;
    L22:
        return true;
    L18:
        r17 = false;
        goto L20
    L19:
        r17 = r15.equals(r16);
        goto L20
    L24:
        return false;
    L11:
        r14 = false;
        goto L13
    L12:
        r14 = r11.equals(r12);
        goto L13
    L26:
        return false;
    }

    public boolean isAvailable() {
        if (TextUtils.isEmpty(this.travelDate) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.travelNumber) == true) goto L7;
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

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder("FlightReq{travelDate=");
        r5.append(this.travelDate);
        r5.append(", travelNumber=");
        r5.append(this.travelNumber);
        r5.append(", registered=");
        r5.append(this.registered);
        r5.append(", fromTime=");
        r5.append(this.fromTime);
        r5.append(", toTime=");
        r5.append(this.toTime);
        r5.append(", fromStation=");
        r5.append(this.fromStation);
        r5.append(" toStation=");
        return j0.q(r5, this.toStation, "}");
    }
}
