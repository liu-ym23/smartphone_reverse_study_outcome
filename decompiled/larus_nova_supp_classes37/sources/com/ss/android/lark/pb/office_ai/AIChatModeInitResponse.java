package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIChatModeInitResponse extends Message<AIChatModeInitResponse, Builder> {
    public static final ProtoAdapter<AIChatModeInitResponse> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mai_chat_mode_id;
    public final String mchat_id;

    public static final class Builder extends Message.Builder<AIChatModeInitResponse, Builder> {
        public String mai_chat_mode_id;
        public String mchat_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIChatModeInitResponse m1919build() {
            return new AIChatModeInitResponse(this.mai_chat_mode_id, this.mchat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1919build();
        }

        public Builder ai_chat_mode_id(String r1) {
            this.mai_chat_mode_id = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AIChatModeInitResponse extends ProtoAdapter<AIChatModeInitResponse> {
        public ProtoAdapter_AIChatModeInitResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AIChatModeInitResponse.class);
        }

        public AIChatModeInitResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mai_chat_mode_id = "";
            r0.mchat_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mai_chat_mode_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1919build();
        }

        public int encodedSize(AIChatModeInitResponse r5) {
            String r0 = r5.mai_chat_mode_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mchat_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1920decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIChatModeInitResponse) r1);
        }

        public void encode(ProtoWriter r4, AIChatModeInitResponse r5) throws IOException {
            String r0 = r5.mai_chat_mode_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mchat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIChatModeInitResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIChatModeInitResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1918newBuilder() {
        Builder r0 = new Builder();
        r0.mai_chat_mode_id = this.mai_chat_mode_id;
        r0.mchat_id = this.mchat_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIChatModeInitResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1918newBuilder();
    }

    public AIChatModeInitResponse(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public AIChatModeInitResponse(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mai_chat_mode_id = r2;
        this.mchat_id = r3;
    }
}
