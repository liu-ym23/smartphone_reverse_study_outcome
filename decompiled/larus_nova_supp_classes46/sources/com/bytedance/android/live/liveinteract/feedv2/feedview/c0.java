package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleUIWidget;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;
    public final /* synthetic */ q2 b;

    public c0(MultiLinkCommonVoiceFeedPreview r1, q2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.b.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L5;
        int r0 = LinkmicSubtitleUIWidget.w;
    L6:
        MultiLinkCommonVoiceFeedPreview r1 = this.a;
        if (r1.Q == r0) goto L23;
        r1.Q = r0;
        ViewGroup.LayoutParams r2 = MultiLinkCommonVoiceFeedPreview.z(r1).getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == true) goto L11;
        r2 = null;
    L11:
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
        if (r3 == null) goto L15;
        MultiLinkCommonVoiceFeedPreview r4 = this.a;
        ((ViewGroup.MarginLayoutParams) r3).width = r4.Q;
        MultiLinkCommonVoiceFeedPreview.z(r4).setLayoutParams(r3);
    L15:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L23;
        HybridCard r5 = this.a.P;
        if (r5 == null) goto L23;
        r5.release();
        this.a.t(2131378052).removeView(this.a.P);
        MultiLinkCommonVoiceFeedPreview r6 = this.a;
        int r7 = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.a;
        r6.P = com.bytedance.android.live.liveinteract.voicechat.subtitle.g0.f(r6.getContext(), this.a.Q);
        HybridCard r8 = this.a.P;
        if (r8 == null) goto L23;
        r8.setLayoutParams(new ConstraintLayout.LayoutParams(this.a.Q, LinkmicSubtitleUIWidget.u));
        ConstraintLayout r9 = this.a.t(2131378052);
        if (r9 == null) goto L23;
        r9.addView(r8);
    L23:
        double r10 = this.b.getX() * ((double) s1.y());
        double r11 = this.b.getY() * ((double) MultiLinkCommonVoiceFeedPreview.y(this.a));
        Pair r12 = MultiLinkCommonVoiceFeedPreview.v(this.a, (float) r10, (float) r11);
        ConstraintLayout r13 = MultiLinkCommonVoiceFeedPreview.z(this.a);
        r13.setTranslationX(((Number) r12.getFirst()).floatValue());
        r13.setTranslationY(((Number) r12.getSecond()).floatValue());
        return;
    L5:
        r0 = LinkmicSubtitleUIWidget.x;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
