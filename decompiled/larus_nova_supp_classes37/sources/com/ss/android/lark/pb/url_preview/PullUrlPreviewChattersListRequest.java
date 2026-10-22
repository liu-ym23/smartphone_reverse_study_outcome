package com.ss.android.lark.pb.url_preview;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullUrlPreviewChattersListRequest extends Message<PullUrlPreviewChattersListRequest, Builder> {
    public static final ProtoAdapter<PullUrlPreviewChattersListRequest> ADAPTER = null;
    public static final String DEFAULT_COMPONENT_ID = "";
    public static final String DEFAULT_NEXT_TOKEN = "";
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MPREVIEW_ID = null;
    private static final long serialVersionUID = 0;
    public final String mcomponent_id;
    public final String mnext_token;
    public final String mpreview_id;

    public static final class Builder extends Message.Builder<PullUrlPreviewChattersListRequest, Builder> {
        public String mcomponent_id;
        public String mnext_token;
        public String mpreview_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUrlPreviewChattersListRequest m2489build() {
            String r0 = this.mpreview_id;
            if (r0 == null) goto L7;
            return new PullUrlPreviewChattersListRequest(this.mpreview_id, this.mcomponent_id, this.mnext_token, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mpreview_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2489build();
        }

        public Builder component_id(String r1) {
            this.mcomponent_id = r1;
            return this;
        }

        public Builder next_token(String r1) {
            this.mnext_token = r1;
            return this;
        }

        public Builder preview_id(String r1) {
            this.mpreview_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUrlPreviewChattersListRequest extends ProtoAdapter<PullUrlPreviewChattersListRequest> {
        public ProtoAdapter_PullUrlPreviewChattersListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUrlPreviewChattersListRequest.class);
        }

        public PullUrlPreviewChattersListRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mpreview_id = "";
            r0.mcomponent_id = "";
            r0.mnext_token = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mpreview_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcomponent_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mnext_token = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2489build();
        }

        public int encodedSize(PullUrlPreviewChattersListRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mpreview_id);
            String r2 = r6.mcomponent_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.mnext_token;
            if (r7 == null) goto L10;
            r3 = r0.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2490decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUrlPreviewChattersListRequest) r1);
        }

        public void encode(ProtoWriter r4, PullUrlPreviewChattersListRequest r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mpreview_id);
            String r1 = r5.mcomponent_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.mnext_token;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUrlPreviewChattersListRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUrlPreviewChattersListRequest();
        FIELD_OPTIONS_MPREVIEW_ID = new FieldOptions.Builder().FieldInfo("split,type=url_preview_token").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2488newBuilder() {
        Builder r0 = new Builder();
        r0.mpreview_id = this.mpreview_id;
        r0.mcomponent_id = this.mcomponent_id;
        r0.mnext_token = this.mnext_token;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUrlPreviewChattersListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2488newBuilder();
    }

    public PullUrlPreviewChattersListRequest(String r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullUrlPreviewChattersListRequest(String r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mpreview_id = r2;
        this.mcomponent_id = r3;
        this.mnext_token = r4;
    }
}
