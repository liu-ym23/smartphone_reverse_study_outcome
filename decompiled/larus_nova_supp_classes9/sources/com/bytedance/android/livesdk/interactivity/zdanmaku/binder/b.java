package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.view.StrokeDanmakuTextView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends tk6.e<com.bytedance.android.livesdk.interactivity.zdanmaku.k, View> {
    public final StrokeDanmakuTextView e;
    public final ImageView f;
    public final LinearLayout g;
    public final int h;
    public final int i;
    public final h80.d<p22.a> j;

    public b(View r4, h80.d<p22.a> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "danmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.j = r5;
        this.e = (StrokeDanmakuTextView) r4.findViewById(2131362291);
        this.f = (ImageView) r4.findViewById(2131362292);
        this.g = (LinearLayout) r4.findViewById(2131362290);
        this.h = s1.h(2131107126);
        this.i = s1.h(2131106800);
    }

    public final void b(Object r7, RenderEntity r8) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.k r9 = (com.bytedance.android.livesdk.interactivity.zdanmaku.k) r7;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r8, "entity");
        p22.a r10 = (p22.a) this.j.get();
        IBaseUser r0 = r9.a.getUserInfo();
        if (r0 == null) goto L5;
        String r1 = r0.getIdString();
    L6:
        boolean r2 = true;
        if ((!Intrinsics.areEqual(r1, "0")) == false) goto L24;
        IBaseUser r3 = r9.a.getUserInfo();
        if (r3 == null) goto L24;
        String r4 = r3.getIdString();
        if (r4 == null) goto L24;
        if (r4.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 != true) goto L24;
        String r6 = jc1.k.n(IMiddlewareUserService.class).user().n();
        IBaseUser r11 = r9.a.getUserInfo();
        if (r11 == null) goto L20;
        String r13 = r11.getIdString();
    L22:
        if (Intrinsics.areEqual(r6, r13) == false) goto L24;
        boolean r14 = true;
    L26:
        if (r10.b == BarrageSettingFont.PORTRAIT) goto L29;
        r2 = false;
    L29:
        this.e.setTextSize(0, r10.d.a);
        this.e.setTypeface(Typeface.DEFAULT_BOLD);
        int r15 = x52.a.a;
        h4 r16 = r9.a;
        CharSequence r17 = x52.a.a(r16, r14, r16.isLocalInsertMsg(), this.e.getTextSize());
        if (r14 == false) goto L32;
        this.g.setBackground(s1.m(2131248716));
        this.f.setVisibility(8);
    L33:
        this.e.setText(r17);
        if (r2 == false) goto L36;
        StrokeDanmakuTextView r18 = this.e;
        int r19 = this.h;
        r18.b = 3.0f;
        r18.c = r19;
        r18.init();
        return;
    L36:
        StrokeDanmakuTextView r20 = this.e;
        int r21 = this.i;
        r20.b = 3.0f;
        r20.c = r21;
        r20.init();
        return;
    L32:
        this.f.setVisibility(0);
        this.g.setBackground(null);
        ViewGroup.LayoutParams r23 = this.f.getLayoutParams();
        p22.a.C0259a r24 = r10.d;
        r23.height = r24.b;
        r23.width = r24.c;
        this.f.setLayoutParams(r23);
        this.f.setImageDrawable(s1.m(2131248717));
        goto L33
    L20:
        r13 = null;
        goto L22
    L15:
        r5 = false;
    L24:
        r14 = false;
        goto L26
    L5:
        r1 = null;
        goto L6
    }
}
