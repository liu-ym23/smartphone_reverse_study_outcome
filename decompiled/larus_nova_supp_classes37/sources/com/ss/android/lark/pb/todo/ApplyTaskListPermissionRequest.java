package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.todo_entities.TodoItemMemberRole;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ApplyTaskListPermissionRequest extends Message<ApplyTaskListPermissionRequest, Builder> {
    public static final ProtoAdapter<ApplyTaskListPermissionRequest> ADAPTER = null;
    public static final String DEFAULT_NOTE = "";
    public static final String DEFAULT_TASK_LIST_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mnote;
    public final TodoItemMemberRole mrole;
    public final String mtask_list_guid;

    public static final class Builder extends Message.Builder<ApplyTaskListPermissionRequest, Builder> {
        public String mnote;
        public TodoItemMemberRole mrole;
        public String mtask_list_guid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ApplyTaskListPermissionRequest m2225build() {
            return new ApplyTaskListPermissionRequest(this.mtask_list_guid, this.mrole, this.mnote, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2225build();
        }

        public Builder note(String r1) {
            this.mnote = r1;
            return this;
        }

        public Builder role(TodoItemMemberRole r1) {
            this.mrole = r1;
            return this;
        }

        public Builder task_list_guid(String r1) {
            this.mtask_list_guid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ApplyTaskListPermissionRequest extends ProtoAdapter<ApplyTaskListPermissionRequest> {
        public ProtoAdapter_ApplyTaskListPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ApplyTaskListPermissionRequest.class);
        }

        public ApplyTaskListPermissionRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtask_list_guid = "";
            r0.mnote = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtask_list_guid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mrole = (TodoItemMemberRole) TodoItemMemberRole.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mnote = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2225build();
        }

        public int encodedSize(ApplyTaskListPermissionRequest r6) {
            String r0 = r6.mtask_list_guid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            TodoItemMemberRole r3 = r6.mrole;
            if (r3 == null) goto L9;
            int r4 = TodoItemMemberRole.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mnote;
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
        public /* bridge */ /* synthetic */ Object m2226decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ApplyTaskListPermissionRequest) r1);
        }

        public void encode(ProtoWriter r4, ApplyTaskListPermissionRequest r5) throws IOException {
            String r0 = r5.mtask_list_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            TodoItemMemberRole r1 = r5.mrole;
            if (r1 == null) goto L8;
            TodoItemMemberRole.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mnote;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ApplyTaskListPermissionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ApplyTaskListPermissionRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2224newBuilder() {
        Builder r0 = new Builder();
        r0.mtask_list_guid = this.mtask_list_guid;
        r0.mrole = this.mrole;
        r0.mnote = this.mnote;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ApplyTaskListPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2224newBuilder();
    }

    public ApplyTaskListPermissionRequest(String r2, TodoItemMemberRole r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ApplyTaskListPermissionRequest(String r2, TodoItemMemberRole r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtask_list_guid = r2;
        this.mrole = r3;
        this.mnote = r4;
    }
}
