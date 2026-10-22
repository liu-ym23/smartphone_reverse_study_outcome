package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Parameter implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("AssistType")
    public AssistParameterType assistType;

    @SerializedName("BizExtend")
    public String bizExtend;

    @SerializedName("DefaultParamSource")
    public DefaultParamSource defaultParamSource;

    @SerializedName("Desc")
    public String desc;

    @SerializedName("EnumList")
    public List<String> enumList;

    @SerializedName("EnumVarNames")
    public List<String> enumVarNames;

    @SerializedName("ExclusiveMaximum")
    public boolean exclusiveMaximum;

    @SerializedName("ExclusiveMinimum")
    public boolean exclusiveMinimum;

    @SerializedName("Format")
    public String format;

    @SerializedName("FromNodeId")
    public String fromNodeId;

    @SerializedName("FromOutput")
    public List<String> fromOutput;

    @SerializedName("Maximum")
    public double maximum;

    @SerializedName("Minimum")
    public double minimum;

    @SerializedName("Name")
    public String name;

    @SerializedName("Required")
    public boolean required;

    @SerializedName("SubParameters")
    public List<Parameter> subParameters;

    @SerializedName("SubType")
    public String subType;

    @SerializedName("Title")
    public String title;

    @SerializedName("Type")
    public String type;

    @SerializedName("Value")
    public String value;

    @SerializedName("VariableRef")
    public String variableRef;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Parameter() {
    }
}
