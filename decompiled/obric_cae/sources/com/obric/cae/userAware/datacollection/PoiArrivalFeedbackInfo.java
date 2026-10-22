package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes2.dex */
public class PoiArrivalFeedbackInfo {
    public static final long INVALID_RECORD_ID = -1;
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_NONE = -1;
    public static final int USER_SELECT_TRUE = 1;
    private String aoiName;
    private String category;
    private long feedbackTime;
    private boolean hasFeedback;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f5859id;
    private String poiName;
    private long timeStamp;
    private int userChoice;

    public PoiArrivalFeedbackInfo() {
        this.f5859id = -1;
        this.userChoice = -1;
    }

    public String getAoiName() {
        return this.aoiName;
    }

    public String getCategory() {
        return this.category;
    }

    public long getFeedbackTime() {
        return this.feedbackTime;
    }

    public boolean getHasFeedback() {
        return this.hasFeedback;
    }

    public long getId() {
        return this.f5859id;
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

    public void setAoiName(String r8) {
        this.aoiName = r8;
    }

    public void setCategory(String r8) {
        this.category = r8;
    }

    public void setFeedbackTime(long r8) {
        this.feedbackTime = r8;
    }

    public void setHasFeedback(boolean r8) {
        this.hasFeedback = r8;
    }

    public void setId(long r8) {
        this.f5859id = r8;
    }

    public void setPoiName(String r8) {
        this.poiName = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public void setUserChoice(int r8) {
        this.userChoice = r8;
    }

    public String toString() {
        return "PoiArrivalFeedbackInfo{id=" + this.f5859id + ", timeStamp=" + this.timeStamp + ", feedbackTime=" + this.feedbackTime + ", poiName='" + this.poiName + "', aoiName='" + this.aoiName + "', category='" + this.category + "', userChoice=" + this.userChoice + ", hasFeedback=" + this.hasFeedback + '}';
    }
}
