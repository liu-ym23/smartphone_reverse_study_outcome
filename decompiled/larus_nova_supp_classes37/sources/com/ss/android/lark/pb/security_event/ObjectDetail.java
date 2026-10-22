package com.ss.android.lark.pb.security_event;

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
public final class ObjectDetail extends Message<ObjectDetail, Builder> {
    public static final ProtoAdapter<ObjectDetail> ADAPTER = null;
    public static final String DEFAULT_CLONESOURCE = "";
    public static final String DEFAULT_CONTAINERID = "";
    public static final String DEFAULT_CURRENTPAGE = "";
    public static final String DEFAULT_FILENAME = "";
    public static final String DEFAULT_POSTID = "";
    public static final String DEFAULT_TEXTDETAIL = "";
    public static final String DEFAULT_THIRDPARTYAPPID = "";
    private static final long serialVersionUID = 0;
    public final String mCloneSource;
    public final String mContainerID;
    public final ContainerType mContainerType;
    public final String mCurrentPage;
    public final Document mDocument;
    public final String mFileName;
    public final List<String> mForwardIDs;
    public final List<String> mImageKeys;
    public final PermissionSettingType mPermissionSettingType;
    public final String mPostID;
    public final String mTextDetail;
    public final String mThirdPartyAppID;
    public final List<String> mVideoKeys;

    public static final class Builder extends Message.Builder<ObjectDetail, Builder> {
        public String mCloneSource;
        public String mContainerID;
        public ContainerType mContainerType;
        public String mCurrentPage;
        public Document mDocument;
        public String mFileName;
        public List<String> mForwardIDs;
        public List<String> mImageKeys;
        public PermissionSettingType mPermissionSettingType;
        public String mPostID;
        public String mTextDetail;
        public String mThirdPartyAppID;
        public List<String> mVideoKeys;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ObjectDetail m2180build() {
            return new ObjectDetail(this.mCloneSource, this.mTextDetail, this.mFileName, this.mThirdPartyAppID, this.mPermissionSettingType, this.mContainerType, this.mContainerID, this.mCurrentPage, this.mPostID, this.mForwardIDs, this.mImageKeys, this.mVideoKeys, this.mDocument, super.buildUnknownFields());
        }

        public Builder() {
            this.mForwardIDs = Internal.newMutableList();
            this.mImageKeys = Internal.newMutableList();
            this.mVideoKeys = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2180build();
        }

        public Builder CloneSource(String r1) {
            this.mCloneSource = r1;
            return this;
        }

        public Builder ContainerID(String r1) {
            this.mContainerID = r1;
            return this;
        }

        public Builder ContainerType(ContainerType r1) {
            this.mContainerType = r1;
            return this;
        }

        public Builder CurrentPage(String r1) {
            this.mCurrentPage = r1;
            return this;
        }

        public Builder Document(Document r1) {
            this.mDocument = r1;
            return this;
        }

        public Builder FileName(String r1) {
            this.mFileName = r1;
            return this;
        }

        public Builder ForwardIDs(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mForwardIDs = r1;
            return this;
        }

        public Builder ImageKeys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mImageKeys = r1;
            return this;
        }

        public Builder PermissionSettingType(PermissionSettingType r1) {
            this.mPermissionSettingType = r1;
            return this;
        }

        public Builder PostID(String r1) {
            this.mPostID = r1;
            return this;
        }

        public Builder TextDetail(String r1) {
            this.mTextDetail = r1;
            return this;
        }

        public Builder ThirdPartyAppID(String r1) {
            this.mThirdPartyAppID = r1;
            return this;
        }

        public Builder VideoKeys(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mVideoKeys = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ObjectDetail extends ProtoAdapter<ObjectDetail> {
        public ProtoAdapter_ObjectDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, ObjectDetail.class);
        }

