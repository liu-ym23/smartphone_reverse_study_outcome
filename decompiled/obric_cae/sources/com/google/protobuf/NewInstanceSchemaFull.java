package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    public NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object r8) {
        return ((Message) r8).toBuilder().buildPartial();
    }
}
