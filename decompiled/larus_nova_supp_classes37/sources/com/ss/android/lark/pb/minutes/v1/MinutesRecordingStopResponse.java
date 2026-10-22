package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingStopResponse extends Message<MinutesRecordingStopResponse, Builder> {
    public static final ProtoAdapter<MinutesRecordingStopResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesRecordingStopResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<MinutesRecordingStopResponse, Builder> implements d<MinutesRecordingStopResponse> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingStopResponse m1889build() {
            return new MinutesRecordingStopResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1889build();
        }
    }

    public static final class ProtoAdapter_MinutesRecordingStopResponse extends ProtoAdapter<MinutesRecordingStopResponse> implements c<MinutesRecordingStopResponse> {
        public ProtoAdapter_MinutesRecordingStopResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingStopResponse.class);
        }

        public MinutesRecordingStopResponse decode(ProtoReader r7) throws IOException {
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
            return r0.m1889build();
        }

        public int encodedSize(MinutesRecordingStopResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1890decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingStopResponse) r1);
        }

        public void encode(ProtoWriter r1, MinutesRecordingStopResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingStopResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingStopResponse r0 = new ProtoAdapter_MinutesRecordingStopResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    public MinutesRecordingStopResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1888newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingStopResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1888newBuilder();
    }

    public MinutesRecordingStopResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
