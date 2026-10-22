package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4292a = 0;

    public UnknownFieldSetSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSet.Builder r10, int r11, int r12) {
        r10.mergeField(r11, UnknownFieldSet.Field.newBuilder().addFixed32(r12).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed32(UnknownFieldSet.Builder r10, int r11, int r12) {
        addFixed322(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSet.Builder r10, int r11, long r12) {
        r10.mergeField(r11, UnknownFieldSet.Field.newBuilder().addFixed64(r12).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addFixed64(UnknownFieldSet.Builder r10, int r11, long r12) {
        addFixed642(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSet.Builder r10, int r11, UnknownFieldSet r12) {
        r10.mergeField(r11, UnknownFieldSet.Field.newBuilder().addGroup(r12).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addGroup(UnknownFieldSet.Builder r10, int r11, UnknownFieldSet r12) {
        addGroup2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSet.Builder r10, int r11, ByteString r12) {
        r10.mergeField(r11, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r12).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addLengthDelimited(UnknownFieldSet.Builder r10, int r11, ByteString r12) {
        addLengthDelimited2(r10, r11, r12);
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSet.Builder r10, int r11, long r12) {
        r10.mergeField(r11, UnknownFieldSet.Field.newBuilder().addVarint(r12).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void addVarint(UnknownFieldSet.Builder r10, int r11, long r12) {
        addVarint2(r10, r11, r12);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSet.Builder getBuilderFromMessage(Object r10) {
        return ((GeneratedMessage) r10).unknownFields.toBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet.Builder getBuilderFromMessage(Object r10) {
        return getBuilderFromMessage(r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSet getFromMessage(Object r10) {
        return ((GeneratedMessage) r10).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet getFromMessage(Object r10) {
        return getFromMessage(r10);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSet r10) {
        return r10.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSize(UnknownFieldSet r10) {
        return getSerializedSize2(r10);
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSet r10) {
        return r10.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSet r10) {
        return getSerializedSizeAsMessageSet2(r10);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object r10) {
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSet merge2(UnknownFieldSet r10, UnknownFieldSet r11) {
        return r10.toBuilder().mergeFrom(r11).build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet merge(UnknownFieldSet r10, UnknownFieldSet r11) {
        return merge2(r10, r11);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSet.Builder newBuilder() {
        return UnknownFieldSet.newBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet.Builder newBuilder() {
        return newBuilder();
    }

    /* JADX INFO: renamed from: setBuilderToMessage, reason: avoid collision after fix types in other method */
    void setBuilderToMessage2(Object r10, UnknownFieldSet.Builder r11) {
        UnknownFieldSet r12 = r11.build();
        ((GeneratedMessage) r10).unknownFields = r12;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setBuilderToMessage(Object r10, UnknownFieldSet.Builder r11) {
        setBuilderToMessage2(r10, r11);
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object r10, UnknownFieldSet r11) {
        ((GeneratedMessage) r10).unknownFields = r11;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void setToMessage(Object r10, UnknownFieldSet r11) {
        setToMessage2(r10, r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader r10) {
        return r10.shouldDiscardUnknownFields();
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSet toImmutable2(UnknownFieldSet.Builder r10) {
        return r10.build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet toImmutable(UnknownFieldSet.Builder r10) {
        return toImmutable2(r10);
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSet r10, Writer r11) {
        r10.writeAsMessageSetTo(r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeAsMessageSetTo(UnknownFieldSet r10, Writer r11) {
        writeAsMessageSetTo2(r10, r11);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSet r10, Writer r11) {
        r10.writeTo(r11);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ void writeTo(UnknownFieldSet r10, Writer r11) {
        writeTo2(r10, r11);
    }
}
