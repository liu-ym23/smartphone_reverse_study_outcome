package com.zte.miboard.cards.travel.data;

import ai.j0;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import androidx.annotation.NonNull;
import c.m;
import com.google.gson.Gson;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.travel.a;
import com.zte.miboard.cards.travel.b;
import com.zte.miboard.cards.travel.net.data.FlightReq;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TravelData implements ContextMenu.ContextMenuInfo {
    public static final String TAG = "TravelData";
    public String cardDetailsPageDeepLink;
    public String cardDetailsPagePkg;
    private String dataFrom;
    private String dataKeyString;
    private String fromStation;
    public LngLat fromStationLngLat;
    private String fromTime;
    private Boolean hideBind;
    private Boolean ignored;
    private String mergeFromTime;
    private String mergeToTime;
    private Long netUpdateTimeLong;
    private String notifications;
    public String orderNo;
    private String planFromTime;
    private String planToTime;
    private String realFromTime;
    private String realToTime;
    private String source;
    private String toStation;
    private String toTime;
    public String travelDate;
    public String travelNumber;
    private Long updateTimeLong;
    private Boolean userCancelStatus;
    public String userName;
    private Boolean userRegistered;

    public static class LngLat {
        public static final String COORD_TYPE_GCJ = "gcj";
        public String arrCoordType;
        public String coordType;
        public String depCoordType;
        public String lat;
        public String lng;

        public LngLat(String r5, String r10, String r11) {
            this.lng = r5;
            this.lat = r10;
            this.coordType = r11;
        }

        public boolean isAvailable() {
            if (TextUtils.isEmpty(this.lat) == false) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(this.lng) == true) goto L7;
            return true;
        }

        public boolean isGCJ() {
            if (TextUtils.isEmpty(this.coordType) == true) goto L7;
            if (this.coordType.toLowerCase(Locale.ROOT).contains(COORD_TYPE_GCJ) == false) goto L7;
        L14:
            return true;
        L7:
            if (TextUtils.isEmpty(this.depCoordType) == true) goto L11;
            if (this.depCoordType.toLowerCase(Locale.ROOT).contains(COORD_TYPE_GCJ) == true) goto L14;
        L11:
            if (TextUtils.isEmpty(this.arrCoordType) == false) goto L13;
        L15:
            return false;
        L13:
            if (this.arrCoordType.toLowerCase(Locale.ROOT).contains(COORD_TYPE_GCJ) == false) goto L15;
            goto L14
        }

        @NonNull
        public String toString() {
            StringBuilder r5 = new StringBuilder("LngLat{lat=");
            r5.append(this.lat);
            r5.append(", lng=");
            r5.append(this.lng);
            r5.append(", isGCJ=");
            r5.append(isGCJ());
            String r10 = "";
            if (TextUtils.isEmpty(this.coordType) == true) goto L5;
            String r11 = ", coordType=" + this.coordType;
        L6:
            r5.append(r11);
            if (TextUtils.isEmpty(this.depCoordType) == true) goto L9;
            String r12 = ", depCoordType=" + this.depCoordType;
        L10:
            r5.append(r12);
            if (TextUtils.isEmpty(this.arrCoordType) == true) goto L14;
            r10 = ", arrCoordType=" + this.arrCoordType;
        L14:
            return j0.q(r5, r10, "}");
        L9:
            r12 = "";
            goto L10
        L5:
            r11 = "";
            goto L6
        }
    }

    public TravelData() {
    }

    public long getCurAvailableFromTimeLong() {
        long r5 = getRealFromTimeLong();
        if (r5 <= 0) goto L5;
        return r5;
    L5:
        long r10 = getPlanFromTimeLong();
        if (r10 <= 0) goto L9;
        return r10;
    L9:
        return getFromTimeLong();
    }

    public long getCurAvailableToTimeLong() {
        long r5 = getRealToTimeLong();
        if (r5 <= 0) goto L5;
        return r5;
    L5:
        long r10 = getPlanToTimeLong();
        if (r10 <= 0) goto L9;
        return r10;
    L9:
        return getToTimeLong();
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public LngLat getFromStationLngLat() {
        return this.fromStationLngLat;
    }

    public long getFromTimeDelayTimeLong() {
        long r5 = getFromTimeLong();
        if (getRealFromTimeLong() <= 0) goto L6;
        long r10 = getRealFromTimeLong();
    L10:
        if (r10 > r5) goto L13;
        return 0;
    L13:
        return r10 - r5;
    L6:
        if (getPlanFromTimeLong() <= 0) goto L8;
        r10 = getPlanFromTimeLong();
        goto L10
    L8:
        r10 = r5;
        goto L10
    }

    public long getFromTimeLong() {
        return b.a(this.fromTime, false);
    }

    public String getFromTimeString() {
        String r5 = this.fromTime;
        if (r5 != null) goto L7;
        return "";
    L7:
        return r5;
    }

    public long getNetUpdateTimeLong() {
        Long r5 = this.netUpdateTimeLong;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.longValue();
    }

    public long getPlanFromTimeLong() {
        return b.a(this.planFromTime, false);
    }

    public String getPlanOrRealFromTimeInfo(Context r10) {
        long r5 = getRealFromTimeLong();
        if (r5 > 0) goto L5;
        long r11 = getPlanFromTimeLong();
        if (r11 > 0) goto L9;
        return "";
    L9:
        return r10.getString(R.string.travel_flight_plan_from_time_info, new Object[]{b.e().format(Long.valueOf(r11))});
    L5:
        return r10.getString(R.string.travel_flight_real_from_time_info, new Object[]{b.e().format(Long.valueOf(r5))});
    }

    public String getPlanOrRealToTimeInfo(Context r10) {
        long r5 = getRealToTimeLong();
        if (r5 > 0) goto L5;
        long r11 = getPlanToTimeLong();
        if (r11 > 0) goto L9;
        return "";
    L9:
        return r10.getString(R.string.travel_flight_plan_to_time_info, new Object[]{b.e().format(Long.valueOf(r11))});
    L5:
        return r10.getString(R.string.travel_flight_real_to_time_info, new Object[]{b.e().format(Long.valueOf(r5))});
    }

    public long getPlanToTimeLong() {
        return b.a(this.planToTime, false);
    }

    public long getRealFromTimeLong() {
        return b.a(this.realFromTime, false);
    }

    public long getRealToTimeLong() {
        return b.a(this.realToTime, false);
    }

    public String getRealToTimeStr() {
        if (TextUtils.isEmpty(this.realToTime) == false) goto L7;
        return "";
    L7:
        return this.realToTime;
    }

    public String getShowToString() {
        return "";
    }

    public String getSource() {
        if (TextUtils.isEmpty(this.source) == false) goto L7;
        return "";
    L7:
        return this.source;
    }

    public String getToStation() {
        if (TextUtils.isEmpty(this.toStation) == false) goto L7;
        return "";
    L7:
        return this.toStation;
    }

    public long getToTimeLong() {
        if (TextUtils.isEmpty(this.mergeToTime) == true) goto L8;
        long r5 = b.a(this.mergeToTime, false);
        if (r5 <= 0) goto L8;
        return r5;
    L8:
        return b.a(this.toTime, false);
    }

    public String getToTimeString() {
        if (TextUtils.isEmpty(this.mergeToTime) == false) goto L5;
        String r5 = this.toTime;
        if (r5 != null) goto L11;
        return "";
    L11:
        return r5;
    L5:
        return this.mergeToTime;
    }

    public String getTravelKey() {
        return (this.travelDate + "_" + this.travelNumber).toLowerCase(Locale.ROOT);
    }

    public long getUpdateTimeLong() {
        Long r5 = this.updateTimeLong;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.longValue() > 0) goto L7;
        return 0;
    L7:
        return this.updateTimeLong.longValue();
    }

    public boolean hasSendNotificationType(String r5) {
        if (a.b(r5) == false) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(r5) == false) goto L9;
        return false;
    L9:
        if (this.notifications != null) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L28;
    L17:
        StringBuilder r10 = j0.x("hasSendNotificationType error, notificationType=", r5, ", notifications=");
        r10.append(this.notifications);
        m.l(TAG, r10.toString());
    L18:
        ArrayList r11 = null;
    L19:
        if (r11 != null) goto L22;
        r11 = new ArrayList();
    L22:
        return r11.contains(r5.toLowerCase(Locale.ROOT));
    L14:
        if (TextUtils.isEmpty(this.notifications) == true) goto L18;
        r11 = (ArrayList) new Gson().fromJson(this.notifications, new AnonymousClass1(this).getType());     // Catch: Throwable -> L17
        goto L19
    L28:
        return false;
    }

    public boolean isAvailable() {
        boolean r5 = isBaseInfoAvailable();
        boolean r10 = true;
        if (r5 == true) goto L5;
    L13:
        if (r5 == true) goto L15;
    L25:
        if (r5 == false) goto L33;
        long r11 = getFromTimeLong();
        long r12 = getToTimeLong();
        if (r11 <= 0) goto L33;
        if (r12 <= 0) goto L33;
        if (r11 <= r12) goto L33;
        m.l(TAG, "isAvailable false toTime less than from time, fromTime=" + this.fromTime + ", toTime=" + this.toTime + " this=" + this);
        r5 = false;
    L33:
        if (r5 == true) goto L35;
    L42:
        if (r5 == true) goto L44;
    L51:
        if (r5 == true) goto L53;
    L60:
        if (r5 == true) goto L62;
        return r5;
    L62:
        if (TextUtils.isEmpty(this.realToTime) == false) goto L64;
        return r5;
    L64:
        if (getRealToTimeLong() > 0) goto L67;
        r10 = false;
    L67:
        if (r10 == true) goto L70;
        m.l(TAG, "isAvailable false realToTime error, realToTime=" + this.realToTime + " this=" + this);
    L70:
        return r10;
    L53:
        if (TextUtils.isEmpty(this.realFromTime) == true) goto L60;
        if (getRealFromTimeLong() <= 0) goto L57;
        r5 = true;
    L58:
        if (r5 == true) goto L60;
        m.l(TAG, "isAvailable false realFromTime error, realFromTime=" + this.realFromTime + " this=" + this);
        goto L60
    L57:
        r5 = false;
        goto L58
    L44:
        if (TextUtils.isEmpty(this.planToTime) == true) goto L51;
        if (getPlanToTimeLong() <= 0) goto L48;
        r5 = true;
    L49:
        if (r5 == true) goto L51;
        m.l(TAG, "isAvailable false toTime error, planToTime=" + this.planToTime + " this=" + this);
        goto L51
    L48:
        r5 = false;
        goto L49
    L35:
        if (TextUtils.isEmpty(this.planFromTime) == true) goto L42;
        if (getPlanFromTimeLong() <= 0) goto L39;
        r5 = true;
    L40:
        if (r5 == true) goto L42;
        m.l(TAG, "isAvailable false planFromTime error, planFromTime=" + this.planFromTime + " this=" + this);
        goto L42
    L39:
        r5 = false;
        goto L40
    L15:
        if ((this instanceof MatchData) == false) goto L25;
        if (getToTimeLong() <= 0) goto L19;
    L22:
        r5 = true;
    L23:
        if (r5 == true) goto L25;
        m.l(TAG, "isAvailable false toTime error, toTime=" + this.toTime + " this=" + this);
        goto L25
    L19:
        if (getCurAvailableToTimeLong() > 0) goto L22;
        r5 = false;
        goto L23
    L5:
        if (getFromTimeLong() <= 0) goto L7;
    L10:
        r5 = true;
    L11:
        if (r5 == true) goto L13;
        m.l(TAG, "isAvailable false fromTime error, fromTime=" + this.fromTime + " this=" + this);
        goto L13
    L7:
        if (getCurAvailableFromTimeLong() > 0) goto L10;
        r5 = false;
        goto L11
    }

    public boolean isBaseInfoAvailable() {
        if (TextUtils.isEmpty(this.travelNumber) == false) goto L5;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
        m.l(TAG, "isBaseInfoAvailable false travelNumber or travelDate error, travelNumber=" + this.travelNumber + " travelDate=" + this.travelDate + " check=" + b.a(this.travelDate) + " this=" + this);
    L12:
        return r5;
    L5:
        if (TextUtils.isEmpty(this.travelDate) == true) goto L9;
        if (b.a(this.travelDate) == false) goto L9;
        r5 = true;
        goto L10
    }

    public boolean isHideBind() {
        Boolean r5 = this.hideBind;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isIgnored() {
        Boolean r5 = this.ignored;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isUserCancel() {
        Boolean r5 = this.userCancelStatus;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    public boolean isUserRegistered() {
        Boolean r5 = this.userRegistered;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.booleanValue() == false) goto L7;
        return true;
    }

    public void mergeTravelData(TravelData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isAvailable() == false) goto L10;
        this.mergeToTime = r5.toTime;
        r5.mergeFromTime = this.fromTime;
        if (r5.getUpdateTimeLong() <= 0) goto L11;
        this.updateTimeLong = Long.valueOf(r5.getUpdateTimeLong());
        return;
    L11:
        return;
    }

    public boolean needIgnoreByHasMergeFromTime() {
        return !TextUtils.isEmpty(this.mergeFromTime);
    }

    public boolean saveSendNotificationType(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return false;
    L19:
    L10:
        StringBuilder r10 = j0.x("saveSendNotificationType error, notificationType=", r5, ", notifications=");
        r10.append(this.notifications);
        m.l(TAG, r10.toString());
    L11:
        ArrayList r11 = null;
    L12:
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        String r12 = r5.toLowerCase(Locale.ROOT);
        if (r11.contains(r12) == true) goto L21;
        r11.add(r12);
        this.notifications = new Gson().toJson(r11);
        return true;
    L21:
        return true;
    L7:
        if (TextUtils.isEmpty(this.notifications) == true) goto L11;
        r11 = (ArrayList) new Gson().fromJson(this.notifications, new AnonymousClass2(this).getType());     // Catch: Throwable -> L10
        goto L12
    }

    public void setDataFrom(String r5) {
        this.dataFrom = r5;
    }

    public void setDataKeyString(String r5) {
        this.dataKeyString = r5;
    }

    public void setHideBind() {
        this.hideBind = Boolean.TRUE;
    }

    public void setIgnored() {
        this.ignored = Boolean.TRUE;
    }

    public void setNetUpdateTimeLong(long r5) {
        this.netUpdateTimeLong = Long.valueOf(r5);
    }

    public void setUpdateTimeToNowIfNeed() {
        if (getUpdateTimeLong() > 0) goto L6;
        this.updateTimeLong = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public void setUserRegistered() {
        this.userRegistered = Boolean.TRUE;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getSimpleName());
        r5.append("{travelDate=");
        r5.append(this.travelDate);
        r5.append(", travelNumber=");
        r5.append(this.travelNumber);
        String r10 = "";
        if (this.ignored == null) goto L5;
        String r11 = ", ignored=" + this.ignored;
    L6:
        r5.append(r11);
        if (this.userCancelStatus == null) goto L9;
        String r12 = ", userCancelStatus=" + this.userCancelStatus;
    L10:
        r5.append(r12);
        r5.append(", fromTime=");
        r5.append(this.fromTime);
        r5.append(", toTime=");
        r5.append(this.toTime);
        r5.append(getShowToString());
        r5.append(", notifications=");
        r5.append(this.notifications);
        if (this.planFromTime == null) goto L13;
        String r13 = ", planFromTime=" + this.planFromTime;
    L14:
        r5.append(r13);
        if (this.planToTime == null) goto L17;
        String r14 = ", planToTime=" + this.planToTime;
    L18:
        r5.append(r14);
        if (this.realFromTime == null) goto L21;
        String r15 = ", realFromTime=" + this.realFromTime;
    L22:
        r5.append(r15);
        if (this.realToTime == null) goto L25;
        String r16 = ", realToTime=" + this.planToTime;
    L26:
        r5.append(r16);
        if (this.source == null) goto L29;
        String r17 = ", source=" + this.source;
    L30:
        r5.append(r17);
        if (this.cardDetailsPagePkg == null) goto L34;
        r10 = ", cardDetailsPagePkg=" + this.cardDetailsPagePkg;
    L34:
        return j0.q(r5, r10, "}");
    L29:
        r17 = "";
        goto L30
    L25:
        r16 = "";
        goto L26
    L21:
        r15 = "";
        goto L22
    L17:
        r14 = "";
        goto L18
    L13:
        r13 = "";
        goto L14
    L9:
        r12 = "";
        goto L10
    L5:
        r11 = "";
        goto L6
    }

    public void updateFlightReq(@NonNull FlightReq r5) {
        r5.travelNumber = this.travelNumber;
        r5.travelDate = this.travelDate;
        r5.fromTime = this.fromTime;
        r5.toTime = this.toTime;
        r5.fromStation = this.fromStation;
        r5.toStation = this.toStation;
    }
}
