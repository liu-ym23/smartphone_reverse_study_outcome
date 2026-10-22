package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchQAHistory extends Message<SearchQAHistory, Builder> {
    public static final ProtoAdapter<SearchQAHistory> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_CACHE_KEY = "";
    public static final String DEFAULT_EXPIRE_TIME = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String manswer;
    public final String mapp_link;
    public final String mcache_key;
    public final String mexpire_time;
    public final String mquery;
    public final TopicInfo mtopic_info;

    public static final class Builder extends Message.Builder<SearchQAHistory, Builder> {
        public String manswer;
        public String mapp_link;
        public String mcache_key;
        public String mexpire_time;
        public String mquery;
        public TopicInfo mtopic_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchQAHistory m809build() {
            return new SearchQAHistory(this.mapp_link, this.mquery, this.manswer, this.mexpire_time, this.mcache_key, this.mtopic_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m809build();
        }

        public Builder answer(String r1) {
            this.manswer = r1;
            return this;
        }

        public Builder app_link(String r1) {
            this.mapp_link = r1;
            return this;
        }

        public Builder cache_key(String r1) {
            this.mcache_key = r1;
            return this;
        }

        public Builder expire_time(String r1) {
            this.mexpire_time = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }

        public Builder topic_info(TopicInfo r1) {
            this.mtopic_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchQAHistory extends ProtoAdapter<SearchQAHistory> {
        public ProtoAdapter_SearchQAHistory() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchQAHistory.class);
        }

        public SearchQAHistory decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mapp_link = "";
            r0.mquery = "";
            r0.manswer = "";
            r0.mexpire_time = "";
            r0.mcache_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.mtopic_info = (TopicInfo) TopicInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            r0.mcache_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mexpire_time = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.manswer = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mquery = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mapp_link = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m809build();
        }

        public int encodedSize(SearchQAHistory r6) {
            String r0 = r6.mapp_link;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mquery;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.manswer;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mexpire_time;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mcache_key;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            TopicInfo r16 = r6.mtopic_info;
            if (r16 == null) goto L26;
            r1 = TopicInfo.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m810decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchQAHistory) r1);
        }

        public void encode(ProtoWriter r4, SearchQAHistory r5) throws IOException {
            String r0 = r5.mapp_link;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mquery;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.manswer;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mexpire_time;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mcache_key;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            TopicInfo r7 = r5.mtopic_info;
            if (r7 == null) goto L20;
            TopicInfo.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchQAHistory) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchQAHistory();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m808newBuilder() {
        Builder r0 = new Builder();
        r0.mapp_link = this.mapp_link;
        r0.mquery = this.mquery;
        r0.manswer = this.manswer;
        r0.mexpire_time = this.mexpire_time;
        r0.mcache_key = this.mcache_key;
        r0.mtopic_info = this.mtopic_info;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchQAHistory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m808newBuilder();
    }

    public SearchQAHistory(String r9, String r10, String r11, String r12, String r13, TopicInfo r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SearchQAHistory(String r2, String r3, String r4, String r5, String r6, TopicInfo r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mapp_link = r2;
        this.mquery = r3;
        this.manswer = r4;
        this.mexpire_time = r5;
        this.mcache_key = r6;
        this.mtopic_info = r7;
    }
}
