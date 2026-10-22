package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
final class OAccount$verifySmsCode$1 extends Lambda implements Function1<f, Unit> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ int $scene;

    /* JADX WARN: Multi-variable type inference failed */
    OAccount$verifySmsCode$1(String r10, String r11, int r12, Function2<? super Integer, ? super String, Unit> r13, Function1<? super Bundle, Unit> r14) {
        this.$mobile = r10;
        this.$code = r11;
        this.$scene = r12;
        this.$onFailed = r13;
        this.$onSuccess = r14;
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
        r10.J1(this.$mobile, this.$code, this.$scene, new OAccount.AsyncResultCallback("verifySmsCode", null, this.$onFailed, this.$onSuccess));
    }
}
