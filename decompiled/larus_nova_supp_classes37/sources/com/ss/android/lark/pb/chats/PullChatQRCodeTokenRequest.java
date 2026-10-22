package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChatQRCodeTokenRequest extends Message<PullChatQRCodeTokenRequest, Builder> {
    public static final ProtoAdapter<PullChatQRCodeTokenRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_EXPIRED_DAY = null;
    public static final Boolean DEFAULT_IS_UNLIMITED = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Integer mexpired_day;
    public final Boolean mis_unlimited;

    public static final class Builder extends Message.Builder<PullChatQRCodeTokenRequest, Builder> {
        public String mchat_id;
        public Integer mexpired_day;
        public Boolean mis_unlimited;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChatQRCodeTokenRequest m899build() {
            String r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new PullChatQRCodeTokenRequest(this.mchat_id, this.mexpired_day, this.mis_unlimited, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m899build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder expired_day(Integer r1) {
            this.mexpired_day = r1;
            return this;
        }

        public Builder is_unlimited(Boolean r1) {
            this.mis_unlimited = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChatQRCodeTokenRequest extends ProtoAdapter<PullChatQRCodeTokenRequest> {
        public ProtoAdapter_PullChatQRCodeTokenRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChatQRCodeTokenRequest.class);
        }

        public PullChatQRCodeTokenRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            r0.mexpired_day = 7;
            r0.mis_unlimited = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mexpired_day = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mis_unlimited = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m899build();
        }

        public int encodedSize(PullChatQRCodeTokenRequest r6) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r6.mchat_id);
            Integer r1 = r6.mexpired_day;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.INT32.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Boolean r5 = r6.mis_unlimited;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m900decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChatQRCodeTokenRequest) r1);
        }

        public void encode(ProtoWriter r4, PullChatQRCodeTokenRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mchat_id);
            Integer r0 = r5.mexpired_day;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r0);
        L5:
            Boolean r1 = r5.mis_unlimited;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChatQRCodeTokenRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChatQRCodeTokenRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_EXPIRED_DAY = 7;
        DEFAULT_IS_UNLIMITED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m898newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mexpired_day = this.mexpired_day;
        r0.mis_unlimited = this.mis_unlimited;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChatQRCodeTokenRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m898newBuilder();
    }

    public PullChatQRCodeTokenRequest(String r2, Integer r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullChatQRCodeTokenRequest(String r2, Integer r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mchat_id = r2;
        this.mexpired_day = r3;
        this.mis_unlimited = r4;
    }
}
