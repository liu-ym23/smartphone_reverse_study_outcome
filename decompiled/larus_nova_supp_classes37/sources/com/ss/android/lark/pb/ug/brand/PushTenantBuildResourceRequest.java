package com.ss.android.lark.pb.ug.brand;

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
public final class PushTenantBuildResourceRequest extends Message<PushTenantBuildResourceRequest, Builder> {
    public static final ProtoAdapter<PushTenantBuildResourceRequest> ADAPTER = null;
    public static final String DEFAULT_TENANT_ID = "";
    private static final long serialVersionUID = 0;
    public final List<BuildResource> mbuild_resources;
    public final String mtenant_id;

    public static final class Builder extends Message.Builder<PushTenantBuildResourceRequest, Builder> {
        public List<BuildResource> mbuild_resources;
        public String mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PushTenantBuildResourceRequest m2411build() {
            String r0 = this.mtenant_id;
            if (r0 == null) goto L7;
            return new PushTenantBuildResourceRequest(this.mtenant_id, this.mbuild_resources, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtenant_id"});
        }

        public Builder() {
            this.mbuild_resources = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2411build();
        }

        public Builder build_resources(List<BuildResource> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbuild_resources = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTenantBuildResourceRequest extends ProtoAdapter<PushTenantBuildResourceRequest> {
        public ProtoAdapter_PushTenantBuildResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTenantBuildResourceRequest.class);
        }

        public PushTenantBuildResourceRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtenant_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mbuild_resources.add((BuildResource) BuildResource.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2411build();
        }

        public int encodedSize(PushTenantBuildResourceRequest r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mtenant_id) + BuildResource.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mbuild_resources)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2412decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushTenantBuildResourceRequest) r1);
        }

        public void encode(ProtoWriter r4, PushTenantBuildResourceRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mtenant_id);
            BuildResource.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mbuild_resources);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushTenantBuildResourceRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushTenantBuildResourceRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2410newBuilder() {
        Builder r0 = new Builder();
        r0.mtenant_id = this.mtenant_id;
        r0.mbuild_resources = Internal.copyOf("mbuild_resources", this.mbuild_resources);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushTenantBuildResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2410newBuilder();
    }

    public PushTenantBuildResourceRequest(String r2, List<BuildResource> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PushTenantBuildResourceRequest(String r2, List<BuildResource> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtenant_id = r2;
        this.mbuild_resources = Internal.immutableCopyOf("mbuild_resources", r3);
    }
}
