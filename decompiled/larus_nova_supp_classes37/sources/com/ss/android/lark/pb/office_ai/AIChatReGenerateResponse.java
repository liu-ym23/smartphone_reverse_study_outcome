package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AIChatReGenerateResponse extends Message<AIChatReGenerateResponse, Builder> {
    public static final ProtoAdapter<AIChatReGenerateResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mmessage_ids;

    public static final class Builder extends Message.Builder<AIChatReGenerateResponse, Builder> {
        public List<Long> mmessage_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AIChatReGenerateResponse m1928build() {
            return new AIChatReGenerateResponse(this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1928build();
        }

        public Builder message_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessage_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AIChatReGenerateResponse extends ProtoAdapter<AIChatReGenerateResponse> {
        public ProtoAdapter_AIChatReGenerateResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, AIChatReGenerateResponse.class);
        }

        public AIChatReGenerateResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmessage_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1928build();
        }

        public int encodedSize(AIChatReGenerateResponse r4) {
            return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r4.mmessage_ids) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1929decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AIChatReGenerateResponse) r1);
        }

        public void encode(ProtoWriter r4, AIChatReGenerateResponse r5) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 1, r5.mmessage_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AIChatReGenerateResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIChatReGenerateResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1927newBuilder() {
        Builder r0 = new Builder();
        r0.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AIChatReGenerateResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1927newBuilder();
    }

    public AIChatReGenerateResponse(List<Long> r2) {
        this(r2, ByteString.EMPTY);
    }

    public AIChatReGenerateResponse(List<Long> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r2);
    }
}
