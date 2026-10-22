package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatConfig extends com.squareup.wire.Message<ChatConfig, Builder> {
    public static final ProtoAdapter<ChatConfig> ADAPTER = null;
    public static final Boolean DEFAULT_CHATABLE = null;
    public static final Boolean DEFAULT_IN_TOTAL_BADGE = null;
    public static final Boolean DEFAULT_MUTEABLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mchatable;
    public final Boolean min_total_badge;
    public final Boolean mmuteable;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatConfig, Builder> {
        public Boolean mchatable;
        public Boolean min_total_badge;
        public Boolean mmuteable;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatConfig m1082build() {
            return new ChatConfig(this.mchatable, this.mmuteable, this.min_total_badge, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1082build();
        }

        public Builder chatable(Boolean r1) {
            this.mchatable = r1;
            return this;
        }

        public Builder in_total_badge(Boolean r1) {
            this.min_total_badge = r1;
            return this;
        }

        public Builder muteable(Boolean r1) {
            this.mmuteable = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatConfig extends ProtoAdapter<ChatConfig> {
        public ProtoAdapter_ChatConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatConfig.class);
        }

        public ChatConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.TRUE;
            r0.mchatable = r1;
            r0.mmuteable = r1;
            r0.min_total_badge = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mchatable = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mmuteable = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.min_total_badge = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.m1082build();
        }

        public int encodedSize(ChatConfig r6) {
            Boolean r0 = r6.mchatable;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mmuteable;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.min_total_badge;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1083decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatConfig) r1);
        }

        public void encode(ProtoWriter r4, ChatConfig r5) throws IOException {
            Boolean r0 = r5.mchatable;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mmuteable;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.min_total_badge;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatConfig();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_CHATABLE = r0;
        DEFAULT_MUTEABLE = r0;
        DEFAULT_IN_TOTAL_BADGE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1081newBuilder() {
        Builder r0 = new Builder();
        r0.mchatable = this.mchatable;
        r0.mmuteable = this.mmuteable;
        r0.min_total_badge = this.min_total_badge;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1081newBuilder();
    }

    public ChatConfig(Boolean r2, Boolean r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ChatConfig(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mchatable = r2;
        this.mmuteable = r3;
        this.min_total_badge = r4;
    }
}