        public ObjectDetail decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mCloneSource = "";
            r0.mTextDetail = "";
            r0.mFileName = "";
            r0.mThirdPartyAppID = "";
            r0.mContainerID = "";
            r0.mCurrentPage = "";
            r0.mPostID = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L31;
            if (r3 != 31) goto L8;
            r0.mPostID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 32) goto L9;
            r0.mForwardIDs.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L9:
            switch(r3) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L33;
                case 6: goto L35;
                case 7: goto L16;
                case 8: goto L15;
                default: goto L10;
            };
        L33:
            r0.mPermissionSettingType = (PermissionSettingType) PermissionSettingType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r0.mContainerType = (ContainerType) ContainerType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r0.mCurrentPage = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mContainerID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L25:
            r0.mThirdPartyAppID = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L26:
            r0.mFileName = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mTextDetail = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L28:
            r0.mCloneSource = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            switch(r3) {
                case 9000002: goto L14;
                case 9000003: goto L13;
                case 9000004: goto L12;
                default: goto L11;
            };
        L12:
            r0.mDocument = (Document) Document.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mVideoKeys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L14:
            r0.mImageKeys.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L31:
            r9.endMessage(r1);
            return r0.m2180build();
        }

        public int encodedSize(ObjectDetail r7) {
            String r0 = r7.mCloneSource;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r7.mTextDetail;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r6 = r7.mFileName;
            if (r6 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
        L14:
            int r9 = r5 + r8;
            String r10 = r7.mThirdPartyAppID;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            PermissionSettingType r13 = r7.mPermissionSettingType;
            if (r13 == null) goto L21;
            int r14 = PermissionSettingType.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ContainerType r16 = r7.mContainerType;
            if (r16 == null) goto L25;
            int r17 = ContainerType.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r7.mContainerID;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r7.mCurrentPage;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r7.mPostID;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(31, r25);
        L38:
            int r27 = r24 + r26;
            ProtoAdapter r28 = ProtoAdapter.STRING;
            int r29 = ((r27 + r28.asRepeated().encodedSizeWithTag(32, r7.mForwardIDs)) + r28.asRepeated().encodedSizeWithTag(9000002, r7.mImageKeys)) + r28.asRepeated().encodedSizeWithTag(9000003, r7.mVideoKeys);
            Document r30 = r7.mDocument;
            if (r30 == null) goto L42;
            r1 = Document.ADAPTER.encodedSizeWithTag(9000004, r30);
        L42:
            return (r29 + r1) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2181decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ObjectDetail) r1);
        }

        public void encode(ProtoWriter r5, ObjectDetail r6) throws IOException {
            String r0 = r6.mCloneSource;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            String r1 = r6.mTextDetail;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
        L8:
            String r2 = r6.mFileName;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
        L11:
            String r3 = r6.mThirdPartyAppID;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r5, 4, r3);
        L14:
            PermissionSettingType r4 = r6.mPermissionSettingType;
            if (r4 == null) goto L17;
            PermissionSettingType.ADAPTER.encodeWithTag(r5, 5, r4);
        L17:
            ContainerType r7 = r6.mContainerType;
            if (r7 == null) goto L20;
            ContainerType.ADAPTER.encodeWithTag(r5, 6, r7);
        L20:
            String r8 = r6.mContainerID;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r5, 7, r8);
        L23:
            String r9 = r6.mCurrentPage;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r5, 8, r9);
        L26:
            String r10 = r6.mPostID;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r5, 31, r10);
        L29:
            ProtoAdapter r11 = ProtoAdapter.STRING;
            r11.asRepeated().encodeWithTag(r5, 32, r6.mForwardIDs);
            r11.asRepeated().encodeWithTag(r5, 9000002, r6.mImageKeys);
            r11.asRepeated().encodeWithTag(r5, 9000003, r6.mVideoKeys);
            Document r12 = r6.mDocument;
            if (r12 == null) goto L32;
            Document.ADAPTER.encodeWithTag(r5, 9000004, r12);
        L32:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ObjectDetail) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ObjectDetail();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2179newBuilder() {
        Builder r0 = new Builder();
        r0.mCloneSource = this.mCloneSource;
        r0.mTextDetail = this.mTextDetail;
        r0.mFileName = this.mFileName;
        r0.mThirdPartyAppID = this.mThirdPartyAppID;
        r0.mPermissionSettingType = this.mPermissionSettingType;
        r0.mContainerType = this.mContainerType;
        r0.mContainerID = this.mContainerID;
        r0.mCurrentPage = this.mCurrentPage;
        r0.mPostID = this.mPostID;
        r0.mForwardIDs = Internal.copyOf("mForwardIDs", this.mForwardIDs);
        r0.mImageKeys = Internal.copyOf("mImageKeys", this.mImageKeys);
        r0.mVideoKeys = Internal.copyOf("mVideoKeys", this.mVideoKeys);
        r0.mDocument = this.mDocument;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ObjectDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2179newBuilder();
    }

    public ObjectDetail(String r16, String r17, String r18, String r19, PermissionSettingType r20, ContainerType r21, String r22, String r23, String r24, List<String> r25, List<String> r26, List<String> r27, Document r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public ObjectDetail(String r2, String r3, String r4, String r5, PermissionSettingType r6, ContainerType r7, String r8, String r9, String r10, List<String> r11, List<String> r12, List<String> r13, Document r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mCloneSource = r2;
        this.mTextDetail = r3;
        this.mFileName = r4;
        this.mThirdPartyAppID = r5;
        this.mPermissionSettingType = r6;
        this.mContainerType = r7;
        this.mContainerID = r8;
        this.mCurrentPage = r9;
        this.mPostID = r10;
        this.mForwardIDs = Internal.immutableCopyOf("mForwardIDs", r11);
        this.mImageKeys = Internal.immutableCopyOf("mImageKeys", r12);
        this.mVideoKeys = Internal.immutableCopyOf("mVideoKeys", r13);
        this.mDocument = r14;
    }
}
