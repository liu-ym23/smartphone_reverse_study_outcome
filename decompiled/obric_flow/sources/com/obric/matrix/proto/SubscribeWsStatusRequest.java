package com.obric.matrix.proto;

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

        public Builder() {
            this.opt = 0;
            this.packageName = "";
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder opt(Integer r5) {
            this.opt = r5;
            return this;
        }

        public Builder packageName(String r5) {
            this.packageName = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsStatusRequest build() {
            return new SubscribeWsStatusRequest(this.opt, this.packageName, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusRequest extends ProtoAdapter<SubscribeWsStatusRequest> {
        public ProtoAdapter_SubscribeWsStatusRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SubscribeWsStatusRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusRequest redact(SubscribeWsStatusRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsStatusRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.opt(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.packageName(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SubscribeWsStatusRequest r10) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r5, 1, r10.opt);
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r10.packageName);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsStatusRequest r5) {
            int r10 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.opt);
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(2, r5.packageName) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsStatusRequest redact2(SubscribeWsStatusRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusRequest();
        DEFAULT_OPT = 0;
    }

    public SubscribeWsStatusRequest(Integer r5, String r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusRequest r10 = (SubscribeWsStatusRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.opt, r10.opt) == false) goto L16;
        if (Internal.equals(this.packageName, r10.packageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.opt;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.packageName;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        int r16 = r14 + r12;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.opt == null) goto L6;
        r5.append(", opt=");
        r5.append(this.opt);
    L6:
        if (this.packageName == null) goto L9;
        r5.append(", packageName=");
        r5.append(this.packageName);
    L9:
        return a.s(r5, 0, 2, "SubscribeWsStatusRequest{", '}');
    }

    public SubscribeWsStatusRequest(Integer r5, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.opt = r5;
        this.packageName = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.opt = this.opt;
        r5.packageName = this.packageName;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
