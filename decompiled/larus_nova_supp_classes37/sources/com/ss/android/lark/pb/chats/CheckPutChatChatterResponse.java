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
public final class CheckPutChatChatterResponse extends Message<CheckPutChatChatterResponse, Builder> {
    public static final ProtoAdapter<CheckPutChatChatterResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, CheckPutChatChatterResult> mresults;

    public static final class Builder extends Message.Builder<CheckPutChatChatterResponse, Builder> {
        public Map<Long, CheckPutChatChatterResult> mresults;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CheckPutChatChatterResponse m872build() {
            return new CheckPutChatChatterResponse(this.mresults, super.buildUnknownFields());
        }

        public Builder() {
            this.mresults = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m872build();
        }

        public Builder results(Map<Long, CheckPutChatChatterResult> r1) {
            Internal.checkElementsNotNull(r1);
            this.mresults = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPutChatChatterResponse extends ProtoAdapter<CheckPutChatChatterResponse> {
        private final ProtoAdapter<Map<Long, CheckPutChatChatterResult>> mresults;

        public ProtoAdapter_CheckPutChatChatterResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPutChatChatterResponse.class);
            this.mresults = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, CheckPutChatChatterResult.ADAPTER);
        }

        public CheckPutChatChatterResponse decode(ProtoReader r7) throws IOException {
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
            return r0.m872build();
        }

        public int encodedSize(CheckPutChatChatterResponse r4) {
            return this.mresults.encodedSizeWithTag(1, r4.mresults) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m873decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CheckPutChatChatterResponse) r1);
        }

        public void encode(ProtoWriter r4, CheckPutChatChatterResponse r5) throws IOException {
            this.mresults.encodeWithTag(r4, 1, r5.mresults);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CheckPutChatChatterResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPutChatChatterResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m871newBuilder() {
        Builder r0 = new Builder();
        r0.mresults = Internal.copyOf("mresults", this.mresults);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CheckPutChatChatterResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m871newBuilder();
    }

    public CheckPutChatChatterResponse(Map<Long, CheckPutChatChatterResult> r2) {
        this(r2, ByteString.EMPTY);
    }

    public CheckPutChatChatterResponse(Map<Long, CheckPutChatChatterResult> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mresults = Internal.immutableCopyOf("mresults", r2);
    }
}
