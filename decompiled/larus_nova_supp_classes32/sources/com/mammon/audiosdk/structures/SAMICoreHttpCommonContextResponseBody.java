package com.mammon.audiosdk.structures;

import com.mammon.audiosdk.enums.SAMICoreHttpPayloadType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreHttpCommonContextResponseBody {
    public String apiNamespace;
    public byte[] data;
    public Object payload;
    public SAMICoreHttpPayloadType payloadType;
    public int statusCode;
    public String statusText;
    public String taskId;

    public SAMICoreHttpCommonContextResponseBody() {
    }

    public int getPayloadType() {
        SAMICoreHttpPayloadType r0 = this.payloadType;
        if (r0 != null) goto L5;
        System.out.println("payloadType is null, return 0 as fallback!");
        return 0;
    L5:
        return r0.getValue();
    }

    public void setPayloadType(int r1) {
        this.payloadType = SAMICoreHttpPayloadType.fromInt(r1);
    }
}
