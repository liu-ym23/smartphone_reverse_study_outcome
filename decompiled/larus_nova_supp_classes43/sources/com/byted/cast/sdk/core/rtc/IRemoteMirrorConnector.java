package com.byted.cast.sdk.core.rtc;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IRemoteMirrorConnector {
    void init(Context r1, int r10, int r11, int r12, int r13);

    void leaveRoom();

    void requestRemoteVideoKeyFrame();

    int sendAudioFrame(byte[] r1, int r10, int r11, int r12, int r13, long r14);

    boolean sendVideoFrame(byte[] r1, byte[] r10, int r11, int r12, int r13, long r14, int r15, int r16);

    boolean sendVideoImage(Bitmap r1);

    void setRTCCallback(IRemoteMirrorCallback r1);

    int sinkInitAndJoinRoom(String r1, String r10, String r11, String r12);

    int sourceInitAndJoinRoom(String r1, String r10, String r11, String r12);
}
