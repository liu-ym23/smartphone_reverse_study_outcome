package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetQueryByMessageIDsResponse extends Message<GetQueryByMessageIDsResponse, Builder> {
    public static final ProtoAdapter<GetQueryByMessageIDsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ALLOW_ALL_FORWARD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_allow_all_forward;
    public final QueryContent mquery;

    public static final class Builder extends Message.Builder<GetQueryByMessageIDsResponse, Builder> {
        public Boolean mis_allow_all_forward;
        public QueryContent mquery;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetQueryByMessageIDsResponse m797build() {
            return new GetQueryByMessageIDsResponse(this.mquery, this.mis_allow_all_forward, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m797build();
        }

        public Builder is_allow_all_forward(Boolean r1) {
            this.mis_allow_all_forward = r1;
            return this;
        }

        public Builder query(QueryContent r1) {
            this.mquery = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetQueryByMessageIDsResponse extends ProtoAdapter<GetQueryByMessageIDsResponse> {
        public ProtoAdapter_GetQueryByMessageIDsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetQueryByMessageIDsResponse.class);
        }

        public GetQueryByMessageIDsResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mis_allow_all_forward = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mquery = (QueryContent) QueryContent.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mis_allow_all_forward = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m797build();
        }

        public int encodedSize(GetQueryByMessageIDsResponse r5) {
            QueryContent r0 = r5.mquery;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = QueryContent.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r5.mis_allow_all_forward;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m798decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetQueryByMessageIDsResponse) r1);
        }

        public void encode(ProtoWriter r4, GetQueryByMessageIDsResponse r5) throws IOException {
            QueryContent r0 = r5.mquery;
            if (r0 == null) goto L5;
            QueryContent.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_allow_all_forward;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetQueryByMessageIDsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetQueryByMessageIDsResponse();
        DEFAULT_IS_ALLOW_ALL_FORWARD = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m796newBuilder() {
        Builder r0 = new Builder();
        r0.mquery = this.mquery;
        r0.mis_allow_all_forward = this.mis_allow_all_forward;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetQueryByMessageIDsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m796newBuilder();
    }

    public GetQueryByMessageIDsResponse(QueryContent r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GetQueryByMessageIDsResponse(QueryContent r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mquery = r2;
        this.mis_allow_all_forward = r3;
    }
}
