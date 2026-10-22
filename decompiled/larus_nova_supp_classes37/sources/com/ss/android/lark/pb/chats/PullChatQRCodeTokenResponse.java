package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChatQRCodeTokenResponse extends Message<PullChatQRCodeTokenResponse, Builder> {
    public static final ProtoAdapter<PullChatQRCodeTokenResponse> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final String DEFAULT_SHARED_URL = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Long mexpire_time;
    public final Boolean mis_unlimited;
    public final String mshared_url;
    public final String mtoken;

    public static final class Builder extends Message.Builder<PullChatQRCodeTokenResponse, Builder> {
        public Long mexpire_time;
        public Boolean mis_unlimited;
        public String mshared_url;
        public String mtoken;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChatQRCodeTokenResponse m902build() {
            return new PullChatQRCodeTokenResponse(this.mtoken, this.mexpire_time, this.mshared_url, this.mis_unlimited, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m902build();
        }

        public Builder expire_time(Long r1) {
            this.mexpire_time = r1;
            return this;
        }

        public Builder is_unlimited(Boolean r1) {
            this.mis_unlimited = r1;
            return this;
        }

        public Builder shared_url(String r1) {
            this.mshared_url = r1;
            return this;
        }

        public Builder token(String r1) {
            this.mtoken = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatQRCodeTokenResponse extends ProtoAdapter<PullChatQRCodeTokenResponse> {
        public ProtoAdapter_PullChatQRCodeTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatQRCodeTokenResponse.class);
        }

        public PullChatQRCodeTokenResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtoken = "";
            r0.mexpire_time = 0L;
            r0.mshared_url = "";
            r0.mis_unlimited = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexpire_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mshared_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mis_unlimited = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m902build();
        }

        public int encodedSize(PullChatQRCodeTokenResponse r6) {
            String r0 = r6.mtoken;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mexpire_time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mshared_url;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_unlimited;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m903decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChatQRCodeTokenResponse) r1);
        }

        public void encode(ProtoWriter r4, PullChatQRCodeTokenResponse r5) throws IOException {
            String r0 = r5.mtoken;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mexpire_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mshared_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mis_unlimited;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChatQRCodeTokenResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatQRCodeTokenResponse();
        DEFAULT_EXPIRE_TIME = 0L;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m901newBuilder() {
        Builder r0 = new Builder();
        r0.mtoken = this.mtoken;
        r0.mexpire_time = this.mexpire_time;
        r0.mshared_url = this.mshared_url;
        r0.mis_unlimited = this.mis_unlimited;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChatQRCodeTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m901newBuilder();
    }

    public PullChatQRCodeTokenResponse(String r7, Long r8, String r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullChatQRCodeTokenResponse(String r2, Long r3, String r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mtoken = r2;
        this.mexpire_time = r3;
        this.mshared_url = r4;
        this.mis_unlimited = r5;
    }
}
