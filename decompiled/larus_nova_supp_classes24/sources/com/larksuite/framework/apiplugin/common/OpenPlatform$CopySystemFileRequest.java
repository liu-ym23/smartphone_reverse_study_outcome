package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class OpenPlatform$CopySystemFileRequest extends LKBaseRequestModel {

    @JSONField(name = "destTTPath")
    @LKRequiredParam
    public String mDestTTPath;

    @JSONField(name = "srcPath")
    @LKRequiredParam
    public String mSrcPath;

    @JSONField(name = "tag")
    @LKRequiredParam
    public String mTag;

    public OpenPlatform$CopySystemFileRequest() {
    }
}
