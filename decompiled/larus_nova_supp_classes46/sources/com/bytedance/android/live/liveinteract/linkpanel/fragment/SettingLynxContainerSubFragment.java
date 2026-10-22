package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/SettingLynxContainerSubFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/SettingLynxContainerFragment;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public class SettingLynxContainerSubFragment extends SettingLynxContainerFragment {
    public static final /* synthetic */ int t = 0;
    public ih0.c s;

    public static final class a {
    }

    public static final class b extends b7.a {
        public b() {
        }

        public final void onLoadSuccess(View r1) {
            super.onLoadSuccess(r1);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment
    public final void aa0() {
        if (r2.a(this.l) == false) goto L18;
        Uri r3 = x6.a.d(this.l);
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        ih0.b r1 = r0.dynamicService(this.n);
        if (r1 == null) goto L9;
        ih0.c r2 = ih0.b.a.a(r1, requireContext(), r3, new b(), System.currentTimeMillis());
    L10:
        this.s = r2;
        if (r2 == null) goto L20;
        ih0.c.a.a(r2, null, null, 7);
        View r4 = ((com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r2).h;
        if (r4 == null) goto L21;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-1, -1);
        r5.gravity = 17;
        r4.setLayoutParams(r5);
        View r6 = this.g;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((FrameLayout) r6.findViewById(2131386007)).addView(r4);
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r2 = null;
        goto L10
    L18:
        ALogger.e("SettingLynxContainerSubFragment", "sub handleFragmentLynx urlFromInit is empty");
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment
    public final void ba0() {
        ALogger.e("SettingLynxContainerSubFragment", "onReleaseFragmentRes call");
        ih0.c r0 = this.s;
        if (r0 == null) goto L5;
        r0.J();
    L5:
        ih0.c r1 = this.s;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.s = null;
    }

    private SettingLynxContainerSubFragment() {
    }

    public /* synthetic */ SettingLynxContainerSubFragment(int r1) {
        this();
    }
}
