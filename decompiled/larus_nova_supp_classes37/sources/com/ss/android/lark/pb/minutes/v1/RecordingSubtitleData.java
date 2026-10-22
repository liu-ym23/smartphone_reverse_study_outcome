package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RecordingSubtitleData extends Message<RecordingSubtitleData, Builder> {
    public static final ProtoAdapter<RecordingSubtitleData> ADAPTER = null;
    public static final Long DEFAULT_ABSOLUTE_TIMESTAMP = null;
    public static final Boolean DEFAULT_DELETE_SEGMENT = null;
    public static final Long DEFAULT_FIRST_WORD_START_TIME = null;
    public static final Boolean DEFAULT_IS_PARTIAL = null;
    public static final Boolean DEFAULT_IS_SEG_FINAL = null;
    public static final Long DEFAULT_SEG_ID = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final Boolean DEFAULT_SHOW_EDIT_SPEAKER_BUTTON = null;
    public static final Long DEFAULT_SLICE_ID = null;
    public static final SoundType DEFAULT_SOUND_TYPE = null;
    public static final Long DEFAULT_TIMESTAMP = null;
    public static final Boolean DEFAULT_TRACK_RECEIVED = null;
    public static final ProtoAdapter_RecordingSubtitleData RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long absolute_timestamp;
    public final Boolean delete_segment;
    public final Long first_word_start_time;
    public final Boolean is_partial;
    public final Boolean is_seg_final;
    public final Long seg_id;
    public final String session_id;
    public final Boolean show_edit_speaker_button;
    public final Long slice_id;
    public final SoundType sound_type;
    public final Subtitle source;
    public final SSDSpeaker ssd_speaker;
    public final Subtitle target;
    public final Long timestamp;
    public final Boolean track_received;

    public static final class Builder extends Message.Builder<RecordingSubtitleData, Builder> implements d<RecordingSubtitleData> {
        public Long absolute_timestamp;
        public Boolean delete_segment;
        public Long first_word_start_time;
        public Boolean is_partial;
        public Boolean is_seg_final;
        public Long seg_id;
        public String session_id;
        public Boolean show_edit_speaker_button;
        public Long slice_id;
        public SoundType sound_type;
        public Subtitle source;
        public SSDSpeaker ssd_speaker;
        public Subtitle target;
        public Long timestamp;
        public Boolean track_received;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RecordingSubtitleData m1898build() {
            String r1 = this.session_id;
            if (r1 == null) goto L9;
            if (this.seg_id == null) goto L9;
            return new RecordingSubtitleData(this.session_id, this.seg_id, this.source, this.target, this.timestamp, this.slice_id, this.is_seg_final, this.track_received, this.sound_type, this.is_partial, this.absolute_timestamp, this.ssd_speaker, this.first_word_start_time, this.show_edit_speaker_button, this.delete_segment, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r1, "session_id", this.seg_id, "seg_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1898build();
        }

        public Builder absolute_timestamp(Long r1) {
            this.absolute_timestamp = r1;
            return this;
        }

        public Builder delete_segment(Boolean r1) {
            this.delete_segment = r1;
            return this;
        }

        public Builder first_word_start_time(Long r1) {
            this.first_word_start_time = r1;
            return this;
        }

        public Builder is_partial(Boolean r1) {
            this.is_partial = r1;
            return this;
        }

        public Builder is_seg_final(Boolean r1) {
            this.is_seg_final = r1;
            return this;
        }

        public Builder seg_id(Long r1) {
            this.seg_id = r1;
            return this;
        }

        public Builder session_id(String r1) {
            this.session_id = r1;
            return this;
        }

        public Builder show_edit_speaker_button(Boolean r1) {
            this.show_edit_speaker_button = r1;
            return this;
        }

        public Builder slice_id(Long r1) {
            this.slice_id = r1;
            return this;
        }

        public Builder sound_type(SoundType r1) {
            this.sound_type = r1;
            return this;
        }

        public Builder source(Subtitle r1) {
            this.source = r1;
            return this;
        }

        public Builder ssd_speaker(SSDSpeaker r1) {
            this.ssd_speaker = r1;
            return this;
        }

        public Builder target(Subtitle r1) {
            this.target = r1;
            return this;
        }

        public Builder timestamp(Long r1) {
            this.timestamp = r1;
            return this;
        }

        public Builder track_received(Boolean r1) {
            this.track_received = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RecordingSubtitleData extends ProtoAdapter<RecordingSubtitleData> implements c<RecordingSubtitleData> {
        public ProtoAdapter_RecordingSubtitleData() {
            super(FieldEncoding.LENGTH_DELIMITED, RecordingSubtitleData.class);
        }

        public RecordingSubtitleData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            r0.seg_id = 0L;
            r0.timestamp = 0L;
            r0.slice_id = 0L;
            Boolean r2 = Boolean.FALSE;
            r0.is_seg_final = r2;
            r0.track_received = r2;
            r0.sound_type = SoundType.NORMAL;
            r0.is_partial = r2;
            r0.absolute_timestamp = 0L;
            r0.first_word_start_time = 0L;
            r0.show_edit_speaker_button = r2;
            r0.delete_segment = r2;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L43;
            if (r3 != 1) goto L8;
            r0.session_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.seg_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 12) goto L12;
            r0.sound_type = (SoundType) SoundType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L39
        L39:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 13) goto L14;
            r0.is_partial = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            if (r3 != 16) goto L16;
            r0.absolute_timestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L16:
            if (r3 != 17) goto L18;
            r0.ssd_speaker = (SSDSpeaker) SSDSpeaker.ADAPTER.decode(r9);
            goto L3
        L18:
            if (r3 != 23) goto L20;
            r0.first_word_start_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L20:
            if (r3 != 24) goto L22;
            r0.show_edit_speaker_button = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L22:
            if (r3 != 26) goto L23;
            r0.delete_segment = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L23:
            switch(r3) {
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L28;
                case 7: goto L27;
                case 8: goto L26;
                case 9: goto L25;
                default: goto L24;
            };
        L25:
            r0.track_received = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L26:
            r0.is_seg_final = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L27:
            r0.slice_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L28:
            r0.timestamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L29:
            r0.target = (Subtitle) Subtitle.ADAPTER.decode(r9);
            goto L3
        L30:
            r0.source = (Subtitle) Subtitle.ADAPTER.decode(r9);
            goto L3
        L24:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L43:
            r9.endMessage(r1);
            return r0.m1898build();
        }

        public int encodedSize(RecordingSubtitleData r7) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r7.session_id);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            int r2 = r0 + r1.encodedSizeWithTag(2, r7.seg_id);
            Subtitle r3 = r7.source;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = Subtitle.ADAPTER.encodedSizeWithTag(4, r3);
        L6:
            int r6 = r2 + r5;
            Subtitle r8 = r7.target;
            if (r8 == null) goto L9;
            int r9 = Subtitle.ADAPTER.encodedSizeWithTag(5, r8);
        L10:
            int r10 = r6 + r9;
            Long r11 = r7.timestamp;
            if (r11 == null) goto L13;
            int r12 = r1.encodedSizeWithTag(6, r11);
        L14:
            int r13 = r10 + r12;
            Long r14 = r7.slice_id;
            if (r14 == null) goto L17;
            int r15 = r1.encodedSizeWithTag(7, r14);
        L18:
            int r16 = r13 + r15;
            Boolean r17 = r7.is_seg_final;
            if (r17 == null) goto L21;
            int r18 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r17);
        L22:
            int r19 = r16 + r18;
            Boolean r20 = r7.track_received;
            if (r20 == null) goto L25;
            int r21 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r20);
        L26:
            int r22 = r19 + r21;
            SoundType r23 = r7.sound_type;
            if (r23 == null) goto L29;
            int r24 = SoundType.ADAPTER.encodedSizeWithTag(12, r23);
        L30:
            int r25 = r22 + r24;
            Boolean r26 = r7.is_partial;
            if (r26 == null) goto L33;
            int r27 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r26);
        L34:
            int r28 = r25 + r27;
            Long r29 = r7.absolute_timestamp;
            if (r29 == null) goto L37;
            int r30 = r1.encodedSizeWithTag(16, r29);
        L38:
            int r31 = r28 + r30;
            SSDSpeaker r32 = r7.ssd_speaker;
            if (r32 == null) goto L41;
            int r33 = SSDSpeaker.ADAPTER.encodedSizeWithTag(17, r32);
        L42:
            int r34 = r31 + r33;
            Long r35 = r7.first_word_start_time;
            if (r35 == null) goto L45;
            int r36 = r1.encodedSizeWithTag(23, r35);
        L46:
            int r37 = r34 + r36;
            Boolean r38 = r7.show_edit_speaker_button;
            if (r38 == null) goto L49;
            int r39 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r38);
        L50:
            int r40 = r37 + r39;
            Boolean r41 = r7.delete_segment;
            if (r41 == null) goto L54;
            r4 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r41);
        L54:
            return (r40 + r4) + r7.unknownFields().size();
        L49:
            r39 = 0;
            goto L50
        L45:
            r36 = 0;
            goto L46
        L41:
            r33 = 0;
            goto L42
        L37:
            r30 = 0;
            goto L38
        L33:
            r27 = 0;
            goto L34
        L29:
            r24 = 0;
            goto L30
        L25:
            r21 = 0;
            goto L26
        L21:
            r18 = 0;
            goto L22
        L17:
            r15 = 0;
            goto L18
        L13:
            r12 = 0;
            goto L14
        L9:
            r9 = 0;
            goto L10
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1899decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RecordingSubtitleData) r1);
        }

        public void encode(ProtoWriter r5, RecordingSubtitleData r6) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r6.session_id);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 2, r6.seg_id);
            Subtitle r1 = r6.source;
            if (r1 == null) goto L5;
            Subtitle.ADAPTER.encodeWithTag(r5, 4, r1);
        L5:
            Subtitle r2 = r6.target;
            if (r2 == null) goto L8;
            Subtitle.ADAPTER.encodeWithTag(r5, 5, r2);
        L8:
            Long r3 = r6.timestamp;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 6, r3);
        L11:
            Long r4 = r6.slice_id;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 7, r4);
        L14:
            Boolean r7 = r6.is_seg_final;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 8, r7);
        L17:
            Boolean r8 = r6.track_received;
            if (r8 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r8);
        L20:
            SoundType r9 = r6.sound_type;
            if (r9 == null) goto L23;
            SoundType.ADAPTER.encodeWithTag(r5, 12, r9);
        L23:
            Boolean r10 = r6.is_partial;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 13, r10);
        L26:
            Long r11 = r6.absolute_timestamp;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 16, r11);
        L29:
            SSDSpeaker r12 = r6.ssd_speaker;
            if (r12 == null) goto L32;
            SSDSpeaker.ADAPTER.encodeWithTag(r5, 17, r12);
        L32:
            Long r13 = r6.first_word_start_time;
            if (r13 == null) goto L35;
            r0.encodeWithTag(r5, 23, r13);
        L35:
            Boolean r14 = r6.show_edit_speaker_button;
            if (r14 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r5, 24, r14);
        L38:
            Boolean r15 = r6.delete_segment;
            if (r15 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 26, r15);
        L41:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RecordingSubtitleData) r2);
        }
    }

    public static final class SSDSpeaker extends Message<SSDSpeaker, Builder> {
        public static final ProtoAdapter<SSDSpeaker> ADAPTER = null;
        public static final String DEFAULT_SPEAKER_INFO_SOURCE = "";
        public static final String DEFAULT_SPEAKER_USER_ID = "";
        public static final String DEFAULT_USER_ID = "";
        public static final SSDSpeakerUserType DEFAULT_USER_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String speaker_info_source;
        public final String speaker_user_id;
        public final String user_id;
        public final SSDSpeakerUserType user_type;

        public static final class Builder extends Message.Builder<SSDSpeaker, Builder> {
            public String speaker_info_source;
            public String speaker_user_id;
            public String user_id;
            public SSDSpeakerUserType user_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SSDSpeaker m1901build() {
                return new SSDSpeaker(this.speaker_user_id, this.user_id, this.user_type, this.speaker_info_source, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1901build();
            }

            public Builder speaker_info_source(String r1) {
                this.speaker_info_source = r1;
                return this;
            }

            public Builder speaker_user_id(String r1) {
                this.speaker_user_id = r1;
                return this;
            }

            public Builder user_id(String r1) {
                this.user_id = r1;
                return this;
            }

            public Builder user_type(SSDSpeakerUserType r1) {
                this.user_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SSDSpeaker extends ProtoAdapter<SSDSpeaker> {
            public ProtoAdapter_SSDSpeaker() {
                super(FieldEncoding.LENGTH_DELIMITED, SSDSpeaker.class);
            }

            public SSDSpeaker decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.speaker_user_id = "";
                r0.user_id = "";
                r0.user_type = SSDSpeakerUserType.UNKNOWN;
                r0.speaker_info_source = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.speaker_user_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 3) goto L10;
                r0.user_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 4) goto L12;
                r0.user_type = (SSDSpeakerUserType) SSDSpeakerUserType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 5) goto L13;
                r0.speaker_info_source = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1901build();
            }

            public int encodedSize(SSDSpeaker r6) {
                String r0 = r6.speaker_user_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.user_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(3, r3);
            L10:
                int r5 = r2 + r4;
                SSDSpeakerUserType r7 = r6.user_type;
                if (r7 == null) goto L13;
                int r8 = SSDSpeakerUserType.ADAPTER.encodedSizeWithTag(4, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.speaker_info_source;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1902decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SSDSpeaker) r1);
            }

            public void encode(ProtoWriter r4, SSDSpeaker r5) throws IOException {
                String r0 = r5.speaker_user_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.user_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
            L8:
                SSDSpeakerUserType r2 = r5.user_type;
                if (r2 == null) goto L11;
                SSDSpeakerUserType.ADAPTER.encodeWithTag(r4, 4, r2);
            L11:
                String r3 = r5.speaker_info_source;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SSDSpeaker) r2);
            }
        }

        public static final enum SSDSpeakerUserType extends Enum<SSDSpeakerUserType> implements WireEnum {
            private static final /* synthetic */ SSDSpeakerUserType[] $VALUES = null;
            public static final ProtoAdapter<SSDSpeakerUserType> ADAPTER = null;
            public static final SSDSpeakerUserType LARK_USER = null;
            public static final SSDSpeakerUserType UNKNOWN = null;
            private final int value;

            static {
                SSDSpeakerUserType r0 = new SSDSpeakerUserType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                SSDSpeakerUserType r1 = new SSDSpeakerUserType("LARK_USER", 1, 1);
                LARK_USER = r1;
                $VALUES = new SSDSpeakerUserType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(SSDSpeakerUserType.class);
            }

            public static SSDSpeakerUserType[] values() {
                return (SSDSpeakerUserType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static SSDSpeakerUserType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return LARK_USER;
            L10:
                return UNKNOWN;
            }

            public static SSDSpeakerUserType valueOf(String r1) {
                return (SSDSpeakerUserType) a.a(SSDSpeakerUserType.class, r1);
            }

            private SSDSpeakerUserType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SSDSpeaker();
            DEFAULT_USER_TYPE = SSDSpeakerUserType.UNKNOWN;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1900newBuilder() {
            Builder r0 = new Builder();
            r0.speaker_user_id = this.speaker_user_id;
            r0.user_id = this.user_id;
            r0.user_type = this.user_type;
            r0.speaker_info_source = this.speaker_info_source;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SSDSpeaker.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1900newBuilder();
        }

        public SSDSpeaker(String r7, String r8, SSDSpeakerUserType r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public SSDSpeaker(String r2, String r3, SSDSpeakerUserType r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.speaker_user_id = r2;
            this.user_id = r3;
            this.user_type = r4;
            this.speaker_info_source = r5;
        }
    }

    public static final enum SoundType extends Enum<SoundType> implements WireEnum {
        private static final /* synthetic */ SoundType[] $VALUES = null;
        public static final ProtoAdapter<SoundType> ADAPTER = null;
        public static final SoundType NOISE = null;
        public static final SoundType NORMAL = null;
        private final int value;

        static {
            SoundType r0 = new SoundType("NORMAL", 0, 1);
            NORMAL = r0;
            SoundType r1 = new SoundType("NOISE", 1, 2);
            NOISE = r1;
            $VALUES = new SoundType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(SoundType.class);
        }

        public static SoundType[] values() {
            return (SoundType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SoundType fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return NOISE;
        L11:
            return NORMAL;
        }

        public static SoundType valueOf(String r1) {
            return (SoundType) a.a(SoundType.class, r1);
        }

        private SoundType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Subtitle extends Message<Subtitle, Builder> {
        public static final ProtoAdapter<Subtitle> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_LANGUAGE = "";
        public static final Boolean DEFAULT_TRACK_ARRIVAL = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final String language;
        public final Punctuation punctuation;
        public final ByteviewUser speaker;
        public final Boolean track_arrival;

        public static final class Builder extends Message.Builder<Subtitle, Builder> {
            public String content;
            public String language;
            public Punctuation punctuation;
            public ByteviewUser speaker;
            public Boolean track_arrival;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Subtitle m1904build() {
                String r0 = this.content;
                if (r0 == null) goto L9;
                if (this.language == null) goto L9;
                return new Subtitle(this.content, this.language, this.speaker, this.punctuation, this.track_arrival, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "content", this.language, "language"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1904build();
            }

            public Builder content(String r1) {
                this.content = r1;
                return this;
            }

            public Builder language(String r1) {
                this.language = r1;
                return this;
            }

            public Builder punctuation(Punctuation r1) {
                this.punctuation = r1;
                return this;
            }

            public Builder speaker(ByteviewUser r1) {
                this.speaker = r1;
                return this;
            }

            public Builder track_arrival(Boolean r1) {
                this.track_arrival = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Subtitle extends ProtoAdapter<Subtitle> {
            public ProtoAdapter_Subtitle() {
                super(FieldEncoding.LENGTH_DELIMITED, Subtitle.class);
            }

            public Subtitle decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.content = "";
                r0.language = "";
                r0.track_arrival = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.content = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.language = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 5) goto L12;
                r0.speaker = (ByteviewUser) ByteviewUser.ADAPTER.decode(r7);
                goto L3
            L12:
                if (r3 != 8) goto L14;
                r0.punctuation = (Punctuation) Punctuation.ADAPTER.decode(r7);
                goto L3
            L14:
                if (r3 != 11) goto L15;
                r0.track_arrival = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m1904build();
            }

            public int encodedSize(Subtitle r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r6.content) + r0.encodedSizeWithTag(2, r6.language);
                ByteviewUser r2 = r6.speaker;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = ByteviewUser.ADAPTER.encodedSizeWithTag(5, r2);
            L6:
                int r5 = r1 + r4;
                Punctuation r7 = r6.punctuation;
                if (r7 == null) goto L9;
                int r8 = Punctuation.ADAPTER.encodedSizeWithTag(8, r7);
            L10:
                int r9 = r5 + r8;
                Boolean r10 = r6.track_arrival;
                if (r10 == null) goto L14;
                r3 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r10);
            L14:
                return (r9 + r3) + r6.unknownFields().size();
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1905decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Subtitle) r1);
            }

            public void encode(ProtoWriter r4, Subtitle r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.content);
                r0.encodeWithTag(r4, 2, r5.language);
                ByteviewUser r1 = r5.speaker;
                if (r1 == null) goto L5;
                ByteviewUser.ADAPTER.encodeWithTag(r4, 5, r1);
            L5:
                Punctuation r2 = r5.punctuation;
                if (r2 == null) goto L8;
                Punctuation.ADAPTER.encodeWithTag(r4, 8, r2);
            L8:
                Boolean r3 = r5.track_arrival;
                if (r3 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 11, r3);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Subtitle) r2);
            }
        }

        public static final class Punctuation extends Message<Punctuation, Builder> {
            public static final ProtoAdapter<Punctuation> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<Long> word_ends;

            public static final class Builder extends Message.Builder<Punctuation, Builder> {
                public List<Long> word_ends;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Punctuation m1907build() {
                    return new Punctuation(this.word_ends, super.buildUnknownFields());
                }

                public Builder() {
                    this.word_ends = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m1907build();
                }

                public Builder word_ends(List<Long> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.word_ends = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Punctuation extends ProtoAdapter<Punctuation> {
                public ProtoAdapter_Punctuation() {
                    super(FieldEncoding.LENGTH_DELIMITED, Punctuation.class);
                }

                public Punctuation decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L9;
                    if (r3 != 2) goto L7;
                    r0.word_ends.add((Long) ProtoAdapter.INT64.decode(r7));
                    goto L3
                L7:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L9:
                    r7.endMessage(r1);
                    return r0.m1907build();
                }

                public int encodedSize(Punctuation r4) {
                    return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r4.word_ends) + r4.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1908decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Punctuation) r1);
                }

                public void encode(ProtoWriter r4, Punctuation r5) throws IOException {
                    ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 2, r5.word_ends);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Punctuation) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Punctuation();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m1906newBuilder() {
                Builder r0 = new Builder();
                r0.word_ends = Internal.copyOf("word_ends", this.word_ends);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Punctuation.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m1906newBuilder();
            }

            public Punctuation(List<Long> r2) {
                this(r2, ByteString.EMPTY);
            }

            public Punctuation(List<Long> r2, ByteString r3) {
                super(ADAPTER, r3);
                this.word_ends = Internal.immutableCopyOf("word_ends", r2);
            }
        }

        public static final class SubtitleLanguage extends Message<SubtitleLanguage, Builder> {
            public static final ProtoAdapter<SubtitleLanguage> ADAPTER = null;
            public static final String DEFAULT_DESCRIPTION_KEY = "";
            public static final String DEFAULT_LANGUAGE = "";
            private static final long serialVersionUID = 0;
            public final String description_key;
            public final String language;

            public static final class Builder extends Message.Builder<SubtitleLanguage, Builder> {
                public String description_key;
                public String language;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public SubtitleLanguage m1910build() {
                    String r0 = this.language;
                    if (r0 == null) goto L9;
                    if (this.description_key == null) goto L9;
                    return new SubtitleLanguage(this.language, this.description_key, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r0, "language", this.description_key, "description_key"});
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m1910build();
                }

                public Builder description_key(String r1) {
                    this.description_key = r1;
                    return this;
                }

                public Builder language(String r1) {
                    this.language = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_SubtitleLanguage extends ProtoAdapter<SubtitleLanguage> {
                public ProtoAdapter_SubtitleLanguage() {
                    super(FieldEncoding.LENGTH_DELIMITED, SubtitleLanguage.class);
                }

                public SubtitleLanguage decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.language = "";
                    r0.description_key = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.language = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.description_key = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m1910build();
                }

                public int encodedSize(SubtitleLanguage r5) {
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    return (r0.encodedSizeWithTag(1, r5.language) + r0.encodedSizeWithTag(2, r5.description_key)) + r5.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1911decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((SubtitleLanguage) r1);
                }

                public void encode(ProtoWriter r4, SubtitleLanguage r5) throws IOException {
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    r0.encodeWithTag(r4, 1, r5.language);
                    r0.encodeWithTag(r4, 2, r5.description_key);
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
            public Builder m1909newBuilder() {
                Builder r0 = new Builder();
                r0.language = this.language;
                r0.description_key = this.description_key;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return SubtitleLanguage.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m1909newBuilder();
            }

            public SubtitleLanguage(String r2, String r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public SubtitleLanguage(String r2, String r3, ByteString r4) {
                super(ADAPTER, r4);
                this.language = r2;
                this.description_key = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Subtitle();
            DEFAULT_TRACK_ARRIVAL = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1903newBuilder() {
            Builder r0 = new Builder();
            r0.content = this.content;
            r0.language = this.language;
            r0.speaker = this.speaker;
            r0.punctuation = this.punctuation;
            r0.track_arrival = this.track_arrival;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Subtitle.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1903newBuilder();
        }

        public Subtitle(String r8, String r9, ByteviewUser r10, Punctuation r11, Boolean r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public Subtitle(String r2, String r3, ByteviewUser r4, Punctuation r5, Boolean r6, ByteString r7) {
            super(ADAPTER, r7);
            this.content = r2;
            this.language = r3;
            this.speaker = r4;
            this.punctuation = r5;
            this.track_arrival = r6;
        }
    }

    static {
        ProtoAdapter_RecordingSubtitleData r0 = new ProtoAdapter_RecordingSubtitleData();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_SEG_ID = 0L;
        DEFAULT_TIMESTAMP = 0L;
        DEFAULT_SLICE_ID = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_IS_SEG_FINAL = r1;
        DEFAULT_TRACK_RECEIVED = r1;
        DEFAULT_SOUND_TYPE = SoundType.NORMAL;
        DEFAULT_IS_PARTIAL = r1;
        DEFAULT_ABSOLUTE_TIMESTAMP = 0L;
        DEFAULT_FIRST_WORD_START_TIME = 0L;
        DEFAULT_SHOW_EDIT_SPEAKER_BUTTON = r1;
        DEFAULT_DELETE_SEGMENT = r1;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1897newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.seg_id = this.seg_id;
        r0.source = this.source;
        r0.target = this.target;
        r0.timestamp = this.timestamp;
        r0.slice_id = this.slice_id;
        r0.is_seg_final = this.is_seg_final;
        r0.track_received = this.track_received;
        r0.sound_type = this.sound_type;
        r0.is_partial = this.is_partial;
        r0.absolute_timestamp = this.absolute_timestamp;
        r0.ssd_speaker = this.ssd_speaker;
        r0.first_word_start_time = this.first_word_start_time;
        r0.show_edit_speaker_button = this.show_edit_speaker_button;
        r0.delete_segment = this.delete_segment;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RecordingSubtitleData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1897newBuilder();
    }

    public RecordingSubtitleData(String r18, Long r19, Subtitle r20, Subtitle r21, Long r22, Long r23, Boolean r24, Boolean r25, SoundType r26, Boolean r27, Long r28, SSDSpeaker r29, Long r30, Boolean r31, Boolean r32) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, ByteString.EMPTY);
    }

    public RecordingSubtitleData(String r4, Long r5, Subtitle r6, Subtitle r7, Long r8, Long r9, Boolean r10, Boolean r11, SoundType r12, Boolean r13, Long r14, SSDSpeaker r15, Long r16, Boolean r17, Boolean r18, ByteString r19) {
        super(ADAPTER, r19);
        this.session_id = r4;
        this.seg_id = r5;
        this.source = r6;
        this.target = r7;
        this.timestamp = r8;
        this.slice_id = r9;
        this.is_seg_final = r10;
        this.track_received = r11;
        this.sound_type = r12;
        this.is_partial = r13;
        this.absolute_timestamp = r14;
        this.ssd_speaker = r15;
        this.first_word_start_time = r16;
        this.show_edit_speaker_button = r17;
        this.delete_segment = r18;
    }
}
