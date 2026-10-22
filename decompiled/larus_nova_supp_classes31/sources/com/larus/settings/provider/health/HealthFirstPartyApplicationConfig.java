package com.larus.settings.provider.health;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.e2;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B_\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/health/HealthFirstPartyApplicationConfig;", "Ljava/io/Serializable;", "healthBotList", "", "", "panelTotalContent", "panelLinkRanges", "Lcom/larus/settings/provider/health/HealthAgreementInfo;", "settingAgreementTitle", "settingAgreementUrl", "settingAgreementTrackName", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHealthBotList", "()Ljava/util/List;", "getPanelTotalContent", "()Ljava/lang/String;", "getPanelLinkRanges", "getSettingAgreementTitle", "getSettingAgreementUrl", "getSettingAgreementTrackName", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HealthFirstPartyApplicationConfig implements Serializable {

    @SerializedName("bot_ids")
    private final List<String> healthBotList;

    @SerializedName("panel_link_ranges")
    private final List<HealthAgreementInfo> panelLinkRanges;

    @SerializedName("panel_total_content")
    private final String panelTotalContent;

    @SerializedName("setting_agreement_title")
    private final String settingAgreementTitle;

    @SerializedName("setting_agreement_track_name")
    private final String settingAgreementTrackName;

    @SerializedName("setting_agreement_url")
    private final String settingAgreementUrl;

    public HealthFirstPartyApplicationConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final List<String> getHealthBotList() {
        return this.healthBotList;
    }

    public final List<HealthAgreementInfo> getPanelLinkRanges() {
        return this.panelLinkRanges;
    }

    public final String getPanelTotalContent() {
        return this.panelTotalContent;
    }

    public final String getSettingAgreementTitle() {
        return this.settingAgreementTitle;
    }

    public final String getSettingAgreementTrackName() {
        return this.settingAgreementTrackName;
    }

    public final String getSettingAgreementUrl() {
        return this.settingAgreementUrl;
    }

    public HealthFirstPartyApplicationConfig(List<String> r1, String r2, List<HealthAgreementInfo> r3, String r4, String r5, String r6) {
        this.healthBotList = r1;
        this.panelTotalContent = r2;
        this.panelLinkRanges = r3;
        this.settingAgreementTitle = r4;
        this.settingAgreementUrl = r5;
        this.settingAgreementTrackName = r6;
    }

    public HealthFirstPartyApplicationConfig(List r8, String r9, List r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r8 = CollectionsKt.emptyList();
    L6:
        if ((r14 & 2) == 0) goto L8;
        r9 = AppHost.a.getApplication().getString(2131897770);
    L8:
        String r16 = r9;
        String r0 = "notice_for_health_consultation";
        String r1 = "";
        if ((r14 & 4) == 0) goto L29;
        HealthAgreementInfo[] r17 = new HealthAgreementInfo[3];
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L13;
        r3.r0();
        e2 r4 = e2.a;
        String r5 = e2.b;
    L14:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r17[0] = new HealthAgreementInfo(r5, 87, 10, "user_service_agreement");
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L19;
        r6.r0();
        e2 r7 = e2.a;
        String r18 = e2.d;
    L20:
        if (r18 != null) goto L22;
        r18 = "";
    L22:
        r17[1] = new HealthAgreementInfo(r18, 97, 8, "privacy_policy");
        IFlowSdkDepend r19 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r19 == null) goto L25;
        r19.r0();
        e2 r20 = e2.a;
        String r21 = e2.c;
    L26:
        if (r21 != null) goto L28;
        r21 = "";
    L28:
        r17[2] = new HealthAgreementInfo(r21, 107, 14, "notice_for_health_consultation");
        r10 = CollectionsKt.listOf(r17);
        goto L29
    L25:
        r21 = null;
        goto L26
    L19:
        r18 = null;
        goto L20
    L13:
        r5 = null;
    L29:
        List r22 = r10;
        if ((r14 & 8) == 0) goto L32;
        r11 = AppHost.a.getApplication().getString(2131897772);
    L32:
        String r23 = r11;
        if ((r14 & 16) == 0) goto L40;
        IFlowSdkDepend r24 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r24 == null) goto L37;
        r24.r0();
        e2 r25 = e2.a;
        r12 = e2.c;
    L38:
        if (r12 != null) goto L40;
    L42:
        if ((r14 & 32) != 0) goto L45;
        r0 = r13;
    L45:
        this(r8, r16, r22, r23, r1, r0);
        return;
    L37:
        r12 = null;
    L40:
        r1 = r12;
        goto L42
    }
}
