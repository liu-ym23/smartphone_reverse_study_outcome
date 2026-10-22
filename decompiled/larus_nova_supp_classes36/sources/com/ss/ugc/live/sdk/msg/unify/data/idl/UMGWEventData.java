package com.ss.ugc.live.sdk.msg.unify.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UMGWEventData extends AndroidMessage<UMGWEventData, Builder> {
    public static final ProtoAdapter<UMGWEventData> ADAPTER = null;
    public static final Parcelable.Creator<UMGWEventData> CREATOR = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Integer DEFAULT_SERVICE = null;
    public static final Long DEFAULT_TOKEN = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer method;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWCustomData#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<UMGWCustomData> params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer service;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long token;

    public static final class Builder extends Message.Builder<UMGWEventData, Builder> {
        public Integer method;
        public List<UMGWCustomData> params;
        public ByteString payload;
        public Integer service;
        public Long token;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWEventData m1697build() {
            return new UMGWEventData(this.service, this.method, this.token, this.params, this.payload, super.buildUnknownFields());
        }

        public Builder() {
            this.service = 0;
            this.method = 0;
            this.token = 0L;
            this.payload = ByteString.EMPTY;
            this.params = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1697build();
        }

        public Builder method(Integer r1) {
            this.method = r1;
            return this;
        }

        public Builder params(List<UMGWCustomData> r1) {
            Internal.checkElementsNotNull(r1);
            this.params = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder service(Integer r1) {
            this.service = r1;
            return this;
        }

        public Builder token(Long r1) {
            this.token = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWEventData extends ProtoAdapter<UMGWEventData> {
        public ProtoAdapter_UMGWEventData() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWEventData.class);
        }

        public UMGWEventData decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.service((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.method((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.token((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.params.add((UMGWCustomData) UMGWCustomData.ADAPTER.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.payload((ByteString) ProtoAdapter.BYTES.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1697build();
        }

        public int encodedSize(UMGWEventData r5) {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            return ((((r0.encodedSizeWithTag(1, r5.service) + r0.encodedSizeWithTag(2, r5.method)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r5.token)) + UMGWCustomData.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.params)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r5.payload)) + r5.unknownFields().size();
        }

        public UMGWEventData redact(UMGWEventData r3) {
            Builder r4 = r3.m1696newBuilder();
            Internal.redactElements(r4.params, UMGWCustomData.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1697build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1698decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWEventData) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWEventData) r1);
        }

        public void encode(ProtoWriter r4, UMGWEventData r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r4, 1, r5.service);
            r0.encodeWithTag(r4, 2, r5.method);
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r5.token);
            UMGWCustomData.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.params);
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r5.payload);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWEventData) r2);
        }
    }

    static {
        ProtoAdapter_UMGWEventData r0 = new ProtoAdapter_UMGWEventData();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_TOKEN = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
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
        Long r9 = this.token;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.params.hashCode()) * 37;
        ByteString r12 = this.payload;
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

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1696newBuilder() {
        Builder r0 = new Builder();
        r0.service = this.service;
        r0.method = this.method;
        r0.token = this.token;
        r0.params = Internal.copyOf("params", this.params);
        r0.payload = this.payload;
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
        if (this.token == null) goto L11;
        r0.append(", token=");
        r0.append(this.token);
    L11:
        List<UMGWCustomData> r1 = this.params;
        if (r1 != null) goto L14;
    L16:
        StringBuilder r2 = r0.replace(0, 2, "UMGWEventData{");
        r2.append('}');
        return r2.toString();
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", params=");
        r0.append(this.params);
        goto L16
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1696newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWEventData) == true) goto L8;
        return false;
    L8:
        UMGWEventData r6 = (UMGWEventData) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.service, r6.service) == false) goto L21;
        if (Internal.equals(this.method, r6.method) == false) goto L21;
        if (Internal.equals(this.token, r6.token) == false) goto L21;
        if (this.params.equals(r6.params) == false) goto L21;
        if (Internal.equals(this.payload, r6.payload) == false) goto L21;
        return true;
    }

    public UMGWEventData(Integer r8, Integer r9, Long r10, List<UMGWCustomData> r11, ByteString r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public UMGWEventData(Integer r2, Integer r3, Long r4, List<UMGWCustomData> r5, ByteString r6, ByteString r7) {
        super(ADAPTER, r7);
        this.service = r2;
        this.method = r3;
        this.token = r4;
        this.params = Internal.immutableCopyOf("params", r5);
        this.payload = r6;
    }
}
