package com.obric.update.impl.v2;

import com.bytedance.keva.Keva;
import com.obric.update.api.v2.IObricUpdateSettingService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0010H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/update/impl/v2/ObricUpdateSettingServiceImpl;", "Lcom/obric/update/api/v2/IObricUpdateSettingService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "isWiFiUpdateEnable", "", "setWifiUpdateEnable", "", "enable", "getLastCheckDate", "", "setLastCheckDate", "date", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateSettingServiceImpl implements IObricUpdateSettingService {
    public static final /* synthetic */ int b = 0;
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final boolean a() {
        return ((Keva) this.a.getValue()).getBoolean("wifi_auto_update_enable", true);
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final String c() {
        return ((Keva) this.a.getValue()).getString("last_check_date", "");
    }

    public ObricUpdateSettingServiceImpl() {
        this.a = LazyKt.lazy(new n());
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "date");
        ((Keva) this.a.getValue()).storeString("last_check_date", r3);
    }

    @Override // com.obric.update.api.v2.IObricUpdateSettingService
    public final void d(boolean r3) {
        ((Keva) this.a.getValue()).storeBoolean("wifi_auto_update_enable", r3);
    }
}
