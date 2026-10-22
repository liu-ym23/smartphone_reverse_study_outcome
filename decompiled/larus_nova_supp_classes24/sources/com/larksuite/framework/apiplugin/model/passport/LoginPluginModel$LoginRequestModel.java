package com.larksuite.framework.apiplugin.model.passport;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseRequestModel;
import com.larksuite.framework.apiplugin.validator.format.Max;
import com.larksuite.framework.apiplugin.validator.format.Min;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LoginPluginModel$LoginRequestModel extends LKBaseRequestModel {

    @Max(include = true, value = 128.0d)
    @Min(include = true, value = 43.0d)
    @JSONField(name = "codeChallenge")
    public String codeChallenge;

    @JSONField(name = "codeChallengeMethod")
    @StringEnum(values = {"S256", "plain"})
    public String codeChallengeMethod;

    public LoginPluginModel$LoginRequestModel() {
    }
}
