package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class NullableMap extends Message<NullableMap, a> {
    public static final ProtoAdapter<NullableMap> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> _value;

    public static final class a extends Message.Builder<NullableMap, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f8181a;

        public a() {
            this.f8181a = Internal.newMutableMap();
        }

        public NullableMap a() {
            return new NullableMap(this.f8181a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<NullableMap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8182a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, NullableMap.class);
            this.f8182a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(NullableMap r3) {
            return this.f8182a.encodedSizeWithTag(1, r3._value) + r3.unknownFields().size();
        }

        public NullableMap a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.f8181a.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8182a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L9:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r3, NullableMap r4) {
            this.f8182a.encodeWithTag(r3, 1, r4._value);
            r3.writeBytes(r4.unknownFields());
        }

        public NullableMap b(NullableMap r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ NullableMap decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, NullableMap r4) {
            a(r3, (NullableMap) ZeusTransformUtils.preCheckCast(r4, NullableMap.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(NullableMap r3) {
            return a((NullableMap) ZeusTransformUtils.preCheckCast(r3, NullableMap.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ NullableMap redact(NullableMap r3) {
            return b((NullableMap) ZeusTransformUtils.preCheckCast(r3, NullableMap.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public NullableMap(Map<String, String> r3) {
        this((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public NullableMap(Map<String, String> r3, ByteString r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r4);
        this._value = Internal.immutableCopyOf("_value", r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NullableMap.class) == true) goto L8;
        return false;
    L8:
        NullableMap r6 = (NullableMap) ZeusTransformUtils.preCheckCast(r5, NullableMap.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this._value.equals(r6._value) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8181a = Internal.copyOf("_value", this._value);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, String> r1 = this._value;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=").append(this._value);
    L8:
        return r0.replace(0, 2, "NullableMap{").append('}').toString();
    }
}
