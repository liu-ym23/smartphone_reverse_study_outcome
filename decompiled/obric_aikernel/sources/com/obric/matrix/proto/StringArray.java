package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class StringArray extends Message<StringArray, a> {
    public static final ProtoAdapter<StringArray> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    @c("_value")
    public final List<String> _value;

    public static final class a extends Message.Builder<StringArray, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f6103a;

        public a() {
            this.f6103a = Internal.newMutableList();
        }

        public StringArray a() {
            return new StringArray(this.f6103a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<StringArray> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, StringArray.class);
        }

        public StringArray a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.f6103a.add(ProtoAdapter.STRING.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, StringArray r11) {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r10, 1, r11._value);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(StringArray r10) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r10._value) + r10.unknownFields().size();
        }

        public StringArray d(StringArray r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, StringArray r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StringArray r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StringArray redact(StringArray r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public StringArray(List<String> r10) {
        this(r10, ByteString.EMPTY);
    }

    public StringArray(List<String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this._value = Internal.immutableCopyOf("_value", r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof StringArray) == true) goto L8;
        return false;
    L8:
        StringArray r11 = (StringArray) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (this._value.equals(r11._value) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6103a = Internal.copyOf("_value", this._value);
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
        List<String> r11 = this._value;
        if (r11 != null) goto L5;
    L7:
        StringBuilder r12 = r10.replace(0, 2, "StringArray{");
        r12.append('}');
        return r12.toString();
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", _value=");
        r10.append(this._value);
        goto L7
    }
}
