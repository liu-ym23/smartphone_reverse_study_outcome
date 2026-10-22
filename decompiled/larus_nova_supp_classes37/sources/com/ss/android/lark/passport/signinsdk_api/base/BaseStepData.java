package com.ss.android.lark.passport.signinsdk_api.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class BaseStepData implements Serializable {

    @JSONField(name = "back_first")
    public boolean backFirst;
    public String message;

    @JSONField(name = "next_step")
    public String nextStep;

    @JSONField(name = "step_info")
    public JSONObject stepInfo;

    public BaseStepData() {
    }

    public String getNextStep() {
        return this.nextStep;
    }

    public JSONObject getStepInfo() {
        return this.stepInfo;
    }

    public boolean isBackFirst() {
        return this.backFirst;
    }

    public void setBackFirst(boolean r1) {
        this.backFirst = r1;
    }

    public void setNextStep(String r1) {
        this.nextStep = r1;
    }

    public void setStepInfo(JSONObject r1) {
        this.stepInfo = r1;
    }
}
