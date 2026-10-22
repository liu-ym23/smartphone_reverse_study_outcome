package com.ss.android.lark.pb.authorization;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullPermissionRequest extends Message<PullPermissionRequest, Builder> {
    public static final ProtoAdapter<PullPermissionRequest> ADAPTER = null;
    public static final String DEFAULT_API_VERSION = "";
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_PERM_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String mapi_version;
    public final Long mapp_id;
    public final String mperm_version;

    public static final class Builder extends Message.Builder<PullPermissionRequest, Builder> {
        public String mapi_version;
        public Long mapp_id;
        public String mperm_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullPermissionRequest m851build() {
            Long r0 = this.mapp_id;
            if (r0 == null) goto L11;
            if (this.mapi_version == null) goto L11;
            if (this.mperm_version == null) goto L11;
            return new PullPermissionRequest(this.mapp_id, this.mapi_version, this.mperm_version, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mapp_id", this.mapi_version, "mapi_version", this.mperm_version, "mperm_version"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m851build();
        }

        public Builder api_version(String r1) {
            this.mapi_version = r1;
            return this;
        }

        public Builder app_id(Long r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder perm_version(String r1) {
            this.mperm_version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullPermissionRequest extends ProtoAdapter<PullPermissionRequest> {
        public ProtoAdapter_PullPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullPermissionRequest.class);
        }

        public PullPermissionRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mapp_id = 0L;
            r0.mapi_version = "";
            r0.mperm_version = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mapp_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mapi_version = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mperm_version = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m851build();
        }

        public int encodedSize(PullPermissionRequest r5) {
            int r0 = ProtoAdapter.INT64.encodedSizeWithTag(1, r5.mapp_id);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return ((r0 + r1.encodedSizeWithTag(2, r5.mapi_version)) + r1.encodedSizeWithTag(3, r5.mperm_version)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m852decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullPermissionRequest) r1);
        }

        public void encode(ProtoWriter r4, PullPermissionRequest r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.mapp_id);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.mapi_version);
            r0.encodeWithTag(r4, 3, r5.mperm_version);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullPermissionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullPermissionRequest();
        DEFAULT_APP_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m850newBuilder() {
        Builder r0 = new Builder();
        r0.mapp_id = this.mapp_id;
        r0.mapi_version = this.mapi_version;
        r0.mperm_version = this.mperm_version;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m850newBuilder();
    }

    public PullPermissionRequest(Long r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullPermissionRequest(Long r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mapp_id = r2;
        this.mapi_version = r3;
        this.mperm_version = r4;
    }
}
