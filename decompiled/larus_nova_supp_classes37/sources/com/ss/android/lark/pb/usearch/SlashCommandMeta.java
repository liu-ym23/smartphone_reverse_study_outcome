package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SlashCommandMeta extends Message<SlashCommandMeta, Builder> {
    public static final ProtoAdapter<SlashCommandMeta> ADAPTER = null;
    public static final String DEFAULT_APP_LINK = "";
    public static final String DEFAULT_DATA_SOURCE_ID = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_IMAGE_URL = "";
    public static final Long DEFAULT_RENDER_TIME_STAMP = null;
    public static final FieldOptions FIELD_OPTIONS_MDATA_SOURCE_ID = null;
    private static final long serialVersionUID = 0;
    public final String mapp_link;
    public final String mdata_source_id;
    public final String mdescription;
    public final String mextra;
    public final String mimage_url;
    public final Long mrender_time_stamp;
    public final SearchQABizType msearch_qa_biz_type;
    public final SlashCommandType mslash_command_type;
    public final List<SlashCommandTag> mtag;

    public static final class Builder extends Message.Builder<SlashCommandMeta, Builder> {
        public String mapp_link;
        public String mdata_source_id;
        public String mdescription;
        public String mextra;
        public String mimage_url;
        public Long mrender_time_stamp;
        public SearchQABizType msearch_qa_biz_type;
        public SlashCommandType mslash_command_type;
        public List<SlashCommandTag> mtag;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SlashCommandMeta m2849build() {
            SlashCommandType r0 = this.mslash_command_type;
            if (r0 == null) goto L7;
            return new SlashCommandMeta(this.mslash_command_type, this.mapp_link, this.mtag, this.mextra, this.mimage_url, this.mdescription, this.mdata_source_id, this.msearch_qa_biz_type, this.mrender_time_stamp, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mslash_command_type"});
        }

        public Builder() {
            this.mtag = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2849build();
        }

        public Builder app_link(String r1) {
            this.mapp_link = r1;
            return this;
        }

        public Builder data_source_id(String r1) {
            this.mdata_source_id = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder extra(String r1) {
            this.mextra = r1;
            return this;
        }

        public Builder image_url(String r1) {
            this.mimage_url = r1;
            return this;
        }

        public Builder render_time_stamp(Long r1) {
            this.mrender_time_stamp = r1;
            return this;
        }

        public Builder search_qa_biz_type(SearchQABizType r1) {
            this.msearch_qa_biz_type = r1;
            return this;
        }

        public Builder slash_command_type(SlashCommandType r1) {
            this.mslash_command_type = r1;
            return this;
        }

        public Builder tag(List<SlashCommandTag> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtag = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SlashCommandMeta extends ProtoAdapter<SlashCommandMeta> {
        public ProtoAdapter_SlashCommandMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, SlashCommandMeta.class);
        }

        public SlashCommandMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mapp_link = "";
            r0.mextra = "";
            r0.mimage_url = "";
            r0.mdescription = "";
            r0.mdata_source_id = "";
            r0.mrender_time_stamp = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L22;
            switch(r3) {
                case 1: goto L24;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L26;
                case 9: goto L7;
                default: goto L6;
            };
        L24:
            r0.mslash_command_type = (SlashCommandType) SlashCommandType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L26:
            r0.msearch_qa_biz_type = (SearchQABizType) SearchQABizType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mrender_time_stamp = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            r0.mdata_source_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mimage_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mextra = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mtag.add((SlashCommandTag) SlashCommandTag.ADAPTER.decode(r9));
            goto L3
        L17:
            r0.mapp_link = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L22:
            r9.endMessage(r1);
            return r0.m2849build();
        }

        public int encodedSize(SlashCommandMeta r6) {
            int r0 = SlashCommandType.ADAPTER.encodedSizeWithTag(1, r6.mslash_command_type);
            String r1 = r6.mapp_link;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.STRING.encodedSizeWithTag(2, r1);
        L6:
            int r4 = (r0 + r3) + SlashCommandTag.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.mtag);
            String r5 = r6.mextra;
            if (r5 == null) goto L9;
            int r7 = ProtoAdapter.STRING.encodedSizeWithTag(4, r5);
        L10:
            int r8 = r4 + r7;
            String r9 = r6.mimage_url;
            if (r9 == null) goto L13;
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(5, r9);
        L14:
            int r11 = r8 + r10;
            String r12 = r6.mdescription;
            if (r12 == null) goto L17;
            int r13 = ProtoAdapter.STRING.encodedSizeWithTag(6, r12);
        L18:
            int r14 = r11 + r13;
            String r15 = r6.mdata_source_id;
            if (r15 == null) goto L21;
            int r16 = ProtoAdapter.STRING.encodedSizeWithTag(7, r15);
        L22:
            int r17 = r14 + r16;
            SearchQABizType r18 = r6.msearch_qa_biz_type;
            if (r18 == null) goto L25;
            int r19 = SearchQABizType.ADAPTER.encodedSizeWithTag(8, r18);
        L26:
            int r20 = r17 + r19;
            Long r21 = r6.mrender_time_stamp;
            if (r21 == null) goto L30;
            r2 = ProtoAdapter.INT64.encodedSizeWithTag(9, r21);
        L30:
            return (r20 + r2) + r6.unknownFields().size();
        L25:
            r19 = 0;
            goto L26
        L21:
            r16 = 0;
            goto L22
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r7 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2850decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SlashCommandMeta) r1);
        }

        public void encode(ProtoWriter r4, SlashCommandMeta r5) throws IOException {
            SlashCommandType.ADAPTER.encodeWithTag(r4, 1, r5.mslash_command_type);
            String r0 = r5.mapp_link;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r0);
        L5:
            SlashCommandTag.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mtag);
            String r1 = r5.mextra;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r1);
        L8:
            String r2 = r5.mimage_url;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r2);
        L11:
            String r3 = r5.mdescription;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r3);
        L14:
            String r6 = r5.mdata_source_id;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r6);
        L17:
            SearchQABizType r7 = r5.msearch_qa_biz_type;
            if (r7 == null) goto L20;
            SearchQABizType.ADAPTER.encodeWithTag(r4, 8, r7);
        L20:
            Long r8 = r5.mrender_time_stamp;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 9, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SlashCommandMeta) r2);
        }
    }

    public static final class SlashCommandTag extends Message<SlashCommandTag, Builder> {
        public static final ProtoAdapter<SlashCommandTag> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        public static final Integer DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String mtext;
        public final Integer mtype;

        public static final class Builder extends Message.Builder<SlashCommandTag, Builder> {
            public String mtext;
            public Integer mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SlashCommandTag m2852build() {
                Integer r0 = this.mtype;
                if (r0 == null) goto L9;
                if (this.mtext == null) goto L9;
                return new SlashCommandTag(this.mtype, this.mtext, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mtype", this.mtext, "mtext"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2852build();
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }

            public Builder type(Integer r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SlashCommandTag extends ProtoAdapter<SlashCommandTag> {
            public ProtoAdapter_SlashCommandTag() {
                super(FieldEncoding.LENGTH_DELIMITED, SlashCommandTag.class);
            }

            public SlashCommandTag decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtype = 0;
                r0.mtext = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mtype = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2852build();
            }

            public int encodedSize(SlashCommandTag r5) {
                return (ProtoAdapter.INT32.encodedSizeWithTag(1, r5.mtype) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.mtext)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2853decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SlashCommandTag) r1);
            }

            public void encode(ProtoWriter r4, SlashCommandTag r5) throws IOException {
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.mtype);
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.mtext);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SlashCommandTag) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SlashCommandTag();
            DEFAULT_TYPE = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2851newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mtext = this.mtext;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SlashCommandTag.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2851newBuilder();
        }

        public SlashCommandTag(Integer r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public SlashCommandTag(Integer r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mtext = r3;
        }
    }

    public static final enum SlashCommandType extends Enum<SlashCommandType> implements WireEnum {
        private static final /* synthetic */ SlashCommandType[] $VALUES = null;
        public static final ProtoAdapter<SlashCommandType> ADAPTER = null;
        public static final SlashCommandType ENTITY = null;
        public static final SlashCommandType FILTER = null;
        private final int value;

        static {
            SlashCommandType r0 = new SlashCommandType("ENTITY", 0, 0);
            ENTITY = r0;
            SlashCommandType r1 = new SlashCommandType("FILTER", 1, 1);
            FILTER = r1;
            $VALUES = new SlashCommandType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(SlashCommandType.class);
        }

        public static SlashCommandType[] values() {
            return (SlashCommandType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SlashCommandType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return FILTER;
        L10:
            return ENTITY;
        }

        public static SlashCommandType valueOf(String r1) {
            return (SlashCommandType) a.a(SlashCommandType.class, r1);
        }

        private SlashCommandType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SlashCommandMeta();
        FieldOptions.Builder r0 = new FieldOptions.Builder();
        Boolean r1 = Boolean.TRUE;
        FIELD_OPTIONS_MDATA_SOURCE_ID = r0.security_field(r1).security_search_data_source_id(r1).build();
        DEFAULT_RENDER_TIME_STAMP = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2848newBuilder() {
        Builder r0 = new Builder();
        r0.mslash_command_type = this.mslash_command_type;
        r0.mapp_link = this.mapp_link;
        r0.mtag = Internal.copyOf("mtag", this.mtag);
        r0.mextra = this.mextra;
        r0.mimage_url = this.mimage_url;
        r0.mdescription = this.mdescription;
        r0.mdata_source_id = this.mdata_source_id;
        r0.msearch_qa_biz_type = this.msearch_qa_biz_type;
        r0.mrender_time_stamp = this.mrender_time_stamp;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SlashCommandMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2848newBuilder();
    }

    public SlashCommandMeta(SlashCommandType r12, String r13, List<SlashCommandTag> r14, String r15, String r16, String r17, String r18, SearchQABizType r19, Long r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public SlashCommandMeta(SlashCommandType r2, String r3, List<SlashCommandTag> r4, String r5, String r6, String r7, String r8, SearchQABizType r9, Long r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mslash_command_type = r2;
        this.mapp_link = r3;
        this.mtag = Internal.immutableCopyOf("mtag", r4);
        this.mextra = r5;
        this.mimage_url = r6;
        this.mdescription = r7;
        this.mdata_source_id = r8;
        this.msearch_qa_biz_type = r9;
        this.mrender_time_stamp = r10;
    }
}
