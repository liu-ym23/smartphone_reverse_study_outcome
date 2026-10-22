package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class EmptyStateAction extends Message<EmptyStateAction, Builder> {
    public static final ProtoAdapter<EmptyStateAction> ADAPTER = null;
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_MATERIAL_ID = "";
    public static final String DEFAULT_NOTE_URL = "";
    private static final long serialVersionUID = 0;
    public final EmptyStateType mempty_state_type;
    public final String mlocation;
    public final String mmaterial_id;
    public final String mnote_url;

    public static final class Builder extends Message.Builder<EmptyStateAction, Builder> {
        public EmptyStateType mempty_state_type;
        public String mlocation;
        public String mmaterial_id;
        public String mnote_url;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EmptyStateAction m3269build() {
            return new EmptyStateAction(this.mempty_state_type, this.mmaterial_id, this.mnote_url, this.mlocation, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3269build();
        }

        public Builder empty_state_type(EmptyStateType r1) {
            this.mempty_state_type = r1;
            return this;
        }

        public Builder location(String r1) {
            this.mlocation = r1;
            return this;
        }

        public Builder material_id(String r1) {
            this.mmaterial_id = r1;
            return this;
        }

        public Builder note_url(String r1) {
            this.mnote_url = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateAction extends ProtoAdapter<EmptyStateAction> {
        public ProtoAdapter_EmptyStateAction() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateAction.class);
        }

        public EmptyStateAction decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmaterial_id = "";
            r0.mnote_url = "";
            r0.mlocation = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mempty_state_type = (EmptyStateType) EmptyStateType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmaterial_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mnote_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mlocation = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m3269build();
        }

        public int encodedSize(EmptyStateAction r6) {
            EmptyStateType r0 = r6.mempty_state_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = EmptyStateType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mmaterial_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mnote_url;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mlocation;
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
        public /* bridge */ /* synthetic */ Object m3270decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EmptyStateAction) r1);
        }

        public void encode(ProtoWriter r4, EmptyStateAction r5) throws IOException {
            EmptyStateType r0 = r5.mempty_state_type;
            if (r0 == null) goto L5;
            EmptyStateType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mmaterial_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mnote_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mlocation;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EmptyStateAction) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateAction();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3268newBuilder() {
        Builder r0 = new Builder();
        r0.mempty_state_type = this.mempty_state_type;
        r0.mmaterial_id = this.mmaterial_id;
        r0.mnote_url = this.mnote_url;
        r0.mlocation = this.mlocation;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EmptyStateAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3268newBuilder();
    }

    public EmptyStateAction(EmptyStateType r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public EmptyStateAction(EmptyStateType r2, String r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mempty_state_type = r2;
        this.mmaterial_id = r3;
        this.mnote_url = r4;
        this.mlocation = r5;
    }
}
