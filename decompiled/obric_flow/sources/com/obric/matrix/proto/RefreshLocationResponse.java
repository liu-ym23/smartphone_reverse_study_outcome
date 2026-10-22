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

        public Builder() {
            this.resultCode = 0;
            this.resultMsg = 0;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder resultCode(Integer r5) {
            this.resultCode = r5;
            return this;
        }

        public Builder resultMsg(Integer r5) {
            this.resultMsg = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RefreshLocationResponse build() {
            return new RefreshLocationResponse(this.resultCode, this.resultMsg, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_RefreshLocationResponse extends ProtoAdapter<RefreshLocationResponse> {
        public ProtoAdapter_RefreshLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, RefreshLocationResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, RefreshLocationResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RefreshLocationResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RefreshLocationResponse redact(RefreshLocationResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RefreshLocationResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.resultCode(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.resultMsg(ProtoAdapter.INT32.decode(r10));
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
        public void encode2(ProtoWriter r5, RefreshLocationResponse r10) throws IOException {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.encodeWithTag(r5, 1, r10.resultCode);
            r11.encodeWithTag(r5, 2, r10.resultMsg);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RefreshLocationResponse r5) {
            ProtoAdapter<Integer> r10 = ProtoAdapter.INT32;
            int r11 = r10.encodedSizeWithTag(1, r5.resultCode);
            int r12 = r10.encodedSizeWithTag(2, r5.resultMsg) + r11;
            return r5.unknownFields().size() + r12;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RefreshLocationResponse redact2(RefreshLocationResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RefreshLocationResponse();
        DEFAULT_RESULTCODE = 0;
        DEFAULT_RESULTMSG = 0;
    }

    public RefreshLocationResponse(Integer r5, Integer r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RefreshLocationResponse) == true) goto L8;
        return false;
    L8:
        RefreshLocationResponse r10 = (RefreshLocationResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.resultCode, r10.resultCode) == false) goto L16;
        if (Internal.equals(this.resultMsg, r10.resultMsg) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.resultCode;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.resultMsg;
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
        if (this.resultCode == null) goto L6;
        r5.append(", resultCode=");
        r5.append(this.resultCode);
    L6:
        if (this.resultMsg == null) goto L9;
        r5.append(", resultMsg=");
        r5.append(this.resultMsg);
    L9:
        return a.s(r5, 0, 2, "RefreshLocationResponse{", '}');
    }

    public RefreshLocationResponse(Integer r5, Integer r10, ByteString r11) {
        super(ADAPTER, r11);
        this.resultCode = r5;
        this.resultMsg = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.resultCode = this.resultCode;
        r5.resultMsg = this.resultMsg;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
