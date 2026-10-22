package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GenLarkReportUrlResponse extends Message<GenLarkReportUrlResponse, Builder> {
    public static final ProtoAdapter<GenLarkReportUrlResponse> ADAPTER = null;
    public static final Boolean DEFAULT_OPEN_PC_CUSTOMIZED_WV = null;
    public static final String DEFAULT_REPORT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean mopen_pc_customized_wv;
    public final String mreport_url;

    public static final class Builder extends Message.Builder<GenLarkReportUrlResponse, Builder> {
        public Boolean mopen_pc_customized_wv;
        public String mreport_url;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GenLarkReportUrlResponse m1805build() {
            String r0 = this.mreport_url;
            if (r0 == null) goto L7;
            return new GenLarkReportUrlResponse(this.mreport_url, this.mopen_pc_customized_wv, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mreport_url"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1805build();
        }

        public Builder open_pc_customized_wv(Boolean r1) {
            this.mopen_pc_customized_wv = r1;
            return this;
        }

        public Builder report_url(String r1) {
            this.mreport_url = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GenLarkReportUrlResponse extends ProtoAdapter<GenLarkReportUrlResponse> {
        public ProtoAdapter_GenLarkReportUrlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GenLarkReportUrlResponse.class);
        }

        public GenLarkReportUrlResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mreport_url = "";
            r0.mopen_pc_customized_wv = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mreport_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mopen_pc_customized_wv = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1805build();
        }

        public int encodedSize(GenLarkReportUrlResponse r5) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mreport_url);
            Boolean r1 = r5.mopen_pc_customized_wv;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1806decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GenLarkReportUrlResponse) r1);
        }

        public void encode(ProtoWriter r4, GenLarkReportUrlResponse r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mreport_url);
            Boolean r0 = r5.mopen_pc_customized_wv;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GenLarkReportUrlResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenLarkReportUrlResponse();
        DEFAULT_OPEN_PC_CUSTOMIZED_WV = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1804newBuilder() {
        Builder r0 = new Builder();
        r0.mreport_url = this.mreport_url;
        r0.mopen_pc_customized_wv = this.mopen_pc_customized_wv;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GenLarkReportUrlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1804newBuilder();
    }

    public GenLarkReportUrlResponse(String r2, Boolean r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GenLarkReportUrlResponse(String r2, Boolean r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mreport_url = r2;
        this.mopen_pc_customized_wv = r3;
    }
}
