package jmb;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.bear.contract.config.InterfaceDomain;
import com.bytedance.ee.bear.contract.config.LoginInfo;
import com.bytedance.ee.bear.contract.config.TenantInfo;
import com.bytedance.ee.bear.lark.dependency.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.integrator.ccm.dependency.FrontierAppKeyConfig;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static DocDynamicConfig a() {
        User r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r0 == null) goto L5;
        String r2 = r0.getUserId();
        String r1 = r0.getTenantCode();
        String r3 = r2;
    L6:
        String r4 = jl5.a.a();
        if (TextUtils.isEmpty(r4) == true) goto L9;
        String r5 = r4;
    L10:
        User r6 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r6 != null) goto L13;
        String r7 = "";
    L14:
        User r8 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        String r13 = null;
        if (r8 == null) goto L17;
        String r9 = b0c.a.a(r8);
    L18:
        if (r9 != null) goto L20;
        String r10 = "";
    L21:
        User r11 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r11 == null) goto L24;
        String r12 = r11.enName;
    L25:
        if (r12 != null) goto L27;
        String r14 = "";
    L28:
        User r15 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r15 == null) goto L31;
        String r16 = r15.getTenantId();
    L32:
        if (r16 != null) goto L34;
        String r17 = "";
    L35:
        User r18 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r18 == null) goto L38;
        String r19 = r18.getTenantName();
    L39:
        if (r19 != null) goto L41;
        String r20 = "";
    L42:
        LoginInfo r110 = new LoginInfo(r3, r5, r7, r10, r14, r17, r20, false);
        String r21 = ((epb.a) LarkContext.spiByDwarf(epb.a.class)).getDeviceId();
        String r111 = gcb.b.a(r1);
        String r112 = gcb.b.b(r1);
        boolean r113 = !((gpb.a) ApiUtils.getApi(gpb.a.class)).isFeishuBrand();
        InterfaceDomain r22 = new InterfaceDomain(jcb.b.c().a("docs_api"), jcb.b.c().a("docs_drive"));
        String r23 = jcb.b.c().a("docs_long");
        List r24 = jcb.b.c().b("docs_frontier");
        if (r24 != null) goto L45;
    L47:
        String r114 = r23;
        String r25 = jcb.b.c().a("mina");
        String r26 = jcb.b.c().a("docs_fe_resource_hotfix");
        iva.a.a().getClass();
        int r27 = LarkAppContext.inst().appIdInfo().a;
        FrontierAppKeyConfig r28 = (FrontierAppKeyConfig) SettingManager.getInstance().get(FrontierAppKeyConfig.class);
        if (r28 == null) goto L50;
        r13 = r28.mDocAppKey;
    L50:
        TenantInfo r29 = new TenantInfo(r111, r112, r113, r22, r114, r24, r25, r26, r27, r13);
        boolean r30 = !((g) LarkContext.spiByDwarf(g.class)).N0();
        Application r31 = LarkContext.getApplication();
        if (PackageChannelManager.isKABuildPackage(r31) == true) goto L53;
    L55:
        boolean r32 = false;
    L56:
        String r115 = PackageChannelManager.getBuildPackageChannel(r31);
        String r33 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).getUserUnit();
        String r34 = ((gpb.a) ApiUtils.getApi(gpb.a.class)).getTenantBrand();
        boolean r116 = LarkAppContext.inst().buildConfig().isUsPackage();
        tt5.a.h("DocDynamicConfigImpl", "getDocDynamicConfig: showDocWatermark= " + r30 + " isPrivateKaPkg= " + r32 + " buildPackageChannel= " + r115 + "userUnit= " + r33 + "isUsPackage=" + r116);
        return new DocDynamicConfig(r110, r21, r29, r30, r32, r115, r33, r34, r116);
    L53:
        if (PackageChannelManager.getDeployMode(r31) == 1) goto L55;
        r32 = true;
        goto L56
    L45:
        if (r24.isEmpty() == true) goto L47;
        r23 = (String) ListProtector.get(r24, 0);
        goto L47
    L41:
        r20 = r19;
        goto L42
    L38:
        r19 = null;
        goto L39
    L34:
        r17 = r16;
        goto L35
    L31:
        r16 = null;
        goto L32
    L27:
        r14 = r12;
        goto L28
    L24:
        r12 = null;
        goto L25
    L20:
        r10 = r9;
        goto L21
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = r6.avatarUrl;
        goto L14
    L9:
        tt5.a.d("DocDynamicConfigImpl", "preloadDocSdk().getAppKey() appToken is empty");
        r5 = "";
        goto L10
    L5:
        r1 = "";
        r3 = r1;
        goto L6
    }
}
