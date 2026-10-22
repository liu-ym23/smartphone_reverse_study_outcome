package com.byted.cast.render.datasource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IDataSourceListener {
    void onAudioPacketAvailable(byte[] r1, long r10);

    void onVideoPacketAvailable(byte[] r1, long r10);
}
