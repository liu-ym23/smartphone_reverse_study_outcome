package com.ss.ttvideoengine.strategrycenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PlayerInfo {
    private float mFrameRate;
    private int mPlaybackPos;
    private float mPlaybackSpeed;

    public PlayerInfo() {
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getPlaybackPos() {
        return this.mPlaybackPos;
    }

    public float getPlaybackSpeed() {
        return this.mPlaybackSpeed;
    }

    public void setFrameRate(float r1) {
        this.mFrameRate = r1;
    }

    public void setPlaybackPos(int r1) {
        this.mPlaybackPos = r1;
    }

    public void setPlaybackSpeed(float r1) {
        this.mPlaybackSpeed = r1;
    }
}
