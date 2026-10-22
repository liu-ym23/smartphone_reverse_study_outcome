package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SystemPermission$Response extends LKBaseResponseModel {

    @JSONField(name = "deniedPermissions")
    public List<String> mDeniedPermissions;

    @JSONField(name = "grantedPermissions")
    public List<String> mGrantedPermissions;

    public SystemPermission$Response() {
        this.mGrantedPermissions = new ArrayList();
        this.mDeniedPermissions = new ArrayList();
    }
}
