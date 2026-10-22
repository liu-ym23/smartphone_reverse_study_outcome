package com.ss.android.lark.pb.annotation;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Serde extends Message<Serde, Builder> {
    public static final ProtoAdapter<Serde> ADAPTER = null;
    public static final Boolean DEFAULT_DEFAULT_ = null;
    private static final long serialVersionUID = 0;
    public final Boolean mdefault_;

    public static final class Builder extends Message.Builder<Serde, Builder> {
        public Boolean mdefault_;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Serde m821build() {
            return new Serde(this.mdefault_, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m821build();
        }

        public Builder default_(Boolean r1) {
            this.mdefault_ = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Serde extends ProtoAdapter<Serde> {
        public ProtoAdapter_Serde() {
            super(FieldEncoding.LENGTH_DELIMITED, Serde.class);
        }

        public Serde decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mdefault_ = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mdefault_ = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m821build();
        }

        public int encodedSize(Serde r4) {
            Boolean r0 = r4.mdefault_;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m822decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Serde) r1);
        }

        public void encode(ProtoWriter r4, Serde r5) throws IOException {
            Boolean r0 = r5.mdefault_;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Serde) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Serde();
        DEFAULT_DEFAULT_ = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m820newBuilder() {
        Builder r0 = new Builder();
        r0.mdefault_ = this.mdefault_;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Serde.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m820newBuilder();
    }

    public Serde(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public Serde(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mdefault_ = r2;
    }
}
