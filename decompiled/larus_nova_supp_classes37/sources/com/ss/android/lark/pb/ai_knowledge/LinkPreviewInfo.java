package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LinkPreviewInfo extends Message<LinkPreviewInfo, Builder> {
    public static final ProtoAdapter<LinkPreviewInfo> ADAPTER = null;
    public static final String DEFAULT_ICON_IMG_KEY = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final String micon_img_key;
    public final String micon_url;
    public final String mlink;
    public final String mtitle;

    public static final class Builder extends Message.Builder<LinkPreviewInfo, Builder> {
        public String micon_img_key;
        public String micon_url;
        public String mlink;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public LinkPreviewInfo m800build() {
            return new LinkPreviewInfo(this.mlink, this.mtitle, this.micon_img_key, this.micon_url, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m800build();
        }

        public Builder icon_img_key(String r1) {
            this.micon_img_key = r1;
            return this;
        }

        public Builder icon_url(String r1) {
            this.micon_url = r1;
            return this;
        }

        public Builder link(String r1) {
            this.mlink = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkPreviewInfo extends ProtoAdapter<LinkPreviewInfo> {
        public ProtoAdapter_LinkPreviewInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkPreviewInfo.class);
        }

        public LinkPreviewInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mlink = "";
            r0.mtitle = "";
            r0.micon_img_key = "";
            r0.micon_url = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mlink = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.micon_img_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.micon_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m800build();
        }

        public int encodedSize(LinkPreviewInfo r6) {
            String r0 = r6.mlink;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtitle;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.micon_img_key;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.micon_url;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m801decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LinkPreviewInfo) r1);
        }

        public void encode(ProtoWriter r4, LinkPreviewInfo r5) throws IOException {
            String r0 = r5.mlink;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtitle;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.micon_img_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.micon_url;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LinkPreviewInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkPreviewInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m799newBuilder() {
        Builder r0 = new Builder();
        r0.mlink = this.mlink;
        r0.mtitle = this.mtitle;
        r0.micon_img_key = this.micon_img_key;
        r0.micon_url = this.micon_url;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return LinkPreviewInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m799newBuilder();
    }

    public LinkPreviewInfo(String r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public LinkPreviewInfo(String r2, String r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mlink = r2;
        this.mtitle = r3;
        this.micon_img_key = r4;
        this.micon_url = r5;
    }
}
