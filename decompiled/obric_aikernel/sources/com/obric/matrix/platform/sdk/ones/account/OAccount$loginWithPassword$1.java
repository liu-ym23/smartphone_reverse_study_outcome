package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class OAccount$loginWithPassword$1 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    OAccount$loginWithPassword$1(String r10, String r11, Function0<Unit> r12, Function2<? super Integer, ? super String, Unit> r13) {
        this.$mobile = r10;
        this.$password = r11;
        this.$onSuccess = r12;
        this.$onFailed = r13;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(f r10) {
        invoke2(r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r11) {
        Intrinsics.checkNotNullParameter(r11, "service");
        r11.S1(this.$mobile, this.$password, new OAccount.AsyncResultCallback("loginWithPassword", this.$onSuccess, this.$onFailed, null, 8, null));
    }
}
