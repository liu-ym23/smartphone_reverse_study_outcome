package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    public ListFieldSchemaLite() {
    }

    public static <E> Internal.ProtobufList<E> getProtobufList(Object r8, long r10) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(r8, r10);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r8, long r10) {
        getProtobufList(r8, r10).makeImmutable();
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r8, Object r10, long r11) {
        Internal.ProtobufList r12 = getProtobufList(r8, r11);
        Internal.ProtobufList r13 = getProtobufList(r10, r11);
        int r14 = r12.size();
        int r15 = r13.size();
        if (r14 <= 0) goto L9;
        if (r15 <= 0) goto L9;
        if (r12.isModifiable() == true) goto L8;
        r12 = r12.mutableCopyWithCapacity(r15 + r14);
    L8:
        r12.addAll(r13);
    L9:
        if (r14 <= 0) goto L11;
        r13 = r12;
    L11:
        UnsafeUtil.putObject(r8, r11, r13);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r8, long r10) {
        Internal.ProtobufList r11 = getProtobufList(r8, r10);
        if (r11.isModifiable() == true) goto L10;
        int r12 = r11.size();
        if (r12 != 0) goto L7;
        int r13 = 10;
    L8:
        Internal.ProtobufList r14 = r11.mutableCopyWithCapacity(r13);
        UnsafeUtil.putObject(r8, r10, r14);
        return r14;
    L7:
        r13 = r12 * 2;
        goto L8
    L10:
        return r11;
    }
}
