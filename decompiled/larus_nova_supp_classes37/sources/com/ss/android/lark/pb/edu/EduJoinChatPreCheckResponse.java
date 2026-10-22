package com.ss.android.lark.pb.edu;

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
public final class EduJoinChatPreCheckResponse extends Message<EduJoinChatPreCheckResponse, Builder> {
    public static final ProtoAdapter<EduJoinChatPreCheckResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> muser_ids;

    public static final class Builder extends Message.Builder<EduJoinChatPreCheckResponse, Builder> {
        public Map<String, Boolean> muser_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public EduJoinChatPreCheckResponse m986build() {
            return new EduJoinChatPreCheckResponse(this.muser_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_ids = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m986build();
        }

        public Builder user_ids(Map<String, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.muser_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_EduJoinChatPreCheckResponse extends ProtoAdapter<EduJoinChatPreCheckResponse> {
        private final ProtoAdapter<Map<String, Boolean>> muser_ids;

        public ProtoAdapter_EduJoinChatPreCheckResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, EduJoinChatPreCheckResponse.class);
            this.muser_ids = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        public EduJoinChatPreCheckResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.muser_ids.putAll((Map) this.muser_ids.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m986build();
        }

        public int encodedSize(EduJoinChatPreCheckResponse r4) {
            return this.muser_ids.encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m987decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((EduJoinChatPreCheckResponse) r1);
        }

        public void encode(ProtoWriter r4, EduJoinChatPreCheckResponse r5) throws IOException {
            this.muser_ids.encodeWithTag(r4, 1, r5.muser_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (EduJoinChatPreCheckResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EduJoinChatPreCheckResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m985newBuilder() {
        Builder r0 = new Builder();
        r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return EduJoinChatPreCheckResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m985newBuilder();
    }

    public EduJoinChatPreCheckResponse(Map<String, Boolean> r2) {
        this(r2, ByteString.EMPTY);
    }

    public EduJoinChatPreCheckResponse(Map<String, Boolean> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
    }
}
