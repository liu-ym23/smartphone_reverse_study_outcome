package com.obric.matrix.platform.sdk.ones.account;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "service", "Lcom/obric/matrix/platform/sdk/ones/account/IAccountService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAccount$ticketResetPassword$1 extends Lambda implements Function1<c, Unit> {
    final /* synthetic */ Function2<Integer, String, Unit> $onFailed;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ String $password;
    final /* synthetic */ String $ticket;

    OAccount$ticketResetPassword$1(String r3, String r4, Function0<Unit> r5, Function2<? super Integer, ? super String, Unit> r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Function2<Integer, String, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        this.$ticket = r3;
        this.$password = r4;
        this.$onSuccess = r7;
        this.$onFailed = r8;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(c r3) {
        invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r12) {
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r12, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "service");
        r13.c(this.$ticket, this.$password, (b) ZeusTransformUtils.preCheckCast(new d.a("ticketResetPassword", this.$onSuccess, this.$onFailed, null, 8, null), b.class, "com.obric.memorydata.plugin"));
    }
}
