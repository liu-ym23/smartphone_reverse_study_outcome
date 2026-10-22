package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o extends tk6.e<q72.c, View> {
    public final ImageView e;
    public float f;
    public final BarrageWidgetContext g;

    public o(View r4, BarrageWidgetContext r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.g = r5;
        this.e = (ImageView) r4.findViewById(2131363969);
        this.f = 1.0f;
    }

    public final void b(Object r4, RenderEntity r5) {
        q72.c r6 = (q72.c) r4;
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r5, "entity");
        if (this.g == null) goto L37;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.c> r1 = null;
        this.e.setImageDrawable(null);     // Catch: Exception -> L30
        com.bytedance.android.livesdk.interactivity.api.barrage.data.c r0 = r6.g;     // Catch: Exception -> L30
        if (r0 != null) goto L20;
        int r2 = r6.j;     // Catch: Exception -> L30
        GeneralCarnivalDataSyncModel r3 = (GeneralCarnivalDataSyncModel) this.g.getGeneralCarnivalSyncModel().getValue();     // Catch: Exception -> L30
        if (r3 == null) goto L16;
        dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r7 = r3.getCarnivalMessage();     // Catch: Exception -> L30
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.k r8 = r7.c();     // Catch: Exception -> L30
        if (r8 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r9 = r8.a();     // Catch: Exception -> L30
        if (r9 == null) goto L16;
        r1 = r9.u();     // Catch: Exception -> L30
    L16:
        if (r1 == null) goto L34;
        r0 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.c) CollectionsKt.getOrNull(r1, r2);     // Catch: Exception -> L30
        if (r0 != null) goto L20;
        return;
    L34:
        return;
    L20:
        this.f = ((Number) this.g.getScaleRate().getValue()).floatValue();     // Catch: Exception -> L30
        tc2.f r10 = (tc2.f) r5.e(tc2.f.class);     // Catch: Exception -> L30
        if (r10 == null) goto L25;
        Float r11 = r10.a;     // Catch: Exception -> L30
        if (r11 == null) goto L25;
        float r13 = r11.floatValue();     // Catch: Exception -> L30
    L26:
        this.f *= r13;     // Catch: Exception -> L30
        Bitmap r14 = r6.f;     // Catch: Exception -> L30
        if (r14 == null) goto L36;
        this.e.setImageDrawable(new BitmapDrawable(r14));     // Catch: Exception -> L30
        ViewGroup.LayoutParams r15 = this.e.getLayoutParams();     // Catch: Exception -> L30
        r15.height = (int) (this.f * s1.f(r0.b()));     // Catch: Exception -> L30
        this.e.setLayoutParams(r15);     // Catch: Exception -> L30
        return;
    L36:
        return;
    L25:
        r13 = 1.0f;
    L30:
        ALogger.e("CARNIVAL_MESSAGE", "bind danmaku egg error");
        return;
    }
}
