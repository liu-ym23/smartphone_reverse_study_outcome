package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$verifySmsCode$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ String $code;
    final /* synthetic */ String $mobile;
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function1<Bundle, Unit> $onSuccess;
    final /* synthetic */ int $scene;

    OAccount$verifySmsCode$1(String r3, String r4, int r5, Function2<? super Integer, ? super String, Unit> r6, Function1<? super Bundle, Unit> r7) {
        Function2<Integer, String, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Function1<Bundle, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        this.$mobile = r3;
        this.$code = r4;
        this.$scene = r5;
        this.$onFailed = r8;
        this.$onSuccess = r9;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(c r3) {
        invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "service");
        r10.a(this.$mobile, this.$code, this.$scene, (b) ZeusTransformUtils.preCheckCast(new d.a("verifySmsCode", null, this.$onFailed, this.$onSuccess), b.class, "com.obric.memorydata.plugin"));
    }
}
