package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchEntity extends Message<SearchEntity, Builder> {
    public static final ProtoAdapter<SearchEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Props> mprops;

    public static final class Builder extends Message.Builder<SearchEntity, Builder> {
        public List<Props> mprops;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchEntity m2813build() {
            return new SearchEntity(this.mprops, super.buildUnknownFields());
        }

        public Builder() {
            this.mprops = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2813build();
        }

        public Builder props(List<Props> r1) {
            Internal.checkElementsNotNull(r1);
            this.mprops = r1;
            return this;
        }
    }

    public static final class ChatterMeta extends Message<ChatterMeta, Builder> {
        public static final ProtoAdapter<ChatterMeta> ADAPTER = null;
        public static final String DEFAULT_CHATTER_ID = "";
        public static final String DEFAULT_ENTERPRISE_MAIL_ADDRESS = "";
        private static final long serialVersionUID = 0;
        public final String mchatter_id;
        public final String menterprise_mail_address;

        public static final class Builder extends Message.Builder<ChatterMeta, Builder> {
            public String mchatter_id;
            public String menterprise_mail_address;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatterMeta m2815build() {
                return new ChatterMeta(this.menterprise_mail_address, this.mchatter_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2815build();
            }

            public Builder chatter_id(String r1) {
                this.mchatter_id = r1;
                return this;
            }

            public Builder enterprise_mail_address(String r1) {
                this.menterprise_mail_address = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatterMeta extends ProtoAdapter<ChatterMeta> {
            public ProtoAdapter_ChatterMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatterMeta.class);
            }

            public ChatterMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.menterprise_mail_address = "";
                r0.mchatter_id = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.menterprise_mail_address = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mchatter_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2815build();
            }

            public int encodedSize(ChatterMeta r5) {
                String r0 = r5.menterprise_mail_address;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mchatter_id;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2816decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatterMeta) r1);
            }

            public void encode(ProtoWriter r4, ChatterMeta r5) throws IOException {
                String r0 = r5.menterprise_mail_address;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mchatter_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatterMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatterMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2814newBuilder() {
            Builder r0 = new Builder();
            r0.menterprise_mail_address = this.menterprise_mail_address;
            r0.mchatter_id = this.mchatter_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatterMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2814newBuilder();
        }

        public ChatterMeta(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ChatterMeta(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.menterprise_mail_address = r2;
            this.mchatter_id = r3;
        }
    }

    public static final class DocFolderMeta extends Message<DocFolderMeta, Builder> {
        public static final ProtoAdapter<DocFolderMeta> ADAPTER = null;
        public static final Boolean DEFAULT_IS_SHARE_FOLDER = null;
        public static final Long DEFAULT_UPDATE_TIME = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_share_folder;
        public final DocType mtype;
        public final Long mupdate_time;

        public static final class Builder extends Message.Builder<DocFolderMeta, Builder> {
            public Boolean mis_share_folder;
            public DocType mtype;
            public Long mupdate_time;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocFolderMeta m2818build() {
                return new DocFolderMeta(this.mupdate_time, this.mis_share_folder, this.mtype, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2818build();
            }

            public Builder is_share_folder(Boolean r1) {
                this.mis_share_folder = r1;
                return this;
            }

            public Builder type(DocType r1) {
                this.mtype = r1;
                return this;
            }

            public Builder update_time(Long r1) {
                this.mupdate_time = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocFolderMeta extends ProtoAdapter<DocFolderMeta> {
            public ProtoAdapter_DocFolderMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DocFolderMeta.class);
            }

            public DocFolderMeta decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mupdate_time = 0L;
                r0.mis_share_folder = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mis_share_folder = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mtype = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2818build();
            }

            public int encodedSize(DocFolderMeta r6) {
                Long r0 = r6.mupdate_time;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mis_share_folder;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                DocType r7 = r6.mtype;
                if (r7 == null) goto L14;
                r1 = DocType.ADAPTER.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m2819decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocFolderMeta) r1);
            }

            public void encode(ProtoWriter r4, DocFolderMeta r5) throws IOException {
                Long r0 = r5.mupdate_time;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_share_folder;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                DocType r2 = r5.mtype;
                if (r2 == null) goto L11;
                DocType.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocFolderMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocFolderMeta();
            DEFAULT_UPDATE_TIME = 0L;
            DEFAULT_IS_SHARE_FOLDER = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2817newBuilder() {
            Builder r0 = new Builder();
            r0.mupdate_time = this.mupdate_time;
            r0.mis_share_folder = this.mis_share_folder;
            r0.mtype = this.mtype;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocFolderMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2817newBuilder();
        }

        public DocFolderMeta(Long r2, Boolean r3, DocType r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public DocFolderMeta(Long r2, Boolean r3, DocType r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mupdate_time = r2;
            this.mis_share_folder = r3;
            this.mtype = r4;
        }
    }

    public static final class HistoryMeta extends Message<HistoryMeta, Builder> {
        public static final ProtoAdapter<HistoryMeta> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatterMeta mchatter_meta;
        public final DocFolderMeta mdoc_folder_meta;

        public static final class Builder extends Message.Builder<HistoryMeta, Builder> {
            public ChatterMeta mchatter_meta;
            public DocFolderMeta mdoc_folder_meta;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HistoryMeta m2821build() {
                return new HistoryMeta(this.mdoc_folder_meta, this.mchatter_meta, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2821build();
            }

            public Builder chatter_meta(ChatterMeta r1) {
                this.mchatter_meta = r1;
                this.mdoc_folder_meta = null;
                return this;
            }

            public Builder doc_folder_meta(DocFolderMeta r1) {
                this.mdoc_folder_meta = r1;
                this.mchatter_meta = null;
                return this;
            }
        }

        public static final class ProtoAdapter_HistoryMeta extends ProtoAdapter<HistoryMeta> {
            public ProtoAdapter_HistoryMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, HistoryMeta.class);
            }

            public HistoryMeta decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.doc_folder_meta((DocFolderMeta) DocFolderMeta.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.chatter_meta((ChatterMeta) ChatterMeta.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2821build();
            }

            public int encodedSize(HistoryMeta r5) {
                DocFolderMeta r0 = r5.mdoc_folder_meta;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = DocFolderMeta.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ChatterMeta r3 = r5.mchatter_meta;
                if (r3 == null) goto L10;
                r1 = ChatterMeta.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2822decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HistoryMeta) r1);
            }

            public void encode(ProtoWriter r4, HistoryMeta r5) throws IOException {
                DocFolderMeta r0 = r5.mdoc_folder_meta;
                if (r0 == null) goto L5;
                DocFolderMeta.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                ChatterMeta r1 = r5.mchatter_meta;
                if (r1 == null) goto L8;
                ChatterMeta.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HistoryMeta) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HistoryMeta();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2820newBuilder() {
            Builder r0 = new Builder();
            r0.mdoc_folder_meta = this.mdoc_folder_meta;
            r0.mchatter_meta = this.mchatter_meta;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HistoryMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2820newBuilder();
        }

        public HistoryMeta(DocFolderMeta r2, ChatterMeta r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public HistoryMeta(DocFolderMeta r2, ChatterMeta r3, ByteString r4) {
            super(ADAPTER, r4);
            if (Internal.countNonNull(r2, r3) > 1) goto L7;
            this.mdoc_folder_meta = r2;
            this.mchatter_meta = r3;
            return;
        L7:
            throw new IllegalArgumentException("at most one of mdoc_folder_meta, mchatter_meta may be non-null");
        }
    }

    public static final class Props extends Message<Props, Builder> {
        public static final ProtoAdapter<Props> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mdescription;
        public final HistoryMeta mmeta;
        public final String mname;

        public static final class Builder extends Message.Builder<Props, Builder> {
            public String mdescription;
            public HistoryMeta mmeta;
            public String mname;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Props m2824build() {
                return new Props(this.mname, this.mdescription, this.mmeta, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2824build();
            }

            public Builder description(String r1) {
                this.mdescription = r1;
                return this;
            }

            public Builder meta(HistoryMeta r1) {
                this.mmeta = r1;
                return this;
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Props extends ProtoAdapter<Props> {
            public ProtoAdapter_Props() {
                super(FieldEncoding.LENGTH_DELIMITED, Props.class);
            }

            public Props decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mname = "";
                r0.mdescription = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mname = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdescription = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mmeta = (HistoryMeta) HistoryMeta.ADAPTER.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2824build();
            }

            public int encodedSize(Props r6) {
                String r0 = r6.mname;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mdescription;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                HistoryMeta r7 = r6.mmeta;
                if (r7 == null) goto L14;
                r1 = HistoryMeta.ADAPTER.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m2825decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Props) r1);
            }

            public void encode(ProtoWriter r4, Props r5) throws IOException {
                String r0 = r5.mname;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdescription;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                HistoryMeta r2 = r5.mmeta;
                if (r2 == null) goto L11;
                HistoryMeta.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Props) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Props();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2823newBuilder() {
            Builder r0 = new Builder();
            r0.mname = this.mname;
            r0.mdescription = this.mdescription;
            r0.mmeta = this.mmeta;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Props.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2823newBuilder();
        }

        public Props(String r2, String r3, HistoryMeta r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public Props(String r2, String r3, HistoryMeta r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mname = r2;
            this.mdescription = r3;
            this.mmeta = r4;
        }
    }

    public static final class ProtoAdapter_SearchEntity extends ProtoAdapter<SearchEntity> {
        public ProtoAdapter_SearchEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchEntity.class);
        }

        public SearchEntity decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mprops.add((Props) Props.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2813build();
        }

        public int encodedSize(SearchEntity r4) {
            return Props.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mprops) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2826decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchEntity) r1);
        }

        public void encode(ProtoWriter r4, SearchEntity r5) throws IOException {
            Props.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mprops);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchEntity) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchEntity();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2812newBuilder() {
        Builder r0 = new Builder();
        r0.mprops = Internal.copyOf("mprops", this.mprops);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2812newBuilder();
    }

    public SearchEntity(List<Props> r2) {
        this(r2, ByteString.EMPTY);
    }

    public SearchEntity(List<Props> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mprops = Internal.immutableCopyOf("mprops", r2);
    }
}
