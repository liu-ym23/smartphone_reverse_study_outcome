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
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this.subscribeResult = Boolean.FALSE;
            this.ext = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ext(String r5) {
            this.ext = r5;
            return this;
        }

        public Builder subscribeResult(Boolean r5) {
            this.subscribeResult = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByProviderResponse build() {
            return new SubscribeWsMsgByProviderResponse(this.subscribeResult, this.ext, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByProviderResponse extends ProtoAdapter<SubscribeWsMsgByProviderResponse> {
        public ProtoAdapter_SubscribeWsMsgByProviderResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SubscribeWsMsgByProviderResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByProviderResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderResponse redact(SubscribeWsMsgByProviderResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByProviderResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.subscribeResult(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.ext(ProtoAdapter.STRING.decode(r10));
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
        public void encode2(ProtoWriter r5, SubscribeWsMsgByProviderResponse r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r10.ext);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByProviderResponse r5) {
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.subscribeResult);
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(2, r5.ext) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByProviderResponse redact2(SubscribeWsMsgByProviderResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByProviderResponse();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r5, String r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByProviderResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r10 = (SubscribeWsMsgByProviderResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.subscribeResult, r10.subscribeResult) == false) goto L16;
        if (Internal.equals(this.ext, r10.ext) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        Boolean r11 = this.subscribeResult;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.ext;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        int r16 = r14 + r12;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.subscribeResult == null) goto L6;
        r5.append(", subscribeResult=");
        r5.append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L9;
        r5.append(", ext=");
        r5.append(this.ext);
    L9:
        return a.s(r5, 0, 2, "SubscribeWsMsgByProviderResponse{", '}');
    }

    public SubscribeWsMsgByProviderResponse(Boolean r5, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.subscribeResult = r5;
        this.ext = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.subscribeResult = this.subscribeResult;
        r5.ext = this.ext;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
