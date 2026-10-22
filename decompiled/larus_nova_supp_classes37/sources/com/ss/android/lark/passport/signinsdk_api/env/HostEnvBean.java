package com.ss.android.lark.passport.signinsdk_api.env;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class HostEnvBean implements Serializable {

    @JSONField(name = "env_type")
    public int envType;

    @JSONField(name = "set_rust_env")
    public boolean needSetRustEnvForListenerOnly;

    @JSONField(name = "tenant_brand")
    public String tenantBrand;

    @JSONField(name = "user_unit")
    public String userUnit;

    public HostEnvBean cloneMe() {
        return new HostEnvBean(this.userUnit, this.tenantBrand, this.envType);
    }

    public String toString() {
        return "HostEnvBean{userUnit='" + this.userUnit + "', envType=" + this.envType + ", tenantBrand='" + this.tenantBrand + "', needSetRustEnvForListenerOnly='" + this.needSetRustEnvForListenerOnly + "'}";
    }

    public HostEnvBean() {
    }

    public boolean isChanged(HostEnvBean r4) {
        if (r4 != null) goto L6;
        return true;
    L6:
        if (TextUtils.equals(this.userUnit, r4.userUnit) == true) goto L8;
        return true;
    L8:
        if (TextUtils.equals(this.tenantBrand, r4.tenantBrand) == true) goto L10;
        return true;
    L10:
        if (this.envType != r4.envType) goto L16;
        return false;
    L16:
        return true;
    }

    public HostEnvBean(String r1, String r2, int r3) {
        this.userUnit = r1;
        this.envType = r3;
        this.tenantBrand = r2;
    }
}
