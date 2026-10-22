package com.mammon.speechlinklayersdk.param;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SpeechLinkLayerUplinkCallbackParam {
    public ByteBuffer audioData;
    public ByteBuffer audioExtraPbData;
    public ByteBuffer eventPbData;
    public int speechEvent;
    public String speechOnlyEventName;
    public String speechOnlyEventPayload;
    public Object userContext;

    public SpeechLinkLayerUplinkCallbackParam() {
    }
}
