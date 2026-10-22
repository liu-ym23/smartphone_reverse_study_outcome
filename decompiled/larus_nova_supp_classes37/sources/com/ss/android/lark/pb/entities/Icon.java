package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Icon extends com.squareup.wire.Message<Icon, Builder> {
    public static final ProtoAdapter<Icon> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mKey;
    public final String mfs_unit;
    public final IconType mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Icon, Builder> {
        public String mKey;
        public String mfs_unit;
        public IconType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Icon m1271build() {
            return new Icon(this.mtype, this.mKey, this.mfs_unit, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1271build();
        }

        public Builder Key(String r1) {
            this.mKey = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder type(IconType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Icon extends ProtoAdapter<Icon> {
        public ProtoAdapter_Icon() {
            super(FieldEncoding.LENGTH_DELIMITED, Icon.class);
        }

        public Icon decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mKey = "";
            r0.mfs_unit = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtype = (IconType) IconType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mKey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1271build();
        }

        public int encodedSize(Icon r6) {
            IconType r0 = r6.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = IconType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mKey;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mfs_unit;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1272decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Icon) r1);
        }

        public void encode(ProtoWriter r4, Icon r5) throws IOException {
            IconType r0 = r5.mtype;
            if (r0 == null) goto L5;
            IconType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mKey;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mfs_unit;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Icon) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Icon();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1270newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mKey = this.mKey;
        r0.mfs_unit = this.mfs_unit;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Icon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1270newBuilder();
    }

    public Icon(IconType r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public Icon(IconType r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtype = r2;
        this.mKey = r3;
        this.mfs_unit = r4;
    }
}
