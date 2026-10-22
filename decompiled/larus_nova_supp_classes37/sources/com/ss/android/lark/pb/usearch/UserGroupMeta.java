package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.UserGroupType;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserGroupMeta extends Message<UserGroupMeta, Builder> {
    public static final ProtoAdapter<UserGroupMeta> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final String mid;
    public final String mname;
    public final Integer mtype;
    public final UserGroupType muserGroupType;

    public static final class Builder extends Message.Builder<UserGroupMeta, Builder> {
        public String mdescription;
        public String mid;
        public String mname;
        public Integer mtype;
        public UserGroupType muserGroupType;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UserGroupMeta m2966build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new UserGroupMeta(this.mid, this.mtype, this.mname, this.mdescription, this.muserGroupType, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2966build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder type(Integer r1) {
            this.mtype = r1;
            return this;
        }

        public Builder userGroupType(UserGroupType r1) {
            this.muserGroupType = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGroupMeta extends ProtoAdapter<UserGroupMeta> {
        public ProtoAdapter_UserGroupMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGroupMeta.class);
        }

        public UserGroupMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtype = 0;
            r0.mname = "";
            r0.mdescription = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.muserGroupType = (UserGroupType) UserGroupType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m2966build();
        }

        public int encodedSize(UserGroupMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            Integer r2 = r7.mtype;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = ProtoAdapter.INT32.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mname;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.mdescription;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            UserGroupType r13 = r7.muserGroupType;
            if (r13 == null) goto L18;
            r3 = UserGroupType.ADAPTER.encodedSizeWithTag(5, r13);
        L18:
            return (r12 + r3) + r7.unknownFields().size();
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2967decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UserGroupMeta) r1);
        }

        public void encode(ProtoWriter r5, UserGroupMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            Integer r1 = r6.mtype;
            if (r1 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mname;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.mdescription;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            UserGroupType r4 = r6.muserGroupType;
            if (r4 == null) goto L14;
            UserGroupType.ADAPTER.encodeWithTag(r5, 5, r4);
        L14:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UserGroupMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGroupMeta();
        DEFAULT_TYPE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2965newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mname = this.mname;
        r0.mdescription = this.mdescription;
        r0.muserGroupType = this.muserGroupType;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UserGroupMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2965newBuilder();
    }

    public UserGroupMeta(String r8, Integer r9, String r10, String r11, UserGroupType r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public UserGroupMeta(String r2, Integer r3, String r4, String r5, UserGroupType r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mid = r2;
        this.mtype = r3;
        this.mname = r4;
        this.mdescription = r5;
        this.muserGroupType = r6;
    }
}
