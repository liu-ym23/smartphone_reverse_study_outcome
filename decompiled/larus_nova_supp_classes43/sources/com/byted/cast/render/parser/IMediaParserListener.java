package com.byted.cast.render.parser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IMediaParserListener {
    void OnAudioPacketAvalibale(byte[] r1, long r10);

    void OnError(String r1);

    void OnVideoPacketAvalibale(byte[] r1, long r10);

    void OnVideoParamtersChanged(int r1, int r10);
}
