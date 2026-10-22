package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public e(h r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        TextView r5 = this.a.G;
        int r0 = 8;
        if (r5 == null) goto L5;
        r5.setVisibility(8);
    L5:
        TextView r6 = this.a.G;
        if (r6 == null) goto L8;
        r6.setText("");
    L8:
        MultiLinkMicSeatGiftIconElement r7 = this.a.m;
        if (r7 == null) goto L13;
        LinkMicQuickInteractView r8 = r7.c;
        if (r8 == null) goto L13;
        r8.setAlpha(1.0f);
    L13:
        MultiLinkGuestViewBinder.a r9 = this.a.e;
        if (r9 == null) goto L20;
        ch0.e r10 = r9.k;
        if (r10 == null) goto L20;
        ILinkPlayerInfoBridge r11 = r10.a;
        if (r11 == null) goto L20;
        boolean r12 = r11.isOpenSendGift();
    L21:
        if (r12 == false) goto L38;
        h r1 = this.a;
        MultiLinkMicSeatGiftIconElement r2 = r1.m;
        if (r2 == null) goto L30;
        LinkMicQuickInteractView r3 = r2.c;
        if (r3 == null) goto L30;
        if (r12 == false) goto L28;
        r0 = 0;
    L28:
        r3.setVisibility(r0);
    L30:
        if (GuestBattleContext.Companion.e() == false) goto L32;
    L33:
        MultiLinkMicSeatGiftIconElement r13 = r1.m;
        if (r13 == null) goto L38;
        LinkMicQuickInteractView r14 = r13.c;
        if (r14 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r14);
        goto L38
    L32:
        if (ThemedCompetitionContext.Companion.g() == true) goto L33;
    L38:
        xs2.b.a().post(new dh0.a());
        return;
    L20:
        r12 = true;
        goto L21
    }
}
