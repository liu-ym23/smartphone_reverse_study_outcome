package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullDocFeedCardsRequest extends Message<PullDocFeedCardsRequest, Builder> {
    public static final ProtoAdapter<PullDocFeedCardsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_IS_NEED_AGENT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_need_agent;

    public static final class Builder extends Message.Builder<PullDocFeedCardsRequest, Builder> {
        public Boolean mis_need_agent;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullDocFeedCardsRequest m2753build() {
            return new PullDocFeedCardsRequest(this.mis_need_agent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2753build();
        }

        public Builder is_need_agent(Boolean r1) {
            this.mis_need_agent = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDocFeedCardsRequest extends ProtoAdapter<PullDocFeedCardsRequest> {
        public ProtoAdapter_PullDocFeedCardsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDocFeedCardsRequest.class);
        }

        public PullDocFeedCardsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mis_need_agent = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mis_need_agent = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2753build();
        }

        public int encodedSize(PullDocFeedCardsRequest r4) {
            Boolean r0 = r4.mis_need_agent;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2754decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullDocFeedCardsRequest) r1);
        }

        public void encode(ProtoWriter r4, PullDocFeedCardsRequest r5) throws IOException {
            Boolean r0 = r5.mis_need_agent;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullDocFeedCardsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDocFeedCardsRequest();
        DEFAULT_IS_NEED_AGENT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2752newBuilder() {
        Builder r0 = new Builder();
        r0.mis_need_agent = this.mis_need_agent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullDocFeedCardsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2752newBuilder();
    }

    public PullDocFeedCardsRequest(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullDocFeedCardsRequest(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mis_need_agent = r2;
    }
}
