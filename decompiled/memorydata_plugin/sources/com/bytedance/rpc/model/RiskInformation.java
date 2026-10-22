package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RiskInformation implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("has_intervene_response")
    public boolean hasInterveneResponse;

    @SerializedName("hit_security_check")
    public boolean hitSecurityCheck;

    @SerializedName("hit_words_table_ids")
    public Set<Long> hitWordsTableIds;

    @SerializedName("hit_words_table_ids_rsp")
    public Set<Long> hitWordsTableIdsRsp;

    @SerializedName("intervene_content")
    public String interveneContent;

    @SerializedName("refused_by_engine")
    public boolean refusedByEngine;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public RiskInformation() {
    }
}
