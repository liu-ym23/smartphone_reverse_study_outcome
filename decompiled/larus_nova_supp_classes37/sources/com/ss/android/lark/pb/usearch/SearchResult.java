package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.security.AuthEntity;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchResult extends Message<SearchResult, Builder> {
    public static final ProtoAdapter<SearchResult> ADAPTER = null;
    public static final String DEFAULT_AUTHZ_ID = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_BID = "";
    public static final String DEFAULT_ENTITY_TYPE = "";
    public static final String DEFAULT_EXTRAS_HIGHLIGHTED = "";
    public static final String DEFAULT_EXTRA_INFO_SEPARATOR = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_TRANSLATED = null;
    public static final String DEFAULT_RAW_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_RAW_TITLE_HIGHLIGHTED = "";
    public static final String DEFAULT_RENDER_DATA = "";
    public static final String DEFAULT_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    public static final String DEFAULT_TRACKING_META = "";
    public static final FieldOptions FIELD_OPTIONS_MAUTHZ_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MRESULT_META = null;
    public static final FieldOptions FIELD_OPTIONS_MTYPE = null;
    private static final long serialVersionUID = 0;
    public final String mauthz_id;
    public final String mavatar_key;
    public final AvatarType mavatar_type;
    public final List<BaikeEntry> mbaike_entries;
    public final String mbid;
    public final String mentity_type;
    public final List<ExplanationTag> mexplanation_tags;
    public final String mextra_info_separator;
    public final List<ExtraInfoBlock> mextra_infos;
    public final String mextras_highlighted;
    public final String mid;
    public final Boolean mis_translated;
    public final List<ParsingInfo> mparsing_infos;
    public final String mraw_summary_highlighted;
    public final String mraw_title_highlighted;
    public final RecallScene mrecall_scene;
    public final String mrender_data;
    public final ResultMeta mresult_meta;
    public final String msummary_highlighted;
    public final String mtitle_highlighted;
    public final String mtracking_meta;
    public final SearchEntityType mtype;

    public static final enum AvatarType extends Enum<AvatarType> implements WireEnum {
        private static final /* synthetic */ AvatarType[] $VALUES = null;
        public static final ProtoAdapter<AvatarType> ADAPTER = null;
        public static final AvatarType CHAT = null;
        public static final AvatarType CHATTER = null;
        public static final AvatarType UNKNOWN = null;
        private final int value;

        static {
            AvatarType r0 = new AvatarType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AvatarType r1 = new AvatarType("CHAT", 1, 1);
            CHAT = r1;
            AvatarType r3 = new AvatarType("CHATTER", 2, 2);
            CHATTER = r3;
            $VALUES = new AvatarType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(AvatarType.class);
        }

        public static AvatarType[] values() {
            return (AvatarType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AvatarType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CHATTER;
        L12:
            return CHAT;
        L14:
            return UNKNOWN;
        }

        public static AvatarType valueOf(String r1) {
            return (AvatarType) a.a(AvatarType.class, r1);
        }

        private AvatarType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<SearchResult, Builder> {
        public String mauthz_id;
        public String mavatar_key;
        public AvatarType mavatar_type;
        public List<BaikeEntry> mbaike_entries;
        public String mbid;
        public String mentity_type;
        public List<ExplanationTag> mexplanation_tags;
        public String mextra_info_separator;
        public List<ExtraInfoBlock> mextra_infos;
        public String mextras_highlighted;
        public String mid;
        public Boolean mis_translated;
        public List<ParsingInfo> mparsing_infos;
        public String mraw_summary_highlighted;
        public String mraw_title_highlighted;
        public RecallScene mrecall_scene;
        public String mrender_data;
        public ResultMeta mresult_meta;
        public String msummary_highlighted;
        public String mtitle_highlighted;
        public String mtracking_meta;
        public SearchEntityType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchResult m2831build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new SearchResult(this.mid, this.mtype, this.mtitle_highlighted, this.msummary_highlighted, this.mextras_highlighted, this.mavatar_key, this.mresult_meta, this.mexplanation_tags, this.mextra_infos, this.mextra_info_separator, this.mbaike_entries, this.mis_translated, this.mraw_title_highlighted, this.mraw_summary_highlighted, this.mbid, this.mentity_type, this.mauthz_id, this.mtracking_meta, this.mrender_data, this.mparsing_infos, this.mavatar_type, this.mrecall_scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mexplanation_tags = Internal.newMutableList();
            this.mextra_infos = Internal.newMutableList();
            this.mbaike_entries = Internal.newMutableList();
            this.mparsing_infos = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2831build();
        }

        public Builder authz_id(String r1) {
            this.mauthz_id = r1;
            return this;
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder avatar_type(AvatarType r1) {
            this.mavatar_type = r1;
            return this;
        }

        public Builder baike_entries(List<BaikeEntry> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbaike_entries = r1;
            return this;
        }

        public Builder bid(String r1) {
            this.mbid = r1;
            return this;
        }

        public Builder entity_type(String r1) {
            this.mentity_type = r1;
            return this;
        }

        public Builder explanation_tags(List<ExplanationTag> r1) {
            Internal.checkElementsNotNull(r1);
            this.mexplanation_tags = r1;
            return this;
        }

        public Builder extra_info_separator(String r1) {
            this.mextra_info_separator = r1;
            return this;
        }

        public Builder extra_infos(List<ExtraInfoBlock> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextra_infos = r1;
            return this;
        }

        public Builder extras_highlighted(String r1) {
            this.mextras_highlighted = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_translated(Boolean r1) {
            this.mis_translated = r1;
            return this;
        }

        public Builder parsing_infos(List<ParsingInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparsing_infos = r1;
            return this;
        }

        public Builder raw_summary_highlighted(String r1) {
            this.mraw_summary_highlighted = r1;
            return this;
        }

        public Builder raw_title_highlighted(String r1) {
            this.mraw_title_highlighted = r1;
            return this;
        }

        public Builder recall_scene(RecallScene r1) {
            this.mrecall_scene = r1;
            return this;
        }

        public Builder render_data(String r1) {
            this.mrender_data = r1;
            return this;
        }

        public Builder result_meta(ResultMeta r1) {
            this.mresult_meta = r1;
            return this;
        }

        public Builder summary_highlighted(String r1) {
            this.msummary_highlighted = r1;
            return this;
        }

        public Builder title_highlighted(String r1) {
            this.mtitle_highlighted = r1;
            return this;
        }

        public Builder tracking_meta(String r1) {
            this.mtracking_meta = r1;
            return this;
        }

        public Builder type(SearchEntityType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchResult extends ProtoAdapter<SearchResult> {
        public ProtoAdapter_SearchResult() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchResult.class);
        }

        public SearchResult decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtitle_highlighted = "";
            r0.msummary_highlighted = "";
            r0.mextras_highlighted = "";
            r0.mavatar_key = "";
            r0.mextra_info_separator = "";
            r0.mis_translated = Boolean.FALSE;
            r0.mraw_title_highlighted = "";
            r0.mraw_summary_highlighted = "";
            r0.mbid = "";
            r0.mentity_type = "";
            r0.mauthz_id = "";
            r0.mtracking_meta = "";
            r0.mrender_data = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L38;
            switch(r3) {
                case 1: goto L37;
                case 2: goto L42;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L23;
                case 13: goto L22;
                case 14: goto L21;
                case 15: goto L20;
                case 16: goto L19;
                case 17: goto L18;
                case 18: goto L17;
                case 19: goto L16;
                case 20: goto L15;
                case 21: goto L44;
                case 22: goto L40;
                default: goto L6;
            };
        L40:
            r0.mrecall_scene = (RecallScene) RecallScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r0.mtype = (SearchEntityType) SearchEntityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L35
        L35:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r0.mavatar_type = (AvatarType) AvatarType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r0.mparsing_infos.add((ParsingInfo) ParsingInfo.ADAPTER.decode(r9));
            goto L3
        L16:
            r0.mrender_data = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mtracking_meta = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mauthz_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mentity_type = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mbid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mraw_summary_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mraw_title_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mis_translated = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.mbaike_entries.add((BaikeEntry) BaikeEntry.ADAPTER.decode(r9));
            goto L3
        L25:
            r0.mextra_info_separator = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L26:
            r0.mextra_infos.add((ExtraInfoBlock) ExtraInfoBlock.ADAPTER.decode(r9));
            goto L3
        L27:
            r0.mexplanation_tags.add((ExplanationTag) ExplanationTag.ADAPTER.decode(r9));
            goto L3
        L28:
            r0.mresult_meta = (ResultMeta) ResultMeta.ADAPTER.decode(r9);
            goto L3
        L29:
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L30:
            r0.mextras_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.msummary_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L32:
            r0.mtitle_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L37:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L38:
            r9.endMessage(r1);
            return r0.m2831build();
        }

        public int encodedSize(SearchResult r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            SearchEntityType r2 = r7.mtype;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = SearchEntityType.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mtitle_highlighted;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.msummary_highlighted;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mextras_highlighted;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mavatar_key;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            ResultMeta r19 = r7.mresult_meta;
            if (r19 == null) goto L25;
            int r20 = ResultMeta.ADAPTER.encodedSizeWithTag(7, r19);
        L26:
            int r21 = ((r18 + r20) + ExplanationTag.ADAPTER.asRepeated().encodedSizeWithTag(8, r7.mexplanation_tags)) + ExtraInfoBlock.ADAPTER.asRepeated().encodedSizeWithTag(9, r7.mextra_infos);
            String r22 = r7.mextra_info_separator;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(10, r22);
        L30:
            int r24 = (r21 + r23) + BaikeEntry.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mbaike_entries);
            Boolean r25 = r7.mis_translated;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r25);
        L34:
            int r27 = r24 + r26;
            String r28 = r7.mraw_title_highlighted;
            if (r28 == null) goto L37;
            int r29 = r0.encodedSizeWithTag(13, r28);
        L38:
            int r30 = r27 + r29;
            String r31 = r7.mraw_summary_highlighted;
            if (r31 == null) goto L41;
            int r32 = r0.encodedSizeWithTag(14, r31);
        L42:
            int r33 = r30 + r32;
            String r34 = r7.mbid;
            if (r34 == null) goto L45;
            int r35 = r0.encodedSizeWithTag(15, r34);
        L46:
            int r36 = r33 + r35;
            String r37 = r7.mentity_type;
            if (r37 == null) goto L49;
            int r38 = r0.encodedSizeWithTag(16, r37);
        L50:
            int r39 = r36 + r38;
            String r40 = r7.mauthz_id;
            if (r40 == null) goto L53;
            int r41 = r0.encodedSizeWithTag(17, r40);
        L54:
            int r42 = r39 + r41;
            String r43 = r7.mtracking_meta;
            if (r43 == null) goto L57;
            int r44 = r0.encodedSizeWithTag(18, r43);
        L58:
            int r45 = r42 + r44;
            String r46 = r7.mrender_data;
            if (r46 == null) goto L61;
            int r47 = r0.encodedSizeWithTag(19, r46);
        L62:
            int r48 = (r45 + r47) + ParsingInfo.ADAPTER.asRepeated().encodedSizeWithTag(20, r7.mparsing_infos);
            AvatarType r49 = r7.mavatar_type;
            if (r49 == null) goto L65;
            int r50 = AvatarType.ADAPTER.encodedSizeWithTag(21, r49);
        L66:
            int r51 = r48 + r50;
            RecallScene r52 = r7.mrecall_scene;
            if (r52 == null) goto L70;
            r3 = RecallScene.ADAPTER.encodedSizeWithTag(22, r52);
        L70:
            return (r51 + r3) + r7.unknownFields().size();
        L65:
            r50 = 0;
            goto L66
        L61:
            r47 = 0;
            goto L62
        L57:
            r44 = 0;
            goto L58
        L53:
            r41 = 0;
            goto L54
        L49:
            r38 = 0;
            goto L50
        L45:
            r35 = 0;
            goto L46
        L41:
            r32 = 0;
            goto L42
        L37:
            r29 = 0;
            goto L38
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Object m2832decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchResult) r1);
        }

        public void encode(ProtoWriter r5, SearchResult r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            SearchEntityType r1 = r6.mtype;
            if (r1 == null) goto L5;
            SearchEntityType.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mtitle_highlighted;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.msummary_highlighted;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.mextras_highlighted;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mavatar_key;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            ResultMeta r8 = r6.mresult_meta;
            if (r8 == null) goto L20;
            ResultMeta.ADAPTER.encodeWithTag(r5, 7, r8);
        L20:
            ExplanationTag.ADAPTER.asRepeated().encodeWithTag(r5, 8, r6.mexplanation_tags);
            ExtraInfoBlock.ADAPTER.asRepeated().encodeWithTag(r5, 9, r6.mextra_infos);
            String r9 = r6.mextra_info_separator;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 10, r9);
        L23:
            BaikeEntry.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mbaike_entries);
            Boolean r10 = r6.mis_translated;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 12, r10);
        L26:
            String r11 = r6.mraw_title_highlighted;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 13, r11);
        L29:
            String r12 = r6.mraw_summary_highlighted;
            if (r12 == null) goto L32;
            r0.encodeWithTag(r5, 14, r12);
        L32:
            String r13 = r6.mbid;
            if (r13 == null) goto L35;
            r0.encodeWithTag(r5, 15, r13);
        L35:
            String r14 = r6.mentity_type;
            if (r14 == null) goto L38;
            r0.encodeWithTag(r5, 16, r14);
        L38:
            String r15 = r6.mauthz_id;
            if (r15 == null) goto L41;
            r0.encodeWithTag(r5, 17, r15);
        L41:
            String r16 = r6.mtracking_meta;
            if (r16 == null) goto L44;
            r0.encodeWithTag(r5, 18, r16);
        L44:
            String r17 = r6.mrender_data;
            if (r17 == null) goto L47;
            r0.encodeWithTag(r5, 19, r17);
        L47:
            ParsingInfo.ADAPTER.asRepeated().encodeWithTag(r5, 20, r6.mparsing_infos);
            AvatarType r18 = r6.mavatar_type;
            if (r18 == null) goto L50;
            AvatarType.ADAPTER.encodeWithTag(r5, 21, r18);
        L50:
            RecallScene r19 = r6.mrecall_scene;
            if (r19 == null) goto L53;
            RecallScene.ADAPTER.encodeWithTag(r5, 22, r19);
        L53:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchResult) r2);
        }
    }

    public static final enum RecallScene extends Enum<RecallScene> implements WireEnum {
        private static final /* synthetic */ RecallScene[] $VALUES = null;
        public static final ProtoAdapter<RecallScene> ADAPTER = null;
        public static final RecallScene DEFAULT = null;
        public static final RecallScene MESSAGE_PINYIN_TO_CHINESE_NAME = null;
        private final int value;

        static {
            RecallScene r0 = new RecallScene("DEFAULT", 0, 0);
            DEFAULT = r0;
            RecallScene r1 = new RecallScene("MESSAGE_PINYIN_TO_CHINESE_NAME", 1, 1);
            MESSAGE_PINYIN_TO_CHINESE_NAME = r1;
            $VALUES = new RecallScene[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(RecallScene.class);
        }

        public static RecallScene[] values() {
            return (RecallScene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static RecallScene fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return MESSAGE_PINYIN_TO_CHINESE_NAME;
        L10:
            return DEFAULT;
        }

        public static RecallScene valueOf(String r1) {
            return (RecallScene) a.a(RecallScene.class, r1);
        }

        private RecallScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchResult();
        FieldOptions.Builder r0 = new FieldOptions.Builder();
        Boolean r1 = Boolean.TRUE;
        FIELD_OPTIONS_MTYPE = r0.security_field(r1).security_search_entity_type(r1).build();
        FIELD_OPTIONS_MRESULT_META = new FieldOptions.Builder().security_field(r1).build();
        FIELD_OPTIONS_MAUTHZ_ID = new FieldOptions.Builder().security_field(r1).security_object(new AuthEntity.Builder().m2153build()).build();
        DEFAULT_IS_TRANSLATED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2830newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mtitle_highlighted = this.mtitle_highlighted;
        r0.msummary_highlighted = this.msummary_highlighted;
        r0.mextras_highlighted = this.mextras_highlighted;
        r0.mavatar_key = this.mavatar_key;
        r0.mresult_meta = this.mresult_meta;
        r0.mexplanation_tags = Internal.copyOf("mexplanation_tags", this.mexplanation_tags);
        r0.mextra_infos = Internal.copyOf("mextra_infos", this.mextra_infos);
        r0.mextra_info_separator = this.mextra_info_separator;
        r0.mbaike_entries = Internal.copyOf("mbaike_entries", this.mbaike_entries);
        r0.mis_translated = this.mis_translated;
        r0.mraw_title_highlighted = this.mraw_title_highlighted;
        r0.mraw_summary_highlighted = this.mraw_summary_highlighted;
        r0.mbid = this.mbid;
        r0.mentity_type = this.mentity_type;
        r0.mauthz_id = this.mauthz_id;
        r0.mtracking_meta = this.mtracking_meta;
        r0.mrender_data = this.mrender_data;
        r0.mparsing_infos = Internal.copyOf("mparsing_infos", this.mparsing_infos);
        r0.mavatar_type = this.mavatar_type;
        r0.mrecall_scene = this.mrecall_scene;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2830newBuilder();
    }

    public SearchResult(String r25, SearchEntityType r26, String r27, String r28, String r29, String r30, ResultMeta r31, List<ExplanationTag> r32, List<ExtraInfoBlock> r33, String r34, List<BaikeEntry> r35, Boolean r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, List<ParsingInfo> r44, AvatarType r45, RecallScene r46) {
        this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, ByteString.EMPTY);
    }

    public SearchResult(String r4, SearchEntityType r5, String r6, String r7, String r8, String r9, ResultMeta r10, List<ExplanationTag> r11, List<ExtraInfoBlock> r12, String r13, List<BaikeEntry> r14, Boolean r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, List<ParsingInfo> r23, AvatarType r24, RecallScene r25, ByteString r26) {
        super(ADAPTER, r26);
        this.mid = r4;
        this.mtype = r5;
        this.mtitle_highlighted = r6;
        this.msummary_highlighted = r7;
        this.mextras_highlighted = r8;
        this.mavatar_key = r9;
        this.mresult_meta = r10;
        this.mexplanation_tags = Internal.immutableCopyOf("mexplanation_tags", r11);
        this.mextra_infos = Internal.immutableCopyOf("mextra_infos", r12);
        this.mextra_info_separator = r13;
        this.mbaike_entries = Internal.immutableCopyOf("mbaike_entries", r14);
        this.mis_translated = r15;
        this.mraw_title_highlighted = r16;
        this.mraw_summary_highlighted = r17;
        this.mbid = r18;
        this.mentity_type = r19;
        this.mauthz_id = r20;
        this.mtracking_meta = r21;
        this.mrender_data = r22;
        this.mparsing_infos = Internal.immutableCopyOf("mparsing_infos", r23);
        this.mavatar_type = r24;
        this.mrecall_scene = r25;
    }
}
