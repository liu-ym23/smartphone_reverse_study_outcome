package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Area extends Message<Area, Builder> {
    public static final ProtoAdapter<Area> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Long DEFAULT_PRIORITY = null;
    private static final long serialVersionUID = 0;
    public final String mkey;
    public final Long mpriority;

    public static final class Builder extends Message.Builder<Area, Builder> {
        public String mkey;
        public Long mpriority;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Area m1718build() {
            return new Area(this.mkey, this.mpriority, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1718build();
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder priority(Long r1) {
            this.mpriority = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Area extends ProtoAdapter<Area> {
        public ProtoAdapter_Area() {
            super(FieldEncoding.LENGTH_DELIMITED, Area.class);
        }

        public Area decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mpriority = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mpriority = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m1718build();
        }

        public int encodedSize(Area r5) {
            String r0 = r5.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r5.mpriority;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1719decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Area) r1);
        }

        public void encode(ProtoWriter r4, Area r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mpriority;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Area) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Area();
        DEFAULT_PRIORITY = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1717newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mpriority = this.mpriority;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Area.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1717newBuilder();
    }

    public Area(String r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Area(String r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mkey = r2;
        this.mpriority = r3;
    }
}
