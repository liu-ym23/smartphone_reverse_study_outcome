package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WikiTenantInfo extends Message<WikiTenantInfo, Builder> {
    public static final ProtoAdapter<WikiTenantInfo> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mavatar_key;
    public final Long mtenant_id;
    public final I18NNameText mtenant_name;

    public static final class Builder extends Message.Builder<WikiTenantInfo, Builder> {
        public String mavatar_key;
        public Long mtenant_id;
        public I18NNameText mtenant_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WikiTenantInfo m2984build() {
            return new WikiTenantInfo(this.mtenant_id, this.mtenant_name, this.mavatar_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2984build();
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder tenant_id(Long r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder tenant_name(I18NNameText r1) {
            this.mtenant_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiTenantInfo extends ProtoAdapter<WikiTenantInfo> {
        public ProtoAdapter_WikiTenantInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiTenantInfo.class);
        }

        public WikiTenantInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtenant_id = 0L;
            r0.mavatar_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtenant_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtenant_name = (I18NNameText) I18NNameText.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2984build();
        }

        public int encodedSize(WikiTenantInfo r6) {
            Long r0 = r6.mtenant_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            I18NNameText r3 = r6.mtenant_name;
            if (r3 == null) goto L9;
            int r4 = I18NNameText.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mavatar_key;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2985decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WikiTenantInfo) r1);
        }

        public void encode(ProtoWriter r4, WikiTenantInfo r5) throws IOException {
            Long r0 = r5.mtenant_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            I18NNameText r1 = r5.mtenant_name;
            if (r1 == null) goto L8;
            I18NNameText.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mavatar_key;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WikiTenantInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiTenantInfo();
        DEFAULT_TENANT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2983newBuilder() {
        Builder r0 = new Builder();
        r0.mtenant_id = this.mtenant_id;
        r0.mtenant_name = this.mtenant_name;
        r0.mavatar_key = this.mavatar_key;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return WikiTenantInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2983newBuilder();
    }

    public WikiTenantInfo(Long r2, I18NNameText r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public WikiTenantInfo(Long r2, I18NNameText r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtenant_id = r2;
        this.mtenant_name = r3;
        this.mavatar_key = r4;
    }
}
