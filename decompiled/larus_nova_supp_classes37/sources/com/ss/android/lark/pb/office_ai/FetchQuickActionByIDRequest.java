package com.ss.android.lark.pb.office_ai;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ChatContext;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FetchQuickActionByIDRequest extends Message<FetchQuickActionByIDRequest, Builder> {
    public static final ProtoAdapter<FetchQuickActionByIDRequest> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final String DEFAULT_AI_CHAT_MODE_ID = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CHECK_ID = "";
    public static final String DEFAULT_SYSTEM_META_DATA = "";
    public static final Long DEFAULT_THREAD_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String maction_id;
    public final String mai_chat_mode_id;
    public final ChatContext mchat_context;
    public final String mchat_id;
    public final String mcheck_id;
    public final String msystem_meta_data;
    public final Long mthread_id;

    public static final class Builder extends Message.Builder<FetchQuickActionByIDRequest, Builder> {
        public String maction_id;
        public String mai_chat_mode_id;
        public ChatContext mchat_context;
        public String mchat_id;
        public String mcheck_id;
        public String msystem_meta_data;
        public Long mthread_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FetchQuickActionByIDRequest m1946build() {
            return new FetchQuickActionByIDRequest(this.maction_id, this.mchat_id, this.mai_chat_mode_id, this.mcheck_id, this.mchat_context, this.msystem_meta_data, this.mthread_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1946build();
        }

        public Builder action_id(String r1) {
            this.maction_id = r1;
            return this;
        }

        public Builder ai_chat_mode_id(String r1) {
            this.mai_chat_mode_id = r1;
            return this;
        }

        public Builder chat_context(ChatContext r1) {
            this.mchat_context = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder check_id(String r1) {
            this.mcheck_id = r1;
            return this;
        }

        public Builder system_meta_data(String r1) {
            this.msystem_meta_data = r1;
            return this;
        }

        public Builder thread_id(Long r1) {
            this.mthread_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_FetchQuickActionByIDRequest extends ProtoAdapter<FetchQuickActionByIDRequest> {
        public ProtoAdapter_FetchQuickActionByIDRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FetchQuickActionByIDRequest.class);
        }

        public FetchQuickActionByIDRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.maction_id = "";
            r0.mchat_id = "";
            r0.mai_chat_mode_id = "";
            r0.mcheck_id = "";
            r0.msystem_meta_data = "";
            r0.mthread_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mthread_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            r0.msystem_meta_data = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mchat_context = (ChatContext) ChatContext.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mcheck_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mai_chat_mode_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.maction_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m1946build();
        }

        public int encodedSize(FetchQuickActionByIDRequest r6) {
            String r0 = r6.maction_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mchat_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mai_chat_mode_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mcheck_id;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ChatContext r13 = r6.mchat_context;
            if (r13 == null) goto L21;
            int r14 = ChatContext.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.msystem_meta_data;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Long r19 = r6.mthread_id;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(7, r19);
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
        public /* bridge */ /* synthetic */ Object m1947decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FetchQuickActionByIDRequest) r1);
        }

        public void encode(ProtoWriter r4, FetchQuickActionByIDRequest r5) throws IOException {
            String r0 = r5.maction_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mchat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mai_chat_mode_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mcheck_id;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            ChatContext r6 = r5.mchat_context;
            if (r6 == null) goto L17;
            ChatContext.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.msystem_meta_data;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            Long r8 = r5.mthread_id;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FetchQuickActionByIDRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FetchQuickActionByIDRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_THREAD_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1945newBuilder() {
        Builder r0 = new Builder();
        r0.maction_id = this.maction_id;
        r0.mchat_id = this.mchat_id;
        r0.mai_chat_mode_id = this.mai_chat_mode_id;
        r0.mcheck_id = this.mcheck_id;
        r0.mchat_context = this.mchat_context;
        r0.msystem_meta_data = this.msystem_meta_data;
        r0.mthread_id = this.mthread_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FetchQuickActionByIDRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1945newBuilder();
    }

    public FetchQuickActionByIDRequest(String r10, String r11, String r12, String r13, ChatContext r14, String r15, Long r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public FetchQuickActionByIDRequest(String r2, String r3, String r4, String r5, ChatContext r6, String r7, Long r8, ByteString r9) {
        super(ADAPTER, r9);
        this.maction_id = r2;
        this.mchat_id = r3;
        this.mai_chat_mode_id = r4;
        this.mcheck_id = r5;
        this.mchat_context = r6;
        this.msystem_meta_data = r7;
        this.mthread_id = r8;
    }
}
