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
public final class OnePartyCommonNetworkResponse extends Message<OnePartyCommonNetworkResponse, Builder> {
    public static final ProtoAdapter<OnePartyCommonNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extraMap;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<OnePartyCommonNetworkResponse, Builder> {
        public String body;
        public Map<String, String> extraMap;
        public Boolean isSucceed;
        public String serverLogId;

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
            this.extraMap = Internal.newMutableMap();
        }

        public Builder body(String r5) {
            this.body = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extraMap(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.extraMap = r5;
            return this;
        }

        public Builder isSucceed(Boolean r5) {
            this.isSucceed = r5;
            return this;
        }

        public Builder serverLogId(String r5) {
            this.serverLogId = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public OnePartyCommonNetworkResponse build() {
            return new OnePartyCommonNetworkResponse(this.isSucceed, this.body, this.serverLogId, this.extraMap, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_OnePartyCommonNetworkResponse extends ProtoAdapter<OnePartyCommonNetworkResponse> {
        private final ProtoAdapter<Map<String, String>> extraMap;

        public ProtoAdapter_OnePartyCommonNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkResponse.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.extraMap = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, OnePartyCommonNetworkResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkResponse redact(OnePartyCommonNetworkResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OnePartyCommonNetworkResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r5.isSucceed(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.body(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r5.serverLogId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r5.extraMap.putAll(this.extraMap.decode(r10));
            goto L3
        L13:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, OnePartyCommonNetworkResponse r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.isSucceed);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 2, r10.body);
            r11.encodeWithTag(r5, 3, r10.serverLogId);
            this.extraMap.encodeWithTag(r5, 4, r10.extraMap);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OnePartyCommonNetworkResponse r5) {
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isSucceed);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            int r12 = r11.encodedSizeWithTag(2, r5.body) + r10;
            int r13 = r11.encodedSizeWithTag(3, r5.serverLogId) + r12;
            int r14 = this.extraMap.encodedSizeWithTag(4, r5.extraMap) + r13;
            return r5.unknownFields().size() + r14;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public OnePartyCommonNetworkResponse redact2(OnePartyCommonNetworkResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OnePartyCommonNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public OnePartyCommonNetworkResponse(Boolean r10, String r11, String r12, Map<String, String> r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof OnePartyCommonNetworkResponse) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkResponse r10 = (OnePartyCommonNetworkResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.isSucceed, r10.isSucceed) == false) goto L20;
        if (Internal.equals(this.body, r10.body) == false) goto L20;
        if (Internal.equals(this.serverLogId, r10.serverLogId) == false) goto L20;
        if (this.extraMap.equals(r10.extraMap) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        Boolean r11 = this.isSucceed;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.body;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.serverLogId;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = ((r17 + r12) * 37) + this.extraMap.hashCode();
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.isSucceed == null) goto L6;
        r5.append(", isSucceed=");
        r5.append(this.isSucceed);
    L6:
        if (this.body == null) goto L9;
        r5.append(", body=");
        r5.append(this.body);
    L9:
        if (this.serverLogId == null) goto L11;
        r5.append(", serverLogId=");
        r5.append(this.serverLogId);
    L11:
        Map<String, String> r10 = this.extraMap;
        if (r10 == null) goto L17;
        if (r10.isEmpty() == true) goto L17;
        r5.append(", extraMap=");
        r5.append(this.extraMap);
    L17:
        return a.s(r5, 0, 2, "OnePartyCommonNetworkResponse{", '}');
    }

    public OnePartyCommonNetworkResponse(Boolean r5, String r10, String r11, Map<String, String> r12, ByteString r13) {
        super(ADAPTER, r13);
        this.isSucceed = r5;
        this.body = r10;
        this.serverLogId = r11;
        this.extraMap = Internal.immutableCopyOf("extraMap", r12);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.isSucceed = this.isSucceed;
        r5.body = this.body;
        r5.serverLogId = this.serverLogId;
        r5.extraMap = Internal.copyOf("extraMap", this.extraMap);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
