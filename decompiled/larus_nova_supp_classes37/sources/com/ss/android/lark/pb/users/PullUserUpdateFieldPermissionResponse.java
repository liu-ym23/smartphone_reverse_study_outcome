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
public final class PullUserUpdateFieldPermissionResponse extends Message<PullUserUpdateFieldPermissionResponse, Builder> {
    public static final ProtoAdapter<PullUserUpdateFieldPermissionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UserUpdatePermissionInfo> muser_update_permission_infos;

    public static final class Builder extends Message.Builder<PullUserUpdateFieldPermissionResponse, Builder> {
        public List<UserUpdatePermissionInfo> muser_update_permission_infos;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserUpdateFieldPermissionResponse m3086build() {
            return new PullUserUpdateFieldPermissionResponse(this.muser_update_permission_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.muser_update_permission_infos = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3086build();
        }

        public Builder user_update_permission_infos(List<UserUpdatePermissionInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.muser_update_permission_infos = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserUpdateFieldPermissionResponse extends ProtoAdapter<PullUserUpdateFieldPermissionResponse> {
        public ProtoAdapter_PullUserUpdateFieldPermissionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserUpdateFieldPermissionResponse.class);
        }

        public PullUserUpdateFieldPermissionResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.muser_update_permission_infos.add((UserUpdatePermissionInfo) UserUpdatePermissionInfo.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m3086build();
        }

        public int encodedSize(PullUserUpdateFieldPermissionResponse r4) {
            return UserUpdatePermissionInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.muser_update_permission_infos) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3087decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserUpdateFieldPermissionResponse) r1);
        }

        public void encode(ProtoWriter r4, PullUserUpdateFieldPermissionResponse r5) throws IOException {
            UserUpdatePermissionInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.muser_update_permission_infos);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserUpdateFieldPermissionResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserUpdateFieldPermissionResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3085newBuilder() {
        Builder r0 = new Builder();
        r0.muser_update_permission_infos = Internal.copyOf("muser_update_permission_infos", this.muser_update_permission_infos);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserUpdateFieldPermissionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3085newBuilder();
    }

    public PullUserUpdateFieldPermissionResponse(List<UserUpdatePermissionInfo> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullUserUpdateFieldPermissionResponse(List<UserUpdatePermissionInfo> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.muser_update_permission_infos = Internal.immutableCopyOf("muser_update_permission_infos", r2);
    }
}
