package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.appid = "";
            this.eventMap = Internal.newMutableMap();
        }

        public Builder appid(String r5) {
            this.appid = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder eventMap(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.eventMap = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SendApplogEventRequest build() {
            return new SendApplogEventRequest(this.appid, this.eventMap, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SendApplogEventRequest extends ProtoAdapter<SendApplogEventRequest> {
        private final ProtoAdapter<Map<String, String>> eventMap;

        public ProtoAdapter_SendApplogEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.eventMap = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SendApplogEventRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SendApplogEventRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SendApplogEventRequest redact(SendApplogEventRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SendApplogEventRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.appid(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.eventMap.putAll(this.eventMap.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SendApplogEventRequest r10) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r10.appid);
            this.eventMap.encodeWithTag(r5, 2, r10.eventMap);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SendApplogEventRequest r5) {
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.appid);
            int r11 = this.eventMap.encodedSizeWithTag(2, r5.eventMap) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SendApplogEventRequest redact2(SendApplogEventRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendApplogEventRequest();
    }

    public SendApplogEventRequest(String r5, Map<String, String> r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendApplogEventRequest) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r10 = (SendApplogEventRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.appid, r10.appid) == false) goto L16;
        if (this.eventMap.equals(r10.eventMap) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.appid;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = ((r10 + r12) * 37) + this.eventMap.hashCode();
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.appid == null) goto L5;
        r5.append(", appid=");
        r5.append(this.appid);
    L5:
        Map<String, String> r10 = this.eventMap;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", eventMap=");
        r5.append(this.eventMap);
    L11:
        return a.s(r5, 0, 2, "SendApplogEventRequest{", '}');
    }

    public SendApplogEventRequest(String r5, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.appid = r5;
        this.eventMap = Internal.immutableCopyOf("eventMap", r10);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.appid = this.appid;
        r5.eventMap = Internal.copyOf("eventMap", this.eventMap);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
