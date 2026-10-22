package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SimpleAgentTodo extends Message<SimpleAgentTodo, Builder> {
    public static final ProtoAdapter<SimpleAgentTodo> ADAPTER = null;
    public static final String DEFAULT_GUID = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_TASK_PROGRESS = "";
    private static final long serialVersionUID = 0;
    public final String mguid;
    public final String msummary;
    public final String mtask_progress;

    public static final class Builder extends Message.Builder<SimpleAgentTodo, Builder> {
        public String mguid;
        public String msummary;
        public String mtask_progress;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SimpleAgentTodo m2324build() {
            return new SimpleAgentTodo(this.mguid, this.msummary, this.mtask_progress, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2324build();
        }

        public Builder guid(String r1) {
            this.mguid = r1;
            return this;
        }

        public Builder summary(String r1) {
            this.msummary = r1;
            return this;
        }

        public Builder task_progress(String r1) {
            this.mtask_progress = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleAgentTodo extends ProtoAdapter<SimpleAgentTodo> {
        public ProtoAdapter_SimpleAgentTodo() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleAgentTodo.class);
        }

        public SimpleAgentTodo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mguid = "";
            r0.msummary = "";
            r0.mtask_progress = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mguid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msummary = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtask_progress = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2324build();
        }

        public int encodedSize(SimpleAgentTodo r6) {
            String r0 = r6.mguid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.msummary;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtask_progress;
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
        public /* bridge */ /* synthetic */ Object m2325decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SimpleAgentTodo) r1);
        }

        public void encode(ProtoWriter r4, SimpleAgentTodo r5) throws IOException {
            String r0 = r5.mguid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.msummary;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtask_progress;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SimpleAgentTodo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleAgentTodo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2323newBuilder() {
        Builder r0 = new Builder();
        r0.mguid = this.mguid;
        r0.msummary = this.msummary;
        r0.mtask_progress = this.mtask_progress;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SimpleAgentTodo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2323newBuilder();
    }

    public SimpleAgentTodo(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SimpleAgentTodo(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mguid = r2;
        this.msummary = r3;
        this.mtask_progress = r4;
    }
}
