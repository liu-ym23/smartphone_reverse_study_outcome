package com.larus.account.saas.core.ttaccount;

import android.net.Uri;
import com.larus.account.saas.coreapi.IAccountDeeplinkHandler;
import com.larus.account.saas.coreapi.IAccountDispatchService;
import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/core/ttaccount/AccountDispatchService;", "Lcom/larus/account/saas/coreapi/IAccountDispatchService;", "<init>", "()V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class AccountDispatchService implements IAccountDispatchService {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((IAccountFrontierMessageHandler) r2).priority().getValue()), Integer.valueOf(((IAccountFrontierMessageHandler) r1).priority().getValue()));
        }
    }

    public AccountDispatchService() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountDispatchService
    public final boolean e(Uri r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        Iterator r0 = ServiceManager.get().getServices(IAccountDeeplinkHandler.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((IAccountDeeplinkHandler) r0.next()).a(r4) == false) goto L4;
        SaasTracking r1 = SaasTracking.a;
        JSONObject r2 = new JSONObject();
        r2.put("path", r4.toString());
        Unit r5 = Unit.INSTANCE;
        r1.reportEvent("doubao_account_remote_notification_dispatch", r2);
        return true;
    L9:
        return false;
    }

    @Override // com.larus.account.saas.coreapi.IAccountDispatchService
    public final boolean c(int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "payload");
        Iterator r0 = CollectionsKt.sortedWith(ServiceManager.get().getServices(IAccountFrontierMessageHandler.class), new a()).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((IAccountFrontierMessageHandler) r0.next()).a(r4, r5) == false) goto L4;
        SaasTracking r6 = SaasTracking.a;
        JSONObject r1 = new JSONObject();
        r1.put("service", String.valueOf(r3));
        r1.put("method", String.valueOf(r4));
        Unit r7 = Unit.INSTANCE;
        r6.reportEvent("doubao_account_frontier_msg_dispatch", r1);
        return true;
    L9:
        return false;
    }
}
