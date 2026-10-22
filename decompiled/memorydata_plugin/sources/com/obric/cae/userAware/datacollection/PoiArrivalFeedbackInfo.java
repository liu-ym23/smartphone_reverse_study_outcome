package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes3.dex */
public class PoiArrivalFeedbackInfo {
    public static final int EVENT_TYPE_ADSP_ENTRY_REQUEST = 3;
    public static final int EVENT_TYPE_ARRIVAL = 1;
    public static final int EVENT_TYPE_DEBUG_MANUAL_ENTRY = 4;
    public static final int EVENT_TYPE_DEBUG_MANUAL_MONITORING = 5;
    public static final int EVENT_TYPE_LEAVE = 2;
    public static final long INVALID_RECORD_ID = -1;
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_NONE = -1;
    public static final int USER_SELECT_TRUE = 1;
    private String aoiName;
    private String category;
    private int eventType;
    private long feedbackTime;
    private boolean hasFeedback;
    private long id;
    private String poiName;
    private long timeStamp;
    private int userChoice;

    public PoiArrivalFeedbackInfo() {
        this.id = -1;
        this.eventType = 1;
        this.userChoice = -1;
    }

    public String getAoiName() {
        return this.aoiName;
    }

    public String getCategory() {
        return this.category;
    }

    public int getEventType() {
        return this.eventType;
    }

    public long getFeedbackTime() {
        return this.feedbackTime;
    }

    public boolean getHasFeedback() {
        return this.hasFeedback;
    }

    public long getId() {
        return this.id;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getUserChoice() {
        return this.userChoice;
    }

    public boolean isArrivalEvent() {
        if (this.eventType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isCaeAdspEvent() {
        int r1 = this.eventType;
        if (r1 != 3) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 4) goto L10;
        if (r1 == 5) goto L10;
        return false;
    }

    public boolean isDebugEvent() {
        int r1 = this.eventType;
        if (r1 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 5) goto L8;
        return false;
    }

    public boolean isLeaveEvent() {
        if (this.eventType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void setAoiName(String r1) {
        this.aoiName = r1;
    }

    public void setCategory(String r1) {
        this.category = r1;
    }

    public void setEventType(int r1) {
        this.eventType = r1;
    }

    public void setFeedbackTime(long r1) {
        this.feedbackTime = r1;
    }

    public void setHasFeedback(boolean r1) {
        this.hasFeedback = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setPoiName(String r1) {
        this.poiName = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public void setUserChoice(int r1) {
        this.userChoice = r1;
    }

    public boolean supportsFeedback() {
        return isArrivalEvent();
    }

    public String toString() {
        return "PoiArrivalFeedbackInfo{id=" + this.id + ", timeStamp=" + this.timeStamp + ", feedbackTime=" + this.feedbackTime + ", poiName='" + this.poiName + "', aoiName='" + this.aoiName + "', category='" + this.category + "', eventType=" + this.eventType + ", userChoice=" + this.userChoice + ", hasFeedback=" + this.hasFeedback + '}';
    }
}
