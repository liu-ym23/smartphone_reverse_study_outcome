package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CheckPutChatChatterRequest extends Message<CheckPutChatChatterRequest, Builder> {
    public static final ProtoAdapter<CheckPutChatChatterRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final List<Long> mchatter_ids;
    public final AddChatChatterSource msource;

    public static final class Builder extends Message.Builder<CheckPutChatChatterRequest, Builder> {
        public Long mchat_id;
        public List<Long> mchatter_ids;
        public AddChatChatterSource msource;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CheckPutChatChatterRequest m869build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new CheckPutChatChatterRequest(this.mchat_id, this.mchatter_ids, this.msource, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
            this.mchatter_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m869build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder chatter_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatter_ids = r1;
            return this;
        }

        public Builder source(AddChatChatterSource r1) {
            this.msource = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPutChatChatterRequest extends ProtoAdapter<CheckPutChatChatterRequest> {
        public ProtoAdapter_CheckPutChatChatterRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPutChatChatterRequest.class);
        }

        public CheckPutChatChatterRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchatter_ids.add((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.msource = (AddChatChatterSource) AddChatChatterSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m869build();
        }

        public int encodedSize(CheckPutChatChatterRequest r5) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            int r1 = r0.encodedSizeWithTag(1, r5.mchat_id) + r0.asRepeated().encodedSizeWithTag(2, r5.mchatter_ids);
            AddChatChatterSource r2 = r5.msource;
            if (r2 == null) goto L5;
            int r3 = AddChatChatterSource.ADAPTER.encodedSizeWithTag(3, r2);
        L7:
            return (r1 + r3) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m870decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CheckPutChatChatterRequest) r1);
        }

        public void encode(ProtoWriter r4, CheckPutChatChatterRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 1, r5.mchat_id);
            r0.asRepeated().encodeWithTag(r4, 2, r5.mchatter_ids);
            AddChatChatterSource r1 = r5.msource;
            if (r1 == null) goto L5;
            AddChatChatterSource.ADAPTER.encodeWithTag(r4, 3, r1);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CheckPutChatChatterRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPutChatChatterRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m868newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mchatter_ids = Internal.copyOf("mchatter_ids", this.mchatter_ids);
        r0.msource = this.msource;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CheckPutChatChatterRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m868newBuilder();
    }

    public CheckPutChatChatterRequest(Long r2, List<Long> r3, AddChatChatterSource r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CheckPutChatChatterRequest(Long r2, List<Long> r3, AddChatChatterSource r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mchat_id = r2;
        this.mchatter_ids = Internal.immutableCopyOf("mchatter_ids", r3);
        this.msource = r4;
    }
}
