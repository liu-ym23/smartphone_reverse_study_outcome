package com.zte.miboard.cards.travel.data;

import android.content.Context;
import android.text.TextUtils;
import c.m;
import c.s0;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.travel.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class FlightData extends TravelData {
    public static final HashMap<String, int[]> FLIGHT_STATUS_COLOR_MAP = null;
    private static final String STATUS_KEY_CANCEL = "cancel";
    private static final List<String> STATUS_KEY_LIST = null;
    private static final String STATUS_KEY_NORMAL = "normal";
    private static final String STATUS_KEY_PLAN = "plan";
    private static final String STATUS_KEY_WARNING = "warning";
    private String actArrTime;
    private String actDepTime;
    private String airlinesCode;
    private String airlinesName;
    private String arrAirport;
    private String arrCityName;
    private String arrCode;
    private String arrCountry;
    private String arrDate;
    private TravelData.LngLat arrPoint;
    private String arrStation;
    private String arrTerminal;
    private String baggageTurntable;
    private String boardingGate;
    private ArrayList<CheckInTable> checkinTableList;
    private String depAirport;
    private String depCityName;
    private String depCode;
    private String depCountry;
    protected String depDate;
    private TravelData.LngLat depPoint;
    private String depStation;
    private String depTerminal;
    private String economyClass;
    private String estimateArrTime;
    private String estimateDepTime;
    protected String flightNo;
    protected String flightSource;
    public int flightStatusCode;
    private String flightStatusDesc;
    public JumpUrl jumpUrl;
    private String planArrTime;
    private String planDepTime;
    private int shuttleCar;
    protected String statusKey;
    private long time;

    public static class CheckInTable {
        public String key;
        public String value;

        public CheckInTable() {
        }
    }

    public static class JumpUrl {
        public String appUrl;
        public String webURL;
        public String wxappURL;

        public JumpUrl() {
        }
    }

    static {
        STATUS_KEY_LIST = Arrays.asList(new String[]{STATUS_KEY_PLAN, STATUS_KEY_NORMAL, STATUS_KEY_CANCEL, STATUS_KEY_WARNING});
        FLIGHT_STATUS_COLOR_MAP = new AnonymousClass1();
    }

    public FlightData() {
    }

    public static SimpleDateFormat getFlightTimeFormat() {
        return s0.f("yyyy-MM-dd HH:mm:ss");
    }

    private String getStatusKey() {
        if (TextUtils.isEmpty(this.statusKey) == true) goto L8;
        List<String> r5 = STATUS_KEY_LIST;
        String r10 = this.statusKey;
        Locale r11 = Locale.ROOT;
        if (r5.contains(r10.toLowerCase(r11)) == true) goto L7;
        return STATUS_KEY_PLAN;
    L7:
        return this.statusKey.toLowerCase(r11);
    L8:
        return STATUS_KEY_PLAN;
    }

    public String getBaggageID() {
        if (TextUtils.isEmpty(this.baggageTurntable) == false) goto L7;
        return "";
    L7:
        return this.baggageTurntable;
    }

    public String getBoardGate() {
        if (TextUtils.isEmpty(this.boardingGate) == false) goto L7;
        return "";
    L7:
        return this.boardingGate;
    }

    public String getCheckInTable() {
        if (TextUtils.isEmpty(this.economyClass) == false) goto L7;
        return "";
    L7:
        return this.economyClass;
    }

    public String getFlightCompany() {
        if (TextUtils.isEmpty(this.airlinesName) == false) goto L7;
        return "";
    L7:
        return this.airlinesName;
    }

    public String getFlightStatusDesc(Context r5) {
        if (TextUtils.isEmpty(this.flightStatusDesc) == true) goto L7;
        return this.flightStatusDesc;
    L7:
        return r5.getString(R.string.travel_state_plan);
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getFromStation() {
        if (TextUtils.isEmpty(this.depStation) == true) goto L7;
        return this.depStation;
    L7:
        return super.getFromStation();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public TravelData.LngLat getFromStationLngLat() {
        return this.depPoint;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getFromTimeLong() {
        long r5 = b.a(this.planDepTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getFromTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getPlanFromTimeLong() {
        long r5 = b.a(this.estimateDepTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getPlanFromTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getPlanToTimeLong() {
        long r5 = b.a(this.estimateArrTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getPlanToTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getRealFromTimeLong() {
        long r5 = b.a(this.actDepTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getRealFromTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getRealToTimeLong() {
        long r5 = b.a(this.actArrTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getRealToTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getRealToTimeStr() {
        if (TextUtils.isEmpty(this.actArrTime) == true) goto L7;
        return this.actArrTime;
    L7:
        return super.getRealToTimeStr();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getShowToString() {
        return ", fromStation=" + getFromStation() + ", toStation=" + getToStation() + ", economyClass=" + getCheckInTable() + ", boardingGate=" + getBoardGate() + ", baggageTurntable=" + getBaggageID() + ", flightStatusCode=" + this.flightStatusCode + ", flightStatusDesc=" + this.flightStatusDesc + ", planDepTime=" + this.planDepTime + ", planArrTime=" + this.planArrTime + ", estimateDepTime=" + this.estimateDepTime + ", estimateArrTime=" + this.estimateArrTime + ", actDepTime=" + this.actDepTime + ", actArrTime=" + this.actArrTime;
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getSource() {
        if (TextUtils.isEmpty(this.flightSource) == true) goto L7;
        return this.flightSource;
    L7:
        return super.getSource();
    }

    public int getStatusKeyIconResId() {
        return FLIGHT_STATUS_COLOR_MAP.get(getStatusKey())[0];
    }

    public int getStatusKeyLineResId() {
        return FLIGHT_STATUS_COLOR_MAP.get(getStatusKey())[2];
    }

    public int getStatusKeyTextColor(Context r5) {
        return r5.getColor(FLIGHT_STATUS_COLOR_MAP.get(getStatusKey())[1]);
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public String getToStation() {
        if (TextUtils.isEmpty(this.arrStation) == true) goto L7;
        return this.arrStation;
    L7:
        return super.getToStation();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getToTimeLong() {
        long r5 = b.a(this.planArrTime, getFlightTimeFormat());
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getToTimeLong();
    }

    @Override // com.zte.miboard.cards.travel.data.TravelData
    public long getUpdateTimeLong() {
        long r5 = this.time;
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return super.getUpdateTimeLong();
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
