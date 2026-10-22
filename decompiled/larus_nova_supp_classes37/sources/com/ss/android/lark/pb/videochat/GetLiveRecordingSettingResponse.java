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
public final class GetLiveRecordingSettingResponse extends Message<GetLiveRecordingSettingResponse, Builder> {
    public static final ProtoAdapter<GetLiveRecordingSettingResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_RECORDING_MARK = null;
    public static final Boolean DEFAULT_IS_BILINGUAL = null;
    public static final Long DEFAULT_WAITING_TIME = null;
    private static final long serialVersionUID = 0;
    public final Boolean mcan_recording_mark;
    public final Boolean mis_bilingual;
    public final SubtitleLanguage mspoken_language;
    public final List<SubtitleLanguage> mspoken_language_list;
    public final SubtitleLanguage mtranslation_language;
    public final List<SubtitleLanguage> mtranslation_language_list;
    public final Long mwaiting_time;

    public static final class Builder extends Message.Builder<GetLiveRecordingSettingResponse, Builder> {
        public Boolean mcan_recording_mark;
        public Boolean mis_bilingual;
        public SubtitleLanguage mspoken_language;
        public List<SubtitleLanguage> mspoken_language_list;
        public SubtitleLanguage mtranslation_language;
        public List<SubtitleLanguage> mtranslation_language_list;
        public Long mwaiting_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetLiveRecordingSettingResponse m3119build() {
            return new GetLiveRecordingSettingResponse(this.mspoken_language_list, this.mtranslation_language_list, this.mspoken_language, this.mtranslation_language, this.mis_bilingual, this.mwaiting_time, this.mcan_recording_mark, super.buildUnknownFields());
        }

        public Builder() {
            this.mspoken_language_list = Internal.newMutableList();
            this.mtranslation_language_list = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3119build();
        }

        public Builder can_recording_mark(Boolean r1) {
            this.mcan_recording_mark = r1;
            return this;
        }

        public Builder is_bilingual(Boolean r1) {
            this.mis_bilingual = r1;
            return this;
        }

        public Builder spoken_language(SubtitleLanguage r1) {
            this.mspoken_language = r1;
            return this;
        }

        public Builder spoken_language_list(List<SubtitleLanguage> r1) {
            Internal.checkElementsNotNull(r1);
            this.mspoken_language_list = r1;
            return this;
        }

        public Builder translation_language(SubtitleLanguage r1) {
            this.mtranslation_language = r1;
            return this;
        }

        public Builder translation_language_list(List<SubtitleLanguage> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtranslation_language_list = r1;
            return this;
        }

        public Builder waiting_time(Long r1) {
            this.mwaiting_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLiveRecordingSettingResponse extends ProtoAdapter<GetLiveRecordingSettingResponse> {
        public ProtoAdapter_GetLiveRecordingSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLiveRecordingSettingResponse.class);
        }

        public GetLiveRecordingSettingResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mis_bilingual = r1;
            r0.mwaiting_time = 0L;
            r0.mcan_recording_mark = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mcan_recording_mark = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mwaiting_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            r0.mis_bilingual = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            r0.mtranslation_language = (SubtitleLanguage) SubtitleLanguage.ADAPTER.decode(r7);
            goto L3
        L11:
            r0.mspoken_language = (SubtitleLanguage) SubtitleLanguage.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.mtranslation_language_list.add((SubtitleLanguage) SubtitleLanguage.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.mspoken_language_list.add((SubtitleLanguage) SubtitleLanguage.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r2);
            return r0.m3119build();
        }

