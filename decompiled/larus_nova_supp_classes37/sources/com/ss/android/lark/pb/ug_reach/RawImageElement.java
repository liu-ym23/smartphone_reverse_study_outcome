package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RawImageElement extends Message<RawImageElement, Builder> {
    public static final ProtoAdapter<RawImageElement> ADAPTER = null;
    public static final ByteString DEFAULT_RAW_DATA = null;
    public static final ByteString DEFAULT_SECRETS = null;
    private static final long serialVersionUID = 0;
    public final ByteString mraw_data;
    public final ByteString msecrets;

    public static final class Builder extends Message.Builder<RawImageElement, Builder> {
        public ByteString mraw_data;
        public ByteString msecrets;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public RawImageElement m2453build() {
            return new RawImageElement(this.mraw_data, this.msecrets, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2453build();
        }

        public Builder raw_data(ByteString r1) {
            this.mraw_data = r1;
            return this;
        }

        public Builder secrets(ByteString r1) {
            this.msecrets = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RawImageElement extends ProtoAdapter<RawImageElement> {
        public ProtoAdapter_RawImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, RawImageElement.class);
        }

        public RawImageElement decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            ByteString r1 = ByteString.EMPTY;
            r0.mraw_data = r1;
            r0.msecrets = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mraw_data = (ByteString) ProtoAdapter.BYTES.decode(r7);
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
            r7.endMessage(r2);
            return r0.m2453build();
        }

        public int encodedSize(RawImageElement r5) {
            ByteString r0 = r5.mraw_data;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BYTES.encodedSizeWithTag(1, r0);
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
        public /* bridge */ /* synthetic */ Object m2454decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RawImageElement) r1);
        }

        public void encode(ProtoWriter r4, RawImageElement r5) throws IOException {
            ByteString r0 = r5.mraw_data;
            if (r0 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r4, 1, r0);
        L5:
            ByteString r1 = r5.msecrets;
            if (r1 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RawImageElement) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RawImageElement();
        ByteString r0 = ByteString.EMPTY;
        DEFAULT_RAW_DATA = r0;
        DEFAULT_SECRETS = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2452newBuilder() {
        Builder r0 = new Builder();
        r0.mraw_data = this.mraw_data;
        r0.msecrets = this.msecrets;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return RawImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2452newBuilder();
    }

    public RawImageElement(ByteString r2, ByteString r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RawImageElement(ByteString r2, ByteString r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mraw_data = r2;
        this.msecrets = r3;
    }
}
