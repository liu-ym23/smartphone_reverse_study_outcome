package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SubscribeWsStatusRequest extends Message<SubscribeWsStatusRequest, Builder> {
    public static final ProtoAdapter<SubscribeWsStatusRequest> ADAPTER = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String packageName;

    public static final class Builder extends Message.Builder<SubscribeWsStatusRequest, Builder> {
        public Integer opt;
        public String packageName;

        public SubscribeWsStatusRequest build() {
            return new SubscribeWsStatusRequest(this.opt, this.packageName, super.buildUnknownFields());
        }

        public Builder() {
            this.opt = 0;
            this.packageName = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m221build() {
            return build();
        }

        public Builder opt(Integer r1) {
            this.opt = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusRequest extends ProtoAdapter<SubscribeWsStatusRequest> {
        public ProtoAdapter_SubscribeWsStatusRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusRequest.class);
        }

        public SubscribeWsStatusRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.opt((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.packageName((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsStatusRequest r5) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r5.opt) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.packageName)) + r5.unknownFields().size();
        }

        public SubscribeWsStatusRequest redact(SubscribeWsStatusRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m222decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsStatusRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsStatusRequest) r1);
        }

        public void encode(ProtoWriter r4, SubscribeWsStatusRequest r5) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.opt);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.packageName);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsStatusRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusRequest();
        DEFAULT_OPT = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.opt;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.packageName;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.opt = this.opt;
        r0.packageName = this.packageName;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.opt == null) goto L6;
        r0.append(", opt=");
        r0.append(this.opt);
    L6:
        if (this.packageName == null) goto L8;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsStatusRequest{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m220newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusRequest r6 = (SubscribeWsStatusRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.opt, r6.opt) == false) goto L15;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L15;
        return true;
    }

    public SubscribeWsStatusRequest(Integer r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SubscribeWsStatusRequest(Integer r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.opt = r2;
        this.packageName = r3;
    }
}
