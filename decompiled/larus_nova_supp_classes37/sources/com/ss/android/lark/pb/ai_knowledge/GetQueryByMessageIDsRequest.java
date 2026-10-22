package com.ss.android.lark.pb.ai_knowledge;

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
public final class GetQueryByMessageIDsRequest extends Message<GetQueryByMessageIDsRequest, Builder> {
    public static final ProtoAdapter<GetQueryByMessageIDsRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_LEAVE_NOTE = "";
    public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final String mleave_note;
    public final List<Long> mmessage_ids;
    public final String morigin_merge_forward_id;

    public static final class Builder extends Message.Builder<GetQueryByMessageIDsRequest, Builder> {
        public Long mchat_id;
        public String mleave_note;
        public List<Long> mmessage_ids;
        public String morigin_merge_forward_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetQueryByMessageIDsRequest m794build() {
            return new GetQueryByMessageIDsRequest(this.mchat_id, this.mmessage_ids, this.morigin_merge_forward_id, this.mleave_note, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m794build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder leave_note(String r1) {
            this.mleave_note = r1;
            return this;
        }

        public Builder message_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessage_ids = r1;
            return this;
        }

        public Builder origin_merge_forward_id(String r1) {
            this.morigin_merge_forward_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetQueryByMessageIDsRequest extends ProtoAdapter<GetQueryByMessageIDsRequest> {
        public ProtoAdapter_GetQueryByMessageIDsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetQueryByMessageIDsRequest.class);
        }

        public GetQueryByMessageIDsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.morigin_merge_forward_id = "";
            r0.mleave_note = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmessage_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.morigin_merge_forward_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mleave_note = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m794build();
        }

        public int encodedSize(GetQueryByMessageIDsRequest r6) {
            Long r0 = r6.mchat_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r6.mmessage_ids);
            String r4 = r6.morigin_merge_forward_id;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.STRING.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.mleave_note;
            if (r8 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            return (r7 + r1) + r6.unknownFields().size();
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m795decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetQueryByMessageIDsRequest) r1);
        }

        public void encode(ProtoWriter r4, GetQueryByMessageIDsRequest r5) throws IOException {
            Long r0 = r5.mchat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 2, r5.mmessage_ids);
            String r1 = r5.morigin_merge_forward_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.mleave_note;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetQueryByMessageIDsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetQueryByMessageIDsRequest();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m793newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r0.morigin_merge_forward_id = this.morigin_merge_forward_id;
        r0.mleave_note = this.mleave_note;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetQueryByMessageIDsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m793newBuilder();
    }

    public GetQueryByMessageIDsRequest(Long r7, List<Long> r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public GetQueryByMessageIDsRequest(Long r2, List<Long> r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchat_id = r2;
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r3);
        this.morigin_merge_forward_id = r4;
        this.mleave_note = r5;
    }
}
