package com.ss.android.lark.pb.usearch;

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
public final class CapsuleInfo extends Message<CapsuleInfo, Builder> {
    public static final ProtoAdapter<CapsuleInfo> ADAPTER = null;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;
    public final CapsuleType mcapsule_type;
    public final List<SearchResult> mfilter_entities;
    public final SearchAction msearch_action;
    public final String mtitle;

    public static final class Builder extends Message.Builder<CapsuleInfo, Builder> {
        public CapsuleType mcapsule_type;
        public List<SearchResult> mfilter_entities;
        public SearchAction msearch_action;
        public String mtitle;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CapsuleInfo m2570build() {
            return new CapsuleInfo(this.mcapsule_type, this.msearch_action, this.mtitle, this.mfilter_entities, super.buildUnknownFields());
        }

        public Builder() {
            this.mfilter_entities = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2570build();
        }

        public Builder capsule_type(CapsuleType r1) {
            this.mcapsule_type = r1;
            return this;
        }

        public Builder filter_entities(List<SearchResult> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfilter_entities = r1;
            return this;
        }

        public Builder search_action(SearchAction r1) {
            this.msearch_action = r1;
            return this;
        }

        public Builder title(String r1) {
            this.mtitle = r1;
            return this;
        }
    }

    public static final enum CapsuleType extends Enum<CapsuleType> implements WireEnum {
        private static final /* synthetic */ CapsuleType[] $VALUES = null;
        public static final ProtoAdapter<CapsuleType> ADAPTER = null;
        public static final CapsuleType FILTER = null;
        public static final CapsuleType FILTER_VALUE = null;
        public static final CapsuleType TAB = null;
        public static final CapsuleType UNKNOWN = null;
        private final int value;

        static {
            CapsuleType r0 = new CapsuleType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CapsuleType r1 = new CapsuleType("TAB", 1, 1);
            TAB = r1;
            CapsuleType r3 = new CapsuleType("FILTER", 2, 2);
            FILTER = r3;
            CapsuleType r5 = new CapsuleType("FILTER_VALUE", 3, 3);
            FILTER_VALUE = r5;
            $VALUES = new CapsuleType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(CapsuleType.class);
        }

        public static CapsuleType[] values() {
            return (CapsuleType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CapsuleType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return FILTER_VALUE;
        L14:
            return FILTER;
        L16:
            return TAB;
        L18:
            return UNKNOWN;
        }

        public static CapsuleType valueOf(String r1) {
            return (CapsuleType) a.a(CapsuleType.class, r1);
        }

        private CapsuleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_CapsuleInfo extends ProtoAdapter<CapsuleInfo> {
        public ProtoAdapter_CapsuleInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CapsuleInfo.class);
        }

        public CapsuleInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtitle = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mcapsule_type = (CapsuleType) CapsuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msearch_action = (SearchAction) SearchAction.ADAPTER.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtitle = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mfilter_entities.add((SearchResult) SearchResult.ADAPTER.decode(r9));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2570build();
        }

        public int encodedSize(CapsuleInfo r6) {
            CapsuleType r0 = r6.mcapsule_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = CapsuleType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            SearchAction r3 = r6.msearch_action;
            if (r3 == null) goto L9;
            int r4 = SearchAction.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtitle;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return ((r5 + r1) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mfilter_entities)) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2571decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CapsuleInfo) r1);
        }

        public void encode(ProtoWriter r4, CapsuleInfo r5) throws IOException {
            CapsuleType r0 = r5.mcapsule_type;
            if (r0 == null) goto L5;
            CapsuleType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            SearchAction r1 = r5.msearch_action;
            if (r1 == null) goto L8;
            SearchAction.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtitle;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mfilter_entities);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CapsuleInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CapsuleInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2569newBuilder() {
        Builder r0 = new Builder();
        r0.mcapsule_type = this.mcapsule_type;
        r0.msearch_action = this.msearch_action;
        r0.mtitle = this.mtitle;
        r0.mfilter_entities = Internal.copyOf("mfilter_entities", this.mfilter_entities);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CapsuleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2569newBuilder();
    }

    public CapsuleInfo(CapsuleType r7, SearchAction r8, String r9, List<SearchResult> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public CapsuleInfo(CapsuleType r2, SearchAction r3, String r4, List<SearchResult> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mcapsule_type = r2;
        this.msearch_action = r3;
        this.mtitle = r4;
        this.mfilter_entities = Internal.immutableCopyOf("mfilter_entities", r5);
    }
}
