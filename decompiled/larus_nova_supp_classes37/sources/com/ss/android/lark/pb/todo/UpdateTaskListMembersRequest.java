package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.TaskListMember;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateTaskListMembersRequest extends Message<UpdateTaskListMembersRequest, Builder> {
    public static final ProtoAdapter<UpdateTaskListMembersRequest> ADAPTER = null;
    public static final String DEFAULT_NOTE = "";
    public static final Boolean DEFAULT_SEND_NOTE = null;
    public static final String DEFAULT_TASK_LIST_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mnote;
    public final Boolean msend_note;
    public final String mtask_list_guid;
    public final Map<Long, TaskListMember> mupdated_member;

    public static final class Builder extends Message.Builder<UpdateTaskListMembersRequest, Builder> {
        public String mnote;
        public Boolean msend_note;
        public String mtask_list_guid;
        public Map<Long, TaskListMember> mupdated_member;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateTaskListMembersRequest m2243build() {
            return new UpdateTaskListMembersRequest(this.mtask_list_guid, this.mupdated_member, this.msend_note, this.mnote, super.buildUnknownFields());
        }

        public Builder() {
            this.mupdated_member = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2243build();
        }

        public Builder note(String r1) {
            this.mnote = r1;
            return this;
        }

        public Builder send_note(Boolean r1) {
            this.msend_note = r1;
            return this;
        }

        public Builder task_list_guid(String r1) {
            this.mtask_list_guid = r1;
            return this;
        }

        public Builder updated_member(Map<Long, TaskListMember> r1) {
            Internal.checkElementsNotNull(r1);
            this.mupdated_member = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskListMembersRequest extends ProtoAdapter<UpdateTaskListMembersRequest> {
        private final ProtoAdapter<Map<Long, TaskListMember>> mupdated_member;

        public ProtoAdapter_UpdateTaskListMembersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskListMembersRequest.class);
            this.mupdated_member = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TaskListMember.ADAPTER);
        }

        public UpdateTaskListMembersRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtask_list_guid = "";
            r0.msend_note = Boolean.FALSE;
            r0.mnote = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtask_list_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mupdated_member.putAll((Map) this.mupdated_member.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.msend_note = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mnote = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2243build();
        }

        public int encodedSize(UpdateTaskListMembersRequest r6) {
            String r0 = r6.mtask_list_guid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + this.mupdated_member.encodedSizeWithTag(2, r6.mupdated_member);
            Boolean r4 = r6.msend_note;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.mnote;
            if (r8 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r8);
        L14:
            return (r7 + r1) + r6.unknownFields().size();
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2244decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateTaskListMembersRequest) r1);
        }

        public void encode(ProtoWriter r4, UpdateTaskListMembersRequest r5) throws IOException {
            String r0 = r5.mtask_list_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            this.mupdated_member.encodeWithTag(r4, 2, r5.mupdated_member);
            Boolean r1 = r5.msend_note;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            String r2 = r5.mnote;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateTaskListMembersRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateTaskListMembersRequest();
        DEFAULT_SEND_NOTE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2242newBuilder() {
        Builder r0 = new Builder();
        r0.mtask_list_guid = this.mtask_list_guid;
        r0.mupdated_member = Internal.copyOf("mupdated_member", this.mupdated_member);
        r0.msend_note = this.msend_note;
        r0.mnote = this.mnote;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateTaskListMembersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2242newBuilder();
    }

    public UpdateTaskListMembersRequest(String r7, Map<Long, TaskListMember> r8, Boolean r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public UpdateTaskListMembersRequest(String r2, Map<Long, TaskListMember> r3, Boolean r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mtask_list_guid = r2;
        this.mupdated_member = Internal.immutableCopyOf("mupdated_member", r3);
        this.msend_note = r4;
        this.mnote = r5;
    }
}
