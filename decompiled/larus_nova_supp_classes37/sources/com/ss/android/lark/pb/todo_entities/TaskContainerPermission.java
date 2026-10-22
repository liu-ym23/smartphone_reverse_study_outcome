package com.ss.android.lark.pb.todo_entities;

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
public final class TaskContainerPermission extends Message<TaskContainerPermission, Builder> {
    public static final ProtoAdapter<TaskContainerPermission> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, Boolean> mpermissions;

    public static final class Builder extends Message.Builder<TaskContainerPermission, Builder> {
        public Map<Integer, Boolean> mpermissions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskContainerPermission m2339build() {
            return new TaskContainerPermission(this.mpermissions, super.buildUnknownFields());
        }

        public Builder() {
            this.mpermissions = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2339build();
        }

        public Builder permissions(Map<Integer, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpermissions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskContainerPermission extends ProtoAdapter<TaskContainerPermission> {
        private final ProtoAdapter<Map<Integer, Boolean>> mpermissions;

        public ProtoAdapter_TaskContainerPermission() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskContainerPermission.class);
            this.mpermissions = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        public TaskContainerPermission decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mpermissions.putAll((Map) this.mpermissions.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2339build();
        }

        public int encodedSize(TaskContainerPermission r4) {
            return this.mpermissions.encodedSizeWithTag(1, r4.mpermissions) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2340decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskContainerPermission) r1);
        }

        public void encode(ProtoWriter r4, TaskContainerPermission r5) throws IOException {
            this.mpermissions.encodeWithTag(r4, 1, r5.mpermissions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskContainerPermission) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskContainerPermission();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2338newBuilder() {
        Builder r0 = new Builder();
        r0.mpermissions = Internal.copyOf("mpermissions", this.mpermissions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskContainerPermission.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2338newBuilder();
    }

    public TaskContainerPermission(Map<Integer, Boolean> r2) {
        this(r2, ByteString.EMPTY);
    }

    public TaskContainerPermission(Map<Integer, Boolean> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mpermissions = Internal.immutableCopyOf("mpermissions", r2);
    }
}
