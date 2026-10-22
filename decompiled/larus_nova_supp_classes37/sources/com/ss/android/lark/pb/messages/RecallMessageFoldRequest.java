package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecallMessageFoldRequest extends Message<RecallMessageFoldRequest, Builder> {
    public static final ProtoAdapter<RecallMessageFoldRequest> ADAPTER = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final Boolean DEFAULT_RECALL_BY_GROUP_ADMIN = null;
    public static final FieldOptions FIELD_OPTIONS_MFOLD_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mfold_id;
    public final Boolean mrecall_by_group_admin;

    public static final class Builder extends Message.Builder<RecallMessageFoldRequest, Builder> {
        public Long mfold_id;
        public Boolean mrecall_by_group_admin;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RecallMessageFoldRequest m1829build() {
            return new RecallMessageFoldRequest(this.mfold_id, this.mrecall_by_group_admin, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1829build();
        }

        public Builder fold_id(Long r1) {
            this.mfold_id = r1;
            return this;
        }

        public Builder recall_by_group_admin(Boolean r1) {
            this.mrecall_by_group_admin = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallMessageFoldRequest extends ProtoAdapter<RecallMessageFoldRequest> {
        public ProtoAdapter_RecallMessageFoldRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallMessageFoldRequest.class);
        }

        public RecallMessageFoldRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mfold_id = 0L;
            r0.mrecall_by_group_admin = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mfold_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mrecall_by_group_admin = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1829build();
        }

        public int encodedSize(RecallMessageFoldRequest r5) {
            Long r0 = r5.mfold_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mrecall_by_group_admin;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1830decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RecallMessageFoldRequest) r1);
        }

        public void encode(ProtoWriter r4, RecallMessageFoldRequest r5) throws IOException {
            Long r0 = r5.mfold_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mrecall_by_group_admin;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RecallMessageFoldRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecallMessageFoldRequest();
        FIELD_OPTIONS_MFOLD_ID = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_RECALL_BY_GROUP_ADMIN = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1828newBuilder() {
        Builder r0 = new Builder();
        r0.mfold_id = this.mfold_id;
        r0.mrecall_by_group_admin = this.mrecall_by_group_admin;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RecallMessageFoldRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1828newBuilder();
    }

    public RecallMessageFoldRequest(Long r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RecallMessageFoldRequest(Long r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mfold_id = r2;
        this.mrecall_by_group_admin = r3;
    }
}
