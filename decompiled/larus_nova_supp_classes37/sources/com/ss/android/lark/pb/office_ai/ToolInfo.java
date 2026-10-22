package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ToolInfo extends Message<ToolInfo, Builder> {
    public static final ProtoAdapter<ToolInfo> ADAPTER = null;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_DETAIL = "";
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mdesc;
    public final String mdetail;
    public final String micon;
    public final String mid;
    public final Map<String, String> mlocale_2_desc;
    public final Map<String, String> mlocale_2_detail;
    public final Map<String, String> mlocale_2_name;
    public final String mname;

    public static final class Builder extends Message.Builder<ToolInfo, Builder> {
        public String mdesc;
        public String mdetail;
        public String micon;
        public String mid;
        public Map<String, String> mlocale_2_desc;
        public Map<String, String> mlocale_2_detail;
        public Map<String, String> mlocale_2_name;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ToolInfo m2030build() {
            return new ToolInfo(this.mid, this.mname, this.micon, this.mdesc, this.mdetail, this.mlocale_2_name, this.mlocale_2_desc, this.mlocale_2_detail, super.buildUnknownFields());
        }

        public Builder() {
            this.mlocale_2_name = Internal.newMutableMap();
            this.mlocale_2_desc = Internal.newMutableMap();
            this.mlocale_2_detail = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2030build();
        }

        public Builder desc(String r1) {
            this.mdesc = r1;
            return this;
        }

        public Builder detail(String r1) {
            this.mdetail = r1;
            return this;
        }

        public Builder icon(String r1) {
            this.micon = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder locale_2_desc(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlocale_2_desc = r1;
            return this;
        }

        public Builder locale_2_detail(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlocale_2_detail = r1;
            return this;
        }

        public Builder locale_2_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlocale_2_name = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ToolInfo extends ProtoAdapter<ToolInfo> {
        private final ProtoAdapter<Map<String, String>> mlocale_2_desc;
        private final ProtoAdapter<Map<String, String>> mlocale_2_detail;
        private final ProtoAdapter<Map<String, String>> mlocale_2_name;

        public ProtoAdapter_ToolInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ToolInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mlocale_2_name = ProtoAdapter.newMapAdapter(r0, r0);
            this.mlocale_2_desc = ProtoAdapter.newMapAdapter(r0, r0);
            this.mlocale_2_detail = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ToolInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mname = "";
            r0.micon = "";
            r0.mdesc = "";
            r0.mdetail = "";
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
            r0.mlocale_2_detail.putAll((Map) this.mlocale_2_detail.decode(r7));
            goto L3
        L8:
            r0.mlocale_2_desc.putAll((Map) this.mlocale_2_desc.decode(r7));
            goto L3
        L9:
            r0.mlocale_2_name.putAll((Map) this.mlocale_2_name.decode(r7));
            goto L3
        L10:
            r0.mdetail = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mdesc = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.micon = (String) ProtoAdapter.STRING.decode(r7);
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
            return r0.m2030build();
        }

        public int encodedSize(ToolInfo r6) {
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
            String r7 = r6.micon;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mdesc;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mdetail;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            return ((((r12 + r1) + this.mlocale_2_name.encodedSizeWithTag(6, r6.mlocale_2_name)) + this.mlocale_2_desc.encodedSizeWithTag(7, r6.mlocale_2_desc)) + this.mlocale_2_detail.encodedSizeWithTag(8, r6.mlocale_2_detail)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2031decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ToolInfo) r1);
        }

        public void encode(ProtoWriter r4, ToolInfo r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.micon;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mdesc;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mdetail;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            this.mlocale_2_name.encodeWithTag(r4, 6, r5.mlocale_2_name);
            this.mlocale_2_desc.encodeWithTag(r4, 7, r5.mlocale_2_desc);
            this.mlocale_2_detail.encodeWithTag(r4, 8, r5.mlocale_2_detail);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ToolInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ToolInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2029newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.micon = this.micon;
        r0.mdesc = this.mdesc;
        r0.mdetail = this.mdetail;
        r0.mlocale_2_name = Internal.copyOf("mlocale_2_name", this.mlocale_2_name);
        r0.mlocale_2_desc = Internal.copyOf("mlocale_2_desc", this.mlocale_2_desc);
        r0.mlocale_2_detail = Internal.copyOf("mlocale_2_detail", this.mlocale_2_detail);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ToolInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2029newBuilder();
    }

    public ToolInfo(String r11, String r12, String r13, String r14, String r15, Map<String, String> r16, Map<String, String> r17, Map<String, String> r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public ToolInfo(String r2, String r3, String r4, String r5, String r6, Map<String, String> r7, Map<String, String> r8, Map<String, String> r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mid = r2;
        this.mname = r3;
        this.micon = r4;
        this.mdesc = r5;
        this.mdetail = r6;
        this.mlocale_2_name = Internal.immutableCopyOf("mlocale_2_name", r7);
        this.mlocale_2_desc = Internal.immutableCopyOf("mlocale_2_desc", r8);
        this.mlocale_2_detail = Internal.immutableCopyOf("mlocale_2_detail", r9);
    }
}
