package com.ss.android.lark.pb.messages;

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
public final class PullMessageDocPermsRequest extends Message<PullMessageDocPermsRequest, Builder> {
    public static final ProtoAdapter<PullMessageDocPermsRequest> ADAPTER = null;
    public static final FieldOptions FIELD_OPTIONS_MMESSAGE_IDS = null;
    private static final long serialVersionUID = 0;
    public final List<String> mmessage_ids;

    public static final class Builder extends Message.Builder<PullMessageDocPermsRequest, Builder> {
        public List<String> mmessage_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullMessageDocPermsRequest m1808build() {
            return new PullMessageDocPermsRequest(this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1808build();
        }

        public Builder message_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmessage_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullMessageDocPermsRequest extends ProtoAdapter<PullMessageDocPermsRequest> {
        public ProtoAdapter_PullMessageDocPermsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullMessageDocPermsRequest.class);
        }

        public PullMessageDocPermsRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmessage_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1808build();
        }

        public int encodedSize(PullMessageDocPermsRequest r4) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mmessage_ids) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1809decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullMessageDocPermsRequest) r1);
        }

        public void encode(ProtoWriter r4, PullMessageDocPermsRequest r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mmessage_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullMessageDocPermsRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullMessageDocPermsRequest();
        FIELD_OPTIONS_MMESSAGE_IDS = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1807newBuilder() {
        Builder r0 = new Builder();
        r0.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullMessageDocPermsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1807newBuilder();
    }

    public PullMessageDocPermsRequest(List<String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullMessageDocPermsRequest(List<String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r2);
    }
}
