package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Param extends Message<Param, Builder> {
    public static final ProtoAdapter<Param> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_ = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_OPTIONAL = null;
    public static final String DEFAULT_NAME = "";
    public static final Boolean DEFAULT_NEED_CONFIRM = null;
    public static final String DEFAULT_PLACE_HOLDER = "";
    private static final long serialVersionUID = 0;
    public final String mdefault_;
    public final String mdescription;
    public final String mdisplay_name;
    public final String mid;
    public final Boolean mis_optional;
    public final String mname;
    public final Boolean mneed_confirm;
    public final String mplace_holder;

    public static final class Builder extends Message.Builder<Param, Builder> {
        public String mdefault_;
        public String mdescription;
        public String mdisplay_name;
        public String mid;
        public Boolean mis_optional;
        public String mname;
        public Boolean mneed_confirm;
        public String mplace_holder;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Param m1976build() {
            return new Param(this.mid, this.mname, this.mis_optional, this.mdefault_, this.mneed_confirm, this.mdescription, this.mplace_holder, this.mdisplay_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1976build();
        }

        public Builder default_(String r1) {
            this.mdefault_ = r1;
            return this;
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

    public static final class ProtoAdapter_Param extends ProtoAdapter<Param> {
        public ProtoAdapter_Param() {
            super(FieldEncoding.LENGTH_DELIMITED, Param.class);
        }

        public Param decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_optional = r2;
            r0.mdefault_ = "";
            r0.mneed_confirm = r2;
            r0.mdescription = "";
            r0.mplace_holder = "";
            r0.mdisplay_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
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
            r0.mdefault_ = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mis_optional = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1976build();
        }

        public int encodedSize(Param r6) {
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
            String r10 = r6.mdefault_;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mneed_confirm;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mdescription;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mplace_holder;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mdisplay_name;
            if (r22 == null) goto L34;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            return (r21 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1977decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Param) r1);
        }

        public void encode(ProtoWriter r4, Param r5) throws IOException {
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
            String r3 = r5.mdefault_;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mneed_confirm;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mdescription;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mplace_holder;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mdisplay_name;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Param) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Param();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_OPTIONAL = r0;
        DEFAULT_NEED_CONFIRM = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1975newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mis_optional = this.mis_optional;
        r0.mdefault_ = this.mdefault_;
        r0.mneed_confirm = this.mneed_confirm;
        r0.mdescription = this.mdescription;
        r0.mplace_holder = this.mplace_holder;
        r0.mdisplay_name = this.mdisplay_name;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Param.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1975newBuilder();
    }

    public Param(String r11, String r12, Boolean r13, String r14, Boolean r15, String r16, String r17, String r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public Param(String r2, String r3, Boolean r4, String r5, Boolean r6, String r7, String r8, String r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mid = r2;
        this.mname = r3;
        this.mis_optional = r4;
        this.mdefault_ = r5;
        this.mneed_confirm = r6;
        this.mdescription = r7;
        this.mplace_holder = r8;
        this.mdisplay_name = r9;
    }
}
