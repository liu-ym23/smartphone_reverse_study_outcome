package com.obric.assistant.spi.account;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gga.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0013\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/spi/account/ObricAccountSPIServiceDelegate;", "Lcom/obric/assistant/spi/account/IObricAccountSPIService;", "<init>", "()V", "getActionBarModelMenuPolicy", "Lcom/obric/assistant/spi/account/ObricActionBarModelMenuPolicy;", "getCurrentPersonalAccountUid", "", "getLocalAccountUidBySecUserId", "secUserId", "shouldOnlyShowEnterpriseLoginWhenAddAccount", "", "shouldShowAccountSettingLogout", "shouldShowAccountSettingPhoneEntry", "shouldShowAccountSettingPlatformEntry", "platform", "shouldShowRemoveButton", "isEnterprise", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAccountSPIServiceDelegate implements IObricAccountSPIService {
    public static final ObricAccountSPIServiceDelegate b = null;
    public final /* synthetic */ IObricAccountSPIService a;

    static {
        b = new ObricAccountSPIServiceDelegate();
    }

    public final String a() {
        return this.a.a();
    }

    public final boolean b(String r2) {
        return this.a.b(r2);
    }

    public final boolean c() {
        return this.a.c();
    }

    public final String d(String r2) {
        return this.a.d(r2);
    }

    public final a e() {
        return this.a.e();
    }

    public final boolean f(String r2, boolean r3) {
        return this.a.f(r2, r3);
    }

    public final boolean g() {
        return this.a.g();
    }

    public final boolean h() {
        return this.a.h();
    }

    private ObricAccountSPIServiceDelegate() {
        this.a = (IObricAccountSPIService) ServiceManager.get().getService(IObricAccountSPIService.class);
    }
}
