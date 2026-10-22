package b41;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevenueLayoutClient;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final RevenueLayoutClient a;
    public final rx0.b b;
    public IRoom c;
    public RevSeiFrame d;
    public RectF e;
    public RectF f;
    public Matrix g;
    public Pair<Integer, Integer> h;
    public com.bytedance.android.live.revenue.common.player.vendor.link.a i;
    public float j;
    public RectF k;
    public final c41.a l;
    public final boolean m;

    public static void b(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        if (a(r4.getLayoutParams(), r1) == true) goto L13;
        r4.setLayoutParams(r1);
    L13:
        if ((r0 instanceof RelativeLayout.LayoutParams) == false) goto L18;
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, -1);
        if (a(r4.getLayoutParams(), r2) == true) goto L19;
        r4.setLayoutParams(r2);
        return;
    L19:
        return;
    }

    public d(c41.a r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.l = r3;
        this.m = r4;
        RevenueLayoutClient r5 = new RevenueLayoutClient();
        this.a = r5;
        rx0.b r0 = new rx0.b();
        Intrinsics.checkNotNullParameter(r5, "client");
        r0.a = r5;
        Unit r6 = Unit.INSTANCE;
        this.b = r0;
        this.j = 1.0f;
        if ((!r4) == false) goto L8;
        RectF r7 = this.k;
        if (r7 != null) goto L7;
        com.bytedance.android.live.revenue.common.player.vendor.link.a r8 = null;
    L9:
        this.i = r8;
        return;
    L7:
        r8 = new com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a(r7);
        goto L9
    L8:
        r8 = com.bytedance.android.live.revenue.common.player.vendor.link.a.b.a;
        goto L9
    }

    public static boolean a(ViewGroup.LayoutParams r6, ViewGroup.LayoutParams r7) {
        if (r6 != null) goto L5;
        return false;
    L5:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r6;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r7;
        if (r1.width == r3.width) goto L9;
    L19:
        boolean r2 = false;
    L20:
        if (r2 == true) goto L23;
        return false;
    L9:
        if (r1.height != r3.height) goto L19;
        if (r1.leftMargin != r3.leftMargin) goto L19;
        if (r1.rightMargin != r3.rightMargin) goto L19;
        if (r1.topMargin != r3.topMargin) goto L19;
        if (r1.bottomMargin != r3.bottomMargin) goto L19;
        r2 = true;
    L23:
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L31;
        if ((r7 instanceof FrameLayout.LayoutParams) == false) goto L31;
        if (((FrameLayout.LayoutParams) r6).gravity != ((FrameLayout.LayoutParams) r7).gravity) goto L38;
        return true;
    L38:
        return false;
    L31:
        if ((r6 instanceof RelativeLayout.LayoutParams) == true) goto L33;
        return false;
    L33:
        if ((r7 instanceof RelativeLayout.LayoutParams) == true) goto L35;
        return false;
    L35:
        if (((RelativeLayout.LayoutParams) r6).alignWithParent != ((RelativeLayout.LayoutParams) r7).alignWithParent) goto L42;
        return true;
    L42:
        return false;
    }
}
