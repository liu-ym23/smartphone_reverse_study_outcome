package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    UnknownFieldSetLiteSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSetLite r10, int r11, int r12) {
        r10.storeField(WireFormat.makeTag(r11, 5), Integer.valueOf(r12));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSetLite r10, int r11, int r12) {
        addFixed322(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSetLite r10, int r11, long r12) {
        r10.storeField(WireFormat.makeTag(r11, 1), Long.valueOf(r12));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSetLite r10, int r11, long r12) {
        addFixed642(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSetLite r10, int r11, UnknownFieldSetLite r12) {
        r10.storeField(WireFormat.makeTag(r11, 3), r12);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addGroup(UnknownFieldSetLite r10, int r11, UnknownFieldSetLite r12) {
        addGroup2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSetLite r10, int r11, ByteString r12) {
        r10.storeField(WireFormat.makeTag(r11, 2), r12);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSetLite r10, int r11, ByteString r12) {
        addLengthDelimited2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSetLite r10, int r11, long r12) {
        r10.storeField(WireFormat.makeTag(r11, 0), Long.valueOf(r12));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addVarint(UnknownFieldSetLite r10, int r11, long r12) {
        addVarint2(r10, r11, r12);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getBuilderFromMessage(Object r10) {
        UnknownFieldSetLite r11 = getFromMessage(r10);
        if (r11 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r12 = UnknownFieldSetLite.newInstance();
        setToMessage2(r10, r12);
        return r12;
    L6:
        return r11;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getBuilderFromMessage(Object r10) {
        return getBuilderFromMessage(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getFromMessage(Object r10) {
        return ((GeneratedMessageLite) r10).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getFromMessage(Object r10) {
        return getFromMessage(r10);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSetLite r10) {
        return r10.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSetLite r10) {
        return getSerializedSize2(r10);
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSetLite r10) {
        return r10.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSetLite r10) {
        return getSerializedSizeAsMessageSet2(r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object r10) {
        getFromMessage(r10).makeImmutable();
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite merge2(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(r11) == false) goto L6;
        return r10;
    L6:
        if (UnknownFieldSetLite.getDefaultInstance().equals(r10) == false) goto L10;
        return UnknownFieldSetLite.mutableCopyOf(r10, r11);
    L10:
        return r10.mergeFrom(r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite merge(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
        return merge2(r10, r11);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite newBuilder() {
        return newBuilder();
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    void setBuilderToMessage2(Object r10, UnknownFieldSetLite r11) {
        setToMessage2(r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setBuilderToMessage(Object r10, UnknownFieldSetLite r11) {
        setBuilderToMessage2(r10, r11);
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object r10, UnknownFieldSetLite r11) {
        ((GeneratedMessageLite) r10).unknownFields = r11;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setToMessage(Object r10, UnknownFieldSetLite r11) {
        setToMessage2(r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader r10) {
        return false;
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite toImmutable2(UnknownFieldSetLite r10) {
        r10.makeImmutable();
        return r10;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite toImmutable(UnknownFieldSetLite r10) {
        return toImmutable2(r10);
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSetLite r10, Writer r11) {
        r10.writeAsMessageSetTo(r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSetLite r10, Writer r11) {
        writeAsMessageSetTo2(r10, r11);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSetLite r10, Writer r11) {
        r10.writeTo(r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeTo(UnknownFieldSetLite r10, Writer r11) {
        writeTo2(r10, r11);
    }
}
