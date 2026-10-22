package com.ss.android.lark.pb.hongbao;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.HongbaoCover;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullHongbaoCoverListResponse extends Message<PullHongbaoCoverListResponse, Builder> {
    public static final ProtoAdapter<PullHongbaoCoverListResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Category> mcategory_list;
    public final Map<Long, CoverList> mcovers;
    public final List<HongbaoCover> mrecommend_covers;

    public static final class Builder extends Message.Builder<PullHongbaoCoverListResponse, Builder> {
        public List<Category> mcategory_list;
        public Map<Long, CoverList> mcovers;
        public List<HongbaoCover> mrecommend_covers;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullHongbaoCoverListResponse m1745build() {
            return new PullHongbaoCoverListResponse(this.mcategory_list, this.mcovers, this.mrecommend_covers, super.buildUnknownFields());
        }

        public Builder() {
            this.mcategory_list = Internal.newMutableList();
            this.mcovers = Internal.newMutableMap();
            this.mrecommend_covers = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1745build();
        }

        public Builder category_list(List<Category> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcategory_list = r1;
            return this;
        }

        public Builder covers(Map<Long, CoverList> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcovers = r1;
            return this;
        }

        public Builder recommend_covers(List<HongbaoCover> r1) {
            Internal.checkElementsNotNull(r1);
            this.mrecommend_covers = r1;
            return this;
        }
    }

    public static final class Category extends Message<Category, Builder> {
        public static final ProtoAdapter<Category> ADAPTER = null;
        public static final Long DEFAULT_ID = null;
        public static final String DEFAULT_NAME = "";
        public static final Integer DEFAULT_ORDER = null;
        private static final long serialVersionUID = 0;
        public final Long mid;
        public final String mname;
        public final Integer morder;

        public static final class Builder extends Message.Builder<Category, Builder> {
            public Long mid;
            public String mname;
            public Integer morder;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Category m1747build() {
                return new Category(this.mid, this.mname, this.morder, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1747build();
            }

            public Builder id(Long r1) {
                this.mid = r1;
                return this;
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }

            public Builder order(Integer r1) {
                this.morder = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Category extends ProtoAdapter<Category> {
            public ProtoAdapter_Category() {
                super(FieldEncoding.LENGTH_DELIMITED, Category.class);
            }

            public Category decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mid = 0L;
                r0.mname = "";
                r0.morder = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mid = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mname = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.morder = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m1747build();
            }

            public int encodedSize(Category r6) {
                Long r0 = r6.mid;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mname;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Integer r7 = r6.morder;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1748decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Category) r1);
            }

            public void encode(ProtoWriter r4, Category r5) throws IOException {
                Long r0 = r5.mid;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mname;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Integer r2 = r5.morder;
                if (r2 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Category) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Category();
            DEFAULT_ID = 0L;
            DEFAULT_ORDER = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1746newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mname = this.mname;
            r0.morder = this.morder;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Category.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1746newBuilder();
        }

        public Category(Long r2, String r3, Integer r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Category(Long r2, String r3, Integer r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mid = r2;
            this.mname = r3;
            this.morder = r4;
        }
    }

    public static final class CoverList extends Message<CoverList, Builder> {
        public static final ProtoAdapter<CoverList> ADAPTER = null;
        public static final Long DEFAULT_CATEGORY_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mcategory_id;
        public final List<HongbaoCover> mcovers;

        public static final class Builder extends Message.Builder<CoverList, Builder> {
            public Long mcategory_id;
            public List<HongbaoCover> mcovers;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CoverList m1750build() {
                return new CoverList(this.mcategory_id, this.mcovers, super.buildUnknownFields());
            }

            public Builder() {
                this.mcovers = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1750build();
            }

            public Builder category_id(Long r1) {
                this.mcategory_id = r1;
                return this;
            }

            public Builder covers(List<HongbaoCover> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcovers = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CoverList extends ProtoAdapter<CoverList> {
            public ProtoAdapter_CoverList() {
                super(FieldEncoding.LENGTH_DELIMITED, CoverList.class);
            }

            public CoverList decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcategory_id = 0L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcategory_id = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mcovers.add((HongbaoCover) HongbaoCover.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1750build();
            }

            public int encodedSize(CoverList r5) {
                Long r0 = r5.mcategory_id;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + HongbaoCover.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mcovers)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1751decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CoverList) r1);
            }

            public void encode(ProtoWriter r4, CoverList r5) throws IOException {
                Long r0 = r5.mcategory_id;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                HongbaoCover.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mcovers);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CoverList) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CoverList();
            DEFAULT_CATEGORY_ID = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1749newBuilder() {
            Builder r0 = new Builder();
            r0.mcategory_id = this.mcategory_id;
            r0.mcovers = Internal.copyOf("mcovers", this.mcovers);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CoverList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1749newBuilder();
        }

        public CoverList(Long r2, List<HongbaoCover> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public CoverList(Long r2, List<HongbaoCover> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcategory_id = r2;
            this.mcovers = Internal.immutableCopyOf("mcovers", r3);
        }
    }

    public static final class ProtoAdapter_PullHongbaoCoverListResponse extends ProtoAdapter<PullHongbaoCoverListResponse> {
        private final ProtoAdapter<Map<Long, CoverList>> mcovers;

        public ProtoAdapter_PullHongbaoCoverListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullHongbaoCoverListResponse.class);
            this.mcovers = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, CoverList.ADAPTER);
        }

        public PullHongbaoCoverListResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mcategory_list.add((Category) Category.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcovers.putAll((Map) this.mcovers.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mrecommend_covers.add((HongbaoCover) HongbaoCover.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1745build();
        }

        public int encodedSize(PullHongbaoCoverListResponse r5) {
            return ((Category.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mcategory_list) + this.mcovers.encodedSizeWithTag(2, r5.mcovers)) + HongbaoCover.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mrecommend_covers)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1752decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullHongbaoCoverListResponse) r1);
        }

        public void encode(ProtoWriter r4, PullHongbaoCoverListResponse r5) throws IOException {
            Category.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mcategory_list);
            this.mcovers.encodeWithTag(r4, 2, r5.mcovers);
            HongbaoCover.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mrecommend_covers);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullHongbaoCoverListResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullHongbaoCoverListResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1744newBuilder() {
        Builder r0 = new Builder();
        r0.mcategory_list = Internal.copyOf("mcategory_list", this.mcategory_list);
        r0.mcovers = Internal.copyOf("mcovers", this.mcovers);
        r0.mrecommend_covers = Internal.copyOf("mrecommend_covers", this.mrecommend_covers);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullHongbaoCoverListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1744newBuilder();
    }

    public PullHongbaoCoverListResponse(List<Category> r2, Map<Long, CoverList> r3, List<HongbaoCover> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullHongbaoCoverListResponse(List<Category> r2, Map<Long, CoverList> r3, List<HongbaoCover> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mcategory_list = Internal.immutableCopyOf("mcategory_list", r2);
        this.mcovers = Internal.immutableCopyOf("mcovers", r3);
        this.mrecommend_covers = Internal.immutableCopyOf("mrecommend_covers", r4);
    }
}
