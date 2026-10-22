package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskSourceFieldFilterValue extends Message<TaskSourceFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskSourceFieldFilterValue> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_DOCX_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final String mdocx_token;
    public final TaskSimpleSourceType msource_type;

    public static final class Builder extends Message.Builder<TaskSourceFieldFilterValue, Builder> {
        public Long mchat_id;
        public String mdocx_token;
        public TaskSimpleSourceType msource_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskSourceFieldFilterValue m2357build() {
            return new TaskSourceFieldFilterValue(this.msource_type, this.mchat_id, this.mdocx_token, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2357build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder docx_token(String r1) {
            this.mdocx_token = r1;
            return this;
        }

        public Builder source_type(TaskSimpleSourceType r1) {
            this.msource_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSourceFieldFilterValue extends ProtoAdapter<TaskSourceFieldFilterValue> {
        public ProtoAdapter_TaskSourceFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSourceFieldFilterValue.class);
        }

        public TaskSourceFieldFilterValue decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mdocx_token = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.msource_type = (TaskSimpleSourceType) TaskSimpleSourceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mdocx_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2357build();
        }

        public int encodedSize(TaskSourceFieldFilterValue r6) {
            TaskSimpleSourceType r0 = r6.msource_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = TaskSimpleSourceType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mchat_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mdocx_token;
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
        public /* bridge */ /* synthetic */ Object m2358decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskSourceFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, TaskSourceFieldFilterValue r5) throws IOException {
            TaskSimpleSourceType r0 = r5.msource_type;
            if (r0 == null) goto L5;
            TaskSimpleSourceType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mchat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mdocx_token;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskSourceFieldFilterValue) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSourceFieldFilterValue();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2356newBuilder() {
        Builder r0 = new Builder();
        r0.msource_type = this.msource_type;
        r0.mchat_id = this.mchat_id;
        r0.mdocx_token = this.mdocx_token;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskSourceFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2356newBuilder();
    }

    public TaskSourceFieldFilterValue(TaskSimpleSourceType r2, Long r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public TaskSourceFieldFilterValue(TaskSimpleSourceType r2, Long r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.msource_type = r2;
        this.mchat_id = r3;
        this.mdocx_token = r4;
    }
}
