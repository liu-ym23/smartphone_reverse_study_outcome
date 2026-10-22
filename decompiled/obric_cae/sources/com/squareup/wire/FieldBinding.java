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

    public FieldBinding(WireField r8, Field r10, Class<B> r11) {
        this.label = r8.label();
        String r12 = r10.getName();
        this.name = r12;
        this.tag = r8.tag();
        this.keyAdapterString = r8.keyAdapter();
        this.adapterString = r8.adapter();
        this.redacted = r8.redacted();
        this.messageField = r10;
        this.builderField = getBuilderField(r11, r12);
        this.builderMethod = getBuilderMethod(r11, r12, r10.getType());
    }

    private static Field getBuilderField(Class<?> r8, String r10) {
        return r8.getField(r10);
    L5:
        throw new AssertionError("No builder field " + r8.getName() + "." + r10);
    }

    private static Method getBuilderMethod(Class<?> r8, String r10, Class<?> r11) {
        return r8.getMethod(r10, new Class[]{r11});
    L5:
        throw new AssertionError("No builder method " + r8.getName() + "." + r10 + "(" + r11.getName() + ")");
    }

    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r8 = this.adapter;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (isMap() == false) goto L10;
        ProtoAdapter<?> r10 = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
    L8:
        this.adapter = r10;
        return r10;
    L10:
        r10 = singleAdapter().withLabel(this.label);
        goto L8
    }

    public Object get(M r8) {
        return this.messageField.get(r8);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Object getFromBuilder(B r8) {
        return this.builderField.get(r8);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    public ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r8 = this.keyAdapter;
        if (r8 == null) goto L5;
        return r8;
    L5:
        ProtoAdapter<?> r10 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = r10;
        return r10;
    }

    public void set(B r8, Object r10) {
    L7:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (this.label.isOneOf() == false) goto L5;
        this.builderMethod.invoke(r8, new Object[]{r10});     // Catch: Throwable -> L7
        return;
    L5:
        this.builderField.set(r8, r10);     // Catch: Throwable -> L7
    }

    public ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r8 = this.singleAdapter;
        if (r8 == null) goto L5;
        return r8;
    L5:
        ProtoAdapter<?> r10 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = r10;
        return r10;
    }

    public void value(B r8, Object r10) {
        if (this.label.isRepeated() == false) goto L6;
        ((List) getFromBuilder(r8)).add(r10);
        return;
    L6:
        if (this.keyAdapterString.isEmpty() == true) goto L8;
        ((Map) getFromBuilder(r8)).putAll((Map) r10);
        return;
    L8:
        set(r8, r10);
    }
}
