package com.ss.android.lark.pb.role;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GetAdminPermissionInfoResponse extends Message<GetAdminPermissionInfoResponse, Builder> {
    public static final ProtoAdapter<GetAdminPermissionInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_ISADMINISTRATOR = null;
    public static final Boolean DEFAULT_ISDEPARTMENTADMINISTRATOR = null;
    public static final Boolean DEFAULT_ISSUPERADMINISTRATOR = null;
    private static final long serialVersionUID = 0;
    public final Boolean misAdministrator;
    public final Boolean misDepartmentAdministrator;
    public final Boolean misSuperAdministrator;

    public static final class Builder extends Message.Builder<GetAdminPermissionInfoResponse, Builder> {
        public Boolean misAdministrator;
        public Boolean misDepartmentAdministrator;
        public Boolean misSuperAdministrator;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GetAdminPermissionInfoResponse m2120build() {
            Boolean r0 = this.misSuperAdministrator;
            if (r0 == null) goto L7;
            return new GetAdminPermissionInfoResponse(this.misSuperAdministrator, this.misDepartmentAdministrator, this.misAdministrator, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "misSuperAdministrator"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2120build();
        }

        public Builder isAdministrator(Boolean r1) {
            this.misAdministrator = r1;
            return this;
        }

        public Builder isDepartmentAdministrator(Boolean r1) {
            this.misDepartmentAdministrator = r1;
            return this;
        }

        public Builder isSuperAdministrator(Boolean r1) {
            this.misSuperAdministrator = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAdminPermissionInfoResponse extends ProtoAdapter<GetAdminPermissionInfoResponse> {
        public ProtoAdapter_GetAdminPermissionInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAdminPermissionInfoResponse.class);
        }

        public GetAdminPermissionInfoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.misSuperAdministrator = r1;
            r0.misDepartmentAdministrator = r1;
            r0.misAdministrator = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.misSuperAdministrator = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.misDepartmentAdministrator = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.misAdministrator = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.m2120build();
        }

        public int encodedSize(GetAdminPermissionInfoResponse r6) {
            ProtoAdapter r0 = ProtoAdapter.BOOL;
            int r1 = r0.encodedSizeWithTag(1, r6.misSuperAdministrator);
            Boolean r2 = r6.misDepartmentAdministrator;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Boolean r7 = r6.misAdministrator;
            if (r7 == null) goto L10;
            r3 = r0.encodedSizeWithTag(3, r7);
        L10:
            return (r5 + r3) + r6.unknownFields().size();
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2121decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetAdminPermissionInfoResponse) r1);
        }

        public void encode(ProtoWriter r4, GetAdminPermissionInfoResponse r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.BOOL;
            r0.encodeWithTag(r4, 1, r5.misSuperAdministrator);
            Boolean r1 = r5.misDepartmentAdministrator;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            Boolean r2 = r5.misAdministrator;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetAdminPermissionInfoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetAdminPermissionInfoResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_ISSUPERADMINISTRATOR = r0;
        DEFAULT_ISDEPARTMENTADMINISTRATOR = r0;
        DEFAULT_ISADMINISTRATOR = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2119newBuilder() {
        Builder r0 = new Builder();
        r0.misSuperAdministrator = this.misSuperAdministrator;
        r0.misDepartmentAdministrator = this.misDepartmentAdministrator;
        r0.misAdministrator = this.misAdministrator;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetAdminPermissionInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2119newBuilder();
    }

    public GetAdminPermissionInfoResponse(Boolean r2, Boolean r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetAdminPermissionInfoResponse(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.misSuperAdministrator = r2;
        this.misDepartmentAdministrator = r3;
        this.misAdministrator = r4;
    }
}
