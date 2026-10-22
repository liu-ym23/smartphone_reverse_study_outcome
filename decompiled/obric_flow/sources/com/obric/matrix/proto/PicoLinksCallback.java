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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class PicoLinksCallback extends Message<PicoLinksCallback, Builder> {
    public static final ProtoAdapter<PicoLinksCallback> ADAPTER = null;
    public static final Integer DEFAULT_CALLBACKID = null;
    private static final long serialVersionUID = 0;

    @SerializedName("callbackData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> callbackData;

    @SerializedName("callbackId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer callbackId;

    public static final class Builder extends Message.Builder<PicoLinksCallback, Builder> {
        public Map<String, String> callbackData;
        public Integer callbackId;

        public Builder() {
            this.callbackId = 0;
            this.callbackData = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder callbackData(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.callbackData = r5;
            return this;
        }

        public Builder callbackId(Integer r5) {
            this.callbackId = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public PicoLinksCallback build() {
            return new PicoLinksCallback(this.callbackId, this.callbackData, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_PicoLinksCallback extends ProtoAdapter<PicoLinksCallback> {
        private final ProtoAdapter<Map<String, String>> callbackData;

        public ProtoAdapter_PicoLinksCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.callbackData = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, PicoLinksCallback r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PicoLinksCallback r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback redact(PicoLinksCallback r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PicoLinksCallback decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.callbackId(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.callbackData.putAll(this.callbackData.decode(r10));
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
        public void encode2(ProtoWriter r5, PicoLinksCallback r10) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r5, 1, r10.callbackId);
            this.callbackData.encodeWithTag(r5, 2, r10.callbackData);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PicoLinksCallback r5) {
            int r10 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.callbackId);
            int r11 = this.callbackData.encodedSizeWithTag(2, r5.callbackData) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public PicoLinksCallback redact2(PicoLinksCallback r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PicoLinksCallback();
        DEFAULT_CALLBACKID = 0;
    }

    public PicoLinksCallback(Integer r5, Map<String, String> r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PicoLinksCallback) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r10 = (PicoLinksCallback) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.callbackId, r10.callbackId) == false) goto L16;
        if (this.callbackData.equals(r10.callbackData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.callbackId;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = ((r10 + r12) * 37) + this.callbackData.hashCode();
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.callbackId == null) goto L5;
        r5.append(", callbackId=");
        r5.append(this.callbackId);
    L5:
        Map<String, String> r10 = this.callbackData;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", callbackData=");
        r5.append(this.callbackData);
    L11:
        return a.s(r5, 0, 2, "PicoLinksCallback{", '}');
    }

    public PicoLinksCallback(Integer r5, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.callbackId = r5;
        this.callbackData = Internal.immutableCopyOf("callbackData", r10);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.callbackId = this.callbackId;
        r5.callbackData = Internal.copyOf("callbackData", this.callbackData);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
