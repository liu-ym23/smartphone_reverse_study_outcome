package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullDoubaoSearchQueryHistoryRequest extends Message<PullDoubaoSearchQueryHistoryRequest, Builder> {
    public static final ProtoAdapter<PullDoubaoSearchQueryHistoryRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ClientType mclient_type;
    public final DoubaoSearchSceneMeta mscene_meta;

    public static final class Builder extends Message.Builder<PullDoubaoSearchQueryHistoryRequest, Builder> {
        public ClientType mclient_type;
        public DoubaoSearchSceneMeta mscene_meta;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullDoubaoSearchQueryHistoryRequest m2759build() {
            return new PullDoubaoSearchQueryHistoryRequest(this.mscene_meta, this.mclient_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2759build();
        }

        public Builder client_type(ClientType r1) {
            this.mclient_type = r1;
            return this;
        }

        public Builder scene_meta(DoubaoSearchSceneMeta r1) {
            this.mscene_meta = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDoubaoSearchQueryHistoryRequest extends ProtoAdapter<PullDoubaoSearchQueryHistoryRequest> {
        public ProtoAdapter_PullDoubaoSearchQueryHistoryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDoubaoSearchQueryHistoryRequest.class);
        }

        public PullDoubaoSearchQueryHistoryRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mscene_meta = (DoubaoSearchSceneMeta) DoubaoSearchSceneMeta.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mclient_type = (ClientType) ClientType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2759build();
        }

        public int encodedSize(PullDoubaoSearchQueryHistoryRequest r5) {
            DoubaoSearchSceneMeta r0 = r5.mscene_meta;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = DoubaoSearchSceneMeta.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ClientType r3 = r5.mclient_type;
            if (r3 == null) goto L10;
            r1 = ClientType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2760decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullDoubaoSearchQueryHistoryRequest) r1);
        }

        public void encode(ProtoWriter r4, PullDoubaoSearchQueryHistoryRequest r5) throws IOException {
            DoubaoSearchSceneMeta r0 = r5.mscene_meta;
            if (r0 == null) goto L5;
            DoubaoSearchSceneMeta.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ClientType r1 = r5.mclient_type;
            if (r1 == null) goto L8;
            ClientType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullDoubaoSearchQueryHistoryRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDoubaoSearchQueryHistoryRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2758newBuilder() {
        Builder r0 = new Builder();
        r0.mscene_meta = this.mscene_meta;
        r0.mclient_type = this.mclient_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullDoubaoSearchQueryHistoryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2758newBuilder();
    }

    public PullDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r2, ClientType r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PullDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r2, ClientType r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mscene_meta = r2;
        this.mclient_type = r3;
    }
}
