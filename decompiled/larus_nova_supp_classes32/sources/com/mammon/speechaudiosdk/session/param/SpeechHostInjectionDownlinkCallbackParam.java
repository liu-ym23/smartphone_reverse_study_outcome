package com.mammon.speechaudiosdk.session.param;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechHostInjectionDownlinkCallbackParam {
    public ByteBuffer audioData;
    public ByteBuffer audioExtraPbData;
    public ByteBuffer eventPbData;
    public int speechEvent;
    public Object userContext;

    public SpeechHostInjectionDownlinkCallbackParam() {
    }
}
