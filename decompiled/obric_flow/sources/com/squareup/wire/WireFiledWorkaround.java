package com.squareup.wire;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class WireFiledWorkaround {
    public WireFiledWorkaround() {
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r10) {
        Class r5 = getBuilderType(r10);
        LinkedHashMap r11 = new LinkedHashMap();
        Field[] r12 = r10.getDeclaredFields();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L14;
        Field r15 = r12[r14];
        WireField r16 = (WireField) r15.getAnnotation(WireField.class);     // Catch: Throwable -> L7
    L8:
        if (r16 != null) goto L10;
        r16 = toWireFiled((WireFieldNoEnum) r15.getAnnotation(WireFieldNoEnum.class));
    L10:
        if (r16 == null) goto L12;
        r11.put(Integer.valueOf(r16.tag()), new FieldBinding(r16, r15, r5));
    L12:
        r14 = r14 + 1;
    L7:
        r16 = null;
        goto L8
    L14:
        return new RuntimeMessageAdapter(r10, r5, Collections.unmodifiableMap(r11));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r5) {
        return (Class<B>) Class.forName(r5.getName().concat("$Builder"));
    L6:
        throw new IllegalArgumentException("No builder class found for message type ".concat(r5.getName()));
    }

    private static WireField toWireFiled(final WireFieldNoEnum r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(r5);
    }
}
