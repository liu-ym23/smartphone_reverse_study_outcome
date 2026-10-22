package com.ss.android.lark.pb.todo_comments;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DeleteTodoCommentReactionResponse extends Message<DeleteTodoCommentReactionResponse, Builder> {
    public static final ProtoAdapter<DeleteTodoCommentReactionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<DeleteTodoCommentReactionResponse, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DeleteTodoCommentReactionResponse m2258build() {
            return new DeleteTodoCommentReactionResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2258build();
        }
    }

    public static final class ProtoAdapter_DeleteTodoCommentReactionResponse extends ProtoAdapter<DeleteTodoCommentReactionResponse> {
        public ProtoAdapter_DeleteTodoCommentReactionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, DeleteTodoCommentReactionResponse.class);
        }

        public DeleteTodoCommentReactionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.m2258build();
        }

        public int encodedSize(DeleteTodoCommentReactionResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2259decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DeleteTodoCommentReactionResponse) r1);
        }

        public void encode(ProtoWriter r1, DeleteTodoCommentReactionResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DeleteTodoCommentReactionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeleteTodoCommentReactionResponse();
    }

    public DeleteTodoCommentReactionResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2257newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DeleteTodoCommentReactionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2257newBuilder();
    }

    public DeleteTodoCommentReactionResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
