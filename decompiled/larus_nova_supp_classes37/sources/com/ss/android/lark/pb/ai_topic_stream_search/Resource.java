package com.ss.android.lark.pb.ai_topic_stream_search;

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
public final class Resource extends Message<Resource, Builder> {
    public static final ProtoAdapter<Resource> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mkey;
    public final Type mtype;

    public static final class Builder extends Message.Builder<Resource, Builder> {
        public String mkey;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Resource m806build() {
            return new Resource(this.mtype, this.mkey, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m806build();
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Resource extends ProtoAdapter<Resource> {
        public ProtoAdapter_Resource() {
            super(FieldEncoding.LENGTH_DELIMITED, Resource.class);
        }

        public Resource decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
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
            r0.mkey = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m806build();
        }

        public int encodedSize(Resource r5) {
            Type r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mkey;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m807decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Resource) r1);
        }

        public void encode(ProtoWriter r4, Resource r5) throws IOException {
            Type r0 = r5.mtype;
            if (r0 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mkey;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Resource) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type IMAGE = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("IMAGE", 1, 1);
            IMAGE = r1;
            Type r3 = new Type("USER", 2, 2);
            USER = r3;
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
            return USER;
        L12:
            return IMAGE;
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
        ADAPTER = new ProtoAdapter_Resource();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m805newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mkey = this.mkey;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Resource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m805newBuilder();
    }

    public Resource(Type r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Resource(Type r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mkey = r3;
    }
}
