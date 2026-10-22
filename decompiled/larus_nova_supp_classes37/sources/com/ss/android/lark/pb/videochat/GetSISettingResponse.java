package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSISettingResponse extends Message<GetSISettingResponse, Builder> {
    public static final ProtoAdapter<GetSISettingResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUPPORT_SI = null;
    private static final long serialVersionUID = 0;
    public final Boolean msupport_si;
    public final List<Language> msupport_target_lang_list;

    public static final class Builder extends Message.Builder<GetSISettingResponse, Builder> {
        public Boolean msupport_si;
        public List<Language> msupport_target_lang_list;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSISettingResponse m3128build() {
            return new GetSISettingResponse(this.msupport_si, this.msupport_target_lang_list, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_target_lang_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3128build();
        }

        public Builder support_si(Boolean r1) {
            this.msupport_si = r1;
            return this;
        }

        public Builder support_target_lang_list(List<Language> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_target_lang_list = r1;
            return this;
        }
    }

    public static final class Language extends Message<Language, Builder> {
        public static final ProtoAdapter<Language> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final String DEFAULT_ICON = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription;
        public final String micon;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<Language, Builder> {
            public String mdescription;
            public String micon;
            public String mlanguage;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Language m3130build() {
                return new Language(this.mlanguage, this.mdescription, this.micon, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3130build();
            }

            public Builder description(String r1) {
                this.mdescription = r1;
                return this;
            }

            public Builder icon(String r1) {
                this.micon = r1;
                return this;
            }

            public Builder language(String r1) {
                this.mlanguage = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Language extends ProtoAdapter<Language> {
            public ProtoAdapter_Language() {
                super(FieldEncoding.LENGTH_DELIMITED, Language.class);
            }

            public Language decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mlanguage = "";
                r0.mdescription = "";
                r0.micon = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mlanguage = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.micon = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3130build();
            }

            public int encodedSize(Language r6) {
                String r0 = r6.mlanguage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mdescription;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.micon;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m3131decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Language) r1);
            }

            public void encode(ProtoWriter r4, Language r5) throws IOException {
                String r0 = r5.mlanguage;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdescription;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.micon;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Language) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Language();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3129newBuilder() {
            Builder r0 = new Builder();
            r0.mlanguage = this.mlanguage;
            r0.mdescription = this.mdescription;
            r0.micon = this.micon;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Language.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3129newBuilder();
        }

        public Language(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Language(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mlanguage = r2;
            this.mdescription = r3;
            this.micon = r4;
        }
    }

    public static final class ProtoAdapter_GetSISettingResponse extends ProtoAdapter<GetSISettingResponse> {
        public ProtoAdapter_GetSISettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSISettingResponse.class);
        }

        public GetSISettingResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.msupport_si = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.msupport_si = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msupport_target_lang_list.add((Language) Language.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3128build();
        }

        public int encodedSize(GetSISettingResponse r5) {
            Boolean r0 = r5.msupport_si;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + Language.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.msupport_target_lang_list)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3132decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSISettingResponse) r1);
        }

        public void encode(ProtoWriter r4, GetSISettingResponse r5) throws IOException {
            Boolean r0 = r5.msupport_si;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Language.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.msupport_target_lang_list);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSISettingResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSISettingResponse();
        DEFAULT_SUPPORT_SI = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3127newBuilder() {
        Builder r0 = new Builder();
        r0.msupport_si = this.msupport_si;
        r0.msupport_target_lang_list = Internal.copyOf("msupport_target_lang_list", this.msupport_target_lang_list);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSISettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3127newBuilder();
    }

    public GetSISettingResponse(Boolean r2, List<Language> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public GetSISettingResponse(Boolean r2, List<Language> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.msupport_si = r2;
        this.msupport_target_lang_list = Internal.immutableCopyOf("msupport_target_lang_list", r3);
    }
}
