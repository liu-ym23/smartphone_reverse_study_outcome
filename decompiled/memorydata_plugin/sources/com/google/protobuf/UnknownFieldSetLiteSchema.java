package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    UnknownFieldSetLiteSchema() {
    }

    /* JADX INFO: renamed from: addFixed32, reason: avoid collision after fix types in other method */
    void addFixed322(UnknownFieldSetLite r1, int r2, int r3) {
        r1.storeField(WireFormat.makeTag(r2, 5), Integer.valueOf(r3));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addFixed32(UnknownFieldSetLite r3, int r4, int r5) {
        addFixed322((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addFixed64, reason: avoid collision after fix types in other method */
    void addFixed642(UnknownFieldSetLite r1, int r2, long r3) {
        r1.storeField(WireFormat.makeTag(r2, 1), Long.valueOf(r3));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addFixed64(UnknownFieldSetLite r3, int r4, long r5) {
        addFixed642((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addGroup, reason: avoid collision after fix types in other method */
    void addGroup2(UnknownFieldSetLite r1, int r2, UnknownFieldSetLite r3) {
        r1.storeField(WireFormat.makeTag(r2, 3), r3);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addGroup(UnknownFieldSetLite r3, int r4, UnknownFieldSetLite r5) {
        addGroup2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r4, (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r5, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: addLengthDelimited, reason: avoid collision after fix types in other method */
    void addLengthDelimited2(UnknownFieldSetLite r1, int r2, ByteString r3) {
        r1.storeField(WireFormat.makeTag(r2, 2), r3);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addLengthDelimited(UnknownFieldSetLite r3, int r4, ByteString r5) {
        addLengthDelimited2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: addVarint, reason: avoid collision after fix types in other method */
    void addVarint2(UnknownFieldSetLite r1, int r2, long r3) {
        r1.storeField(WireFormat.makeTag(r2, 0), Long.valueOf(r3));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void addVarint(UnknownFieldSetLite r3, int r4, long r5) {
        addVarint2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getBuilderFromMessage(Object r3) {
        UnknownFieldSetLite r0 = getFromMessage(r3);
        if (r0 != UnknownFieldSetLite.getDefaultInstance()) goto L6;
        UnknownFieldSetLite r1 = UnknownFieldSetLite.newInstance();
        setToMessage2(r3, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getBuilderFromMessage(Object r1) {
        return getBuilderFromMessage(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.UnknownFieldSchema
    UnknownFieldSetLite getFromMessage(Object r2) {
        return ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* bridge */ /* synthetic */ UnknownFieldSetLite getFromMessage(Object r1) {
        return getFromMessage(r1);
    }

    /* JADX INFO: renamed from: getSerializedSize, reason: avoid collision after fix types in other method */
    int getSerializedSize2(UnknownFieldSetLite r1) {
        return r1.getSerializedSize();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ int getSerializedSize(UnknownFieldSetLite r3) {
        return getSerializedSize2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: getSerializedSizeAsMessageSet, reason: avoid collision after fix types in other method */
    int getSerializedSizeAsMessageSet2(UnknownFieldSetLite r1) {
        return r1.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ int getSerializedSizeAsMessageSet(UnknownFieldSetLite r3) {
        return getSerializedSizeAsMessageSet2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    void makeImmutable(Object r1) {
        getFromMessage(r1).makeImmutable();
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite merge2(UnknownFieldSetLite r1, UnknownFieldSetLite r2) {
        if (UnknownFieldSetLite.getDefaultInstance().equals(r2) == false) goto L6;
        return r1;
    L6:
        if (UnknownFieldSetLite.getDefaultInstance().equals(r1) == false) goto L10;
        return UnknownFieldSetLite.mutableCopyOf(r1, r2);
    L10:
        return r1.mergeFrom(r2);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ UnknownFieldSetLite merge(UnknownFieldSetLite r3, UnknownFieldSetLite r4) {
        return merge2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
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
    void setBuilderToMessage2(Object r1, UnknownFieldSetLite r2) {
        setToMessage2(r1, r2);
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void setBuilderToMessage(Object r3, UnknownFieldSetLite r4) {
        setBuilderToMessage2(r3, (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: setToMessage, reason: avoid collision after fix types in other method */
    void setToMessage2(Object r2, UnknownFieldSetLite r3) {
        ((GeneratedMessageLite) ZeusTransformUtils.preCheckCast(r2, GeneratedMessageLite.class, "com.obric.memorydata.plugin")).unknownFields = r3;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void setToMessage(Object r3, UnknownFieldSetLite r4) {
        setToMessage2(r3, (UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    boolean shouldDiscardUnknownFields(Reader r2) {
        Reader r1 = (Reader) ZeusTransformUtils.wrapperContextForParams(r2, Reader.class, "com.obric.memorydata.plugin");
        return false;
    }

    /* JADX INFO: renamed from: toImmutable, reason: avoid collision after fix types in other method */
    UnknownFieldSetLite toImmutable2(UnknownFieldSetLite r1) {
        r1.makeImmutable();
        return r1;
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ UnknownFieldSetLite toImmutable(UnknownFieldSetLite r3) {
        return toImmutable2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: writeAsMessageSetTo, reason: avoid collision after fix types in other method */
    void writeAsMessageSetTo2(UnknownFieldSetLite r2, Writer r3) {
        r2.writeAsMessageSetTo((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void writeAsMessageSetTo(UnknownFieldSetLite r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        writeAsMessageSetTo2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    void writeTo2(UnknownFieldSetLite r2, Writer r3) {
        r2.writeTo((Writer) ZeusTransformUtils.wrapperContextForParams(r3, Writer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.UnknownFieldSchema
    /* synthetic */ void writeTo(UnknownFieldSetLite r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        writeTo2((UnknownFieldSetLite) ZeusTransformUtils.preCheckCast(r3, UnknownFieldSetLite.class, "com.obric.memorydata.plugin"), r5);
    }
}
