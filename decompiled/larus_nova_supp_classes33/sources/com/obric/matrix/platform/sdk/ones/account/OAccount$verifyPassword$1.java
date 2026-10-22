package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$verifyPassword$1 extends Lambda implements Function1<IAccountService, Unit> {
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    public OAccount$verifyPassword$1(String r1, String r2, Function2<? super Integer, ? super String, Unit> r3, Function1<? super Bundle, Unit> r4) {
        this.$mobile = r1;
        this.$password = r2;
        this.$onFailed = r3;
        this.$onSuccess = r4;
        super(1);
    }

    public final void invoke(IAccountService r8) {
        Intrinsics.checkNotNullParameter(r8, "service");
        r8.verifyPassword(this.$mobile, this.$password, new OAccount$AsyncResultCallback("verifyPassword", null, this.$onFailed, this.$onSuccess));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IAccountService) r1);
        return Unit.INSTANCE;
    }
}
