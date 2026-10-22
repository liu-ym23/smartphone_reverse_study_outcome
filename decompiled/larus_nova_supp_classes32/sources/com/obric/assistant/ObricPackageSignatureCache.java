package com.obric.assistant;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/ObricPackageSignatureCache;", "Lcom/obric/assistant/IObricPackageSignatureCacheService;", "<init>", "()V", "service", "getService", "()Lcom/obric/assistant/IObricPackageSignatureCacheService;", "service$delegate", "Lkotlin/Lazy;", "getOrCompute", NameKeys.UnloadStrategy_No_Strategy, "pkgName", "refresh", "remove", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPackageSignatureCache implements IObricPackageSignatureCacheService {
    public static final ObricPackageSignatureCache a = null;
    public static final Lazy b = null;

    private ObricPackageSignatureCache() {
    }

    static {
        a = new ObricPackageSignatureCache();
        b = LazyKt.lazy(new o1());
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final String getOrCompute(String r2) {
        IObricPackageSignatureCacheService r0 = (IObricPackageSignatureCacheService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getOrCompute(r2);
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final String refresh(String r2) {
        IObricPackageSignatureCacheService r0 = (IObricPackageSignatureCacheService) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.refresh(r2);
    }

    @Override // com.obric.assistant.IObricPackageSignatureCacheService
    public final void remove(String r2) {
        IObricPackageSignatureCacheService r0 = (IObricPackageSignatureCacheService) b.getValue();
        if (r0 == null) goto L6;
        r0.remove(r2);
        return;
    }
}
