package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskSectionFieldFilterValue extends Message<TaskSectionFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskSectionFieldFilterValue> ADAPTER = null;
    public static final String DEFAULT_TASK_SECTION_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mtask_section_guid;

    public static final class Builder extends Message.Builder<TaskSectionFieldFilterValue, Builder> {
        public String mtask_section_guid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskSectionFieldFilterValue m2354build() {
            return new TaskSectionFieldFilterValue(this.mtask_section_guid, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2354build();
        }

        public Builder task_section_guid(String r1) {
            this.mtask_section_guid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskSectionFieldFilterValue extends ProtoAdapter<TaskSectionFieldFilterValue> {
        public ProtoAdapter_TaskSectionFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskSectionFieldFilterValue.class);
        }

        public TaskSectionFieldFilterValue decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtask_section_guid = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mtask_section_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2354build();
        }

        public int encodedSize(TaskSectionFieldFilterValue r4) {
            String r0 = r4.mtask_section_guid;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2355decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskSectionFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, TaskSectionFieldFilterValue r5) throws IOException {
            String r0 = r5.mtask_section_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskSectionFieldFilterValue) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskSectionFieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2353newBuilder() {
        Builder r0 = new Builder();
        r0.mtask_section_guid = this.mtask_section_guid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskSectionFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2353newBuilder();
    }

    public TaskSectionFieldFilterValue(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public TaskSectionFieldFilterValue(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mtask_section_guid = r2;
    }
}
