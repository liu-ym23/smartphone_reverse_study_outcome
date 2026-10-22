package com.larus.business.debug.base.nmt;

import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.business.debug.api.NmtInjectService;
import com.larus.common.larksso.api.ILarkSSOService;
import com.larus.network.m;
import com.larus.network.ttnet.TTNetCommonQueryParamsInjector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.q1;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yv8.a;
import yv8.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/business/debug/base/nmt/NmtInjectServiceImpl;", "Lcom/larus/business/debug/api/NmtInjectService;", "<init>", "()V", "setTestEnv", "", "envType", "", "envName", "clearTestEnv", "addOrUpdateCommonQueryParams", "key", "value", "clearCommonQueryParams", "uploadAllALog", "openAppLogEtVerify", "closeAppLogEtVerify", "openNetworkAnyDoor", "closeNetworkAnyDoor", "closeDebugFloatPanel", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NmtInjectServiceImpl implements NmtInjectService {
    public NmtInjectServiceImpl() {
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void a() {
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void d() {
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void h() {
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void b() {
        IApplog r0 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r0 == null) goto L6;
        r0.m();
        return;
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void g() {
        IApplog r0 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r0 == null) goto L6;
        r0.z();
        return;
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void j() {
        int r0 = c.a;
        FLogger.a.e("auto_test", new a());
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void f() {
        TTNetCommonQueryParamsInjector.clearCommonQueryParams();
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void i() {
        c.b();
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        TTNetCommonQueryParamsInjector.addCommonQueryParams(r2, r3);
    }

    @Override // com.larus.business.debug.api.NmtInjectService
    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "envType");
        Intrinsics.checkNotNullParameter(r11, "envName");
        int r0 = c.a;
        if (r10 == null) goto L92;
        Lazy r1 = m.a;
        q1 r2 = m.a();
        boolean r3 = r2.a;
        boolean r4 = r2.c;
        String r12 = r10.toLowerCase(Locale.ROOT);
        boolean r5 = Intrinsics.areEqual("boe", r12);
        boolean r13 = Intrinsics.areEqual("ppe", r12);
        if (r5 == true) goto L12;
        if (r13 == true) goto L12;
        if (r3 == true) goto L11;
        if (r4 == true) goto L11;
        return;
    L11:
        c.b();
        return;
    L12:
        boolean r6 = true;
        if (r11 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L94;
        String r8 = "";
        if (r5 == true) goto L24;
        if (r13 == true) goto L59;
        return;
    L59:
        if (StringsKt.startsWith$default(r11, "ppe_", false, 2, null) == true) goto L63;
        r11 = "ppe_" + r11;
    L63:
        if (Intrinsics.areEqual(r11, r2.d) == false) goto L66;
        return;
    L66:
        if (StringsKt.startsWith$default(r11, "ppe_", false, 2, null) == true) goto L69;
        r11 = "ppe_" + r11;
    L69:
        m.c("", r11);
        Thread.sleep(10);     // Catch: InterruptedException -> L78
        if (c.a().length() > 0) goto L75;
        r6 = false;
    L75:
        if (r6 == false) goto L91;
        return;
    L91:
        return;
    L78:
        e = move-exception;
        e.getMessage();
        return;
    L24:
        if (StringsKt.startsWith$default(r11, "boe_", false, 2, null) == true) goto L28;
        r11 = "boe_" + r11;
    L28:
        if (Intrinsics.areEqual(r11, r2.b) == true) goto L86;
        m.c(r11, "");
        Thread.sleep(10);     // Catch: InterruptedException -> L55
        ServiceManager r14 = ServiceManager.get();
        if (r14 != null) goto L35;
        r8 = "SetTestEnv failed for null ServiceManager";
    L43:
        if (r8.length() <= 0) goto L45;
        boolean r15 = true;
    L46:
        if (r15 == false) goto L49;
        return;
    L49:
        if (c.a().length() > 0) goto L52;
        r6 = false;
    L52:
        if (r6 == true) goto L96;
        "SetTestEnv success with boe environment ".concat(r11);
        return;
    L96:
        return;
    L45:
        r15 = false;
        goto L46
    L35:
        ILarkSSOService r9 = (ILarkSSOService) r14.getService(ILarkSSOService.class);
        if (r9 != null) goto L38;
        r8 = "SetTestEnv failed for null ILarkSSOService";
        goto L43
    L38:
        ILoginService r16 = (ILoginService) r14.getService(ILoginService.class);
        if (r16 != null) goto L41;
        r8 = "SetTestEnv failed for null ILoginService";
        goto L43
    L41:
        r9.clearCache();
        r16.x(false, null, "logout_by_auto_test");
    L55:
        e = move-exception;
        e.getMessage();
        return;
    L86:
        return;
    L94:
        return;
    L15:
        if (r11.length() == 0) goto L18;
        r7 = false;
        goto L19
    }
}
