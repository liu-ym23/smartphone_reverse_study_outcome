package com.obric.cae.userAware.datacollection;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayFeedbackInfo {
    public static final int SUBWAY_STATUS_ENTER = 1;
    public static final int SUBWAY_STATUS_EXIT = 0;
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_TRUE = 1;
    boolean hasFeedback;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    long f5860id;
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
        return this.f5860id;
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

    public void setHasFeedback(boolean r8) {
        this.hasFeedback = r8;
    }

    public void setId(long r8) {
        this.f5860id = r8;
    }

    public void setStationName(String r8) {
        this.stationName = r8;
    }

    public void setSubwayStatus(int r8) {
        this.subwayStatus = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public void setUserChoice(int r8) {
        this.userChoice = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("SubwayFeedbackInfo{timeStamp='");
        r8.append(this.timeStamp);
        r8.append(", subwayStatus=");
        r8.append(this.subwayStatus);
        r8.append(", stationName='");
        r8.append(this.stationName);
        r8.append("', userChoice=");
        return a.f(r8, this.userChoice, '}');
    }
}
