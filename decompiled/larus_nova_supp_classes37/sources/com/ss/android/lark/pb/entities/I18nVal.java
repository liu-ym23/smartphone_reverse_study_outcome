package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class I18nVal extends com.squareup.wire.Message<I18nVal, Builder> {
    public static final ProtoAdapter<I18nVal> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_VAL = "";
    private static final long serialVersionUID = 0;
    public final String mdefault_val;
    public final Map<String, String> mi18n_vals;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nVal, Builder> {
        public String mdefault_val;
        public Map<String, String> mi18n_vals;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public I18nVal m1268build() {
            String r0 = this.mdefault_val;
            if (r0 == null) goto L7;
            return new I18nVal(this.mdefault_val, this.mi18n_vals, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mdefault_val"});
        }

        public Builder() {
            this.mi18n_vals = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1268build();
        }

        public Builder default_val(String r1) {
            this.mdefault_val = r1;
            return this;
        }

        public Builder i18n_vals(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_vals = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_I18nVal extends ProtoAdapter<I18nVal> {
        private final ProtoAdapter<Map<String, String>> mi18n_vals;

        public ProtoAdapter_I18nVal() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nVal.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_vals = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public I18nVal decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdefault_val = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mdefault_val = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mi18n_vals.putAll((Map) this.mi18n_vals.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1268build();
        }

        public int encodedSize(I18nVal r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mdefault_val) + this.mi18n_vals.encodedSizeWithTag(2, r5.mi18n_vals)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1269decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((I18nVal) r1);
        }

        public void encode(ProtoWriter r4, I18nVal r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mdefault_val);
            this.mi18n_vals.encodeWithTag(r4, 2, r5.mi18n_vals);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (I18nVal) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nVal();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1267newBuilder() {
        Builder r0 = new Builder();
        r0.mdefault_val = this.mdefault_val;
        r0.mi18n_vals = Internal.copyOf("mi18n_vals", this.mi18n_vals);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return I18nVal.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1267newBuilder();
    }

    public I18nVal(String r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public I18nVal(String r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mdefault_val = r2;
        this.mi18n_vals = Internal.immutableCopyOf("mi18n_vals", r3);
    }
}
