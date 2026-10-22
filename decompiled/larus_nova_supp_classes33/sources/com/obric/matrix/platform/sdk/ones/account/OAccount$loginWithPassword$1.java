package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$loginWithPassword$1 extends Lambda implements Function1<IAccountService, Unit> {
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$loginWithPassword$1(String r1, String r2, Function0<Unit> r3, Function2<? super Integer, ? super String, Unit> r4) {
        this.$mobile = r1;
        this.$password = r2;
        this.$onSuccess = r3;
        this.$onFailed = r4;
        super(1);
    }

    public final void invoke(IAccountService r11) {
        Intrinsics.checkNotNullParameter(r11, "service");
        r11.loginWithPassword(this.$mobile, this.$password, new OAccount$AsyncResultCallback("loginWithPassword", this.$onSuccess, this.$onFailed, null, 8, null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IAccountService) r1);
        return Unit.INSTANCE;
    }
}
