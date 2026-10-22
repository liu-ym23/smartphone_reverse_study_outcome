package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateSISettingRequest extends Message<UpdateSISettingRequest, Builder> {
    public static final ProtoAdapter<UpdateSISettingRequest> ADAPTER = null;
    public static final String DEFAULT_BREAKOUT_ROOM_ID = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final String DEFAULT_RECORD_ID = "";
    public static final String DEFAULT_TARGET_LANG = "";
    public static final Boolean DEFAULT_TURN_ON = null;
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final SIBizScene mbiz_scene;
    public final String mbreakout_room_id;
    public final DoubaoBizInfo mdoubao_bizinfo;
    public final String mmeeting_id;
    public final String mrecord_id;
    public final String mtarget_lang;
    public final Boolean mturn_on;

    public static final class Builder extends Message.Builder<UpdateSISettingRequest, Builder> {
        public SIBizScene mbiz_scene;
        public String mbreakout_room_id;
        public DoubaoBizInfo mdoubao_bizinfo;
        public String mmeeting_id;
        public String mrecord_id;
        public String mtarget_lang;
        public Boolean mturn_on;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateSISettingRequest m3203build() {
            return new UpdateSISettingRequest(this.mmeeting_id, this.mbreakout_room_id, this.mturn_on, this.mtarget_lang, this.mbiz_scene, this.mrecord_id, this.mdoubao_bizinfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3203build();
        }

        public Builder biz_scene(SIBizScene r1) {
            this.mbiz_scene = r1;
            return this;
        }

        public Builder breakout_room_id(String r1) {
            this.mbreakout_room_id = r1;
            return this;
        }

        public Builder doubao_bizinfo(DoubaoBizInfo r1) {
            this.mdoubao_bizinfo = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }

        public Builder record_id(String r1) {
            this.mrecord_id = r1;
            return this;
        }

        public Builder target_lang(String r1) {
            this.mtarget_lang = r1;
            return this;
        }

        public Builder turn_on(Boolean r1) {
            this.mturn_on = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateSISettingRequest extends ProtoAdapter<UpdateSISettingRequest> {
        public ProtoAdapter_UpdateSISettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateSISettingRequest.class);
        }

        public UpdateSISettingRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            r0.mbreakout_room_id = "";
            r0.mturn_on = Boolean.FALSE;
            r0.mtarget_lang = "";
            r0.mrecord_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L19;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r0.mbiz_scene = (SIBizScene) SIBizScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mdoubao_bizinfo = (DoubaoBizInfo) DoubaoBizInfo.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mrecord_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mtarget_lang = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mturn_on = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            r0.mbreakout_room_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L17:
            r9.endMessage(r1);
            return r0.m3203build();
        }

        public int encodedSize(UpdateSISettingRequest r6) {
            String r0 = r6.mmeeting_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mbreakout_room_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mturn_on;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtarget_lang;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            SIBizScene r13 = r6.mbiz_scene;
            if (r13 == null) goto L21;
            int r14 = SIBizScene.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mrecord_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            DoubaoBizInfo r19 = r6.mdoubao_bizinfo;
            if (r19 == null) goto L30;
            r1 = DoubaoBizInfo.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            return (r18 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m3204decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateSISettingRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateSISettingRequest r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mbreakout_room_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mturn_on;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtarget_lang;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            SIBizScene r6 = r5.mbiz_scene;
            if (r6 == null) goto L17;
            SIBizScene.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mrecord_id;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            DoubaoBizInfo r8 = r5.mdoubao_bizinfo;
            if (r8 == null) goto L23;
            DoubaoBizInfo.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateSISettingRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateSISettingRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
        DEFAULT_TURN_ON = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3202newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mbreakout_room_id = this.mbreakout_room_id;
        r0.mturn_on = this.mturn_on;
        r0.mtarget_lang = this.mtarget_lang;
        r0.mbiz_scene = this.mbiz_scene;
        r0.mrecord_id = this.mrecord_id;
        r0.mdoubao_bizinfo = this.mdoubao_bizinfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateSISettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3202newBuilder();
    }

    public UpdateSISettingRequest(String r10, String r11, Boolean r12, String r13, SIBizScene r14, String r15, DoubaoBizInfo r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public UpdateSISettingRequest(String r2, String r3, Boolean r4, String r5, SIBizScene r6, String r7, DoubaoBizInfo r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mmeeting_id = r2;
        this.mbreakout_room_id = r3;
        this.mturn_on = r4;
        this.mtarget_lang = r5;
        this.mbiz_scene = r6;
        this.mrecord_id = r7;
        this.mdoubao_bizinfo = r8;
    }
}