        public int encodedSize(GetLiveRecordingSettingResponse r6) {
            ProtoAdapter<SubtitleLanguage> r0 = SubtitleLanguage.ADAPTER;
            int r1 = r0.asRepeated().encodedSizeWithTag(1, r6.mspoken_language_list) + r0.asRepeated().encodedSizeWithTag(2, r6.mtranslation_language_list);
            SubtitleLanguage r2 = r6.mspoken_language;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            SubtitleLanguage r7 = r6.mtranslation_language;
            if (r7 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(4, r7);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_bilingual;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r10);
        L14:
            int r12 = r9 + r11;
            Long r13 = r6.mwaiting_time;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(6, r13);
        L18:
            int r15 = r12 + r14;
            Boolean r16 = r6.mcan_recording_mark;
            if (r16 == null) goto L22;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r16);
        L22:
            return (r15 + r3) + r6.unknownFields().size();
        L17:
            r14 = 0;
            goto L18
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3120decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetLiveRecordingSettingResponse) r1);
        }

        public void encode(ProtoWriter r5, GetLiveRecordingSettingResponse r6) throws IOException {
            ProtoAdapter<SubtitleLanguage> r0 = SubtitleLanguage.ADAPTER;
            r0.asRepeated().encodeWithTag(r5, 1, r6.mspoken_language_list);
            r0.asRepeated().encodeWithTag(r5, 2, r6.mtranslation_language_list);
            SubtitleLanguage r1 = r6.mspoken_language;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 3, r1);
        L5:
            SubtitleLanguage r2 = r6.mtranslation_language;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            Boolean r3 = r6.mis_bilingual;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 5, r3);
        L11:
            Long r4 = r6.mwaiting_time;
            if (r4 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r5, 6, r4);
        L14:
            Boolean r7 = r6.mcan_recording_mark;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 7, r7);
        L17:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetLiveRecordingSettingResponse) r2);
        }
    }

    public static final class SubtitleLanguage extends Message<SubtitleLanguage, Builder> {
        public static final ProtoAdapter<SubtitleLanguage> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION_I18N = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription_i18n;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<SubtitleLanguage, Builder> {
            public String mdescription_i18n;
            public String mlanguage;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SubtitleLanguage m3122build() {
                return new SubtitleLanguage(this.mlanguage, this.mdescription_i18n, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3122build();
            }

            public Builder description_i18n(String r1) {
                this.mdescription_i18n = r1;
                return this;
            }

            public Builder language(String r1) {
                this.mlanguage = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SubtitleLanguage extends ProtoAdapter<SubtitleLanguage> {
            public ProtoAdapter_SubtitleLanguage() {
                super(FieldEncoding.LENGTH_DELIMITED, SubtitleLanguage.class);
            }

            public SubtitleLanguage decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mlanguage = "";
                r0.mdescription_i18n = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mlanguage = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mdescription_i18n = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3122build();
            }

            public int encodedSize(SubtitleLanguage r5) {
                String r0 = r5.mlanguage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mdescription_i18n;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3123decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SubtitleLanguage) r1);
            }

            public void encode(ProtoWriter r4, SubtitleLanguage r5) throws IOException {
                String r0 = r5.mlanguage;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdescription_i18n;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SubtitleLanguage) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SubtitleLanguage();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3121newBuilder() {
            Builder r0 = new Builder();
            r0.mlanguage = this.mlanguage;
            r0.mdescription_i18n = this.mdescription_i18n;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SubtitleLanguage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3121newBuilder();
        }

        public SubtitleLanguage(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public SubtitleLanguage(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mlanguage = r2;
            this.mdescription_i18n = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLiveRecordingSettingResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_BILINGUAL = r0;
        DEFAULT_WAITING_TIME = 0L;
        DEFAULT_CAN_RECORDING_MARK = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3118newBuilder() {
        Builder r0 = new Builder();
        r0.mspoken_language_list = Internal.copyOf("mspoken_language_list", this.mspoken_language_list);
        r0.mtranslation_language_list = Internal.copyOf("mtranslation_language_list", this.mtranslation_language_list);
        r0.mspoken_language = this.mspoken_language;
        r0.mtranslation_language = this.mtranslation_language;
        r0.mis_bilingual = this.mis_bilingual;
        r0.mwaiting_time = this.mwaiting_time;
        r0.mcan_recording_mark = this.mcan_recording_mark;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetLiveRecordingSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3118newBuilder();
    }

    public GetLiveRecordingSettingResponse(List<SubtitleLanguage> r10, List<SubtitleLanguage> r11, SubtitleLanguage r12, SubtitleLanguage r13, Boolean r14, Long r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public GetLiveRecordingSettingResponse(List<SubtitleLanguage> r2, List<SubtitleLanguage> r3, SubtitleLanguage r4, SubtitleLanguage r5, Boolean r6, Long r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mspoken_language_list = Internal.immutableCopyOf("mspoken_language_list", r2);
        this.mtranslation_language_list = Internal.immutableCopyOf("mtranslation_language_list", r3);
        this.mspoken_language = r4;
        this.mtranslation_language = r5;
        this.mis_bilingual = r6;
        this.mwaiting_time = r7;
        this.mcan_recording_mark = r8;
    }
}
