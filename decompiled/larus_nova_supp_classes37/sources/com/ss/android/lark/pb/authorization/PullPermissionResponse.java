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
public final class PullPermissionResponse extends Message<PullPermissionResponse, Builder> {
    public static final ProtoAdapter<PullPermissionResponse> ADAPTER = null;
    public static final Boolean DEFAULT_CLEAR_OLD = null;
    public static final String DEFAULT_PERM_VERSION = "";
    private static final long serialVersionUID = 0;
    public final Boolean mclear_old;
    public final String mperm_version;
    public final AllPermissionData mpermission_data;
    public final PermissionExtra mpermission_extra;

    public static final class Builder extends Message.Builder<PullPermissionResponse, Builder> {
        public Boolean mclear_old;
        public String mperm_version;
        public AllPermissionData mpermission_data;
        public PermissionExtra mpermission_extra;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullPermissionResponse m854build() {
            AllPermissionData r0 = this.mpermission_data;
            if (r0 == null) goto L11;
            if (this.mclear_old == null) goto L11;
            if (this.mperm_version == null) goto L11;
            return new PullPermissionResponse(this.mpermission_data, this.mclear_old, this.mperm_version, this.mpermission_extra, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mpermission_data", this.mclear_old, "mclear_old", this.mperm_version, "mperm_version"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m854build();
        }

        public Builder clear_old(Boolean r1) {
            this.mclear_old = r1;
            return this;
        }

        public Builder perm_version(String r1) {
            this.mperm_version = r1;
            return this;
        }

        public Builder permission_data(AllPermissionData r1) {
            this.mpermission_data = r1;
            return this;
        }

        public Builder permission_extra(PermissionExtra r1) {
            this.mpermission_extra = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullPermissionResponse extends ProtoAdapter<PullPermissionResponse> {
        public ProtoAdapter_PullPermissionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullPermissionResponse.class);
        }

        public PullPermissionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mclear_old = Boolean.FALSE;
            r0.mperm_version = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mpermission_data = (AllPermissionData) AllPermissionData.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mclear_old = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mperm_version = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mpermission_extra = (PermissionExtra) PermissionExtra.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m854build();
        }

        public int encodedSize(PullPermissionResponse r5) {
            int r0 = (AllPermissionData.ADAPTER.encodedSizeWithTag(1, r5.mpermission_data) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.mclear_old)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.mperm_version);
            PermissionExtra r1 = r5.mpermission_extra;
            if (r1 == null) goto L5;
            int r2 = PermissionExtra.ADAPTER.encodedSizeWithTag(4, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m855decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullPermissionResponse) r1);
        }

        public void encode(ProtoWriter r4, PullPermissionResponse r5) throws IOException {
            AllPermissionData.ADAPTER.encodeWithTag(r4, 1, r5.mpermission_data);
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r5.mclear_old);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.mperm_version);
            PermissionExtra r0 = r5.mpermission_extra;
            if (r0 == null) goto L5;
            PermissionExtra.ADAPTER.encodeWithTag(r4, 4, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullPermissionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullPermissionResponse();
        DEFAULT_CLEAR_OLD = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m853newBuilder() {
        Builder r0 = new Builder();
        r0.mpermission_data = this.mpermission_data;
        r0.mclear_old = this.mclear_old;
        r0.mperm_version = this.mperm_version;
        r0.mpermission_extra = this.mpermission_extra;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullPermissionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m853newBuilder();
    }

    public PullPermissionResponse(AllPermissionData r7, Boolean r8, String r9, PermissionExtra r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullPermissionResponse(AllPermissionData r2, Boolean r3, String r4, PermissionExtra r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mpermission_data = r2;
        this.mclear_old = r3;
        this.mperm_version = r4;
        this.mpermission_extra = r5;
    }
}
