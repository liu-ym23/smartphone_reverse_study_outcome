package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BotMutedInfo extends com.squareup.wire.Message<BotMutedInfo, Builder> {
    public static final ProtoAdapter<BotMutedInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> mmuted_scenes;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotMutedInfo, Builder> {
        public Map<String, Boolean> mmuted_scenes;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BotMutedInfo m1031build() {
            return new BotMutedInfo(this.mmuted_scenes, super.buildUnknownFields());
        }

        public Builder() {
            this.mmuted_scenes = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1031build();
        }

        public Builder muted_scenes(Map<String, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mmuted_scenes = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BotMutedInfo extends ProtoAdapter<BotMutedInfo> {
        private final ProtoAdapter<Map<String, Boolean>> mmuted_scenes;

        public ProtoAdapter_BotMutedInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BotMutedInfo.class);
            this.mmuted_scenes = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        public BotMutedInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mmuted_scenes.putAll((Map) this.mmuted_scenes.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1031build();
        }

        public int encodedSize(BotMutedInfo r4) {
            return this.mmuted_scenes.encodedSizeWithTag(1, r4.mmuted_scenes) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1032decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BotMutedInfo) r1);
        }

        public void encode(ProtoWriter r4, BotMutedInfo r5) throws IOException {
            this.mmuted_scenes.encodeWithTag(r4, 1, r5.mmuted_scenes);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BotMutedInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotMutedInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1030newBuilder() {
        Builder r0 = new Builder();
        r0.mmuted_scenes = Internal.copyOf("mmuted_scenes", this.mmuted_scenes);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BotMutedInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1030newBuilder();
    }

    public BotMutedInfo(Map<String, Boolean> r2) {
        this(r2, ByteString.EMPTY);
    }

    public BotMutedInfo(Map<String, Boolean> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mmuted_scenes = Internal.immutableCopyOf("mmuted_scenes", r2);
    }
}
