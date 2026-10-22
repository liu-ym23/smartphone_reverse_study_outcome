package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CdnImageElement extends Message<CdnImageElement, Builder> {
    public static final ProtoAdapter<CdnImageElement> ADAPTER = null;
    public static final ByteString DEFAULT_SECRETS = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final ByteString msecrets;
    public final String murl;

    public static final class Builder extends Message.Builder<CdnImageElement, Builder> {
        public ByteString msecrets;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CdnImageElement m2435build() {
            return new CdnImageElement(this.murl, this.msecrets, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2435build();
        }

        public Builder secrets(ByteString r1) {
            this.msecrets = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CdnImageElement extends ProtoAdapter<CdnImageElement> {
        public ProtoAdapter_CdnImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, CdnImageElement.class);
        }

        public CdnImageElement decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.murl = "";
            r0.msecrets = ByteString.EMPTY;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.msecrets = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2435build();
        }

        public int encodedSize(CdnImageElement r5) {
            String r0 = r5.murl;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ByteString r3 = r5.msecrets;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2436decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CdnImageElement) r1);
        }

        public void encode(ProtoWriter r4, CdnImageElement r5) throws IOException {
            String r0 = r5.murl;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.msecrets;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CdnImageElement) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CdnImageElement();
        DEFAULT_SECRETS = ByteString.EMPTY;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2434newBuilder() {
        Builder r0 = new Builder();
        r0.murl = this.murl;
        r0.msecrets = this.msecrets;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CdnImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2434newBuilder();
    }

    public CdnImageElement(String r2, ByteString r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CdnImageElement(String r2, ByteString r3, ByteString r4) {
        super(ADAPTER, r4);
        this.murl = r2;
        this.msecrets = r3;
    }
}
