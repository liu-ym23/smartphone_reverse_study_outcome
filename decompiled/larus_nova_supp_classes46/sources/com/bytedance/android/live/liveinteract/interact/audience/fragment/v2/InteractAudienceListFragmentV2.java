package com.bytedance.android.live.liveinteract.interact.audience.fragment.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/InteractAudienceListFragmentV2;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "Lcom/bytedance/android/live/liveinteract/interact/audience/fragment/v2/h;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractAudienceListFragmentV2 extends VideoTalkDialogContract$View implements h {
    public static final /* synthetic */ int n = 0;
    public View g;
    public DouyinLoadingLayout h;
    public NestedScrollView i;
    public InteractAudienceApplyListFragmentV2 j;
    public InteractAudienceInviteListFragmentV2 k;
    public DataCenter l;
    public int m;

    public static final class a {
        @JvmStatic
        public static InteractAudienceListFragmentV2 a(yf0.g r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            InteractAudienceListFragmentV2 r0 = new InteractAudienceListFragmentV2();
            r0.d = r2;
            r0.l = r3;
            if (r3 == null) goto L7;
            Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
            if (r4 == null) goto L7;
            r4.booleanValue();
        L7:
            return r0;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.h
    public final void Wo() {
        DouyinLoadingLayout r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L5:
        r0.setVisibility(8);
    }

    public final void aa0() {
        ALogger.i("InteractAudienceListFragmentV2", "interact audience loadListFragment");
        Fragment r0 = this.j;
        if (r0 != null) goto L5;
        int r1 = InteractAudienceApplyListFragmentV2.N;
        yf0.g r2 = this.d;
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(this, "dataLoadCallback");
        Fragment r4 = new InteractAudienceApplyListFragmentV2();
        r4.d = r2;
        r4.j = this;
        r4.C = true;
        this.j = r4;
        r0 = r4;
    L5:
        Fragment r5 = this.k;
        if (r5 != null) goto L8;
        int r6 = InteractAudienceInviteListFragmentV2.v;
        yf0.g r7 = this.d;
        DataCenter r8 = this.l;
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(this, "dataLoadCallback");
        Fragment r3 = new InteractAudienceInviteListFragmentV2();
        r3.d = r7;
        r3.t = r8;
        r3.q = this;
        r3.o = true;
        this.k = r3;
        r5 = r3;
    L8:
        FragmentTransaction r9 = getChildFragmentManager().beginTransaction();
        if (r0.isAdded() == true) goto L15;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "apply_list", 2131375502) == true) goto L15;
        r9.add(2131375502, r0, "apply_list");
    L15:
        if (r5.isAdded() == false) goto L17;
    L20:
        r9.commitAllowingStateLoss();
        return;
    L17:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "invite_list", 2131375517) == true) goto L20;
        r9.add(2131375517, r5, "invite_list");
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.h
    public final void zs() {
        int r0 = this.m + 1;
        this.m = r0;
        if (r0 < 2) goto L9;
        DouyinLoadingLayout r1 = this.h;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L7:
        r1.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return s1.B(2131919433);
    }

    public InteractAudienceListFragmentV2() {
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        boolean r0 = false;
        View r5 = r2.inflate(2131565500, r3, false);
        this.g = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        DouyinLoadingLayout r6 = r5.findViewById(2131379091);
        this.h = r6;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L8:
        r6.setVisibility(0);
        View r7 = this.g;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        this.i = r7.findViewById(2131368538);
        com.bytedance.android.live.liveinteract.plantform.base.g r8 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r8 != null) goto L14;
    L16:
        if (r0 == false) goto L18;
        aa0();
    L18:
        View r9 = this.g;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L21:
        return r9;
    L14:
        if (r8.k0(2) != true) goto L16;
        r0 = true;
        goto L16
    }
}
