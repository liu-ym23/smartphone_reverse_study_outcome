package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class Messenger$DepartmentId2OpenDepartmentResponse extends LKBaseResponseModel {

    @JSONField(name = "departmentIdsWithOpenDepartmentIds")
    public Map<String, String> mDepartmentIdsWithOpenDepartmentIds;

    public Messenger$DepartmentId2OpenDepartmentResponse() {
        this.mDepartmentIdsWithOpenDepartmentIds = new HashMap();
    }
}
