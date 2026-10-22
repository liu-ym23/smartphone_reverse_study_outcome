package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.RichText;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NotesBlock extends Message<NotesBlock, Builder> {
    public static final ProtoAdapter<NotesBlock> ADAPTER = null;
    public static final String DEFAULT_AI_CONTENT_MARKDOWN = "";
    public static final Long DEFAULT_AUDIO_LOCATION_TIME = null;
    public static final Long DEFAULT_CID = null;
    public static final Long DEFAULT_CLIENT_CREATE_TIME = null;
    public static final Long DEFAULT_CREATE_REL_AUDIO_TIME = null;
    public static final Long DEFAULT_CREATE_REL_MEETING_TIME = null;
    public static final Boolean DEFAULT_DELETED = null;
    public static final String DEFAULT_INPUT_CONTENT_MARKDOWN = "";
    public static final String DEFAULT_MARK_ID = "";
    public static final Boolean DEFAULT_POLISH_ENABLED = null;
    public static final Long DEFAULT_SERVICE_TIME = null;
    public static final Long DEFAULT_SID = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final RichText mai_content;
    public final String mai_content_markdown;
    public final Long maudio_location_time;
    public final Long mcid;
    public final Long mclient_create_time;
    public final PolishContentState mcontent_state;
    public final Long mcreate_rel_audio_time;
    public final Long mcreate_rel_meeting_time;
    public final CreateSource mcreate_source;
    public final Boolean mdeleted;
    public final List<ImageSetV2> mfull_images;
    public final List<String> mimages;
    public final ImageInfo mimages_v2;
    public final RichText minput_content;
    public final String minput_content_markdown;
    public final String mmark_id;
    public final NoteType mnote_type;
    public final Boolean mpolish_enabled;
    public final Long mservice_time;
    public final Long msid;
    public final Long mversion;

    public static final class Builder extends Message.Builder<NotesBlock, Builder> {
        public RichText mai_content;
        public String mai_content_markdown;
        public Long maudio_location_time;
        public Long mcid;
        public Long mclient_create_time;
        public PolishContentState mcontent_state;
        public Long mcreate_rel_audio_time;
        public Long mcreate_rel_meeting_time;
        public CreateSource mcreate_source;
        public Boolean mdeleted;
        public List<ImageSetV2> mfull_images;
        public List<String> mimages;
        public ImageInfo mimages_v2;
        public RichText minput_content;
        public String minput_content_markdown;
        public String mmark_id;
        public NoteType mnote_type;
        public Boolean mpolish_enabled;
        public Long mservice_time;
        public Long msid;
        public Long mversion;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public NotesBlock m3299build() {
            return new NotesBlock(this.minput_content, this.mcid, this.msid, this.mclient_create_time, this.mservice_time, this.mai_content, this.mnote_type, this.mversion, this.mpolish_enabled, this.mdeleted, this.mimages, this.mcontent_state, this.mcreate_rel_meeting_time, this.mcreate_rel_audio_time, this.minput_content_markdown, this.mai_content_markdown, this.maudio_location_time, this.mmark_id, this.mfull_images, this.mcreate_source, this.mimages_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.mimages = Internal.newMutableList();
            this.mfull_images = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3299build();
        }

        public Builder ai_content(RichText r1) {
            this.mai_content = r1;
            return this;
        }

        public Builder ai_content_markdown(String r1) {
            this.mai_content_markdown = r1;
            return this;
        }

        public Builder audio_location_time(Long r1) {
            this.maudio_location_time = r1;
            return this;
        }

        public Builder cid(Long r1) {
            this.mcid = r1;
            return this;
        }

        public Builder client_create_time(Long r1) {
            this.mclient_create_time = r1;
            return this;
        }

        public Builder content_state(PolishContentState r1) {
            this.mcontent_state = r1;
            return this;
        }

        public Builder create_rel_audio_time(Long r1) {
            this.mcreate_rel_audio_time = r1;
            return this;
        }

        public Builder create_rel_meeting_time(Long r1) {
            this.mcreate_rel_meeting_time = r1;
            return this;
        }

        public Builder create_source(CreateSource r1) {
            this.mcreate_source = r1;
            return this;
        }

        public Builder deleted(Boolean r1) {
            this.mdeleted = r1;
            return this;
        }

        public Builder full_images(List<ImageSetV2> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfull_images = r1;
            return this;
        }

        public Builder images(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimages = r1;
            return this;
        }

        public Builder images_v2(ImageInfo r1) {
            this.mimages_v2 = r1;
            return this;
        }

        public Builder input_content(RichText r1) {
            this.minput_content = r1;
            return this;
        }

        public Builder input_content_markdown(String r1) {
            this.minput_content_markdown = r1;
            return this;
        }

        public Builder mark_id(String r1) {
            this.mmark_id = r1;
            return this;
        }

        public Builder note_type(NoteType r1) {
            this.mnote_type = r1;
            return this;
        }

        public Builder polish_enabled(Boolean r1) {
            this.mpolish_enabled = r1;
            return this;
        }

        public Builder service_time(Long r1) {
            this.mservice_time = r1;
            return this;
        }

        public Builder sid(Long r1) {
            this.msid = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.mversion = r1;
            return this;
        }
    }

    public static final enum CreateSource extends Enum<CreateSource> implements WireEnum {
        private static final /* synthetic */ CreateSource[] $VALUES = null;
        public static final ProtoAdapter<CreateSource> ADAPTER = null;
        public static final CreateSource AI_VISION_HIGHLIGHT = null;
        public static final CreateSource EMPTY_STATE = null;
        public static final CreateSource HIGHLIGHT = null;
        public static final CreateSource INPUT = null;
        public static final CreateSource PHOTO = null;
        public static final CreateSource SUBTITLE_HIGHLIGHT = null;
        private final int value;

        static {
            CreateSource r0 = new CreateSource("INPUT", 0, 0);
            INPUT = r0;
            CreateSource r1 = new CreateSource("HIGHLIGHT", 1, 1);
            HIGHLIGHT = r1;
            CreateSource r3 = new CreateSource("PHOTO", 2, 2);
            PHOTO = r3;
            CreateSource r5 = new CreateSource("SUBTITLE_HIGHLIGHT", 3, 3);
            SUBTITLE_HIGHLIGHT = r5;
            CreateSource r7 = new CreateSource("AI_VISION_HIGHLIGHT", 4, 4);
            AI_VISION_HIGHLIGHT = r7;
            CreateSource r9 = new CreateSource("EMPTY_STATE", 5, 5);
            EMPTY_STATE = r9;
            $VALUES = new CreateSource[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(CreateSource.class);
        }

        public static CreateSource[] values() {
            return (CreateSource[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CreateSource fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return EMPTY_STATE;
        L18:
            return AI_VISION_HIGHLIGHT;
        L20:
            return SUBTITLE_HIGHLIGHT;
        L22:
            return PHOTO;
        L24:
            return HIGHLIGHT;
        L26:
            return INPUT;
        }

        public static CreateSource valueOf(String r1) {
            return (CreateSource) a.a(CreateSource.class, r1);
        }

        private CreateSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ImageInfo extends Message<ImageInfo, Builder> {
        public static final ProtoAdapter<ImageInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mimages;

        public static final class Builder extends Message.Builder<ImageInfo, Builder> {
            public List<String> mimages;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ImageInfo m3301build() {
                return new ImageInfo(this.mimages, super.buildUnknownFields());
            }

            public Builder() {
                this.mimages = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3301build();
            }

            public Builder images(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mimages = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageInfo extends ProtoAdapter<ImageInfo> {
            public ProtoAdapter_ImageInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageInfo.class);
            }

            public ImageInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mimages.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3301build();
            }

            public int encodedSize(ImageInfo r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mimages) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3302decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ImageInfo) r1);
            }

            public void encode(ProtoWriter r4, ImageInfo r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mimages);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ImageInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3300newBuilder() {
            Builder r0 = new Builder();
            r0.mimages = Internal.copyOf("mimages", this.mimages);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ImageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3300newBuilder();
        }

        public ImageInfo(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public ImageInfo(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mimages = Internal.immutableCopyOf("mimages", r2);
        }
    }

    public static final enum NoteType extends Enum<NoteType> implements WireEnum {
        private static final /* synthetic */ NoteType[] $VALUES = null;
        public static final ProtoAdapter<NoteType> ADAPTER = null;
        public static final NoteType FISH_BONE_CHART = null;
        public static final NoteType FISH_BONE_TEXT = null;
        public static final NoteType HARDWARE_MARK = null;
        public static final NoteType HARDWARE_MARK_OFFLINE = null;
        public static final NoteType REGULAR = null;
        public static final NoteType SOFTWARE_MARK = null;
        public static final NoteType SUBTITLE = null;
        private final int value;

        static {
            NoteType r0 = new NoteType("REGULAR", 0, 0);
            REGULAR = r0;
            NoteType r1 = new NoteType("SOFTWARE_MARK", 1, 1);
            SOFTWARE_MARK = r1;
            NoteType r3 = new NoteType("HARDWARE_MARK", 2, 2);
            HARDWARE_MARK = r3;
            NoteType r5 = new NoteType("SUBTITLE", 3, 3);
            SUBTITLE = r5;
            NoteType r7 = new NoteType("FISH_BONE_TEXT", 4, 4);
            FISH_BONE_TEXT = r7;
            NoteType r9 = new NoteType("FISH_BONE_CHART", 5, 5);
            FISH_BONE_CHART = r9;
            NoteType r11 = new NoteType("HARDWARE_MARK_OFFLINE", 6, 6);
            HARDWARE_MARK_OFFLINE = r11;
            $VALUES = new NoteType[]{r0, r1, r3, r5, r7, r9, r11};
            ADAPTER = ProtoAdapter.newEnumAdapter(NoteType.class);
        }

        public static NoteType[] values() {
            return (NoteType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NoteType fromValue(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return HARDWARE_MARK_OFFLINE;
        L8:
            return FISH_BONE_CHART;
        L10:
            return FISH_BONE_TEXT;
        L12:
            return SUBTITLE;
        L14:
            return HARDWARE_MARK;
        L16:
            return SOFTWARE_MARK;
        L18:
            return REGULAR;
        }

        public static NoteType valueOf(String r1) {
            return (NoteType) a.a(NoteType.class, r1);
        }

        private NoteType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum PolishContentState extends Enum<PolishContentState> implements WireEnum {
        private static final /* synthetic */ PolishContentState[] $VALUES = null;
        public static final ProtoAdapter<PolishContentState> ADAPTER = null;
        public static final PolishContentState EDITING = null;
        public static final PolishContentState FINISH = null;
        public static final PolishContentState NEED = null;
        public static final PolishContentState NO_NEED = null;
        public static final PolishContentState REVERTED = null;
        public static final PolishContentState USE = null;
        private final int value;

        static {
            PolishContentState r0 = new PolishContentState("NEED", 0, 0);
            NEED = r0;
            PolishContentState r1 = new PolishContentState("NO_NEED", 1, 1);
            NO_NEED = r1;
            PolishContentState r3 = new PolishContentState("FINISH", 2, 2);
            FINISH = r3;
            PolishContentState r5 = new PolishContentState("REVERTED", 3, 3);
            REVERTED = r5;
            PolishContentState r7 = new PolishContentState("USE", 4, 4);
            USE = r7;
            PolishContentState r9 = new PolishContentState("EDITING", 5, 5);
            EDITING = r9;
            $VALUES = new PolishContentState[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(PolishContentState.class);
        }

        public static PolishContentState[] values() {
            return (PolishContentState[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PolishContentState fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return EDITING;
        L18:
            return USE;
        L20:
            return REVERTED;
        L22:
            return FINISH;
        L24:
            return NO_NEED;
        L26:
            return NEED;
        }

        public static PolishContentState valueOf(String r1) {
            return (PolishContentState) a.a(PolishContentState.class, r1);
        }

        private PolishContentState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_NotesBlock extends ProtoAdapter<NotesBlock> {
        public ProtoAdapter_NotesBlock() {
            super(FieldEncoding.LENGTH_DELIMITED, NotesBlock.class);
        }

        public NotesBlock decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcid = 0L;
            r0.msid = 0L;
            r0.mclient_create_time = 0L;
            r0.mservice_time = 0L;
            r0.mversion = 0L;
            Boolean r2 = Boolean.FALSE;
            r0.mpolish_enabled = r2;
            r0.mdeleted = r2;
            r0.mcreate_rel_meeting_time = 0L;
            r0.mcreate_rel_audio_time = 0L;
            r0.minput_content_markdown = "";
            r0.mai_content_markdown = "";
            r0.maudio_location_time = 0L;
            r0.mmark_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L37;
            switch(r3) {
                case 1: goto L36;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L33;
                case 5: goto L32;
                case 6: goto L31;
                case 7: goto L41;
                case 8: goto L26;
                case 9: goto L25;
                case 10: goto L24;
                case 11: goto L23;
                case 12: goto L43;
                case 13: goto L18;
                case 14: goto L17;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L14;
                case 18: goto L13;
                case 19: goto L12;
                case 20: goto L39;
                case 21: goto L7;
                default: goto L6;
            };
        L39:
            r0.mcreate_source = (CreateSource) CreateSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r0.mnote_type = (NoteType) NoteType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r0.mcontent_state = (PolishContentState) PolishContentState.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mimages_v2 = (ImageInfo) ImageInfo.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.mfull_images.add((ImageSetV2) ImageSetV2.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mmark_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.maudio_location_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mai_content_markdown = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.minput_content_markdown = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mcreate_rel_audio_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L18:
            r0.mcreate_rel_meeting_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L23:
            r0.mimages.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L24:
            r0.mdeleted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L25:
            r0.mpolish_enabled = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L26:
            r0.mversion = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L31:
            r0.mai_content = (RichText) RichText.ADAPTER.decode(r9);
            goto L3
        L32:
            r0.mservice_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L33:
            r0.mclient_create_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L34:
            r0.msid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L35:
            r0.mcid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L36:
            r0.minput_content = (RichText) RichText.ADAPTER.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L37:
            r9.endMessage(r1);
            return r0.m3299build();
        }

        public int encodedSize(NotesBlock r7) {
            RichText r0 = r7.minput_content;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = RichText.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r7.mcid;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r6 = r7.msid;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            Long r10 = r7.mclient_create_time;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Long r13 = r7.mservice_time;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            RichText r16 = r7.mai_content;
            if (r16 == null) goto L25;
            int r17 = RichText.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            NoteType r19 = r7.mnote_type;
            if (r19 == null) goto L29;
            int r20 = NoteType.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Long r22 = r7.mversion;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.INT64.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Boolean r25 = r7.mpolish_enabled;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            Boolean r28 = r7.mdeleted;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            ProtoAdapter r31 = ProtoAdapter.STRING;
            int r32 = r30 + r31.asRepeated().encodedSizeWithTag(11, r7.mimages);
            PolishContentState r33 = r7.mcontent_state;
            if (r33 == null) goto L45;
            int r34 = PolishContentState.ADAPTER.encodedSizeWithTag(12, r33);
        L46:
            int r35 = r32 + r34;
            Long r36 = r7.mcreate_rel_meeting_time;
            if (r36 == null) goto L49;
            int r37 = ProtoAdapter.INT64.encodedSizeWithTag(13, r36);
        L50:
            int r38 = r35 + r37;
            Long r39 = r7.mcreate_rel_audio_time;
            if (r39 == null) goto L53;
            int r40 = ProtoAdapter.INT64.encodedSizeWithTag(14, r39);
        L54:
            int r41 = r38 + r40;
            String r42 = r7.minput_content_markdown;
            if (r42 == null) goto L57;
            int r43 = r31.encodedSizeWithTag(15, r42);
        L58:
            int r44 = r41 + r43;
            String r45 = r7.mai_content_markdown;
            if (r45 == null) goto L61;
            int r46 = r31.encodedSizeWithTag(16, r45);
        L62:
            int r47 = r44 + r46;
            Long r48 = r7.maudio_location_time;
            if (r48 == null) goto L65;
            int r49 = ProtoAdapter.INT64.encodedSizeWithTag(17, r48);
        L66:
            int r50 = r47 + r49;
            String r51 = r7.mmark_id;
            if (r51 == null) goto L69;
            int r52 = r31.encodedSizeWithTag(18, r51);
        L70:
            int r53 = (r50 + r52) + ImageSetV2.ADAPTER.asRepeated().encodedSizeWithTag(19, r7.mfull_images);
            CreateSource r54 = r7.mcreate_source;
            if (r54 == null) goto L73;
            int r55 = CreateSource.ADAPTER.encodedSizeWithTag(20, r54);
        L74:
            int r56 = r53 + r55;
            ImageInfo r57 = r7.mimages_v2;
            if (r57 == null) goto L78;
            r1 = ImageInfo.ADAPTER.encodedSizeWithTag(21, r57);
        L78:
            return (r56 + r1) + r7.unknownFields().size();
        L73:
            r55 = 0;
            goto L74
        L69:
            r52 = 0;
            goto L70
        L65:
            r49 = 0;
            goto L66
        L61:
            r46 = 0;
            goto L62
        L57:
            r43 = 0;
            goto L58
        L53:
            r40 = 0;
            goto L54
        L49:
            r37 = 0;
            goto L50
        L45:
            r34 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Object m3303decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NotesBlock) r1);
        }

        public void encode(ProtoWriter r5, NotesBlock r6) throws IOException {
            RichText r0 = r6.minput_content;
            if (r0 == null) goto L5;
            RichText.ADAPTER.encodeWithTag(r5, 1, r0);
        L5:
            Long r1 = r6.mcid;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r5, 2, r1);
        L8:
            Long r2 = r6.msid;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L11:
            Long r3 = r6.mclient_create_time;
            if (r3 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r5, 4, r3);
        L14:
            Long r4 = r6.mservice_time;
            if (r4 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r5, 5, r4);
        L17:
            RichText r7 = r6.mai_content;
            if (r7 == null) goto L20;
            RichText.ADAPTER.encodeWithTag(r5, 6, r7);
        L20:
            NoteType r8 = r6.mnote_type;
            if (r8 == null) goto L23;
            NoteType.ADAPTER.encodeWithTag(r5, 7, r8);
        L23:
            Long r9 = r6.mversion;
            if (r9 == null) goto L26;
            ProtoAdapter.INT64.encodeWithTag(r5, 8, r9);
        L26:
            Boolean r10 = r6.mpolish_enabled;
            if (r10 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L29:
            Boolean r11 = r6.mdeleted;
            if (r11 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r5, 10, r11);
        L32:
            ProtoAdapter r12 = ProtoAdapter.STRING;
            r12.asRepeated().encodeWithTag(r5, 11, r6.mimages);
            PolishContentState r13 = r6.mcontent_state;
            if (r13 == null) goto L35;
            PolishContentState.ADAPTER.encodeWithTag(r5, 12, r13);
        L35:
            Long r14 = r6.mcreate_rel_meeting_time;
            if (r14 == null) goto L38;
            ProtoAdapter.INT64.encodeWithTag(r5, 13, r14);
        L38:
            Long r15 = r6.mcreate_rel_audio_time;
            if (r15 == null) goto L41;
            ProtoAdapter.INT64.encodeWithTag(r5, 14, r15);
        L41:
            String r16 = r6.minput_content_markdown;
            if (r16 == null) goto L44;
            r12.encodeWithTag(r5, 15, r16);
        L44:
            String r17 = r6.mai_content_markdown;
            if (r17 == null) goto L47;
            r12.encodeWithTag(r5, 16, r17);
        L47:
            Long r18 = r6.maudio_location_time;
            if (r18 == null) goto L50;
            ProtoAdapter.INT64.encodeWithTag(r5, 17, r18);
        L50:
            String r19 = r6.mmark_id;
            if (r19 == null) goto L53;
            r12.encodeWithTag(r5, 18, r19);
        L53:
            ImageSetV2.ADAPTER.asRepeated().encodeWithTag(r5, 19, r6.mfull_images);
            CreateSource r20 = r6.mcreate_source;
            if (r20 == null) goto L56;
            CreateSource.ADAPTER.encodeWithTag(r5, 20, r20);
        L56:
            ImageInfo r21 = r6.mimages_v2;
            if (r21 == null) goto L59;
            ImageInfo.ADAPTER.encodeWithTag(r5, 21, r21);
        L59:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NotesBlock) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotesBlock();
        DEFAULT_CID = 0L;
        DEFAULT_SID = 0L;
        DEFAULT_CLIENT_CREATE_TIME = 0L;
        DEFAULT_SERVICE_TIME = 0L;
        DEFAULT_VERSION = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_POLISH_ENABLED = r1;
        DEFAULT_DELETED = r1;
        DEFAULT_CREATE_REL_MEETING_TIME = 0L;
        DEFAULT_CREATE_REL_AUDIO_TIME = 0L;
        DEFAULT_AUDIO_LOCATION_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3298newBuilder() {
        Builder r0 = new Builder();
        r0.minput_content = this.minput_content;
        r0.mcid = this.mcid;
        r0.msid = this.msid;
        r0.mclient_create_time = this.mclient_create_time;
        r0.mservice_time = this.mservice_time;
        r0.mai_content = this.mai_content;
        r0.mnote_type = this.mnote_type;
        r0.mversion = this.mversion;
        r0.mpolish_enabled = this.mpolish_enabled;
        r0.mdeleted = this.mdeleted;
        r0.mimages = Internal.copyOf("mimages", this.mimages);
        r0.mcontent_state = this.mcontent_state;
        r0.mcreate_rel_meeting_time = this.mcreate_rel_meeting_time;
        r0.mcreate_rel_audio_time = this.mcreate_rel_audio_time;
        r0.minput_content_markdown = this.minput_content_markdown;
        r0.mai_content_markdown = this.mai_content_markdown;
        r0.maudio_location_time = this.maudio_location_time;
        r0.mmark_id = this.mmark_id;
        r0.mfull_images = Internal.copyOf("mfull_images", this.mfull_images);
        r0.mcreate_source = this.mcreate_source;
        r0.mimages_v2 = this.mimages_v2;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return NotesBlock.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3298newBuilder();
    }

    public NotesBlock(RichText r24, Long r25, Long r26, Long r27, Long r28, RichText r29, NoteType r30, Long r31, Boolean r32, Boolean r33, List<String> r34, PolishContentState r35, Long r36, Long r37, String r38, String r39, Long r40, String r41, List<ImageSetV2> r42, CreateSource r43, ImageInfo r44) {
        this(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, ByteString.EMPTY);
    }

    public NotesBlock(RichText r4, Long r5, Long r6, Long r7, Long r8, RichText r9, NoteType r10, Long r11, Boolean r12, Boolean r13, List<String> r14, PolishContentState r15, Long r16, Long r17, String r18, String r19, Long r20, String r21, List<ImageSetV2> r22, CreateSource r23, ImageInfo r24, ByteString r25) {
        super(ADAPTER, r25);
        this.minput_content = r4;
        this.mcid = r5;
        this.msid = r6;
        this.mclient_create_time = r7;
        this.mservice_time = r8;
        this.mai_content = r9;
        this.mnote_type = r10;
        this.mversion = r11;
        this.mpolish_enabled = r12;
        this.mdeleted = r13;
        this.mimages = Internal.immutableCopyOf("mimages", r14);
        this.mcontent_state = r15;
        this.mcreate_rel_meeting_time = r16;
        this.mcreate_rel_audio_time = r17;
        this.minput_content_markdown = r18;
        this.mai_content_markdown = r19;
        this.maudio_location_time = r20;
        this.mmark_id = r21;
        this.mfull_images = Internal.immutableCopyOf("mfull_images", r22);
        this.mcreate_source = r23;
        this.mimages_v2 = r24;
    }
}
