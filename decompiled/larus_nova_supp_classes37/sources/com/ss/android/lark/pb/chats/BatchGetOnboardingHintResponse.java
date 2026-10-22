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
public final class BatchGetOnboardingHintResponse extends Message<BatchGetOnboardingHintResponse, Builder> {
    public static final ProtoAdapter<BatchGetOnboardingHintResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mconfig_values;

    public static final class Builder extends Message.Builder<BatchGetOnboardingHintResponse, Builder> {
        public Map<String, Boolean> mconfig_values;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BatchGetOnboardingHintResponse m866build() {
            return new BatchGetOnboardingHintResponse(this.mconfig_values, super.buildUnknownFields());
        }

        public Builder() {
            this.mconfig_values = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m866build();
        }

        public Builder config_values(Map<String, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mconfig_values = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BatchGetOnboardingHintResponse extends ProtoAdapter<BatchGetOnboardingHintResponse> {
        private final ProtoAdapter<Map<String, Boolean>> mconfig_values;

        public ProtoAdapter_BatchGetOnboardingHintResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchGetOnboardingHintResponse.class);
            this.mconfig_values = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        public BatchGetOnboardingHintResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mconfig_values.putAll((Map) this.mconfig_values.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m866build();
        }

        public int encodedSize(BatchGetOnboardingHintResponse r4) {
            return this.mconfig_values.encodedSizeWithTag(1, r4.mconfig_values) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m867decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BatchGetOnboardingHintResponse) r1);
        }

        public void encode(ProtoWriter r4, BatchGetOnboardingHintResponse r5) throws IOException {
            this.mconfig_values.encodeWithTag(r4, 1, r5.mconfig_values);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BatchGetOnboardingHintResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchGetOnboardingHintResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m865newBuilder() {
        Builder r0 = new Builder();
        r0.mconfig_values = Internal.copyOf("mconfig_values", this.mconfig_values);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BatchGetOnboardingHintResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m865newBuilder();
    }

    public BatchGetOnboardingHintResponse(Map<String, Boolean> r2) {
        this(r2, ByteString.EMPTY);
    }

    public BatchGetOnboardingHintResponse(Map<String, Boolean> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mconfig_values = Internal.immutableCopyOf("mconfig_values", r2);
    }
}
