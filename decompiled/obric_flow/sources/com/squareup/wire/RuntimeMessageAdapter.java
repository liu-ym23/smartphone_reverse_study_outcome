package com.squareup.wire;

import ai.j0;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    public RuntimeMessageAdapter(Class<M> r5, Class<B> r10, Map<Integer, FieldBinding<M, B>> r11) {
        super(FieldEncoding.LENGTH_DELIMITED, r5);
        this.messageType = r5;
        this.builderType = r10;
        this.fieldBindings = r11;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r10) {
        Class r5 = getBuilderType(r10);
        LinkedHashMap r11 = new LinkedHashMap();
        Field[] r12 = r10.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        Field r15 = r12[r14];
        WireField r16 = (WireField) r15.getAnnotation(WireField.class);
        if (r16 == null) goto L7;
        r11.put(Integer.valueOf(r16.tag()), new FieldBinding(r16, r15, r5));
    L7:
        r14 = r14 + 1;
        goto L3
    L9:
        return new RuntimeMessageAdapter(r10, r5, Collections.unmodifiableMap(r11));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r5) {
        return (Class<B>) Class.forName(r5.getName().concat("$Builder"));
    L6:
        throw new IllegalArgumentException("No builder class found for message type ".concat(r5.getName()));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r5) throws IOException {
        return decode(r5);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Object r10) throws IOException {
        encode(r5, (Message) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r5) {
        return encodedSize((Message) r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof RuntimeMessageAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeMessageAdapter) r5).messageType != this.messageType) goto L7;
        return true;
    }

    public Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public B newBuilder() {
        return this.builderType.newInstance();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r5) {
        return redact((Message) r5);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ String toString(Object r5) {
        return toString((Message) r5);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r10) throws IOException {
        Message.Builder r5 = newBuilder();
        long r11 = r10.beginMessage();
    L3:
        int r12 = r10.nextTag();
        if (r12 == (-1)) goto L17;
        FieldBinding<M, B> r13 = this.fieldBindings.get(Integer.valueOf(r12));
        if (r13 == null) goto L14;
        if (r13.isMap() == false) goto L12;
        ProtoAdapter<?> r14 = r13.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
    L13:
        r13.value(r5, r14.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        goto L3
    L12:
        r14 = r13.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
    L10:
        e = move-exception;
        r5.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L14:
        FieldEncoding r15 = r10.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        r5.addUnknownField(r12, r15, r15.rawProtoAdapter().decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        goto L3
    L17:
        r10.endMessage(r11);
        return (M) r5.build();
    }

    public void encode(ProtoWriter r5, M r10) throws IOException {
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        FieldBinding<M, B> r12 = r11.next();
        Object r13 = r12.get(r10);
        if (r13 == null) goto L4;
        r12.adapter().encodeWithTag(r5, r12.tag, r13);
        goto L4
    L9:
        r5.writeBytes(r10.unknownFields());
    }

    public int encodedSize(M r5) {
        int r10 = r5.cachedSerializedSize;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
        int r12 = 0;
    L7:
        if (r11.hasNext() == false) goto L12;
        FieldBinding<M, B> r13 = r11.next();
        Object r14 = r13.get(r5);
        if (r14 == null) goto L7;
        r12 = r12 + r13.adapter().encodedSizeWithTag(r13.tag, r14);
        goto L7
    L12:
        int r15 = r5.unknownFields().size() + r12;
        r5.cachedSerializedSize = r15;
        return r15;
    }

    public M redact(M r5) {
        Message.Builder<M, B> r10 = r5.newBuilder();
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L25;
        FieldBinding<M, B> r12 = r11.next();
        if (r12.redacted == true) goto L8;
    L12:
        boolean r13 = Message.class.isAssignableFrom(r12.singleAdapter().javaType);
        if (r12.redacted == true) goto L22;
        if (r13 == false) goto L18;
        if (r12.label.isRepeated() == false) goto L22;
    L18:
        if (r13 == false) goto L4;
        if (r12.label.isRepeated() == false) goto L4;
        Internal.redactElements((List) r12.getFromBuilder(r10), r12.singleAdapter());
    L22:
        Object r14 = r12.getFromBuilder(r10);
        if (r14 == null) goto L4;
        r12.set(r10, r12.adapter().redact(r14));
        goto L4
    L8:
        if (r12.label != WireField.Label.REQUIRED) goto L12;
        throw new UnsupportedOperationException(j0.l("Field '", r12.name, "' in ", this.javaType.getName(), " is required and cannot be redacted."));
    L25:
        r10.clearUnknownFields();
        return (M) r10.build();
    }

    public String toString(M r10) {
        StringBuilder r5 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        FieldBinding<M, B> r12 = r11.next();
        Object r13 = r12.get(r10);
        if (r13 == null) goto L4;
        r5.append(", ");
        r5.append(r12.name);
        r5.append('=');
        if (r12.redacted == false) goto L10;
        r13 = REDACTED;
    L10:
        r5.append(r13);
        goto L4
    L11:
        r5.replace(0, 2, this.messageType.getSimpleName().concat("{"));
        r5.append('}');
        return r5.toString();
    }
}
