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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
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

        public PicoLinksCallback build() {
            return new PicoLinksCallback(this.callbackId, this.callbackData, super.buildUnknownFields());
        }

        public Builder() {
            this.callbackId = 0;
            this.callbackData = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m134build() {
            return build();
        }

        public Builder callbackData(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.callbackData = r1;
            return this;
        }

        public Builder callbackId(Integer r1) {
            this.callbackId = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PicoLinksCallback extends ProtoAdapter<PicoLinksCallback> {
        private final ProtoAdapter<Map<String, String>> callbackData;

        public ProtoAdapter_PicoLinksCallback() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.callbackData = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public PicoLinksCallback decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.callbackId((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.callbackData.putAll((Map) this.callbackData.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(PicoLinksCallback r5) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r5.callbackId) + this.callbackData.encodedSizeWithTag(2, r5.callbackData)) + r5.unknownFields().size();
        }

        public PicoLinksCallback redact(PicoLinksCallback r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m135decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PicoLinksCallback) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((PicoLinksCallback) r1);
        }

        public void encode(ProtoWriter r4, PicoLinksCallback r5) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.callbackId);
            this.callbackData.encodeWithTag(r4, 2, r5.callbackData);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PicoLinksCallback) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PicoLinksCallback();
        DEFAULT_CALLBACKID = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.callbackId;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.callbackData.hashCode();
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.callbackId = this.callbackId;
        r0.callbackData = Internal.copyOf("callbackData", this.callbackData);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.callbackId == null) goto L5;
        r0.append(", callbackId=");
        r0.append(this.callbackId);
    L5:
        Map<String, String> r1 = this.callbackData;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r2 = r0.replace(0, 2, "PicoLinksCallback{");
        r2.append('}');
        return r2.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", callbackData=");
        r0.append(this.callbackData);
        goto L10
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m133newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof PicoLinksCallback) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r6 = (PicoLinksCallback) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.callbackId, r6.callbackId) == false) goto L15;
        if (this.callbackData.equals(r6.callbackData) == false) goto L15;
        return true;
    }

    public PicoLinksCallback(Integer r2, Map<String, String> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PicoLinksCallback(Integer r2, Map<String, String> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.callbackId = r2;
        this.callbackData = Internal.immutableCopyOf("callbackData", r3);
    }
}
