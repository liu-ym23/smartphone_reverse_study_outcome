package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QuickActionParam extends Message<QuickActionParam, Builder> {
    public static final ProtoAdapter<QuickActionParam> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final String DEFAULT_NAME = "";
    public static final Boolean DEFAULT_NEED_CONFIRM = null;
    public static final String DEFAULT_PLACE_HOLDER = "";
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final String mdisplay_name;
    public final String mid;
    public final Boolean mis_optional;
    public final String mname;
    public final Boolean mneed_confirm;
    public final String mplace_holder;

    public static final class Builder extends Message.Builder<QuickActionParam, Builder> {
        public String mdescription;
        public String mdisplay_name;
        public String mid;
        public Boolean mis_optional;
        public String mname;
        public Boolean mneed_confirm;
        public String mplace_holder;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public QuickActionParam m2048build() {
            return new QuickActionParam(this.mid, this.mname, this.mis_optional, this.mneed_confirm, this.mdescription, this.mplace_holder, this.mdisplay_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2048build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder display_name(String r1) {
            this.mdisplay_name = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_optional(Boolean r1) {
            this.mis_optional = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder need_confirm(Boolean r1) {
            this.mneed_confirm = r1;
            return this;
        }

        public Builder place_holder(String r1) {
            this.mplace_holder = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_QuickActionParam extends ProtoAdapter<QuickActionParam> {
        public ProtoAdapter_QuickActionParam() {
            super(FieldEncoding.LENGTH_DELIMITED, QuickActionParam.class);
        }

        public QuickActionParam decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_optional = r2;
            r0.mneed_confirm = r2;
            r0.mdescription = "";
            r0.mplace_holder = "";
            r0.mdisplay_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L6;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r0.mdisplay_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mplace_holder = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mneed_confirm = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.mis_optional = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m2048build();
        }

        public int encodedSize(QuickActionParam r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_optional;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mneed_confirm;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mdescription;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(6, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mplace_holder;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(7, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mdisplay_name;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(8, r19);
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
        public /* bridge */ /* synthetic */ Object m2049decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((QuickActionParam) r1);
        }

        public void encode(ProtoWriter r4, QuickActionParam r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_optional;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mneed_confirm;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r3);
        L14:
            String r6 = r5.mdescription;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r6);
        L17:
            String r7 = r5.mplace_holder;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r7);
        L20:
            String r8 = r5.mdisplay_name;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (QuickActionParam) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QuickActionParam();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_OPTIONAL = r0;
        DEFAULT_NEED_CONFIRM = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2047newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mis_optional = this.mis_optional;
        r0.mneed_confirm = this.mneed_confirm;
        r0.mdescription = this.mdescription;
        r0.mplace_holder = this.mplace_holder;
        r0.mdisplay_name = this.mdisplay_name;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return QuickActionParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2047newBuilder();
    }

    public QuickActionParam(String r10, String r11, Boolean r12, Boolean r13, String r14, String r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public QuickActionParam(String r2, String r3, Boolean r4, Boolean r5, String r6, String r7, String r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mid = r2;
        this.mname = r3;
        this.mis_optional = r4;
        this.mneed_confirm = r5;
        this.mdescription = r6;
        this.mplace_holder = r7;
        this.mdisplay_name = r8;
    }
}
