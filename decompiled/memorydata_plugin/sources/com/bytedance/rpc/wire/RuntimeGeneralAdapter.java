package com.bytedance.rpc.wire;

import com.bytedance.rpc.annotation.RpcFieldTag;
import com.bytedance.rpc.log.Logger;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class RuntimeGeneralAdapter<M> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Map<Integer, SimpleFieldBinding<M>> fieldBindings;
    private final Class<M> messageType;

    RuntimeGeneralAdapter(Class<M> r3, Map<Integer, SimpleFieldBinding<M>> r4) {
        Map<Integer, SimpleFieldBinding<M>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(FieldEncoding.LENGTH_DELIMITED, r3);
        this.messageType = r3;
        this.fieldBindings = r5;
    }

    public static <M> RuntimeGeneralAdapter<M> create(Class<M> r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Field[] r1 = r8.getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        Field r4 = r1[r3];
        WireField r5 = (WireField) ZeusTransformUtils.preCheckCast(r4.getAnnotation(WireField.class), WireField.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        RpcFieldTag r6 = (RpcFieldTag) ZeusTransformUtils.preCheckCast(r4.getAnnotation(RpcFieldTag.class), RpcFieldTag.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L11;
        Integer r7 = Integer.valueOf(r6.id());
        SimpleFieldBinding r9 = new SimpleFieldBinding(r6, r4);
    L10:
        r0.put(r7, r9);
    L11:
        r3 = r3 + 1;
        goto L3
    L9:
        r7 = Integer.valueOf(r5.tag());
        r9 = new SimpleFieldBinding(r5, r4);
        goto L10
    L13:
        return new RuntimeGeneralAdapter(r8, Collections.unmodifiableMap(r0));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r14) {
        M r0 = newResultObject();
        long r1 = r14.beginMessage();
    L3:
        int r3 = r14.nextTag();
    L5:
        if (r3 == (-1)) goto L35;
        SimpleFieldBinding r5 = (SimpleFieldBinding) ZeusTransformUtils.preCheckCast(this.fieldBindings.get(Integer.valueOf(r3)), SimpleFieldBinding.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L27;
        if (r5.isLabelRepeated() == false) goto L18;
        ProtoAdapter<?> r10 = r5.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        List r7 = (List) ZeusTransformUtils.preCheckCast(r5.getValue(r0), List.class, "com.obric.memorydata.plugin");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        if (r7 != null) goto L13;
        r7 = new ArrayList();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        r5.setValue(r0, r7);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
    L13:
        r7.add(r10.decode(r14));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        int r6 = r14.nextTag();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        if (r6 == (-1)) goto L16;
        if (r6 == r3) goto L13;
    L16:
        r3 = r6;
        goto L5
    L18:
        if (r5.isMap() == false) goto L26;
        ProtoAdapter<Object> r11 = r5.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(r5.getValue(r0), Map.class, "com.obric.memorydata.plugin");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        if (r12 != null) goto L22;
        r12 = new LinkedHashMap();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        r5.setValue(r0, r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
    L22:
        r12.putAll((Map) ZeusTransformUtils.preCheckCast(r11.decode(r14), Map.class, "com.obric.memorydata.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        r6 = r14.nextTag();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        if (r6 == (-1)) goto L16;
        if (r6 == r3) goto L22;
    L26:
        r5.setValue(r0, r5.singleAdapter().decode(r14));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
    L31:
        e = move-exception;
        if (Logger.isLoggableW() == false) goto L3;
        Logger.w(String.format("cant decode enum field %s with value %s", new Object[]{FieldEncoding.VARINT, Long.valueOf(e.value)}));
        goto L3
    L27:
        FieldEncoding r4 = r14.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        Object r8 = r4.rawProtoAdapter().decode(r14);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        if (Logger.isLoggableW() == false) goto L3;
        Logger.w(String.format("cant decode field %s with value %s", new Object[]{r4, r8}));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        goto L3
    L35:
        r14.endMessage(r1);
        return r0;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public void encode(ProtoWriter r4, M r5) {
        Iterator<SimpleFieldBinding<M>> r3 = this.fieldBindings.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        SimpleFieldBinding r0 = (SimpleFieldBinding) ZeusTransformUtils.preCheckCast(r3.next(), SimpleFieldBinding.class, "com.obric.memorydata.plugin");
        Object r1 = r0.getValue(r5);
        if (r1 == null) goto L4;
        r0.adapter().encodeWithTag(r4, r0.tag, r1);
        goto L4
    }

    @Override // com.squareup.wire.ProtoAdapter
    public int encodedSize(M r7) {
        Map<Object, Integer> r0 = WireAdapter.getEncodeSizeMap();
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        int r2 = 0;
        Iterator<SimpleFieldBinding<M>> r6 = this.fieldBindings.values().iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        SimpleFieldBinding r3 = (SimpleFieldBinding) ZeusTransformUtils.preCheckCast(r6.next(), SimpleFieldBinding.class, "com.obric.memorydata.plugin");
        Object r4 = r3.getValue(r7);
        if (r4 == null) goto L8;
        r2 = r2 + r3.adapter().encodedSizeWithTag(r3.tag, r4);
        goto L8
    L12:
        r0.put(r7, Integer.valueOf(r2));
        return r2;
    L5:
        return r1.intValue();
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, RuntimeGeneralAdapter.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeGeneralAdapter) ZeusTransformUtils.preCheckCast(r3, RuntimeGeneralAdapter.class, "com.obric.memorydata.plugin")).messageType != this.messageType) goto L7;
        return true;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    M newResultObject() {
        return this.messageType.newInstance();
    L7:
        e = move-exception;
        throw new AssertionError(e);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M redact(M r6) {
        M r7 = newResultObject();
        Iterator<SimpleFieldBinding<M>> r0 = this.fieldBindings.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        SimpleFieldBinding r1 = (SimpleFieldBinding) ZeusTransformUtils.preCheckCast(r0.next(), SimpleFieldBinding.class, "com.obric.memorydata.plugin");
        if (r1.redacted == false) goto L13;
        if (r1.label != RpcFieldTag.Tag.REQUIRED) goto L13;
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{r1.name, this.messageType.getName()}));
    L13:
        if (r1.redacted == true) goto L22;
        if (r1.isLabelRepeated() == false) goto L22;
        if (r1.isLabelRepeated() == false) goto L4;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(r7), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        Internal.redactElements(r2, r1.singleAdapter());
    L22:
        Object r3 = r1.getValue(r7);
        if (r3 == null) goto L4;
        r1.setValue(r7, r1.adapter().redact(r3));
        goto L4
    L25:
        return r7;
    }

    @Override // com.squareup.wire.ProtoAdapter
    public String toString(M r7) {
        StringBuilder r0 = new StringBuilder();
        Iterator<SimpleFieldBinding<M>> r1 = this.fieldBindings.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        SimpleFieldBinding r2 = (SimpleFieldBinding) ZeusTransformUtils.preCheckCast(r1.next(), SimpleFieldBinding.class, "com.obric.memorydata.plugin");
        Object r3 = r2.getValue(r7);
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
}
