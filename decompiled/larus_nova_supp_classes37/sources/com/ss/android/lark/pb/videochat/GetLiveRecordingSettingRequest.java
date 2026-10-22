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
public final class GetLiveRecordingSettingRequest extends Message<GetLiveRecordingSettingRequest, Builder> {
    public static final ProtoAdapter<GetLiveRecordingSettingRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_USER_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final Action maction;
    public final String mmeeting_id;
    public final String muser_id;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action GET_CAN_RECORDING_MARK = null;
        public static final Action GET_CURRENT_SETTING = null;
        public static final Action GET_SPEAKER_INFO_EDIT_WAITING_TIME = null;
        public static final Action GET_SUPPORT_SPOKEN_LANGUAGE = null;
        public static final Action GET_SUPPORT_TRANSLATION_LANGUAGE = null;
        public static final Action UNKNOWN = null;
        private final int value;

        static {
            Action r0 = new Action("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Action r1 = new Action("GET_CURRENT_SETTING", 1, 1);
            GET_CURRENT_SETTING = r1;
            Action r3 = new Action("GET_SUPPORT_SPOKEN_LANGUAGE", 2, 2);
            GET_SUPPORT_SPOKEN_LANGUAGE = r3;
            Action r5 = new Action("GET_SUPPORT_TRANSLATION_LANGUAGE", 3, 3);
            GET_SUPPORT_TRANSLATION_LANGUAGE = r5;
            Action r7 = new Action("GET_SPEAKER_INFO_EDIT_WAITING_TIME", 4, 4);
            GET_SPEAKER_INFO_EDIT_WAITING_TIME = r7;
            Action r9 = new Action("GET_CAN_RECORDING_MARK", 5, 5);
            GET_CAN_RECORDING_MARK = r9;
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
            return GET_CAN_RECORDING_MARK;
        L18:
            return GET_SPEAKER_INFO_EDIT_WAITING_TIME;
        L20:
            return GET_SUPPORT_TRANSLATION_LANGUAGE;
        L22:
            return GET_SUPPORT_SPOKEN_LANGUAGE;
        L24:
            return GET_CURRENT_SETTING;
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

    public static final class Builder extends Message.Builder<GetLiveRecordingSettingRequest, Builder> {
        public Action maction;
        public String mmeeting_id;
        public String muser_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetLiveRecordingSettingRequest m3116build() {
            return new GetLiveRecordingSettingRequest(this.mmeeting_id, this.maction, this.muser_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3116build();
        }

        public Builder action(Action r1) {
            this.maction = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder user_id(String r1) {
            this.muser_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLiveRecordingSettingRequest extends ProtoAdapter<GetLiveRecordingSettingRequest> {
        public ProtoAdapter_GetLiveRecordingSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLiveRecordingSettingRequest.class);
        }

        public GetLiveRecordingSettingRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.muser_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.maction = (Action) Action.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.muser_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m3116build();
        }

        public int encodedSize(GetLiveRecordingSettingRequest r6) {
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
            String r7 = r6.muser_id;
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
        public /* bridge */ /* synthetic */ Object m3117decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetLiveRecordingSettingRequest) r1);
        }

        public void encode(ProtoWriter r4, GetLiveRecordingSettingRequest r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Action r1 = r5.maction;
            if (r1 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.muser_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetLiveRecordingSettingRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLiveRecordingSettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3115newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.maction = this.maction;
        r0.muser_id = this.muser_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetLiveRecordingSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3115newBuilder();
    }

    public GetLiveRecordingSettingRequest(String r2, Action r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetLiveRecordingSettingRequest(String r2, Action r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mmeeting_id = r2;
        this.maction = r3;
        this.muser_id = r4;
    }
}
