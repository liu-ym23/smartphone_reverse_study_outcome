package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Image extends Message<Image, Builder> {
    public static final ProtoAdapter<Image> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final String mfs_unit;
    public final String mkey;

    public static final class Builder extends Message.Builder<Image, Builder> {
        public String mfs_unit;
        public String mkey;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Image m3146build() {
            String r0 = this.mkey;
            if (r0 == null) goto L9;
            if (this.mfs_unit == null) goto L9;
            return new Image(this.mkey, this.mfs_unit, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mkey", this.mfs_unit, "mfs_unit"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m3146build();
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
        public ProtoAdapter_Image() {
            super(FieldEncoding.LENGTH_DELIMITED, Image.class);
        }

        public Image decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mfs_unit = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m3146build();
        }

        public int encodedSize(Image r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5.mkey) + r0.encodedSizeWithTag(2, r5.mfs_unit)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m3147decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Image) r1);
        }

        public void encode(ProtoWriter r4, Image r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mkey);
            r0.encodeWithTag(r4, 2, r5.mfs_unit);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Image) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Image();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m3145newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mfs_unit = this.mfs_unit;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Image.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m3145newBuilder();
    }

    public Image(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Image(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mkey = r2;
        this.mfs_unit = r3;
    }
}
