package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ LinkResultDialogFragment a;

    public q(LinkResultDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 9) goto L18;
        LiveDialogFragment r11 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog("LinkResultDialog", null, true);
        if (r11 == null) goto L32;
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        Intrinsics.checkNotNull(r1);
        FragmentManager r2 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "KtvFeedbackDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r11, r3) == true) goto L34;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L17:
        r11.show(r2, "KtvFeedbackDialog");
        return;
    L34:
        return;
    L32:
        return;
    L18:
        int r12 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r13 = TalkRoomFeedbackDialog.a.a(r0, false, "LinkResultDialog", null, true, null, null, null, 952);
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        Intrinsics.checkNotNull(r4);
        FragmentManager r5 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "TalkRoomFeedbackDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r13, r6) == true) goto L35;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L22:
        r13.show(r5, "TalkRoomFeedbackDialog");
        return;
    L35:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L9;
        com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
