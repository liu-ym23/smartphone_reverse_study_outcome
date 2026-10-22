package com.ss.android.lark.chat.entity.message;

import java.io.Serializable;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CardActionPacket implements Serializable {
    private String cid;
    private CardAction.Parameters parameters;
    private ByteString payload;

    public CardActionPacket() {
    }

    public String getCid() {
        return this.cid;
    }

    public CardAction.Parameters getParameters() {
        return this.parameters;
    }

    public ByteString getPayload() {
        return this.payload;
    }

    public void setCid(String r1) {
        this.cid = r1;
    }

    public void setParameters(CardAction.Parameters r1) {
        this.parameters = r1;
    }

    public void setPayload(ByteString r1) {
        this.payload = r1;
    }
}
