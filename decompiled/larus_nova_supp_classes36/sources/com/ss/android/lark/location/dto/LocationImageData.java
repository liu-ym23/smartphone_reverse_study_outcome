package com.ss.android.lark.location.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LocationImageData implements Cloneable, Serializable {
    private static final long serialVersionUID = -2131021848780457914L;
    private int height;
    private String imagePath;
    private int width;

    public LocationImageData() {
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getHeight() {
        return this.height;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setImagePath(String r1) {
        this.imagePath = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
