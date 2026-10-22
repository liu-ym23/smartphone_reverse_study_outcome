package com.bytedance.android.live.browser.jsbridge.event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RoomTopRightBannerEvent {
    public static final int BANNER_STATUS_COLLAPSE = 1;
    public static final int BANNER_STATUS_EXPAND = 0;
    private long animationTime;
    private int status;

    public RoomTopRightBannerEvent() {
    }

    public String toString() {
        return "RoomTopRightBannerEvent{animationTime=" + this.animationTime + ", status=" + this.status + '}';
    }

    public long getAnimationTime() {
        return this.animationTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAnimationTime(long r1) {
        this.animationTime = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }
}
