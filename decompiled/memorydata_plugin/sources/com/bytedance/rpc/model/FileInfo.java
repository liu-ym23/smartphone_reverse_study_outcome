package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class FileInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String md5;
    public String name;
    public String uri;
    public String url;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public FileInfo() {
    }
}
