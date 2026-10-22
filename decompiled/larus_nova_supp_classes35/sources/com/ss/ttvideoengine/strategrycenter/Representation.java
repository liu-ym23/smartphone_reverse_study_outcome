package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Representation {
    private int mBitrate;
    private String mCodec;
    private String mFileID;
    private int mFileSize;
    private int mHeight;
    private String mMediaType;
    private String mQuality;
    private int mWidth;

    public Representation() {
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public String getFileID() {
        return this.mFileID;
    }

    public int getFileSize() {
        return this.mFileSize;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setBitrate(int r1) {
        this.mBitrate = r1;
    }

    public void setFileID(String r1) {
        this.mFileID = r1;
    }

    public void setFileSize(int r1) {
        this.mFileSize = r1;
    }

    public void setHeight(int r1) {
        this.mHeight = r1;
    }

    public void setMediaType(String r1) {
        this.mMediaType = r1;
    }

    public void setQuality(String r1) {
        this.mQuality = r1;
    }

    public void setWidth(int r1) {
        this.mWidth = r1;
    }
}
