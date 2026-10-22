package com.ss.android.lark.integrator.security.compliance.psda;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "scs_psda_config")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/psda/PsdaConfig;", "", "<init>", "()V", "disable", "", "disableTokenList", "", "", "getDisableTokenList", "()Ljava/util/List;", "setDisableTokenList", "(Ljava/util/List;)V", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PsdaConfig {

    @SerializedName("sensitive_api_control_disable")
    public boolean disable;

    @SerializedName("disable_token_list")
    private List<String> disableTokenList;

    public PsdaConfig() {
    }

    public final List<String> a() {
        return this.disableTokenList;
    }
}
