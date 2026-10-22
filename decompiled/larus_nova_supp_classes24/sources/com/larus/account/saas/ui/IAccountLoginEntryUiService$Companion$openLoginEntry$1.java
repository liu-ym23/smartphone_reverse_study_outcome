package com.larus.account.saas.ui;

import b48.e;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import x38.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "service", "Lcom/larus/account/saas/ui/IAccountLoginEntryUiService;", "invoke", "(Lcom/larus/account/saas/ui/IAccountLoginEntryUiService;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = WheelView.WHEEL_ITEM_HEIGHT)
final class IAccountLoginEntryUiService$Companion$openLoginEntry$1 extends Lambda implements Function1<IAccountLoginEntryUiService, Boolean> {
    final /* synthetic */ d $callback;
    final /* synthetic */ e $context;

    public IAccountLoginEntryUiService$Companion$openLoginEntry$1(e r1, d r2) {
        super(1);
    }

    public final Boolean invoke(IAccountLoginEntryUiService r2) {
        Intrinsics.checkNotNullParameter(r2, "service");
        return Boolean.valueOf(r2.a());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IAccountLoginEntryUiService) r1);
    }
}
