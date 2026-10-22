package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b extends com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a {
    public final TextView g;
    public final HSImageView h;
    public final HSImageView i;
    public ObjectAnimator j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.topview.b$b, reason: collision with other inner class name */
    public static final class C0017b extends BaseControllerListener<Object> {
        public final /* synthetic */ b a;
        public final /* synthetic */ k b;

        public C0017b(b r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "throwable");
            this.a.i(this.b, 1);
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            this.a.i(this.b, 0);
        }
    }

    static {
    }

    public void i(k r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "imageModel");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public final void a() {
        this.f.put("data_is_blind_box_banner_present", Boolean.FALSE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public final void b() {
        this.f.put("data_is_blind_box_banner_present", Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public final void c() {
        this.g.setText(BuildConfig.FLAVOR);
        this.h.setController(null);
        this.i.setController(null);
        ObjectAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.j = null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public void d() {
        e0 r0 = this.d;
        if (r0 == null) goto L5;
        String r1 = r0.uri;
    L6:
        if (r1 == null) goto L14;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(this.a.getContext(), r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        jy0.b.b("GiftBannerView", "failed to open uri ".concat(r1), th);
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void g(e0 r6) {
        this.d = r6;
        if (r6 == null) goto L5;
        k r1 = r6.backgroundImage;
    L6:
        if (r1 == null) goto L18;
        a5 r2 = r6.text;
        if (r2 == null) goto L10;
        this.g.setText(vh6.c.b(ur2.a.class).Lf(r2, null));
    L10:
        GradientDrawable r0 = new GradientDrawable();
        String r3 = r6.textBackgroundColor;
        if (r3 != null) goto L23;
    L16:
        int r4 = 0;
    L17:
        r0.setColor(r4);
        r0.setCornerRadius(com.bytedance.android.live.revenue.common.i.a(6));
        r0.setShape(0);
        this.g.setBackground(r0);
        h(this.h, r6.backgroundImage);
        h(this.i, r6.boxImage);
        return;
    L23:
        r4 = Color.parseColor(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        jy0.b.b("GiftBannerView", "error parsing color ".concat(r3), th);
        goto L16
    L18:
        this.g.setText(BuildConfig.FLAVOR);
        this.h.setController(null);
        this.i.setController(null);
        ObjectAnimator r7 = this.j;
        if (r7 == null) goto L21;
        r7.cancel();
    L21:
        this.j = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public b(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, 2131565271);
        ViewGroup r4 = this.a;
        this.h = r4.findViewById(2131376035);
        this.g = (TextView) r4.findViewById(2131391524);
        this.i = r4.findViewById(2131376057);
    }

    public final void h(HSImageView r3, k r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r3.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r4, -1)).setOldController(r3.getController()).setControllerListener(new C0017b(this, r4)).build());
    }
}
