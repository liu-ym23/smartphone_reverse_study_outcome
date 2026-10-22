package com.obric.matrix.proto;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.isSucceed = Boolean.FALSE;
            this.body = "";
            this.serverLogId = "";
        }

        public Builder body(String r5) {
            this.body = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
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
        public GenericNetworkResponse build() {
            Boolean r5 = this.isSucceed;
            if (r5 == null) goto L11;
            if (this.body == null) goto L11;
            if (this.serverLogId == null) goto L11;
            return new GenericNetworkResponse(this.isSucceed, this.body, this.serverLogId, buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r5, "isSucceed", this.body, "body", this.serverLogId, "serverLogId"});
        }
    }

    public static final class ProtoAdapter_GenericNetworkResponse extends ProtoAdapter<GenericNetworkResponse> {
        public ProtoAdapter_GenericNetworkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, GenericNetworkResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GenericNetworkResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GenericNetworkResponse redact(GenericNetworkResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GenericNetworkResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r5.isSucceed(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.body(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L11;
            r5.serverLogId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, GenericNetworkResponse r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.isSucceed);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 2, r10.body);
            r11.encodeWithTag(r5, 3, r10.serverLogId);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GenericNetworkResponse r5) {
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isSucceed);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            int r12 = r11.encodedSizeWithTag(2, r5.body) + r10;
            int r13 = r11.encodedSizeWithTag(3, r5.serverLogId) + r12;
            return r5.unknownFields().size() + r13;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GenericNetworkResponse redact2(GenericNetworkResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenericNetworkResponse();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public GenericNetworkResponse(Boolean r5, String r10, String r11) {
        this(r5, r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GenericNetworkResponse) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r10 = (GenericNetworkResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (this.isSucceed.equals(r10.isSucceed) == false) goto L18;
        if (this.body.equals(r10.body) == false) goto L18;
        if (this.serverLogId.equals(r10.serverLogId) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L6;
        int r10 = unknownFields().hashCode() * 37;
        int r11 = a.c((this.isSucceed.hashCode() + r10) * 37, 37, this.body) + this.serverLogId.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = j0.u(", isSucceed=");
        r5.append(this.isSucceed);
        r5.append(", body=");
        r5.append(this.body);
        r5.append(", serverLogId=");
        r5.append(this.serverLogId);
        return androidx.room.jarjarred.org.antlr.runtime.a.s(r5, 0, 2, "GenericNetworkResponse{", '}');
    }

    public GenericNetworkResponse(Boolean r5, String r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.isSucceed = r5;
        this.body = r10;
        this.serverLogId = r11;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.isSucceed = this.isSucceed;
        r5.body = this.body;
        r5.serverLogId = this.serverLogId;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
