package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livehostapi.business.depend.share.IShareDirectTypeCallback;
import com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.LiveLinkShareToThirdDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v2 implements IShareDirectTypeCallback {
    public final /* synthetic */ View a;

    public v2(View r1) {
        this.a = r1;
    }

    public final void onShareLinkSuccess(String r3, ICommonLiveSharePackage r4) {
        Intrinsics.checkNotNullParameter(r3, "copyLinkStr");
        ALogger.i("ToolbarCopyLinkBehavior", "onShareLinkSuccess copyLinkStr:" + r3);
        View r0 = this.a;
        if (r0 == null) goto L6;
        Context r1 = r0.getContext();
        if (r1 == null) goto L6;
    L7:
        FragmentActivity r2 = ContextUtil.contextToFragmentActivity(r1);
        if (r2 == null) goto L20;
        FragmentManager r5 = r2.getSupportFragmentManager();
        if (r5 == null) goto L21;
        int r6 = LiveLinkShareToThirdDialogFragment.n;
        Intrinsics.checkNotNullParameter(r3, "copiedLink");
        LiveLinkShareToThirdDialogFragment r7 = new LiveLinkShareToThirdDialogFragment();
        r7.d = r4;
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "LiveLinkShareToThirdDialogFragment", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r7, r8) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r7.show(r5, "LiveLinkShareToThirdDialogFragment");
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r1 = com.bytedance.android.live.core.utils.a.d();
        goto L7
    }
}
