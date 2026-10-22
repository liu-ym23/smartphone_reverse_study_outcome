package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingAICapabilityControlResponse extends Message<MeetingAICapabilityControlResponse, Builder> {
    public static final ProtoAdapter<MeetingAICapabilityControlResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MeetingAIQuickActions mmeeting_ai_quick_action;

    public static final class Builder extends Message.Builder<MeetingAICapabilityControlResponse, Builder> {
        public MeetingAIQuickActions mmeeting_ai_quick_action;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAICapabilityControlResponse m3155build() {
            return new MeetingAICapabilityControlResponse(this.mmeeting_ai_quick_action, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3155build();
        }

        public Builder meeting_ai_quick_action(MeetingAIQuickActions r1) {
            this.mmeeting_ai_quick_action = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAICapabilityControlResponse extends ProtoAdapter<MeetingAICapabilityControlResponse> {
        public ProtoAdapter_MeetingAICapabilityControlResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAICapabilityControlResponse.class);
        }

        public MeetingAICapabilityControlResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmeeting_ai_quick_action = (MeetingAIQuickActions) MeetingAIQuickActions.ADAPTER.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3155build();
        }

        public int encodedSize(MeetingAICapabilityControlResponse r4) {
            MeetingAIQuickActions r0 = r4.mmeeting_ai_quick_action;
            if (r0 == null) goto L5;
            int r1 = MeetingAIQuickActions.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3156decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAICapabilityControlResponse) r1);
        }

        public void encode(ProtoWriter r4, MeetingAICapabilityControlResponse r5) throws IOException {
            MeetingAIQuickActions r0 = r5.mmeeting_ai_quick_action;
            if (r0 == null) goto L5;
            MeetingAIQuickActions.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAICapabilityControlResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAICapabilityControlResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3154newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_ai_quick_action = this.mmeeting_ai_quick_action;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAICapabilityControlResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3154newBuilder();
    }

    public MeetingAICapabilityControlResponse(MeetingAIQuickActions r2) {
        this(r2, ByteString.EMPTY);
    }

    public MeetingAICapabilityControlResponse(MeetingAIQuickActions r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmeeting_ai_quick_action = r2;
    }
}
