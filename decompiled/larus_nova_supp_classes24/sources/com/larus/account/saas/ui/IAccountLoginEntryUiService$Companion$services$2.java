package com.larus.account.saas.ui;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larus/account/saas/ui/IAccountLoginEntryUiService;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class IAccountLoginEntryUiService$Companion$services$2 extends Lambda implements Function0<Set<? extends IAccountLoginEntryUiService>> {
    public static final IAccountLoginEntryUiService$Companion$services$2 INSTANCE = null;

    static {
        INSTANCE = new IAccountLoginEntryUiService$Companion$services$2();
    }

    public IAccountLoginEntryUiService$Companion$services$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Set<IAccountLoginEntryUiService> m390invoke() {
        return ServiceManager.get().getServices(IAccountLoginEntryUiService.class);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m390invoke();
    }
}
