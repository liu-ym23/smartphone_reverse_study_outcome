package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingStartRequest extends Message<MinutesRecordingStartRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingStartRequest> ADAPTER = null;
    public static final Boolean DEFAULT_APPLY_RECORDING_ID = null;
    public static final ContentType DEFAULT_CONTENT_TYPE = null;
    public static final ExtraType DEFAULT_EXTRA_TYPE = null;
    public static final ProtoAdapter_MinutesRecordingStartRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean apply_recording_id;
    public final ContentType content_type;
    public final DoubaoBizInfo doubao_biz_info;
    public final ExtraType extra_type;
    public final HardwareInfo hardware_info;

    public static final class Builder extends Message.Builder<MinutesRecordingStartRequest, Builder> implements d<MinutesRecordingStartRequest> {
        public Boolean apply_recording_id;
        public ContentType content_type;
        public DoubaoBizInfo doubao_biz_info;
        public ExtraType extra_type;
        public HardwareInfo hardware_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingStartRequest m1874build() {
            return new MinutesRecordingStartRequest(this.doubao_biz_info, this.extra_type, this.apply_recording_id, this.content_type, this.hardware_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1874build();
        }

        public Builder apply_recording_id(Boolean r1) {
            this.apply_recording_id = r1;
            return this;
        }

        public Builder content_type(ContentType r1) {
            this.content_type = r1;
            return this;
        }

        public Builder doubao_biz_info(DoubaoBizInfo r1) {
            this.doubao_biz_info = r1;
            return this;
        }

        public Builder extra_type(ExtraType r1) {
            this.extra_type = r1;
            return this;
        }

        public Builder hardware_info(HardwareInfo r1) {
            this.hardware_info = r1;
            return this;
        }
    }

    public static final enum ContentType extends Enum<ContentType> implements WireEnum {
        private static final /* synthetic */ ContentType[] $VALUES = null;
        public static final ProtoAdapter<ContentType> ADAPTER = null;
        public static final ContentType COMMONRECORDING = null;
        public static final ContentType INTERPRETATION = null;
        private final int value;

        static {
            ContentType r0 = new ContentType("COMMONRECORDING", 0, 0);
            COMMONRECORDING = r0;
            ContentType r1 = new ContentType("INTERPRETATION", 1, 1);
            INTERPRETATION = r1;
            $VALUES = new ContentType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContentType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return INTERPRETATION;
        L10:
            return COMMONRECORDING;
        }

        public static ContentType valueOf(String r1) {
            return (ContentType) a.a(ContentType.class, r1);
        }

        private ContentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class DoubaoBizInfo extends Message<DoubaoBizInfo, Builder> {
        public static final ProtoAdapter<DoubaoBizInfo> ADAPTER = null;
        public static final String DEFAULT_APP_ID = "";
        public static final String DEFAULT_BIZ_ID = "";
        public static final String DEFAULT_CONVERSATION_ID = "";
        public static final String DEFAULT_DEVICE_ID = "";
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final String DEFAULT_RECORDING_ID = "";
        public static final String DEFAULT_REPLY_MESSAGE_ID = "";
        public static final String DEFAULT_TENANT_ID = "";
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String app_id;
        public final String biz_id;
        public final String conversation_id;
        public final String device_id;
        public final String message_id;
        public final String recording_id;
        public final String reply_message_id;
        public final String tenant_id;
        public final String user_id;

        public static final class Builder extends Message.Builder<DoubaoBizInfo, Builder> {
            public String app_id;
            public String biz_id;
            public String conversation_id;
            public String device_id;
            public String message_id;
            public String recording_id;
            public String reply_message_id;
            public String tenant_id;
            public String user_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DoubaoBizInfo m1876build() {
                return new DoubaoBizInfo(this.user_id, this.conversation_id, this.message_id, this.reply_message_id, this.biz_id, this.app_id, this.tenant_id, this.device_id, this.recording_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1876build();
            }

            public Builder app_id(String r1) {
                this.app_id = r1;
                return this;
            }

            public Builder biz_id(String r1) {
                this.biz_id = r1;
                return this;
            }

            public Builder conversation_id(String r1) {
                this.conversation_id = r1;
                return this;
            }

            public Builder device_id(String r1) {
                this.device_id = r1;
                return this;
            }

            public Builder message_id(String r1) {
                this.message_id = r1;
                return this;
            }

            public Builder recording_id(String r1) {
                this.recording_id = r1;
                return this;
            }

            public Builder reply_message_id(String r1) {
                this.reply_message_id = r1;
                return this;
            }

            public Builder tenant_id(String r1) {
                this.tenant_id = r1;
                return this;
            }

            public Builder user_id(String r1) {
                this.user_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DoubaoBizInfo extends ProtoAdapter<DoubaoBizInfo> {
            public ProtoAdapter_DoubaoBizInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DoubaoBizInfo.class);
            }

            public DoubaoBizInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.user_id = "";
                r0.conversation_id = "";
                r0.message_id = "";
                r0.reply_message_id = "";
                r0.biz_id = "";
                r0.app_id = "";
                r0.tenant_id = "";
                r0.device_id = "";
                r0.recording_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L16;
                switch(r3) {
                    case 1: goto L15;
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
            L7:
                r0.recording_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.device_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                r0.tenant_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                r0.app_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.biz_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.reply_message_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L13:
                r0.message_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L14:
                r0.conversation_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L15:
                r0.user_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L16:
                r7.endMessage(r1);
                return r0.m1876build();
            }

            public int encodedSize(DoubaoBizInfo r6) {
                String r0 = r6.user_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.conversation_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.message_id;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.reply_message_id;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                String r13 = r6.biz_id;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                String r16 = r6.app_id;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                String r19 = r6.tenant_id;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                String r22 = r6.device_id;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                String r25 = r6.recording_id;
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
            public /* bridge */ /* synthetic */ Object m1877decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DoubaoBizInfo) r1);
            }

            public void encode(ProtoWriter r4, DoubaoBizInfo r5) throws IOException {
                String r0 = r5.user_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.conversation_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.message_id;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.reply_message_id;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                String r6 = r5.biz_id;
                if (r6 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
            L17:
                String r7 = r5.app_id;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
            L20:
                String r8 = r5.tenant_id;
                if (r8 == null) goto L23;
                ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
            L23:
                String r9 = r5.device_id;
                if (r9 == null) goto L26;
                ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
            L26:
                String r10 = r5.recording_id;
                if (r10 == null) goto L29;
                ProtoAdapter.STRING.encodeWithTag(r4, 9, r10);
            L29:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DoubaoBizInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DoubaoBizInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1875newBuilder() {
            Builder r0 = new Builder();
            r0.user_id = this.user_id;
            r0.conversation_id = this.conversation_id;
            r0.message_id = this.message_id;
            r0.reply_message_id = this.reply_message_id;
            r0.biz_id = this.biz_id;
            r0.app_id = this.app_id;
            r0.tenant_id = this.tenant_id;
            r0.device_id = this.device_id;
            r0.recording_id = this.recording_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DoubaoBizInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1875newBuilder();
        }

        public DoubaoBizInfo(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
            this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
        }

        public DoubaoBizInfo(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, ByteString r11) {
            super(ADAPTER, r11);
            this.user_id = r2;
            this.conversation_id = r3;
            this.message_id = r4;
            this.reply_message_id = r5;
            this.biz_id = r6;
            this.app_id = r7;
            this.tenant_id = r8;
            this.device_id = r9;
            this.recording_id = r10;
        }
    }

    public static final enum ExtraType extends Enum<ExtraType> implements WireEnum {
        private static final /* synthetic */ ExtraType[] $VALUES = null;
        public static final ProtoAdapter<ExtraType> ADAPTER = null;
        public static final ExtraType DOUBAO_EARBUDS = null;
        public static final ExtraType DOUBAO_GLASSES = null;
        public static final ExtraType DOUBAO_IN_LARK = null;
        public static final ExtraType UNKNOWN = null;
        private final int value;

        static {
            ExtraType r0 = new ExtraType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ExtraType r1 = new ExtraType("DOUBAO_IN_LARK", 1, 1);
            DOUBAO_IN_LARK = r1;
            ExtraType r3 = new ExtraType("DOUBAO_GLASSES", 2, 2);
            DOUBAO_GLASSES = r3;
            ExtraType r5 = new ExtraType("DOUBAO_EARBUDS", 3, 3);
            DOUBAO_EARBUDS = r5;
            $VALUES = new ExtraType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(ExtraType.class);
        }

        public static ExtraType[] values() {
            return (ExtraType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ExtraType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return DOUBAO_EARBUDS;
        L14:
            return DOUBAO_GLASSES;
        L16:
            return DOUBAO_IN_LARK;
        L18:
            return UNKNOWN;
        }

        public static ExtraType valueOf(String r1) {
            return (ExtraType) a.a(ExtraType.class, r1);
        }

        private ExtraType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class HardwareInfo extends Message<HardwareInfo, Builder> {
        public static final ProtoAdapter<HardwareInfo> ADAPTER = null;
        public static final HardwareSubType DEFAULT_HARDWARE_SUBTYPE = null;
        public static final String DEFAULT_HARDWARE_UNIQUE_KEY = "";
        private static final long serialVersionUID = 0;
        public final HardwareSubType hardware_subtype;
        public final String hardware_unique_key;

        public static final class Builder extends Message.Builder<HardwareInfo, Builder> {
            public HardwareSubType hardware_subtype;
            public String hardware_unique_key;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HardwareInfo m1879build() {
                return new HardwareInfo(this.hardware_unique_key, this.hardware_subtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1879build();
            }

            public Builder hardware_subtype(HardwareSubType r1) {
                this.hardware_subtype = r1;
                return this;
            }

            public Builder hardware_unique_key(String r1) {
                this.hardware_unique_key = r1;
                return this;
            }
        }

        public static final enum HardwareSubType extends Enum<HardwareSubType> implements WireEnum {
            private static final /* synthetic */ HardwareSubType[] $VALUES = null;
            public static final ProtoAdapter<HardwareSubType> ADAPTER = null;
            public static final HardwareSubType LIBERTY = null;
            public static final HardwareSubType SOUNDCORE = null;
            private final int value;

            static {
                HardwareSubType r0 = new HardwareSubType("SOUNDCORE", 0, 0);
                SOUNDCORE = r0;
                HardwareSubType r1 = new HardwareSubType("LIBERTY", 1, 1);
                LIBERTY = r1;
                $VALUES = new HardwareSubType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(HardwareSubType.class);
            }

            public static HardwareSubType[] values() {
                return (HardwareSubType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static HardwareSubType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return LIBERTY;
            L10:
                return SOUNDCORE;
            }

            public static HardwareSubType valueOf(String r1) {
                return (HardwareSubType) a.a(HardwareSubType.class, r1);
            }

            private HardwareSubType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_HardwareInfo extends ProtoAdapter<HardwareInfo> {
            public ProtoAdapter_HardwareInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, HardwareInfo.class);
            }

            public HardwareInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.hardware_unique_key = "";
                r0.hardware_subtype = HardwareSubType.SOUNDCORE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.hardware_unique_key = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.hardware_subtype = (HardwareSubType) HardwareSubType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1879build();
            }

            public int encodedSize(HardwareInfo r5) {
                String r0 = r5.hardware_unique_key;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                HardwareSubType r3 = r5.hardware_subtype;
                if (r3 == null) goto L10;
                r1 = HardwareSubType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1880decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HardwareInfo) r1);
            }

            public void encode(ProtoWriter r4, HardwareInfo r5) throws IOException {
                String r0 = r5.hardware_unique_key;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                HardwareSubType r1 = r5.hardware_subtype;
                if (r1 == null) goto L8;
                HardwareSubType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HardwareInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HardwareInfo();
            DEFAULT_HARDWARE_SUBTYPE = HardwareSubType.SOUNDCORE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1878newBuilder() {
            Builder r0 = new Builder();
            r0.hardware_unique_key = this.hardware_unique_key;
            r0.hardware_subtype = this.hardware_subtype;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HardwareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1878newBuilder();
        }

        public HardwareInfo(String r2, HardwareSubType r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public HardwareInfo(String r2, HardwareSubType r3, ByteString r4) {
            super(ADAPTER, r4);
            this.hardware_unique_key = r2;
            this.hardware_subtype = r3;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStartRequest extends ProtoAdapter<MinutesRecordingStartRequest> implements c<MinutesRecordingStartRequest> {
        public ProtoAdapter_MinutesRecordingStartRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStartRequest.class);
        }

        public MinutesRecordingStartRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.extra_type = ExtraType.UNKNOWN;
            r0.apply_recording_id = Boolean.FALSE;
            r0.content_type = ContentType.COMMONRECORDING;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L27;
            if (r3 != 1) goto L8;
            r0.doubao_biz_info = (DoubaoBizInfo) DoubaoBizInfo.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.extra_type = (ExtraType) ExtraType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.apply_recording_id = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.content_type = (ContentType) ContentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.hardware_info = (HardwareInfo) HardwareInfo.ADAPTER.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L27:
            r9.endMessage(r1);
            return r0.m1874build();
        }

        public int encodedSize(MinutesRecordingStartRequest r6) {
            DoubaoBizInfo r0 = r6.doubao_biz_info;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = DoubaoBizInfo.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            ExtraType r3 = r6.extra_type;
            if (r3 == null) goto L9;
            int r4 = ExtraType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.apply_recording_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ContentType r10 = r6.content_type;
            if (r10 == null) goto L17;
            int r11 = ContentType.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            HardwareInfo r13 = r6.hardware_info;
            if (r13 == null) goto L22;
            r1 = HardwareInfo.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1881decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingStartRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingStartRequest r5) throws IOException {
            DoubaoBizInfo r0 = r5.doubao_biz_info;
            if (r0 == null) goto L5;
            DoubaoBizInfo.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            ExtraType r1 = r5.extra_type;
            if (r1 == null) goto L8;
            ExtraType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.apply_recording_id;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            ContentType r3 = r5.content_type;
            if (r3 == null) goto L14;
            ContentType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            HardwareInfo r6 = r5.hardware_info;
            if (r6 == null) goto L17;
            HardwareInfo.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingStartRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStartRequest r0 = new ProtoAdapter_MinutesRecordingStartRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_EXTRA_TYPE = ExtraType.UNKNOWN;
        DEFAULT_APPLY_RECORDING_ID = Boolean.FALSE;
        DEFAULT_CONTENT_TYPE = ContentType.COMMONRECORDING;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1873newBuilder() {
        Builder r0 = new Builder();
        r0.doubao_biz_info = this.doubao_biz_info;
        r0.extra_type = this.extra_type;
        r0.apply_recording_id = this.apply_recording_id;
        r0.content_type = this.content_type;
        r0.hardware_info = this.hardware_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingStartRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1873newBuilder();
    }

    public MinutesRecordingStartRequest(DoubaoBizInfo r8, ExtraType r9, Boolean r10, ContentType r11, HardwareInfo r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public MinutesRecordingStartRequest(DoubaoBizInfo r2, ExtraType r3, Boolean r4, ContentType r5, HardwareInfo r6, ByteString r7) {
        super(ADAPTER, r7);
        this.doubao_biz_info = r2;
        this.extra_type = r3;
        this.apply_recording_id = r4;
        this.content_type = r5;
        this.hardware_info = r6;
    }
}
