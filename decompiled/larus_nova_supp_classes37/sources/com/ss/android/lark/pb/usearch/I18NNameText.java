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
public final class I18NNameText extends Message<I18NNameText, Builder> {
    public static final ProtoAdapter<I18NNameText> ADAPTER = null;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mi18n_value;
    public final String mvalue;

    public static final class Builder extends Message.Builder<I18NNameText, Builder> {
        public Map<String, String> mi18n_value;
        public String mvalue;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public I18NNameText m2672build() {
            return new I18NNameText(this.mvalue, this.mi18n_value, super.buildUnknownFields());
        }

        public Builder() {
            this.mi18n_value = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2672build();
        }

        public Builder i18n_value(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_value = r1;
            return this;
        }

        public Builder value(String r1) {
            this.mvalue = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_I18NNameText extends ProtoAdapter<I18NNameText> {
        private final ProtoAdapter<Map<String, String>> mi18n_value;

        public ProtoAdapter_I18NNameText() {
            super(FieldEncoding.LENGTH_DELIMITED, I18NNameText.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_value = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public I18NNameText decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mvalue = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mvalue = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mi18n_value.putAll((Map) this.mi18n_value.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2672build();
        }

        public int encodedSize(I18NNameText r5) {
            String r0 = r5.mvalue;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + this.mi18n_value.encodedSizeWithTag(2, r5.mi18n_value)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2673decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((I18NNameText) r1);
        }

        public void encode(ProtoWriter r4, I18NNameText r5) throws IOException {
            String r0 = r5.mvalue;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            this.mi18n_value.encodeWithTag(r4, 2, r5.mi18n_value);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (I18NNameText) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18NNameText();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2671newBuilder() {
        Builder r0 = new Builder();
        r0.mvalue = this.mvalue;
        r0.mi18n_value = Internal.copyOf("mi18n_value", this.mi18n_value);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return I18NNameText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2671newBuilder();
    }

    public I18NNameText(String r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public I18NNameText(String r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mvalue = r2;
        this.mi18n_value = Internal.immutableCopyOf("mi18n_value", r3);
    }
}
