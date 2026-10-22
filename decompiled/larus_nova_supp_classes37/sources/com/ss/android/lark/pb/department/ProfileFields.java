package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.users.Profile;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ProfileFields extends Message<ProfileFields, Builder> {
    public static final ProtoAdapter<ProfileFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Profile.Field> mprofile_fields;

    public static final class Builder extends Message.Builder<ProfileFields, Builder> {
        public List<Profile.Field> mprofile_fields;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ProfileFields m974build() {
            return new ProfileFields(this.mprofile_fields, super.buildUnknownFields());
        }

        public Builder() {
            this.mprofile_fields = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m974build();
        }

        public Builder profile_fields(List<Profile.Field> r1) {
            Internal.checkElementsNotNull(r1);
            this.mprofile_fields = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ProfileFields extends ProtoAdapter<ProfileFields> {
        public ProtoAdapter_ProfileFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ProfileFields.class);
        }

        public ProfileFields decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mprofile_fields.add((Profile.Field) Profile.Field.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m974build();
        }

        public int encodedSize(ProfileFields r4) {
            return Profile.Field.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mprofile_fields) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m975decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ProfileFields) r1);
        }

        public void encode(ProtoWriter r4, ProfileFields r5) throws IOException {
            Profile.Field.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mprofile_fields);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ProfileFields) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ProfileFields();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m973newBuilder() {
        Builder r0 = new Builder();
        r0.mprofile_fields = Internal.copyOf("mprofile_fields", this.mprofile_fields);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ProfileFields.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m973newBuilder();
    }

    public ProfileFields(List<Profile.Field> r2) {
        this(r2, ByteString.EMPTY);
    }

    public ProfileFields(List<Profile.Field> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mprofile_fields = Internal.immutableCopyOf("mprofile_fields", r2);
    }
}
