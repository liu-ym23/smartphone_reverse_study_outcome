package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TagData extends com.squareup.wire.Message<TagData, Builder> {
    public static final ProtoAdapter<TagData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TagDataItem> mtag_data_items;

    public static final class Builder extends com.squareup.wire.Message.Builder<TagData, Builder> {
        public List<TagDataItem> mtag_data_items;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TagData m1544build() {
            return new TagData(this.mtag_data_items, super.buildUnknownFields());
        }

        public Builder() {
            this.mtag_data_items = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1544build();
        }

        public Builder tag_data_items(List<TagDataItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtag_data_items = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TagData extends ProtoAdapter<TagData> {
        public ProtoAdapter_TagData() {
            super(FieldEncoding.LENGTH_DELIMITED, TagData.class);
        }

        public TagData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mtag_data_items.add((TagDataItem) TagDataItem.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1544build();
        }

        public int encodedSize(TagData r4) {
            return TagDataItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mtag_data_items) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1545decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TagData) r1);
        }

        public void encode(ProtoWriter r4, TagData r5) throws IOException {
            TagDataItem.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mtag_data_items);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TagData) r2);
        }
    }

    public static final class TagDataItem extends com.squareup.wire.Message<TagDataItem, Builder> {
        public static final ProtoAdapter<TagDataItem> ADAPTER = null;
        public static final Integer DEFAULT_PRIORITY = null;
        public static final String DEFAULT_TAG_ID = "";
        private static final long serialVersionUID = 0;
        public final Integer mpriority;
        public final RequestTagTypeEnum mreq_tag_type;
        public final ResponseTagTypeEnum mresp_tag_type;
        public final String mtag_id;
        public final I18nVal mtext_val;

        public static final class Builder extends com.squareup.wire.Message.Builder<TagDataItem, Builder> {
            public Integer mpriority;
            public RequestTagTypeEnum mreq_tag_type;
            public ResponseTagTypeEnum mresp_tag_type;
            public String mtag_id;
            public I18nVal mtext_val;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TagDataItem m1547build() {
                return new TagDataItem(this.mtext_val, this.mtag_id, this.mreq_tag_type, this.mresp_tag_type, this.mpriority, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1547build();
            }

            public Builder priority(Integer r1) {
                this.mpriority = r1;
                return this;
            }

            public Builder req_tag_type(RequestTagTypeEnum r1) {
                this.mreq_tag_type = r1;
                return this;
            }

            public Builder resp_tag_type(ResponseTagTypeEnum r1) {
                this.mresp_tag_type = r1;
                return this;
            }

            public Builder tag_id(String r1) {
                this.mtag_id = r1;
                return this;
            }

            public Builder text_val(I18nVal r1) {
                this.mtext_val = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TagDataItem extends ProtoAdapter<TagDataItem> {
            public ProtoAdapter_TagDataItem() {
                super(FieldEncoding.LENGTH_DELIMITED, TagDataItem.class);
            }

            public TagDataItem decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mtag_id = "";
                r0.mpriority = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L27;
                if (r3 != 1) goto L8;
                r0.mtext_val = (I18nVal) I18nVal.ADAPTER.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mtag_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mreq_tag_type = (RequestTagTypeEnum) RequestTagTypeEnum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.mresp_tag_type = (ResponseTagTypeEnum) ResponseTagTypeEnum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mpriority = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L15:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L27:
                r9.endMessage(r1);
                return r0.m1547build();
            }

            public int encodedSize(TagDataItem r6) {
                I18nVal r0 = r6.mtext_val;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = I18nVal.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mtag_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                RequestTagTypeEnum r7 = r6.mreq_tag_type;
                if (r7 == null) goto L13;
                int r8 = RequestTagTypeEnum.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                ResponseTagTypeEnum r10 = r6.mresp_tag_type;
                if (r10 == null) goto L17;
                int r11 = ResponseTagTypeEnum.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Integer r13 = r6.mpriority;
                if (r13 == null) goto L22;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
            L22:
                return (r12 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1548decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TagDataItem) r1);
            }

            public void encode(ProtoWriter r4, TagDataItem r5) throws IOException {
                I18nVal r0 = r5.mtext_val;
                if (r0 == null) goto L5;
                I18nVal.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mtag_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                RequestTagTypeEnum r2 = r5.mreq_tag_type;
                if (r2 == null) goto L11;
                RequestTagTypeEnum.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                ResponseTagTypeEnum r3 = r5.mresp_tag_type;
                if (r3 == null) goto L14;
                ResponseTagTypeEnum.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                Integer r6 = r5.mpriority;
                if (r6 == null) goto L17;
                ProtoAdapter.INT32.encodeWithTag(r4, 5, r6);
            L17:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TagDataItem) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TagDataItem();
            DEFAULT_PRIORITY = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1546newBuilder() {
            Builder r0 = new Builder();
            r0.mtext_val = this.mtext_val;
            r0.mtag_id = this.mtag_id;
            r0.mreq_tag_type = this.mreq_tag_type;
            r0.mresp_tag_type = this.mresp_tag_type;
            r0.mpriority = this.mpriority;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TagDataItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1546newBuilder();
        }

        public TagDataItem(I18nVal r8, String r9, RequestTagTypeEnum r10, ResponseTagTypeEnum r11, Integer r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public TagDataItem(I18nVal r2, String r3, RequestTagTypeEnum r4, ResponseTagTypeEnum r5, Integer r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mtext_val = r2;
            this.mtag_id = r3;
            this.mreq_tag_type = r4;
            this.mresp_tag_type = r5;
            this.mpriority = r6;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TagData();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1543newBuilder() {
        Builder r0 = new Builder();
        r0.mtag_data_items = Internal.copyOf("mtag_data_items", this.mtag_data_items);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TagData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1543newBuilder();
    }

    public TagData(List<TagDataItem> r2) {
        this(r2, ByteString.EMPTY);
    }

    public TagData(List<TagDataItem> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mtag_data_items = Internal.immutableCopyOf("mtag_data_items", r2);
    }
}
