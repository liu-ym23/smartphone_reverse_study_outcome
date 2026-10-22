package com.byted.cast.render.decoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMediaDecoderListener {
    void OnAVFrameAvailable(byte[] r1, long r10);

    void OnAVFrameRendered(byte[] r1, long r10);

    void OnError(int r1, String r10);

    void OnVideoSizeChanged(int r1, int r10, int r11, int r12, int r13);
}
