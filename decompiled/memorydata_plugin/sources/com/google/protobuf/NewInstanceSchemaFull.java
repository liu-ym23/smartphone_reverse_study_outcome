package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
final class NewInstanceSchemaFull implements NewInstanceSchema {
    NewInstanceSchemaFull() {
    }

    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object r2) {
        return ((Message) ZeusTransformUtils.preCheckCast(r2, Message.class, "com.obric.memorydata.plugin")).toBuilder().buildPartial();
    }
}
