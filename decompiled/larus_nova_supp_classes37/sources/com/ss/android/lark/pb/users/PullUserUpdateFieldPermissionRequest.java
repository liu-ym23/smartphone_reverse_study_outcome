package com.ss.android.lark.pb.users;

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
public final class PullUserUpdateFieldPermissionRequest extends Message<PullUserUpdateFieldPermissionRequest, Builder> {
    public static final ProtoAdapter<PullUserUpdateFieldPermissionRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserUpdatePermission> muser_update_permissions;

    public static final class Builder extends Message.Builder<PullUserUpdateFieldPermissionRequest, Builder> {
        public List<UserUpdatePermission> muser_update_permissions;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserUpdateFieldPermissionRequest m3083build() {
            return new PullUserUpdateFieldPermissionRequest(this.muser_update_permissions, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_update_permissions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3083build();
        }

        public Builder user_update_permissions(List<UserUpdatePermission> r1) {
            Internal.checkElementsNotNull(r1);
            this.muser_update_permissions = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserUpdateFieldPermissionRequest extends ProtoAdapter<PullUserUpdateFieldPermissionRequest> {
        public ProtoAdapter_PullUserUpdateFieldPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserUpdateFieldPermissionRequest.class);
        }

        public PullUserUpdateFieldPermissionRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.muser_update_permissions.add((UserUpdatePermission) UserUpdatePermission.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            return r0.m3083build();
        }

        public int encodedSize(PullUserUpdateFieldPermissionRequest r4) {
            return UserUpdatePermission.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.muser_update_permissions) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3084decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserUpdateFieldPermissionRequest) r1);
        }

        public void encode(ProtoWriter r4, PullUserUpdateFieldPermissionRequest r5) throws IOException {
            UserUpdatePermission.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.muser_update_permissions);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserUpdateFieldPermissionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserUpdateFieldPermissionRequest();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3082newBuilder() {
        Builder r0 = new Builder();
        r0.muser_update_permissions = Internal.copyOf("muser_update_permissions", this.muser_update_permissions);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserUpdateFieldPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3082newBuilder();
    }

    public PullUserUpdateFieldPermissionRequest(List<UserUpdatePermission> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullUserUpdateFieldPermissionRequest(List<UserUpdatePermission> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.muser_update_permissions = Internal.immutableCopyOf("muser_update_permissions", r2);
    }
}
