package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.ai_topic_stream_search.Resource;
import com.ss.android.lark.pb.entities.RichText;
import com.ss.android.lark.pb.entities.UrlPreviewHangPoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QueryContent extends Message<QueryContent, Builder> {
    public static final ProtoAdapter<QueryContent> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_QUOTE_BLOCK = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final Map<String, UrlPreviewHangPoint> mlink_preview_hang_points;
    public final Map<String, LinkPreviewInfo> mlink_preview_infos;
    public final String mquote_block;
    public final List<Resource> mresources;
    public final RichText mrich_text;

    public static final class Builder extends Message.Builder<QueryContent, Builder> {
        public String mcontent;
        public Map<String, UrlPreviewHangPoint> mlink_preview_hang_points;
        public Map<String, LinkPreviewInfo> mlink_preview_infos;
        public String mquote_block;
        public List<Resource> mresources;
        public RichText mrich_text;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public QueryContent m803build() {
            return new QueryContent(this.mcontent, this.mresources, this.mlink_preview_infos, this.mlink_preview_hang_points, this.mrich_text, this.mquote_block, super.buildUnknownFields());
        }

        public Builder() {
            this.mresources = Internal.newMutableList();
            this.mlink_preview_infos = Internal.newMutableMap();
            this.mlink_preview_hang_points = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m803build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder link_preview_hang_points(Map<String, UrlPreviewHangPoint> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlink_preview_hang_points = r1;
            return this;
        }

        public Builder link_preview_infos(Map<String, LinkPreviewInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlink_preview_infos = r1;
            return this;
        }

        public Builder quote_block(String r1) {
            this.mquote_block = r1;
            return this;
        }

        public Builder resources(List<Resource> r1) {
            Internal.checkElementsNotNull(r1);
            this.mresources = r1;
            return this;
        }

        public Builder rich_text(RichText r1) {
            this.mrich_text = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_QueryContent extends ProtoAdapter<QueryContent> {
        private final ProtoAdapter<Map<String, UrlPreviewHangPoint>> mlink_preview_hang_points;
        private final ProtoAdapter<Map<String, LinkPreviewInfo>> mlink_preview_infos;

        public ProtoAdapter_QueryContent() {
            super(FieldEncoding.LENGTH_DELIMITED, QueryContent.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mlink_preview_infos = ProtoAdapter.newMapAdapter(r0, LinkPreviewInfo.ADAPTER);
            this.mlink_preview_hang_points = ProtoAdapter.newMapAdapter(r0, UrlPreviewHangPoint.ADAPTER);
        }

        public QueryContent decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            r0.mquote_block = "";
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
            r0.mquote_block = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mrich_text = (RichText) RichText.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mlink_preview_hang_points.putAll((Map) this.mlink_preview_hang_points.decode(r7));
            goto L3
        L10:
            r0.mlink_preview_infos.putAll((Map) this.mlink_preview_infos.decode(r7));
            goto L3
        L11:
            r0.mresources.add((Resource) Resource.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m803build();
        }

        public int encodedSize(QueryContent r6) {
            String r0 = r6.mcontent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            int r3 = ((r2 + Resource.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mresources)) + this.mlink_preview_infos.encodedSizeWithTag(3, r6.mlink_preview_infos)) + this.mlink_preview_hang_points.encodedSizeWithTag(4, r6.mlink_preview_hang_points);
            RichText r4 = r6.mrich_text;
            if (r4 == null) goto L9;
            int r5 = RichText.ADAPTER.encodedSizeWithTag(5, r4);
        L10:
            int r7 = r3 + r5;
            String r8 = r6.mquote_block;
            if (r8 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r8);
        L14:
            return (r7 + r1) + r6.unknownFields().size();
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m804decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((QueryContent) r1);
        }

        public void encode(ProtoWriter r4, QueryContent r5) throws IOException {
            String r0 = r5.mcontent;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Resource.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mresources);
            this.mlink_preview_infos.encodeWithTag(r4, 3, r5.mlink_preview_infos);
            this.mlink_preview_hang_points.encodeWithTag(r4, 4, r5.mlink_preview_hang_points);
            RichText r1 = r5.mrich_text;
            if (r1 == null) goto L8;
            RichText.ADAPTER.encodeWithTag(r4, 5, r1);
        L8:
            String r2 = r5.mquote_block;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (QueryContent) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QueryContent();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m802newBuilder() {
        Builder r0 = new Builder();
        r0.mcontent = this.mcontent;
        r0.mresources = Internal.copyOf("mresources", this.mresources);
        r0.mlink_preview_infos = Internal.copyOf("mlink_preview_infos", this.mlink_preview_infos);
        r0.mlink_preview_hang_points = Internal.copyOf("mlink_preview_hang_points", this.mlink_preview_hang_points);
        r0.mrich_text = this.mrich_text;
        r0.mquote_block = this.mquote_block;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return QueryContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m802newBuilder();
    }

    public QueryContent(String r9, List<Resource> r10, Map<String, LinkPreviewInfo> r11, Map<String, UrlPreviewHangPoint> r12, RichText r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public QueryContent(String r2, List<Resource> r3, Map<String, LinkPreviewInfo> r4, Map<String, UrlPreviewHangPoint> r5, RichText r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mcontent = r2;
        this.mresources = Internal.immutableCopyOf("mresources", r3);
        this.mlink_preview_infos = Internal.immutableCopyOf("mlink_preview_infos", r4);
        this.mlink_preview_hang_points = Internal.immutableCopyOf("mlink_preview_hang_points", r5);
        this.mrich_text = r6;
        this.mquote_block = r7;
    }
}
