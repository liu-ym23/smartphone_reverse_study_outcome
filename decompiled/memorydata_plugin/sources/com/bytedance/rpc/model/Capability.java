package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Capability implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ala_src_allow_list")
    public List<String> alaSrcAllowList;
    public boolean batch;
    public boolean card;

    @SerializedName("complex_function_call")
    public boolean complexFunctionCall;

    @SerializedName("cot_display")
    public boolean cotDisplay;

    @SerializedName("fixed_function")
    public boolean fixedFunction;

    @SerializedName("function_call")
    public boolean functionCall;

    @SerializedName("json_mode")
    public boolean jsonMode;
    public boolean media;

    @SerializedName("multi_modal")
    public boolean multiModal;

    @SerializedName("multimodal_types")
    public List<String> multimodalTypes;
    public boolean nameable;

    @SerializedName("pre_query")
    public boolean preQuery;

    @SerializedName("profile_memory")
    public boolean profileMemory;
    public ModelProxy proxy;

    @SerializedName("resume_segment")
    public boolean resumeSegment;

    @SerializedName("search_enhance")
    public boolean searchEnhance;
    public boolean tool;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Capability() {
    }
}
