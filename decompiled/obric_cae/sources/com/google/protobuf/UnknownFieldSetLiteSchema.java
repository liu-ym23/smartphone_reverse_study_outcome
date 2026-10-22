package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    public UnknownFieldSetLiteSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    public void addFixed322(UnknownFieldSetLite r8, int r10, int r11) {
        r8.storeField(WireFormat.makeTag(r10, 5), Integer.valueOf(r11));
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    public void addFixed642(UnknownFieldSetLite r8, int r10, long r11) {
        r8.storeField(WireFormat.makeTag(r10, 1), Long.valueOf(r11));
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    public void addGroup2(UnknownFieldSetLite r8, int r10, UnknownFieldSetLite r11) {
        r8.storeField(WireFormat.makeTag(r10, 3), r11);
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    public void addLengthDelimited2(UnknownFieldSetLite r8, int r10, ByteString r11) {
        r8.storeField(WireFormat.makeTag(r10, 2), r11);
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    public void addVarint2(UnknownFieldSetLite r8, int r10, long r11) {
        r8.storeField(WireFormat.makeTag(r10, 0), Long.valueOf(r11));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getBuilderFromMessage(Object r8) {
        UnknownFieldSetLite r10 = getFromMessage(r8);
        if (r10 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r11 = UnknownFieldSetLite.newInstance();
        setToMessage2(r8, r11);
        return r11;
    L6:
        return r10;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getFromMessage(Object r8) {
        return ((GeneratedMessageLite) r8).unknownFields;
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    public int getSerializedSize2(UnknownFieldSetLite r8) {
        return r8.getSerializedSize();
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    public int getSerializedSizeAsMessageSet2(UnknownFieldSetLite r8) {
        return r8.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void makeImmutable(Object r8) {
        getFromMessage(r8).makeImmutable();
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public UnknownFieldSetLite merge2(UnknownFieldSetLite r8, UnknownFieldSetLite r10) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(r10) == false) goto L6;
        return r8;
    L6:
        if (UnknownFieldSetLite.getDefaultInstance().equals(r8) == false) goto L10;
        return UnknownFieldSetLite.mutableCopyOf(r8, r10);
    L10:
        return r8.mergeFrom(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    public void setBuilderToMessage2(Object r8, UnknownFieldSetLite r10) {
        setToMessage2(r8, r10);
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    public void setToMessage2(Object r8, UnknownFieldSetLite r10) {
        ((GeneratedMessageLite) r8).unknownFields = r10;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public boolean shouldDiscardUnknownFields(Reader r8) {
        return false;
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    public UnknownFieldSetLite toImmutable2(UnknownFieldSetLite r8) {
        r8.makeImmutable();
        return r8;
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    public void writeAsMessageSetTo2(UnknownFieldSetLite r8, Writer r10) {
        r8.writeAsMessageSetTo(r10);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public void writeTo2(UnknownFieldSetLite r8, Writer r10) {
        r8.writeTo(r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSetLite r8, int r10, int r11) {
        addFixed322(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSetLite r8, int r10, long r11) {
        addFixed642(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addGroup(UnknownFieldSetLite r8, int r10, UnknownFieldSetLite r11) {
        addGroup2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSetLite r8, int r10, ByteString r11) {
        addLengthDelimited2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addVarint(UnknownFieldSetLite r8, int r10, long r11) {
        addVarint2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSetLite getBuilderFromMessage(Object r8) {
        return getBuilderFromMessage(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSetLite getFromMessage(Object r8) {
        return getFromMessage(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSetLite r8) {
        return getSerializedSize2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSetLite r8) {
        return getSerializedSizeAsMessageSet2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSetLite merge(UnknownFieldSetLite r8, UnknownFieldSetLite r10) {
        return merge2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSetLite newBuilder() {
        return newBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void setBuilderToMessage(Object r8, UnknownFieldSetLite r10) {
        setBuilderToMessage2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void setToMessage(Object r8, UnknownFieldSetLite r10) {
        setToMessage2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSetLite toImmutable(UnknownFieldSetLite r8) {
        return toImmutable2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSetLite r8, Writer r10) {
        writeAsMessageSetTo2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void writeTo(UnknownFieldSetLite r8, Writer r10) {
        writeTo2(r8, r10);
    }
}
