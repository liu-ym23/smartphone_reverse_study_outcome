package com.obric.matrix.proto;

import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

    @SerializedName(NotificationCompat.CATEGORY_SERVICE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByCallBackRequest, Builder> {
        public Integer method;
        public Integer opt;
        public String packageName;
        public Integer service;

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.packageName = "";
            this.opt = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder method(Integer r5) {
            this.method = r5;
            return this;
        }

        public Builder opt(Integer r5) {
            this.opt = r5;
            return this;
        }

        public Builder packageName(String r5) {
            this.packageName = r5;
            return this;
        }

        public Builder service(Integer r5) {
            this.service = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByCallBackRequest build() {
            return new SubscribeWsMsgByCallBackRequest(this.service, this.method, this.packageName, this.opt, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByCallBackRequest extends ProtoAdapter<SubscribeWsMsgByCallBackRequest> {
        public ProtoAdapter_SubscribeWsMsgByCallBackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByCallBackRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByCallBackRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SubscribeWsMsgByCallBackRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByCallBackRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByCallBackRequest redact(SubscribeWsMsgByCallBackRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByCallBackRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r5.service(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.method(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r5.packageName(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r5.opt(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SubscribeWsMsgByCallBackRequest r10) throws IOException {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.encodeWithTag(r5, 1, r10.service);
            r11.encodeWithTag(r5, 2, r10.method);
            ProtoAdapter.STRING.encodeWithTag(r5, 3, r10.packageName);
            r11.encodeWithTag(r5, 4, r10.opt);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByCallBackRequest r5) {
            ProtoAdapter<Integer> r10 = ProtoAdapter.INT32;
            int r11 = r10.encodedSizeWithTag(1, r5.service);
            int r12 = r10.encodedSizeWithTag(2, r5.method) + r11;
            int r13 = ProtoAdapter.STRING.encodedSizeWithTag(3, r5.packageName) + r12;
            int r14 = r10.encodedSizeWithTag(4, r5.opt) + r13;
            return r5.unknownFields().size() + r14;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByCallBackRequest redact2(SubscribeWsMsgByCallBackRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByCallBackRequest();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
    }

    public SubscribeWsMsgByCallBackRequest(Integer r10, Integer r11, String r12, Integer r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByCallBackRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByCallBackRequest r10 = (SubscribeWsMsgByCallBackRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.service, r10.service) == false) goto L20;
        if (Internal.equals(this.method, r10.method) == false) goto L20;
        if (Internal.equals(this.packageName, r10.packageName) == false) goto L20;
        if (Internal.equals(this.opt, r10.opt) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.service;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.method;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.packageName;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Integer r21 = this.opt;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        int r22 = r20 + r12;
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.service == null) goto L6;
        r5.append(", service=");
        r5.append(this.service);
    L6:
        if (this.method == null) goto L9;
        r5.append(", method=");
        r5.append(this.method);
    L9:
        if (this.packageName == null) goto L12;
        r5.append(", packageName=");
        r5.append(this.packageName);
    L12:
        if (this.opt == null) goto L15;
        r5.append(", opt=");
        r5.append(this.opt);
    L15:
        return a.s(r5, 0, 2, "SubscribeWsMsgByCallBackRequest{", '}');
    }

    public SubscribeWsMsgByCallBackRequest(Integer r5, Integer r10, String r11, Integer r12, ByteString r13) {
        super(ADAPTER, r13);
        this.service = r5;
        this.method = r10;
        this.packageName = r11;
        this.opt = r12;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.service = this.service;
        r5.method = this.method;
        r5.packageName = this.packageName;
        r5.opt = this.opt;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
