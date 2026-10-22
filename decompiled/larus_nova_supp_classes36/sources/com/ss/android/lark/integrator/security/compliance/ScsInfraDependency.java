package com.ss.android.lark.integrator.security.compliance;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.security.compliance.infra.dependency.IScsInfraDependency;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(IScsInfraDependency.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/integrator/security/compliance/ScsInfraDependency;", "Lcom/ss/android/lark/security/compliance/infra/dependency/IScsInfraDependency;", "<init>", "()V", "getUserId", "", "getTenantId", "getDeviceId", "getForegroundUserSession", "isBoe", "", "isChinaMainlandGeo", "isFeishuBrand", "getLarkHttpClient", "Lcom/larksuite/framework/http/client/IHttpClient;", "security-compliance-assembly-officesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ScsInfraDependency implements IScsInfraDependency {
    public ScsInfraDependency() {
    }

    public x18.b getLarkHttpClient() {
        return null;
    }

    public String getDeviceId() {
        return ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
    }

    public String getForegroundUserSession() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.getSession();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getTenantId() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 == null) goto L6;
        String r1 = r0.getTenantId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    public boolean isBoe() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isBoe();
    }

    public boolean isChinaMainlandGeo() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isChinaMainlandGeo();
    }

    public boolean isFeishuBrand() {
        return ((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
    }
}
