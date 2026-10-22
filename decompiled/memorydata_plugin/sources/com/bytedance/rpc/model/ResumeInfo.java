package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ResumeInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("break_point")
    public BreakPoint breakPoint;

    @SerializedName("ctx_info")
    public CtxInfo ctxInfo;

    @SerializedName("engine_interrupt_info")
    public EngineInterruptInfo engineInterruptInfo;

    @SerializedName("plugin_info_resp")
    public PluginInterruptInfoResp pluginInfoResp;

    @SerializedName("resume_scene")
    public ResumeScene resumeScene;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public ResumeInfo() {
    }
}
