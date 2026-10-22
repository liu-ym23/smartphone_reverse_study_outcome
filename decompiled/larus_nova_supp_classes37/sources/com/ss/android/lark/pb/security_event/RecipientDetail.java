package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecipientDetail extends Message<RecipientDetail, Builder> {
    public static final ProtoAdapter<RecipientDetail> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PermissionActionType mPermissionActionType;

    public static final class Builder extends Message.Builder<RecipientDetail, Builder> {
        public PermissionActionType mPermissionActionType;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RecipientDetail m2192build() {
            return new RecipientDetail(this.mPermissionActionType, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2192build();
        }

        public Builder PermissionActionType(PermissionActionType r1) {
            this.mPermissionActionType = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RecipientDetail extends ProtoAdapter<RecipientDetail> {
        public ProtoAdapter_RecipientDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, RecipientDetail.class);
        }

        public RecipientDetail decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mPermissionActionType = (PermissionActionType) PermissionActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m2192build();
        }

        public int encodedSize(RecipientDetail r4) {
            PermissionActionType r0 = r4.mPermissionActionType;
            if (r0 == null) goto L5;
            int r1 = PermissionActionType.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2193decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RecipientDetail) r1);
        }

        public void encode(ProtoWriter r4, RecipientDetail r5) throws IOException {
            PermissionActionType r0 = r5.mPermissionActionType;
            if (r0 == null) goto L5;
            PermissionActionType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RecipientDetail) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecipientDetail();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2191newBuilder() {
        Builder r0 = new Builder();
        r0.mPermissionActionType = this.mPermissionActionType;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RecipientDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2191newBuilder();
    }

    public RecipientDetail(PermissionActionType r2) {
        this(r2, ByteString.EMPTY);
    }

    public RecipientDetail(PermissionActionType r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mPermissionActionType = r2;
    }
}
