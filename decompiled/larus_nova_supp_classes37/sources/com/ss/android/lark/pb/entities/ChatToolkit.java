package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatToolkit extends com.squareup.wire.Message<ChatToolkit, Builder> {
    public static final ProtoAdapter<ChatToolkit> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Long> mids;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatToolkit, Builder> {
        public List<Long> mids;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatToolkit m1166build() {
            return new ChatToolkit(this.mids, super.buildUnknownFields());
        }

        public Builder() {
            this.mids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1166build();
        }

        public Builder ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mids = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatToolkit extends ProtoAdapter<ChatToolkit> {
        public ProtoAdapter_ChatToolkit() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatToolkit.class);
        }

        public ChatToolkit decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1166build();
        }

        public int encodedSize(ChatToolkit r4) {
            return ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r4.mids) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1167decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatToolkit) r1);
        }

        public void encode(ProtoWriter r4, ChatToolkit r5) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 1, r5.mids);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatToolkit) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatToolkit();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1165newBuilder() {
        Builder r0 = new Builder();
        r0.mids = Internal.copyOf("mids", this.mids);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatToolkit.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1165newBuilder();
    }

    public ChatToolkit(List<Long> r2) {
        this(r2, ByteString.EMPTY);
    }

    public ChatToolkit(List<Long> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mids = Internal.immutableCopyOf("mids", r2);
    }
}
