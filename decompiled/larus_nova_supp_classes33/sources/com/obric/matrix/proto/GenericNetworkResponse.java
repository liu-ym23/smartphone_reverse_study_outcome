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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class GenericNetworkResponse extends Message<GenericNetworkResponse, Builder> {
    public static final ProtoAdapter<GenericNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String body;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String serverLogId;

    public static final class Builder extends Message.Builder<GenericNetworkResponse, Builder> {
        public String body;
        public Boolean isSucceed;
        public String serverLogId;

        public GenericNetworkResponse build() {
            Boolean r0 = this.isSucceed;
            if (r0 == null) goto L11;
            if (this.body == null) goto L11;
            if (this.serverLogId == null) goto L11;
            return new GenericNetworkResponse(this.isSucceed, this.body, this.serverLogId, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "isSucceed", this.body, "body", this.serverLogId, "serverLogId"});
        }

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m90build() {
            return build();
        }

        public Builder body(String r1) {
            this.body = r1;
            return this;
        }

        public Builder isSucceed(Boolean r1) {
            this.isSucceed = r1;
            return this;
        }

        public Builder serverLogId(String r1) {
            this.serverLogId = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GenericNetworkResponse extends ProtoAdapter<GenericNetworkResponse> {
        public ProtoAdapter_GenericNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        public GenericNetworkResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.isSucceed((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.body((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.serverLogId((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GenericNetworkResponse r5) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isSucceed);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return ((r0 + r1.encodedSizeWithTag(2, r5.body)) + r1.encodedSizeWithTag(3, r5.serverLogId)) + r5.unknownFields().size();
        }

        public GenericNetworkResponse redact(GenericNetworkResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m91decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GenericNetworkResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GenericNetworkResponse) r1);
        }

        public void encode(ProtoWriter r4, GenericNetworkResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isSucceed);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.body);
            r0.encodeWithTag(r4, 3, r5.serverLogId);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GenericNetworkResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.isSucceed.hashCode()) * 37) + this.body.hashCode()) * 37) + this.serverLogId.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isSucceed = this.isSucceed;
        r0.body = this.body;
        r0.serverLogId = this.serverLogId;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", isSucceed=");
        r0.append(this.isSucceed);
        r0.append(", body=");
        r0.append(this.body);
        r0.append(", serverLogId=");
        r0.append(this.serverLogId);
        StringBuilder r1 = r0.replace(0, 2, "GenericNetworkResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m89newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkResponse) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r6 = (GenericNetworkResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.isSucceed.equals(r6.isSucceed) == false) goto L17;
        if (this.body.equals(r6.body) == false) goto L17;
        if (this.serverLogId.equals(r6.serverLogId) == false) goto L17;
        return true;
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.isSucceed = r2;
        this.body = r3;
        this.serverLogId = r4;
    }
}
