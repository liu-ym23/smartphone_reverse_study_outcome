package com.byted.cast.render.parser;

import com.byted.cast.mediacommon.render.parameters.CodecId;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AVParser {
    private static final String TAG = "Parser";
    private CodecId codecId;
    private int height;
    private IMediaParserListener listener;
    private int width;

    public boolean release() {
        return true;
    }

    public void sendStream(byte[] r1) {
    }

    public AVParser() {
        this.width = 1920;
        this.height = 1080;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setMediaParserListener(IMediaParserListener r1) {
        this.listener = r1;
    }

    public void setVideoCodecId(CodecId r1) {
        this.codecId = r1;
    }

    public void sendAudioPacket(byte[] r10, long r11) {
        this.listener.OnAudioPacketAvalibale(r10, r11);
    }

    public void sendVideoPacket(byte[] r10, long r11) {
        NAL r0 = new NAL(r10, r10.length, this.codecId);
        NAL.detectNALType(r0);
        if (r0.type != 7) goto L5;
        r11 = 0;
    L5:
        this.listener.OnVideoPacketAvalibale(r10, r11);
    }
}
