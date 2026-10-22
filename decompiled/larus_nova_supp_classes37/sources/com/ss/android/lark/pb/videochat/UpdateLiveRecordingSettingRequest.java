package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateLiveRecordingSettingRequest extends Message<UpdateLiveRecordingSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateLiveRecordingSettingRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_AUTO_SET_BILINGUAL = null;
    public static final Boolean DEFAULT_IS_AUTO_SET_TRANSCRIPT_LANGUAGE = null;
    public static final Boolean DEFAULT_IS_BILINGUAL = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_ORIGINAL_MEETING_ID = "";
    public static final String DEFAULT_SOURCE_TYPE = "";
    public static final String DEFAULT_SPOKEN_LANGUAGE = "";
    public static final String DEFAULT_TRANSLATION_LANGUAGE = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final Boolean mis_auto_set_bilingual;
    public final Boolean mis_auto_set_transcript_language;
    public final Boolean mis_bilingual;
    public final String mmeeting_id;
    public final String moriginal_meeting_id;
    public final String msource_type;
    public final String mspoken_language;
    public final String mtranslation_language;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action SET_BILINGUAL_STATUS = null;
        public static final Action SET_SPOKEN_LANGUAGE = null;
        public static final Action SET_TRANSLATION_LANGUAGE = null;
        public static final Action TURN_OFF = null;
        public static final Action TURN_ON = null;
        public static final Action UNKNOWN = null;
        private final int value;

        static {
            Action r0 = new Action("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Action r1 = new Action("TURN_ON", 1, 1);
            TURN_ON = r1;
            Action r3 = new Action("TURN_OFF", 2, 2);
            TURN_OFF = r3;
            Action r5 = new Action("SET_SPOKEN_LANGUAGE", 3, 3);
            SET_SPOKEN_LANGUAGE = r5;
            Action r7 = new Action("SET_TRANSLATION_LANGUAGE", 4, 4);
            SET_TRANSLATION_LANGUAGE = r7;
            Action r9 = new Action("SET_BILINGUAL_STATUS", 5, 5);
            SET_BILINGUAL_STATUS = r9;
            $VALUES = new Action[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return SET_BILINGUAL_STATUS;
        L18:
            return SET_TRANSLATION_LANGUAGE;
        L20:
            return SET_SPOKEN_LANGUAGE;
        L22:
            return TURN_OFF;
        L24:
            return TURN_ON;
        L26:
            return UNKNOWN;
        }

        public static Action valueOf(String r1) {
            return (Action) a.a(Action.class, r1);
        }

        private Action(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<UpdateLiveRecordingSettingRequest, Builder> {
        public Action maction;
        public Boolean mis_auto_set_bilingual;
        public Boolean mis_auto_set_transcript_language;
        public Boolean mis_bilingual;
        public String mmeeting_id;
        public String moriginal_meeting_id;
        public String msource_type;
        public String mspoken_language;
        public String mtranslation_language;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateLiveRecordingSettingRequest m3197build() {
            return new UpdateLiveRecordingSettingRequest(this.mmeeting_id, this.maction, this.mspoken_language, this.mtranslation_language, this.mis_bilingual, this.mis_auto_set_transcript_language, this.mis_auto_set_bilingual, this.moriginal_meeting_id, this.msource_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3197build();
        }

        public Builder action(Action r1) {
            this.maction = r1;
            return this;
        }

        public Builder is_auto_set_bilingual(Boolean r1) {
            this.mis_auto_set_bilingual = r1;
            return this;
        }

        public Builder is_auto_set_transcript_language(Boolean r1) {
            this.mis_auto_set_transcript_language = r1;
            return this;
        }

        public Builder is_bilingual(Boolean r1) {
            this.mis_bilingual = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder original_meeting_id(String r1) {
            this.moriginal_meeting_id = r1;
            return this;
        }

        public Builder source_type(String r1) {
            this.msource_type = r1;
            return this;
        }

        public Builder spoken_language(String r1) {
            this.mspoken_language = r1;
            return this;
        }

        public Builder translation_language(String r1) {
            this.mtranslation_language = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateLiveRecordingSettingRequest extends ProtoAdapter<UpdateLiveRecordingSettingRequest> {
        public ProtoAdapter_UpdateLiveRecordingSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateLiveRecordingSettingRequest.class);
        }

        public UpdateLiveRecordingSettingRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mspoken_language = "";
            r0.mtranslation_language = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_bilingual = r2;
            r0.mis_auto_set_transcript_language = r2;
            r0.mis_auto_set_bilingual = r2;
            r0.moriginal_meeting_id = "";
            r0.msource_type = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L21;
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
            r0.maction = (Action) Action.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.msource_type = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.moriginal_meeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mis_auto_set_bilingual = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.mis_auto_set_transcript_language = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.mis_bilingual = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mtranslation_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mspoken_language = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m3197build();
        }

        public int encodedSize(UpdateLiveRecordingSettingRequest r6) {
            String r0 = r6.mmeeting_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Action r3 = r6.maction;
            if (r3 == null) goto L9;
            int r4 = Action.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mspoken_language;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtranslation_language;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_bilingual;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.mis_auto_set_transcript_language;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mis_auto_set_bilingual;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.moriginal_meeting_id;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.msource_type;
            if (r25 == null) goto L38;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
        L38:
            return (r24 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3198decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateLiveRecordingSettingRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateLiveRecordingSettingRequest r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Action r1 = r5.maction;
            if (r1 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mspoken_language;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtranslation_language;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mis_bilingual;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.mis_auto_set_transcript_language;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mis_auto_set_bilingual;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.moriginal_meeting_id;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            String r10 = r5.msource_type;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r10);
        L29:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateLiveRecordingSettingRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateLiveRecordingSettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_BILINGUAL = r0;
        DEFAULT_IS_AUTO_SET_TRANSCRIPT_LANGUAGE = r0;
        DEFAULT_IS_AUTO_SET_BILINGUAL = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3196newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.maction = this.maction;
        r0.mspoken_language = this.mspoken_language;
        r0.mtranslation_language = this.mtranslation_language;
        r0.mis_bilingual = this.mis_bilingual;
        r0.mis_auto_set_transcript_language = this.mis_auto_set_transcript_language;
        r0.mis_auto_set_bilingual = this.mis_auto_set_bilingual;
        r0.moriginal_meeting_id = this.moriginal_meeting_id;
        r0.msource_type = this.msource_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateLiveRecordingSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3196newBuilder();
    }

    public UpdateLiveRecordingSettingRequest(String r12, Action r13, String r14, String r15, Boolean r16, Boolean r17, Boolean r18, String r19, String r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public UpdateLiveRecordingSettingRequest(String r2, Action r3, String r4, String r5, Boolean r6, Boolean r7, Boolean r8, String r9, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mmeeting_id = r2;
        this.maction = r3;
        this.mspoken_language = r4;
        this.mtranslation_language = r5;
        this.mis_bilingual = r6;
        this.mis_auto_set_transcript_language = r7;
        this.mis_auto_set_bilingual = r8;
        this.moriginal_meeting_id = r9;
        this.msource_type = r10;
    }
}
