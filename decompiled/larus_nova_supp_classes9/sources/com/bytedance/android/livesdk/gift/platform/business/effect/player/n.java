package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n {
    public FrameLayout a;
    public ITextureViewPlayerController b;
    public IPlayerActionListener c;
    public IResultMonitor d;

    public n() {
    }

    public final void a() {
        ITextureViewPlayerController r0 = this.b;
        if (r0 == null) goto L5;
        r0.removePlayerActionListener();
    L5:
        ITextureViewPlayerController r1 = this.b;
        if (r1 == null) goto L8;
        r1.removeMonitor();
    L8:
        FrameLayout r2 = this.a;
        if (r2 == null) goto L13;
        ITextureViewPlayerController r3 = this.b;
        if (r3 == null) goto L13;
        r3.detachAlphaView(r2);
    L13:
        ITextureViewPlayerController r4 = this.b;
        if (r4 == null) goto L16;
        r4.release();
    L16:
        this.a = null;
        this.b = null;
    }

    public final void b(Context r13, FrameLayout r14, String r15, boolean r16, BaseVideoGiftWidget.e r17, BaseVideoGiftWidget.f r18) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r15, "filePath");
        if (r14 != null) goto L5;
        return;
    L5:
        ITextureViewPlayerController r3 = this.b;
        View r6 = null;
        if (r3 == null) goto L11;
        r3.release();
        IPlayerActionListener r4 = this.c;
        if (r4 == null) goto L10;
        r4.onEnd();
    L10:
        this.b = null;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxVideoController", "playerController is not null and release");
    L11:
        this.a = r14;
        this.c = r17;
        this.d = r18;
        if (this.b == null) goto L14;
    L20:
        ITextureViewPlayerController r1 = this.b;
        if (r1 == null) goto L30;
        View r2 = r1.getAlphaView();
        if (r2 == null) goto L30;
        ViewParent r5 = r2.getParent();
        if (r5 == null) goto L30;
        ViewGroup r7 = (ViewGroup) r5;
        ITextureViewPlayerController r8 = this.b;
        if (r8 == null) goto L29;
        r6 = r8.getAlphaView();
    L29:
        r7.removeView(r6);
    L30:
        IPlayerActionListener r9 = this.c;
        if (r9 == null) goto L35;
        ITextureViewPlayerController r10 = this.b;
        if (r10 == null) goto L35;
        r10.setPlayerActionListener(r9);
    L35:
        IResultMonitor r11 = this.d;
        if (r11 == null) goto L40;
        ITextureViewPlayerController r19 = this.b;
        if (r19 == null) goto L40;
        r19.setMonitor(r11);
    L40:
        FrameLayout r20 = this.a;
        if (r20 == null) goto L46;
        ITextureViewPlayerController r21 = this.b;
        if (r21 == null) goto L46;
        r21.attachAlphaView(r20);
    L46:
        if (this.b != null) goto L48;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("LynxVideoController", "playerController is null");
    L48:
        ITextureViewPlayerController r23 = this.b;
        if (r23 == null) goto L52;
        ITextureViewPlayerController.DefaultImpls.start$default(r23, r15, false, r16, false, null, 24, null);
        return;
    L52:
        return;
    L14:
        if ((r13 instanceof FragmentActivity) == false) goto L20;
        ILiveGiftPlayControllerManager r24 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).giftPlayControllerManager();
        if (r24 == null) goto L18;
        ITextureViewPlayerController r25 = r24.createTextureViewPlayer((LifecycleOwner) r13);
    L19:
        this.b = r25;
        goto L20
    L18:
        r25 = null;
        goto L19
    }
}
