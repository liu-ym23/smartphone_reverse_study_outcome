package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ListFieldSchemaFull implements ListFieldSchema {
    private static final Class<?> UNMODIFIABLE_LIST_CLASS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5188a = 0;

    static {
        UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    public ListFieldSchemaFull() {
    }

    public static <E> List<E> getList(Object r8, long r10) {
        return (List) UnsafeUtil.getObject(r8, r10);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r8, long r10) {
        List r11 = (List) UnsafeUtil.getObject(r8, r10);
        if ((r11 instanceof LazyStringList) == false) goto L6;
        Object r12 = ((LazyStringList) r11).getUnmodifiableView();
    L17:
        UnsafeUtil.putObject(r8, r10, r12);
        return;
    L6:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r11.getClass()) == false) goto L9;
        return;
    L9:
        if ((r11 instanceof PrimitiveNonBoxingCollection) == true) goto L11;
    L16:
        r12 = Collections.unmodifiableList(r11);
        goto L17
    L11:
        if ((r11 instanceof Internal.ProtobufList) == false) goto L16;
        Internal.ProtobufList r13 = (Internal.ProtobufList) r11;
        if (r13.isModifiable() == false) goto L19;
        r13.makeImmutable();
        return;
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r8, Object r10, long r11) {
        List r12 = getList(r10, r11);
        List r13 = mutableListAt(r8, r11, r12.size());
        int r14 = r13.size();
        int r15 = r12.size();
        if (r14 <= 0) goto L6;
        if (r15 <= 0) goto L6;
        r13.addAll(r12);
    L6:
        if (r14 <= 0) goto L8;
        r12 = r13;
    L8:
        UnsafeUtil.putObject(r8, r11, r12);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r8, long r10) {
        return mutableListAt(r8, r10, 10);
    }

    private static <L> List<L> mutableListAt(Object r8, long r10, int r11) {
        List<L> r12 = getList(r8, r10);
        if (r12.isEmpty() == false) goto L15;
        if ((r12 instanceof LazyStringList) == false) goto L8;
        List<L> r13 = new LazyStringArrayList(r11);
    L13:
        UnsafeUtil.putObject(r8, r10, r13);
        return r13;
    L8:
        if ((r12 instanceof PrimitiveNonBoxingCollection) == true) goto L10;
    L12:
        r13 = new ArrayList(r11);
        goto L13
    L10:
        if ((r12 instanceof Internal.ProtobufList) == false) goto L12;
        r13 = ((Internal.ProtobufList) r12).mutableCopyWithCapacity(r11);
        goto L13
    L15:
        if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r12.getClass()) == false) goto L19;
        ArrayList r14 = new ArrayList(r12.size() + r11);
        r14.addAll(r12);
        Object r15 = r14;
    L17:
        UnsafeUtil.putObject(r8, r10, r15);
        return (List<L>) r15;
    L19:
        if ((r12 instanceof UnmodifiableLazyStringList) == false) goto L22;
        LazyStringArrayList r16 = new LazyStringArrayList(r12.size() + r11);
        r16.addAll((UnmodifiableLazyStringList) r12);
        r15 = r16;
        goto L17
    L22:
        if ((r12 instanceof PrimitiveNonBoxingCollection) == true) goto L24;
        return r12;
    L24:
        if ((r12 instanceof Internal.ProtobufList) == false) goto L31;
        Internal.ProtobufList r17 = (Internal.ProtobufList) r12;
        if (r17.isModifiable() == true) goto L32;
        r13 = r17.mutableCopyWithCapacity(r12.size() + r11);
        goto L13
    L32:
        return r12;
    L31:
        return r12;
    }
}
