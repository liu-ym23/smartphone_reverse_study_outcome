package com.obric.cae.userAware.report;

import com.obric.cae.userAware.db.SubwayRecordDatabase;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayEvaluationEvent {
    public static final String EVENT_TYPE_ENTER = "enter";
    public static final String VERIFY_EVENT_TYPE_ALIPAY = "alipay";
    public static final String VERIFY_EVENT_TYPE_HAR = "har";
    public static final String VERIFY_EVENT_TYPE_NFC = "nfc";
    public static final String VERIFY_METHOD_ALIPAY = "alipay";
    public static final String VERIFY_METHOD_HAR_SUBWAY = "har_subway";
    public static final String VERIFY_METHOD_NFC = "nfc";
    public static final String VERIFY_METHOD_NONE = "none";
    public static final String VERIFY_STATUS_FAIL = "fail";
    public static final String VERIFY_STATUS_SUCCESS = "success";
    public static final String VERIFY_STATUS_TIMEOUT = "timeout";
    public long cellId;
    public float confidenceScore;
    public long delayMs;
    public final String eventType;
    public int harState;
    public float light;
    public String locationState;
    public float pressure;
    public int rat;
    public String stationName;
    public int tac;
    public final long triggerTime;
    public Integer verifyEventHarState;
    public long verifyEventTime;
    public String verifyEventType;
    public String verifyMethod;
    public String verifyStatus;
    public boolean wifiConnected;
    public int windowSeconds;

    public SubwayEvaluationEvent(String r8, long r10) {
        this.eventType = r8;
        this.triggerTime = r10;
    }

    public JSONObject toJSON() {
        JSONObject r8 = new JSONObject();
        r8.put("event_type", this.eventType);
        r8.put("trigger_time", this.triggerTime);
        r8.put("confidence_score", this.confidenceScore);
        String r10 = this.stationName;
        String r11 = "";
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        r8.put(SubwayRecordDatabase.COLUMN_STATION_NAME, r10);
        r8.put("cell_id", this.cellId);
        r8.put("rat", this.rat);
        r8.put("tac", this.tac);
        r8.put("window_seconds", this.windowSeconds);
        String r12 = this.verifyStatus;
        if (r12 == null) goto L9;
        r8.put("verify_status", r12);
    L9:
        String r13 = this.verifyMethod;
        if (r13 == null) goto L12;
        r8.put("verify_method", r13);
    L12:
        r8.put("delay_ms", this.delayMs);
        String r14 = this.verifyStatus;
        if (r14 != null) goto L15;
    L21:
        r8.put("pressure", this.pressure);
        r8.put("light", this.light);
        r8.put("har_state", this.harState);
        r8.put("wifi_connected", this.wifiConnected);
        String r15 = this.locationState;
        if (r15 == null) goto L24;
        r11 = r15;
    L24:
        r8.put("location_state", r11);
        return r8;
    L15:
        if (r14.equals("success") == false) goto L21;
        String r16 = this.verifyEventType;
        if (r16 == null) goto L21;
        r8.put("verify_event_type", r16);
        r8.put("verify_event_time", this.verifyEventTime);
        Integer r17 = this.verifyEventHarState;
        if (r17 == null) goto L21;
        r8.put("verify_event_har_state", r17);
        goto L21
    }
}
