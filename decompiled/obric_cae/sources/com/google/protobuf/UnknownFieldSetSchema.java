package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5190a = 0;

    public UnknownFieldSetSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    public void addFixed322(UnknownFieldSet.Builder r8, int r10, int r11) {
        r8.mergeField(r10, UnknownFieldSet.Field.newBuilder().addFixed32(r11).build());
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    public void addFixed642(UnknownFieldSet.Builder r8, int r10, long r11) {
        r8.mergeField(r10, UnknownFieldSet.Field.newBuilder().addFixed64(r11).build());
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    public void addGroup2(UnknownFieldSet.Builder r8, int r10, UnknownFieldSet r11) {
        r8.mergeField(r10, UnknownFieldSet.Field.newBuilder().addGroup(r11).build());
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    public void addLengthDelimited2(UnknownFieldSet.Builder r8, int r10, ByteString r11) {
        r8.mergeField(r10, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r11).build());
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    public void addVarint2(UnknownFieldSet.Builder r8, int r10, long r11) {
        r8.mergeField(r10, UnknownFieldSet.Field.newBuilder().addVarint(r11).build());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder getBuilderFromMessage(Object r8) {
        return ((GeneratedMessage) r8).unknownFields.toBuilder();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet getFromMessage(Object r8) {
        return ((GeneratedMessage) r8).unknownFields;
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    public int getSerializedSize2(UnknownFieldSet r8) {
        return r8.getSerializedSize();
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    public int getSerializedSizeAsMessageSet2(UnknownFieldSet r8) {
        return r8.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public void makeImmutable(Object r8) {
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public UnknownFieldSet merge2(UnknownFieldSet r8, UnknownFieldSet r10) {
        return r8.toBuilder().mergeFrom(r10).build();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    public UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    public void setBuilderToMessage2(Object r8, UnknownFieldSet.Builder r10) {
        UnknownFieldSet r11 = r10.build();
        ((GeneratedMessage) r8).unknownFields = r11;
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    public void setToMessage2(Object r8, UnknownFieldSet r10) {
        ((GeneratedMessage) r8).unknownFields = r10;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public boolean shouldDiscardUnknownFields(Reader r8) {
        return r8.shouldDiscardUnknownFields();
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    public UnknownFieldSet toImmutable2(UnknownFieldSet.Builder r8) {
        return r8.build();
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    public void writeAsMessageSetTo2(UnknownFieldSet r8, Writer r10) {
        r8.writeAsMessageSetTo(r10);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public void writeTo2(UnknownFieldSet r8, Writer r10) {
        r8.writeTo(r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSet.Builder r8, int r10, int r11) {
        addFixed322(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSet.Builder r8, int r10, long r11) {
        addFixed642(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addGroup(UnknownFieldSet.Builder r8, int r10, UnknownFieldSet r11) {
        addGroup2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSet.Builder r8, int r10, ByteString r11) {
        addLengthDelimited2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void addVarint(UnknownFieldSet.Builder r8, int r10, long r11) {
        addVarint2(r8, r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSet.Builder getBuilderFromMessage(Object r8) {
        return getBuilderFromMessage(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSet getFromMessage(Object r8) {
        return getFromMessage(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSet r8) {
        return getSerializedSize2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSet r8) {
        return getSerializedSizeAsMessageSet2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSet merge(UnknownFieldSet r8, UnknownFieldSet r10) {
        return merge2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSet.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void setBuilderToMessage(Object r8, UnknownFieldSet.Builder r10) {
        setBuilderToMessage2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void setToMessage(Object r8, UnknownFieldSet r10) {
        setToMessage2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ UnknownFieldSet toImmutable(UnknownFieldSet.Builder r8) {
        return toImmutable2(r8);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSet r8, Writer r10) {
        writeAsMessageSetTo2(r8, r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    public /* bridge */ /* synthetic */ void writeTo(UnknownFieldSet r8, Writer r10) {
        writeTo2(r8, r10);
    }
}
