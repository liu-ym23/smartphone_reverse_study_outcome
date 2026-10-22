package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Prompt implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("output_parsers")
    public List<OutputParser> outputParsers;

    @SerializedName("partial_variables")
    public Variables partialVariables;

    @SerializedName("prompt_template")
    public PromptTemplate promptTemplate;

    @SerializedName("variable_formatters")
    public List<VariableFormatter> variableFormatters;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Prompt() {
    }
}
