package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ListFieldSchemaFull implements ListFieldSchema {
    private static final Class<?> UNMODIFIABLE_LIST_CLASS = null;

    static {
        UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    ListFieldSchemaFull() {
    }

    static <E> List<E> getList(Object r0, long r1) {
        return (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r0, r1), List.class, "com.obric.memorydata.plugin");
    }

    private static <L> List<L> mutableListAt(Object r4, long r5, int r7) {
        List<L> r0 = getList(r4, r5);
        if (r0.isEmpty() == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r0, LazyStringList.class) == false) goto L8;
        List<L> r1 = new LazyStringArrayList(r7);
    L13:
        UnsafeUtil.putObject(r4, r5, r1);
        return r1;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, PrimitiveNonBoxingCollection.class) == true) goto L10;
    L12:
        r1 = new ArrayList(r7);
        goto L13
    L10:
        if (ZeusTransformUtils.instanceOf(r0, Internal.ProtobufList.class) == false) goto L12;
        r1 = ((Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r0, Internal.ProtobufList.class, "com.obric.memorydata.plugin")).mutableCopyWithCapacity(r7);
        goto L13
    L15:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r0.getClass()) == false) goto L19;
        ArrayList r2 = new ArrayList(r0.size() + r7);
        r2.addAll(r0);
        Object r3 = r2;
    L17:
        UnsafeUtil.putObject(r4, r5, r3);
        return (List<L>) r3;
    L19:
        if (ZeusTransformUtils.instanceOf(r0, UnmodifiableLazyStringList.class) == false) goto L22;
        LazyStringArrayList r6 = new LazyStringArrayList(r0.size() + r7);
        r6.addAll((UnmodifiableLazyStringList) ZeusTransformUtils.preCheckCast(r0, UnmodifiableLazyStringList.class, "com.obric.memorydata.plugin"));
        r3 = r6;
        goto L17
    L22:
        if (ZeusTransformUtils.instanceOf(r0, PrimitiveNonBoxingCollection.class) == true) goto L24;
        return r0;
    L24:
        if (ZeusTransformUtils.instanceOf(r0, Internal.ProtobufList.class) == true) goto L26;
        return r0;
    L26:
        if (((Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r0, Internal.ProtobufList.class, "com.obric.memorydata.plugin")).isModifiable() == true) goto L32;
        r1 = ((Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r0, Internal.ProtobufList.class, "com.obric.memorydata.plugin")).mutableCopyWithCapacity(r0.size() + r7);
        goto L13
    L32:
        return r0;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r4, long r5) {
        List r3 = (List) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r4, r5), List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, LazyStringList.class) == false) goto L6;
        Object r6 = ((LazyStringList) ZeusTransformUtils.preCheckCast(r3, LazyStringList.class, "com.obric.memorydata.plugin")).getUnmodifiableView();
    L17:
        UnsafeUtil.putObject(r4, r5, r6);
        return;
    L6:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r3.getClass()) == false) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, PrimitiveNonBoxingCollection.class) == true) goto L11;
    L16:
        r6 = Collections.unmodifiableList(r3);
        goto L17
    L11:
        if (ZeusTransformUtils.instanceOf(r3, Internal.ProtobufList.class) == false) goto L16;
        if (((Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r3, Internal.ProtobufList.class, "com.obric.memorydata.plugin")).isModifiable() == false) goto L19;
        ((Internal.ProtobufList) ZeusTransformUtils.preCheckCast(r3, Internal.ProtobufList.class, "com.obric.memorydata.plugin")).makeImmutable();
        return;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r3, Object r4, long r5) {
        List r2 = getList(r4, r5);
        List r6 = mutableListAt(r3, r5, r2.size());
        int r0 = r6.size();
        int r1 = r2.size();
        if (r0 <= 0) goto L6;
        if (r1 <= 0) goto L6;
        r6.addAll(r2);
    L6:
        if (r0 <= 0) goto L8;
        r2 = r6;
    L8:
        UnsafeUtil.putObject(r3, r5, r2);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r1, long r2) {
        return mutableListAt(r1, r2, 10);
    }
}
