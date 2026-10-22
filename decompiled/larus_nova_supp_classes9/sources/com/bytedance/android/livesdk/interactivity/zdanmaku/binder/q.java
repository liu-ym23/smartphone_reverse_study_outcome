package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends tk6.e<q72.d, View> {
    public final ViewGroup e;
    public final BarrageWidgetContext f;

    public q(View r4, BarrageWidgetContext r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.f = r5;
        this.e = (ViewGroup) r4.findViewById(2131365237);
    }

    public final void b(Object r6, RenderEntity r7) {
        q72.d r8 = (q72.d) r6;
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r7, "entity");
        this.e.removeAllViews();
        CombinedTextRenderView r9 = r8.e;
        if (r9 == null) goto L21;
        BarrageWidgetContext r0 = this.f;
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m<Float> r1 = r0.getScaleRate();
        if (r1 == null) goto L12;
        Float r2 = (Float) r1.getValue();
        if (r2 == null) goto L12;
        float r3 = r2.floatValue();
    L13:
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, (int) (UtilityKotlinExtentionsKt.i(36) * r3));
        r4.gravity = 17;
        this.e.addView(r9, r4);
        ViewGroup.LayoutParams r10 = this.e.getLayoutParams();
        r10.height = (int) (UtilityKotlinExtentionsKt.i(36) * r3);
        this.e.setLayoutParams(r10);
        if (s1.getResources() == null) goto L16;
        Resources r11 = s1.getResources();
        float r13 = WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density;
    L16:
        Drawable r14 = r8.c;
        if (r14 == null) goto L20;
        this.e.setBackground(r14);
        return;
    L20:
        return;
    L12:
        r3 = 1.0f;
        goto L13
    }
}
