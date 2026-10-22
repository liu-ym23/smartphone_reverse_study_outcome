package com.obric.oui.actionbar.v2;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import com.lynx.tasm.utils.j;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.segmentedtab.OBottomToolBar;
import com.obric.oui.window.permission.WebViewActivity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f11933b;

    public /* synthetic */ b(KeyEvent.Callback r5, int r10) {
        this.f11932a = r10;
        this.f11933b = r5;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
        int r5 = 0;
        KeyEvent.Callback r12 = this.f11933b;
        switch(this.f11932a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L14;
            default: goto L4;
        };
    L4:
        int r13 = OBlurMaskView.f12023i;
        OBlurMaskView r14 = (OBlurMaskView) r12;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$noName_0");
        Intrinsics.checkNotNullParameter(r11, "insets");
        Insets r15 = j.r(r14, r11);
        if (r14.f12025b == false) goto L7;
        int r16 = r15.top;
    L8:
        r14.setPadding(r14.getPaddingLeft(), r16, r14.getPaddingRight(), r14.getPaddingBottom());
        if (r14.f12026c == false) goto L11;
        int r17 = r15.bottom;
    L12:
        r14.setPadding(r14.getPaddingLeft(), r14.getPaddingTop(), r14.getPaddingRight(), r17);
        return r11;
    L11:
        r17 = r14.e;
        goto L12
    L7:
        r16 = r14.d;
        goto L8
    L14:
        int r18 = WebViewActivity.f14915x;
        WebViewActivity r19 = (WebViewActivity) r12;
        r19.getClass();
        int r20 = j.r(r10, r11).bottom;
        if (j.s(r10.getContext()) == true) goto L19;
        r5 = r20;
    L19:
        if ((r19.s.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r19.s.getLayoutParams();
        r21.bottomMargin = r5;
        r19.s.setLayoutParams(r21);
        Log.d("WebViewActivity", "updateLayoutForInsetBottom, insetBottom: " + r5);
    L21:
        return r11;
    L22:
        int r22 = OBottomToolBar.E;
        OBottomToolBar r23 = (OBottomToolBar) r12;
        Intrinsics.checkNotNullParameter(r23, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$noName_0");
        Intrinsics.checkNotNullParameter(r11, "insets");
        a.a.B(RangesKt.coerceAtLeast(0, j.r(r23, r11).bottom), r23);
        return r11;
    L24:
        int r24 = OBottomActionBarNormalVertical.g;
        OBottomActionBarNormalVertical r25 = (OBottomActionBarNormalVertical) r12;
        Intrinsics.checkNotNullParameter(r25, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$noName_0");
        Intrinsics.checkNotNullParameter(r11, "insets");
        int r26 = j.r(r25, r11).bottom;
        View r27 = r25.f11928a;
        r27.setPaddingRelative(r27.getPaddingLeft(), r27.getPaddingTop(), r27.getPaddingRight(), Math.max(r26, r25.f));
        return r11;
    L26:
        int r28 = OBottomActionBarNormalHorizontal.g;
        OBottomActionBarNormalHorizontal r29 = (OBottomActionBarNormalHorizontal) r12;
        Intrinsics.checkNotNullParameter(r29, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$noName_0");
        Intrinsics.checkNotNullParameter(r11, "insets");
        int r30 = j.r(r29, r11).bottom;
        View r31 = r29.f11925a;
        r31.setPaddingRelative(r31.getPaddingLeft(), r31.getPaddingTop(), r31.getPaddingRight(), Math.max(r30, r29.f));
        return r11;
    }
}
