package com.ss.android.lark.pb.settings;

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
public final class UserPermissionGroup extends Message<UserPermissionGroup, Builder> {
    public static final ProtoAdapter<UserPermissionGroup> ADAPTER = null;
    public static final Long DEFAULT_GROUP_ID = null;
    public static final String DEFAULT_GROUP_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long mgroup_id;
    public final String mgroup_name;
    public final List<UserPermissionObject> mobjects;

    public static final class Builder extends Message.Builder<UserPermissionGroup, Builder> {
        public Long mgroup_id;
        public String mgroup_name;
        public List<UserPermissionObject> mobjects;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserPermissionGroup m2219build() {
            return new UserPermissionGroup(this.mgroup_id, this.mgroup_name, this.mobjects, super.buildUnknownFields());
        }

        public Builder() {
            this.mobjects = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2219build();
        }

        public Builder group_id(Long r1) {
            this.mgroup_id = r1;
            return this;
        }

        public Builder group_name(String r1) {
            this.mgroup_name = r1;
            return this;
        }

        public Builder objects(List<UserPermissionObject> r1) {
            Internal.checkElementsNotNull(r1);
            this.mobjects = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserPermissionGroup extends ProtoAdapter<UserPermissionGroup> {
        public ProtoAdapter_UserPermissionGroup() {
            super(FieldEncoding.LENGTH_DELIMITED, UserPermissionGroup.class);
        }

        public UserPermissionGroup decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mgroup_id = 0L;
            r0.mgroup_name = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mgroup_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mgroup_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mobjects.add((UserPermissionObject) UserPermissionObject.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m2219build();
        }

        public int encodedSize(UserPermissionGroup r5) {
            Long r0 = r5.mgroup_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mgroup_name;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + UserPermissionObject.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mobjects)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2220decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserPermissionGroup) r1);
        }

        public void encode(ProtoWriter r4, UserPermissionGroup r5) throws IOException {
            Long r0 = r5.mgroup_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mgroup_name;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            UserPermissionObject.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mobjects);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserPermissionGroup) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserPermissionGroup();
        DEFAULT_GROUP_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2218newBuilder() {
        Builder r0 = new Builder();
        r0.mgroup_id = this.mgroup_id;
        r0.mgroup_name = this.mgroup_name;
        r0.mobjects = Internal.copyOf("mobjects", this.mobjects);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserPermissionGroup.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2218newBuilder();
    }

    public UserPermissionGroup(Long r2, String r3, List<UserPermissionObject> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UserPermissionGroup(Long r2, String r3, List<UserPermissionObject> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mgroup_id = r2;
        this.mgroup_name = r3;
        this.mobjects = Internal.immutableCopyOf("mobjects", r4);
    }
}
