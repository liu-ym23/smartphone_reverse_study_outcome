package com.bytedance.android.live.revlink.impl.behavior;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ ToolbarPkBehavior a;

    public w(ToolbarPkBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        b30.o r13 = (b30.o) r12;
        Intrinsics.checkNotNullParameter(r13, "openPkPanelEvent");
        View r0 = this.a.j;
        Intrinsics.checkNotNull(r0);
        if (r0.getVisibility() == 0) goto L10;
        int r1 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        if (TextUtils.equals(r13.a, "pve_activity_pve") == false) goto L8;
        int r14 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922642), 0);
        return;
    L8:
        if (gd0.v.a(r1, 32) == false) goto L22;
        int r15 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922650), 0);
        return;
    L22:
        return;
    L10:
        IRevBroadcastService r2 = com.bytedance.android.live.revenue.core.util.e.a(IRevBroadcastService.class);
        if (r2.shouldShowGuidePromptBubble(17) == false) goto L13;
        u r3 = new u(this);
        r2.markPopupShown(17);
        ToolbarPkBehavior r4 = this.a;
        r4.getClass();
        AnimatorSet r5 = new AnimatorSet();
        View r6 = r4.j;
        Intrinsics.checkNotNull(r6);
        View r7 = r4.j;
        Intrinsics.checkNotNull(r7);
        r5.playSequentially(new Animator[]{com.bytedance.android.live.revenue.common.e.c(r6, new float[]{0.1f}).setDuration(500), com.bytedance.android.live.revenue.common.e.c(r7, new float[]{1.0f}).setDuration(500)});
        r5.start();
        ((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.a.z))).subscribe(new v(this));
    L15:
        if (this.a.y == null) goto L24;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r8 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r8 == null) goto L19;
        String r16 = r13.a;
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r8.b = r16;
    L19:
        this.a.y.Ne(1, r3, false);
        return;
    L24:
        return;
    L13:
        r3 = null;
        goto L15
    }
}
