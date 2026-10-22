package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Document extends Message<Document, Builder> {
    public static final ProtoAdapter<Document> ADAPTER = null;
    public static final String DEFAULT_FOLDERID = "";
    public static final String DEFAULT_FOLDERNAME = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TENANTID = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_WIKIID = "";
    public static final String DEFAULT_WIKINAME = "";
    public static final String DEFAULT_WIKITOKEN = "";
    private static final long serialVersionUID = 0;
    public final DocSecLabel mDocSecLabel;
    public final String mFolderID;
    public final String mFolderName;
    public final String mID;
    public final User mOwner;
    public final String mTenantID;
    public final String mTitle;
    public final EntityType mType;
    public final String mWikiID;
    public final String mWikiName;
    public final String mWikiToken;

    public static final class Builder extends Message.Builder<Document, Builder> {
        public DocSecLabel mDocSecLabel;
        public String mFolderID;
        public String mFolderName;
        public String mID;
        public User mOwner;
        public String mTenantID;
        public String mTitle;
        public EntityType mType;
        public String mWikiID;
        public String mWikiName;
        public String mWikiToken;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Document m2162build() {
            return new Document(this.mID, this.mType, this.mTitle, this.mOwner, this.mDocSecLabel, this.mWikiToken, this.mTenantID, this.mFolderID, this.mFolderName, this.mWikiID, this.mWikiName, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2162build();
        }

        public Builder DocSecLabel(DocSecLabel r1) {
            this.mDocSecLabel = r1;
            return this;
        }

        public Builder FolderID(String r1) {
            this.mFolderID = r1;
            return this;
        }

        public Builder FolderName(String r1) {
            this.mFolderName = r1;
            return this;
        }

        public Builder ID(String r1) {
            this.mID = r1;
            return this;
        }

        public Builder Owner(User r1) {
            this.mOwner = r1;
            return this;
        }

        public Builder TenantID(String r1) {
            this.mTenantID = r1;
            return this;
        }

        public Builder Title(String r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder Type(EntityType r1) {
            this.mType = r1;
            return this;
        }

        public Builder WikiID(String r1) {
            this.mWikiID = r1;
            return this;
        }

        public Builder WikiName(String r1) {
            this.mWikiName = r1;
            return this;
        }

        public Builder WikiToken(String r1) {
            this.mWikiToken = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Document extends ProtoAdapter<Document> {
        public ProtoAdapter_Document() {
            super(FieldEncoding.LENGTH_DELIMITED, Document.class);
        }

        public Document decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mID = "";
            r0.mTitle = "";
            r0.mWikiToken = "";
            r0.mTenantID = "";
            r0.mFolderID = "";
            r0.mFolderName = "";
            r0.mWikiID = "";
            r0.mWikiName = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            switch(r3) {
                case 1: goto L20;
                case 2: goto L23;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r0.mType = (EntityType) EntityType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mWikiName = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mWikiID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mFolderName = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mFolderID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.mTenantID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mWikiToken = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mDocSecLabel = (DocSecLabel) DocSecLabel.ADAPTER.decode(r9);
            goto L3
        L14:
            r0.mOwner = (User) User.ADAPTER.decode(r9);
            goto L3
        L15:
            r0.mTitle = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2162build();
        }

        public int encodedSize(Document r6) {
            String r0 = r6.mID;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            EntityType r3 = r6.mType;
            if (r3 == null) goto L9;
            int r4 = EntityType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mTitle;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            User r10 = r6.mOwner;
            if (r10 == null) goto L17;
            int r11 = User.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            DocSecLabel r13 = r6.mDocSecLabel;
            if (r13 == null) goto L21;
            int r14 = DocSecLabel.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mWikiToken;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mTenantID;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mFolderID;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.mFolderName;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mWikiID;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            String r31 = r6.mWikiName;
            if (r31 == null) goto L46;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(11, r31);
        L46:
            return (r30 + r1) + r6.unknownFields().size();
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m2163decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Document) r1);
        }

        public void encode(ProtoWriter r4, Document r5) throws IOException {
            String r0 = r5.mID;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            EntityType r1 = r5.mType;
            if (r1 == null) goto L8;
            EntityType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mTitle;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            User r3 = r5.mOwner;
            if (r3 == null) goto L14;
            User.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            DocSecLabel r6 = r5.mDocSecLabel;
            if (r6 == null) goto L17;
            DocSecLabel.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mWikiToken;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mTenantID;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mFolderID;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            String r10 = r5.mFolderName;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r10);
        L29:
            String r11 = r5.mWikiID;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r11);
        L32:
            String r12 = r5.mWikiName;
            if (r12 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r12);
        L35:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Document) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Document();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2161newBuilder() {
        Builder r0 = new Builder();
        r0.mID = this.mID;
        r0.mType = this.mType;
        r0.mTitle = this.mTitle;
        r0.mOwner = this.mOwner;
        r0.mDocSecLabel = this.mDocSecLabel;
        r0.mWikiToken = this.mWikiToken;
        r0.mTenantID = this.mTenantID;
        r0.mFolderID = this.mFolderID;
        r0.mFolderName = this.mFolderName;
        r0.mWikiID = this.mWikiID;
        r0.mWikiName = this.mWikiName;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Document.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2161newBuilder();
    }

    public Document(String r14, EntityType r15, String r16, User r17, DocSecLabel r18, String r19, String r20, String r21, String r22, String r23, String r24) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
    }

    public Document(String r2, EntityType r3, String r4, User r5, DocSecLabel r6, String r7, String r8, String r9, String r10, String r11, String r12, ByteString r13) {
        super(ADAPTER, r13);
        this.mID = r2;
        this.mType = r3;
        this.mTitle = r4;
        this.mOwner = r5;
        this.mDocSecLabel = r6;
        this.mWikiToken = r7;
        this.mTenantID = r8;
        this.mFolderID = r9;
        this.mFolderName = r10;
        this.mWikiID = r11;
        this.mWikiName = r12;
    }
}
