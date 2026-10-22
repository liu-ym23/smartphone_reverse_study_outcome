package com.bytedance.obric.memory.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PoiItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String address;
    public Adm adms;
    public String id;
    public double latitude;
    public double longitude;
    public String name;

    @SerializedName("type_code")
    public String typeCode;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PoiItem() {
    }
}
