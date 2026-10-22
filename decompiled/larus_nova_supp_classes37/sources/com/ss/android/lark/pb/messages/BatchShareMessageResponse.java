package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BatchShareMessageResponse extends Message<BatchShareMessageResponse, Builder> {
    public static final ProtoAdapter<BatchShareMessageResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, com.ss.android.lark.pb.entities.Message> mmessages;

    public static final class Builder extends Message.Builder<BatchShareMessageResponse, Builder> {
        public Map<String, com.ss.android.lark.pb.entities.Message> mmessages;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BatchShareMessageResponse m1793build() {
            return new BatchShareMessageResponse(this.mmessages, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessages = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1793build();
        }

        public Builder messages(Map<String, com.ss.android.lark.pb.entities.Message> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessages = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BatchShareMessageResponse extends ProtoAdapter<BatchShareMessageResponse> {
        private final ProtoAdapter<Map<String, com.ss.android.lark.pb.entities.Message>> mmessages;

        public ProtoAdapter_BatchShareMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchShareMessageResponse.class);
            this.mmessages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, com.ss.android.lark.pb.entities.Message.ADAPTER);
        }

        public BatchShareMessageResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmessages.putAll((Map) this.mmessages.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1793build();
        }

        public int encodedSize(BatchShareMessageResponse r4) {
            return this.mmessages.encodedSizeWithTag(1, r4.mmessages) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1794decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BatchShareMessageResponse) r1);
        }

        public void encode(ProtoWriter r4, BatchShareMessageResponse r5) throws IOException {
            this.mmessages.encodeWithTag(r4, 1, r5.mmessages);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BatchShareMessageResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchShareMessageResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1792newBuilder() {
        Builder r0 = new Builder();
        r0.mmessages = Internal.copyOf("mmessages", this.mmessages);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BatchShareMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1792newBuilder();
    }

    public BatchShareMessageResponse(Map<String, com.ss.android.lark.pb.entities.Message> r2) {
        this(r2, ByteString.EMPTY);
    }

    public BatchShareMessageResponse(Map<String, com.ss.android.lark.pb.entities.Message> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmessages = Internal.immutableCopyOf("mmessages", r2);
    }
}
