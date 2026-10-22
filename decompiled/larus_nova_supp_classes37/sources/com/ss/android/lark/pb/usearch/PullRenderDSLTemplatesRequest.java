package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullRenderDSLTemplatesRequest extends Message<PullRenderDSLTemplatesRequest, Builder> {
    public static final ProtoAdapter<PullRenderDSLTemplatesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_QUERY_TEMPLATE = null;
    public static final String DEFAULT_LOCALE = "";
    public static final ByteString DEFAULT_TEMPLATES = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_query_template;
    public final String mlocale;
    public final ByteString mtemplates;

    public static final class Builder extends Message.Builder<PullRenderDSLTemplatesRequest, Builder> {
        public Boolean mis_query_template;
        public String mlocale;
        public ByteString mtemplates;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullRenderDSLTemplatesRequest m2765build() {
            return new PullRenderDSLTemplatesRequest(this.mlocale, this.mtemplates, this.mis_query_template, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2765build();
        }

        public Builder is_query_template(Boolean r1) {
            this.mis_query_template = r1;
            return this;
        }

        public Builder locale(String r1) {
            this.mlocale = r1;
            return this;
        }

        public Builder templates(ByteString r1) {
            this.mtemplates = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullRenderDSLTemplatesRequest extends ProtoAdapter<PullRenderDSLTemplatesRequest> {
        public ProtoAdapter_PullRenderDSLTemplatesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullRenderDSLTemplatesRequest.class);
        }

        public PullRenderDSLTemplatesRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mlocale = "";
            r0.mtemplates = ByteString.EMPTY;
            r0.mis_query_template = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mlocale = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtemplates = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mis_query_template = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2765build();
        }

        public int encodedSize(PullRenderDSLTemplatesRequest r6) {
            String r0 = r6.mlocale;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ByteString r3 = r6.mtemplates;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_query_template;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m2766decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullRenderDSLTemplatesRequest) r1);
        }

        public void encode(ProtoWriter r4, PullRenderDSLTemplatesRequest r5) throws IOException {
            String r0 = r5.mlocale;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.mtemplates;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_query_template;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullRenderDSLTemplatesRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullRenderDSLTemplatesRequest();
        DEFAULT_TEMPLATES = ByteString.EMPTY;
        DEFAULT_IS_QUERY_TEMPLATE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2764newBuilder() {
        Builder r0 = new Builder();
        r0.mlocale = this.mlocale;
        r0.mtemplates = this.mtemplates;
        r0.mis_query_template = this.mis_query_template;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullRenderDSLTemplatesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2764newBuilder();
    }

    public PullRenderDSLTemplatesRequest(String r2, ByteString r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullRenderDSLTemplatesRequest(String r2, ByteString r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mlocale = r2;
        this.mtemplates = r3;
        this.mis_query_template = r4;
    }
}
