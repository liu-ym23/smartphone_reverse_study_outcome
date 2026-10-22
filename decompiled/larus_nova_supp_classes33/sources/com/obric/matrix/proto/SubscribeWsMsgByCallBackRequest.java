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
public final class SubscribeWsMsgByCallBackRequest extends Message<SubscribeWsMsgByCallBackRequest, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByCallBackRequest> ADAPTER = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String packageName;

    @SerializedName("service")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByCallBackRequest, Builder> {
        public Integer method;
        public Integer opt;
        public String packageName;
        public Integer service;

        public SubscribeWsMsgByCallBackRequest build() {
            return new SubscribeWsMsgByCallBackRequest(this.service, this.method, this.packageName, this.opt, super.buildUnknownFields());
        }

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.packageName = "";
            this.opt = 0;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m203build() {
            return build();
        }

        public Builder method(Integer r1) {
            this.method = r1;
            return this;
        }

        public Builder opt(Integer r1) {
            this.opt = r1;
            return this;
        }

        public Builder packageName(String r1) {
            this.packageName = r1;
            return this;
        }

        public Builder service(Integer r1) {
            this.service = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByCallBackRequest extends ProtoAdapter<SubscribeWsMsgByCallBackRequest> {
        public ProtoAdapter_SubscribeWsMsgByCallBackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByCallBackRequest.class);
        }

        public SubscribeWsMsgByCallBackRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.service((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.method((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.packageName((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.opt((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsMsgByCallBackRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            return (((r0.encodedSizeWithTag(1, r6.service) + r0.encodedSizeWithTag(2, r6.method)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r6.packageName)) + r0.encodedSizeWithTag(4, r6.opt)) + r6.unknownFields().size();
        }

        public SubscribeWsMsgByCallBackRequest redact(SubscribeWsMsgByCallBackRequest r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m204decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsMsgByCallBackRequest) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsMsgByCallBackRequest) r1);
        }

        public void encode(ProtoWriter r5, SubscribeWsMsgByCallBackRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r5, 1, r6.service);
            r0.encodeWithTag(r5, 2, r6.method);
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r6.packageName);
            r0.encodeWithTag(r5, 4, r6.opt);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsMsgByCallBackRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByCallBackRequest();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.service;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.method;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.packageName;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.opt;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.service = this.service;
        r0.method = this.method;
        r0.packageName = this.packageName;
        r0.opt = this.opt;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.service == null) goto L6;
        r0.append(", service=");
        r0.append(this.service);
    L6:
        if (this.method == null) goto L9;
        r0.append(", method=");
        r0.append(this.method);
    L9:
        if (this.packageName == null) goto L12;
        r0.append(", packageName=");
        r0.append(this.packageName);
    L12:
        if (this.opt == null) goto L14;
        r0.append(", opt=");
        r0.append(this.opt);
    L14:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsMsgByCallBackRequest{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m202newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByCallBackRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByCallBackRequest r6 = (SubscribeWsMsgByCallBackRequest) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.service, r6.service) == false) goto L19;
        if (Internal.equals(this.method, r6.method) == false) goto L19;
        if (Internal.equals(this.packageName, r6.packageName) == false) goto L19;
        if (Internal.equals(this.opt, r6.opt) == false) goto L19;
        return true;
    }

    public SubscribeWsMsgByCallBackRequest(Integer r7, Integer r8, String r9, Integer r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SubscribeWsMsgByCallBackRequest(Integer r2, Integer r3, String r4, Integer r5, ByteString r6) {
        super(ADAPTER, r6);
        this.service = r2;
        this.method = r3;
        this.packageName = r4;
        this.opt = r5;
    }
}
