package com.obric.cae.userAware.datacollection;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
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

    public void setStateChange(int r8) {
        this.stateChange = r8;
    }

    public void setStateCode(int r8) {
        this.stateCode = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public void setType(String r8) {
        this.type = r8;
    }

    public void setUserChoice(int r8) {
        this.userChoice = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("UserFeedbackInfo{type='");
        r8.append(this.type);
        r8.append("', timeStamp='");
        r8.append(this.timeStamp);
        r8.append("', stateCode=");
        r8.append(this.stateCode);
        r8.append(", stateChange=");
        r8.append(this.stateChange);
        r8.append(", userChoice=");
        return a.f(r8, this.userChoice, '}');
    }
}
