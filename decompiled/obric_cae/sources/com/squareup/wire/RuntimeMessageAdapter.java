package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    public RuntimeMessageAdapter(Class<M> r8, Class<B> r10, Map<Integer, FieldBinding<M, B>> r11) {
        super(FieldEncoding.LENGTH_DELIMITED, r8);
        this.messageType = r8;
        this.builderType = r10;
        this.fieldBindings = r11;
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r10) {
        Class r8 = getBuilderType(r10);
        LinkedHashMap r11 = new LinkedHashMap();
        Field[] r12 = r10.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        Field r15 = r12[r14];
        WireField r16 = (WireField) r15.getAnnotation(WireField.class);
        if (r16 == null) goto L7;
        r11.put(Integer.valueOf(r16.tag()), new FieldBinding(r16, r15, r8));
    L7:
        r14 = r14 + 1;
        goto L3
    L9:
        return new RuntimeMessageAdapter(r10, r8, Collections.unmodifiableMap(r11));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r8) {
        return (Class<B>) Class.forName(r8.getName().concat("$Builder"));
    L6:
        throw new IllegalArgumentException("No builder class found for message type ".concat(r8.getName()));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r10) {
        Message.Builder r8 = newBuilder();
        long r11 = r10.beginMessage();
    L3:
        int r12 = r10.nextTag();
        if (r12 == (-1)) goto L16;
        FieldBinding<M, B> r13 = this.fieldBindings.get(Integer.valueOf(r12));
        if (r13 == null) goto L12;
        if (r13.isMap() == false) goto L10;
        ProtoAdapter<?> r14 = r13.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L11:
        r13.value(r8, r14.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L10:
        r14 = r13.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L14:
        e = move-exception;
        r8.addUnknownField(r12, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L12:
        FieldEncoding r15 = r10.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        r8.addUnknownField(r12, r15, r15.rawProtoAdapter().decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L16:
        r10.endMessage(r11);
        return (M) r8.build();
    }

    public void encode(ProtoWriter r8, M r10) {
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        FieldBinding<M, B> r12 = r11.next();
        Object r13 = r12.get(r10);
        if (r13 == null) goto L4;
        r12.adapter().encodeWithTag(r8, r12.tag, r13);
        goto L4
    L9:
        r8.writeBytes(r10.unknownFields());
    }

    public int encodedSize(M r8) {
        int r10 = r8.cachedSerializedSize;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
        int r12 = 0;
    L7:
        if (r11.hasNext() == false) goto L12;
        FieldBinding<M, B> r13 = r11.next();
        Object r14 = r13.get(r8);
        if (r14 == null) goto L7;
        r12 = r12 + r13.adapter().encodedSizeWithTag(r13.tag, r14);
        goto L7
    L12:
        int r15 = r8.unknownFields().l() + r12;
        r8.cachedSerializedSize = r15;
        return r15;
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof RuntimeMessageAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeMessageAdapter) r8).messageType != this.messageType) goto L7;
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

    public M redact(M r8) {
        Message.Builder<M, B> r10 = r8.newBuilder();
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
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{r12.name, this.javaType.getName()}));
    L25:
        r10.clearUnknownFields();
        return (M) r10.build();
    }

    public String toString(M r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r11 = this.fieldBindings.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        FieldBinding<M, B> r12 = r11.next();
        Object r13 = r12.get(r8);
        if (r13 == null) goto L4;
        r10.append(", ");
        r10.append(r12.name);
        r10.append('=');
        if (r12.redacted == false) goto L10;
        r13 = REDACTED;
    L10:
        r10.append(r13);
        goto L4
    L11:
        r10.replace(0, 2, this.messageType.getSimpleName().concat("{"));
        r10.append('}');
        return r10.toString();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r8) {
        return decode(r8);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r8, Object r10) {
        encode(r8, (Message) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r8) {
        return encodedSize((Message) r8);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r8) {
        return redact((Message) r8);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ String toString(Object r8) {
        return toString((Message) r8);
    }
}
