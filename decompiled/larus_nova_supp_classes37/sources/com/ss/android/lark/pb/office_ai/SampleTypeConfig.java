package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SampleTypeConfig extends Message<SampleTypeConfig, Builder> {
    public static final ProtoAdapter<SampleTypeConfig> ADAPTER = null;
    public static final String DEFAULT_SAMPLE_CATEGORY_NAME = "";
    public static final Integer DEFAULT_SAMPLE_CATEGORY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String msample_category_name;
    public final Integer msample_category_type;

    public static final class Builder extends Message.Builder<SampleTypeConfig, Builder> {
        public String msample_category_name;
        public Integer msample_category_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SampleTypeConfig m2015build() {
            return new SampleTypeConfig(this.msample_category_type, this.msample_category_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2015build();
        }

        public Builder sample_category_name(String r1) {
            this.msample_category_name = r1;
            return this;
        }

        public Builder sample_category_type(Integer r1) {
            this.msample_category_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SampleTypeConfig extends ProtoAdapter<SampleTypeConfig> {
        public ProtoAdapter_SampleTypeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SampleTypeConfig.class);
        }

        public SampleTypeConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msample_category_type = 0;
            r0.msample_category_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.msample_category_type = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msample_category_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2015build();
        }

        public int encodedSize(SampleTypeConfig r5) {
            Integer r0 = r5.msample_category_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.msample_category_name;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2016decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SampleTypeConfig) r1);
        }

        public void encode(ProtoWriter r4, SampleTypeConfig r5) throws IOException {
            Integer r0 = r5.msample_category_type;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.msample_category_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SampleTypeConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SampleTypeConfig();
        DEFAULT_SAMPLE_CATEGORY_TYPE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2014newBuilder() {
        Builder r0 = new Builder();
        r0.msample_category_type = this.msample_category_type;
        r0.msample_category_name = this.msample_category_name;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SampleTypeConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2014newBuilder();
    }

    public SampleTypeConfig(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SampleTypeConfig(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.msample_category_type = r2;
        this.msample_category_name = r3;
    }
}
