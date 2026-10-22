package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/InteractAudienceOpenFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceOpenFragment extends BaseFragment {
    public View d;
    public TextView e;

    public InteractAudienceOpenFragment() {
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566051, r3, false);
        this.d = r5.findViewById(2131381518);
        this.e = (TextView) r5.findViewById(2131391031);
        View r6 = this.d;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("openLinkBtn");
    L5:
        r6.setOnClickListener(x0.a(AnonymousClass1.INSTANCE));
        RevPkState r7 = jc1.k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().d();
        if (us1.b.a() == true) goto L8;
    L13:
        TextView r8 = this.e;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tvOpenTips");
    L16:
        r8.setText(s1.B(2131923099));
    L17:
        int r9 = jf0.b.a;
        jf0.b.j("livesdk_guest_connection_open_banner_show");
        return r5;
    L8:
        if (r7 == RevPkState.DISABLE) goto L13;
        TextView r10 = this.e;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tvOpenTips");
    L12:
        r10.setText(s1.B(2131923100));
        goto L17
    }
}
