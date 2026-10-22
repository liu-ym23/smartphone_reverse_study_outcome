package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Gradient extends com.squareup.wire.Message<Gradient, Builder> {
    public static final ProtoAdapter<Gradient> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Linear mlinear;
    public final Type mtype;

    public static final class Builder extends com.squareup.wire.Message.Builder<Gradient, Builder> {
        public Linear mlinear;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Gradient m1250build() {
            return new Gradient(this.mtype, this.mlinear, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1250build();
        }

        public Builder linear(Linear r1) {
            this.mlinear = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class Linear extends com.squareup.wire.Message<Linear, Builder> {
        public static final ProtoAdapter<Linear> ADAPTER = null;
        public static final Integer DEFAULT_DEG = null;
        private static final long serialVersionUID = 0;
        public final List<Integer> mcolors;
        public final List<Integer> mcolors_v2;
        public final List<ThemeColor> mcolors_v3;
        public final Integer mdeg;

        public static final class Builder extends com.squareup.wire.Message.Builder<Linear, Builder> {
            public List<Integer> mcolors;
            public List<Integer> mcolors_v2;
            public List<ThemeColor> mcolors_v3;
            public Integer mdeg;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Linear m1252build() {
                return new Linear(this.mdeg, this.mcolors, this.mcolors_v2, this.mcolors_v3, super.buildUnknownFields());
            }

            public Builder() {
                this.mcolors = Internal.newMutableList();
                this.mcolors_v2 = Internal.newMutableList();
                this.mcolors_v3 = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1252build();
            }

            public Builder colors(List<Integer> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcolors = r1;
                return this;
            }

            public Builder colors_v2(List<Integer> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcolors_v2 = r1;
                return this;
            }

            public Builder colors_v3(List<ThemeColor> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcolors_v3 = r1;
                return this;
            }

            public Builder deg(Integer r1) {
                this.mdeg = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Linear extends ProtoAdapter<Linear> {
            public ProtoAdapter_Linear() {
                super(FieldEncoding.LENGTH_DELIMITED, Linear.class);
            }

            public Linear decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mdeg = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mdeg = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcolors.add((Integer) ProtoAdapter.INT32.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mcolors_v2.add((Integer) ProtoAdapter.UINT32.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mcolors_v3.add((ThemeColor) ThemeColor.ADAPTER.decode(r7));
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m1252build();
            }

            public int encodedSize(Linear r5) {
                Integer r0 = r5.mdeg;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
            L7:
                return (((r1 + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r5.mcolors)) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(3, r5.mcolors_v2)) + ThemeColor.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.mcolors_v3)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1253decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Linear) r1);
            }

            public void encode(ProtoWriter r4, Linear r5) throws IOException {
                Integer r0 = r5.mdeg;
                if (r0 == null) goto L5;
                ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
            L5:
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 2, r5.mcolors);
                ProtoAdapter.UINT32.asRepeated().encodeWithTag(r4, 3, r5.mcolors_v2);
                ThemeColor.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mcolors_v3);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Linear) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Linear();
            DEFAULT_DEG = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1251newBuilder() {
            Builder r0 = new Builder();
            r0.mdeg = this.mdeg;
            r0.mcolors = Internal.copyOf("mcolors", this.mcolors);
            r0.mcolors_v2 = Internal.copyOf("mcolors_v2", this.mcolors_v2);
            r0.mcolors_v3 = Internal.copyOf("mcolors_v3", this.mcolors_v3);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Linear.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1251newBuilder();
        }

        public Linear(Integer r7, List<Integer> r8, List<Integer> r9, List<ThemeColor> r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public Linear(Integer r2, List<Integer> r3, List<Integer> r4, List<ThemeColor> r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mdeg = r2;
            this.mcolors = Internal.immutableCopyOf("mcolors", r3);
            this.mcolors_v2 = Internal.immutableCopyOf("mcolors_v2", r4);
            this.mcolors_v3 = Internal.immutableCopyOf("mcolors_v3", r5);
        }
    }

    public static final class ProtoAdapter_Gradient extends ProtoAdapter<Gradient> {
        public ProtoAdapter_Gradient() {
            super(FieldEncoding.LENGTH_DELIMITED, Gradient.class);
        }

        public Gradient decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.linear((Linear) Linear.ADAPTER.decode(r9));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m1250build();
        }

        public int encodedSize(Gradient r5) {
            Type r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Linear r3 = r5.mlinear;
            if (r3 == null) goto L10;
            r1 = Linear.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1254decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Gradient) r1);
        }

        public void encode(ProtoWriter r4, Gradient r5) throws IOException {
            Type r0 = r5.mtype;
            if (r0 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Linear r1 = r5.mlinear;
            if (r1 == null) goto L8;
            Linear.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Gradient) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type LINEAR = null;
        private final int value;

        static {
            Type r0 = new Type("LINEAR", 0, 0);
            LINEAR = r0;
            $VALUES = new Type[]{r0};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r0) {
            if (r0 == 0) goto L6;
            return null;
        L6:
            return LINEAR;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Gradient();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1249newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mlinear = this.mlinear;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Gradient.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1249newBuilder();
    }

    public Gradient(Type r2, Linear r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Gradient(Type r2, Linear r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mlinear = r3;
    }
}
