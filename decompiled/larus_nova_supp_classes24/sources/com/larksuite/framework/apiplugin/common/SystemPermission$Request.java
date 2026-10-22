package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class SystemPermission$Request extends LKBaseRequestModel {

    @JSONField(name = "force")
    private boolean mForceUiThread;

    @JSONField(name = "permissions")
    public List<String> mPermissions;

    public SystemPermission$Request() {
        this.mPermissions = new ArrayList();
        this.mForceUiThread = true;
    }

    public boolean isForceUiThread() {
        return this.mForceUiThread;
    }

    public void setForceUiThread(boolean r1) {
        this.mForceUiThread = r1;
    }
}
