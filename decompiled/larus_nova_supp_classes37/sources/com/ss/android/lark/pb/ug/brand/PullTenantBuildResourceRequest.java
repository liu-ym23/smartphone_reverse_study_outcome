package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullTenantBuildResourceRequest extends Message<PullTenantBuildResourceRequest, Builder> {
    public static final ProtoAdapter<PullTenantBuildResourceRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Platform mplatform;

    public static final class Builder extends Message.Builder<PullTenantBuildResourceRequest, Builder> {
        public Platform mplatform;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullTenantBuildResourceRequest m2405build() {
            Platform r0 = this.mplatform;
            if (r0 == null) goto L7;
            return new PullTenantBuildResourceRequest(this.mplatform, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mplatform"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2405build();
        }

        public Builder platform(Platform r1) {
            this.mplatform = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullTenantBuildResourceRequest extends ProtoAdapter<PullTenantBuildResourceRequest> {
        public ProtoAdapter_PullTenantBuildResourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullTenantBuildResourceRequest.class);
        }

        public PullTenantBuildResourceRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mplatform = (Platform) Platform.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L12:
            r9.endMessage(r1);
            return r0.m2405build();
        }

        public int encodedSize(PullTenantBuildResourceRequest r4) {
            return Platform.ADAPTER.encodedSizeWithTag(1, r4.mplatform) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2406decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullTenantBuildResourceRequest) r1);
        }

        public void encode(ProtoWriter r4, PullTenantBuildResourceRequest r5) throws IOException {
            Platform.ADAPTER.encodeWithTag(r4, 1, r5.mplatform);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullTenantBuildResourceRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullTenantBuildResourceRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2404newBuilder() {
        Builder r0 = new Builder();
        r0.mplatform = this.mplatform;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullTenantBuildResourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2404newBuilder();
    }

    public PullTenantBuildResourceRequest(Platform r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullTenantBuildResourceRequest(Platform r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mplatform = r2;
    }
}
