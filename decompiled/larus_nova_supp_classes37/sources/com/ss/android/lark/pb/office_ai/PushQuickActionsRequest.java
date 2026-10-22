package com.ss.android.lark.pb.office_ai;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PushQuickActionsRequest extends Message<PushQuickActionsRequest, Builder> {
    public static final ProtoAdapter<PushQuickActionsRequest> ADAPTER = null;
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ROUND_ID = "";
    public static final String DEFAULT_ROUND_LAST_POSITION = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mai_chat_mode_id;
    public final String mchat_id;
    public final String mround_id;
    public final String mround_last_position;

    public static final class Builder extends Message.Builder<PushQuickActionsRequest, Builder> {
        public String mai_chat_mode_id;
        public String mchat_id;
        public String mround_id;
        public String mround_last_position;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PushQuickActionsRequest m1997build() {
            return new PushQuickActionsRequest(this.mchat_id, this.mai_chat_mode_id, this.mround_id, this.mround_last_position, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1997build();
        }

        public Builder ai_chat_mode_id(String r1) {
            this.mai_chat_mode_id = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder round_id(String r1) {
            this.mround_id = r1;
            return this;
        }

        public Builder round_last_position(String r1) {
            this.mround_last_position = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushQuickActionsRequest extends ProtoAdapter<PushQuickActionsRequest> {
        public ProtoAdapter_PushQuickActionsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushQuickActionsRequest.class);
        }

        public PushQuickActionsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            r0.mai_chat_mode_id = "";
            r0.mround_id = "";
            r0.mround_last_position = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mai_chat_mode_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mround_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mround_last_position = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1997build();
        }

        public int encodedSize(PushQuickActionsRequest r6) {
            String r0 = r6.mchat_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mai_chat_mode_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mround_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mround_last_position;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1998decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushQuickActionsRequest) r1);
        }

        public void encode(ProtoWriter r4, PushQuickActionsRequest r5) throws IOException {
            String r0 = r5.mchat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mai_chat_mode_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mround_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mround_last_position;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushQuickActionsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushQuickActionsRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1996newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mai_chat_mode_id = this.mai_chat_mode_id;
        r0.mround_id = this.mround_id;
        r0.mround_last_position = this.mround_last_position;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushQuickActionsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1996newBuilder();
    }

    public PushQuickActionsRequest(String r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PushQuickActionsRequest(String r2, String r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchat_id = r2;
        this.mai_chat_mode_id = r3;
        this.mround_id = r4;
        this.mround_last_position = r5;
    }
}
