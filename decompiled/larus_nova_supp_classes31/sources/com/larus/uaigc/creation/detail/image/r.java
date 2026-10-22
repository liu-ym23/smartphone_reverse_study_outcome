package com.larus.uaigc.creation.detail.image;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.home.impl.sdk.b1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class r implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ BigImageDetailFragment b;

    public /* synthetic */ r(String r1, BigImageDetailFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        String r0 = this.a;
        BigImageDetailFragment r1 = this.b;
        int r2 = BigImageDetailFragment.I;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L5;
        r3.D0();
        b1.a.d(r0);
    L5:
        String r4 = r1.F.k;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r1), null, null, new BigImageDetailFragment$saveImage$1(r1, r4, r0, null), 3, null);
        return Unit.INSTANCE;
    }
}
