package com.bytedance.android.livesdk.chatroom.ui;

import android.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l4 implements kf1.a {
    public final /* synthetic */ AbsInteractionFragment a;

    public final String tag() {
        return "AbsInteractionFragment_Reward";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public l4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r7, boolean r8) {
        AbsInteractionFragment r9 = this.a;
        if (r9.q != null) goto L5;
        return false;
    L5:
        Pair r10 = (Pair) com.bytedance.android.livesdk.jsbridge.methods.o0.a.get(r9.getActivity());
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((this.a.q.getId() + "").equals(r10.first) == true) goto L12;
        return false;
    L12:
        if ("reward".equals(r10.second) == true) goto L15;
        return false;
    L15:
        if (tb1.c.c == true) goto L17;
        return false;
    L17:
        DialogFragment r11 = jc1.k.f(IHostBusiness.class).showRewardDetainmentDialog(this.a.getActivity(), this.a.q.getId() + "", null, r7);
        if (r11 != null) goto L20;
        return false;
    L20:
        FragmentManager r12 = this.a.getFragmentManager();
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "RewardDetainment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r11, r0) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L24:
        r11.show(r12, "RewardDetainment");
        return true;
    L30:
        return true;
    }
}
