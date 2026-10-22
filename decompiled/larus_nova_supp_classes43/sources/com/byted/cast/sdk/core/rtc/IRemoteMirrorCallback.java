package com.byted.cast.sdk.core.rtc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IRemoteMirrorCallback {
    void onAudioFrame(byte[] r1, long r10);

    void onJoinRoomResult(String r1, String r10, int r11);

    void onRequestKeyFrame();

    void onStreamAdd(String r1);

    void onUserJoined(String r1);

    void onUserLeave(String r1, int r10);

    void onVideoFrame(byte[] r1, long r10);
}
