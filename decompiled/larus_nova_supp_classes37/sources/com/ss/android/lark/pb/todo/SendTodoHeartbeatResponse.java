package com.ss.android.lark.pb.todo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SendTodoHeartbeatResponse extends Message<SendTodoHeartbeatResponse, Builder> {
    public static final ProtoAdapter<SendTodoHeartbeatResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_OPEN_MEEGO_TIP = null;
    public static final Boolean DEFAULT_SHOW_SYNC_FROM_MEEGO = null;
    public static final Boolean DEFAULT_SYNC_FROM_MEEGO = null;
    private static final long serialVersionUID = 0;
    public final Boolean mshow_open_meego_tip;
    public final Boolean mshow_sync_from_meego;
    public final Boolean msync_from_meego;

    public static final class Builder extends Message.Builder<SendTodoHeartbeatResponse, Builder> {
        public Boolean mshow_open_meego_tip;
        public Boolean mshow_sync_from_meego;
        public Boolean msync_from_meego;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SendTodoHeartbeatResponse m2240build() {
            return new SendTodoHeartbeatResponse(this.msync_from_meego, this.mshow_open_meego_tip, this.mshow_sync_from_meego, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2240build();
        }

        public Builder show_open_meego_tip(Boolean r1) {
            this.mshow_open_meego_tip = r1;
            return this;
        }

        public Builder show_sync_from_meego(Boolean r1) {
            this.mshow_sync_from_meego = r1;
            return this;
        }

        public Builder sync_from_meego(Boolean r1) {
            this.msync_from_meego = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SendTodoHeartbeatResponse extends ProtoAdapter<SendTodoHeartbeatResponse> {
        public ProtoAdapter_SendTodoHeartbeatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SendTodoHeartbeatResponse.class);
        }

        public SendTodoHeartbeatResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.msync_from_meego = r1;
            r0.mshow_open_meego_tip = r1;
            r0.mshow_sync_from_meego = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.msync_from_meego = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mshow_open_meego_tip = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mshow_sync_from_meego = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.m2240build();
        }

        public int encodedSize(SendTodoHeartbeatResponse r6) {
            Boolean r0 = r6.msync_from_meego;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mshow_open_meego_tip;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mshow_sync_from_meego;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m2241decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SendTodoHeartbeatResponse) r1);
        }

        public void encode(ProtoWriter r4, SendTodoHeartbeatResponse r5) throws IOException {
            Boolean r0 = r5.msync_from_meego;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mshow_open_meego_tip;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mshow_sync_from_meego;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SendTodoHeartbeatResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SendTodoHeartbeatResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_SYNC_FROM_MEEGO = r0;
        DEFAULT_SHOW_OPEN_MEEGO_TIP = r0;
        DEFAULT_SHOW_SYNC_FROM_MEEGO = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2239newBuilder() {
        Builder r0 = new Builder();
        r0.msync_from_meego = this.msync_from_meego;
        r0.mshow_open_meego_tip = this.mshow_open_meego_tip;
        r0.mshow_sync_from_meego = this.mshow_sync_from_meego;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SendTodoHeartbeatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2239newBuilder();
    }

    public SendTodoHeartbeatResponse(Boolean r2, Boolean r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SendTodoHeartbeatResponse(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.msync_from_meego = r2;
        this.mshow_open_meego_tip = r3;
        this.mshow_sync_from_meego = r4;
    }
}
