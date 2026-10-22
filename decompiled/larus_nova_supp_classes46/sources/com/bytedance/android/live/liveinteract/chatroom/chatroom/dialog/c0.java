package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ c0 a;

        public a(c0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            View r2 = this.a.a.getView();
            if (r2 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r2);
        L5:
            BannerWidget r3 = this.a.a.q;
            if (r3 == null) goto L9;
            r3.yq();
            return;
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ c0 a;

        public b(c0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            View r2 = this.a.a.getView();
            if (r2 == null) goto L5;
            UtilityKotlinExtentionsKt.w(r2);
        L5:
            BannerWidget r3 = this.a.a.q;
            if (r3 == null) goto L9;
            r3.yq();
            return;
        }
    }

    public c0(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        View r11 = this.a.getView();
        if (r11 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r11);
    L5:
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 9) goto L16;
        LiveDialogFragment r12 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog("LinkResultDialog", null, true);
        if (r12 == null) goto L10;
        r12.setOnDismissListener(new a(this));
    L10:
        if (r12 == null) goto L28;
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        Intrinsics.checkNotNull(r1);
        FragmentManager r2 = r1.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "KtvFeedbackDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r12, r3) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
    L15:
        r12.show(r2, "KtvFeedbackDialog");
        return;
    L30:
        return;
    L28:
        return;
    L16:
        int r13 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r14 = TalkRoomFeedbackDialog.a.a(r0, false, "LinkResultDialog", null, true, null, null, null, 952);
        r14.setOnDismissListener(new b(this));
        FragmentActivity r4 = ContextUtil.contextToFragmentActivity(this.a.getContext());
        Intrinsics.checkNotNull(r4);
        FragmentManager r5 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "TalkRoomFeedbackDialog", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r14, r6) == true) goto L31;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L20:
        r14.show(r5, "TalkRoomFeedbackDialog");
        return;
    }
}
