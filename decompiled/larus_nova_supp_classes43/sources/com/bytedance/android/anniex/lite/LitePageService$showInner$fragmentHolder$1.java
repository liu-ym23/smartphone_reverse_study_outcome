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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/a;", "", "invoke", "(Lcom/bytedance/android/anniex/base/builder/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LitePageService$showInner$fragmentHolder$1 extends Lambda implements Function1<com.bytedance.android.anniex.base.builder.a, Unit> {
    final /* synthetic */ com.bytedance.android.anniex.base.lifecycle.a $annieXLifecycle;
    final /* synthetic */ IAnnieXLifecycleConfigService $annieXLifecycleConfigService;
    final /* synthetic */ String $bid;
    final /* synthetic */ k $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isFromScan;

    public LitePageService$showInner$fragmentHolder$1(String r1, k r10, Context r11, com.bytedance.android.anniex.base.lifecycle.a r12, IAnnieXLifecycleConfigService r13, boolean r14) {
        this.$bid = r1;
        this.$config = r10;
        this.$context = r11;
        this.$annieXLifecycle = r12;
        this.$annieXLifecycleConfigService = r13;
        this.$isFromScan = r14;
        super(1);
    }

    public final void invoke(com.bytedance.android.anniex.base.builder.a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$createFullScreenFragmentHolder");
        String r0 = this.$bid;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r10.b = r0;
        r10.b(this.$config.d);
        FragmentActivity r1 = this.$context;
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.a = r1;
        com.bytedance.android.anniex.base.lifecycle.a r11 = this.$annieXLifecycle;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        r10.f = r11;
    L5:
        IAnnieXLifecycleConfigService r12 = this.$annieXLifecycleConfigService;
        if (r12 == null) goto L8;
        r12.z();
    L8:
        r10.j = this.$isFromScan;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.anniex.base.builder.a) r1);
        return Unit.INSTANCE;
    }
}
