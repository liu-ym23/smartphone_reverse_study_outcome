package com.bytedance.android.livesdk.chatroom.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public ShortTermFrameLayout.a a;
    public final ViewGroup b;
    public final ViewGroup c;

    public final boolean b() {
        ViewGroup r0 = this.c;
        if (r0 == null) goto L5;
        int r1 = r0.getChildCount();
    L6:
        if (r1 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = 0;
        goto L6
    }

    public final void c() {
        ViewGroup r0 = this.c;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r0, b());
    L5:
        ShortTermFrameLayout.a r1 = this.a;
        if (r1 == null) goto L17;
        int r2 = this.b.getChildCount() + (b() ? 1 : 0);
        int[] r3 = {0, 0};
        if (((Boolean) LiveInfraSettingKeys.LIVE_DISABLE_ENHANCED_SHORT_TOUCH.getValue()).booleanValue() == false) goto L10;
        ViewGroup r4 = this.b;
    L15:
        r4.getLocationInWindow(r3);
        int r5 = UtilityKotlinExtentionsKt.k(r3[0]);
        int r6 = UtilityKotlinExtentionsKt.k(r3[1]);
        int r7 = UtilityKotlinExtentionsKt.k(r4.getWidth());
        r1.a(r2, new Rect(r5, r6, r7 + r5, UtilityKotlinExtentionsKt.k(r4.getHeight()) + r6));
        return;
    L10:
        ViewGroup r8 = UtilityKotlinExtentionsKt.p(this.b);
        if (r8 == null) goto L14;
        r4 = UtilityKotlinExtentionsKt.p(r8);
        if (r4 != null) goto L15;
    L14:
        r4 = this.b;
        goto L15
    }

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (Intrinsics.areEqual(r3.getTag(), Boolean.TRUE) == true) goto L5;
        this.b.addView(r3);
    L16:
        c();
        return;
    L5:
        if (b() == false) goto L12;
        ViewGroup r0 = this.c;
        if (r0 == null) goto L9;
        View r1 = r0.getChildAt(0);
    L11:
        if ((!Intrinsics.areEqual(r1, r3)) == false) goto L16;
    L9:
        r1 = null;
    L12:
        ViewGroup r2 = this.c;
        if (r2 == null) goto L16;
        r2.removeAllViews();
        UtilityKotlinExtentionsKt.q(r3);
        r2.addView(r3);
        goto L16
    }

    public final void d(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (Intrinsics.areEqual(r3.getTag(), Boolean.TRUE) == false) goto L7;
        ViewGroup r4 = this.c;
        if (r4 == null) goto L8;
        r4.removeAllViews();
    L8:
        c();
        return;
    L7:
        this.b.removeView(r3);
        goto L8
    }

    public l(ViewGroup r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultLayout");
        this.b = r2;
        this.c = r3;
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
