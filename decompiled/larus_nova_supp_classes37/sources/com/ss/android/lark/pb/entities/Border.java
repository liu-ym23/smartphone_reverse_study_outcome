package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Border extends com.squareup.wire.Message<Border, Builder> {
    public static final ProtoAdapter<Border> ADAPTER = null;
    public static final Integer DEFAULT_COLOR = null;
    public static final Float DEFAULT_CORNER_RADIUS = null;
    public static final Float DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer mcolor;
    public final ThemeColor mcolor_v2;
    public final Float mcorner_radius;
    public final Float mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<Border, Builder> {
        public Integer mcolor;
        public ThemeColor mcolor_v2;
        public Float mcorner_radius;
        public Float mwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Border m1022build() {
            return new Border(this.mwidth, this.mcolor, this.mcorner_radius, this.mcolor_v2, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1022build();
        }

        public Builder color(Integer r1) {
            this.mcolor = r1;
            return this;
        }

        public Builder color_v2(ThemeColor r1) {
            this.mcolor_v2 = r1;
            return this;
        }

        public Builder corner_radius(Float r1) {
            this.mcorner_radius = r1;
            return this;
        }

        public Builder width(Float r1) {
            this.mwidth = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Border extends ProtoAdapter<Border> {
        public ProtoAdapter_Border() {
            super(FieldEncoding.LENGTH_DELIMITED, Border.class);
        }

        public Border decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Float r1 = Float.valueOf(0.0f);
            r0.mwidth = r1;
            r0.mcolor = 0;
            r0.mcorner_radius = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mwidth = (Float) ProtoAdapter.FLOAT.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcolor = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcorner_radius = (Float) ProtoAdapter.FLOAT.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mcolor_v2 = (ThemeColor) ThemeColor.ADAPTER.decode(r7);
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r2);
            return r0.m1022build();
        }

        public int encodedSize(Border r6) {
            Float r0 = r6.mwidth;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.FLOAT.encodedSizeWithTag(1, r0);
        L6:
            Integer r3 = r6.mcolor;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.UINT32.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Float r7 = r6.mcorner_radius;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ThemeColor r10 = r6.mcolor_v2;
            if (r10 == null) goto L18;
            r1 = ThemeColor.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m1023decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Border) r1);
        }

        public void encode(ProtoWriter r4, Border r5) throws IOException {
            Float r0 = r5.mwidth;
            if (r0 == null) goto L5;
            ProtoAdapter.FLOAT.encodeWithTag(r4, 1, r0);
        L5:
            Integer r1 = r5.mcolor;
            if (r1 == null) goto L8;
            ProtoAdapter.UINT32.encodeWithTag(r4, 2, r1);
        L8:
            Float r2 = r5.mcorner_radius;
            if (r2 == null) goto L11;
            ProtoAdapter.FLOAT.encodeWithTag(r4, 3, r2);
        L11:
            ThemeColor r3 = r5.mcolor_v2;
            if (r3 == null) goto L14;
            ThemeColor.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Border) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Border();
        Float r0 = Float.valueOf(0.0f);
        DEFAULT_WIDTH = r0;
        DEFAULT_COLOR = 0;
        DEFAULT_CORNER_RADIUS = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1021newBuilder() {
        Builder r0 = new Builder();
        r0.mwidth = this.mwidth;
        r0.mcolor = this.mcolor;
        r0.mcorner_radius = this.mcorner_radius;
        r0.mcolor_v2 = this.mcolor_v2;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Border.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1021newBuilder();
    }

    public Border(Float r7, Integer r8, Float r9, ThemeColor r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public Border(Float r2, Integer r3, Float r4, ThemeColor r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mwidth = r2;
        this.mcolor = r3;
        this.mcorner_radius = r4;
        this.mcolor_v2 = r5;
    }
}
