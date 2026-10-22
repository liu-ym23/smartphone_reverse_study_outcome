package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class VersionRange extends Message<VersionRange, Builder> {
    public static final ProtoAdapter<VersionRange> ADAPTER = null;
    public static final String DEFAULT_END = "";
    public static final String DEFAULT_START = "";
    private static final long serialVersionUID = 0;
    public final String mend;
    public final String mstart;

    public static final class Builder extends Message.Builder<VersionRange, Builder> {
        public String mend;
        public String mstart;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public VersionRange m1772build() {
            String r0 = this.mstart;
            if (r0 == null) goto L9;
            if (this.mend == null) goto L9;
            return new VersionRange(this.mstart, this.mend, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mstart", this.mend, "mend"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1772build();
        }

        public Builder end(String r1) {
            this.mend = r1;
            return this;
        }

        public Builder start(String r1) {
            this.mstart = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_VersionRange extends ProtoAdapter<VersionRange> {
        public ProtoAdapter_VersionRange() {
            super(FieldEncoding.LENGTH_DELIMITED, VersionRange.class);
        }

        public VersionRange decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mstart = "";
            r0.mend = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mstart = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mend = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1772build();
        }

        public int encodedSize(VersionRange r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mstart) + r0.encodedSizeWithTag(2, r5.mend)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1773decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((VersionRange) r1);
        }

        public void encode(ProtoWriter r4, VersionRange r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mstart);
            r0.encodeWithTag(r4, 2, r5.mend);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (VersionRange) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VersionRange();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1771newBuilder() {
        Builder r0 = new Builder();
        r0.mstart = this.mstart;
        r0.mend = this.mend;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return VersionRange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1771newBuilder();
    }

    public VersionRange(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public VersionRange(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mstart = r2;
        this.mend = r3;
    }
}
