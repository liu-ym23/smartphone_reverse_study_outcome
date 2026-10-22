package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OpenSearchFilter extends Message<OpenSearchFilter, Builder> {
    public static final ProtoAdapter<OpenSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<OpenSearchFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public OpenSearchFilter m2738build() {
            return new OpenSearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2738build();
        }
    }

    public static final class OpenSearchSortFilter extends Message<OpenSearchSortFilter, Builder> {
        public static final ProtoAdapter<OpenSearchSortFilter> ADAPTER = null;
        public static final String DEFAULT_CHECKED_ID = "";
        public static final String DEFAULT_CUSTOM_FILTER_ID = "";
        private static final long serialVersionUID = 0;
        public final String mchecked_id;
        public final String mcustom_filter_id;

        public static final class Builder extends Message.Builder<OpenSearchSortFilter, Builder> {
            public String mchecked_id;
            public String mcustom_filter_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OpenSearchSortFilter m2740build() {
                return new OpenSearchSortFilter(this.mcustom_filter_id, this.mchecked_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2740build();
            }

            public Builder checked_id(String r1) {
                this.mchecked_id = r1;
                return this;
            }

            public Builder custom_filter_id(String r1) {
                this.mcustom_filter_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenSearchSortFilter extends ProtoAdapter<OpenSearchSortFilter> {
            public ProtoAdapter_OpenSearchSortFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenSearchSortFilter.class);
            }

            public OpenSearchSortFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcustom_filter_id = "";
                r0.mchecked_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mcustom_filter_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mchecked_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2740build();
            }

            public int encodedSize(OpenSearchSortFilter r5) {
                String r0 = r5.mcustom_filter_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mchecked_id;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2741decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OpenSearchSortFilter) r1);
            }

            public void encode(ProtoWriter r4, OpenSearchSortFilter r5) throws IOException {
                String r0 = r5.mcustom_filter_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mchecked_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OpenSearchSortFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenSearchSortFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2739newBuilder() {
            Builder r0 = new Builder();
            r0.mcustom_filter_id = this.mcustom_filter_id;
            r0.mchecked_id = this.mchecked_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OpenSearchSortFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2739newBuilder();
        }

        public OpenSearchSortFilter(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public OpenSearchSortFilter(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mcustom_filter_id = r2;
            this.mchecked_id = r3;
        }
    }

    public static final class ProtoAdapter_OpenSearchFilter extends ProtoAdapter<OpenSearchFilter> {
        public ProtoAdapter_OpenSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, OpenSearchFilter.class);
        }

        public OpenSearchFilter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.m2738build();
        }

        public int encodedSize(OpenSearchFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2742decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((OpenSearchFilter) r1);
        }

        public void encode(ProtoWriter r1, OpenSearchFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (OpenSearchFilter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OpenSearchFilter();
    }

    public OpenSearchFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2737newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return OpenSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2737newBuilder();
    }

    public OpenSearchFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
