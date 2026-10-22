package com.ss.android.lark.forwardv2.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class StickImage implements Serializable {
    private int mHeight;
    private String mKey;
    private int mWidth;

    public StickImage() {
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int r1) {
        this.mHeight = r1;
    }

    public void setKey(String r1) {
        this.mKey = r1;
    }

    public void setWidth(int r1) {
        this.mWidth = r1;
    }
}
