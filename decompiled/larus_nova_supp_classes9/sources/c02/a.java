package c02;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e;
import com.bytedance.android.livesdk.gift.platform.business.dialog.topview.g;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.widget.GiftPanelWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.live.datacontext.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e {
    public final /* synthetic */ GiftPanelWidget.a a;
    public final /* synthetic */ GiftPanelWidget b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final boolean isAdded() {
        if (this.a.b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final void remove() {
        g r0 = this.a.b;
        if (r0 != null) goto L5;
        return;
    L5:
        FrameLayout r1 = this.b.d;
        if (r1 == null) goto L8;
        r1.removeView(r0.a);
    L8:
        this.a.b = null;
        d r2 = r0.c;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        GiftContext r3 = b.b();
        if (r3 == null) goto L17;
        k<Boolean> r4 = r3.getGiftBannerShowEvent();
        if (r4 == null) goto L18;
        r4.post(Boolean.FALSE);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.e
    public final void a(g r5) {
        Intrinsics.checkNotNullParameter(r5, "topView");
        FrameLayout r0 = this.b.d;
        if (isAdded() == true) goto L24;
        if (r0 == null) goto L27;
        View r1 = r5.a;
        if ((!Intrinsics.areEqual(r1.getParent(), r0)) == false) goto L15;
        ViewParent r2 = r1.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L11;
        r2 = null;
    L11:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L14;
        r3.removeView(r1);
    L14:
        r0.addView(r1, r5.b);
    L15:
        this.a.b = r5;
        d r6 = r5.c;
        if (r6 == null) goto L18;
        r6.b();
    L18:
        GiftContext r7 = b.b();
        if (r7 == null) goto L25;
        k<Boolean> r8 = r7.getGiftBannerShowEvent();
        if (r8 == null) goto L26;
        r8.post(Boolean.TRUE);
        return;
    L26:
        return;
    L25:
        return;
    L27:
        return;
    }

    public a(GiftPanelWidget.a r1, GiftPanelWidget r2) {
        this.a = r1;
        this.b = r2;
    }
}
