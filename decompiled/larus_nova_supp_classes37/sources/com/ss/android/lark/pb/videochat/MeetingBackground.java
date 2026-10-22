package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.videochat_material.MaterialSource;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MeetingBackground extends Message<MeetingBackground, Builder> {
    public static final ProtoAdapter<MeetingBackground> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PORTRAIT_URL = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String mname;
    public final String mportrait_url;
    public final MaterialSource msource;
    public final Type mtype;
    public final String murl;

    public static final class Builder extends Message.Builder<MeetingBackground, Builder> {
        public String mname;
        public String mportrait_url;
        public MaterialSource msource;
        public Type mtype;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MeetingBackground m3161build() {
            Type r0 = this.mtype;
            if (r0 == null) goto L11;
            if (this.mname == null) goto L11;
            if (this.murl == null) goto L11;
            return new MeetingBackground(this.mtype, this.mname, this.murl, this.msource, this.mportrait_url, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtype", this.mname, "mname", this.murl, "murl"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3161build();
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder portrait_url(String r1) {
            this.mportrait_url = r1;
            return this;
        }

        public Builder source(MaterialSource r1) {
            this.msource = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingBackground extends ProtoAdapter<MeetingBackground> {
        public ProtoAdapter_MeetingBackground() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingBackground.class);
        }

        public MeetingBackground decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mname = "";
            r0.murl = "";
            r0.mportrait_url = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L27;
            if (r3 != 1) goto L8;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.msource = (MaterialSource) MaterialSource.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mportrait_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L27:
            r9.endMessage(r1);
            return r0.m3161build();
        }

        public int encodedSize(MeetingBackground r7) {
            int r0 = Type.ADAPTER.encodedSizeWithTag(1, r7.mtype);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = (r0 + r1.encodedSizeWithTag(2, r7.mname)) + r1.encodedSizeWithTag(3, r7.murl);
            MaterialSource r3 = r7.msource;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = MaterialSource.ADAPTER.encodedSizeWithTag(4, r3);
        L6:
            int r6 = r2 + r5;
            String r8 = r7.mportrait_url;
            if (r8 == null) goto L10;
            r4 = r1.encodedSizeWithTag(5, r8);
        L10:
            return (r6 + r4) + r7.unknownFields().size();
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3162decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MeetingBackground) r1);
        }

        public void encode(ProtoWriter r5, MeetingBackground r6) throws IOException {
            Type.ADAPTER.encodeWithTag(r5, 1, r6.mtype);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 2, r6.mname);
            r0.encodeWithTag(r5, 3, r6.murl);
            MaterialSource r1 = r6.msource;
            if (r1 == null) goto L5;
            MaterialSource.ADAPTER.encodeWithTag(r5, 4, r1);
        L5:
            String r2 = r6.mportrait_url;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 5, r2);
        L8:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MeetingBackground) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type IMAGE = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("IMAGE", 1, 1);
            IMAGE = r1;
            Type r3 = new Type("VIDEO", 2, 2);
            VIDEO = r3;
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
            return VIDEO;
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
        ADAPTER = new ProtoAdapter_MeetingBackground();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3160newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mname = this.mname;
        r0.murl = this.murl;
        r0.msource = this.msource;
        r0.mportrait_url = this.mportrait_url;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MeetingBackground.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3160newBuilder();
    }

    public MeetingBackground(Type r8, String r9, String r10, MaterialSource r11, String r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public MeetingBackground(Type r2, String r3, String r4, MaterialSource r5, String r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mtype = r2;
        this.mname = r3;
        this.murl = r4;
        this.msource = r5;
        this.mportrait_url = r6;
    }
}
