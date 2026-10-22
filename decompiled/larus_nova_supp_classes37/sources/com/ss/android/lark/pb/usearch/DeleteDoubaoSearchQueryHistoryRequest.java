package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DeleteDoubaoSearchQueryHistoryRequest extends Message<DeleteDoubaoSearchQueryHistoryRequest, Builder> {
    public static final ProtoAdapter<DeleteDoubaoSearchQueryHistoryRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ClientType mclient_type;
    public final DoubaoSearchQueryMeta mquery_meta;
    public final DoubaoSearchSceneMeta mscene_meta;

    public static final class Builder extends Message.Builder<DeleteDoubaoSearchQueryHistoryRequest, Builder> {
        public ClientType mclient_type;
        public DoubaoSearchQueryMeta mquery_meta;
        public DoubaoSearchSceneMeta mscene_meta;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DeleteDoubaoSearchQueryHistoryRequest m2579build() {
            return new DeleteDoubaoSearchQueryHistoryRequest(this.mscene_meta, this.mclient_type, this.mquery_meta, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2579build();
        }

        public Builder client_type(ClientType r1) {
            this.mclient_type = r1;
            return this;
        }

        public Builder query_meta(DoubaoSearchQueryMeta r1) {
            this.mquery_meta = r1;
            return this;
        }

        public Builder scene_meta(DoubaoSearchSceneMeta r1) {
            this.mscene_meta = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest extends ProtoAdapter<DeleteDoubaoSearchQueryHistoryRequest> {
        public ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteDoubaoSearchQueryHistoryRequest.class);
        }

        public DeleteDoubaoSearchQueryHistoryRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mscene_meta = (DoubaoSearchSceneMeta) DoubaoSearchSceneMeta.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mclient_type = (ClientType) ClientType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mquery_meta = (DoubaoSearchQueryMeta) DoubaoSearchQueryMeta.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2579build();
        }

        public int encodedSize(DeleteDoubaoSearchQueryHistoryRequest r6) {
            DoubaoSearchSceneMeta r0 = r6.mscene_meta;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = DoubaoSearchSceneMeta.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ClientType r3 = r6.mclient_type;
            if (r3 == null) goto L9;
            int r4 = ClientType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            DoubaoSearchQueryMeta r7 = r6.mquery_meta;
            if (r7 == null) goto L14;
            r1 = DoubaoSearchQueryMeta.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2580decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DeleteDoubaoSearchQueryHistoryRequest) r1);
        }

        public void encode(ProtoWriter r4, DeleteDoubaoSearchQueryHistoryRequest r5) throws IOException {
            DoubaoSearchSceneMeta r0 = r5.mscene_meta;
            if (r0 == null) goto L5;
            DoubaoSearchSceneMeta.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ClientType r1 = r5.mclient_type;
            if (r1 == null) goto L8;
            ClientType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            DoubaoSearchQueryMeta r2 = r5.mquery_meta;
            if (r2 == null) goto L11;
            DoubaoSearchQueryMeta.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DeleteDoubaoSearchQueryHistoryRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteDoubaoSearchQueryHistoryRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2578newBuilder() {
        Builder r0 = new Builder();
        r0.mscene_meta = this.mscene_meta;
        r0.mclient_type = this.mclient_type;
        r0.mquery_meta = this.mquery_meta;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DeleteDoubaoSearchQueryHistoryRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2578newBuilder();
    }

    public DeleteDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r2, ClientType r3, DoubaoSearchQueryMeta r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DeleteDoubaoSearchQueryHistoryRequest(DoubaoSearchSceneMeta r2, ClientType r3, DoubaoSearchQueryMeta r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mscene_meta = r2;
        this.mclient_type = r3;
        this.mquery_meta = r4;
    }
}
