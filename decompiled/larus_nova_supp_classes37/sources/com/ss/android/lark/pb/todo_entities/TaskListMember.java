package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TaskListMember extends Message<TaskListMember, Builder> {
    public static final ProtoAdapter<TaskListMember> ADAPTER = null;
    public static final String DEFAULT_MEMBER_ID = "";
    private static final long serialVersionUID = 0;
    public final List<TodoItemMemberRole> menable_roles;
    public final String mmember_id;
    public final TaskContainerPermission mpermission;
    public final TodoItemMemberRole mrole;
    public final TodoItemMemberType mtype;

    public static final class Builder extends Message.Builder<TaskListMember, Builder> {
        public List<TodoItemMemberRole> menable_roles;
        public String mmember_id;
        public TaskContainerPermission mpermission;
        public TodoItemMemberRole mrole;
        public TodoItemMemberType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TaskListMember m2348build() {
            return new TaskListMember(this.mmember_id, this.mtype, this.mrole, this.mpermission, this.menable_roles, super.buildUnknownFields());
        }

        public Builder() {
            this.menable_roles = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2348build();
        }

        public Builder enable_roles(List<TodoItemMemberRole> r1) {
            Internal.checkElementsNotNull(r1);
            this.menable_roles = r1;
            return this;
        }

        public Builder member_id(String r1) {
            this.mmember_id = r1;
            return this;
        }

        public Builder permission(TaskContainerPermission r1) {
            this.mpermission = r1;
            return this;
        }

        public Builder role(TodoItemMemberRole r1) {
            this.mrole = r1;
            return this;
        }

        public Builder type(TodoItemMemberType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskListMember extends ProtoAdapter<TaskListMember> {
        public ProtoAdapter_TaskListMember() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskListMember.class);
        }

        public TaskListMember decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmember_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            if (r3 != 1) goto L8;
            r0.mmember_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (TodoItemMemberType) TodoItemMemberType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mrole = (TodoItemMemberRole) TodoItemMemberRole.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mpermission = (TaskContainerPermission) TaskContainerPermission.ADAPTER.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.menable_roles.add((TodoItemMemberRole) TodoItemMemberRole.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m2348build();
        }

        public int encodedSize(TaskListMember r6) {
            String r0 = r6.mmember_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            TodoItemMemberType r3 = r6.mtype;
            if (r3 == null) goto L9;
            int r4 = TodoItemMemberType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TodoItemMemberRole r7 = r6.mrole;
            if (r7 == null) goto L13;
            int r8 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TaskContainerPermission r10 = r6.mpermission;
            if (r10 == null) goto L18;
            r1 = TaskContainerPermission.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return ((r9 + r1) + TodoItemMemberRole.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.menable_roles)) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2349decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TaskListMember) r1);
        }

        public void encode(ProtoWriter r4, TaskListMember r5) throws IOException {
            String r0 = r5.mmember_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            TodoItemMemberType r1 = r5.mtype;
            if (r1 == null) goto L8;
            TodoItemMemberType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            TodoItemMemberRole r2 = r5.mrole;
            if (r2 == null) goto L11;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TaskContainerPermission r3 = r5.mpermission;
            if (r3 == null) goto L14;
            TaskContainerPermission.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            TodoItemMemberRole.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.menable_roles);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TaskListMember) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskListMember();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2347newBuilder() {
        Builder r0 = new Builder();
        r0.mmember_id = this.mmember_id;
        r0.mtype = this.mtype;
        r0.mrole = this.mrole;
        r0.mpermission = this.mpermission;
        r0.menable_roles = Internal.copyOf("menable_roles", this.menable_roles);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TaskListMember.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2347newBuilder();
    }

    public TaskListMember(String r8, TodoItemMemberType r9, TodoItemMemberRole r10, TaskContainerPermission r11, List<TodoItemMemberRole> r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public TaskListMember(String r2, TodoItemMemberType r3, TodoItemMemberRole r4, TaskContainerPermission r5, List<TodoItemMemberRole> r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mmember_id = r2;
        this.mtype = r3;
        this.mrole = r4;
        this.mpermission = r5;
        this.menable_roles = Internal.immutableCopyOf("menable_roles", r6);
    }
}
