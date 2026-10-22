package com.ss.android.lark.pb.messages;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocPermission;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullMessageDocPermsResponse extends Message<PullMessageDocPermsResponse, Builder> {
    public static final ProtoAdapter<PullMessageDocPermsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DocPerm> mdoc_perms;

    public static final class Builder extends Message.Builder<PullMessageDocPermsResponse, Builder> {
        public List<DocPerm> mdoc_perms;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullMessageDocPermsResponse m1811build() {
            return new PullMessageDocPermsResponse(this.mdoc_perms, super.buildUnknownFields());
        }

        public Builder() {
            this.mdoc_perms = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1811build();
        }

        public Builder doc_perms(List<DocPerm> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdoc_perms = r1;
            return this;
        }
    }

    public static final class DocPerm extends Message<DocPerm, Builder> {
        public static final ProtoAdapter<DocPerm> ADAPTER = null;
        public static final String DEFAULT_DOC_TITLE = "";
        public static final String DEFAULT_DOC_URL = "";
        public static final String DEFAULT_OWNER_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mdoc_title;
        public final DocType mdoc_type;
        public final String mdoc_url;
        public final List<String> mmessage_ids;
        public final String mowner_name;
        public final List<DocPermission> mpermissions;

        public static final class Builder extends Message.Builder<DocPerm, Builder> {
            public String mdoc_title;
            public DocType mdoc_type;
            public String mdoc_url;
            public List<String> mmessage_ids;
            public String mowner_name;
            public List<DocPermission> mpermissions;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocPerm m1813build() {
                return new DocPerm(this.mdoc_title, this.mdoc_type, this.mowner_name, this.mdoc_url, this.mpermissions, this.mmessage_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mpermissions = Internal.newMutableList();
                this.mmessage_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1813build();
            }

            public Builder doc_title(String r1) {
                this.mdoc_title = r1;
                return this;
            }

            public Builder doc_type(DocType r1) {
                this.mdoc_type = r1;
                return this;
            }

            public Builder doc_url(String r1) {
                this.mdoc_url = r1;
                return this;
            }

            public Builder message_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mmessage_ids = r1;
                return this;
            }

            public Builder owner_name(String r1) {
                this.mowner_name = r1;
                return this;
            }

            public Builder permissions(List<DocPermission> r1) {
                Internal.checkElementsNotNull(r1);
                this.mpermissions = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocPerm extends ProtoAdapter<DocPerm> {
            public ProtoAdapter_DocPerm() {
                super(FieldEncoding.LENGTH_DELIMITED, DocPerm.class);
            }

            public DocPerm decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mdoc_title = "";
                r0.mowner_name = "";
                r0.mdoc_url = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L16;
                switch(r3) {
                    case 1: goto L15;
                    case 2: goto L18;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L18:
                r0.mdoc_type = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mmessage_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L8:
                r0.mpermissions.add((DocPermission) DocPermission.ADAPTER.decode(r9));
                goto L3
            L9:
                r0.mdoc_url = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                r0.mowner_name = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L15:
                r0.mdoc_title = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L16:
                r9.endMessage(r1);
                return r0.m1813build();
            }

            public int encodedSize(DocPerm r6) {
                String r0 = r6.mdoc_title;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                DocType r3 = r6.mdoc_type;
                if (r3 == null) goto L9;
                int r4 = DocType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mowner_name;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                String r10 = r6.mdoc_url;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
            L18:
                return (((r9 + r1) + DocPermission.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mpermissions)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, r6.mmessage_ids)) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1814decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocPerm) r1);
            }

            public void encode(ProtoWriter r4, DocPerm r5) throws IOException {
                String r0 = r5.mdoc_title;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                DocType r1 = r5.mdoc_type;
                if (r1 == null) goto L8;
                DocType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mowner_name;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                String r3 = r5.mdoc_url;
                if (r3 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
            L14:
                DocPermission.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mpermissions);
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 6, r5.mmessage_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocPerm) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocPerm();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1812newBuilder() {
            Builder r0 = new Builder();
            r0.mdoc_title = this.mdoc_title;
            r0.mdoc_type = this.mdoc_type;
            r0.mowner_name = this.mowner_name;
            r0.mdoc_url = this.mdoc_url;
            r0.mpermissions = Internal.copyOf("mpermissions", this.mpermissions);
            r0.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocPerm.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1812newBuilder();
        }

        public DocPerm(String r9, DocType r10, String r11, String r12, List<DocPermission> r13, List<String> r14) {
            this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
        }

        public DocPerm(String r2, DocType r3, String r4, String r5, List<DocPermission> r6, List<String> r7, ByteString r8) {
            super(ADAPTER, r8);
            this.mdoc_title = r2;
            this.mdoc_type = r3;
            this.mowner_name = r4;
            this.mdoc_url = r5;
            this.mpermissions = Internal.immutableCopyOf("mpermissions", r6);
            this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r7);
        }
    }

    public static final class ProtoAdapter_PullMessageDocPermsResponse extends ProtoAdapter<PullMessageDocPermsResponse> {
        public ProtoAdapter_PullMessageDocPermsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullMessageDocPermsResponse.class);
        }

        public PullMessageDocPermsResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mdoc_perms.add((DocPerm) DocPerm.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m1811build();
        }

        public int encodedSize(PullMessageDocPermsResponse r4) {
            return DocPerm.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mdoc_perms) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1815decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullMessageDocPermsResponse) r1);
        }

        public void encode(ProtoWriter r4, PullMessageDocPermsResponse r5) throws IOException {
            DocPerm.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mdoc_perms);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullMessageDocPermsResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullMessageDocPermsResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1810newBuilder() {
        Builder r0 = new Builder();
        r0.mdoc_perms = Internal.copyOf("mdoc_perms", this.mdoc_perms);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullMessageDocPermsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1810newBuilder();
    }

    public PullMessageDocPermsResponse(List<DocPerm> r2) {
        this(r2, ByteString.EMPTY);
    }

    public PullMessageDocPermsResponse(List<DocPerm> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mdoc_perms = Internal.immutableCopyOf("mdoc_perms", r2);
    }
}
