package jcb;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class b implements IDomainConfigService {
    public static IDomainConfigService b;
    public final IGlobalDomainConfigService a;

    public static IDomainConfigService c() {
        if (b != null) goto L6;
        Log.i("DomainConfigService", "get DomainConfigService instance from hilt");
        b = (IDomainConfigService) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(IDomainConfigService.class);
    L6:
        return b;
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String f0() {
        Log.i("DomainConfigService", "getSdkConfigDirPath called");
        return this.a.f0();
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void preload() {
        Log.i("DomainConfigService", "preload called");
        this.a.preload();
    }

    @Inject
    public b() {
        this.a = (IGlobalDomainConfigService) ((DwarfSPIEntryPoint) EntryPoints.get(gcb.a.a().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(IGlobalDomainConfigService.class);
        Log.i("DomainConfigService", "DomainConfigService constructor called");
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void M0(icb.a r3) {
        Log.i("DomainConfigService", "removeDomainSettingChangedObserver called.");
        Objects.requireNonNull(r3);
        a r0 = new a(r3);
        String r4 = gcb.a.a().getUserId();
        IGlobalDomainConfigService r1 = this.a;
        if (r4 != null) goto L5;
        r4 = BuildConfig.FLAVOR;
    L5:
        r1.Yb(r4, r0);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String a(String r3) {
        Log.d("DomainConfigService", "getDomain called, alias: " + r3);
        return this.a.e0(gcb.a.a().getUserId(), r3);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final List<String> b(String r3) {
        Log.d("DomainConfigService", "getDomains called, alias: ".concat(r3));
        return this.a.A(gcb.a.a().getUserId(), r3);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void h0(Map<String, List<String>> r3) {
        Log.i("DomainConfigService", "onForegroundUserDomainChanged called");
        this.a.h0(r3);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final Map<String, List<String>> o0(String r2) {
        return this.a.o0(r2);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final String L0(String r3, String r4) {
        Log.d("DomainConfigService", "getDomain called, alias: ".concat(r4));
        return this.a.e0(r3, r4);
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void N0(String r3, icb.a r4) {
        Log.i("DomainConfigService", "addDomainSettingChangedObserver with uid: " + r3 + " called.");
        Objects.requireNonNull(r4);
        this.a.sd(r3, new a(r4));
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final List<String> p0(String r3, int r4, String r5, String r6) {
        Log.d("DomainConfigService", "getDomainsFromFullEnvUnitBrandCache called, alias: " + r3 + ", envType:" + r4 + ", unit:" + r5 + ", brand:" + r6);
        List<String> r7 = this.a.p0(r3, r4, r5, r6);
        if (r7 == null) goto L6;
        return r7;
    L6:
        return Collections.emptyList();
    }

    @Override // com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService
    public final void K0(String r9, InitSDKRequest.EnvType r10, String r11, String r12, DomainSettings r13) {
        Log.i("DomainConfigService", "updateDomainSetting with uid start");
        this.a.K0(r9, r10, r11, r12, r13);
    }
}
