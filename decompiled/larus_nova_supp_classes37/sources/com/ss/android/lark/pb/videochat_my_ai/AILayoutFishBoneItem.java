package com.ss.android.lark.pb.videochat_my_ai;

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
public final class AILayoutFishBoneItem extends Message<AILayoutFishBoneItem, Builder> {
    public static final ProtoAdapter<AILayoutFishBoneItem> ADAPTER = null;
    public static final Long DEFAULT_BEGIN_TIME_MS = null;
    public static final Long DEFAULT_END_TIME_MS = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final Long mbegin_time_ms;
    public final Chart mchart;
    public final List<AILayoutFishBoneItem> mchildren;
    public final Long mend_time_ms;
    public final String mid;
    public final ItemType mitem_type;
    public final Text mtext;

    public static final class Builder extends Message.Builder<AILayoutFishBoneItem, Builder> {
        public Long mbegin_time_ms;
        public Chart mchart;
        public List<AILayoutFishBoneItem> mchildren;
        public Long mend_time_ms;
        public String mid;
        public ItemType mitem_type;
        public Text mtext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AILayoutFishBoneItem m3218build() {
            return new AILayoutFishBoneItem(this.mitem_type, this.mchildren, this.mbegin_time_ms, this.mend_time_ms, this.mtext, this.mchart, this.mid, super.buildUnknownFields());
        }

        public Builder() {
            this.mchildren = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3218build();
        }

        public Builder begin_time_ms(Long r1) {
            this.mbegin_time_ms = r1;
            return this;
        }

        public Builder chart(Chart r1) {
            this.mchart = r1;
            return this;
        }

        public Builder children(List<AILayoutFishBoneItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchildren = r1;
            return this;
        }

        public Builder end_time_ms(Long r1) {
            this.mend_time_ms = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder item_type(ItemType r1) {
            this.mitem_type = r1;
            return this;
        }

        public Builder text(Text r1) {
            this.mtext = r1;
            return this;
        }
    }

    public static final class Chart extends Message<Chart, Builder> {
        public static final ProtoAdapter<Chart> ADAPTER = null;
        public static final String DEFAULT_DATA = "";
        public static final String DEFAULT_DESCRIPTION = "";
        public static final Long DEFAULT_ID = null;
        public static final String DEFAULT_LANG = "";
        public static final String DEFAULT_TYPE = "";
        private static final long serialVersionUID = 0;
        public final String mdata;
        public final String mdescription;
        public final Long mid;
        public final String mlang;
        public final List<Long> msentence_ids;
        public final String mtype;

        public static final class Builder extends Message.Builder<Chart, Builder> {
            public String mdata;
            public String mdescription;
            public Long mid;
            public String mlang;
            public List<Long> msentence_ids;
            public String mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Chart m3220build() {
                return new Chart(this.mtype, this.mdescription, this.mdata, this.msentence_ids, this.mid, this.mlang, super.buildUnknownFields());
            }

            public Builder() {
                this.msentence_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3220build();
            }

            public Builder data(String r1) {
                this.mdata = r1;
                return this;
            }

            public Builder description(String r1) {
                this.mdescription = r1;
                return this;
            }

            public Builder id(Long r1) {
                this.mid = r1;
                return this;
            }

            public Builder lang(String r1) {
                this.mlang = r1;
                return this;
            }

            public Builder sentence_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.msentence_ids = r1;
                return this;
            }

            public Builder type(String r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Chart extends ProtoAdapter<Chart> {
            public ProtoAdapter_Chart() {
                super(FieldEncoding.LENGTH_DELIMITED, Chart.class);
            }

            public Chart decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtype = "";
                r0.mdescription = "";
                r0.mdata = "";
                r0.mid = 0L;
                r0.mlang = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L13;
                switch(r3) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mlang = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                r0.mid = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L9:
                r0.msentence_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L10:
                r0.mdata = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L11:
                r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L12:
                r0.mtype = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L13:
                r7.endMessage(r1);
                return r0.m3220build();
            }

            public int encodedSize(Chart r7) {
                String r0 = r7.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r7.mdescription;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r6 = r7.mdata;
                if (r6 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r6);
            L14:
                int r9 = r5 + r8;
                ProtoAdapter r10 = ProtoAdapter.INT64;
                int r11 = r9 + r10.asRepeated().encodedSizeWithTag(4, r7.msentence_ids);
                Long r12 = r7.mid;
                if (r12 == null) goto L17;
                int r13 = r10.encodedSizeWithTag(5, r12);
            L18:
                int r14 = r11 + r13;
                String r15 = r7.mlang;
                if (r15 == null) goto L22;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r15);
            L22:
                return (r14 + r1) + r7.unknownFields().size();
            L17:
                r13 = 0;
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
            public /* bridge */ /* synthetic */ Object m3221decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Chart) r1);
            }

