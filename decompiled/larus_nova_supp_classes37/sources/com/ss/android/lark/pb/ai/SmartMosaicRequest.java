package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SmartMosaicRequest extends Message<SmartMosaicRequest, Builder> {
    public static final ProtoAdapter<SmartMosaicRequest> ADAPTER = null;
    public static final Boolean DEFAULT_AVATAR = null;
    public static final Boolean DEFAULT_TEXT = null;
    private static final long serialVersionUID = 0;
    public final Boolean mavatar;
    public final ImageInfo mimage;
    public final Boolean mtext;

    public static final class Builder extends Message.Builder<SmartMosaicRequest, Builder> {
        public Boolean mavatar;
        public ImageInfo mimage;
        public Boolean mtext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SmartMosaicRequest m770build() {
            ImageInfo r0 = this.mimage;
            if (r0 == null) goto L7;
            return new SmartMosaicRequest(this.mimage, this.mtext, this.mavatar, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mimage"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m770build();
        }

        public Builder avatar(Boolean r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder image(ImageInfo r1) {
            this.mimage = r1;
            return this;
        }

        public Builder text(Boolean r1) {
            this.mtext = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SmartMosaicRequest extends ProtoAdapter<SmartMosaicRequest> {
        public ProtoAdapter_SmartMosaicRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SmartMosaicRequest.class);
        }

        public SmartMosaicRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.TRUE;
            r0.mtext = r1;
            r0.mavatar = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mimage = (ImageInfo) ImageInfo.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtext = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mavatar = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.m770build();
        }

        public int encodedSize(SmartMosaicRequest r6) {
            int r0 = ImageInfo.ADAPTER.encodedSizeWithTag(1, r6.mimage);
            Boolean r1 = r6.mtext;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Boolean r5 = r6.mavatar;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m771decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SmartMosaicRequest) r1);
        }

        public void encode(ProtoWriter r4, SmartMosaicRequest r5) throws IOException {
            ImageInfo.ADAPTER.encodeWithTag(r4, 1, r5.mimage);
            Boolean r0 = r5.mtext;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
        L5:
            Boolean r1 = r5.mavatar;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SmartMosaicRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmartMosaicRequest();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_TEXT = r0;
        DEFAULT_AVATAR = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m769newBuilder() {
        Builder r0 = new Builder();
        r0.mimage = this.mimage;
        r0.mtext = this.mtext;
        r0.mavatar = this.mavatar;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SmartMosaicRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m769newBuilder();
    }

    public SmartMosaicRequest(ImageInfo r2, Boolean r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public SmartMosaicRequest(ImageInfo r2, Boolean r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mimage = r2;
        this.mtext = r3;
        this.mavatar = r4;
    }
}
