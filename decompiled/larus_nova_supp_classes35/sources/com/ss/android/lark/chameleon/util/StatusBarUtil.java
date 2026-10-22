package com.ss.android.lark.chameleon.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StatusBarUtil {
    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;
    private static final int FAKE_STATUS_BAR_VIEW_ID = 2131387322;
    private static final int FAKE_TRANSLUCENT_VIEW_ID = 2131387323;
    private static final int TAG_KEY_HAVE_SET_OFFSET = -123;

    public StatusBarUtil() {
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private static void clearPreviousSetting(Activity r2) {
        ViewGroup r0 = (ViewGroup) INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2.getWindow());
        View r1 = r0.findViewById(FAKE_STATUS_BAR_VIEW_ID);
        if (r1 == null) goto L6;
        r0.removeView(r1);
        ((ViewGroup) ((ViewGroup) r2.findViewById(R.id.content)).getChildAt(0)).setPadding(0, 0, 0, 0);
        return;
    }

    public static int getStatusBarHeight(Context r4) {
        int r0 = r4.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r4.getResources().getDimensionPixelSize(r0);
    }

    public static void hideStatusBar(Activity r1) {
        if (r1 == null) goto L5;
        r1.getWindow().addFlags(ChameleonContainerUtils.MAX_URL_LENGTH);
        return;
    }

    public static void setTransparent(Activity r2) {
        setTranslucentForImageView(r2, 0, new View[0]);
    }

    private static void setTransparentForWindow(Activity r2) {
        r2.getWindow().setStatusBarColor(0);
        int r0 = INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2.getWindow()).getSystemUiVisibility();
        INVOKEVIRTUAL_com_ss_android_lark_chameleon_util_StatusBarUtil_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2.getWindow()).setSystemUiVisibility((r0 | 256) | ChameleonContainerUtils.MAX_URL_LENGTH);
    }

    public static void showStatusBar(Activity r1) {
        if (r1 == null) goto L5;
        r1.getWindow().clearFlags(ChameleonContainerUtils.MAX_URL_LENGTH);
        return;
    }

    private static void addTranslucentView(Activity r3, int r4) {
        ViewGroup r0 = (ViewGroup) r3.findViewById(R.id.content);
        View r1 = r0.findViewById(FAKE_TRANSLUCENT_VIEW_ID);
        if (r1 != null) goto L5;
        r0.addView(createTranslucentStatusBarView(r3, r4));
        return;
    L5:
        if (r1.getVisibility() != 8) goto L7;
        r1.setVisibility(0);
    L7:
        r1.setBackgroundColor(Color.argb(r4, 0, 0, 0));
    }

    private static View createTranslucentStatusBarView(Activity r3, int r4) {
        View r0 = new View(r3);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(r3)));
        r0.setBackgroundColor(Color.argb(r4, 0, 0, 0));
        r0.setId(FAKE_TRANSLUCENT_VIEW_ID);
        return r0;
    }

    public static void setTranslucentForImageViewInFragment(Activity r1, View r2) {
        setTranslucentForImageViewInFragment(r1, 112, r2);
    }

    public static void setTransparentForImageView(Activity r1, View... r2) {
        setTranslucentForImageView(r1, 0, r2);
    }

    public static void setTransparentForImageViewInFragment(Activity r1, View r2) {
        setTranslucentForImageViewInFragment(r1, 0, r2);
    }

    public static void setTranslucentForImageView(Activity r8, int r9, View... r10) {
        setTransparentForWindow(r8);
        addTranslucentView(r8, r9);
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.length;
        int r0 = 0;
    L6:
        if (r0 >= r11) goto L17;
        View r1 = r10[r0];
        if (r1 == null) goto L16;
        Object r3 = r1.getTag(TAG_KEY_HAVE_SET_OFFSET);
        if (r3 != null) goto L13;
    L15:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r4.setMargins(r4.leftMargin, r4.topMargin + getStatusBarHeight(r8), r4.rightMargin, r4.bottomMargin);
        r1.setTag(TAG_KEY_HAVE_SET_OFFSET, Boolean.TRUE);
        goto L16
    L13:
        if (((Boolean) r3).booleanValue() == false) goto L15;
    L16:
        r0 = r0 + 1;
        goto L6
    }

    public static void setTranslucentForImageViewInFragment(Activity r2, int r3, View r4) {
        setTranslucentForImageView(r2, r3, new View[]{r4});
    }
}
