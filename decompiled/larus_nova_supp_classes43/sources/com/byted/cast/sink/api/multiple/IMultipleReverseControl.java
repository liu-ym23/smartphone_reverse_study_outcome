package com.byted.cast.sink.api.multiple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMultipleReverseControl {
    int getCurrentPosition(String r1);

    int getDuration(String r1);

    void lowerVolume(String r1);

    boolean pause(String r1);

    void raiseVolume(String r1);

    void seekTo(String r1, int r10);

    void sendMetaData(String r1);

    void setVolume(String r1, int r10);

    boolean start(String r1);

    boolean stop(String r1);
}