            public void encode(ProtoWriter r5, Chart r6) throws IOException {
                String r0 = r6.mtype;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
            L5:
                String r1 = r6.mdescription;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
            L8:
                String r2 = r6.mdata;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r5, 3, r2);
            L11:
                ProtoAdapter r3 = ProtoAdapter.INT64;
                r3.asRepeated().encodeWithTag(r5, 4, r6.msentence_ids);
                Long r4 = r6.mid;
                if (r4 == null) goto L14;
                r3.encodeWithTag(r5, 5, r4);
            L14:
                String r7 = r6.mlang;
                if (r7 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r5, 6, r7);
            L17:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Chart) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Chart();
            DEFAULT_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3219newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mdescription = this.mdescription;
            r0.mdata = this.mdata;
            r0.msentence_ids = Internal.copyOf("msentence_ids", this.msentence_ids);
            r0.mid = this.mid;
            r0.mlang = this.mlang;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Chart.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3219newBuilder();
        }

        public Chart(String r9, String r10, String r11, List<Long> r12, Long r13, String r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public Chart(String r2, String r3, String r4, List<Long> r5, Long r6, String r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mtype = r2;
            this.mdescription = r3;
            this.mdata = r4;
            this.msentence_ids = Internal.immutableCopyOf("msentence_ids", r5);
            this.mid = r6;
            this.mlang = r7;
        }
    }

    public static final enum ItemType extends Enum<ItemType> implements WireEnum {
        private static final /* synthetic */ ItemType[] $VALUES = null;
        public static final ProtoAdapter<ItemType> ADAPTER = null;
        public static final ItemType TYPE_IMAGE = null;
        public static final ItemType TYPE_TEXT = null;
        public static final ItemType TYPE_UNKNOWN = null;
        private final int value;

        static {
            ItemType r0 = new ItemType("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r0;
            ItemType r1 = new ItemType("TYPE_TEXT", 1, 1);
            TYPE_TEXT = r1;
            ItemType r3 = new ItemType("TYPE_IMAGE", 2, 2);
            TYPE_IMAGE = r3;
            $VALUES = new ItemType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ItemType.class);
        }

        public static ItemType[] values() {
            return (ItemType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ItemType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return TYPE_IMAGE;
        L12:
            return TYPE_TEXT;
        L14:
            return TYPE_UNKNOWN;
        }

        public static ItemType valueOf(String r1) {
            return (ItemType) a.a(ItemType.class, r1);
        }

        private ItemType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_AILayoutFishBoneItem extends ProtoAdapter<AILayoutFishBoneItem> {
        public ProtoAdapter_AILayoutFishBoneItem() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutFishBoneItem.class);
        }

        public AILayoutFishBoneItem decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mbegin_time_ms = 0L;
            r0.mend_time_ms = 0L;
            r0.mid = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L25;
            if (r3 != 1) goto L8;
            r0.mitem_type = (ItemType) ItemType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchildren.add((AILayoutFishBoneItem) AILayoutFishBoneItem.ADAPTER.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mbegin_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mend_time_ms = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L13:
            switch(r3) {
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                default: goto L14;
            };
        L15:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mchart = (Chart) Chart.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mtext = (Text) Text.ADAPTER.decode(r9);
            goto L3
        L14:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L25:
            r9.endMessage(r1);
            return r0.m3218build();
        }

        public int encodedSize(AILayoutFishBoneItem r6) {
            ItemType r0 = r6.mitem_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ItemType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + AILayoutFishBoneItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r6.mchildren);
            Long r4 = r6.mbegin_time_ms;
            if (r4 == null) goto L9;
            int r5 = ProtoAdapter.INT64.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            Long r8 = r6.mend_time_ms;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.INT64.encodedSizeWithTag(4, r8);
        L14:
            int r10 = r7 + r9;
            Text r11 = r6.mtext;
            if (r11 == null) goto L17;
            int r12 = Text.ADAPTER.encodedSizeWithTag(11, r11);
        L18:
            int r13 = r10 + r12;
            Chart r14 = r6.mchart;
            if (r14 == null) goto L21;
            int r15 = Chart.ADAPTER.encodedSizeWithTag(12, r14);
        L22:
            int r16 = r13 + r15;
            String r17 = r6.mid;
            if (r17 == null) goto L26;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(13, r17);
        L26:
            return (r16 + r1) + r6.unknownFields().size();
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3222decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AILayoutFishBoneItem) r1);
        }

        public void encode(ProtoWriter r4, AILayoutFishBoneItem r5) throws IOException {
            ItemType r0 = r5.mitem_type;
            if (r0 == null) goto L5;
            ItemType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            AILayoutFishBoneItem.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mchildren);
            Long r1 = r5.mbegin_time_ms;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r1);
        L8:
            Long r2 = r5.mend_time_ms;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r2);
        L11:
            Text r3 = r5.mtext;
            if (r3 == null) goto L14;
            Text.ADAPTER.encodeWithTag(r4, 11, r3);
        L14:
            Chart r6 = r5.mchart;
            if (r6 == null) goto L17;
            Chart.ADAPTER.encodeWithTag(r4, 12, r6);
        L17:
            String r7 = r5.mid;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 13, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AILayoutFishBoneItem) r2);
        }
    }

    public static final class Text extends Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final List<Long> mchapter_ids;
        public final String mcontent;
        public final List<Long> msentence_ids;

        public static final class Builder extends Message.Builder<Text, Builder> {
            public List<Long> mchapter_ids;
            public String mcontent;
            public List<Long> msentence_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Text m3224build() {
                return new Text(this.mcontent, this.msentence_ids, this.mchapter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.msentence_ids = Internal.newMutableList();
                this.mchapter_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m3224build();
            }

            public Builder chapter_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchapter_ids = r1;
                return this;
            }

            public Builder content(String r1) {
                this.mcontent = r1;
                return this;
            }

            public Builder sentence_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.msentence_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Text extends ProtoAdapter<Text> {
            public ProtoAdapter_Text() {
                super(FieldEncoding.LENGTH_DELIMITED, Text.class);
            }

            public Text decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcontent = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mcontent = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.msentence_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mchapter_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m3224build();
            }

            public int encodedSize(Text r6) {
                String r0 = r6.mcontent;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                ProtoAdapter r2 = ProtoAdapter.INT64;
                return ((r1 + r2.asRepeated().encodedSizeWithTag(2, r6.msentence_ids)) + r2.asRepeated().encodedSizeWithTag(3, r6.mchapter_ids)) + r6.unknownFields().size();
            L5:
                r1 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m3225decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Text) r1);
            }

            public void encode(ProtoWriter r5, Text r6) throws IOException {
                String r0 = r6.mcontent;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
            L5:
                ProtoAdapter r1 = ProtoAdapter.INT64;
                r1.asRepeated().encodeWithTag(r5, 2, r6.msentence_ids);
                r1.asRepeated().encodeWithTag(r5, 3, r6.mchapter_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Text) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Text();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m3223newBuilder() {
            Builder r0 = new Builder();
            r0.mcontent = this.mcontent;
            r0.msentence_ids = Internal.copyOf("msentence_ids", this.msentence_ids);
            r0.mchapter_ids = Internal.copyOf("mchapter_ids", this.mchapter_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Text.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m3223newBuilder();
        }

        public Text(String r2, List<Long> r3, List<Long> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Text(String r2, List<Long> r3, List<Long> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mcontent = r2;
            this.msentence_ids = Internal.immutableCopyOf("msentence_ids", r3);
            this.mchapter_ids = Internal.immutableCopyOf("mchapter_ids", r4);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutFishBoneItem();
        DEFAULT_BEGIN_TIME_MS = 0L;
        DEFAULT_END_TIME_MS = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3217newBuilder() {
        Builder r0 = new Builder();
        r0.mitem_type = this.mitem_type;
        r0.mchildren = Internal.copyOf("mchildren", this.mchildren);
        r0.mbegin_time_ms = this.mbegin_time_ms;
        r0.mend_time_ms = this.mend_time_ms;
        r0.mtext = this.mtext;
        r0.mchart = this.mchart;
        r0.mid = this.mid;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AILayoutFishBoneItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3217newBuilder();
    }

    public AILayoutFishBoneItem(ItemType r10, List<AILayoutFishBoneItem> r11, Long r12, Long r13, Text r14, Chart r15, String r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public AILayoutFishBoneItem(ItemType r2, List<AILayoutFishBoneItem> r3, Long r4, Long r5, Text r6, Chart r7, String r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mitem_type = r2;
        this.mchildren = Internal.immutableCopyOf("mchildren", r3);
        this.mbegin_time_ms = r4;
        this.mend_time_ms = r5;
        this.mtext = r6;
        this.mchart = r7;
        this.mid = r8;
    }
}
