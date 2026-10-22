package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskCompleteStatusFieldFilterValue extends Message<TaskCompleteStatusFieldFilterValue, Builder> {
    public static final ProtoAdapter<TaskCompleteStatusFieldFilterValue> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskCompleteStatus mtask_complete_status;

    public static final class Builder extends Message.Builder<TaskCompleteStatusFieldFilterValue, Builder> {
        public TaskCompleteStatus mtask_complete_status;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskCompleteStatusFieldFilterValue m2330build() {
            return new TaskCompleteStatusFieldFilterValue(this.mtask_complete_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2330build();
        }

        public Builder task_complete_status(TaskCompleteStatus r1) {
            this.mtask_complete_status = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskCompleteStatusFieldFilterValue extends ProtoAdapter<TaskCompleteStatusFieldFilterValue> {
        public ProtoAdapter_TaskCompleteStatusFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskCompleteStatusFieldFilterValue.class);
        }

        public TaskCompleteStatusFieldFilterValue decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mtask_complete_status = (TaskCompleteStatus) TaskCompleteStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m2330build();
        }

        public int encodedSize(TaskCompleteStatusFieldFilterValue r4) {
            TaskCompleteStatus r0 = r4.mtask_complete_status;
            if (r0 == null) goto L5;
            int r1 = TaskCompleteStatus.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2331decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskCompleteStatusFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, TaskCompleteStatusFieldFilterValue r5) throws IOException {
            TaskCompleteStatus r0 = r5.mtask_complete_status;
            if (r0 == null) goto L5;
            TaskCompleteStatus.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskCompleteStatusFieldFilterValue) r2);
        }
    }

    public static final enum TaskCompleteStatus extends Enum<TaskCompleteStatus> implements WireEnum {
        private static final /* synthetic */ TaskCompleteStatus[] $VALUES = null;
        public static final ProtoAdapter<TaskCompleteStatus> ADAPTER = null;
        public static final TaskCompleteStatus ALL = null;
        public static final TaskCompleteStatus COMPLETED = null;
        public static final TaskCompleteStatus UNCOMPLETED = null;
        public static final TaskCompleteStatus UNKNOWN = null;
        private final int value;

        static {
            TaskCompleteStatus r0 = new TaskCompleteStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TaskCompleteStatus r1 = new TaskCompleteStatus("UNCOMPLETED", 1, 1);
            UNCOMPLETED = r1;
            TaskCompleteStatus r3 = new TaskCompleteStatus("COMPLETED", 2, 2);
            COMPLETED = r3;
            TaskCompleteStatus r5 = new TaskCompleteStatus("ALL", 3, 3);
            ALL = r5;
            $VALUES = new TaskCompleteStatus[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(TaskCompleteStatus.class);
        }

        public static TaskCompleteStatus[] values() {
            return (TaskCompleteStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TaskCompleteStatus fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return ALL;
        L14:
            return COMPLETED;
        L16:
            return UNCOMPLETED;
        L18:
            return UNKNOWN;
        }

        public static TaskCompleteStatus valueOf(String r1) {
            return (TaskCompleteStatus) a.a(TaskCompleteStatus.class, r1);
        }

        private TaskCompleteStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskCompleteStatusFieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2329newBuilder() {
        Builder r0 = new Builder();
        r0.mtask_complete_status = this.mtask_complete_status;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskCompleteStatusFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2329newBuilder();
    }

    public TaskCompleteStatusFieldFilterValue(TaskCompleteStatus r2) {
        this(r2, ByteString.EMPTY);
    }

    public TaskCompleteStatusFieldFilterValue(TaskCompleteStatus r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mtask_complete_status = r2;
    }
}
