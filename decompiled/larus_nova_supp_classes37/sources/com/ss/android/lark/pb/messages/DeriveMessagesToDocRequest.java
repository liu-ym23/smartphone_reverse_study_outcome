package com.ss.android.lark.pb.messages;

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
public final class DeriveMessagesToDocRequest extends Message<DeriveMessagesToDocRequest, Builder> {
    public static final ProtoAdapter<DeriveMessagesToDocRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_USER_TIME_ZONE = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final List<Long> mmessage_ids;
    public final String muser_time_zone;

    public static final class Builder extends Message.Builder<DeriveMessagesToDocRequest, Builder> {
        public Long mchat_id;
        public List<Long> mmessage_ids;
        public String muser_time_zone;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DeriveMessagesToDocRequest m1796build() {
            return new DeriveMessagesToDocRequest(this.muser_time_zone, this.mchat_id, this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1796build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder message_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessage_ids = r1;
            return this;
        }

        public Builder user_time_zone(String r1) {
            this.muser_time_zone = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DeriveMessagesToDocRequest extends ProtoAdapter<DeriveMessagesToDocRequest> {
        public ProtoAdapter_DeriveMessagesToDocRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeriveMessagesToDocRequest.class);
        }

        public DeriveMessagesToDocRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.muser_time_zone = "";
            r0.mchat_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.muser_time_zone = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mmessage_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1796build();
        }

        public int encodedSize(DeriveMessagesToDocRequest r5) {
            String r0 = r5.muser_time_zone;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r5.mchat_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r5.mmessage_ids)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1797decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DeriveMessagesToDocRequest) r1);
        }

        public void encode(ProtoWriter r4, DeriveMessagesToDocRequest r5) throws IOException {
            String r0 = r5.muser_time_zone;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mchat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 3, r5.mmessage_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DeriveMessagesToDocRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeriveMessagesToDocRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1795newBuilder() {
        Builder r0 = new Builder();
        r0.muser_time_zone = this.muser_time_zone;
        r0.mchat_id = this.mchat_id;
        r0.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DeriveMessagesToDocRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1795newBuilder();
    }

    public DeriveMessagesToDocRequest(String r2, Long r3, List<Long> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DeriveMessagesToDocRequest(String r2, Long r3, List<Long> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.muser_time_zone = r2;
        this.mchat_id = r3;
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r4);
    }
}
