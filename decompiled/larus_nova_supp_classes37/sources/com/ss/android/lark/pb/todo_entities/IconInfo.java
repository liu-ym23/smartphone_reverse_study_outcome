package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IconInfo extends Message<IconInfo, Builder> {
    public static final ProtoAdapter<IconInfo> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String mkey;
    public final Integer mtype;

    public static final class Builder extends Message.Builder<IconInfo, Builder> {
        public String mkey;
        public Integer mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public IconInfo m2300build() {
            return new IconInfo(this.mtype, this.mkey, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2300build();
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder type(Integer r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_IconInfo extends ProtoAdapter<IconInfo> {
        public ProtoAdapter_IconInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, IconInfo.class);
        }

        public IconInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mtype = 0;
            r0.mkey = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mtype = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2300build();
        }

        public int encodedSize(IconInfo r5) {
            Integer r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
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
        public /* bridge */ /* synthetic */ Object m2301decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((IconInfo) r1);
        }

        public void encode(ProtoWriter r4, IconInfo r5) throws IOException {
            Integer r0 = r5.mtype;
            if (r0 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mkey;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (IconInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IconInfo();
        DEFAULT_TYPE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2299newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mkey = this.mkey;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return IconInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2299newBuilder();
    }

    public IconInfo(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public IconInfo(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mkey = r3;
    }
}
