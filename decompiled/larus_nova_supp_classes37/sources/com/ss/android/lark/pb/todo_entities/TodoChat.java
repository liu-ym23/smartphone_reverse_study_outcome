package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TodoChat extends Message<TodoChat, Builder> {
    public static final ProtoAdapter<TodoChat> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mavatar_key;
    public final String mchat_id;
    public final Boolean mis_cross_tenant;
    public final String mname;

    public static final class Builder extends Message.Builder<TodoChat, Builder> {
        public String mavatar_key;
        public String mchat_id;
        public Boolean mis_cross_tenant;
        public String mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TodoChat m2396build() {
            return new TodoChat(this.mchat_id, this.mname, this.mavatar_key, this.mis_cross_tenant, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2396build();
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TodoChat extends ProtoAdapter<TodoChat> {
        public ProtoAdapter_TodoChat() {
            super(FieldEncoding.LENGTH_DELIMITED, TodoChat.class);
        }

        public TodoChat decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            r0.mname = "";
            r0.mavatar_key = "";
            r0.mis_cross_tenant = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2396build();
        }

        public int encodedSize(TodoChat r6) {
            String r0 = r6.mchat_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mavatar_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_cross_tenant;
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
        public /* bridge */ /* synthetic */ Object m2397decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TodoChat) r1);
        }

        public void encode(ProtoWriter r4, TodoChat r5) throws IOException {
            String r0 = r5.mchat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mavatar_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mis_cross_tenant;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TodoChat) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TodoChat();
        DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2395newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mname = this.mname;
        r0.mavatar_key = this.mavatar_key;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TodoChat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2395newBuilder();
    }

    public TodoChat(String r7, String r8, String r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public TodoChat(String r2, String r3, String r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchat_id = r2;
        this.mname = r3;
        this.mavatar_key = r4;
        this.mis_cross_tenant = r5;
    }
}
