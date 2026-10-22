package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BadgeMaterial extends Message<BadgeMaterial, Builder> {
    public static final ProtoAdapter<BadgeMaterial> ADAPTER = null;
    public static final Integer DEFAULT_VIEWNUMBER = null;
    private static final long serialVersionUID = 0;
    public final Integer mViewNumber;
    public final TextElement mViewText;
    public final MaterialBase mbase;
    public final BadgeType mtype;

    public static final enum BadgeType extends Enum<BadgeType> implements WireEnum {
        private static final /* synthetic */ BadgeType[] $VALUES = null;
        public static final ProtoAdapter<BadgeType> ADAPTER = null;
        public static final BadgeType Number = null;
        public static final BadgeType RedPoint = null;
        public static final BadgeType Text = null;
        private final int value;

        static {
            BadgeType r0 = new BadgeType("RedPoint", 0, 1);
            RedPoint = r0;
            BadgeType r1 = new BadgeType("Text", 1, 2);
            Text = r1;
            BadgeType r4 = new BadgeType("Number", 2, 3);
            Number = r4;
            $VALUES = new BadgeType[]{r0, r1, r4};
            ADAPTER = ProtoAdapter.newEnumAdapter(BadgeType.class);
        }

        public static BadgeType[] values() {
            return (BadgeType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BadgeType fromValue(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return Number;
        L13:
            return Text;
        L15:
            return RedPoint;
        }

        public static BadgeType valueOf(String r1) {
            return (BadgeType) a.a(BadgeType.class, r1);
        }

        private BadgeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<BadgeMaterial, Builder> {
        public Integer mViewNumber;
        public TextElement mViewText;
        public MaterialBase mbase;
        public BadgeType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BadgeMaterial m2414build() {
            return new BadgeMaterial(this.mbase, this.mtype, this.mViewNumber, this.mViewText, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2414build();
        }

        public Builder ViewNumber(Integer r1) {
            this.mViewNumber = r1;
            this.mViewText = null;
            return this;
        }

        public Builder ViewText(TextElement r1) {
            this.mViewText = r1;
            this.mViewNumber = null;
            return this;
        }

        public Builder base(MaterialBase r1) {
            this.mbase = r1;
            return this;
        }

        public Builder type(BadgeType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BadgeMaterial extends ProtoAdapter<BadgeMaterial> {
        public ProtoAdapter_BadgeMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, BadgeMaterial.class);
        }

        public BadgeMaterial decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.ViewNumber(0);
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mbase = (MaterialBase) MaterialBase.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (BadgeType) BadgeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.ViewNumber((Integer) ProtoAdapter.INT32.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.ViewText((TextElement) TextElement.ADAPTER.decode(r9));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2414build();
        }

        public int encodedSize(BadgeMaterial r6) {
            MaterialBase r0 = r6.mbase;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = MaterialBase.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            BadgeType r3 = r6.mtype;
            if (r3 == null) goto L9;
            int r4 = BadgeType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.mViewNumber;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TextElement r10 = r6.mViewText;
            if (r10 == null) goto L18;
            r1 = TextElement.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2415decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BadgeMaterial) r1);
        }

        public void encode(ProtoWriter r4, BadgeMaterial r5) throws IOException {
            MaterialBase r0 = r5.mbase;
            if (r0 == null) goto L5;
            MaterialBase.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            BadgeType r1 = r5.mtype;
            if (r1 == null) goto L8;
            BadgeType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.mViewNumber;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            TextElement r3 = r5.mViewText;
            if (r3 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BadgeMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BadgeMaterial();
        DEFAULT_VIEWNUMBER = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2413newBuilder() {
        Builder r0 = new Builder();
        r0.mbase = this.mbase;
        r0.mtype = this.mtype;
        r0.mViewNumber = this.mViewNumber;
        r0.mViewText = this.mViewText;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BadgeMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2413newBuilder();
    }

    public BadgeMaterial(MaterialBase r7, BadgeType r8, Integer r9, TextElement r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public BadgeMaterial(MaterialBase r2, BadgeType r3, Integer r4, TextElement r5, ByteString r6) {
        super(ADAPTER, r6);
        if (Internal.countNonNull(r4, r5) > 1) goto L7;
        this.mbase = r2;
        this.mtype = r3;
        this.mViewNumber = r4;
        this.mViewText = r5;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mViewNumber, mViewText may be non-null");
    }
}
