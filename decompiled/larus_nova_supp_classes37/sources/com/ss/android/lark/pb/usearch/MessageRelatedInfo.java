package com.ss.android.lark.pb.usearch;

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
public final class MessageRelatedInfo extends Message<MessageRelatedInfo, Builder> {
    public static final ProtoAdapter<MessageRelatedInfo> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_FROM_TENANT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final String mfrom_id;
    public final String mfrom_tenant_id;
    public final String mid;
    public final Boolean mis_restricted;
    public final Integer mposition;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final Integer mthread_position;

    public static final class Builder extends Message.Builder<MessageRelatedInfo, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public String mfrom_id;
        public String mfrom_tenant_id;
        public String mid;
        public Boolean mis_restricted;
        public Integer mposition;
        public Integer mthread_chat_position;
        public String mthread_id;
        public Integer mthread_position;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageRelatedInfo m2726build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new MessageRelatedInfo(this.mid, this.mposition, this.mcreate_time, this.mthread_position, this.mthread_id, this.mthread_chat_position, this.mchat_id, this.mis_restricted, this.mdisabled_action, this.mfrom_id, this.mfrom_tenant_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2726build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdisabled_action = r1;
            return this;
        }

        public Builder from_id(String r1) {
            this.mfrom_id = r1;
            return this;
        }

        public Builder from_tenant_id(String r1) {
            this.mfrom_tenant_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_restricted(Boolean r1) {
            this.mis_restricted = r1;
            return this;
        }

        public Builder position(Integer r1) {
            this.mposition = r1;
            return this;
        }

        public Builder thread_chat_position(Integer r1) {
            this.mthread_chat_position = r1;
            return this;
        }

        public Builder thread_id(String r1) {
            this.mthread_id = r1;
            return this;
        }

        public Builder thread_position(Integer r1) {
            this.mthread_position = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageRelatedInfo extends ProtoAdapter<MessageRelatedInfo> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_MessageRelatedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageRelatedInfo.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public MessageRelatedInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mposition = 0;
            r0.mcreate_time = 0L;
            r0.mthread_position = 0;
            r0.mthread_id = "";
            r0.mthread_chat_position = 0;
            r0.mchat_id = "";
            r0.mis_restricted = Boolean.FALSE;
            r0.mfrom_id = "";
            r0.mfrom_tenant_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r0.mfrom_tenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mfrom_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mdisabled_action.putAll((Map) this.mdisabled_action.decode(r7));
            goto L3
        L10:
            r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L13:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L16:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L17:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2726build();
        }

        public int encodedSize(MessageRelatedInfo r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Integer r2 = r7.mposition;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Long r6 = r7.mcreate_time;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Integer r10 = r7.mthread_position;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mthread_id;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Integer r16 = r7.mthread_chat_position;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mchat_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            Boolean r22 = r7.mis_restricted;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
        L30:
            int r24 = (r21 + r23) + this.mdisabled_action.encodedSizeWithTag(9, r7.mdisabled_action);
            String r25 = r7.mfrom_id;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(10, r25);
        L34:
            int r27 = r24 + r26;
            String r28 = r7.mfrom_tenant_id;
            if (r28 == null) goto L38;
            r3 = r0.encodedSizeWithTag(11, r28);
        L38:
            return (r27 + r3) + r7.unknownFields().size();
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Object m2727decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageRelatedInfo) r1);
        }

        public void encode(ProtoWriter r5, MessageRelatedInfo r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Integer r1 = r6.mposition;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r1);
        L5:
            Long r2 = r6.mcreate_time;
            if (r2 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L8:
            Integer r3 = r6.mthread_position;
            if (r3 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.mthread_id;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 5, r4);
        L14:
            Integer r7 = r6.mthread_chat_position;
            if (r7 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mchat_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            Boolean r9 = r6.mis_restricted;
            if (r9 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r5, 8, r9);
        L23:
            this.mdisabled_action.encodeWithTag(r5, 9, r6.mdisabled_action);
            String r10 = r6.mfrom_id;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 10, r10);
        L26:
            String r11 = r6.mfrom_tenant_id;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 11, r11);
        L29:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageRelatedInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageRelatedInfo();
        DEFAULT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_RESTRICTED = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2725newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mposition = this.mposition;
        r0.mcreate_time = this.mcreate_time;
        r0.mthread_position = this.mthread_position;
        r0.mthread_id = this.mthread_id;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.mchat_id = this.mchat_id;
        r0.mis_restricted = this.mis_restricted;
        r0.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r0.mfrom_id = this.mfrom_id;
        r0.mfrom_tenant_id = this.mfrom_tenant_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageRelatedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2725newBuilder();
    }

    public MessageRelatedInfo(String r14, Integer r15, Long r16, Integer r17, String r18, Integer r19, String r20, Boolean r21, Map<Integer, MessageBehavior> r22, String r23, String r24) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
    }

    public MessageRelatedInfo(String r2, Integer r3, Long r4, Integer r5, String r6, Integer r7, String r8, Boolean r9, Map<Integer, MessageBehavior> r10, String r11, String r12, ByteString r13) {
        super(ADAPTER, r13);
        this.mid = r2;
        this.mposition = r3;
        this.mcreate_time = r4;
        this.mthread_position = r5;
        this.mthread_id = r6;
        this.mthread_chat_position = r7;
        this.mchat_id = r8;
        this.mis_restricted = r9;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r10);
        this.mfrom_id = r11;
        this.mfrom_tenant_id = r12;
    }
}
