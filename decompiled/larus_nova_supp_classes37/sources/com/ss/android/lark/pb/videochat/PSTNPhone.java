package com.ss.android.lark.pb.videochat;

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
public final class PSTNPhone extends Message<PSTNPhone, Builder> {
    public static final ProtoAdapter<PSTNPhone> ADAPTER = null;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_NUMBER = "";
    public static final String DEFAULT_NUMBER_DISPLAY = "";
    private static final long serialVersionUID = 0;
    public final String mcountry;
    public final String mnumber;
    public final String mnumber_display;
    public final Type mtype;

    public static final class Builder extends Message.Builder<PSTNPhone, Builder> {
        public String mcountry;
        public String mnumber;
        public String mnumber_display;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PSTNPhone m3170build() {
            String r0 = this.mcountry;
            if (r0 == null) goto L11;
            if (this.mtype == null) goto L11;
            if (this.mnumber == null) goto L11;
            return new PSTNPhone(this.mcountry, this.mtype, this.mnumber, this.mnumber_display, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mcountry", this.mtype, "mtype", this.mnumber, "mnumber"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3170build();
        }

        public Builder country(String r1) {
            this.mcountry = r1;
            return this;
        }

        public Builder number(String r1) {
            this.mnumber = r1;
            return this;
        }

        public Builder number_display(String r1) {
            this.mnumber_display = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PSTNPhone extends ProtoAdapter<PSTNPhone> {
        public ProtoAdapter_PSTNPhone() {
            super(FieldEncoding.LENGTH_DELIMITED, PSTNPhone.class);
        }

        public PSTNPhone decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcountry = "";
            r0.mnumber = "";
            r0.mnumber_display = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mcountry = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mnumber = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mnumber_display = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m3170build();
        }

        public int encodedSize(PSTNPhone r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (r0.encodedSizeWithTag(1, r6.mcountry) + Type.ADAPTER.encodedSizeWithTag(2, r6.mtype)) + r0.encodedSizeWithTag(3, r6.mnumber);
            String r2 = r6.mnumber_display;
            if (r2 == null) goto L5;
            int r3 = r0.encodedSizeWithTag(4, r2);
        L7:
            return (r1 + r3) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3171decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PSTNPhone) r1);
        }

        public void encode(ProtoWriter r5, PSTNPhone r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mcountry);
            Type.ADAPTER.encodeWithTag(r5, 2, r6.mtype);
            r0.encodeWithTag(r5, 3, r6.mnumber);
            String r1 = r6.mnumber_display;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 4, r1);
        L5:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PSTNPhone) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHARGE = null;
        public static final Type FREE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("FREE", 1, 1);
            FREE = r1;
            Type r3 = new Type("CHARGE", 2, 2);
            CHARGE = r3;
            $VALUES = new Type[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CHARGE;
        L12:
            return FREE;
        L14:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_PSTNPhone();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3169newBuilder() {
        Builder r0 = new Builder();
        r0.mcountry = this.mcountry;
        r0.mtype = this.mtype;
        r0.mnumber = this.mnumber;
        r0.mnumber_display = this.mnumber_display;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PSTNPhone.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3169newBuilder();
    }

    public PSTNPhone(String r7, Type r8, String r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public PSTNPhone(String r2, Type r3, String r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mcountry = r2;
        this.mtype = r3;
        this.mnumber = r4;
        this.mnumber_display = r5;
    }
}
