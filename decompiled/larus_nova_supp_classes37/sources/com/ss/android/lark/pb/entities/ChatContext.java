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
public final class ChatContext extends com.squareup.wire.Message<ChatContext, Builder> {
    public static final ProtoAdapter<ChatContext> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mextra_map;
    public final AISceneObject mobject;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatContext, Builder> {
        public Map<String, String> mextra_map;
        public AISceneObject mobject;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatContext m1085build() {
            return new ChatContext(this.mextra_map, this.mobject, super.buildUnknownFields());
        }

        public Builder() {
            this.mextra_map = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1085build();
        }

        public Builder extra_map(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextra_map = r1;
            return this;
        }

        public Builder object(AISceneObject r1) {
            this.mobject = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatContext extends ProtoAdapter<ChatContext> {
        private final ProtoAdapter<Map<String, String>> mextra_map;

        public ProtoAdapter_ChatContext() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatContext.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mextra_map = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public ChatContext decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mextra_map.putAll((Map) this.mextra_map.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mobject = (AISceneObject) AISceneObject.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1085build();
        }

        public int encodedSize(ChatContext r5) {
            int r0 = this.mextra_map.encodedSizeWithTag(1, r5.mextra_map);
            AISceneObject r1 = r5.mobject;
            if (r1 == null) goto L5;
            int r2 = AISceneObject.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1086decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatContext) r1);
        }

        public void encode(ProtoWriter r4, ChatContext r5) throws IOException {
            this.mextra_map.encodeWithTag(r4, 1, r5.mextra_map);
            AISceneObject r0 = r5.mobject;
            if (r0 == null) goto L5;
            AISceneObject.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatContext) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatContext();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1084newBuilder() {
        Builder r0 = new Builder();
        r0.mextra_map = Internal.copyOf("mextra_map", this.mextra_map);
        r0.mobject = this.mobject;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1084newBuilder();
    }

    public ChatContext(Map<String, String> r2, AISceneObject r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ChatContext(Map<String, String> r2, AISceneObject r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mextra_map = Internal.immutableCopyOf("mextra_map", r2);
        this.mobject = r3;
    }
}
