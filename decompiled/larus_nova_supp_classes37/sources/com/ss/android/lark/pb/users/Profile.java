package com.ss.android.lark.pb.users;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Gender;
import com.ss.android.lark.pb.entities.Image;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import com.ss.android.lark.pb.entities.RichText;
import com.ss.android.lark.pb.entities.TenantNameStatus;
import com.ss.android.lark.pb.url_preview.PreviewHangPoint;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Profile extends Message<Profile, Builder> {
    public static final ProtoAdapter<Profile> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CTA> mctas;
    public final List<Field> mfields;
    public final List<TabInfo> mtabs;
    public final UserInfo muser_info;

    public static final class ApplyCommunication extends Message<ApplyCommunication, Builder> {
        public static final ProtoAdapter<ApplyCommunication> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ApplyCommunicationStatus mopposite_apply_status;
        public final ApplyCommunicationStatus mself_apply_status;

        public static final class Builder extends Message.Builder<ApplyCommunication, Builder> {
            public ApplyCommunicationStatus mopposite_apply_status;
            public ApplyCommunicationStatus mself_apply_status;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ApplyCommunication m3009build() {
                return new ApplyCommunication(this.mself_apply_status, this.mopposite_apply_status, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3009build();
            }

            public Builder opposite_apply_status(ApplyCommunicationStatus r1) {
                this.mopposite_apply_status = r1;
                return this;
            }

            public Builder self_apply_status(ApplyCommunicationStatus r1) {
                this.mself_apply_status = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ApplyCommunication extends ProtoAdapter<ApplyCommunication> {
            public ProtoAdapter_ApplyCommunication() {
                super(FieldEncoding.LENGTH_DELIMITED, ApplyCommunication.class);
            }

            public ApplyCommunication decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mself_apply_status = (ApplyCommunicationStatus) ApplyCommunicationStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mopposite_apply_status = (ApplyCommunicationStatus) ApplyCommunicationStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m3009build();
            }

            public int encodedSize(ApplyCommunication r5) {
                ApplyCommunicationStatus r0 = r5.mself_apply_status;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ApplyCommunicationStatus.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ApplyCommunicationStatus r3 = r5.mopposite_apply_status;
                if (r3 == null) goto L10;
                r1 = ApplyCommunicationStatus.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3010decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ApplyCommunication) r1);
            }

            public void encode(ProtoWriter r4, ApplyCommunication r5) throws IOException {
                ApplyCommunicationStatus r0 = r5.mself_apply_status;
                if (r0 == null) goto L5;
                ApplyCommunicationStatus.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                ApplyCommunicationStatus r1 = r5.mopposite_apply_status;
                if (r1 == null) goto L8;
                ApplyCommunicationStatus.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ApplyCommunication) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ApplyCommunication();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3008newBuilder() {
            Builder r0 = new Builder();
            r0.mself_apply_status = this.mself_apply_status;
            r0.mopposite_apply_status = this.mopposite_apply_status;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ApplyCommunication.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3008newBuilder();
        }

        public ApplyCommunication(ApplyCommunicationStatus r2, ApplyCommunicationStatus r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ApplyCommunication(ApplyCommunicationStatus r2, ApplyCommunicationStatus r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mself_apply_status = r2;
            this.mopposite_apply_status = r3;
        }
    }

    public static final enum ApplyCommunicationStatus extends Enum<ApplyCommunicationStatus> implements WireEnum {
        private static final /* synthetic */ ApplyCommunicationStatus[] $VALUES = null;
        public static final ProtoAdapter<ApplyCommunicationStatus> ADAPTER = null;
        public static final ApplyCommunicationStatus APPLYING_CANNOT_APPLY = null;
        public static final ApplyCommunicationStatus APPLYING_CAN_APPLY = null;
        public static final ApplyCommunicationStatus APPLY_UNKNOWN = null;
        public static final ApplyCommunicationStatus CAN_APPLY = null;
        public static final ApplyCommunicationStatus CAN_NOT_APPLY = null;
        public static final ApplyCommunicationStatus PASS = null;
        private final int value;

        static {
            ApplyCommunicationStatus r0 = new ApplyCommunicationStatus("APPLY_UNKNOWN", 0, 0);
            APPLY_UNKNOWN = r0;
            ApplyCommunicationStatus r1 = new ApplyCommunicationStatus("PASS", 1, 1);
            PASS = r1;
            ApplyCommunicationStatus r3 = new ApplyCommunicationStatus("CAN_APPLY", 2, 2);
            CAN_APPLY = r3;
            ApplyCommunicationStatus r5 = new ApplyCommunicationStatus("APPLYING_CANNOT_APPLY", 3, 3);
            APPLYING_CANNOT_APPLY = r5;
            ApplyCommunicationStatus r7 = new ApplyCommunicationStatus("APPLYING_CAN_APPLY", 4, 4);
            APPLYING_CAN_APPLY = r7;
            ApplyCommunicationStatus r9 = new ApplyCommunicationStatus("CAN_NOT_APPLY", 5, 5);
            CAN_NOT_APPLY = r9;
            $VALUES = new ApplyCommunicationStatus[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(ApplyCommunicationStatus.class);
        }

        public static ApplyCommunicationStatus[] values() {
            return (ApplyCommunicationStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ApplyCommunicationStatus fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return CAN_NOT_APPLY;
        L18:
            return APPLYING_CAN_APPLY;
        L20:
            return APPLYING_CANNOT_APPLY;
        L22:
            return CAN_APPLY;
        L24:
            return PASS;
        L26:
            return APPLY_UNKNOWN;
        }

        public static ApplyCommunicationStatus valueOf(String r1) {
            return (ApplyCommunicationStatus) a.a(ApplyCommunicationStatus.class, r1);
        }

        private ApplyCommunicationStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum BlockStatus extends Enum<BlockStatus> implements WireEnum {
        private static final /* synthetic */ BlockStatus[] $VALUES = null;
        public static final ProtoAdapter<BlockStatus> ADAPTER = null;
        public static final BlockStatus B_Double = null;
        public static final BlockStatus B_Forward = null;
        public static final BlockStatus B_None = null;
        public static final BlockStatus B_Reverse = null;
        public static final BlockStatus B_UNKNOWN = null;
        private final int value;

        static {
            BlockStatus r0 = new BlockStatus("B_UNKNOWN", 0, 0);
            B_UNKNOWN = r0;
            BlockStatus r1 = new BlockStatus("B_None", 1, 1);
            B_None = r1;
            BlockStatus r3 = new BlockStatus("B_Forward", 2, 2);
            B_Forward = r3;
            BlockStatus r5 = new BlockStatus("B_Reverse", 3, 3);
            B_Reverse = r5;
            BlockStatus r7 = new BlockStatus("B_Double", 4, 4);
            B_Double = r7;
            $VALUES = new BlockStatus[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(BlockStatus.class);
        }

        public static BlockStatus[] values() {
            return (BlockStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BlockStatus fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return B_Double;
        L16:
            return B_Reverse;
        L18:
            return B_Forward;
        L20:
            return B_None;
        L22:
            return B_UNKNOWN;
        }

        public static BlockStatus valueOf(String r1) {
            return (BlockStatus) a.a(BlockStatus.class, r1);
        }

        private BlockStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<Profile, Builder> {
        public List<CTA> mctas;
        public List<Field> mfields;
        public List<TabInfo> mtabs;
        public UserInfo muser_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Profile m3011build() {
            return new Profile(this.muser_info, this.mctas, this.mfields, this.mtabs, super.buildUnknownFields());
        }

        public Builder() {
            this.mctas = Internal.newMutableList();
            this.mfields = Internal.newMutableList();
            this.mtabs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3011build();
        }

        public Builder ctas(List<CTA> r1) {
            Internal.checkElementsNotNull(r1);
            this.mctas = r1;
            return this;
        }

        public Builder fields(List<Field> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfields = r1;
            return this;
        }

        public Builder tabs(List<TabInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtabs = r1;
            return this;
        }

        public Builder user_info(UserInfo r1) {
            this.muser_info = r1;
            return this;
        }
    }

    public static final class CTA extends Message<CTA, Builder> {
        public static final ProtoAdapter<CTA> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_LINK = "";
        private static final long serialVersionUID = 0;
        public final CTAType mcta_type;
        public final I18nVal mdenied_description;
        public final com.ss.android.lark.pb.misc.DeniedReason mdenied_reason;
        public final DeniedReason mdeny_reason;
        public final Boolean menable;
        public final I18nVal mi18n_names;
        public final Image micon;
        public final String mkey;
        public final String mlink;
        public final List<CTA> msub_ctas;

        public static final class Builder extends Message.Builder<CTA, Builder> {
            public CTAType mcta_type;
            public I18nVal mdenied_description;
            public com.ss.android.lark.pb.misc.DeniedReason mdenied_reason;
            public DeniedReason mdeny_reason;
            public Boolean menable;
            public I18nVal mi18n_names;
            public Image micon;
            public String mkey;
            public String mlink;
            public List<CTA> msub_ctas;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CTA m3013build() {
                String r0 = this.mkey;
                if (r0 == null) goto L13;
                if (this.mi18n_names == null) goto L13;
                if (this.menable == null) goto L13;
                if (this.mcta_type == null) goto L13;
                return new CTA(this.mkey, this.mi18n_names, this.menable, this.mcta_type, this.micon, this.mlink, this.mdeny_reason, this.mdenied_reason, this.mdenied_description, this.msub_ctas, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r0, "mkey", this.mi18n_names, "mi18n_names", this.menable, "menable", this.mcta_type, "mcta_type"});
            }

            public Builder() {
                this.msub_ctas = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3013build();
            }

            public Builder cta_type(CTAType r1) {
                this.mcta_type = r1;
                return this;
            }

            public Builder denied_description(I18nVal r1) {
                this.mdenied_description = r1;
                return this;
            }

            public Builder denied_reason(com.ss.android.lark.pb.misc.DeniedReason r1) {
                this.mdenied_reason = r1;
                return this;
            }

            public Builder deny_reason(DeniedReason r1) {
                this.mdeny_reason = r1;
                return this;
            }

            public Builder enable(Boolean r1) {
                this.menable = r1;
                return this;
            }

            public Builder i18n_names(I18nVal r1) {
                this.mi18n_names = r1;
                return this;
            }

            public Builder icon(Image r1) {
                this.micon = r1;
                return this;
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }

            public Builder link(String r1) {
                this.mlink = r1;
                return this;
            }

            public Builder sub_ctas(List<CTA> r1) {
                Internal.checkElementsNotNull(r1);
                this.msub_ctas = r1;
                return this;
            }
        }

        public static final enum CTAType extends Enum<CTAType> implements WireEnum {
            private static final /* synthetic */ CTAType[] $VALUES = null;
            public static final ProtoAdapter<CTAType> ADAPTER = null;
            public static final CTAType LINK = null;
            public static final CTAType S_BLOCK_SETTING = null;
            public static final CTAType S_CHAT = null;
            public static final CTAType S_COLLABORATION_PERMISSION_SETTING = null;
            public static final CTAType S_CRYPTO_CHAT = null;
            public static final CTAType S_PRIVATE_MODE = null;
            public static final CTAType S_USER_CARD = null;
            public static final CTAType S_VIDEO = null;
            public static final CTAType S_VOICE = null;
            public static final CTAType S_VOICE_EPHONE = null;
            public static final CTAType S_VOICE_PHONE = null;
            public static final CTAType UNKNOWN = null;
            private final int value;

            static {
                CTAType r0 = new CTAType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                CTAType r1 = new CTAType("LINK", 1, 1);
                LINK = r1;
                CTAType r3 = new CTAType("S_CHAT", 2, 10);
                S_CHAT = r3;
                CTAType r5 = new CTAType("S_CRYPTO_CHAT", 3, 11);
                S_CRYPTO_CHAT = r5;
                CTAType r8 = new CTAType("S_VOICE", 4, 12);
                S_VOICE = r8;
                CTAType r11 = new CTAType("S_VIDEO", 5, 13);
                S_VIDEO = r11;
                CTAType r14 = new CTAType("S_USER_CARD", 6, 14);
                S_USER_CARD = r14;
                CTAType r12 = new CTAType("S_BLOCK_SETTING", 7, 15);
                S_BLOCK_SETTING = r12;
                CTAType r9 = new CTAType("S_COLLABORATION_PERMISSION_SETTING", 8, 16);
                S_COLLABORATION_PERMISSION_SETTING = r9;
                CTAType r6 = new CTAType("S_VOICE_EPHONE", 9, 17);
                S_VOICE_EPHONE = r6;
                CTAType r4 = new CTAType("S_VOICE_PHONE", 10, 18);
                S_VOICE_PHONE = r4;
                CTAType r2 = new CTAType("S_PRIVATE_MODE", 11, 19);
                S_PRIVATE_MODE = r2;
                $VALUES = new CTAType[]{r0, r1, r3, r5, r8, r11, r14, r12, r9, r6, r4, r2};
                ADAPTER = ProtoAdapter.newEnumAdapter(CTAType.class);
            }

            public static CTAType[] values() {
                return (CTAType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static CTAType fromValue(int r1) {
                if (r1 == 0) goto L31;
                if (r1 == 1) goto L29;
                switch(r1) {
                    case 10: goto L27;
                    case 11: goto L25;
                    case 12: goto L23;
                    case 13: goto L21;
                    case 14: goto L19;
                    case 15: goto L17;
                    case 16: goto L15;
                    case 17: goto L13;
                    case 18: goto L11;
                    case 19: goto L9;
                    default: goto L6;
                };
            L6:
                return null;
            L9:
                return S_PRIVATE_MODE;
            L11:
                return S_VOICE_PHONE;
            L13:
                return S_VOICE_EPHONE;
            L15:
                return S_COLLABORATION_PERMISSION_SETTING;
            L17:
                return S_BLOCK_SETTING;
            L19:
                return S_USER_CARD;
            L21:
                return S_VIDEO;
            L23:
                return S_VOICE;
            L25:
                return S_CRYPTO_CHAT;
            L27:
                return S_CHAT;
            L29:
                return LINK;
            L31:
                return UNKNOWN;
            }

            public static CTAType valueOf(String r1) {
                return (CTAType) a.a(CTAType.class, r1);
            }

            private CTAType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum DeniedReason extends Enum<DeniedReason> implements WireEnum {
            private static final /* synthetic */ DeniedReason[] $VALUES = null;
            public static final ProtoAdapter<DeniedReason> ADAPTER = null;
            public static final DeniedReason CROSS_TENANT_BLOCKED = null;
            public static final DeniedReason CROSS_TENANT_DENY = null;
            public static final DeniedReason SAME_TENANT_DENY = null;
            public static final DeniedReason UNKNOWN_REASON = null;
            private final int value;

            static {
                DeniedReason r0 = new DeniedReason("UNKNOWN_REASON", 0, 0);
                UNKNOWN_REASON = r0;
                DeniedReason r1 = new DeniedReason("CROSS_TENANT_BLOCKED", 1, 1);
                CROSS_TENANT_BLOCKED = r1;
                DeniedReason r3 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
                CROSS_TENANT_DENY = r3;
                DeniedReason r5 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
                SAME_TENANT_DENY = r5;
                $VALUES = new DeniedReason[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(DeniedReason.class);
            }

            public static DeniedReason[] values() {
                return (DeniedReason[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static DeniedReason fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return SAME_TENANT_DENY;
            L14:
                return CROSS_TENANT_DENY;
            L16:
                return CROSS_TENANT_BLOCKED;
            L18:
                return UNKNOWN_REASON;
            }

            public static DeniedReason valueOf(String r1) {
                return (DeniedReason) a.a(DeniedReason.class, r1);
            }

            private DeniedReason(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_CTA extends ProtoAdapter<CTA> {
            public ProtoAdapter_CTA() {
                super(FieldEncoding.LENGTH_DELIMITED, CTA.class);
            }

            public CTA decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                r0.menable = Boolean.FALSE;
                r0.mlink = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L26;
                switch(r3) {
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L30;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L32;
                    case 8: goto L28;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L28:
                r0.mdenied_reason = (com.ss.android.lark.pb.misc.DeniedReason) com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r0.mcta_type = (CTAType) CTAType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r0.mdeny_reason = (DeniedReason) DeniedReason.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.msub_ctas.add((CTA) CTA.ADAPTER.decode(r9));
                goto L3
            L8:
                r0.mdenied_description = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L17:
                r0.mlink = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L18:
                r0.micon = (Image) Image.ADAPTER.decode(r9);
                goto L3
            L23:
                r0.menable = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L24:
                r0.mi18n_names = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L25:
                r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L26:
                r9.endMessage(r1);
                return r0.m3013build();
            }

            public int encodedSize(CTA r8) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r8.mkey);
                ProtoAdapter<I18nVal> r2 = I18nVal.ADAPTER;
                int r3 = ((r1 + r2.encodedSizeWithTag(2, r8.mi18n_names)) + ProtoAdapter.BOOL.encodedSizeWithTag(3, r8.menable)) + CTAType.ADAPTER.encodedSizeWithTag(4, r8.mcta_type);
                Image r4 = r8.micon;
                int r5 = 0;
                if (r4 == null) goto L5;
                int r6 = Image.ADAPTER.encodedSizeWithTag(5, r4);
            L6:
                int r7 = r3 + r6;
                String r9 = r8.mlink;
                if (r9 == null) goto L9;
                int r10 = r0.encodedSizeWithTag(6, r9);
            L10:
                int r11 = r7 + r10;
                DeniedReason r12 = r8.mdeny_reason;
                if (r12 == null) goto L13;
                int r13 = DeniedReason.ADAPTER.encodedSizeWithTag(7, r12);
            L14:
                int r14 = r11 + r13;
                com.ss.android.lark.pb.misc.DeniedReason r15 = r8.mdenied_reason;
                if (r15 == null) goto L17;
                int r16 = com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.encodedSizeWithTag(8, r15);
            L18:
                int r17 = r14 + r16;
                I18nVal r18 = r8.mdenied_description;
                if (r18 == null) goto L22;
                r5 = r2.encodedSizeWithTag(9, r18);
            L22:
                return ((r17 + r5) + CTA.ADAPTER.asRepeated().encodedSizeWithTag(10, r8.msub_ctas)) + r8.unknownFields().size();
            L17:
                r16 = 0;
                goto L18
            L13:
                r13 = 0;
                goto L14
            L9:
                r10 = 0;
                goto L10
            L5:
                r6 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3014decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CTA) r1);
            }

            public void encode(ProtoWriter r6, CTA r7) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r6, 1, r7.mkey);
                ProtoAdapter<I18nVal> r1 = I18nVal.ADAPTER;
                r1.encodeWithTag(r6, 2, r7.mi18n_names);
                ProtoAdapter.BOOL.encodeWithTag(r6, 3, r7.menable);
                CTAType.ADAPTER.encodeWithTag(r6, 4, r7.mcta_type);
                Image r2 = r7.micon;
                if (r2 == null) goto L5;
                Image.ADAPTER.encodeWithTag(r6, 5, r2);
            L5:
                String r3 = r7.mlink;
                if (r3 == null) goto L8;
                r0.encodeWithTag(r6, 6, r3);
            L8:
                DeniedReason r4 = r7.mdeny_reason;
                if (r4 == null) goto L11;
                DeniedReason.ADAPTER.encodeWithTag(r6, 7, r4);
            L11:
                com.ss.android.lark.pb.misc.DeniedReason r5 = r7.mdenied_reason;
                if (r5 == null) goto L14;
                com.ss.android.lark.pb.misc.DeniedReason.ADAPTER.encodeWithTag(r6, 8, r5);
            L14:
                I18nVal r8 = r7.mdenied_description;
                if (r8 == null) goto L17;
                r1.encodeWithTag(r6, 9, r8);
            L17:
                CTA.ADAPTER.asRepeated().encodeWithTag(r6, 10, r7.msub_ctas);
                r6.writeBytes(r7.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CTA) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CTA();
            DEFAULT_ENABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3012newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.mi18n_names = this.mi18n_names;
            r0.menable = this.menable;
            r0.mcta_type = this.mcta_type;
            r0.micon = this.micon;
            r0.mlink = this.mlink;
            r0.mdeny_reason = this.mdeny_reason;
            r0.mdenied_reason = this.mdenied_reason;
            r0.mdenied_description = this.mdenied_description;
            r0.msub_ctas = Internal.copyOf("msub_ctas", this.msub_ctas);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CTA.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3012newBuilder();
        }

        public CTA(String r13, I18nVal r14, Boolean r15, CTAType r16, Image r17, String r18, DeniedReason r19, com.ss.android.lark.pb.misc.DeniedReason r20, I18nVal r21, List<CTA> r22) {
            this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
        }

        public CTA(String r2, I18nVal r3, Boolean r4, CTAType r5, Image r6, String r7, DeniedReason r8, com.ss.android.lark.pb.misc.DeniedReason r9, I18nVal r10, List<CTA> r11, ByteString r12) {
            super(ADAPTER, r12);
            this.mkey = r2;
            this.mi18n_names = r3;
            this.menable = r4;
            this.mcta_type = r5;
            this.micon = r6;
            this.mlink = r7;
            this.mdeny_reason = r8;
            this.mdenied_reason = r9;
            this.mdenied_description = r10;
            this.msub_ctas = Internal.immutableCopyOf("msub_ctas", r11);
        }
    }

    public static final enum CertificateStatus extends Enum<CertificateStatus> implements WireEnum {
        private static final /* synthetic */ CertificateStatus[] $VALUES = null;
        public static final ProtoAdapter<CertificateStatus> ADAPTER = null;
        public static final CertificateStatus CERTIFICATED = null;
        public static final CertificateStatus EXPIRED = null;
        public static final CertificateStatus TEAM_CERTIFICATED = null;
        public static final CertificateStatus UNCERTIFICATED = null;
        private final int value;

        static {
            CertificateStatus r0 = new CertificateStatus("UNCERTIFICATED", 0, 0);
            UNCERTIFICATED = r0;
            CertificateStatus r1 = new CertificateStatus("CERTIFICATED", 1, 1);
            CERTIFICATED = r1;
            CertificateStatus r3 = new CertificateStatus("EXPIRED", 2, 2);
            EXPIRED = r3;
            CertificateStatus r5 = new CertificateStatus("TEAM_CERTIFICATED", 3, 3);
            TEAM_CERTIFICATED = r5;
            $VALUES = new CertificateStatus[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(CertificateStatus.class);
        }

        public static CertificateStatus[] values() {
            return (CertificateStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CertificateStatus fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return TEAM_CERTIFICATED;
        L14:
            return EXPIRED;
        L16:
            return CERTIFICATED;
        L18:
            return UNCERTIFICATED;
        }

        public static CertificateStatus valueOf(String r1) {
            return (CertificateStatus) a.a(CertificateStatus.class, r1);
        }

        private CertificateStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class CertificationInfo extends Message<CertificationInfo, Builder> {
        public static final ProtoAdapter<CertificationInfo> ADAPTER = null;
        public static final Boolean DEFAULT_IS_SHOW_CERT_SIGN = null;
        public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
        private static final long serialVersionUID = 0;
        public final CertificateStatus mcertificate_status;
        public final Boolean mis_show_cert_sign;
        public final String mtenant_certification_url;

        public static final class Builder extends Message.Builder<CertificationInfo, Builder> {
            public CertificateStatus mcertificate_status;
            public Boolean mis_show_cert_sign;
            public String mtenant_certification_url;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CertificationInfo m3016build() {
                return new CertificationInfo(this.mis_show_cert_sign, this.mcertificate_status, this.mtenant_certification_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3016build();
            }

            public Builder certificate_status(CertificateStatus r1) {
                this.mcertificate_status = r1;
                return this;
            }

            public Builder is_show_cert_sign(Boolean r1) {
                this.mis_show_cert_sign = r1;
                return this;
            }

            public Builder tenant_certification_url(String r1) {
                this.mtenant_certification_url = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CertificationInfo extends ProtoAdapter<CertificationInfo> {
            public ProtoAdapter_CertificationInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CertificationInfo.class);
            }

            public CertificationInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_show_cert_sign = Boolean.FALSE;
                r0.mtenant_certification_url = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mis_show_cert_sign = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcertificate_status = (CertificateStatus) CertificateStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mtenant_certification_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m3016build();
            }

            public int encodedSize(CertificationInfo r6) {
                Boolean r0 = r6.mis_show_cert_sign;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                CertificateStatus r3 = r6.mcertificate_status;
                if (r3 == null) goto L9;
                int r4 = CertificateStatus.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mtenant_certification_url;
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
            public /* bridge */ /* synthetic */ Object m3017decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CertificationInfo) r1);
            }

            public void encode(ProtoWriter r4, CertificationInfo r5) throws IOException {
                Boolean r0 = r5.mis_show_cert_sign;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                CertificateStatus r1 = r5.mcertificate_status;
                if (r1 == null) goto L8;
                CertificateStatus.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mtenant_certification_url;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CertificationInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CertificationInfo();
            DEFAULT_IS_SHOW_CERT_SIGN = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3015newBuilder() {
            Builder r0 = new Builder();
            r0.mis_show_cert_sign = this.mis_show_cert_sign;
            r0.mcertificate_status = this.mcertificate_status;
            r0.mtenant_certification_url = this.mtenant_certification_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CertificationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3015newBuilder();
        }

        public CertificationInfo(Boolean r2, CertificateStatus r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public CertificationInfo(Boolean r2, CertificateStatus r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mis_show_cert_sign = r2;
            this.mcertificate_status = r3;
            this.mtenant_certification_url = r4;
        }
    }

    public static final class CustomImage extends Message<CustomImage, Builder> {
        public static final ProtoAdapter<CustomImage> ADAPTER = null;
        public static final String DEFAULT_FS_UNIT = "";
        public static final String DEFAULT_RESOURCE_KEY = "";
        public static final String DEFAULT_RESOURCE_URL = "";
        private static final long serialVersionUID = 0;
        public final String mfs_unit;
        public final String mresource_key;
        public final String mresource_url;

        public static final class Builder extends Message.Builder<CustomImage, Builder> {
            public String mfs_unit;
            public String mresource_key;
            public String mresource_url;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CustomImage m3019build() {
                return new CustomImage(this.mresource_key, this.mfs_unit, this.mresource_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3019build();
            }

            public Builder fs_unit(String r1) {
                this.mfs_unit = r1;
                return this;
            }

            public Builder resource_key(String r1) {
                this.mresource_key = r1;
                return this;
            }

            public Builder resource_url(String r1) {
                this.mresource_url = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomImage extends ProtoAdapter<CustomImage> {
            public ProtoAdapter_CustomImage() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomImage.class);
            }

            public CustomImage decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mresource_key = "";
                r0.mfs_unit = "";
                r0.mresource_url = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mresource_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mresource_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3019build();
            }

            public int encodedSize(CustomImage r6) {
                String r0 = r6.mresource_key;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mfs_unit;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mresource_url;
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
            public /* bridge */ /* synthetic */ Object m3020decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CustomImage) r1);
            }

            public void encode(ProtoWriter r4, CustomImage r5) throws IOException {
                String r0 = r5.mresource_key;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mfs_unit;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mresource_url;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CustomImage) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomImage();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3018newBuilder() {
            Builder r0 = new Builder();
            r0.mresource_key = this.mresource_key;
            r0.mfs_unit = this.mfs_unit;
            r0.mresource_url = this.mresource_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CustomImage.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3018newBuilder();
        }

        public CustomImage(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public CustomImage(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mresource_key = r2;
            this.mfs_unit = r3;
            this.mresource_url = r4;
        }
    }

    public static final class CustomPhone extends Message<CustomPhone, Builder> {
        public static final ProtoAdapter<CustomPhone> ADAPTER = null;
        public static final String DEFAULT_EXTENSION_NUMBER = "";
        public static final String DEFAULT_PHONE_NUMBER = "";
        private static final long serialVersionUID = 0;
        public final String mextension_number;
        public final String mphone_number;

        public static final class Builder extends Message.Builder<CustomPhone, Builder> {
            public String mextension_number;
            public String mphone_number;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CustomPhone m3022build() {
                return new CustomPhone(this.mphone_number, this.mextension_number, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3022build();
            }

            public Builder extension_number(String r1) {
                this.mextension_number = r1;
                return this;
            }

            public Builder phone_number(String r1) {
                this.mphone_number = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomPhone extends ProtoAdapter<CustomPhone> {
            public ProtoAdapter_CustomPhone() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomPhone.class);
            }

            public CustomPhone decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mphone_number = "";
                r0.mextension_number = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mphone_number = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mextension_number = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3022build();
            }

            public int encodedSize(CustomPhone r5) {
                String r0 = r5.mphone_number;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mextension_number;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3023decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CustomPhone) r1);
            }

            public void encode(ProtoWriter r4, CustomPhone r5) throws IOException {
                String r0 = r5.mphone_number;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mextension_number;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CustomPhone) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomPhone();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3021newBuilder() {
            Builder r0 = new Builder();
            r0.mphone_number = this.mphone_number;
            r0.mextension_number = this.mextension_number;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CustomPhone.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3021newBuilder();
        }

        public CustomPhone(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public CustomPhone(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mphone_number = r2;
            this.mextension_number = r3;
        }
    }

    public static final class Department extends Message<Department, Builder> {
        public static final ProtoAdapter<Department> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<DepartmentPath> mdepartment_paths;
        public final GroupedManagedDepartments mgrouped_managed_departments;

        public static final class Builder extends Message.Builder<Department, Builder> {
            public List<DepartmentPath> mdepartment_paths;
            public GroupedManagedDepartments mgrouped_managed_departments;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Department m3025build() {
                return new Department(this.mdepartment_paths, this.mgrouped_managed_departments, super.buildUnknownFields());
            }

            public Builder() {
                this.mdepartment_paths = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3025build();
            }

            public Builder department_paths(List<DepartmentPath> r1) {
                Internal.checkElementsNotNull(r1);
                this.mdepartment_paths = r1;
                return this;
            }

            public Builder grouped_managed_departments(GroupedManagedDepartments r1) {
                this.mgrouped_managed_departments = r1;
                return this;
            }
        }

        public static final class DepartmentPath extends Message<DepartmentPath, Builder> {
            public static final ProtoAdapter<DepartmentPath> ADAPTER = null;
            public static final Boolean DEFAULT_ACCESSIBLE = null;
            public static final String DEFAULT_REDIRECT_LINK = "";
            private static final long serialVersionUID = 0;
            public final Boolean maccessible;
            public final List<DepartmentNode> mdepartment_nodes;
            public final I18nVal mno_access_description;
            public final String mredirect_link;

            public static final class Builder extends Message.Builder<DepartmentPath, Builder> {
                public Boolean maccessible;
                public List<DepartmentNode> mdepartment_nodes;
                public I18nVal mno_access_description;
                public String mredirect_link;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public DepartmentPath m3027build() {
                    return new DepartmentPath(this.mdepartment_nodes, this.maccessible, this.mredirect_link, this.mno_access_description, super.buildUnknownFields());
                }

                public Builder() {
                    this.mdepartment_nodes = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m3027build();
                }

                public Builder accessible(Boolean r1) {
                    this.maccessible = r1;
                    return this;
                }

                public Builder department_nodes(List<DepartmentNode> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mdepartment_nodes = r1;
                    return this;
                }

                public Builder no_access_description(I18nVal r1) {
                    this.mno_access_description = r1;
                    return this;
                }

                public Builder redirect_link(String r1) {
                    this.mredirect_link = r1;
                    return this;
                }
            }

            public static final class DepartmentNode extends Message<DepartmentNode, Builder> {
                public static final ProtoAdapter<DepartmentNode> ADAPTER = null;
                public static final String DEFAULT_DEPARTMENT_ID = "";
                private static final long serialVersionUID = 0;
                public final String mdepartment_id;
                public final I18nVal mdepartment_name;

                public static final class Builder extends Message.Builder<DepartmentNode, Builder> {
                    public String mdepartment_id;
                    public I18nVal mdepartment_name;

                    /* JADX INFO: renamed from: build, reason: collision with other method in class */
                    public DepartmentNode m3029build() {
                        return new DepartmentNode(this.mdepartment_name, this.mdepartment_id, super.buildUnknownFields());
                    }

                    public Builder() {
                    }

                    public /* bridge */ /* synthetic */ Message build() {
                        return m3029build();
                    }

                    public Builder department_id(String r1) {
                        this.mdepartment_id = r1;
                        return this;
                    }

                    public Builder department_name(I18nVal r1) {
                        this.mdepartment_name = r1;
                        return this;
                    }
                }

                public static final class ProtoAdapter_DepartmentNode extends ProtoAdapter<DepartmentNode> {
                    public ProtoAdapter_DepartmentNode() {
                        super(FieldEncoding.LENGTH_DELIMITED, DepartmentNode.class);
                    }

                    public DepartmentNode decode(ProtoReader r7) throws IOException {
                        Builder r0 = new Builder();
                        r0.mdepartment_id = "";
                        long r1 = r7.beginMessage();
                    L3:
                        int r3 = r7.nextTag();
                        if (r3 == (-1)) goto L12;
                        if (r3 != 1) goto L8;
                        r0.mdepartment_name = (I18nVal) I18nVal.ADAPTER.decode(r7);
                        goto L3
                    L8:
                        if (r3 != 2) goto L9;
                        r0.mdepartment_id = (String) ProtoAdapter.STRING.decode(r7);
                        goto L3
                    L9:
                        FieldEncoding r4 = r7.peekFieldEncoding();
                        r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                        goto L3
                    L12:
                        r7.endMessage(r1);
                        return r0.m3029build();
                    }

                    public int encodedSize(DepartmentNode r5) {
                        I18nVal r0 = r5.mdepartment_name;
                        int r1 = 0;
                        if (r0 == null) goto L5;
                        int r2 = I18nVal.ADAPTER.encodedSizeWithTag(1, r0);
                    L6:
                        String r3 = r5.mdepartment_id;
                        if (r3 == null) goto L10;
                        r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                    L10:
                        return (r2 + r1) + r5.unknownFields().size();
                    L5:
                        r2 = 0;
                        goto L6
                    }

                    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                    public /* bridge */ /* synthetic */ Object m3030decode(ProtoReader r1) throws IOException {
                        return decode(r1);
                    }

                    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                        return encodedSize((DepartmentNode) r1);
                    }

                    public void encode(ProtoWriter r4, DepartmentNode r5) throws IOException {
                        I18nVal r0 = r5.mdepartment_name;
                        if (r0 == null) goto L5;
                        I18nVal.ADAPTER.encodeWithTag(r4, 1, r0);
                    L5:
                        String r1 = r5.mdepartment_id;
                        if (r1 == null) goto L8;
                        ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                    L8:
                        r4.writeBytes(r5.unknownFields());
                    }

                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                        encode(r1, (DepartmentNode) r2);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_DepartmentNode();
                }

                /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
                public Builder m3028newBuilder() {
                    Builder r0 = new Builder();
                    r0.mdepartment_name = this.mdepartment_name;
                    r0.mdepartment_id = this.mdepartment_id;
                    r0.addUnknownFields(unknownFields());
                    return r0;
                }

                public String toString() {
                    return DepartmentNode.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return m3028newBuilder();
                }

                public DepartmentNode(I18nVal r2, String r3) {
                    this(r2, r3, ByteString.EMPTY);
                }

                public DepartmentNode(I18nVal r2, String r3, ByteString r4) {
                    super(ADAPTER, r4);
                    this.mdepartment_name = r2;
                    this.mdepartment_id = r3;
                }
            }

            public static final class ProtoAdapter_DepartmentPath extends ProtoAdapter<DepartmentPath> {
                public ProtoAdapter_DepartmentPath() {
                    super(FieldEncoding.LENGTH_DELIMITED, DepartmentPath.class);
                }

                public DepartmentPath decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.maccessible = Boolean.FALSE;
                    r0.mredirect_link = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L18;
                    if (r3 != 1) goto L8;
                    r0.mdepartment_nodes.add((DepartmentNode) DepartmentNode.ADAPTER.decode(r7));
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.maccessible = (Boolean) ProtoAdapter.BOOL.decode(r7);
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.mredirect_link = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.mno_access_description = (I18nVal) I18nVal.ADAPTER.decode(r7);
                    goto L3
                L13:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L18:
                    r7.endMessage(r1);
                    return r0.m3027build();
                }

                public int encodedSize(DepartmentPath r6) {
                    int r0 = DepartmentNode.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mdepartment_nodes);
                    Boolean r1 = r6.maccessible;
                    int r2 = 0;
                    if (r1 == null) goto L5;
                    int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
                L6:
                    int r4 = r0 + r3;
                    String r5 = r6.mredirect_link;
                    if (r5 == null) goto L9;
                    int r7 = ProtoAdapter.STRING.encodedSizeWithTag(3, r5);
                L10:
                    int r8 = r4 + r7;
                    I18nVal r9 = r6.mno_access_description;
                    if (r9 == null) goto L14;
                    r2 = I18nVal.ADAPTER.encodedSizeWithTag(4, r9);
                L14:
                    return (r8 + r2) + r6.unknownFields().size();
                L9:
                    r7 = 0;
                    goto L10
                L5:
                    r3 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m3031decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((DepartmentPath) r1);
                }

                public void encode(ProtoWriter r4, DepartmentPath r5) throws IOException {
                    DepartmentNode.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mdepartment_nodes);
                    Boolean r0 = r5.maccessible;
                    if (r0 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
                L5:
                    String r1 = r5.mredirect_link;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 3, r1);
                L8:
                    I18nVal r2 = r5.mno_access_description;
                    if (r2 == null) goto L11;
                    I18nVal.ADAPTER.encodeWithTag(r4, 4, r2);
                L11:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (DepartmentPath) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DepartmentPath();
                DEFAULT_ACCESSIBLE = Boolean.FALSE;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m3026newBuilder() {
                Builder r0 = new Builder();
                r0.mdepartment_nodes = Internal.copyOf("mdepartment_nodes", this.mdepartment_nodes);
                r0.maccessible = this.maccessible;
                r0.mredirect_link = this.mredirect_link;
                r0.mno_access_description = this.mno_access_description;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return DepartmentPath.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m3026newBuilder();
            }

            public DepartmentPath(List<DepartmentNode> r7, Boolean r8, String r9, I18nVal r10) {
                this(r7, r8, r9, r10, ByteString.EMPTY);
            }

            public DepartmentPath(List<DepartmentNode> r2, Boolean r3, String r4, I18nVal r5, ByteString r6) {
                super(ADAPTER, r6);
                this.mdepartment_nodes = Internal.immutableCopyOf("mdepartment_nodes", r2);
                this.maccessible = r3;
                this.mredirect_link = r4;
                this.mno_access_description = r5;
            }
        }

        public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
            public ProtoAdapter_Department() {
                super(FieldEncoding.LENGTH_DELIMITED, Department.class);
            }

            public Department decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mdepartment_paths.add((DepartmentPath) DepartmentPath.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mgrouped_managed_departments = (GroupedManagedDepartments) GroupedManagedDepartments.ADAPTER.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3025build();
            }

            public int encodedSize(Department r5) {
                int r0 = DepartmentPath.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mdepartment_paths);
                GroupedManagedDepartments r1 = r5.mgrouped_managed_departments;
                if (r1 == null) goto L5;
                int r2 = GroupedManagedDepartments.ADAPTER.encodedSizeWithTag(2, r1);
            L7:
                return (r0 + r2) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3032decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Department) r1);
            }

            public void encode(ProtoWriter r4, Department r5) throws IOException {
                DepartmentPath.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mdepartment_paths);
                GroupedManagedDepartments r0 = r5.mgrouped_managed_departments;
                if (r0 == null) goto L5;
                GroupedManagedDepartments.ADAPTER.encodeWithTag(r4, 2, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Department) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Department();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3024newBuilder() {
            Builder r0 = new Builder();
            r0.mdepartment_paths = Internal.copyOf("mdepartment_paths", this.mdepartment_paths);
            r0.mgrouped_managed_departments = this.mgrouped_managed_departments;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Department.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3024newBuilder();
        }

        public Department(List<DepartmentPath> r2, GroupedManagedDepartments r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Department(List<DepartmentPath> r2, GroupedManagedDepartments r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mdepartment_paths = Internal.immutableCopyOf("mdepartment_paths", r2);
            this.mgrouped_managed_departments = r3;
        }
    }

    public static final class Field extends Message<Field, Builder> {
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Boolean DEFAULT_EDITABLE = null;
        public static final ByteString DEFAULT_FIELD_VAL = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_STR_FIELD_VAL = "";
        public static final Boolean DEFAULT_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final Boolean meditable;
        public final ByteString mfield_val;
        public final FieldValueType mfield_value_type;
        public final I18nVal mi18n_names;
        public final I18nVal mi18n_tip;
        public final String mkey;
        public final String mstr_field_val;
        public final UserFieldSource muser_field_source;
        public final Boolean mvisible;

        public static final class Builder extends Message.Builder<Field, Builder> {
            public Boolean meditable;
            public ByteString mfield_val;
            public FieldValueType mfield_value_type;
            public I18nVal mi18n_names;
            public I18nVal mi18n_tip;
            public String mkey;
            public String mstr_field_val;
            public UserFieldSource muser_field_source;
            public Boolean mvisible;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Field m3034build() {
                String r0 = this.mkey;
                if (r0 == null) goto L13;
                if (this.mi18n_names == null) goto L13;
                if (this.mvisible == null) goto L13;
                if (this.mfield_value_type == null) goto L13;
                return new Field(this.mkey, this.mi18n_names, this.mvisible, this.mfield_value_type, this.mfield_val, this.mstr_field_val, this.meditable, this.muser_field_source, this.mi18n_tip, super.buildUnknownFields());
            L13:
                throw Internal.missingRequiredFields(new Object[]{r0, "mkey", this.mi18n_names, "mi18n_names", this.mvisible, "mvisible", this.mfield_value_type, "mfield_value_type"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3034build();
            }

            public Builder editable(Boolean r1) {
                this.meditable = r1;
                return this;
            }

            public Builder field_val(ByteString r1) {
                this.mfield_val = r1;
                return this;
            }

            public Builder field_value_type(FieldValueType r1) {
                this.mfield_value_type = r1;
                return this;
            }

            public Builder i18n_names(I18nVal r1) {
                this.mi18n_names = r1;
                return this;
            }

            public Builder i18n_tip(I18nVal r1) {
                this.mi18n_tip = r1;
                return this;
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }

            public Builder str_field_val(String r1) {
                this.mstr_field_val = r1;
                return this;
            }

            public Builder user_field_source(UserFieldSource r1) {
                this.muser_field_source = r1;
                return this;
            }

            public Builder visible(Boolean r1) {
                this.mvisible = r1;
                return this;
            }
        }

        public static final enum FieldValueType extends Enum<FieldValueType> implements WireEnum {
            private static final /* synthetic */ FieldValueType[] $VALUES = null;
            public static final ProtoAdapter<FieldValueType> ADAPTER = null;
            public static final FieldValueType ALIAS_AND_MEMO = null;
            public static final FieldValueType CUSTOM_FIELD_IMAGE = null;
            public static final FieldValueType CUSTOM_PHONE = null;
            public static final FieldValueType C_ALIAS = null;
            public static final FieldValueType ENUMERATION = null;
            public static final FieldValueType GENERIC_USER = null;
            public static final FieldValueType LINK = null;
            public static final FieldValueType LINK_LIST = null;
            public static final FieldValueType MEMO_DESCRIPTION = null;
            public static final FieldValueType S_DEPARTMENT = null;
            public static final FieldValueType S_FRIEND_LINK = null;
            public static final FieldValueType S_PHONE_NUMBER = null;
            public static final FieldValueType TEXT = null;
            public static final FieldValueType TEXT_LIST = null;
            public static final FieldValueType UNKNOWN = null;
            private final int value;

            static {
                FieldValueType r0 = new FieldValueType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                FieldValueType r1 = new FieldValueType("TEXT", 1, 1);
                TEXT = r1;
                FieldValueType r3 = new FieldValueType("LINK", 2, 2);
                LINK = r3;
                FieldValueType r5 = new FieldValueType("TEXT_LIST", 3, 3);
                TEXT_LIST = r5;
                FieldValueType r7 = new FieldValueType("LINK_LIST", 4, 4);
                LINK_LIST = r7;
                FieldValueType r9 = new FieldValueType("ENUMERATION", 5, 5);
                ENUMERATION = r9;
                FieldValueType r11 = new FieldValueType("GENERIC_USER", 6, 6);
                GENERIC_USER = r11;
                FieldValueType r13 = new FieldValueType("CUSTOM_PHONE", 7, 9);
                CUSTOM_PHONE = r13;
                FieldValueType r15 = new FieldValueType("C_ALIAS", 8, 50);
                C_ALIAS = r15;
                FieldValueType r10 = new FieldValueType("S_DEPARTMENT", 9, 100);
                S_DEPARTMENT = r10;
                FieldValueType r8 = new FieldValueType("S_PHONE_NUMBER", 10, BaseField.FIELD_TYPE_S_PHONE_NUMBER);
                S_PHONE_NUMBER = r8;
                FieldValueType r12 = new FieldValueType("S_FRIEND_LINK", 11, BaseField.FIELD_TYPE_S_FRIEND_LINK);
                S_FRIEND_LINK = r12;
                FieldValueType r6 = new FieldValueType("CUSTOM_FIELD_IMAGE", 12, 103);
                CUSTOM_FIELD_IMAGE = r6;
                FieldValueType r4 = new FieldValueType("ALIAS_AND_MEMO", 13, BaseField.FIELD_TYPE_ALIAS_AND_MEMO);
                ALIAS_AND_MEMO = r4;
                FieldValueType r2 = new FieldValueType("MEMO_DESCRIPTION", 14, BaseField.FIELD_TYPE_MEMO_DESCRIPTION);
                MEMO_DESCRIPTION = r2;
                $VALUES = new FieldValueType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r10, r8, r12, r6, r4, r2};
                ADAPTER = ProtoAdapter.newEnumAdapter(FieldValueType.class);
            }

            public static FieldValueType[] values() {
                return (FieldValueType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static FieldValueType fromValue(int r1) {
                if (r1 == 9) goto L39;
                if (r1 == 50) goto L37;
                switch(r1) {
                    case 0: goto L35;
                    case 1: goto L33;
                    case 2: goto L31;
                    case 3: goto L29;
                    case 4: goto L27;
                    case 5: goto L25;
                    case 6: goto L23;
                    default: goto L7;
                };
            L7:
                switch(r1) {
                    case 100: goto L21;
                    case 101: goto L19;
                    case 102: goto L17;
                    case 103: goto L15;
                    case 104: goto L13;
                    case 105: goto L11;
                    default: goto L8;
                };
            L8:
                return null;
            L11:
                return MEMO_DESCRIPTION;
            L13:
                return ALIAS_AND_MEMO;
            L15:
                return CUSTOM_FIELD_IMAGE;
            L17:
                return S_FRIEND_LINK;
            L19:
                return S_PHONE_NUMBER;
            L21:
                return S_DEPARTMENT;
            L23:
                return GENERIC_USER;
            L25:
                return ENUMERATION;
            L27:
                return LINK_LIST;
            L29:
                return TEXT_LIST;
            L31:
                return LINK;
            L33:
                return TEXT;
            L35:
                return UNKNOWN;
            L37:
                return C_ALIAS;
            L39:
                return CUSTOM_PHONE;
            }

            public static FieldValueType valueOf(String r1) {
                return (FieldValueType) a.a(FieldValueType.class, r1);
            }

            private FieldValueType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_Field extends ProtoAdapter<Field> {
            public ProtoAdapter_Field() {
                super(FieldEncoding.LENGTH_DELIMITED, Field.class);
            }

            public Field decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                Boolean r2 = Boolean.FALSE;
                r0.mvisible = r2;
                r0.mfield_val = ByteString.EMPTY;
                r0.mstr_field_val = "";
                r0.meditable = r2;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L22;
                switch(r3) {
                    case 1: goto L21;
                    case 2: goto L20;
                    case 3: goto L19;
                    case 4: goto L6;
                    case 5: goto L24;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L26;
                    case 10: goto L7;
                    default: goto L6;
                };
            L24:
                r0.mfield_value_type = (FieldValueType) FieldValueType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L26:
                r0.muser_field_source = (UserFieldSource) UserFieldSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mi18n_tip = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L12:
                r0.meditable = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mstr_field_val = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L14:
                r0.mfield_val = (ByteString) ProtoAdapter.BYTES.decode(r9);
                goto L3
            L19:
                r0.mvisible = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L20:
                r0.mi18n_names = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L21:
                r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L22:
                r9.endMessage(r1);
                return r0.m3034build();
            }

            public int encodedSize(Field r9) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = r0.encodedSizeWithTag(1, r9.mkey);
                ProtoAdapter<I18nVal> r2 = I18nVal.ADAPTER;
                int r3 = r1 + r2.encodedSizeWithTag(2, r9.mi18n_names);
                ProtoAdapter r4 = ProtoAdapter.BOOL;
                int r5 = (r3 + r4.encodedSizeWithTag(3, r9.mvisible)) + FieldValueType.ADAPTER.encodedSizeWithTag(5, r9.mfield_value_type);
                ByteString r6 = r9.mfield_val;
                int r7 = 0;
                if (r6 == null) goto L5;
                int r8 = ProtoAdapter.BYTES.encodedSizeWithTag(6, r6);
            L6:
                int r10 = r5 + r8;
                String r11 = r9.mstr_field_val;
                if (r11 == null) goto L9;
                int r12 = r0.encodedSizeWithTag(7, r11);
            L10:
                int r13 = r10 + r12;
                Boolean r14 = r9.meditable;
                if (r14 == null) goto L13;
                int r15 = r4.encodedSizeWithTag(8, r14);
            L14:
                int r16 = r13 + r15;
                UserFieldSource r17 = r9.muser_field_source;
                if (r17 == null) goto L17;
                int r18 = UserFieldSource.ADAPTER.encodedSizeWithTag(9, r17);
            L18:
                int r19 = r16 + r18;
                I18nVal r20 = r9.mi18n_tip;
                if (r20 == null) goto L22;
                r7 = r2.encodedSizeWithTag(10, r20);
            L22:
                return (r19 + r7) + r9.unknownFields().size();
            L17:
                r18 = 0;
                goto L18
            L13:
                r15 = 0;
                goto L14
            L9:
                r12 = 0;
                goto L10
            L5:
                r8 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3035decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Field) r1);
            }

            public void encode(ProtoWriter r7, Field r8) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r7, 1, r8.mkey);
                ProtoAdapter<I18nVal> r1 = I18nVal.ADAPTER;
                r1.encodeWithTag(r7, 2, r8.mi18n_names);
                ProtoAdapter r2 = ProtoAdapter.BOOL;
                r2.encodeWithTag(r7, 3, r8.mvisible);
                FieldValueType.ADAPTER.encodeWithTag(r7, 5, r8.mfield_value_type);
                ByteString r3 = r8.mfield_val;
                if (r3 == null) goto L5;
                ProtoAdapter.BYTES.encodeWithTag(r7, 6, r3);
            L5:
                String r4 = r8.mstr_field_val;
                if (r4 == null) goto L8;
                r0.encodeWithTag(r7, 7, r4);
            L8:
                Boolean r5 = r8.meditable;
                if (r5 == null) goto L11;
                r2.encodeWithTag(r7, 8, r5);
            L11:
                UserFieldSource r6 = r8.muser_field_source;
                if (r6 == null) goto L14;
                UserFieldSource.ADAPTER.encodeWithTag(r7, 9, r6);
            L14:
                I18nVal r9 = r8.mi18n_tip;
                if (r9 == null) goto L17;
                r1.encodeWithTag(r7, 10, r9);
            L17:
                r7.writeBytes(r8.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Field) r2);
            }
        }

        public static final enum UserFieldSource extends Enum<UserFieldSource> implements WireEnum {
            private static final /* synthetic */ UserFieldSource[] $VALUES = null;
            public static final ProtoAdapter<UserFieldSource> ADAPTER = null;
            public static final UserFieldSource UserFieldSource_BUILTIN = null;
            public static final UserFieldSource UserFieldSource_CUSTOM = null;
            private final int value;

            static {
                UserFieldSource r0 = new UserFieldSource("UserFieldSource_BUILTIN", 0, 1);
                UserFieldSource_BUILTIN = r0;
                UserFieldSource r1 = new UserFieldSource("UserFieldSource_CUSTOM", 1, 2);
                UserFieldSource_CUSTOM = r1;
                $VALUES = new UserFieldSource[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(UserFieldSource.class);
            }

            public static UserFieldSource[] values() {
                return (UserFieldSource[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static UserFieldSource fromValue(int r1) {
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L9;
                return null;
            L9:
                return UserFieldSource_CUSTOM;
            L11:
                return UserFieldSource_BUILTIN;
            }

            public static UserFieldSource valueOf(String r1) {
                return (UserFieldSource) a.a(UserFieldSource.class, r1);
            }

            private UserFieldSource(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Field();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_VISIBLE = r0;
            DEFAULT_FIELD_VAL = ByteString.EMPTY;
            DEFAULT_EDITABLE = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3033newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.mi18n_names = this.mi18n_names;
            r0.mvisible = this.mvisible;
            r0.mfield_value_type = this.mfield_value_type;
            r0.mfield_val = this.mfield_val;
            r0.mstr_field_val = this.mstr_field_val;
            r0.meditable = this.meditable;
            r0.muser_field_source = this.muser_field_source;
            r0.mi18n_tip = this.mi18n_tip;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Field.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3033newBuilder();
        }

        public Field(String r12, I18nVal r13, Boolean r14, FieldValueType r15, ByteString r16, String r17, Boolean r18, UserFieldSource r19, I18nVal r20) {
            this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
        }

        public Field(String r2, I18nVal r3, Boolean r4, FieldValueType r5, ByteString r6, String r7, Boolean r8, UserFieldSource r9, I18nVal r10, ByteString r11) {
            super(ADAPTER, r11);
            this.mkey = r2;
            this.mi18n_names = r3;
            this.mvisible = r4;
            this.mfield_value_type = r5;
            this.mfield_val = r6;
            this.mstr_field_val = r7;
            this.meditable = r8;
            this.muser_field_source = r9;
            this.mi18n_tip = r10;
        }
    }

    public static final enum FriendStatus extends Enum<FriendStatus> implements WireEnum {
        private static final /* synthetic */ FriendStatus[] $VALUES = null;
        public static final ProtoAdapter<FriendStatus> ADAPTER = null;
        public static final FriendStatus Double = null;
        public static final FriendStatus Forward = null;
        public static final FriendStatus None = null;
        public static final FriendStatus Reverse = null;
        public static final FriendStatus UNKNOWN = null;
        private final int value;

        static {
            FriendStatus r0 = new FriendStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FriendStatus r1 = new FriendStatus("Double", 1, 1);
            Double = r1;
            FriendStatus r3 = new FriendStatus("Forward", 2, 2);
            Forward = r3;
            FriendStatus r5 = new FriendStatus("Reverse", 3, 3);
            Reverse = r5;
            FriendStatus r7 = new FriendStatus("None", 4, 4);
            None = r7;
            $VALUES = new FriendStatus[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(FriendStatus.class);
        }

        public static FriendStatus[] values() {
            return (FriendStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FriendStatus fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return None;
        L16:
            return Reverse;
        L18:
            return Forward;
        L20:
            return Double;
        L22:
            return UNKNOWN;
        }

        public static FriendStatus valueOf(String r1) {
            return (FriendStatus) a.a(FriendStatus.class, r1);
        }

        private FriendStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Href extends Message<Href, Builder> {
        public static final ProtoAdapter<Href> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mlink;
        public final Style mstyle;
        public final I18nVal mtitle;

        public static final class Builder extends Message.Builder<Href, Builder> {
            public I18nVal mlink;
            public Style mstyle;
            public I18nVal mtitle;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Href m3037build() {
                return new Href(this.mtitle, this.mlink, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3037build();
            }

            public Builder link(I18nVal r1) {
                this.mlink = r1;
                return this;
            }

            public Builder style(Style r1) {
                this.mstyle = r1;
                return this;
            }

            public Builder title(I18nVal r1) {
                this.mtitle = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Href extends ProtoAdapter<Href> {
            public ProtoAdapter_Href() {
                super(FieldEncoding.LENGTH_DELIMITED, Href.class);
            }

            public Href decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtitle = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mlink = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mstyle = (Style) Style.ADAPTER.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3037build();
            }

            public int encodedSize(Href r6) {
                I18nVal r0 = r6.mtitle;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = I18nVal.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                I18nVal r3 = r6.mlink;
                if (r3 == null) goto L9;
                int r4 = I18nVal.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Style r7 = r6.mstyle;
                if (r7 == null) goto L14;
                r1 = Style.ADAPTER.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m3038decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Href) r1);
            }

            public void encode(ProtoWriter r4, Href r5) throws IOException {
                I18nVal r0 = r5.mtitle;
                if (r0 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                I18nVal r1 = r5.mlink;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Style r2 = r5.mstyle;
                if (r2 == null) goto L11;
                Style.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Href) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Href();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3036newBuilder() {
            Builder r0 = new Builder();
            r0.mtitle = this.mtitle;
            r0.mlink = this.mlink;
            r0.mstyle = this.mstyle;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Href.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3036newBuilder();
        }

        public Href(I18nVal r2, I18nVal r3, Style r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Href(I18nVal r2, I18nVal r3, Style r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtitle = r2;
            this.mlink = r3;
            this.mstyle = r4;
        }
    }

    public static final class HrefList extends Message<HrefList, Builder> {
        public static final ProtoAdapter<HrefList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Href> mhref_list;

        public static final class Builder extends Message.Builder<HrefList, Builder> {
            public List<Href> mhref_list;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HrefList m3040build() {
                return new HrefList(this.mhref_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mhref_list = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3040build();
            }

            public Builder href_list(List<Href> r1) {
                Internal.checkElementsNotNull(r1);
                this.mhref_list = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_HrefList extends ProtoAdapter<HrefList> {
            public ProtoAdapter_HrefList() {
                super(FieldEncoding.LENGTH_DELIMITED, HrefList.class);
            }

            public HrefList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mhref_list.add((Href) Href.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3040build();
            }

            public int encodedSize(HrefList r4) {
                return Href.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mhref_list) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3041decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HrefList) r1);
            }

            public void encode(ProtoWriter r4, HrefList r5) throws IOException {
                Href.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mhref_list);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HrefList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HrefList();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3039newBuilder() {
            Builder r0 = new Builder();
            r0.mhref_list = Internal.copyOf("mhref_list", this.mhref_list);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HrefList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3039newBuilder();
        }

        public HrefList(List<Href> r2) {
            this(r2, ByteString.EMPTY);
        }

        public HrefList(List<Href> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mhref_list = Internal.immutableCopyOf("mhref_list", r2);
        }
    }

    public static final class Medal extends Message<Medal, Builder> {
        public static final ProtoAdapter<Medal> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mi18n_name;
        public final ImageSetPassThrough mimage;

        public static final class Builder extends Message.Builder<Medal, Builder> {
            public I18nVal mi18n_name;
            public ImageSetPassThrough mimage;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Medal m3043build() {
                return new Medal(this.mimage, this.mi18n_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3043build();
            }

            public Builder i18n_name(I18nVal r1) {
                this.mi18n_name = r1;
                return this;
            }

            public Builder image(ImageSetPassThrough r1) {
                this.mimage = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Medal extends ProtoAdapter<Medal> {
            public ProtoAdapter_Medal() {
                super(FieldEncoding.LENGTH_DELIMITED, Medal.class);
            }

            public Medal decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mimage = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mi18n_name = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3043build();
            }

            public int encodedSize(Medal r5) {
                ImageSetPassThrough r0 = r5.mimage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                I18nVal r3 = r5.mi18n_name;
                if (r3 == null) goto L10;
                r1 = I18nVal.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3044decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Medal) r1);
            }

            public void encode(ProtoWriter r4, Medal r5) throws IOException {
                ImageSetPassThrough r0 = r5.mimage;
                if (r0 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                I18nVal r1 = r5.mi18n_name;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Medal) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Medal();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3042newBuilder() {
            Builder r0 = new Builder();
            r0.mimage = this.mimage;
            r0.mi18n_name = this.mi18n_name;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Medal.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3042newBuilder();
        }

        public Medal(ImageSetPassThrough r2, I18nVal r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Medal(ImageSetPassThrough r2, I18nVal r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mimage = r2;
            this.mi18n_name = r3;
        }
    }

    public static final class MedalList extends Message<MedalList, Builder> {
        public static final ProtoAdapter<MedalList> ADAPTER = null;
        public static final Integer DEFAULT_TOTAL_NUM = null;
        private static final long serialVersionUID = 0;
        public final List<Medal> mmedal_meta;
        public final Integer mtotal_num;

        public static final class Builder extends Message.Builder<MedalList, Builder> {
            public List<Medal> mmedal_meta;
            public Integer mtotal_num;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MedalList m3046build() {
                return new MedalList(this.mmedal_meta, this.mtotal_num, super.buildUnknownFields());
            }

            public Builder() {
                this.mmedal_meta = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3046build();
            }

            public Builder medal_meta(List<Medal> r1) {
                Internal.checkElementsNotNull(r1);
                this.mmedal_meta = r1;
                return this;
            }

            public Builder total_num(Integer r1) {
                this.mtotal_num = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MedalList extends ProtoAdapter<MedalList> {
            public ProtoAdapter_MedalList() {
                super(FieldEncoding.LENGTH_DELIMITED, MedalList.class);
            }

            public MedalList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtotal_num = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mmedal_meta.add((Medal) Medal.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtotal_num = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3046build();
            }

            public int encodedSize(MedalList r5) {
                int r0 = Medal.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mmedal_meta);
                Integer r1 = r5.mtotal_num;
                if (r1 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(2, r1);
            L7:
                return (r0 + r2) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3047decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MedalList) r1);
            }

            public void encode(ProtoWriter r4, MedalList r5) throws IOException {
                Medal.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mmedal_meta);
                Integer r0 = r5.mtotal_num;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MedalList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MedalList();
            DEFAULT_TOTAL_NUM = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3045newBuilder() {
            Builder r0 = new Builder();
            r0.mmedal_meta = Internal.copyOf("mmedal_meta", this.mmedal_meta);
            r0.mtotal_num = this.mtotal_num;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MedalList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3045newBuilder();
        }

        public MedalList(List<Medal> r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MedalList(List<Medal> r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mmedal_meta = Internal.immutableCopyOf("mmedal_meta", r2);
            this.mtotal_num = r3;
        }
    }

    public static final class MemoDescription extends Message<MemoDescription, Builder> {
        public static final ProtoAdapter<MemoDescription> ADAPTER = null;
        public static final String DEFAULT_MEMO_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Map<String, PreviewHangPoint> manchor_id_2_preview_hang_point;
        public final ImageSetPassThrough mmemo_picture;
        public final List<ImageSetPassThrough> mmemo_picture_v2;
        public final String mmemo_text;
        public final RichText mmemo_text_v2;

        public static final class Builder extends Message.Builder<MemoDescription, Builder> {
            public Map<String, PreviewHangPoint> manchor_id_2_preview_hang_point;
            public ImageSetPassThrough mmemo_picture;
            public List<ImageSetPassThrough> mmemo_picture_v2;
            public String mmemo_text;
            public RichText mmemo_text_v2;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MemoDescription m3049build() {
                return new MemoDescription(this.mmemo_text, this.mmemo_picture, this.mmemo_text_v2, this.mmemo_picture_v2, this.manchor_id_2_preview_hang_point, super.buildUnknownFields());
            }

            public Builder() {
                this.mmemo_picture_v2 = Internal.newMutableList();
                this.manchor_id_2_preview_hang_point = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3049build();
            }

            public Builder anchor_id_2_preview_hang_point(Map<String, PreviewHangPoint> r1) {
                Internal.checkElementsNotNull(r1);
                this.manchor_id_2_preview_hang_point = r1;
                return this;
            }

            public Builder memo_picture(ImageSetPassThrough r1) {
                this.mmemo_picture = r1;
                return this;
            }

            public Builder memo_picture_v2(List<ImageSetPassThrough> r1) {
                Internal.checkElementsNotNull(r1);
                this.mmemo_picture_v2 = r1;
                return this;
            }

            public Builder memo_text(String r1) {
                this.mmemo_text = r1;
                return this;
            }

            public Builder memo_text_v2(RichText r1) {
                this.mmemo_text_v2 = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MemoDescription extends ProtoAdapter<MemoDescription> {
            private final ProtoAdapter<Map<String, PreviewHangPoint>> manchor_id_2_preview_hang_point;

            public ProtoAdapter_MemoDescription() {
                super(FieldEncoding.LENGTH_DELIMITED, MemoDescription.class);
                this.manchor_id_2_preview_hang_point = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, PreviewHangPoint.ADAPTER);
            }

            public MemoDescription decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmemo_text = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mmemo_text = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mmemo_picture = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mmemo_text_v2 = (RichText) RichText.ADAPTER.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mmemo_picture_v2.add((ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r7));
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.manchor_id_2_preview_hang_point.putAll((Map) this.manchor_id_2_preview_hang_point.decode(r7));
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m3049build();
            }

            public int encodedSize(MemoDescription r6) {
                String r0 = r6.mmemo_text;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                ImageSetPassThrough r3 = r6.mmemo_picture;
                if (r3 == null) goto L9;
                int r4 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                RichText r7 = r6.mmemo_text_v2;
                if (r7 == null) goto L14;
                r1 = RichText.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                return (((r5 + r1) + ImageSetPassThrough.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mmemo_picture_v2)) + this.manchor_id_2_preview_hang_point.encodedSizeWithTag(5, r6.manchor_id_2_preview_hang_point)) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3050decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MemoDescription) r1);
            }

            public void encode(ProtoWriter r4, MemoDescription r5) throws IOException {
                String r0 = r5.mmemo_text;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                ImageSetPassThrough r1 = r5.mmemo_picture;
                if (r1 == null) goto L8;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                RichText r2 = r5.mmemo_text_v2;
                if (r2 == null) goto L11;
                RichText.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                ImageSetPassThrough.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mmemo_picture_v2);
                this.manchor_id_2_preview_hang_point.encodeWithTag(r4, 5, r5.manchor_id_2_preview_hang_point);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MemoDescription) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MemoDescription();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3048newBuilder() {
            Builder r0 = new Builder();
            r0.mmemo_text = this.mmemo_text;
            r0.mmemo_picture = this.mmemo_picture;
            r0.mmemo_text_v2 = this.mmemo_text_v2;
            r0.mmemo_picture_v2 = Internal.copyOf("mmemo_picture_v2", this.mmemo_picture_v2);
            r0.manchor_id_2_preview_hang_point = Internal.copyOf("manchor_id_2_preview_hang_point", this.manchor_id_2_preview_hang_point);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MemoDescription.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3048newBuilder();
        }

        public MemoDescription(String r8, ImageSetPassThrough r9, RichText r10, List<ImageSetPassThrough> r11, Map<String, PreviewHangPoint> r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public MemoDescription(String r2, ImageSetPassThrough r3, RichText r4, List<ImageSetPassThrough> r5, Map<String, PreviewHangPoint> r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mmemo_text = r2;
            this.mmemo_picture = r3;
            this.mmemo_text_v2 = r4;
            this.mmemo_picture_v2 = Internal.immutableCopyOf("mmemo_picture_v2", r5);
            this.manchor_id_2_preview_hang_point = Internal.immutableCopyOf("manchor_id_2_preview_hang_point", r6);
        }
    }

    public static final class OpenSectionInfo extends Message<OpenSectionInfo, Builder> {
        public static final ProtoAdapter<OpenSectionInfo> ADAPTER = null;
        public static final String DEFAULT_SECTION_CONTENT = "";
        public static final String DEFAULT_SECTION_ID = "";
        private static final long serialVersionUID = 0;
        public final String msection_content;
        public final String msection_id;
        public final OpenSectionType msection_type;

        public static final class Builder extends Message.Builder<OpenSectionInfo, Builder> {
            public String msection_content;
            public String msection_id;
            public OpenSectionType msection_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OpenSectionInfo m3052build() {
                return new OpenSectionInfo(this.msection_id, this.msection_type, this.msection_content, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3052build();
            }

            public Builder section_content(String r1) {
                this.msection_content = r1;
                return this;
            }

            public Builder section_id(String r1) {
                this.msection_id = r1;
                return this;
            }

            public Builder section_type(OpenSectionType r1) {
                this.msection_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSectionInfo extends ProtoAdapter<OpenSectionInfo> {
            public ProtoAdapter_OpenSectionInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSectionInfo.class);
            }

            public OpenSectionInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.msection_id = "";
                r0.msection_content = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.msection_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.msection_type = (OpenSectionType) OpenSectionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.msection_content = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m3052build();
            }

            public int encodedSize(OpenSectionInfo r6) {
                String r0 = r6.msection_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                OpenSectionType r3 = r6.msection_type;
                if (r3 == null) goto L9;
                int r4 = OpenSectionType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.msection_content;
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
            public /* bridge */ /* synthetic */ Object m3053decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OpenSectionInfo) r1);
            }

            public void encode(ProtoWriter r4, OpenSectionInfo r5) throws IOException {
                String r0 = r5.msection_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                OpenSectionType r1 = r5.msection_type;
                if (r1 == null) goto L8;
                OpenSectionType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.msection_content;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OpenSectionInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSectionInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3051newBuilder() {
            Builder r0 = new Builder();
            r0.msection_id = this.msection_id;
            r0.msection_type = this.msection_type;
            r0.msection_content = this.msection_content;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OpenSectionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3051newBuilder();
        }

        public OpenSectionInfo(String r2, OpenSectionType r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public OpenSectionInfo(String r2, OpenSectionType r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.msection_id = r2;
            this.msection_type = r3;
            this.msection_content = r4;
        }
    }

    public static final class OpenSectionInfoList extends Message<OpenSectionInfoList, Builder> {
        public static final ProtoAdapter<OpenSectionInfoList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<OpenSectionInfo> mopen_section_list;

        public static final class Builder extends Message.Builder<OpenSectionInfoList, Builder> {
            public List<OpenSectionInfo> mopen_section_list;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OpenSectionInfoList m3055build() {
                return new OpenSectionInfoList(this.mopen_section_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mopen_section_list = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3055build();
            }

            public Builder open_section_list(List<OpenSectionInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mopen_section_list = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSectionInfoList extends ProtoAdapter<OpenSectionInfoList> {
            public ProtoAdapter_OpenSectionInfoList() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSectionInfoList.class);
            }

            public OpenSectionInfoList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mopen_section_list.add((OpenSectionInfo) OpenSectionInfo.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3055build();
            }

            public int encodedSize(OpenSectionInfoList r4) {
                return OpenSectionInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mopen_section_list) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3056decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OpenSectionInfoList) r1);
            }

            public void encode(ProtoWriter r4, OpenSectionInfoList r5) throws IOException {
                OpenSectionInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mopen_section_list);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OpenSectionInfoList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSectionInfoList();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3054newBuilder() {
            Builder r0 = new Builder();
            r0.mopen_section_list = Internal.copyOf("mopen_section_list", this.mopen_section_list);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OpenSectionInfoList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3054newBuilder();
        }

        public OpenSectionInfoList(List<OpenSectionInfo> r2) {
            this(r2, ByteString.EMPTY);
        }

        public OpenSectionInfoList(List<OpenSectionInfo> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mopen_section_list = Internal.immutableCopyOf("mopen_section_list", r2);
        }
    }

    public static final enum OpenSectionType extends Enum<OpenSectionType> implements WireEnum {
        private static final /* synthetic */ OpenSectionType[] $VALUES = null;
        public static final ProtoAdapter<OpenSectionType> ADAPTER = null;
        public static final OpenSectionType S_CARD = null;
        public static final OpenSectionType S_UNKNOWN = null;
        private final int value;

        static {
            OpenSectionType r0 = new OpenSectionType("S_UNKNOWN", 0, 0);
            S_UNKNOWN = r0;
            OpenSectionType r1 = new OpenSectionType("S_CARD", 1, 1);
            S_CARD = r1;
            $VALUES = new OpenSectionType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(OpenSectionType.class);
        }

        public static OpenSectionType[] values() {
            return (OpenSectionType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static OpenSectionType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return S_CARD;
        L10:
            return S_UNKNOWN;
        }

        public static OpenSectionType valueOf(String r1) {
            return (OpenSectionType) a.a(OpenSectionType.class, r1);
        }

        private OpenSectionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class PhoneNumber extends Message<PhoneNumber, Builder> {
        public static final ProtoAdapter<PhoneNumber> ADAPTER = null;
        public static final String DEFAULT_COUNTRY_CODE = "";
        public static final Boolean DEFAULT_IS_PLAIN = null;
        public static final String DEFAULT_NUMBER = "";
        public static final Boolean DEFAULT_RATE_LIMITED = null;
        private static final long serialVersionUID = 0;
        public final String mcountry_code;
        public final Boolean mis_plain;
        public final String mnumber;
        public final Boolean mrate_limited;

        public static final class Builder extends Message.Builder<PhoneNumber, Builder> {
            public String mcountry_code;
            public Boolean mis_plain;
            public String mnumber;
            public Boolean mrate_limited;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public PhoneNumber m3058build() {
                return new PhoneNumber(this.mnumber, this.mcountry_code, this.mrate_limited, this.mis_plain, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3058build();
            }

            public Builder country_code(String r1) {
                this.mcountry_code = r1;
                return this;
            }

            public Builder is_plain(Boolean r1) {
                this.mis_plain = r1;
                return this;
            }

            public Builder number(String r1) {
                this.mnumber = r1;
                return this;
            }

            public Builder rate_limited(Boolean r1) {
                this.mrate_limited = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_PhoneNumber extends ProtoAdapter<PhoneNumber> {
            public ProtoAdapter_PhoneNumber() {
                super(FieldEncoding.LENGTH_DELIMITED, PhoneNumber.class);
            }

            public PhoneNumber decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mnumber = "";
                r0.mcountry_code = "";
                Boolean r1 = Boolean.FALSE;
                r0.mrate_limited = r1;
                r0.mis_plain = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mnumber = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcountry_code = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mrate_limited = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mis_plain = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r2);
                return r0.m3058build();
            }

            public int encodedSize(PhoneNumber r6) {
                String r0 = r6.mnumber;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mcountry_code;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mrate_limited;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mis_plain;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m3059decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((PhoneNumber) r1);
            }

            public void encode(ProtoWriter r4, PhoneNumber r5) throws IOException {
                String r0 = r5.mnumber;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mcountry_code;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mrate_limited;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mis_plain;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (PhoneNumber) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PhoneNumber();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_RATE_LIMITED = r0;
            DEFAULT_IS_PLAIN = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3057newBuilder() {
            Builder r0 = new Builder();
            r0.mnumber = this.mnumber;
            r0.mcountry_code = this.mcountry_code;
            r0.mrate_limited = this.mrate_limited;
            r0.mis_plain = this.mis_plain;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return PhoneNumber.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3057newBuilder();
        }

        public PhoneNumber(String r7, String r8, Boolean r9, Boolean r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public PhoneNumber(String r2, String r3, Boolean r4, Boolean r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mnumber = r2;
            this.mcountry_code = r3;
            this.mrate_limited = r4;
            this.mis_plain = r5;
        }
    }

    public static final class ProtoAdapter_Profile extends ProtoAdapter<Profile> {
        public ProtoAdapter_Profile() {
            super(FieldEncoding.LENGTH_DELIMITED, Profile.class);
        }

        public Profile decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.muser_info = (UserInfo) UserInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mctas.add((CTA) CTA.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfields.add((Field) Field.ADAPTER.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mtabs.add((TabInfo) TabInfo.ADAPTER.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m3011build();
        }

        public int encodedSize(Profile r5) {
            UserInfo r0 = r5.muser_info;
            if (r0 == null) goto L5;
            int r1 = UserInfo.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return (((r1 + CTA.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mctas)) + Field.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mfields)) + TabInfo.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mtabs)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3060decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Profile) r1);
        }

        public void encode(ProtoWriter r4, Profile r5) throws IOException {
            UserInfo r0 = r5.muser_info;
            if (r0 == null) goto L5;
            UserInfo.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            CTA.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mctas);
            Field.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mfields);
            TabInfo.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mtabs);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Profile) r2);
        }
    }

    public static final class ShareInfo extends Message<ShareInfo, Builder> {
        public static final ProtoAdapter<ShareInfo> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE = null;
        private static final long serialVersionUID = 0;
        public final I18nVal mdenied_description;
        public final Boolean menable;
        public final I18nVal mi18n_names;

        public static final class Builder extends Message.Builder<ShareInfo, Builder> {
            public I18nVal mdenied_description;
            public Boolean menable;
            public I18nVal mi18n_names;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ShareInfo m3062build() {
                return new ShareInfo(this.menable, this.mi18n_names, this.mdenied_description, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3062build();
            }

            public Builder denied_description(I18nVal r1) {
                this.mdenied_description = r1;
                return this;
            }

            public Builder enable(Boolean r1) {
                this.menable = r1;
                return this;
            }

            public Builder i18n_names(I18nVal r1) {
                this.mi18n_names = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ShareInfo extends ProtoAdapter<ShareInfo> {
            public ProtoAdapter_ShareInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareInfo.class);
            }

            public ShareInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.menable = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.menable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mi18n_names = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mdenied_description = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3062build();
            }

            public int encodedSize(ShareInfo r6) {
                Boolean r0 = r6.menable;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                I18nVal r3 = r6.mi18n_names;
                if (r3 == null) goto L9;
                int r4 = I18nVal.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                I18nVal r7 = r6.mdenied_description;
                if (r7 == null) goto L14;
                r1 = I18nVal.ADAPTER.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m3063decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ShareInfo) r1);
            }

            public void encode(ProtoWriter r4, ShareInfo r5) throws IOException {
                Boolean r0 = r5.menable;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                I18nVal r1 = r5.mi18n_names;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                I18nVal r2 = r5.mdenied_description;
                if (r2 == null) goto L11;
                I18nVal.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ShareInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareInfo();
            DEFAULT_ENABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3061newBuilder() {
            Builder r0 = new Builder();
            r0.menable = this.menable;
            r0.mi18n_names = this.mi18n_names;
            r0.mdenied_description = this.mdenied_description;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ShareInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3061newBuilder();
        }

        public ShareInfo(Boolean r2, I18nVal r3, I18nVal r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ShareInfo(Boolean r2, I18nVal r3, I18nVal r4, ByteString r5) {
            super(ADAPTER, r5);
            this.menable = r2;
            this.mi18n_names = r3;
            this.mdenied_description = r4;
        }
    }

    public static final class SingleFieldTabInfo extends Message<SingleFieldTabInfo, Builder> {
        public static final ProtoAdapter<SingleFieldTabInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Field msingle_field;

        public static final class Builder extends Message.Builder<SingleFieldTabInfo, Builder> {
            public Field msingle_field;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SingleFieldTabInfo m3065build() {
                return new SingleFieldTabInfo(this.msingle_field, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3065build();
            }

            public Builder single_field(Field r1) {
                this.msingle_field = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SingleFieldTabInfo extends ProtoAdapter<SingleFieldTabInfo> {
            public ProtoAdapter_SingleFieldTabInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, SingleFieldTabInfo.class);
            }

            public SingleFieldTabInfo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.msingle_field = (Field) Field.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3065build();
            }

            public int encodedSize(SingleFieldTabInfo r4) {
                Field r0 = r4.msingle_field;
                if (r0 == null) goto L5;
                int r1 = Field.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3066decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SingleFieldTabInfo) r1);
            }

            public void encode(ProtoWriter r4, SingleFieldTabInfo r5) throws IOException {
                Field r0 = r5.msingle_field;
                if (r0 == null) goto L5;
                Field.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SingleFieldTabInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SingleFieldTabInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3064newBuilder() {
            Builder r0 = new Builder();
            r0.msingle_field = this.msingle_field;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SingleFieldTabInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3064newBuilder();
        }

        public SingleFieldTabInfo(Field r2) {
            this(r2, ByteString.EMPTY);
        }

        public SingleFieldTabInfo(Field r2, ByteString r3) {
            super(ADAPTER, r3);
            this.msingle_field = r2;
        }
    }

    public static final class Style extends Message<Style, Builder> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final String DEFAULT_COLOR = "";
        public static final Boolean DEFAULT_EXPANDABLE = null;
        public static final Integer DEFAULT_MAX_LINES = null;
        private static final long serialVersionUID = 0;
        public final String mcolor;
        public final Boolean mexpandable;
        public final Integer mmax_lines;

        public static final class Builder extends Message.Builder<Style, Builder> {
            public String mcolor;
            public Boolean mexpandable;
            public Integer mmax_lines;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Style m3068build() {
                return new Style(this.mmax_lines, this.mexpandable, this.mcolor, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3068build();
            }

            public Builder color(String r1) {
                this.mcolor = r1;
                return this;
            }

            public Builder expandable(Boolean r1) {
                this.mexpandable = r1;
                return this;
            }

            public Builder max_lines(Integer r1) {
                this.mmax_lines = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Style extends ProtoAdapter<Style> {
            public ProtoAdapter_Style() {
                super(FieldEncoding.LENGTH_DELIMITED, Style.class);
            }

            public Style decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mmax_lines = 0;
                r0.mexpandable = Boolean.FALSE;
                r0.mcolor = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmax_lines = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mexpandable = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mcolor = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3068build();
            }

            public int encodedSize(Style r6) {
                Integer r0 = r6.mmax_lines;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mexpandable;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mcolor;
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
            public /* bridge */ /* synthetic */ Object m3069decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Style) r1);
            }

            public void encode(ProtoWriter r4, Style r5) throws IOException {
                Integer r0 = r5.mmax_lines;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mexpandable;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mcolor;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Style) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Style();
            DEFAULT_MAX_LINES = 0;
            DEFAULT_EXPANDABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3067newBuilder() {
            Builder r0 = new Builder();
            r0.mmax_lines = this.mmax_lines;
            r0.mexpandable = this.mexpandable;
            r0.mcolor = this.mcolor;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Style.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3067newBuilder();
        }

        public Style(Integer r2, Boolean r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Style(Integer r2, Boolean r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mmax_lines = r2;
            this.mexpandable = r3;
            this.mcolor = r4;
        }
    }

    public static final class TabInfo extends Message<TabInfo, Builder> {
        public static final ProtoAdapter<TabInfo> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final String DEFAULT_KEY = "";
        private static final long serialVersionUID = 0;
        public final String mcontent;
        public final String mkey;
        public final I18nVal mname;
        public final TabType mtab_type;

        public static final class Builder extends Message.Builder<TabInfo, Builder> {
            public String mcontent;
            public String mkey;
            public I18nVal mname;
            public TabType mtab_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TabInfo m3071build() {
                return new TabInfo(this.mkey, this.mname, this.mtab_type, this.mcontent, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3071build();
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder key(String r1) {
                this.mkey = r1;
                return this;
            }

            public Builder name(I18nVal r1) {
                this.mname = r1;
                return this;
            }

            public Builder tab_type(TabType r1) {
                this.mtab_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TabInfo extends ProtoAdapter<TabInfo> {
            public ProtoAdapter_TabInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TabInfo.class);
            }

            public TabInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mkey = "";
                r0.mcontent = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mname = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mtab_type = (TabType) TabType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m3071build();
            }

            public int encodedSize(TabInfo r6) {
                String r0 = r6.mkey;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                I18nVal r3 = r6.mname;
                if (r3 == null) goto L9;
                int r4 = I18nVal.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                TabType r7 = r6.mtab_type;
                if (r7 == null) goto L13;
                int r8 = TabType.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mcontent;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m3072decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TabInfo) r1);
            }

            public void encode(ProtoWriter r4, TabInfo r5) throws IOException {
                String r0 = r5.mkey;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                I18nVal r1 = r5.mname;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                TabType r2 = r5.mtab_type;
                if (r2 == null) goto L11;
                TabType.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mcontent;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TabInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TabInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3070newBuilder() {
            Builder r0 = new Builder();
            r0.mkey = this.mkey;
            r0.mname = this.mname;
            r0.mtab_type = this.mtab_type;
            r0.mcontent = this.mcontent;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TabInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3070newBuilder();
        }

        public TabInfo(String r7, I18nVal r8, TabType r9, String r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public TabInfo(String r2, I18nVal r3, TabType r4, String r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mkey = r2;
            this.mname = r3;
            this.mtab_type = r4;
            this.mcontent = r5;
        }
    }

    public static final enum TabType extends Enum<TabType> implements WireEnum {
        private static final /* synthetic */ TabType[] $VALUES = null;
        public static final ProtoAdapter<TabType> ADAPTER = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_ACTIVITY = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_OVERVIEW = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE = null;
        public static final TabType F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY = null;
        public static final TabType F_COMMON_INFO = null;
        public static final TabType F_COMMUNITY = null;
        public static final TabType F_OPEN_SECTION_CLUSTER = null;
        public static final TabType F_SECTION_CLUSTER = null;
        public static final TabType F_SINGLE_FIELD = null;
        public static final TabType F_UNKNOWN = null;
        private final int value;

        static {
            TabType r0 = new TabType("F_UNKNOWN", 0, 0);
            F_UNKNOWN = r0;
            TabType r1 = new TabType("F_COMMON_INFO", 1, 1);
            F_COMMON_INFO = r1;
            TabType r3 = new TabType("F_COMMUNITY", 2, 2);
            F_COMMUNITY = r3;
            TabType r5 = new TabType("F_SINGLE_FIELD", 3, 3);
            F_SINGLE_FIELD = r5;
            TabType r7 = new TabType("F_SECTION_CLUSTER", 4, 4);
            F_SECTION_CLUSTER = r7;
            TabType r9 = new TabType("F_OPEN_SECTION_CLUSTER", 5, 5);
            F_OPEN_SECTION_CLUSTER = r9;
            TabType r11 = new TabType("F_BUILT_IN_PROFILE_MANAGE_ACTIVITY", 6, 6);
            F_BUILT_IN_PROFILE_MANAGE_ACTIVITY = r11;
            TabType r13 = new TabType("F_BUILT_IN_PROFILE_MANAGE_OVERVIEW", 7, 7);
            F_BUILT_IN_PROFILE_MANAGE_OVERVIEW = r13;
            TabType r15 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY", 8, 8);
            F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY = r15;
            TabType r14 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION", 9, 9);
            F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION = r14;
            TabType r12 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY", 10, 10);
            F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY = r12;
            TabType r10 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION", 11, 11);
            F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION = r10;
            TabType r8 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY", 12, 12);
            F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY = r8;
            TabType r6 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE", 13, 13);
            F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE = r6;
            TabType r4 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT", 14, 14);
            F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT = r4;
            TabType r2 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE", 15, 15);
            F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE = r2;
            TabType r16 = new TabType("F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT", 16, 16);
            F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT = r16;
            $VALUES = new TabType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
            ADAPTER = ProtoAdapter.newEnumAdapter(TabType.class);
        }

        public static TabType[] values() {
            return (TabType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TabType fromValue(int r0) {
            switch(r0) {
                case 0: goto L38;
                case 1: goto L36;
                case 2: goto L34;
                case 3: goto L32;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L20;
                case 10: goto L18;
                case 11: goto L16;
                case 12: goto L14;
                case 13: goto L12;
                case 14: goto L10;
                case 15: goto L8;
                case 16: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ABSTRACT;
        L8:
            return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_TIMELINE;
        L10:
            return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ABSTRACT;
        L12:
            return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_TIMELINE;
        L14:
            return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_ACTIVITY;
        L16:
            return F_BUILT_IN_PROFILE_MANAGE_V2_TEAM_INFORMATION;
        L18:
            return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_ACTIVITY;
        L20:
            return F_BUILT_IN_PROFILE_MANAGE_V2_DEPT_INFORMATION;
        L22:
            return F_BUILT_IN_PROFILE_MANAGE_V2_USER_ACTIVITY;
        L24:
            return F_BUILT_IN_PROFILE_MANAGE_OVERVIEW;
        L26:
            return F_BUILT_IN_PROFILE_MANAGE_ACTIVITY;
        L28:
            return F_OPEN_SECTION_CLUSTER;
        L30:
            return F_SECTION_CLUSTER;
        L32:
            return F_SINGLE_FIELD;
        L34:
            return F_COMMUNITY;
        L36:
            return F_COMMON_INFO;
        L38:
            return F_UNKNOWN;
        }

        public static TabType valueOf(String r1) {
            return (TabType) a.a(TabType.class, r1);
        }

        private TabType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Text extends Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Style mstyle;
        public final I18nVal mtext;

        public static final class Builder extends Message.Builder<Text, Builder> {
            public Style mstyle;
            public I18nVal mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Text m3074build() {
                return new Text(this.mtext, this.mstyle, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3074build();
            }

            public Builder style(Style r1) {
                this.mstyle = r1;
                return this;
            }

            public Builder text(I18nVal r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Text extends ProtoAdapter<Text> {
            public ProtoAdapter_Text() {
                super(FieldEncoding.LENGTH_DELIMITED, Text.class);
            }

            public Text decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mtext = (I18nVal) I18nVal.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mstyle = (Style) Style.ADAPTER.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m3074build();
            }

            public int encodedSize(Text r5) {
                I18nVal r0 = r5.mtext;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = I18nVal.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Style r3 = r5.mstyle;
                if (r3 == null) goto L10;
                r1 = Style.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3075decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Text) r1);
            }

            public void encode(ProtoWriter r4, Text r5) throws IOException {
                I18nVal r0 = r5.mtext;
                if (r0 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Style r1 = r5.mstyle;
                if (r1 == null) goto L8;
                Style.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Text) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Text();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3073newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.mstyle = this.mstyle;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Text.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3073newBuilder();
        }

        public Text(I18nVal r2, Style r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Text(I18nVal r2, Style r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtext = r2;
            this.mstyle = r3;
        }
    }

    public static final class TextList extends Message<TextList, Builder> {
        public static final ProtoAdapter<TextList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Text> mtext_list;

        public static final class Builder extends Message.Builder<TextList, Builder> {
            public List<Text> mtext_list;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TextList m3077build() {
                return new TextList(this.mtext_list, super.buildUnknownFields());
            }

            public Builder() {
                this.mtext_list = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3077build();
            }

            public Builder text_list(List<Text> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtext_list = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TextList extends ProtoAdapter<TextList> {
            public ProtoAdapter_TextList() {
                super(FieldEncoding.LENGTH_DELIMITED, TextList.class);
            }

            public TextList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mtext_list.add((Text) Text.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m3077build();
            }

            public int encodedSize(TextList r4) {
                return Text.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mtext_list) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3078decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TextList) r1);
            }

            public void encode(ProtoWriter r4, TextList r5) throws IOException {
                Text.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mtext_list);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TextList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TextList();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3076newBuilder() {
            Builder r0 = new Builder();
            r0.mtext_list = Internal.copyOf("mtext_list", this.mtext_list);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TextList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3076newBuilder();
        }

        public TextList(List<Text> r2) {
            this(r2, ByteString.EMPTY);
        }

        public TextList(List<Text> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mtext_list = Internal.immutableCopyOf("mtext_list", r2);
        }
    }

    public static final class UserInfo extends Message<UserInfo, Builder> {
        public static final ProtoAdapter<UserInfo> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_BLOCK = null;
        public static final Boolean DEFAULT_CAN_SET_STRANGER = null;
        public static final Long DEFAULT_CONTACT_APPLICATION_ID = null;
        public static final String DEFAULT_CONTACT_TOKEN = "";
        public static final Boolean DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = null;
        public static final String DEFAULT_GENDER_PRONOUNS = "";
        public static final Boolean DEFAULT_HIDE_ADD_CONNECT_BUTTON = null;
        public static final Boolean DEFAULT_IS_BLOCKED = null;
        public static final Boolean DEFAULT_IS_LH = null;
        public static final Boolean DEFAULT_IS_SPECIAL_FOCUS = null;
        public static final Boolean DEFAULT_IS_STRANGER = null;
        public static final Boolean DEFAULT_IS_TENANT_CERTIFICATION = null;
        public static final String DEFAULT_LEADER_ID = "";
        public static final Boolean DEFAULT_SHOW_DESCRIPTION = null;
        public static final String DEFAULT_TENANT_CERTIFICATION_URL = "";
        public static final FieldOptions FIELD_OPTIONS_MLEADER_ID = null;
        private static final long serialVersionUID = 0;
        public final ApplyCommunication mapply_communication;
        public final BlockStatus mblock_status;
        public final Boolean mcan_block;
        public final Boolean mcan_set_stranger;
        public final CertificationInfo mcertification_info;
        public final Long mcontact_application_id;
        public final String mcontact_token;
        public final I18nVal mcross_meta_unit_description;
        public final List<Field> mcustom_tag_fields;
        public final Boolean menable_add_by_contact_token;
        public final FriendStatus mfriend_status;
        public final Gender mgender;
        public final String mgender_pronouns;
        public final Boolean mhide_add_connect_button;
        public final Boolean mis_blocked;
        public final Boolean mis_lh;
        public final Boolean mis_special_focus;
        public final Boolean mis_stranger;
        public final Boolean mis_tenant_certification;
        public final String mleader_id;
        public final MedalList mmedal_list;
        public final ShareInfo mshare_info;
        public final Boolean mshow_description;
        public final String mtenant_certification_url;
        public final I18nVal mtenant_name;
        public final TenantNameStatus mtenant_name_status;
        public final ImageSetPassThrough mtop_image;
        public final UserTag muser_tag;

        public static final class Builder extends Message.Builder<UserInfo, Builder> {
            public ApplyCommunication mapply_communication;
            public BlockStatus mblock_status;
            public Boolean mcan_block;
            public Boolean mcan_set_stranger;
            public CertificationInfo mcertification_info;
            public Long mcontact_application_id;
            public String mcontact_token;
            public I18nVal mcross_meta_unit_description;
            public List<Field> mcustom_tag_fields;
            public Boolean menable_add_by_contact_token;
            public FriendStatus mfriend_status;
            public Gender mgender;
            public String mgender_pronouns;
            public Boolean mhide_add_connect_button;
            public Boolean mis_blocked;
            public Boolean mis_lh;
            public Boolean mis_special_focus;
            public Boolean mis_stranger;
            public Boolean mis_tenant_certification;
            public String mleader_id;
            public MedalList mmedal_list;
            public ShareInfo mshare_info;
            public Boolean mshow_description;
            public String mtenant_certification_url;
            public I18nVal mtenant_name;
            public TenantNameStatus mtenant_name_status;
            public ImageSetPassThrough mtop_image;
            public UserTag muser_tag;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserInfo m3080build() {
                FriendStatus r1 = this.mfriend_status;
                if (r1 == null) goto L7;
                return new UserInfo(this.mfriend_status, this.mgender, this.mtenant_name, this.mcontact_token, this.mcontact_application_id, this.menable_add_by_contact_token, this.mleader_id, this.mis_blocked, this.mblock_status, this.muser_tag, this.mis_tenant_certification, this.mtenant_certification_url, this.mcustom_tag_fields, this.mtop_image, this.mshare_info, this.mshow_description, this.mmedal_list, this.mis_special_focus, this.mgender_pronouns, this.mcross_meta_unit_description, this.mcertification_info, this.mtenant_name_status, this.mapply_communication, this.mcan_block, this.mhide_add_connect_button, this.mcan_set_stranger, this.mis_stranger, this.mis_lh, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r1, "mfriend_status"});
            }

            public Builder() {
                this.mcustom_tag_fields = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3080build();
            }

            public Builder apply_communication(ApplyCommunication r1) {
                this.mapply_communication = r1;
                return this;
            }

            public Builder block_status(BlockStatus r1) {
                this.mblock_status = r1;
                return this;
            }

            public Builder can_block(Boolean r1) {
                this.mcan_block = r1;
                return this;
            }

            public Builder can_set_stranger(Boolean r1) {
                this.mcan_set_stranger = r1;
                return this;
            }

            public Builder certification_info(CertificationInfo r1) {
                this.mcertification_info = r1;
                return this;
            }

            public Builder contact_application_id(Long r1) {
                this.mcontact_application_id = r1;
                return this;
            }

            public Builder contact_token(String r1) {
                this.mcontact_token = r1;
                return this;
            }

            public Builder cross_meta_unit_description(I18nVal r1) {
                this.mcross_meta_unit_description = r1;
                return this;
            }

            public Builder custom_tag_fields(List<Field> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcustom_tag_fields = r1;
                return this;
            }

            public Builder enable_add_by_contact_token(Boolean r1) {
                this.menable_add_by_contact_token = r1;
                return this;
            }

            public Builder friend_status(FriendStatus r1) {
                this.mfriend_status = r1;
                return this;
            }

            public Builder gender(Gender r1) {
                this.mgender = r1;
                return this;
            }

            public Builder gender_pronouns(String r1) {
                this.mgender_pronouns = r1;
                return this;
            }

            public Builder hide_add_connect_button(Boolean r1) {
                this.mhide_add_connect_button = r1;
                return this;
            }

            public Builder is_blocked(Boolean r1) {
                this.mis_blocked = r1;
                return this;
            }

            public Builder is_lh(Boolean r1) {
                this.mis_lh = r1;
                return this;
            }

            public Builder is_special_focus(Boolean r1) {
                this.mis_special_focus = r1;
                return this;
            }

            public Builder is_stranger(Boolean r1) {
                this.mis_stranger = r1;
                return this;
            }

            public Builder is_tenant_certification(Boolean r1) {
                this.mis_tenant_certification = r1;
                return this;
            }

            public Builder leader_id(String r1) {
                this.mleader_id = r1;
                return this;
            }

            public Builder medal_list(MedalList r1) {
                this.mmedal_list = r1;
                return this;
            }

            public Builder share_info(ShareInfo r1) {
                this.mshare_info = r1;
                return this;
            }

            public Builder show_description(Boolean r1) {
                this.mshow_description = r1;
                return this;
            }

            public Builder tenant_certification_url(String r1) {
                this.mtenant_certification_url = r1;
                return this;
            }

            public Builder tenant_name(I18nVal r1) {
                this.mtenant_name = r1;
                return this;
            }

            public Builder tenant_name_status(TenantNameStatus r1) {
                this.mtenant_name_status = r1;
                return this;
            }

            public Builder top_image(ImageSetPassThrough r1) {
                this.mtop_image = r1;
                return this;
            }

            public Builder user_tag(UserTag r1) {
                this.muser_tag = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UserInfo extends ProtoAdapter<UserInfo> {
            public ProtoAdapter_UserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, UserInfo.class);
            }

            public UserInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcontact_token = "";
                r0.mcontact_application_id = 0L;
                Boolean r2 = Boolean.FALSE;
                r0.menable_add_by_contact_token = r2;
                r0.mleader_id = "";
                r0.mis_blocked = r2;
                r0.mis_tenant_certification = r2;
                r0.mtenant_certification_url = "";
                r0.mshow_description = r2;
                r0.mis_special_focus = r2;
                r0.mgender_pronouns = "";
                r0.mcan_block = r2;
                r0.mhide_add_connect_button = r2;
                r0.mcan_set_stranger = r2;
                r0.mis_stranger = r2;
                r0.mis_lh = r2;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L50;
                switch(r3) {
                    case 1: goto L54;
                    case 2: goto L56;
                    case 3: goto L41;
                    case 4: goto L40;
                    case 5: goto L39;
                    case 6: goto L38;
                    case 7: goto L37;
                    case 8: goto L36;
                    case 9: goto L52;
                    case 10: goto L58;
                    case 11: goto L27;
                    case 12: goto L26;
                    case 13: goto L25;
                    case 14: goto L24;
                    case 15: goto L23;
                    case 16: goto L22;
                    case 17: goto L21;
                    case 18: goto L20;
                    case 19: goto L19;
                    case 20: goto L18;
                    case 21: goto L17;
                    case 22: goto L60;
                    case 23: goto L12;
                    case 24: goto L11;
                    case 25: goto L10;
                    case 26: goto L9;
                    case 27: goto L8;
                    case 28: goto L7;
                    default: goto L6;
                };
            L52:
                r0.mblock_status = (BlockStatus) BlockStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
            L34:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L54:
                r0.mfriend_status = (FriendStatus) FriendStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
            L48:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L56:
                r0.mgender = (Gender) Gender.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L44
            L44:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L58:
                r0.muser_tag = (UserTag) UserTag.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
            L30:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L60:
                r0.mtenant_name_status = (TenantNameStatus) TenantNameStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mis_lh = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                r0.mis_stranger = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L9:
                r0.mcan_set_stranger = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L10:
                r0.mhide_add_connect_button = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L11:
                r0.mcan_block = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                r0.mapply_communication = (ApplyCommunication) ApplyCommunication.ADAPTER.decode(r9);
                goto L3
            L17:
                r0.mcertification_info = (CertificationInfo) CertificationInfo.ADAPTER.decode(r9);
                goto L3
            L18:
                r0.mcross_meta_unit_description = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L19:
                r0.mgender_pronouns = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L20:
                r0.mis_special_focus = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L21:
                r0.mmedal_list = (MedalList) MedalList.ADAPTER.decode(r9);
                goto L3
            L22:
                r0.mshow_description = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L23:
                r0.mshare_info = (ShareInfo) ShareInfo.ADAPTER.decode(r9);
                goto L3
            L24:
                r0.mtop_image = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
                goto L3
            L25:
                r0.mcustom_tag_fields.add((Field) Field.ADAPTER.decode(r9));
                goto L3
            L26:
                r0.mtenant_certification_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L27:
                r0.mis_tenant_certification = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L36:
                r0.mis_blocked = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L37:
                r0.mleader_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L38:
                r0.menable_add_by_contact_token = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L39:
                r0.mcontact_application_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L40:
                r0.mcontact_token = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L41:
                r0.mtenant_name = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L50:
                r9.endMessage(r1);
                return r0.m3080build();
            }

            public int encodedSize(UserInfo r6) {
                int r0 = FriendStatus.ADAPTER.encodedSizeWithTag(1, r6.mfriend_status);
                Gender r1 = r6.mgender;
                int r2 = 0;
                if (r1 == null) goto L5;
                int r3 = Gender.ADAPTER.encodedSizeWithTag(2, r1);
            L6:
                int r4 = r0 + r3;
                I18nVal r5 = r6.mtenant_name;
                if (r5 == null) goto L9;
                int r7 = I18nVal.ADAPTER.encodedSizeWithTag(3, r5);
            L10:
                int r8 = r4 + r7;
                String r9 = r6.mcontact_token;
                if (r9 == null) goto L13;
                int r10 = ProtoAdapter.STRING.encodedSizeWithTag(4, r9);
            L14:
                int r11 = r8 + r10;
                Long r12 = r6.mcontact_application_id;
                if (r12 == null) goto L17;
                int r13 = ProtoAdapter.INT64.encodedSizeWithTag(5, r12);
            L18:
                int r14 = r11 + r13;
                Boolean r15 = r6.menable_add_by_contact_token;
                if (r15 == null) goto L21;
                int r16 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r15);
            L22:
                int r17 = r14 + r16;
                String r18 = r6.mleader_id;
                if (r18 == null) goto L25;
                int r19 = ProtoAdapter.STRING.encodedSizeWithTag(7, r18);
            L26:
                int r20 = r17 + r19;
                Boolean r21 = r6.mis_blocked;
                if (r21 == null) goto L29;
                int r22 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r21);
            L30:
                int r23 = r20 + r22;
                BlockStatus r24 = r6.mblock_status;
                if (r24 == null) goto L33;
                int r25 = BlockStatus.ADAPTER.encodedSizeWithTag(9, r24);
            L34:
                int r26 = r23 + r25;
                UserTag r27 = r6.muser_tag;
                if (r27 == null) goto L37;
                int r28 = UserTag.ADAPTER.encodedSizeWithTag(10, r27);
            L38:
                int r29 = r26 + r28;
                Boolean r30 = r6.mis_tenant_certification;
                if (r30 == null) goto L41;
                int r31 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r30);
            L42:
                int r32 = r29 + r31;
                String r33 = r6.mtenant_certification_url;
                if (r33 == null) goto L45;
                int r34 = ProtoAdapter.STRING.encodedSizeWithTag(12, r33);
            L46:
                int r35 = (r32 + r34) + Field.ADAPTER.asRepeated().encodedSizeWithTag(13, r6.mcustom_tag_fields);
                ImageSetPassThrough r36 = r6.mtop_image;
                if (r36 == null) goto L49;
                int r37 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(14, r36);
            L50:
                int r38 = r35 + r37;
                ShareInfo r39 = r6.mshare_info;
                if (r39 == null) goto L53;
                int r40 = ShareInfo.ADAPTER.encodedSizeWithTag(15, r39);
            L54:
                int r41 = r38 + r40;
                Boolean r42 = r6.mshow_description;
                if (r42 == null) goto L57;
                int r43 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r42);
            L58:
                int r44 = r41 + r43;
                MedalList r45 = r6.mmedal_list;
                if (r45 == null) goto L61;
                int r46 = MedalList.ADAPTER.encodedSizeWithTag(17, r45);
            L62:
                int r47 = r44 + r46;
                Boolean r48 = r6.mis_special_focus;
                if (r48 == null) goto L65;
                int r49 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r48);
            L66:
                int r50 = r47 + r49;
                String r51 = r6.mgender_pronouns;
                if (r51 == null) goto L69;
                int r52 = ProtoAdapter.STRING.encodedSizeWithTag(19, r51);
            L70:
                int r53 = r50 + r52;
                I18nVal r54 = r6.mcross_meta_unit_description;
                if (r54 == null) goto L73;
                int r55 = I18nVal.ADAPTER.encodedSizeWithTag(20, r54);
            L74:
                int r56 = r53 + r55;
                CertificationInfo r57 = r6.mcertification_info;
                if (r57 == null) goto L77;
                int r58 = CertificationInfo.ADAPTER.encodedSizeWithTag(21, r57);
            L78:
                int r59 = r56 + r58;
                TenantNameStatus r60 = r6.mtenant_name_status;
                if (r60 == null) goto L81;
                int r61 = TenantNameStatus.ADAPTER.encodedSizeWithTag(22, r60);
            L82:
                int r62 = r59 + r61;
                ApplyCommunication r63 = r6.mapply_communication;
                if (r63 == null) goto L85;
                int r64 = ApplyCommunication.ADAPTER.encodedSizeWithTag(23, r63);
            L86:
                int r65 = r62 + r64;
                Boolean r66 = r6.mcan_block;
                if (r66 == null) goto L89;
                int r67 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r66);
            L90:
                int r68 = r65 + r67;
                Boolean r69 = r6.mhide_add_connect_button;
                if (r69 == null) goto L93;
                int r70 = ProtoAdapter.BOOL.encodedSizeWithTag(25, r69);
            L94:
                int r71 = r68 + r70;
                Boolean r72 = r6.mcan_set_stranger;
                if (r72 == null) goto L97;
                int r73 = ProtoAdapter.BOOL.encodedSizeWithTag(26, r72);
            L98:
                int r74 = r71 + r73;
                Boolean r75 = r6.mis_stranger;
                if (r75 == null) goto L101;
                int r76 = ProtoAdapter.BOOL.encodedSizeWithTag(27, r75);
            L102:
                int r77 = r74 + r76;
                Boolean r78 = r6.mis_lh;
                if (r78 == null) goto L106;
                r2 = ProtoAdapter.BOOL.encodedSizeWithTag(28, r78);
            L106:
                return (r77 + r2) + r6.unknownFields().size();
            L101:
                r76 = 0;
                goto L102
            L97:
                r73 = 0;
                goto L98
            L93:
                r70 = 0;
                goto L94
            L89:
                r67 = 0;
                goto L90
            L85:
                r64 = 0;
                goto L86
            L81:
                r61 = 0;
                goto L82
            L77:
                r58 = 0;
                goto L78
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
                r31 = 0;
                goto L42
            L37:
                r28 = 0;
                goto L38
            L33:
                r25 = 0;
                goto L34
            L29:
                r22 = 0;
                goto L30
            L25:
                r19 = 0;
                goto L26
            L21:
                r16 = 0;
                goto L22
            L17:
                r13 = 0;
                goto L18
            L13:
                r10 = 0;
                goto L14
            L9:
                r7 = 0;
                goto L10
            L5:
                r3 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3081decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserInfo) r1);
            }

            public void encode(ProtoWriter r4, UserInfo r5) throws IOException {
                FriendStatus.ADAPTER.encodeWithTag(r4, 1, r5.mfriend_status);
                Gender r0 = r5.mgender;
                if (r0 == null) goto L5;
                Gender.ADAPTER.encodeWithTag(r4, 2, r0);
            L5:
                I18nVal r1 = r5.mtenant_name;
                if (r1 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r4, 3, r1);
            L8:
                String r2 = r5.mcontact_token;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
            L11:
                Long r3 = r5.mcontact_application_id;
                if (r3 == null) goto L14;
                ProtoAdapter.INT64.encodeWithTag(r4, 5, r3);
            L14:
                Boolean r6 = r5.menable_add_by_contact_token;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
            L17:
                String r7 = r5.mleader_id;
                if (r7 == null) goto L20;
                ProtoAdapter.STRING.encodeWithTag(r4, 7, r7);
            L20:
                Boolean r8 = r5.mis_blocked;
                if (r8 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r8);
            L23:
                BlockStatus r9 = r5.mblock_status;
                if (r9 == null) goto L26;
                BlockStatus.ADAPTER.encodeWithTag(r4, 9, r9);
            L26:
                UserTag r10 = r5.muser_tag;
                if (r10 == null) goto L29;
                UserTag.ADAPTER.encodeWithTag(r4, 10, r10);
            L29:
                Boolean r11 = r5.mis_tenant_certification;
                if (r11 == null) goto L32;
                ProtoAdapter.BOOL.encodeWithTag(r4, 11, r11);
            L32:
                String r12 = r5.mtenant_certification_url;
                if (r12 == null) goto L35;
                ProtoAdapter.STRING.encodeWithTag(r4, 12, r12);
            L35:
                Field.ADAPTER.asRepeated().encodeWithTag(r4, 13, r5.mcustom_tag_fields);
                ImageSetPassThrough r13 = r5.mtop_image;
                if (r13 == null) goto L38;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 14, r13);
            L38:
                ShareInfo r14 = r5.mshare_info;
                if (r14 == null) goto L41;
                ShareInfo.ADAPTER.encodeWithTag(r4, 15, r14);
            L41:
                Boolean r15 = r5.mshow_description;
                if (r15 == null) goto L44;
                ProtoAdapter.BOOL.encodeWithTag(r4, 16, r15);
            L44:
                MedalList r16 = r5.mmedal_list;
                if (r16 == null) goto L47;
                MedalList.ADAPTER.encodeWithTag(r4, 17, r16);
            L47:
                Boolean r17 = r5.mis_special_focus;
                if (r17 == null) goto L50;
                ProtoAdapter.BOOL.encodeWithTag(r4, 18, r17);
            L50:
                String r18 = r5.mgender_pronouns;
                if (r18 == null) goto L53;
                ProtoAdapter.STRING.encodeWithTag(r4, 19, r18);
            L53:
                I18nVal r19 = r5.mcross_meta_unit_description;
                if (r19 == null) goto L56;
                I18nVal.ADAPTER.encodeWithTag(r4, 20, r19);
            L56:
                CertificationInfo r20 = r5.mcertification_info;
                if (r20 == null) goto L59;
                CertificationInfo.ADAPTER.encodeWithTag(r4, 21, r20);
            L59:
                TenantNameStatus r21 = r5.mtenant_name_status;
                if (r21 == null) goto L62;
                TenantNameStatus.ADAPTER.encodeWithTag(r4, 22, r21);
            L62:
                ApplyCommunication r22 = r5.mapply_communication;
                if (r22 == null) goto L65;
                ApplyCommunication.ADAPTER.encodeWithTag(r4, 23, r22);
            L65:
                Boolean r23 = r5.mcan_block;
                if (r23 == null) goto L68;
                ProtoAdapter.BOOL.encodeWithTag(r4, 24, r23);
            L68:
                Boolean r24 = r5.mhide_add_connect_button;
                if (r24 == null) goto L71;
                ProtoAdapter.BOOL.encodeWithTag(r4, 25, r24);
            L71:
                Boolean r25 = r5.mcan_set_stranger;
                if (r25 == null) goto L74;
                ProtoAdapter.BOOL.encodeWithTag(r4, 26, r25);
            L74:
                Boolean r26 = r5.mis_stranger;
                if (r26 == null) goto L77;
                ProtoAdapter.BOOL.encodeWithTag(r4, 27, r26);
            L77:
                Boolean r27 = r5.mis_lh;
                if (r27 == null) goto L80;
                ProtoAdapter.BOOL.encodeWithTag(r4, 28, r27);
            L80:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserInfo();
            FIELD_OPTIONS_MLEADER_ID = new FieldOptions.Builder().id("user_id").build();
            DEFAULT_CONTACT_APPLICATION_ID = 0L;
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ENABLE_ADD_BY_CONTACT_TOKEN = r0;
            DEFAULT_IS_BLOCKED = r0;
            DEFAULT_IS_TENANT_CERTIFICATION = r0;
            DEFAULT_SHOW_DESCRIPTION = r0;
            DEFAULT_IS_SPECIAL_FOCUS = r0;
            DEFAULT_CAN_BLOCK = r0;
            DEFAULT_HIDE_ADD_CONNECT_BUTTON = r0;
            DEFAULT_CAN_SET_STRANGER = r0;
            DEFAULT_IS_STRANGER = r0;
            DEFAULT_IS_LH = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3079newBuilder() {
            Builder r0 = new Builder();
            r0.mfriend_status = this.mfriend_status;
            r0.mgender = this.mgender;
            r0.mtenant_name = this.mtenant_name;
            r0.mcontact_token = this.mcontact_token;
            r0.mcontact_application_id = this.mcontact_application_id;
            r0.menable_add_by_contact_token = this.menable_add_by_contact_token;
            r0.mleader_id = this.mleader_id;
            r0.mis_blocked = this.mis_blocked;
            r0.mblock_status = this.mblock_status;
            r0.muser_tag = this.muser_tag;
            r0.mis_tenant_certification = this.mis_tenant_certification;
            r0.mtenant_certification_url = this.mtenant_certification_url;
            r0.mcustom_tag_fields = Internal.copyOf("mcustom_tag_fields", this.mcustom_tag_fields);
            r0.mtop_image = this.mtop_image;
            r0.mshare_info = this.mshare_info;
            r0.mshow_description = this.mshow_description;
            r0.mmedal_list = this.mmedal_list;
            r0.mis_special_focus = this.mis_special_focus;
            r0.mgender_pronouns = this.mgender_pronouns;
            r0.mcross_meta_unit_description = this.mcross_meta_unit_description;
            r0.mcertification_info = this.mcertification_info;
            r0.mtenant_name_status = this.mtenant_name_status;
            r0.mapply_communication = this.mapply_communication;
            r0.mcan_block = this.mcan_block;
            r0.mhide_add_connect_button = this.mhide_add_connect_button;
            r0.mcan_set_stranger = this.mcan_set_stranger;
            r0.mis_stranger = this.mis_stranger;
            r0.mis_lh = this.mis_lh;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3079newBuilder();
        }

        public UserInfo(FriendStatus r31, Gender r32, I18nVal r33, String r34, Long r35, Boolean r36, String r37, Boolean r38, BlockStatus r39, UserTag r40, Boolean r41, String r42, List<Field> r43, ImageSetPassThrough r44, ShareInfo r45, Boolean r46, MedalList r47, Boolean r48, String r49, I18nVal r50, CertificationInfo r51, TenantNameStatus r52, ApplyCommunication r53, Boolean r54, Boolean r55, Boolean r56, Boolean r57, Boolean r58) {
            this(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, ByteString.EMPTY);
        }

        public UserInfo(FriendStatus r4, Gender r5, I18nVal r6, String r7, Long r8, Boolean r9, String r10, Boolean r11, BlockStatus r12, UserTag r13, Boolean r14, String r15, List<Field> r16, ImageSetPassThrough r17, ShareInfo r18, Boolean r19, MedalList r20, Boolean r21, String r22, I18nVal r23, CertificationInfo r24, TenantNameStatus r25, ApplyCommunication r26, Boolean r27, Boolean r28, Boolean r29, Boolean r30, Boolean r31, ByteString r32) {
            super(ADAPTER, r32);
            this.mfriend_status = r4;
            this.mgender = r5;
            this.mtenant_name = r6;
            this.mcontact_token = r7;
            this.mcontact_application_id = r8;
            this.menable_add_by_contact_token = r9;
            this.mleader_id = r10;
            this.mis_blocked = r11;
            this.mblock_status = r12;
            this.muser_tag = r13;
            this.mis_tenant_certification = r14;
            this.mtenant_certification_url = r15;
            this.mcustom_tag_fields = Internal.immutableCopyOf("mcustom_tag_fields", r16);
            this.mtop_image = r17;
            this.mshare_info = r18;
            this.mshow_description = r19;
            this.mmedal_list = r20;
            this.mis_special_focus = r21;
            this.mgender_pronouns = r22;
            this.mcross_meta_unit_description = r23;
            this.mcertification_info = r24;
            this.mtenant_name_status = r25;
            this.mapply_communication = r26;
            this.mcan_block = r27;
            this.mhide_add_connect_button = r28;
            this.mcan_set_stranger = r29;
            this.mis_stranger = r30;
            this.mis_lh = r31;
        }
    }

    public static final enum UserTag extends Enum<UserTag> implements WireEnum {
        private static final /* synthetic */ UserTag[] $VALUES = null;
        public static final ProtoAdapter<UserTag> ADAPTER = null;
        public static final UserTag U_Default = null;
        public static final UserTag U_Parent = null;
        public static final UserTag U_Student = null;
        private final int value;

        static {
            UserTag r0 = new UserTag("U_Default", 0, 0);
            U_Default = r0;
            UserTag r1 = new UserTag("U_Student", 1, 1);
            U_Student = r1;
            UserTag r3 = new UserTag("U_Parent", 2, 2);
            U_Parent = r3;
            $VALUES = new UserTag[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(UserTag.class);
        }

        public static UserTag[] values() {
            return (UserTag[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static UserTag fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return U_Parent;
        L12:
            return U_Student;
        L14:
            return U_Default;
        }

        public static UserTag valueOf(String r1) {
            return (UserTag) a.a(UserTag.class, r1);
        }

        private UserTag(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Profile();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3007newBuilder() {
        Builder r0 = new Builder();
        r0.muser_info = this.muser_info;
        r0.mctas = Internal.copyOf("mctas", this.mctas);
        r0.mfields = Internal.copyOf("mfields", this.mfields);
        r0.mtabs = Internal.copyOf("mtabs", this.mtabs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Profile.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3007newBuilder();
    }

    public Profile(UserInfo r7, List<CTA> r8, List<Field> r9, List<TabInfo> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public Profile(UserInfo r2, List<CTA> r3, List<Field> r4, List<TabInfo> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.muser_info = r2;
        this.mctas = Internal.immutableCopyOf("mctas", r3);
        this.mfields = Internal.immutableCopyOf("mfields", r4);
        this.mtabs = Internal.immutableCopyOf("mtabs", r5);
    }
}
