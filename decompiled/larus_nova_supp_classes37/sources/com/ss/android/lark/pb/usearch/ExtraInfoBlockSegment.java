package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtraInfoBlockSegment extends Message<ExtraInfoBlockSegment, Builder> {
    public static final ProtoAdapter<ExtraInfoBlockSegment> ADAPTER = null;
    public static final Boolean DEFAULT_IS_OMISSIBLE = null;
    public static final String DEFAULT_TEXT_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final Boolean mis_omissible;
    public final String mtext_highlighted;
    public final SegmentTextType mtype;
    public final UserProfile muser_profile;

    public static final class Builder extends Message.Builder<ExtraInfoBlockSegment, Builder> {
        public Boolean mis_omissible;
        public String mtext_highlighted;
        public SegmentTextType mtype;
        public UserProfile muser_profile;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtraInfoBlockSegment m2648build() {
            return new ExtraInfoBlockSegment(this.mtext_highlighted, this.mis_omissible, this.mtype, this.muser_profile, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2648build();
        }

        public Builder is_omissible(Boolean r1) {
            this.mis_omissible = r1;
            return this;
        }

        public Builder text_highlighted(String r1) {
            this.mtext_highlighted = r1;
            return this;
        }

        public Builder type(SegmentTextType r1) {
            this.mtype = r1;
            return this;
        }

        public Builder user_profile(UserProfile r1) {
            this.muser_profile = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtraInfoBlockSegment extends ProtoAdapter<ExtraInfoBlockSegment> {
        public ProtoAdapter_ExtraInfoBlockSegment() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtraInfoBlockSegment.class);
        }

        public ExtraInfoBlockSegment decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtext_highlighted = "";
            r0.mis_omissible = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mtext_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mis_omissible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtype = (SegmentTextType) SegmentTextType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.muser_profile = (UserProfile) UserProfile.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2648build();
        }

        public int encodedSize(ExtraInfoBlockSegment r6) {
            String r0 = r6.mtext_highlighted;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mis_omissible;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SegmentTextType r7 = r6.mtype;
            if (r7 == null) goto L13;
            int r8 = SegmentTextType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            UserProfile r10 = r6.muser_profile;
            if (r10 == null) goto L18;
            r1 = UserProfile.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2649decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtraInfoBlockSegment) r1);
        }

        public void encode(ProtoWriter r4, ExtraInfoBlockSegment r5) throws IOException {
            String r0 = r5.mtext_highlighted;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_omissible;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            SegmentTextType r2 = r5.mtype;
            if (r2 == null) goto L11;
            SegmentTextType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            UserProfile r3 = r5.muser_profile;
            if (r3 == null) goto L14;
            UserProfile.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtraInfoBlockSegment) r2);
        }
    }

    public static final enum SegmentTextType extends Enum<SegmentTextType> implements WireEnum {
        private static final /* synthetic */ SegmentTextType[] $VALUES = null;
        public static final ProtoAdapter<SegmentTextType> ADAPTER = null;
        public static final SegmentTextType TEXT = null;
        public static final SegmentTextType TIMESTAMP = null;
        public static final SegmentTextType UNKNOWN = null;
        public static final SegmentTextType USERPROFILE = null;
        private final int value;

        static {
            SegmentTextType r0 = new SegmentTextType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            SegmentTextType r1 = new SegmentTextType("TEXT", 1, 1);
            TEXT = r1;
            SegmentTextType r3 = new SegmentTextType("TIMESTAMP", 2, 2);
            TIMESTAMP = r3;
            SegmentTextType r5 = new SegmentTextType("USERPROFILE", 3, 3);
            USERPROFILE = r5;
            $VALUES = new SegmentTextType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(SegmentTextType.class);
        }

        public static SegmentTextType[] values() {
            return (SegmentTextType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SegmentTextType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return USERPROFILE;
        L14:
            return TIMESTAMP;
        L16:
            return TEXT;
        L18:
            return UNKNOWN;
        }

        public static SegmentTextType valueOf(String r1) {
            return (SegmentTextType) a.a(SegmentTextType.class, r1);
        }

        private SegmentTextType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class UserProfile extends Message<UserProfile, Builder> {
        public static final ProtoAdapter<UserProfile> ADAPTER = null;
        public static final String DEFAULT_AVATAR_KEY = "";
        public static final String DEFAULT_USER_ID = "";
        public static final String DEFAULT_USER_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mavatar_key;
        public final String muser_id;
        public final String muser_name;

        public static final class Builder extends Message.Builder<UserProfile, Builder> {
            public String mavatar_key;
            public String muser_id;
            public String muser_name;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserProfile m2651build() {
                return new UserProfile(this.muser_id, this.muser_name, this.mavatar_key, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2651build();
            }

            public Builder avatar_key(String r1) {
                this.mavatar_key = r1;
                return this;
            }

            public Builder user_id(String r1) {
                this.muser_id = r1;
                return this;
            }

            public Builder user_name(String r1) {
                this.muser_name = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UserProfile extends ProtoAdapter<UserProfile> {
            public ProtoAdapter_UserProfile() {
                super(FieldEncoding.LENGTH_DELIMITED, UserProfile.class);
            }

            public UserProfile decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_id = "";
                r0.muser_name = "";
                r0.mavatar_key = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.muser_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.muser_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2651build();
            }

            public int encodedSize(UserProfile r6) {
                String r0 = r6.muser_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.muser_name;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mavatar_key;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m2652decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserProfile) r1);
            }

            public void encode(ProtoWriter r4, UserProfile r5) throws IOException {
                String r0 = r5.muser_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.muser_name;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mavatar_key;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserProfile) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserProfile();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2650newBuilder() {
            Builder r0 = new Builder();
            r0.muser_id = this.muser_id;
            r0.muser_name = this.muser_name;
            r0.mavatar_key = this.mavatar_key;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserProfile.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2650newBuilder();
        }

        public UserProfile(String r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public UserProfile(String r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.muser_id = r2;
            this.muser_name = r3;
            this.mavatar_key = r4;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtraInfoBlockSegment();
        DEFAULT_IS_OMISSIBLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2647newBuilder() {
        Builder r0 = new Builder();
        r0.mtext_highlighted = this.mtext_highlighted;
        r0.mis_omissible = this.mis_omissible;
        r0.mtype = this.mtype;
        r0.muser_profile = this.muser_profile;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtraInfoBlockSegment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2647newBuilder();
    }

    public ExtraInfoBlockSegment(String r7, Boolean r8, SegmentTextType r9, UserProfile r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ExtraInfoBlockSegment(String r2, Boolean r3, SegmentTextType r4, UserProfile r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mtext_highlighted = r2;
        this.mis_omissible = r3;
        this.mtype = r4;
        this.muser_profile = r5;
    }
}
