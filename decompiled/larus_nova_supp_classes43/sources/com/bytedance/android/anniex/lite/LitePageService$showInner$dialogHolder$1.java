package com.bytedance.android.anniex.lite;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import q26.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/c;", "", "invoke", "(Lcom/bytedance/android/anniex/base/builder/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LitePageService$showInner$dialogHolder$1 extends Lambda implements Function1<com.bytedance.android.anniex.base.builder.c, Unit> {
    final /* synthetic */ com.bytedance.android.anniex.base.lifecycle.a $annieXLifecycle;
    final /* synthetic */ IAnnieXLifecycleConfigService $annieXLifecycleConfigService;
    final /* synthetic */ String $bid;
    final /* synthetic */ k $config;
    final /* synthetic */ Context $context;

    public LitePageService$showInner$dialogHolder$1(String r1, k r10, Context r11, com.bytedance.android.anniex.base.lifecycle.a r12, IAnnieXLifecycleConfigService r13) {
        this.$bid = r1;
        this.$config = r10;
        this.$context = r11;
        this.$annieXLifecycle = r12;
        this.$annieXLifecycleConfigService = r13;
        super(1);
    }

    public final void invoke(com.bytedance.android.anniex.base.builder.c r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$createDialogHolder");
        r10.a(this.$bid);
        r10.b(this.$config.d);
        r10.d((FragmentActivity) this.$context);
        com.bytedance.android.anniex.base.lifecycle.a r0 = this.$annieXLifecycle;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "lifecycle");
        r10.f = r0;
    L5:
        IAnnieXLifecycleConfigService r1 = this.$annieXLifecycleConfigService;
        if (r1 == null) goto L8;
        r1.s();
    L8:
        r10.i = true;
        r10.c.putBoolean("bundle_annie_x_flow", true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.anniex.base.builder.c) r1);
        return Unit.INSTANCE;
    }
}
