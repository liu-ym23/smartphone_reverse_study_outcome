package com.obric.memory.datacollect;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UserParams implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String did;
    public String uid;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public UserParams() {
    }
}
