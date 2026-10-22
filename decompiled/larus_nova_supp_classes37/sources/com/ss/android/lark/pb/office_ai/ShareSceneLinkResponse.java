package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ShareSceneLinkResponse extends Message<ShareSceneLinkResponse, Builder> {
    public static final ProtoAdapter<ShareSceneLinkResponse> ADAPTER = null;
    public static final String DEFAULT_LINK = "";
    private static final long serialVersionUID = 0;
    public final String mlink;

    public static final class Builder extends Message.Builder<ShareSceneLinkResponse, Builder> {
        public String mlink;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ShareSceneLinkResponse m2024build() {
            return new ShareSceneLinkResponse(this.mlink, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2024build();
        }

        public Builder link(String r1) {
            this.mlink = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareSceneLinkResponse extends ProtoAdapter<ShareSceneLinkResponse> {
        public ProtoAdapter_ShareSceneLinkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareSceneLinkResponse.class);
        }

        public ShareSceneLinkResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mlink = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mlink = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2024build();
        }

        public int encodedSize(ShareSceneLinkResponse r4) {
            String r0 = r4.mlink;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2025decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ShareSceneLinkResponse) r1);
        }

        public void encode(ProtoWriter r4, ShareSceneLinkResponse r5) throws IOException {
            String r0 = r5.mlink;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ShareSceneLinkResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShareSceneLinkResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2023newBuilder() {
        Builder r0 = new Builder();
        r0.mlink = this.mlink;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ShareSceneLinkResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2023newBuilder();
    }

    public ShareSceneLinkResponse(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public ShareSceneLinkResponse(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mlink = r2;
    }
}
