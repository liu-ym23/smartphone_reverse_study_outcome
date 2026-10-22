package com.ss.android.lark.pb.misc;

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
public final class ChattersAuthResult extends Message<ChattersAuthResult, Builder> {
    public static final ProtoAdapter<ChattersAuthResult> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DeniedReason> mdenied_reasons;

    public static final class Builder extends Message.Builder<ChattersAuthResult, Builder> {
        public Map<String, DeniedReason> mdenied_reasons;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChattersAuthResult m1913build() {
            return new ChattersAuthResult(this.mdenied_reasons, super.buildUnknownFields());
        }

        public Builder() {
            this.mdenied_reasons = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1913build();
        }

        public Builder denied_reasons(Map<String, DeniedReason> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdenied_reasons = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChattersAuthResult extends ProtoAdapter<ChattersAuthResult> {
        private final ProtoAdapter<Map<String, DeniedReason>> mdenied_reasons;

        public ProtoAdapter_ChattersAuthResult() {
            super(FieldEncoding.LENGTH_DELIMITED, ChattersAuthResult.class);
            this.mdenied_reasons = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DeniedReason.ADAPTER);
        }

        public ChattersAuthResult decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mdenied_reasons.putAll((Map) this.mdenied_reasons.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1913build();
        }

        public int encodedSize(ChattersAuthResult r4) {
            return this.mdenied_reasons.encodedSizeWithTag(1, r4.mdenied_reasons) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1914decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChattersAuthResult) r1);
        }

        public void encode(ProtoWriter r4, ChattersAuthResult r5) throws IOException {
            this.mdenied_reasons.encodeWithTag(r4, 1, r5.mdenied_reasons);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChattersAuthResult) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChattersAuthResult();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1912newBuilder() {
        Builder r0 = new Builder();
        r0.mdenied_reasons = Internal.copyOf("mdenied_reasons", this.mdenied_reasons);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChattersAuthResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1912newBuilder();
    }

    public ChattersAuthResult(Map<String, DeniedReason> r2) {
        this(r2, ByteString.EMPTY);
    }

    public ChattersAuthResult(Map<String, DeniedReason> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mdenied_reasons = Internal.immutableCopyOf("mdenied_reasons", r2);
    }
}
