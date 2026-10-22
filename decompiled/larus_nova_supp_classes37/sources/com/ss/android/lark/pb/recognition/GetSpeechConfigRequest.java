package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetSpeechConfigRequest extends Message<GetSpeechConfigRequest, Builder> {
    public static final ProtoAdapter<GetSpeechConfigRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetSpeechConfigRequest, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetSpeechConfigRequest m2084build() {
            return new GetSpeechConfigRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2084build();
        }
    }

    public static final class ProtoAdapter_GetSpeechConfigRequest extends ProtoAdapter<GetSpeechConfigRequest> {
        public ProtoAdapter_GetSpeechConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSpeechConfigRequest.class);
        }

        public GetSpeechConfigRequest decode(ProtoReader r7) throws IOException {
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
            return r0.m2084build();
        }

        public int encodedSize(GetSpeechConfigRequest r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2085decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSpeechConfigRequest) r1);
        }

        public void encode(ProtoWriter r1, GetSpeechConfigRequest r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSpeechConfigRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSpeechConfigRequest();
    }

    public GetSpeechConfigRequest() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2083newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSpeechConfigRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2083newBuilder();
    }

    public GetSpeechConfigRequest(ByteString r2) {
        super(ADAPTER, r2);
    }
}
