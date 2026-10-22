package com.byted.cast.sdk.render.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IVideoFrameListener {
    void onDecodeIn(String r1, long r10);

    void onDecoded(String r1, long r10);

    void onRendered(String r1, long r10);
}
