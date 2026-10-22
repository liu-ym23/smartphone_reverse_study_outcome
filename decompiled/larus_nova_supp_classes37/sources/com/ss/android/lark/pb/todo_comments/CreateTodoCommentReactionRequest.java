package com.ss.android.lark.pb.todo_comments;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CreateTodoCommentReactionRequest extends Message<CreateTodoCommentReactionRequest, Builder> {
    public static final ProtoAdapter<CreateTodoCommentReactionRequest> ADAPTER = null;
    public static final String DEFAULT_COMMENT_ID = "";
    public static final String DEFAULT_REACTION_TYPE = "";
    public static final String DEFAULT_TODO_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mcomment_id;
    public final String mreaction_type;
    public final String mtodo_guid;

    public static final class Builder extends Message.Builder<CreateTodoCommentReactionRequest, Builder> {
        public String mcomment_id;
        public String mreaction_type;
        public String mtodo_guid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CreateTodoCommentReactionRequest m2249build() {
            return new CreateTodoCommentReactionRequest(this.mtodo_guid, this.mcomment_id, this.mreaction_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2249build();
        }

        public Builder comment_id(String r1) {
            this.mcomment_id = r1;
            return this;
        }

        public Builder reaction_type(String r1) {
            this.mreaction_type = r1;
            return this;
        }

        public Builder todo_guid(String r1) {
            this.mtodo_guid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CreateTodoCommentReactionRequest extends ProtoAdapter<CreateTodoCommentReactionRequest> {
        public ProtoAdapter_CreateTodoCommentReactionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CreateTodoCommentReactionRequest.class);
        }

        public CreateTodoCommentReactionRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtodo_guid = "";
            r0.mcomment_id = "";
            r0.mreaction_type = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtodo_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcomment_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mreaction_type = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2249build();
        }

        public int encodedSize(CreateTodoCommentReactionRequest r6) {
            String r0 = r6.mtodo_guid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mcomment_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mreaction_type;
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
        public /* bridge */ /* synthetic */ Object m2250decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CreateTodoCommentReactionRequest) r1);
        }

        public void encode(ProtoWriter r4, CreateTodoCommentReactionRequest r5) throws IOException {
            String r0 = r5.mtodo_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcomment_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mreaction_type;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CreateTodoCommentReactionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CreateTodoCommentReactionRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2248newBuilder() {
        Builder r0 = new Builder();
        r0.mtodo_guid = this.mtodo_guid;
        r0.mcomment_id = this.mcomment_id;
        r0.mreaction_type = this.mreaction_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CreateTodoCommentReactionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2248newBuilder();
    }

    public CreateTodoCommentReactionRequest(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public CreateTodoCommentReactionRequest(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtodo_guid = r2;
        this.mcomment_id = r3;
        this.mreaction_type = r4;
    }
}
