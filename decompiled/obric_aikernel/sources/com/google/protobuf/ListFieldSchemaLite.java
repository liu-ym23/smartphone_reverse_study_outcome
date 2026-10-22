package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    ListFieldSchemaLite() {
    }

    static <E> Internal.ProtobufList<E> getProtobufList(Object r10, long r11) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(r10, r11);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object r10, long r11) {
        getProtobufList(r10, r11).makeImmutable();
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object r10, Object r11, long r12) {
        Internal.ProtobufList r13 = getProtobufList(r10, r12);
        Internal.ProtobufList r14 = getProtobufList(r11, r12);
        int r15 = r13.size();
        int r16 = r14.size();
        if (r15 <= 0) goto L9;
        if (r16 <= 0) goto L9;
        if (r13.isModifiable() == true) goto L8;
        r13 = r13.mutableCopyWithCapacity(r16 + r15);
    L8:
        r13.addAll(r14);
    L9:
        if (r15 <= 0) goto L11;
        r14 = r13;
    L11:
        UnsafeUtil.putObject(r10, r12, r14);
    }

    @Override // com.google.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object r10, long r11) {
        Internal.ProtobufList r12 = getProtobufList(r10, r11);
        if (r12.isModifiable() == true) goto L10;
        int r13 = r12.size();
        if (r13 != 0) goto L7;
        int r14 = 10;
    L8:
        Internal.ProtobufList r15 = r12.mutableCopyWithCapacity(r14);
        UnsafeUtil.putObject(r10, r11, r15);
        return r15;
    L7:
        r14 = r13 * 2;
        goto L8
    L10:
        return r12;
    }
}
