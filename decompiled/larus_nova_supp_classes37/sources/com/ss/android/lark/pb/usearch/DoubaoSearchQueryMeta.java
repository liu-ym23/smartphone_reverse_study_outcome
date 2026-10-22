package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoSearchQueryMeta extends Message<DoubaoSearchQueryMeta, Builder> {
    public static final ProtoAdapter<DoubaoSearchQueryMeta> ADAPTER = null;
    public static final String DEFAULT_DIGEST = "";
    public static final String DEFAULT_QUERY = "";
    private static final long serialVersionUID = 0;
    public final String mdigest;
    public final String mquery;

    public static final class Builder extends Message.Builder<DoubaoSearchQueryMeta, Builder> {
        public String mdigest;
        public String mquery;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DoubaoSearchQueryMeta m2633build() {
            return new DoubaoSearchQueryMeta(this.mdigest, this.mquery, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2633build();
        }

        public Builder digest(String r1) {
            this.mdigest = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoSearchQueryMeta extends ProtoAdapter<DoubaoSearchQueryMeta> {
        public ProtoAdapter_DoubaoSearchQueryMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoSearchQueryMeta.class);
        }

        public DoubaoSearchQueryMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdigest = "";
            r0.mquery = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mdigest = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mquery = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2633build();
        }

        public int encodedSize(DoubaoSearchQueryMeta r5) {
            String r0 = r5.mdigest;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mquery;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2634decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DoubaoSearchQueryMeta) r1);
        }

        public void encode(ProtoWriter r4, DoubaoSearchQueryMeta r5) throws IOException {
            String r0 = r5.mdigest;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mquery;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DoubaoSearchQueryMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoSearchQueryMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2632newBuilder() {
        Builder r0 = new Builder();
        r0.mdigest = this.mdigest;
        r0.mquery = this.mquery;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DoubaoSearchQueryMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2632newBuilder();
    }

    public DoubaoSearchQueryMeta(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DoubaoSearchQueryMeta(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mdigest = r2;
        this.mquery = r3;
    }
}
