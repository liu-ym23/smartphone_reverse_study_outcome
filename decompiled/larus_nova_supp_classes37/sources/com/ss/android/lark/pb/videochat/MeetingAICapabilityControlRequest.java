package com.ss.android.lark.pb.videochat;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingAICapabilityControlRequest extends Message<MeetingAICapabilityControlRequest, Builder> {
    public static final ProtoAdapter<MeetingAICapabilityControlRequest> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MMEETING_ID = null;
    private static final long serialVersionUID = 0;
    public final AICapabilityPermData mai_capability_perm_data;
    public final String mmeeting_id;

    public static final class Builder extends Message.Builder<MeetingAICapabilityControlRequest, Builder> {
        public AICapabilityPermData mai_capability_perm_data;
        public String mmeeting_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingAICapabilityControlRequest m3152build() {
            return new MeetingAICapabilityControlRequest(this.mmeeting_id, this.mai_capability_perm_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3152build();
        }

        public Builder ai_capability_perm_data(AICapabilityPermData r1) {
            this.mai_capability_perm_data = r1;
            return this;
        }

        public Builder meeting_id(String r1) {
            this.mmeeting_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAICapabilityControlRequest extends ProtoAdapter<MeetingAICapabilityControlRequest> {
        public ProtoAdapter_MeetingAICapabilityControlRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAICapabilityControlRequest.class);
        }

        public MeetingAICapabilityControlRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mmeeting_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mmeeting_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mai_capability_perm_data = (AICapabilityPermData) AICapabilityPermData.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3152build();
        }

        public int encodedSize(MeetingAICapabilityControlRequest r5) {
            String r0 = r5.mmeeting_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            AICapabilityPermData r3 = r5.mai_capability_perm_data;
            if (r3 == null) goto L10;
            r1 = AICapabilityPermData.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3153decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingAICapabilityControlRequest) r1);
        }

        public void encode(ProtoWriter r4, MeetingAICapabilityControlRequest r5) throws IOException {
            String r0 = r5.mmeeting_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            AICapabilityPermData r1 = r5.mai_capability_perm_data;
            if (r1 == null) goto L8;
            AICapabilityPermData.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingAICapabilityControlRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAICapabilityControlRequest();
        FIELD_OPTIONS_MMEETING_ID = new FieldOptions.Builder().FieldInfo("split,type=meeting").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3151newBuilder() {
        Builder r0 = new Builder();
        r0.mmeeting_id = this.mmeeting_id;
        r0.mai_capability_perm_data = this.mai_capability_perm_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingAICapabilityControlRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3151newBuilder();
    }

    public MeetingAICapabilityControlRequest(String r2, AICapabilityPermData r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MeetingAICapabilityControlRequest(String r2, AICapabilityPermData r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mmeeting_id = r2;
        this.mai_capability_perm_data = r3;
    }
}
