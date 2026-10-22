package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes3.dex */
public class SubwayFeedbackInfo {
    public static final int SUBWAY_STATUS_ENTER = 1;
    public static final int SUBWAY_STATUS_EXIT = 0;
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_TRUE = 1;
    boolean hasFeedback;
    long id;
    String stationName;
    int subwayStatus;
    long timeStamp;
    int userChoice;

    public SubwayFeedbackInfo() {
    }

    public boolean getHasFeedback() {
        return this.hasFeedback;
    }

    public long getId() {
        return this.id;
    }

    public String getStationName() {
        return this.stationName;
    }

    public int getSubwayStatus() {
        return this.subwayStatus;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getUserChoice() {
        return this.userChoice;
    }

    public void setHasFeedback(boolean r1) {
        this.hasFeedback = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setStationName(String r1) {
        this.stationName = r1;
    }

    public void setSubwayStatus(int r1) {
        this.subwayStatus = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public void setUserChoice(int r1) {
        this.userChoice = r1;
    }

    public String toString() {
        return "SubwayFeedbackInfo{timeStamp='" + this.timeStamp + ", subwayStatus=" + this.subwayStatus + ", stationName='" + this.stationName + "', userChoice=" + this.userChoice + '}';
    }
}
