package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreTokenType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreMultiSpeakerEmbeddingContextCreateParameter {
    public String appKey;
    public String audioUrl;
    public int channel;
    public int connect_timeout;
    public int enable_net_transport_compress;
    public String extra;
    public String format;
    public String header;
    public String protoVersion;
    public int sampleRate;
    public String taskId;
    public String token;
    public SAMICoreTokenType tokenType;
    public String url;

    public SAMICoreMultiSpeakerEmbeddingContextCreateParameter() {
    }

    public int getTokenType() {
        SAMICoreTokenType r0 = this.tokenType;
        if (r0 == null) goto L7;
        return r0.getValue();
    L7:
        return SAMICoreTokenType.TOKEN_TO_B.getValue();
    }

    public void setTokenType(int r1) {
        this.tokenType = SAMICoreTokenType.fromInt(r1);
    }
}
