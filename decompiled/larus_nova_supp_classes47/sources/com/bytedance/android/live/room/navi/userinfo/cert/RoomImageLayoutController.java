package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RoomImageLayoutController extends d<k> {
    public boolean a;
    public final Lazy b;
    public final a c;

    public interface a {
        void a();

        void b(Bitmap r1, ImageView r2, k r3);

        ViewGroup getContainer();

        void onShow();

        void onUnload();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        this.a = false;
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.setVisibility(8);
    L5:
        this.c.onUnload();
    }

    public final ImageView c() {
        return (ImageView) this.b.getValue();
    }

    public final void d() {
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L13;
        this.c.a();
        r0.setVisibility(8);
        ViewParent r2 = null;
        c().setImageBitmap(null);
        ViewParent r1 = c().getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        r2 = r1;
    L8:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L11;
        r3.removeView(c());
    L11:
        r0.addView(c());
        this.a = false;
        return;
    }

    public RoomImageLayoutController(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.c = r2;
        this.b = LazyKt.lazy(new RoomImageLayoutController$certImg$2(this));
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final /* bridge */ /* synthetic */ void a(AnchorTabLabel r1) {
        e((k) r1);
    }

    public final void e(k r6) {
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        if (this.a == false) goto L5;
        return;
    L5:
        ViewGroup r0 = this.c.getContainer();
        if (r0 == null) goto L17;
        this.a = true;
        ImageView r1 = c();
        int r2 = r6.getWidth();
        if (r2 > 0) goto L11;
        r2 = 64;
    L11:
        int r3 = (int) UtilityKotlinExtentionsKt.h(r2);
        int r4 = r6.getHeight();
        if (r4 > 0) goto L15;
        r4 = 12;
    L15:
        r1.setLayoutParams(new FrameLayout.LayoutParams(r3, (int) UtilityKotlinExtentionsKt.h(r4)));
        r0.setVisibility(0);
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r6, new c(this, r6));
        return;
    }
}
