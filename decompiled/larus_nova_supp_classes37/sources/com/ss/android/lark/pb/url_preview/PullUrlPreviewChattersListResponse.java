package com.ss.android.lark.pb.url_preview;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.URLPreviewComponent;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullUrlPreviewChattersListResponse extends Message<PullUrlPreviewChattersListResponse, Builder> {
    public static final ProtoAdapter<PullUrlPreviewChattersListResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_NEXT_TOKEN = "";
    private static final long serialVersionUID = 0;
    public final List<String> mchatter_ids;
    public final List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> mchatter_infos;
    public final Boolean mhas_more;
    public final String mnext_token;

    public static final class Builder extends Message.Builder<PullUrlPreviewChattersListResponse, Builder> {
        public List<String> mchatter_ids;
        public List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> mchatter_infos;
        public Boolean mhas_more;
        public String mnext_token;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUrlPreviewChattersListResponse m2492build() {
            return new PullUrlPreviewChattersListResponse(this.mchatter_ids, this.mchatter_infos, this.mhas_more, this.mnext_token, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatter_ids = Internal.newMutableList();
            this.mchatter_infos = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2492build();
        }

        public Builder chatter_ids(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatter_ids = r1;
            return this;
        }

        public Builder chatter_infos(List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatter_infos = r1;
            return this;
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder next_token(String r1) {
            this.mnext_token = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUrlPreviewChattersListResponse extends ProtoAdapter<PullUrlPreviewChattersListResponse> {
        public ProtoAdapter_PullUrlPreviewChattersListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUrlPreviewChattersListResponse.class);
        }

        public PullUrlPreviewChattersListResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhas_more = Boolean.FALSE;
            r0.mnext_token = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mchatter_ids.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchatter_infos.add((URLPreviewComponent.ChattersPreviewProperty.ChatterInfo) URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mnext_token = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m2492build();
        }

        public int encodedSize(PullUrlPreviewChattersListResponse r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.asRepeated().encodedSizeWithTag(1, r7.mchatter_ids) + URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r7.mchatter_infos);
            Boolean r2 = r7.mhas_more;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mnext_token;
            if (r6 == null) goto L10;
            r3 = r0.encodedSizeWithTag(4, r6);
        L10:
            return (r5 + r3) + r7.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2493decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUrlPreviewChattersListResponse) r1);
        }

        public void encode(ProtoWriter r5, PullUrlPreviewChattersListResponse r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.asRepeated().encodeWithTag(r5, 1, r6.mchatter_ids);
            URLPreviewComponent.ChattersPreviewProperty.ChatterInfo.ADAPTER.asRepeated().encodeWithTag(r5, 2, r6.mchatter_infos);
            Boolean r1 = r6.mhas_more;
            if (r1 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 3, r1);
        L5:
            String r2 = r6.mnext_token;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUrlPreviewChattersListResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUrlPreviewChattersListResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2491newBuilder() {
        Builder r0 = new Builder();
        r0.mchatter_ids = Internal.copyOf("mchatter_ids", this.mchatter_ids);
        r0.mchatter_infos = Internal.copyOf("mchatter_infos", this.mchatter_infos);
        r0.mhas_more = this.mhas_more;
        r0.mnext_token = this.mnext_token;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUrlPreviewChattersListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2491newBuilder();
    }

    public PullUrlPreviewChattersListResponse(List<String> r7, List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r8, Boolean r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullUrlPreviewChattersListResponse(List<String> r2, List<URLPreviewComponent.ChattersPreviewProperty.ChatterInfo> r3, Boolean r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mchatter_ids = Internal.immutableCopyOf("mchatter_ids", r2);
        this.mchatter_infos = Internal.immutableCopyOf("mchatter_infos", r3);
        this.mhas_more = r4;
        this.mnext_token = r5;
    }
}
