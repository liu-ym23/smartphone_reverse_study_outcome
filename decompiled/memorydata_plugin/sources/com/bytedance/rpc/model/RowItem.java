package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RowItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("info_item_list")
    public List<InfoItem> infoItemList;
    public long row;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RowItem() {
    }
}
