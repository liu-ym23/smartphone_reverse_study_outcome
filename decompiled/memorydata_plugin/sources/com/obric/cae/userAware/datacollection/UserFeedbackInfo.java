package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes3.dex */
public class UserFeedbackInfo {
    int stateChange;
    int stateCode;
    long timeStamp;
    String type;
    int userChoice;

    public UserFeedbackInfo() {
    }

    public int getStateChange() {
        return this.stateChange;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getType() {
        return this.type;
    }

    public int getUserChoice() {
        return this.userChoice;
    }

    public void setStateChange(int r1) {
        this.stateChange = r1;
    }

    public void setStateCode(int r1) {
        this.stateCode = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setUserChoice(int r1) {
        this.userChoice = r1;
    }

    public String toString() {
        return "UserFeedbackInfo{type='" + this.type + "', timeStamp='" + this.timeStamp + "', stateCode=" + this.stateCode + ", stateChange=" + this.stateChange + ", userChoice=" + this.userChoice + '}';
    }
}
