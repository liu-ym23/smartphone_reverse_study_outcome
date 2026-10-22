package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/InteractAudienceApplyListFragmentV2;", "Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/BaseTalkApplyListFragmentV2;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceApplyListFragmentV2 extends BaseTalkApplyListFragmentV2 {
    public static final /* synthetic */ int N = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkApplyListFragmentV2
    public final void ba0() {
        super.ba0();
        qd0.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService();
        Context r1 = getContext();
        ((com.bytedance.android.live.liveinteract.service.f) r0).getClass();
        if (fj0.c.a() == false) goto L7;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter("apply_panel", "source");
        cj0.h.b(r1, "apply_panel");
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkApplyListFragmentV2
    public final void onDestroy() {
        super.onDestroy();
        yj0.f r0 = this.e;
        if (r0 == null) goto L6;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
        return;
    }

    public final void onResume() {
        super.onResume();
        aa0();
    }

    public InteractAudienceApplyListFragmentV2() {
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.BaseTalkApplyListFragmentV2
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        yj0.f r3 = new yj0.f(this.t, this);
        this.e = r3;
        ((com.bytedance.android.livesdk.common.c) r3).a = this;
    }
}
