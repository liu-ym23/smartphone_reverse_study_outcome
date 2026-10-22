package com.zte.miboard.recommend.agent.data;

import android.util.Log;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import m.g;

/* JADX INFO: loaded from: classes3.dex */
public class HotelData extends TravelData {
    public String hotelLocation;
    public String hotelRoomType;

    public HotelData(String r5, String r10, String r11, String r12, String r13, String r14, String r15) {
        super(r5, r10, r11, r12, r13);
        this.hotelLocation = r14;
        this.hotelRoomType = r15;
    }

    public static HotelData parseToHotelData(String r10, String r11, String r12, String r13, String r14) {
        String r5 = g.d(r11);
        String r15 = g.d(r12);
        if (r5 != null) goto L5;
    L7:
        String r16 = "";
    L8:
        if (r15 != null) goto L10;
    L18:
        DateTimeFormatter r17 = DateTimeFormatter.ofPattern("yyyy-MM-dd");     // Catch: Exception -> L15
        String r18 = LocalDate.parse(r5, r17).plusDays(1).format(r17) + " 00:00";     // Catch: Exception -> L15
    L12:
        String r19 = r18;
    L17:
        return new HotelData(r10, r13, r5, r16, r19, r13, r14);
    L15:
        Log.e("HotelData", "error: parse data failed, please check data");
        r19 = "";
        goto L17
    L10:
        if (r15.isEmpty() == true) goto L18;
        r18 = r15.concat(" 00:00");
        goto L12
    L5:
        if (r5.isEmpty() == true) goto L7;
        r16 = r5.concat(" 00:00");
        goto L8
    }
}
