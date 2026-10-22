package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesMgetChattersRequest extends Message<MinutesMgetChattersRequest, Builder> {
    public static final ProtoAdapter<MinutesMgetChattersRequest> ADAPTER = null;
    public static final ProtoAdapter_MinutesMgetChattersRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chatter_ids;

    public static final class Builder extends Message.Builder<MinutesMgetChattersRequest, Builder> implements d<MinutesMgetChattersRequest> {
        public List<String> chatter_ids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesMgetChattersRequest m1847build() {
            return new MinutesMgetChattersRequest(this.chatter_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.chatter_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1847build();
        }

        public Builder chatter_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.chatter_ids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesMgetChattersRequest extends ProtoAdapter<MinutesMgetChattersRequest> implements c<MinutesMgetChattersRequest> {
        public ProtoAdapter_MinutesMgetChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesMgetChattersRequest.class);
        }

        public MinutesMgetChattersRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.chatter_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1847build();
        }

        public int encodedSize(MinutesMgetChattersRequest r4) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.chatter_ids) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1848decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesMgetChattersRequest) r1);
        }

        public void encode(ProtoWriter r4, MinutesMgetChattersRequest r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.chatter_ids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesMgetChattersRequest) r2);
        }
    }

    static {
        ProtoAdapter_MinutesMgetChattersRequest r0 = new ProtoAdapter_MinutesMgetChattersRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1846newBuilder() {
        Builder r0 = new Builder();
        r0.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesMgetChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1846newBuilder();
    }

    public MinutesMgetChattersRequest(List<String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MinutesMgetChattersRequest(List<String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r2);
    }
}
