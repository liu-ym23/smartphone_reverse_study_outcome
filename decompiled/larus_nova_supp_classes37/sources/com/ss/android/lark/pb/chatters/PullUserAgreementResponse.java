package com.ss.android.lark.pb.chatters;

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
public final class PullUserAgreementResponse extends Message<PullUserAgreementResponse, Builder> {
    public static final ProtoAdapter<PullUserAgreementResponse> ADAPTER = null;
    public static final String DEFAULT_AGREEMENT_VERSION = "";
    public static final Boolean DEFAULT_IS_AGREED = null;
    public static final Boolean DEFAULT_IS_NECESSARY = null;
    private static final long serialVersionUID = 0;
    public final String magreement_version;
    public final Boolean mis_agreed;
    public final Boolean mis_necessary;
    public final UserAgreement muser_agreement;

    public static final class Builder extends Message.Builder<PullUserAgreementResponse, Builder> {
        public String magreement_version;
        public Boolean mis_agreed;
        public Boolean mis_necessary;
        public UserAgreement muser_agreement;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullUserAgreementResponse m923build() {
            return new PullUserAgreementResponse(this.mis_necessary, this.mis_agreed, this.muser_agreement, this.magreement_version, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m923build();
        }

        public Builder agreement_version(String r1) {
            this.magreement_version = r1;
            return this;
        }

        public Builder is_agreed(Boolean r1) {
            this.mis_agreed = r1;
            return this;
        }

        public Builder is_necessary(Boolean r1) {
            this.mis_necessary = r1;
            return this;
        }

        public Builder user_agreement(UserAgreement r1) {
            this.muser_agreement = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserAgreementResponse extends ProtoAdapter<PullUserAgreementResponse> {
        public ProtoAdapter_PullUserAgreementResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserAgreementResponse.class);
        }

        public PullUserAgreementResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.mis_necessary = r1;
            r0.mis_agreed = r1;
            r0.magreement_version = "";
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mis_necessary = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mis_agreed = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.muser_agreement = (UserAgreement) UserAgreement.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.magreement_version = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r2);
            return r0.m923build();
        }

        public int encodedSize(PullUserAgreementResponse r6) {
            Boolean r0 = r6.mis_necessary;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mis_agreed;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            UserAgreement r7 = r6.muser_agreement;
            if (r7 == null) goto L13;
            int r8 = UserAgreement.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.magreement_version;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m924decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullUserAgreementResponse) r1);
        }

        public void encode(ProtoWriter r4, PullUserAgreementResponse r5) throws IOException {
            Boolean r0 = r5.mis_necessary;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mis_agreed;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            UserAgreement r2 = r5.muser_agreement;
            if (r2 == null) goto L11;
            UserAgreement.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.magreement_version;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullUserAgreementResponse) r2);
        }
    }

    public static final class UserAgreement extends Message<UserAgreement, Builder> {
        public static final ProtoAdapter<UserAgreement> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final List<UserAgreementContent> mcontent;
        public final String mtitle;

        public static final class Builder extends Message.Builder<UserAgreement, Builder> {
            public List<UserAgreementContent> mcontent;
            public String mtitle;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserAgreement m926build() {
                return new UserAgreement(this.mtitle, this.mcontent, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontent = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m926build();
            }

            public Builder content(List<UserAgreementContent> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcontent = r1;
                return this;
            }

            public Builder title(String r1) {
                this.mtitle = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_UserAgreement extends ProtoAdapter<UserAgreement> {
            public ProtoAdapter_UserAgreement() {
                super(FieldEncoding.LENGTH_DELIMITED, UserAgreement.class);
            }

            public UserAgreement decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtitle = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mtitle = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mcontent.add((UserAgreementContent) UserAgreementContent.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m926build();
            }

            public int encodedSize(UserAgreement r5) {
                String r0 = r5.mtitle;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + UserAgreementContent.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mcontent)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m927decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserAgreement) r1);
            }

            public void encode(ProtoWriter r4, UserAgreement r5) throws IOException {
                String r0 = r5.mtitle;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                UserAgreementContent.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mcontent);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserAgreement) r2);
            }
        }

        public static final class UserAgreementContent extends Message<UserAgreementContent, Builder> {
            public static final ProtoAdapter<UserAgreementContent> ADAPTER = null;
            public static final String DEFAULT_LINK_URL = "";
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final String mlink_url;
            public final String mtext;

            public static final class Builder extends Message.Builder<UserAgreementContent, Builder> {
                public String mlink_url;
                public String mtext;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public UserAgreementContent m929build() {
                    return new UserAgreementContent(this.mtext, this.mlink_url, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m929build();
                }

                public Builder link_url(String r1) {
                    this.mlink_url = r1;
                    return this;
                }

                public Builder text(String r1) {
                    this.mtext = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_UserAgreementContent extends ProtoAdapter<UserAgreementContent> {
                public ProtoAdapter_UserAgreementContent() {
                    super(FieldEncoding.LENGTH_DELIMITED, UserAgreementContent.class);
                }

                public UserAgreementContent decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mtext = "";
                    r0.mlink_url = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.mlink_url = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m929build();
                }

                public int encodedSize(UserAgreementContent r5) {
                    String r0 = r5.mtext;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
                L6:
                    String r3 = r5.mlink_url;
                    if (r3 == null) goto L10;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                L10:
                    return (r2 + r1) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m930decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((UserAgreementContent) r1);
                }

                public void encode(ProtoWriter r4, UserAgreementContent r5) throws IOException {
                    String r0 = r5.mtext;
                    if (r0 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
                L5:
                    String r1 = r5.mlink_url;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                L8:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (UserAgreementContent) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_UserAgreementContent();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m928newBuilder() {
                Builder r0 = new Builder();
                r0.mtext = this.mtext;
                r0.mlink_url = this.mlink_url;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return UserAgreementContent.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m928newBuilder();
            }

            public UserAgreementContent(String r2, String r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public UserAgreementContent(String r2, String r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mtext = r2;
                this.mlink_url = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserAgreement();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m925newBuilder() {
            Builder r0 = new Builder();
            r0.mtitle = this.mtitle;
            r0.mcontent = Internal.copyOf("mcontent", this.mcontent);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserAgreement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m925newBuilder();
        }

        public UserAgreement(String r2, List<UserAgreementContent> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public UserAgreement(String r2, List<UserAgreementContent> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtitle = r2;
            this.mcontent = Internal.immutableCopyOf("mcontent", r3);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserAgreementResponse();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_NECESSARY = r0;
        DEFAULT_IS_AGREED = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m922newBuilder() {
        Builder r0 = new Builder();
        r0.mis_necessary = this.mis_necessary;
        r0.mis_agreed = this.mis_agreed;
        r0.muser_agreement = this.muser_agreement;
        r0.magreement_version = this.magreement_version;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullUserAgreementResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m922newBuilder();
    }

    public PullUserAgreementResponse(Boolean r7, Boolean r8, UserAgreement r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PullUserAgreementResponse(Boolean r2, Boolean r3, UserAgreement r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mis_necessary = r2;
        this.mis_agreed = r3;
        this.muser_agreement = r4;
        this.magreement_version = r5;
    }
}
