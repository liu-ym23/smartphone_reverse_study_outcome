package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class PicoLinksCallback extends Message<PicoLinksCallback, a> {
    public static final ProtoAdapter<PicoLinksCallback> ADAPTER = null;
    public static final Integer DEFAULT_CALLBACKID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("callbackData")
    public final Map<String, String> callbackData;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("callbackId")
    public final Integer callbackId;

    public static final class a extends Message.Builder<PicoLinksCallback, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f6007b;

        public a() {
            this.f6006a = 0;
            this.f6007b = Internal.newMutableMap();
        }

        public PicoLinksCallback a() {
            return new PicoLinksCallback(this.f6006a, this.f6007b, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f6006a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<PicoLinksCallback> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6008a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6008a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public PicoLinksCallback a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.f6007b.putAll(this.f6008a.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, PicoLinksCallback r11) {
            ProtoAdapter.INT32.encodeWithTag(r10, 1, r11.callbackId);
            this.f6008a.encodeWithTag(r10, 2, r11.callbackData);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(PicoLinksCallback r10) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r10.callbackId) + this.f6008a.encodedSizeWithTag(2, r10.callbackData)) + r10.unknownFields().size();
        }

        public PicoLinksCallback d(PicoLinksCallback r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, PicoLinksCallback r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PicoLinksCallback r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PicoLinksCallback redact(PicoLinksCallback r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CALLBACKID = 0;
    }

    public PicoLinksCallback(Integer r10, Map<String, String> r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public PicoLinksCallback(Integer r10, Map<String, String> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.callbackId = r10;
        this.callbackData = Internal.immutableCopyOf("callbackData", r11);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof PicoLinksCallback) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r11 = (PicoLinksCallback) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.callbackId, r11.callbackId) == false) goto L16;
        if (this.callbackData.equals(r11.callbackData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.callbackId;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = ((r11 + r13) * 37) + this.callbackData.hashCode();
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6006a = this.callbackId;
        r10.f6007b = Internal.copyOf("callbackData", this.callbackData);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.callbackId == null) goto L5;
        r10.append(", callbackId=");
        r10.append(this.callbackId);
    L5:
        Map<String, String> r11 = this.callbackData;
        if (r11 != null) goto L8;
    L10:
        StringBuilder r12 = r10.replace(0, 2, "PicoLinksCallback{");
        r12.append('}');
        return r12.toString();
    L8:
        if (r11.isEmpty() == true) goto L10;
        r10.append(", callbackData=");
        r10.append(this.callbackData);
        goto L10
    }
}
