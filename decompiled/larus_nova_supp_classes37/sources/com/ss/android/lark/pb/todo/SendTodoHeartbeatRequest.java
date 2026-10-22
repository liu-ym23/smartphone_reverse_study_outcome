package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SendTodoHeartbeatRequest extends Message<SendTodoHeartbeatRequest, Builder> {
    public static final ProtoAdapter<SendTodoHeartbeatRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_GUID = "";
    public static final String DEFAULT_TODO_GUID = "";
    private static final long serialVersionUID = 0;
    public final String mcontainer_guid;
    public final String mtodo_guid;

    public static final class Builder extends Message.Builder<SendTodoHeartbeatRequest, Builder> {
        public String mcontainer_guid;
        public String mtodo_guid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SendTodoHeartbeatRequest m2237build() {
            return new SendTodoHeartbeatRequest(this.mtodo_guid, this.mcontainer_guid, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2237build();
        }

        public Builder container_guid(String r1) {
            this.mcontainer_guid = r1;
            return this;
        }

        public Builder todo_guid(String r1) {
            this.mtodo_guid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SendTodoHeartbeatRequest extends ProtoAdapter<SendTodoHeartbeatRequest> {
        public ProtoAdapter_SendTodoHeartbeatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SendTodoHeartbeatRequest.class);
        }

        public SendTodoHeartbeatRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtodo_guid = "";
            r0.mcontainer_guid = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtodo_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mcontainer_guid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2237build();
        }

        public int encodedSize(SendTodoHeartbeatRequest r5) {
            String r0 = r5.mtodo_guid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mcontainer_guid;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2238decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SendTodoHeartbeatRequest) r1);
        }

        public void encode(ProtoWriter r4, SendTodoHeartbeatRequest r5) throws IOException {
            String r0 = r5.mtodo_guid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcontainer_guid;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SendTodoHeartbeatRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendTodoHeartbeatRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2236newBuilder() {
        Builder r0 = new Builder();
        r0.mtodo_guid = this.mtodo_guid;
        r0.mcontainer_guid = this.mcontainer_guid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SendTodoHeartbeatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2236newBuilder();
    }

    public SendTodoHeartbeatRequest(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SendTodoHeartbeatRequest(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtodo_guid = r2;
        this.mcontainer_guid = r3;
    }
}
