package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    FieldBinding(WireField r10, Field r11, Class<B> r12) {
        this.label = r10.label();
        String r13 = r11.getName();
        this.name = r13;
        this.tag = r10.tag();
        this.keyAdapterString = r10.keyAdapter();
        this.adapterString = r10.adapter();
        this.redacted = r10.redacted();
        this.messageField = r11;
        this.builderField = getBuilderField(r12, r13);
        this.builderMethod = getBuilderMethod(r12, r13, r11.getType());
    }

    private static Field getBuilderField(Class<?> r10, String r11) {
        return r10.getField(r11);
    L5:
        throw new AssertionError("No builder field " + r10.getName() + "." + r11);
    }

    private static Method getBuilderMethod(Class<?> r10, String r11, Class<?> r12) {
        return r10.getMethod(r11, new Class[]{r12});
    L6:
        throw new AssertionError("No builder method " + r10.getName() + "." + r11 + "(" + r12.getName() + ")");
    }

    ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r10 = this.adapter;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (isMap() == false) goto L10;
        ProtoAdapter<?> r11 = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
    L8:
        this.adapter = r11;
        return r11;
    L10:
        r11 = singleAdapter().withLabel(this.label);
        goto L8
    }

    Object get(M r10) {
        return this.messageField.get(r10);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    Object getFromBuilder(B r10) {
        return this.builderField.get(r10);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r10 = this.keyAdapter;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ProtoAdapter<?> r11 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = r11;
        return r11;
    }

    void set(B r10, Object r11) {
    L7:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (this.label.isOneOf() == false) goto L5;
        this.builderMethod.invoke(r10, new Object[]{r11});     // Catch: Throwable -> L7
        return;
    L5:
        this.builderField.set(r10, r11);     // Catch: Throwable -> L7
    }

    ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r10 = this.singleAdapter;
        if (r10 == null) goto L5;
        return r10;
    L5:
        ProtoAdapter<?> r11 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = r11;
        return r11;
    }

    void value(B r10, Object r11) {
        if (this.label.isRepeated() == false) goto L6;
        ((List) getFromBuilder(r10)).add(r11);
        return;
    L6:
        if (this.keyAdapterString.isEmpty() == true) goto L8;
        ((Map) getFromBuilder(r10)).putAll((Map) r11);
        return;
    L8:
        set(r10, r11);
    }
}
