package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MessageLastVisibleInfoPatch extends com.squareup.wire.Message<MessageLastVisibleInfoPatch, Builder> {
    public static final ProtoAdapter<MessageLastVisibleInfoPatch> ADAPTER = null;
    public static final Long DEFAULT_REMOVED_LAST_ID = null;
    public static final Integer DEFAULT_REMOVED_LAST_POSITION = null;
    public static final Long DEFAULT_VISIBLE_ID = null;
    public static final Integer DEFAULT_VISIBLE_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Long mremoved_last_id;
    public final Integer mremoved_last_position;
    public final Long mvisible_id;
    public final Integer mvisible_position;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLastVisibleInfoPatch, Builder> {
        public Long mremoved_last_id;
        public Integer mremoved_last_position;
        public Long mvisible_id;
        public Integer mvisible_position;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageLastVisibleInfoPatch m1343build() {
            return new MessageLastVisibleInfoPatch(this.mvisible_id, this.mvisible_position, this.mremoved_last_position, this.mremoved_last_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1343build();
        }

        public Builder removed_last_id(Long r1) {
            this.mremoved_last_id = r1;
            return this;
        }

        public Builder removed_last_position(Integer r1) {
            this.mremoved_last_position = r1;
            return this;
        }

        public Builder visible_id(Long r1) {
            this.mvisible_id = r1;
            return this;
        }

        public Builder visible_position(Integer r1) {
            this.mvisible_position = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageLastVisibleInfoPatch extends ProtoAdapter<MessageLastVisibleInfoPatch> {
        public ProtoAdapter_MessageLastVisibleInfoPatch() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLastVisibleInfoPatch.class);
        }

        public MessageLastVisibleInfoPatch decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mvisible_id = 0L;
            r0.mvisible_position = 0;
            r0.mremoved_last_position = 0;
            r0.mremoved_last_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mvisible_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mvisible_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mremoved_last_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mremoved_last_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1343build();
        }

        public int encodedSize(MessageLastVisibleInfoPatch r6) {
            Long r0 = r6.mvisible_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mvisible_position;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mremoved_last_position;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Long r10 = r6.mremoved_last_id;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1344decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageLastVisibleInfoPatch) r1);
        }

        public void encode(ProtoWriter r4, MessageLastVisibleInfoPatch r5) throws IOException {
            Long r0 = r5.mvisible_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mvisible_position;
            if (r1 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mremoved_last_position;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            Long r3 = r5.mremoved_last_id;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageLastVisibleInfoPatch) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLastVisibleInfoPatch();
        DEFAULT_VISIBLE_ID = 0L;
        DEFAULT_VISIBLE_POSITION = 0;
        DEFAULT_REMOVED_LAST_POSITION = 0;
        DEFAULT_REMOVED_LAST_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1342newBuilder() {
        Builder r0 = new Builder();
        r0.mvisible_id = this.mvisible_id;
        r0.mvisible_position = this.mvisible_position;
        r0.mremoved_last_position = this.mremoved_last_position;
        r0.mremoved_last_id = this.mremoved_last_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageLastVisibleInfoPatch.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1342newBuilder();
    }

    public MessageLastVisibleInfoPatch(Long r7, Integer r8, Integer r9, Long r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public MessageLastVisibleInfoPatch(Long r2, Integer r3, Integer r4, Long r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mvisible_id = r2;
        this.mvisible_position = r3;
        this.mremoved_last_position = r4;
        this.mremoved_last_id = r5;
    }
}
