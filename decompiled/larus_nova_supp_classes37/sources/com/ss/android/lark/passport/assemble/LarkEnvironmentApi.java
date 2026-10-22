package com.ss.android.lark.passport.assemble;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$UNIT;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(gpb.a.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/assemble/LarkEnvironmentApi;", "Lcom/ss/android/lark/lark_env/api/ILarkEnvironmentApi;", "<init>", "()V", "envType", "", "isBoe", "", "registerEnvChangeListener", "", "listener", "Lcom/ss/android/lark/lark_env/listener/ILarkEnvChangeListener;", "unregisterEnvChangeListener", "buildConfigValue", "", "key", "isUsPackage", "getUserUnit", "isFeishuBrand", "getTenantBrand", "isChinaMainlandGeo", "getGeo", "getTenantGeo", "getPolicyUrl", "policyAgreement", "Lcom/ss/android/lark/passport/signinsdk_api/base/policy/PolicyAgreement;", "passport-officesdk-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LarkEnvironmentApi implements gpb.a {
    public LarkEnvironmentApi() {
    }

    public void registerEnvChangeListener(ipb.a r1) {
    }

    public void unregisterEnvChangeListener(ipb.a r1) {
    }

    private final boolean isUsPackage() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp().buildConfig().isUsPackage();
    }

    public String getTenantBrand() {
        String r0 = buildConfigValue("DEFAULT_BRAND");
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (isUsPackage() == false) goto L7;
        return "lark";
    L7:
        return "feishu";
    }

    public int envType() {
        Integer r0 = OfficeSDKManager.getEnv();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.intValue();
    }

    public String getGeo() {
        if (isBoe() == true) goto L5;
        String r0 = buildConfigValue("DEFAULT_GEO");
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (isUsPackage() == false) goto L14;
        return EnvConst$GEO.SG;
    L14:
        return EnvConst$GEO.CN;
    L5:
        if (isUsPackage() == false) goto L7;
        return EnvConst$GEO.BOE_US;
    L7:
        return EnvConst$GEO.BOE_CN;
    }

    public String getTenantGeo() {
        return getGeo();
    }

    public String getUserUnit() {
        if (isBoe() == true) goto L5;
        String r0 = buildConfigValue("DEFAULT_UNIT");
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (isUsPackage() == false) goto L14;
        return "larksgaws";
    L14:
        return "eu_nc";
    L5:
        if (isUsPackage() == false) goto L7;
        return EnvConst$UNIT.BOE_VA;
    L7:
        return EnvConst$UNIT.BOE_CN;
    }

    public boolean isBoe() {
        if (envType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isChinaMainlandGeo() {
        String r0 = getGeo();
        if (Intrinsics.areEqual(r0, EnvConst$GEO.CN) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r0, EnvConst$GEO.BOE_CN) == true) goto L8;
        return false;
    }

    public boolean isFeishuBrand() {
        return Intrinsics.areEqual(getTenantBrand(), "feishu");
    }

    @Deprecated(message = "use isFeishuBrand and envType")
    public int oldSdkEnv() {
        return gpb.a.a.a(this);
    }

    private final String buildConfigValue(String r3) {
        LarkAppContext.Companion.getClass();
        String r4 = (String) LarkAppContext.access$getInstance$cp().buildConfig().getValue(r3);
        if (r4 == null) goto L8;
        if ((!StringsKt.isBlank(r4)) == false) goto L8;
        return r4;
    L8:
        return null;
    }

    public String getPolicyUrl(PolicyAgreement r4) {
        Intrinsics.checkNotNullParameter(r4, "policyAgreement");
        String r0 = jcb.b.c().a("privacy");
        Intrinsics.checkNotNull(r0);
        if (StringsKt.startsWith(r0, "http", true) == false) goto L5;
        String r1 = "";
    L6:
        String r5 = r1 + r0 + '/' + r4.getPath();
        PassportLog.d("LarkEnvironmentApi", "policyAgreement url: " + r5);
        return r5;
    L5:
        r1 = "https://";
        goto L6
    }
}
