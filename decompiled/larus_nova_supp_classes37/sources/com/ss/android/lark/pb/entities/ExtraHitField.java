package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtraHitField extends com.squareup.wire.Message<ExtraHitField, Builder> {
    public static final ProtoAdapter<ExtraHitField> ADAPTER = null;
    public static final String DEFAULT_FIELD_NAME = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String mfield_name;
    public final String mtitle;
    public final List<String> mtitle_hit_terms;

    public static final class Builder extends com.squareup.wire.Message.Builder<ExtraHitField, Builder> {
        public String mfield_name;
        public String mtitle;
        public List<String> mtitle_hit_terms;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtraHitField m1214build() {
            return new ExtraHitField(this.mfield_name, this.mtitle, this.mtitle_hit_terms, super.buildUnknownFields());
        }

        public Builder() {
            this.mtitle_hit_terms = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1214build();
        }

        public Builder field_name(String r1) {
            this.mfield_name = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }

        public Builder title_hit_terms(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtitle_hit_terms = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraHitField extends ProtoAdapter<ExtraHitField> {
        public ProtoAdapter_ExtraHitField() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraHitField.class);
        }

        public ExtraHitField decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mfield_name = "";
            r0.mtitle = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mfield_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtitle_hit_terms.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1214build();
        }

        public int encodedSize(ExtraHitField r5) {
            String r0 = r5.mfield_name;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mtitle;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r5.mtitle_hit_terms)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1215decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtraHitField) r1);
        }

        public void encode(ProtoWriter r4, ExtraHitField r5) throws IOException {
            String r0 = r5.mfield_name;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtitle;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 3, r5.mtitle_hit_terms);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtraHitField) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraHitField();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1213newBuilder() {
        Builder r0 = new Builder();
        r0.mfield_name = this.mfield_name;
        r0.mtitle = this.mtitle;
        r0.mtitle_hit_terms = Internal.copyOf("mtitle_hit_terms", this.mtitle_hit_terms);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtraHitField.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1213newBuilder();
    }

    public ExtraHitField(String r2, String r3, List<String> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ExtraHitField(String r2, String r3, List<String> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mfield_name = r2;
        this.mtitle = r3;
        this.mtitle_hit_terms = Internal.immutableCopyOf("mtitle_hit_terms", r4);
    }
}
