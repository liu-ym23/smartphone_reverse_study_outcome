package com.obric.cae.userAware.datacollection;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public class HARFeedbackInfo {
    public static final int USER_SELECT_FALSE = 0;
    public static final int USER_SELECT_TRUE = 1;
    boolean hasFeedback;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    long f5858id;
    int stateCode;
    long timeStamp;
    int userChoice;

    public HARFeedbackInfo() {
    }

    public boolean getHasFeedback() {
        return this.hasFeedback;
    }

    public long getId() {
        return this.f5858id;
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

    public void setHasFeedback(boolean r8) {
        this.hasFeedback = r8;
    }

    public void setId(long r8) {
        this.f5858id = r8;
    }

    public void setStateCode(int r8) {
        this.stateCode = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public void setUserChoice(int r8) {
        this.userChoice = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("HARFeedbackInfo{timeStamp='");
        r8.append(this.timeStamp);
        r8.append(", stateCode=");
        r8.append(this.stateCode);
        r8.append(", userChoice=");
        return a.f(r8, this.userChoice, '}');
    }
}
