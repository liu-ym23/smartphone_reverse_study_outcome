package com.larus.account.saas;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.saas.coreapi.IAccountMfaService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/larus/account/saas/coreapi/IAccountMfaService;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class FlowAccountSdk$getAccountMfaService$1 extends Lambda implements Function0<IAccountMfaService> {
    public static final FlowAccountSdk$getAccountMfaService$1 INSTANCE = null;

    static {
        INSTANCE = new FlowAccountSdk$getAccountMfaService$1();
    }

    public FlowAccountSdk$getAccountMfaService$1() {
        super(0);
    }

    public final IAccountMfaService invoke() {
        return (IAccountMfaService) ServiceManager.get().getService(IAccountMfaService.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m364invoke() {
        return invoke();
    }
}
