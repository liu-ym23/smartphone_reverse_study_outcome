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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class StringArray extends Message<StringArray, a> {
    public static final ProtoAdapter<StringArray> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> _value;

    public static final class a extends Message.Builder<StringArray, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f8233a;

        public a() {
            this.f8233a = Internal.newMutableList();
        }

        public StringArray a() {
            return new StringArray(this.f8233a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<StringArray> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StringArray.class);
        }

        public int a(StringArray r3) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r3._value) + r3.unknownFields().size();
        }

        public StringArray a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r6.f8233a.add((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r7), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r0);
            return r6.a();
        }

        public void a(ProtoWriter r3, StringArray r4) {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r3, 1, r4._value);
            r3.writeBytes(r4.unknownFields());
        }

        public StringArray b(StringArray r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StringArray decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, StringArray r4) {
            a(r3, (StringArray) ZeusTransformUtils.preCheckCast(r4, StringArray.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(StringArray r3) {
            return a((StringArray) ZeusTransformUtils.preCheckCast(r3, StringArray.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ StringArray redact(StringArray r3) {
            return b((StringArray) ZeusTransformUtils.preCheckCast(r3, StringArray.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public StringArray(List<String> r3) {
        this((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public StringArray(List<String> r3, ByteString r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r4);
        this._value = Internal.immutableCopyOf("_value", r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StringArray.class) == true) goto L8;
        return false;
    L8:
        StringArray r6 = (StringArray) ZeusTransformUtils.preCheckCast(r5, StringArray.class, "com.obric.memorydata.plugin");
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
        r0.f8233a = Internal.copyOf("_value", this._value);
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
        List<String> r1 = this._value;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", _value=").append(this._value);
    L8:
        return r0.replace(0, 2, "StringArray{").append('}').toString();
    }
}
