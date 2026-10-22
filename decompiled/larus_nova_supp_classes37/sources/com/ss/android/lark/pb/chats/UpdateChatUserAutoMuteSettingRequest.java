package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateChatUserAutoMuteSettingRequest extends Message<UpdateChatUserAutoMuteSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateChatUserAutoMuteSettingRequest> ADAPTER = null;
    public static final Long DEFAULT_BOT_ID = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mbot_id;
    public final Long mchat_id;
    public final MuteSource msource;
    public final UpdateField mupdate_field;

    public static final class Builder extends Message.Builder<UpdateChatUserAutoMuteSettingRequest, Builder> {
        public Long mbot_id;
        public Long mchat_id;
        public MuteSource msource;
        public UpdateField mupdate_field;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateChatUserAutoMuteSettingRequest m914build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new UpdateChatUserAutoMuteSettingRequest(this.mchat_id, this.mbot_id, this.mupdate_field, this.msource, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m914build();
        }

        public Builder bot_id(Long r1) {
            this.mbot_id = r1;
            return this;
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder source(MuteSource r1) {
            this.msource = r1;
            return this;
        }

        public Builder update_field(UpdateField r1) {
            this.mupdate_field = r1;
            return this;
        }
    }

    public static final enum MuteSource extends Enum<MuteSource> implements WireEnum {
        private static final /* synthetic */ MuteSource[] $VALUES = null;
        public static final ProtoAdapter<MuteSource> ADAPTER = null;
        public static final MuteSource CHAT_SETTINGS = null;
        public static final MuteSource CHAT_TOP_BANNER = null;
        public static final MuteSource GROUP_MEMBER_ROBOT_LIST = null;
        public static final MuteSource NOISE_REDUCTION_SYS_MSG = null;
        public static final MuteSource RIGHT_CLICK_LIST_OPTIONS = null;
        public static final MuteSource UNKNOWN_SOURCE = null;
        private final int value;

        static {
            MuteSource r0 = new MuteSource("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r0;
            MuteSource r1 = new MuteSource("CHAT_TOP_BANNER", 1, 1);
            CHAT_TOP_BANNER = r1;
            MuteSource r3 = new MuteSource("GROUP_MEMBER_ROBOT_LIST", 2, 2);
            GROUP_MEMBER_ROBOT_LIST = r3;
            MuteSource r5 = new MuteSource("NOISE_REDUCTION_SYS_MSG", 3, 3);
            NOISE_REDUCTION_SYS_MSG = r5;
            MuteSource r7 = new MuteSource("RIGHT_CLICK_LIST_OPTIONS", 4, 4);
            RIGHT_CLICK_LIST_OPTIONS = r7;
            MuteSource r9 = new MuteSource("CHAT_SETTINGS", 5, 5);
            CHAT_SETTINGS = r9;
            $VALUES = new MuteSource[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(MuteSource.class);
        }

        public static MuteSource[] values() {
            return (MuteSource[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static MuteSource fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return CHAT_SETTINGS;
        L18:
            return RIGHT_CLICK_LIST_OPTIONS;
        L20:
            return NOISE_REDUCTION_SYS_MSG;
        L22:
            return GROUP_MEMBER_ROBOT_LIST;
        L24:
            return CHAT_TOP_BANNER;
        L26:
            return UNKNOWN_SOURCE;
        }

        public static MuteSource valueOf(String r1) {
            return (MuteSource) a.a(MuteSource.class, r1);
        }

        private MuteSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_UpdateChatUserAutoMuteSettingRequest extends ProtoAdapter<UpdateChatUserAutoMuteSettingRequest> {
        public ProtoAdapter_UpdateChatUserAutoMuteSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatUserAutoMuteSettingRequest.class);
        }

        public UpdateChatUserAutoMuteSettingRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mbot_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mbot_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 4) goto L12;
            r0.mupdate_field = (UpdateField) UpdateField.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 5) goto L13;
            r0.msource = (MuteSource) MuteSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m914build();
        }

        public int encodedSize(UpdateChatUserAutoMuteSettingRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            int r1 = r0.encodedSizeWithTag(1, r6.mchat_id);
            Long r2 = r6.mbot_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            UpdateField r7 = r6.mupdate_field;
            if (r7 == null) goto L9;
            int r8 = UpdateField.ADAPTER.encodedSizeWithTag(4, r7);
        L10:
            int r9 = r5 + r8;
            MuteSource r10 = r6.msource;
            if (r10 == null) goto L14;
            r3 = MuteSource.ADAPTER.encodedSizeWithTag(5, r10);
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
        public /* bridge */ /* synthetic */ Object m915decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateChatUserAutoMuteSettingRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateChatUserAutoMuteSettingRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 1, r5.mchat_id);
            Long r1 = r5.mbot_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            UpdateField r2 = r5.mupdate_field;
            if (r2 == null) goto L8;
            UpdateField.ADAPTER.encodeWithTag(r4, 4, r2);
        L8:
            MuteSource r3 = r5.msource;
            if (r3 == null) goto L11;
            MuteSource.ADAPTER.encodeWithTag(r4, 5, r3);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateChatUserAutoMuteSettingRequest) r2);
        }
    }

    public static final enum UpdateField extends Enum<UpdateField> implements WireEnum {
        private static final /* synthetic */ UpdateField[] $VALUES = null;
        public static final ProtoAdapter<UpdateField> ADAPTER = null;
        public static final UpdateField CLOSE_BANNER_SHOW = null;
        public static final UpdateField CLOSE_BOT_MUTE = null;
        public static final UpdateField CLOSE_LARGE_CHAT_MUTE = null;
        public static final UpdateField OPEN_BOT_MUTE = null;
        public static final UpdateField UNKNOWN = null;
        private final int value;

        static {
            UpdateField r0 = new UpdateField("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            UpdateField r1 = new UpdateField("CLOSE_LARGE_CHAT_MUTE", 1, 1);
            CLOSE_LARGE_CHAT_MUTE = r1;
            UpdateField r3 = new UpdateField("CLOSE_BOT_MUTE", 2, 2);
            CLOSE_BOT_MUTE = r3;
            UpdateField r5 = new UpdateField("OPEN_BOT_MUTE", 3, 3);
            OPEN_BOT_MUTE = r5;
            UpdateField r7 = new UpdateField("CLOSE_BANNER_SHOW", 4, 4);
            CLOSE_BANNER_SHOW = r7;
            $VALUES = new UpdateField[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(UpdateField.class);
        }

        public static UpdateField[] values() {
            return (UpdateField[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UpdateField fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return CLOSE_BANNER_SHOW;
        L16:
            return OPEN_BOT_MUTE;
        L18:
            return CLOSE_BOT_MUTE;
        L20:
            return CLOSE_LARGE_CHAT_MUTE;
        L22:
            return UNKNOWN;
        }

        public static UpdateField valueOf(String r1) {
            return (UpdateField) a.a(UpdateField.class, r1);
        }

        private UpdateField(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateChatUserAutoMuteSettingRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_BOT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m913newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mbot_id = this.mbot_id;
        r0.mupdate_field = this.mupdate_field;
        r0.msource = this.msource;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateChatUserAutoMuteSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m913newBuilder();
    }

    public UpdateChatUserAutoMuteSettingRequest(Long r7, Long r8, UpdateField r9, MuteSource r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public UpdateChatUserAutoMuteSettingRequest(Long r2, Long r3, UpdateField r4, MuteSource r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchat_id = r2;
        this.mbot_id = r3;
        this.mupdate_field = r4;
        this.msource = r5;
    }
}
