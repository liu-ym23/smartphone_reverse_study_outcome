package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class QACardMeta extends Message<QACardMeta, Builder> {
    public static final ProtoAdapter<QACardMeta> ADAPTER = null;
    public static final String DEFAULT_CATEGORY_DESC = "";
    public static final String DEFAULT_CATEGORY_NAME = "";
    public static final String DEFAULT_CONTENT_AVATAR_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_QA_RENDER_META = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_URL = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final String mcategory_desc;
    public final String mcategory_name;
    public final String mcontent_avatar_key;
    public final String mid;
    public final JumpType mjump_type;
    public final String mname;
    public final String mqa_render_meta;
    public final List<String> mrecommended_questions;
    public final String msource_id;
    public final SourceMeta msource_meta;
    public final SourceType msource_type;
    public final String msource_url;
    public final Long mupdate_time;

    public static final class AppMeta extends Message<AppMeta, Builder> {
        public static final ProtoAdapter<AppMeta> ADAPTER = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String muser_id;

        public static final class Builder extends Message.Builder<AppMeta, Builder> {
            public String muser_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AppMeta m2781build() {
                return new AppMeta(this.muser_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2781build();
            }

            public Builder user_id(String r1) {
                this.muser_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AppMeta extends ProtoAdapter<AppMeta> {
            public ProtoAdapter_AppMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, AppMeta.class);
            }

            public AppMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.muser_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.muser_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2781build();
            }

            public int encodedSize(AppMeta r4) {
                String r0 = r4.muser_id;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2782decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AppMeta) r1);
            }

            public void encode(ProtoWriter r4, AppMeta r5) throws IOException {
                String r0 = r5.muser_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AppMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2780newBuilder() {
            Builder r0 = new Builder();
            r0.muser_id = this.muser_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AppMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2780newBuilder();
        }

        public AppMeta(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public AppMeta(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_id = r2;
        }
    }

    public static final class Builder extends Message.Builder<QACardMeta, Builder> {
        public String mcategory_desc;
        public String mcategory_name;
        public String mcontent_avatar_key;
        public String mid;
        public JumpType mjump_type;
        public String mname;
        public String mqa_render_meta;
        public List<String> mrecommended_questions;
        public String msource_id;
        public SourceMeta msource_meta;
        public SourceType msource_type;
        public String msource_url;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public QACardMeta m2783build() {
            String r1 = this.mid;
            if (r1 == null) goto L9;
            if (this.msource_meta == null) goto L9;
            return new QACardMeta(this.mid, this.msource_id, this.msource_type, this.msource_meta, this.msource_url, this.mname, this.mcategory_name, this.mcategory_desc, this.mupdate_time, this.mcontent_avatar_key, this.mrecommended_questions, this.mqa_render_meta, this.mjump_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid", this.msource_meta, "msource_meta"});
        }

        public Builder() {
            this.mrecommended_questions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2783build();
        }

        public Builder category_desc(String r1) {
            this.mcategory_desc = r1;
            return this;
        }

        public Builder category_name(String r1) {
            this.mcategory_name = r1;
            return this;
        }

        public Builder content_avatar_key(String r1) {
            this.mcontent_avatar_key = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder jump_type(JumpType r1) {
            this.mjump_type = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder qa_render_meta(String r1) {
            this.mqa_render_meta = r1;
            return this;
        }

        public Builder recommended_questions(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrecommended_questions = r1;
            return this;
        }

        public Builder source_id(String r1) {
            this.msource_id = r1;
            return this;
        }

        public Builder source_meta(SourceMeta r1) {
            this.msource_meta = r1;
            return this;
        }

        public Builder source_type(SourceType r1) {
            this.msource_type = r1;
            return this;
        }

        public Builder source_url(String r1) {
            this.msource_url = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class DocMeta extends Message<DocMeta, Builder> {
        public static final ProtoAdapter<DocMeta> ADAPTER = null;
        public static final String DEFAULT_ANCHOR_URL = "";
        private static final long serialVersionUID = 0;
        public final String manchor_url;
        public final DocType mdoc_type;

        public static final class Builder extends Message.Builder<DocMeta, Builder> {
            public String manchor_url;
            public DocType mdoc_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocMeta m2785build() {
                return new DocMeta(this.manchor_url, this.mdoc_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2785build();
            }

            public Builder anchor_url(String r1) {
                this.manchor_url = r1;
                return this;
            }

            public Builder doc_type(DocType r1) {
                this.mdoc_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocMeta extends ProtoAdapter<DocMeta> {
            public ProtoAdapter_DocMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DocMeta.class);
            }

            public DocMeta decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.manchor_url = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.manchor_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mdoc_type = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2785build();
            }

            public int encodedSize(DocMeta r5) {
                String r0 = r5.manchor_url;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                DocType r3 = r5.mdoc_type;
                if (r3 == null) goto L10;
                r1 = DocType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2786decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocMeta) r1);
            }

            public void encode(ProtoWriter r4, DocMeta r5) throws IOException {
                String r0 = r5.manchor_url;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                DocType r1 = r5.mdoc_type;
                if (r1 == null) goto L8;
                DocType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2784newBuilder() {
            Builder r0 = new Builder();
            r0.manchor_url = this.manchor_url;
            r0.mdoc_type = this.mdoc_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2784newBuilder();
        }

        public DocMeta(String r2, DocType r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public DocMeta(String r2, DocType r3, ByteString r4) {
            super(ADAPTER, r4);
            this.manchor_url = r2;
            this.mdoc_type = r3;
        }
    }

    public static final enum JumpType extends Enum<JumpType> implements WireEnum {
        private static final /* synthetic */ JumpType[] $VALUES = null;
        public static final ProtoAdapter<JumpType> ADAPTER = null;
        public static final JumpType ENTERPRISE_QA = null;
        public static final JumpType HELPDESK = null;
        public static final JumpType UNKNOWN = null;
        private final int value;

        static {
            JumpType r0 = new JumpType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            JumpType r1 = new JumpType("ENTERPRISE_QA", 1, 1);
            ENTERPRISE_QA = r1;
            JumpType r3 = new JumpType("HELPDESK", 2, 2);
            HELPDESK = r3;
            $VALUES = new JumpType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(JumpType.class);
        }

        public static JumpType[] values() {
            return (JumpType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static JumpType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return HELPDESK;
        L12:
            return ENTERPRISE_QA;
        L14:
            return UNKNOWN;
        }

        public static JumpType valueOf(String r1) {
            return (JumpType) a.a(JumpType.class, r1);
        }

        private JumpType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class OncallMeta extends Message<OncallMeta, Builder> {
        public static final ProtoAdapter<OncallMeta> ADAPTER = null;
        public static final String DEFAULT_FAQ_ID = "";
        private static final long serialVersionUID = 0;
        public final String mfaq_id;

        public static final class Builder extends Message.Builder<OncallMeta, Builder> {
            public String mfaq_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OncallMeta m2788build() {
                return new OncallMeta(this.mfaq_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2788build();
            }

            public Builder faq_id(String r1) {
                this.mfaq_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OncallMeta extends ProtoAdapter<OncallMeta> {
            public ProtoAdapter_OncallMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, OncallMeta.class);
            }

            public OncallMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mfaq_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfaq_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2788build();
            }

            public int encodedSize(OncallMeta r4) {
                String r0 = r4.mfaq_id;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2789decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OncallMeta) r1);
            }

            public void encode(ProtoWriter r4, OncallMeta r5) throws IOException {
                String r0 = r5.mfaq_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OncallMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OncallMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2787newBuilder() {
            Builder r0 = new Builder();
            r0.mfaq_id = this.mfaq_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OncallMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2787newBuilder();
        }

        public OncallMeta(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public OncallMeta(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfaq_id = r2;
        }
    }

    public static final class ProtoAdapter_QACardMeta extends ProtoAdapter<QACardMeta> {
        public ProtoAdapter_QACardMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, QACardMeta.class);
        }

        public QACardMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.msource_id = "";
            r0.msource_url = "";
            r0.mname = "";
            r0.mcategory_name = "";
            r0.mcategory_desc = "";
            r0.mupdate_time = 0L;
            r0.mcontent_avatar_key = "";
            r0.mqa_render_meta = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L26;
            switch(r3) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L28;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L30;
                default: goto L6;
            };
        L28:
            r0.msource_type = (SourceType) SourceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r0.mjump_type = (JumpType) JumpType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mqa_render_meta = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mrecommended_questions.add((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L13:
            r0.mcontent_avatar_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mcategory_desc = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mcategory_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.msource_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.msource_meta = (SourceMeta) SourceMeta.ADAPTER.decode(r9);
            goto L3
        L24:
            r0.msource_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L25:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L26:
            r9.endMessage(r1);
            return r0.m2783build();
        }

        public int encodedSize(QACardMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            String r2 = r7.msource_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            SourceType r6 = r7.msource_type;
            if (r6 == null) goto L9;
            int r8 = SourceType.ADAPTER.encodedSizeWithTag(3, r6);
        L10:
            int r9 = (r5 + r8) + SourceMeta.ADAPTER.encodedSizeWithTag(4, r7.msource_meta);
            String r10 = r7.msource_url;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(5, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mname;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(6, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mcategory_name;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(7, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mcategory_desc;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(8, r19);
        L26:
            int r21 = r18 + r20;
            Long r22 = r7.mupdate_time;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.INT64.encodedSizeWithTag(9, r22);
        L30:
            int r24 = r21 + r23;
            String r25 = r7.mcontent_avatar_key;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(10, r25);
        L34:
            int r27 = (r24 + r26) + r0.asRepeated().encodedSizeWithTag(11, r7.mrecommended_questions);
            String r28 = r7.mqa_render_meta;
            if (r28 == null) goto L37;
            int r29 = r0.encodedSizeWithTag(12, r28);
        L38:
            int r30 = r27 + r29;
            JumpType r31 = r7.mjump_type;
            if (r31 == null) goto L42;
            r3 = JumpType.ADAPTER.encodedSizeWithTag(13, r31);
        L42:
            return (r30 + r3) + r7.unknownFields().size();
        L37:
            r29 = 0;
            goto L38
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ Object m2790decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((QACardMeta) r1);
        }

        public void encode(ProtoWriter r5, QACardMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            String r1 = r6.msource_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 2, r1);
        L5:
            SourceType r2 = r6.msource_type;
            if (r2 == null) goto L8;
            SourceType.ADAPTER.encodeWithTag(r5, 3, r2);
        L8:
            SourceMeta.ADAPTER.encodeWithTag(r5, 4, r6.msource_meta);
            String r3 = r6.msource_url;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 5, r3);
        L11:
            String r4 = r6.mname;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 6, r4);
        L14:
            String r7 = r6.mcategory_name;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 7, r7);
        L17:
            String r8 = r6.mcategory_desc;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 8, r8);
        L20:
            Long r9 = r6.mupdate_time;
            if (r9 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r5, 9, r9);
        L23:
            String r10 = r6.mcontent_avatar_key;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 10, r10);
        L26:
            r0.asRepeated().encodeWithTag(r5, 11, r6.mrecommended_questions);
            String r11 = r6.mqa_render_meta;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 12, r11);
        L29:
            JumpType r12 = r6.mjump_type;
            if (r12 == null) goto L32;
            JumpType.ADAPTER.encodeWithTag(r5, 13, r12);
        L32:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (QACardMeta) r2);
        }
    }

    public static final class SourceMeta extends Message<SourceMeta, Builder> {
        public static final ProtoAdapter<SourceMeta> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final AppMeta mapp_meta;
        public final DocMeta mdoc_meta;
        public final OncallMeta moncall_meta;
        public final WikiMeta mwiki_meta;

        public static final class Builder extends Message.Builder<SourceMeta, Builder> {
            public AppMeta mapp_meta;
            public DocMeta mdoc_meta;
            public OncallMeta moncall_meta;
            public WikiMeta mwiki_meta;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SourceMeta m2792build() {
                return new SourceMeta(this.moncall_meta, this.mdoc_meta, this.mapp_meta, this.mwiki_meta, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2792build();
            }

            public Builder app_meta(AppMeta r1) {
                this.mapp_meta = r1;
                this.moncall_meta = null;
                this.mdoc_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder doc_meta(DocMeta r1) {
                this.mdoc_meta = r1;
                this.moncall_meta = null;
                this.mapp_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder oncall_meta(OncallMeta r1) {
                this.moncall_meta = r1;
                this.mdoc_meta = null;
                this.mapp_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder wiki_meta(WikiMeta r1) {
                this.mwiki_meta = r1;
                this.moncall_meta = null;
                this.mdoc_meta = null;
                this.mapp_meta = null;
                return this;
            }
        }

        public static final class ProtoAdapter_SourceMeta extends ProtoAdapter<SourceMeta> {
            public ProtoAdapter_SourceMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, SourceMeta.class);
            }

            public SourceMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.oncall_meta((OncallMeta) OncallMeta.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.doc_meta((DocMeta) DocMeta.ADAPTER.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.app_meta((AppMeta) AppMeta.ADAPTER.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.wiki_meta((WikiMeta) WikiMeta.ADAPTER.decode(r7));
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2792build();
            }

            public int encodedSize(SourceMeta r6) {
                OncallMeta r0 = r6.moncall_meta;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = OncallMeta.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                DocMeta r3 = r6.mdoc_meta;
                if (r3 == null) goto L9;
                int r4 = DocMeta.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                AppMeta r7 = r6.mapp_meta;
                if (r7 == null) goto L13;
                int r8 = AppMeta.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                WikiMeta r10 = r6.mwiki_meta;
                if (r10 == null) goto L18;
                r1 = WikiMeta.ADAPTER.encodedSizeWithTag(4, r10);
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
            public /* bridge */ /* synthetic */ Object m2793decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SourceMeta) r1);
            }

            public void encode(ProtoWriter r4, SourceMeta r5) throws IOException {
                OncallMeta r0 = r5.moncall_meta;
                if (r0 == null) goto L5;
                OncallMeta.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                DocMeta r1 = r5.mdoc_meta;
                if (r1 == null) goto L8;
                DocMeta.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                AppMeta r2 = r5.mapp_meta;
                if (r2 == null) goto L11;
                AppMeta.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                WikiMeta r3 = r5.mwiki_meta;
                if (r3 == null) goto L14;
                WikiMeta.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SourceMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SourceMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2791newBuilder() {
            Builder r0 = new Builder();
            r0.moncall_meta = this.moncall_meta;
            r0.mdoc_meta = this.mdoc_meta;
            r0.mapp_meta = this.mapp_meta;
            r0.mwiki_meta = this.mwiki_meta;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SourceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2791newBuilder();
        }

        public SourceMeta(OncallMeta r7, DocMeta r8, AppMeta r9, WikiMeta r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public SourceMeta(OncallMeta r2, DocMeta r3, AppMeta r4, WikiMeta r5, ByteString r6) {
            super(ADAPTER, r6);
            if (Internal.countNonNull(r2, r3, r4, r5, new Object[0]) > 1) goto L7;
            this.moncall_meta = r2;
            this.mdoc_meta = r3;
            this.mapp_meta = r4;
            this.mwiki_meta = r5;
            return;
        L7:
            throw new IllegalArgumentException("at most one of moncall_meta, mdoc_meta, mapp_meta, mwiki_meta may be non-null");
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType APP = null;
        public static final SourceType DOC = null;
        public static final SourceType ONCALL = null;
        public static final SourceType UNKNOWN_SOURCE = null;
        public static final SourceType WIKI = null;
        private final int value;

        static {
            SourceType r0 = new SourceType("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r0;
            SourceType r1 = new SourceType("ONCALL", 1, 1);
            ONCALL = r1;
            SourceType r3 = new SourceType("DOC", 2, 2);
            DOC = r3;
            SourceType r5 = new SourceType("APP", 3, 3);
            APP = r5;
            SourceType r7 = new SourceType("WIKI", 4, 4);
            WIKI = r7;
            $VALUES = new SourceType[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return WIKI;
        L16:
            return APP;
        L18:
            return DOC;
        L20:
            return ONCALL;
        L22:
            return UNKNOWN_SOURCE;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) a.a(SourceType.class, r1);
        }

        private SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class WikiMeta extends Message<WikiMeta, Builder> {
        public static final ProtoAdapter<WikiMeta> ADAPTER = null;
        public static final String DEFAULT_ANCHOR_URL = "";
        private static final long serialVersionUID = 0;
        public final String manchor_url;

        public static final class Builder extends Message.Builder<WikiMeta, Builder> {
            public String manchor_url;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WikiMeta m2795build() {
                return new WikiMeta(this.manchor_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2795build();
            }

            public Builder anchor_url(String r1) {
                this.manchor_url = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiMeta extends ProtoAdapter<WikiMeta> {
            public ProtoAdapter_WikiMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiMeta.class);
            }

            public WikiMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.manchor_url = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.manchor_url = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2795build();
            }

            public int encodedSize(WikiMeta r4) {
                String r0 = r4.manchor_url;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2796decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WikiMeta) r1);
            }

            public void encode(ProtoWriter r4, WikiMeta r5) throws IOException {
                String r0 = r5.manchor_url;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WikiMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2794newBuilder() {
            Builder r0 = new Builder();
            r0.manchor_url = this.manchor_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WikiMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2794newBuilder();
        }

        public WikiMeta(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public WikiMeta(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.manchor_url = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QACardMeta();
        DEFAULT_UPDATE_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2779newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.msource_id = this.msource_id;
        r0.msource_type = this.msource_type;
        r0.msource_meta = this.msource_meta;
        r0.msource_url = this.msource_url;
        r0.mname = this.mname;
        r0.mcategory_name = this.mcategory_name;
        r0.mcategory_desc = this.mcategory_desc;
        r0.mupdate_time = this.mupdate_time;
        r0.mcontent_avatar_key = this.mcontent_avatar_key;
        r0.mrecommended_questions = Internal.copyOf("mrecommended_questions", this.mrecommended_questions);
        r0.mqa_render_meta = this.mqa_render_meta;
        r0.mjump_type = this.mjump_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return QACardMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2779newBuilder();
    }

    public QACardMeta(String r16, String r17, SourceType r18, SourceMeta r19, String r20, String r21, String r22, String r23, Long r24, String r25, List<String> r26, String r27, JumpType r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public QACardMeta(String r2, String r3, SourceType r4, SourceMeta r5, String r6, String r7, String r8, String r9, Long r10, String r11, List<String> r12, String r13, JumpType r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mid = r2;
        this.msource_id = r3;
        this.msource_type = r4;
        this.msource_meta = r5;
        this.msource_url = r6;
        this.mname = r7;
        this.mcategory_name = r8;
        this.mcategory_desc = r9;
        this.mupdate_time = r10;
        this.mcontent_avatar_key = r11;
        this.mrecommended_questions = Internal.immutableCopyOf("mrecommended_questions", r12);
        this.mqa_render_meta = r13;
        this.mjump_type = r14;
    }
}
