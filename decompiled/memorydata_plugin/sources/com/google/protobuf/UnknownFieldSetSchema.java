package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
class UnknownFieldSetSchema extends UnknownFieldSchema<UnknownFieldSet, UnknownFieldSet.Builder> {
    public UnknownFieldSetSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSet.Builder r1, int r2, int r3) {
        r1.mergeField(r2, UnknownFieldSet.Field.newBuilder().addFixed32(r3).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addFixed32(UnknownFieldSet.Builder r3, int r4, int r5) {
        addFixed322((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSet.Builder r1, int r2, long r3) {
        r1.mergeField(r2, UnknownFieldSet.Field.newBuilder().addFixed64(r3).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addFixed64(UnknownFieldSet.Builder r3, int r4, long r5) {
        addFixed642((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSet.Builder r1, int r2, UnknownFieldSet r3) {
        r1.mergeField(r2, UnknownFieldSet.Field.newBuilder().addGroup(r3).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addGroup(UnknownFieldSet.Builder r3, int r4, UnknownFieldSet r5) {
        addGroup2((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"), r4, (UnknownFieldSet) ZeusTransformUtils.preCheckCast(r5, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSet.Builder r1, int r2, ByteString r3) {
        r1.mergeField(r2, UnknownFieldSet.Field.newBuilder().addLengthDelimited(r3).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addLengthDelimited(UnknownFieldSet.Builder r3, int r4, ByteString r5) {
        addLengthDelimited2((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSet.Builder r1, int r2, long r3) {
        r1.mergeField(r2, UnknownFieldSet.Field.newBuilder().addVarint(r3).build());
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addVarint(UnknownFieldSet.Builder r3, int r4, long r5) {
        addVarint2((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSet.Builder getBuilderFromMessage(Object r2) {
        return ((GeneratedMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessage.class, "com.obric.memorydata.plugin")).unknownFields.toBuilder();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet.Builder getBuilderFromMessage(Object r1) {
        return getBuilderFromMessage(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSet getFromMessage(Object r2) {
        return ((GeneratedMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessage.class, "com.obric.memorydata.plugin")).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSet getFromMessage(Object r1) {
        return getFromMessage(r1);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSet r1) {
        return r1.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ int getSerializedSize(UnknownFieldSet r3) {
        return getSerializedSize2((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSet r1) {
        return r1.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSet r3) {
        return getSerializedSizeAsMessageSet2((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object r1) {
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSet merge2(UnknownFieldSet r1, UnknownFieldSet r2) {
        return r1.toBuilder().mergeFrom(r2).build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ UnknownFieldSet merge(UnknownFieldSet r3, UnknownFieldSet r4) {
        return merge2((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.class, "com.obric.memorydata.plugin"), (UnknownFieldSet) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
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
    void setBuilderToMessage2(Object r2, UnknownFieldSet.Builder r3) {
        GeneratedMessage r1 = (GeneratedMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessage.class, "com.obric.memorydata.plugin");
        r1.unknownFields = r3.build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void setBuilderToMessage(Object r3, UnknownFieldSet.Builder r4) {
        setBuilderToMessage2(r3, (UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object r2, UnknownFieldSet r3) {
        ((GeneratedMessage) ZeusTransformUtils.preCheckCast(r2, GeneratedMessage.class, "com.obric.memorydata.plugin")).unknownFields = r3;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void setToMessage(Object r3, UnknownFieldSet r4) {
        setToMessage2(r3, (UnknownFieldSet) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader r2) {
        return ((Reader) ZeusTransformUtils.wrapperContextForParams(r2, Reader.class, "com.obric.memorydata.plugin")).shouldDiscardUnknownFields();
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSet toImmutable2(UnknownFieldSet.Builder r1) {
        return r1.build();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ UnknownFieldSet toImmutable(UnknownFieldSet.Builder r3) {
        return toImmutable2((UnknownFieldSet.Builder) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.Builder.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSet r2, Writer r3) {
        r2.writeAsMessageSetTo((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void writeAsMessageSetTo(UnknownFieldSet r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        writeAsMessageSetTo2((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSet r2, Writer r3) {
        r2.writeTo((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void writeTo(UnknownFieldSet r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        writeTo2((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSet.class, "com.obric.memorydata.plugin"), r5);
    }
}
