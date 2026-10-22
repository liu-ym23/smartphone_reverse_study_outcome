package com.ss.android.lark.pb.chats;

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
public final class PutChatChatterByMentionResponse extends Message<PutChatChatterByMentionResponse, Builder> {
    public static final ProtoAdapter<PutChatChatterByMentionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, PutChatChatterByMentionResult> mresults;

    public static final class Builder extends Message.Builder<PutChatChatterByMentionResponse, Builder> {
        public Map<Long, PutChatChatterByMentionResult> mresults;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutChatChatterByMentionResponse m908build() {
            return new PutChatChatterByMentionResponse(this.mresults, super.buildUnknownFields());
        }

        public Builder() {
            this.mresults = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m908build();
        }

        public Builder results(Map<Long, PutChatChatterByMentionResult> r1) {
            Internal.checkElementsNotNull(r1);
            this.mresults = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutChatChatterByMentionResponse extends ProtoAdapter<PutChatChatterByMentionResponse> {
        private final ProtoAdapter<Map<Long, PutChatChatterByMentionResult>> mresults;

        public ProtoAdapter_PutChatChatterByMentionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutChatChatterByMentionResponse.class);
            this.mresults = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, PutChatChatterByMentionResult.ADAPTER);
        }

        public PutChatChatterByMentionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mresults.putAll((Map) this.mresults.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m908build();
        }

        public int encodedSize(PutChatChatterByMentionResponse r4) {
            return this.mresults.encodedSizeWithTag(1, r4.mresults) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m909decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutChatChatterByMentionResponse) r1);
        }

        public void encode(ProtoWriter r4, PutChatChatterByMentionResponse r5) throws IOException {
            this.mresults.encodeWithTag(r4, 1, r5.mresults);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutChatChatterByMentionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutChatChatterByMentionResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m907newBuilder() {
        Builder r0 = new Builder();
        r0.mresults = Internal.copyOf("mresults", this.mresults);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutChatChatterByMentionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m907newBuilder();
    }

    public PutChatChatterByMentionResponse(Map<Long, PutChatChatterByMentionResult> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PutChatChatterByMentionResponse(Map<Long, PutChatChatterByMentionResult> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mresults = Internal.immutableCopyOf("mresults", r2);
    }
}
