package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes3.dex */
public class HARFeedbackInfo {
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_TRUE = 1;
    boolean hasFeedback;
    long id;
    int stateCode;
    long timeStamp;
    int userChoice;

    public HARFeedbackInfo() {
    }

    public boolean getHasFeedback() {
        return this.hasFeedback;
    }

    public long getId() {
        return this.id;
    }

    public int getStateCode() {
        return this.stateCode;
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

    public void setStateCode(int r1) {
        this.stateCode = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public void setUserChoice(int r1) {
        this.userChoice = r1;
    }

    public String toString() {
        return "HARFeedbackInfo{timeStamp='" + this.timeStamp + ", stateCode=" + this.stateCode + ", userChoice=" + this.userChoice + '}';
    }
}
