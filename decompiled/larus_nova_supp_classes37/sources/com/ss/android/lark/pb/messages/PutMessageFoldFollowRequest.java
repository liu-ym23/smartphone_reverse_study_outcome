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
public final class PutMessageFoldFollowRequest extends Message<PutMessageFoldFollowRequest, Builder> {
    public static final ProtoAdapter<PutMessageFoldFollowRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MFOLD_ID = null;
    private static final long serialVersionUID = 0;
    public final Integer mcount;
    public final Long mfold_id;

    public static final class Builder extends Message.Builder<PutMessageFoldFollowRequest, Builder> {
        public Integer mcount;
        public Long mfold_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutMessageFoldFollowRequest m1817build() {
            return new PutMessageFoldFollowRequest(this.mfold_id, this.mcount, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1817build();
        }

        public Builder count(Integer r1) {
            this.mcount = r1;
            return this;
        }

        public Builder fold_id(Long r1) {
            this.mfold_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutMessageFoldFollowRequest extends ProtoAdapter<PutMessageFoldFollowRequest> {
        public ProtoAdapter_PutMessageFoldFollowRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageFoldFollowRequest.class);
        }

        public PutMessageFoldFollowRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mfold_id = 0L;
            r0.mcount = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mfold_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mcount = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1817build();
        }

        public int encodedSize(PutMessageFoldFollowRequest r5) {
            Long r0 = r5.mfold_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r5.mcount;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1818decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutMessageFoldFollowRequest) r1);
        }

        public void encode(ProtoWriter r4, PutMessageFoldFollowRequest r5) throws IOException {
            Long r0 = r5.mfold_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mcount;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutMessageFoldFollowRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageFoldFollowRequest();
        FIELD_OPTIONS_MFOLD_ID = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1816newBuilder() {
        Builder r0 = new Builder();
        r0.mfold_id = this.mfold_id;
        r0.mcount = this.mcount;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutMessageFoldFollowRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1816newBuilder();
    }

    public PutMessageFoldFollowRequest(Long r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PutMessageFoldFollowRequest(Long r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mfold_id = r2;
        this.mcount = r3;
    }
}
