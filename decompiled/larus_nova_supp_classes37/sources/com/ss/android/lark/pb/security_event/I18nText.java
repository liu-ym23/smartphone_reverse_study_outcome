package com.ss.android.lark.pb.security_event;

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
public final class I18nText extends Message<I18nText, Builder> {
    public static final ProtoAdapter<I18nText> ADAPTER = null;
    public static final String DEFAULT_DEFAULTTEXT = "";
    private static final long serialVersionUID = 0;
    public final String mDefaultText;
    public final Map<String, String> mI18nTexts;

    public static final class Builder extends Message.Builder<I18nText, Builder> {
        public String mDefaultText;
        public Map<String, String> mI18nTexts;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public I18nText m2177build() {
            String r0 = this.mDefaultText;
            if (r0 == null) goto L7;
            return new I18nText(this.mDefaultText, this.mI18nTexts, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mDefaultText"});
        }

        public Builder() {
            this.mI18nTexts = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2177build();
        }

        public Builder DefaultText(String r1) {
            this.mDefaultText = r1;
            return this;
        }

        public Builder I18nTexts(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mI18nTexts = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_I18nText extends ProtoAdapter<I18nText> {
        private final ProtoAdapter<Map<String, String>> mI18nTexts;

        public ProtoAdapter_I18nText() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nText.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mI18nTexts = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public I18nText decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mDefaultText = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mDefaultText = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mI18nTexts.putAll((Map) this.mI18nTexts.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2177build();
        }

        public int encodedSize(I18nText r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mDefaultText) + this.mI18nTexts.encodedSizeWithTag(2, r5.mI18nTexts)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2178decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((I18nText) r1);
        }

        public void encode(ProtoWriter r4, I18nText r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mDefaultText);
            this.mI18nTexts.encodeWithTag(r4, 2, r5.mI18nTexts);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (I18nText) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nText();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2176newBuilder() {
        Builder r0 = new Builder();
        r0.mDefaultText = this.mDefaultText;
        r0.mI18nTexts = Internal.copyOf("mI18nTexts", this.mI18nTexts);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return I18nText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2176newBuilder();
    }

    public I18nText(String r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public I18nText(String r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mDefaultText = r2;
        this.mI18nTexts = Internal.immutableCopyOf("mI18nTexts", r3);
    }
}
