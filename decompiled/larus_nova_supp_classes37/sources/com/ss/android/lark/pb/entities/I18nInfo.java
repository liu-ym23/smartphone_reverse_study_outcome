package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class I18nInfo extends com.squareup.wire.Message<I18nInfo, Builder> {
    public static final ProtoAdapter<I18nInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_I18N_MESSAGE = null;
    public static final String DEFAULT_LOCALE = "zh_cn";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mcontent_language;
    public final Boolean mis_i18n_message;
    public final String mlocale;
    public final Map<String, LocaleInfo> mlocale_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nInfo, Builder> {
        public Map<String, String> mcontent_language;
        public Boolean mis_i18n_message;
        public String mlocale;
        public Map<String, LocaleInfo> mlocale_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public I18nInfo m1262build() {
            return new I18nInfo(this.mis_i18n_message, this.mlocale, this.mcontent_language, this.mlocale_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mcontent_language = Internal.newMutableMap();
            this.mlocale_info = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1262build();
        }

        public Builder content_language(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcontent_language = r1;
            return this;
        }

        public Builder is_i18n_message(Boolean r1) {
            this.mis_i18n_message = r1;
            return this;
        }

        public Builder locale(String r1) {
            this.mlocale = r1;
            return this;
        }

        public Builder locale_info(Map<String, LocaleInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlocale_info = r1;
            return this;
        }
    }

    public static final class LocaleInfo extends com.squareup.wire.Message<LocaleInfo, Builder> {
        public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mcontent_languages;

        public static final class Builder extends com.squareup.wire.Message.Builder<LocaleInfo, Builder> {
            public List<String> mcontent_languages;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public LocaleInfo m1264build() {
                return new LocaleInfo(this.mcontent_languages, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontent_languages = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1264build();
            }

            public Builder content_languages(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcontent_languages = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_LocaleInfo extends ProtoAdapter<LocaleInfo> {
            public ProtoAdapter_LocaleInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, LocaleInfo.class);
            }

            public LocaleInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mcontent_languages.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1264build();
            }

            public int encodedSize(LocaleInfo r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mcontent_languages) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1265decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((LocaleInfo) r1);
            }

            public void encode(ProtoWriter r4, LocaleInfo r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mcontent_languages);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (LocaleInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LocaleInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1263newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent_languages = Internal.copyOf("mcontent_languages", this.mcontent_languages);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return LocaleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1263newBuilder();
        }

        public LocaleInfo(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public LocaleInfo(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mcontent_languages = Internal.immutableCopyOf("mcontent_languages", r2);
        }
    }

    public static final class ProtoAdapter_I18nInfo extends ProtoAdapter<I18nInfo> {
        private final ProtoAdapter<Map<String, String>> mcontent_language;
        private final ProtoAdapter<Map<String, LocaleInfo>> mlocale_info;

        public ProtoAdapter_I18nInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mcontent_language = ProtoAdapter.newMapAdapter(r0, r0);
            this.mlocale_info = ProtoAdapter.newMapAdapter(r0, LocaleInfo.ADAPTER);
        }

        public I18nInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mis_i18n_message = Boolean.FALSE;
            r0.mlocale = I18nInfo.DEFAULT_LOCALE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mis_i18n_message = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mlocale = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcontent_language.putAll((Map) this.mcontent_language.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mlocale_info.putAll((Map) this.mlocale_info.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1262build();
        }

        public int encodedSize(I18nInfo r5) {
            Boolean r0 = r5.mis_i18n_message;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mlocale;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (((r2 + r1) + this.mcontent_language.encodedSizeWithTag(3, r5.mcontent_language)) + this.mlocale_info.encodedSizeWithTag(4, r5.mlocale_info)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1266decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((I18nInfo) r1);
        }

        public void encode(ProtoWriter r4, I18nInfo r5) throws IOException {
            Boolean r0 = r5.mis_i18n_message;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mlocale;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            this.mcontent_language.encodeWithTag(r4, 3, r5.mcontent_language);
            this.mlocale_info.encodeWithTag(r4, 4, r5.mlocale_info);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (I18nInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nInfo();
        DEFAULT_IS_I18N_MESSAGE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1261newBuilder() {
        Builder r0 = new Builder();
        r0.mis_i18n_message = this.mis_i18n_message;
        r0.mlocale = this.mlocale;
        r0.mcontent_language = Internal.copyOf("mcontent_language", this.mcontent_language);
        r0.mlocale_info = Internal.copyOf("mlocale_info", this.mlocale_info);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return I18nInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1261newBuilder();
    }

    public I18nInfo(Boolean r7, String r8, Map<String, String> r9, Map<String, LocaleInfo> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public I18nInfo(Boolean r2, String r3, Map<String, String> r4, Map<String, LocaleInfo> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mis_i18n_message = r2;
        this.mlocale = r3;
        this.mcontent_language = Internal.immutableCopyOf("mcontent_language", r4);
        this.mlocale_info = Internal.immutableCopyOf("mlocale_info", r5);
    }
}
