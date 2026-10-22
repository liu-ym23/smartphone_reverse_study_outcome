package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes3.dex */
public class HARStateInfo {
    int modelNumber;
    long timeStamp;
    int value;

    public HARStateInfo(int r1, long r2, int r4) {
        this.value = r1;
        this.timeStamp = r2;
        this.modelNumber = r4;
    }

    public int getModelNumber() {
        return this.modelNumber;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getValue() {
        return this.value;
    }

    public void setModelNumber(int r1) {
        this.modelNumber = r1;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public void setValue(int r1) {
        this.value = r1;
    }
}
