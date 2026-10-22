package com.bytedance.rpc.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OmniSkillLoadResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("error_code")
    public int errorCode;

    @SerializedName("error_msg")
    public String errorMsg;
    public Map<String, String> extra;

    @SerializedName("install_type")
    public String installType;

    @SerializedName(LocationMonitorConst.IS_SUCCESS)
    public boolean isSuccess;

    @SerializedName("load_id")
    public String loadId;

    @SerializedName("skill_id")
    public String skillId;

    @SerializedName("skill_name")
    public String skillName;
    public OmniSkillSource source;

    @SerializedName("tool_schema")
    public String toolSchema;
    public boolean truncated;
    public long version;

    @SerializedName("work_dir")
    public String workDir;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public OmniSkillLoadResult() {
    }
}
