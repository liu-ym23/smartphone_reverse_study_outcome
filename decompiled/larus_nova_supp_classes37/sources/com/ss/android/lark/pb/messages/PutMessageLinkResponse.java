package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutMessageLinkResponse extends Message<PutMessageLinkResponse, Builder> {
    public static final ProtoAdapter<PutMessageLinkResponse> ADAPTER = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_TOKEN_URL = "";
    private static final long serialVersionUID = 0;
    public final String mtoken;
    public final String mtoken_url;

    public static final class Builder extends Message.Builder<PutMessageLinkResponse, Builder> {
        public String mtoken;
        public String mtoken_url;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutMessageLinkResponse m1826build() {
            String r0 = this.mtoken;
            if (r0 == null) goto L9;
            if (this.mtoken_url == null) goto L9;
            return new PutMessageLinkResponse(this.mtoken, this.mtoken_url, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtoken", this.mtoken_url, "mtoken_url"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1826build();
        }

        public Builder token(String r1) {
            this.mtoken = r1;
            return this;
        }

        public Builder token_url(String r1) {
            this.mtoken_url = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutMessageLinkResponse extends ProtoAdapter<PutMessageLinkResponse> {
        public ProtoAdapter_PutMessageLinkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageLinkResponse.class);
        }

        public PutMessageLinkResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtoken = "";
            r0.mtoken_url = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtoken_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1826build();
        }

        public int encodedSize(PutMessageLinkResponse r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mtoken) + r0.encodedSizeWithTag(2, r5.mtoken_url)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1827decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutMessageLinkResponse) r1);
        }

        public void encode(ProtoWriter r4, PutMessageLinkResponse r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mtoken);
            r0.encodeWithTag(r4, 2, r5.mtoken_url);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutMessageLinkResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageLinkResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1825newBuilder() {
        Builder r0 = new Builder();
        r0.mtoken = this.mtoken;
        r0.mtoken_url = this.mtoken_url;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutMessageLinkResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1825newBuilder();
    }

    public PutMessageLinkResponse(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PutMessageLinkResponse(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtoken = r2;
        this.mtoken_url = r3;
    }
}
