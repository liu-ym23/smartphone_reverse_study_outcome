package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class GroupChatConfig implements Serializable {
    private Condition$GroupChatTypeCondition groupChatTypeCondition;
    private Condition$PublicTypeCondition publicTypeCondition;
    private Condition$ShieldTypeCondition shieldTypeCondition;
    private Condition$TenantCondition tenantCondition;

    public GroupChatConfig() {
        this.tenantCondition = Condition$TenantCondition.ALL_TENANT;
        this.groupChatTypeCondition = Condition$GroupChatTypeCondition.ALL_CHAT;
        this.publicTypeCondition = Condition$PublicTypeCondition.ALL_STATUS;
        this.shieldTypeCondition = Condition$ShieldTypeCondition.ALL;
    }

    public Condition$GroupChatTypeCondition getGroupChatTypeCondition() {
        return this.groupChatTypeCondition;
    }

    public Condition$PublicTypeCondition getPublicTypeCondition() {
        return this.publicTypeCondition;
    }

    public Condition$ShieldTypeCondition getShieldTypeCondition() {
        return this.shieldTypeCondition;
    }

    public Condition$TenantCondition getTenantCondition() {
        return this.tenantCondition;
    }

    public void setGroupChatTypeCondition(Condition$GroupChatTypeCondition r1) {
        this.groupChatTypeCondition = r1;
    }

    public void setTenantCondition(Condition$TenantCondition r1) {
        this.tenantCondition = r1;
    }

    public static void access$000(GroupChatConfig r0, Condition$PublicTypeCondition r1) {
        r0.publicTypeCondition = r1;
    }

    public static void access$100(GroupChatConfig r0, Condition$ShieldTypeCondition r1) {
        r0.shieldTypeCondition = r1;
    }
}
