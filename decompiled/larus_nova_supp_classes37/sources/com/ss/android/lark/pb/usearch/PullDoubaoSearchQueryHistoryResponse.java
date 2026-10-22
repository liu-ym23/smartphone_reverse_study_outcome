package com.ss.android.lark.pb.usearch;

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
public final class PullDoubaoSearchQueryHistoryResponse extends Message<PullDoubaoSearchQueryHistoryResponse, Builder> {
    public static final ProtoAdapter<PullDoubaoSearchQueryHistoryResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DoubaoSearchQueryMeta> mquery_metas;

    public static final class Builder extends Message.Builder<PullDoubaoSearchQueryHistoryResponse, Builder> {
        public List<DoubaoSearchQueryMeta> mquery_metas;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullDoubaoSearchQueryHistoryResponse m2762build() {
            return new PullDoubaoSearchQueryHistoryResponse(this.mquery_metas, super.buildUnknownFields());
        }

        public Builder() {
            this.mquery_metas = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2762build();
        }

        public Builder query_metas(List<DoubaoSearchQueryMeta> r1) {
            Internal.checkElementsNotNull(r1);
            this.mquery_metas = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDoubaoSearchQueryHistoryResponse extends ProtoAdapter<PullDoubaoSearchQueryHistoryResponse> {
        public ProtoAdapter_PullDoubaoSearchQueryHistoryResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDoubaoSearchQueryHistoryResponse.class);
        }

        public PullDoubaoSearchQueryHistoryResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mquery_metas.add((DoubaoSearchQueryMeta) DoubaoSearchQueryMeta.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2762build();
        }

        public int encodedSize(PullDoubaoSearchQueryHistoryResponse r4) {
            return DoubaoSearchQueryMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mquery_metas) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2763decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullDoubaoSearchQueryHistoryResponse) r1);
        }

        public void encode(ProtoWriter r4, PullDoubaoSearchQueryHistoryResponse r5) throws IOException {
            DoubaoSearchQueryMeta.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mquery_metas);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullDoubaoSearchQueryHistoryResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDoubaoSearchQueryHistoryResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2761newBuilder() {
        Builder r0 = new Builder();
        r0.mquery_metas = Internal.copyOf("mquery_metas", this.mquery_metas);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullDoubaoSearchQueryHistoryResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2761newBuilder();
    }

    public PullDoubaoSearchQueryHistoryResponse(List<DoubaoSearchQueryMeta> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullDoubaoSearchQueryHistoryResponse(List<DoubaoSearchQueryMeta> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mquery_metas = Internal.immutableCopyOf("mquery_metas", r2);
    }
}
