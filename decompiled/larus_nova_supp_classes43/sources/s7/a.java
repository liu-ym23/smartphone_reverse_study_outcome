package s7;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.util.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public final com.bytedance.android.annie.param.a a;
    public int b;

    /* JADX INFO: renamed from: s7.a$a, reason: collision with other inner class name */
    public static final class C0195a {
    }

    static {
    }

    public a(com.bytedance.android.annie.param.a r1) {
        this.a = r1;
        this.b = -1;
    }

    @Override // s7.c
    public final void c(Resources r10) {
        Intrinsics.checkNotNullParameter(r10, "resources");
        this.b = r10.getConfiguration().screenWidthDp;
        com.bytedance.android.annie.param.a r0 = this.a;
        if (r0 == null) goto L8;
        x8.b r1 = r0.d;
        if (r1 == null) goto L9;
        r1.e("AdaptMultiWindowHelper", "initScreenSizeAndOrientation, screenWidthDp:" + this.b + ", screenHeightDp:" + r10.getConfiguration().screenHeightDp);
        return;
    L9:
        return;
    }

    @Override // s7.c
    public final void a(Configuration r10, PopupHybridParamVoNew r11) {
        Intrinsics.checkNotNullParameter(r11, "popupHybridParamVoNew");
        Intrinsics.checkNotNull(r10);
        if (r10.screenWidthDp == this.b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        Intrinsics.checkNotNull(r10);
        float r12 = (r10.screenWidthDp * 1.0f) / this.b;
        int r1 = (int) (r11.getWidth() * r12);
        com.bytedance.android.annie.param.a r13 = this.a;
        if (r13 == null) goto L12;
        x8.b r14 = r13.d;
        if (r14 == null) goto L12;
        r14.e("AdaptMultiWindowHelper", "adaptDialogSize, oldWidthDp: " + r11.getWidth() + ", newWidthDp:" + r1 + ", ratio:" + r12);
    L12:
        com.bytedance.android.annie.scheme.helper.a.d(r11, "width", Integer.valueOf(r1));
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // s7.c
    public final void b(Configuration r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r11, "annieCard");
        Intrinsics.checkNotNull(r10);
        if (r10.screenWidthDp == this.b) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if ((r11.getMCurrentHybridComponent() instanceof BaseHybridComponent) == false) goto L12;
        p r1 = p.a;
        Intrinsics.checkNotNull(r10);
        int r12 = r1.a(r10.screenWidthDp * 1.0f);
        int r13 = r1.a(r10.screenHeightDp * 1.0f);
        IHybridComponent r14 = r11.getMCurrentHybridComponent();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.android.annie.card.base.BaseHybridComponent");
        ((BaseHybridComponent) r14).updateScreenMetrics(r12, r13);
        r11.requestLayout();
        r11.getMAnnieContext().d.e("AdaptMultiWindowHelper", "adaptLynxScreenSize, newScreenWidthDp:" + r10.screenWidthDp + ", newScreenHeightPx:" + r10.screenHeightDp);
        this.b = r10.screenWidthDp;
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
