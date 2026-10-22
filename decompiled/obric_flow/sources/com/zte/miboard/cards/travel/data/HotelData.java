package com.zte.miboard.cards.travel.data;

import android.text.TextUtils;
import c.m;

/* JADX INFO: loaded from: classes3.dex */
public class HotelData extends TravelData {
    private String hotelLocation;
    private String hotelRoomType;

    public HotelData() {
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getFromStation() {
        return getHotelLocation();
    }

    public String getHotelLocation() {
        if (TextUtils.isEmpty(this.hotelLocation) == true) goto L7;
        return this.hotelLocation;
    L7:
        if (TextUtils.isEmpty(this.travelNumber) == false) goto L9;
        return "";
    L9:
        return this.travelNumber;
    }

    public String getHotelRoomType() {
        if (TextUtils.isEmpty(this.hotelRoomType) == false) goto L7;
        return "";
    L7:
        return this.hotelRoomType;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getShowToString() {
        return ", hotelRoomType=" + this.hotelRoomType + ", hotelLocation=" + this.hotelLocation;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public boolean isAvailable() {
        boolean r5 = super.isAvailable();
        if (r5 == false) goto L9;
        boolean r10 = TextUtils.isEmpty(this.hotelLocation);
        boolean r11 = !r10;
        if (r10 == false) goto L8;
        m.l(TravelData.TAG, "isAvailable false hotelLocation error, hotelLocation=" + this.hotelLocation + " this=" + this);
    L8:
        return r11;
    L9:
        return r5;
    }
}
