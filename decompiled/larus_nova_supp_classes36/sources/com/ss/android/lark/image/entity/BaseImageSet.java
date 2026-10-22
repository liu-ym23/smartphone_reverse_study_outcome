package com.ss.android.lark.image.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class BaseImageSet implements Serializable {
    protected String key;
    protected Image middle;
    protected Image origin;
    protected Image thumbnail;

    public BaseImageSet() {
    }

    public String getKey() {
        return this.key;
    }

    public Image getMiddle() {
        return this.middle;
    }

    public Image getOrigin() {
        return this.origin;
    }

    public Image getThumbnail() {
        return this.thumbnail;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setMiddle(Image r1) {
        this.middle = r1;
    }

    public void setOrigin(Image r1) {
        this.origin = r1;
    }

    public void setThumbnail(Image r1) {
        this.thumbnail = r1;
    }

    public BaseImageSet(String r1, Image r2, Image r3) {
        this.key = r1;
        this.origin = r2;
        this.thumbnail = r3;
    }
}
