package com.larus.uaigc.creation.detail.image;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ BigImageDetailFragment a;

    public /* synthetic */ p(BigImageDetailFragment r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        BigImageDetailFragment r0 = this.a;
        String r10 = (String) r9;
        int r1 = BigImageDetailFragment.I;
        Intrinsics.checkNotNullParameter(r10, "watermarkUrl");
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L5;
        r2.D0();
        b1.a.d(r10);
    L5:
        String r3 = r0.F.k;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new BigImageDetailFragment$saveImage$1(r0, r3, r10, null), 3, null);
        return Unit.INSTANCE;
    }
}
