package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GenLarkReportUrlRequest extends Message<GenLarkReportUrlRequest, Builder> {
    public static final ProtoAdapter<GenLarkReportUrlRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_LANG_TYPE = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final String mlang_type;

    public static final class Builder extends Message.Builder<GenLarkReportUrlRequest, Builder> {
        public Long mchat_id;
        public String mlang_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GenLarkReportUrlRequest m1802build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L9;
            if (this.mlang_type == null) goto L9;
            return new GenLarkReportUrlRequest(this.mchat_id, this.mlang_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id", this.mlang_type, "mlang_type"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1802build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder lang_type(String r1) {
            this.mlang_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GenLarkReportUrlRequest extends ProtoAdapter<GenLarkReportUrlRequest> {
        public ProtoAdapter_GenLarkReportUrlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GenLarkReportUrlRequest.class);
        }

        public GenLarkReportUrlRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mlang_type = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mlang_type = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1802build();
        }

        public int encodedSize(GenLarkReportUrlRequest r5) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r5.mchat_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.mlang_type)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1803decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GenLarkReportUrlRequest) r1);
        }

        public void encode(ProtoWriter r4, GenLarkReportUrlRequest r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mchat_id);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.mlang_type);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GenLarkReportUrlRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GenLarkReportUrlRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1801newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mlang_type = this.mlang_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GenLarkReportUrlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1801newBuilder();
    }

    public GenLarkReportUrlRequest(Long r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GenLarkReportUrlRequest(Long r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mchat_id = r2;
        this.mlang_type = r3;
    }
}
