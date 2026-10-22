package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AgentInfo extends Message<AgentInfo, Builder> {
    public static final ProtoAdapter<AgentInfo> ADAPTER = null;
    public static final String DEFAULT_APP_DESCRIPTION = "";
    public static final String DEFAULT_APP_ID = "";
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_ICON_URL = "";
    private static final long serialVersionUID = 0;
    public final String mapp_description;
    public final String mapp_id;
    public final String mapp_name;
    public final String micon_url;
    public final SimpleAgentTodo mlatest_todo_in_progress;

    public static final class Builder extends Message.Builder<AgentInfo, Builder> {
        public String mapp_description;
        public String mapp_id;
        public String mapp_name;
        public String micon_url;
        public SimpleAgentTodo mlatest_todo_in_progress;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AgentInfo m2261build() {
            return new AgentInfo(this.mapp_id, this.mapp_name, this.micon_url, this.mapp_description, this.mlatest_todo_in_progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2261build();
        }

        public Builder app_description(String r1) {
            this.mapp_description = r1;
            return this;
        }

        public Builder app_id(String r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder app_name(String r1) {
            this.mapp_name = r1;
            return this;
        }

        public Builder icon_url(String r1) {
            this.micon_url = r1;
            return this;
        }

        public Builder latest_todo_in_progress(SimpleAgentTodo r1) {
            this.mlatest_todo_in_progress = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AgentInfo extends ProtoAdapter<AgentInfo> {
        public ProtoAdapter_AgentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AgentInfo.class);
        }

        public AgentInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mapp_id = "";
            r0.mapp_name = "";
            r0.micon_url = "";
            r0.mapp_description = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mapp_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mapp_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.micon_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mapp_description = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mlatest_todo_in_progress = (SimpleAgentTodo) SimpleAgentTodo.ADAPTER.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2261build();
        }

        public int encodedSize(AgentInfo r6) {
            String r0 = r6.mapp_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mapp_name;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.micon_url;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mapp_description;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            SimpleAgentTodo r13 = r6.mlatest_todo_in_progress;
            if (r13 == null) goto L22;
            r1 = SimpleAgentTodo.ADAPTER.encodedSizeWithTag(5, r13);
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
        public /* bridge */ /* synthetic */ Object m2262decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AgentInfo) r1);
        }

        public void encode(ProtoWriter r4, AgentInfo r5) throws IOException {
            String r0 = r5.mapp_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mapp_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.micon_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mapp_description;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            SimpleAgentTodo r6 = r5.mlatest_todo_in_progress;
            if (r6 == null) goto L17;
            SimpleAgentTodo.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AgentInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AgentInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2260newBuilder() {
        Builder r0 = new Builder();
        r0.mapp_id = this.mapp_id;
        r0.mapp_name = this.mapp_name;
        r0.micon_url = this.micon_url;
        r0.mapp_description = this.mapp_description;
        r0.mlatest_todo_in_progress = this.mlatest_todo_in_progress;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AgentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2260newBuilder();
    }

    public AgentInfo(String r8, String r9, String r10, String r11, SimpleAgentTodo r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public AgentInfo(String r2, String r3, String r4, String r5, SimpleAgentTodo r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mapp_id = r2;
        this.mapp_name = r3;
        this.micon_url = r4;
        this.mapp_description = r5;
        this.mlatest_todo_in_progress = r6;
    }
}
