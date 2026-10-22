package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ListFieldSchemaFull implements ListFieldSchema {
    private static final Class<?> UNMODIFIABLE_LIST_CLASS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4291a = 0;

    static {
        UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    ListFieldSchemaFull() {
    }

    static <E> List<E> getList(Object r10, long r11) {
        return (List) UnsafeUtil.getObject(r10, r11);
    }

    private static <L> List<L> mutableListAt(Object r10, long r11, int r12) {
        List<L> r13 = getList(r10, r11);
        if (r13.isEmpty() == false) goto L15;
        if ((r13 instanceof LazyStringList) == false) goto L8;
        List<L> r14 = new LazyStringArrayList(r12);
    L13:
        UnsafeUtil.putObject(r10, r11, r14);
        return r14;
    L8:
        if ((r13 instanceof PrimitiveNonBoxingCollection) == true) goto L10;
    L12:
        r14 = new ArrayList(r12);
        goto L13
    L10:
        if ((r13 instanceof Internal.ProtobufList) == false) goto L12;
        r14 = ((Internal.ProtobufList) r13).mutableCopyWithCapacity(r12);
        goto L13
    L15:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r13.getClass()) == false) goto L19;
        ArrayList r15 = new ArrayList(r13.size() + r12);
        r15.addAll(r13);
        Object r16 = r15;
    L17:
        UnsafeUtil.putObject(r10, r11, r16);
        return (List<L>) r16;
    L19:
        if ((r13 instanceof UnmodifiableLazyStringList) == false) goto L22;
        LazyStringArrayList r17 = new LazyStringArrayList(r13.size() + r12);
        r17.addAll((UnmodifiableLazyStringList) r13);
        r16 = r17;
        goto L17
    L22:
        if ((r13 instanceof PrimitiveNonBoxingCollection) == true) goto L24;
        return r13;
    L24:
        if ((r13 instanceof Internal.ProtobufList) == false) goto L31;
        Internal.ProtobufList r18 = (Internal.ProtobufList) r13;
        if (r18.isModifiable() == true) goto L32;
        r14 = r18.mutableCopyWithCapacity(r13.size() + r12);
        goto L13
    L32:
        return r13;
    L31:
        return r13;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r10, long r11) {
        List r12 = (List) UnsafeUtil.getObject(r10, r11);
        if ((r12 instanceof LazyStringList) == false) goto L6;
        Object r13 = ((LazyStringList) r12).getUnmodifiableView();
    L17:
        UnsafeUtil.putObject(r10, r11, r13);
        return;
    L6:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r12.getClass()) == false) goto L9;
        return;
    L9:
        if ((r12 instanceof PrimitiveNonBoxingCollection) == true) goto L11;
    L16:
        r13 = Collections.unmodifiableList(r12);
        goto L17
    L11:
        if ((r12 instanceof Internal.ProtobufList) == false) goto L16;
        Internal.ProtobufList r14 = (Internal.ProtobufList) r12;
        if (r14.isModifiable() == false) goto L19;
        r14.makeImmutable();
        return;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r10, Object r11, long r12) {
        List r13 = getList(r11, r12);
        List r14 = mutableListAt(r10, r12, r13.size());
        int r15 = r14.size();
        int r16 = r13.size();
        if (r15 <= 0) goto L6;
        if (r16 <= 0) goto L6;
        r14.addAll(r13);
    L6:
        if (r15 <= 0) goto L8;
        r13 = r14;
    L8:
        UnsafeUtil.putObject(r10, r12, r13);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r10, long r11) {
        return mutableListAt(r10, r11, 10);
    }
}
