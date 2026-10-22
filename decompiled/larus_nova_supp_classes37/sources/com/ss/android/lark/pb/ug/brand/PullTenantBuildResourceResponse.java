package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullTenantBuildResourceResponse extends Message<PullTenantBuildResourceResponse, Builder> {
    public static final ProtoAdapter<PullTenantBuildResourceResponse> ADAPTER = null;
    public static final String DEFAULT_RESOURCE_URL = "";
    public static final String DEFAULT_TASK_ID = "";
    private static final long serialVersionUID = 0;
    public final String mresource_url;
    public final String mtask_id;

    public static final class Builder extends Message.Builder<PullTenantBuildResourceResponse, Builder> {
        public String mresource_url;
        public String mtask_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullTenantBuildResourceResponse m2408build() {
            return new PullTenantBuildResourceResponse(this.mresource_url, this.mtask_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2408build();
        }

        public Builder resource_url(String r1) {
            this.mresource_url = r1;
            return this;
        }

        public Builder task_id(String r1) {
            this.mtask_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullTenantBuildResourceResponse extends ProtoAdapter<PullTenantBuildResourceResponse> {
        public ProtoAdapter_PullTenantBuildResourceResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullTenantBuildResourceResponse.class);
        }

        public PullTenantBuildResourceResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mresource_url = "";
            r0.mtask_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mresource_url = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtask_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2408build();
        }

        public int encodedSize(PullTenantBuildResourceResponse r5) {
            String r0 = r5.mresource_url;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mtask_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2409decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullTenantBuildResourceResponse) r1);
        }

        public void encode(ProtoWriter r4, PullTenantBuildResourceResponse r5) throws IOException {
            String r0 = r5.mresource_url;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtask_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullTenantBuildResourceResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullTenantBuildResourceResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2407newBuilder() {
        Builder r0 = new Builder();
        r0.mresource_url = this.mresource_url;
        r0.mtask_id = this.mtask_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullTenantBuildResourceResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2407newBuilder();
    }

    public PullTenantBuildResourceResponse(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PullTenantBuildResourceResponse(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mresource_url = r2;
        this.mtask_id = r3;
    }
}
