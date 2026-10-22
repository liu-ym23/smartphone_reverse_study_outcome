package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIChatStopGenerateResponse extends Message<AIChatStopGenerateResponse, Builder> {
    public static final ProtoAdapter<AIChatStopGenerateResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<AIChatStopGenerateResponse, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIChatStopGenerateResponse m1931build() {
            return new AIChatStopGenerateResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1931build();
        }
    }

    public static final class ProtoAdapter_AIChatStopGenerateResponse extends ProtoAdapter<AIChatStopGenerateResponse> {
        public ProtoAdapter_AIChatStopGenerateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AIChatStopGenerateResponse.class);
        }

        public AIChatStopGenerateResponse decode(ProtoReader r7) throws IOException {
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
            return r0.m1931build();
        }

        public int encodedSize(AIChatStopGenerateResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1932decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIChatStopGenerateResponse) r1);
        }

        public void encode(ProtoWriter r1, AIChatStopGenerateResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIChatStopGenerateResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIChatStopGenerateResponse();
    }

    public AIChatStopGenerateResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1930newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIChatStopGenerateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1930newBuilder();
    }

    public AIChatStopGenerateResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
