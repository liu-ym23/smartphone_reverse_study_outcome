package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.pb.entities.FileContent;
import com.ss.android.lark.pb.entities.ImageSetV2;
import com.ss.android.lark.pb.entities.MediaContent;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MessageAttachment extends Message<MessageAttachment, Builder> {
    public static final ProtoAdapter<MessageAttachment> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_RESOURCE_ACCESS_AUTH = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_SUMMARY = "";
    public static final String DEFAULT_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final AttachmentRenderType mattachmentRenderType;
    public final com.ss.android.lark.pb.entities.Message.MessageAttachmentType mattachmentType;
    public final FileContent mfile_meta;
    public final Boolean mhas_resource_access_auth;
    public final String mid;
    public final ImageSetV2 mimage;
    public final MediaContent mmedia_content;
    public final String msummary;
    public final String msummary_highlighted;
    public final String mtitle;
    public final String mtitle_highlighted;
    public final URLMeta murl_meta;

    public static final enum AttachmentRenderType extends Enum<AttachmentRenderType> implements WireEnum {
        private static final /* synthetic */ AttachmentRenderType[] $VALUES = null;
        public static final ProtoAdapter<AttachmentRenderType> ADAPTER = null;
        public static final AttachmentRenderType CARD = null;
        public static final AttachmentRenderType SLOT = null;
        public static final AttachmentRenderType UNKNOWN = null;
        private final int value;

        static {
            AttachmentRenderType r0 = new AttachmentRenderType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            AttachmentRenderType r1 = new AttachmentRenderType("SLOT", 1, 1);
            SLOT = r1;
            AttachmentRenderType r3 = new AttachmentRenderType("CARD", 2, 2);
            CARD = r3;
            $VALUES = new AttachmentRenderType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(AttachmentRenderType.class);
        }

        public static AttachmentRenderType[] values() {
            return (AttachmentRenderType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AttachmentRenderType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CARD;
        L12:
            return SLOT;
        L14:
            return UNKNOWN;
        }

        public static AttachmentRenderType valueOf(String r1) {
            return (AttachmentRenderType) a.a(AttachmentRenderType.class, r1);
        }

        private AttachmentRenderType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<MessageAttachment, Builder> {
        public AttachmentRenderType mattachmentRenderType;
        public com.ss.android.lark.pb.entities.Message.MessageAttachmentType mattachmentType;
        public FileContent mfile_meta;
        public Boolean mhas_resource_access_auth;
        public String mid;
        public ImageSetV2 mimage;
        public MediaContent mmedia_content;
        public String msummary;
        public String msummary_highlighted;
        public String mtitle;
        public String mtitle_highlighted;
        public URLMeta murl_meta;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageAttachment m2684build() {
            return new MessageAttachment(this.mid, this.mattachmentType, this.mattachmentRenderType, this.mtitle, this.mtitle_highlighted, this.msummary, this.msummary_highlighted, this.mimage, this.mmedia_content, this.mfile_meta, this.murl_meta, this.mhas_resource_access_auth, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2684build();
        }

        public Builder attachmentRenderType(AttachmentRenderType r1) {
            this.mattachmentRenderType = r1;
            return this;
        }

        public Builder attachmentType(com.ss.android.lark.pb.entities.Message.MessageAttachmentType r1) {
            this.mattachmentType = r1;
            return this;
        }

        public Builder file_meta(FileContent r1) {
            this.mfile_meta = r1;
            return this;
        }

        public Builder has_resource_access_auth(Boolean r1) {
            this.mhas_resource_access_auth = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder image(ImageSetV2 r1) {
            this.mimage = r1;
            return this;
        }

        public Builder media_content(MediaContent r1) {
            this.mmedia_content = r1;
            return this;
        }

        public Builder summary(String r1) {
            this.msummary = r1;
            return this;
        }

        public Builder summary_highlighted(String r1) {
            this.msummary_highlighted = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }

        public Builder title_highlighted(String r1) {
            this.mtitle_highlighted = r1;
            return this;
        }

        public Builder url_meta(URLMeta r1) {
            this.murl_meta = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageAttachment extends ProtoAdapter<MessageAttachment> {
        public ProtoAdapter_MessageAttachment() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageAttachment.class);
        }

        public MessageAttachment decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtitle = "";
            r0.mtitle_highlighted = "";
            r0.msummary = "";
            r0.msummary_highlighted = "";
            r0.mhas_resource_access_auth = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L25;
            switch(r3) {
                case 1: goto L24;
                case 2: goto L27;
                case 3: goto L29;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L6;
                case 10: goto L6;
                case 11: goto L11;
                case 12: goto L10;
                case 13: goto L9;
                case 14: goto L8;
                case 15: goto L7;
                default: goto L6;
            };
        L27:
            r0.mattachmentType = (com.ss.android.lark.pb.entities.Message.MessageAttachmentType) com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r0.mattachmentRenderType = (AttachmentRenderType) AttachmentRenderType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mhas_resource_access_auth = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.murl_meta = (URLMeta) URLMeta.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mfile_meta = (FileContent) FileContent.ADAPTER.decode(r9);
            goto L3
        L10:
            r0.mmedia_content = (MediaContent) MediaContent.ADAPTER.decode(r9);
            goto L3
        L11:
            r0.mimage = (ImageSetV2) ImageSetV2.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.msummary_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.msummary = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mtitle_highlighted = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L25:
            r9.endMessage(r1);
            return r0.m2684build();
        }

        public int encodedSize(MessageAttachment r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            com.ss.android.lark.pb.entities.Message.MessageAttachmentType r3 = r6.mattachmentType;
            if (r3 == null) goto L9;
            int r4 = com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            AttachmentRenderType r7 = r6.mattachmentRenderType;
            if (r7 == null) goto L13;
            int r8 = AttachmentRenderType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtitle;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mtitle_highlighted;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.msummary;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.msummary_highlighted;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            ImageSetV2 r22 = r6.mimage;
            if (r22 == null) goto L33;
            int r23 = ImageSetV2.ADAPTER.encodedSizeWithTag(11, r22);
        L34:
            int r24 = r21 + r23;
            MediaContent r25 = r6.mmedia_content;
            if (r25 == null) goto L37;
            int r26 = MediaContent.ADAPTER.encodedSizeWithTag(12, r25);
        L38:
            int r27 = r24 + r26;
            FileContent r28 = r6.mfile_meta;
            if (r28 == null) goto L41;
            int r29 = FileContent.ADAPTER.encodedSizeWithTag(13, r28);
        L42:
            int r30 = r27 + r29;
            URLMeta r31 = r6.murl_meta;
            if (r31 == null) goto L45;
            int r32 = URLMeta.ADAPTER.encodedSizeWithTag(14, r31);
        L46:
            int r33 = r30 + r32;
            Boolean r34 = r6.mhas_resource_access_auth;
            if (r34 == null) goto L50;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r34);
        L50:
            return (r33 + r1) + r6.unknownFields().size();
        L45:
            r32 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ Object m2685decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageAttachment) r1);
        }

        public void encode(ProtoWriter r4, MessageAttachment r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            com.ss.android.lark.pb.entities.Message.MessageAttachmentType r1 = r5.mattachmentType;
            if (r1 == null) goto L8;
            com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            AttachmentRenderType r2 = r5.mattachmentRenderType;
            if (r2 == null) goto L11;
            AttachmentRenderType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtitle;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mtitle_highlighted;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.msummary;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.msummary_highlighted;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            ImageSetV2 r9 = r5.mimage;
            if (r9 == null) goto L26;
            ImageSetV2.ADAPTER.encodeWithTag(r4, 11, r9);
        L26:
            MediaContent r10 = r5.mmedia_content;
            if (r10 == null) goto L29;
            MediaContent.ADAPTER.encodeWithTag(r4, 12, r10);
        L29:
            FileContent r11 = r5.mfile_meta;
            if (r11 == null) goto L32;
            FileContent.ADAPTER.encodeWithTag(r4, 13, r11);
        L32:
            URLMeta r12 = r5.murl_meta;
            if (r12 == null) goto L35;
            URLMeta.ADAPTER.encodeWithTag(r4, 14, r12);
        L35:
            Boolean r13 = r5.mhas_resource_access_auth;
            if (r13 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r4, 15, r13);
        L38:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageAttachment) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageAttachment();
        DEFAULT_HAS_RESOURCE_ACCESS_AUTH = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2683newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mattachmentType = this.mattachmentType;
        r0.mattachmentRenderType = this.mattachmentRenderType;
        r0.mtitle = this.mtitle;
        r0.mtitle_highlighted = this.mtitle_highlighted;
        r0.msummary = this.msummary;
        r0.msummary_highlighted = this.msummary_highlighted;
        r0.mimage = this.mimage;
        r0.mmedia_content = this.mmedia_content;
        r0.mfile_meta = this.mfile_meta;
        r0.murl_meta = this.murl_meta;
        r0.mhas_resource_access_auth = this.mhas_resource_access_auth;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageAttachment.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2683newBuilder();
    }

    public MessageAttachment(String r15, com.ss.android.lark.pb.entities.Message.MessageAttachmentType r16, AttachmentRenderType r17, String r18, String r19, String r20, String r21, ImageSetV2 r22, MediaContent r23, FileContent r24, URLMeta r25, Boolean r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public MessageAttachment(String r2, com.ss.android.lark.pb.entities.Message.MessageAttachmentType r3, AttachmentRenderType r4, String r5, String r6, String r7, String r8, ImageSetV2 r9, MediaContent r10, FileContent r11, URLMeta r12, Boolean r13, ByteString r14) {
        super(ADAPTER, r14);
        this.mid = r2;
        this.mattachmentType = r3;
        this.mattachmentRenderType = r4;
        this.mtitle = r5;
        this.mtitle_highlighted = r6;
        this.msummary = r7;
        this.msummary_highlighted = r8;
        this.mimage = r9;
        this.mmedia_content = r10;
        this.mfile_meta = r11;
        this.murl_meta = r12;
        this.mhas_resource_access_auth = r13;
    }
}
