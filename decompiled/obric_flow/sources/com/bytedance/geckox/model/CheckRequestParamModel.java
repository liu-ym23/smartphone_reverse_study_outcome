package com.bytedance.geckox.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Deprecated
public class CheckRequestParamModel {

    @SerializedName("group_name")
    private String group;

    @SerializedName("target_channels")
    private List<CheckRequestBodyModel.TargetChannel> targetChannels;

    public CheckRequestParamModel(String r5) {
        this.group = r5;
    }

    public String getGroup() {
        return this.group;
    }

    public List<CheckRequestBodyModel.TargetChannel> getTargetChannels() {
        return this.targetChannels;
    }

    public void setGroup(String r5) {
        this.group = r5;
    }

    public void setTargetChannels(List<CheckRequestBodyModel.TargetChannel> r5) {
        this.targetChannels = r5;
    }

    public CheckRequestParamModel(String r5, List<CheckRequestBodyModel.TargetChannel> r10) {
        this.group = r5;
        this.targetChannels = r10;
    }
}
