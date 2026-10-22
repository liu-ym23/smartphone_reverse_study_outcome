package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageInfo extends Message<ImageInfo, Builder> {
    public static final ProtoAdapter<ImageInfo> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_TOS_OBJECT = "";
    private static final long serialVersionUID = 0;
    public final ByteString mdata;
    public final String mtos_object;

    public static final class Builder extends Message.Builder<ImageInfo, Builder> {
        public ByteString mdata;
        public String mtos_object;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageInfo m761build() {
            return new ImageInfo(this.mdata, this.mtos_object, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m761build();
        }

        public Builder data(ByteString r1) {
            this.mdata = r1;
            return this;
        }

        public Builder tos_object(String r1) {
            this.mtos_object = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageInfo extends ProtoAdapter<ImageInfo> {
        public ProtoAdapter_ImageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageInfo.class);
        }

        public ImageInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdata = ByteString.EMPTY;
            r0.mtos_object = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mdata = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mtos_object = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m761build();
        }

        public int encodedSize(ImageInfo r5) {
            ByteString r0 = r5.mdata;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mtos_object;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m762decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageInfo) r1);
        }

        public void encode(ProtoWriter r4, ImageInfo r5) throws IOException {
            ByteString r0 = r5.mdata;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtos_object;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageInfo();
        DEFAULT_DATA = ByteString.EMPTY;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m760newBuilder() {
        Builder r0 = new Builder();
        r0.mdata = this.mdata;
        r0.mtos_object = this.mtos_object;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m760newBuilder();
    }

    public ImageInfo(ByteString r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ImageInfo(ByteString r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mdata = r2;
        this.mtos_object = r3;
    }
}
