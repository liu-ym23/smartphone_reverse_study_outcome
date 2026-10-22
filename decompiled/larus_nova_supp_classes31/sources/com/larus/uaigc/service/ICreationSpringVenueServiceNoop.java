package com.larus.uaigc.service;

import android.app.Activity;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J>\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/uaigc/service/ICreationSpringVenueServiceNoop;", "Lcom/larus/uaigc/service/ICreationSpringVenueService;", "<init>", "()V", "getCacheOrFetchSpringPocketData", "", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchSpringPocketData", "", "startObservePollingConfig", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "getWorldCupMainRouterInterceptor", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationSpringVenueServiceNoop implements ICreationSpringVenueService {
    public ICreationSpringVenueServiceNoop() {
    }

    public final void b(Activity r1, Map<String, ? extends Object> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "extra");
    }

    public final q97.a d() {
        return null;
    }

    public final void f() {
    }

    public final q97.a k() {
        return null;
    }

    public final void n() {
    }

    public final void r(Activity r1) {
    }

    public final Object l(Continuation<? super Map<String, ? extends Object>> r1) {
        return MapsKt.emptyMap();
    }
}
