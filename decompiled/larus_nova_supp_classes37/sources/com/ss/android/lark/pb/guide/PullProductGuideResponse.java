package com.ss.android.lark.pb.guide;

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
public final class PullProductGuideResponse extends Message<PullProductGuideResponse, Builder> {
    public static final ProtoAdapter<PullProductGuideResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mguides;

    public static final class Builder extends Message.Builder<PullProductGuideResponse, Builder> {
        public Map<String, Boolean> mguides;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullProductGuideResponse m1733build() {
            return new PullProductGuideResponse(this.mguides, super.buildUnknownFields());
        }

        public Builder() {
            this.mguides = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1733build();
        }

        public Builder guides(Map<String, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mguides = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullProductGuideResponse extends ProtoAdapter<PullProductGuideResponse> {
        private final ProtoAdapter<Map<String, Boolean>> mguides;

        public ProtoAdapter_PullProductGuideResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullProductGuideResponse.class);
            this.mguides = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        public PullProductGuideResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 2) goto L7;
            r0.mguides.putAll((Map) this.mguides.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1733build();
        }

        public int encodedSize(PullProductGuideResponse r4) {
            return this.mguides.encodedSizeWithTag(2, r4.mguides) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1734decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullProductGuideResponse) r1);
        }

        public void encode(ProtoWriter r4, PullProductGuideResponse r5) throws IOException {
            this.mguides.encodeWithTag(r4, 2, r5.mguides);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullProductGuideResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullProductGuideResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1732newBuilder() {
        Builder r0 = new Builder();
        r0.mguides = Internal.copyOf("mguides", this.mguides);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullProductGuideResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1732newBuilder();
    }

    public PullProductGuideResponse(Map<String, Boolean> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullProductGuideResponse(Map<String, Boolean> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mguides = Internal.immutableCopyOf("mguides", r2);
    }
}
