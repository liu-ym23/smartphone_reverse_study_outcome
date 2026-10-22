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
public final class MinutesRecordingSyncSubtitlesResponse extends Message<MinutesRecordingSyncSubtitlesResponse, Builder> {
    public static final ProtoAdapter<MinutesRecordingSyncSubtitlesResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesRecordingSyncSubtitlesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<MinutesRecordingSyncSubtitlesResponse, Builder> implements d<MinutesRecordingSyncSubtitlesResponse> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingSyncSubtitlesResponse m1895build() {
            return new MinutesRecordingSyncSubtitlesResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1895build();
        }
    }

    public static final class ProtoAdapter_MinutesRecordingSyncSubtitlesResponse extends ProtoAdapter<MinutesRecordingSyncSubtitlesResponse> implements c<MinutesRecordingSyncSubtitlesResponse> {
        public ProtoAdapter_MinutesRecordingSyncSubtitlesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingSyncSubtitlesResponse.class);
        }

        public MinutesRecordingSyncSubtitlesResponse decode(ProtoReader r7) throws IOException {
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
            return r0.m1895build();
        }

        public int encodedSize(MinutesRecordingSyncSubtitlesResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1896decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingSyncSubtitlesResponse) r1);
        }

        public void encode(ProtoWriter r1, MinutesRecordingSyncSubtitlesResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingSyncSubtitlesResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingSyncSubtitlesResponse r0 = new ProtoAdapter_MinutesRecordingSyncSubtitlesResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    public MinutesRecordingSyncSubtitlesResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1894newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingSyncSubtitlesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1894newBuilder();
    }

    public MinutesRecordingSyncSubtitlesResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
