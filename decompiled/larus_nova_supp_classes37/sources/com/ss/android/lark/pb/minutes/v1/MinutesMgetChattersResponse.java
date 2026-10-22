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
public final class MinutesMgetChattersResponse extends Message<MinutesMgetChattersResponse, Builder> {
    public static final ProtoAdapter<MinutesMgetChattersResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesMgetChattersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MinutesChatter> chatters;

    public static final class Builder extends Message.Builder<MinutesMgetChattersResponse, Builder> implements d<MinutesMgetChattersResponse> {
        public List<MinutesChatter> chatters;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesMgetChattersResponse m1850build() {
            return new MinutesMgetChattersResponse(this.chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.chatters = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1850build();
        }

        public Builder chatters(List<MinutesChatter> r1) {
            Internal.checkElementsNotNull(r1);
            this.chatters = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesMgetChattersResponse extends ProtoAdapter<MinutesMgetChattersResponse> implements c<MinutesMgetChattersResponse> {
        public ProtoAdapter_MinutesMgetChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesMgetChattersResponse.class);
        }

        public MinutesMgetChattersResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.chatters.add((MinutesChatter) MinutesChatter.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1850build();
        }

        public int encodedSize(MinutesMgetChattersResponse r4) {
            return MinutesChatter.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.chatters) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1851decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesMgetChattersResponse) r1);
        }

        public void encode(ProtoWriter r4, MinutesMgetChattersResponse r5) throws IOException {
            MinutesChatter.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.chatters);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesMgetChattersResponse) r2);
        }
    }

    static {
        ProtoAdapter_MinutesMgetChattersResponse r0 = new ProtoAdapter_MinutesMgetChattersResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1849newBuilder() {
        Builder r0 = new Builder();
        r0.chatters = Internal.copyOf("chatters", this.chatters);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesMgetChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1849newBuilder();
    }

    public MinutesMgetChattersResponse(List<MinutesChatter> r2) {
        this(r2, ByteString.EMPTY);
    }

    public MinutesMgetChattersResponse(List<MinutesChatter> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chatters = Internal.immutableCopyOf("chatters", r2);
    }
}
