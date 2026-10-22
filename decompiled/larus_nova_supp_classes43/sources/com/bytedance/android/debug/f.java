package com.bytedance.android.debug;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {
    public final /* synthetic */ DebugGiftPreviewDebugWidget a;

    public f(DebugGiftPreviewDebugWidget r1) {
        this.a = r1;
    }

    public final void a(long r1) {
        ToastUtil.b("特效资源下载任务被取消", 0);
    }

    public final void onFailed(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "t");
        ToastUtil.b("获取特效资源本地路径失败", 0);
    }

    public final void c(long r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "path");
        DebugGiftPreviewDebugWidget r12 = this.a;
        FrameLayout r13 = r12.i;
        if (r13 == null) goto L37;
        l r0 = r12.j;
        if (r0 == null) goto L38;
        LifecycleOwner r14 = ((Widget) r12).context;
        boolean r1 = AssetsUtils.b;
        Intrinsics.checkNotNullParameter(r11, "filePath");
        View r15 = null;
        if (StringsKt.endsWith$default(r11, '/', false, 2, null) == false) goto L9;
        r11 = r11.substring(0, r11.length() - 1);
    L9:
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r13, "videoContainer");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        r0.a = r13;
        Intrinsics.checkNotNullParameter(r14, "context");
        if (r0.b == null) goto L12;
    L31:
        ITextureViewPlayerController r16 = r0.b;
        if (r16 == null) goto L39;
        View r17 = r16.getAlphaView();
        if (r17 == null) goto L40;
        r17.postDelayed(new m(r0, r11), 1000);
        return;
    L40:
        return;
    L39:
        return;
    L12:
        if ((r14 instanceof FragmentActivity) == false) goto L31;
        ITextureViewPlayerController r18 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).giftPlayControllerManager().createTextureViewPlayer(r14);
        r0.b = r18;
        if (r18 == null) goto L16;
        r18.setPlayerActionListener(r0.c);
    L16:
        ITextureViewPlayerController r19 = r0.b;
        if (r19 == null) goto L26;
        View r20 = r19.getAlphaView();
        if (r20 == null) goto L26;
        ViewParent r21 = r20.getParent();
        if (r21 == null) goto L26;
        ViewGroup r22 = (ViewGroup) r21;
        ITextureViewPlayerController r23 = r0.b;
        if (r23 == null) goto L25;
        r15 = r23.getAlphaView();
    L25:
        r22.removeView(r15);
    L26:
        FrameLayout r24 = r0.a;
        if (r24 == null) goto L31;
        ITextureViewPlayerController r25 = r0.b;
        if (r25 == null) goto L31;
        r25.attachAlphaView(r24);
        goto L31
    L38:
        return;
    }
}
