package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.todo_entities.TaskListMember;
import com.ss.android.lark.pb.todo_entities.TodoChat;
import com.ss.android.lark.pb.todo_entities.TodoDoc;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateTaskListMembersResponse extends Message<UpdateTaskListMembersResponse, Builder> {
    public static final ProtoAdapter<UpdateTaskListMembersResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, TodoChat> mchats;
    public final List<Long> mpassed_ids;
    public final List<Long> mrefused_ids;
    public final Map<String, TodoDoc> mtodo_docs;
    public final Map<Long, TaskListMember> mupdated_member;

    public static final class Builder extends Message.Builder<UpdateTaskListMembersResponse, Builder> {
        public Map<Long, TodoChat> mchats;
        public List<Long> mpassed_ids;
        public List<Long> mrefused_ids;
        public Map<String, TodoDoc> mtodo_docs;
        public Map<Long, TaskListMember> mupdated_member;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateTaskListMembersResponse m2246build() {
            return new UpdateTaskListMembersResponse(this.mpassed_ids, this.mrefused_ids, this.mupdated_member, this.mchats, this.mtodo_docs, super.buildUnknownFields());
        }

        public Builder() {
            this.mpassed_ids = Internal.newMutableList();
            this.mrefused_ids = Internal.newMutableList();
            this.mupdated_member = Internal.newMutableMap();
            this.mchats = Internal.newMutableMap();
            this.mtodo_docs = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2246build();
        }

        public Builder chats(Map<Long, TodoChat> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchats = r1;
            return this;
        }

        public Builder passed_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpassed_ids = r1;
            return this;
        }

        public Builder refused_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrefused_ids = r1;
            return this;
        }

        public Builder todo_docs(Map<String, TodoDoc> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtodo_docs = r1;
            return this;
        }

        public Builder updated_member(Map<Long, TaskListMember> r1) {
            Internal.checkElementsNotNull(r1);
            this.mupdated_member = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateTaskListMembersResponse extends ProtoAdapter<UpdateTaskListMembersResponse> {
        private final ProtoAdapter<Map<Long, TodoChat>> mchats;
        private final ProtoAdapter<Map<String, TodoDoc>> mtodo_docs;
        private final ProtoAdapter<Map<Long, TaskListMember>> mupdated_member;

        public ProtoAdapter_UpdateTaskListMembersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateTaskListMembersResponse.class);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            this.mupdated_member = ProtoAdapter.newMapAdapter(r0, TaskListMember.ADAPTER);
            this.mchats = ProtoAdapter.newMapAdapter(r0, TodoChat.ADAPTER);
            this.mtodo_docs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, TodoDoc.ADAPTER);
        }

        public UpdateTaskListMembersResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mpassed_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mrefused_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mupdated_member.putAll((Map) this.mupdated_member.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mchats.putAll((Map) this.mchats.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mtodo_docs.putAll((Map) this.mtodo_docs.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2246build();
        }

        public int encodedSize(UpdateTaskListMembersResponse r5) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((((r0.asRepeated().encodedSizeWithTag(1, r5.mpassed_ids) + r0.asRepeated().encodedSizeWithTag(2, r5.mrefused_ids)) + this.mupdated_member.encodedSizeWithTag(3, r5.mupdated_member)) + this.mchats.encodedSizeWithTag(4, r5.mchats)) + this.mtodo_docs.encodedSizeWithTag(5, r5.mtodo_docs)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2247decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateTaskListMembersResponse) r1);
        }

        public void encode(ProtoWriter r5, UpdateTaskListMembersResponse r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.asRepeated().encodeWithTag(r5, 1, r6.mpassed_ids);
            r0.asRepeated().encodeWithTag(r5, 2, r6.mrefused_ids);
            this.mupdated_member.encodeWithTag(r5, 3, r6.mupdated_member);
            this.mchats.encodeWithTag(r5, 4, r6.mchats);
            this.mtodo_docs.encodeWithTag(r5, 5, r6.mtodo_docs);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateTaskListMembersResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateTaskListMembersResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2245newBuilder() {
        Builder r0 = new Builder();
        r0.mpassed_ids = Internal.copyOf("mpassed_ids", this.mpassed_ids);
        r0.mrefused_ids = Internal.copyOf("mrefused_ids", this.mrefused_ids);
        r0.mupdated_member = Internal.copyOf("mupdated_member", this.mupdated_member);
        r0.mchats = Internal.copyOf("mchats", this.mchats);
        r0.mtodo_docs = Internal.copyOf("mtodo_docs", this.mtodo_docs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateTaskListMembersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2245newBuilder();
    }

    public UpdateTaskListMembersResponse(List<Long> r8, List<Long> r9, Map<Long, TaskListMember> r10, Map<Long, TodoChat> r11, Map<String, TodoDoc> r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public UpdateTaskListMembersResponse(List<Long> r2, List<Long> r3, Map<Long, TaskListMember> r4, Map<Long, TodoChat> r5, Map<String, TodoDoc> r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mpassed_ids = Internal.immutableCopyOf("mpassed_ids", r2);
        this.mrefused_ids = Internal.immutableCopyOf("mrefused_ids", r3);
        this.mupdated_member = Internal.immutableCopyOf("mupdated_member", r4);
        this.mchats = Internal.immutableCopyOf("mchats", r5);
        this.mtodo_docs = Internal.immutableCopyOf("mtodo_docs", r6);
    }
}
