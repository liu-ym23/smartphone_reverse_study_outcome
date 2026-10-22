package com.ss.android.lark.contact.base.dto;

import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatterSelectBean extends BaseSelectBean {
    private static final long serialVersionUID = -8980352757996945035L;
    private ChatterDescription chatterDescription;
    private Chatter.ChatterType chatterType;
    private boolean hasOUPermission;
    private boolean isRegistered;
    private String mailAddress;
    private List<String> mailAddressHitTerms;
    private String tenantId;
    private String timeZoneId;
    private WorkStatus workStatus;

    @Override // com.ss.android.lark.contact.base.dto.BaseSelectBean
    public int getType() {
        return 2;
    }

    public boolean isCustomer() {
        return DocTabPayload.DocType.UNKNOWN.equals(this.tenantId);
    }

    public ChatterSelectBean() {
        this.hasOUPermission = true;
    }

    public ChatterDescription getChatterDescription() {
        return this.chatterDescription;
    }

    public Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public List<String> getMailAddressHitTerms() {
        return this.mailAddressHitTerms;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTimeZoneId() {
        return this.timeZoneId;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public boolean isHasOUPermission() {
        return this.hasOUPermission;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setChatterDescription(ChatterDescription r1) {
        this.chatterDescription = r1;
    }

    public void setChatterType(Chatter.ChatterType r1) {
        this.chatterType = r1;
    }

    public void setHasOUPermission(boolean r1) {
        this.hasOUPermission = r1;
    }

    public void setMailAddress(String r1) {
        this.mailAddress = r1;
    }

    public void setMailAddressHitTerms(List<String> r1) {
        this.mailAddressHitTerms = r1;
    }

    public void setRegistered(boolean r1) {
        this.isRegistered = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTimeZoneId(String r1) {
        this.timeZoneId = r1;
    }

    public void setWorkStatus(WorkStatus r1) {
        this.workStatus = r1;
    }
}
