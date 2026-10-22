package com.ss.android.lark.pb.settings;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserPermissionObject extends Message<UserPermissionObject, Builder> {
    public static final ProtoAdapter<UserPermissionObject> ADAPTER = null;
    public static final String DEFAULT_OBJECT_ID = "";
    public static final String DEFAULT_OBJECT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mobject_i18n_name;
    public final String mobject_id;
    public final String mobject_name;
    public final UserPermissionObjectType mobject_type;

    public static final class Builder extends Message.Builder<UserPermissionObject, Builder> {
        public Map<String, String> mobject_i18n_name;
        public String mobject_id;
        public String mobject_name;
        public UserPermissionObjectType mobject_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserPermissionObject m2222build() {
            return new UserPermissionObject(this.mobject_type, this.mobject_id, this.mobject_name, this.mobject_i18n_name, super.buildUnknownFields());
        }

        public Builder() {
            this.mobject_i18n_name = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2222build();
        }

        public Builder object_i18n_name(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mobject_i18n_name = r1;
            return this;
        }

        public Builder object_id(String r1) {
            this.mobject_id = r1;
            return this;
        }

        public Builder object_name(String r1) {
            this.mobject_name = r1;
            return this;
        }

        public Builder object_type(UserPermissionObjectType r1) {
            this.mobject_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserPermissionObject extends ProtoAdapter<UserPermissionObject> {
        private final ProtoAdapter<Map<String, String>> mobject_i18n_name;

        public ProtoAdapter_UserPermissionObject() {
            super(FieldEncoding.LENGTH_DELIMITED, UserPermissionObject.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mobject_i18n_name = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public UserPermissionObject decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mobject_id = "";
            r0.mobject_name = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mobject_type = (UserPermissionObjectType) UserPermissionObjectType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mobject_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mobject_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mobject_i18n_name.putAll((Map) this.mobject_i18n_name.decode(r9));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2222build();
        }

        public int encodedSize(UserPermissionObject r6) {
            UserPermissionObjectType r0 = r6.mobject_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = UserPermissionObjectType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mobject_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mobject_name;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return ((r5 + r1) + this.mobject_i18n_name.encodedSizeWithTag(4, r6.mobject_i18n_name)) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2223decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserPermissionObject) r1);
        }

        public void encode(ProtoWriter r4, UserPermissionObject r5) throws IOException {
            UserPermissionObjectType r0 = r5.mobject_type;
            if (r0 == null) goto L5;
            UserPermissionObjectType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mobject_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mobject_name;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            this.mobject_i18n_name.encodeWithTag(r4, 4, r5.mobject_i18n_name);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserPermissionObject) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserPermissionObject();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2221newBuilder() {
        Builder r0 = new Builder();
        r0.mobject_type = this.mobject_type;
        r0.mobject_id = this.mobject_id;
        r0.mobject_name = this.mobject_name;
        r0.mobject_i18n_name = Internal.copyOf("mobject_i18n_name", this.mobject_i18n_name);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserPermissionObject.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2221newBuilder();
    }

    public UserPermissionObject(UserPermissionObjectType r7, String r8, String r9, Map<String, String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public UserPermissionObject(UserPermissionObjectType r2, String r3, String r4, Map<String, String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mobject_type = r2;
        this.mobject_id = r3;
        this.mobject_name = r4;
        this.mobject_i18n_name = Internal.immutableCopyOf("mobject_i18n_name", r5);
    }
}
