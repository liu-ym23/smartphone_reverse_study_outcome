package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserUpdatePermissionInfo extends Message<UserUpdatePermissionInfo, Builder> {
    public static final ProtoAdapter<UserUpdatePermissionInfo> ADAPTER = null;
    public static final Boolean DEFAULT_ENABLE = null;
    private static final long serialVersionUID = 0;
    public final I18nVal mdeny_description;
    public final Boolean menable;
    public final UserUpdatePermission muser_update_permission;

    public static final class Builder extends Message.Builder<UserUpdatePermissionInfo, Builder> {
        public I18nVal mdeny_description;
        public Boolean menable;
        public UserUpdatePermission muser_update_permission;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserUpdatePermissionInfo m3089build() {
            UserUpdatePermission r0 = this.muser_update_permission;
            if (r0 == null) goto L9;
            if (this.menable == null) goto L9;
            return new UserUpdatePermissionInfo(this.muser_update_permission, this.menable, this.mdeny_description, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "muser_update_permission", this.menable, "menable"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3089build();
        }

        public Builder deny_description(I18nVal r1) {
            this.mdeny_description = r1;
            return this;
        }

        public Builder enable(Boolean r1) {
            this.menable = r1;
            return this;
        }

        public Builder user_update_permission(UserUpdatePermission r1) {
            this.muser_update_permission = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserUpdatePermissionInfo extends ProtoAdapter<UserUpdatePermissionInfo> {
        public ProtoAdapter_UserUpdatePermissionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UserUpdatePermissionInfo.class);
        }

        public UserUpdatePermissionInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.menable = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.muser_update_permission = (UserUpdatePermission) UserUpdatePermission.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.menable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mdeny_description = (I18nVal) I18nVal.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m3089build();
        }

        public int encodedSize(UserUpdatePermissionInfo r5) {
            int r0 = UserUpdatePermission.ADAPTER.encodedSizeWithTag(1, r5.muser_update_permission) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r5.menable);
            I18nVal r1 = r5.mdeny_description;
            if (r1 == null) goto L5;
            int r2 = I18nVal.ADAPTER.encodedSizeWithTag(3, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3090decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserUpdatePermissionInfo) r1);
        }

        public void encode(ProtoWriter r4, UserUpdatePermissionInfo r5) throws IOException {
            UserUpdatePermission.ADAPTER.encodeWithTag(r4, 1, r5.muser_update_permission);
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r5.menable);
            I18nVal r0 = r5.mdeny_description;
            if (r0 == null) goto L5;
            I18nVal.ADAPTER.encodeWithTag(r4, 3, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserUpdatePermissionInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserUpdatePermissionInfo();
        DEFAULT_ENABLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3088newBuilder() {
        Builder r0 = new Builder();
        r0.muser_update_permission = this.muser_update_permission;
        r0.menable = this.menable;
        r0.mdeny_description = this.mdeny_description;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserUpdatePermissionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3088newBuilder();
    }

    public UserUpdatePermissionInfo(UserUpdatePermission r2, Boolean r3, I18nVal r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UserUpdatePermissionInfo(UserUpdatePermission r2, Boolean r3, I18nVal r4, ByteString r5) {
        super(ADAPTER, r5);
        this.muser_update_permission = r2;
        this.menable = r3;
        this.mdeny_description = r4;
    }
}
