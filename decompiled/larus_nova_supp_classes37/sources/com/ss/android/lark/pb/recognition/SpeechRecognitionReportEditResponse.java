package com.ss.android.lark.pb.recognition;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SpeechRecognitionReportEditResponse extends Message<SpeechRecognitionReportEditResponse, Builder> {
    public static final ProtoAdapter<SpeechRecognitionReportEditResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SpeechRecognitionReportEditResponse, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SpeechRecognitionReportEditResponse m2114build() {
            return new SpeechRecognitionReportEditResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2114build();
        }
    }

    public static final class ProtoAdapter_SpeechRecognitionReportEditResponse extends ProtoAdapter<SpeechRecognitionReportEditResponse> {
        public ProtoAdapter_SpeechRecognitionReportEditResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SpeechRecognitionReportEditResponse.class);
        }

        public SpeechRecognitionReportEditResponse decode(ProtoReader r7) throws IOException {
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
            return r0.m2114build();
        }

        public int encodedSize(SpeechRecognitionReportEditResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2115decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SpeechRecognitionReportEditResponse) r1);
        }

        public void encode(ProtoWriter r1, SpeechRecognitionReportEditResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SpeechRecognitionReportEditResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SpeechRecognitionReportEditResponse();
    }

    public SpeechRecognitionReportEditResponse() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2113newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SpeechRecognitionReportEditResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2113newBuilder();
    }

    public SpeechRecognitionReportEditResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
