package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class HandleFaaSEventRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public ByteBuffer message;
    public String topic;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public HandleFaaSEventRequest() {
    }
}
