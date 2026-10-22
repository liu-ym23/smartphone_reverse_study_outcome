package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullRenderDSLTemplatesResponse extends Message<PullRenderDSLTemplatesResponse, Builder> {
    public static final ProtoAdapter<PullRenderDSLTemplatesResponse> ADAPTER = null;
    public static final ByteString DEFAULT_QUERY_TEMPLATE_INFO = null;
    private static final long serialVersionUID = 0;
    public final ByteString mquery_template_info;
    public final Map<String, String> mtemplates;

    public static final class Builder extends Message.Builder<PullRenderDSLTemplatesResponse, Builder> {
        public ByteString mquery_template_info;
        public Map<String, String> mtemplates;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullRenderDSLTemplatesResponse m2768build() {
            return new PullRenderDSLTemplatesResponse(this.mtemplates, this.mquery_template_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mtemplates = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2768build();
        }

        public Builder query_template_info(ByteString r1) {
            this.mquery_template_info = r1;
            return this;
        }

        public Builder templates(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtemplates = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullRenderDSLTemplatesResponse extends ProtoAdapter<PullRenderDSLTemplatesResponse> {
        private final ProtoAdapter<Map<String, String>> mtemplates;

        public ProtoAdapter_PullRenderDSLTemplatesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullRenderDSLTemplatesResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mtemplates = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public PullRenderDSLTemplatesResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mquery_template_info = ByteString.EMPTY;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtemplates.putAll((Map) this.mtemplates.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mquery_template_info = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2768build();
        }

        public int encodedSize(PullRenderDSLTemplatesResponse r5) {
            int r0 = this.mtemplates.encodedSizeWithTag(1, r5.mtemplates);
            ByteString r1 = r5.mquery_template_info;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2769decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullRenderDSLTemplatesResponse) r1);
        }

        public void encode(ProtoWriter r4, PullRenderDSLTemplatesResponse r5) throws IOException {
            this.mtemplates.encodeWithTag(r4, 1, r5.mtemplates);
            ByteString r0 = r5.mquery_template_info;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullRenderDSLTemplatesResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullRenderDSLTemplatesResponse();
        DEFAULT_QUERY_TEMPLATE_INFO = ByteString.EMPTY;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2767newBuilder() {
        Builder r0 = new Builder();
        r0.mtemplates = Internal.copyOf("mtemplates", this.mtemplates);
        r0.mquery_template_info = this.mquery_template_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullRenderDSLTemplatesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2767newBuilder();
    }

    public PullRenderDSLTemplatesResponse(Map<String, String> r2, ByteString r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PullRenderDSLTemplatesResponse(Map<String, String> r2, ByteString r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtemplates = Internal.immutableCopyOf("mtemplates", r2);
        this.mquery_template_info = r3;
    }
}
