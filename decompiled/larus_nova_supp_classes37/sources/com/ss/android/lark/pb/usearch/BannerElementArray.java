package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BannerElementArray extends Message<BannerElementArray, Builder> {
    public static final ProtoAdapter<BannerElementArray> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Alignment malignment;
    public final List<BannerElement> melements;

    public static final class Builder extends Message.Builder<BannerElementArray, Builder> {
        public Alignment malignment;
        public List<BannerElement> melements;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerElementArray m2546build() {
            return new BannerElementArray(this.melements, this.malignment, super.buildUnknownFields());
        }

        public Builder() {
            this.melements = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2546build();
        }

        public Builder alignment(Alignment r1) {
            this.malignment = r1;
            return this;
        }

        public Builder elements(List<BannerElement> r1) {
            Internal.checkElementsNotNull(r1);
            this.melements = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerElementArray extends ProtoAdapter<BannerElementArray> {
        public ProtoAdapter_BannerElementArray() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerElementArray.class);
        }

        public BannerElementArray decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.melements.add((BannerElement) BannerElement.ADAPTER.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.malignment = (Alignment) Alignment.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2546build();
        }

        public int encodedSize(BannerElementArray r5) {
            int r0 = BannerElement.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.melements);
            Alignment r1 = r5.malignment;
            if (r1 == null) goto L5;
            int r2 = Alignment.ADAPTER.encodedSizeWithTag(2, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2547decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerElementArray) r1);
        }

        public void encode(ProtoWriter r4, BannerElementArray r5) throws IOException {
            BannerElement.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.melements);
            Alignment r0 = r5.malignment;
            if (r0 == null) goto L5;
            Alignment.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerElementArray) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerElementArray();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2545newBuilder() {
        Builder r0 = new Builder();
        r0.melements = Internal.copyOf("melements", this.melements);
        r0.malignment = this.malignment;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerElementArray.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2545newBuilder();
    }

    public BannerElementArray(List<BannerElement> r2, Alignment r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public BannerElementArray(List<BannerElement> r2, Alignment r3, ByteString r4) {
        super(ADAPTER, r4);
        this.melements = Internal.immutableCopyOf("melements", r2);
        this.malignment = r3;
    }
}
