package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class MaasAuthConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String ak;
    public String endpoint;
    public String host;
    public String region;
    public String sk;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public MaasAuthConf() {
    }
}
