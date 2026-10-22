package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChatLinkTokenResponse extends Message<PullChatLinkTokenResponse, Builder> {
    public static final ProtoAdapter<PullChatLinkTokenResponse> ADAPTER = null;
    public static final Long DEFAULT_EXPIRE_TIME = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final String DEFAULT_KOULING = "";
    public static final String DEFAULT_SHARED_URL = "";
    public static final String DEFAULT_TOKEN = "";
    public static final FieldOptions FIELD_OPTIONS_MTOKEN = null;
    private static final long serialVersionUID = 0;
    public final Long mexpire_time;
    public final Boolean mis_unlimited;
    public final String mkouLing;
    public final String mshared_url;
    public final String mtoken;

    public static final class Builder extends Message.Builder<PullChatLinkTokenResponse, Builder> {
        public Long mexpire_time;
        public Boolean mis_unlimited;
        public String mkouLing;
        public String mshared_url;
        public String mtoken;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChatLinkTokenResponse m896build() {
            return new PullChatLinkTokenResponse(this.mtoken, this.mexpire_time, this.mshared_url, this.mkouLing, this.mis_unlimited, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m896build();
        }

        public Builder expire_time(Long r1) {
            this.mexpire_time = r1;
            return this;
        }

        public Builder is_unlimited(Boolean r1) {
            this.mis_unlimited = r1;
            return this;
        }

        public Builder kouLing(String r1) {
            this.mkouLing = r1;
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

    public static final class ProtoAdapter_PullChatLinkTokenResponse extends ProtoAdapter<PullChatLinkTokenResponse> {
        public ProtoAdapter_PullChatLinkTokenResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatLinkTokenResponse.class);
        }

        public PullChatLinkTokenResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtoken = "";
            r0.mexpire_time = 0L;
            r0.mshared_url = "";
            r0.mkouLing = "";
            r0.mis_unlimited = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
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
            if (r3 != 4) goto L14;
            r0.mkouLing = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mis_unlimited = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m896build();
        }

        public int encodedSize(PullChatLinkTokenResponse r6) {
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
            String r10 = r6.mkouLing;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_unlimited;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m897decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChatLinkTokenResponse) r1);
        }

        public void encode(ProtoWriter r4, PullChatLinkTokenResponse r5) throws IOException {
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
            String r3 = r5.mkouLing;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mis_unlimited;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChatLinkTokenResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatLinkTokenResponse();
        FIELD_OPTIONS_MTOKEN = new FieldOptions.Builder().FieldInfo("split,type=chat_token").build();
        DEFAULT_EXPIRE_TIME = 0L;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m895newBuilder() {
        Builder r0 = new Builder();
        r0.mtoken = this.mtoken;
        r0.mexpire_time = this.mexpire_time;
        r0.mshared_url = this.mshared_url;
        r0.mkouLing = this.mkouLing;
        r0.mis_unlimited = this.mis_unlimited;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChatLinkTokenResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m895newBuilder();
    }

    public PullChatLinkTokenResponse(String r8, Long r9, String r10, String r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public PullChatLinkTokenResponse(String r2, Long r3, String r4, String r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mtoken = r2;
        this.mexpire_time = r3;
        this.mshared_url = r4;
        this.mkouLing = r5;
        this.mis_unlimited = r6;
    }
}
