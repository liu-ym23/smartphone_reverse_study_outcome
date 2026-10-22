package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKFireEvent$Request extends LKBaseRequestModel {

    @JSONField(name = "action")
    public String mAction;

    @JSONField(name = "data")
    public JSONObject mData;

    @JSONField(name = "extraData")
    public Map<String, Object> mExtraData;

    @JSONField(name = "originEvent")
    public String mOriginEvent;

    @JSONField(name = "useArrayBuffer")
    public boolean mUseArrayBuffer;

    public LKFireEvent$Request() {
        this.mUseArrayBuffer = false;
        this.mExtraData = new HashMap();
    }
}
