package com.bytedance.rpc.wire;

import com.bytedance.rpc.annotation.RpcFieldTag;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class SimpleFieldBinding<M> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Type genericType;
    private final boolean isMap;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final RpcFieldTag.Tag label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    SimpleFieldBinding(RpcFieldTag r3, Field r4) {
        RpcFieldTag r5 = (RpcFieldTag) ZeusTransformUtils.wrapperContextForParams(r3, RpcFieldTag.class, "com.obric.memorydata.plugin");
        this.label = r5.tag();
        this.name = r4.getName();
        this.tag = r5.id();
        this.keyAdapterString = "";
        this.adapterString = "";
        this.redacted = false;
        this.messageField = r4;
        if (r4.isAccessible() == true) goto L5;
        r4.setAccessible(true);
    L5:
        this.genericType = r4.getGenericType();
        this.isMap = Map.class.isAssignableFrom(r4.getType());
    }

    SimpleFieldBinding(WireField r3, Field r4) {
        WireField r5 = (WireField) ZeusTransformUtils.wrapperContextForParams(r3, WireField.class, "com.obric.memorydata.plugin");
        this.label = transferTag(r5.label());
        this.name = r4.getName();
        this.tag = r5.tag();
        String r0 = r5.keyAdapter();
        this.keyAdapterString = r0;
        this.adapterString = r5.adapter();
        this.redacted = r5.redacted();
        this.messageField = r4;
        boolean r1 = true;
        if (r4.isAccessible() == true) goto L5;
        r4.setAccessible(true);
    L5:
        this.genericType = r4.getGenericType();
        if (r0.isEmpty() == true) goto L8;
    L11:
        this.isMap = r1;
        return;
    L8:
        if (Map.class.isAssignableFrom(r4.getType()) == true) goto L11;
        r1 = false;
        goto L11
    }

    private RpcFieldTag.Tag transferTag(WireField.Label r1) {
        if (WireField.Label.REQUIRED != r1) goto L7;
        return RpcFieldTag.Tag.REQUIRED;
    L7:
        if (WireField.Label.OPTIONAL != r1) goto L11;
        return RpcFieldTag.Tag.OPTIONAL;
    L11:
        if (WireField.Label.REPEATED != r1) goto L15;
        return RpcFieldTag.Tag.REPEATED;
    L15:
        if (WireField.Label.PACKED != r1) goto L19;
        return RpcFieldTag.Tag.PACKED;
    L19:
        if (WireField.Label.ONE_OF != r1) goto L23;
        return RpcFieldTag.Tag.ONE_OF;
    L23:
        return RpcFieldTag.Tag.OPTIONAL;
    }

    ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r0 = this.adapter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isMap() == false) goto L9;
        ProtoAdapter<?> r1 = WireAdapter.getMapAdapter(this.genericType, this.keyAdapterString, this.adapterString);
        this.adapter = r1;
        return r1;
    L9:
        ProtoAdapter<?> r2 = singleAdapter();
        if (this.label != RpcFieldTag.Tag.PACKED) goto L13;
        r2 = r2.asPacked();
    L15:
        this.adapter = r2;
        return r2;
    L13:
        if (this.label != RpcFieldTag.Tag.REPEATED) goto L15;
        r2 = r2.asRepeated();
        goto L15
    }

    Object getValue(M r1) {
        return this.messageField.get(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    boolean isLabelPacked() {
        if (this.label != RpcFieldTag.Tag.PACKED) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isLabelRepeated() {
        if (this.label != RpcFieldTag.Tag.REPEATED) goto L5;
    L8:
        return true;
    L5:
        if (this.label == RpcFieldTag.Tag.PACKED) goto L8;
        return false;
    }

    boolean isMap() {
        return this.isMap;
    }

    ProtoAdapter<?> keyAdapter() {
        return keyAdapter(this.genericType);
    }

    ProtoAdapter<?> keyAdapter(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        ProtoAdapter<?> r0 = this.keyAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r5 = WireAdapter.getAdapter(this.keyAdapterString, r4);
        this.keyAdapter = r5;
        return r5;
    }

    void setValue(M r1, Object r2) {
        this.messageField.set(r1, r2);     // Catch: IllegalAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    ProtoAdapter<?> singleAdapter() {
        return singleAdapter(this.genericType);
    }

    ProtoAdapter<?> singleAdapter(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        ProtoAdapter<?> r0 = this.singleAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r5 = WireAdapter.getAdapter(this.adapterString, r4);
        this.singleAdapter = r5;
        return r5;
    }
}
