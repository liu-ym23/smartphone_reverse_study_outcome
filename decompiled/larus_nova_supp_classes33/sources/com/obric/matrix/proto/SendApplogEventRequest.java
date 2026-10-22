package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SendApplogEventRequest extends Message<SendApplogEventRequest, Builder> {
    public static final ProtoAdapter<SendApplogEventRequest> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String appid;

    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> eventMap;

    public static final class Builder extends Message.Builder<SendApplogEventRequest, Builder> {
        public String appid;
        public Map<String, String> eventMap;

        public SendApplogEventRequest build() {
            return new SendApplogEventRequest(this.appid, this.eventMap, super.buildUnknownFields());
        }

        public Builder() {
            this.appid = "";
            this.eventMap = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m173build() {
            return build();
        }

        public Builder appid(String r1) {
            this.appid = r1;
            return this;
        }

        public Builder eventMap(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.eventMap = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SendApplogEventRequest extends ProtoAdapter<SendApplogEventRequest> {
        private final ProtoAdapter<Map<String, String>> eventMap;

        public ProtoAdapter_SendApplogEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.eventMap = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SendApplogEventRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.appid((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.eventMap.putAll((Map) this.eventMap.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SendApplogEventRequest r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.appid) + this.eventMap.encodedSizeWithTag(2, r5.eventMap)) + r5.unknownFields().size();
        }

        public SendApplogEventRequest redact(SendApplogEventRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m174decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SendApplogEventRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SendApplogEventRequest) r1);
        }

        public void encode(ProtoWriter r4, SendApplogEventRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.appid);
            this.eventMap.encodeWithTag(r4, 2, r5.eventMap);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SendApplogEventRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendApplogEventRequest();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.appid;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.eventMap.hashCode();
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.appid = this.appid;
        r0.eventMap = Internal.copyOf("eventMap", this.eventMap);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.appid == null) goto L5;
        r0.append(", appid=");
        r0.append(this.appid);
    L5:
        Map<String, String> r1 = this.eventMap;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r2 = r0.replace(0, 2, "SendApplogEventRequest{");
        r2.append('}');
        return r2.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", eventMap=");
        r0.append(this.eventMap);
        goto L10
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m172newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendApplogEventRequest) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r6 = (SendApplogEventRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.appid, r6.appid) == false) goto L15;
        if (this.eventMap.equals(r6.eventMap) == false) goto L15;
        return true;
    }

    public SendApplogEventRequest(String r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SendApplogEventRequest(String r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.appid = r2;
        this.eventMap = Internal.immutableCopyOf("eventMap", r3);
    }
}
