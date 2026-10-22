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
public final class RefreshLocationResponse extends Message<RefreshLocationResponse, Builder> {
    public static final ProtoAdapter<RefreshLocationResponse> ADAPTER = null;
    public static final Integer DEFAULT_RESULTCODE = null;
    public static final Integer DEFAULT_RESULTMSG = null;
    private static final long serialVersionUID = 0;

    @SerializedName("resultCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer resultCode;

    @SerializedName("resultMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer resultMsg;

    public static final class Builder extends Message.Builder<RefreshLocationResponse, Builder> {
        public Integer resultCode;
        public Integer resultMsg;

        public RefreshLocationResponse build() {
            return new RefreshLocationResponse(this.resultCode, this.resultMsg, super.buildUnknownFields());
        }

        public Builder() {
            this.resultCode = 0;
            this.resultMsg = 0;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m146build() {
            return build();
        }

        public Builder resultCode(Integer r1) {
            this.resultCode = r1;
            return this;
        }

        public Builder resultMsg(Integer r1) {
            this.resultMsg = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RefreshLocationResponse extends ProtoAdapter<RefreshLocationResponse> {
        public ProtoAdapter_RefreshLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        public RefreshLocationResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.resultCode((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.resultMsg((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(RefreshLocationResponse r5) {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            return (r0.encodedSizeWithTag(1, r5.resultCode) + r0.encodedSizeWithTag(2, r5.resultMsg)) + r5.unknownFields().size();
        }

        public RefreshLocationResponse redact(RefreshLocationResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m147decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RefreshLocationResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((RefreshLocationResponse) r1);
        }

        public void encode(ProtoWriter r4, RefreshLocationResponse r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r4, 1, r5.resultCode);
            r0.encodeWithTag(r4, 2, r5.resultMsg);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RefreshLocationResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationResponse();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.resultCode;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.resultMsg;
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
        r0.resultCode = this.resultCode;
        r0.resultMsg = this.resultMsg;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.resultCode == null) goto L6;
        r0.append(", resultCode=");
        r0.append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L8;
        r0.append(", resultMsg=");
        r0.append(this.resultMsg);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "RefreshLocationResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m145newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationResponse) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r6 = (RefreshLocationResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.resultCode, r6.resultCode) == false) goto L15;
        if (Internal.equals(this.resultMsg, r6.resultMsg) == false) goto L15;
        return true;
    }

    public RefreshLocationResponse(Integer r2, Integer r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public RefreshLocationResponse(Integer r2, Integer r3, ByteString r4) {
        super(ADAPTER, r4);
        this.resultCode = r2;
        this.resultMsg = r3;
    }
}
