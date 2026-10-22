package com.larus.account.saas;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.saas.coreapi.IAccountTouristService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/account/saas/coreapi/IAccountTouristService;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class FlowAccountSdk$getAccountTouristService$1 extends Lambda implements Function0<IAccountTouristService> {
    public static final FlowAccountSdk$getAccountTouristService$1 INSTANCE = null;

    static {
        INSTANCE = new FlowAccountSdk$getAccountTouristService$1();
    }

    public FlowAccountSdk$getAccountTouristService$1() {
        super(0);
    }

    public final IAccountTouristService invoke() {
        return (IAccountTouristService) ServiceManager.get().getService(IAccountTouristService.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m368invoke() {
        return invoke();
    }
}
