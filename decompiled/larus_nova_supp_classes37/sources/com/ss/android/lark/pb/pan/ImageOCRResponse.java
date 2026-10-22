package com.ss.android.lark.pb.pan;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageOCRResponse extends Message<ImageOCRResponse, Builder> {
    public static final ProtoAdapter<ImageOCRResponse> ADAPTER = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer mheight;
    public final List<Line> mlines;
    public final List<Region> mregions;
    public final Map<Integer, Entities> mtype_to_entities;
    public final Integer mwidth;

    public static final class Builder extends Message.Builder<ImageOCRResponse, Builder> {
        public Integer mheight;
        public List<Line> mlines;
        public List<Region> mregions;
        public Map<Integer, Entities> mtype_to_entities;
        public Integer mwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageOCRResponse m2051build() {
            Integer r0 = this.mwidth;
            if (r0 == null) goto L9;
            if (this.mheight == null) goto L9;
            return new ImageOCRResponse(this.mlines, this.mregions, this.mtype_to_entities, this.mwidth, this.mheight, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mwidth", this.mheight, "mheight"});
        }

        public Builder() {
            this.mlines = Internal.newMutableList();
            this.mregions = Internal.newMutableList();
            this.mtype_to_entities = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2051build();
        }

        public Builder height(Integer r1) {
            this.mheight = r1;
            return this;
        }

        public Builder lines(List<Line> r1) {
            Internal.checkElementsNotNull(r1);
            this.mlines = r1;
            return this;
        }

        public Builder regions(List<Region> r1) {
            Internal.checkElementsNotNull(r1);
            this.mregions = r1;
            return this;
        }

        public Builder type_to_entities(Map<Integer, Entities> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtype_to_entities = r1;
            return this;
        }

        public Builder width(Integer r1) {
            this.mwidth = r1;
            return this;
        }
    }

    public static final class Entities extends Message<Entities, Builder> {
        public static final ProtoAdapter<Entities> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Entity> mlist;

        public static final class Builder extends Message.Builder<Entities, Builder> {
            public List<Entity> mlist;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Entities m2053build() {
                return new Entities(this.mlist, super.buildUnknownFields());
            }

            public Builder() {
                this.mlist = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2053build();
            }

            public Builder list(List<Entity> r1) {
                Internal.checkElementsNotNull(r1);
                this.mlist = r1;
                return this;
            }
        }

        public static final class Entity extends Message<Entity, Builder> {
            public static final ProtoAdapter<Entity> ADAPTER = null;
            public static final Integer DEFAULT_REGION_ID = null;
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final Map<String, String> mentity_ext;
            public final List<LineMsg> mline_msgs;
            public final Integer mregion_id;
            public final Range mregion_range;
            public final String mtext;

            public static final class Builder extends Message.Builder<Entity, Builder> {
                public Map<String, String> mentity_ext;
                public List<LineMsg> mline_msgs;
                public Integer mregion_id;
                public Range mregion_range;
                public String mtext;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Entity m2055build() {
                    String r0 = this.mtext;
                    if (r0 == null) goto L11;
                    if (this.mregion_id == null) goto L11;
                    if (this.mregion_range == null) goto L11;
                    return new Entity(this.mtext, this.mregion_id, this.mregion_range, this.mline_msgs, this.mentity_ext, super.buildUnknownFields());
                L11:
                    throw Internal.missingRequiredFields(new Object[]{r0, "mtext", this.mregion_id, "mregion_id", this.mregion_range, "mregion_range"});
                }

                public Builder() {
                    this.mline_msgs = Internal.newMutableList();
                    this.mentity_ext = Internal.newMutableMap();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2055build();
                }

                public Builder entity_ext(Map<String, String> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mentity_ext = r1;
                    return this;
                }

                public Builder line_msgs(List<LineMsg> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mline_msgs = r1;
                    return this;
                }

                public Builder region_id(Integer r1) {
                    this.mregion_id = r1;
                    return this;
                }

                public Builder region_range(Range r1) {
                    this.mregion_range = r1;
                    return this;
                }

                public Builder text(String r1) {
                    this.mtext = r1;
                    return this;
                }
            }

            public static final class LineMsg extends Message<LineMsg, Builder> {
                public static final ProtoAdapter<LineMsg> ADAPTER = null;
                public static final Integer DEFAULT_LINE_ID = null;
                private static final long serialVersionUID = 0;
                public final Integer mline_id;
                public final Range mline_range;

                public static final class Builder extends Message.Builder<LineMsg, Builder> {
                    public Integer mline_id;
                    public Range mline_range;

                    /* JADX INFO: renamed from: build, reason: collision with other method in class */
                    public LineMsg m2057build() {
                        Integer r0 = this.mline_id;
                        if (r0 == null) goto L9;
                        if (this.mline_range == null) goto L9;
                        return new LineMsg(this.mline_id, this.mline_range, super.buildUnknownFields());
                    L9:
                        throw Internal.missingRequiredFields(new Object[]{r0, "mline_id", this.mline_range, "mline_range"});
                    }

                    public Builder() {
                    }

                    public /* bridge */ /* synthetic */ Message build() {
                        return m2057build();
                    }

                    public Builder line_id(Integer r1) {
                        this.mline_id = r1;
                        return this;
                    }

                    public Builder line_range(Range r1) {
                        this.mline_range = r1;
                        return this;
                    }
                }

                public static final class ProtoAdapter_LineMsg extends ProtoAdapter<LineMsg> {
                    public ProtoAdapter_LineMsg() {
                        super(FieldEncoding.LENGTH_DELIMITED, LineMsg.class);
                    }

                    public LineMsg decode(ProtoReader r7) throws IOException {
                        Builder r0 = new Builder();
                        r0.mline_id = 0;
                        long r1 = r7.beginMessage();
                    L3:
                        int r3 = r7.nextTag();
                        if (r3 == (-1)) goto L12;
                        if (r3 != 1) goto L8;
                        r0.mline_id = (Integer) ProtoAdapter.INT32.decode(r7);
                        goto L3
                    L8:
                        if (r3 != 2) goto L9;
                        r0.mline_range = (Range) Range.ADAPTER.decode(r7);
                        goto L3
                    L9:
                        FieldEncoding r4 = r7.peekFieldEncoding();
                        r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                        goto L3
                    L12:
                        r7.endMessage(r1);
                        return r0.m2057build();
                    }

                    public int encodedSize(LineMsg r5) {
                        return (ProtoAdapter.INT32.encodedSizeWithTag(1, r5.mline_id) + Range.ADAPTER.encodedSizeWithTag(2, r5.mline_range)) + r5.unknownFields().size();
                    }

                    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                    public /* bridge */ /* synthetic */ Object m2058decode(ProtoReader r1) throws IOException {
                        return decode(r1);
                    }

                    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                        return encodedSize((LineMsg) r1);
                    }

                    public void encode(ProtoWriter r4, LineMsg r5) throws IOException {
                        ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.mline_id);
                        Range.ADAPTER.encodeWithTag(r4, 2, r5.mline_range);
                        r4.writeBytes(r5.unknownFields());
                    }

                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                        encode(r1, (LineMsg) r2);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_LineMsg();
                    DEFAULT_LINE_ID = 0;
                }

                /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
                public Builder m2056newBuilder() {
                    Builder r0 = new Builder();
                    r0.mline_id = this.mline_id;
                    r0.mline_range = this.mline_range;
                    r0.addUnknownFields(unknownFields());
                    return r0;
                }

                public String toString() {
                    return LineMsg.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return m2056newBuilder();
                }

                public LineMsg(Integer r2, Range r3) {
                    this(r2, r3, ByteString.EMPTY);
                }

                public LineMsg(Integer r2, Range r3, ByteString r4) {
                    super(ADAPTER, r4);
                    this.mline_id = r2;
                    this.mline_range = r3;
                }
            }

            public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> {
                private final ProtoAdapter<Map<String, String>> mentity_ext;

                public ProtoAdapter_Entity() {
                    super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    this.mentity_ext = ProtoAdapter.newMapAdapter(r0, r0);
                }

                public Entity decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mtext = "";
                    r0.mregion_id = 0;
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L21;
                    if (r3 != 1) goto L8;
                    r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mregion_id = (Integer) ProtoAdapter.INT32.decode(r7);
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.mregion_range = (Range) Range.ADAPTER.decode(r7);
                    goto L3
                L12:
                    if (r3 != 4) goto L14;
                    r0.mline_msgs.add((LineMsg) LineMsg.ADAPTER.decode(r7));
                    goto L3
                L14:
                    if (r3 != 5) goto L15;
                    r0.mentity_ext.putAll((Map) this.mentity_ext.decode(r7));
                    goto L3
                L15:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L21:
                    r7.endMessage(r1);
                    return r0.m2055build();
                }

                public int encodedSize(Entity r5) {
                    return ((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mtext) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.mregion_id)) + Range.ADAPTER.encodedSizeWithTag(3, r5.mregion_range)) + LineMsg.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mline_msgs)) + this.mentity_ext.encodedSizeWithTag(5, r5.mentity_ext)) + r5.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2059decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Entity) r1);
                }

                public void encode(ProtoWriter r4, Entity r5) throws IOException {
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mtext);
                    ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.mregion_id);
                    Range.ADAPTER.encodeWithTag(r4, 3, r5.mregion_range);
                    LineMsg.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mline_msgs);
                    this.mentity_ext.encodeWithTag(r4, 5, r5.mentity_ext);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Entity) r2);
                }
            }

            public static final class Range extends Message<Range, Builder> {
                public static final ProtoAdapter<Range> ADAPTER = null;
                public static final Integer DEFAULT_END = null;
                public static final Integer DEFAULT_START = null;
                private static final long serialVersionUID = 0;
                public final Integer mend;
                public final Integer mstart;

                public static final class Builder extends Message.Builder<Range, Builder> {
                    public Integer mend;
                    public Integer mstart;

                    /* JADX INFO: renamed from: build, reason: collision with other method in class */
                    public Range m2061build() {
                        Integer r0 = this.mstart;
                        if (r0 == null) goto L9;
                        if (this.mend == null) goto L9;
                        return new Range(this.mstart, this.mend, super.buildUnknownFields());
                    L9:
                        throw Internal.missingRequiredFields(new Object[]{r0, "mstart", this.mend, "mend"});
                    }

                    public Builder() {
                    }

                    public /* bridge */ /* synthetic */ Message build() {
                        return m2061build();
                    }

                    public Builder end(Integer r1) {
                        this.mend = r1;
                        return this;
                    }

                    public Builder start(Integer r1) {
                        this.mstart = r1;
                        return this;
                    }
                }

                public static final class ProtoAdapter_Range extends ProtoAdapter<Range> {
                    public ProtoAdapter_Range() {
                        super(FieldEncoding.LENGTH_DELIMITED, Range.class);
                    }

                    public Range decode(ProtoReader r7) throws IOException {
                        Builder r0 = new Builder();
                        r0.mstart = 0;
                        r0.mend = 0;
                        long r1 = r7.beginMessage();
                    L3:
                        int r3 = r7.nextTag();
                        if (r3 == (-1)) goto L12;
                        if (r3 != 1) goto L8;
                        r0.mstart = (Integer) ProtoAdapter.UINT32.decode(r7);
                        goto L3
                    L8:
                        if (r3 != 2) goto L9;
                        r0.mend = (Integer) ProtoAdapter.UINT32.decode(r7);
                        goto L3
                    L9:
                        FieldEncoding r4 = r7.peekFieldEncoding();
                        r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                        goto L3
                    L12:
                        r7.endMessage(r1);
                        return r0.m2061build();
                    }

                    public int encodedSize(Range r5) {
                        ProtoAdapter r0 = ProtoAdapter.UINT32;
                        return (r0.encodedSizeWithTag(1, r5.mstart) + r0.encodedSizeWithTag(2, r5.mend)) + r5.unknownFields().size();
                    }

                    /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                    public /* bridge */ /* synthetic */ Object m2062decode(ProtoReader r1) throws IOException {
                        return decode(r1);
                    }

                    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                        return encodedSize((Range) r1);
                    }

                    public void encode(ProtoWriter r4, Range r5) throws IOException {
                        ProtoAdapter r0 = ProtoAdapter.UINT32;
                        r0.encodeWithTag(r4, 1, r5.mstart);
                        r0.encodeWithTag(r4, 2, r5.mend);
                        r4.writeBytes(r5.unknownFields());
                    }

                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                        encode(r1, (Range) r2);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_Range();
                    DEFAULT_START = 0;
                    DEFAULT_END = 0;
                }

                /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
                public Builder m2060newBuilder() {
                    Builder r0 = new Builder();
                    r0.mstart = this.mstart;
                    r0.mend = this.mend;
                    r0.addUnknownFields(unknownFields());
                    return r0;
                }

                public String toString() {
                    return Range.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return m2060newBuilder();
                }

                public Range(Integer r2, Integer r3) {
                    this(r2, r3, ByteString.EMPTY);
                }

                public Range(Integer r2, Integer r3, ByteString r4) {
                    super(ADAPTER, r4);
                    this.mstart = r2;
                    this.mend = r3;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Entity();
                DEFAULT_REGION_ID = 0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2054newBuilder() {
                Builder r0 = new Builder();
                r0.mtext = this.mtext;
                r0.mregion_id = this.mregion_id;
                r0.mregion_range = this.mregion_range;
                r0.mline_msgs = Internal.copyOf("mline_msgs", this.mline_msgs);
                r0.mentity_ext = Internal.copyOf("mentity_ext", this.mentity_ext);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2054newBuilder();
            }

            public Entity(String r8, Integer r9, Range r10, List<LineMsg> r11, Map<String, String> r12) {
                this(r8, r9, r10, r11, r12, ByteString.EMPTY);
            }

            public Entity(String r2, Integer r3, Range r4, List<LineMsg> r5, Map<String, String> r6, ByteString r7) {
                super(ADAPTER, r7);
                this.mtext = r2;
                this.mregion_id = r3;
                this.mregion_range = r4;
                this.mline_msgs = Internal.immutableCopyOf("mline_msgs", r5);
                this.mentity_ext = Internal.immutableCopyOf("mentity_ext", r6);
            }
        }

        public static final class ProtoAdapter_Entities extends ProtoAdapter<Entities> {
            public ProtoAdapter_Entities() {
                super(FieldEncoding.LENGTH_DELIMITED, Entities.class);
            }

            public Entities decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mlist.add((Entity) Entity.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2053build();
            }

            public int encodedSize(Entities r4) {
                return Entity.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mlist) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2063decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Entities) r1);
            }

            public void encode(ProtoWriter r4, Entities r5) throws IOException {
                Entity.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mlist);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Entities) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Entities();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2052newBuilder() {
            Builder r0 = new Builder();
            r0.mlist = Internal.copyOf("mlist", this.mlist);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Entities.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2052newBuilder();
        }

        public Entities(List<Entity> r2) {
            this(r2, ByteString.EMPTY);
        }

        public Entities(List<Entity> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mlist = Internal.immutableCopyOf("mlist", r2);
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType PHONE = null;
        public static final EntityType UNKNOWN = null;
        public static final EntityType URL = null;
        private final int value;

        static {
            EntityType r0 = new EntityType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            EntityType r1 = new EntityType("PHONE", 1, 1);
            PHONE = r1;
            EntityType r3 = new EntityType("URL", 2, 2);
            URL = r3;
            $VALUES = new EntityType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return URL;
        L12:
            return PHONE;
        L14:
            return UNKNOWN;
        }

        public static EntityType valueOf(String r1) {
            return (EntityType) a.a(EntityType.class, r1);
        }

        private EntityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Line extends Message<Line, Builder> {
        public static final ProtoAdapter<Line> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Rect mrect;
        public final String mtext;

        public static final class Builder extends Message.Builder<Line, Builder> {
            public Rect mrect;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Line m2065build() {
                Rect r0 = this.mrect;
                if (r0 == null) goto L9;
                if (this.mtext == null) goto L9;
                return new Line(this.mrect, this.mtext, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mrect", this.mtext, "mtext"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2065build();
            }

            public Builder rect(Rect r1) {
                this.mrect = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Line extends ProtoAdapter<Line> {
            public ProtoAdapter_Line() {
                super(FieldEncoding.LENGTH_DELIMITED, Line.class);
            }

            public Line decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mrect = (Rect) Rect.ADAPTER.decode(r7);
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
                return r0.m2065build();
            }

            public int encodedSize(Line r5) {
                return (Rect.ADAPTER.encodedSizeWithTag(1, r5.mrect) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.mtext)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2066decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Line) r1);
            }

            public void encode(ProtoWriter r4, Line r5) throws IOException {
                Rect.ADAPTER.encodeWithTag(r4, 1, r5.mrect);
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.mtext);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Line) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Line();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2064newBuilder() {
            Builder r0 = new Builder();
            r0.mrect = this.mrect;
            r0.mtext = this.mtext;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Line.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2064newBuilder();
        }

        public Line(Rect r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Line(Rect r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mrect = r2;
            this.mtext = r3;
        }
    }

    public static final class ProtoAdapter_ImageOCRResponse extends ProtoAdapter<ImageOCRResponse> {
        private final ProtoAdapter<Map<Integer, Entities>> mtype_to_entities;

        public ProtoAdapter_ImageOCRResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageOCRResponse.class);
            this.mtype_to_entities = ProtoAdapter.newMapAdapter(ProtoAdapter.UINT32, Entities.ADAPTER);
        }

        public ImageOCRResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mwidth = 0;
            r0.mheight = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mlines.add((Line) Line.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mregions.add((Region) Region.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtype_to_entities.putAll((Map) this.mtype_to_entities.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mwidth = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mheight = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2051build();
        }

        public int encodedSize(ImageOCRResponse r5) {
            int r0 = (Line.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mlines) + Region.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mregions)) + this.mtype_to_entities.encodedSizeWithTag(3, r5.mtype_to_entities);
            ProtoAdapter r1 = ProtoAdapter.UINT32;
            return ((r0 + r1.encodedSizeWithTag(4, r5.mwidth)) + r1.encodedSizeWithTag(5, r5.mheight)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2067decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageOCRResponse) r1);
        }

        public void encode(ProtoWriter r4, ImageOCRResponse r5) throws IOException {
            Line.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mlines);
            Region.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mregions);
            this.mtype_to_entities.encodeWithTag(r4, 3, r5.mtype_to_entities);
            ProtoAdapter r0 = ProtoAdapter.UINT32;
            r0.encodeWithTag(r4, 4, r5.mwidth);
            r0.encodeWithTag(r4, 5, r5.mheight);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageOCRResponse) r2);
        }
    }

    public static final class Rect extends Message<Rect, Builder> {
        public static final ProtoAdapter<Rect> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Point> mpoints;

        public static final class Builder extends Message.Builder<Rect, Builder> {
            public List<Point> mpoints;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Rect m2069build() {
                return new Rect(this.mpoints, super.buildUnknownFields());
            }

            public Builder() {
                this.mpoints = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2069build();
            }

            public Builder points(List<Point> r1) {
                Internal.checkElementsNotNull(r1);
                this.mpoints = r1;
                return this;
            }
        }

        public static final class Point extends Message<Point, Builder> {
            public static final ProtoAdapter<Point> ADAPTER = null;
            public static final Integer DEFAULT_X = null;
            public static final Integer DEFAULT_Y = null;
            private static final long serialVersionUID = 0;
            public final Integer mx;
            public final Integer my;

            public static final class Builder extends Message.Builder<Point, Builder> {
                public Integer mx;
                public Integer my;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Point m2071build() {
                    Integer r0 = this.mx;
                    if (r0 == null) goto L9;
                    if (this.my == null) goto L9;
                    return new Point(this.mx, this.my, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r0, "mx", this.my, "my"});
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2071build();
                }

                public Builder x(Integer r1) {
                    this.mx = r1;
                    return this;
                }

                public Builder y(Integer r1) {
                    this.my = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
                public ProtoAdapter_Point() {
                    super(FieldEncoding.LENGTH_DELIMITED, Point.class);
                }

                public Point decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mx = 0;
                    r0.my = 0;
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.mx = (Integer) ProtoAdapter.UINT32.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.my = (Integer) ProtoAdapter.UINT32.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m2071build();
                }

                public int encodedSize(Point r5) {
                    ProtoAdapter r0 = ProtoAdapter.UINT32;
                    return (r0.encodedSizeWithTag(1, r5.mx) + r0.encodedSizeWithTag(2, r5.my)) + r5.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2072decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Point) r1);
                }

                public void encode(ProtoWriter r4, Point r5) throws IOException {
                    ProtoAdapter r0 = ProtoAdapter.UINT32;
                    r0.encodeWithTag(r4, 1, r5.mx);
                    r0.encodeWithTag(r4, 2, r5.my);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Point) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Point();
                DEFAULT_X = 0;
                DEFAULT_Y = 0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2070newBuilder() {
                Builder r0 = new Builder();
                r0.mx = this.mx;
                r0.my = this.my;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Point.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2070newBuilder();
            }

            public Point(Integer r2, Integer r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public Point(Integer r2, Integer r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mx = r2;
                this.my = r3;
            }
        }

        public static final class ProtoAdapter_Rect extends ProtoAdapter<Rect> {
            public ProtoAdapter_Rect() {
                super(FieldEncoding.LENGTH_DELIMITED, Rect.class);
            }

            public Rect decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mpoints.add((Point) Point.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2069build();
            }

            public int encodedSize(Rect r4) {
                return Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mpoints) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2073decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Rect) r1);
            }

            public void encode(ProtoWriter r4, Rect r5) throws IOException {
                Point.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mpoints);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Rect) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Rect();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2068newBuilder() {
            Builder r0 = new Builder();
            r0.mpoints = Internal.copyOf("mpoints", this.mpoints);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Rect.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2068newBuilder();
        }

        public Rect(List<Point> r2) {
            this(r2, ByteString.EMPTY);
        }

        public Rect(List<Point> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mpoints = Internal.immutableCopyOf("mpoints", r2);
        }
    }

    public static final class Region extends Message<Region, Builder> {
        public static final ProtoAdapter<Region> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final List<Integer> mline_ids;
        public final String mtext;

        public static final class Builder extends Message.Builder<Region, Builder> {
            public List<Integer> mline_ids;
            public String mtext;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Region m2075build() {
                String r0 = this.mtext;
                if (r0 == null) goto L7;
                return new Region(this.mtext, this.mline_ids, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mtext"});
            }

            public Builder() {
                this.mline_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2075build();
            }

            public Builder line_ids(List<Integer> r1) {
                Internal.checkElementsNotNull(r1);
                this.mline_ids = r1;
                return this;
            }

            public Builder text(String r1) {
                this.mtext = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Region extends ProtoAdapter<Region> {
            public ProtoAdapter_Region() {
                super(FieldEncoding.LENGTH_DELIMITED, Region.class);
            }

            public Region decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mtext = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mline_ids.add((Integer) ProtoAdapter.UINT32.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2075build();
            }

            public int encodedSize(Region r5) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mtext) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(2, r5.mline_ids)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2076decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Region) r1);
            }

            public void encode(ProtoWriter r4, Region r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mtext);
                ProtoAdapter.UINT32.asRepeated().encodeWithTag(r4, 2, r5.mline_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Region) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Region();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2074newBuilder() {
            Builder r0 = new Builder();
            r0.mtext = this.mtext;
            r0.mline_ids = Internal.copyOf("mline_ids", this.mline_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Region.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2074newBuilder();
        }

        public Region(String r2, List<Integer> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public Region(String r2, List<Integer> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtext = r2;
            this.mline_ids = Internal.immutableCopyOf("mline_ids", r3);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageOCRResponse();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2050newBuilder() {
        Builder r0 = new Builder();
        r0.mlines = Internal.copyOf("mlines", this.mlines);
        r0.mregions = Internal.copyOf("mregions", this.mregions);
        r0.mtype_to_entities = Internal.copyOf("mtype_to_entities", this.mtype_to_entities);
        r0.mwidth = this.mwidth;
        r0.mheight = this.mheight;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageOCRResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2050newBuilder();
    }

    public ImageOCRResponse(List<Line> r8, List<Region> r9, Map<Integer, Entities> r10, Integer r11, Integer r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public ImageOCRResponse(List<Line> r2, List<Region> r3, Map<Integer, Entities> r4, Integer r5, Integer r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mlines = Internal.immutableCopyOf("mlines", r2);
        this.mregions = Internal.immutableCopyOf("mregions", r3);
        this.mtype_to_entities = Internal.immutableCopyOf("mtype_to_entities", r4);
        this.mwidth = r5;
        this.mheight = r6;
    }
}
