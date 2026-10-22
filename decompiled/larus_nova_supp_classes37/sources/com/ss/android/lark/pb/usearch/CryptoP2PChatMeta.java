package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ChatterCustomStatus;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CryptoP2PChatMeta extends Message<CryptoP2PChatMeta, Builder> {
    public static final ProtoAdapter<CryptoP2PChatMeta> ADAPTER = null;
    public static final Boolean DEFAULT_ACCEPT_SMS_PHONE_URGENT = null;
    public static final String DEFAULT_CHATTER_ID = "";
    public static final Long DEFAULT_DO_NOT_DISTURB_END_TIME = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_REGISTERED = null;
    public static final String DEFAULT_MAIL_ADDRESS = "";
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final Boolean maccept_sms_phone_urgent;
    public final String mchatter_id;
    public final List<ChatterCustomStatus> mcustom_statuses;
    public final Long mdo_not_disturb_end_time;
    public final String mid;
    public final Boolean mis_registered;
    public final String mmail_address;
    public final TagData mrelation_tag;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<CryptoP2PChatMeta, Builder> {
        public Boolean maccept_sms_phone_urgent;
        public String mchatter_id;
        public List<ChatterCustomStatus> mcustom_statuses;
        public Long mdo_not_disturb_end_time;
        public String mid;
        public Boolean mis_registered;
        public String mmail_address;
        public TagData mrelation_tag;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CryptoP2PChatMeta m2573build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new CryptoP2PChatMeta(this.mid, this.mis_registered, this.mtenant_id, this.mmail_address, this.mdo_not_disturb_end_time, this.maccept_sms_phone_urgent, this.mchatter_id, this.mcustom_statuses, this.mrelation_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mcustom_statuses = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2573build();
        }

        public Builder accept_sms_phone_urgent(Boolean r1) {
            this.maccept_sms_phone_urgent = r1;
            return this;
        }

        public Builder chatter_id(String r1) {
            this.mchatter_id = r1;
            return this;
        }

        public Builder custom_statuses(List<ChatterCustomStatus> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcustom_statuses = r1;
            return this;
        }

        public Builder do_not_disturb_end_time(Long r1) {
            this.mdo_not_disturb_end_time = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_registered(Boolean r1) {
            this.mis_registered = r1;
            return this;
        }

        public Builder mail_address(String r1) {
            this.mmail_address = r1;
            return this;
        }

        public Builder relation_tag(TagData r1) {
            this.mrelation_tag = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoP2PChatMeta extends ProtoAdapter<CryptoP2PChatMeta> {
        public ProtoAdapter_CryptoP2PChatMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoP2PChatMeta.class);
        }

        public CryptoP2PChatMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_registered = r2;
            r0.mtenant_id = "";
            r0.mmail_address = "";
            r0.mdo_not_disturb_end_time = 0L;
            r0.maccept_sms_phone_urgent = r2;
            r0.mchatter_id = "";
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
            r0.mrelation_tag = (TagData) TagData.ADAPTER.decode(r7);
            goto L3
        L8:
            r0.mcustom_statuses.add((ChatterCustomStatus) ChatterCustomStatus.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.mchatter_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.maccept_sms_phone_urgent = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.mdo_not_disturb_end_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L12:
            r0.mmail_address = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mis_registered = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L15:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.m2573build();
        }

        public int encodedSize(CryptoP2PChatMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Boolean r2 = r7.mis_registered;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mtenant_id;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.mmail_address;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Long r13 = r7.mdo_not_disturb_end_time;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT64.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Boolean r16 = r7.maccept_sms_phone_urgent;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mchatter_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = (r18 + r20) + ChatterCustomStatus.ADAPTER.asRepeated().encodedSizeWithTag(8, r7.mcustom_statuses);
            TagData r22 = r7.mrelation_tag;
            if (r22 == null) goto L30;
            r3 = TagData.ADAPTER.encodedSizeWithTag(9, r22);
        L30:
            return (r21 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2574decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CryptoP2PChatMeta) r1);
        }

        public void encode(ProtoWriter r5, CryptoP2PChatMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Boolean r1 = r6.mis_registered;
            if (r1 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mtenant_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.mmail_address;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            Long r4 = r6.mdo_not_disturb_end_time;
            if (r4 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r5, 5, r4);
        L14:
            Boolean r7 = r6.maccept_sms_phone_urgent;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mchatter_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            ChatterCustomStatus.ADAPTER.asRepeated().encodeWithTag(r5, 8, r6.mcustom_statuses);
            TagData r9 = r6.mrelation_tag;
            if (r9 == null) goto L23;
            TagData.ADAPTER.encodeWithTag(r5, 9, r9);
        L23:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CryptoP2PChatMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoP2PChatMeta();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_REGISTERED = r0;
        DEFAULT_DO_NOT_DISTURB_END_TIME = 0L;
        DEFAULT_ACCEPT_SMS_PHONE_URGENT = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2572newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mis_registered = this.mis_registered;
        r0.mtenant_id = this.mtenant_id;
        r0.mmail_address = this.mmail_address;
        r0.mdo_not_disturb_end_time = this.mdo_not_disturb_end_time;
        r0.maccept_sms_phone_urgent = this.maccept_sms_phone_urgent;
        r0.mchatter_id = this.mchatter_id;
        r0.mcustom_statuses = Internal.copyOf("mcustom_statuses", this.mcustom_statuses);
        r0.mrelation_tag = this.mrelation_tag;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CryptoP2PChatMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2572newBuilder();
    }

    public CryptoP2PChatMeta(String r12, Boolean r13, String r14, String r15, Long r16, Boolean r17, String r18, List<ChatterCustomStatus> r19, TagData r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public CryptoP2PChatMeta(String r2, Boolean r3, String r4, String r5, Long r6, Boolean r7, String r8, List<ChatterCustomStatus> r9, TagData r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mid = r2;
        this.mis_registered = r3;
        this.mtenant_id = r4;
        this.mmail_address = r5;
        this.mdo_not_disturb_end_time = r6;
        this.maccept_sms_phone_urgent = r7;
        this.mchatter_id = r8;
        this.mcustom_statuses = Internal.immutableCopyOf("mcustom_statuses", r9);
        this.mrelation_tag = r10;
    }
}
