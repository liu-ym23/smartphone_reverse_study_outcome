package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CustomizedMessage {
    private String mData;
    private int mMark;
    private String mType;

    public String getData() {
        return this.mData;
    }

    public int getMark() {
        return this.mMark;
    }

    public String getType() {
        return this.mType;
    }

    public void setData(String r1) {
        this.mData = r1;
    }

    public void setMark(int r1) {
        this.mMark = r1;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public CustomizedMessage(String r2, String r3) {
        this(r2, r3, -1);
    }

    public CustomizedMessage(String r1, String r2, int r3) {
        this.mType = r1;
        this.mData = r2;
        this.mMark = r3;
    }
}
