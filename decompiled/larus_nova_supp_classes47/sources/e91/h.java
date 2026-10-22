package e91;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends a<AnchorTabLabel> {
    public final ImageView c;

    @Override // e91.a
    public final void c() {
        super.c();
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L15;
        ImageView r1 = this.c;
        if (r1 == null) goto L16;
        ViewParent r2 = null;
        r1.setImageBitmap(null);
        ViewParent r3 = r1.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L10;
        r2 = r3;
    L10:
        ViewGroup r4 = (ViewGroup) r2;
        if (r4 == null) goto L13;
        r4.removeView(r1);
    L13:
        r0.addView(r1);
        return;
    L16:
        return;
    }

    public h(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(r2);
        ViewGroup r3 = r2.d.k;
        if (r3 == null) goto L5;
        ImageView r0 = new ImageView(r3.getContext());
    L6:
        this.c = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r6) {
        Intrinsics.checkNotNullParameter(r6, "tabLabel");
        k r7 = r6.getLabel();
        if (this.a == true) goto L20;
        if (r7 == null) goto L23;
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L21;
        this.a = true;
        ImageView r1 = this.c;
        if (r1 == null) goto L22;
        int r2 = r7.getWidth();
        if (r2 > 0) goto L14;
        r2 = 64;
    L14:
        int r3 = (int) UtilityKotlinExtentionsKt.h(r2);
        int r4 = r7.getHeight();
        if (r4 > 0) goto L18;
        r4 = 12;
    L18:
        r1.setLayoutParams(new FrameLayout.LayoutParams(r3, (int) UtilityKotlinExtentionsKt.h(r4)));
        r0.setVisibility(0);
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r7, new g(this, r7));
        return;
    L22:
        return;
    L21:
        return;
    L23:
        return;
    }
}
