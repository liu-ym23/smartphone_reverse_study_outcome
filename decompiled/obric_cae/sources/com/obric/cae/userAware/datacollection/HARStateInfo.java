package com.obric.cae.userAware.datacollection;

/* JADX INFO: loaded from: classes2.dex */
public class HARStateInfo {
    int modelNumber;
    long timeStamp;
    int value;

    public HARStateInfo(int r8, long r10, int r11) {
        this.value = r8;
        this.timeStamp = r10;
        this.modelNumber = r11;
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

    public void setModelNumber(int r8) {
        this.modelNumber = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }

    public void setValue(int r8) {
        this.value = r8;
    }
}
