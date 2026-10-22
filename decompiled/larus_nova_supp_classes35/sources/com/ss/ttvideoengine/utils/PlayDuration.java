package com.ss.ttvideoengine.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PlayDuration {
    private static final int STATE_PLAYING = 1;
    private static final int STATE_STOP = 2;
    private int mPlayedDuration;
    private long mStartPlayTime;
    private int mState;

    public void clear() {
        this.mPlayedDuration = 0;
        if (this.mState != 1) goto L6;
        this.mStartPlayTime = SystemClock.elapsedRealtime();
        return;
    }

    public void reset() {
        this.mState = 2;
        this.mPlayedDuration = 0;
        this.mStartPlayTime = 0;
    }

    public int getPlayedDuration() {
        if (this.mState != 1) goto L11;
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.mStartPlayTime;
        int r5 = (int) (r0 - r2);
        if (r5 >= 0) goto L7;
    L9:
        this.mStartPlayTime = r0;
        goto L11
    L7:
        if (r2 <= 0) goto L9;
        this.mPlayedDuration += r5;
    L11:
        return this.mPlayedDuration;
    }

    public void start() {
        if (this.mState != 2) goto L6;
        this.mStartPlayTime = SystemClock.elapsedRealtime();
        this.mState = 1;
        return;
    }

    public void stop() {
        if (this.mState != 1) goto L8;
        this.mState = 2;
        int r1 = (int) (SystemClock.elapsedRealtime() - this.mStartPlayTime);
        if (r1 < 0) goto L9;
        this.mPlayedDuration += r1;
        return;
    L9:
        return;
    }

    public PlayDuration() {
        this.mState = 2;
        this.mPlayedDuration = 0;
        this.mStartPlayTime = 0;
    }
}
