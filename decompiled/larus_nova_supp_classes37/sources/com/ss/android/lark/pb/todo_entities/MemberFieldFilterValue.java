package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MemberFieldFilterValue extends Message<MemberFieldFilterValue, Builder> {
    public static final ProtoAdapter<MemberFieldFilterValue> ADAPTER = null;
    public static final Long DEFAULT_MEMBER_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mmember_id;
    public final Type mmember_type;

    public static final class Builder extends Message.Builder<MemberFieldFilterValue, Builder> {
        public Long mmember_id;
        public Type mmember_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MemberFieldFilterValue m2303build() {
            return new MemberFieldFilterValue(this.mmember_type, this.mmember_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2303build();
        }

        public Builder member_id(Long r1) {
            this.mmember_id = r1;
            return this;
        }

        public Builder member_type(Type r1) {
            this.mmember_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MemberFieldFilterValue extends ProtoAdapter<MemberFieldFilterValue> {
        public ProtoAdapter_MemberFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, MemberFieldFilterValue.class);
        }

        public MemberFieldFilterValue decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mmember_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mmember_type = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mmember_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2303build();
        }

        public int encodedSize(MemberFieldFilterValue r5) {
            Type r0 = r5.mmember_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r5.mmember_id;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2304decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MemberFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, MemberFieldFilterValue r5) throws IOException {
            Type r0 = r5.mmember_type;
            if (r0 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mmember_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MemberFieldFilterValue) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type APP = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("USER", 1, 1);
            USER = r1;
            Type r3 = new Type("APP", 2, 2);
            APP = r3;
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
            return APP;
        L12:
            return USER;
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
        ADAPTER = new ProtoAdapter_MemberFieldFilterValue();
        DEFAULT_MEMBER_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2302newBuilder() {
        Builder r0 = new Builder();
        r0.mmember_type = this.mmember_type;
        r0.mmember_id = this.mmember_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MemberFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2302newBuilder();
    }

    public MemberFieldFilterValue(Type r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public MemberFieldFilterValue(Type r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mmember_type = r2;
        this.mmember_id = r3;
    }
}
