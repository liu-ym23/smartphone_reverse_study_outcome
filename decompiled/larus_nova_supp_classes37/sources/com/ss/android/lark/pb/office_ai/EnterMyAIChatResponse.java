package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EnterMyAIChatResponse extends Message<EnterMyAIChatResponse, Builder> {
    public static final ProtoAdapter<EnterMyAIChatResponse> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    public static final Boolean DEFAULT_NEED_ONBOARD = null;
    private static final long serialVersionUID = 0;
    public final Long mai_chat_mode_id;
    public final Boolean mneed_onboard;

    public static final class Builder extends Message.Builder<EnterMyAIChatResponse, Builder> {
        public Long mai_chat_mode_id;
        public Boolean mneed_onboard;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EnterMyAIChatResponse m1943build() {
            return new EnterMyAIChatResponse(this.mneed_onboard, this.mai_chat_mode_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1943build();
        }

        public Builder ai_chat_mode_id(Long r1) {
            this.mai_chat_mode_id = r1;
            return this;
        }

        public Builder need_onboard(Boolean r1) {
            this.mneed_onboard = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EnterMyAIChatResponse extends ProtoAdapter<EnterMyAIChatResponse> {
        public ProtoAdapter_EnterMyAIChatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, EnterMyAIChatResponse.class);
        }

        public EnterMyAIChatResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mneed_onboard = Boolean.FALSE;
            r0.mai_chat_mode_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mneed_onboard = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mai_chat_mode_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1943build();
        }

        public int encodedSize(EnterMyAIChatResponse r5) {
            Boolean r0 = r5.mneed_onboard;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r5.mai_chat_mode_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1944decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EnterMyAIChatResponse) r1);
        }

        public void encode(ProtoWriter r4, EnterMyAIChatResponse r5) throws IOException {
            Boolean r0 = r5.mneed_onboard;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mai_chat_mode_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EnterMyAIChatResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnterMyAIChatResponse();
        DEFAULT_NEED_ONBOARD = Boolean.FALSE;
        DEFAULT_AI_CHAT_MODE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1942newBuilder() {
        Builder r0 = new Builder();
        r0.mneed_onboard = this.mneed_onboard;
        r0.mai_chat_mode_id = this.mai_chat_mode_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EnterMyAIChatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1942newBuilder();
    }

    public EnterMyAIChatResponse(Boolean r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public EnterMyAIChatResponse(Boolean r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mneed_onboard = r2;
        this.mai_chat_mode_id = r3;
    }
}
