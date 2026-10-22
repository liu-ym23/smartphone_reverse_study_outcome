package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class OAccount$checkPassword$1 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    OAccount$checkPassword$1(String r10, Function0<Unit> r11, Function2<? super Integer, ? super String, Unit> r12) {
        this.$password = r10;
        this.$onSuccess = r11;
        this.$onFailed = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r10) {
        Intrinsics.checkNotNullParameter(r10, "service");
        r10.H1(this.$password, new OAccount.AsyncResultCallback("checkPassword", this.$onSuccess, this.$onFailed, null, 8, null));
    }
}
