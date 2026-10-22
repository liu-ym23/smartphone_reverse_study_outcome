package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object r10) {
        return ((Message) r10).toBuilder().buildPartial();
    }
}
