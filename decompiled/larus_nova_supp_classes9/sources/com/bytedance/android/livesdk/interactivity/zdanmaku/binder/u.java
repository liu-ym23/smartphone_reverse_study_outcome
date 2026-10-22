package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.render.canvas.template.SnapType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends tk6.e<q22.a, View> {
    public final View e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    public final View i;
    public final TextView j;
    public final View k;
    public final TextView l;
    public final TextView m;
    public final h80.d<p22.g> n;

    public u(View r4, h80.d<p22.g> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "giftDanmakuSettingConfigSupplier");
        super(r4, DanmakuCacheProviders.a, SnapType.Bitmap, 8);
        this.n = r5;
        this.e = r4.findViewById(2131373679);
        this.f = (ImageView) r4.findViewById(2131376273);
        this.g = (TextView) r4.findViewById(2131390698);
        this.h = (TextView) r4.findViewById(2131390695);
        this.i = r4.findViewById(2131373715);
        this.j = (TextView) r4.findViewById(2131390699);
        this.k = r4.findViewById(2131373667);
        this.l = (TextView) r4.findViewById(2131390696);
        this.m = (TextView) r4.findViewById(2131390700);
    }

    public final void b(Object r7, RenderEntity r8) {
        q22.a r9 = (q22.a) r7;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r8, "entity");
        p22.g r10 = (p22.g) this.n.get();
        this.e.setBackgroundResource(r9.h);
        this.g.setText(r9.g);
        this.h.setText(r9.j.toString() + " ");
        if (r9.i > 1) goto L5;
        UIUtils.setViewVisibility(this.i, 8);
    L6:
        a1.k(this.i, r10.d.g);
        a1.k(this.f, r10.d.b);
        a1.p(this.f, r10.d.b);
        this.e.setPadding(r10.d.b, -3, -3, -3);
        a1.k(this.e, r10.d.c);
        this.g.setTextSize(0, r10.d.d);
        this.l.setTextSize(0, r10.d.e);
        this.h.setTextSize(0, r10.d.f);
        this.m.setTextSize(0, r10.d.h);
        this.j.setTextSize(0, r10.d.h);
        BarrageSettingFont r11 = r10.b;
        if (r11 == null) goto L15;
        int r13 = t.a[r11.ordinal()];
        if (r13 != 1) goto L12;
        int r14 = s1.f(15.0f);
    L19:
        a1.m(this.i, r14);
        Bitmap r15 = r9.a;
        if (r15 != null) goto L22;
    L24:
        this.f.setImageDrawable(null);
        return;
    L22:
        if (r15.isRecycled() == true) goto L24;
        this.f.setImageBitmap(r15);
        return;
    L12:
        if (r13 != 2) goto L14;
        r14 = s1.f(12.0f);
        goto L19
    L14:
        if (r13 != 3) goto L15;
        r14 = s1.f(9.0f);
    L15:
        r14 = s1.f(9.0f);
        goto L19
    L5:
        UIUtils.setViewVisibility(this.i, 0);
        this.j.setText(String.valueOf(r9.i));
        goto L6
    }
}
