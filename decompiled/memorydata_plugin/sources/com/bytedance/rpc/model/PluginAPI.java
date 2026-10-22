package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PluginAPI implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ApiID")
    public long apiID;

    @SerializedName("Desc")
    public String desc;

    @SerializedName("Name")
    public String name;

    @SerializedName("Parameters")
    public List<Parameter> parameters;

    @SerializedName("PluginID")
    public long pluginID;

    @SerializedName("PluginName")
    public String pluginName;

    @SerializedName("PluginNameForModel")
    public String pluginNameForModel;

    @SerializedName("Score")
    public double score;

    @SerializedName("SpaceID")
    public long spaceID;

    @SerializedName("SpaceType")
    public SpaceType spaceType;

    @SerializedName("ToolType")
    public ToolType toolType;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public PluginAPI() {
    }
}
