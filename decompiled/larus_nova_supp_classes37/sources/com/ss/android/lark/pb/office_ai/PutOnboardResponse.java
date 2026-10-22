package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutOnboardResponse extends Message<PutOnboardResponse, Builder> {
    public static final ProtoAdapter<PutOnboardResponse> ADAPTER = null;
    public static final Long DEFAULT_AI_CHAT_MODE_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mai_chat_mode_id;

    public static final class Builder extends Message.Builder<PutOnboardResponse, Builder> {
        public Long mai_chat_mode_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutOnboardResponse m2003build() {
            return new PutOnboardResponse(this.mai_chat_mode_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2003build();
        }

        public Builder ai_chat_mode_id(Long r1) {
            this.mai_chat_mode_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutOnboardResponse extends ProtoAdapter<PutOnboardResponse> {
        public ProtoAdapter_PutOnboardResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutOnboardResponse.class);
        }

        public PutOnboardResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mai_chat_mode_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mai_chat_mode_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2003build();
        }

        public int encodedSize(PutOnboardResponse r4) {
            Long r0 = r4.mai_chat_mode_id;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2004decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutOnboardResponse) r1);
        }

        public void encode(ProtoWriter r4, PutOnboardResponse r5) throws IOException {
            Long r0 = r5.mai_chat_mode_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutOnboardResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutOnboardResponse();
        DEFAULT_AI_CHAT_MODE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2002newBuilder() {
        Builder r0 = new Builder();
        r0.mai_chat_mode_id = this.mai_chat_mode_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutOnboardResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2002newBuilder();
    }

    public PutOnboardResponse(Long r2) {
        this(r2, ByteString.EMPTY);
    }

    public PutOnboardResponse(Long r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mai_chat_mode_id = r2;
    }
}
