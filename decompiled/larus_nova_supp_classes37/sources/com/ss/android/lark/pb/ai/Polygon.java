package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
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
public final class Polygon extends Message<Polygon, Builder> {
    public static final ProtoAdapter<Polygon> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Point> mpoints;
    public final ContentType mtype;

    public static final class Builder extends Message.Builder<Polygon, Builder> {
        public List<Point> mpoints;
        public ContentType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Polygon m767build() {
            ContentType r0 = this.mtype;
            if (r0 == null) goto L7;
            return new Polygon(this.mpoints, this.mtype, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtype"});
        }

        public Builder() {
            this.mpoints = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m767build();
        }

        public Builder points(List<Point> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpoints = r1;
            return this;
        }

        public Builder type(ContentType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final enum ContentType extends Enum<ContentType> implements WireEnum {
        private static final /* synthetic */ ContentType[] $VALUES = null;
        public static final ProtoAdapter<ContentType> ADAPTER = null;
        public static final ContentType AVATAR = null;
        public static final ContentType TEXT = null;
        public static final ContentType UNKNOWN = null;
        private final int value;

        static {
            ContentType r0 = new ContentType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ContentType r1 = new ContentType("TEXT", 1, 1);
            TEXT = r1;
            ContentType r3 = new ContentType("AVATAR", 2, 2);
            AVATAR = r3;
            $VALUES = new ContentType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(ContentType.class);
        }

        public static ContentType[] values() {
            return (ContentType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContentType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return AVATAR;
        L12:
            return TEXT;
        L14:
            return UNKNOWN;
        }

        public static ContentType valueOf(String r1) {
            return (ContentType) a.a(ContentType.class, r1);
        }

        private ContentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_Polygon extends ProtoAdapter<Polygon> {
        public ProtoAdapter_Polygon() {
            super(FieldEncoding.LENGTH_DELIMITED, Polygon.class);
        }

        public Polygon decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mpoints.add((Point) Point.ADAPTER.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtype = (ContentType) ContentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m767build();
        }

        public int encodedSize(Polygon r5) {
            return (Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mpoints) + ContentType.ADAPTER.encodedSizeWithTag(2, r5.mtype)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m768decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Polygon) r1);
        }

        public void encode(ProtoWriter r4, Polygon r5) throws IOException {
            Point.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mpoints);
            ContentType.ADAPTER.encodeWithTag(r4, 2, r5.mtype);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Polygon) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Polygon();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m766newBuilder() {
        Builder r0 = new Builder();
        r0.mpoints = Internal.copyOf("mpoints", this.mpoints);
        r0.mtype = this.mtype;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Polygon.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m766newBuilder();
    }

    public Polygon(List<Point> r2, ContentType r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Polygon(List<Point> r2, ContentType r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mpoints = Internal.immutableCopyOf("mpoints", r2);
        this.mtype = r3;
    }
}
