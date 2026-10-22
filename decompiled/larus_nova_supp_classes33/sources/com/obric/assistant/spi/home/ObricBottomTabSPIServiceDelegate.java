package com.obric.assistant.spi.home;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/spi/home/ObricBottomTabSPIServiceDelegate;", "Lcom/obric/assistant/spi/home/IObricBottomTabSPIService;", "<init>", "()V", "resolveEnterpriseFallbackBottomTabKeys", "", "", "originKeys", "resolveFallbackBottomTabKeys", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBottomTabSPIServiceDelegate implements IObricBottomTabSPIService {
    public static final ObricBottomTabSPIServiceDelegate b = null;
    public final /* synthetic */ IObricBottomTabSPIService a;

    static {
        b = new ObricBottomTabSPIServiceDelegate();
    }

    @Override // com.obric.assistant.spi.home.IObricBottomTabSPIService
    public final List<String> a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "originKeys");
        return this.a.a(r2);
    }

    @Override // com.obric.assistant.spi.home.IObricBottomTabSPIService
    public final List<String> b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "originKeys");
        return this.a.b(r2);
    }

    private ObricBottomTabSPIServiceDelegate() {
        this.a = (IObricBottomTabSPIService) ServiceManager.get().getService(IObricBottomTabSPIService.class);
    }
}
