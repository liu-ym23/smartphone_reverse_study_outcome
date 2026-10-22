package com.bytedance.android.live.browser.jsbridge.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RoomBannerBarEvent {
    public static final int GONE = 0;
    public static final int VISIBLE = 1;
    private String backgroundColor;
    private String color;
    private int fontSize;
    private String title;
    private int visible;

    public boolean isVisible() {
        if (this.visible == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "RoomBannerBarEvent{title='" + this.title + "', visible=" + this.visible + ", backgroundColor='" + this.backgroundColor + "', fontSize=" + this.fontSize + ", color='" + this.color + "'}";
    }

    public RoomBannerBarEvent() {
        this.fontSize = 9;
    }

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getColor() {
        return this.color;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public String getTitle() {
        return this.title;
    }

    public int getVisible() {
        return this.visible;
    }

    public void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public void setColor(String r1) {
        this.color = r1;
    }

    public void setFontSize(int r1) {
        this.fontSize = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setVisible(int r1) {
        this.visible = r1;
    }
}
