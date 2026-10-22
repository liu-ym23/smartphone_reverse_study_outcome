package com.byted.cast.render.decoder;

import com.byted.cast.mediacommon.render.MediaRenderState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMediaDecoder {
    MediaRenderState getState();

    boolean sendPacket(byte[] r1, long r10);

    void setMediaDecoderListener(IMediaDecoderListener r1);

    boolean start();

    boolean stop();
}
