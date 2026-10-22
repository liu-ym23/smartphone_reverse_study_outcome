package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RichTextElements extends com.squareup.wire.Message<RichTextElements, Builder> {
    public static final ProtoAdapter<RichTextElements> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, RichTextElement> mdictionary;
    public final Map<String, RichTextElementStyleRefs> mstyle_refs;
    public final List<RichTextStyle> mstyles;

    public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElements, Builder> {
        public Map<String, RichTextElement> mdictionary;
        public Map<String, RichTextElementStyleRefs> mstyle_refs;
        public List<RichTextStyle> mstyles;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RichTextElements m1526build() {
            return new RichTextElements(this.mdictionary, this.mstyle_refs, this.mstyles, super.buildUnknownFields());
        }

        public Builder() {
            this.mdictionary = Internal.newMutableMap();
            this.mstyle_refs = Internal.newMutableMap();
            this.mstyles = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1526build();
        }

        public Builder dictionary(Map<String, RichTextElement> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdictionary = r1;
            return this;
        }

        public Builder style_refs(Map<String, RichTextElementStyleRefs> r1) {
            Internal.checkElementsNotNull(r1);
            this.mstyle_refs = r1;
            return this;
        }

        public Builder styles(List<RichTextStyle> r1) {
            Internal.checkElementsNotNull(r1);
            this.mstyles = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RichTextElements extends ProtoAdapter<RichTextElements> {
        private final ProtoAdapter<Map<String, RichTextElement>> mdictionary;
        private final ProtoAdapter<Map<String, RichTextElementStyleRefs>> mstyle_refs;

        public ProtoAdapter_RichTextElements() {
            super(FieldEncoding.LENGTH_DELIMITED, RichTextElements.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mdictionary = ProtoAdapter.newMapAdapter(r0, RichTextElement.ADAPTER);
            this.mstyle_refs = ProtoAdapter.newMapAdapter(r0, RichTextElementStyleRefs.ADAPTER);
        }

        public RichTextElements decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mdictionary.putAll((Map) this.mdictionary.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mstyle_refs.putAll((Map) this.mstyle_refs.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mstyles.add((RichTextStyle) RichTextStyle.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1526build();
        }

        public int encodedSize(RichTextElements r5) {
            return ((this.mdictionary.encodedSizeWithTag(1, r5.mdictionary) + this.mstyle_refs.encodedSizeWithTag(2, r5.mstyle_refs)) + RichTextStyle.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mstyles)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1527decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RichTextElements) r1);
        }

        public void encode(ProtoWriter r4, RichTextElements r5) throws IOException {
            this.mdictionary.encodeWithTag(r4, 1, r5.mdictionary);
            this.mstyle_refs.encodeWithTag(r4, 2, r5.mstyle_refs);
            RichTextStyle.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mstyles);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RichTextElements) r2);
        }
    }

    public static final class RichTextElementStyleRefs extends com.squareup.wire.Message<RichTextElementStyleRefs, Builder> {
        public static final ProtoAdapter<RichTextElementStyleRefs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Integer> mstyle_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextElementStyleRefs, Builder> {
            public List<Integer> mstyle_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RichTextElementStyleRefs m1529build() {
                return new RichTextElementStyleRefs(this.mstyle_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mstyle_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1529build();
            }

            public Builder style_ids(List<Integer> r1) {
                Internal.checkElementsNotNull(r1);
                this.mstyle_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextElementStyleRefs extends ProtoAdapter<RichTextElementStyleRefs> {
            public ProtoAdapter_RichTextElementStyleRefs() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextElementStyleRefs.class);
            }

            public RichTextElementStyleRefs decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mstyle_ids.add((Integer) ProtoAdapter.INT32.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1529build();
            }

            public int encodedSize(RichTextElementStyleRefs r4) {
                return ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, r4.mstyle_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1530decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RichTextElementStyleRefs) r1);
            }

            public void encode(ProtoWriter r4, RichTextElementStyleRefs r5) throws IOException {
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 1, r5.mstyle_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RichTextElementStyleRefs) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextElementStyleRefs();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1528newBuilder() {
            Builder r0 = new Builder();
            r0.mstyle_ids = Internal.copyOf("mstyle_ids", this.mstyle_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RichTextElementStyleRefs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1528newBuilder();
        }

        public RichTextElementStyleRefs(List<Integer> r2) {
            this(r2, ByteString.EMPTY);
        }

        public RichTextElementStyleRefs(List<Integer> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mstyle_ids = Internal.immutableCopyOf("mstyle_ids", r2);
        }
    }

    public static final class RichTextStyle extends com.squareup.wire.Message<RichTextStyle, Builder> {
        public static final ProtoAdapter<RichTextStyle> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;
        public final String mname;
        public final String mvalue;

        public static final class Builder extends com.squareup.wire.Message.Builder<RichTextStyle, Builder> {
            public String mname;
            public String mvalue;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RichTextStyle m1532build() {
                return new RichTextStyle(this.mname, this.mvalue, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1532build();
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }

            public Builder value(String r1) {
                this.mvalue = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RichTextStyle extends ProtoAdapter<RichTextStyle> {
            public ProtoAdapter_RichTextStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, RichTextStyle.class);
            }

            public RichTextStyle decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mname = "";
                r0.mvalue = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mname = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mvalue = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1532build();
            }

            public int encodedSize(RichTextStyle r5) {
                String r0 = r5.mname;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mvalue;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1533decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RichTextStyle) r1);
            }

            public void encode(ProtoWriter r4, RichTextStyle r5) throws IOException {
                String r0 = r5.mname;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mvalue;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RichTextStyle) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RichTextStyle();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1531newBuilder() {
            Builder r0 = new Builder();
            r0.mname = this.mname;
            r0.mvalue = this.mvalue;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RichTextStyle.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1531newBuilder();
        }

        public RichTextStyle(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public RichTextStyle(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mname = r2;
            this.mvalue = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RichTextElements();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1525newBuilder() {
        Builder r0 = new Builder();
        r0.mdictionary = Internal.copyOf("mdictionary", this.mdictionary);
        r0.mstyle_refs = Internal.copyOf("mstyle_refs", this.mstyle_refs);
        r0.mstyles = Internal.copyOf("mstyles", this.mstyles);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RichTextElements.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1525newBuilder();
    }

    public RichTextElements(Map<String, RichTextElement> r2, Map<String, RichTextElementStyleRefs> r3, List<RichTextStyle> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public RichTextElements(Map<String, RichTextElement> r2, Map<String, RichTextElementStyleRefs> r3, List<RichTextStyle> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mdictionary = Internal.immutableCopyOf("mdictionary", r2);
        this.mstyle_refs = Internal.immutableCopyOf("mstyle_refs", r3);
        this.mstyles = Internal.immutableCopyOf("mstyles", r4);
    }
}
