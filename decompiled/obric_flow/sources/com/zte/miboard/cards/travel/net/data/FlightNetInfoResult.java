package com.zte.miboard.cards.travel.net.data;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class FlightNetInfoResult {
    public int code;
    public ArrayList<FlightReqAndResult> flights;
    private Boolean registered;
    public String resultMessage;
    public long time;

    public static class FlightReqAndResult {
        public FlightReq req;
        public FlightResult result;

        public FlightReqAndResult() {
        }
    }

    public FlightNetInfoResult() {
        this.registered = null;
    }

    public boolean isAvailable() {
        if (this.code == 0) goto L5;
    L11:
        return false;
    L5:
        if (this.time <= 0) goto L11;
        ArrayList<FlightReqAndResult> r5 = this.flights;
        if (r5 == null) goto L11;
        if (r5.isEmpty() == true) goto L11;
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
        StringBuilder r5 = new StringBuilder("FlightNetInfoResult{code=");
        r5.append(this.code);
        r5.append(", resultMessage=");
        r5.append(this.resultMessage);
        r5.append(", registered=");
        r5.append(this.registered);
        r5.append(", flights=");
        ArrayList<FlightReqAndResult> r10 = this.flights;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.size());
    L6:
        r5.append(r11);
        r5.append("}");
        return r5.toString();
    L5:
        r11 = null;
        goto L6
    }
}
