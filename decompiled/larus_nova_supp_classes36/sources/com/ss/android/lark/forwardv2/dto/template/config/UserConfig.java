package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class UserConfig implements Serializable {
    private Condition$ShieldTypeCondition shieldTypeCondition;
    private Condition$TenantCondition tenantCondition;
    private Condition$UserTypeCondition userTypeCondition;

    public UserConfig() {
        this.tenantCondition = Condition$TenantCondition.ALL_TENANT;
        this.userTypeCondition = Condition$UserTypeCondition.ALL_USER;
        this.shieldTypeCondition = Condition$ShieldTypeCondition.ALL;
    }

    public Condition$ShieldTypeCondition getShieldTypeCondition() {
        return this.shieldTypeCondition;
    }

    public Condition$TenantCondition getTenantCondition() {
        return this.tenantCondition;
    }

    public Condition$UserTypeCondition getUserTypeCondition() {
        return this.userTypeCondition;
    }

    public void setTenantCondition(Condition$TenantCondition r1) {
        this.tenantCondition = r1;
    }

    public void setUserTypeCondition(Condition$UserTypeCondition r1) {
        this.userTypeCondition = r1;
    }

    public static void access$000(UserConfig r0, Condition$ShieldTypeCondition r1) {
        r0.shieldTypeCondition = r1;
    }
}
