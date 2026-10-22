package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class User extends Message<User, Builder> {
    public static final ProtoAdapter<User> ADAPTER = null;
    public static final String DEFAULT_USERID = "";
    private static final long serialVersionUID = 0;
    public final String mUserID;
    public final I18nText mUserName;
    public final UserType mUserType;

    public static final class Builder extends Message.Builder<User, Builder> {
        public String mUserID;
        public I18nText mUserName;
        public UserType mUserType;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public User m2201build() {
            return new User(this.mUserID, this.mUserType, this.mUserName, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2201build();
        }

        public Builder UserID(String r1) {
            this.mUserID = r1;
            return this;
        }

        public Builder UserName(I18nText r1) {
            this.mUserName = r1;
            return this;
        }

        public Builder UserType(UserType r1) {
            this.mUserType = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_User extends ProtoAdapter<User> {
        public ProtoAdapter_User() {
            super(FieldEncoding.LENGTH_DELIMITED, User.class);
        }

        public User decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mUserID = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mUserID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mUserType = (UserType) UserType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mUserName = (I18nText) I18nText.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2201build();
        }

        public int encodedSize(User r6) {
            String r0 = r6.mUserID;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            UserType r3 = r6.mUserType;
            if (r3 == null) goto L9;
            int r4 = UserType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            I18nText r7 = r6.mUserName;
            if (r7 == null) goto L14;
            r1 = I18nText.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2202decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((User) r1);
        }

        public void encode(ProtoWriter r4, User r5) throws IOException {
            String r0 = r5.mUserID;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            UserType r1 = r5.mUserType;
            if (r1 == null) goto L8;
            UserType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            I18nText r2 = r5.mUserName;
            if (r2 == null) goto L11;
            I18nText.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (User) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_User();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2200newBuilder() {
        Builder r0 = new Builder();
        r0.mUserID = this.mUserID;
        r0.mUserType = this.mUserType;
        r0.mUserName = this.mUserName;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return User.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2200newBuilder();
    }

    public User(String r2, UserType r3, I18nText r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public User(String r2, UserType r3, I18nText r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mUserID = r2;
        this.mUserType = r3;
        this.mUserName = r4;
    }
}
