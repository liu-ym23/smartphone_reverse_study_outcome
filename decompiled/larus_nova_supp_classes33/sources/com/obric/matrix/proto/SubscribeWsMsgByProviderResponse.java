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
public final class SubscribeWsMsgByProviderResponse extends Message<SubscribeWsMsgByProviderResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderResponse> ADAPTER = null;
    public static final String DEFAULT_EXT = "";
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ext;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByProviderResponse, Builder> {
        public String ext;
        public Boolean subscribeResult;

        public SubscribeWsMsgByProviderResponse build() {
            return new SubscribeWsMsgByProviderResponse(this.subscribeResult, this.ext, super.buildUnknownFields());
        }

        public Builder() {
            this.subscribeResult = Boolean.FALSE;
            this.ext = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m212build() {
            return build();
        }

        public Builder ext(String r1) {
            this.ext = r1;
            return this;
        }

        public Builder subscribeResult(Boolean r1) {
            this.subscribeResult = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByProviderResponse extends ProtoAdapter<SubscribeWsMsgByProviderResponse> {
        public ProtoAdapter_SubscribeWsMsgByProviderResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        public SubscribeWsMsgByProviderResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.subscribeResult((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.ext((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsMsgByProviderResponse r5) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.subscribeResult) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.ext)) + r5.unknownFields().size();
        }

        public SubscribeWsMsgByProviderResponse redact(SubscribeWsMsgByProviderResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m213decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsMsgByProviderResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsMsgByProviderResponse) r1);
        }

        public void encode(ProtoWriter r4, SubscribeWsMsgByProviderResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.ext);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsMsgByProviderResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByProviderResponse();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.subscribeResult;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.ext;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.subscribeResult = this.subscribeResult;
        r0.ext = this.ext;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.subscribeResult == null) goto L6;
        r0.append(", subscribeResult=");
        r0.append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L8;
        r0.append(", ext=");
        r0.append(this.ext);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsMsgByProviderResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m211newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByProviderResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r6 = (SubscribeWsMsgByProviderResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.subscribeResult, r6.subscribeResult) == false) goto L15;
        if (Internal.equals(this.ext, r6.ext) == false) goto L15;
        return true;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SubscribeWsMsgByProviderResponse(Boolean r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.subscribeResult = r2;
        this.ext = r3;
    }
}
