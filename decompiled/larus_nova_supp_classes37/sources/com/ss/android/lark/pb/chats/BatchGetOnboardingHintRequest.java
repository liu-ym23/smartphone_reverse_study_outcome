package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
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
public final class BatchGetOnboardingHintRequest extends Message<BatchGetOnboardingHintRequest, Builder> {
    public static final ProtoAdapter<BatchGetOnboardingHintRequest> ADAPTER = null;
    public static final Long DEFAULT_UID = null;
    public static final FieldOptions FIELD_OPTIONS_MUID = null;
    private static final long serialVersionUID = 0;
    public final List<String> mconfig_keys;
    public final Long muid;

    public static final class Builder extends Message.Builder<BatchGetOnboardingHintRequest, Builder> {
        public List<String> mconfig_keys;
        public Long muid;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BatchGetOnboardingHintRequest m863build() {
            Long r0 = this.muid;
            if (r0 == null) goto L7;
            return new BatchGetOnboardingHintRequest(this.muid, this.mconfig_keys, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "muid"});
        }

        public Builder() {
            this.mconfig_keys = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m863build();
        }

        public Builder config_keys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mconfig_keys = r1;
            return this;
        }

        public Builder uid(Long r1) {
            this.muid = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BatchGetOnboardingHintRequest extends ProtoAdapter<BatchGetOnboardingHintRequest> {
        public ProtoAdapter_BatchGetOnboardingHintRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchGetOnboardingHintRequest.class);
        }

        public BatchGetOnboardingHintRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.muid = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.muid = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mconfig_keys.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m863build();
        }

        public int encodedSize(BatchGetOnboardingHintRequest r5) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r5.muid) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r5.mconfig_keys)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m864decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BatchGetOnboardingHintRequest) r1);
        }

        public void encode(ProtoWriter r4, BatchGetOnboardingHintRequest r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.muid);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 2, r5.mconfig_keys);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BatchGetOnboardingHintRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchGetOnboardingHintRequest();
        FIELD_OPTIONS_MUID = new FieldOptions.Builder().FieldInfo("split,type=user").build();
        DEFAULT_UID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m862newBuilder() {
        Builder r0 = new Builder();
        r0.muid = this.muid;
        r0.mconfig_keys = Internal.copyOf("mconfig_keys", this.mconfig_keys);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BatchGetOnboardingHintRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m862newBuilder();
    }

    public BatchGetOnboardingHintRequest(Long r2, List<String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public BatchGetOnboardingHintRequest(Long r2, List<String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.muid = r2;
        this.mconfig_keys = Internal.immutableCopyOf("mconfig_keys", r3);
    }
}
