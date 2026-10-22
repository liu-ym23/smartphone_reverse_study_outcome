package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends tk6.e<q72.c, View> {
    public final ImageView e;
    public float f;
    public final BarrageWidgetContext g;

    public i(View r4, BarrageWidgetContext r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.g = r5;
        this.e = (ImageView) r4.findViewById(2131363969);
        this.f = 1.0f;
    }

    public final void b(Object r6, RenderEntity r7) {
        q72.c r8 = (q72.c) r6;
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r7, "entity");
        if (this.g == null) goto L58;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);     // Catch: Exception -> L51
        com.bytedance.android.livesdk.interactivity.api.barrage.data.i r1 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r0, null, 0, 3);     // Catch: Exception -> L51
    L9:
        int r3 = a1.a;     // Catch: Exception -> L51
        if (a1.a.a().d() == false) goto L25;
        if (r2 == null) goto L13;
        Boolean r4 = r2.isVSRoom();     // Catch: Exception -> L51
    L15:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L25;
        if (Intrinsics.areEqual(r2.isPortraitInteraction(), Boolean.FALSE) == false) goto L25;
        pk6.a r5 = r7.e(pk6.a.class);     // Catch: Exception -> L51
        if (r5 == null) goto L25;
        BarrageSetting r9 = (BarrageSetting) l42.a.d.getValue();     // Catch: Exception -> L51
        if (r9 == null) goto L23;
        float r10 = r9.getAlpha();     // Catch: Exception -> L51
    L24:
        r5.a = (int) (r5.a * (r10 / 100.0f));     // Catch: Exception -> L51
        goto L25
    L23:
        r10 = 75;
        goto L24
    L13:
        r4 = null;
    L25:
        this.e.setImageDrawable(null);     // Catch: Exception -> L51
        int r11 = r8.j;     // Catch: Exception -> L51
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r13 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) this.g.getChatCarnivalMessage().getValue();     // Catch: Exception -> L51
        if (r13 == null) goto L28;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r14 = r13.r();     // Catch: Exception -> L51
    L29:
        if (r14 == null) goto L31;
        int r15 = r14.size();     // Catch: Exception -> L51
    L32:
        if (r11 >= r15) goto L55;
        if (r11 < 0) goto L56;
        this.f = ((Number) this.g.getScaleRate().getValue()).floatValue();     // Catch: Exception -> L51
        tc2.f r16 = (tc2.f) r7.e(tc2.f.class);     // Catch: Exception -> L51
        if (r16 == null) goto L40;
        Float r17 = r16.a;     // Catch: Exception -> L51
        if (r17 == null) goto L40;
        float r18 = r17.floatValue();     // Catch: Exception -> L51
    L41:
        this.f *= r18;     // Catch: Exception -> L51
        Bitmap r19 = r8.f;     // Catch: Exception -> L51
        if (r19 == null) goto L57;
        this.e.setImageDrawable(new BitmapDrawable(r19));     // Catch: Exception -> L51
        ViewGroup.LayoutParams r20 = this.e.getLayoutParams();     // Catch: Exception -> L51
        if (r14 == null) goto L46;
        r1 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.i) ListProtector.get(r14, r11);     // Catch: Exception -> L51
    L46:
        if (r1 == null) goto L48;
        float r21 = r1.b();     // Catch: Exception -> L51
    L49:
        r20.height = (int) (this.f * s1.f(r21));     // Catch: Exception -> L51
        this.e.setLayoutParams(r20);     // Catch: Exception -> L51
        return;
    L48:
        r21 = 0.0f;
        goto L49
    L57:
        return;
    L40:
        r18 = 1.0f;
        goto L41
    L56:
        return;
    L55:
        return;
    L31:
        r15 = 0;
        goto L32
    L28:
        r14 = null;
        goto L29
    L8:
        r2 = null;
    L51:
        ALogger.e("CARNIVAL_MESSAGE", "bind danmaku egg error");
        return;
    }
}
