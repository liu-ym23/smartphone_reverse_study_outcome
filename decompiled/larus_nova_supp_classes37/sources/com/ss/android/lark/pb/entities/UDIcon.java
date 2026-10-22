package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UDIcon extends com.squareup.wire.Message<UDIcon, Builder> {
    public static final ProtoAdapter<UDIcon> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_UNICODE = "";
    private static final long serialVersionUID = 0;
    public final ThemeColor mcolor;
    public final String mkey;
    public final String municode;

    public static final class Builder extends com.squareup.wire.Message.Builder<UDIcon, Builder> {
        public ThemeColor mcolor;
        public String mkey;
        public String municode;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UDIcon m1574build() {
            return new UDIcon(this.mkey, this.mcolor, this.municode, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1574build();
        }

        public Builder color(ThemeColor r1) {
            this.mcolor = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder unicode(String r1) {
            this.municode = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UDIcon extends ProtoAdapter<UDIcon> {
        public ProtoAdapter_UDIcon() {
            super(FieldEncoding.LENGTH_DELIMITED, UDIcon.class);
        }

        public UDIcon decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.municode = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcolor = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.municode = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1574build();
        }

        public int encodedSize(UDIcon r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ThemeColor r3 = r6.mcolor;
            if (r3 == null) goto L9;
            int r4 = ThemeColor.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.municode;
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
        public /* bridge */ /* synthetic */ Object m1575decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UDIcon) r1);
        }

        public void encode(ProtoWriter r4, UDIcon r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ThemeColor r1 = r5.mcolor;
            if (r1 == null) goto L8;
            ThemeColor.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.municode;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UDIcon) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UDIcon();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1573newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mcolor = this.mcolor;
        r0.municode = this.municode;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UDIcon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1573newBuilder();
    }

    public UDIcon(String r2, ThemeColor r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UDIcon(String r2, ThemeColor r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mkey = r2;
        this.mcolor = r3;
        this.municode = r4;
    }
}
