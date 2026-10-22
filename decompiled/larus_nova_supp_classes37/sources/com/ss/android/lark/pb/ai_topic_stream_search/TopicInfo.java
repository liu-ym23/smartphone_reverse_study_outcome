package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TopicInfo extends Message<TopicInfo, Builder> {
    public static final ProtoAdapter<TopicInfo> ADAPTER = null;
    public static final String DEFAULT_ROUND_ID = "";
    public static final String DEFAULT_TOPIC_ID = "";
    private static final long serialVersionUID = 0;
    public final String mround_id;
    public final String mtopic_id;

    public static final class Builder extends Message.Builder<TopicInfo, Builder> {
        public String mround_id;
        public String mtopic_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TopicInfo m812build() {
            return new TopicInfo(this.mtopic_id, this.mround_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m812build();
        }

        public Builder round_id(String r1) {
            this.mround_id = r1;
            return this;
        }

        public Builder topic_id(String r1) {
            this.mtopic_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TopicInfo extends ProtoAdapter<TopicInfo> {
        public ProtoAdapter_TopicInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TopicInfo.class);
        }

        public TopicInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtopic_id = "";
            r0.mround_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtopic_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mround_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m812build();
        }

        public int encodedSize(TopicInfo r5) {
            String r0 = r5.mtopic_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mround_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m813decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TopicInfo) r1);
        }

        public void encode(ProtoWriter r4, TopicInfo r5) throws IOException {
            String r0 = r5.mtopic_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mround_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TopicInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TopicInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m811newBuilder() {
        Builder r0 = new Builder();
        r0.mtopic_id = this.mtopic_id;
        r0.mround_id = this.mround_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TopicInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m811newBuilder();
    }

    public TopicInfo(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public TopicInfo(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtopic_id = r2;
        this.mround_id = r3;
    }
}
