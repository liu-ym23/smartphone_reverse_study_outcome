package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoBizInfo extends Message<DoubaoBizInfo, Builder> {
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
    public final String mapp_id;
    public final String mbiz_id;
    public final String mconversation_id;
    public final String mdevice_id;
    public final String mmessage_id;
    public final String mrecording_id;
    public final String mreply_message_id;
    public final String mtenant_id;
    public final String muser_id;

    public static final class Builder extends Message.Builder<DoubaoBizInfo, Builder> {
        public String mapp_id;
        public String mbiz_id;
        public String mconversation_id;
        public String mdevice_id;
        public String mmessage_id;
        public String mrecording_id;
        public String mreply_message_id;
        public String mtenant_id;
        public String muser_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DoubaoBizInfo m3107build() {
            return new DoubaoBizInfo(this.muser_id, this.mconversation_id, this.mmessage_id, this.mreply_message_id, this.mbiz_id, this.mapp_id, this.mtenant_id, this.mdevice_id, this.mrecording_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3107build();
        }

        public Builder app_id(String r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder biz_id(String r1) {
            this.mbiz_id = r1;
            return this;
        }

        public Builder conversation_id(String r1) {
            this.mconversation_id = r1;
            return this;
        }

        public Builder device_id(String r1) {
            this.mdevice_id = r1;
            return this;
        }

        public Builder message_id(String r1) {
            this.mmessage_id = r1;
            return this;
        }

        public Builder recording_id(String r1) {
            this.mrecording_id = r1;
            return this;
        }

        public Builder reply_message_id(String r1) {
            this.mreply_message_id = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder user_id(String r1) {
            this.muser_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoBizInfo extends ProtoAdapter<DoubaoBizInfo> {
        public ProtoAdapter_DoubaoBizInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoBizInfo.class);
        }

        public DoubaoBizInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.muser_id = "";
            r0.mconversation_id = "";
            r0.mmessage_id = "";
            r0.mreply_message_id = "";
            r0.mbiz_id = "";
            r0.mapp_id = "";
            r0.mtenant_id = "";
            r0.mdevice_id = "";
            r0.mrecording_id = "";
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
            r0.mrecording_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mdevice_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mapp_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mbiz_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mreply_message_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mconversation_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            r0.muser_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.m3107build();
        }

        public int encodedSize(DoubaoBizInfo r6) {
            String r0 = r6.muser_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mconversation_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mmessage_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mreply_message_id;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mbiz_id;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mapp_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mtenant_id;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mdevice_id;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.mrecording_id;
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
        public /* bridge */ /* synthetic */ Object m3108decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DoubaoBizInfo) r1);
        }

        public void encode(ProtoWriter r4, DoubaoBizInfo r5) throws IOException {
            String r0 = r5.muser_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mconversation_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mmessage_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mreply_message_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mbiz_id;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mapp_id;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mtenant_id;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mdevice_id;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            String r10 = r5.mrecording_id;
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
    public Builder m3106newBuilder() {
        Builder r0 = new Builder();
        r0.muser_id = this.muser_id;
        r0.mconversation_id = this.mconversation_id;
        r0.mmessage_id = this.mmessage_id;
        r0.mreply_message_id = this.mreply_message_id;
        r0.mbiz_id = this.mbiz_id;
        r0.mapp_id = this.mapp_id;
        r0.mtenant_id = this.mtenant_id;
        r0.mdevice_id = this.mdevice_id;
        r0.mrecording_id = this.mrecording_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DoubaoBizInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3106newBuilder();
    }

    public DoubaoBizInfo(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public DoubaoBizInfo(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.muser_id = r2;
        this.mconversation_id = r3;
        this.mmessage_id = r4;
        this.mreply_message_id = r5;
        this.mbiz_id = r6;
        this.mapp_id = r7;
        this.mtenant_id = r8;
        this.mdevice_id = r9;
        this.mrecording_id = r10;
    }
}
