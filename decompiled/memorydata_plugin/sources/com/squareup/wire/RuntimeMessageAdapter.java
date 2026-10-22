package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    RuntimeMessageAdapter(Class<M> r3, Class<B> r4, Map<Integer, FieldBinding<M, B>> r5) {
        Map<Integer, FieldBinding<M, B>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        super(FieldEncoding.LENGTH_DELIMITED, r3);
        this.messageType = r3;
        this.builderType = r4;
        this.fieldBindings = r6;
    }

    static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r9) {
        Class r0 = getBuilderType(r9);
        LinkedHashMap r1 = new LinkedHashMap();
        Field[] r2 = r9.getDeclaredFields();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L9;
        Field r5 = r2[r4];
        WireField r6 = (WireField) ZeusTransformUtils.preCheckCast(r5.getAnnotation(WireField.class), WireField.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        r1.put(Integer.valueOf(r6.tag()), new FieldBinding(r6, r5, r0));
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return new RuntimeMessageAdapter(r9, r0, Collections.unmodifiableMap(r1));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r3) {
        return ZeusTransformUtils.forName(r3.getName() + "$Builder", "com.obric.memorydata.plugin");
    L5:
        throw new IllegalArgumentException("No builder class found for message type " + r3.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r9) {
        Message.Builder r0 = newBuilder();
        long r1 = r9.beginMessage();
    L3:
        int r3 = r9.nextTag();
        if (r3 == (-1)) goto L16;
        FieldBinding r4 = (FieldBinding) ZeusTransformUtils.preCheckCast(this.fieldBindings.get(Integer.valueOf(r3)), FieldBinding.class, "com.obric.memorydata.plugin");
        if (r4 == 0) goto L12;
        if (r4.isMap() == false) goto L10;
        ProtoAdapter<?> r5 = r4.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L11:
        r4.value(r0, r5.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L10:
        r5 = r4.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L14:
        e = move-exception;
        r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L12:
        FieldEncoding r6 = r9.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        r0.addUnknownField(r3, r6, r6.rawProtoAdapter().decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L16:
        r9.endMessage(r1);
        return (M) r0.build();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    public void encode(ProtoWriter r4, M r5) {
        Iterator<FieldBinding<M, B>> r3 = this.fieldBindings.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        FieldBinding r0 = (FieldBinding) ZeusTransformUtils.preCheckCast(r3.next(), FieldBinding.class, "com.obric.memorydata.plugin");
        Object r1 = r0.get(r5);
        if (r1 == null) goto L4;
        r0.adapter().encodeWithTag(r4, r0.tag, r1);
        goto L4
    L9:
        r4.writeBytes(r5.unknownFields());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ void encode(ProtoWriter r3, Object r4) {
        encode(r3, (Message) ZeusTransformUtils.preCheckCast(r4, Message.class, "com.obric.memorydata.plugin"));
    }

    public int encodedSize(M r5) {
        int r0 = r5.cachedSerializedSize;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = 0;
        Iterator<FieldBinding<M, B>> r4 = this.fieldBindings.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        FieldBinding r2 = (FieldBinding) ZeusTransformUtils.preCheckCast(r4.next(), FieldBinding.class, "com.obric.memorydata.plugin");
        Object r3 = r2.get(r5);
        if (r3 == null) goto L7;
        r1 = r1 + r2.adapter().encodedSizeWithTag(r2.tag, r3);
        goto L7
    L12:
        int r6 = r1 + r5.unknownFields().size();
        r5.cachedSerializedSize = r6;
        return r6;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ int encodedSize(Object r3) {
        return encodedSize((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, RuntimeMessageAdapter.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeMessageAdapter) ZeusTransformUtils.preCheckCast(r3, RuntimeMessageAdapter.class, "com.obric.memorydata.plugin")).messageType != this.messageType) goto L7;
        return true;
    }

    Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    B newBuilder() {
        return (B) ZeusTransformUtils.preCheckCast(this.builderType.newInstance(), Message.Builder.class, "com.obric.memorydata.plugin");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public M redact(M r6) {
        Message.Builder r7 = r6.newBuilder();
        Iterator<FieldBinding<M, B>> r0 = this.fieldBindings.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        FieldBinding r1 = (FieldBinding) ZeusTransformUtils.preCheckCast(r0.next(), FieldBinding.class, "com.obric.memorydata.plugin");
        if (r1.redacted == true) goto L8;
    L12:
        boolean r2 = Message.class.isAssignableFrom(r1.singleAdapter().javaType);
        if (r1.redacted == true) goto L22;
        if (r2 == false) goto L18;
        if (r1.label.isRepeated() == false) goto L22;
    L18:
        if (r2 == false) goto L4;
        if (r1.label.isRepeated() == false) goto L4;
        Internal.redactElements((List) ZeusTransformUtils.preCheckCast(r1.getFromBuilder(r7), List.class, "com.obric.memorydata.plugin"), r1.singleAdapter());
    L22:
        Object r3 = r1.getFromBuilder(r7);
        if (r3 == null) goto L4;
        r1.set(r7, r1.adapter().redact(r3));
        goto L4
    L8:
        if (r1.label != WireField.Label.REQUIRED) goto L12;
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{r1.name, this.javaType.getName()}));
    L25:
        r7.clearUnknownFields();
        return (M) r7.build();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ Object redact(Object r3) {
        return redact((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin"));
    }

    public String toString(M r7) {
        StringBuilder r0 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r1 = this.fieldBindings.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        FieldBinding r2 = (FieldBinding) ZeusTransformUtils.preCheckCast(r1.next(), FieldBinding.class, "com.obric.memorydata.plugin");
        Object r3 = r2.get(r7);
        if (r3 == null) goto L4;
        StringBuilder r4 = r0.append(", ").append(r2.name).append('=');
        if (r2.redacted == false) goto L10;
        r3 = REDACTED;
    L10:
        r4.append(r3);
        goto L4
    L11:
        r0.replace(0, 2, this.messageType.getSimpleName() + '{');
        return r0.append('}').toString();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ String toString(Object r3) {
        return toString((Message) ZeusTransformUtils.preCheckCast(r3, Message.class, "com.obric.memorydata.plugin"));
    }
}
