package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.section.SectionFooter;
import com.ss.android.lark.pb.section.SectionHeader;
import com.ss.android.lark.pb.security.AuthEntity;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SectionMeta extends Message<SectionMeta, Builder> {
    public static final ProtoAdapter<SectionMeta> ADAPTER = null;
    public static final String DEFAULT_EXTRAS = "";
    public static final String DEFAULT_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    public static final FieldOptions FIELD_OPTIONS_MITEMS = null;
    private static final long serialVersionUID = 0;
    public final String mextras;
    public final SectionFooter mfooter;
    public final SectionHeader mheader;
    public final String mid;
    public final List<SearchResult> mitems;

    public static final class Builder extends Message.Builder<SectionMeta, Builder> {
        public String mextras;
        public SectionFooter mfooter;
        public SectionHeader mheader;
        public String mid;
        public List<SearchResult> mitems;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SectionMeta m2840build() {
            return new SectionMeta(this.mid, this.mheader, this.mfooter, this.mitems, this.mextras, super.buildUnknownFields());
        }

        public Builder() {
            this.mitems = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2840build();
        }

        public Builder extras(String r1) {
            this.mextras = r1;
            return this;
        }

        public Builder footer(SectionFooter r1) {
            this.mfooter = r1;
            return this;
        }

        public Builder header(SectionHeader r1) {
            this.mheader = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder items(List<SearchResult> r1) {
            Internal.checkElementsNotNull(r1);
            this.mitems = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SectionMeta extends ProtoAdapter<SectionMeta> {
        public ProtoAdapter_SectionMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, SectionMeta.class);
        }

        public SectionMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mextras = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mheader = (SectionHeader) SectionHeader.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfooter = (SectionFooter) SectionFooter.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mitems.add((SearchResult) SearchResult.ADAPTER.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mextras = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2840build();
        }

        public int encodedSize(SectionMeta r6) {
            String r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            SectionHeader r3 = r6.mheader;
            if (r3 == null) goto L9;
            int r4 = SectionHeader.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SectionFooter r7 = r6.mfooter;
            if (r7 == null) goto L13;
            int r8 = SectionFooter.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = (r5 + r8) + SearchResult.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mitems);
            String r10 = r6.mextras;
            if (r10 == null) goto L18;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r10);
        L18:
            return (r9 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2841decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SectionMeta) r1);
        }

        public void encode(ProtoWriter r4, SectionMeta r5) throws IOException {
            String r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            SectionHeader r1 = r5.mheader;
            if (r1 == null) goto L8;
            SectionHeader.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            SectionFooter r2 = r5.mfooter;
            if (r2 == null) goto L11;
            SectionFooter.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            SearchResult.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mitems);
            String r3 = r5.mextras;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SectionMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SectionMeta();
        FieldOptions.Builder r0 = new FieldOptions.Builder();
        Boolean r1 = Boolean.TRUE;
        FIELD_OPTIONS_MID = r0.security_field(r1).security_object(new AuthEntity.Builder().m2153build()).build();
        FIELD_OPTIONS_MITEMS = new FieldOptions.Builder().security_field(r1).build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2839newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mheader = this.mheader;
        r0.mfooter = this.mfooter;
        r0.mitems = Internal.copyOf("mitems", this.mitems);
        r0.mextras = this.mextras;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SectionMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2839newBuilder();
    }

    public SectionMeta(String r8, SectionHeader r9, SectionFooter r10, List<SearchResult> r11, String r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public SectionMeta(String r2, SectionHeader r3, SectionFooter r4, List<SearchResult> r5, String r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mid = r2;
        this.mheader = r3;
        this.mfooter = r4;
        this.mitems = Internal.immutableCopyOf("mitems", r5);
        this.mextras = r6;
    }
}
