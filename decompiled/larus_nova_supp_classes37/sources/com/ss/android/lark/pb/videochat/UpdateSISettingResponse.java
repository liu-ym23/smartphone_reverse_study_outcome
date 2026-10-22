package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateSISettingResponse extends Message<UpdateSISettingResponse, Builder> {
    public static final ProtoAdapter<UpdateSISettingResponse> ADAPTER = null;
    public static final String DEFAULT_CHANNEL = "";
    public static final String DEFAULT_HIGHLIGHT_SUBTITLE_LANG = "";
    private static final long serialVersionUID = 0;
    public final String mchannel;
    public final SILanguage mhighlight_lang;
    public final SILanguage mhighlight_spoken_lang;
    public final String mhighlight_subtitle_lang;
    public final Status mstatus;
    public final List<SILanguage> msupport_lans;
    public final List<SILanguage> msupport_spoken_lans;
    public final Map<String, StringList> msupport_spoken_translate_map_lans;
    public final Map<String, StringList> msupport_translate_spoken_map_lans;

    public static final class Builder extends Message.Builder<UpdateSISettingResponse, Builder> {
        public String mchannel;
        public SILanguage mhighlight_lang;
        public SILanguage mhighlight_spoken_lang;
        public String mhighlight_subtitle_lang;
        public Status mstatus;
        public List<SILanguage> msupport_lans;
        public List<SILanguage> msupport_spoken_lans;
        public Map<String, StringList> msupport_spoken_translate_map_lans;
        public Map<String, StringList> msupport_translate_spoken_map_lans;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateSISettingResponse m3206build() {
            return new UpdateSISettingResponse(this.mstatus, this.mchannel, this.mhighlight_subtitle_lang, this.mhighlight_lang, this.msupport_lans, this.msupport_spoken_lans, this.msupport_spoken_translate_map_lans, this.msupport_translate_spoken_map_lans, this.mhighlight_spoken_lang, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_lans = Internal.newMutableList();
            this.msupport_spoken_lans = Internal.newMutableList();
            this.msupport_spoken_translate_map_lans = Internal.newMutableMap();
            this.msupport_translate_spoken_map_lans = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3206build();
        }

        public Builder channel(String r1) {
            this.mchannel = r1;
            return this;
        }

        public Builder highlight_lang(SILanguage r1) {
            this.mhighlight_lang = r1;
            return this;
        }

        public Builder highlight_spoken_lang(SILanguage r1) {
            this.mhighlight_spoken_lang = r1;
            return this;
        }

        public Builder highlight_subtitle_lang(String r1) {
            this.mhighlight_subtitle_lang = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder support_lans(List<SILanguage> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_lans = r1;
            return this;
        }

        public Builder support_spoken_lans(List<SILanguage> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_spoken_lans = r1;
            return this;
        }

        public Builder support_spoken_translate_map_lans(Map<String, StringList> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_spoken_translate_map_lans = r1;
            return this;
        }

        public Builder support_translate_spoken_map_lans(Map<String, StringList> r1) {
            Internal.checkElementsNotNull(r1);
            this.msupport_translate_spoken_map_lans = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateSISettingResponse extends ProtoAdapter<UpdateSISettingResponse> {
        private final ProtoAdapter<Map<String, StringList>> msupport_spoken_translate_map_lans;
        private final ProtoAdapter<Map<String, StringList>> msupport_translate_spoken_map_lans;

        public ProtoAdapter_UpdateSISettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateSISettingResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            ProtoAdapter<StringList> r1 = StringList.ADAPTER;
            this.msupport_spoken_translate_map_lans = ProtoAdapter.newMapAdapter(r0, r1);
            this.msupport_translate_spoken_map_lans = ProtoAdapter.newMapAdapter(r0, r1);
        }

        public UpdateSISettingResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchannel = "";
            r0.mhighlight_subtitle_lang = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mhighlight_spoken_lang = (SILanguage) SILanguage.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.msupport_translate_spoken_map_lans.putAll((Map) this.msupport_translate_spoken_map_lans.decode(r9));
            goto L3
        L9:
            r0.msupport_spoken_translate_map_lans.putAll((Map) this.msupport_spoken_translate_map_lans.decode(r9));
            goto L3
        L10:
            r0.msupport_spoken_lans.add((SILanguage) SILanguage.ADAPTER.decode(r9));
            goto L3
        L11:
            r0.msupport_lans.add((SILanguage) SILanguage.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.mhighlight_lang = (SILanguage) SILanguage.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mhighlight_subtitle_lang = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mchannel = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m3206build();
        }

        public int encodedSize(UpdateSISettingResponse r7) {
            Status r0 = r7.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Status.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r7.mchannel;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r6 = r7.mhighlight_subtitle_lang;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            SILanguage r10 = r7.mhighlight_lang;
            if (r10 == null) goto L17;
            int r11 = SILanguage.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ProtoAdapter<SILanguage> r13 = SILanguage.ADAPTER;
            int r14 = (((r12 + r13.asRepeated().encodedSizeWithTag(5, r7.msupport_lans)) + r13.asRepeated().encodedSizeWithTag(6, r7.msupport_spoken_lans)) + this.msupport_spoken_translate_map_lans.encodedSizeWithTag(7, r7.msupport_spoken_translate_map_lans)) + this.msupport_translate_spoken_map_lans.encodedSizeWithTag(8, r7.msupport_translate_spoken_map_lans);
            SILanguage r15 = r7.mhighlight_spoken_lang;
            if (r15 == null) goto L22;
            r1 = r13.encodedSizeWithTag(9, r15);
        L22:
            return (r14 + r1) + r7.unknownFields().size();
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3207decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateSISettingResponse) r1);
        }

        public void encode(ProtoWriter r5, UpdateSISettingResponse r6) throws IOException {
            Status r0 = r6.mstatus;
            if (r0 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r5, 1, r0);
        L5:
            String r1 = r6.mchannel;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
        L8:
            String r2 = r6.mhighlight_subtitle_lang;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
        L11:
            SILanguage r3 = r6.mhighlight_lang;
            if (r3 == null) goto L14;
            SILanguage.ADAPTER.encodeWithTag(r5, 4, r3);
        L14:
            ProtoAdapter<SILanguage> r4 = SILanguage.ADAPTER;
            r4.asRepeated().encodeWithTag(r5, 5, r6.msupport_lans);
            r4.asRepeated().encodeWithTag(r5, 6, r6.msupport_spoken_lans);
            this.msupport_spoken_translate_map_lans.encodeWithTag(r5, 7, r6.msupport_spoken_translate_map_lans);
            this.msupport_translate_spoken_map_lans.encodeWithTag(r5, 8, r6.msupport_translate_spoken_map_lans);
            SILanguage r7 = r6.mhighlight_spoken_lang;
            if (r7 == null) goto L17;
            r4.encodeWithTag(r5, 9, r7);
        L17:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateSISettingResponse) r2);
        }
    }

    public static final class SILanguage extends Message<SILanguage, Builder> {
        public static final ProtoAdapter<SILanguage> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION_I18N = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription_i18n;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<SILanguage, Builder> {
            public String mdescription_i18n;
            public String mlanguage;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SILanguage m3209build() {
                return new SILanguage(this.mlanguage, this.mdescription_i18n, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3209build();
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

        public static final class ProtoAdapter_SILanguage extends ProtoAdapter<SILanguage> {
            public ProtoAdapter_SILanguage() {
                super(FieldEncoding.LENGTH_DELIMITED, SILanguage.class);
            }

            public SILanguage decode(ProtoReader r7) throws IOException {
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
                return r0.m3209build();
            }

            public int encodedSize(SILanguage r5) {
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
            public /* bridge */ /* synthetic */ Object m3210decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SILanguage) r1);
            }

            public void encode(ProtoWriter r4, SILanguage r5) throws IOException {
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
                encode(r1, (SILanguage) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SILanguage();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3208newBuilder() {
            Builder r0 = new Builder();
            r0.mlanguage = this.mlanguage;
            r0.mdescription_i18n = this.mdescription_i18n;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SILanguage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3208newBuilder();
        }

        public SILanguage(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public SILanguage(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mlanguage = r2;
            this.mdescription_i18n = r3;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status FAIL = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;
        public static final Status WAITING = null;
        private final int value;

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("SUCCESS", 1, 1);
            SUCCESS = r1;
            Status r3 = new Status("WAITING", 2, 2);
            WAITING = r3;
            Status r5 = new Status("FAIL", 3, 3);
            FAIL = r5;
            $VALUES = new Status[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return FAIL;
        L14:
            return WAITING;
        L16:
            return SUCCESS;
        L18:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class StringList extends Message<StringList, Builder> {
        public static final ProtoAdapter<StringList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mvalues;

        public static final class Builder extends Message.Builder<StringList, Builder> {
            public List<String> mvalues;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public StringList m3212build() {
                return new StringList(this.mvalues, super.buildUnknownFields());
            }

            public Builder() {
                this.mvalues = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3212build();
            }

            public Builder values(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mvalues = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_StringList extends ProtoAdapter<StringList> {
            public ProtoAdapter_StringList() {
                super(FieldEncoding.LENGTH_DELIMITED, StringList.class);
            }

            public StringList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mvalues.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3212build();
            }

            public int encodedSize(StringList r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mvalues) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3213decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((StringList) r1);
            }

            public void encode(ProtoWriter r4, StringList r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mvalues);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (StringList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_StringList();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3211newBuilder() {
            Builder r0 = new Builder();
            r0.mvalues = Internal.copyOf("mvalues", this.mvalues);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return StringList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3211newBuilder();
        }

        public StringList(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public StringList(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mvalues = Internal.immutableCopyOf("mvalues", r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateSISettingResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3205newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mchannel = this.mchannel;
        r0.mhighlight_subtitle_lang = this.mhighlight_subtitle_lang;
        r0.mhighlight_lang = this.mhighlight_lang;
        r0.msupport_lans = Internal.copyOf("msupport_lans", this.msupport_lans);
        r0.msupport_spoken_lans = Internal.copyOf("msupport_spoken_lans", this.msupport_spoken_lans);
        r0.msupport_spoken_translate_map_lans = Internal.copyOf("msupport_spoken_translate_map_lans", this.msupport_spoken_translate_map_lans);
        r0.msupport_translate_spoken_map_lans = Internal.copyOf("msupport_translate_spoken_map_lans", this.msupport_translate_spoken_map_lans);
        r0.mhighlight_spoken_lang = this.mhighlight_spoken_lang;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateSISettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3205newBuilder();
    }

    public UpdateSISettingResponse(Status r12, String r13, String r14, SILanguage r15, List<SILanguage> r16, List<SILanguage> r17, Map<String, StringList> r18, Map<String, StringList> r19, SILanguage r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public UpdateSISettingResponse(Status r2, String r3, String r4, SILanguage r5, List<SILanguage> r6, List<SILanguage> r7, Map<String, StringList> r8, Map<String, StringList> r9, SILanguage r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mstatus = r2;
        this.mchannel = r3;
        this.mhighlight_subtitle_lang = r4;
        this.mhighlight_lang = r5;
        this.msupport_lans = Internal.immutableCopyOf("msupport_lans", r6);
        this.msupport_spoken_lans = Internal.immutableCopyOf("msupport_spoken_lans", r7);
        this.msupport_spoken_translate_map_lans = Internal.immutableCopyOf("msupport_spoken_translate_map_lans", r8);
        this.msupport_translate_spoken_map_lans = Internal.immutableCopyOf("msupport_translate_spoken_map_lans", r9);
        this.mhighlight_spoken_lang = r10;
    }
}
