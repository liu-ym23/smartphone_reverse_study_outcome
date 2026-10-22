package com.ss.android.lark.pb.videochat_my_ai;

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
public final class AILayoutTopic extends Message<AILayoutTopic, Builder> {
    public static final ProtoAdapter<AILayoutTopic> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final List<MeetingAISSDUser> musers;

    public static final class Builder extends Message.Builder<AILayoutTopic, Builder> {
        public String mcontent;
        public List<MeetingAISSDUser> musers;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AILayoutTopic m3227build() {
            return new AILayoutTopic(this.mcontent, this.musers, super.buildUnknownFields());
        }

        public Builder() {
            this.musers = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3227build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder users(List<MeetingAISSDUser> r1) {
            Internal.checkElementsNotNull(r1);
            this.musers = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AILayoutTopic extends ProtoAdapter<AILayoutTopic> {
        public ProtoAdapter_AILayoutTopic() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutTopic.class);
        }

        public AILayoutTopic decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.musers.add((MeetingAISSDUser) MeetingAISSDUser.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3227build();
        }

        public int encodedSize(AILayoutTopic r5) {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return (r1 + MeetingAISSDUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.musers)) + r5.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3228decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AILayoutTopic) r1);
        }

        public void encode(ProtoWriter r4, AILayoutTopic r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            MeetingAISSDUser.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.musers);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AILayoutTopic) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutTopic();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3226newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.musers = Internal.copyOf("musers", this.musers);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AILayoutTopic.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3226newBuilder();
    }

    public AILayoutTopic(String r2, List<MeetingAISSDUser> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public AILayoutTopic(String r2, List<MeetingAISSDUser> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mcontent = r2;
        this.musers = Internal.immutableCopyOf("musers", r3);
    }
}
