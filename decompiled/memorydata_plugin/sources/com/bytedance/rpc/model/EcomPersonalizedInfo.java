package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EcomPersonalizedInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("purchase_author_list")
    public List<String> purchaseAuthorList;

    @SerializedName("purchase_shop_list")
    public List<String> purchaseShopList;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public EcomPersonalizedInfo() {
    }
}
