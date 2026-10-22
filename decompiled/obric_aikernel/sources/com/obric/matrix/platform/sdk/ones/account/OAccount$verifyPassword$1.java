package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class OAccount$verifyPassword$1 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ String $password;

    /* JADX WARN: Multi-variable type inference failed */
    OAccount$verifyPassword$1(String r10, String r11, Function2<? super Integer, ? super String, Unit> r12, Function1<? super Bundle, Unit> r13) {
        this.$mobile = r10;
        this.$password = r11;
        this.$onFailed = r12;
        this.$onSuccess = r13;
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
        r10.c2(this.$mobile, this.$password, new OAccount.AsyncResultCallback("verifyPassword", null, this.$onFailed, this.$onSuccess));
    }
}
