package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ShellApi extends Message<ShellApi, Builder> {
    public static final ProtoAdapter<ShellApi> ADAPTER = null;
    public static final String DEFAULT_PARAMS = "";
    private static final long serialVersionUID = 0;
    public final String mparams;
    public final ShellApiType mtype;

    public static final class Builder extends Message.Builder<ShellApi, Builder> {
        public String mparams;
        public ShellApiType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ShellApi m2843build() {
            return new ShellApi(this.mtype, this.mparams, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2843build();
        }

        public Builder params(String r1) {
            this.mparams = r1;
            return this;
        }

        public Builder type(ShellApiType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ShellApi extends ProtoAdapter<ShellApi> {
        public ProtoAdapter_ShellApi() {
            super(FieldEncoding.LENGTH_DELIMITED, ShellApi.class);
        }

        public ShellApi decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mparams = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtype = (ShellApiType) ShellApiType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mparams = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2843build();
        }

        public int encodedSize(ShellApi r5) {
            ShellApiType r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ShellApiType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mparams;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2844decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ShellApi) r1);
        }

        public void encode(ProtoWriter r4, ShellApi r5) throws IOException {
            ShellApiType r0 = r5.mtype;
            if (r0 == null) goto L5;
            ShellApiType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mparams;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ShellApi) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ShellApi();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2842newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mparams = this.mparams;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ShellApi.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2842newBuilder();
    }

    public ShellApi(ShellApiType r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ShellApi(ShellApiType r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mparams = r3;
    }
}
