package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingStopRequest extends Message<MinutesRecordingStopRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingStopRequest> ADAPTER = null;
    public static final String DEFAULT_SESSION_ID = "";
    public static final ProtoAdapter_MinutesRecordingStopRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String session_id;

    public static final class Builder extends Message.Builder<MinutesRecordingStopRequest, Builder> implements d<MinutesRecordingStopRequest> {
        public String session_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingStopRequest m1886build() {
            String r0 = this.session_id;
            if (r0 == null) goto L7;
            return new MinutesRecordingStopRequest(this.session_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "session_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1886build();
        }

        public Builder session_id(String r1) {
            this.session_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStopRequest extends ProtoAdapter<MinutesRecordingStopRequest> implements c<MinutesRecordingStopRequest> {
        public ProtoAdapter_MinutesRecordingStopRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStopRequest.class);
        }

        public MinutesRecordingStopRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.session_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.session_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1886build();
        }

        public int encodedSize(MinutesRecordingStopRequest r4) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.session_id) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1887decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingStopRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingStopRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.session_id);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingStopRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStopRequest r0 = new ProtoAdapter_MinutesRecordingStopRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1885newBuilder() {
        Builder r0 = new Builder();
        r0.session_id = this.session_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingStopRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1885newBuilder();
    }

    public MinutesRecordingStopRequest(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public MinutesRecordingStopRequest(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.session_id = r2;
    }
}
